package com.facebook.graphql.executor.cache;

import javax.inject.Singleton;

@Singleton
/* compiled from: saved_dashboard_filter_section_clicked */
public class GraphQLDiskCacheQueryFormatter {
    public static final String f6167a = ("SELECT " + GraphQLDBContract$QueriesTable$Columns.f6135g.f1025d + ", COUNT(*) AS " + "row_count, " + "SUM(LENGTH(" + GraphQLDBContract$QueriesTable$Columns.f6132d.f1025d + ")) AS total_length" + ", AVG(? - timestamp) AS " + "average_age " + "FROM queries" + " ");
    public static final String f6168b = ("GROUP BY " + GraphQLDBContract$QueriesTable$Columns.f6135g.f1025d + " ORDER BY " + "average_age");
    private static volatile GraphQLDiskCacheQueryFormatter f6169c;

    public static com.facebook.graphql.executor.cache.GraphQLDiskCacheQueryFormatter m10353a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f6169c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.GraphQLDiskCacheQueryFormatter.class;
        monitor-enter(r1);
        r0 = f6169c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m10359c();	 Catch:{ all -> 0x0034 }
        f6169c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6169c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.GraphQLDiskCacheQueryFormatter.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.GraphQLDiskCacheQueryFormatter");
    }

    private static GraphQLDiskCacheQueryFormatter m10359c() {
        return new GraphQLDiskCacheQueryFormatter();
    }

    public static String m10354a() {
        return "SELECT COUNT(*) FROM queries";
    }

    public static String m10357b() {
        return f6167a + f6168b;
    }

    public static String[] m10356a(long j) {
        return new String[]{String.valueOf(j)};
    }

    public static String m10355a(String str) {
        return "SELECT " + GraphQLDBContract$QueriesTable$Columns.f6129a.f1025d + " FROM " + "queries " + "WHERE (? - " + GraphQLDBContract$QueriesTable$Columns.f6133e.f1025d + ") > " + GraphQLDBContract$QueriesTable$Columns.f6138j.f1025d + " AND " + GraphQLDBContract$QueriesTable$Columns.f6130b + " NOT IN (" + str + ")";
    }

    public static String[] m10358b(long j) {
        return new String[]{String.valueOf(j)};
    }

    public static String m10360c(String str) {
        return "SELECT " + GraphQLDBContract$QueriesTable$Columns.f6129a.f1025d + " FROM " + "queries " + "WHERE " + GraphQLDBContract$QueriesTable$Columns.f6130b + " NOT IN (" + str + ") ORDER BY " + GraphQLDBContract$QueriesTable$Columns.f6134f.f1025d + " ASC LIMIT ?";
    }

    public static String[] m10361d(long j) {
        return new String[]{String.valueOf(j)};
    }
}
