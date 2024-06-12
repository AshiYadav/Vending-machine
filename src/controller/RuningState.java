package controller;

import model.Coin;
import model.Note;
import model.Product;

public class RuningState implements VendingState{

    VendingMachineController controller;

    public RuningState(VendingMachineController controller) {
        this.controller = controller;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        controller.addCoin(coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        controller.addNote(note);
        checkPaymentStatus();
    }

    @Override
    public void disperseProduct() {
        System.out.println("Once Coin and Note added then we will do payment");
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
        controller.setState(controller.getIdleState());
    }

    private void checkPaymentStatus() {
        if (controller.getTotalPayment() >= controller.getSelectedProduct().getPrice()) {
            controller.setState(controller.getDispenseState());
        }
    }
}
