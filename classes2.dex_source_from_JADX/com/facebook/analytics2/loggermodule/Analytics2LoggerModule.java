package com.facebook.analytics2.loggermodule;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.analytics.Analytics2ProcessPolicy;
import com.facebook.analytics.NewAnalyticsSamplingPolicy;
import com.facebook.analytics2.beacon.BeaconGeneratingEventListener;
import com.facebook.analytics2.beacon.BeaconLogger;
import com.facebook.analytics2.logger.Analytics2Logger;
import com.facebook.analytics2.logger.Analytics2Logger.Builder;
import com.facebook.analytics2.logger.CompositeEventListener;
import com.facebook.analytics2.logger.EventListener;
import com.facebook.analytics2.logger.ProcessPolicy;
import com.facebook.analytics2.logger.SamplingPolicy;
import com.facebook.analytics2.logger.SessionManager;
import com.facebook.analytics2.loggermodule.Analytics2BatchSizeExperiment.NormalPriMaxEventsPerBatchProvider;
import com.facebook.analytics2.loggermodule.Analytics2BatchSizeExperiment.NormalPriUploadSchedulerParamsProvider;
import com.facebook.analytics2.uploader.fbhttp.FbHttpUploader;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
@SuppressLint({"ProviderUsage"})
/* compiled from: target_tab_name */
public class Analytics2LoggerModule extends AbstractLibraryModule {

    /* compiled from: target_tab_name */
    public final class C02003 {
        final /* synthetic */ Provider f3183a;

        C02003(Provider provider) {
            this.f3183a = provider;
        }

        public final boolean m5348a() {
            return ((Boolean) this.f3183a.get()).booleanValue();
        }
    }

    /* compiled from: target_tab_name */
    public final class C02012 {
        final /* synthetic */ Lazy f3184a;

        C02012(Lazy lazy) {
            this.f3184a = lazy;
        }

        public final String m5349a() {
            return ((UniqueIdForDeviceHolderImpl) this.f3184a.get()).m4346a();
        }
    }

    /* compiled from: target_tab_name */
    public final class C02021 {
        public final /* synthetic */ Lazy f3185a;

        C02021(Lazy lazy) {
            this.f3185a = lazy;
        }
    }

    public void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static Analytics2Logger m5327a(Context context, EventListener eventListener, EventListener eventListener2, Provider<Boolean> provider, Lazy<UniqueIdForDeviceHolder> lazy, SessionManager sessionManager, ProcessPolicy processPolicy, SamplingPolicy samplingPolicy, Class cls, Lazy<QeAccessor> lazy2, FbandroidAppInfoProvider fbandroidAppInfoProvider, Lazy<FbNetworkManager> lazy3, Class cls2, Lazy<AppInitLock> lazy4) {
        EventListener compositeEventListener = new CompositeEventListener();
        EventListener compositeEventListener2 = new CompositeEventListener();
        compositeEventListener.m5329a(eventListener);
        compositeEventListener2.m5329a(eventListener2);
        Analytics2Logger a = new Builder(context).m5335a(compositeEventListener).m5345b(compositeEventListener2).m5341a(new C02003(provider)).m5342a(fbandroidAppInfoProvider).m5340a(new C02012(lazy)).m5339a(new C02021(lazy3)).m5336a(new NormalPriMaxEventsPerBatchProvider(lazy4, lazy2)).m5338a(new NormalPriUploadSchedulerParamsProvider(lazy4, lazy2)).m5343a(FbHttpUploader.class).m5337a(sessionManager).m5333a((Analytics2ProcessPolicy) processPolicy).m5334a((NewAnalyticsSamplingPolicy) samplingPolicy).m5346b(cls).m5347c(cls2).m5344a();
        compositeEventListener.m5329a(new BeaconGeneratingEventListener(BeaconLogger.m5411a(context, a)));
        compositeEventListener2.m5329a(new BeaconGeneratingEventListener(BeaconLogger.m5412b(context, a)));
        return a;
    }
}
