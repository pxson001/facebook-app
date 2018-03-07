package com.facebook.messaging.tincan.database;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: clock_skew/ */
public class DbFetchTincanIdentityKeys {
    static final String[] f17897a = new String[]{Columns.f17916a.d, Columns.f17917b.d};
    private static volatile DbFetchTincanIdentityKeys f17898c;
    private final Provider<TincanDatabaseSupplier> f17899b;

    public static com.facebook.messaging.tincan.database.DbFetchTincanIdentityKeys m17907a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17898c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.DbFetchTincanIdentityKeys.class;
        monitor-enter(r1);
        r0 = f17898c;	 Catch:{ all -> 0x003a }
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
        r0 = m17908b(r0);	 Catch:{ all -> 0x0035 }
        f17898c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17898c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanIdentityKeys.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.DbFetchTincanIdentityKeys");
    }

    private static DbFetchTincanIdentityKeys m17908b(InjectorLike injectorLike) {
        return new DbFetchTincanIdentityKeys(IdBasedProvider.a(injectorLike, 8567));
    }

    @Inject
    public DbFetchTincanIdentityKeys(Provider<TincanDatabaseSupplier> provider) {
        this.f17899b = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    @javax.annotation.Nullable
    public final byte[] m17909a(java.lang.String r12) {
        /*
        r11 = this;
        r9 = 0;
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.IdentityKeyTable.Columns.f17916a;
        r0 = r0.a();
        r4 = com.facebook.database.sqlite.SqlExpression.a(r0, r12);
        r0 = r11.f17899b;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.m17930k();	 Catch:{ Throwable -> 0x0075, all -> 0x0093 }
        r1 = "identity_keys";
        r2 = f17897a;	 Catch:{ Throwable -> 0x0067, all -> 0x0087 }
        r3 = r4.a();	 Catch:{ Throwable -> 0x0067, all -> 0x0087 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0067, all -> 0x0087 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0067, all -> 0x0087 }
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x0059, all -> 0x00a2 }
        if (r1 == 0) goto L_0x0048;
    L_0x0031:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.IdentityKeyTable.Columns.f17917b;	 Catch:{ Throwable -> 0x0059, all -> 0x00a2 }
        r1 = r1.e(r3);	 Catch:{ Throwable -> 0x0059, all -> 0x00a2 }
        if (r3 == 0) goto L_0x003c;
    L_0x0039:
        r3.close();	 Catch:{  }
    L_0x003c:
        if (r0 == 0) goto L_0x0041;
    L_0x003e:
        r0.close();	 Catch:{  }
    L_0x0041:
        if (r8 == 0) goto L_0x0046;
    L_0x0043:
        r8.close();
    L_0x0046:
        r0 = r1;
    L_0x0047:
        return r0;
    L_0x0048:
        if (r3 == 0) goto L_0x004d;
    L_0x004a:
        r3.close();	 Catch:{  }
    L_0x004d:
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r0.close();	 Catch:{  }
    L_0x0052:
        if (r8 == 0) goto L_0x0057;
    L_0x0054:
        r8.close();
    L_0x0057:
        r0 = r9;
        goto L_0x0047;
    L_0x0059:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005b }
    L_0x005b:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x005f:
        if (r3 == 0) goto L_0x0066;
    L_0x0061:
        if (r2 == 0) goto L_0x008a;
    L_0x0063:
        r3.close();	 Catch:{ Throwable -> 0x0082, all -> 0x0087 }
    L_0x0066:
        throw r1;	 Catch:{  }
    L_0x0067:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0069 }
    L_0x0069:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x006d:
        if (r0 == 0) goto L_0x0074;
    L_0x006f:
        if (r2 == 0) goto L_0x0095;
    L_0x0071:
        r0.close();	 Catch:{ Throwable -> 0x008e, all -> 0x0093 }
    L_0x0074:
        throw r1;	 Catch:{  }
    L_0x0075:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0077 }
    L_0x0077:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x007a:
        if (r8 == 0) goto L_0x0081;
    L_0x007c:
        if (r9 == 0) goto L_0x009e;
    L_0x007e:
        r8.close();	 Catch:{ Throwable -> 0x0099 }
    L_0x0081:
        throw r0;
    L_0x0082:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0066;
    L_0x0087:
        r1 = move-exception;
        r2 = r9;
        goto L_0x006d;
    L_0x008a:
        r3.close();	 Catch:{  }
        goto L_0x0066;
    L_0x008e:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x0074;
    L_0x0093:
        r0 = move-exception;
        goto L_0x007a;
    L_0x0095:
        r0.close();	 Catch:{  }
        goto L_0x0074;
    L_0x0099:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x0081;
    L_0x009e:
        r8.close();
        goto L_0x0081;
    L_0x00a2:
        r1 = move-exception;
        r2 = r9;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanIdentityKeys.a(java.lang.String):byte[]");
    }
}
