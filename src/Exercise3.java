import java.util.*;

class SliceOHeaven {
    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;
    
    static final String STORE_NAME = "Slice-o-Heaven";
    static final String STORE_ADDRESS = "Pizza Streer";
    static final String STORE_EMAIL = "sliceoheaven@qq.com";
    static final String STORE_PHONE = "114514";

    static final Map<String, List<String>> PIZZA_INGREDIENTS = new HashMap<>();
    static final Map<String, Double> PIZZA_PRICE = new HashMap<>();
    static final Map<String, Double> SIDES = new HashMap<>();
    static final Map<String, Double> DRINKS = new HashMap<>();

    static{
        PIZZA_INGREDIENTS.put("Margherita", Arrays.asList("Tomato sauce", "Mozzarella", "Basil"));
        PIZZA_INGREDIENTS.put("Pepperoni", Arrays.asList("Tomato sauce", "Mozzarella", "Pepperoni"));
        PIZZA_INGREDIENTS.put("Pepperoni", Arrays.asList("Tomato sauce", "Mozzarella", "Mushroom", "Bell peppers"));
        
        PIZZA_PRICE.put("Margherita", 10.00);
        PIZZA_PRICE.put("Pepperoni", 12.00);
        PIZZA_PRICE.put("Vegetarian", 11.00);

        SIDES.put("Garlic Bread", 5.00);
        SIDES.put("Chicken Wings", 7.00);
        SIDES.put("Cheese Sticks", 6.00);
    
        DRINKS.put("Cola", 3.00);
        DRINKS.put("Lemonade", 3.50);
    }
    
    private final String orderId;
    private double orderTotal;
    private String pizzaIngredients;
    private final List<String> orderItems = new ArrayList<>();
    private List<String> sides = new ArrayList<>();
    private List<String> drinks = new ArrayList<>();

    public SliceOHeaven(){
        this.orderId = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public SliceOHeaven(String orderId, String pizzaIngredients, double orderTotal){
        this.orderId = orderId;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderId(){
        return orderId;
    } 

    public double getOrderTotal(){
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal){
        this.orderTotal = orderTotal;
    }

    public String getPizzaIngredients(){
        return pizzaIngredients;
    }
    
    public void setPizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients = pizzaIngredients;
    }
    
    public void takeOrder(List<String> pizzas, List<String> sides, List<String> drinks){
        processItems(pizzas, PIZZA_PRICE, "Pizza");
        this.sides = sides;
        this.drinks = drinks;
        for (String side : sides){
            orderItems.add("Side: " + side);
        }
        for (String drink : drinks){
            orderItems.add("Drink: " + drink);
        }
        processItems(sides, SIDES, "Side");
        processItems(drinks, DRINKS, "Drink");
        printReceipt();
    }

    private void processItems(List<String> items, Map<String, Double> menu, String category){
        if (items == null) return;

        for (String item : items){
            if (menu.containsKey(item)){
                double price = menu.get(item);
                orderTotal += price;
                orderItems.add(String.format("%s: %s - $%.2f", category, item, price));
                if(category.equals("Pizza")){
                    makePizza(item);
                }
            } else {
                System.out.println("Item not available: " + item);
            }
        }
    }

    private void makePizza(String pizzaType){
        if (PIZZA_INGREDIENTS.containsKey(pizzaType)){
            String ingredients = String.join(", ", PIZZA_INGREDIENTS.get(pizzaType));
            System.out.println("Making " + pizzaType + " pizza with: " + ingredients);
        }
    }

    public void printReceipt(){
        System.out.println("\n=== " + STORE_NAME + " Receipt ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Items: ");
        for (String item : orderItems){
            System.out.println("- " + item);
        }
        System.out.printf("Total: $%.2f\n", orderTotal);
        System.out.println("==============================\n");
        
    }
}