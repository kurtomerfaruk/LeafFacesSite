package com.blogspot.ofarukkurt.leaffacessite.controllers;

import com.blogspot.ofarukkurt.leaffaces.model.map.DefaultMapModel;
import com.blogspot.ofarukkurt.leaffaces.model.map.LatLng;
import com.blogspot.ofarukkurt.leaffaces.model.map.MapModel;
import com.blogspot.ofarukkurt.leaffaces.model.map.Marker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Omer Faruk Kurt
 * @Created on date 04/09/2018 10:29:07
 */
@Named(value = "simpleController")
@ViewScoped
public class SimpleController implements java.io.Serializable {

    private static final long serialVersionUID = 8642010380539719215L;

    private List<String> modelList;

    private MapModel model;
    private Marker marker;

    @PostConstruct
    public void init() {
        model = new DefaultMapModel();
        LatLng coord1 = new LatLng(37.067103, 37.371856);
        LatLng coord2 = new LatLng(37.064548, 37.371333);

        //Draggable
        model.addOverlay(new Marker(coord1,"Gaziantep1"));
        model.addOverlay(new Marker(coord2,"Gaziantep2"));
//        modelList = createData();
    }

    public List<String> getModelList() {
        return modelList;
    }

    public void setModelList(List<String> modelList) {
        this.modelList = modelList;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }

    private List<String> createData() {
        List<String> models = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Random randomLat = new Random();
            double latBegin = -37.8839;
            double latEnd = -37.9124889333;
            double lngBegin = 175.3745188667;
            double lngEnd = 175.4727737833;
//            double latitude = (Math.random() * 180.0) - 90.0;
            double latitude = latBegin + (latEnd - latBegin) * randomLat.nextDouble();
            //double longitude = (Math.random() * 360.0) - 180.0;
            double longitude = lngBegin + (lngEnd - lngBegin) * randomLat.nextDouble();
            String model = "[" + latitude + "," + longitude + "]";
            models.add(model);
        }

        return models;
    }

}
