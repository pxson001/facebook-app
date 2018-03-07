package com.facebook.messengerwear.support;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.WearableListenerService;
import javax.inject.Provider;

/* compiled from: photo_save_temp_photo_view */
public class MessengerWearDetectionService extends WearableListenerService {
    @Inject
    volatile Provider<MessengerWearSoftAlarm> f4990a = UltralightRuntime.a;
    @Inject
    MessengerWearHelper f4991b;

    private static <T extends Context> void m4533a(Class<T> cls, T t) {
        m4534a((Object) t, (Context) t);
    }

    public static void m4534a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MessengerWearDetectionService) obj).m4535a(IdBasedSingletonScopeProvider.a(fbInjector, 8614), MessengerWearHelper.b(fbInjector));
    }

    public final void mo133a(CapabilityInfo capabilityInfo) {
        super.mo133a(capabilityInfo);
        Class cls = MessengerWearDetectionService.class;
        m4534a((Object) this, (Context) this);
        if (this.f4991b.c()) {
            boolean a = this.f4991b.a();
            this.f4991b.a(capabilityInfo);
            if (!a && this.f4991b.a()) {
                ((MessengerWearSoftAlarm) this.f4990a.get()).m4560a();
            }
            Integer.valueOf(capabilityInfo.mo575b().size());
        }
    }

    private void m4535a(Provider<MessengerWearSoftAlarm> provider, MessengerWearHelper messengerWearHelper) {
        this.f4990a = provider;
        this.f4991b = messengerWearHelper;
    }
}
