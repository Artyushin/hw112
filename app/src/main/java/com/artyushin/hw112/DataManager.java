package com.artyushin.hw112;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    static public List<Information> retrieveInformation(){
        List<Information> result = new ArrayList<> ();
        result.add(new Information(R.mipmap.ic_settings, "Настройки", "Переход в системные настройки", R.string.Del));
        result.add(new Information(R.mipmap.ic_note, "Записная книжка", "Приложение Записная книжка.\n" +
                "Данные сохраняютя и подгружаются при следующем запуске приложения. \n" +
                "Используется SharedPreferences", R.string.Del));
        result.add(new Information(R.mipmap.ic_password, "Регистрация", "Простая форма для ввода регистрационных данных", R.string.Del));
        result.add(new Information(R.mipmap.ic_payment, "Платеж", "Интерфейс для ввода данных о платеже", R.string.Del));
        return result;
    }
}
