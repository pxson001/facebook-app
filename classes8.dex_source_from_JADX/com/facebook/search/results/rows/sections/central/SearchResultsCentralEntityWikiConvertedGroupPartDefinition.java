package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsEnvironment;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModule;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESULTS_LOADED */
public class SearchResultsCentralEntityWikiConvertedGroupPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsWikiModule>, Void, SearchResultsEnvironment> {
    private static final CacheableEntity f23669a = new C25331();
    private static SearchResultsCentralEntityWikiConvertedGroupPartDefinition f23670e;
    private static final Object f23671f = new Object();
    private final SearchResultsCentralEntityWikiTitleConvertedPartDefinition f23672b;
    private final SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition f23673c;
    private final SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition f23674d;

    /* compiled from: RESULTS_LOADED */
    final class C25331 implements CacheableEntity {
        C25331() {
        }

        public final String m27323g() {
            return null;
        }
    }

    private static SearchResultsCentralEntityWikiConvertedGroupPartDefinition m27325b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiConvertedGroupPartDefinition(SearchResultsCentralEntityWikiTitleConvertedPartDefinition.m27349a(injectorLike), SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition.m27299a(injectorLike), SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition.m27332a(injectorLike));
    }

    public final Object m27326a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        EdgesModel edgesModel = (EdgesModel) ((NodeModel) searchResultsProps.f23388a).bf().m9710a().get(0);
        SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState = (SearchResultsCentralEntityWikiState) ((SearchResultsEnvironment) anyEnvironment).a(SearchResultsCentralEntityWikiState.m27347a(edgesModel.m9705n()), f23669a);
        if (edgesModel.m9705n().jl_() == null || edgesModel.m9705n().jl_().m10625a().length() <= 150) {
            searchResultsCentralEntityWikiState.f23694b = false;
            searchResultsCentralEntityWikiState.f23693a = false;
        }
        baseMultiRowSubParts.a(this.f23672b, edgesModel.m9705n());
        SearchResultsProps a = SearchResultsProps.m27103a(((EdgesModel) ((NodeModel) searchResultsProps.f23388a).bf().m9710a().get(0)).m9705n(), searchResultsProps.f23390c);
        baseMultiRowSubParts.a(this.f23673c, a);
        if (searchResultsCentralEntityWikiState.m27348a()) {
            baseMultiRowSubParts.a(this.f23674d, a);
        }
        return null;
    }

    @Inject
    public SearchResultsCentralEntityWikiConvertedGroupPartDefinition(SearchResultsCentralEntityWikiTitleConvertedPartDefinition searchResultsCentralEntityWikiTitleConvertedPartDefinition, SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition searchResultsCentralEntityWikiAboutTextConvertedPartDefinition, SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition searchResultsCentralEntityWikiReadMoreConvertedPartDefinition) {
        this.f23672b = searchResultsCentralEntityWikiTitleConvertedPartDefinition;
        this.f23673c = searchResultsCentralEntityWikiAboutTextConvertedPartDefinition;
        this.f23674d = searchResultsCentralEntityWikiReadMoreConvertedPartDefinition;
    }

    public static SearchResultsCentralEntityWikiConvertedGroupPartDefinition m27324a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiConvertedGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23671f) {
                SearchResultsCentralEntityWikiConvertedGroupPartDefinition searchResultsCentralEntityWikiConvertedGroupPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiConvertedGroupPartDefinition = (SearchResultsCentralEntityWikiConvertedGroupPartDefinition) a2.a(f23671f);
                } else {
                    searchResultsCentralEntityWikiConvertedGroupPartDefinition = f23670e;
                }
                if (searchResultsCentralEntityWikiConvertedGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27325b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23671f, b3);
                        } else {
                            f23670e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiConvertedGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27327a(Object obj) {
        return true;
    }
}
