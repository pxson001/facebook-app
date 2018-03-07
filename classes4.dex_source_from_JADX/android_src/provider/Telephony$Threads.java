package android_src.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.BaseColumns;
import android_src.database.sqlite.SqliteWrapper;
import com.facebook.debug.log.BLog;
import java.util.Set;

/* compiled from: fb4a_upload_quality */
public final class Telephony$Threads implements BaseColumns {
    public static final Uri f13306a;
    public static final Uri f13307b;
    private static final String[] f13308c = new String[]{"_id"};
    private static final Uri f13309d = Uri.parse("content://mms-sms/threadID");

    static {
        Uri withAppendedPath = Uri.withAppendedPath(Telephony$MmsSms.f13310a, "conversations");
        f13306a = withAppendedPath;
        f13307b = Uri.withAppendedPath(withAppendedPath, "obsolete");
    }

    public static long m14195a(Context context, Set<String> set) {
        Builder buildUpon = f13309d.buildUpon();
        for (String str : set) {
            String str2;
            if (Telephony$Mms.m12758b(str2)) {
                str2 = Telephony$Mms.m12757a(str2);
            }
            buildUpon.appendQueryParameter("recipient", str2);
        }
        Uri build = buildUpon.build();
        Cursor a = SqliteWrapper.a(context, context.getContentResolver(), build, f13308c, null, null, null);
        if (a != null) {
            new StringBuilder("getOrCreateThreadId cursor cnt: ").append(a.getCount());
            long j = -1;
            Object obj = null;
            while (a.moveToNext()) {
                try {
                    obj = 1;
                    j = a.getLong(0);
                    if (j > 0) {
                        break;
                    }
                } finally {
                    a.close();
                }
            }
            if (obj != null) {
                a.close();
                return j;
            }
            BLog.b("Telephony", "getOrCreateThreadId returned no rows!");
            a.close();
        }
        BLog.b("Telephony", "getOrCreateThreadId failed with uri " + build.toString());
        throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
    }
}
