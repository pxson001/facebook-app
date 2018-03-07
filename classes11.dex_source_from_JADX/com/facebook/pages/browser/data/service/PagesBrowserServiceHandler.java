package com.facebook.pages.browser.data.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.pages.browser.data.methods.FetchInitialRecommendedPages;
import com.facebook.pages.browser.data.methods.FetchRecommendedPagesInCategory;
import com.facebook.pages.browser.data.methods.FetchRecommendedPagesInCategory.Params;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: stroke */
public class PagesBrowserServiceHandler implements BlueServiceHandler {
    private static PagesBrowserServiceHandler f1284d;
    private static final Object f1285e = new Object();
    private final Provider<SingleMethodRunner> f1286a;
    private final FetchInitialRecommendedPages f1287b;
    private final FetchRecommendedPagesInCategory f1288c;

    private static PagesBrowserServiceHandler m1933b(InjectorLike injectorLike) {
        return new PagesBrowserServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new FetchInitialRecommendedPages(ResourcesMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike)), new FetchRecommendedPagesInCategory(ResourcesMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike)));
    }

    @Inject
    public PagesBrowserServiceHandler(Provider<SingleMethodRunner> provider, FetchInitialRecommendedPages fetchInitialRecommendedPages, FetchRecommendedPagesInCategory fetchRecommendedPagesInCategory) {
        this.f1286a = provider;
        this.f1287b = fetchInitialRecommendedPages;
        this.f1288c = fetchRecommendedPagesInCategory;
    }

    public final OperationResult m1934a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        String str = operationParams.b;
        if ("fetch_initial_recommended_pages".equals(str)) {
            return m1931a(this.f1287b, null);
        }
        if ("fetch_recommended_pages_in_category".equals(str)) {
            return m1931a(this.f1288c, (Params) bundle.getParcelable("fetchRecommendedPagesInCategory"));
        }
        throw new ApiMethodNotFoundException(str);
    }

    public static PagesBrowserServiceHandler m1932a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesBrowserServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1285e) {
                PagesBrowserServiceHandler pagesBrowserServiceHandler;
                if (a2 != null) {
                    pagesBrowserServiceHandler = (PagesBrowserServiceHandler) a2.a(f1285e);
                } else {
                    pagesBrowserServiceHandler = f1284d;
                }
                if (pagesBrowserServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1933b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1285e, b3);
                        } else {
                            f1284d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesBrowserServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m1931a(ApiMethod apiMethod, Parcelable parcelable) {
        return OperationResult.a(((AbstractSingleMethodRunner) this.f1286a.get()).a(apiMethod, parcelable));
    }
}
