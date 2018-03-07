package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.proxygen.HTTPTransportCallback;

public final class zzg {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m287a(android.content.Context r13, int r14, java.lang.String r15) {
        /*
        r2 = 1;
        r3 = 0;
        r0 = r13.getResources();
        switch(r14) {
            case 1: goto L_0x0011;
            case 2: goto L_0x0048;
            case 3: goto L_0x0030;
            case 5: goto L_0x0074;
            case 7: goto L_0x006c;
            case 9: goto L_0x0060;
            case 16: goto L_0x007c;
            case 17: goto L_0x0088;
            case 18: goto L_0x003c;
            case 42: goto L_0x0054;
            default: goto L_0x0009;
        };
    L_0x0009:
        r1 = 2131233792; // 0x7f080c00 float:1.8083731E38 double:1.0529694E-314;
        r0 = r0.getString(r1);
    L_0x0010:
        return r0;
    L_0x0011:
        r5 = 1;
        r6 = 0;
        if (r0 != 0) goto L_0x0091;
    L_0x0015:
        r1 = r6;
        if (r1 == 0) goto L_0x0024;
    L_0x0018:
        r1 = 2131233777; // 0x7f080bf1 float:1.8083701E38 double:1.0529693925E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x0024:
        r1 = 2131233776; // 0x7f080bf0 float:1.80837E38 double:1.052969392E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x0030:
        r1 = 2131233780; // 0x7f080bf4 float:1.8083707E38 double:1.052969394E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x003c:
        r1 = 2131233787; // 0x7f080bfb float:1.8083721E38 double:1.0529693974E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x0048:
        r1 = 2131233784; // 0x7f080bf8 float:1.8083715E38 double:1.052969396E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x0054:
        r1 = 2131233785; // 0x7f080bf9 float:1.8083717E38 double:1.0529693964E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x0060:
        r1 = 2131233794; // 0x7f080c02 float:1.8083736E38 double:1.052969401E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x006c:
        r1 = 2131233789; // 0x7f080bfd float:1.8083725E38 double:1.0529693984E-314;
        r0 = r0.getString(r1);
        goto L_0x0010;
    L_0x0074:
        r1 = 2131233791; // 0x7f080bff float:1.808373E38 double:1.0529693994E-314;
        r0 = r0.getString(r1);
        goto L_0x0010;
    L_0x007c:
        r1 = 2131233797; // 0x7f080c05 float:1.8083742E38 double:1.0529694024E-314;
        r2 = new java.lang.Object[r2];
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        goto L_0x0010;
    L_0x0088:
        r1 = 2131233799; // 0x7f080c07 float:1.8083746E38 double:1.0529694033E-314;
        r0 = r0.getString(r1);
        goto L_0x0010;
    L_0x0091:
        r4 = r0.getConfiguration();
        r4 = r4.screenLayout;
        r4 = r4 & 15;
        r7 = 3;
        if (r4 <= r7) goto L_0x00c7;
    L_0x009c:
        r4 = r5;
    L_0x009d:
        r7 = com.google.android.gms.internal.zznx.m283a();
        if (r7 == 0) goto L_0x00a5;
    L_0x00a3:
        if (r4 != 0) goto L_0x00c4;
    L_0x00a5:
        r8 = 0;
        r9 = r0.getConfiguration();
        r12 = 13;
        r12 = com.google.android.gms.internal.zznx.m284a(r12);
        r10 = r12;
        if (r10 == 0) goto L_0x00c1;
    L_0x00b3:
        r10 = r9.screenLayout;
        r10 = r10 & 15;
        r11 = 3;
        if (r10 > r11) goto L_0x00c1;
    L_0x00ba:
        r9 = r9.smallestScreenWidthDp;
        r10 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r9 < r10) goto L_0x00c1;
    L_0x00c0:
        r8 = 1;
    L_0x00c1:
        r4 = r8;
        if (r4 == 0) goto L_0x0015;
    L_0x00c4:
        r6 = r5;
        goto L_0x0015;
    L_0x00c7:
        r4 = r6;
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzg.a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    public static String m288b(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return resources.getString(2131233778);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 42:
                return resources.getString(2131233795);
            case 3:
                return resources.getString(2131233781);
            default:
                return resources.getString(17039370);
        }
    }
}
