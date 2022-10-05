import entities.Meal;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        var vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.printf("Total cost: " + vegMeal.getCost());

    }
}
