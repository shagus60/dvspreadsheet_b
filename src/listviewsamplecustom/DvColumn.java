/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listviewsamplecustom;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;
//https://stackoverflow.com/questions/41004084/dynamically-updating-a-listview-from-a-textfield-javafx
//https://stackoverflow.com/questions/49733670/different-types-of-objects-in-the-same-column

public class DvColumn extends VBox {

    // int counter = 0;
    int width = 300;
    //ListView<DvModel> list = new ListView<DvModel>();
    ObservableList<DvModel> data = FXCollections.observableArrayList(new DvModel(
            "chocolate", "salmon", "gold"), new DvModel("coral", "darkorchid",
            "darkgoldenrod"), new DvModel("lightsalmon", "black", "rosybrown"));

    public DvColumn() {

        ScrollPane sp = new ScrollPane();
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
       // sp.setContent(this);
        VBox.setVgrow(this, Priority.ALWAYS);

        setSpacing(5);
        setPrefWidth(width);

        TextField tfHeader = new TextField();

        tfHeader.setPrefWidth(width);
        // tfHeader.setMaxWidth(width);
        tfHeader.setPromptText("Enter column name");
        tfHeader.setAlignment(Pos.CENTER);
        getChildren().add(tfHeader);

        Button btn = new Button("Add cell");
        //  Label btn = new Label();
        //btn.setGraphic(new Label("+"));
        //btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        VBox hbox = new VBox();

        VBox cells = new VBox(3);

        /*
        ScrollPane sp = new ScrollPane();
            sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            sp.setContent(cells);
        
         */
        getChildren().add(cells);

        HBox hbcreateNewCell = new HBox();
        hbcreateNewCell.setPadding(new Insets(8, 8, 8, 8));
        hbcreateNewCell.getChildren().add(btn);

        getChildren().add(hbcreateNewCell);

        btn.setOnAction((ActionEvent event) -> {

            VBox custom = new VBox(2);
            HBox internal = new HBox(10);
            TextField tfOn = new TextField("00 00 00 000");
            TextField tfOff = new TextField("00 00 00 000");
            Text delete = new Text("X");
            delete.setFill(Color.RED);
            internal.getChildren().addAll(tfOn, tfOff, delete);
            delete.setOnMouseClicked((MouseEvent event1) -> {
                cells.getChildren().remove(custom);
            });

            TextField code = new TextField("([Coding])");
            code.setAlignment(Pos.CENTER);
            custom.getChildren().addAll(internal, code);

            cells.getChildren().addAll(custom);

            System.out.println("Adding .....");
        });

        hbcreateNewCell.setAlignment(Pos.CENTER);

        setSpacing(5);

        ContextMenu contextMenu = new ContextMenu();
        /*
        // final MenuItem addMenuItem = new MenuItem("Add...");
        final MenuItem deleteSelectedMenuItem = new MenuItem("Delete selected cell");

        contextMenu.getItems()
                .addAll(deleteSelectedMenuItem);
        deleteSelectedMenuItem.disableProperty()
                .bind(Bindings.isEmpty(list.getSelectionModel().getSelectedItems()));
        deleteSelectedMenuItem.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                //final List<Person> selectedPeople = new ArrayList<>(table.getSelectionModel().getSelectedItems());
                list.getItems().remove(list.getSelectionModel().getSelectedItem());

            }
        }
        );

        list.setContextMenu(contextMenu);
         */
    }

}
