package com.facebook.messaging.tincan.database;

import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.database.TincanDbSchemaPart.ThreadsTable.Columns;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: close/ */
public class DbFetchTincanCryptoHandler {
    static final String[] f17891a = new String[]{Columns.a.d, Columns.f.d};
    private static final Class<?> f17892b = DbFetchTincanCryptoHandler.class;
    private static volatile DbFetchTincanCryptoHandler f17893f;
    private final Provider<TincanDatabaseSupplier> f17894c;
    private final DbCrypto f17895d;
    private final Provider<ThreadEncryptionKeyCache> f17896e;

    public static com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler m17899a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17893f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler.class;
        monitor-enter(r1);
        r0 = f17893f;	 Catch:{ all -> 0x003a }
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
        r0 = m17902b(r0);	 Catch:{ all -> 0x0035 }
        f17893f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17893f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler");
    }

    private static DbFetchTincanCryptoHandler m17902b(InjectorLike injectorLike) {
        return new DbFetchTincanCryptoHandler(IdBasedProvider.a(injectorLike, 8567), DbCrypto.a(injectorLike), IdBasedProvider.a(injectorLike, 8566));
    }

    @Inject
    public DbFetchTincanCryptoHandler(Provider<TincanDatabaseSupplier> provider, DbCrypto dbCrypto, Provider<ThreadEncryptionKeyCache> provider2) {
        this.f17894c = provider;
        this.f17895d = dbCrypto;
        this.f17896e = provider2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    @javax.annotation.Nullable
    public final synchronized java.lang.String m17904a(com.facebook.messaging.model.threadkey.ThreadKey r14) {
        /*
        r13 = this;
        r10 = 0;
        monitor-enter(r13);
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.ThreadsTable.Columns.a;	 Catch:{ all -> 0x00b5 }
        r1 = r1.a();	 Catch:{ all -> 0x00b5 }
        r2 = r14.toString();	 Catch:{ all -> 0x00b5 }
        r11 = com.facebook.database.sqlite.SqlExpression.a(r1, r2);	 Catch:{ all -> 0x00b5 }
        r1 = r13.f17894c;	 Catch:{ all -> 0x00b5 }
        r1 = r1.get();	 Catch:{ all -> 0x00b5 }
        r0 = r1;
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x00b5 }
        r9 = r0;
        r1 = r9.m17930k();	 Catch:{ Throwable -> 0x00a8, all -> 0x00f2 }
        r2 = "threads";
        r3 = f17891a;	 Catch:{ Throwable -> 0x009a, all -> 0x00bd }
        r4 = r11.a();	 Catch:{ Throwable -> 0x009a, all -> 0x00bd }
        r5 = r11.b();	 Catch:{ Throwable -> 0x009a, all -> 0x00bd }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r4 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x009a, all -> 0x00bd }
        r2 = r4.moveToNext();	 Catch:{ Throwable -> 0x008c, all -> 0x0104 }
        if (r2 == 0) goto L_0x0053;
    L_0x0037:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.ThreadsTable.Columns.f;	 Catch:{ Throwable -> 0x008c, all -> 0x0104 }
        r2 = r2.e(r4);	 Catch:{ Throwable -> 0x008c, all -> 0x0104 }
        r2 = r13.m17900a(r14, r2);	 Catch:{ Throwable -> 0x008c, all -> 0x0104 }
        if (r4 == 0) goto L_0x0046;
    L_0x0043:
        r4.close();	 Catch:{  }
    L_0x0046:
        if (r1 == 0) goto L_0x004b;
    L_0x0048:
        r1.close();	 Catch:{  }
    L_0x004b:
        if (r9 == 0) goto L_0x0050;
    L_0x004d:
        r9.close();	 Catch:{  }
    L_0x0050:
        r1 = r2;
    L_0x0051:
        monitor-exit(r13);
        return r1;
    L_0x0053:
        if (r4 == 0) goto L_0x0058;
    L_0x0055:
        r4.close();	 Catch:{  }
    L_0x0058:
        r2 = "pending_sessions";
        r3 = f17891a;	 Catch:{  }
        r4 = r11.a();	 Catch:{  }
        r5 = r11.b();	 Catch:{  }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r4 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{  }
        r2 = r4.moveToNext();	 Catch:{ Throwable -> 0x00d6, all -> 0x0101 }
        if (r2 == 0) goto L_0x00c4;
    L_0x0071:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17925b;	 Catch:{ Throwable -> 0x00d6, all -> 0x0101 }
        r2 = r2.e(r4);	 Catch:{ Throwable -> 0x00d6, all -> 0x0101 }
        r2 = r13.m17900a(r14, r2);	 Catch:{ Throwable -> 0x00d6, all -> 0x0101 }
        if (r4 == 0) goto L_0x0080;
    L_0x007d:
        r4.close();	 Catch:{  }
    L_0x0080:
        if (r1 == 0) goto L_0x0085;
    L_0x0082:
        r1.close();	 Catch:{  }
    L_0x0085:
        if (r9 == 0) goto L_0x008a;
    L_0x0087:
        r9.close();	 Catch:{  }
    L_0x008a:
        r1 = r2;
        goto L_0x0051;
    L_0x008c:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x008e }
    L_0x008e:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
    L_0x0092:
        if (r4 == 0) goto L_0x0099;
    L_0x0094:
        if (r3 == 0) goto L_0x00c0;
    L_0x0096:
        r4.close();	 Catch:{ Throwable -> 0x00b8, all -> 0x00bd }
    L_0x0099:
        throw r2;	 Catch:{  }
    L_0x009a:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x009c }
    L_0x009c:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
    L_0x00a0:
        if (r1 == 0) goto L_0x00a7;
    L_0x00a2:
        if (r3 == 0) goto L_0x00f4;
    L_0x00a4:
        r1.close();	 Catch:{ Throwable -> 0x00ed, all -> 0x00f2 }
    L_0x00a7:
        throw r2;	 Catch:{  }
    L_0x00a8:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00aa }
    L_0x00aa:
        r2 = move-exception;
        r10 = r1;
        r1 = r2;
    L_0x00ad:
        if (r9 == 0) goto L_0x00b4;
    L_0x00af:
        if (r10 == 0) goto L_0x00fd;
    L_0x00b1:
        r9.close();	 Catch:{ Throwable -> 0x00f8 }
    L_0x00b4:
        throw r1;	 Catch:{  }
    L_0x00b5:
        r1 = move-exception;
        monitor-exit(r13);
        throw r1;
    L_0x00b8:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x0099;
    L_0x00bd:
        r2 = move-exception;
        r3 = r10;
        goto L_0x00a0;
    L_0x00c0:
        r4.close();	 Catch:{  }
        goto L_0x0099;
    L_0x00c4:
        if (r4 == 0) goto L_0x00c9;
    L_0x00c6:
        r4.close();	 Catch:{  }
    L_0x00c9:
        if (r1 == 0) goto L_0x00ce;
    L_0x00cb:
        r1.close();	 Catch:{  }
    L_0x00ce:
        if (r9 == 0) goto L_0x00d3;
    L_0x00d0:
        r9.close();	 Catch:{  }
    L_0x00d3:
        r1 = r10;
        goto L_0x0051;
    L_0x00d6:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x00d8 }
    L_0x00d8:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
    L_0x00dc:
        if (r4 == 0) goto L_0x00e3;
    L_0x00de:
        if (r3 == 0) goto L_0x00e9;
    L_0x00e0:
        r4.close();	 Catch:{ Throwable -> 0x00e4, all -> 0x00bd }
    L_0x00e3:
        throw r2;	 Catch:{  }
    L_0x00e4:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x00e3;
    L_0x00e9:
        r4.close();	 Catch:{  }
        goto L_0x00e3;
    L_0x00ed:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r1);	 Catch:{  }
        goto L_0x00a7;
    L_0x00f2:
        r1 = move-exception;
        goto L_0x00ad;
    L_0x00f4:
        r1.close();	 Catch:{  }
        goto L_0x00a7;
    L_0x00f8:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r10, r2);	 Catch:{  }
        goto L_0x00b4;
    L_0x00fd:
        r9.close();	 Catch:{  }
        goto L_0x00b4;
    L_0x0101:
        r2 = move-exception;
        r3 = r10;
        goto L_0x00dc;
    L_0x0104:
        r2 = move-exception;
        r3 = r10;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler.a(com.facebook.messaging.model.threadkey.ThreadKey):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final synchronized com.google.common.collect.ImmutableMap<com.facebook.messaging.model.threadkey.ThreadKey, android.os.Bundle> m17903a() {
        /*
        r13 = this;
        r10 = 0;
        monitor-enter(r13);
        r11 = new java.util.HashMap;	 Catch:{ all -> 0x009a }
        r11.<init>();	 Catch:{ all -> 0x009a }
        r1 = r13.f17894c;	 Catch:{ all -> 0x009a }
        r1 = r1.get();	 Catch:{ all -> 0x009a }
        r0 = r1;
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x009a }
        r9 = r0;
        r1 = r9.m17930k();	 Catch:{ Throwable -> 0x008d, all -> 0x00c3 }
        r2 = "pending_sessions";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r4 = 0;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17924a;	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r5 = r5.a();	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r4 = 1;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17925b;	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r5 = r5.a();	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r4 = 2;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17926c;	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r5 = r5.a();	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r4 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x007f, all -> 0x00b7 }
    L_0x003e:
        r2 = r4.moveToNext();	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        if (r2 == 0) goto L_0x009d;
    L_0x0044:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17924a;	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r2 = r2.b(r4);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r2 = com.facebook.messaging.model.threadkey.ThreadKey.a(r2);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r3 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17925b;	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r3 = r3.e(r4);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r3 = r13.m17900a(r2, r3);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.f17926c;	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r5 = r5.b(r4);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r6 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r6.<init>();	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r7 = "session_state";
        r6.putString(r7, r3);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r3 = "packet_key";
        r6.putString(r3, r5);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        r11.put(r2, r6);	 Catch:{ Throwable -> 0x0071, all -> 0x00d2 }
        goto L_0x003e;
    L_0x0071:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0073 }
    L_0x0073:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
    L_0x0077:
        if (r4 == 0) goto L_0x007e;
    L_0x0079:
        if (r3 == 0) goto L_0x00ba;
    L_0x007b:
        r4.close();	 Catch:{ Throwable -> 0x00b2, all -> 0x00b7 }
    L_0x007e:
        throw r2;	 Catch:{  }
    L_0x007f:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r3 = move-exception;
        r12 = r3;
        r3 = r2;
        r2 = r12;
    L_0x0085:
        if (r1 == 0) goto L_0x008c;
    L_0x0087:
        if (r3 == 0) goto L_0x00c5;
    L_0x0089:
        r1.close();	 Catch:{ Throwable -> 0x00be, all -> 0x00c3 }
    L_0x008c:
        throw r2;	 Catch:{  }
    L_0x008d:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x008f }
    L_0x008f:
        r2 = move-exception;
        r10 = r1;
        r1 = r2;
    L_0x0092:
        if (r9 == 0) goto L_0x0099;
    L_0x0094:
        if (r10 == 0) goto L_0x00ce;
    L_0x0096:
        r9.close();	 Catch:{ Throwable -> 0x00c9 }
    L_0x0099:
        throw r1;	 Catch:{  }
    L_0x009a:
        r1 = move-exception;
        monitor-exit(r13);
        throw r1;
    L_0x009d:
        if (r4 == 0) goto L_0x00a2;
    L_0x009f:
        r4.close();	 Catch:{  }
    L_0x00a2:
        if (r1 == 0) goto L_0x00a7;
    L_0x00a4:
        r1.close();	 Catch:{  }
    L_0x00a7:
        if (r9 == 0) goto L_0x00ac;
    L_0x00a9:
        r9.close();	 Catch:{  }
    L_0x00ac:
        r1 = com.google.common.collect.ImmutableMap.copyOf(r11);	 Catch:{  }
        monitor-exit(r13);
        return r1;
    L_0x00b2:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x007e;
    L_0x00b7:
        r2 = move-exception;
        r3 = r10;
        goto L_0x0085;
    L_0x00ba:
        r4.close();	 Catch:{  }
        goto L_0x007e;
    L_0x00be:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r1);	 Catch:{  }
        goto L_0x008c;
    L_0x00c3:
        r1 = move-exception;
        goto L_0x0092;
    L_0x00c5:
        r1.close();	 Catch:{  }
        goto L_0x008c;
    L_0x00c9:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r10, r2);	 Catch:{  }
        goto L_0x0099;
    L_0x00ce:
        r9.close();	 Catch:{  }
        goto L_0x0099;
    L_0x00d2:
        r2 = move-exception;
        r3 = r10;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler.a():com.google.common.collect.ImmutableMap<com.facebook.messaging.model.threadkey.ThreadKey, android.os.Bundle>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final synchronized int m17906b() {
        /*
        r7 = this;
        r3 = 0;
        monitor-enter(r7);
        r0 = r7.f17894c;	 Catch:{ all -> 0x0073 }
        r0 = r0.get();	 Catch:{ all -> 0x0073 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0073 }
        r4 = r0.m17930k();	 Catch:{ Throwable -> 0x0066, all -> 0x0087 }
        r1 = "SELECT COUNT(*) FROM pending_sessions";
        r2 = 0;
        r5 = r4.rawQuery(r1, r2);	 Catch:{ Throwable -> 0x0058, all -> 0x007b }
        r1 = r5.moveToNext();	 Catch:{ Throwable -> 0x004a, all -> 0x0096 }
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r1 = 0;
        r1 = r5.getInt(r1);	 Catch:{ Throwable -> 0x004a, all -> 0x0096 }
        if (r5 == 0) goto L_0x0025;
    L_0x0022:
        r5.close();	 Catch:{  }
    L_0x0025:
        if (r4 == 0) goto L_0x002a;
    L_0x0027:
        r4.close();	 Catch:{  }
    L_0x002a:
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0.close();	 Catch:{  }
    L_0x002f:
        r0 = r1;
    L_0x0030:
        monitor-exit(r7);
        return r0;
    L_0x0032:
        if (r5 == 0) goto L_0x0037;
    L_0x0034:
        r5.close();	 Catch:{  }
    L_0x0037:
        if (r4 == 0) goto L_0x003c;
    L_0x0039:
        r4.close();	 Catch:{  }
    L_0x003c:
        if (r0 == 0) goto L_0x0041;
    L_0x003e:
        r0.close();	 Catch:{  }
    L_0x0041:
        r0 = f17892b;	 Catch:{  }
        r1 = "Could not retrieve pending session count";
        com.facebook.debug.log.BLog.b(r0, r1);	 Catch:{  }
        r0 = -1;
        goto L_0x0030;
    L_0x004a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x004c }
    L_0x004c:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0050:
        if (r5 == 0) goto L_0x0057;
    L_0x0052:
        if (r2 == 0) goto L_0x007e;
    L_0x0054:
        r5.close();	 Catch:{ Throwable -> 0x0076, all -> 0x007b }
    L_0x0057:
        throw r1;	 Catch:{  }
    L_0x0058:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005a }
    L_0x005a:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x005e:
        if (r4 == 0) goto L_0x0065;
    L_0x0060:
        if (r2 == 0) goto L_0x0089;
    L_0x0062:
        r4.close();	 Catch:{ Throwable -> 0x0082, all -> 0x0087 }
    L_0x0065:
        throw r1;	 Catch:{  }
    L_0x0066:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0068 }
    L_0x0068:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x006b:
        if (r0 == 0) goto L_0x0072;
    L_0x006d:
        if (r3 == 0) goto L_0x0092;
    L_0x006f:
        r0.close();	 Catch:{ Throwable -> 0x008d }
    L_0x0072:
        throw r1;	 Catch:{  }
    L_0x0073:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0076:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x0057;
    L_0x007b:
        r1 = move-exception;
        r2 = r3;
        goto L_0x005e;
    L_0x007e:
        r5.close();	 Catch:{  }
        goto L_0x0057;
    L_0x0082:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0065;
    L_0x0087:
        r1 = move-exception;
        goto L_0x006b;
    L_0x0089:
        r4.close();	 Catch:{  }
        goto L_0x0065;
    L_0x008d:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0072;
    L_0x0092:
        r0.close();	 Catch:{  }
        goto L_0x0072;
    L_0x0096:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler.b():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    @javax.annotation.Nullable
    public final synchronized byte[] m17905a(java.lang.String r13, int r14) {
        /*
        r12 = this;
        r10 = 0;
        monitor-enter(r12);
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PreKeyTable.Columns.f17930a;	 Catch:{ all -> 0x00a9 }
        r1 = r1.a();	 Catch:{ all -> 0x00a9 }
        r2 = java.lang.Integer.toString(r14);	 Catch:{ all -> 0x00a9 }
        r2 = com.facebook.database.sqlite.SqlExpression.a(r1, r2);	 Catch:{ all -> 0x00a9 }
        r1 = r12.f17894c;	 Catch:{ all -> 0x00a9 }
        r1 = r1.get();	 Catch:{ all -> 0x00a9 }
        r0 = r1;
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x00a9 }
        r9 = r0;
        r1 = r9.m17930k();	 Catch:{ Throwable -> 0x009c, all -> 0x00bd }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r4 = 0;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PreKeyTable.Columns.f17931b;	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r5 = r5.a();	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r4 = r2.a();	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r5 = r2.b();	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r2 = r13;
        r4 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x008e, all -> 0x00b1 }
        r2 = r4.moveToNext();	 Catch:{ Throwable -> 0x0080, all -> 0x00cc }
        if (r2 == 0) goto L_0x005b;
    L_0x0040:
        r2 = 0;
        r2 = r4.getBlob(r2);	 Catch:{ Throwable -> 0x0080, all -> 0x00cc }
        r2 = r12.m17901a(r2);	 Catch:{ Throwable -> 0x0080, all -> 0x00cc }
        if (r4 == 0) goto L_0x004e;
    L_0x004b:
        r4.close();	 Catch:{  }
    L_0x004e:
        if (r1 == 0) goto L_0x0053;
    L_0x0050:
        r1.close();	 Catch:{  }
    L_0x0053:
        if (r9 == 0) goto L_0x0058;
    L_0x0055:
        r9.close();	 Catch:{  }
    L_0x0058:
        r1 = r2;
    L_0x0059:
        monitor-exit(r12);
        return r1;
    L_0x005b:
        if (r4 == 0) goto L_0x0060;
    L_0x005d:
        r4.close();	 Catch:{  }
    L_0x0060:
        if (r1 == 0) goto L_0x0065;
    L_0x0062:
        r1.close();	 Catch:{  }
    L_0x0065:
        if (r9 == 0) goto L_0x006a;
    L_0x0067:
        r9.close();	 Catch:{  }
    L_0x006a:
        r1 = f17892b;	 Catch:{  }
        r2 = "Could not retrieve pre key %d from %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{  }
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r14);	 Catch:{  }
        r3[r4] = r5;	 Catch:{  }
        r4 = 1;
        r3[r4] = r13;	 Catch:{  }
        com.facebook.debug.log.BLog.b(r1, r2, r3);	 Catch:{  }
        r1 = r10;
        goto L_0x0059;
    L_0x0080:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0082 }
    L_0x0082:
        r3 = move-exception;
        r11 = r3;
        r3 = r2;
        r2 = r11;
    L_0x0086:
        if (r4 == 0) goto L_0x008d;
    L_0x0088:
        if (r3 == 0) goto L_0x00b4;
    L_0x008a:
        r4.close();	 Catch:{ Throwable -> 0x00ac, all -> 0x00b1 }
    L_0x008d:
        throw r2;	 Catch:{  }
    L_0x008e:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0090 }
    L_0x0090:
        r3 = move-exception;
        r11 = r3;
        r3 = r2;
        r2 = r11;
    L_0x0094:
        if (r1 == 0) goto L_0x009b;
    L_0x0096:
        if (r3 == 0) goto L_0x00bf;
    L_0x0098:
        r1.close();	 Catch:{ Throwable -> 0x00b8, all -> 0x00bd }
    L_0x009b:
        throw r2;	 Catch:{  }
    L_0x009c:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x009e }
    L_0x009e:
        r2 = move-exception;
        r10 = r1;
        r1 = r2;
    L_0x00a1:
        if (r9 == 0) goto L_0x00a8;
    L_0x00a3:
        if (r10 == 0) goto L_0x00c8;
    L_0x00a5:
        r9.close();	 Catch:{ Throwable -> 0x00c3 }
    L_0x00a8:
        throw r1;	 Catch:{  }
    L_0x00a9:
        r1 = move-exception;
        monitor-exit(r12);
        throw r1;
    L_0x00ac:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x008d;
    L_0x00b1:
        r2 = move-exception;
        r3 = r10;
        goto L_0x0094;
    L_0x00b4:
        r4.close();	 Catch:{  }
        goto L_0x008d;
    L_0x00b8:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r1);	 Catch:{  }
        goto L_0x009b;
    L_0x00bd:
        r1 = move-exception;
        goto L_0x00a1;
    L_0x00bf:
        r1.close();	 Catch:{  }
        goto L_0x009b;
    L_0x00c3:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r10, r2);	 Catch:{  }
        goto L_0x00a8;
    L_0x00c8:
        r9.close();	 Catch:{  }
        goto L_0x00a8;
    L_0x00cc:
        r2 = move-exception;
        r3 = r10;
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler.a(java.lang.String, int):byte[]");
    }

    @Nullable
    private String m17900a(ThreadKey threadKey, byte[] bArr) {
        Throwable e;
        if (bArr == null) {
            return null;
        }
        try {
            return new String(this.f17895d.b(((ThreadEncryptionKeyCache) this.f17896e.get()).m17924a(threadKey), bArr), "UTF-8");
        } catch (KeyChainException e2) {
            e = e2;
            BLog.b(f17892b, "Failed to decrypt message content", e);
            throw new RuntimeException(e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            BLog.b(f17892b, "Failed to decrypt message content", e);
            throw new RuntimeException(e);
        } catch (IOException e4) {
            e = e4;
            BLog.b(f17892b, "Failed to decrypt message content", e);
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private byte[] m17901a(byte[] bArr) {
        Throwable e;
        if (bArr == null) {
            return null;
        }
        try {
            return this.f17895d.b(bArr);
        } catch (KeyChainException e2) {
            e = e2;
            BLog.b(f17892b, "Failed to decrypt pre-key", e);
            throw new RuntimeException(e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            BLog.b(f17892b, "Failed to decrypt pre-key", e);
            throw new RuntimeException(e);
        } catch (IOException e4) {
            e = e4;
            BLog.b(f17892b, "Failed to decrypt pre-key", e);
            throw new RuntimeException(e);
        }
    }
}
