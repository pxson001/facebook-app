package com.facebook.feed.data.freshfeed.ranking;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Files;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: session_count */
public class MediaRollHelper {
    private static final Uri f5487c = Files.getContentUri("external");
    private static final String[] f5488d = new String[]{"date_added", "_data", "media_type"};
    public static final String f5489e = StringFormatUtil.a("%s = %d AND (LOWER(%s) LIKE '%%dcim%%' or LOWER(%s) LIKE '%%camera%%')", new Object[]{"media_type", Integer.valueOf(1), "_data", "_data"});
    private Context f5490a;
    private Clock f5491b;

    @Inject
    public MediaRollHelper(Clock clock, Context context) {
        this.f5491b = clock;
        this.f5490a = context;
    }

    public final boolean m9377a(long j) {
        long a = m9376a();
        if (a != -1000 && (this.f5491b.mo211a() - a) / 60000 <= j) {
            return true;
        }
        return false;
    }

    private long m9376a() {
        if (this.f5490a.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == -1) {
            return -1000;
        }
        Cursor query = this.f5490a.getContentResolver().query(f5487c, f5488d, f5489e, null, "date_added DESC LIMIT 1");
        if (query == null) {
            return -1000;
        }
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(-1000);
        if (query.moveToNext()) {
            toSeconds = query.getLong(0);
        }
        query.close();
        return TimeUnit.SECONDS.toMillis(toSeconds);
    }
}
