package com.facebook.search.fragment;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsPerformanceLogger;
import com.facebook.search.logging.perf.SearchWaterfallLogger;
import com.facebook.search.results.fragment.tabs.SearchResultsTabConfig;
import com.facebook.search.suggestions.log.ActivityLoggingUpdateTypeVisitor;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;

/* compiled from: ThrowbackMoreStoriesQuery */
public class GraphSearchNavigationControllerProvider extends AbstractAssistedProvider<GraphSearchNavigationController> {
    public final GraphSearchNavigationController m25430a(GraphSearchChildFragmentInstanceManager graphSearchChildFragmentInstanceManager, GraphSearchChildFragmentNavigator graphSearchChildFragmentNavigator, FragmentManager fragmentManager) {
        GraphSearchNavigationController graphSearchNavigationController = new GraphSearchNavigationController((Context) getInstance(Context.class), FbUriIntentHandler.a(this), GraphQLLinkExtractor.a(this), graphSearchChildFragmentInstanceManager, graphSearchChildFragmentNavigator, fragmentManager, SearchWaterfallLogger.m25591a((InjectorLike) this), GraphSearchErrorReporter.a(this), SearchResultsPerformanceLogger.m25495a((InjectorLike) this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), SearchResultsTabConfig.m26873a((InjectorLike) this), SearchBugReportExtraDataProvider.a(this), ActivityLoggingUpdateTypeVisitor.a(this));
        graphSearchNavigationController.m25423a(IdBasedSingletonScopeProvider.b(this, 3256), IdBasedSingletonScopeProvider.b(this, 3255), IdBasedLazy.a(this, 9835), IdBasedSingletonScopeProvider.b(this, 3375), IdBasedLazy.a(this, 10603), IdBasedSingletonScopeProvider.b(this, 968), IdBasedSingletonScopeProvider.b(this, 10581), IdBasedLazy.a(this, 10601));
        return graphSearchNavigationController;
    }
}
