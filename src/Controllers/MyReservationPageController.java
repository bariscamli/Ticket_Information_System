/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Models.Event;
import Models.Reservation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tis_fx.EventDAOImpl;
import tis_fx.ReservationDAOImpl;
import tis_fx.UserName;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class MyReservationPageController implements Initializable {

    @FXML
    private TableView<Event> tableView;

    ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl();
    EventDAOImpl eventDAOImpl = new EventDAOImpl();
    
    List<Integer> reservedEvents = reservationDAOImpl.getReservedEvents(UserName.getInstance().getUser());
    ArrayList<Event> reservedEventsInfo = new ArrayList<Event>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventDAOImpl.getReservedEventsInfo(1);
        
        System.out.println("Reserved events size: " + reservedEvents.size()); 
        int size_=reservedEvents.size();
        for(int i=0;i<size_;i++){
               Event e = eventDAOImpl.getReservedEventsInfo(i);
               System.out.println(e.getName()+"-"+ e.getType()+"-"+e.getStarTime());
            }
    
     
        
        /*
        for(Event e : reservedEventsInfo){
            System.out.println(e.getName()+"-"+ e.getType()+"-"+e.getStarTime());
            
        }
        */
       // ObservableList<Event> oListEvents = FXCollections.observableArrayList(reservedEventsInfo);

    //    System.out.println(reservedEventsInfo.get(0).getName());
        System.out.println("Test Test Test : "+reservedEvents.get(0));
         
        TableColumn nameCol = new TableColumn("Name");
        TableColumn typeCol = new TableColumn("Type");
        TableColumn locationCol = new TableColumn("Location");
        TableColumn startTimeCol = new TableColumn("Start Time");
        TableColumn dateCol = new TableColumn("Date");
        
        tableView.getColumns().addAll(nameCol, typeCol, locationCol, startTimeCol, dateCol);

        nameCol.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        //nameCol.setMaxWidth(400);
        typeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("type"));
        //typeCol.setMaxWidth(200);
        locationCol.setCellValueFactory(new PropertyValueFactory<Event, String>("location"));
        //locationCol.setMaxWidth(400);
        startTimeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("starTime"));
        //startTimeCol.setMaxWidth(200);
        dateCol.setCellValueFactory(new PropertyValueFactory<Event, Date>("date"));
        // dateCol.setMaxWidth(200);
        
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  
                
      // tableView.setItems(oListEvents);    
    }    
    
}
