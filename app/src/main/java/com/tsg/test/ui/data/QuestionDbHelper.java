package com.tsg.test.ui.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class QuestionDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "questions.db";
    private static final String TABLE_NAME = "Questions";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_CATEGORY = "Category";
    private static final String COLUMN_BODY = "Question";
    private static final String COLUMN_CORRECT_ANSWER = "CorrectAnswer";
    private static final String COLUMN_UNCORRECT_ANSWER1 = "UncorrectAnswer1";
    private static final String COLUMN_UNCORRECT_ANSWER2 = "UncorrectAnswer2";
    private static final String COLUMN_UNCORRECT_ANSWER3 = "UncorrectAnswer3";


    public QuestionDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public QuestionDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public QuestionDbHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_BODY + " TEXT, " +
                COLUMN_CORRECT_ANSWER + " TEXT, " +
                COLUMN_UNCORRECT_ANSWER1 + " TEXT, " +
                COLUMN_UNCORRECT_ANSWER2 + " TEXT, " +
                COLUMN_UNCORRECT_ANSWER3 + " TEXT); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
