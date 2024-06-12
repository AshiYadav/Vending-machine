package controller;

import model.Coin;
import model.Inventory;
import model.Note;
import model.Product;

public class VendingMachineController {

    private static VendingMachineController instance;

    private Inventory inventory;
    private VendingState idleState;
    private VendingState runState;
    private VendingState disperseState;
    private VendingState refundState;
    private VendingState currentState;
    private Product selectedProduct;
    private double totalPayment;

    private VendingMachineController() {
        this.idleState = new IdleState(this);
        this.runState = new RuningState(this);
        this.disperseState = new DisperseState(this);
        this.refundState = new RefundState(this);
        this.currentState = idleState;
        this.selectedProduct = null;
        this.totalPayment = 0.00;
        this.inventory = new Inventory();
    }

    public static VendingMachineController  getInstance(){
        if(instance == null){
            synchronized (VendingMachineController.class){
                if(instance == null){
                    return new VendingMachineController();
                }
            }
        }

        return instance;

    }

    public void selectProduct(Product product){
        System.out.println("Product selected is : " + product.getName());
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        System.out.println("Coin inserted of value"+coin.getValue());
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        System.out.println("Note inserted of value"+note.getValue());
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        System.out.println("Going to do finish the payment");
        currentState.disperseProduct();
    }

    public void returnChange() {
        currentState.refundChange();
    }

    public void addProduct(Product product, int quantity){
        System.out.println("New Product Added");
        inventory.addProduct(product, quantity);
    }

    public Inventory getInventory(){
        return  inventory;
    }


    void setState(VendingState state) {
        currentState = state;
    }

    VendingState getIdleState() {
        return idleState;
    }

    VendingState getReadyState() {
        return runState;
    }

    VendingState getDispenseState() {
        return disperseState;
    }

    VendingState getReturnChangeState() {
        return refundState;
    }

    Product getSelectedProduct() {
        return selectedProduct;
    }

    void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    void resetSelectedProduct() {
        selectedProduct = null;
    }

    double getTotalPayment() {
        return totalPayment;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void addNote(Note note) {
        totalPayment += note.getValue();
    }

    void resetPayment() {
        totalPayment = 0.0;
    }
}
