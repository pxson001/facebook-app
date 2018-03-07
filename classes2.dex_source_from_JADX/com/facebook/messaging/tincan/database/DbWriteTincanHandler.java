package com.facebook.messaging.tincan.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.database.serialization.DbDraftSerialization;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.database.clock.TincanDbClock;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: manual */
public class DbWriteTincanHandler {
    private static final Class<?> f15262a = DbWriteTincanHandler.class;
    private static volatile DbWriteTincanHandler f15263g;
    private final Provider<TincanDatabaseSupplier> f15264b;
    private final Lazy<DbDraftSerialization> f15265c;
    private final TincanDbClock f15266d;
    private final DbCrypto f15267e;
    private final Provider<ThreadEncryptionKeyCache> f15268f;

    public static com.facebook.messaging.tincan.database.DbWriteTincanHandler m21775a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15263g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.DbWriteTincanHandler.class;
        monitor-enter(r1);
        r0 = f15263g;	 Catch:{ all -> 0x003a }
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
        r0 = m21786b(r0);	 Catch:{ all -> 0x0035 }
        f15263g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15263g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.DbWriteTincanHandler");
    }

    private static DbWriteTincanHandler m21786b(InjectorLike injectorLike) {
        return new DbWriteTincanHandler(IdBasedProvider.m1811a(injectorLike, 8567), IdBasedLazy.m1808a(injectorLike, 2601), TincanDbClock.m21809a(injectorLike), DbCrypto.m21813a(injectorLike), IdBasedProvider.m1811a(injectorLike, 8566));
    }

    @Inject
    public DbWriteTincanHandler(Provider<TincanDatabaseSupplier> provider, Lazy<DbDraftSerialization> lazy, TincanDbClock tincanDbClock, DbCrypto dbCrypto, Provider<ThreadEncryptionKeyCache> provider2) {
        this.f15264b = provider;
        this.f15265c = lazy;
        this.f15266d = tincanDbClock;
        this.f15267e = dbCrypto;
        this.f15268f = provider2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21803a(java.lang.String r9, byte[] r10) {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0078 }
        r1.<init>();	 Catch:{ all -> 0x0078 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.IdentityKeyTable.Columns.b;	 Catch:{ all -> 0x0078 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0078 }
        r1.put(r0, r10);	 Catch:{ all -> 0x0078 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.IdentityKeyTable.Columns.a;	 Catch:{ all -> 0x0078 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0078 }
        r2 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r9);	 Catch:{ all -> 0x0078 }
        r0 = r8.f15264b;	 Catch:{ all -> 0x0078 }
        r0 = r0.get();	 Catch:{ all -> 0x0078 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0078 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x006b, all -> 0x0080 }
        r5 = "identity_keys";
        r6 = r2.mo1476a();	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r2 = r2.mo1477b();	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r2 = r4.update(r5, r1, r6, r2);	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        if (r2 != 0) goto L_0x0051;
    L_0x0036:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.IdentityKeyTable.Columns.a;	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r2 = r2.m2091a();	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r1.put(r2, r9);	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r2 = "identity_keys";
        r5 = 0;
        r6 = -509105078; // 0xffffffffe1a7ac4a float:-3.8662762E20 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r6);	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r4.insertOrThrow(r2, r5, r1);	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
        r1 = 375846363; // 0x1666f5db float:1.865683E-25 double:1.85692776E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1);	 Catch:{ Throwable -> 0x005d, all -> 0x008f }
    L_0x0051:
        if (r4 == 0) goto L_0x0056;
    L_0x0053:
        r4.close();	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x005b;
    L_0x0058:
        r0.close();	 Catch:{  }
    L_0x005b:
        monitor-exit(r8);
        return;
    L_0x005d:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005f }
    L_0x005f:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x0063:
        if (r4 == 0) goto L_0x006a;
    L_0x0065:
        if (r2 == 0) goto L_0x0082;
    L_0x0067:
        r4.close();	 Catch:{ Throwable -> 0x007b, all -> 0x0080 }
    L_0x006a:
        throw r1;	 Catch:{  }
    L_0x006b:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0070:
        if (r0 == 0) goto L_0x0077;
    L_0x0072:
        if (r3 == 0) goto L_0x008b;
    L_0x0074:
        r0.close();	 Catch:{ Throwable -> 0x0086 }
    L_0x0077:
        throw r1;	 Catch:{  }
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x007b:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x006a;
    L_0x0080:
        r1 = move-exception;
        goto L_0x0070;
    L_0x0082:
        r4.close();	 Catch:{  }
        goto L_0x006a;
    L_0x0086:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0077;
    L_0x008b:
        r0.close();	 Catch:{  }
        goto L_0x0077;
    L_0x008f:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(java.lang.String, byte[]):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final synchronized void m21795a(com.facebook.messaging.model.threadkey.ThreadKey r9, java.lang.String r10) {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0070 }
        r1.<init>();	 Catch:{ all -> 0x0070 }
        r8.m21782a(r9, r10, r1);	 Catch:{ all -> 0x0070 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x0070 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0070 }
        r2 = r9.toString();	 Catch:{ all -> 0x0070 }
        r2 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = r8.f15264b;	 Catch:{ all -> 0x0070 }
        r0 = r0.get();	 Catch:{ all -> 0x0070 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0070 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0063, all -> 0x0078 }
        r5 = "threads";
        r6 = r2.mo1476a();	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
        r2 = r2.mo1477b();	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
        r2 = r4.update(r5, r1, r6, r2);	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
        if (r2 != 0) goto L_0x0049;
    L_0x0034:
        r8.m21787b(r9, r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
        r2 = "threads";
        r5 = 0;
        r6 = 1653400742; // 0x628ce4a6 float:1.29951E21 double:8.168885054E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r6);	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
        r4.insertOrThrow(r2, r5, r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
        r1 = -1813887585; // 0xffffffff93e2459f float:-5.7119072E-27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0087 }
    L_0x0049:
        if (r4 == 0) goto L_0x004e;
    L_0x004b:
        r4.close();	 Catch:{  }
    L_0x004e:
        if (r0 == 0) goto L_0x0053;
    L_0x0050:
        r0.close();	 Catch:{  }
    L_0x0053:
        monitor-exit(r8);
        return;
    L_0x0055:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0057 }
    L_0x0057:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x005b:
        if (r4 == 0) goto L_0x0062;
    L_0x005d:
        if (r2 == 0) goto L_0x007a;
    L_0x005f:
        r4.close();	 Catch:{ Throwable -> 0x0073, all -> 0x0078 }
    L_0x0062:
        throw r1;	 Catch:{  }
    L_0x0063:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0065 }
    L_0x0065:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0068:
        if (r0 == 0) goto L_0x006f;
    L_0x006a:
        if (r3 == 0) goto L_0x0083;
    L_0x006c:
        r0.close();	 Catch:{ Throwable -> 0x007e }
    L_0x006f:
        throw r1;	 Catch:{  }
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0073:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0062;
    L_0x0078:
        r1 = move-exception;
        goto L_0x0068;
    L_0x007a:
        r4.close();	 Catch:{  }
        goto L_0x0062;
    L_0x007e:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x006f;
    L_0x0083:
        r0.close();	 Catch:{  }
        goto L_0x006f;
    L_0x0087:
        r1 = move-exception;
        r2 = r3;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final synchronized void m21796a(com.facebook.messaging.model.threadkey.ThreadKey r9, java.lang.String r10, java.lang.String r11) {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0086 }
        r1.<init>();	 Catch:{ all -> 0x0086 }
        r8.m21782a(r9, r10, r1);	 Catch:{ all -> 0x0086 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.c;	 Catch:{ all -> 0x0086 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0086 }
        r1.put(r0, r11);	 Catch:{ all -> 0x0086 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x0086 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0086 }
        r2 = r9.toString();	 Catch:{ all -> 0x0086 }
        r2 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r2);	 Catch:{ all -> 0x0086 }
        r0 = r8.f15264b;	 Catch:{ all -> 0x0086 }
        r0 = r0.get();	 Catch:{ all -> 0x0086 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0086 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0079, all -> 0x008e }
        r5 = "pending_sessions";
        r6 = r2.mo1476a();	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r2 = r2.mo1477b();	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r2 = r4.update(r5, r1, r6, r2);	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        if (r2 != 0) goto L_0x005f;
    L_0x003d:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r2 = r2.m2091a();	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r5 = r9.toString();	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r1.put(r2, r5);	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r8.m21788c(r9, r1);	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r2 = "pending_sessions";
        r5 = 0;
        r6 = -817658080; // 0xffffffffcf438720 float:-3.28041267E9 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r6);	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r4.insertOrThrow(r2, r5, r1);	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
        r1 = 1053837598; // 0x3ed0491e float:0.40680784 double:5.206649535E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1);	 Catch:{ Throwable -> 0x006b, all -> 0x009d }
    L_0x005f:
        if (r4 == 0) goto L_0x0064;
    L_0x0061:
        r4.close();	 Catch:{  }
    L_0x0064:
        if (r0 == 0) goto L_0x0069;
    L_0x0066:
        r0.close();	 Catch:{  }
    L_0x0069:
        monitor-exit(r8);
        return;
    L_0x006b:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x0071:
        if (r4 == 0) goto L_0x0078;
    L_0x0073:
        if (r2 == 0) goto L_0x0090;
    L_0x0075:
        r4.close();	 Catch:{ Throwable -> 0x0089, all -> 0x008e }
    L_0x0078:
        throw r1;	 Catch:{  }
    L_0x0079:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x007b }
    L_0x007b:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x007e:
        if (r0 == 0) goto L_0x0085;
    L_0x0080:
        if (r3 == 0) goto L_0x0099;
    L_0x0082:
        r0.close();	 Catch:{ Throwable -> 0x0094 }
    L_0x0085:
        throw r1;	 Catch:{  }
    L_0x0086:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0089:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0078;
    L_0x008e:
        r1 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r4.close();	 Catch:{  }
        goto L_0x0078;
    L_0x0094:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0085;
    L_0x0099:
        r0.close();	 Catch:{  }
        goto L_0x0085;
    L_0x009d:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21794a(com.facebook.messaging.model.threadkey.ThreadKey r11, com.facebook.messaging.model.threadkey.ThreadKey r12, java.lang.String r13) {
        /*
        r10 = this;
        r3 = 0;
        monitor-enter(r10);
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0084 }
        r1.<init>();	 Catch:{ all -> 0x0084 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x0084 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0084 }
        r2 = r12.toString();	 Catch:{ all -> 0x0084 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0084 }
        r10.m21782a(r11, r13, r1);	 Catch:{ all -> 0x0084 }
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x0084 }
        r2.<init>();	 Catch:{ all -> 0x0084 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x0084 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0084 }
        r4 = r12.toString();	 Catch:{ all -> 0x0084 }
        r2.put(r0, r4);	 Catch:{ all -> 0x0084 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x0084 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0084 }
        r4 = r11.toString();	 Catch:{ all -> 0x0084 }
        r4 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r4);	 Catch:{ all -> 0x0084 }
        r0 = r10.f15264b;	 Catch:{ all -> 0x0084 }
        r0 = r0.get();	 Catch:{ all -> 0x0084 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0084 }
        r5 = r0.k();	 Catch:{ Throwable -> 0x0077, all -> 0x008c }
        r6 = "threads";
        r7 = r4.mo1476a();	 Catch:{ Throwable -> 0x0069, all -> 0x009b }
        r8 = r4.mo1477b();	 Catch:{ Throwable -> 0x0069, all -> 0x009b }
        r5.update(r6, r1, r7, r8);	 Catch:{ Throwable -> 0x0069, all -> 0x009b }
        r1 = "messages";
        r6 = r4.mo1476a();	 Catch:{ Throwable -> 0x0069, all -> 0x009b }
        r4 = r4.mo1477b();	 Catch:{ Throwable -> 0x0069, all -> 0x009b }
        r5.update(r1, r2, r6, r4);	 Catch:{ Throwable -> 0x0069, all -> 0x009b }
        if (r5 == 0) goto L_0x0062;
    L_0x005f:
        r5.close();	 Catch:{  }
    L_0x0062:
        if (r0 == 0) goto L_0x0067;
    L_0x0064:
        r0.close();	 Catch:{  }
    L_0x0067:
        monitor-exit(r10);
        return;
    L_0x0069:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x006b }
    L_0x006b:
        r2 = move-exception;
        r9 = r2;
        r2 = r1;
        r1 = r9;
    L_0x006f:
        if (r5 == 0) goto L_0x0076;
    L_0x0071:
        if (r2 == 0) goto L_0x008e;
    L_0x0073:
        r5.close();	 Catch:{ Throwable -> 0x0087, all -> 0x008c }
    L_0x0076:
        throw r1;	 Catch:{  }
    L_0x0077:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0079 }
    L_0x0079:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x007c:
        if (r0 == 0) goto L_0x0083;
    L_0x007e:
        if (r3 == 0) goto L_0x0097;
    L_0x0080:
        r0.close();	 Catch:{ Throwable -> 0x0092 }
    L_0x0083:
        throw r1;	 Catch:{  }
    L_0x0084:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0087:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0076;
    L_0x008c:
        r1 = move-exception;
        goto L_0x007c;
    L_0x008e:
        r5.close();	 Catch:{  }
        goto L_0x0076;
    L_0x0092:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0083;
    L_0x0097:
        r0.close();	 Catch:{  }
        goto L_0x0083;
    L_0x009b:
        r1 = move-exception;
        r2 = r3;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, com.facebook.messaging.model.threadkey.ThreadKey, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21792a(com.facebook.messaging.model.threadkey.ThreadKey r6) {
        /*
        r5 = this;
        r3 = 0;
        monitor-enter(r5);
        r0 = com.facebook.messaging.model.threadkey.ThreadKey.h(r6);	 Catch:{ all -> 0x003d }
        com.google.common.base.Preconditions.checkState(r0);	 Catch:{ all -> 0x003d }
        r0 = r5.f15264b;	 Catch:{ all -> 0x003d }
        r0 = r0.get();	 Catch:{ all -> 0x003d }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x003d }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0030, all -> 0x0045 }
        r1 = 0;
        r5.m21783a(r6, r1, r4);	 Catch:{ Throwable -> 0x0025, all -> 0x0054 }
        if (r4 == 0) goto L_0x001e;
    L_0x001b:
        r4.close();	 Catch:{  }
    L_0x001e:
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.close();	 Catch:{  }
    L_0x0023:
        monitor-exit(r5);
        return;
    L_0x0025:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0027 }
    L_0x0027:
        r1 = move-exception;
    L_0x0028:
        if (r4 == 0) goto L_0x002f;
    L_0x002a:
        if (r2 == 0) goto L_0x0047;
    L_0x002c:
        r4.close();	 Catch:{ Throwable -> 0x0040, all -> 0x0045 }
    L_0x002f:
        throw r1;	 Catch:{  }
    L_0x0030:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0035:
        if (r0 == 0) goto L_0x003c;
    L_0x0037:
        if (r3 == 0) goto L_0x0050;
    L_0x0039:
        r0.close();	 Catch:{ Throwable -> 0x004b }
    L_0x003c:
        throw r1;	 Catch:{  }
    L_0x003d:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0040:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x002f;
    L_0x0045:
        r1 = move-exception;
        goto L_0x0035;
    L_0x0047:
        r4.close();	 Catch:{  }
        goto L_0x002f;
    L_0x004b:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x003c;
    L_0x0050:
        r0.close();	 Catch:{  }
        goto L_0x003c;
    L_0x0054:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final synchronized void m21804a(java.util.Map<com.facebook.messaging.model.threadkey.ThreadKey, android.os.Bundle> r9) {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r0 = r8.f15264b;	 Catch:{ all -> 0x005b }
        r0 = r0.get();	 Catch:{ all -> 0x005b }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x005b }
        r4 = r0.k();	 Catch:{ Throwable -> 0x004e, all -> 0x007f }
        r1 = 1940501745; // 0x73a9b4f1 float:2.6891116E31 double:9.58735248E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r4, r1);	 Catch:{ all -> 0x0038 }
        r1 = r9.keySet();	 Catch:{ all -> 0x0038 }
        r5 = r1.iterator();	 Catch:{ all -> 0x0038 }
    L_0x001c:
        r1 = r5.hasNext();	 Catch:{ all -> 0x0038 }
        if (r1 == 0) goto L_0x005e;
    L_0x0022:
        r1 = r5.next();	 Catch:{ all -> 0x0038 }
        r1 = (com.facebook.messaging.model.threadkey.ThreadKey) r1;	 Catch:{ all -> 0x0038 }
        r2 = r9.get(r1);	 Catch:{ all -> 0x0038 }
        r2 = (android.os.Bundle) r2;	 Catch:{ all -> 0x0038 }
        r6 = "session_state";
        r2 = r2.getString(r6);	 Catch:{ all -> 0x0038 }
        r8.m21783a(r1, r2, r4);	 Catch:{ all -> 0x0038 }
        goto L_0x001c;
    L_0x0038:
        r1 = move-exception;
        r2 = -1288536159; // 0xffffffffb3327fa1 float:-4.1559932E-8 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r4, r2);	 Catch:{ Throwable -> 0x0040, all -> 0x008e }
        throw r1;	 Catch:{ Throwable -> 0x0040, all -> 0x008e }
    L_0x0040:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0042 }
    L_0x0042:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x0046:
        if (r4 == 0) goto L_0x004d;
    L_0x0048:
        if (r2 == 0) goto L_0x0081;
    L_0x004a:
        r4.close();	 Catch:{ Throwable -> 0x007a, all -> 0x007f }
    L_0x004d:
        throw r1;	 Catch:{  }
    L_0x004e:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0050 }
    L_0x0050:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0053:
        if (r0 == 0) goto L_0x005a;
    L_0x0055:
        if (r3 == 0) goto L_0x008a;
    L_0x0057:
        r0.close();	 Catch:{ Throwable -> 0x0085 }
    L_0x005a:
        throw r1;	 Catch:{  }
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x005e:
        r1 = "pending_sessions";
        r2 = 0;
        r5 = 0;
        r4.delete(r1, r2, r5);	 Catch:{  }
        r4.setTransactionSuccessful();	 Catch:{  }
        r1 = -550155142; // 0xffffffffdf354c7a float:-1.3063951E19 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r4, r1);	 Catch:{  }
        if (r4 == 0) goto L_0x0073;
    L_0x0070:
        r4.close();	 Catch:{  }
    L_0x0073:
        if (r0 == 0) goto L_0x0078;
    L_0x0075:
        r0.close();	 Catch:{  }
    L_0x0078:
        monitor-exit(r8);
        return;
    L_0x007a:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x004d;
    L_0x007f:
        r1 = move-exception;
        goto L_0x0053;
    L_0x0081:
        r4.close();	 Catch:{  }
        goto L_0x004d;
    L_0x0085:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x005a;
    L_0x008a:
        r0.close();	 Catch:{  }
        goto L_0x005a;
    L_0x008e:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(java.util.Map):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final synchronized int m21789a(java.lang.String r8) {
        /*
        r7 = this;
        r3 = 0;
        monitor-enter(r7);
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.c;	 Catch:{ all -> 0x004d }
        r0 = r0.m2091a();	 Catch:{ all -> 0x004d }
        r1 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r8);	 Catch:{ all -> 0x004d }
        r0 = r7.f15264b;	 Catch:{ all -> 0x004d }
        r0 = r0.get();	 Catch:{ all -> 0x004d }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x004d }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0040, all -> 0x0055 }
        r2 = "pending_sessions";
        r5 = r1.mo1476a();	 Catch:{ Throwable -> 0x0032, all -> 0x0064 }
        r1 = r1.mo1477b();	 Catch:{ Throwable -> 0x0032, all -> 0x0064 }
        r1 = r4.delete(r2, r5, r1);	 Catch:{ Throwable -> 0x0032, all -> 0x0064 }
        if (r4 == 0) goto L_0x002b;
    L_0x0028:
        r4.close();	 Catch:{  }
    L_0x002b:
        if (r0 == 0) goto L_0x0030;
    L_0x002d:
        r0.close();	 Catch:{  }
    L_0x0030:
        monitor-exit(r7);
        return r1;
    L_0x0032:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0034 }
    L_0x0034:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0038:
        if (r4 == 0) goto L_0x003f;
    L_0x003a:
        if (r2 == 0) goto L_0x0057;
    L_0x003c:
        r4.close();	 Catch:{ Throwable -> 0x0050, all -> 0x0055 }
    L_0x003f:
        throw r1;	 Catch:{  }
    L_0x0040:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0042 }
    L_0x0042:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0045:
        if (r0 == 0) goto L_0x004c;
    L_0x0047:
        if (r3 == 0) goto L_0x0060;
    L_0x0049:
        r0.close();	 Catch:{ Throwable -> 0x005b }
    L_0x004c:
        throw r1;	 Catch:{  }
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0050:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x003f;
    L_0x0055:
        r1 = move-exception;
        goto L_0x0045;
    L_0x0057:
        r4.close();	 Catch:{  }
        goto L_0x003f;
    L_0x005b:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x004c;
    L_0x0060:
        r0.close();	 Catch:{  }
        goto L_0x004c;
    L_0x0064:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(java.lang.String):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21793a(com.facebook.messaging.model.threadkey.ThreadKey r7, long r8) {
        /*
        r6 = this;
        r3 = 0;
        monitor-enter(r6);
        r0 = r6.f15264b;	 Catch:{ all -> 0x0035 }
        r0 = r0.get();	 Catch:{ all -> 0x0035 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0035 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0028, all -> 0x003d }
        m21776a(r4, r7, r8);	 Catch:{ Throwable -> 0x001d, all -> 0x004c }
        if (r4 == 0) goto L_0x0016;
    L_0x0013:
        r4.close();	 Catch:{  }
    L_0x0016:
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0.close();	 Catch:{  }
    L_0x001b:
        monitor-exit(r6);
        return;
    L_0x001d:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x001f }
    L_0x001f:
        r1 = move-exception;
    L_0x0020:
        if (r4 == 0) goto L_0x0027;
    L_0x0022:
        if (r2 == 0) goto L_0x003f;
    L_0x0024:
        r4.close();	 Catch:{ Throwable -> 0x0038, all -> 0x003d }
    L_0x0027:
        throw r1;	 Catch:{  }
    L_0x0028:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x002a }
    L_0x002a:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x002d:
        if (r0 == 0) goto L_0x0034;
    L_0x002f:
        if (r3 == 0) goto L_0x0048;
    L_0x0031:
        r0.close();	 Catch:{ Throwable -> 0x0043 }
    L_0x0034:
        throw r1;	 Catch:{  }
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0038:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0027;
    L_0x003d:
        r1 = move-exception;
        goto L_0x002d;
    L_0x003f:
        r4.close();	 Catch:{  }
        goto L_0x0027;
    L_0x0043:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0034;
    L_0x0048:
        r0.close();	 Catch:{  }
        goto L_0x0034;
    L_0x004c:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, long):void");
    }

    @SuppressLint({"NewApi"})
    public final synchronized void m21801a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TincanDbSchemaPart$MessagesTable$Columns.f15410k.m2091a(), Long.valueOf(j));
        m21784a(str, contentValues);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21799a(com.facebook.messaging.model.threadkey.ThreadKey r9, boolean r10) {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0067 }
        r1.<init>();	 Catch:{ all -> 0x0067 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15373k;	 Catch:{ all -> 0x0067 }
        r2 = r0.m2091a();	 Catch:{ all -> 0x0067 }
        if (r10 == 0) goto L_0x004a;
    L_0x000f:
        r0 = 1;
    L_0x0010:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0067 }
        r1.put(r2, r0);	 Catch:{ all -> 0x0067 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x0067 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0067 }
        r2 = r9.toString();	 Catch:{ all -> 0x0067 }
        r2 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r2);	 Catch:{ all -> 0x0067 }
        r0 = r8.f15264b;	 Catch:{ all -> 0x0067 }
        r0 = r0.get();	 Catch:{ all -> 0x0067 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0067 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x005a, all -> 0x006f }
        r5 = "threads";
        r6 = r2.mo1476a();	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        r2 = r2.mo1477b();	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        r4.update(r5, r1, r6, r2);	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        if (r4 == 0) goto L_0x0043;
    L_0x0040:
        r4.close();	 Catch:{  }
    L_0x0043:
        if (r0 == 0) goto L_0x0048;
    L_0x0045:
        r0.close();	 Catch:{  }
    L_0x0048:
        monitor-exit(r8);
        return;
    L_0x004a:
        r0 = 0;
        goto L_0x0010;
    L_0x004c:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x004e }
    L_0x004e:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x0052:
        if (r4 == 0) goto L_0x0059;
    L_0x0054:
        if (r2 == 0) goto L_0x0071;
    L_0x0056:
        r4.close();	 Catch:{ Throwable -> 0x006a, all -> 0x006f }
    L_0x0059:
        throw r1;	 Catch:{  }
    L_0x005a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x005f:
        if (r0 == 0) goto L_0x0066;
    L_0x0061:
        if (r3 == 0) goto L_0x007a;
    L_0x0063:
        r0.close();	 Catch:{ Throwable -> 0x0075 }
    L_0x0066:
        throw r1;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006a:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0059;
    L_0x006f:
        r1 = move-exception;
        goto L_0x005f;
    L_0x0071:
        r4.close();	 Catch:{  }
        goto L_0x0059;
    L_0x0075:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0066;
    L_0x007a:
        r0.close();	 Catch:{  }
        goto L_0x0066;
    L_0x007e:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21806b(com.facebook.messaging.model.threadkey.ThreadKey r9) {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ all -> 0x005d }
        r0 = r0.m2091a();	 Catch:{ all -> 0x005d }
        r1 = r9.toString();	 Catch:{ all -> 0x005d }
        r1 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r1);	 Catch:{ all -> 0x005d }
        r0 = r8.f15264b;	 Catch:{ all -> 0x005d }
        r0 = r0.get();	 Catch:{ all -> 0x005d }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x005d }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0050, all -> 0x0065 }
        r2 = "threads";
        r5 = r1.mo1476a();	 Catch:{ Throwable -> 0x0042, all -> 0x0074 }
        r6 = r1.mo1477b();	 Catch:{ Throwable -> 0x0042, all -> 0x0074 }
        r4.delete(r2, r5, r6);	 Catch:{ Throwable -> 0x0042, all -> 0x0074 }
        r2 = "messages";
        r5 = r1.mo1476a();	 Catch:{ Throwable -> 0x0042, all -> 0x0074 }
        r1 = r1.mo1477b();	 Catch:{ Throwable -> 0x0042, all -> 0x0074 }
        r4.delete(r2, r5, r1);	 Catch:{ Throwable -> 0x0042, all -> 0x0074 }
        if (r4 == 0) goto L_0x003b;
    L_0x0038:
        r4.close();	 Catch:{  }
    L_0x003b:
        if (r0 == 0) goto L_0x0040;
    L_0x003d:
        r0.close();	 Catch:{  }
    L_0x0040:
        monitor-exit(r8);
        return;
    L_0x0042:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0044 }
    L_0x0044:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x0048:
        if (r4 == 0) goto L_0x004f;
    L_0x004a:
        if (r2 == 0) goto L_0x0067;
    L_0x004c:
        r4.close();	 Catch:{ Throwable -> 0x0060, all -> 0x0065 }
    L_0x004f:
        throw r1;	 Catch:{  }
    L_0x0050:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0052 }
    L_0x0052:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0055:
        if (r0 == 0) goto L_0x005c;
    L_0x0057:
        if (r3 == 0) goto L_0x0070;
    L_0x0059:
        r0.close();	 Catch:{ Throwable -> 0x006b }
    L_0x005c:
        throw r1;	 Catch:{  }
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0060:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x004f;
    L_0x0065:
        r1 = move-exception;
        goto L_0x0055;
    L_0x0067:
        r4.close();	 Catch:{  }
        goto L_0x004f;
    L_0x006b:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x005c;
    L_0x0070:
        r0.close();	 Catch:{  }
        goto L_0x005c;
    L_0x0074:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.b(com.facebook.messaging.model.threadkey.ThreadKey):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21798a(com.facebook.messaging.model.threadkey.ThreadKey r8, java.util.Set<java.lang.String> r9) {
        /*
        r7 = this;
        r3 = 0;
        monitor-enter(r7);
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15401b;	 Catch:{ all -> 0x0067 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0067 }
        r1 = r8.toString();	 Catch:{ all -> 0x0067 }
        r0 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r1);	 Catch:{ all -> 0x0067 }
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15400a;	 Catch:{ all -> 0x0067 }
        r1 = r1.m2091a();	 Catch:{ all -> 0x0067 }
        r1 = com.facebook.database.sqlite.SqlExpression.m10728a(r1, r9);	 Catch:{ all -> 0x0067 }
        r2 = 2;
        r2 = new com.facebook.database.sqlite.SqlExpression.Expression[r2];	 Catch:{ all -> 0x0067 }
        r4 = 0;
        r2[r4] = r0;	 Catch:{ all -> 0x0067 }
        r0 = 1;
        r2[r0] = r1;	 Catch:{ all -> 0x0067 }
        r1 = com.facebook.database.sqlite.SqlExpression.m10723a(r2);	 Catch:{ all -> 0x0067 }
        r0 = r7.f15264b;	 Catch:{ all -> 0x0067 }
        r0 = r0.get();	 Catch:{ all -> 0x0067 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0067 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x005a, all -> 0x006f }
        r2 = "messages";
        r5 = r1.mo1476a();	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        r1 = r1.mo1477b();	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        r4.delete(r2, r5, r1);	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        if (r4 == 0) goto L_0x0045;
    L_0x0042:
        r4.close();	 Catch:{  }
    L_0x0045:
        if (r0 == 0) goto L_0x004a;
    L_0x0047:
        r0.close();	 Catch:{  }
    L_0x004a:
        monitor-exit(r7);
        return;
    L_0x004c:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x004e }
    L_0x004e:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0052:
        if (r4 == 0) goto L_0x0059;
    L_0x0054:
        if (r2 == 0) goto L_0x0071;
    L_0x0056:
        r4.close();	 Catch:{ Throwable -> 0x006a, all -> 0x006f }
    L_0x0059:
        throw r1;	 Catch:{  }
    L_0x005a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x005f:
        if (r0 == 0) goto L_0x0066;
    L_0x0061:
        if (r3 == 0) goto L_0x007a;
    L_0x0063:
        r0.close();	 Catch:{ Throwable -> 0x0075 }
    L_0x0066:
        throw r1;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x006a:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0059;
    L_0x006f:
        r1 = move-exception;
        goto L_0x005f;
    L_0x0071:
        r4.close();	 Catch:{  }
        goto L_0x0059;
    L_0x0075:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0066;
    L_0x007a:
        r0.close();	 Catch:{  }
        goto L_0x0066;
    L_0x007e:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, java.util.Set):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21791a(com.facebook.messaging.model.messages.Message r10, byte[] r11, @javax.annotation.Nullable java.lang.String r12) {
        /*
        r9 = this;
        r3 = 0;
        monitor-enter(r9);
        r0 = r10.b;	 Catch:{ all -> 0x0105 }
        r0 = r0.a;	 Catch:{ all -> 0x0105 }
        r1 = com.facebook.messaging.model.threadkey.ThreadKey.Type.TINCAN;	 Catch:{ all -> 0x0105 }
        if (r0 != r1) goto L_0x00df;
    L_0x000a:
        r0 = 1;
    L_0x000b:
        com.google.common.base.Preconditions.checkArgument(r0);	 Catch:{ all -> 0x0105 }
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0105 }
        r1.<init>();	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15400a;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r10.a;	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15401b;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r10.b;	 Catch:{ all -> 0x0105 }
        r2 = r2.toString();	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15402c;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r9.m21785a(r10, r11);	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15403d;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r10.e;	 Catch:{ all -> 0x0105 }
        r2 = r2.b;	 Catch:{ all -> 0x0105 }
        r2 = r2.m5867b();	 Catch:{ all -> 0x0105 }
        r4 = java.lang.Long.parseLong(r2);	 Catch:{ all -> 0x0105 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15404e;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r4 = r10.c;	 Catch:{ all -> 0x0105 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15405f;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r4 = r10.d;	 Catch:{ all -> 0x0105 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15407h;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r10.l;	 Catch:{ all -> 0x0105 }
        r2 = r2.dbKeyValue;	 Catch:{ all -> 0x0105 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15408i;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r10.n;	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15410k;	 Catch:{ all -> 0x0105 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0105 }
        r2 = r10.K;	 Catch:{ all -> 0x0105 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0105 }
        r0 = r9.f15264b;	 Catch:{ all -> 0x0105 }
        r0 = r0.get();	 Catch:{ all -> 0x0105 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0105 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x00f8, all -> 0x010d }
        r2 = -1725645264; // 0xffffffff9924be30 float:-8.517009E-24 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r4, r2);	 Catch:{ all -> 0x00e2 }
        r2 = "messages";
        r5 = 0;
        r6 = -1709032514; // 0xffffffff9a223bbe float:-3.3549074E-23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r6);	 Catch:{ all -> 0x00e2 }
        r4.insertOrThrow(r2, r5, r1);	 Catch:{ all -> 0x00e2 }
        r1 = 975462726; // 0x3a246146 float:6.2705984E-4 double:4.819426217E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1);	 Catch:{ all -> 0x00e2 }
        if (r12 == 0) goto L_0x00c3;
    L_0x00be:
        r1 = r10.b;	 Catch:{ all -> 0x00e2 }
        r9.m21778a(r4, r1, r12);	 Catch:{ all -> 0x00e2 }
    L_0x00c3:
        r1 = r10.b;	 Catch:{ all -> 0x00e2 }
        r6 = r10.c;	 Catch:{ all -> 0x00e2 }
        m21776a(r4, r1, r6);	 Catch:{ all -> 0x00e2 }
        r4.setTransactionSuccessful();	 Catch:{ all -> 0x00e2 }
        r1 = 570078781; // 0x21fab63d float:1.6988897E-18 double:2.81656341E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r4, r1);	 Catch:{ Throwable -> 0x00ea, all -> 0x011c }
        if (r4 == 0) goto L_0x00d8;
    L_0x00d5:
        r4.close();	 Catch:{  }
    L_0x00d8:
        if (r0 == 0) goto L_0x00dd;
    L_0x00da:
        r0.close();	 Catch:{  }
    L_0x00dd:
        monitor-exit(r9);
        return;
    L_0x00df:
        r0 = 0;
        goto L_0x000b;
    L_0x00e2:
        r1 = move-exception;
        r2 = -863463226; // 0xffffffffcc8898c6 float:-7.1616048E7 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r4, r2);	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x00ea:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00ec }
    L_0x00ec:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00f0:
        if (r4 == 0) goto L_0x00f7;
    L_0x00f2:
        if (r2 == 0) goto L_0x010f;
    L_0x00f4:
        r4.close();	 Catch:{ Throwable -> 0x0108, all -> 0x010d }
    L_0x00f7:
        throw r1;	 Catch:{  }
    L_0x00f8:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00fa }
    L_0x00fa:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x00fd:
        if (r0 == 0) goto L_0x0104;
    L_0x00ff:
        if (r3 == 0) goto L_0x0118;
    L_0x0101:
        r0.close();	 Catch:{ Throwable -> 0x0113 }
    L_0x0104:
        throw r1;	 Catch:{  }
    L_0x0105:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0108:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x00f7;
    L_0x010d:
        r1 = move-exception;
        goto L_0x00fd;
    L_0x010f:
        r4.close();	 Catch:{  }
        goto L_0x00f7;
    L_0x0113:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0104;
    L_0x0118:
        r0.close();	 Catch:{  }
        goto L_0x0104;
    L_0x011c:
        r1 = move-exception;
        r2 = r3;
        goto L_0x00f0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.messages.Message, byte[], java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21805b(com.facebook.messaging.model.messages.Message r10, @javax.annotation.Nullable byte[] r11, @javax.annotation.Nullable java.lang.String r12) {
        /*
        r9 = this;
        r3 = 0;
        monitor-enter(r9);
        r0 = r10.b;	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.model.threadkey.ThreadKey.g(r0);	 Catch:{ all -> 0x00ef }
        com.google.common.base.Preconditions.checkArgument(r0);	 Catch:{ all -> 0x00ef }
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x00ef }
        r1.<init>();	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15400a;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r10.a;	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15401b;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r10.b;	 Catch:{ all -> 0x00ef }
        r2 = r2.toString();	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15402c;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r9.m21785a(r10, r11);	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15403d;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r10.e;	 Catch:{ all -> 0x00ef }
        r2 = r2.b;	 Catch:{ all -> 0x00ef }
        r2 = r2.m5867b();	 Catch:{ all -> 0x00ef }
        r4 = java.lang.Long.parseLong(r2);	 Catch:{ all -> 0x00ef }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15404e;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r4 = r10.c;	 Catch:{ all -> 0x00ef }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15405f;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r4 = r10.d;	 Catch:{ all -> 0x00ef }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15407h;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r10.l;	 Catch:{ all -> 0x00ef }
        r2 = r2.dbKeyValue;	 Catch:{ all -> 0x00ef }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15408i;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r10.n;	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15409j;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r1.put(r0, r12);	 Catch:{ all -> 0x00ef }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15410k;	 Catch:{ all -> 0x00ef }
        r0 = r0.m2091a();	 Catch:{ all -> 0x00ef }
        r2 = r10.K;	 Catch:{ all -> 0x00ef }
        r1.put(r0, r2);	 Catch:{ all -> 0x00ef }
        r0 = r10.w;	 Catch:{ all -> 0x00ef }
        m21780a(r0, r1);	 Catch:{ all -> 0x00ef }
        r0 = r9.f15264b;	 Catch:{ all -> 0x00ef }
        r0 = r0.get();	 Catch:{ all -> 0x00ef }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x00ef }
        r4 = r0.k();	 Catch:{ Throwable -> 0x00e2, all -> 0x00f7 }
        r2 = "messages";
        r5 = 0;
        r6 = 822258046; // 0x3102a97e float:1.9013835E-9 double:4.062494525E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r6);	 Catch:{ Throwable -> 0x00d4, all -> 0x0106 }
        r4.replaceOrThrow(r2, r5, r1);	 Catch:{ Throwable -> 0x00d4, all -> 0x0106 }
        r1 = 1058544568; // 0x3f181bb8 float:0.59417295 double:5.229905056E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1);	 Catch:{ Throwable -> 0x00d4, all -> 0x0106 }
        r1 = r10.b;	 Catch:{ Throwable -> 0x00d4, all -> 0x0106 }
        r6 = r10.c;	 Catch:{ Throwable -> 0x00d4, all -> 0x0106 }
        m21776a(r4, r1, r6);	 Catch:{ Throwable -> 0x00d4, all -> 0x0106 }
        if (r4 == 0) goto L_0x00cd;
    L_0x00ca:
        r4.close();	 Catch:{  }
    L_0x00cd:
        if (r0 == 0) goto L_0x00d2;
    L_0x00cf:
        r0.close();	 Catch:{  }
    L_0x00d2:
        monitor-exit(r9);
        return;
    L_0x00d4:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00d6 }
    L_0x00d6:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00da:
        if (r4 == 0) goto L_0x00e1;
    L_0x00dc:
        if (r2 == 0) goto L_0x00f9;
    L_0x00de:
        r4.close();	 Catch:{ Throwable -> 0x00f2, all -> 0x00f7 }
    L_0x00e1:
        throw r1;	 Catch:{  }
    L_0x00e2:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00e4 }
    L_0x00e4:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x00e7:
        if (r0 == 0) goto L_0x00ee;
    L_0x00e9:
        if (r3 == 0) goto L_0x0102;
    L_0x00eb:
        r0.close();	 Catch:{ Throwable -> 0x00fd }
    L_0x00ee:
        throw r1;	 Catch:{  }
    L_0x00ef:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x00f2:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x00e1;
    L_0x00f7:
        r1 = move-exception;
        goto L_0x00e7;
    L_0x00f9:
        r4.close();	 Catch:{  }
        goto L_0x00e1;
    L_0x00fd:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x00ee;
    L_0x0102:
        r0.close();	 Catch:{  }
        goto L_0x00ee;
    L_0x0106:
        r1 = move-exception;
        r2 = r3;
        goto L_0x00da;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.b(com.facebook.messaging.model.messages.Message, byte[], java.lang.String):void");
    }

    @SuppressLint({"NewApi"})
    public final synchronized void m21802a(String str, SendError sendError) {
        boolean z = true;
        synchronized (this) {
            Preconditions.checkArgument(sendError != null);
            if (sendError.b == SendErrorType.NONE) {
                z = false;
            }
            Preconditions.checkArgument(z);
            ContentValues contentValues = new ContentValues();
            m21780a(sendError, contentValues);
            contentValues.put(TincanDbSchemaPart$MessagesTable$Columns.f15407h.m2091a(), Integer.valueOf(MessageType.FAILED_SEND.dbKeyValue));
            m21784a(str, contentValues);
        }
    }

    public final synchronized void m21797a(ThreadKey threadKey, @Nullable String str, @Nullable String str2, @Nullable Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15372j.m2091a(), str);
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15370h.m2091a(), str2);
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15371i.m2091a(), l);
        m21781a(threadKey, contentValues);
    }

    public final synchronized void m21807b(ThreadKey threadKey, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15376n.m2091a(), Long.valueOf(j));
        m21781a(threadKey, contentValues);
    }

    public final synchronized void m21808c(ThreadKey threadKey, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15375m.m2091a(), Long.valueOf(j));
        m21781a(threadKey, contentValues);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21790a(long r10, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
        r9 = this;
        r3 = 0;
        monitor-enter(r9);
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a;	 Catch:{ all -> 0x0074 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0074 }
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0074 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0074 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15379b;	 Catch:{ all -> 0x0074 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0074 }
        r1.put(r0, r12);	 Catch:{ all -> 0x0074 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15380c;	 Catch:{ all -> 0x0074 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0074 }
        r1.put(r0, r13);	 Catch:{ all -> 0x0074 }
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15381d;	 Catch:{ all -> 0x0074 }
        r0 = r0.m2091a();	 Catch:{ all -> 0x0074 }
        r1.put(r0, r14);	 Catch:{ all -> 0x0074 }
        r0 = r9.f15264b;	 Catch:{ all -> 0x0074 }
        r0 = r0.get();	 Catch:{ all -> 0x0074 }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x0074 }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0067, all -> 0x007c }
        r2 = "thread_participants";
        r5 = 0;
        r6 = 712588973; // 0x2a793ead float:2.2137388E-13 double:3.52065731E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r6);	 Catch:{ Throwable -> 0x0059, all -> 0x008b }
        r4.replaceOrThrow(r2, r5, r1);	 Catch:{ Throwable -> 0x0059, all -> 0x008b }
        r1 = -1551629633; // 0xffffffffa38402bf float:-1.4312632E-17 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1);	 Catch:{ Throwable -> 0x0059, all -> 0x008b }
        if (r4 == 0) goto L_0x0052;
    L_0x004f:
        r4.close();	 Catch:{  }
    L_0x0052:
        if (r0 == 0) goto L_0x0057;
    L_0x0054:
        r0.close();	 Catch:{  }
    L_0x0057:
        monitor-exit(r9);
        return;
    L_0x0059:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005b }
    L_0x005b:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x005f:
        if (r4 == 0) goto L_0x0066;
    L_0x0061:
        if (r2 == 0) goto L_0x007e;
    L_0x0063:
        r4.close();	 Catch:{ Throwable -> 0x0077, all -> 0x007c }
    L_0x0066:
        throw r1;	 Catch:{  }
    L_0x0067:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0069 }
    L_0x0069:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x006c:
        if (r0 == 0) goto L_0x0073;
    L_0x006e:
        if (r3 == 0) goto L_0x0087;
    L_0x0070:
        r0.close();	 Catch:{ Throwable -> 0x0082 }
    L_0x0073:
        throw r1;	 Catch:{  }
    L_0x0074:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0077:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0066;
    L_0x007c:
        r1 = move-exception;
        goto L_0x006c;
    L_0x007e:
        r4.close();	 Catch:{  }
        goto L_0x0066;
    L_0x0082:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x0073;
    L_0x0087:
        r0.close();	 Catch:{  }
        goto L_0x0073;
    L_0x008b:
        r1 = move-exception;
        r2 = r3;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(long, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final synchronized void m21800a(java.lang.String r7, int r8) {
        /*
        r6 = this;
        r3 = 0;
        monitor-enter(r6);
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PreKeyTable.Columns.a;	 Catch:{ all -> 0x004e }
        r0 = r0.m2091a();	 Catch:{ all -> 0x004e }
        r1 = java.lang.Integer.toString(r8);	 Catch:{ all -> 0x004e }
        r1 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r1);	 Catch:{ all -> 0x004e }
        r0 = r6.f15264b;	 Catch:{ all -> 0x004e }
        r0 = r0.get();	 Catch:{ all -> 0x004e }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{ all -> 0x004e }
        r4 = r0.k();	 Catch:{ Throwable -> 0x0041, all -> 0x0056 }
        r2 = r1.mo1476a();	 Catch:{ Throwable -> 0x0033, all -> 0x0065 }
        r1 = r1.mo1477b();	 Catch:{ Throwable -> 0x0033, all -> 0x0065 }
        r4.delete(r7, r2, r1);	 Catch:{ Throwable -> 0x0033, all -> 0x0065 }
        if (r4 == 0) goto L_0x002c;
    L_0x0029:
        r4.close();	 Catch:{  }
    L_0x002c:
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        r0.close();	 Catch:{  }
    L_0x0031:
        monitor-exit(r6);
        return;
    L_0x0033:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0035 }
    L_0x0035:
        r2 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r5;
    L_0x0039:
        if (r4 == 0) goto L_0x0040;
    L_0x003b:
        if (r2 == 0) goto L_0x0058;
    L_0x003d:
        r4.close();	 Catch:{ Throwable -> 0x0051, all -> 0x0056 }
    L_0x0040:
        throw r1;	 Catch:{  }
    L_0x0041:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x0046:
        if (r0 == 0) goto L_0x004d;
    L_0x0048:
        if (r3 == 0) goto L_0x0061;
    L_0x004a:
        r0.close();	 Catch:{ Throwable -> 0x005c }
    L_0x004d:
        throw r1;	 Catch:{  }
    L_0x004e:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0051:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0040;
    L_0x0056:
        r1 = move-exception;
        goto L_0x0046;
    L_0x0058:
        r4.close();	 Catch:{  }
        goto L_0x0040;
    L_0x005c:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);	 Catch:{  }
        goto L_0x004d;
    L_0x0061:
        r0.close();	 Catch:{  }
        goto L_0x004d;
    L_0x0065:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(java.lang.String, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    private void m21781a(com.facebook.messaging.model.threadkey.ThreadKey r6, android.content.ContentValues r7) {
        /*
        r5 = this;
        r3 = 0;
        r0 = r5.f15264b;
        r0 = r0.get();
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;
        r4 = r0.k();	 Catch:{ Throwable -> 0x0026, all -> 0x0038 }
        m21777a(r4, r6, r7);	 Catch:{ Throwable -> 0x001b, all -> 0x0047 }
        if (r4 == 0) goto L_0x0015;
    L_0x0012:
        r4.close();	 Catch:{  }
    L_0x0015:
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0.close();
    L_0x001a:
        return;
    L_0x001b:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x001d }
    L_0x001d:
        r1 = move-exception;
    L_0x001e:
        if (r4 == 0) goto L_0x0025;
    L_0x0020:
        if (r2 == 0) goto L_0x003a;
    L_0x0022:
        r4.close();	 Catch:{ Throwable -> 0x0033, all -> 0x0038 }
    L_0x0025:
        throw r1;	 Catch:{  }
    L_0x0026:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0028 }
    L_0x0028:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x002b:
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        if (r3 == 0) goto L_0x0043;
    L_0x002f:
        r0.close();	 Catch:{ Throwable -> 0x003e }
    L_0x0032:
        throw r1;
    L_0x0033:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0025;
    L_0x0038:
        r1 = move-exception;
        goto L_0x002b;
    L_0x003a:
        r4.close();	 Catch:{  }
        goto L_0x0025;
    L_0x003e:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);
        goto L_0x0032;
    L_0x0043:
        r0.close();
        goto L_0x0032;
    L_0x0047:
        r1 = move-exception;
        r2 = r3;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(com.facebook.messaging.model.threadkey.ThreadKey, android.content.ContentValues):void");
    }

    @SuppressLint({"NewApi"})
    private static void m21777a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, ContentValues contentValues) {
        Expression a = SqlExpression.m10727a(TincanDbSchemaPart$ThreadsTable$Columns.f15363a.f1025d, threadKey.toString());
        sQLiteDatabase.update("threads", contentValues, a.mo1476a(), a.mo1477b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    private void m21784a(java.lang.String r6, android.content.ContentValues r7) {
        /*
        r5 = this;
        r3 = 0;
        r0 = r5.f15264b;
        r0 = r0.get();
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;
        r4 = r0.k();	 Catch:{ Throwable -> 0x0026, all -> 0x0038 }
        m21779a(r4, r6, r7);	 Catch:{ Throwable -> 0x001b, all -> 0x0047 }
        if (r4 == 0) goto L_0x0015;
    L_0x0012:
        r4.close();	 Catch:{  }
    L_0x0015:
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0.close();
    L_0x001a:
        return;
    L_0x001b:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x001d }
    L_0x001d:
        r1 = move-exception;
    L_0x001e:
        if (r4 == 0) goto L_0x0025;
    L_0x0020:
        if (r2 == 0) goto L_0x003a;
    L_0x0022:
        r4.close();	 Catch:{ Throwable -> 0x0033, all -> 0x0038 }
    L_0x0025:
        throw r1;	 Catch:{  }
    L_0x0026:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0028 }
    L_0x0028:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x002b:
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        if (r3 == 0) goto L_0x0043;
    L_0x002f:
        r0.close();	 Catch:{ Throwable -> 0x003e }
    L_0x0032:
        throw r1;
    L_0x0033:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0025;
    L_0x0038:
        r1 = move-exception;
        goto L_0x002b;
    L_0x003a:
        r4.close();	 Catch:{  }
        goto L_0x0025;
    L_0x003e:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);
        goto L_0x0032;
    L_0x0043:
        r0.close();
        goto L_0x0032;
    L_0x0047:
        r1 = move-exception;
        r2 = r3;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbWriteTincanHandler.a(java.lang.String, android.content.ContentValues):void");
    }

    @SuppressLint({"NewApi"})
    private static void m21779a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        Expression a = SqlExpression.m10727a(TincanDbSchemaPart$MessagesTable$Columns.f15400a.f1025d, str);
        sQLiteDatabase.update("messages", contentValues, a.mo1476a(), a.mo1477b());
    }

    private void m21778a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, String str) {
        boolean z = true;
        ContentValues contentValues = new ContentValues();
        m21782a(threadKey, str, contentValues);
        Expression a = SqlExpression.m10727a(TincanDbSchemaPart$ThreadsTable$Columns.f15363a.f1025d, threadKey.toString());
        if (sQLiteDatabase.update("threads", contentValues, a.mo1476a(), a.mo1477b()) != 1) {
            z = false;
        }
        Preconditions.checkState(z);
    }

    private void m21783a(ThreadKey threadKey, @Nullable String str, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15364b.f1025d, Long.valueOf(threadKey.d));
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15373k.f1025d, Integer.valueOf(1));
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15366d.f1025d, Long.valueOf(this.f15266d.mo211a()));
        if (str != null) {
            m21782a(threadKey, str, contentValues);
        }
        Expression a = SqlExpression.m10727a(TincanDbSchemaPart$ThreadsTable$Columns.f15363a.f1025d, threadKey.toString());
        if (sQLiteDatabase.update("threads", contentValues, a.mo1476a(), a.mo1477b()) == 0) {
            m21787b(threadKey, contentValues);
            SQLiteDetour.a(836263803);
            sQLiteDatabase.insertOrThrow("threads", null, contentValues);
            SQLiteDetour.a(-614166698);
        }
    }

    private static void m21776a(SQLiteDatabase sQLiteDatabase, ThreadKey threadKey, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15366d.f1025d, Long.valueOf(j));
        Expression a = SqlExpression.m10727a(TincanDbSchemaPart$ThreadsTable$Columns.f15363a.f1025d, threadKey.toString());
        sQLiteDatabase.update("threads", contentValues, a.mo1476a(), a.mo1477b());
    }

    private static void m21780a(SendError sendError, ContentValues contentValues) {
        contentValues.put(TincanDbSchemaPart$MessagesTable$Columns.f15411l.f1025d, sendError.b.serializedString);
        contentValues.put(TincanDbSchemaPart$MessagesTable$Columns.f15412m.f1025d, sendError.c);
        contentValues.put(TincanDbSchemaPart$MessagesTable$Columns.f15413n.f1025d, Long.valueOf(sendError.e));
    }

    private void m21787b(ThreadKey threadKey, ContentValues contentValues) {
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15363a.f1025d, threadKey.toString());
        contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15364b.f1025d, Long.valueOf(threadKey.d));
        m21788c(threadKey, contentValues);
    }

    private byte[] m21785a(Message message, byte[] bArr) {
        Throwable e;
        try {
            return this.f15267e.m21817a(((ThreadEncryptionKeyCache) this.f15268f.get()).a(message.b), bArr);
        } catch (KeyChainException e2) {
            e = e2;
            BLog.b(f15262a, "Failed to encrypt message for local storage", e);
            throw new RuntimeException(e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            BLog.b(f15262a, "Failed to encrypt message for local storage", e);
            throw new RuntimeException(e);
        } catch (IOException e4) {
            e = e4;
            BLog.b(f15262a, "Failed to encrypt message for local storage", e);
            throw new RuntimeException(e);
        }
    }

    private byte[] m21788c(ThreadKey threadKey, ContentValues contentValues) {
        Throwable e;
        try {
            ThreadEncryptionKeyCache threadEncryptionKeyCache = (ThreadEncryptionKeyCache) this.f15268f.get();
            byte[] a = threadEncryptionKeyCache.a(threadKey);
            if (a == null) {
                a = this.f15267e.m21815a();
            }
            threadEncryptionKeyCache.a(threadKey, a);
            contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15377o.m2091a(), this.f15267e.m21816a(a));
            return a;
        } catch (KeyChainException e2) {
            e = e2;
            BLog.b(f15262a, "Failed to encrypt key for local storage", e);
            throw new RuntimeException(e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            BLog.b(f15262a, "Failed to encrypt key for local storage", e);
            throw new RuntimeException(e);
        } catch (IOException e4) {
            e = e4;
            BLog.b(f15262a, "Failed to encrypt key for local storage", e);
            throw new RuntimeException(e);
        }
    }

    private void m21782a(ThreadKey threadKey, String str, ContentValues contentValues) {
        Throwable e;
        try {
            contentValues.put(TincanDbSchemaPart$ThreadsTable$Columns.f15368f.m2091a(), this.f15267e.m21817a(m21788c(threadKey, contentValues), str.getBytes("UTF-8")));
        } catch (KeyChainException e2) {
            e = e2;
            BLog.b(f15262a, "Failed to encrypt crypto session for local storage", e);
            throw new RuntimeException(e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            BLog.b(f15262a, "Failed to encrypt crypto session for local storage", e);
            throw new RuntimeException(e);
        } catch (IOException e4) {
            e = e4;
            BLog.b(f15262a, "Failed to encrypt crypto session for local storage", e);
            throw new RuntimeException(e);
        }
    }
}
