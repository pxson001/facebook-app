package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.EventRemindersTable.Columns;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Singleton;

@Singleton
/* compiled from: me/linked_messenger_commerce_businesses */
public class DbThreadEventRemindersUtil {
    public static final String f10446a = Columns.f10666a.d;
    public static final String f10447b = Columns.f10667b.d;
    public static final String f10448c = Columns.f10668c.d;
    public static final String f10449d = Columns.f10669d.d;
    public static final String f10450e = Columns.f10670e.d;
    private static volatile DbThreadEventRemindersUtil f10451f;

    public static com.facebook.messaging.database.threads.DbThreadEventRemindersUtil m11114a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10451f;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.DbThreadEventRemindersUtil.class;
        monitor-enter(r1);
        r0 = f10451f;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m11113a();	 Catch:{ all -> 0x0034 }
        f10451f = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10451f;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.DbThreadEventRemindersUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.DbThreadEventRemindersUtil");
    }

    private static DbThreadEventRemindersUtil m11113a() {
        return new DbThreadEventRemindersUtil();
    }

    public static void m11116a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, List<ThreadEventReminder> list) {
        SQLiteDetour.a(sQLiteDatabase, 174864327);
        try {
            for (ThreadEventReminder threadEventReminder : list) {
                if (threadEventReminder.d()) {
                    m11117a(sQLiteDatabase, threadEventReminder.a());
                } else {
                    m11115a(sQLiteDatabase, threadKey, threadEventReminder);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(sQLiteDatabase, -623914134);
        }
    }

    public static Cursor m11112a(SQLiteDatabase sQLiteDatabase, ImmutableList<ThreadKey> immutableList, long j) {
        Collection arrayList = new ArrayList(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((ThreadKey) immutableList.get(i)).g());
        }
        Expression a = SqlExpression.a(Columns.f10666a.d, arrayList);
        Expression f = SqlExpression.f(Columns.f10668c.d, String.valueOf(j / 1000));
        ConjunctionExpression a2 = SqlExpression.a(new Expression[]{a, f});
        return sQLiteDatabase.query("event_reminders", null, a2.a(), a2.b(), null, null, "event_reminder_timestamp ASC");
    }

    private static void m11115a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, ThreadEventReminder threadEventReminder) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f10446a, threadKey.g());
        contentValues.put(f10447b, threadEventReminder.a);
        contentValues.put(f10448c, Long.valueOf(threadEventReminder.b));
        contentValues.put(f10449d, threadEventReminder.c);
        contentValues.put(f10450e, Boolean.valueOf(threadEventReminder.f));
        SQLiteDetour.a(1288355702);
        sQLiteDatabase.replaceOrThrow("event_reminders", null, contentValues);
        SQLiteDetour.a(-1153848693);
        contentValues.clear();
    }

    private static void m11117a(SQLiteDatabase sQLiteDatabase, String str) {
        Expression a = SqlExpression.a(Columns.f10667b.d, str);
        sQLiteDatabase.delete("event_reminders", a.a(), a.b());
    }
}
