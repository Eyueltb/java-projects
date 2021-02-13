import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CartSystem {
    public static void main(String...args){

        Random r=new Random();
        Cart cart=Cart.getInstance();
        for(int i=0;i<=100;i++){
            Product product=new Product("product"+i, r.nextInt(100)+1, i+1 );
            cart.addItem(product);
        }
        cart.checkOut();
        cart.getItems().forEach(item->System.out.println(" name->"+ item.getName() + " , price->" + item.getPrice() + ", number in stock-> " + item.getStock()));
    }
}
/** To represent Product class */
final class Product {
    private  String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }
    public Product(Product product){
        this(product.name, product.price,product.stock);
    }
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
    public void setStock(int stock){
        this.stock=stock;
    }
}
/** To manage Cart */
class Cart {
    private static List<Product> items=new ArrayList<>();
    private static Cart instance;
    private static int total=0;
    private Cart(){}
    public static Cart getInstance(){
        if(instance==null){
            instance=new Cart();
        }
        return  instance;
    }
    public static void addItem(Product product){
        if(product!=null)
            items.add(product);
    }
    public static void removeItem(Product product){
        if(product!=null)
            items.remove(product);
    }
    public static void clear(){
        for(Product product: items){
            items.remove(product);
            product.setStock(product.getStock()+1);
        }
    }
    public void checkOut(){
        for(Product product: items){
            total+=product.getPrice();
        }
        getTotal();
    }
    private int getTotal(){return total;}
    public  List<Product> getItems(){
        return  new ArrayList<>(items);
    }
}