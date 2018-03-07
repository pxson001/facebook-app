package com.facebook.backstage.consumption.importflow;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.data.TimezoneDate;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.prefs.shared.FbSharedPreferences;
import java.util.Date;
import java.util.TimeZone;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ride_service_params */
public class LocalMediaCursorUtil {
    private static final String f4828a = LocalMediaCursorUtil.class.getSimpleName();
    private static final String[] f4829b = new String[]{"_id", "_data", "datetaken", "mini_thumb_magic"};
    private static final String[] f4830c = new String[]{"_id", "_data", "datetaken", "mini_thumb_magic"};
    private final ContentResolver f4831d;
    private final AbstractFbErrorReporter f4832e;
    private final FbSharedPreferences f4833f;
    private final Clock f4834g;
    private final BackstageGatekeepers f4835h;

    @Inject
    public LocalMediaCursorUtil(ContentResolver contentResolver, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, Clock clock, BackstageGatekeepers backstageGatekeepers) {
        this.f4831d = contentResolver;
        this.f4832e = abstractFbErrorReporter;
        this.f4833f = fbSharedPreferences;
        this.f4834g = clock;
        this.f4835h = backstageGatekeepers;
    }

    @Nullable
    public final Cursor m4725a(boolean z) {
        return m4721a(Media.EXTERNAL_CONTENT_URI, m4723a(), f4829b, m4724c(z));
    }

    @Nullable
    public final Cursor m4726b(boolean z) {
        return m4721a(Video.Media.EXTERNAL_CONTENT_URI, m4723a(), f4830c, m4724c(z));
    }

    public static ImportMedia m4722a(Cursor cursor, boolean z) {
        return new ImportMedia(cursor.getString(1), "", new TimezoneDate(cursor.getLong(2), (long) TimeZone.getDefault().getRawOffset()), z);
    }

    private long m4724c(boolean z) {
        if (z) {
            return Math.min(this.f4834g.a() - this.f4833f.a(StacksConstants.f4257g, 0), 86400000);
        }
        if (this.f4835h.m4257a()) {
            return 86400000;
        }
        return Math.min(this.f4834g.a() - this.f4833f.a(StacksConstants.f4255e, 0), 86400000);
    }

    @Nullable
    private Cursor m4721a(Uri uri, String str, String[] strArr, long j) {
        Date date = new Date();
        long time = date.getTime() / 1000;
        long time2 = new Date(date.getTime() - j).getTime() / 1000;
        try {
            String[] strArr2 = new String[]{Long.toString(time2), Long.toString(time)};
            return this.f4831d.query(uri, strArr, str, strArr2, "datetaken DESC");
        } catch (Throwable e) {
            BLog.b(f4828a, "fetchMediaItems failed", new Object[]{"error creating cursor", e});
            this.f4832e.a(f4828a + ": fetchMediaItems failed", "error creating cursor", e);
            return null;
        }
    }

    private static String m4723a() {
        return StringFormatUtil.a("%s>=? and %s<=?", new Object[]{"date_added", "date_added"});
    }
}
