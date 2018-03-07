package com.facebook.messaging.tincan.database;

import android.database.Cursor;
import android.util.Pair;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.serialization.DbDraftSerialization;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.FetchThreadResult.Builder;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mTarget= */
public class TincanDbThreadsFetcher {
    static final String[] f15354a = new String[]{TincanDbSchemaPart$ThreadsTable$Columns.f15363a.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15365c.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15366d.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15367e.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15376n.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15375m.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15374l.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15369g.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15370h.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15371i.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15372j.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15373k.f1025d, TincanDbSchemaPart$ThreadsTable$Columns.f15364b.f1025d, TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15379b.f1025d, TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15380c.f1025d, TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15381d.f1025d, TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15382e.f1025d};
    private static volatile TincanDbThreadsFetcher f15355i;
    private final SystemClock f15356b;
    private final Provider<User> f15357c;
    private final Provider<TincanDatabaseSupplier> f15358d;
    private final DbDraftSerialization f15359e;
    private final TincanDbMessagesFetcher f15360f;
    private final TincanDbUserConverter f15361g;
    private final ThriftUtil f15362h;

    public static com.facebook.messaging.tincan.database.TincanDbThreadsFetcher m21906a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15355i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.class;
        monitor-enter(r1);
        r0 = f15355i;	 Catch:{ all -> 0x003a }
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
        r0 = m21907b(r0);	 Catch:{ all -> 0x0035 }
        f15355i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15355i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.TincanDbThreadsFetcher");
    }

    private static TincanDbThreadsFetcher m21907b(InjectorLike injectorLike) {
        return new TincanDbThreadsFetcher(SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), IdBasedProvider.m1811a(injectorLike, 8567), DbDraftSerialization.m21918b(injectorLike), TincanDbMessagesFetcher.m21940a(injectorLike), TincanDbUserConverter.m21957a(injectorLike), ThriftUtil.m21835a(injectorLike));
    }

    @Inject
    TincanDbThreadsFetcher(SystemClock systemClock, Provider<User> provider, Provider<TincanDatabaseSupplier> provider2, DbDraftSerialization dbDraftSerialization, TincanDbMessagesFetcher tincanDbMessagesFetcher, TincanDbUserConverter tincanDbUserConverter, ThriftUtil thriftUtil) {
        this.f15356b = systemClock;
        this.f15357c = provider;
        this.f15358d = provider2;
        this.f15359e = dbDraftSerialization;
        this.f15360f = tincanDbMessagesFetcher;
        this.f15361g = tincanDbUserConverter;
        this.f15362h = thriftUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final com.google.common.collect.ImmutableList<com.facebook.messaging.model.threadkey.ThreadKey> m21912a(long r12) {
        /*
        r11 = this;
        r9 = 0;
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15364b;
        r0 = r0.m2091a();
        r1 = java.lang.String.valueOf(r12);
        r4 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r1);
        r0 = r11.f15358d;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x0076, all -> 0x00a8 }
        r1 = "threads";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r3 = 0;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r5 = r5.m2091a();	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r2[r3] = r5;	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r3 = r4.mo1476a();	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r4 = r4.mo1477b();	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r5 = 0;
        r6 = 0;
        r7 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15366d;	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r7 = r7.m2100e();	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0068, all -> 0x009c }
        r1 = new com.google.common.collect.ImmutableList$Builder;	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        r1.<init>();	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
    L_0x0043:
        r2 = r3.moveToNext();	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        if (r2 == 0) goto L_0x0083;
    L_0x0049:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        r2 = r2.m2093b(r3);	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        r2 = com.facebook.messaging.model.threadkey.ThreadKey.a(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        com.google.common.base.Preconditions.checkNotNull(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        r1.m1069c(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x00b7 }
        goto L_0x0043;
    L_0x005a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0060:
        if (r3 == 0) goto L_0x0067;
    L_0x0062:
        if (r2 == 0) goto L_0x009f;
    L_0x0064:
        r3.close();	 Catch:{ Throwable -> 0x0097, all -> 0x009c }
    L_0x0067:
        throw r1;	 Catch:{  }
    L_0x0068:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x006a }
    L_0x006a:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x006e:
        if (r0 == 0) goto L_0x0075;
    L_0x0070:
        if (r2 == 0) goto L_0x00aa;
    L_0x0072:
        r0.close();	 Catch:{ Throwable -> 0x00a3, all -> 0x00a8 }
    L_0x0075:
        throw r1;	 Catch:{  }
    L_0x0076:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0078 }
    L_0x0078:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x007b:
        if (r8 == 0) goto L_0x0082;
    L_0x007d:
        if (r9 == 0) goto L_0x00b3;
    L_0x007f:
        r8.close();	 Catch:{ Throwable -> 0x00ae }
    L_0x0082:
        throw r0;
    L_0x0083:
        r1 = r1.m1068b();	 Catch:{  }
        if (r3 == 0) goto L_0x008c;
    L_0x0089:
        r3.close();	 Catch:{  }
    L_0x008c:
        if (r0 == 0) goto L_0x0091;
    L_0x008e:
        r0.close();	 Catch:{  }
    L_0x0091:
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r8.close();
    L_0x0096:
        return r1;
    L_0x0097:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0067;
    L_0x009c:
        r1 = move-exception;
        r2 = r9;
        goto L_0x006e;
    L_0x009f:
        r3.close();	 Catch:{  }
        goto L_0x0067;
    L_0x00a3:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x0075;
    L_0x00a8:
        r0 = move-exception;
        goto L_0x007b;
    L_0x00aa:
        r0.close();	 Catch:{  }
        goto L_0x0075;
    L_0x00ae:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x0082;
    L_0x00b3:
        r8.close();
        goto L_0x0082;
    L_0x00b7:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.a(long):com.google.common.collect.ImmutableList<com.facebook.messaging.model.threadkey.ThreadKey>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final com.google.common.collect.ImmutableList<com.facebook.messaging.model.threads.ThreadSummary> m21913a(java.lang.String r15) {
        /*
        r14 = this;
        r4 = m21909c(r15);
        r12 = new com.google.common.collect.ImmutableList$Builder;
        r12.<init>();
        r0 = r14.f15358d;
        r0 = r0.get();
        r9 = r0;
        r9 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r9;
        r11 = 0;
        r0 = r9.k();	 Catch:{ Throwable -> 0x0093, all -> 0x00fa }
        r10 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = "threads LEFT JOIN thread_participants ON ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15364b;	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = r2.m2091a();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = " = ";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a;	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = r2.m2091a();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r3 = 0;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r5 = r5.m2091a();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2[r3] = r5;	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r3 = r4.mo1476a();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r4 = r4.mo1477b();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r5 = 0;
        r6 = 0;
        r7 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15366d;	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r7 = r7.m2100e();	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r8 = "5";
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0085, all -> 0x00ee }
        r2 = 0;
    L_0x0060:
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x0077, all -> 0x0111 }
        if (r1 == 0) goto L_0x00a1;
    L_0x0066:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x0077, all -> 0x0111 }
        r1 = r1.m2093b(r3);	 Catch:{ Throwable -> 0x0077, all -> 0x0111 }
        r1 = com.facebook.messaging.model.threadkey.ThreadKey.a(r1);	 Catch:{ Throwable -> 0x0077, all -> 0x0111 }
        com.google.common.base.Preconditions.checkNotNull(r1);	 Catch:{ Throwable -> 0x0077, all -> 0x0111 }
        r12.m1069c(r1);	 Catch:{ Throwable -> 0x0077, all -> 0x0111 }
        goto L_0x0060;
    L_0x0077:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0079 }
    L_0x0079:
        r2 = move-exception;
        r13 = r2;
        r2 = r1;
        r1 = r13;
    L_0x007d:
        if (r3 == 0) goto L_0x0084;
    L_0x007f:
        if (r2 == 0) goto L_0x00f1;
    L_0x0081:
        r3.close();	 Catch:{ Throwable -> 0x00e9, all -> 0x00ee }
    L_0x0084:
        throw r1;	 Catch:{  }
    L_0x0085:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0087 }
    L_0x0087:
        r2 = move-exception;
        r13 = r2;
        r2 = r1;
        r1 = r13;
    L_0x008b:
        if (r0 == 0) goto L_0x0092;
    L_0x008d:
        if (r2 == 0) goto L_0x00fd;
    L_0x008f:
        r0.close();	 Catch:{ Throwable -> 0x00f5, all -> 0x00fa }
    L_0x0092:
        throw r1;	 Catch:{  }
    L_0x0093:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0095 }
    L_0x0095:
        r1 = move-exception;
        r13 = r1;
        r1 = r0;
        r0 = r13;
    L_0x0099:
        if (r9 == 0) goto L_0x00a0;
    L_0x009b:
        if (r1 == 0) goto L_0x0106;
    L_0x009d:
        r9.close();	 Catch:{ Throwable -> 0x0101 }
    L_0x00a0:
        throw r0;
    L_0x00a1:
        if (r3 == 0) goto L_0x00a6;
    L_0x00a3:
        r3.close();	 Catch:{  }
    L_0x00a6:
        if (r0 == 0) goto L_0x00ab;
    L_0x00a8:
        r0.close();	 Catch:{  }
    L_0x00ab:
        if (r9 == 0) goto L_0x00b0;
    L_0x00ad:
        r9.close();
    L_0x00b0:
        r3 = r12.m1068b();
        r4 = new com.google.common.collect.ImmutableList$Builder;
        r4.<init>();
        r5 = r3.size();
        r0 = 0;
        r2 = r0;
    L_0x00bf:
        if (r2 >= r5) goto L_0x010c;
    L_0x00c1:
        r0 = r3.get(r2);
        r0 = (com.facebook.messaging.model.threadkey.ThreadKey) r0;
        r6 = -1;
        r1 = -1;
        r0 = r14.m21903a(r0, r6, r1);
        r0 = r0.first;
        r0 = (com.facebook.messaging.model.threads.ThreadsCollection) r0;
        r1 = r0.e();
        r6 = 1;
        if (r1 != r6) goto L_0x010a;
    L_0x00d9:
        r1 = 1;
    L_0x00da:
        com.google.common.base.Preconditions.checkState(r1);
        r1 = 0;
        r0 = r0.a(r1);
        r4.m1069c(r0);
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x00bf;
    L_0x00e9:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0084;
    L_0x00ee:
        r1 = move-exception;
        r2 = r10;
        goto L_0x008b;
    L_0x00f1:
        r3.close();	 Catch:{  }
        goto L_0x0084;
    L_0x00f5:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x0092;
    L_0x00fa:
        r0 = move-exception;
        r1 = r11;
        goto L_0x0099;
    L_0x00fd:
        r0.close();	 Catch:{  }
        goto L_0x0092;
    L_0x0101:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x00a0;
    L_0x0106:
        r9.close();
        goto L_0x00a0;
    L_0x010a:
        r1 = 0;
        goto L_0x00da;
    L_0x010c:
        r0 = r4.m1068b();
        return r0;
    L_0x0111:
        r1 = move-exception;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.a(java.lang.String):com.google.common.collect.ImmutableList<com.facebook.messaging.model.threads.ThreadSummary>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    @javax.annotation.Nullable
    public final com.facebook.messaging.model.threadkey.ThreadKey m21910a(byte[] r12) {
        /*
        r11 = this;
        r9 = 0;
        r0 = r11.f15358d;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x007d, all -> 0x009b }
        r1 = "threads";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r3 = 0;
        r4 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r4 = r4.m2091a();	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x006f, all -> 0x008f }
    L_0x0025:
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x0061, all -> 0x00aa }
        if (r1 == 0) goto L_0x0050;
    L_0x002b:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;	 Catch:{ Throwable -> 0x0061, all -> 0x00aa }
        r1 = r1.m2093b(r3);	 Catch:{ Throwable -> 0x0061, all -> 0x00aa }
        r1 = com.facebook.messaging.model.threadkey.ThreadKey.a(r1);	 Catch:{ Throwable -> 0x0061, all -> 0x00aa }
        r2 = r11.m21908b(r1);	 Catch:{ Throwable -> 0x0061, all -> 0x00aa }
        r2 = java.util.Arrays.equals(r12, r2);	 Catch:{ Throwable -> 0x0061, all -> 0x00aa }
        if (r2 == 0) goto L_0x0025;
    L_0x003f:
        if (r3 == 0) goto L_0x0044;
    L_0x0041:
        r3.close();	 Catch:{  }
    L_0x0044:
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.close();	 Catch:{  }
    L_0x0049:
        if (r8 == 0) goto L_0x004e;
    L_0x004b:
        r8.close();
    L_0x004e:
        r0 = r1;
    L_0x004f:
        return r0;
    L_0x0050:
        if (r3 == 0) goto L_0x0055;
    L_0x0052:
        r3.close();	 Catch:{  }
    L_0x0055:
        if (r0 == 0) goto L_0x005a;
    L_0x0057:
        r0.close();	 Catch:{  }
    L_0x005a:
        if (r8 == 0) goto L_0x005f;
    L_0x005c:
        r8.close();
    L_0x005f:
        r0 = r9;
        goto L_0x004f;
    L_0x0061:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0063 }
    L_0x0063:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0067:
        if (r3 == 0) goto L_0x006e;
    L_0x0069:
        if (r2 == 0) goto L_0x0092;
    L_0x006b:
        r3.close();	 Catch:{ Throwable -> 0x008a, all -> 0x008f }
    L_0x006e:
        throw r1;	 Catch:{  }
    L_0x006f:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x0075:
        if (r0 == 0) goto L_0x007c;
    L_0x0077:
        if (r2 == 0) goto L_0x009d;
    L_0x0079:
        r0.close();	 Catch:{ Throwable -> 0x0096, all -> 0x009b }
    L_0x007c:
        throw r1;	 Catch:{  }
    L_0x007d:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x007f }
    L_0x007f:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x0082:
        if (r8 == 0) goto L_0x0089;
    L_0x0084:
        if (r9 == 0) goto L_0x00a6;
    L_0x0086:
        r8.close();	 Catch:{ Throwable -> 0x00a1 }
    L_0x0089:
        throw r0;
    L_0x008a:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x006e;
    L_0x008f:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0075;
    L_0x0092:
        r3.close();	 Catch:{  }
        goto L_0x006e;
    L_0x0096:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x007c;
    L_0x009b:
        r0 = move-exception;
        goto L_0x0082;
    L_0x009d:
        r0.close();	 Catch:{  }
        goto L_0x007c;
    L_0x00a1:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x0089;
    L_0x00a6:
        r8.close();
        goto L_0x0089;
    L_0x00aa:
        r1 = move-exception;
        r2 = r9;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.a(byte[]):com.facebook.messaging.model.threadkey.ThreadKey");
    }

    private byte[] m21908b(ThreadKey threadKey) {
        if (ThreadKey.h(threadKey)) {
            return m21914a(threadKey.d, null);
        }
        return m21914a(threadKey.d, threadKey.f);
    }

    public final byte[] m21914a(long j, @Nullable String str) {
        byte[] bArr;
        if (str == null) {
            bArr = new byte[0];
        } else {
            bArr = str.getBytes();
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 8);
        allocate.putLong(j);
        allocate.put(bArr);
        return this.f15362h.m21838a(allocate.array());
    }

    public final FetchThreadResult m21911a(ThreadKey threadKey, int i) {
        boolean z = true;
        Pair a = m21903a(threadKey, -1, -1);
        ThreadsCollection threadsCollection = (ThreadsCollection) a.first;
        if (threadsCollection.d()) {
            return FetchThreadResult.a;
        }
        if (threadsCollection.e() != 1) {
            z = false;
        }
        Preconditions.checkState(z);
        ThreadSummary a2 = threadsCollection.a(0);
        MessagesCollection messagesCollection = null;
        if (i > 0) {
            messagesCollection = this.f15360f.m21947a(threadKey, -1, i);
        }
        Builder b = FetchThreadResult.b();
        b.f = this.f15356b.mo211a();
        b.a = DataFetchDisposition.f;
        b.c = messagesCollection;
        b.b = a2;
        b.d = (ImmutableList) a.second;
        return b.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    public final boolean m21916b(java.lang.String r12) {
        /*
        r11 = this;
        r9 = 0;
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a;
        r0 = r0.m2091a();
        r4 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r12);
        r0 = r11.f15358d;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x0062, all -> 0x0080 }
        r1 = "thread_participants";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r3 = 0;
        r5 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a;	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r5 = r5.m2091a();	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r2[r3] = r5;	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r3 = r4.mo1476a();	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r4 = r4.mo1477b();	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0054, all -> 0x0074 }
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x0049, all -> 0x008f }
        if (r3 == 0) goto L_0x003e;
    L_0x003b:
        r3.close();	 Catch:{  }
    L_0x003e:
        if (r0 == 0) goto L_0x0043;
    L_0x0040:
        r0.close();	 Catch:{  }
    L_0x0043:
        if (r8 == 0) goto L_0x0048;
    L_0x0045:
        r8.close();
    L_0x0048:
        return r1;
    L_0x0049:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x004b }
    L_0x004b:
        r1 = move-exception;
    L_0x004c:
        if (r3 == 0) goto L_0x0053;
    L_0x004e:
        if (r2 == 0) goto L_0x0077;
    L_0x0050:
        r3.close();	 Catch:{ Throwable -> 0x006f, all -> 0x0074 }
    L_0x0053:
        throw r1;	 Catch:{  }
    L_0x0054:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0056 }
    L_0x0056:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x005a:
        if (r0 == 0) goto L_0x0061;
    L_0x005c:
        if (r2 == 0) goto L_0x0082;
    L_0x005e:
        r0.close();	 Catch:{ Throwable -> 0x007b, all -> 0x0080 }
    L_0x0061:
        throw r1;	 Catch:{  }
    L_0x0062:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0064 }
    L_0x0064:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x0067:
        if (r8 == 0) goto L_0x006e;
    L_0x0069:
        if (r9 == 0) goto L_0x008b;
    L_0x006b:
        r8.close();	 Catch:{ Throwable -> 0x0086 }
    L_0x006e:
        throw r0;
    L_0x006f:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0053;
    L_0x0074:
        r1 = move-exception;
        r2 = r9;
        goto L_0x005a;
    L_0x0077:
        r3.close();	 Catch:{  }
        goto L_0x0053;
    L_0x007b:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x0061;
    L_0x0080:
        r0 = move-exception;
        goto L_0x0067;
    L_0x0082:
        r0.close();	 Catch:{  }
        goto L_0x0061;
    L_0x0086:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x006e;
    L_0x008b:
        r8.close();
        goto L_0x006e;
    L_0x008f:
        r1 = move-exception;
        r2 = r9;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.b(java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi", "Recycle"})
    @javax.annotation.Nullable
    final byte[] m21915a(com.facebook.messaging.model.threadkey.ThreadKey r13) {
        /*
        r12 = this;
        r9 = 0;
        if (r13 != 0) goto L_0x0005;
    L_0x0003:
        r0 = r9;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = 2;
        r2 = new java.lang.String[r0];
        r0 = 0;
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;
        r1 = r1.m2091a();
        r2[r0] = r1;
        r0 = 1;
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15377o;
        r1 = r1.m2091a();
        r2[r0] = r1;
        r0 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;
        r0 = r0.m2091a();
        r1 = r13.toString();
        r10 = com.facebook.database.sqlite.SqlExpression.m10727a(r0, r1);
        r0 = r12.f15358d;
        r0 = r0.get();
        r8 = r0;
        r8 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r8;
        r0 = r8.k();	 Catch:{ Throwable -> 0x00c3, all -> 0x010a }
        r1 = "threads";
        r3 = r10.mo1476a();	 Catch:{ Throwable -> 0x00b5, all -> 0x00d5 }
        r4 = r10.mo1477b();	 Catch:{ Throwable -> 0x00b5, all -> 0x00d5 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00b5, all -> 0x00d5 }
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x00a7, all -> 0x011c }
        if (r1 == 0) goto L_0x006b;
    L_0x004c:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15377o;	 Catch:{ Throwable -> 0x00a7, all -> 0x011c }
        r1 = r1.m2091a();	 Catch:{ Throwable -> 0x00a7, all -> 0x011c }
        r1 = r3.getColumnIndex(r1);	 Catch:{ Throwable -> 0x00a7, all -> 0x011c }
        r1 = r3.getBlob(r1);	 Catch:{ Throwable -> 0x00a7, all -> 0x011c }
        if (r3 == 0) goto L_0x005f;
    L_0x005c:
        r3.close();	 Catch:{  }
    L_0x005f:
        if (r0 == 0) goto L_0x0064;
    L_0x0061:
        r0.close();	 Catch:{  }
    L_0x0064:
        if (r8 == 0) goto L_0x0069;
    L_0x0066:
        r8.close();
    L_0x0069:
        r0 = r1;
        goto L_0x0004;
    L_0x006b:
        if (r3 == 0) goto L_0x0070;
    L_0x006d:
        r3.close();	 Catch:{  }
    L_0x0070:
        r1 = "pending_sessions";
        r3 = r10.mo1476a();	 Catch:{  }
        r4 = r10.mo1477b();	 Catch:{  }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{  }
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x00ee, all -> 0x0119 }
        if (r1 == 0) goto L_0x00dc;
    L_0x0087:
        r1 = com.facebook.messaging.tincan.database.TincanDbSchemaPart.PendingSessionsTable.Columns.d;	 Catch:{ Throwable -> 0x00ee, all -> 0x0119 }
        r1 = r1.m2091a();	 Catch:{ Throwable -> 0x00ee, all -> 0x0119 }
        r1 = r3.getColumnIndex(r1);	 Catch:{ Throwable -> 0x00ee, all -> 0x0119 }
        r1 = r3.getBlob(r1);	 Catch:{ Throwable -> 0x00ee, all -> 0x0119 }
        if (r3 == 0) goto L_0x009a;
    L_0x0097:
        r3.close();	 Catch:{  }
    L_0x009a:
        if (r0 == 0) goto L_0x009f;
    L_0x009c:
        r0.close();	 Catch:{  }
    L_0x009f:
        if (r8 == 0) goto L_0x00a4;
    L_0x00a1:
        r8.close();
    L_0x00a4:
        r0 = r1;
        goto L_0x0004;
    L_0x00a7:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00a9 }
    L_0x00a9:
        r2 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x00ad:
        if (r3 == 0) goto L_0x00b4;
    L_0x00af:
        if (r2 == 0) goto L_0x00d8;
    L_0x00b1:
        r3.close();	 Catch:{ Throwable -> 0x00d0, all -> 0x00d5 }
    L_0x00b4:
        throw r1;	 Catch:{  }
    L_0x00b5:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00b7 }
    L_0x00b7:
        r2 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x00bb:
        if (r0 == 0) goto L_0x00c2;
    L_0x00bd:
        if (r2 == 0) goto L_0x010c;
    L_0x00bf:
        r0.close();	 Catch:{ Throwable -> 0x0105, all -> 0x010a }
    L_0x00c2:
        throw r1;	 Catch:{  }
    L_0x00c3:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00c5 }
    L_0x00c5:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
    L_0x00c8:
        if (r8 == 0) goto L_0x00cf;
    L_0x00ca:
        if (r9 == 0) goto L_0x0115;
    L_0x00cc:
        r8.close();	 Catch:{ Throwable -> 0x0110 }
    L_0x00cf:
        throw r0;
    L_0x00d0:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x00b4;
    L_0x00d5:
        r1 = move-exception;
        r2 = r9;
        goto L_0x00bb;
    L_0x00d8:
        r3.close();	 Catch:{  }
        goto L_0x00b4;
    L_0x00dc:
        if (r3 == 0) goto L_0x00e1;
    L_0x00de:
        r3.close();	 Catch:{  }
    L_0x00e1:
        if (r0 == 0) goto L_0x00e6;
    L_0x00e3:
        r0.close();	 Catch:{  }
    L_0x00e6:
        if (r8 == 0) goto L_0x00eb;
    L_0x00e8:
        r8.close();
    L_0x00eb:
        r0 = r9;
        goto L_0x0004;
    L_0x00ee:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00f0 }
    L_0x00f0:
        r2 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x00f4:
        if (r3 == 0) goto L_0x00fb;
    L_0x00f6:
        if (r2 == 0) goto L_0x0101;
    L_0x00f8:
        r3.close();	 Catch:{ Throwable -> 0x00fc, all -> 0x00d5 }
    L_0x00fb:
        throw r1;	 Catch:{  }
    L_0x00fc:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x00fb;
    L_0x0101:
        r3.close();	 Catch:{  }
        goto L_0x00fb;
    L_0x0105:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x00c2;
    L_0x010a:
        r0 = move-exception;
        goto L_0x00c8;
    L_0x010c:
        r0.close();	 Catch:{  }
        goto L_0x00c2;
    L_0x0110:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r9, r1);
        goto L_0x00cf;
    L_0x0115:
        r8.close();
        goto L_0x00cf;
    L_0x0119:
        r1 = move-exception;
        r2 = r9;
        goto L_0x00f4;
    L_0x011c:
        r1 = move-exception;
        r2 = r9;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.a(com.facebook.messaging.model.threadkey.ThreadKey):byte[]");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    private android.util.Pair<com.facebook.messaging.model.threads.ThreadsCollection, com.google.common.collect.ImmutableList<com.facebook.user.model.User>> m21903a(@javax.annotation.Nullable com.facebook.messaging.model.threadkey.ThreadKey r15, long r16, int r18) {
        /*
        r14 = this;
        r2 = 0;
        r9 = 0;
        if (r15 == 0) goto L_0x00bd;
    L_0x0004:
        r2 = 0;
        r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x00b7;
    L_0x000a:
        r2 = 1;
    L_0x000b:
        com.google.common.base.Preconditions.checkArgument(r2);
        if (r18 > 0) goto L_0x00ba;
    L_0x0010:
        r2 = 1;
    L_0x0011:
        com.google.common.base.Preconditions.checkArgument(r2);
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15363a;
        r2 = r2.m2091a();
        r3 = 1;
        r3 = new java.lang.String[r3];
        r4 = 0;
        r5 = r15.toString();
        r3[r4] = r5;
        r2 = com.facebook.database.sqlite.SqlExpression.m10729a(r2, r3);
        r6 = r2;
    L_0x0029:
        r2 = new java.lang.StringBuilder;
        r3 = "threads LEFT JOIN thread_participants ON ";
        r2.<init>(r3);
        r3 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15364b;
        r3 = r3.m2091a();
        r2 = r2.append(r3);
        r3 = " = ";
        r2 = r2.append(r3);
        r3 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15378a;
        r3 = r3.m2091a();
        r2 = r2.append(r3);
        r3 = r2.toString();
        r2 = r14.f15358d;
        r2 = r2.get();
        r10 = r2;
        r10 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r10;
        r12 = 0;
        r2 = r10.k();	 Catch:{ Throwable -> 0x00a9, all -> 0x014d }
        r11 = 0;
        r4 = f15354a;	 Catch:{ Throwable -> 0x009b, all -> 0x013e }
        if (r6 != 0) goto L_0x00f5;
    L_0x0061:
        r5 = 0;
    L_0x0062:
        if (r6 != 0) goto L_0x00fb;
    L_0x0064:
        r6 = 0;
    L_0x0065:
        r7 = 0;
        r8 = 0;
        r5 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x009b, all -> 0x013e }
        r4 = 0;
        r3 = new com.google.common.collect.ImmutableList$Builder;	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r3.<init>();	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r6 = new com.google.common.collect.ImmutableList$Builder;	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r6.<init>();	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
    L_0x0076:
        r7 = r5.moveToNext();	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        if (r7 == 0) goto L_0x0101;
    L_0x007c:
        r7 = r14.m21905a(r5);	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r3.m1069c(r7);	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r7 = r14.f15361g;	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r7 = r7.m21959b(r5);	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        r6.m1069c(r7);	 Catch:{ Throwable -> 0x008d, all -> 0x0161 }
        goto L_0x0076;
    L_0x008d:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x008f }
    L_0x008f:
        r4 = move-exception;
        r13 = r4;
        r4 = r3;
        r3 = r13;
    L_0x0093:
        if (r5 == 0) goto L_0x009a;
    L_0x0095:
        if (r4 == 0) goto L_0x0142;
    L_0x0097:
        r5.close();	 Catch:{ Throwable -> 0x0138, all -> 0x013e }
    L_0x009a:
        throw r3;	 Catch:{  }
    L_0x009b:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x009d }
    L_0x009d:
        r4 = move-exception;
        r13 = r4;
        r4 = r3;
        r3 = r13;
    L_0x00a1:
        if (r2 == 0) goto L_0x00a8;
    L_0x00a3:
        if (r4 == 0) goto L_0x0151;
    L_0x00a5:
        r2.close();	 Catch:{ Throwable -> 0x0147, all -> 0x014d }
    L_0x00a8:
        throw r3;	 Catch:{  }
    L_0x00a9:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x00ab }
    L_0x00ab:
        r3 = move-exception;
        r13 = r3;
        r3 = r2;
        r2 = r13;
    L_0x00af:
        if (r10 == 0) goto L_0x00b6;
    L_0x00b1:
        if (r3 == 0) goto L_0x015c;
    L_0x00b3:
        r10.close();	 Catch:{ Throwable -> 0x0156 }
    L_0x00b6:
        throw r2;
    L_0x00b7:
        r2 = 0;
        goto L_0x000b;
    L_0x00ba:
        r2 = 0;
        goto L_0x0011;
    L_0x00bd:
        r4 = 0;
        r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x00d1;
    L_0x00c3:
        r2 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15366d;
        r2 = r2.m2091a();
        r3 = java.lang.String.valueOf(r16);
        r2 = com.facebook.database.sqlite.SqlExpression.m10733b(r2, r3);
    L_0x00d1:
        r3 = com.facebook.messaging.tincan.database.TincanDbSchemaPart$ThreadsTable$Columns.f15366d;
        r9 = r3.m2100e();
        if (r18 <= 0) goto L_0x0164;
    L_0x00d9:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r9);
        r4 = " LIMIT ";
        r3 = r3.append(r4);
        r0 = r18;
        r3 = r3.append(r0);
        r9 = r3.toString();
        r6 = r2;
        goto L_0x0029;
    L_0x00f5:
        r5 = r6.mo1476a();	 Catch:{  }
        goto L_0x0062;
    L_0x00fb:
        r6 = r6.mo1477b();	 Catch:{  }
        goto L_0x0065;
    L_0x0101:
        r7 = r14.f15357c;	 Catch:{  }
        r7 = r7.get();	 Catch:{  }
        r6.m1069c(r7);	 Catch:{  }
        r7 = r3.m1068b();	 Catch:{  }
        if (r18 <= 0) goto L_0x0118;
    L_0x0110:
        r3 = r7.size();	 Catch:{  }
        r0 = r18;
        if (r3 >= r0) goto L_0x0136;
    L_0x0118:
        r3 = 1;
    L_0x0119:
        r8 = new com.facebook.messaging.model.threads.ThreadsCollection;	 Catch:{  }
        r8.<init>(r7, r3);	 Catch:{  }
        r3 = r6.m1068b();	 Catch:{  }
        r3 = android.util.Pair.create(r8, r3);	 Catch:{  }
        if (r5 == 0) goto L_0x012b;
    L_0x0128:
        r5.close();	 Catch:{  }
    L_0x012b:
        if (r2 == 0) goto L_0x0130;
    L_0x012d:
        r2.close();	 Catch:{  }
    L_0x0130:
        if (r10 == 0) goto L_0x0135;
    L_0x0132:
        r10.close();
    L_0x0135:
        return r3;
    L_0x0136:
        r3 = 0;
        goto L_0x0119;
    L_0x0138:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r4, r5);	 Catch:{  }
        goto L_0x009a;
    L_0x013e:
        r3 = move-exception;
        r4 = r11;
        goto L_0x00a1;
    L_0x0142:
        r5.close();	 Catch:{  }
        goto L_0x009a;
    L_0x0147:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r4, r2);	 Catch:{  }
        goto L_0x00a8;
    L_0x014d:
        r2 = move-exception;
        r3 = r12;
        goto L_0x00af;
    L_0x0151:
        r2.close();	 Catch:{  }
        goto L_0x00a8;
    L_0x0156:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);
        goto L_0x00b6;
    L_0x015c:
        r10.close();
        goto L_0x00b6;
    L_0x0161:
        r3 = move-exception;
        goto L_0x0093;
    L_0x0164:
        r6 = r2;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDbThreadsFetcher.a(com.facebook.messaging.model.threadkey.ThreadKey, long, int):android.util.Pair<com.facebook.messaging.model.threads.ThreadsCollection, com.google.common.collect.ImmutableList<com.facebook.user.model.User>>");
    }

    private ThreadSummary m21905a(Cursor cursor) {
        String b = TincanDbSchemaPart$ThreadsTable$Columns.f15363a.m2093b(cursor);
        String b2 = TincanDbSchemaPart$ThreadsTable$Columns.f15365c.m2093b(cursor);
        long c = TincanDbSchemaPart$ThreadsTable$Columns.f15366d.m2094c(cursor);
        long c2 = TincanDbSchemaPart$ThreadsTable$Columns.f15367e.m2094c(cursor);
        int d = TincanDbSchemaPart$ThreadsTable$Columns.f15374l.m2096d(cursor);
        String b3 = TincanDbSchemaPart$ThreadsTable$Columns.f15370h.m2093b(cursor);
        String b4 = TincanDbSchemaPart$ThreadsTable$Columns.f15371i.m2093b(cursor);
        String b5 = TincanDbSchemaPart$ThreadsTable$Columns.f15372j.m2093b(cursor);
        String b6 = TincanDbSchemaPart$ThreadsTable$Columns.f15369g.m2093b(cursor);
        boolean z = TincanDbSchemaPart$ThreadsTable$Columns.f15373k.m2096d(cursor) == 1;
        ThreadKey a = ThreadKey.a(b);
        Preconditions.checkNotNull(a);
        Preconditions.checkState(a.a == Type.TINCAN);
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        newBuilder.A = FolderName.INBOX;
        newBuilder.a = a;
        newBuilder.w = true;
        newBuilder.g = b2;
        newBuilder.e(c);
        newBuilder.f(c2);
        newBuilder.G = d;
        newBuilder.B = this.f15359e.m21919a(b6);
        newBuilder.u = z;
        newBuilder.r = b5;
        ThreadParticipant a2 = TincanDbUserConverter.m21956a(cursor);
        ThreadParticipant a3 = m21904a();
        newBuilder.h = ImmutableList.of(a2, a3);
        if (b4 != null) {
            newBuilder.p = b3;
            if (b4.equals(a3.b().m5867b())) {
                newBuilder.q = a3.a;
            } else {
                newBuilder.q = a2.a;
            }
        }
        return newBuilder.V();
    }

    private ThreadParticipant m21904a() {
        User user = (User) this.f15357c.get();
        ParticipantInfo participantInfo = new ParticipantInfo(user.f3592T, user.m5845j());
        ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
        threadParticipantBuilder.a = participantInfo;
        return threadParticipantBuilder.f();
    }

    private static Expression m21909c(String str) {
        Expression b = SqlExpression.m10730b();
        for (String trim : str.split(" ")) {
            String trim2;
            CharSequence trim3 = trim2.trim();
            if (!StringUtil.m3589a(trim3)) {
                trim2 = trim3 + '%';
                Expression d = SqlExpression.m10737d("threads." + TincanDbSchemaPart$ThreadsTable$Columns.f15365c.f1025d, trim2);
                Expression d2 = SqlExpression.m10737d(TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15379b.f1025d, trim2);
                Expression d3 = SqlExpression.m10737d(TincanDbSchemaPart$ThreadParticipantsTable$Columns.f15380c.f1025d, trim2);
                b.m10741a(d);
                b.m10741a(d2);
                b.m10741a(d3);
            }
        }
        return b;
    }
}
