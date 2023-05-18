package com.example.ourapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public class StoresDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "storesDB.db";
    public static final String TABLE_STORES = "stores";
    public static final String COLUMN_STORE_ID = "store_id";
    public static final String COLUMN_STORE_NAME = "store_name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_STYLE = "style";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_MUSIC = "music";
    public static final String COLUMN_AVERAGE_AGE = "average_age";
    public static final boolean COLUMN_PARKING = false;
    public static final boolean COLUMN_DISABLED_ACCESS = false;



    public StoresDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STORES_TABLE = "CREATE TABLE " +
                TABLE_STORES + "(" +
                COLUMN_STORE_ID + " INTEGER PRIMARY KEY," +
                COLUMN_STORE_NAME + " TEXT," +
                COLUMN_TYPE + " TEXT," +
                COLUMN_STYLE + " TEXT," +
                COLUMN_LOCATION + " TEXT," +
                COLUMN_MUSIC + " TEXT," +
                COLUMN_AVERAGE_AGE + " TEXT," +
                COLUMN_PARKING + " INTEGER," +
                COLUMN_DISABLED_ACCESS + " INTEGER" +
                ")";
        db.execSQL(CREATE_STORES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORES);
        onCreate(db);
    }

    public ArrayList<Store> findStore(Store store) {
        ArrayList<Store> stores=new ArrayList<>();
        String query;
        if(store.getParking()==true && store.getDisabledAccess()==false)
        {
           query="SELECT * FROM" + TABLE_STORES +
                   "WHERE" + COLUMN_TYPE + "=" + store.getType() +
                   COLUMN_STYLE + "=" + store.getStyle() +
                   COLUMN_LOCATION + "=" + store.getLocation() +
                   COLUMN_MUSIC + "=" + store.getMusic() +
                   COLUMN_AVERAGE_AGE + "=" + store.getAverageAge() +
                   COLUMN_PARKING + "=" + store.getParking();
        }
        else if (store.getParking()==false && store.getDisabledAccess()==true)
        {

        } else if (store.getParking()==false && store.getDisabledAccess()==false)
        {

        }
        else
        {

        }
        String query = "SELECT * FROM " + TABLE_STORES + " WHERE " +
                COLUMN_PRODUCTNAME + " = '" + productname + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Store store = new Store();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            store.setStoreID(Integer.parseInt(cursor.getString(0)));
            store.setStoreName(cursor.getString(1));
            store.setQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            store = null;
        }
        db.close();
        return ;

    }
