package com.facebook.loom.module;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: translation_id */
public class LoomStateDataSupplier implements FbCustomReportDataSupplier {
    private Lazy<NotificationControls> f2266a;

    @Inject
    public LoomStateDataSupplier(Lazy<NotificationControls> lazy) {
        this.f2266a = lazy;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo633a(java.lang.Throwable r10) {
        /*
        r9 = this;
        r7 = 32;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r7);
        r6 = 1;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x0013;
    L_0x000e:
        r6 = "async ";
        r5.append(r6);
    L_0x0013:
        r6 = 4;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x001f;
    L_0x001a:
        r6 = "qpl ";
        r5.append(r6);
    L_0x001f:
        r6 = 8;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x002c;
    L_0x0027:
        r6 = "other ";
        r5.append(r6);
    L_0x002c:
        r6 = 2;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x0038;
    L_0x0033:
        r6 = "lifecycle ";
        r5.append(r6);
    L_0x0038:
        r6 = 16;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x0045;
    L_0x0040:
        r6 = "fbtrace ";
        r5.append(r6);
    L_0x0045:
        r6 = com.facebook.loom.core.TraceEvents.a(r7);
        if (r6 == 0) goto L_0x0050;
    L_0x004b:
        r6 = "user_counters ";
        r5.append(r6);
    L_0x0050:
        r6 = 64;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x005d;
    L_0x0058:
        r6 = "system_counters ";
        r5.append(r6);
    L_0x005d:
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x006a;
    L_0x0065:
        r6 = "stack_frame ";
        r5.append(r6);
    L_0x006a:
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r6 = com.facebook.loom.core.TraceEvents.a(r6);
        if (r6 == 0) goto L_0x0077;
    L_0x0072:
        r6 = "liger ";
        r5.append(r6);
    L_0x0077:
        r5 = r5.toString();
        r1 = r5;
        r5 = com.facebook.loom.core.TraceOrchestrator.b();
        r7 = r5.e();
        r5 = 0;
        r8 = r7.iterator();
        r6 = r5;
    L_0x008a:
        r5 = r8.hasNext();
        if (r5 == 0) goto L_0x00a3;
    L_0x0090:
        r5 = r8.next();
        r5 = (java.io.File) r5;
        r5 = r5.getPath();
        r5 = r5.length();
        r5 = r5 + 1;
        r5 = r5 + r6;
        r6 = r5;
        goto L_0x008a;
    L_0x00a3:
        r8 = new java.lang.StringBuilder;
        r8.<init>(r6);
        r6 = r7.iterator();
    L_0x00ac:
        r5 = r6.hasNext();
        if (r5 == 0) goto L_0x00c6;
    L_0x00b2:
        r5 = r6.next();
        r5 = (java.io.File) r5;
        r5 = r5.getPath();
        r5 = r8.append(r5);
        r7 = 10;
        r5.append(r7);
        goto L_0x00ac;
    L_0x00c6:
        r5 = r8.toString();
        r2 = r5;
        r6 = "<none>";
        r8 = com.facebook.loom.core.TraceControl.b;
        r5 = r8;
        if (r5 == 0) goto L_0x00f6;
    L_0x00d2:
        r5 = r5.c();
        r7 = "AAAAAAAAAAA";
        r7 = r7.equals(r5);
        if (r7 != 0) goto L_0x00f6;
    L_0x00de:
        r3 = r5;
        r4 = "Trace ID: %s\nNotification visible: %s\nEnabled providers: %s\nTrace files: %s";
        r0 = r9.f2266a;
        r0 = r0.get();
        r0 = (com.facebook.loom.module.NotificationControls) r0;
        r0 = r0.a();
        r0 = java.lang.Boolean.valueOf(r0);
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r4, r3, r0, r1, r2);
        return r0;
    L_0x00f6:
        r5 = r6;
        goto L_0x00de;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.loom.module.LoomStateDataSupplier.a(java.lang.Throwable):java.lang.String");
    }

    public final String mo632a() {
        return "loom_state";
    }
}
