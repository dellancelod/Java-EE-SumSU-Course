package view;

import controller.serializing.json.JsonSaver;
import controller.serializing.memento.CareTaker;
import controller.serializing.memento.Memento;
import model.races.CharacterRace;
import model.stats.Stats;
import org.reflections.Reflections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class MainView extends JFrame{
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel raceLabel;
    private JButton generateButton;
    private JComboBox racesList;
    private JTable statsTable;
    private JList сreatedCharacters;
    private JButton saveJsonButton;
    private JButton saveCharacterButton;
    private DefaultListModel listModel = new DefaultListModel();
    private CareTaker careTaker;

    public MainView(String title) throws HeadlessException {
        super(title);

        ArrayList<Map<String, Object>> charactersJson = new ArrayList<>();
        saveCharacterButton.setEnabled(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();

        careTaker = new CareTaker();

        //Отримуємо створені раси через рефлексію
        Reflections reflections = new Reflections("model.races");
        Set<Class<? extends CharacterRace>> classes = reflections.getSubTypesOf(CharacterRace.class);
        for (Class race : classes) {
            racesList.addItem(race.getSimpleName());
        }

        statsTable.setModel(
                new DefaultTableModel(
                        new Object[][]{},
                        new Object[]{"strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma"}
                )
        );

        DefaultTableModel model = (DefaultTableModel) this.statsTable.getModel();

        generateButton.addActionListener(actionEvent -> {

            if(model.getRowCount() == 1){
                model.removeRow(0);
            }

            if (model.getRowCount() < 1) {
                Stats stats = Stats.generate();
                careTaker.add(stats.save());
                Map<String, Integer> statsRow = stats.getStats();

                JTableHeader tableHeader = this.statsTable.getTableHeader();
                TableColumnModel columnModel = tableHeader.getColumnModel();
                List<Integer> params = new ArrayList<>(6);

                for (int i = 0; i < columnModel.getColumnCount(); i++) {
                    Integer valueParam = statsRow.get(columnModel.getColumn(i).getHeaderValue());
                    params.add(valueParam);
                }

                model.addRow(params.toArray());

                if (model.getRowCount() == 1) {
                    saveCharacterButton.setEnabled(true);
                }

                return;
            }

        });
        saveCharacterButton.addActionListener(actionEvent ->{
            if (nameTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Name cannot be empty",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Map<String, Integer> mapStats = new TreeMap<>();

            careTaker.getSaves().stream()
                    .limit(3)
                    .map(Memento::getStats)
                    .forEach(stats1 -> {
                        Map<String, Integer> values = stats1.getStats();

                        for (var entry : values.entrySet()) {
                            Integer integer = mapStats.get(entry.getKey()) == null ?
                                    mapStats.put(entry.getKey(), entry.getValue()) :
                                    mapStats.put(entry.getKey(), mapStats.get(entry.getKey()) + entry.getValue());
                        }
                    });

            StringBuilder sb = new StringBuilder(100);
            for (var entry : mapStats.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            listModel.addElement(nameTextField.getText()  + " " + racesList.getSelectedItem());
            сreatedCharacters.setModel(listModel);

            Map<String, Object> json = new LinkedHashMap<>();
            json.put("Name", nameTextField.getText());
            json.put("Race", Objects.requireNonNull(racesList.getSelectedItem()).toString());
            json.put("stats:", mapStats);

            charactersJson.add(json);
        });

        saveJsonButton.addActionListener(actionEvent -> {
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            f.showSaveDialog(null);
            new JsonSaver().write(f.getSelectedFile() + "\\characters.json", charactersJson);
        });
    }

    public static void main(String[] args) {
        MainView mainView = new MainView("Lab-8 MVC");
        mainView.setVisible(true);
    }


}
