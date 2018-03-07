package com.facebook.search.results.filters.definition;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: SMS_CODE_SEARCHED */
public class SearchResultPageFilterDefinitionRegistry {
    private final Map<String, Lazy<? extends SearchResultPageFilterDefinition>> f22813a = new HashMap();
    private final Lazy<SearchResultPageUnsupportedFilterDefinition> f22814b;

    public static SearchResultPageFilterDefinitionRegistry m26462b(InjectorLike injectorLike) {
        return new SearchResultPageFilterDefinitionRegistry(IdBasedLazy.a(injectorLike, 10566), IdBasedLazy.a(injectorLike, 10567), IdBasedLazy.a(injectorLike, 10564), IdBasedLazy.a(injectorLike, 10568), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchResultPageFilterDefinitionRegistry(Lazy<SearchResultPagePriceFilterDefinition> lazy, Lazy<SearchResultPageRadioGroupFilterDefinition> lazy2, Lazy<SearchResultPageDistanceFilterDefinition> lazy3, Lazy<SearchResultPageUnsupportedFilterDefinition> lazy4, QeAccessor qeAccessor) {
        m26461a("rp_commerce_price", lazy);
        m26461a("rp_commerce_price_sort", lazy2);
        m26461a("friends", lazy2);
        m26461a("city", lazy2);
        m26461a("employer", lazy2);
        m26461a("school", lazy2);
        if (qeAccessor.a(ExperimentsForSearchAbTestModule.d, false)) {
            m26461a("rp_commerce_location", lazy2);
            m26461a("rp_commerce_distance", lazy3);
        }
        if (qeAccessor.a(ExperimentsForSearchAbTestModule.g, false)) {
            m26461a("rp_commerce_source", lazy2);
        }
        this.f22814b = lazy4;
    }

    public final boolean m26463a(String str) {
        return this.f22813a.containsKey(str);
    }

    public final SearchResultPageFilterDefinition m26464b(String str) {
        if (m26463a(str)) {
            return (SearchResultPageFilterDefinition) ((Lazy) this.f22813a.get(str)).get();
        }
        return (SearchResultPageFilterDefinition) this.f22814b.get();
    }

    private void m26461a(String str, Lazy<? extends SearchResultPageFilterDefinition> lazy) {
        this.f22813a.put(str, lazy);
    }
}
