package com.facebook.photos.simplepicker.logging;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Files;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeConversions;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaCursorHelper;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: shadow-radius */
public class MediaStatsLoggingManager {
    private static final String[] f3175a = new String[]{"_id", "media_type", "mime_type", "date_modified"};
    private final ContentResolver f3176b;
    private final AnalyticsLogger f3177c;
    private final FbNetworkManager f3178d;
    private final GatekeeperStoreImpl f3179e;
    private final FbSharedPreferences f3180f;
    private final Clock f3181g;

    public static MediaStatsLoggingManager m3164b(InjectorLike injectorLike) {
        return new MediaStatsLoggingManager(ContentResolverMethodAutoProvider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaStatsLoggingManager(ContentResolver contentResolver, AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, GatekeeperStoreImpl gatekeeperStoreImpl, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f3176b = contentResolver;
        this.f3177c = analyticsLogger;
        this.f3178d = fbNetworkManager;
        this.f3179e = gatekeeperStoreImpl;
        this.f3180f = fbSharedPreferences;
        this.f3181g = clock;
    }

    public final void m3165a() {
        if (this.f3179e.a(608, false)) {
            long a = this.f3181g.a();
            long a2 = this.f3180f.a(PhotosPrefKeys.i, -1);
            if (a - a2 >= 600000) {
                Cursor a3 = m3162a(a);
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                if (a3.moveToFirst()) {
                    int columnIndexOrThrow = a3.getColumnIndexOrThrow("date_modified");
                    int columnIndexOrThrow2 = a3.getColumnIndexOrThrow("mime_type");
                    do {
                        long parseLong = Long.parseLong(a3.getString(columnIndexOrThrow)) * 1000;
                        MimeType a4 = MimeType.a(a3.getString(columnIndexOrThrow2));
                        if (MediaUtils.a(a4.a())) {
                            if (parseLong > a2) {
                                i2++;
                            }
                            i++;
                        } else if (MediaUtils.b(a4.a())) {
                            if (parseLong > a2) {
                                i4++;
                            }
                            i3++;
                        }
                    } while (a3.moveToNext());
                }
                m3163a(i, i2, i3, i4);
                a3.close();
                this.f3180f.edit().a(PhotosPrefKeys.i, a).commit();
            }
        }
    }

    private Cursor m3162a(long j) {
        String str = StringFormatUtil.a("%s>=? AND %s<=?", new Object[]{"date_modified", "date_modified"}) + " AND " + MediaCursorHelper.a(SupportedMediaType.ALL);
        long m = TimeConversions.m(j - 172800000);
        long m2 = TimeConversions.m(j);
        return this.f3176b.query(Files.getContentUri("external"), f3175a, str, new String[]{Long.toString(m), Long.toString(m2)}, "date_modified DESC");
    }

    private void m3163a(int i, int i2, int i3, int i4) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("picker_new_media_count");
        honeyClientEvent.b("reachability_status", this.f3178d.p());
        honeyClientEvent.a("photo_count_48_h", i);
        honeyClientEvent.a("photo_count_48_h_since_last_log", i2);
        honeyClientEvent.a("video_count_48_h", i3);
        honeyClientEvent.a("video_count_48_h_since_last_log", i4);
        this.f3177c.a(honeyClientEvent);
    }
}
