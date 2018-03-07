package com.facebook.backgroundlocation.reporting;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: dialogready */
interface LocationSignalPackageDbContract {

    /* compiled from: dialogready */
    public interface SnapshotsTable {

        /* compiled from: dialogready */
        public interface Columns {
            public static final SqlColumn f14982a = new SqlColumn("snapshot", "BLOB");
            public static final SqlColumn f14983b = new SqlColumn("timestamp", "INTEGER NOT NULL");
        }
    }
}
