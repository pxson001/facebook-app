package com.facebook.events.sync;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentUris;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.CalendarContract.Events;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.debug.log.BLog;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@TargetApi(14)
/* compiled from: fb4a_auto_update_complete_notification_enabled */
public class FacebookCalendar {
    private static final String[] f7218a = new String[]{"_id", "_sync_id"};
    private static final String f7219b = "true";
    private static final String f7220c = FacebookCalendar.class.getSimpleName();
    private final long f7221d;
    private final Account f7222e;
    private final ContentProviderClient f7223f;
    private final Context f7224g;

    /* compiled from: fb4a_auto_update_complete_notification_enabled */
    public class SyncEntry {
        public final long f7216a;
        public final long f7217b;

        public SyncEntry(long j, long j2) {
            this.f7216a = j;
            this.f7217b = j2;
        }
    }

    public FacebookCalendar(long j, Account account, ContentProviderClient contentProviderClient, Context context) {
        this.f7221d = j;
        this.f7222e = account;
        this.f7223f = contentProviderClient;
        this.f7224g = context;
    }

    public final boolean m8451a(ArrayList<ContentProviderOperation> arrayList) {
        try {
            this.f7223f.applyBatch(arrayList);
            return true;
        } catch (RemoteException e) {
            return false;
        } catch (OperationApplicationException e2) {
            return false;
        }
    }

    private ContentProviderOperation m8446a(FacebookCalendarEvent facebookCalendarEvent, Builder builder) {
        if (facebookCalendarEvent.m8452b() == null || facebookCalendarEvent.m8453d() == null) {
            return null;
        }
        int i;
        Object obj;
        long time = facebookCalendarEvent.m8452b().getTime();
        long time2 = facebookCalendarEvent.m8453d().getTime();
        builder.withValue("calendar_id", Long.valueOf(this.f7221d));
        builder.withValue("dtstart", Long.valueOf(time));
        builder.withValue("dtend", Long.valueOf(time2));
        String str = "allDay";
        if (facebookCalendarEvent.f7233i) {
            i = 1;
        } else {
            i = 0;
        }
        builder.withValue(str, Integer.valueOf(i));
        builder.withValue("title", facebookCalendarEvent.f7227c);
        builder.withValue("eventLocation", facebookCalendarEvent.f7228d);
        String str2 = "description";
        builder.withValue(str2, StringLocaleUtil.a("%s%n%n%s%n%s", new Object[]{facebookCalendarEvent.f7230f, this.f7224g.getString(2131242456).toUpperCase(this.f7224g.getResources().getConfiguration().locale), facebookCalendarEvent.f7232h}));
        if (facebookCalendarEvent.f7231g != -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            builder.withValue("eventStatus", Integer.valueOf(facebookCalendarEvent.f7231g));
        }
        builder.withValue("_sync_id", facebookCalendarEvent.f7229e);
        return builder.build();
    }

    public final ContentProviderOperation m8448a(FacebookCalendarEvent facebookCalendarEvent, long j) {
        Builder newUpdate = ContentProviderOperation.newUpdate(Events.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", f7219b).appendQueryParameter("account_name", this.f7222e.name).appendQueryParameter("account_type", this.f7222e.type).build());
        newUpdate.withSelection("_id = '" + j + "'", null);
        return m8446a(facebookCalendarEvent, newUpdate);
    }

    public final ContentProviderOperation m8447a(FacebookCalendarEvent facebookCalendarEvent) {
        return m8446a(facebookCalendarEvent, ContentProviderOperation.newInsert(Events.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", f7219b).appendQueryParameter("account_name", this.f7222e.name).appendQueryParameter("account_type", this.f7222e.type).build()));
    }

    public final void m8450a(long j) {
        try {
            this.f7223f.delete(ContentUris.withAppendedId(Events.CONTENT_URI, j).buildUpon().appendQueryParameter("caller_is_syncadapter", f7219b).appendQueryParameter("account_name", this.f7222e.name).appendQueryParameter("account_type", this.f7222e.type).build(), null, null);
        } catch (Throwable e) {
            BLog.b(f7220c, e, "Error while trying to delete the event with URI=%s.", new Object[]{r1});
        }
    }

    @Nullable
    public final List<SyncEntry> m8449a() {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            Cursor query = this.f7223f.query(Events.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.f7222e.name).appendQueryParameter("account_type", this.f7222e.type).build(), f7218a, "calendar_id=?", new String[]{String.valueOf(this.f7221d)}, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                List<SyncEntry> a = Lists.a(query.getCount());
                while (query.moveToNext()) {
                    a.add(new SyncEntry(query.getLong(0), query.getLong(1)));
                }
                if (query == null) {
                    return a;
                }
                query.close();
                return a;
            } catch (RemoteException e) {
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (RemoteException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }
}
