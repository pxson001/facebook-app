package com.facebook.search.results.fragment.tabs;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.search.abtest.CommerceSearchExperimentHelper;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.abtest.VideoSearchExperimentHelper;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecHelper;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SECONDS_SINCE_GREATER_THAN */
public class SearchResultsTabConfig {
    private static SearchResultsTabConfig f23168e;
    private static final Object f23169f = new Object();
    private final boolean f23170a;
    private final QeAccessor f23171b;
    private final CommerceSearchExperimentHelper f23172c;
    private final VideoSearchExperimentHelper f23173d;

    private static SearchResultsTabConfig m26875b(InjectorLike injectorLike) {
        return new SearchResultsTabConfig(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CommerceSearchExperimentHelper.a(injectorLike), VideoSearchExperimentHelper.b(injectorLike));
    }

    @Inject
    public SearchResultsTabConfig(Boolean bool, QeAccessor qeAccessor, CommerceSearchExperimentHelper commerceSearchExperimentHelper, VideoSearchExperimentHelper videoSearchExperimentHelper) {
        this.f23170a = bool.booleanValue();
        this.f23171b = qeAccessor;
        this.f23172c = commerceSearchExperimentHelper;
        this.f23173d = videoSearchExperimentHelper;
    }

    public static boolean m26874a(@Nullable GraphSearchQuerySpec graphSearchQuerySpec, GatekeeperStoreImpl gatekeeperStoreImpl) {
        return GraphSearchQuerySpecHelper.m25628a(graphSearchQuerySpec) || GraphSearchQuerySpecHelper.m25629b(graphSearchQuerySpec) || gatekeeperStoreImpl.a(SearchAbTestGatekeepers.h, false);
    }

    public static SearchResultsTabConfig m26873a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTabConfig b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23169f) {
                SearchResultsTabConfig searchResultsTabConfig;
                if (a2 != null) {
                    searchResultsTabConfig = (SearchResultsTabConfig) a2.a(f23169f);
                } else {
                    searchResultsTabConfig = f23168e;
                }
                if (searchResultsTabConfig == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26875b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23169f, b3);
                        } else {
                            f23168e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTabConfig;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ImmutableList<SearchResultsTab> m26877a(GraphSearchQuerySpec graphSearchQuerySpec) {
        int i = 0;
        if (this.f23170a) {
            return SearchResultsTab.WORK_TABS;
        }
        if (GraphSearchQuerySpecHelper.m25628a(graphSearchQuerySpec)) {
            return SearchResultsTab.VIDEO_HOME_TABS;
        }
        if (this.f23171b.a(ExperimentsForSearchAbTestModule.al, false)) {
            return SearchResultsTab.I18N_TOP_ENTITIES_TABS;
        }
        if (this.f23171b.a(ExperimentsForSearchAbTestModule.aj, false)) {
            return SearchResultsTab.I18N_TABS;
        }
        Builder builder = new Builder();
        builder.c(m26876b(graphSearchQuerySpec) ? SearchResultsTab.TOP_REACTION : SearchResultsTab.TOP);
        ImmutableList immutableList = SearchResultsTab.SECONDARY_TABS;
        int size = immutableList.size();
        while (i < size) {
            SearchResultsTab searchResultsTab = (SearchResultsTab) immutableList.get(i);
            if (searchResultsTab != SearchResultsTab.MARKETPLACE || this.f23172c.a()) {
                if (searchResultsTab == SearchResultsTab.VIDEOS) {
                    VideoSearchExperimentHelper videoSearchExperimentHelper = this.f23173d;
                    boolean z = true;
                    int a = videoSearchExperimentHelper.a.a(ExperimentsForSearchAbTestModule.F, -1);
                    if (a == -1) {
                        z = videoSearchExperimentHelper.b.a(SearchAbTestGatekeepers.H, false);
                    } else if (a != 1) {
                        z = false;
                    }
                    if (!z) {
                    }
                }
                builder.c(searchResultsTab);
            }
            i++;
        }
        return builder.b();
    }

    public static boolean m26876b(GraphSearchQuerySpec graphSearchQuerySpec) {
        return (graphSearchQuerySpec.mo1221m() == null || !ReactionSurfaceUtil.m4784k(graphSearchQuerySpec.mo1221m().f22250e) || (Strings.isNullOrEmpty(graphSearchQuerySpec.mo1221m().f22246a) && Strings.isNullOrEmpty(graphSearchQuerySpec.mo1221m().f22248c))) ? false : true;
    }
}
