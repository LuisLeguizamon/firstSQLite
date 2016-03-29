package com.example.luis.dbtry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luis on 24/03/16.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

  private static final  String DATABASE_NAME = "data.db";
  private static final  int DATABASE_VERSION = 1;

  public static final String TABLE_A_NAME = "cat";
  public static final String COLUMN_ID ="_id";
  public static final String COLUMN_NAME="name";


    public MySQLiteHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

  //Database creation sql statement
  private static final String DATABASE_CREATE = "create table "+ TABLE_A_NAME+"("+COLUMN_ID+" integer primary key, "+COLUMN_NAME+
          " text not null);";
 private static final String INSERT_CAT = "INSERT INTO "+TABLE_A_NAME+" (_id,name)"
         +" VALUES(0,"+"\"Agro\"),"+"(1,"+"\"Artes\"),"+"(2,"+"\"Electricidad\")";

    @Override
    public void onCreate(SQLiteDatabase db) {
    //Create the table cat_table
    db.execSQL(DATABASE_CREATE);
    //Insert initial records
    db.execSQL(INSERT_CAT);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
