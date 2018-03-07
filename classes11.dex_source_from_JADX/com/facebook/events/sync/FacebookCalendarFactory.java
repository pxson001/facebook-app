package com.facebook.events.sync;

import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.CalendarContract.Calendars;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fb.com/reg?i=%s */
public class FacebookCalendarFactory {
    private static final Class<?> f7234a = FacebookCalendarFactory.class;
    private static final String[] f7235b = new String[]{"_id"};
    private final Context f7236c;
    public ContentProviderClient f7237d;
    public Account f7238e;

    @Inject
    public FacebookCalendarFactory(Context context) {
        this.f7236c = context;
    }

    private long m8455b() {
        try {
            Cursor query = this.f7237d.query(Calendars.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.f7238e.name).appendQueryParameter("account_type", this.f7238e.type).build(), f7235b, null, null, null);
            if (query.moveToNext()) {
                return query.getLong(0);
            }
            return -1;
        } catch (RemoteException e) {
            return -1;
        }
    }

    private long m8456c() {
        long b = m8455b();
        if (b != -1) {
            return b;
        }
        ArrayList a = Lists.a();
        a.add(ContentProviderOperation.newInsert(Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.f7238e.name).appendQueryParameter("account_type", this.f7238e.type).build()).withValue("account_name", this.f7238e.name).withValue("account_type", this.f7238e.type).withValue("name", "facebook_event").withValue("calendar_displayName", this.f7236c.getString(2131242455)).withValue("calendar_access_level", Integer.valueOf(200)).withValue("ownerAccount", this.f7238e.name).withValue("sync_events", Integer.valueOf(1)).build());
        if (m8454a(a)) {
            return m8455b();
        }
        return -1;
    }

    private boolean m8454a(ArrayList<ContentProviderOperation> arrayList) {
        try {
            this.f7237d.applyBatch(arrayList);
            return true;
        } catch (RemoteException e) {
            return false;
        } catch (OperationApplicationException e2) {
            return false;
        }
    }

    @Nullable
    private FacebookCalendar m8457d() {
        long c = m8456c();
        if (c == -1) {
            return null;
        }
        return new FacebookCalendar(c, this.f7238e, this.f7237d, this.f7236c);
    }

    public final FacebookCalendar m8458a() {
        return m8457d();
    }
}
