package com.facebook.auth.login;

/* compiled from: syncObjectUUIDs */
class KindleSsoUtil$3 implements Runnable {
    final /* synthetic */ KindleSsoUtil f2299a;

    KindleSsoUtil$3(KindleSsoUtil kindleSsoUtil) {
        this.f2299a = kindleSsoUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r7 = this;
        r1 = android.os.Parcel.obtain();
        r2 = android.os.Parcel.obtain();
        r0 = "com.amazon.FacebookSSOService";
        r1.writeInterfaceToken(r0);	 Catch:{ Exception -> 0x0076 }
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x0076 }
        r0.<init>();	 Catch:{ Exception -> 0x0076 }
        r3 = "method_name";
        r4 = "getFBAccessToken";
        r0.putString(r3, r4);	 Catch:{ Exception -> 0x0076 }
        r3 = "app_id";
        r4 = r7.f2299a;	 Catch:{ Exception -> 0x0076 }
        r4 = r4.c;	 Catch:{ Exception -> 0x0076 }
        r4 = r4.c();	 Catch:{ Exception -> 0x0076 }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ Exception -> 0x0076 }
        r0.putLong(r3, r4);	 Catch:{ Exception -> 0x0076 }
        r1.writeBundle(r0);	 Catch:{ Exception -> 0x0076 }
        r0 = r7.f2299a;	 Catch:{ Exception -> 0x0076 }
        r0 = r0.f;	 Catch:{ Exception -> 0x0076 }
        r3 = 1;
        r4 = 0;
        r0.transact(r3, r1, r2, r4);	 Catch:{ Exception -> 0x0076 }
        r2.readException();	 Catch:{ Exception -> 0x0076 }
        r0 = r2.readBundle();	 Catch:{ Exception -> 0x0076 }
        r3 = "access_token";
        r3 = r0.getString(r3);	 Catch:{ Exception -> 0x0076 }
        r4 = com.facebook.common.util.StringUtil.a(r3);	 Catch:{ Exception -> 0x0076 }
        if (r4 == 0) goto L_0x006b;
    L_0x0049:
        r3 = r7.f2299a;	 Catch:{ Exception -> 0x0076 }
        r3 = r3.e;	 Catch:{ Exception -> 0x0076 }
        r4 = new java.lang.Exception;	 Catch:{ Exception -> 0x0076 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0076 }
        r6 = "No access token in reply: ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0076 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x0076 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0076 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0076 }
        r3.a(r4);	 Catch:{ Exception -> 0x0076 }
    L_0x0064:
        r1.recycle();
        r2.recycle();
    L_0x006a:
        return;
    L_0x006b:
        r0 = r7.f2299a;	 Catch:{  }
        r0 = r0.e;	 Catch:{  }
        r4 = 525787066; // 0x1f56dfba float:4.5501325E-20 double:2.597733263E-315;
        com.facebook.tools.dextr.runtime.detour.FutureDetour.a(r0, r3, r4);	 Catch:{  }
        goto L_0x0064;
    L_0x0076:
        r0 = move-exception;
        r3 = r7.f2299a;	 Catch:{ all -> 0x0085 }
        r3 = r3.e;	 Catch:{ all -> 0x0085 }
        r3.a(r0);	 Catch:{ all -> 0x0085 }
        r1.recycle();
        r2.recycle();
        goto L_0x006a;
    L_0x0085:
        r0 = move-exception;
        r1.recycle();
        r2.recycle();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.KindleSsoUtil$3.run():void");
    }
}
