package com.facebook.search.bootstrap.db.data;

import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesIndexTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesTable.Columns;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: external_ref_name */
public class BootstrapDbCacheWarmer {
    private static final String f15644a = ("SELECT COUNT(*) FROM entities WHERE " + Columns.f15679a + " IN ( SELECT " + EntitiesIndexTable.Columns.f15671a + " FROM entities_data" + " WHERE " + EntitiesIndexTable.Columns.f15672b + " GLOB '*' )");
    private final BootstrapDatabaseSupplier f15645b;
    private final ExecutorService f15646c;
    private final DbBootstrapPerformanceLogger f15647d;
    public final BootstrapDbCacheWarmerTimer f15648e;

    /* compiled from: external_ref_name */
    class C11101 implements Runnable {
        final /* synthetic */ BootstrapDbCacheWarmer f15643a;

        C11101(BootstrapDbCacheWarmer bootstrapDbCacheWarmer) {
            this.f15643a = bootstrapDbCacheWarmer;
        }

        public void run() {
            BootstrapDbCacheWarmer.m23376b(this.f15643a);
            BootstrapDbCacheWarmerTimer bootstrapDbCacheWarmerTimer = this.f15643a.f15648e;
            bootstrapDbCacheWarmerTimer.f15651b.set(bootstrapDbCacheWarmerTimer.f15650a.a());
        }
    }

    @Inject
    public BootstrapDbCacheWarmer(BootstrapDatabaseSupplier bootstrapDatabaseSupplier, ExecutorService executorService, DbBootstrapPerformanceLogger dbBootstrapPerformanceLogger, BootstrapDbCacheWarmerTimer bootstrapDbCacheWarmerTimer) {
        this.f15645b = bootstrapDatabaseSupplier;
        this.f15646c = executorService;
        this.f15647d = dbBootstrapPerformanceLogger;
        this.f15648e = bootstrapDbCacheWarmerTimer;
    }

    public final void m23377a() {
        Object obj;
        BootstrapDbCacheWarmerTimer bootstrapDbCacheWarmerTimer = this.f15648e;
        if (bootstrapDbCacheWarmerTimer.f15650a.a() - bootstrapDbCacheWarmerTimer.f15651b.get() > 900000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ExecutorDetour.a(this.f15646c, new C11101(this), 778055637);
        }
    }

    public static void m23376b(BootstrapDbCacheWarmer bootstrapDbCacheWarmer) {
        bootstrapDbCacheWarmer.f15647d.m23363b();
        SQLiteStatement compileStatement = bootstrapDbCacheWarmer.f15645b.a().compileStatement(f15644a);
        try {
            SQLiteStatement compileStatement2 = bootstrapDbCacheWarmer.f15645b.a().compileStatement(f15644a);
            SQLiteDetour.a(202754659);
            compileStatement2.simpleQueryForLong();
            SQLiteDetour.a(-75071351);
            bootstrapDbCacheWarmer.f15647d.m23366c();
            compileStatement.close();
        } catch (SQLiteException e) {
            bootstrapDbCacheWarmer.f15647d.m23369d();
            throw e;
        } catch (Throwable th) {
            compileStatement.close();
        }
    }
}
