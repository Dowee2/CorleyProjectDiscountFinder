package edu.westga.cs3211.discountFinder.view.codebehind;

import edu.westga.cs3211.discountFinder.model.Category;
import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.DistanceEnum;
import edu.westga.cs3211.discountFinder.model.Filter;
import edu.westga.cs3211.discountFinder.model.Item;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * MainWindow code behind
 * @author Team 1
 */
public class MainWindow {
	@FXML
    private Button addItemFilterButton;

    @FXML
    private Button clearFiltersList;

    @FXML
    private TextField filterItemByTextField;

    @FXML
    private ListView<Item> itemsListView;

    @FXML
    private Button favoriteSellerButton;

    @FXML
    private Button addDisplayFilterButton;

    @FXML
    private TextField filterBySellerTextField;

    @FXML
    private TextField filterByDistanceTextField;


    @FXML
    private ComboBox<Category> categoriesCombobox;

    @FXML
    private ComboBox<DistanceEnum> distanceFromComboBox;
	
	private DiscountFinder finder;



    private void initializeListView() {
		// this.itemsListView.itemsProperty().bind(new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.getItems())));
		ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.getItems()));
		this.itemsListView.itemsProperty().setValue(filtered);
	}


	@FXML
    void handleFindItemButton(ActionEvent event) {
		if (this.filterItemByTextField.getText().isEmpty()) {
			this.initializeListView();
		} else {
			ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(Filter.filterByName(this.finder.getItems(), this.filterItemByTextField.getText())));
            
			this.itemsListView.itemsProperty().setValue(filtered);
		}
    }

	@FXML
    void handleClearButton(ActionEvent event) {
		this.itemsListView.itemsProperty().setValue(new SimpleListProperty<Item>(FXCollections.observableArrayList(this.finder.getItems())));
    }

	@FXML
    void onFavoriteSeller(ActionEvent event) {
        if (this.itemsListView.getSelectionModel().getSelectedItem() != null) {
            
            this.itemsListView.getSelectionModel().getSelectedItem().getSeller().setFavorite();
            this.initializeListView();
        }
        
    }

    @FXML
    void handleDisplaySellerButton(ActionEvent event) {
        if (this.filterBySellerTextField.getText().isEmpty()) {
			this.initializeListView();
		} else {
			ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(Filter.filterBySeller(this.finder.getItems(), this.filterBySellerTextField.getText())));
            
			this.itemsListView.itemsProperty().setValue(filtered);
		} 
    }

    private void setupListenerForDistanceCombobox() {

        this.distanceFromComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldDistance, newDistance) -> {
            if (newDistance != null) {
                ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(Filter.filterByDistance(this.finder.getItems(), newDistance)));
                this.itemsListView.itemsProperty().setValue(filtered);
            } else if (oldDistance == null) {
                this.initializeListView();
            }
        });
    }
/*
*/
    private void setupListenerForListSelect() {
        this.itemsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldSelect, newSelect) -> {
            if (newSelect != null) {
                this.filterItemByTextField.setText(newSelect.getName());
                this.filterBySellerTextField.setText(newSelect.getSeller().getSellerName());
            }
        });
    }

	private void populateComboBox() {
        for (Category category : Category.values()) {
            this.categoriesCombobox.getItems().add(category);
        }

        for (DistanceEnum distanceEnum : DistanceEnum.values()) {
            this.distanceFromComboBox.getItems().add(distanceEnum);
        }
	}

    private void setupListenerForCategoriesCombobox() {

        this.categoriesCombobox.getSelectionModel().selectedItemProperty().addListener((observable, oldCategory, newCategory) -> {
            if (newCategory != null) {
                ObservableList<Item> filtered = new SimpleListProperty<Item>(FXCollections.observableArrayList(Filter.filterByCategory(this.finder.getItems(), newCategory)));
                this.itemsListView.itemsProperty().setValue(filtered);
            } else if (oldCategory == null) {
                this.initializeListView();
            }
        });
    }

    /**
     * Initializes Webpage
     */
    @FXML
	public void initialize() {
		this.finder = new DiscountFinder();
		this.initializeListView();
		this.populateComboBox();
        this.setupListenerForCategoriesCombobox();
        this.setupListenerForDistanceCombobox();

        this.setupListenerForListSelect();
	}

}
