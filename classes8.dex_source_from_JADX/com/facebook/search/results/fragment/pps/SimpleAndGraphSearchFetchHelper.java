package com.facebook.search.results.fragment.pps;

import com.facebook.inject.Assisted;
import com.facebook.search.logging.SeeMoreAnalyticHelper;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.suggestions.simplesearch.SimpleSearchResultsPageLoader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SEE_MORE_TAP */
public class SimpleAndGraphSearchFetchHelper {
    public final SimpleSearchResultsPageLoader f23122a;
    public final Map<FilterType, ImmutableList<SeeMoreResultPageUnit>> f23123b = new HashMap();
    public final Map<FilterType, Map<String, NeedleFilter>> f23124c = new HashMap();
    public final Map<FilterType, NeedleFilter> f23125d = new HashMap();
    public final Map<FilterType, String> f23126e = new HashMap();
    public final Set<FilterType> f23127f = new HashSet();
    public final Set<FilterType> f23128g = new HashSet();
    public final Set<FilterType> f23129h = new HashSet();
    public int f23130i = 10;
    private SeeMoreResultsPagerAdapter f23131j;
    public SeeMoreAnalyticHelper f23132k;

    /* compiled from: SEE_MORE_TAP */
    public class ResultsListener {
        final /* synthetic */ SimpleAndGraphSearchFetchHelper f23120a;
        private FilterType f23121b;

        public ResultsListener(SimpleAndGraphSearchFetchHelper simpleAndGraphSearchFetchHelper, FilterType filterType) {
            this.f23120a = simpleAndGraphSearchFetchHelper;
            this.f23121b = filterType;
        }

        public final void m26782a(ImmutableList<EntityTypeaheadUnit> immutableList, ImmutableList<NeedleFilter> immutableList2, String str, boolean z, boolean z2) {
            this.f23120a.m26785a(this.f23121b, SimpleAndGraphSearchFetchHelper.m26784a(this.f23120a, (ImmutableList) immutableList), immutableList2, str, z, z2);
        }

        public final void m26781a() {
            SimpleAndGraphSearchFetchHelper.m26788e(this.f23120a, this.f23121b);
        }

        public final void m26783b() {
            SimpleAndGraphSearchFetchHelper simpleAndGraphSearchFetchHelper = this.f23120a;
            simpleAndGraphSearchFetchHelper.f23129h.remove(this.f23121b);
        }
    }

    @Inject
    public SimpleAndGraphSearchFetchHelper(@Assisted SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter, SimpleSearchResultsPageLoader simpleSearchResultsPageLoader) {
        this.f23131j = seeMoreResultsPagerAdapter;
        this.f23122a = simpleSearchResultsPageLoader;
    }

    public final void m26789a(String str, FilterType filterType) {
        m26790a(str, filterType, null);
    }

    public final void m26790a(String str, FilterType filterType, @Nullable NeedleFilter needleFilter) {
        Preconditions.checkNotNull(str);
        this.f23129h.add(filterType);
        if (filterType == FilterType.People) {
            Preconditions.checkNotNull(str);
            Map hashMap = new HashMap();
            if (this.f23124c.containsKey(filterType)) {
                hashMap.putAll((Map) this.f23124c.get(filterType));
            }
            if (needleFilter != null) {
                this.f23125d.put(filterType, needleFilter);
                hashMap.put(needleFilter.f22172b, needleFilter);
                if (this.f23132k != null) {
                    Builder builder = ImmutableList.builder();
                    for (NeedleFilter needleFilter2 : hashMap.values()) {
                        if (needleFilter2.f22174d != null) {
                            builder.c(needleFilter2);
                        }
                    }
                    this.f23132k.m25522a(filterType, str, builder.b());
                }
            }
            this.f23122a.a(str, this.f23130i, filterType, (String) this.f23126e.get(filterType), ImmutableList.copyOf(hashMap.values()), new ResultsListener(this, filterType));
            return;
        }
        m26787b(str, filterType);
    }

    private void m26785a(FilterType filterType, ImmutableList<SeeMoreResultPageUnit> immutableList, ImmutableList<NeedleFilter> immutableList2, String str, boolean z, boolean z2) {
        int i = 0;
        if (immutableList == null) {
            m26788e(this, filterType);
            return;
        }
        int size;
        ImmutableList copyOf;
        this.f23129h.remove(filterType);
        ImmutableList immutableList3 = (ImmutableList) this.f23123b.get(filterType);
        if (immutableList3 != null) {
            size = immutableList3.size();
            Collection linkedHashSet = new LinkedHashSet(immutableList3);
            linkedHashSet.addAll(immutableList);
            copyOf = ImmutableList.copyOf(linkedHashSet);
        } else {
            size = 0;
            ImmutableList<SeeMoreResultPageUnit> immutableList4 = immutableList;
        }
        NeedleFilter needleFilter;
        if (immutableList2 != null && !this.f23124c.containsKey(filterType)) {
            Map hashMap = new HashMap();
            int size2 = immutableList2.size();
            while (i < size2) {
                needleFilter = (NeedleFilter) immutableList2.get(i);
                hashMap.put(needleFilter.f22172b, needleFilter);
                i++;
            }
            this.f23124c.put(filterType, hashMap);
        } else if (immutableList2 != null && this.f23125d.containsKey(filterType)) {
            String str2 = ((NeedleFilter) this.f23125d.get(filterType)).f22172b;
            int size3 = immutableList2.size();
            for (int i2 = 0; i2 < size3; i2++) {
                needleFilter = (NeedleFilter) immutableList2.get(i2);
                if (needleFilter.f22172b.equals(str2)) {
                    ((Map) this.f23124c.get(filterType)).put(str2, needleFilter);
                }
            }
        }
        this.f23125d.remove(filterType);
        this.f23123b.put(filterType, copyOf);
        this.f23126e.put(filterType, str);
        if (z) {
            this.f23128g.add(filterType);
        } else {
            this.f23128g.remove(filterType);
        }
        if (z2) {
            this.f23127f.add(filterType);
        } else {
            this.f23127f.remove(filterType);
        }
        this.f23131j.m26776a(filterType, copyOf, immutableList2, size, copyOf.size());
    }

    public static void m26788e(SimpleAndGraphSearchFetchHelper simpleAndGraphSearchFetchHelper, FilterType filterType) {
        simpleAndGraphSearchFetchHelper.f23129h.remove(filterType);
    }

    public final boolean m26792b(FilterType filterType) {
        return this.f23127f.contains(filterType);
    }

    public final ImmutableList<SeeMoreResultPageUnit> m26793c(FilterType filterType) {
        return (ImmutableList) this.f23123b.get(filterType);
    }

    private void m26787b(String str, FilterType filterType) {
        Preconditions.checkNotNull(str);
        this.f23122a.a(str, this.f23130i, filterType, (String) this.f23126e.get(filterType), new ResultsListener(this, filterType), this.f23132k.f21982f);
    }

    static /* synthetic */ ImmutableList m26784a(SimpleAndGraphSearchFetchHelper simpleAndGraphSearchFetchHelper, ImmutableList immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(new SeeMoreResultPageUnit((EntityTypeaheadUnit) immutableList.get(i)));
        }
        return builder.b();
    }

    public final void m26794d(FilterType filterType) {
        this.f23122a.e.c("simple_search_loader_key" + filterType);
        this.f23125d.remove(filterType);
        this.f23123b.remove(filterType);
        this.f23126e.remove(filterType);
        this.f23127f.remove(filterType);
        this.f23128g.remove(filterType);
        this.f23129h.remove(filterType);
    }

    public final void m26791b() {
        this.f23122a.e.c();
    }
}
