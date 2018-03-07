package com.facebook.omnistore.module;

import com.facebook.analytics.CounterLogger;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.omnistore.module.STATICDI_MULTIBIND_PROVIDER.OmnistoreComponent;
import com.facebook.omnistore.module.STATICDI_MULTIBIND_PROVIDER.OmnistoreStoredProcedureComponent;
import java.util.concurrent.ExecutorService;

/* compiled from: text/x-vCard */
public class OmnistoreComponentManagerAutoProvider extends AbstractProvider<OmnistoreComponentManager> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreComponentManager(DefaultOmnistoreOpener.createInstance__com_facebook_omnistore_module_DefaultOmnistoreOpener__INJECTED_BY_TemplateInjector(this), OmnistoreComponent.getSet(this), OmnistoreStoredProcedureComponent.getSet(this), IdBasedProvider.a(this, 4443), ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(this), IdBasedProvider.a(this, 8765), IdBasedProvider.a(this, 8769), CounterLogger.a(this), (ExecutorService) IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(this));
    }
}
