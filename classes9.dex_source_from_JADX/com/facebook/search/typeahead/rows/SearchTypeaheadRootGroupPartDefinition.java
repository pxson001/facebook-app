package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowPartWithIsNeededUtil;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
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
import com.facebook.multirow.api.PartWithIsNeeded;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.EmptyScopedNullStateTypeaheadUnit;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.GapTypeaheadUnit;
import com.facebook.search.model.HorizontalRecentSearchesUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NeueTypeaheadUnit;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SearchSpotlightCollectionUnit;
import com.facebook.search.model.SeeMoreTypeaheadUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.model.DividerTypeaheadUnit;
import com.facebook.search.suggestions.model.HeaderRowTypeaheadUnit;
import com.facebook.search.suggestions.model.QRCodePromoUnit;
import com.facebook.search.typeahead.rows.nullstate.NullStateModuleGroupPartDefinition;
import com.facebook.search.typeahead.rows.nullstate.NullStateSeeMorePartDefinition;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vault_image_hash_idx */
public class SearchTypeaheadRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, SearchSuggestionsEnvironment> {
    private static SearchTypeaheadRootGroupPartDefinition f604d;
    private static final Object f605e = new Object();
    private final RootPartSelector<SearchSuggestionsEnvironment> f606a;
    private final Map<Class<?>, PartWithIsNeeded<?>> f607b;
    private final Lazy<UnsupportedSearchTypeaheadPartDefinition> f608c;

