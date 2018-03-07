package com.facebook.pages.adminedpages;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.pages.adminedpages.backgroundtasks.AdminedPagesPrefetchBackgroundTaskConfig;
import com.facebook.pages.adminedpages.service.AdminedPagesCacheServiceHandler;
import com.facebook.pages.adminedpages.service.AdminedPagesDbServiceHandler;
import com.facebook.pages.adminedpages.service.AdminedPagesQueue;
import com.facebook.pages.adminedpages.service.AdminedPagesWebServiceHandler;

@InjectorModule
/* compiled from: f012e26db282d0a39b9554328af3365e */
public class AdminedPagesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static AdminedPagesPrefetchBackgroundTaskConfig m13120a() {
        return new AdminedPagesPrefetchBackgroundTaskConfig(true, 43200000);
    }

    @ProviderMethod
    @ContextScoped
    @AdminedPagesQueue
    static BlueServiceHandler m13119a(AdminedPagesCacheServiceHandler adminedPagesCacheServiceHandler, AdminedPagesDbServiceHandler adminedPagesDbServiceHandler, AdminedPagesWebServiceHandler adminedPagesWebServiceHandler) {
        return new FilterChainLink(adminedPagesCacheServiceHandler, new FilterChainLink(adminedPagesDbServiceHandler, adminedPagesWebServiceHandler));
    }
}
