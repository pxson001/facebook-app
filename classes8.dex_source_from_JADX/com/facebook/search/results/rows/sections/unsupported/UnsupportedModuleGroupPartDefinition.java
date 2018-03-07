package com.facebook.search.results.rows.sections.unsupported;

import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
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
import com.facebook.search.results.model.unit.SearchResultsUnsupportedFeedUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyFooterPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyHeaderPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POSITIVE */
public class UnsupportedModuleGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsUnsupportedFeedUnit>, Void, SearchResultsFeedEnvironment> {
    private static UnsupportedModuleGroupPartDefinition f25103e;
    private static final Object f25104f = new Object();
    private final SearchResultsResultsEmptyFooterPartDefinition<SearchResultsUnsupportedFeedUnit> f25105a;
    private final UnsupportedModulePartDefinition f25106b;
    private final SearchResultsResultsEmptyHeaderPartDefinition<SearchResultsUnsupportedFeedUnit> f25107c;
    private final EmptyPartDefinition f25108d;

    private static UnsupportedModuleGroupPartDefinition m28402b(InjectorLike injectorLike) {
        return new UnsupportedModuleGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition.m27597a(injectorLike), UnsupportedModulePartDefinition.m28405a(injectorLike), SearchResultsResultsEmptyFooterPartDefinition.m27592a(injectorLike), EmptyPartDefinition.a(injectorLike));
    }

    public final Object m28403a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsUnsupportedFeedUnit searchResultsUnsupportedFeedUnit = (SearchResultsUnsupportedFeedUnit) feedProps.a;
        if (BuildConstants.i) {
            baseMultiRowSubParts.a(this.f25107c, searchResultsUnsupportedFeedUnit);
            baseMultiRowSubParts.a(this.f25106b, feedProps);
            baseMultiRowSubParts.a(this.f25105a, searchResultsUnsupportedFeedUnit);
        } else {
            baseMultiRowSubParts.a(this.f25108d, feedProps);
        }
        return null;
    }

    @Inject
    public UnsupportedModuleGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition searchResultsResultsEmptyHeaderPartDefinition, UnsupportedModulePartDefinition unsupportedModulePartDefinition, SearchResultsResultsEmptyFooterPartDefinition searchResultsResultsEmptyFooterPartDefinition, EmptyPartDefinition emptyPartDefinition) {
        this.f25105a = searchResultsResultsEmptyFooterPartDefinition;
        this.f25106b = unsupportedModulePartDefinition;
        this.f25107c = searchResultsResultsEmptyHeaderPartDefinition;
        this.f25108d = emptyPartDefinition;
    }

    public static UnsupportedModuleGroupPartDefinition m28401a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnsupportedModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25104f) {
                UnsupportedModuleGroupPartDefinition unsupportedModuleGroupPartDefinition;
                if (a2 != null) {
                    unsupportedModuleGroupPartDefinition = (UnsupportedModuleGroupPartDefinition) a2.a(f25104f);
                } else {
                    unsupportedModuleGroupPartDefinition = f25103e;
                }
                if (unsupportedModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28402b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25104f, b3);
                        } else {
                            f25103e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = unsupportedModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m28404a(Object obj) {
        return true;
    }
}
