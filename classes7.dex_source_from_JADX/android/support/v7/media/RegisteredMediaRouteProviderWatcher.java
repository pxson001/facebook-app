package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: current_cap */
public final class RegisteredMediaRouteProviderWatcher {
    public final Context f16365a;
    private final Callback f16366b;
    public final Handler f16367c;
    private final PackageManager f16368d;
    public final ArrayList<RegisteredMediaRouteProvider> f16369e = new ArrayList();
    public boolean f16370f;
    public final BroadcastReceiver f16371g = new C12881(this);
    public final Runnable f16372h = new C12892(this);

    /* compiled from: current_cap */
    public interface Callback {
        void mo1256a(MediaRouteProvider mediaRouteProvider);

        void mo1257b(MediaRouteProvider mediaRouteProvider);
    }

    /* compiled from: current_cap */
    class C12881 extends BroadcastReceiver {
        final /* synthetic */ RegisteredMediaRouteProviderWatcher f16363a;

        C12881(RegisteredMediaRouteProviderWatcher registeredMediaRouteProviderWatcher) {
            this.f16363a = registeredMediaRouteProviderWatcher;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1854138675);
            RegisteredMediaRouteProviderWatcher.m20451b(this.f16363a);
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 638790680, a);
        }
    }

    /* compiled from: current_cap */
    class C12892 implements Runnable {
        final /* synthetic */ RegisteredMediaRouteProviderWatcher f16364a;

        C12892(RegisteredMediaRouteProviderWatcher registeredMediaRouteProviderWatcher) {
            this.f16364a = registeredMediaRouteProviderWatcher;
        }

        public void run() {
            RegisteredMediaRouteProviderWatcher.m20451b(this.f16364a);
        }
    }

    public RegisteredMediaRouteProviderWatcher(Context context, Callback callback) {
        this.f16365a = context;
        this.f16366b = callback;
        this.f16367c = new Handler();
        this.f16368d = context.getPackageManager();
    }

    public static void m20451b(RegisteredMediaRouteProviderWatcher registeredMediaRouteProviderWatcher) {
        if (registeredMediaRouteProviderWatcher.f16370f) {
            RegisteredMediaRouteProvider registeredMediaRouteProvider;
            int i = 0;
            for (ResolveInfo resolveInfo : registeredMediaRouteProviderWatcher.f16368d.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0)) {
                int i2;
                PackageItemInfo packageItemInfo = resolveInfo.serviceInfo;
                if (packageItemInfo != null) {
                    int i3;
                    String str = packageItemInfo.packageName;
                    String str2 = packageItemInfo.name;
                    int size = registeredMediaRouteProviderWatcher.f16369e.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        RegisteredMediaRouteProvider registeredMediaRouteProvider2 = (RegisteredMediaRouteProvider) registeredMediaRouteProviderWatcher.f16369e.get(i4);
                        Object obj = (registeredMediaRouteProvider2.f16356b.getPackageName().equals(str) && registeredMediaRouteProvider2.f16356b.getClassName().equals(str2)) ? 1 : null;
                        if (obj != null) {
                            i3 = i4;
                            break;
                        }
                    }
                    i3 = -1;
                    int i5 = i3;
                    if (i5 < 0) {
                        MediaRouteProvider registeredMediaRouteProvider3 = new RegisteredMediaRouteProvider(registeredMediaRouteProviderWatcher.f16365a, new ComponentName(packageItemInfo.packageName, packageItemInfo.name));
                        registeredMediaRouteProvider3.m20448f();
                        i2 = i + 1;
                        registeredMediaRouteProviderWatcher.f16369e.add(i, registeredMediaRouteProvider3);
                        registeredMediaRouteProviderWatcher.f16366b.mo1256a(registeredMediaRouteProvider3);
                        i = i2;
                    } else if (i5 >= i) {
                        registeredMediaRouteProvider = (RegisteredMediaRouteProvider) registeredMediaRouteProviderWatcher.f16369e.get(i5);
                        registeredMediaRouteProvider.m20448f();
                        registeredMediaRouteProvider.m20450h();
                        i2 = i + 1;
                        Collections.swap(registeredMediaRouteProviderWatcher.f16369e, i5, i);
                        i = i2;
                    }
                }
                i2 = i;
                i = i2;
            }
            if (i < registeredMediaRouteProviderWatcher.f16369e.size()) {
                for (int size2 = registeredMediaRouteProviderWatcher.f16369e.size() - 1; size2 >= i; size2--) {
                    registeredMediaRouteProvider = (RegisteredMediaRouteProvider) registeredMediaRouteProviderWatcher.f16369e.get(size2);
                    registeredMediaRouteProviderWatcher.f16366b.mo1257b(registeredMediaRouteProvider);
                    registeredMediaRouteProviderWatcher.f16369e.remove(registeredMediaRouteProvider);
                    registeredMediaRouteProvider.m20449g();
                }
            }
        }
    }
}
