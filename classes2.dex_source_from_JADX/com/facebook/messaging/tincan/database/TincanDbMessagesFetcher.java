package com.facebook.messaging.tincan.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.serialization.DbMediaResourceSerialization;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorBuilder;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.database.clock.TincanDbClock;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mStateAfterAnimating= */
public class TincanDbMessagesFetcher {
    static final String[] f15389a = new String[]{TincanDbSchemaPart$MessagesTable$Columns.f15400a.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15401b.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15407h.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15402c.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15403d.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15404e.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15405f.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15408i.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15411l.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15412m.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15413n.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15409j.f1025d, TincanDbSchemaPart$MessagesTable$Columns.f15410k.f1025d, TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15381d.f1025d};
    private static final Class<?> f15390b = TincanDbMessagesFetcher.class;
    private static volatile TincanDbMessagesFetcher f15391k;
    private final DbMediaResourceSerialization f15392c;
    private final SalamanderDecoder f15393d;
    private final SystemClock f15394e;
    private final Provider<TincanDatabaseSupplier> f15395f;
    private final TincanDbClock f15396g;
    private final Provider<User> f15397h;
    private final DbCrypto f15398i;
    private final Provider<ThreadEncryptionKeyCache> f15399j;

    public static com.facebook.messaging.tincan.database.TincanDbMessagesFetcher m21940a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15391k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.class;
        monitor-enter(r1);
        r0 = f15391k;	 Catch:{ all -> 0x003a }
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
        r0 = m21944b(r0);	 Catch:{ all -> 0x0035 }
        f15391k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15391k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.TincanDbMessagesFetcher");
    }

    private static TincanDbMessagesFetcher m21944b(InjectorLike injectorLike) {
        return new TincanDbMessagesFetcher(DbMediaResourceSerialization.m21926b(injectorLike), SalamanderDecoder.m21822a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 8567), TincanDbClock.m21809a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), DbCrypto.m21813a(injectorLike), IdBasedProvider.m1811a(injectorLike, 8566));
    }

    @Inject
    TincanDbMessagesFetcher(DbMediaResourceSerialization dbMediaResourceSerialization, SalamanderDecoder salamanderDecoder, SystemClock systemClock, Provider<TincanDatabaseSupplier> provider, TincanDbClock tincanDbClock, Provider<User> provider2, DbCrypto dbCrypto, Provider<ThreadEncryptionKeyCache> provider3) {
        this.f15392c = dbMediaResourceSerialization;
        this.f15393d = salamanderDecoder;
        this.f15394e = systemClock;
        this.f15395f = provider;
        this.f15396g = tincanDbClock;
        this.f15397h = provider2;
        this.f15398i = dbCrypto;
        this.f15399j = provider3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final java.lang.String m21950a(java.lang.String r12) {
        /*
        r11 = this;
        r9 = 0;
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15408i;
        r0 = r0.m2091a();
        r4 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r12);
        r0 = r11.f15395f;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x007f, all -> 0x009d }
        r1 = "messages";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r3 = 0;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15409j;	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r5 = r5.m2091a();	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r2[r3] = r5;	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r3 = r4.mo1476a();	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r4 = r4.mo1477b();	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0071, all -> 0x0091 }
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x0063, all -> 0x00ac }
        if (r1 == 0) goto L_0x0052;
    L_0x003b:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15409j;	 Catch:{ Throwable -> 0x0063, all -> 0x00ac }
        r1 = r1.m2093b(r3);	 Catch:{ Throwable -> 0x0063, all -> 0x00ac }
        if (r3 == 0) goto L_0x0046;
    L_0x0043:
        r3.close();	 Catch:{  }
    L_0x0046:
        if (r0 == 0) goto L_0x004b;
    L_0x0048:
        r0.close();	 Catch:{  }
    L_0x004b:
        if (r8 == 0) goto L_0x0050;
    L_0x004d:
        r8.close();
    L_0x0050:
        r0 = r1;
    L_0x0051:
        return r0;
    L_0x0052:
        if (r3 == 0) goto L_0x0057;
    L_0x0054:
        r3.close();	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x005c;
    L_0x0059:
        r0.close();	 Catch:{  }
    L_0x005c:
        if (r8 == 0) goto L_0x0061;
    L_0x005e:
        r8.close();
    L_0x0061:
        r0 = r9;
        goto L_0x0051;
    L_0x0063:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0065 }
    L_0x0065:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0069:
        if (r3 == 0) goto L_0x0070;
    L_0x006b:
        if (r2 == 0) goto L_0x0094;
    L_0x006d:
        r3.close();	 Catch:{ Throwable -> 0x008c, all -> 0x0091 }
    L_0x0070:
        throw r1;	 Catch:{  }
    L_0x0071:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0073 }
    L_0x0073:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0077:
        if (r0 == 0) goto L_0x007e;
    L_0x0079:
        if (r2 == 0) goto L_0x009f;
    L_0x007b:
        r0.close();	 Catch:{ Throwable -> 0x0098, all -> 0x009d }
    L_0x007e:
        throw r1;	 Catch:{  }
    L_0x007f:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x0084:
        if (r8 == 0) goto L_0x008b;
    L_0x0086:
        if (r9 == 0) goto L_0x00a8;
    L_0x0088:
        r8.close();	 Catch:{ Throwable -> 0x00a3 }
    L_0x008b:
        throw r0;
    L_0x008c:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0070;
    L_0x0091:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0077;
    L_0x0094:
        r3.close();	 Catch:{  }
        goto L_0x0070;
    L_0x0098:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x007e;
    L_0x009d:
        r0 = move-exception;
        goto L_0x0084;
    L_0x009f:
        r0.close();	 Catch:{  }
        goto L_0x007e;
    L_0x00a3:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x008b;
    L_0x00a8:
        r8.close();
        goto L_0x008b;
    L_0x00ac:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a(java.lang.String):java.lang.String");
    }

    public final Message m21953b(String str) {
        return m21939a(SqlExpression.m10727a(TincanDbSchemaPart$MessagesTable$Columns.f15408i.f1025d, str));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final void m21952a(com.facebook.messaging.model.threadkey.ThreadKey r12, com.google.common.base.Function<com.facebook.messaging.model.messages.Message, java.lang.Void> r13) {
        /*
        r11 = this;
        r9 = 0;
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15401b;
        r1 = r12.toString();
        r4 = r0.m2090a(r1);
        r1 = m21945b();
        r0 = r11.f15395f;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x0057, all -> 0x0085 }
        r2 = f15389a;	 Catch:{ Throwable -> 0x0049, all -> 0x0079 }
        r3 = r4.mo1476a();	 Catch:{ Throwable -> 0x0049, all -> 0x0079 }
        r4 = r4.mo1477b();	 Catch:{ Throwable -> 0x0049, all -> 0x0079 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0049, all -> 0x0079 }
    L_0x002d:
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x003b, all -> 0x0094 }
        if (r1 == 0) goto L_0x0064;
    L_0x0033:
        r1 = r11.m21938a(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0094 }
        r13.apply(r1);	 Catch:{ Throwable -> 0x003b, all -> 0x0094 }
        goto L_0x002d;
    L_0x003b:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x003d }
    L_0x003d:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0041:
        if (r3 == 0) goto L_0x0048;
    L_0x0043:
        if (r2 == 0) goto L_0x007c;
    L_0x0045:
        r3.close();	 Catch:{ Throwable -> 0x0074, all -> 0x0079 }
    L_0x0048:
        throw r1;	 Catch:{  }
    L_0x0049:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x004b }
    L_0x004b:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x004f:
        if (r0 == 0) goto L_0x0056;
    L_0x0051:
        if (r2 == 0) goto L_0x0087;
    L_0x0053:
        r0.close();	 Catch:{ Throwable -> 0x0080, all -> 0x0085 }
    L_0x0056:
        throw r1;	 Catch:{  }
    L_0x0057:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0059 }
    L_0x0059:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x005c:
        if (r8 == 0) goto L_0x0063;
    L_0x005e:
        if (r9 == 0) goto L_0x0090;
    L_0x0060:
        r8.close();	 Catch:{ Throwable -> 0x008b }
    L_0x0063:
        throw r0;
    L_0x0064:
        if (r3 == 0) goto L_0x0069;
    L_0x0066:
        r3.close();	 Catch:{  }
    L_0x0069:
        if (r0 == 0) goto L_0x006e;
    L_0x006b:
        r0.close();	 Catch:{  }
    L_0x006e:
        if (r8 == 0) goto L_0x0073;
    L_0x0070:
        r8.close();
    L_0x0073:
        return;
    L_0x0074:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0048;
    L_0x0079:
        r1 = move-exception;
        r2 = r9;
        goto L_0x004f;
    L_0x007c:
        r3.close();	 Catch:{  }
        goto L_0x0048;
    L_0x0080:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x0056;
    L_0x0085:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0087:
        r0.close();	 Catch:{  }
        goto L_0x0056;
    L_0x008b:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x0063;
    L_0x0090:
        r8.close();
        goto L_0x0063;
    L_0x0094:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a(com.facebook.messaging.model.threadkey.ThreadKey, com.google.common.base.Function):void");
    }

    public final ImmutableList<Message> m21948a(ThreadKey threadKey, long j) {
        Expression a = SqlExpression.m10722a();
        a.m10741a(TincanDbSchemaPart$MessagesTable$Columns.f15401b.m2090a(threadKey.toString()));
        a.m10741a(TincanDbSchemaPart$MessagesTable$Columns.f15404e.m2095c(String.valueOf(j)));
        a.m10741a(TincanDbSchemaPart$MessagesTable$Columns.f15410k.m2097d("0"));
        return m21941a(a.mo1476a(), a.mo1477b());
    }

    public final ImmutableList<Message> m21949a(ThreadKey threadKey, long j, @Nullable String str) {
        Expression a = SqlExpression.m10722a();
        a.m10741a(TincanDbSchemaPart$MessagesTable$Columns.f15401b.m2090a(threadKey.toString()));
        a.m10741a(TincanDbSchemaPart$MessagesTable$Columns.f15410k.m2097d("0"));
        a.m10741a(TincanDbSchemaPart$MessagesTable$Columns.f15410k.m2095c(String.valueOf(j)));
        if (str != null) {
            a.m10741a(SqlExpression.m10735b(TincanDbSchemaPart$MessagesTable$Columns.f15403d.f1025d, str));
        }
        return m21941a(a.mo1476a(), a.mo1477b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final com.facebook.messaging.model.messages.MessagesCollection m21947a(com.facebook.messaging.model.threadkey.ThreadKey r17, long r18, int r20) {
        /*
        r16 = this;
        r6 = com.facebook.database.sqlite.SqlExpression.m10722a();
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15401b;
        r3 = r17.toString();
        r2 = r2.m2090a(r3);
        r6.m10741a(r2);
        r2 = 0;
        r2 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0024;
    L_0x0017:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15404e;
        r3 = java.lang.String.valueOf(r18);
        r2 = r2.m2092b(r3);
        r6.m10741a(r2);
    L_0x0024:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15404e;
        r9 = r2.m2100e();
        if (r20 <= 0) goto L_0x0045;
    L_0x002c:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r9);
        r3 = " LIMIT ";
        r2 = r2.append(r3);
        r0 = r20;
        r2 = r2.append(r0);
        r9 = r2.toString();
    L_0x0045:
        r3 = m21945b();
        r13 = new com.google.common.collect.ImmutableList$Builder;
        r13.<init>();
        r0 = r16;
        r2 = r0.f15395f;
        r2 = r2.get();
        r10 = r2;
        r10 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r10;
        r12 = 0;
        r2 = r10.k();	 Catch:{ Throwable -> 0x009c, all -> 0x00e1 }
        r11 = 0;
        r4 = f15389a;	 Catch:{ Throwable -> 0x008e, all -> 0x00d5 }
        r5 = r6.mo1476a();	 Catch:{ Throwable -> 0x008e, all -> 0x00d5 }
        r6 = r6.mo1477b();	 Catch:{ Throwable -> 0x008e, all -> 0x00d5 }
        r7 = 0;
        r8 = 0;
        r5 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x008e, all -> 0x00d5 }
        r4 = 0;
    L_0x0070:
        r3 = r5.moveToNext();	 Catch:{ Throwable -> 0x0080, all -> 0x00f3 }
        if (r3 == 0) goto L_0x00aa;
    L_0x0076:
        r0 = r16;
        r3 = r0.m21938a(r5);	 Catch:{ Throwable -> 0x0080, all -> 0x00f3 }
        r13.m1069c(r3);	 Catch:{ Throwable -> 0x0080, all -> 0x00f3 }
        goto L_0x0070;
    L_0x0080:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x0082 }
    L_0x0082:
        r4 = move-exception;
        r14 = r4;
        r4 = r3;
        r3 = r14;
    L_0x0086:
        if (r5 == 0) goto L_0x008d;
    L_0x0088:
        if (r4 == 0) goto L_0x00d8;
    L_0x008a:
        r5.close();	 Catch:{ Throwable -> 0x00d0, all -> 0x00d5 }
    L_0x008d:
        throw r3;	 Catch:{  }
    L_0x008e:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x0090 }
    L_0x0090:
        r4 = move-exception;
        r14 = r4;
        r4 = r3;
        r3 = r14;
    L_0x0094:
        if (r2 == 0) goto L_0x009b;
    L_0x0096:
        if (r4 == 0) goto L_0x00e4;
    L_0x0098:
        r2.close();	 Catch:{ Throwable -> 0x00dc, all -> 0x00e1 }
    L_0x009b:
        throw r3;	 Catch:{  }
    L_0x009c:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x009e }
    L_0x009e:
        r3 = move-exception;
        r14 = r3;
        r3 = r2;
        r2 = r14;
    L_0x00a2:
        if (r10 == 0) goto L_0x00a9;
    L_0x00a4:
        if (r3 == 0) goto L_0x00ed;
    L_0x00a6:
        r10.close();	 Catch:{ Throwable -> 0x00e8 }
    L_0x00a9:
        throw r2;
    L_0x00aa:
        if (r5 == 0) goto L_0x00af;
    L_0x00ac:
        r5.close();	 Catch:{  }
    L_0x00af:
        if (r2 == 0) goto L_0x00b4;
    L_0x00b1:
        r2.close();	 Catch:{  }
    L_0x00b4:
        if (r10 == 0) goto L_0x00b9;
    L_0x00b6:
        r10.close();
    L_0x00b9:
        r3 = r13.m1068b();
        if (r20 <= 0) goto L_0x00c7;
    L_0x00bf:
        r2 = r3.size();
        r0 = r20;
        if (r2 >= r0) goto L_0x00f1;
    L_0x00c7:
        r2 = 1;
    L_0x00c8:
        r4 = new com.facebook.messaging.model.messages.MessagesCollection;
        r0 = r17;
        r4.<init>(r0, r3, r2);
        return r4;
    L_0x00d0:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r4, r5);	 Catch:{  }
        goto L_0x008d;
    L_0x00d5:
        r3 = move-exception;
        r4 = r11;
        goto L_0x0094;
    L_0x00d8:
        r5.close();	 Catch:{  }
        goto L_0x008d;
    L_0x00dc:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r4, r2);	 Catch:{  }
        goto L_0x009b;
    L_0x00e1:
        r2 = move-exception;
        r3 = r12;
        goto L_0x00a2;
    L_0x00e4:
        r2.close();	 Catch:{  }
        goto L_0x009b;
    L_0x00e8:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);
        goto L_0x00a9;
    L_0x00ed:
        r10.close();
        goto L_0x00a9;
    L_0x00f1:
        r2 = 0;
        goto L_0x00c8;
    L_0x00f3:
        r3 = move-exception;
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a(com.facebook.messaging.model.threadkey.ThreadKey, long, int):com.facebook.messaging.model.messages.MessagesCollection");
    }

    private static String m21945b() {
        return StringFormatUtil.a("%s LEFT OUTER JOIN %s ON (%s.%s = %s.%s)", new Object[]{"messages", "thread_participants", "messages", TincanDbSchemaPart$MessagesTable$Columns.f15403d.f1025d, "thread_participants", TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a.f1025d});
    }

    @Nullable
    final Message m21954c(String str) {
        return m21939a(SqlExpression.m10727a(TincanDbSchemaPart$MessagesTable$Columns.f15400a.f1025d, str));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    @javax.annotation.Nullable
    private com.facebook.messaging.model.messages.Message m21939a(com.facebook.database.sqlite.SqlExpression.Expression r12) {
        /*
        r11 = this;
        r9 = 0;
        r0 = "%s LEFT OUTER JOIN %s ON (%s.%s = %s.%s)";
        r1 = 6;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "messages";
        r1[r2] = r3;
        r2 = 1;
        r3 = "thread_participants";
        r1[r2] = r3;
        r2 = 2;
        r3 = "messages";
        r1[r2] = r3;
        r2 = 3;
        r3 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$MessagesTable$Columns.f15403d;
        r3 = r3.m2091a();
        r1[r2] = r3;
        r2 = 4;
        r3 = "thread_participants";
        r1[r2] = r3;
        r2 = 5;
        r3 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a;
        r3 = r3.m2091a();
        r1[r2] = r3;
        r1 = com.facebook.common.stringformat.StringFormatUtil.a(r0, r1);
        r0 = r11.f15395f;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x0096, all -> 0x00b4 }
        r2 = f15389a;	 Catch:{ Throwable -> 0x0088, all -> 0x00a8 }
        r3 = r12.mo1476a();	 Catch:{ Throwable -> 0x0088, all -> 0x00a8 }
        r4 = r12.mo1477b();	 Catch:{ Throwable -> 0x0088, all -> 0x00a8 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0088, all -> 0x00a8 }
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x007a, all -> 0x00c3 }
        if (r1 == 0) goto L_0x0069;
    L_0x0054:
        r1 = r11.m21938a(r3);	 Catch:{ Throwable -> 0x007a, all -> 0x00c3 }
        if (r3 == 0) goto L_0x005d;
    L_0x005a:
        r3.close();	 Catch:{  }
    L_0x005d:
        if (r0 == 0) goto L_0x0062;
    L_0x005f:
        r0.close();	 Catch:{  }
    L_0x0062:
        if (r8 == 0) goto L_0x0067;
    L_0x0064:
        r8.close();
    L_0x0067:
        r0 = r1;
    L_0x0068:
        return r0;
    L_0x0069:
        if (r3 == 0) goto L_0x006e;
    L_0x006b:
        r3.close();	 Catch:{  }
    L_0x006e:
        if (r0 == 0) goto L_0x0073;
    L_0x0070:
        r0.close();	 Catch:{  }
    L_0x0073:
        if (r8 == 0) goto L_0x0078;
    L_0x0075:
        r8.close();
    L_0x0078:
        r0 = r9;
        goto L_0x0068;
    L_0x007a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x007c }
    L_0x007c:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0080:
        if (r3 == 0) goto L_0x0087;
    L_0x0082:
        if (r2 == 0) goto L_0x00ab;
    L_0x0084:
        r3.close();	 Catch:{ Throwable -> 0x00a3, all -> 0x00a8 }
    L_0x0087:
        throw r1;	 Catch:{  }
    L_0x0088:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x008a }
    L_0x008a:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x008e:
        if (r0 == 0) goto L_0x0095;
    L_0x0090:
        if (r2 == 0) goto L_0x00b6;
    L_0x0092:
        r0.close();	 Catch:{ Throwable -> 0x00af, all -> 0x00b4 }
    L_0x0095:
        throw r1;	 Catch:{  }
    L_0x0096:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0098 }
    L_0x0098:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x009b:
        if (r8 == 0) goto L_0x00a2;
    L_0x009d:
        if (r9 == 0) goto L_0x00bf;
    L_0x009f:
        r8.close();	 Catch:{ Throwable -> 0x00ba }
    L_0x00a2:
        throw r0;
    L_0x00a3:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0087;
    L_0x00a8:
        r1 = move-exception;
        r2 = r9;
        goto L_0x008e;
    L_0x00ab:
        r3.close();	 Catch:{  }
        goto L_0x0087;
    L_0x00af:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x0095;
    L_0x00b4:
        r0 = move-exception;
        goto L_0x009b;
    L_0x00b6:
        r0.close();	 Catch:{  }
        goto L_0x0095;
    L_0x00ba:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x00a2;
    L_0x00bf:
        r8.close();
        goto L_0x00a2;
    L_0x00c3:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a(com.facebook.database.sqlite.SqlExpression$Expression):com.facebook.messaging.model.messages.Message");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final java.util.List<com.facebook.ui.media.attachments.MediaResource> m21951a() {
        /*
        r7 = this;
        r3 = 0;
        r1 = new java.util.LinkedList;
        r1.<init>();
        r0 = r7.f15395f;
        r0 = r0.get();
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;
        r4 = r0.k();	 Catch:{ Throwable -> 0x0040, all -> 0x006e }
        r5 = m21935a(r4);	 Catch:{ Throwable -> 0x0032, all -> 0x0062 }
    L_0x0016:
        r2 = r5.moveToNext();	 Catch:{ Throwable -> 0x0024, all -> 0x007d }
        if (r2 == 0) goto L_0x004d;
    L_0x001c:
        r2 = r7.m21946b(r5);	 Catch:{ Throwable -> 0x0024, all -> 0x007d }
        r1.addAll(r2);	 Catch:{ Throwable -> 0x0024, all -> 0x007d }
        goto L_0x0016;
    L_0x0024:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0026 }
    L_0x0026:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x002a:
        if (r5 == 0) goto L_0x0031;
    L_0x002c:
        if (r2 == 0) goto L_0x0065;
    L_0x002e:
        r5.close();	 Catch:{ Throwable -> 0x005d, all -> 0x0062 }
    L_0x0031:
        throw r1;	 Catch:{  }
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
        if (r2 == 0) goto L_0x0070;
    L_0x003c:
        r4.close();	 Catch:{ Throwable -> 0x0069, all -> 0x006e }
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
        if (r3 == 0) goto L_0x0079;
    L_0x0049:
        r0.close();	 Catch:{ Throwable -> 0x0074 }
    L_0x004c:
        throw r1;
    L_0x004d:
        if (r5 == 0) goto L_0x0052;
    L_0x004f:
        r5.close();	 Catch:{  }
    L_0x0052:
        if (r4 == 0) goto L_0x0057;
    L_0x0054:
        r4.close();	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x005c;
    L_0x0059:
        r0.close();
    L_0x005c:
        return r1;
    L_0x005d:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x0031;
    L_0x0062:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0038;
    L_0x0065:
        r5.close();	 Catch:{  }
        goto L_0x0031;
    L_0x0069:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x003f;
    L_0x006e:
        r1 = move-exception;
        goto L_0x0045;
    L_0x0070:
        r4.close();	 Catch:{  }
        goto L_0x003f;
    L_0x0074:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);
        goto L_0x004c;
    L_0x0079:
        r0.close();
        goto L_0x004c;
    L_0x007d:
        r1 = move-exception;
        r2 = r3;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a():java.util.List<com.facebook.ui.media.attachments.MediaResource>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final java.util.List<com.facebook.ui.media.attachments.MediaResource> m21955d(java.lang.String r8) {
        /*
        r7 = this;
        r3 = 0;
        r0 = r7.f15395f;
        r0 = r0.get();
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;
        r4 = r0.k();	 Catch:{ Throwable -> 0x006a, all -> 0x0088 }
        r5 = m21937a(r4, r8);	 Catch:{ Throwable -> 0x005c, all -> 0x007c }
        r1 = r5.moveToNext();	 Catch:{ Throwable -> 0x004e, all -> 0x0097 }
        if (r1 == 0) goto L_0x0038;
    L_0x0017:
        r1 = r7.m21946b(r5);	 Catch:{ Throwable -> 0x004e, all -> 0x0097 }
        r2 = r1.isEmpty();	 Catch:{ Throwable -> 0x004e, all -> 0x0097 }
        if (r2 != 0) goto L_0x0036;
    L_0x0021:
        r2 = 1;
    L_0x0022:
        com.google.common.base.Preconditions.checkState(r2);	 Catch:{ Throwable -> 0x004e, all -> 0x0097 }
        if (r5 == 0) goto L_0x002a;
    L_0x0027:
        r5.close();	 Catch:{  }
    L_0x002a:
        if (r4 == 0) goto L_0x002f;
    L_0x002c:
        r4.close();	 Catch:{  }
    L_0x002f:
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0.close();
    L_0x0034:
        r0 = r1;
    L_0x0035:
        return r0;
    L_0x0036:
        r2 = 0;
        goto L_0x0022;
    L_0x0038:
        r1 = new java.util.LinkedList;	 Catch:{  }
        r1.<init>();	 Catch:{  }
        if (r5 == 0) goto L_0x0042;
    L_0x003f:
        r5.close();	 Catch:{  }
    L_0x0042:
        if (r4 == 0) goto L_0x0047;
    L_0x0044:
        r4.close();	 Catch:{  }
    L_0x0047:
        if (r0 == 0) goto L_0x004c;
    L_0x0049:
        r0.close();
    L_0x004c:
        r0 = r1;
        goto L_0x0035;
    L_0x004e:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0050 }
    L_0x0050:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0054:
        if (r5 == 0) goto L_0x005b;
    L_0x0056:
        if (r2 == 0) goto L_0x007f;
    L_0x0058:
        r5.close();	 Catch:{ Throwable -> 0x0077, all -> 0x007c }
    L_0x005b:
        throw r1;	 Catch:{  }
    L_0x005c:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005e }
    L_0x005e:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0062:
        if (r4 == 0) goto L_0x0069;
    L_0x0064:
        if (r2 == 0) goto L_0x008a;
    L_0x0066:
        r4.close();	 Catch:{ Throwable -> 0x0083, all -> 0x0088 }
    L_0x0069:
        throw r1;	 Catch:{  }
    L_0x006a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x006f:
        if (r0 == 0) goto L_0x0076;
    L_0x0071:
        if (r3 == 0) goto L_0x0093;
    L_0x0073:
        r0.close();	 Catch:{ Throwable -> 0x008e }
    L_0x0076:
        throw r1;
    L_0x0077:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x005b;
    L_0x007c:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0062;
    L_0x007f:
        r5.close();	 Catch:{  }
        goto L_0x005b;
    L_0x0083:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0069;
    L_0x0088:
        r1 = move-exception;
        goto L_0x006f;
    L_0x008a:
        r4.close();	 Catch:{  }
        goto L_0x0069;
    L_0x008e:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);
        goto L_0x0076;
    L_0x0093:
        r0.close();
        goto L_0x0076;
    L_0x0097:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.d(java.lang.String):java.util.List<com.facebook.ui.media.attachments.MediaResource>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    private com.google.common.collect.ImmutableList<com.facebook.messaging.model.messages.Message> m21941a(java.lang.String r13, java.lang.String[] r14) {
        /*
        r12 = this;
        r9 = 0;
        r10 = new com.google.common.collect.ImmutableList$Builder;
        r10.<init>();
        r0 = r12.f15395f;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x004c, all -> 0x007e }
        r1 = m21945b();	 Catch:{ Throwable -> 0x003e, all -> 0x0072 }
        r2 = f15389a;	 Catch:{ Throwable -> 0x003e, all -> 0x0072 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r13;
        r4 = r14;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x003e, all -> 0x0072 }
    L_0x0022:
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x0030, all -> 0x008d }
        if (r1 == 0) goto L_0x0059;
    L_0x0028:
        r1 = r12.m21938a(r3);	 Catch:{ Throwable -> 0x0030, all -> 0x008d }
        r10.m1069c(r1);	 Catch:{ Throwable -> 0x0030, all -> 0x008d }
        goto L_0x0022;
    L_0x0030:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r2 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x0036:
        if (r3 == 0) goto L_0x003d;
    L_0x0038:
        if (r2 == 0) goto L_0x0075;
    L_0x003a:
        r3.close();	 Catch:{ Throwable -> 0x006d, all -> 0x0072 }
    L_0x003d:
        throw r1;	 Catch:{  }
    L_0x003e:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0040 }
    L_0x0040:
        r2 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x0044:
        if (r0 == 0) goto L_0x004b;
    L_0x0046:
        if (r2 == 0) goto L_0x0080;
    L_0x0048:
        r0.close();	 Catch:{ Throwable -> 0x0079, all -> 0x007e }
    L_0x004b:
        throw r1;	 Catch:{  }
    L_0x004c:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x004e }
    L_0x004e:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x0051:
        if (r8 == 0) goto L_0x0058;
    L_0x0053:
        if (r9 == 0) goto L_0x0089;
    L_0x0055:
        r8.close();	 Catch:{ Throwable -> 0x0084 }
    L_0x0058:
        throw r0;
    L_0x0059:
        if (r3 == 0) goto L_0x005e;
    L_0x005b:
        r3.close();	 Catch:{  }
    L_0x005e:
        if (r0 == 0) goto L_0x0063;
    L_0x0060:
        r0.close();	 Catch:{  }
    L_0x0063:
        if (r8 == 0) goto L_0x0068;
    L_0x0065:
        r8.close();
    L_0x0068:
        r0 = r10.m1068b();
        return r0;
    L_0x006d:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x003d;
    L_0x0072:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0044;
    L_0x0075:
        r3.close();	 Catch:{  }
        goto L_0x003d;
    L_0x0079:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x004b;
    L_0x007e:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0080:
        r0.close();	 Catch:{  }
        goto L_0x004b;
    L_0x0084:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x0058;
    L_0x0089:
        r8.close();
        goto L_0x0058;
    L_0x008d:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbMessagesFetcher.a(java.lang.String, java.lang.String[]):com.google.common.collect.ImmutableList<com.facebook.messaging.model.messages.Message>");
    }

    private static Cursor m21935a(SQLiteDatabase sQLiteDatabase) {
        return m21936a(sQLiteDatabase, SqlExpression.m10725a(TincanDbSchemaPart$MessagesTable$Columns.f15409j.f1025d));
    }

    private static Cursor m21937a(SQLiteDatabase sQLiteDatabase, String str) {
        return m21936a(sQLiteDatabase, SqlExpression.m10727a(TincanDbSchemaPart$MessagesTable$Columns.f15408i.f1025d, str));
    }

    private static Cursor m21936a(SQLiteDatabase sQLiteDatabase, Expression expression) {
        return sQLiteDatabase.query("messages", new String[]{TincanDbSchemaPart$MessagesTable$Columns.f15409j.f1025d}, expression.mo1476a(), expression.mo1477b(), null, null, null);
    }

    private Message m21938a(Cursor cursor) {
        String k;
        ThreadKey a;
        MessageType fromDbKeyValue;
        ParticipantInfo participantInfo;
        SendError sendError;
        List b;
        MessageBuilder newBuilder;
        String b2 = TincanDbSchemaPart$MessagesTable$Columns.f15400a.m2093b(cursor);
        String b3 = TincanDbSchemaPart$MessagesTable$Columns.f15401b.m2093b(cursor);
        int d = TincanDbSchemaPart$MessagesTable$Columns.f15407h.m2096d(cursor);
        byte[] e = TincanDbSchemaPart$MessagesTable$Columns.f15402c.m2101e(cursor);
        long c = TincanDbSchemaPart$MessagesTable$Columns.f15404e.m2094c(cursor);
        long c2 = TincanDbSchemaPart$MessagesTable$Columns.f15405f.m2094c(cursor);
        String b4 = TincanDbSchemaPart$MessagesTable$Columns.f15408i.m2093b(cursor);
        CharSequence b5 = TincanDbSchemaPart$MessagesTable$Columns.f15411l.m2093b(cursor);
        long c3 = TincanDbSchemaPart$MessagesTable$Columns.f15410k.m2094c(cursor);
        String valueOf = String.valueOf(TincanDbSchemaPart$MessagesTable$Columns.f15403d.m2094c(cursor));
        CharSequence b6 = TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15381d.m2093b(cursor);
        if (StringUtil.m3599c(b6)) {
            User user = (User) this.f15397h.get();
            if (user.m5840d().equals(valueOf)) {
                k = user.m5846k();
                a = ThreadKey.a(b3);
                fromDbKeyValue = MessageType.fromDbKeyValue(d);
                participantInfo = new ParticipantInfo(UserKey.m5862b(valueOf), k);
                if (fromDbKeyValue == MessageType.REGULAR) {
                    this.f15396g.m21812a(c);
                }
                e = m21943a(a, e);
                sendError = SendError.a;
                if (!StringUtil.m3599c(b5)) {
                    long c4 = TincanDbSchemaPart$MessagesTable$Columns.f15413n.m2094c(cursor);
                    sendError = new SendErrorBuilder().a(SendErrorType.fromSerializedString(b5)).a(c4).a(TincanDbSchemaPart$MessagesTable$Columns.f15412m.m2093b(cursor)).f();
                }
                b = m21946b(cursor);
                newBuilder = Message.newBuilder();
                newBuilder.a(b2);
                newBuilder.a(a);
                newBuilder.a(fromDbKeyValue);
                newBuilder.a(participantInfo);
                newBuilder.a(c);
                newBuilder.b(c2);
                newBuilder.d(b4);
                newBuilder.a(sendError);
                newBuilder.d(b);
                newBuilder.a(Long.valueOf(c3));
                m21942a(newBuilder, b2, e);
                return newBuilder.R();
            }
        }
        CharSequence charSequence = b6;
        a = ThreadKey.a(b3);
        fromDbKeyValue = MessageType.fromDbKeyValue(d);
        participantInfo = new ParticipantInfo(UserKey.m5862b(valueOf), k);
        if (fromDbKeyValue == MessageType.REGULAR) {
            this.f15396g.m21812a(c);
        }
        e = m21943a(a, e);
        sendError = SendError.a;
        if (StringUtil.m3599c(b5)) {
            long c42 = TincanDbSchemaPart$MessagesTable$Columns.f15413n.m2094c(cursor);
            sendError = new SendErrorBuilder().a(SendErrorType.fromSerializedString(b5)).a(c42).a(TincanDbSchemaPart$MessagesTable$Columns.f15412m.m2093b(cursor)).f();
        }
        b = m21946b(cursor);
        newBuilder = Message.newBuilder();
        newBuilder.a(b2);
        newBuilder.a(a);
        newBuilder.a(fromDbKeyValue);
        newBuilder.a(participantInfo);
        newBuilder.a(c);
        newBuilder.b(c2);
        newBuilder.d(b4);
        newBuilder.a(sendError);
        newBuilder.d(b);
        newBuilder.a(Long.valueOf(c3));
        m21942a(newBuilder, b2, e);
        return newBuilder.R();
    }

    private List<MediaResource> m21946b(Cursor cursor) {
        String b = TincanDbSchemaPart$MessagesTable$Columns.f15409j.m2093b(cursor);
        if (Strings.isNullOrEmpty(b)) {
            return new ArrayList();
        }
        return this.f15392c.m21928a(b);
    }

    private byte[] m21943a(ThreadKey threadKey, byte[] bArr) {
        Throwable e;
        byte[] a = ((ThreadEncryptionKeyCache) this.f15399j.get()).a(threadKey);
        if (a == null) {
            BLog.b(f15390b, "Thread encryption key is missing");
            throw new RuntimeException();
        }
        try {
            return this.f15398i.m21819b(a, bArr);
        } catch (KeyChainException e2) {
            e = e2;
            BLog.b(f15390b, "Failed to decrypt message content", e);
            throw new RuntimeException(e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            BLog.b(f15390b, "Failed to decrypt message content", e);
            throw new RuntimeException(e);
        } catch (IOException e4) {
            e = e4;
            BLog.b(f15390b, "Failed to decrypt message content", e);
            throw new RuntimeException(e);
        }
    }

    private void m21942a(MessageBuilder messageBuilder, String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                this.f15393d.m21832a(messageBuilder, str, this.f15393d.m21831a(bArr));
            } catch (Throwable e) {
                BLog.b(f15390b, "Retrieved Salamander decoded with invalid body", e);
            }
        }
    }
}
