package ua.umbrella.englishverb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import ua.umbrella.englishverb.object.Twin;
import ua.umbrella.englishverb.service.RemoteService;
import ua.umbrella.englishverb.utils.UserEmailFetcher;

public class DbHelper extends SQLiteOpenHelper
{
  private static final String DATABASE_NAME = "EnglishVerb.db";
  private static final int DATABASE_VERSION = 1;
  private String email = "";

  public DbHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    email = UserEmailFetcher.getEmail(context);
  }

  @Override
  public void onCreate(SQLiteDatabase database)
  {
    TwinTable.onCreate(database);
    SettingTable.onCreate(database);
    //TODO: move to TwinTable
    RemoteService remoteService = new RemoteService();
    List<Twin> twinList = remoteService.getTwinsFromJson();
    for (Twin twin : twinList)
    {
      ContentValues valueTwin = new ContentValues();
      valueTwin.put(TwinTable.ID, twin.getId());
      valueTwin.put(TwinTable.ENGLISH, twin.getEnglish());
      valueTwin.put(TwinTable.RUSSIAN, twin.getRussian());
      database.insert(TwinTable.TABLE_TWINS, null, valueTwin);
    }
    //TODO: move to SettingTable
    ContentValues valueSetting = new ContentValues();
    valueSetting.put(SettingTable.EMAIL, email);
    valueSetting.put(SettingTable.MAIN_WORD, 0);
    valueSetting.put(SettingTable.TIME, 0);
    database.insert(SettingTable.TABLE_SETTING, null, valueSetting);
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
  {
    TwinTable.onUpgrade(database, oldVersion, newVersion);
    SettingTable.onUpgrade(database, oldVersion, newVersion);
  }
}
