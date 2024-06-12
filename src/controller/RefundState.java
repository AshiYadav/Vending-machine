package controller;

import model.Coin;
import model.Note;
import model.Product;

public class RefundState implements VendingState{

    VendingMachineController controller;

    public RefundState(VendingMachineController controller) {
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

    }

    @Override
    public void refundChange() {
        double change = controller.getTotalPayment() - controller.getSelectedProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: $" + change);
            controller.resetPayment();
        } else {
            System.out.println("No change to return.");
        }
        controller.resetSelectedProduct();
        controller.setState(controller.getIdleState());
    }
}
