package controller;

import model.Coin;
import model.Note;
import model.Product;

public class IdleState implements VendingState{

    VendingMachineController controller;

    public IdleState(VendingMachineController controller) {
        this.controller = controller;
    }

    @Override
    public void selectProduct(Product product) {

        if(controller.getInventory().isAvailable(product)){
            controller.setSelectedProduct(product);
            controller.setState(controller.getReadyState());
        }
        else {
            System.out.println("Product not available: " + product.getName());
        }

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void disperseProduct() {
        System.out.println("Please select a product first and then do payment.");
    }

    @Override
    public void refundChange() {
        System.out.println("No change to return.");
    }
}
