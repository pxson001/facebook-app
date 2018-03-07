package com.facebook.platform.webdialogs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.platform.webdialogs.PlatformWebDialogsFragment.C12661;
import com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsBridgeApi;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: location_lacking_timestamp */
public class PlatformWebDialogsActivity extends FbFragmentActivity {
    @Inject
    public PlatformWebDialogsPerformanceLogger f8487p;
    private PlatformWebDialogsFragment f8488q;

    private static <T extends Context> void m8390a(Class<T> cls, T t) {
        m8391a((Object) t, (Context) t);
    }

    public static void m8391a(Object obj, Context context) {
        ((PlatformWebDialogsActivity) obj).f8487p = PlatformWebDialogsPerformanceLogger.m8413a(FbInjector.get(context));
    }

    protected final void m8392b(Bundle bundle) {
        super.b(bundle);
        Class cls = PlatformWebDialogsActivity.class;
        m8391a((Object) this, (Context) this);
        this.f8487p.m8423b();
        setContentView(2130907768);
        this.f8488q = new PlatformWebDialogsFragment();
        kO_().a().a(2131568519, this.f8488q).b();
    }

    private void m8389a(PlatformWebDialogsPerformanceLogger platformWebDialogsPerformanceLogger) {
        this.f8487p = platformWebDialogsPerformanceLogger;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f8488q != null) {
            PlatformWebDialogsFragment platformWebDialogsFragment = this.f8488q;
            if (platformWebDialogsFragment.aq != null) {
                JSONObject a;
                PlatformWebDialogsBridgeApi platformWebDialogsBridgeApi = platformWebDialogsFragment.aq;
                Bundle extras = intent.getExtras();
                Bundle a2 = platformWebDialogsBridgeApi.f8545a.a(platformWebDialogsBridgeApi.f8536a);
                if (a2 == null) {
                    a2 = new Bundle();
                }
                a2.putAll(extras);
                String string = a2.getString("com.facebook.platform.extra.APPLICATION_ID");
                a2.remove("com.facebook.platform.extra.APPLICATION_ID");
                a2.putString("app_id", string);
                int i3 = a2.getInt("com.facebook.platform.protocol.PROTOCOL_VERSION");
                a2.remove("com.facebook.platform.protocol.PROTOCOL_VERSION");
                a2.putInt("version", i3);
                Bundle bundle = a2.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
                if (bundle != null) {
                    a2.remove("com.facebook.platform.protocol.RESULT_ARGS");
                    a = platformWebDialogsBridgeApi.f8545a.a(bundle);
                    if (a != null) {
                        a2.putString("method_results", a.toString());
                    }
                }
                bundle = a2.getBundle("com.facebook.platform.protocol.BRIDGE_ARGS");
                if (bundle != null) {
                    a2.remove("com.facebook.platform.protocol.BRIDGE_ARGS");
                    a = platformWebDialogsBridgeApi.f8545a.a(bundle);
                    if (a != null) {
                        a2.putString("bridge_args", a.toString());
                    }
                }
                platformWebDialogsFragment.f8504c.m8439a(platformWebDialogsFragment.ao, platformWebDialogsFragment.ap.f8537b, platformWebDialogsBridgeApi.f8545a.a(a2));
            }
        }
    }

    public void onBackPressed() {
        if (this.f8488q != null) {
            PlatformWebDialogsFragment platformWebDialogsFragment = this.f8488q;
            if (!platformWebDialogsFragment.as) {
                platformWebDialogsFragment.as = true;
                platformWebDialogsFragment.f8504c.m8439a(platformWebDialogsFragment.ao, "fbPlatformDialogMustClose", null);
                HandlerDetour.b(new Handler(Looper.getMainLooper()), new C12661(platformWebDialogsFragment), 500, -940467906);
                return;
            }
            return;
        }
        super.onBackPressed();
    }
}
