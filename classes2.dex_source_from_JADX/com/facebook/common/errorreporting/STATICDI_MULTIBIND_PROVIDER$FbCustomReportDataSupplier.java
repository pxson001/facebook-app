package com.facebook.common.errorreporting;

import com.facebook.abtest.qe.log.QuickExperimentReportDataSupplier;
import com.facebook.apptab.ui.chrome.FragmentCoordinatorLogger;
import com.facebook.common.activitycleaner.ActivityStackManager;
import com.facebook.common.errorreporting.experimental.FileDescriptorCrashDataSupplier;
import com.facebook.common.errorreporting.memory.ClassInstanceCountReportDataSupplier;
import com.facebook.common.errorreporting.memory.STATICDI_MULTIBIND_PROVIDER$ClassInstancesToLog;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.composer.savedsession.ComposerSessionDataSupplier;
import com.facebook.dialtone.DialtoneAsyncSignalFile;
import com.facebook.dialtone.DialtoneStateDataSupplier;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.http.common.NetworkFlightRecorderReportDataSupplier;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.module.LoomConfigDataSupplier;
import com.facebook.loom.module.LoomStateDataSupplier;
import com.facebook.mqtt.diagnostics.MqttFlightRecorder;
import com.facebook.mqtt.diagnostics.MqttFlightRecorderReportDataSupplier;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.push.mqtt.service.ClientSubscriptionDataSupplier;
import com.facebook.push.mqtt.service.MqttHealthStatsDataSupplier;
import com.facebook.push.mqtt.service.MqttPushServiceClientFlightRecorder;
import com.facebook.push.mqtt.service.MqttPushServiceClientFlightRecorderDataSupplier;
import com.facebook.richdocument.logging.RichDocumentReportDataSupplier;
import com.facebook.video.engine.VideoReportDataSupplier;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbCustomReportDataSupplier implements MultiBindIndexedProvider<FbCustomReportDataSupplier>, Provider<Set<FbCustomReportDataSupplier>> {
    private final InjectorLike f2066a;

    public STATICDI_MULTIBIND_PROVIDER$FbCustomReportDataSupplier(InjectorLike injectorLike) {
        this.f2066a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2066a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 17;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return QuickExperimentReportDataSupplier.m4218a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return FragmentCoordinatorLogger.m4277a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ActivityStackManager.m4298a((InjectorLike) injector);
            case 3:
                return new FileDescriptorCrashDataSupplier();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new ClassInstanceCountReportDataSupplier(new MultiBinderSet(injector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ClassInstancesToLog(injector)), Random_InsecureRandomMethodAutoProvider.m2102a(injector));
            case 5:
                return new ComposerSessionDataSupplier(IdBasedSingletonScopeProvider.m1810b(injector, 5282));
            case 6:
                return new DialtoneStateDataSupplier(DialtoneAsyncSignalFile.m4396b((InjectorLike) injector));
            case 7:
                return NewsFeedEventLogger.m4405a((InjectorLike) injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return NetworkFlightRecorderReportDataSupplier.m4422a((InjectorLike) injector);
            case 9:
                return new LoomConfigDataSupplier(IdBasedSingletonScopeProvider.m1810b(injector, 3749));
            case 10:
                return new LoomStateDataSupplier(IdBasedSingletonScopeProvider.m1810b(injector, 2515));
            case 11:
                return new MqttFlightRecorderReportDataSupplier(MqttFlightRecorder.m4451a(injector));
            case 12:
                return new ClientSubscriptionDataSupplier(IdBasedSingletonScopeProvider.m1810b(injector, 3195));
            case 13:
                return new MqttHealthStatsDataSupplier(IdBasedLazy.m1808a(injector, 3208));
            case 14:
                return new MqttPushServiceClientFlightRecorderDataSupplier(MqttPushServiceClientFlightRecorder.m4462a(injector));
            case 15:
                return new RichDocumentReportDataSupplier(FbSharedPreferencesImpl.m1826a((InjectorLike) injector));
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return new VideoReportDataSupplier(IdBasedSingletonScopeProvider.m1810b(injector, 3668));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
