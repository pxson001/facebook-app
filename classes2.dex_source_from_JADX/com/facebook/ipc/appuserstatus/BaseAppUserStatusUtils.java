package com.facebook.ipc.appuserstatus;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

/* compiled from: si */
public abstract class BaseAppUserStatusUtils {
    public static final UserStatus f4837a = new UserStatus(false, false, TriState.UNSET, false);
    private static final Class<?> f4838b = BaseAppUserStatusUtils.class;
    private final ContentResolver f4839c;
    private final AbstractFbErrorReporter f4840d;
    public final MonotonicClock f4841e;
    public final Map<String, StatusFetchResult> f4842f = new HashMap();
    public final Map<String, StatusFetchThreadHolder> f4843g = new HashMap();

    @Immutable
    /* compiled from: si */
    public class UserStatus {
        public final boolean f4844a;
        public final boolean f4845b;
        public final TriState f4846c;
        public final boolean f4847d;

        public UserStatus(boolean z, boolean z2, TriState triState, boolean z3) {
            this.f4844a = z;
            this.f4845b = z2;
            this.f4846c = triState;
            this.f4847d = z3;
        }
    }

    protected abstract String mo1268a();

    public BaseAppUserStatusUtils(ContentResolver contentResolver, AbstractFbErrorReporter abstractFbErrorReporter, MonotonicClock monotonicClock) {
        this.f4839c = contentResolver;
        this.f4840d = abstractFbErrorReporter;
        this.f4841e = monotonicClock;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.UserStatus m8681a(java.lang.String r11) {
        /*
        r10 = this;
        r8 = 0;
        r0 = r10.f4841e;
        r2 = r0.now();
        r1 = r10.f4842f;
        monitor-enter(r1);
        r0 = r10.f4842f;	 Catch:{ all -> 0x007a }
        r0 = r0.get(r11);	 Catch:{ all -> 0x007a }
        r0 = (com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.StatusFetchResult) r0;	 Catch:{ all -> 0x007a }
        if (r0 == 0) goto L_0x0025;
    L_0x0015:
        r4 = r0.b;	 Catch:{ all -> 0x007a }
        r4 = r2 - r4;
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0025;
    L_0x001f:
        r0 = r10.f4842f;	 Catch:{ all -> 0x007a }
        r0.remove(r11);	 Catch:{ all -> 0x007a }
        r0 = 0;
    L_0x0025:
        if (r0 == 0) goto L_0x002b;
    L_0x0027:
        r0 = r0.a;	 Catch:{ all -> 0x007a }
        monitor-exit(r1);	 Catch:{ all -> 0x007a }
    L_0x002a:
        return r0;
    L_0x002b:
        monitor-exit(r1);	 Catch:{ all -> 0x007a }
        r1 = r10.f4843g;
        monitor-enter(r1);
        r0 = r10.f4843g;	 Catch:{ all -> 0x007d }
        r0 = r0.get(r11);	 Catch:{ all -> 0x007d }
        r0 = (com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.StatusFetchThreadHolder) r0;	 Catch:{ all -> 0x007d }
        if (r0 != 0) goto L_0x0054;
    L_0x0039:
        r0 = new com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils$StatusFetchThreadHolder;	 Catch:{ all -> 0x007d }
        r4 = new com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils$StatusFetchRunnable;	 Catch:{ all -> 0x007d }
        r4.<init>(r10, r11);	 Catch:{ all -> 0x007d }
        r5 = 972924849; // 0x39fda7b1 float:4.838086E-4 double:4.80688744E-315;
        r4 = com.facebook.tools.dextr.runtime.detour.ThreadInitDetour.a(r4, r5);	 Catch:{ all -> 0x007d }
        r0.<init>(r4, r2);	 Catch:{ all -> 0x007d }
        r4 = r10.f4843g;	 Catch:{ all -> 0x007d }
        r4.put(r11, r0);	 Catch:{ all -> 0x007d }
        r4 = r0.a;	 Catch:{ all -> 0x007d }
        r4.start();	 Catch:{ all -> 0x007d }
    L_0x0054:
        monitor-exit(r1);	 Catch:{ all -> 0x007d }
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = r0.b;
        r2 = r2 - r6;
        r2 = r4 - r2;
        r2 = java.lang.Math.max(r8, r2);
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0069;
    L_0x0064:
        r0 = r0.a;	 Catch:{ InterruptedException -> 0x0080 }
        r0.join(r2);	 Catch:{ InterruptedException -> 0x0080 }
    L_0x0069:
        r1 = r10.f4842f;
        monitor-enter(r1);
        r0 = r10.f4842f;	 Catch:{ all -> 0x0089 }
        r0 = r0.get(r11);	 Catch:{ all -> 0x0089 }
        r0 = (com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.StatusFetchResult) r0;	 Catch:{ all -> 0x0089 }
        monitor-exit(r1);	 Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x008c;
    L_0x0077:
        r0 = r0.a;
        goto L_0x002a;
    L_0x007a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x007d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x0080:
        r0 = move-exception;
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        goto L_0x0069;
    L_0x0089:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x008c:
        r0 = r10.f4840d;
        r1 = "BASE_APP_USER_STATUS_PROVIDER Default status returned";
        r2 = new java.lang.StringBuilder;
        r3 = "Unable to retrieve status from ";
        r2.<init>(r3);
        r3 = r10.mo1268a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.m2340a(r1, r2);
        r0 = f4838b;
        r1 = "Remote app took too long to respond, using default status.";
        com.facebook.debug.log.BLog.a(r0, r1);
        r0 = f4837a;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.a(java.lang.String):com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils$UserStatus");
    }

    public static UserStatus m8680b(BaseAppUserStatusUtils baseAppUserStatusUtils, String str) {
        TriState triState = TriState.UNSET;
        try {
            boolean z;
            TriState triState2;
            boolean z2;
            boolean z3;
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5137a("userId", str);
            Cursor query = baseAppUserStatusUtils.f4839c.query(Uri.parse(baseAppUserStatusUtils.mo1268a()), null, objectNode.toString(), null, null);
            if (query != null) {
                z = false;
                triState2 = triState;
                boolean z4 = false;
                z2 = false;
                while (query.moveToNext()) {
                    try {
                        z2 = query.getInt(0) > BaseAppUserStatusContract.b.intValue();
                        if (z2) {
                            z4 = true;
                            break;
                        }
                        if (query.getColumnCount() >= 2) {
                            z3 = query.getInt(1) > BaseAppUserStatusContract.b.intValue();
                        } else {
                            z3 = z4;
                        }
                        if (query.getColumnCount() >= 3) {
                            triState2 = query.getInt(2) > BaseAppUserStatusContract.b.intValue() ? TriState.YES : TriState.NO;
                        }
                        if (query.getColumnCount() >= 4) {
                            if (query.getInt(3) > BaseAppUserStatusContract.b.intValue()) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            z = z4;
                            z4 = z3;
                        } else {
                            z4 = z3;
                        }
                    } finally {
                        query.close();
                    }
                }
                z3 = z2;
                z2 = z4;
            } else {
                z = false;
                triState2 = triState;
                z2 = false;
                z3 = false;
            }
            return new UserStatus(z3, z2, triState2, z);
        } catch (SecurityException e) {
            return new UserStatus(false, false, TriState.UNSET, false);
        } catch (Throwable e2) {
            baseAppUserStatusUtils.f4840d.m2343a("BASE_APP_USER_STATUS_PROVIDER", "Exception in BaseAppUserStatusProvider", e2);
            return new UserStatus(false, false, TriState.UNSET, false);
        }
    }
}
