package ua.umbrella.englishverb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.service.RemoteService;

public class DbHelper extends SQLiteOpenHelper
{
  private static final String DATABASE_NAME = "EnglishVerb.db";
  private static final int DATABASE_VERSION = 1;

  public DbHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database)
  {
    TwinTable.onCreate(database);
    RemoteService remoteService = new RemoteService();
    List<Twin> twinList = remoteService.getTwinsFromJson();
    for(Twin twin : twinList)
    {
      ContentValues values = new ContentValues();
      values.put(TwinTable.ID, twin.getId());
      values.put(TwinTable.ENGLISH, twin.getEnglish());
      values.put(TwinTable.RUSSIAN, twin.getRussian());
      database.insert(TwinTable.TABLE_TWINS, null, values);
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
  {
    TwinTable.onUpgrade(database, oldVersion, newVersion);
  }
}