    private static SearchTypeaheadRootGroupPartDefinition m699b(InjectorLike injectorLike) {
        return new SearchTypeaheadRootGroupPartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10928), IdBasedLazy.a(injectorLike, 10897), IdBasedLazy.a(injectorLike, 10904), IdBasedLazy.a(injectorLike, 10906), IdBasedLazy.a(injectorLike, 10923), IdBasedLazy.a(injectorLike, 10915), IdBasedLazy.a(injectorLike, 10899), IdBasedLazy.a(injectorLike, 10918), IdBasedLazy.a(injectorLike, 10909), IdBasedLazy.a(injectorLike, 10936), IdBasedLazy.a(injectorLike, 10916), IdBasedLazy.a(injectorLike, 10917), IdBasedLazy.a(injectorLike, 10914), IdBasedLazy.a(injectorLike, 10907), IdBasedLazy.a(injectorLike, 10911), IdBasedLazy.a(injectorLike, 10924), IdBasedLazy.a(injectorLike, 10922), IdBasedLazy.a(injectorLike, 10901), IdBasedLazy.a(injectorLike, 10910), IdBasedLazy.a(injectorLike, 10896), IdBasedLazy.a(injectorLike, 10898), IdBasedLazy.a(injectorLike, 10908), NullStateModuleGroupPartDefinition.m744a(injectorLike));
    }

    public final Object m700a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnit feedUnit = (FeedUnit) obj;
        if (!this.f606a.a(baseMultiRowSubParts, feedUnit)) {
            for (Entry entry : this.f607b.entrySet()) {
                if (((Class) entry.getKey()).isInstance(feedUnit)) {
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) ((PartWithIsNeeded) entry.getValue()), feedUnit);
                    break;
                }
            }
            if (feedUnit instanceof TypeaheadUnit) {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f608c.get(), (TypeaheadUnit) feedUnit);
            }
        }
        return null;
    }

    public static SearchTypeaheadRootGroupPartDefinition m698a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f605e) {
                SearchTypeaheadRootGroupPartDefinition searchTypeaheadRootGroupPartDefinition;
                if (a2 != null) {
                    searchTypeaheadRootGroupPartDefinition = (SearchTypeaheadRootGroupPartDefinition) a2.a(f605e);
                } else {
                    searchTypeaheadRootGroupPartDefinition = f604d;
                }
                if (searchTypeaheadRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m699b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f605e, b3);
                        } else {
                            f604d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchTypeaheadRootGroupPartDefinition(GatekeeperStore gatekeeperStore, QeAccessor qeAccessor, Lazy<UnsupportedSearchTypeaheadPartDefinition> lazy, Lazy<SearchNeueTypeaheadPartDefinition> lazy2, Lazy<SearchTypeaheadEntityComponentPartDefinition> lazy3, Lazy<SearchTypeaheadEntityPartDefinition> lazy4, Lazy<SearchTypeaheadSimpleEntityPartDefinition> lazy5, Lazy<SearchTypeaheadNeueTrendingEntityPartDefinition> lazy6, Lazy<SearchTypeaheadDividerPartDefinition> lazy7, Lazy<SearchTypeaheadQRCodePartDefinition> lazy8, Lazy<SearchTypeaheadHeaderPartDefinition> lazy9, Lazy<NullStateSeeMorePartDefinition> lazy10, Lazy<SearchTypeaheadNullStateSuggestionPartDefinition> lazy11, Lazy<SearchTypeaheadPlaceTipsPartDefinition> lazy12, Lazy<SearchTypeaheadNearbyPartDefinition> lazy13, Lazy<SearchTypeaheadFindMorePartDefinition> lazy14, Lazy<SearchTypeaheadKeywordPartDefinition> lazy15, Lazy<SearchTypeaheadSimpleKeywordPartDefinition> lazy16, Lazy<SearchTypeaheadShortcutPartDefinition> lazy17, Lazy<SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition> lazy18, Lazy<SearchTypeaheadHorizontalRecentPartDefinition> lazy19, Lazy<SearchHScrollRecyclerRecentPartDefinition> lazy20, Lazy<SearchSpotlightHScrollRecyclerPartDefinition> lazy21, Lazy<SearchTypeaheadGapPartDefinition> lazy22, NullStateModuleGroupPartDefinition nullStateModuleGroupPartDefinition) {
        Lazy a = MultiRowPartWithIsNeededUtil.a(lazy9);
        Lazy a2 = MultiRowPartWithIsNeededUtil.a(lazy10);
        Lazy<SearchTypeaheadHorizontalRecentPartDefinition> a3 = MultiRowPartWithIsNeededUtil.a(lazy20);
        Lazy a4 = MultiRowPartWithIsNeededUtil.a(lazy21);
        Lazy a5 = MultiRowPartWithIsNeededUtil.a(lazy18);
        Lazy a6 = MultiRowPartWithIsNeededUtil.a(lazy3);
        Lazy<SearchTypeaheadKeywordPartDefinition> a7 = MultiRowPartWithIsNeededUtil.a(lazy16);
        RootPartSelector a8 = RootPartSelector.a().a(NeueTypeaheadUnit.class, lazy2).a(TrendingTypeaheadUnit.class, lazy6).a(DividerTypeaheadUnit.class, lazy7).a(QRCodePromoUnit.class, lazy8).a(HeaderRowTypeaheadUnit.class, a).a(NullStateSeeMoreTypeaheadUnit.class, a2).a(NullStateSuggestionTypeaheadUnit.class, lazy11).a(PlaceTipsTypeaheadUnit.class, lazy12).a(NearbyTypeaheadUnit.class, lazy13).a(SeeMoreTypeaheadUnit.class, lazy14);
        Class cls = KeywordTypeaheadUnit.class;
        if (qeAccessor.a(ExperimentsForSearchAbTestModule.E, false)) {
            lazy15 = a7;
        }
        RootPartSelector a9 = a8.a(cls, lazy15).a(ShortcutTypeaheadUnit.class, lazy17).a(EmptyScopedNullStateTypeaheadUnit.class, a5);
        Class cls2 = HorizontalRecentSearchesUnit.class;
        if (qeAccessor.a(ExperimentsForSearchAbTestModule.aN, false)) {
            lazy19 = a3;
        }
        this.f606a = a9.a(cls2, lazy19).a(SearchSpotlightCollectionUnit.class, a4).a(GapTypeaheadUnit.class, lazy22);
        boolean a10 = gatekeeperStore.a(SearchAbTestGatekeepers.C, false);
        if (qeAccessor.a(ExperimentsForSearchAbTestModule.E, false)) {
            this.f606a.a(EntityTypeaheadUnit.class, lazy5);
        } else if (a10) {
            this.f606a.a(EntityTypeaheadUnit.class, a6);
        } else {
            this.f606a.a(EntityTypeaheadUnit.class, lazy4);
        }
        this.f607b = new HashMap();
        this.f607b.put(NullStateModuleCollectionUnit.class, nullStateModuleGroupPartDefinition);
        this.f608c = lazy;
    }

    public final boolean m701a(Object obj) {
        return true;
    }
}
