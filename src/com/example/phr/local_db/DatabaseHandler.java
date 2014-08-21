package com.example.phr.local_db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.phr.model.AccessToken;
import com.example.phr.model.BloodPressure;
import com.example.phr.model.Client;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "HealthGem";
	private static final String TABLE_BLOODPRESSURE = "bloodpressure";
	private static final String TABLE_ACCESSTOKEN = "accesstoken";
	private static final String TABLE_CLIENT = "client";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_DATE = "date";
	private static final String KEY_TIME = "time";
	private static final String KEY_SYSTOLIC = "systolic";
	private static final String KEY_DIASTOLIC = "diastolic";
	private static final String KEY_STATUS = "status";
	private static final String KEY_ACCESSTOKEN = "token";
	private static final String KEY_USERNAME = "username";
	private static final String KEY_CLIENTID = "clientID";
	private static final String KEY_CLIENTPASSWORD = "clientPassword";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_BLOODPRESSURE_TABLE = "CREATE TABLE "
				+ TABLE_BLOODPRESSURE + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DATE + " TEXT,"
				+ KEY_TIME + " TEXT," + KEY_SYSTOLIC + " TEXT," + KEY_DIASTOLIC
				+ " TEXT," + KEY_STATUS + " TEXT" + ")";
		String CREATE_ACCESSTOKEN_TABLE = "CREATE TABLE " + TABLE_ACCESSTOKEN
				+ "(" + KEY_ACCESSTOKEN + " TEXT, " + KEY_USERNAME + " TEXT"
				+ ")";
		String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT
				+ "(" + KEY_CLIENTID + " TEXT, " + KEY_CLIENTPASSWORD + " TEXT"
				+ ")";
		db.execSQL(CREATE_BLOODPRESSURE_TABLE);
		db.execSQL(CREATE_ACCESSTOKEN_TABLE);
		db.execSQL(CREATE_CLIENT_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BLOODPRESSURE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCESSTOKEN);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);

		// Create tables again
		onCreate(db);
	}

	public AccessToken getAccessToken() {
		AccessToken token = new AccessToken();
		String selectQuery = "SELECT  * FROM " + TABLE_ACCESSTOKEN;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				token.setAccessToken(cursor.getString(0));
				token.setUserName(cursor.getString(1));
			} while (cursor.moveToNext());
		}

		return token;
	}

	public Client getClient() {
		Client c = new Client();
		String selectQuery = "SELECT  * FROM " + TABLE_CLIENT;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				c.setClientID(cursor.getString(0));
				c.setClientPassword(cursor.getString(1));
			} while (cursor.moveToNext());
		}

		return c;
	}

	// Adding new bp
	public void addBloodPressure(BloodPressure bp) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DATE, bp.getDate());
		values.put(KEY_TIME, bp.getTime());
		values.put(KEY_SYSTOLIC, bp.getSystolic());
		values.put(KEY_DIASTOLIC, bp.getDiastolic());
		values.put(KEY_STATUS, bp.getStatus());

		// Inserting Row
		db.insert(TABLE_BLOODPRESSURE, null, values);
		db.close(); // Closing database connection
	}

	// Getting All Contacts
	public List<BloodPressure> getAllBloodPressure() {
		List<BloodPressure> bpList = new ArrayList<BloodPressure>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_BLOODPRESSURE;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				BloodPressure bp = new BloodPressure();
				// bp.setId(Integer.parseInt(cursor.getString(0)));
				Log.e("data", cursor.getString(1));
				bp.setDate(cursor.getString(1));
				bp.setTime(cursor.getString(2));
				bp.setSystolic(Integer.parseInt(cursor.getString(3)));
				bp.setDiastolic(Integer.parseInt(cursor.getString(4)));
				bp.setStatus(cursor.getString(5));
				// Adding contact to list
				bpList.add(bp);
			} while (cursor.moveToNext());
		}

		// return contact list
		return bpList;
	}

	public void setAccessToken(AccessToken accessToken) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_ACCESSTOKEN, null, null);
		// db.execSQL("delete * from " + TABLE_ACCESSTOKEN);

		ContentValues values = new ContentValues();
		values.put(KEY_ACCESSTOKEN, accessToken.getAccessToken());
		values.put(KEY_USERNAME, accessToken.getUserName());

		db.insert(TABLE_ACCESSTOKEN, null, values);
		db.close();
	}

	public void setClient(Client c) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_CLIENT, null, null);
		// db.execSQL("delete * from " + TABLE_ACCESSTOKEN);

		ContentValues values = new ContentValues();
		values.put(KEY_CLIENTID, c.getClientID());
		values.put(KEY_CLIENTPASSWORD, c.getClientPassword());

		db.insert(TABLE_CLIENT, null, values);
		db.close();
	}
}
