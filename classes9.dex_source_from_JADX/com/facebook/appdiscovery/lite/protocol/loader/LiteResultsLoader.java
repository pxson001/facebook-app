package com.facebook.appdiscovery.lite.protocol.loader;

import android.content.Context;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryError;
import com.facebook.appdiscovery.lite.common.error.AppDiscoveryException;
import com.facebook.appdiscovery.lite.model.AppDiscoveryResults;
import com.facebook.appdiscovery.lite.model.factory.AppDetailsFeedUnitFactory;
import com.facebook.appdiscovery.lite.model.factory.AppDiscoveryFeedUnitFactory;
import com.facebook.appdiscovery.lite.model.factory.AppDiscoveryUnsupportedUnitFactory;
import com.facebook.appdiscovery.lite.model.factory.LiteRelatedAppsFeedUnitFactory;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppSectionQueryFragmentModel;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.FetchLiteResultsQueryModel;
import com.facebook.appdiscovery.lite.protocol.loader.LiteResultsGraphQLConverter.C03791;
import com.facebook.appdiscovery.lite.ui.AppDiscoveryLiteFragment;
import com.facebook.appdiscovery.lite.ui.AppDiscoveryLiteFragment.LiteResultsListener;
import com.facebook.appdiscovery.lite.ui.widget.resultspage.AppDiscoveryPage.State;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: seller_profile_id */
public class LiteResultsLoader {
    private static LiteResultsLoader f4128e;
    private static final Object f4129f = new Object();
    public final GraphQLQueryExecutor f4130a;
    public final TasksManager f4131b;
    public final LiteResultsGraphQLConverter f4132c;
    public LiteResultsListener f4133d;

    /* compiled from: seller_profile_id */
    public class C03801 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiteResultsQueryModel>> {
        final /* synthetic */ LiteResultsLoader f4127a;

        public C03801(LiteResultsLoader liteResultsLoader) {
            this.f4127a = liteResultsLoader;
        }

        protected final void m4181a(Object obj) {
            AppDiscoveryResults appDiscoveryResults;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            LiteResultsListener liteResultsListener = this.f4127a.f4133d;
            LiteResultsGraphQLConverter liteResultsGraphQLConverter = this.f4127a.f4132c;
            FetchLiteResultsQueryModel fetchLiteResultsQueryModel = (FetchLiteResultsQueryModel) graphQLResult.e;
            if (fetchLiteResultsQueryModel == null || fetchLiteResultsQueryModel.m4153a() == null || fetchLiteResultsQueryModel.m4153a().m4059a() == null || fetchLiteResultsQueryModel.m4153a().m4059a().m4055a().size() <= 0) {
                appDiscoveryResults = null;
            } else {
                Builder builder = ImmutableList.builder();
                ImmutableList a = fetchLiteResultsQueryModel.m4153a().m4059a().m4055a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    AppSectionQueryFragmentModel appSectionQueryFragmentModel = (AppSectionQueryFragmentModel) a.get(i);
                    FeedUnit feedUnit = null;
                    if (appSectionQueryFragmentModel != null) {
                        AppDiscoveryUnsupportedUnitFactory appDiscoveryUnsupportedUnitFactory;
                        switch (C03791.f4123a[appSectionQueryFragmentModel.m4090k().ordinal()]) {
                            case 1:
                                appDiscoveryUnsupportedUnitFactory = liteResultsGraphQLConverter.f4124a;
                                break;
                            case 2:
                                appDiscoveryUnsupportedUnitFactory = liteResultsGraphQLConverter.f4125b;
                                break;
                            default:
                                appDiscoveryUnsupportedUnitFactory = liteResultsGraphQLConverter.f4126c;
                                break;
                        }
                        AppDiscoveryFeedUnitFactory appDiscoveryFeedUnitFactory = appDiscoveryUnsupportedUnitFactory;
                        if (appDiscoveryFeedUnitFactory != null) {
                            feedUnit = appDiscoveryFeedUnitFactory.a(appSectionQueryFragmentModel);
                        }
                    }
                    FeedUnit feedUnit2 = feedUnit;
                    if (feedUnit2 != null) {
                        builder.c(feedUnit2);
                    }
                }
                appDiscoveryResults = new AppDiscoveryResults(builder.b());
            }
            liteResultsListener.m4193a(appDiscoveryResults);
        }

        protected final void m4182a(Throwable th) {
            LiteResultsListener liteResultsListener = this.f4127a.f4133d;
            AppDiscoveryException appDiscoveryException = new AppDiscoveryException(th, AppDiscoveryError.FETCH_LITE_RESULTS_FAIL);
            liteResultsListener.f4142a.aA.setState(State.ERROR);
            AppDiscoveryLiteFragment.m4194a(liteResultsListener.f4142a, "app_discovery_lite_load_failed");
        }
    }

    private static LiteResultsLoader m4184b(InjectorLike injectorLike) {
        return new LiteResultsLoader(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), new LiteResultsGraphQLConverter(AppDetailsFeedUnitFactory.a(injectorLike), LiteRelatedAppsFeedUnitFactory.a(injectorLike), AppDiscoveryUnsupportedUnitFactory.a(injectorLike)));
    }

    @Inject
    public LiteResultsLoader(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, LiteResultsGraphQLConverter liteResultsGraphQLConverter) {
        this.f4130a = graphQLQueryExecutor;
        this.f4131b = tasksManager;
        this.f4132c = liteResultsGraphQLConverter;
    }

    public static LiteResultsLoader m4183a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiteResultsLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4129f) {
                LiteResultsLoader liteResultsLoader;
                if (a2 != null) {
                    liteResultsLoader = (LiteResultsLoader) a2.a(f4129f);
                } else {
                    liteResultsLoader = f4128e;
                }
                if (liteResultsLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4184b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4129f, b3);
                        } else {
                            f4128e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liteResultsLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m4185a(LiteResultsListener liteResultsListener) {
        if (this.f4133d != null) {
            this.f4131b.c("appdiscovery_results_loader_key");
        }
        this.f4133d = liteResultsListener;
    }
}
