package com.facebook.database.advancedsupplier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.supplier.AbstractDatabaseSupplier;
import com.facebook.database.supplier.SharedSQLiteSchemaPart;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.userchecker.DbUserChecker;
import com.google.common.collect.ImmutableList;

/* compiled from: network_priority */
public abstract class AdvancedAbstractDatabaseSupplier extends AbstractDatabaseSupplier {
    private final DbUserChecker f12437a;

    public /* synthetic */ Object get() {
        return mo2480a();
    }

    protected AdvancedAbstractDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, DbUserChecker dbUserChecker, ImmutableList<? extends SharedSQLiteSchemaPart> immutableList, String str) {
        super(context, dbThreadChecker, immutableList, str);
        this.f12437a = dbUserChecker;
    }

    public final synchronized SQLiteDatabase mo2480a() {
        SQLiteDatabase k;
        k = m18510k();
        m18509a(k);
        return k;
    }

    private synchronized SQLiteDatabase m18510k() {
        return super.mo2480a();
    }

    private synchronized void m18509a(SQLiteDatabase sQLiteDatabase) {
        if (!this.f12437a.mo2483a(sQLiteDatabase)) {
            mo2481e();
            if (!this.f12437a.mo2483a(sQLiteDatabase)) {
                throw new IllegalStateException("Cannot store uid");
            }
        }
    }

    public void mo2481e() {
        SQLiteDatabase k = m18510k();
        m2027f();
        this.f12437a.mo2484b(k);
    }

    public final void mo2482g() {
        SQLiteDatabase k = m18510k();
        m2029h();
        this.f12437a.mo2484b(k);
    }
}
