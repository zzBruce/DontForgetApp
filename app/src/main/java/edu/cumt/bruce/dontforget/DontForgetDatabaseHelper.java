package edu.cumt.bruce.dontforget;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Bruce_ZZCOM on 2019/6/4.
 */

public class DontForgetDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_DONT_FORGET_TABLE = "create table DontForgetTable ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "time integer, "
            + "content text)";

    private Context mContext;

    public DontForgetDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_DONT_FORGET_TABLE);
        Toast.makeText(mContext, "DontForgetTable create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
