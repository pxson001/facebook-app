package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.search.results.model.unit.SearchResultsAnnotationUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_SESSION_ID_TAG must be present */
public class SearchResultsAnnotationSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsAnnotationUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsAnnotationSelectorPartDefinition f23992c;
    private static final Object f23993d = new Object();
    private final SearchResultsAnnotationWithPostCountPartDefinition f23994a;
    private final SearchResultsAnnotationPartDefinition f23995b;

    private static SearchResultsAnnotationSelectorPartDefinition m27570b(InjectorLike injectorLike) {
        return new SearchResultsAnnotationSelectorPartDefinition(SearchResultsAnnotationPartDefinition.m27563a(injectorLike), SearchResultsAnnotationWithPostCountPartDefinition.m27574a(injectorLike));
    }

    public final Object m27571a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsAnnotationUnit searchResultsAnnotationUnit = (SearchResultsAnnotationUnit) ((FeedProps) obj).a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23994a, searchResultsAnnotationUnit).a(this.f23995b, searchResultsAnnotationUnit);
        return null;
    }

    @Inject
    public SearchResultsAnnotationSelectorPartDefinition(SearchResultsAnnotationPartDefinition searchResultsAnnotationPartDefinition, SearchResultsAnnotationWithPostCountPartDefinition searchResultsAnnotationWithPostCountPartDefinition) {
        this.f23994a = searchResultsAnnotationWithPostCountPartDefinition;
        this.f23995b = searchResultsAnnotationPartDefinition;
    }

    public final boolean m27572a(Object obj) {
        return true;
    }

    public static SearchResultsAnnotationSelectorPartDefinition m27569a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsAnnotationSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23993d) {
                SearchResultsAnnotationSelectorPartDefinition searchResultsAnnotationSelectorPartDefinition;
                if (a2 != null) {
                    searchResultsAnnotationSelectorPartDefinition = (SearchResultsAnnotationSelectorPartDefinition) a2.a(f23993d);
                } else {
                    searchResultsAnnotationSelectorPartDefinition = f23992c;
                }
                if (searchResultsAnnotationSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27570b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23993d, b3);
                        } else {
                            f23992c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsAnnotationSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
