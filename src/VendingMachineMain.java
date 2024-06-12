import controller.VendingMachineController;
import model.Coin;
import model.Note;
import model.Product;

public class VendingMachineMain {
    public static void main (String args[]){

        VendingMachineController controller = VendingMachineController.getInstance();

        //Add Product
        Product p1 = new Product("coke", 50);
        Product p2 = new Product("Chips", 20);
        Product p3 = new Product("Cake", 10);

        controller.addProduct(p1,5);
        controller.addProduct(p2,10);
        controller.addProduct(p3,5);

        controller.selectProduct(p2);

        controller.insertCoin(Coin.FIVE);
        controller.insertCoin(Coin.ONE);
        controller.insertCoin(Coin.ONE);
        controller.insertCoin(Coin.ONE);
        controller.insertCoin(Coin.ONE);
        controller.insertCoin(Coin.ONE);

        controller.insertNote(Note.TWENTY);

        controller.dispenseProduct();
        controller.returnChange();
        System.out.println("Transaction finish");


    }
}
