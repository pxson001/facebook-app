package com.facebook.messaging.sms.migration.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.PhoneLookup;
import android_src.provider.Telephony.Sms;
import com.facebook.common.time.Clock;
import com.facebook.contactlogs.migrator.TopSmsContact;
import com.facebook.contactlogs.migrator.TopSmsContact.Builder;
import com.facebook.inject.Lazy;
import com.facebook.messaging.sms.migration.abtest.ExperimentsForSMSMigrationModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pull to refresh */
public class TopSmsContactsGetterUtil {
    public final Lazy<Clock> f4246a;
    private final ContentResolver f4247b;
    private final QeAccessor f4248c;
    private final RuntimePermissionsUtil f4249d;

    /* compiled from: pull to refresh */
    class C06401 implements Comparator<TopSmsContact> {
        final /* synthetic */ TopSmsContactsGetterUtil f4245a;

        C06401(TopSmsContactsGetterUtil topSmsContactsGetterUtil) {
            this.f4245a = topSmsContactsGetterUtil;
        }

        public int compare(Object obj, Object obj2) {
            return ((TopSmsContact) obj2).e - ((TopSmsContact) obj).e;
        }
    }

    @javax.annotation.Nullable
    public final com.google.common.collect.ImmutableList<com.facebook.contactlogs.migrator.TopSmsContact> m3875a(int r8) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r6 = 0;
        r0 = r7.f4249d;
        r1 = "android.permission.READ_SMS";
        r0 = r0.a(r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r6;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r7.f4247b;	 Catch:{ all -> 0x0030 }
        r1 = android_src.provider.Telephony.Sms.Conversations.a;	 Catch:{ all -> 0x0030 }
        r2 = 2;	 Catch:{ all -> 0x0030 }
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x0030 }
        r3 = 0;	 Catch:{ all -> 0x0030 }
        r4 = "thread_id";	 Catch:{ all -> 0x0030 }
        r2[r3] = r4;	 Catch:{ all -> 0x0030 }
        r3 = 1;	 Catch:{ all -> 0x0030 }
        r4 = "msg_count";	 Catch:{ all -> 0x0030 }
        r2[r3] = r4;	 Catch:{ all -> 0x0030 }
        r3 = 0;	 Catch:{ all -> 0x0030 }
        r4 = 0;	 Catch:{ all -> 0x0030 }
        r5 = "msg_count DESC LIMIT 20";	 Catch:{ all -> 0x0030 }
        r6 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0030 }
        r0 = r7.m3869a(r6, r8);	 Catch:{ all -> 0x0030 }
        if (r6 == 0) goto L_0x000c;
    L_0x002c:
        r6.close();
        goto L_0x000c;
    L_0x0030:
        r0 = move-exception;
        if (r6 == 0) goto L_0x0036;
    L_0x0033:
        r6.close();
    L_0x0036:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.migration.util.TopSmsContactsGetterUtil.a(int):com.google.common.collect.ImmutableList<com.facebook.contactlogs.migrator.TopSmsContact>");
    }

    @Inject
    public TopSmsContactsGetterUtil(Lazy<Clock> lazy, ContentResolver contentResolver, QeAccessor qeAccessor, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f4246a = lazy;
        this.f4247b = contentResolver;
        this.f4248c = qeAccessor;
        this.f4249d = runtimePermissionsUtil;
    }

    @Nullable
    private ImmutableList<TopSmsContact> m3869a(Cursor cursor, int i) {
        if (cursor == null) {
            return null;
        }
        Collection subList;
        List arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("thread_id");
        int columnIndex2 = cursor.getColumnIndex("msg_count");
        int i2 = 0;
        while (cursor.moveToNext() && i2 < 10) {
            String string = cursor.getString(columnIndex);
            int i3 = cursor.getInt(columnIndex2);
            Builder builder = new Builder();
            builder.c = i3;
            Builder builder2 = builder;
            m3873a(string, builder2);
            if (builder2.a != null) {
                m3872a(builder2);
                if (builder2.e != -1) {
                    arrayList.add(new TopSmsContact(builder2));
                    i2++;
                }
            }
        }
        Collections.sort(arrayList, new C06401(this));
        if (arrayList.size() > i) {
            subList = arrayList.subList(0, i);
        } else {
            Object obj = arrayList;
        }
        return ImmutableList.copyOf(subList);
    }

    private void m3873a(String str, Builder builder) {
        Throwable th;
        Cursor query;
        try {
            query = this.f4247b.query(Sms.a, new String[]{"address"}, m3870a(), m3874a(str), "date DESC");
            try {
                m3871a(query, builder);
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private String m3870a() {
        return this.f4248c.a(ExperimentsForSMSMigrationModule.f4218b, false) ? "thread_id=? and type=? and date>=?" : "thread_id=? and type=?";
    }

    private String[] m3874a(String str) {
        if (this.f4248c.a(ExperimentsForSMSMigrationModule.f4218b, false)) {
            return new String[]{str, "2", String.valueOf(((Clock) this.f4246a.get()).a() - 2592000000L)};
        }
        return new String[]{str, "2"};
    }

    private static void m3871a(Cursor cursor, Builder builder) {
        if (cursor != null && cursor.getCount() != 0) {
            builder.d = cursor.getCount();
            cursor.moveToFirst();
            builder.a = cursor.getString(cursor.getColumnIndex("address"));
        }
    }

    private void m3872a(Builder builder) {
        Throwable th;
        Cursor query;
        try {
            Uri withAppendedPath = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(builder.a()));
            query = this.f4247b.query(withAppendedPath, new String[]{"_id", "display_name"}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        query.moveToFirst();
                        builder.c(query.getInt(query.getColumnIndex("_id")));
                        builder.b(query.getString(query.getColumnIndex("display_name")));
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
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
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
