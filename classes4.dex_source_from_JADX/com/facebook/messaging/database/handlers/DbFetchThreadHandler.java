package com.facebook.messaging.database.handlers;

import android.database.Cursor;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.database.threads.DbMessageCache;
import com.facebook.messaging.database.threads.MessageCursorUtil;
import com.facebook.messaging.database.threads.MessagesDbContract;
import com.facebook.messaging.database.threads.MessagesProviderTable;
import com.facebook.messaging.database.threads.ThreadSummaryCursorUtil;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.database.threads.ThreadsProviderTable;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: m */
public class DbFetchThreadHandler {
    private static final String[] f8787l = new String[]{"msg_id"};
    private static volatile DbFetchThreadHandler f8788m;
    private final Provider<ThreadsDatabaseSupplier> f8789a;
    private final Provider<MessagesProviderTable> f8790b;
    private final Provider<ThreadsProviderTable> f8791c;
    private final Provider<MessagesDbContract> f8792d;
    private final ThreadSummaryCursorUtil f8793e;
    private final MessageCursorUtil f8794f;
    private final Provider<DbFetchThreadUsersHandler> f8795g;
    public final Provider<DbMessageCache> f8796h;
    private final DbClock f8797i;
    private final Provider<Boolean> f8798j;
    private final Provider<Boolean> f8799k;

