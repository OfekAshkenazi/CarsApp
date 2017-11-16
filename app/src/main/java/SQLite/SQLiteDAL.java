package SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import Entities.Car;

import static SQLite.SQLiteDAL.SQliteHelper.Entries.COL_1;
import static SQLite.SQLiteDAL.SQliteHelper.Entries.COL_2;
import static SQLite.SQLiteDAL.SQliteHelper.Entries.COL_3;
import static SQLite.SQLiteDAL.SQliteHelper.Entries.TABLE_NAME;

/**
 * Created by Android on 11/16/2017.
 */

public class SQLiteDAL {
    SQliteHelper instance;

    public SQLiteDAL(Context context) {
        this.instance = new SQliteHelper(context);
    }

    public long insertCar(Car car) {
        ContentValues values = new ContentValues();
        values.put(COL_1,car.getModel());
        values.put(COL_2,car.getYear());
        values.put(COL_3,car.getColor());

        return instance.getWritableDatabase().insert(SQliteHelper.Entries.TABLE_NAME,null,values);
    }
    public ArrayList<Car> getAllCars(Integer searchBy,String searchContent){
        ArrayList<Car> carsList=new ArrayList<>();
        if (searchBy==null|searchContent==null){
            SQLiteDatabase db=instance.getReadableDatabase();
            Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
        }
        else {

        }
        return carsList;
    }


    class SQliteHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "carsDB";
        private static final int DB_VERSION = 1;
        Context context;

        public SQliteHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(Entries.CREATE_TABLE_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Entries.TABLE_NAME);
            onCreate(sqLiteDatabase);
        }

        final class Entries {

            protected static final String TABLE_NAME = "CARS_TABLE";
            protected static final String COL_1 = "MODEL";
            protected static final String ID_COL = "_id";
            protected static final String COL_2 = "YEAR";
            protected static final String COL_3 = "COLOR";
            protected static final String CREATE_TABLE_QUERY = "CREATE TEABLE " + TABLE_NAME + "(" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT+, " + COL_1 + "TEXT, " + COL_2 + "INTEGER, " + COL_3 + "TEXT)";
        }
    }
}