package com.facebook.widget.listview;

import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;

/* compiled from: event_source */
public class ListViewReflectionUtil {
    private static final Field f12730a;

    static {
        Field field = null;
        try {
            field = AbsListView.class.getDeclaredField("mLayoutMode");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
        f12730a = field;
    }

    static int m13547a(ListView listView) {
        int i = -1;
        try {
            if (f12730a != null) {
                i = f12730a.getInt(listView);
            }
        } catch (IllegalAccessException e) {
        }
        return i;
    }
}
