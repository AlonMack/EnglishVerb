package ua.umbrella.englishverb.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import ua.umbrella.englishverb.object.Twin;

public class VerbDao
{
  private SQLiteDatabase database;
  private DbHelper dbHelper;
  private String[] allColumns =
      {
          DbHelper.ID,
          DbHelper.ENGLISH,
          DbHelper.RUSSIAN
      };

  public VerbDao(Context context)
  {
    dbHelper = new DbHelper(context);
  }

  public void openForWrite() throws SQLException
  {
    database = dbHelper.getWritableDatabase();
  }

  public void openForRead() throws SQLException
  {
    database = dbHelper.getReadableDatabase();
  }

  public void close()
  {
    dbHelper.close();
  }

  public Set<Twin> getAllTwins()
  {
    Set<Twin> twinList = new HashSet<Twin>();
    openForRead();
    Cursor cursor = database.query(DbHelper.TABLE_VERBS, allColumns, null, null, null, null, null);
    cursor.moveToFirst();
    while(! cursor.isAfterLast())
    {
      Twin twin = cursorToVerb(cursor);
      twinList.add(twin);
      cursor.moveToNext();
    }
    cursor.close();
    close();
    return twinList;
  }

  public Twin getTwinById(int id)
  {
    Twin twin = new Twin();
    openForRead();
    Cursor cursor = database.query(DbHelper.TABLE_VERBS, allColumns, "_id="+id, null, null, null, null);
    if (cursor.moveToFirst()){
      twin = cursorToVerb(cursor);
    }
    cursor.close();
    close();
    return twin;
  }

  private Twin cursorToVerb(Cursor cursor)
  {
    Twin twin = new Twin();
    twin.setId(cursor.getInt(0));
    twin.setEnglish(cursor.getString(1));
    twin.setRussian(cursor.getString(2));

    return twin;
  }
}
