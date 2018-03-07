package com.facebook.messaging.tincan.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.database.advancedsupplier.AdvancedAbstractDatabaseSupplier;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadCheckerDisallowUiThread;
import com.facebook.database.userchecker.DbUserChecker;
import com.facebook.database.userchecker.DbUserCheckerDefault;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@SuppressLint({"NewApi", "ImprovedNewApi"})
@UserScoped
@ThreadSafe
/* compiled from: client_name */
public class TincanDatabaseSupplier extends AdvancedAbstractDatabaseSupplier implements AutoCloseable {
    private static final Object f17914b = new Object();
    private final Lock f17915a = new ReentrantLock();

    private static TincanDatabaseSupplier m17926b(InjectorLike injectorLike) {
        return new TincanDatabaseSupplier((Context) injectorLike.getInstance(Context.class), (DbThreadChecker) DbThreadCheckerDisallowUiThread.a(injectorLike), (DbUserChecker) DbUserCheckerDefault.a(injectorLike), TincanDbSchemaPart.m17940a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public TincanDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, DbUserChecker dbUserChecker, TincanDbSchemaPart tincanDbSchemaPart, String str) {
        super(context, dbThreadChecker, dbUserChecker, ImmutableList.of(tincanDbSchemaPart), "tincan_db_" + str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.database.TincanDatabaseSupplier m17925a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17914b;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m17926b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17914b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17914b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.TincanDatabaseSupplier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.TincanDatabaseSupplier");
    }

    public final SQLiteDatabase m17930k() {
        m17928m();
        return super.a();
    }

    private void m17927l() {
        this.f17915a.unlock();
    }

    public final void m17929e() {
        m17928m();
        super.i();
        m17927l();
    }

    public void close() {
        m17927l();
    }

    private void m17928m() {
        this.f17915a.lock();
    }
}
