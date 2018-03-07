package com.facebook.rtc.models;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: email_oauth_attempt_count/ */
public class RecentCallsDb {
    public static final Class<?> f13187a = RecentCallsDb.class;
    public static final AtomicBoolean f13188b = new AtomicBoolean();
    private static volatile RecentCallsDb f13189m;
    public final RecentCallsDatabaseSupplier f13190c;
    private final DefaultAndroidThreadUtil f13191d;
    public final ExecutorService f13192e;
    private final Executor f13193f;
    private final DefaultProcessIdleExecutor f13194g;
    public ImmutableList<RtcCallLogInfo> f13195h;
    public QeAccessor f13196i;
    private final BaseFbBroadcastManager f13197j;
    public int f13198k = -1;
    private GatekeeperStoreImpl f13199l;

    public static com.facebook.rtc.models.RecentCallsDb m14049a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f13189m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.models.RecentCallsDb.class;
        monitor-enter(r1);
        r0 = f13189m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14054b(r0);	 Catch:{ all -> 0x0035 }
        f13189m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13189m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.models.RecentCallsDb.a(com.facebook.inject.InjectorLike):com.facebook.rtc.models.RecentCallsDb");
    }

    private static RecentCallsDb m14054b(InjectorLike injectorLike) {
        return new RecentCallsDb(RecentCallsDatabaseSupplier.m14068a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RecentCallsDb(RecentCallsDatabaseSupplier recentCallsDatabaseSupplier, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ExecutorService executorService, QeAccessor qeAccessor, BaseFbBroadcastManager baseFbBroadcastManager, Executor executor, GatekeeperStoreImpl gatekeeperStoreImpl, DefaultProcessIdleExecutor defaultProcessIdleExecutor) {
        this.f13190c = recentCallsDatabaseSupplier;
        this.f13191d = defaultAndroidThreadUtil;
        this.f13192e = executorService;
        this.f13193f = executor;
        this.f13196i = qeAccessor;
        this.f13197j = baseFbBroadcastManager;
        this.f13199l = gatekeeperStoreImpl;
        this.f13194g = defaultProcessIdleExecutor;
    }

    public final void m14065a(String str, boolean z) {
        if (StringUtil.a(str)) {
            BLog.a(f13187a, "Invalid thread id while trying to insert call log into db!");
        } else {
            ExecutorDetour.a(this.f13192e, new 2(this, str, z), 1731845782);
        }
    }

    public final void m14063a(String str, long j, boolean z, boolean z2, boolean z3) {
        if (StringUtil.a(str)) {
            BLog.a(f13187a, "Invalid thread id while trying to insert call log into db!");
        } else {
            m14064a(null, str, j, 0, true, z2, z, true, false, false, z3);
        }
    }

    public final void m14064a(@Nullable String str, @Nullable String str2, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        ExecutorDetour.a(this.f13192e, new 3(this, z4, z3, str, str2, j, j2, z, z2, z5, z6, z7), -1904432781);
    }

    public static void m14057e(RecentCallsDb recentCallsDb) {
        SQLiteDatabase a = recentCallsDb.f13190c.a();
        if (a != null && a.isOpen()) {
            long queryNumEntries = DatabaseUtils.queryNumEntries(a, "person_summary");
            if (queryNumEntries > 100) {
                Long.valueOf(queryNumEntries - 100);
                String str = "delete from person_summary where ROWID IN (SELECT ROWID FROM person_summary ORDER BY last_call_time ASC LIMIT " + String.valueOf(queryNumEntries - 100) + ")";
                SQLiteDetour.a(-1686259235);
                a.execSQL(str);
                SQLiteDetour.a(1328873508);
            }
        }
    }

    public final ImmutableList<RtcCallLogInfo> m14062a(int i) {
        return m14050a(i, new int[]{1, 2}, false);
    }

    public final ImmutableList<RtcCallLogInfo> m14066b(int i) {
        boolean z;
        if (this.f13199l.a(1085, false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return m14062a(i);
        }
        return m14050a(i, new int[]{1, 2, 3}, false);
    }

    public final ImmutableList<RtcCallLogInfo> m14067c(int i) {
        return m14050a(i, new int[]{3}, true);
    }

    private static String m14056d(int i) {
        if (i <= 0) {
            throw new RuntimeException("No placeholders");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            stringBuilder.append(",?");
        }
        return stringBuilder.toString();
    }

    private ImmutableList<RtcCallLogInfo> m14050a(int i, int[] iArr, boolean z) {
        this.f13191d.b("Recent Calls DB accessed from UI Thread");
        Builder builder = ImmutableList.builder();
        SQLiteDatabase a = this.f13190c.a();
        if (a == null || !a.isOpen()) {
            return m14051a(builder);
        }
        int columnIndex;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("call_type");
        stringBuilder.append(" IN (");
        stringBuilder.append(m14056d(iArr.length));
        stringBuilder.append(")");
        stringBuilder.append(" AND ");
        stringBuilder.append("on_going");
        stringBuilder.append(" = ?");
        List arrayList = new ArrayList();
        for (int num : iArr) {
            int num2;
            arrayList.add(Integer.toString(num2));
        }
        arrayList.add(z ? "1" : "0");
        Cursor query = a.query("person_summary", null, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, null, "last_call_time desc", String.valueOf(i));
        if (query == null) {
            return m14051a(builder);
        }
        try {
            ImmutableList<RtcCallLogInfo> a2;
            if (query.moveToFirst()) {
                Integer.valueOf(query.getCount());
                columnIndex = query.getColumnIndex("log_id");
                int columnIndex2 = query.getColumnIndex("user_id");
                int columnIndex3 = query.getColumnIndex("answered");
                num2 = query.getColumnIndex("acknowledged");
                int columnIndex4 = query.getColumnIndex("call_type");
                int columnIndex5 = query.getColumnIndex("direction");
                int columnIndex6 = query.getColumnIndex("duration");
                int columnIndex7 = query.getColumnIndex("last_call_time");
                int columnIndex8 = query.getColumnIndex("seen");
                int columnIndex9 = query.getColumnIndex("thread_id");
                int columnIndex10 = query.getColumnIndex("on_going");
                while (!query.isAfterLast()) {
                    RtcCallLogInfo rtcCallLogInfo = new RtcCallLogInfo();
                    rtcCallLogInfo.a = query.getLong(columnIndex);
                    rtcCallLogInfo.e = query.getInt(columnIndex3) > 0;
                    rtcCallLogInfo.h = query.getInt(num2) > 0;
                    rtcCallLogInfo.g = query.getInt(columnIndex4);
                    rtcCallLogInfo.f = query.getInt(columnIndex5);
                    rtcCallLogInfo.d = query.getLong(columnIndex6);
                    rtcCallLogInfo.c = query.getLong(columnIndex7);
                    rtcCallLogInfo.i = query.getInt(columnIndex8) > 0;
                    if (rtcCallLogInfo.a()) {
                        rtcCallLogInfo.j = ThreadKey.a(Long.parseLong(query.getString(columnIndex9)));
                    }
                    rtcCallLogInfo.b = UserKey.b(query.getString(columnIndex2));
                    rtcCallLogInfo.k = query.getInt(columnIndex10) > 0;
                    builder.c(rtcCallLogInfo);
                    query.moveToNext();
                }
                a2 = m14051a(builder);
                query.close();
                return a2;
            }
            a2 = m14051a(builder);
            return a2;
        } finally {
            query.close();
        }
    }

    public static int m14053b(@Nullable RecentCallsDb recentCallsDb, String str) {
        recentCallsDb.f13191d.b("Recent Calls DB accessed from UI Thread");
        SQLiteDatabase a = recentCallsDb.f13190c.a();
        if (a == null || !a.isOpen()) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("seen", Boolean.valueOf(true));
        if (str == null) {
            return a.update("person_summary", contentValues, "seen = ?", new String[]{"0"});
        }
        return a.update("person_summary", contentValues, "seen = ? AND user_id = ?", new String[]{"0", str});
    }

    public final ImmutableList<UserKey> m14061a() {
        return m14052a(m14062a(5));
    }

    public static ImmutableList<UserKey> m14052a(ImmutableList<RtcCallLogInfo> immutableList) {
        if (immutableList == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RtcCallLogInfo rtcCallLogInfo = (RtcCallLogInfo) immutableList.get(i);
            if (rtcCallLogInfo.b != null && rtcCallLogInfo.b.d()) {
                builder.c(rtcCallLogInfo.b);
            }
        }
        return builder.b();
    }

    private ImmutableList<RtcCallLogInfo> m14051a(Builder<RtcCallLogInfo> builder) {
        ImmutableList b = builder.b();
        m14055b(this, b);
        return b;
    }

    public static void m14058f(RecentCallsDb recentCallsDb) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.rtc.fbwebrtc.CALL_LOG_UPDATED");
        recentCallsDb.f13197j.a(intent);
    }

    public static void m14059g(RecentCallsDb recentCallsDb) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.rtc.fbwebrtc.CALL_LOG_BADGE_UPDATED");
        intent.putExtra("CALL_LOG_EXTRA_UNSEEN_COUNT", recentCallsDb.f13198k);
        recentCallsDb.f13197j.a(intent);
    }

    public static void m14055b(@Nullable RecentCallsDb recentCallsDb, ImmutableList immutableList) {
        ExecutorDetour.a(recentCallsDb.f13193f, new 7(recentCallsDb, immutableList), -1257259347);
    }

    public static int m14060h(RecentCallsDb recentCallsDb) {
        int i = 0;
        recentCallsDb.f13191d.b("Recent Calls DB accessed from UI Thread");
        SQLiteDatabase a = recentCallsDb.f13190c.a();
        if (a != null && a.isOpen()) {
            int i2 = !recentCallsDb.f13199l.a(1085, false) ? 1 : 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select count(");
            stringBuilder.append("seen");
            stringBuilder.append(") from ");
            stringBuilder.append("person_summary");
            stringBuilder.append(" where ");
            stringBuilder.append("seen");
            stringBuilder.append(" = 0 and ");
            stringBuilder.append("answered");
            stringBuilder.append(" = 0 and ");
            stringBuilder.append("direction");
            stringBuilder.append(" = ");
            stringBuilder.append("1");
            if (i2 != 0) {
                stringBuilder.append(" and ");
                stringBuilder.append("call_type");
                stringBuilder.append(" != ");
                stringBuilder.append(Integer.toString(3));
            }
            Cursor rawQuery = a.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        i = rawQuery.getInt(0);
                    }
                    rawQuery.close();
                } catch (Throwable th) {
                    rawQuery.close();
                }
            }
        }
        return i;
    }
}
