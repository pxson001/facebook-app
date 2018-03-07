package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.rows.sections.header.SearchResultsHeaderComponentPartDefinition.HeaderProps;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Pre-logout xconfig sync failed */
public class SearchResultsVideosHeaderPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation & HasSearchResultsContext> extends BaseMultiRowGroupPartDefinition<SearchResultsEdge, Void, E> {
    private static SearchResultsVideosHeaderPartDefinition f24423c;
    private static final Object f24424d = new Object();
    private final SearchResultsTitlePartDefinition f24425a;
    private final SearchResultsHeaderComponentPartDefinition<E> f24426b;

    private static SearchResultsVideosHeaderPartDefinition m27897b(InjectorLike injectorLike) {
        return new SearchResultsVideosHeaderPartDefinition(SearchResultsTitlePartDefinition.m27890a(injectorLike), SearchResultsHeaderComponentPartDefinition.m27871a(injectorLike));
    }

    public final Object m27898a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsEdgeModel searchResultsEdgeModel = (SearchResultsEdgeModel) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        String d = SearchResultsEdgeUtil.m9802d(searchResultsEdgeModel);
        if (((HasSearchResultsContext) hasContext).mo1248s().m27098l() == GraphQLGraphSearchResultsDisplayStyle.BLENDED) {
            baseMultiRowSubParts.a(this.f24425a, new Props(d, SearchResultsEdgeUtil.m9799a(searchResultsEdgeModel), SearchResultsEdgeUtil.m9801c(searchResultsEdgeModel)));
        } else {
            baseMultiRowSubParts.a(this.f24426b, new HeaderProps(d, null));
        }
        return null;
    }

    public final boolean m27899a(Object obj) {
        SearchResultsEdgeModel searchResultsEdgeModel = (SearchResultsEdgeModel) obj;
        return (searchResultsEdgeModel.m9770a() == null || StringUtil.a(searchResultsEdgeModel.m9770a().m9734V())) ? false : true;
    }

    @Inject
    public SearchResultsVideosHeaderPartDefinition(SearchResultsTitlePartDefinition searchResultsTitlePartDefinition, SearchResultsHeaderComponentPartDefinition searchResultsHeaderComponentPartDefinition) {
        this.f24425a = searchResultsTitlePartDefinition;
        this.f24426b = searchResultsHeaderComponentPartDefinition;
    }

    public static SearchResultsVideosHeaderPartDefinition m27896a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideosHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24424d) {
                SearchResultsVideosHeaderPartDefinition searchResultsVideosHeaderPartDefinition;
                if (a2 != null) {
                    searchResultsVideosHeaderPartDefinition = (SearchResultsVideosHeaderPartDefinition) a2.a(f24424d);
                } else {
                    searchResultsVideosHeaderPartDefinition = f24423c;
                }
                if (searchResultsVideosHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27897b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24424d, b3);
                        } else {
                            f24423c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideosHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
