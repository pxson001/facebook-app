package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.EventReminderMembersTable.Columns;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: me/message_animated_images */
public class DbThreadEventReminderMembersUtil {
    public static final String f10442a = Columns.f10661a.d;
    public static final String f10443b = Columns.f10662b.d;
    public static final String f10444c = Columns.f10663c.d;
    private static volatile DbThreadEventReminderMembersUtil f10445d;

    public static com.facebook.messaging.database.threads.DbThreadEventReminderMembersUtil m11109a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10445d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.DbThreadEventReminderMembersUtil.class;
        monitor-enter(r1);
        r0 = f10445d;	 Catch:{ all -> 0x0039 }
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
        r0 = m11108a();	 Catch:{ all -> 0x0034 }
        f10445d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10445d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.DbThreadEventReminderMembersUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.DbThreadEventReminderMembersUtil");
    }

    private static DbThreadEventReminderMembersUtil m11108a() {
        return new DbThreadEventReminderMembersUtil();
    }

    public static void m11111a(SQLiteDatabase sQLiteDatabase, List<ThreadEventReminder> list) {
        SQLiteDetour.a(sQLiteDatabase, 1123613987);
        try {
            for (ThreadEventReminder threadEventReminder : list) {
                m11110a(sQLiteDatabase, threadEventReminder.a(), threadEventReminder.e());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(sQLiteDatabase, -623947081);
        }
    }

    private static void m11110a(SQLiteDatabase sQLiteDatabase, String str, @Nullable ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> immutableMap) {
        if (immutableMap != null) {
            ContentValues contentValues = new ContentValues();
            Iterator it = immutableMap.keySet().iterator();
            while (it.hasNext()) {
                UserKey userKey = (UserKey) it.next();
                if (immutableMap.get(userKey) != null) {
                    contentValues.put(f10442a, str);
                    contentValues.put(f10443b, userKey.c());
                    contentValues.put(f10444c, ((GraphQLLightweightEventGuestStatus) immutableMap.get(userKey)).toString());
                    SQLiteDetour.a(9350996);
                    sQLiteDatabase.replaceOrThrow("event_reminder_members", null, contentValues);
                    SQLiteDetour.a(-622092795);
                    contentValues.clear();
                }
            }
        }
    }

    public static Cursor m11107a(SQLiteDatabase sQLiteDatabase, ImmutableList<ThreadEventReminder> immutableList) {
        Collection arrayList = new ArrayList(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((ThreadEventReminder) immutableList.get(i)).a);
        }
        Expression a = SqlExpression.a(Columns.f10661a.d, arrayList);
        String a2 = a.a();
        String[] b = a.b();
        return sQLiteDatabase.query("event_reminder_members", null, a2, b, null, null, null);
    }
}
