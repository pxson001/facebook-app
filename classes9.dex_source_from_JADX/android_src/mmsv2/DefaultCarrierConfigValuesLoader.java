package android_src.mmsv2;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.facebook.debug.log.BLog;

/* compiled from: setUserSettings */
public class DefaultCarrierConfigValuesLoader implements CarrierConfigValuesLoader {
    private final Context f3758d;
    private final SparseArray<Bundle> f3759e = new SparseArray();

    public DefaultCarrierConfigValuesLoader(Context context) {
        this.f3758d = context;
    }

    public final Bundle mo117a(int i) {
        Bundle bundle;
        int b = Utils.m3585b(i);
        Object obj = null;
        synchronized (this) {
            bundle = (Bundle) this.f3759e.get(b);
            if (bundle == null) {
                bundle = new Bundle();
                this.f3759e.put(b, bundle);
                m3500a(b, bundle);
                obj = 1;
            }
        }
        if (obj != null) {
            new StringBuilder("Carrier configs loaded: ").append(bundle);
        }
        return bundle;
    }

    private void m3500a(int i, Bundle bundle) {
        m3502c(i, bundle);
        if (Utils.m3583a()) {
            m3501b(i, bundle);
        }
    }

    private static void m3501b(int i, Bundle bundle) {
        try {
            Bundle carrierConfigValues = Utils.m3581a(i).getCarrierConfigValues();
            if (carrierConfigValues != null) {
                bundle.putAll(carrierConfigValues);
            }
        } catch (Throwable e) {
            BLog.a("MmsLib", "Calling system getCarrierConfigValues exception", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3502c(int r5, final android.os.Bundle r6) {
        /*
        r4 = this;
        r0 = r4.f3758d;
        r1 = android_src.mmsv2.Utils.m3586b(r0, r5);
        r0 = 0;
        r1 = r1.getResources();	 Catch:{ NotFoundException -> 0x0025, all -> 0x0033 }
        r2 = 2131099652; // 0x7f060004 float:1.7811663E38 double:1.052903126E-314;
        r0 = r1.getXml(r2);	 Catch:{ NotFoundException -> 0x0025, all -> 0x0033 }
        r1 = new android_src.mmsv2.CarrierConfigXmlParser;	 Catch:{ NotFoundException -> 0x0025 }
        r2 = new android_src.mmsv2.DefaultCarrierConfigValuesLoader$1;	 Catch:{ NotFoundException -> 0x0025 }
        r2.<init>(r4, r6);	 Catch:{ NotFoundException -> 0x0025 }
        r1.<init>(r0, r2);	 Catch:{ NotFoundException -> 0x0025 }
        r1.m3473c();	 Catch:{ NotFoundException -> 0x0025 }
        if (r0 == 0) goto L_0x0024;
    L_0x0021:
        r0.close();
    L_0x0024:
        return;
    L_0x0025:
        r1 = move-exception;
        r1 = "MmsLib";
        r2 = "Can not get mms_config.xml";
        com.facebook.debug.log.BLog.b(r1, r2);	 Catch:{ all -> 0x003d }
        if (r0 == 0) goto L_0x0024;
    L_0x002f:
        r0.close();
        goto L_0x0024;
    L_0x0033:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: android_src.mmsv2.DefaultCarrierConfigValuesLoader.c(int, android.os.Bundle):void");
    }
}
