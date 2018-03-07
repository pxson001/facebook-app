package com.facebook.database.supplier;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: vnd.android.cursor.dir/vnd.facebook.katana.gql_notifications */
public class AbstractDatabaseSupplier implements Supplier<SQLiteDatabase> {
    private static final Class<?> f999a = AbstractDatabaseSupplier.class;
    private final Context f1000b;
    private final DbThreadChecker f1001c;
    private final ImmutableList<? extends SharedSQLiteSchemaPart> f1002d;
    private final String f1003e;
    public SQLiteDatabase f1004f;

    public /* synthetic */ Object get() {
        return mo2480a();
    }

    protected AbstractDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, ImmutableList<? extends SharedSQLiteSchemaPart> immutableList, String str) {
        this.f1000b = context;
        this.f1001c = dbThreadChecker;
        this.f1002d = immutableList;
        this.f1003e = str;
    }

    public synchronized SQLiteDatabase mo2480a() {
        this.f1001c.mo318a();
        m2020k();
        return this.f1004f;
    }

    private synchronized void m2020k() {
        if (this.f1004f == null || !this.f1004f.isOpen()) {
            this.f1004f = null;
            TracerDetour.a("ensureDatabase(%s)", this.f1003e, 1483097034);
            Throwable th = null;
            int i = 0;
            while (i <= 10) {
                if (i > 5) {
                    try {
                        this.f1000b.deleteDatabase(this.f1003e);
                    } catch (Throwable e) {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                        i++;
                        th = e;
                    }
                }
                this.f1004f = m2021l();
            }
            if (i > 0) {
                try {
                    FbErrorReporterImpl.m2317a(FbInjector.get(this.f1000b)).m2351b("AbstractDatabaseSupplier_RETRIES", i + " attempts for " + this.f1003e, th);
                } catch (Throwable th2) {
                    TracerDetour.a(1363895060);
                }
            }
            TracerDetour.a(-2122442569);
            if (this.f1004f == null) {
                throw th;
            }
        }
    }

    private SQLiteDatabase m2021l() {
        try {
            SQLiteDatabase writableDatabase = new SharedSQLiteOpenHelper(this.f1000b, this.f1003e, this.f1002d, mo1451c(), mo1452j()).getWritableDatabase();
            if (mo1450b() == -1) {
                return writableDatabase;
            }
            writableDatabase.setMaximumSize(mo1450b());
            return writableDatabase;
        } catch (StackOverflowError e) {
            BLog.a(f999a, "Database %s corrupt and repair overflowed; deleting", new Object[]{this.f1003e});
            mo2482g();
            return m2021l();
        }
    }

    protected long mo1450b() {
        return -1;
    }

    protected int mo1451c() {
        return 51200;
    }

    public final long m2025d() {
        mo2480a();
        return ((long) SharedSQLiteDbHelper.m3758a(this.f1004f, "page_count")) * ((long) SharedSQLiteDbHelper.m3758a(this.f1004f, "page_size"));
    }

    public void mo2481e() {
        mo2480a();
        m2027f();
    }

    protected final void m2027f() {
        int size = this.f1002d.size();
        for (int i = 0; i < size; i++) {
            ((SharedSQLiteSchemaPart) this.f1002d.get(i)).mo322b(this.f1004f);
        }
    }

    public synchronized void mo2482g() {
        m2029h();
    }

    protected final synchronized void m2029h() {
        m2030i();
        this.f1000b.deleteDatabase(this.f1003e);
    }

    protected final synchronized void m2030i() {
        if (this.f1004f != null) {
            this.f1004f.close();
            this.f1004f = null;
        }
    }

    protected DatabaseErrorHandler mo1452j() {
        return new DefaultDatabaseErrorHandler();
    }
}
