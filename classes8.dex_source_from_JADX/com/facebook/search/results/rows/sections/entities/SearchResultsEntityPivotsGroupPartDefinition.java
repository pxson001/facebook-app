package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.EmptyFooterPartDefinition;
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
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityPivotUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyHeaderPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QueryFriends */
public class SearchResultsEntityPivotsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<SearchResultsEntityPivotUnit>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsEntityPivotsGroupPartDefinition f24204d;
    private static final Object f24205e = new Object();
    private final SearchResultsResultsEmptyHeaderPartDefinition f24206a;
    private final EmptyFooterPartDefinition f24207b;
    private final SearchResultsEntityPivotRowPartDefinition f24208c;

    private static SearchResultsEntityPivotsGroupPartDefinition m27737b(InjectorLike injectorLike) {
        return new SearchResultsEntityPivotsGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition.m27597a(injectorLike), EmptyFooterPartDefinition.a(injectorLike), SearchResultsEntityPivotRowPartDefinition.m27730a(injectorLike));
    }

    public final Object m27738a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f24206a, feedProps);
        ImmutableList immutableList = ((SearchResultsCollectionUnit) feedProps.a).f23463d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            baseMultiRowSubParts.a(this.f24208c, FeedProps.c((SearchResultsEntityPivotUnit) immutableList.get(i)));
        }
        baseMultiRowSubParts.a(this.f24207b, feedProps);
        return null;
    }

    public final boolean m27739a(Object obj) {
        return !((SearchResultsCollectionUnit) ((FeedProps) obj).a).f23463d.isEmpty();
    }

    @Inject
    public SearchResultsEntityPivotsGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition searchResultsResultsEmptyHeaderPartDefinition, EmptyFooterPartDefinition emptyFooterPartDefinition, SearchResultsEntityPivotRowPartDefinition searchResultsEntityPivotRowPartDefinition) {
        this.f24206a = searchResultsResultsEmptyHeaderPartDefinition;
        this.f24207b = emptyFooterPartDefinition;
        this.f24208c = searchResultsEntityPivotRowPartDefinition;
    }

    public static SearchResultsEntityPivotsGroupPartDefinition m27736a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityPivotsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24205e) {
                SearchResultsEntityPivotsGroupPartDefinition searchResultsEntityPivotsGroupPartDefinition;
                if (a2 != null) {
                    searchResultsEntityPivotsGroupPartDefinition = (SearchResultsEntityPivotsGroupPartDefinition) a2.a(f24205e);
                } else {
                    searchResultsEntityPivotsGroupPartDefinition = f24204d;
                }
                if (searchResultsEntityPivotsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27737b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24205e, b3);
                        } else {
                            f24204d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityPivotsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
