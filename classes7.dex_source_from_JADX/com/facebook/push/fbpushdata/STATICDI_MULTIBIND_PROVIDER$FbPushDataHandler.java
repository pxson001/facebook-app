package com.facebook.push.fbpushdata;

import com.facebook.backgroundlocation.reporting.BackgroundLocationReportingPushDataHandler;
import com.facebook.events.photoreminder.EventPhotoUploadReminderPushDataHandler;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.push.fbpushdata.FbandroidFbPushDataHandler;
import com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler;
import com.facebook.push.mqttkick.MqttKickFbPushDataHandler;
import com.facebook.search.bootstrap.push.handlers.BootstrapPushHandler;
import com.facebook.today.push.TodayFbPushDataHandler;
import com.facebook.zero.push.handler.ZeroFbPushDataHandler;
import com.facebook.zero.push.handler.ZeroFreeFacebookLaunchPushDataHandler;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$FbPushDataHandler implements MultiBindIndexedProvider<FbPushDataHandler>, Provider<Set<FbPushDataHandler>> {
    private final InjectorLike f11294a;

    public STATICDI_MULTIBIND_PROVIDER$FbPushDataHandler(InjectorLike injectorLike) {
        this.f11294a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11294a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 9;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return BackgroundLocationReportingPushDataHandler.a(injector);
            case 1:
                return EventPhotoUploadReminderPushDataHandler.a(injector);
            case 2:
                return FbandroidFbPushDataHandler.a(injector);
            case 3:
                return OrcaFbPushDataHandler.a(injector);
            case 4:
                return MqttKickFbPushDataHandler.m13193a(injector);
            case 5:
                return BootstrapPushHandler.a(injector);
            case 6:
                return TodayFbPushDataHandler.a(injector);
            case 7:
                return ZeroFbPushDataHandler.a(injector);
            case 8:
                return ZeroFreeFacebookLaunchPushDataHandler.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
