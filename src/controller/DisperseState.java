package controller;

import model.Coin;
import model.Note;
import model.Product;

public class DisperseState implements VendingState{

    VendingMachineController controller;

    public DisperseState(VendingMachineController controller) {
        this.controller = controller;
    }

    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public void insertNote(Note note) {

    }

    @Override
    public void disperseProduct() {
        controller.setState(controller.getReadyState());

        Product product = controller.getSelectedProduct();
        controller.getInventory().updateQty(product, controller.getInventory().getQty(product) - 1);
        System.out.println("Product dispensed: " + product.getName());
        controller.setState(controller.getReturnChangeState());
    }

    @Override
    public void refundChange() {

    }
}
