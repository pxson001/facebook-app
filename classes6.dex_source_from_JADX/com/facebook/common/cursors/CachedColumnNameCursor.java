package com.facebook.common.cursors;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: place_picker_started */
public class CachedColumnNameCursor extends CursorWrapper {
    private static final Class<?> f7712a = CachedColumnNameCursor.class;
    public Map<String, Integer> f7713b;

    @Inject
    public CachedColumnNameCursor(@Assisted Cursor cursor) {
        super(cursor);
    }

    public int getColumnIndexOrThrow(String str) {
        Integer valueOf = Integer.valueOf(getColumnIndex(str));
        if (valueOf.intValue() >= 0) {
            return valueOf.intValue();
        }
        throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("column '%s' does not exist", str));
    }

    public int getColumnIndex(String str) {
        if (this.f7713b == null) {
            this.f7713b = new HashMap();
            String[] columnNames = getColumnNames();
            for (int i = 0; i < columnNames.length; i++) {
                this.f7713b.put(m11023a(columnNames[i]), Integer.valueOf(i));
            }
        }
        Integer num = (Integer) this.f7713b.get(m11023a(str));
        return num == null ? -1 : num.intValue();
    }

    public static String m11023a(String str) {
        String toLowerCase = str.toLowerCase(Locale.US);
        int lastIndexOf = toLowerCase.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return toLowerCase;
        }
        BLog.b(f7712a, "requesting column name with table name -- %s", new Object[]{str});
        return toLowerCase.substring(lastIndexOf + 1);
    }
}
