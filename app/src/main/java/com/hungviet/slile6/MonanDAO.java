package com.hungviet.slile6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MonanDAO {


    KhoaHocReaderSQLite khoaHocReaderSQLite;

    public MonanDAO(Context context) {
        khoaHocReaderSQLite = new KhoaHocReaderSQLite(context);
    }

    public long insertma(KhoaHoc khoaHoc) {
        SQLiteDatabase sqLiteDatabase = khoaHocReaderSQLite.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(khoaHocReaderSQLite.COL_TEN, khoaHoc.getTen());
        contentValues.put(khoaHocReaderSQLite.COL_ANH, khoaHoc.getAnh());
        contentValues.put(khoaHocReaderSQLite.COL_GIA, khoaHoc.getGia());


        long result = sqLiteDatabase.insert(khoaHocReaderSQLite.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();


        return result;
    }

    public long updatema(KhoaHoc khoaHoc) {
        SQLiteDatabase sqLiteDatabase = khoaHocReaderSQLite.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(khoaHocReaderSQLite.COL_TEN, khoaHoc.getTen());
        contentValues.put(khoaHocReaderSQLite.COL_ANH, khoaHoc.getAnh());
        contentValues.put(khoaHocReaderSQLite.COL_GIA, khoaHoc.getGia());


        long result = sqLiteDatabase.update(khoaHocReaderSQLite.TABLE_NAME, contentValues, khoaHocReaderSQLite.COL_TEN + "=?", new String[]{khoaHoc.getTen()});
        sqLiteDatabase.close();


        return result;
    }

    public List<KhoaHoc> getAll() {
        List<KhoaHoc> khoaHocList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = khoaHocReaderSQLite.getReadableDatabase();


        String query = "Select * from " + khoaHocReaderSQLite.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {

            KhoaHoc khoaHoc = new KhoaHoc();

            khoaHoc.setTen(cursor.getString(0));
            khoaHoc.setAnh(Integer.parseInt(cursor.getString(1)));
            khoaHoc.setGia(cursor.getString(2));

            khoaHocList.add(khoaHoc);

            cursor.moveToNext();
        }
        cursor.close();

        return khoaHocList;
    }


    public void deletema(String id){
        SQLiteDatabase sqLiteDatabase = khoaHocReaderSQLite.getWritableDatabase();
        sqLiteDatabase.delete(khoaHocReaderSQLite.TABLE_NAME, khoaHocReaderSQLite.COL_TEN + "=?",new String[]{id});
    }
}
