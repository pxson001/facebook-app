package com.facebook.search.results.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.search.results.model.SearchResultsBridge;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Received entity at position {%d} with key {%s} and id {%s} that can't be put into the ID list {%s} */
public class SearchResultsBridgePartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsBridge>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsBridgePartDefinition f23565b;
    private static final Object f23566c = new Object();
    private final SearchResultsRootPartDefinition f23567a;

    private static SearchResultsBridgePartDefinition m27232b(InjectorLike injectorLike) {
        return new SearchResultsBridgePartDefinition(SearchResultsRootPartDefinition.m27242a(injectorLike));
    }

    public final Object m27233a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f23567a, ((SearchResultsBridge) ((FeedProps) obj).a).f23332b);
        return null;
    }

    @Inject
    public SearchResultsBridgePartDefinition(SearchResultsRootPartDefinition searchResultsRootPartDefinition) {
        this.f23567a = searchResultsRootPartDefinition;
    }

    public final boolean m27234a(Object obj) {
        return true;
    }

    public static SearchResultsBridgePartDefinition m27231a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsBridgePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23566c) {
                SearchResultsBridgePartDefinition searchResultsBridgePartDefinition;
                if (a2 != null) {
                    searchResultsBridgePartDefinition = (SearchResultsBridgePartDefinition) a2.a(f23566c);
                } else {
                    searchResultsBridgePartDefinition = f23565b;
                }
                if (searchResultsBridgePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27232b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23566c, b3);
                        } else {
                            f23565b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsBridgePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
