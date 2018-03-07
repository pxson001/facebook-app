package android_src.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.v7.widget.LinearLayoutCompat;
import android_src.database.sqlite.SqliteWrapper;

/* compiled from: bd_search */
public final class Telephony {

    /* compiled from: bd_search */
    public final class Sms implements BaseColumns {
        public static final Uri f7984a = Uri.parse("content://sms");

        /* compiled from: bd_search */
        public final class Conversations implements BaseColumns {
            public static final Uri f7983a = Uri.parse("content://sms/conversations");
        }

        public static Uri m14118a(ContentResolver contentResolver, Uri uri, String str, String str2, String str3, Long l, boolean z, boolean z2, long j) {
            ContentValues contentValues = new ContentValues(7);
            contentValues.put("address", str);
            if (l != null) {
                contentValues.put("date", l);
            }
            contentValues.put("read", z ? Integer.valueOf(1) : Integer.valueOf(0));
            contentValues.put("subject", str3);
            contentValues.put("body", str2);
            if (z2) {
                contentValues.put("status", Integer.valueOf(32));
            }
            if (j != -1) {
                contentValues.put("thread_id", Long.valueOf(j));
            }
            return contentResolver.insert(uri, contentValues);
        }

        public static boolean m14120a(Context context, Uri uri, int i, int i2) {
            if (uri == null) {
                return false;
            }
            boolean z;
            boolean z2;
            switch (i) {
                case 1:
                case 3:
                    z = false;
                    z2 = false;
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    z = true;
                    z2 = false;
                    break;
                case 5:
                case 6:
                    z = false;
                    z2 = true;
                    break;
                default:
                    return false;
            }
            ContentValues contentValues = new ContentValues(3);
            contentValues.put("type", Integer.valueOf(i));
            if (z2) {
                contentValues.put("read", Integer.valueOf(0));
            } else if (z) {
                contentValues.put("read", Integer.valueOf(1));
            }
            contentValues.put("error_code", Integer.valueOf(i2));
            if (1 == SqliteWrapper.m14113a(context, context.getContentResolver(), uri, contentValues, null, null)) {
                return true;
            }
            return false;
        }

        public static boolean m14119a(int i) {
            return i == 5 || i == 4 || i == 2 || i == 6;
        }
    }
}
