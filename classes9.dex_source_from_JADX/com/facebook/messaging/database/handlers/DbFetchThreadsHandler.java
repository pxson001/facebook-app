package com.facebook.messaging.database.handlers;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.database.threads.DbFolders;
import com.facebook.messaging.database.threads.DbThreadParticipantsUtil;
import com.facebook.messaging.database.threads.DbThreadParticipantsUtil.ParticipantType;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.database.threads.ThreadSummaryCursorUtil;
import com.facebook.messaging.database.threads.ThreadSummaryCursorUtil$Iterator;
import com.facebook.messaging.database.threads.ThreadSummaryIterators;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.UserKey;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: media- */
public class DbFetchThreadsHandler {
    private static final String[] f10335i = new String[]{"unread_count", "unseen_count", "last_seen_time", "last_action_id"};
    private static volatile DbFetchThreadsHandler f10336j;
    private final Provider<ThreadsDatabaseSupplier> f10337a;
    private final DbFetchThreadUsersHandler f10338b;
    private final Provider<DbThreadsPropertyUtil> f10339c;
    private final ThreadSummaryIterators f10340d;
    private final DbClock f10341e;
    private final Clock f10342f;
    private final DefaultThreadKeyFactory f10343g;
    private final ThreadSummaryCursorUtil f10344h;

