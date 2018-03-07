package com.facebook.timeline.cache.db;

/* compiled from: uri_extra */
public class TimelineDbCacheQueryFormatter {
    static final String f820a = ("SUM(LENGTH(" + TimelineContract$CacheTable$Columns.f806c + "))");
    private static final String f821b = ("SELECT COUNT(*), " + f820a + ", AVG(? - " + TimelineContract$CacheTable$Columns.f805b + ") AS " + "average_age FROM ");
    public static final String f822c = ("SELECT " + TimelineContract$CacheTable$Columns.f806c.d + ", " + TimelineContract$CacheTable$Columns.f805b.d + " FROM cache" + " WHERE " + TimelineContract$CacheTable$Columns.f805b.d + " <= (SELECT " + TimelineContract$CacheTable$Columns.f805b.d + " FROM cache" + " ORDER BY " + TimelineContract$CacheTable$Columns.f805b.d + " ASC LIMIT 1 OFFSET ?)");

    public static String m868b() {
        return m866a("cache");
    }

    public static String[] m867a(long j) {
        return new String[]{String.valueOf(j)};
    }

    public static String m866a(String str) {
        return f821b + "(" + str + ")";
    }
}
