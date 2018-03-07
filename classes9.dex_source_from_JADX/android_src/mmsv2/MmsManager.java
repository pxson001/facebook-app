package android_src.mmsv2;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;

/* compiled from: setSettingsParams */
public class MmsManager {
    public static volatile boolean f3777a = false;
    private static SparseArray<Bundle> f3778b = new SparseArray();

    private static void m3540a(int i, Bundle bundle) {
        CarrierConfigValuesLoader carrierConfigValuesLoader = MmsService.f3799e;
        if (!(carrierConfigValuesLoader == null || (carrierConfigValuesLoader instanceof DefaultCarrierConfigValuesLoader))) {
            Bundle carrierConfigValues = Utils.m3581a(i).getCarrierConfigValues();
            Bundle a = MmsService.f3799e.mo117a(i);
            if (carrierConfigValues != null && a != null) {
                for (String str : a.keySet()) {
                    Object obj = a.get(str);
                    Object obj2 = carrierConfigValues.get(str);
                    if (!(obj == null || obj2 == null || obj.equals(obj2)) || ((obj != null && obj2 == null) || (obj == null && obj2 != null))) {
                        if (obj == null || (obj instanceof String)) {
                            bundle.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            bundle.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Boolean) {
                            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                        }
                    }
                }
            } else if (carrierConfigValues == null && a != null) {
                bundle.putAll(a);
            }
        }
        DefaultUserAgentInfoLoader defaultUserAgentInfoLoader = MmsService.f3801g;
        if (defaultUserAgentInfoLoader != null && !(defaultUserAgentInfoLoader instanceof DefaultUserAgentInfoLoader)) {
            bundle.putString("userAgent", defaultUserAgentInfoLoader.m3506a());
            bundle.putString("uaProfUrl", defaultUserAgentInfoLoader.m3507b());
        }
    }

    public static void m3539a(int i, Context context, Uri uri, String str, PendingIntent pendingIntent) {
        if (m3541a()) {
            int b = Utils.m3585b(i);
            Utils.m3581a(b).sendMultimediaMessage(context, uri, str, m3538a(b), pendingIntent);
            return;
        }
        MmsService.m3561a(context, new SendRequest(str, uri, pendingIntent));
    }

    public static boolean m3541a() {
        return Utils.m3583a() && !f3777a;
    }

    public static Bundle m3538a(int i) {
        if (!Utils.m3583a()) {
            return null;
        }
        Bundle bundle;
        synchronized (f3778b) {
            bundle = (Bundle) f3778b.get(i);
            if (bundle == null) {
                bundle = new Bundle();
                f3778b.put(i, bundle);
                m3540a(i, bundle);
            }
        }
        return bundle;
    }
}
