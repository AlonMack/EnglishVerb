package ua.umbrella.englishverb.service;

import android.content.Context;

import ua.umbrella.englishverb.dao.SettingDao;
import ua.umbrella.englishverb.object.Setting;

public class SettingService
{
  private static final SettingService settingService = new SettingService();
  private static SettingDao settingDao;
  private SettingService()
  {
  }

  public static SettingService getSettingService(Context context)
  {
    settingDao = SettingDao.getSettingDao(context);
    return settingService;
  }

  public Setting getSetting()
  {
    return settingDao.getSetting();
  }
}
