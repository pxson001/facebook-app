package com.facebook.search.results.rows.sections.eyewitness;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.search.results.rows.sections.collection.SearchResultsCollectionHeaderPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsFooterPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Provide valid layout resource id */
public class SearchResultsEyewitnessGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<GraphQLStoryAttachment>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsEyewitnessGroupPartDefinition f24293d;
    private static final Object f24294e = new Object();
    private final SearchResultsFooterPartDefinition<GraphQLStoryAttachment> f24295a;
    private final SearchResultsEyewitnessCollageAttachmentPartDefinition f24296b;
    private final SearchResultsCollectionHeaderPartDefinition<GraphQLStoryAttachment> f24297c;

    private static SearchResultsEyewitnessGroupPartDefinition m27813b(InjectorLike injectorLike) {
        return new SearchResultsEyewitnessGroupPartDefinition(SearchResultsCollectionHeaderPartDefinition.m27379a(injectorLike), SearchResultsEyewitnessCollageAttachmentPartDefinition.m27804a(injectorLike), SearchResultsFooterPartDefinition.m27396a(injectorLike));
    }

    public final Object m27814a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f24297c, feedProps);
        baseMultiRowSubParts.a(this.f24296b, feedProps);
        baseMultiRowSubParts.a(this.f24295a, feedProps);
        return null;
    }

    @Inject
    public SearchResultsEyewitnessGroupPartDefinition(SearchResultsCollectionHeaderPartDefinition searchResultsCollectionHeaderPartDefinition, SearchResultsEyewitnessCollageAttachmentPartDefinition searchResultsEyewitnessCollageAttachmentPartDefinition, SearchResultsFooterPartDefinition searchResultsFooterPartDefinition) {
        this.f24295a = searchResultsFooterPartDefinition;
        this.f24296b = searchResultsEyewitnessCollageAttachmentPartDefinition;
        this.f24297c = searchResultsCollectionHeaderPartDefinition;
    }

    public final boolean m27815a(Object obj) {
        return true;
    }

    public static SearchResultsEyewitnessGroupPartDefinition m27812a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEyewitnessGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24294e) {
                SearchResultsEyewitnessGroupPartDefinition searchResultsEyewitnessGroupPartDefinition;
                if (a2 != null) {
                    searchResultsEyewitnessGroupPartDefinition = (SearchResultsEyewitnessGroupPartDefinition) a2.a(f24294e);
                } else {
                    searchResultsEyewitnessGroupPartDefinition = f24293d;
                }
                if (searchResultsEyewitnessGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27813b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24294e, b3);
                        } else {
                            f24293d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEyewitnessGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
