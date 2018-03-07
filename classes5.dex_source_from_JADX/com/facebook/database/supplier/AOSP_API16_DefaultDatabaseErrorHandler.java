package com.facebook.database.supplier;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Pair;
import com.facebook.debug.log.BLog;
import java.io.File;
import java.util.List;

@TargetApi(16)
/* compiled from: search_session_id */
public class AOSP_API16_DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        List list;
        Throwable th2;
        BLog.b("DefaultDatabaseErrorHandler", "Corruption reported by sqlite on database: %s", new Object[]{sQLiteDatabase.getPath()});
        if (sQLiteDatabase.isOpen()) {
            List list2 = null;
            try {
                list2 = sQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException e) {
            } catch (Throwable th3) {
                th = th3;
                list = list2;
                th2 = th;
                if (r0 == null) {
                    for (Pair pair : r0) {
                        m4019a((String) pair.second);
                    }
                } else {
                    m4019a(sQLiteDatabase.getPath());
                }
                throw th2;
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException e2) {
            } catch (Throwable th32) {
                th = th32;
                list = r1;
                th2 = th;
                if (r0 == null) {
                    m4019a(sQLiteDatabase.getPath());
                } else {
                    while (r2.hasNext()) {
                        m4019a((String) pair.second);
                    }
                }
                throw th2;
            }
            if (r1 != null) {
                for (Pair pair2 : r1) {
                    m4019a((String) pair2.second);
                }
                return;
            }
            m4019a(sQLiteDatabase.getPath());
            return;
        }
        m4019a(sQLiteDatabase.getPath());
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length", "InstanceMethodCanBeStatic", "LogMethodNoExceptionInCatch"})
    private static void m4019a(String str) {
        if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
            BLog.b("DefaultDatabaseErrorHandler", "deleting the database file: %s", new Object[]{str});
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                BLog.a("DefaultDatabaseErrorHandler", "delete failed: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
