package com.facebook.composer.publish.cache.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.publish.cache.db.ComposerDbSchemaPart.PendingStoryTable;
import com.facebook.composer.publish.cache.db.ComposerDbSchemaPart.PrivacyOptionsTable.Columns;
import com.facebook.composer.publish.cache.db.ComposerDbSchemaPart.SessionsTable;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unreliable_core_count */
public class DbComposerHandler {
    private static final String[] f543a = new String[]{Columns.f551a.toString()};
    private static final String[] f544b = new String[]{SessionsTable.Columns.f552a.toString()};
    private static final String[] f545c = new String[]{PendingStoryTable.Columns.f553a.toString(), PendingStoryTable.Columns.f554b.toString(), PendingStoryTable.Columns.f555c.toString()};
    private static volatile DbComposerHandler f546h;
    public final ComposerDatabaseSupplier f547d;
    public final DefaultAndroidThreadUtil f548e;
    private final AbstractFbErrorReporter f549f;
    public final FbSharedPreferences f550g;

    public static com.facebook.composer.publish.cache.db.DbComposerHandler m843a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f546h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.publish.cache.db.DbComposerHandler.class;
        monitor-enter(r1);
        r0 = f546h;	 Catch:{ all -> 0x003a }
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
        r0 = m844b(r0);	 Catch:{ all -> 0x0035 }
        f546h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f546h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.cache.db.DbComposerHandler.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.cache.db.DbComposerHandler");
    }

    private static DbComposerHandler m844b(InjectorLike injectorLike) {
        return new DbComposerHandler(ComposerDatabaseSupplier.m850a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public DbComposerHandler(ComposerDatabaseSupplier composerDatabaseSupplier, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences) {
        this.f547d = composerDatabaseSupplier;
        this.f548e = defaultAndroidThreadUtil;
        this.f549f = abstractFbErrorReporter;
        this.f550g = fbSharedPreferences;
    }

    public final String m845a() {
        String str = null;
        this.f548e.b();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("privacy_options");
        Cursor query = sQLiteQueryBuilder.query(this.f547d.a(), f543a, null, null, null, null, null);
        try {
            if (query.moveToNext()) {
                str = query.getString(Columns.f551a.a(query));
            } else {
                query.close();
            }
            return str;
        } finally {
            query.close();
        }
    }

    public final void m846a(String str) {
        this.f548e.b();
        Preconditions.checkNotNull(str);
        this.f547d.a().delete("privacy_options", null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f551a.toString(), str);
        SQLiteDetour.a(-1927395371);
        this.f547d.a().replaceOrThrow("privacy_options", "", contentValues);
        SQLiteDetour.a(-2094869326);
    }

    public final String m847b() {
        String str = null;
        this.f548e.b();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("drafts");
        Cursor query = sQLiteQueryBuilder.query(this.f547d.a(), f544b, null, null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    str = query.getString(SessionsTable.Columns.f552a.a(query));
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return str;
    }

    public final void m848c() {
        this.f548e.b();
        this.f547d.a().delete("drafts", null, null);
    }

    public final ImmutableList<SerializedPendingStoryPersistentData> m849d() {
        this.f548e.b();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("pending_story");
        Cursor query = sQLiteQueryBuilder.query(this.f547d.a(), f545c, null, null, null, null, null);
        int a = PendingStoryTable.Columns.f553a.a(query);
        int a2 = PendingStoryTable.Columns.f555c.a(query);
        int a3 = PendingStoryTable.Columns.f554b.a(query);
        Builder builder = ImmutableList.builder();
        while (query.moveToNext()) {
            try {
                builder.c(new SerializedPendingStoryPersistentData(query.getString(a), query.getString(a2), query.getString(a3)));
            } catch (Throwable e) {
                this.f549f.a("composer_db_load_pending_stories_failed", e);
                return builder.b();
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return builder.b();
    }
}
