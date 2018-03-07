package com.facebook.search.results.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ReactionUnitTagHelper.getTags */
public class SearchResultsFeedRootPartDefinition extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsFeedRootPartDefinition f23568c;
    private static final Object f23569d = new Object();
    private final SearchResultsFeedRootPartRegistry f23570a;
    private final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f23571b;

    private static SearchResultsFeedRootPartDefinition m27236b(InjectorLike injectorLike) {
        return new SearchResultsFeedRootPartDefinition(IdBasedLazy.a(injectorLike, 6023), SearchResultsFeedRootPartRegistry.m27239a(injectorLike));
    }

    public final Object m27237a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnit feedUnit = (FeedUnit) obj;
        SearchResultsFeedRootPartRegistry searchResultsFeedRootPartRegistry = this.f23570a;
        Lazy lazy = (Lazy) searchResultsFeedRootPartRegistry.f23574a.get(feedUnit.getClass());
        if (lazy != null) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) lazy.get(), FeedProps.c(feedUnit));
        } else {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f23571b.get(), feedUnit);
        }
        return null;
    }

    @Inject
    public SearchResultsFeedRootPartDefinition(Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy, SearchResultsFeedRootPartRegistry searchResultsFeedRootPartRegistry) {
        this.f23571b = lazy;
        this.f23570a = searchResultsFeedRootPartRegistry;
    }

    public final boolean m27238a(Object obj) {
        return true;
    }

    public static SearchResultsFeedRootPartDefinition m27235a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFeedRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23569d) {
                SearchResultsFeedRootPartDefinition searchResultsFeedRootPartDefinition;
                if (a2 != null) {
                    searchResultsFeedRootPartDefinition = (SearchResultsFeedRootPartDefinition) a2.a(f23569d);
                } else {
                    searchResultsFeedRootPartDefinition = f23568c;
                }
                if (searchResultsFeedRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27236b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23569d, b3);
                        } else {
                            f23568c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFeedRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
