package edu.westga.cs3211.discountFinder.view.codebehind;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Item;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindow {
    @FXML
    private Button addFilterButton;

    @FXML
    private Button clearFiltersList;

    @FXML
    private TextField filterItemByTextField;

    @FXML
    private ListView<Item> itemsListView;

	private DiscountFinder finder;


    private void initializeListView() {
		// this.itemsListView.itemsProperty().bind(new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.getItems())));
		ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.getItems()));
		this.itemsListView.itemsProperty().setValue(filtered);
	}

	private void populateList() {
		Item item1 = new Item("Fruit", "Publix", "Biolife", 5, true);
        Item item2 = new Item("Cereal", "TJ Maxx", "Generic", 25, false);
        Item item3 = new Item("Beans", "Wawa", "Premium", 6, true);
		Item item4 = new Item("Water", "Kroger", "Aquafina", 3, false);
        Item item5 = new Item("Bucket", "Walmart", "WholeBulk", 2, true);
        Item item6 = new Item("Mop", "Dicks", "John Deer", 7, true);

		this.finder.addItem(item1);
		this.finder.addItem(item2);
		this.finder.addItem(item3);
		this.finder.addItem(item4);
		this.finder.addItem(item5);
		this.finder.addItem(item6);
	}

	@FXML
    void handleAddButton(ActionEvent event) {
		if (this.filterItemByTextField.getText().isEmpty()) {
			this.initializeListView();
		} else {
			ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.findDiscountsForItem(this.filterItemByTextField.getText())));
			this.itemsListView.itemsProperty().setValue(filtered);
		}
    }

	@FXML
    void handleClearButton(ActionEvent event) {
		this.itemsListView.itemsProperty().setValue(new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.getItems())));
    }

	@FXML
	public void initialize() {
		this.finder = new DiscountFinder();
		this.populateList();
		this.initializeListView();
	}
}