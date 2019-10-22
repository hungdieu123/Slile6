package com.hungviet.slile6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KhoaHocReaderSQLite extends SQLiteOpenHelper {

    public KhoaHocReaderSQLite(Context context){
        super(context,"monan.db",null,1);

    }

    public static String TABLE_NAME ="Monan";
    public static String COL_TEN = "ten";
    public static String COL_ANH = "anh";
    public static String COL_GIA = "gia";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = "create table " + TABLE_NAME + "("+COL_TEN+" text primary key, "+COL_ANH+" integer, "+COL_GIA+" text)";
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
