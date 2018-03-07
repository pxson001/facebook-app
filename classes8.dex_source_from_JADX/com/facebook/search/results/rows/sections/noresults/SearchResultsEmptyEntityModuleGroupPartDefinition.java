package com.facebook.search.results.rows.sections.noresults;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsEmptyEntityUnit;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PYMK_FRIENDING_ACTION_TASK */
public class SearchResultsEmptyEntityModuleGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsEmptyEntityUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsEmptyEntityModuleGroupPartDefinition f24692c;
    private static final Object f24693d = new Object();
    SearchResultsTitlePartDefinition f24694a;
    SearchResultsEmptyEntityModuleBodyPartDefinition<SearchResultsFeedEnvironment> f24695b;

    private static SearchResultsEmptyEntityModuleGroupPartDefinition m28109b(InjectorLike injectorLike) {
        return new SearchResultsEmptyEntityModuleGroupPartDefinition(SearchResultsTitlePartDefinition.m27890a(injectorLike), SearchResultsEmptyEntityModuleBodyPartDefinition.m28103a(injectorLike));
    }

    public final Object m28110a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsEmptyEntityUnit searchResultsEmptyEntityUnit = (SearchResultsEmptyEntityUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f24694a, new Props(searchResultsEmptyEntityUnit.f23475a, searchResultsEmptyEntityUnit.mo1321k(), searchResultsEmptyEntityUnit.f23476b));
        baseMultiRowSubParts.a(this.f24695b, feedProps);
        return null;
    }

    public final boolean m28111a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (((SearchResultsEmptyEntityUnit) feedProps.a).f23475a == null || ((SearchResultsEmptyEntityUnit) feedProps.a).f23476b == GraphQLGraphSearchResultsDisplayStyle.VIDEOS) ? false : true;
    }

    @Inject
    public SearchResultsEmptyEntityModuleGroupPartDefinition(SearchResultsTitlePartDefinition searchResultsTitlePartDefinition, SearchResultsEmptyEntityModuleBodyPartDefinition searchResultsEmptyEntityModuleBodyPartDefinition) {
        this.f24694a = searchResultsTitlePartDefinition;
        this.f24695b = searchResultsEmptyEntityModuleBodyPartDefinition;
    }

    public static SearchResultsEmptyEntityModuleGroupPartDefinition m28108a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEmptyEntityModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24693d) {
                SearchResultsEmptyEntityModuleGroupPartDefinition searchResultsEmptyEntityModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsEmptyEntityModuleGroupPartDefinition = (SearchResultsEmptyEntityModuleGroupPartDefinition) a2.a(f24693d);
                } else {
                    searchResultsEmptyEntityModuleGroupPartDefinition = f24692c;
                }
                if (searchResultsEmptyEntityModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28109b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24693d, b3);
                        } else {
                            f24692c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEmptyEntityModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
