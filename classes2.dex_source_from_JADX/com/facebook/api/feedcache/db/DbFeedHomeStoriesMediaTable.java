package com.facebook.api.feedcache.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesMediaTable.Columns;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.FeedUnitMediaLoadedInfo;
import com.facebook.graphql.model.MediaLoadedInfo;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: session_timeout */
public class DbFeedHomeStoriesMediaTable {
    public static final String[] f5393a = new String[]{Columns.f5399c.toString(), Columns.f5398b.toString()};
    private static final Class<DbFeedHomeStoriesMediaTable> f5394c = DbFeedHomeStoriesMediaTable.class;
    private static volatile DbFeedHomeStoriesMediaTable f5395d;
    public final Lazy<FeedDatabaseSupplier> f5396b;

    public static com.facebook.api.feedcache.db.DbFeedHomeStoriesMediaTable m9284a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5395d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.DbFeedHomeStoriesMediaTable.class;
        monitor-enter(r1);
        r0 = f5395d;	 Catch:{ all -> 0x003a }
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
        r0 = m9285b(r0);	 Catch:{ all -> 0x0035 }
        f5395d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5395d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DbFeedHomeStoriesMediaTable.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.DbFeedHomeStoriesMediaTable");
    }

    private static DbFeedHomeStoriesMediaTable m9285b(InjectorLike injectorLike) {
        return new DbFeedHomeStoriesMediaTable(IdBasedSingletonScopeProvider.m1810b(injectorLike, 234));
    }

    @Inject
    public DbFeedHomeStoriesMediaTable(Lazy<FeedDatabaseSupplier> lazy) {
        this.f5396b = lazy;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9286d(java.lang.String r11) {
        /*
        r10 = this;
        r9 = 1;
        r8 = 0;
        r0 = r10.f5396b;
        r0 = r0.get();
        r0 = (com.facebook.api.feedcache.db.FeedDatabaseSupplier) r0;
        r1 = r0.mo2480a();
        r0 = -1712305154; // 0xffffffff99f04bfe float:-2.4846111E-23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1, r0);
        r0 = new android.database.sqlite.SQLiteQueryBuilder;	 Catch:{ all -> 0x0096 }
        r0.<init>();	 Catch:{ all -> 0x0096 }
        r2 = "home_stories_media";
        r0.setTables(r2);	 Catch:{ all -> 0x0096 }
        r2 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesMediaTable.Columns.f5397a;	 Catch:{ all -> 0x0096 }
        r2 = r2.m2091a();	 Catch:{ all -> 0x0096 }
        r4 = com.facebook.database.sqlite.SqlExpression.m10727a(r2, r11);	 Catch:{ all -> 0x0096 }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x0096 }
        r3 = 0;
        r5 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesMediaTable.Columns.f5398b;	 Catch:{ all -> 0x0096 }
        r5 = r5.toString();	 Catch:{ all -> 0x0096 }
        r2[r3] = r5;	 Catch:{ all -> 0x0096 }
        r3 = r4.mo1476a();	 Catch:{ all -> 0x0096 }
        r4 = r4.mo1477b();	 Catch:{ all -> 0x0096 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0096 }
        r3 = r2.getCount();	 Catch:{ all -> 0x0091 }
        r0 = r8;
    L_0x0048:
        r4 = r2.moveToNext();	 Catch:{ all -> 0x0091 }
        if (r4 == 0) goto L_0x0058;
    L_0x004e:
        r4 = 0;
        r4 = r2.getInt(r4);	 Catch:{ all -> 0x0091 }
        if (r4 != r9) goto L_0x0048;
    L_0x0055:
        r0 = r0 + 1;
        goto L_0x0048;
    L_0x0058:
        r2.close();	 Catch:{  }
        if (r0 != r3) goto L_0x009e;
    L_0x005d:
        r0 = 2;
    L_0x005e:
        r2 = new android.content.ContentValues;	 Catch:{  }
        r2.<init>();	 Catch:{  }
        r3 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5276l;	 Catch:{  }
        r3 = r3.m2091a();	 Catch:{  }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{  }
        r2.put(r3, r0);	 Catch:{  }
        r0 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5289y;	 Catch:{  }
        r0 = r0.m2091a();	 Catch:{  }
        r0 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r11);	 Catch:{  }
        r3 = "home_stories";
        r4 = r0.mo1476a();	 Catch:{  }
        r0 = r0.mo1477b();	 Catch:{  }
        r1.update(r3, r2, r4, r0);	 Catch:{  }
        r1.setTransactionSuccessful();	 Catch:{  }
        r0 = 118659267; // 0x71298c3 float:1.1028712E-34 double:5.86254674E-316;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);
        return;
    L_0x0091:
        r0 = move-exception;
        r2.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0096:
        r0 = move-exception;
        r2 = -2030882733; // 0xffffffff86f33053 float:-9.1477447E-35 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r2);
        throw r0;
    L_0x009e:
        if (r0 != 0) goto L_0x00a2;
    L_0x00a0:
        r0 = r8;
        goto L_0x005e;
    L_0x00a2:
        r0 = r9;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DbFeedHomeStoriesMediaTable.d(java.lang.String):void");
    }

    public final void m9290a(String str, String str2, int i) {
        SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5396b.get()).mo2480a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f5398b.f1025d, Integer.valueOf(i));
        Expression a2 = SqlExpression.m10723a(Columns.f5397a.m2090a(str), Columns.f5399c.m2090a(str2));
        if (a.update("home_stories_media", contentValues, a2.mo1476a(), a2.mo1477b()) != 0) {
            m9286d(str);
        }
    }

    public final void m9289a(String str, String str2) {
        SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5396b.get()).mo2480a();
        new SQLiteQueryBuilder().setTables("home_stories_media");
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f5397a.toString(), str);
        contentValues.put(Columns.f5399c.m2091a(), str2);
        contentValues.put(Columns.f5398b.m2091a(), Integer.valueOf(0));
        SQLiteDetour.a(a, 900911757);
        try {
            SQLiteDetour.a(-970481202);
            a.insertWithOnConflict("home_stories_media", "", contentValues, 4);
            SQLiteDetour.a(-1712914636);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -1154644680);
        }
    }

    public final Set<String> m9288a(String str) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories_media");
        Expression a = SqlExpression.m10727a(Columns.f5397a.m2091a(), str);
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5396b.get()).mo2480a(), new String[]{Columns.f5399c.toString()}, a.mo1476a(), a.mo1477b(), null, null, null);
        Set<String> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                CharSequence string = query.getString(0);
                if (!StringUtil.m3589a(string)) {
                    hashSet.add(string);
                }
            } finally {
                query.close();
            }
        }
        return hashSet;
    }

    public final FeedUnitMediaLoadedInfo m9291b(String str) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories_media");
        Expression a = SqlExpression.m10727a(Columns.f5397a.m2091a(), str);
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5396b.get()).mo2480a(), f5393a, a.mo1476a(), a.mo1477b(), null, null, null);
        int a2 = Columns.f5399c.m2089a(query);
        int a3 = Columns.f5398b.m2089a(query);
        List arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new MediaLoadedInfo(query.getString(a2), query.getInt(a3)));
            } finally {
                query.close();
            }
        }
        return new FeedUnitMediaLoadedInfo(arrayList);
    }

    public final void m9292c(String str) {
        int i;
        Expression a = SqlExpression.m10723a(Columns.f5397a.m2090a(str));
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = ((FeedDatabaseSupplier) this.f5396b.get()).mo2480a();
            SQLiteDetour.a(sQLiteDatabase, 1536457983);
            i = "home_stories_media";
            sQLiteDatabase.delete(i, a.mo1476a(), a.mo1477b());
            sQLiteDatabase.setTransactionSuccessful();
            try {
                SQLiteDetour.b(sQLiteDatabase, i);
            } catch (Throwable e) {
                BLog.b(f5394c, "Failed to close the connection to the DB!", e);
            }
        } catch (SQLiteException e2) {
            i = e2;
            BLog.b(f5394c, "Delete story failed!", i);
            try {
                SQLiteDetour.b(sQLiteDatabase, i);
            } catch (Throwable e3) {
                BLog.b(f5394c, "Failed to close the connection to the DB!", e3);
            }
        } finally {
            try {
                SQLiteDetour.b(sQLiteDatabase, -610075343);
            } catch (Throwable e4) {
                BLog.b(f5394c, "Failed to close the connection to the DB!", e4);
            }
        }
    }

    public final int m9287a(ImmutableList<String> immutableList) {
        int e;
        if (immutableList == null) {
            BLog.b(f5394c, "Inconsistent input for deleteStories!");
            return 0;
        } else if (immutableList.isEmpty()) {
            BLog.b(f5394c, "No keys to delete");
            return 0;
        } else {
            SQLiteDatabase sQLiteDatabase = null;
            int delete;
            try {
                sQLiteDatabase = ((FeedDatabaseSupplier) this.f5396b.get()).mo2480a();
                SQLiteDetour.a(sQLiteDatabase, -1302653960);
                Expression b = SqlExpression.m10730b();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    b.m10741a(Columns.f5397a.m2090a((String) immutableList.get(i)));
                }
                try {
                    delete = sQLiteDatabase.delete("home_stories_media", b.mo1476a(), b.mo1477b());
                } catch (Throwable e2) {
                    BLog.b(f5394c, "One Delete operation failed!", e2);
                    delete = 0;
                }
                try {
                    sQLiteDatabase.setTransactionSuccessful();
                    try {
                        SQLiteDetour.b(sQLiteDatabase, -1642245384);
                        return delete;
                    } catch (Throwable e3) {
                        BLog.b(f5394c, "Failed to close the connection to the DB!", e3);
                        return delete;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    try {
                        BLog.b(f5394c, "Delete Stories failed!", e);
                        try {
                            SQLiteDetour.b(sQLiteDatabase, e);
                            return delete;
                        } catch (Throwable e32) {
                            BLog.b(f5394c, "Failed to close the connection to the DB!", e32);
                            return delete;
                        }
                    } finally {
                        e = -879219627;
                        try {
                            SQLiteDetour.b(sQLiteDatabase, -879219627);
                        } catch (Throwable e322) {
                            BLog.b(f5394c, "Failed to close the connection to the DB!", e322);
                        }
                    }
                }
            } catch (Throwable e22) {
                Throwable th = e22;
                delete = 0;
                e = th;
                BLog.b(f5394c, "Delete Stories failed!", e);
                SQLiteDetour.b(sQLiteDatabase, e);
                return delete;
            }
        }
    }
}
