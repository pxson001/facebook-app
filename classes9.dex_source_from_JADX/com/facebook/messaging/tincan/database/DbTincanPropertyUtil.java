package com.facebook.messaging.tincan.database;

import android.annotation.SuppressLint;
import com.facebook.common.typedkey.TypedKey;
import com.facebook.database.properties.DbPropertyUtil;
import com.google.common.base.Supplier;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: client_tag_ */
public class DbTincanPropertyUtil extends DbPropertyUtil<DbTincanPropertyKey> {
    private final Provider<TincanDatabaseSupplier> f17904c;

    @SuppressLint({"NewApi"})
    public final /* synthetic */ void m17916b(TypedKey typedKey, String str) {
        m17915a((DbTincanPropertyKey) typedKey, str);
    }

    @Inject
    public DbTincanPropertyUtil(Provider<TincanDatabaseSupplier> provider) {
        super((Supplier) provider.get(), "properties");
        this.f17904c = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final void m17915a(com.facebook.messaging.tincan.database.DbTincanPropertyKey r6, java.lang.String r7) {
        /*
        r5 = this;
        r3 = 0;
        r0 = r5.f17904c;
        r0 = r0.get();
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;
        r4 = r0.m17930k();	 Catch:{ Throwable -> 0x0026, all -> 0x0038 }
        super.b(r6, r7);	 Catch:{ Throwable -> 0x001b, all -> 0x0047 }
        if (r4 == 0) goto L_0x0015;
    L_0x0012:
        r4.close();	 Catch:{  }
    L_0x0015:
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0.close();
    L_0x001a:
        return;
    L_0x001b:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x001d }
    L_0x001d:
        r1 = move-exception;
    L_0x001e:
        if (r4 == 0) goto L_0x0025;
    L_0x0020:
        if (r2 == 0) goto L_0x003a;
    L_0x0022:
        r4.close();	 Catch:{ Throwable -> 0x0033, all -> 0x0038 }
    L_0x0025:
        throw r1;	 Catch:{  }
    L_0x0026:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0028 }
    L_0x0028:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x002b:
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        if (r3 == 0) goto L_0x0043;
    L_0x002f:
        r0.close();	 Catch:{ Throwable -> 0x003e }
    L_0x0032:
        throw r1;
    L_0x0033:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0025;
    L_0x0038:
        r1 = move-exception;
        goto L_0x002b;
    L_0x003a:
        r4.close();	 Catch:{  }
        goto L_0x0025;
    L_0x003e:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);
        goto L_0x0032;
    L_0x0043:
        r0.close();
        goto L_0x0032;
    L_0x0047:
        r1 = move-exception;
        r2 = r3;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbTincanPropertyUtil.a(com.facebook.messaging.tincan.database.DbTincanPropertyKey, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    @javax.annotation.Nullable
    public final java.lang.String m17914a(com.facebook.messaging.tincan.database.DbTincanPropertyKey r6) {
        /*
        r5 = this;
        r3 = 0;
        r0 = r5.f17904c;
        r0 = r0.get();
        r0 = (com.facebook.messaging.tincan.database.TincanDatabaseSupplier) r0;
        r4 = r0.m17930k();	 Catch:{ Throwable -> 0x0027, all -> 0x0039 }
        r1 = super.a(r6);	 Catch:{ Throwable -> 0x001c, all -> 0x0048 }
        if (r4 == 0) goto L_0x0016;
    L_0x0013:
        r4.close();	 Catch:{  }
    L_0x0016:
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0.close();
    L_0x001b:
        return r1;
    L_0x001c:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x001e }
    L_0x001e:
        r1 = move-exception;
    L_0x001f:
        if (r4 == 0) goto L_0x0026;
    L_0x0021:
        if (r2 == 0) goto L_0x003b;
    L_0x0023:
        r4.close();	 Catch:{ Throwable -> 0x0034, all -> 0x0039 }
    L_0x0026:
        throw r1;	 Catch:{  }
    L_0x0027:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0029 }
    L_0x0029:
        r2 = move-exception;
        r3 = r1;
        r1 = r2;
    L_0x002c:
        if (r0 == 0) goto L_0x0033;
    L_0x002e:
        if (r3 == 0) goto L_0x0044;
    L_0x0030:
        r0.close();	 Catch:{ Throwable -> 0x003f }
    L_0x0033:
        throw r1;
    L_0x0034:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0026;
    L_0x0039:
        r1 = move-exception;
        goto L_0x002c;
    L_0x003b:
        r4.close();	 Catch:{  }
        goto L_0x0026;
    L_0x003f:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r0);
        goto L_0x0033;
    L_0x0044:
        r0.close();
        goto L_0x0033;
    L_0x0048:
        r1 = move-exception;
        r2 = r3;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbTincanPropertyUtil.a(com.facebook.messaging.tincan.database.DbTincanPropertyKey):java.lang.String");
    }
}