    public static com.facebook.messaging.database.handlers.DbFetchThreadsHandler m10920a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10336j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.handlers.DbFetchThreadsHandler.class;
        monitor-enter(r1);
        r0 = f10336j;	 Catch:{ all -> 0x003a }
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
        r0 = m10923b(r0);	 Catch:{ all -> 0x0035 }
        f10336j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10336j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbFetchThreadsHandler");
    }

    private static DbFetchThreadsHandler m10923b(InjectorLike injectorLike) {
        return new DbFetchThreadsHandler(IdBasedProvider.a(injectorLike, 7815), DbFetchThreadUsersHandler.a(injectorLike), IdBasedProvider.a(injectorLike, 7808), ThreadSummaryIterators.m11164a(injectorLike), DbClock.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), ThreadSummaryCursorUtil.a(injectorLike));
    }

    final FetchMoreThreadsResult m10929a(FetchMoreThreadsParams fetchMoreThreadsParams) {
        boolean z;
        FolderName folderName = fetchMoreThreadsParams.f17083a;
        long a = ((DbThreadsPropertyUtil) this.f10339c.get()).a(DbThreadProperties.m11128a(folderName), -1);
        LinkedHashMap a2 = m10934a(folderName, fetchMoreThreadsParams.f17085c, fetchMoreThreadsParams.f17087e);
        if (a2.size() >= fetchMoreThreadsParams.f17087e || !m10927c(folderName)) {
            z = false;
        } else {
            z = true;
        }
        return new FetchMoreThreadsResult(DataFetchDisposition.e, folderName, new ThreadsCollection(m10921a(a2.values(), fetchMoreThreadsParams.f17087e), z), this.f10338b.a(m10922a(a2)), a);
    }

    @Inject
    DbFetchThreadsHandler(Provider<ThreadsDatabaseSupplier> provider, DbFetchThreadUsersHandler dbFetchThreadUsersHandler, Provider<DbThreadsPropertyUtil> provider2, ThreadSummaryIterators threadSummaryIterators, DbClock dbClock, Clock clock, ThreadKeyFactory threadKeyFactory, ThreadSummaryCursorUtil threadSummaryCursorUtil) {
        this.f10337a = provider;
        this.f10338b = dbFetchThreadUsersHandler;
        this.f10339c = provider2;
        this.f10340d = threadSummaryIterators;
        this.f10341e = dbClock;
        this.f10342f = clock;
        this.f10343g = threadKeyFactory;
        this.f10344h = threadSummaryCursorUtil;
    }

    @VisibleForTesting
    public final FetchThreadListResult m10931a(FetchThreadListParams fetchThreadListParams) {
        TracerDetour.a("DbFetchThreadsHandler.fetchThreadListFromDb", 303986619);
        try {
            FetchThreadListResult a;
            DbThreadsPropertyUtil dbThreadsPropertyUtil = (DbThreadsPropertyUtil) this.f10339c.get();
            FolderName b = fetchThreadListParams.m17107b();
            long a2 = dbThreadsPropertyUtil.a(DbThreadProperties.m11128a(b), -1);
            boolean a3 = dbThreadsPropertyUtil.a(DbThreadProperties.m11130c(b), true);
            long a4 = dbThreadsPropertyUtil.a(DbThreadProperties.m11129b(b), -1);
            if (a2 == -1) {
                a = FetchThreadListResult.m17117a(b);
            } else {
                DataFetchDisposition dataFetchDisposition;
                if (a3) {
                    dataFetchDisposition = DataFetchDisposition.f;
                } else {
                    dataFetchDisposition = DataFetchDisposition.e;
                }
                LinkedHashMap a5 = m10934a(fetchThreadListParams.m17107b(), -1, fetchThreadListParams.m17109f());
                ImmutableList a6 = this.f10338b.a(m10922a(a5));
                boolean z = a5.size() < fetchThreadListParams.m17109f() && m10927c(b);
                ImmutableList a7 = m10921a(a5.values(), fetchThreadListParams.m17109f());
                ThreadsCollection threadsCollection = new ThreadsCollection(a7, z);
                FolderCounts b2 = m10935b(fetchThreadListParams.m17107b());
                if (!a7.isEmpty()) {
                    this.f10341e.a(((ThreadSummary) a7.get(0)).k);
                }
                a = FetchThreadListResult.newBuilder().m17119a(dataFetchDisposition).m17121a(b).m17123a(threadsCollection).m17125a(a6).m17120a(b2).m17118a(a2).m17127b(a4).m17129m();
                TracerDetour.a(2145234905);
            }
            return a;
        } finally {
            TracerDetour.a(855726647);
        }
    }

    final FetchPinnedThreadsResult m10930a() {
        TracerDetour.a("DbFetchThreadsHandler.fetchPinnedThreadResultFromDb", 244642281);
        try {
            DbThreadsPropertyUtil dbThreadsPropertyUtil = (DbThreadsPropertyUtil) this.f10339c.get();
            long a = dbThreadsPropertyUtil.a(DbThreadProperties.f10469b, 0);
            long a2 = dbThreadsPropertyUtil.a(DbThreadProperties.f10470c, 0);
            List c = m10926c();
            FetchPinnedThreadsResult e = FetchPinnedThreadsResult.newBuilder().m17094a(c).m17095a(!c.isEmpty()).m17093a(a).m17096b(a2).m17097e();
            return e;
        } finally {
            TracerDetour.a(-1576000682);
        }
    }

    final long m10928a(FolderName folderName) {
        Cursor rawQuery = ((ThreadsDatabaseSupplier) this.f10337a.get()).a().rawQuery("SELECT MIN(timestamp_ms) FROM folders WHERE folder=? AND thread_key != ?", new String[]{folderName.dbName, DbFolders.m11102a(folderName)});
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return -1;
        } finally {
            rawQuery.close();
        }
    }

    private static Set<UserKey> m10922a(LinkedHashMap<ThreadKey, ThreadSummary> linkedHashMap) {
        Set<UserKey> a = Sets.a();
        for (ThreadSummary threadSummary : linkedHashMap.values()) {
            int i;
            ImmutableList immutableList = threadSummary.h;
            int size = immutableList.size();
            for (i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                if (threadParticipant.b() != null) {
                    a.add(threadParticipant.b());
                }
            }
            immutableList = threadSummary.i;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                threadParticipant = (ThreadParticipant) immutableList.get(i);
                if (threadParticipant.b() != null) {
                    a.add(threadParticipant.b());
                }
            }
            ImmutableList immutableList2 = threadSummary.j;
            int size2 = immutableList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ThreadParticipant threadParticipant2 = (ThreadParticipant) immutableList2.get(i2);
                if (threadParticipant2.b() != null) {
                    a.add(threadParticipant2.b());
                }
            }
        }
        return a;
    }

    public final LinkedHashMap<ThreadKey, ThreadSummary> m10934a(FolderName folderName, long j, int i) {
        TracerDetour.a("DbFetchThreadsHandler.doThreadListQuery", -132887862);
        LinkedHashMap<ThreadKey, ThreadSummary> d;
        try {
            LinkedHashMap b = m10924b(folderName, j, i);
            m10925b(b);
            d = Maps.d();
            for (ThreadSummaryBuilder threadSummaryBuilder : b.values()) {
                d.put(threadSummaryBuilder.a(), threadSummaryBuilder.V());
            }
            return d;
        } finally {
            d = 158137510;
            TracerDetour.a(158137510);
        }
    }

    public final ImmutableList<ThreadSummary> m10936b() {
        LinkedHashMap b = m10924b(FolderName.INBOX, -1, -1);
        Builder builder = ImmutableList.builder();
        for (ThreadSummaryBuilder V : b.values()) {
            builder.c(V.V());
        }
        return builder.b();
    }

    public final ImmutableList<ThreadSummary> m10932a(ImmutableSet<UserKey> immutableSet) {
        Builder builder = ImmutableList.builder();
        if (immutableSet.isEmpty()) {
            return builder.b();
        }
        String str = "count(*) = " + immutableSet.size();
        String str2 = DbThreadParticipantsUtil.f10456e + " = '" + ParticipantType.PARTICIPANT.dbValue + "' ";
        String buildQueryString = SQLiteQueryBuilder.buildQueryString(false, "thread_participants", new String[]{DbThreadParticipantsUtil.f10452a}, str2, DbThreadParticipantsUtil.f10452a, str, null, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2).append(" AND ").append(DbThreadParticipantsUtil.f10453b).append(" IN (");
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            stringBuilder.append("'").append(((UserKey) it.next()).c()).append("',");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")).append(") AND ").append(DbThreadParticipantsUtil.f10452a).append(" IN (").append(buildQueryString).append(")");
        String buildQueryString2 = SQLiteQueryBuilder.buildQueryString(false, "thread_participants", new String[]{DbThreadParticipantsUtil.f10452a}, stringBuilder.toString(), DbThreadParticipantsUtil.f10452a, str, null, null);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("((" + buildQueryString2 + ") NATURAL JOIN threads" + ")");
        Cursor query = sQLiteQueryBuilder.query(((ThreadsDatabaseSupplier) this.f10337a.get()).a(), null, null, null, null, null, "timestamp_ms DESC");
        try {
            ThreadSummaryCursorUtil$Iterator a = this.f10344h.a(query);
            for (Object b = a.m11161b(); b != null; b = a.m11161b()) {
                builder.c(b);
            }
            return builder.b();
        } finally {
            query.close();
        }
    }

    private LinkedHashMap<ThreadKey, ThreadSummaryBuilder> m10924b(FolderName folderName, long j, int i) {
        LinkedHashMap<ThreadKey, ThreadSummaryBuilder> d = Maps.d();
        ThreadSummaryCursorUtil$Iterator a = this.f10340d.m11167a(folderName, j, i);
        while (true) {
            try {
                ThreadSummaryBuilder a2 = a.m11160a();
                if (a2 == null) {
                    break;
                }
                d.put(a2.a(), a2);
            } finally {
                a.m11163d();
            }
        }
        return d;
    }

    private void m10925b(LinkedHashMap<ThreadKey, ThreadSummaryBuilder> linkedHashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        Collection a = Sets.a();
        for (ThreadSummaryBuilder k : linkedHashMap.values()) {
            ThreadSummaryBuilder k2;
            a.add(Long.valueOf(k2.k()));
        }
        Expression[] expressionArr = new Expression[3];
        expressionArr[0] = SqlExpression.a("thread_key", linkedHashMap.keySet());
        expressionArr[1] = SqlExpression.a("msg_type", Integer.toString(MessageType.FAILED_SEND.dbKeyValue));
        expressionArr[2] = SqlExpression.b(new Expression[]{SqlExpression.e("timestamp_ms", Long.toString(currentTimeMillis - 86400000)), SqlExpression.a("timestamp_ms", a)});
        ConjunctionExpression a2 = SqlExpression.a(expressionArr);
        Cursor query = ((ThreadsDatabaseSupplier) this.f10337a.get()).a().query(true, "messages", new String[]{"thread_key", "timestamp_ms"}, a2.a(), a2.b(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                k2 = (ThreadSummaryBuilder) linkedHashMap.get(ThreadKey.a(query.getString(0)));
                k2.c(true);
                if (query.getLong(1) == k2.k()) {
                    k2.e(true);
                }
            } finally {
                query.close();
            }
        }
    }

    private static ImmutableList<ThreadSummary> m10921a(Collection<ThreadSummary> collection, int i) {
        Builder builder = ImmutableList.builder();
        Iterator it = collection.iterator();
        int i2 = 0;
        while (it.hasNext() && i2 < i) {
            builder.c(it.next());
            i2++;
        }
        return builder.b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.messaging.model.folders.FolderCounts m10935b(com.facebook.messaging.model.folders.FolderName r11) {
        /*
        r10 = this;
        r8 = 0;
        r0 = "DbFetchThreadsHandler.getFolderCounts";
        r1 = 1937569720; // 0x737cf7b8 float:2.0042162E31 double:9.57286635E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = "folder";
        r1 = r11.dbName;	 Catch:{ all -> 0x0069 }
        r4 = com.facebook.database.sqlite.SqlExpression.a(r0, r1);	 Catch:{ all -> 0x0069 }
        r0 = r10.f10337a;	 Catch:{ all -> 0x0069 }
        r0 = r0.get();	 Catch:{ all -> 0x0069 }
        r0 = (com.facebook.messaging.database.threads.ThreadsDatabaseSupplier) r0;	 Catch:{ all -> 0x0069 }
        r0 = r0.a();	 Catch:{ all -> 0x0069 }
        r1 = "folder_counts";
        r2 = f10335i;	 Catch:{ all -> 0x0069 }
        r3 = r4.a();	 Catch:{ all -> 0x0069 }
        r4 = r4.b();	 Catch:{ all -> 0x0069 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0069 }
        r0 = r9.moveToNext();	 Catch:{ all -> 0x0064 }
        if (r0 == 0) goto L_0x0059;
    L_0x0036:
        r1 = new com.facebook.messaging.model.folders.FolderCounts;	 Catch:{ all -> 0x0064 }
        r0 = 0;
        r2 = r9.getInt(r0);	 Catch:{ all -> 0x0064 }
        r0 = 1;
        r3 = r9.getInt(r0);	 Catch:{ all -> 0x0064 }
        r0 = 2;
        r4 = r9.getLong(r0);	 Catch:{ all -> 0x0064 }
        r0 = 3;
        r6 = r9.getLong(r0);	 Catch:{ all -> 0x0064 }
        r1.<init>(r2, r3, r4, r6);	 Catch:{ all -> 0x0064 }
        r9.close();	 Catch:{  }
        r0 = 539919299; // 0x202e83c3 float:1.478197E-19 double:2.66755577E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0058:
        return r1;
    L_0x0059:
        r9.close();	 Catch:{  }
        r0 = 1945902963; // 0x73fc1f73 float:3.995046E31 double:9.61403804E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r1 = r8;
        goto L_0x0058;
    L_0x0064:
        r0 = move-exception;
        r9.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0069:
        r0 = move-exception;
        r1 = 482601819; // 0x1cc3eb5b float:1.2964856E-21 double:2.384369794E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadsHandler.b(com.facebook.messaging.model.folders.FolderName):com.facebook.messaging.model.folders.FolderCounts");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m10927c(com.facebook.messaging.model.folders.FolderName r9) {
        /*
        r8 = this;
        r0 = "DbFetchThreadsHandler.containsFirstThreadSentinalForFolder";
        r1 = 1942955039; // 0x73cf241f float:3.2822817E31 double:9.59947336E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = "thread_key";
        r1 = com.facebook.messaging.database.threads.DbFolders.m11102a(r9);	 Catch:{ all -> 0x004a }
        r4 = com.facebook.database.sqlite.SqlExpression.a(r0, r1);	 Catch:{ all -> 0x004a }
        r0 = r8.f10337a;	 Catch:{ all -> 0x004a }
        r0 = r0.get();	 Catch:{ all -> 0x004a }
        r0 = (com.facebook.messaging.database.threads.ThreadsDatabaseSupplier) r0;	 Catch:{ all -> 0x004a }
        r0 = r0.a();	 Catch:{ all -> 0x004a }
        r1 = "folders";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x004a }
        r3 = 0;
        r5 = "thread_key";
        r2[r3] = r5;	 Catch:{ all -> 0x004a }
        r3 = r4.a();	 Catch:{ all -> 0x004a }
        r4 = r4.b();	 Catch:{ all -> 0x004a }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x004a }
        r1 = r0.moveToNext();	 Catch:{ all -> 0x0045 }
        r0.close();	 Catch:{  }
        r0 = 1222725671; // 0x48e15027 float:461441.22 double:6.041067483E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        return r1;
    L_0x0045:
        r1 = move-exception;
        r0.close();	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x004a:
        r0 = move-exception;
        r1 = 525272198; // 0x1f4f0486 float:4.3837697E-20 double:2.595189477E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadsHandler.c(com.facebook.messaging.model.folders.FolderName):boolean");
    }

    private ImmutableList<ThreadSummary> m10926c() {
        TracerDetour.a("DbFetchThreadsHandler.doPinnedThreadsQuery", 1904391255);
        try {
            Builder builder = ImmutableList.builder();
            ThreadSummaryCursorUtil$Iterator a = this.f10340d.m11166a();
            while (true) {
                try {
                    ThreadSummaryBuilder a2 = a.m11160a();
                    if (a2 == null) {
                        break;
                    }
                    builder.c(a2.V());
                } finally {
                    a.m11163d();
                }
            }
            ImmutableList<ThreadSummary> b = builder.b();
            return b;
        } finally {
            TracerDetour.a(-1922236946);
        }
    }

    public final ImmutableList<ThreadSummary> m10933a(Set<ThreadKey> set) {
        TracerDetour.a("DbFetchThreadsHandler.doCustomThreadSetQuery", -798718906);
        try {
            Builder builder = ImmutableList.builder();
            ThreadSummaryCursorUtil$Iterator a = this.f10340d.m11170a((Set) set);
            while (true) {
                try {
                    ThreadSummaryBuilder a2 = a.m11160a();
                    if (a2 == null) {
                        break;
                    }
                    builder.c(a2.V());
                } finally {
                    a.m11163d();
                }
            }
            ImmutableList<ThreadSummary> b = builder.b();
            return b;
        } finally {
            TracerDetour.a(-349334561);
        }
    }
}
