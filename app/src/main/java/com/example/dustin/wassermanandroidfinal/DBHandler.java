package com.example.dustin.wassermanandroidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dustin.wassermanandroidfinal.Host;
import com.example.dustin.wassermanandroidfinal.Meeting;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATA_VERSION = 1;
    private static final String DATABASE_NAME = "team.db";

    private static final String TABLE_HOST = "host";

    private static final String COLUMN_HOST_ID = "_id";
    private static final String COLUMN_HOST_EMAIL = "email";

    private static final String TABLE_MEETING = "meeting";

    private static final String COLUMN_MEETING_ID = "_id";
    private static final String COLUMN_MEETING_name = "name";
    private static final String COLUMN_MEETING_DESC = "description";
    private static final String COLUMN_MEETING_LOCATION = "location";
    private static final String COLUMN_MEETING_DATE = "date";
    private static final String COLUMN_MEETING_TIME = "time";
    private static final String COLUMN_MEETING_HOSTID = "_hostid";

    private Host[] hostData;
    private Meeting[] meetingData;


    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create host table
        String query = "CREATE TABLE " + TABLE_HOST + "(" +
                COLUMN_HOST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_HOST_EMAIL + " TEXT" +
                ");";

        db.execSQL(query);

        //create meeting table
        query = "CREATE TABLE " + TABLE_MEETING + "(" +
                COLUMN_MEETING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MEETING_name + " TEXT, " +
                COLUMN_MEETING_DESC + " TEXT, " +
                COLUMN_MEETING_LOCATION + " TEXT, " +
                COLUMN_MEETING_DATE + " TEXT, " +
                COLUMN_MEETING_TIME + " TEXT, " +
                COLUMN_MEETING_HOSTID + " INTEGER " +
                ");";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEETING);

        onCreate(db);
    }

    public void addHost(Host host){

        ContentValues values = new ContentValues();

        //put the values into the values variable. Prepare to insert
        values.put(COLUMN_HOST_EMAIL, host.getEmail());



        //connects to the database (so you can write into it)
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HOST, null, values);
        db.close();
    }

    public void addMeeting(Meeting meet){
        ContentValues values = new ContentValues();

        //put the values into the values variable. Prepare to insert
        values.put(COLUMN_MEETING_name, meet.getName());
        values.put(COLUMN_MEETING_DESC, meet.getDescription());
        values.put(COLUMN_MEETING_LOCATION, meet.getLocation());
        values.put(COLUMN_MEETING_DATE, meet.getDate());
        values.put(COLUMN_MEETING_TIME, meet.getTime());
        values.put(COLUMN_MEETING_HOSTID, meet.get_hostid());


        //connects to the database (so you can write into it)
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MEETING, null, values);
        db.close();
    }

    public Host[] getHosts(){

        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_HOST + ";";

        Cursor c = db.rawQuery(query, null);

        int numHosts = c.getCount();

        if (numHosts >= 1) {

            hostData = new Host [numHosts];

            int i = 0;

            c.moveToFirst();

            while (!c.isAfterLast()){

                hostData[i] = new Host (c.getString(c.getColumnIndex(COLUMN_HOST_EMAIL)));

                hostData[i].set_id(c.getInt(c.getColumnIndex(COLUMN_HOST_ID)));

                c.moveToNext();

                i++;
            }
        }

        db.close();

        return hostData;

    }

    public Meeting[] getMeetings(){
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_MEETING + ";";

        Cursor c = db.rawQuery(query, null);

        int numMeetings = c.getCount();

        if (numMeetings >= 1) {

            meetingData = new Meeting [numMeetings];

            int i = 0;

            c.moveToFirst();

            while (!c.isAfterLast()){

                meetingData[i] = new Meeting (c.getString(c.getColumnIndex(COLUMN_MEETING_name)),
                        c.getString(c.getColumnIndex(COLUMN_MEETING_DESC)),
                        c.getString(c.getColumnIndex(COLUMN_MEETING_LOCATION)),
                        c.getString(c.getColumnIndex(COLUMN_MEETING_DATE)),
                        c.getString(c.getColumnIndex(COLUMN_MEETING_TIME)),
                        c.getInt(c.getColumnIndex(COLUMN_MEETING_HOSTID))

                        );

                meetingData[i].set_id(c.getInt(c.getColumnIndex(COLUMN_MEETING_ID)));

                c.moveToNext();

                i++;
            }
        }

        db.close();

        return meetingData;
    }



}
