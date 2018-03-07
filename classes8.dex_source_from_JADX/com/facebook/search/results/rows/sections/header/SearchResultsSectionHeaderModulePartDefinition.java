package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
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
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsSectionHeaderModuleInterfaces.SearchResultsSectionHeaderModule;
import com.facebook.search.results.rows.sections.header.SearchResultsHeaderComponentPartDefinition.HeaderProps;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PresenceNotLoaded */
public class SearchResultsSectionHeaderModulePartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsSectionHeaderModule>, Void, E> {
    private static SearchResultsSectionHeaderModulePartDefinition f24394b;
    private static final Object f24395c = new Object();
    private final SearchResultsHeaderComponentPartDefinition<E> f24396a;

    private static SearchResultsSectionHeaderModulePartDefinition m27880b(InjectorLike injectorLike) {
        return new SearchResultsSectionHeaderModulePartDefinition(SearchResultsHeaderComponentPartDefinition.m27871a(injectorLike));
    }

    public final Object m27881a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f24396a, new HeaderProps(((NodeModel) ((SearchResultsProps) obj).f23388a).m9734V(), null));
        return null;
    }

    public final boolean m27882a(Object obj) {
        return !StringUtil.a(new CharSequence[]{((NodeModel) ((SearchResultsProps) obj).f23388a).m9734V()});
    }

    @Inject
    public SearchResultsSectionHeaderModulePartDefinition(SearchResultsHeaderComponentPartDefinition searchResultsHeaderComponentPartDefinition) {
        this.f24396a = searchResultsHeaderComponentPartDefinition;
    }

    public static SearchResultsSectionHeaderModulePartDefinition m27879a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSectionHeaderModulePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24395c) {
                SearchResultsSectionHeaderModulePartDefinition searchResultsSectionHeaderModulePartDefinition;
                if (a2 != null) {
                    searchResultsSectionHeaderModulePartDefinition = (SearchResultsSectionHeaderModulePartDefinition) a2.a(f24395c);
                } else {
                    searchResultsSectionHeaderModulePartDefinition = f24394b;
                }
                if (searchResultsSectionHeaderModulePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27880b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24395c, b3);
                        } else {
                            f24394b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSectionHeaderModulePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
