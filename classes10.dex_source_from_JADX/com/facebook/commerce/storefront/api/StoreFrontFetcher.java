package com.facebook.commerce.storefront.api;

import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: createNewGroupChat */
public class StoreFrontFetcher {
    public final Provider<BlueServiceOperationFactory> f15696a;
    public final Lazy<ViewerContextManager> f15697b;

    @Inject
    public StoreFrontFetcher(Provider<BlueServiceOperationFactory> provider, Lazy<ViewerContextManager> lazy) {
        this.f15696a = provider;
        this.f15697b = lazy;
    }
}
