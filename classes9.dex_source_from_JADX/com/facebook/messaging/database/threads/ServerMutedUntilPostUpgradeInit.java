package com.facebook.messaging.database.threads;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.Product;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: max_num_retries */
public class ServerMutedUntilPostUpgradeInit implements INeedInit {
    private final Product f10554a;
    private final FbSharedPreferences f10555b;
    private final Provider<ThreadsDatabaseSupplier> f10556c;
    private final LoggedInUserSessionManager f10557d;
    private final AbstractFbErrorReporter f10558e;

    @Inject
    public ServerMutedUntilPostUpgradeInit(Product product, FbSharedPreferences fbSharedPreferences, Provider<ThreadsDatabaseSupplier> provider, LoggedInUserSessionManager loggedInUserSessionManager, FbErrorReporter fbErrorReporter) {
        this.f10554a = product;
        this.f10555b = fbSharedPreferences;
        this.f10556c = provider;
        this.f10557d = loggedInUserSessionManager;
        this.f10558e = fbErrorReporter;
    }

    public void init() {
        if (this.f10554a != Product.PAA && this.f10557d.b() && !this.f10555b.a(MessagingPrefKeys.av)) {
            m11149a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11149a() {
        /*
        r12 = this;
        r10 = 0;
        r0 = r12.f10556c;
        r0 = r0.get();
        r0 = (com.facebook.messaging.database.threads.ThreadsDatabaseSupplier) r0;
        r0 = r0.a();
        r1 = com.facebook.database.properties.DbPropertyUtil.a;
        r1 = r1.a();
        r2 = "server_muted_until";
        r11 = com.facebook.database.sqlite.SqlExpression.a(r1, r2);
        r8 = 0;
        r1 = "properties";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ IllegalStateException -> 0x0067 }
        r3 = 0;
        r4 = com.facebook.database.properties.DbPropertyUtil.b;	 Catch:{ IllegalStateException -> 0x0067 }
        r4 = r4.a();	 Catch:{ IllegalStateException -> 0x0067 }
        r2[r3] = r4;	 Catch:{ IllegalStateException -> 0x0067 }
        r3 = r11.a();	 Catch:{ IllegalStateException -> 0x0067 }
        r4 = r11.b();	 Catch:{ IllegalStateException -> 0x0067 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r4 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ IllegalStateException -> 0x0067 }
        r1 = r4.moveToFirst();	 Catch:{ IllegalStateException -> 0x008f, all -> 0x0089 }
        if (r1 == 0) goto L_0x0096;
    L_0x003e:
        r1 = 0;
        r2 = r4.getLong(r1);	 Catch:{ IllegalStateException -> 0x008f, all -> 0x0089 }
        r1 = "properties";
        r5 = r11.a();	 Catch:{ IllegalStateException -> 0x0092, all -> 0x0089 }
        r6 = r11.b();	 Catch:{ IllegalStateException -> 0x0092, all -> 0x0089 }
        r0.delete(r1, r5, r6);	 Catch:{ IllegalStateException -> 0x0092, all -> 0x0089 }
        r0 = r2;
    L_0x0051:
        r10 = r4;
    L_0x0052:
        r2 = r12.f10555b;	 Catch:{ all -> 0x0082 }
        r2 = r2.edit();	 Catch:{ all -> 0x0082 }
        r3 = com.facebook.messaging.prefs.MessagingPrefKeys.av;	 Catch:{ all -> 0x0082 }
        r0 = r2.a(r3, r0);	 Catch:{ all -> 0x0082 }
        r0.commit();	 Catch:{ all -> 0x0082 }
        if (r10 == 0) goto L_0x0066;
    L_0x0063:
        r10.close();
    L_0x0066:
        return;
    L_0x0067:
        r0 = move-exception;
        r1 = r10;
    L_0x0069:
        r2 = r12.f10558e;	 Catch:{ all -> 0x008c }
        r3 = "ServerMutedUntilPostUpgradeInit";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008c }
        r5 = "Caught exception when migrating server mute settings. Migrating with: ";
        r4.<init>(r5);	 Catch:{ all -> 0x008c }
        r4 = r4.append(r8);	 Catch:{ all -> 0x008c }
        r4 = r4.toString();	 Catch:{ all -> 0x008c }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x008c }
        r10 = r1;
        r0 = r8;
        goto L_0x0052;
    L_0x0082:
        r0 = move-exception;
    L_0x0083:
        if (r10 == 0) goto L_0x0088;
    L_0x0085:
        r10.close();
    L_0x0088:
        throw r0;
    L_0x0089:
        r0 = move-exception;
        r10 = r4;
        goto L_0x0083;
    L_0x008c:
        r0 = move-exception;
        r10 = r1;
        goto L_0x0083;
    L_0x008f:
        r0 = move-exception;
        r1 = r4;
        goto L_0x0069;
    L_0x0092:
        r0 = move-exception;
        r8 = r2;
        r1 = r4;
        goto L_0x0069;
    L_0x0096:
        r0 = r8;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.ServerMutedUntilPostUpgradeInit.a():void");
    }
}
