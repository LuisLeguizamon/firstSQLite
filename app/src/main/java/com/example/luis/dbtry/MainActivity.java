package com.example.luis.dbtry;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
private DataSource datasource;

    private SQLiteDatabase database;
    private MySQLiteHelper openhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        openhelper = new MySQLiteHelper(this);
        database = openhelper.getReadableDatabase();

        //if(database!=null){Log.d("R:","ok");}
        //database.close();
        Cursor c = database.rawQuery("select * from " + MySQLiteHelper.TABLE_A_NAME, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_row,
                c,
                new String[]{MySQLiteHelper.COLUMN_NAME},
                new int[]{R.id.txv_n},
                0);
//SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        /*
        //Iniciando el nuevo Adaptador
adapter = new SimpleCursorAdapter(
        this,//Context context
        android.R.layout.two_line_list_item,//int layout
        dataSource.getAllQuotes(),//Cursor c
        new String[]{ColumnQuotes.BODY_QUOTES,ColumnQuotes.AUTHOR_QUOTES},//String[] from
        new int[]{android.R.id.text1, android.R.id.text2},//int[] to
        SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER//int flags
);
         */

       /* Cursor cursor = openhelper.getReadableDatabase().rawQuery("SELECT name from cat",null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,
                new String[] { "name" },new int[]{ R.id.txv_name},0);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
*/
    }


}
