package com.facebook.abtest.qe.bootstrap.db;

/* compiled from: unchanged_count */
public enum DataSource {
    FROM_SERVER("from_server"),
    FROM_USER("from_user");
    
    public final String dbName;

    private DataSource(String str) {
        this.dbName = str;
    }
}
