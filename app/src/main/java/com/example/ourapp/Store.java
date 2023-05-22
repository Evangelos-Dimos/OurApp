package com.example.ourapp;

public class Store {

    private int store_id;
    private String store_name;
    private String type;
    private String style;
    private String location;
    private String music;
    private String average_age;
    private boolean parking;
    private boolean disabled_access;


    public Store(){}
    public Store(int store_id,String store_name,String type,String style,String location,String music,String average_age,boolean parking,boolean disabled_access)
    {
        this.store_id = store_id;
        this.store_name=store_name;
        this.type=type;
        this.style=style;
        this.music=music;
        this.location=location;
        this.average_age=average_age;
        this.parking=parking;
        this.disabled_access=disabled_access;
    }

    public int getStoreID() {
        return store_id;
    }

    public void setStoreID(int store_id) { this.store_id = store_id; }

    public String getStoreName() {
        return store_name;
    }

    public void setStoreName(String store_name) { this.store_name = store_name; }

    public String getType() { return type;}

    public void setType(String type) { this.type = type; }

    public String getStyle() {
        return style;
    }

    public void setStyle(String Style) { this.style = style; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) { this.location = location; }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) { this.music = music; }

    public String getAverageAge() {
        return average_age;
    }

    public void setAverageAge(String average_age) { this.average_age = average_age; }

    public boolean getParking() {
        return parking;
    }

    public void setParking(boolean parking) { this.parking = parking; }

    public boolean getDisabledAccess() {
        return disabled_access;
    }

    public void setDisabledAccess(boolean disabled_access) { this.disabled_access = disabled_access; }

}
