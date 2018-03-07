package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.SearchResultsPropsHelper;
import com.facebook.search.results.protocol.video.SearchResultsTopVideosModuleInterfaces.SearchResultsTopVideosModule;
import com.facebook.search.results.rows.sections.header.SearchResultsVideosHeaderPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_TIPS_HIDE_TAP */
public class SearchResultsTopVideosModuleGroupPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation & HasSearchResultsContext & HasSearchResultPosition & HasSearchResultsVideoStoryPersistentState & HasPrefetcher & HasFeedListType & HasRowKey> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsTopVideosModule>, Void, E> {
    private static SearchResultsTopVideosModuleGroupPartDefinition f25150c;
    private static final Object f25151d = new Object();
    private final SearchResultsVideosHeaderPartDefinition<E> f25152a;
    private final SearchResultsVideosModuleGroupPartDefinition<E> f25153b;

    private static SearchResultsTopVideosModuleGroupPartDefinition m28443b(InjectorLike injectorLike) {
        return new SearchResultsTopVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition.m27896a(injectorLike), SearchResultsVideosModuleGroupPartDefinition.m28503a(injectorLike));
    }

    public final Object m28444a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        baseMultiRowSubParts.a(this.f25152a, searchResultsProps.f23390c);
        baseMultiRowSubParts.a(this.f25153b, searchResultsProps);
        return null;
    }

    public final boolean m28445a(Object obj) {
        return SearchResultsPropsHelper.m27109b((SearchResultsProps) obj);
    }

    @Inject
    public SearchResultsTopVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition searchResultsVideosHeaderPartDefinition, SearchResultsVideosModuleGroupPartDefinition searchResultsVideosModuleGroupPartDefinition) {
        this.f25152a = searchResultsVideosHeaderPartDefinition;
        this.f25153b = searchResultsVideosModuleGroupPartDefinition;
    }

    public static SearchResultsTopVideosModuleGroupPartDefinition m28442a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTopVideosModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25151d) {
                SearchResultsTopVideosModuleGroupPartDefinition searchResultsTopVideosModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsTopVideosModuleGroupPartDefinition = (SearchResultsTopVideosModuleGroupPartDefinition) a2.a(f25151d);
                } else {
                    searchResultsTopVideosModuleGroupPartDefinition = f25150c;
                }
                if (searchResultsTopVideosModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28443b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25151d, b3);
                        } else {
                            f25150c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTopVideosModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
