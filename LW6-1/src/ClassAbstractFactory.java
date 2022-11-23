import entities.dndclasses.CharacterClass;
import entities.dndclasses.Paladin;
import entities.dndclasses.Rogue;

public class ClassAbstractFactory {
    public static CharacterClass getClass(String type){
        switch (type){
            case "Paladin":
                return new Paladin();
            case "Rogue":
                return new Rogue();
            default:
                throw new IllegalArgumentException("Can`t find this type: " + type);
        }

    }
}