    private com.facebook.messaging.database.handlers.DbFetchThreadHandler.MessagesQueryResult m9095a(com.facebook.database.sqlite.SqlExpression.Expression r11, @javax.annotation.Nullable java.lang.String r12, int r13) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:12:0x006c in {5, 14, 15, 19, 20, 22, 31, 33, 35, 40, 41, 42, 43, 44, 47, 49, 52} preds:[]
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
        r10 = this;
        r0 = "DbFetchThreadHandler.doMessagesQuery";
        r1 = -499054992; // 0xffffffffe2410670 float:-8.901714E20 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r10.f8789a;	 Catch:{ all -> 0x0078 }
        r0 = r0.get();	 Catch:{ all -> 0x0078 }
        r0 = (com.facebook.messaging.database.threads.ThreadsDatabaseSupplier) r0;	 Catch:{ all -> 0x0078 }
        r7 = r0.a();	 Catch:{ all -> 0x0078 }
        r0 = -1921932364; // 0xffffffff8d71a3b4 float:-7.446091E-31 double:NaN;	 Catch:{ all -> 0x0078 }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r7, r0);	 Catch:{ all -> 0x0078 }
        r8 = com.google.common.collect.Maps.d();	 Catch:{ all -> 0x0070 }
        r9 = com.google.common.collect.Sets.a();	 Catch:{ all -> 0x0070 }
        r0 = r10.f8792d;	 Catch:{ all -> 0x0070 }
        r0 = r0.get();	 Catch:{ all -> 0x0070 }
        r0 = (com.facebook.messaging.database.threads.MessagesDbContract) r0;	 Catch:{ all -> 0x0070 }
        r0 = r0.d;	 Catch:{ all -> 0x0070 }
        r1 = r0.a();	 Catch:{ all -> 0x0070 }
        r3 = r11.a();	 Catch:{ all -> 0x0070 }
        r4 = r11.b();	 Catch:{ all -> 0x0070 }
        r0 = r10.f8790b;	 Catch:{ all -> 0x0070 }
        r0 = r0.get();	 Catch:{ all -> 0x0070 }
        r0 = (com.facebook.messaging.database.threads.MessagesProviderTable) r0;	 Catch:{ all -> 0x0070 }
        r2 = f8787l;	 Catch:{ all -> 0x0070 }
        r6 = java.lang.Integer.toString(r13);	 Catch:{ all -> 0x0070 }
        r5 = r12;	 Catch:{ all -> 0x0070 }
        r2 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x0070 }
    L_0x004b:
        r0 = r2.moveToNext();	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0080;	 Catch:{ all -> 0x006b }
    L_0x0051:
        r0 = 0;
        r3 = r2.getString(r0);	 Catch:{ all -> 0x006b }
        r0 = r10.f8796h;	 Catch:{ all -> 0x006b }
        r0 = r0.get();	 Catch:{ all -> 0x006b }
        r0 = (com.facebook.messaging.database.threads.DbMessageCache) r0;	 Catch:{ all -> 0x006b }
        r0 = r0.a(r3);	 Catch:{ all -> 0x006b }
        r8.put(r3, r0);	 Catch:{ all -> 0x006b }
        if (r0 != 0) goto L_0x004b;	 Catch:{ all -> 0x006b }
    L_0x0067:
        r9.add(r3);	 Catch:{ all -> 0x006b }
        goto L_0x004b;
    L_0x006b:
        r0 = move-exception;
        r2.close();	 Catch:{ all -> 0x006b }
        throw r0;	 Catch:{ all -> 0x006b }
    L_0x0070:
        r0 = move-exception;
        r1 = -644020720; // 0xffffffffd99d0610 float:-5.5247796E15 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r7, r1);	 Catch:{ all -> 0x0070 }
        throw r0;	 Catch:{ all -> 0x0070 }
    L_0x0078:
        r0 = move-exception;
        r1 = 426258638; // 0x196830ce float:1.2003975E-23 double:2.105997493E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x0080:
        r2.close();
        r0 = r9.isEmpty();	 Catch:{  }
        if (r0 != 0) goto L_0x00cb;	 Catch:{  }
    L_0x0089:
        r0 = "msg_id";	 Catch:{  }
        r4 = com.facebook.database.sqlite.SqlExpression.a(r0, r9);	 Catch:{  }
        r6 = r10.f8794f;	 Catch:{  }
        r0 = r10.f8790b;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.MessagesProviderTable) r0;	 Catch:{  }
        r2 = com.facebook.messaging.database.threads.MessageCursorUtil.f8813a;	 Catch:{  }
        r3 = r4.a();	 Catch:{  }
        r4 = r4.b();	 Catch:{  }
        r5 = 0;	 Catch:{  }
        r0 = r0.a(r1, r2, r3, r4, r5);	 Catch:{  }
        r1 = r6.m9145a(r0);	 Catch:{  }
    L_0x00ac:
        r2 = r1.a();	 Catch:{ all -> 0x00c3 }
        if (r2 == 0) goto L_0x00c8;	 Catch:{ all -> 0x00c3 }
    L_0x00b2:
        r0 = r2.a;	 Catch:{ all -> 0x00c3 }
        r8.put(r0, r2);	 Catch:{ all -> 0x00c3 }
        r0 = r10.f8796h;	 Catch:{ all -> 0x00c3 }
        r0 = r0.get();	 Catch:{ all -> 0x00c3 }
        r0 = (com.facebook.messaging.database.threads.DbMessageCache) r0;	 Catch:{ all -> 0x00c3 }
        r0.a(r2);	 Catch:{ all -> 0x00c3 }
        goto L_0x00ac;
    L_0x00c3:
        r0 = move-exception;
        r1.b();	 Catch:{ all -> 0x00c3 }
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x00c8:
        r1.b();
    L_0x00cb:
        r7.setTransactionSuccessful();	 Catch:{ all -> 0x00c3 }
        r0 = new com.facebook.messaging.database.handlers.DbFetchThreadHandler$MessagesQueryResult;	 Catch:{ all -> 0x00c3 }
        r1 = 0;	 Catch:{ all -> 0x00c3 }
        r0.<init>(r8);	 Catch:{ all -> 0x00c3 }
        r1 = -1330089706; // 0xffffffffb0b87116 float:-1.3419903E-9 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r7, r1);	 Catch:{  }
        r1 = -924699887; // 0xffffffffc8e23311 float:-463256.53 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadHandler.a(com.facebook.database.sqlite.SqlExpression$Expression, java.lang.String, int):com.facebook.messaging.database.handlers.DbFetchThreadHandler$MessagesQueryResult");
    }

    private com.facebook.messaging.database.handlers.DbFetchThreadHandler.ThreadSummaryResult m9096a(com.facebook.messaging.model.threadkey.ThreadKey r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:13:0x0058 in {15, 16, 20, 22, 38, 40, 44, 45, 46, 49, 53} preds:[]
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
        r10 = this;
        r6 = 0;
        r0 = "DbFetchThreadHandler.doThreadQuery";
        r1 = 96634814; // 0x5c287be float:1.8293536E-35 double:4.7743942E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = "#threads";	 Catch:{ all -> 0x0064 }
        r1 = -1930373575; // 0xffffffff8cf0d639 float:-3.7106786E-31 double:NaN;	 Catch:{ all -> 0x0064 }
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);	 Catch:{ all -> 0x0064 }
        r0 = r10.f8791c;	 Catch:{ all -> 0x005c }
        r0 = r0.get();	 Catch:{ all -> 0x005c }
        r0 = (com.facebook.messaging.database.threads.ThreadsProviderTable) r0;	 Catch:{ all -> 0x005c }
        r1 = r10.f8792d;	 Catch:{ all -> 0x005c }
        r1 = r1.get();	 Catch:{ all -> 0x005c }
        r1 = (com.facebook.messaging.database.threads.MessagesDbContract) r1;	 Catch:{ all -> 0x005c }
        r1 = r1.c;	 Catch:{ all -> 0x005c }
        r1 = r1.a();	 Catch:{ all -> 0x005c }
        r2 = com.facebook.messaging.database.threads.ThreadSummaryCursorUtil.f8800a;	 Catch:{ all -> 0x005c }
        r3 = "thread_key=?";	 Catch:{ all -> 0x005c }
        r4 = 1;	 Catch:{ all -> 0x005c }
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x005c }
        r5 = 0;	 Catch:{ all -> 0x005c }
        r7 = r11.g();	 Catch:{ all -> 0x005c }
        r4[r5] = r7;	 Catch:{ all -> 0x005c }
        r5 = 0;	 Catch:{ all -> 0x005c }
        r0 = r0.a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005c }
        r1 = r10.f8793e;	 Catch:{ all -> 0x005c }
        r1 = r1.m9114a(r0);	 Catch:{ all -> 0x005c }
        r7 = r1.c();	 Catch:{ all -> 0x0057 }
        r0.close();
        r0 = -1928136153; // 0xffffffff8d12fa27 float:-4.5290833E-31 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);	 Catch:{  }
        if (r7 != 0) goto L_0x006c;
    L_0x004f:
        r0 = 1520797331; // 0x5aa58693 float:2.32956685E16 double:7.513737155E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r6;
    L_0x0056:
        return r0;
    L_0x0057:
        r1 = move-exception;
        r0.close();	 Catch:{ all -> 0x0057 }
        throw r1;	 Catch:{ all -> 0x0057 }
    L_0x005c:
        r0 = move-exception;
        r1 = 1142329100; // 0x44168f0c float:602.2351 double:5.643855646E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{ all -> 0x005c }
        throw r0;	 Catch:{ all -> 0x005c }
    L_0x0064:
        r0 = move-exception;
        r1 = -97746323; // 0xfffffffffa2c826d float:-2.239301E35 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x006c:
        r0 = "#messages";	 Catch:{  }
        r1 = 196672444; // 0xbb8fbbc float:7.125299E-32 double:9.7169098E-316;	 Catch:{  }
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);	 Catch:{  }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0108 }
        r2 = 3;	 Catch:{ all -> 0x0108 }
        r2 = new com.facebook.database.sqlite.SqlExpression.Expression[r2];	 Catch:{ all -> 0x0108 }
        r3 = 0;	 Catch:{ all -> 0x0108 }
        r4 = "thread_key";	 Catch:{ all -> 0x0108 }
        r5 = r11.g();	 Catch:{ all -> 0x0108 }
        r4 = com.facebook.database.sqlite.SqlExpression.a(r4, r5);	 Catch:{ all -> 0x0108 }
        r2[r3] = r4;	 Catch:{ all -> 0x0108 }
        r3 = 1;	 Catch:{ all -> 0x0108 }
        r4 = "msg_type";	 Catch:{ all -> 0x0108 }
        r5 = com.facebook.messaging.model.messages.MessageType.FAILED_SEND;	 Catch:{ all -> 0x0108 }
        r5 = r5.dbKeyValue;	 Catch:{ all -> 0x0108 }
        r5 = java.lang.Integer.toString(r5);	 Catch:{ all -> 0x0108 }
        r4 = com.facebook.database.sqlite.SqlExpression.a(r4, r5);	 Catch:{ all -> 0x0108 }
        r2[r3] = r4;	 Catch:{ all -> 0x0108 }
        r3 = 2;	 Catch:{ all -> 0x0108 }
        r4 = "timestamp_ms";	 Catch:{ all -> 0x0108 }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ all -> 0x0108 }
        r0 = r0 - r8;	 Catch:{ all -> 0x0108 }
        r0 = java.lang.Long.toString(r0);	 Catch:{ all -> 0x0108 }
        r0 = com.facebook.database.sqlite.SqlExpression.e(r4, r0);	 Catch:{ all -> 0x0108 }
        r2[r3] = r0;	 Catch:{ all -> 0x0108 }
        r4 = com.facebook.database.sqlite.SqlExpression.a(r2);	 Catch:{ all -> 0x0108 }
        r0 = r10.f8790b;	 Catch:{ all -> 0x0108 }
        r0 = r0.get();	 Catch:{ all -> 0x0108 }
        r0 = (com.facebook.messaging.database.threads.MessagesProviderTable) r0;	 Catch:{ all -> 0x0108 }
        r1 = r10.f8792d;	 Catch:{ all -> 0x0108 }
        r1 = r1.get();	 Catch:{ all -> 0x0108 }
        r1 = (com.facebook.messaging.database.threads.MessagesDbContract) r1;	 Catch:{ all -> 0x0108 }
        r1 = r1.d;	 Catch:{ all -> 0x0108 }
        r1 = r1.a();	 Catch:{ all -> 0x0108 }
        r2 = 1;	 Catch:{ all -> 0x0108 }
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x0108 }
        r3 = 0;	 Catch:{ all -> 0x0108 }
        r5 = "thread_key";	 Catch:{ all -> 0x0108 }
        r2[r3] = r5;	 Catch:{ all -> 0x0108 }
        r3 = r4.a();	 Catch:{ all -> 0x0108 }
        r4 = r4.b();	 Catch:{ all -> 0x0108 }
        r5 = 0;	 Catch:{ all -> 0x0108 }
        r1 = r0.a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0108 }
        r0 = r1.moveToNext();	 Catch:{ all -> 0x0103 }
        if (r0 == 0) goto L_0x00e5;	 Catch:{ all -> 0x0103 }
    L_0x00df:
        r0 = r7.a;	 Catch:{ all -> 0x0103 }
        r2 = 1;	 Catch:{ all -> 0x0103 }
        r0.c(r2);	 Catch:{ all -> 0x0103 }
    L_0x00e5:
        r1.close();
        r0 = -1177160445; // 0xffffffffb9d5f503 float:-4.0809074E-4 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);	 Catch:{  }
        r0 = new com.facebook.messaging.database.handlers.DbFetchThreadHandler$ThreadSummaryResult;	 Catch:{  }
        r1 = r7.a;	 Catch:{  }
        r1 = r1.V();	 Catch:{  }
        r2 = r7.b;	 Catch:{  }
        r0.<init>(r1, r2);	 Catch:{  }
        r1 = -1828470374; // 0xffffffff9303c19a float:-1.6629978E-27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0056;
    L_0x0103:
        r0 = move-exception;
        r1.close();	 Catch:{ all -> 0x0103 }
        throw r0;	 Catch:{ all -> 0x0103 }
    L_0x0108:
        r0 = move-exception;
        r1 = 233560905; // 0xdebdb49 float:1.4535784E-30 double:1.153944194E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);	 Catch:{ all -> 0x0108 }
        throw r0;	 Catch:{ all -> 0x0108 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadHandler.a(com.facebook.messaging.model.threadkey.ThreadKey):com.facebook.messaging.database.handlers.DbFetchThreadHandler$ThreadSummaryResult");
    }

    public static com.facebook.messaging.database.handlers.DbFetchThreadHandler m9097a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8788m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.handlers.DbFetchThreadHandler.class;
        monitor-enter(r1);
        r0 = f8788m;	 Catch:{ all -> 0x003a }
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
        r0 = m9099b(r0);	 Catch:{ all -> 0x0035 }
        f8788m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8788m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbFetchThreadHandler");
    }

    private static DbFetchThreadHandler m9099b(InjectorLike injectorLike) {
        return new DbFetchThreadHandler(IdBasedProvider.a(injectorLike, 7811), IdBasedProvider.a(injectorLike, 7819), IdBasedProvider.a(injectorLike, 7810), ThreadSummaryCursorUtil.m9112a(injectorLike), MessageCursorUtil.m9136a(injectorLike), IdBasedProvider.a(injectorLike, 7815), IdBasedSingletonScopeProvider.a(injectorLike, 2598), IdBasedProvider.a(injectorLike, 7804), DbClock.m9116a(injectorLike), IdBasedProvider.a(injectorLike, 4084), IdBasedProvider.a(injectorLike, 4054));
    }

    @Inject
    DbFetchThreadHandler(Provider<MessagesProviderTable> provider, Provider<ThreadsProviderTable> provider2, Provider<MessagesDbContract> provider3, ThreadSummaryCursorUtil threadSummaryCursorUtil, MessageCursorUtil messageCursorUtil, Provider<ThreadsDatabaseSupplier> provider4, Provider<DbFetchThreadUsersHandler> provider5, Provider<DbMessageCache> provider6, DbClock dbClock, Provider<Boolean> provider7, Provider<Boolean> provider8) {
        this.f8790b = provider;
        this.f8791c = provider2;
        this.f8792d = provider3;
        this.f8793e = threadSummaryCursorUtil;
        this.f8794f = messageCursorUtil;
        this.f8789a = provider4;
        this.f8795g = provider5;
        this.f8796h = provider6;
        this.f8797i = dbClock;
        this.f8798j = provider7;
        this.f8799k = provider8;
    }

    public final FetchThreadResult m9105a(ThreadKey threadKey, int i) {
        TracerDetour.a("DbFetchThreadHandler.fetchThreadFromDb", 1312418721);
        try {
            FetchThreadResult fetchThreadResult;
            ThreadSummaryResult a = m9096a(threadKey);
            if (a == null) {
                fetchThreadResult = FetchThreadResult.a;
            } else {
                int i2;
                DataFetchDisposition dataFetchDisposition;
                boolean z;
                ThreadSummary threadSummary = a.a;
                LinkedHashMap b = m9101b(threadKey, -1, -1, i);
                Collection a2 = Sets.a();
                ImmutableList immutableList = threadSummary.h;
                int size = immutableList.size();
                for (i2 = 0; i2 < size; i2++) {
                    a2.add(((ThreadParticipant) immutableList.get(i2)).b());
                }
                immutableList = threadSummary.i;
                size = immutableList.size();
                for (i2 = 0; i2 < size; i2++) {
                    a2.add(((ThreadParticipant) immutableList.get(i2)).b());
                }
                immutableList = threadSummary.j;
                size = immutableList.size();
                for (i2 = 0; i2 < size; i2++) {
                    a2.add(((ThreadParticipant) immutableList.get(i2)).b());
                }
                immutableList = threadSummary.o;
                size = immutableList.size();
                for (i2 = 0; i2 < size; i2++) {
                    a2.add(((ParticipantInfo) immutableList.get(i2)).b);
                }
                ImmutableList a3 = ((DbFetchThreadUsersHandler) this.f8795g.get()).a(a2);
                if (threadSummary.f == 0) {
                    dataFetchDisposition = DataFetchDisposition.e;
                } else {
                    long j;
                    for (Message message : b.values()) {
                        if (!message.o) {
                            j = message.g;
                            break;
                        }
                    }
                    j = -1;
                    dataFetchDisposition = j == threadSummary.f ? DataFetchDisposition.e : DataFetchDisposition.f;
                }
                if (b.containsKey(threadSummary.a.g())) {
                    z = true;
                    b.remove(threadSummary.a.g());
                } else {
                    z = false;
                }
                MessagesCollection messagesCollection = new MessagesCollection(threadSummary.a, ImmutableList.copyOf(b.values()), z);
                ImmutableList b2 = messagesCollection.b();
                if (b2.size() > 0) {
                    this.f8797i.m9119a(((Message) b2.get(0)).c);
                }
                fetchThreadResult = FetchThreadResult.b().a(dataFetchDisposition).a(threadSummary).a(messagesCollection).a(a3).a(a.b).a();
                TracerDetour.a(1376143744);
            }
            return fetchThreadResult;
        } finally {
            TracerDetour.a(-1751619937);
        }
    }

    public final FetchThreadResult m9106a(ThreadCriteria threadCriteria, int i) {
        ThreadKey a = m9098a(threadCriteria);
        if (a == null) {
            return FetchThreadResult.a;
        }
        return m9105a(a, i);
    }

    private ThreadKey m9098a(ThreadCriteria threadCriteria) {
        if (threadCriteria.a() != null) {
            return threadCriteria.a();
        }
        if (threadCriteria.a != null) {
            return m9103a(threadCriteria.a);
        }
        throw new IllegalArgumentException("No threadid or userkey specified.");
    }

    final ThreadKey m9103a(String str) {
        ThreadKey threadKey = null;
        Cursor a = ((ThreadsProviderTable) this.f8791c.get()).a(((MessagesDbContract) this.f8792d.get()).c.a(), new String[]{"thread_key"}, "legacy_thread_id=?", new String[]{str}, null);
        try {
            if (a.moveToNext()) {
                threadKey = ThreadKey.a(a.getString(0));
            }
            a.close();
            return threadKey;
        } catch (Throwable th) {
            a.close();
        }
    }

    final FetchMoreMessagesResult m9104a(ThreadKey threadKey, long j, long j2, int i) {
        LinkedHashMap b = m9101b(threadKey, j, j2, i);
        boolean z = false;
        if (b.containsKey(threadKey.g())) {
            z = true;
            b.remove(threadKey.g());
        }
        return new FetchMoreMessagesResult(DataFetchDisposition.e, new MessagesCollection(threadKey, ImmutableList.copyOf(b.values()), z), -1);
    }

    private Message m9100b(long j) {
        LinkedHashMap linkedHashMap = m9095a(SqlExpression.a("action_id", Long.toString(j)), null, 1).a;
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        return (Message) linkedHashMap.values().iterator().next();
    }

    public final Message m9110b(String str) {
        Message a = ((DbMessageCache) this.f8796h.get()).a(str);
        return a != null ? a : (Message) m9095a(SqlExpression.a("msg_id", str), null, 1).a.get(str);
    }

    public final Map<String, Message> m9108a(Collection<String> collection, Collection<String> collection2) {
        if (collection.isEmpty() && collection2.isEmpty()) {
            return RegularImmutableBiMap.a;
        }
        return m9095a(SqlExpression.b(new Expression[]{SqlExpression.a("msg_id", collection), SqlExpression.a("offline_threading_id", collection2)}), null, collection.size() + collection2.size()).a;
    }

    public final Message m9111c(String str) {
        LinkedHashMap linkedHashMap = m9095a(SqlExpression.a("offline_threading_id", str), null, 1).a;
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        return (Message) linkedHashMap.values().iterator().next();
    }

    private LinkedHashMap<String, Message> m9101b(@Nullable ThreadKey threadKey, long j, long j2, int i) {
        TracerDetour.a("DbFetchThreadHandler.doMessagesQuery", 171371676);
        try {
            ConjunctionExpression a = SqlExpression.a();
            if (threadKey != null) {
                a.a(SqlExpression.a("thread_key", threadKey.g()));
            }
            if (j != -1) {
                a.a(SqlExpression.f("timestamp_ms", Long.toString(j)));
            }
            if (j2 != -1) {
                a.a(SqlExpression.c("timestamp_ms", Long.toString(j2)));
            }
            LinkedHashMap<String, Message> linkedHashMap = m9095a(a, "timestamp_ms DESC", i).a;
            return linkedHashMap;
        } finally {
            TracerDetour.a(1029337896);
        }
    }

    private long m9102c(long j) {
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.f("last_visible_action_id", Long.toString(j)));
        Cursor a2 = ((ThreadsProviderTable) this.f8791c.get()).a(((MessagesDbContract) this.f8792d.get()).c.a(), new String[]{"last_visible_action_id"}, a.a(), a.b(), "last_visible_action_id DESC");
        try {
            if (a2.moveToNext()) {
                long j2 = a2.getLong(0);
                return j2;
            }
            a2.close();
            return -1;
        } finally {
            a2.close();
        }
    }

    public final boolean m9109a(long j) {
        if (j == -1 || j == 0) {
            return false;
        }
        if (m9102c(j) != j) {
            return false;
        }
        Message b = m9100b(j);
        return (((Boolean) this.f8798j.get()).booleanValue() && ((Boolean) this.f8799k.get()).booleanValue()) ? b != null : (b == null || b.o) ? false : true;
    }

    public final LinkedHashMap<String, Message> m9107a(long j, int i) {
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.a("msg_type", Integer.toString(MessageType.PENDING_SEND.dbKeyValue)));
        if (j != -1) {
            a.a(SqlExpression.c("timestamp_ms", Long.toString(j)));
        }
        return m9095a(a, "timestamp_ms", i).a;
    }
}
