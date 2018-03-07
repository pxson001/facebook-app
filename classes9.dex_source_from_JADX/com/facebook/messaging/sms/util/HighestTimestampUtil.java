package com.facebook.messaging.sms.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.MmsSms;
import android_src.provider.Telephony.Sms;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: com.facebook.messaging.sms.REQUEST_SEND_MESSAGE */
public class HighestTimestampUtil {
    private static final String[] f17780a = new String[]{"normalized_date"};
    private static final String[] f17781b = new String[]{"date"};
    private final ContentResolver f17782c;

    public static HighestTimestampUtil m17707b(InjectorLike injectorLike) {
        return new HighestTimestampUtil(ContentResolverMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public HighestTimestampUtil(ContentResolver contentResolver) {
        this.f17782c = contentResolver;
    }

    public final long m17708a(long j) {
        Throwable th;
        Cursor cursor;
        if (j < 0) {
            return m17706b(j);
        }
        try {
            long j2;
            Cursor query = this.f17782c.query(Uri.withAppendedPath(MmsSms.b, String.valueOf(j)), f17780a, null, null, "normalized_date DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        j2 = query.getLong(0);
                        if (query != null) {
                            return j2;
                        }
                        query.close();
                        return j2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            j2 = -1;
            if (query != null) {
                return j2;
            }
            query.close();
            return j2;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private long m17706b(long j) {
        Throwable th;
        long j2 = -1;
        Cursor cursor = null;
        Expression a = SqlExpression.a("thread_id", String.valueOf(j));
        Cursor query;
        try {
            query = this.f17782c.query(Sms.a, f17781b, a.a(), a.b(), "date DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        j2 = Math.max(-1, query.getLong(0));
                    }
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
            } else {
                cursor = query;
            }
            try {
                long max;
                query = this.f17782c.query(Mms.a, f17781b, a.a(), a.b(), "date DESC LIMIT 1");
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            max = Math.max(j2, query.getLong(0) * 1000);
                            if (query != null) {
                                query.close();
                            }
                            return max;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                max = j2;
                if (query != null) {
                    query.close();
                }
                return max;
            } catch (Throwable th4) {
                th = th4;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
