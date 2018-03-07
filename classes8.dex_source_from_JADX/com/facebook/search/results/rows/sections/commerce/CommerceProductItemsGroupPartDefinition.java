package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.search.results.rows.sections.commerce.SearchResultsCommerceTitleTogglePartDefinition.GridViewToggleStatusKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RECENT */
public class CommerceProductItemsGroupPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<SearchResultsCollectionUnit<SearchResultsProductItemUnit>, Void, E> {
    private static final GraphQLObjectType f23953a = new GraphQLObjectType(175920258);
    private static CommerceProductItemsGroupPartDefinition f23954e;
    private static final Object f23955f = new Object();
    private final QeAccessor f23956b;
    private final CommerceListItemPartDefinition f23957c;
    private final CommerceProductItemsGridRowPartDefinition f23958d;

    private static CommerceProductItemsGroupPartDefinition m27536b(InjectorLike injectorLike) {
        return new CommerceProductItemsGroupPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CommerceListItemPartDefinition.m27484a(injectorLike), CommerceProductItemsGridRowPartDefinition.m27527a(injectorLike));
    }

    public final Object m27537a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        int i = 0;
        int i2;
        ImmutableList immutableList;
        int size;
        int i3;
        if (searchResultsCollectionUnit.f23460a.orNull() == GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL || !((Boolean) hasPersistentState.a(new GridViewToggleStatusKey(Boolean.valueOf(false)))).booleanValue()) {
            i2 = (this.f23956b.a(ExperimentsForSearchAbTestModule.c, false) && searchResultsCollectionUnit.f23460a.orNull() == GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL) ? 1 : 0;
            immutableList = searchResultsCollectionUnit.f23463d;
            size = immutableList.size();
            int i4 = 0;
            while (i4 < size) {
                if (baseMultiRowSubParts.a(this.f23957c, (SearchResultsProductItemUnit) immutableList.get(i4)) && i2 != 0) {
                    i3 = i + 1;
                    if (i3 == 3) {
                        break;
                    }
                } else {
                    i3 = i;
                }
                i4++;
                i = i3;
            }
        } else {
            Builder builder = new Builder();
            immutableList = searchResultsCollectionUnit.f23463d;
            size = immutableList.size();
            for (i2 = 0; i2 < size; i2++) {
                SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) immutableList.get(i2);
                if (CommerceListItemPartDefinition.m27485a(searchResultsProductItemUnit)) {
                    builder.c(searchResultsProductItemUnit);
                }
            }
            ImmutableList b = builder.b();
            for (i3 = 0; i3 <= b.size() - 2; i3 += 2) {
                baseMultiRowSubParts.a(this.f23958d, ImmutableList.of(b.get(i3), b.get(i3 + 1)));
            }
        }
        return null;
    }

    public final boolean m27538a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) obj;
        return searchResultsCollectionUnit.f23465f.isPresent() && ((GraphQLObjectType) searchResultsCollectionUnit.f23465f.get()).e().equals(f23953a.e());
    }

    @Inject
    public CommerceProductItemsGroupPartDefinition(QeAccessor qeAccessor, CommerceListItemPartDefinition commerceListItemPartDefinition, CommerceProductItemsGridRowPartDefinition commerceProductItemsGridRowPartDefinition) {
        this.f23956b = qeAccessor;
        this.f23957c = commerceListItemPartDefinition;
        this.f23958d = commerceProductItemsGridRowPartDefinition;
    }

    public static CommerceProductItemsGroupPartDefinition m27535a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceProductItemsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23955f) {
                CommerceProductItemsGroupPartDefinition commerceProductItemsGroupPartDefinition;
                if (a2 != null) {
                    commerceProductItemsGroupPartDefinition = (CommerceProductItemsGroupPartDefinition) a2.a(f23955f);
                } else {
                    commerceProductItemsGroupPartDefinition = f23954e;
                }
                if (commerceProductItemsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27536b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23955f, b3);
                        } else {
                            f23954e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceProductItemsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
