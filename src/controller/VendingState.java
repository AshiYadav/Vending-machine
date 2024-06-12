package controller;

import model.Coin;
import model.Note;
import model.Product;

public interface VendingState {

    public void selectProduct(Product product);
    public void insertCoin(Coin coin);
    public void insertNote(Note note);
    public void disperseProduct();
    public void refundChange();
}
