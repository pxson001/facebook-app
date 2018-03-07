package com.facebook.feed.thirdparty.instagram;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: should_show_nux */
public class InstagramAttributionLogRunnable implements Runnable {
    private static final Uri f3762a = Uri.parse(StringFormatUtil.a("content://%s.provider.AttributionIdProvider", new Object[]{BuildConstants.n()}));
    private final ContentResolver f3763b;
    private final AnalyticsLogger f3764c;
    private final HoneyClientEvent f3765d;

    private static String m4430a(ContentResolver contentResolver) {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = contentResolver.query(f3762a, new String[]{"aid"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("aid"));
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (RuntimeException e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (RuntimeException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return null;
    }

    public InstagramAttributionLogRunnable(Context context, AnalyticsLogger analyticsLogger, HoneyClientEvent honeyClientEvent) {
        this.f3763b = context.getContentResolver();
        this.f3764c = analyticsLogger;
        this.f3765d = honeyClientEvent;
    }

    public void run() {
        this.f3765d.b("advertising_id", m4430a(this.f3763b));
        this.f3764c.a(this.f3765d);
    }
}
