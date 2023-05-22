package com.example.ourapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public class StoresDBHandler extends SQLiteOpenHelper
{

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


    public StoresDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORES);
        onCreate(db);
    }

    public ArrayList<Store> findStore(Store store)
    {

        ArrayList<Store> stores = new ArrayList<>();
        String query;

        if (store.getParking() == true && store.getDisabledAccess() == false)
        {
            query = "SELECT * FROM" + TABLE_STORES +
                    "WHERE" + COLUMN_TYPE + "=" + store.getType() +
                    COLUMN_STYLE + "=" + store.getStyle() +
                    COLUMN_LOCATION + "=" + store.getLocation() +
                    COLUMN_MUSIC + "=" + store.getMusic() +
                    COLUMN_AVERAGE_AGE + "=" + store.getAverageAge() +
                    COLUMN_PARKING + "=" + store.getParking();
        }
        else if (store.getParking() == false && store.getDisabledAccess() == true)
        {
            query = "SELECT * FROM" + TABLE_STORES +
                    "WHERE" + COLUMN_TYPE + "=" + store.getType() +
                    COLUMN_STYLE + "=" + store.getStyle() +
                    COLUMN_LOCATION + "=" + store.getLocation() +
                    COLUMN_MUSIC + "=" + store.getMusic() +
                    COLUMN_AVERAGE_AGE + "=" + store.getAverageAge() +
                    COLUMN_DISABLED_ACCESS + "=" + store.getDisabledAccess();
        }
        else if (store.getParking() == false && store.getDisabledAccess() == false)
        {
            query = "SELECT * FROM" + TABLE_STORES +
                    "WHERE" + COLUMN_TYPE + "=" + store.getType() +
                    COLUMN_STYLE + "=" + store.getStyle() +
                    COLUMN_LOCATION + "=" + store.getLocation() +
                    COLUMN_MUSIC + "=" + store.getMusic() +
                    COLUMN_AVERAGE_AGE + "=" + store.getAverageAge();
        }
        else
        {
            query = "SELECT * FROM" + TABLE_STORES +
                    "WHERE" + COLUMN_TYPE + "=" + store.getType() +
                    COLUMN_STYLE + "=" + store.getStyle() +
                    COLUMN_LOCATION + "=" + store.getLocation() +
                    COLUMN_MUSIC + "=" + store.getMusic() +
                    COLUMN_AVERAGE_AGE + "=" + store.getAverageAge() +
                    COLUMN_PARKING + "=" + store.getParking() +
                    COLUMN_DISABLED_ACCESS + "=" + store.getDisabledAccess();
        }

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToFirst())
        {
            Store new_store = new Store();
            new_store.setStoreID(Integer.parseInt(cursor.getString(0)));
            new_store.setStoreName(cursor.getString(1));
            new_store.setType(cursor.getString(2));
            new_store.setStyle(cursor.getString(3));
            new_store.setLocation(cursor.getString(4));
            new_store.setMusic(cursor.getString(5));
            new_store.setAverageAge(cursor.getString(6));

            stores.add(new_store);
        }

        db.close();
        return stores;

    }
}
