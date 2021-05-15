package food.app.demo;

public class FoodItemModel {

    int food_image;
    String food_name, food_price;

    public FoodItemModel() {
    }

    public FoodItemModel(int food_image, String food_name, String food_price) {
        this.food_image = food_image;
        this.food_name = food_name;
        this.food_price = food_price;
    }

    public int getFood_image() {
        return food_image;
    }

    public void setFood_image(int food_image) {
        this.food_image = food_image;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

}
