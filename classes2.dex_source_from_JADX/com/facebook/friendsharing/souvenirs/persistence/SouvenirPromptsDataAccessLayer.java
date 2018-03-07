package com.facebook.friendsharing.souvenirs.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart.PromptsTable.Columns;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: more_story_pill_timeout_to_show_secs */
public class SouvenirPromptsDataAccessLayer {
    private static volatile SouvenirPromptsDataAccessLayer f13326c;
    public final SouvenirsDatabaseSupplier f13327a;
    public final DefaultAndroidThreadUtil f13328b;

    public static com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer m19630a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13326c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer.class;
        monitor-enter(r1);
        r0 = f13326c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m19631b(r0);	 Catch:{ all -> 0x0035 }
        f13326c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13326c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer");
    }

    private static SouvenirPromptsDataAccessLayer m19631b(InjectorLike injectorLike) {
        return new SouvenirPromptsDataAccessLayer(SouvenirsDatabaseSupplier.m19635a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public SouvenirPromptsDataAccessLayer(SouvenirsDatabaseSupplier souvenirsDatabaseSupplier, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f13327a = souvenirsDatabaseSupplier;
        this.f13328b = defaultAndroidThreadUtil;
    }

    public final ImmutableMap<String, Long> m19633a() {
        this.f13328b.m1655b();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("prompted_models");
        Cursor query = sQLiteQueryBuilder.query(this.f13327a.mo2480a(), null, null, null, null, null, null);
        if (query == null) {
            return ImmutableBiMap.m976a();
        }
        try {
            if (query.moveToFirst()) {
                int a = Columns.f13336a.m2089a(query);
                int a2 = Columns.f13337b.m2089a(query);
                Builder builder = new Builder();
                while (true) {
                    builder.m609b(query.getString(a), Long.valueOf(query.getLong(a2)));
                    if (!query.moveToNext()) {
                        break;
                    }
                }
                ImmutableMap<String, Long> b = builder.m610b();
                return b;
            }
            query.close();
            return ImmutableBiMap.m976a();
        } finally {
            query.close();
        }
    }

    public final int m19632a(long j) {
        this.f13328b.m1655b();
        Preconditions.checkArgument(j >= 0, "Please give us a valid UNIX timestamp");
        Expression b = Columns.f13337b.m2092b(String.valueOf(j));
        return this.f13327a.mo2480a().delete("prompted_models", b.mo1476a(), b.mo1477b());
    }

    public final int m19634b() {
        this.f13328b.m1655b();
        return this.f13327a.mo2480a().delete("prompted_models", "1", null);
    }
}
