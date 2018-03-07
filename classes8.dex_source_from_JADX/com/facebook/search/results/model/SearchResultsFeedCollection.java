package com.facebook.search.results.model;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.Assisted;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.results.model.contract.SearchResultsGraphQLStoryFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import com.facebook.search.results.model.unit.SearchResultsResultsNoUnit;
import com.facebook.search.results.model.unit.SearchResultsUnsupportedFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsVideoUnit;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SAVE_LH_AND_NOTIFICATION_SETTING */
public class SearchResultsFeedCollection implements ListItemCollection<FeedUnit> {
    private static final DefaultPageInfoFields f23346a;
    private final GraphSearchErrorReporter f23347b;
    private final SearchResultsMutableContext f23348c;
    public final List<FeedUnit> f23349d = Lists.a();
    public final WeakHashMap<String, FeedProps<GraphQLStory>> f23350e;
    private final Map<String, GraphQLGraphSearchResultRole> f23351f;
    private final Map<String, String> f23352g;
    private final ArrayList<SearchResultsCollectionUnit<?>> f23353h;
    private int f23354i = 0;
    private boolean f23355j = false;
    public DefaultPageInfoFields f23356k = f23346a;

    /* compiled from: SAVE_LH_AND_NOTIFICATION_SETTING */
    class C25131 implements Iterable<SearchResultsBridge> {
        final /* synthetic */ SearchResultsFeedCollection f23342a;

        C25131(SearchResultsFeedCollection searchResultsFeedCollection) {
            this.f23342a = searchResultsFeedCollection;
        }

        public Iterator<SearchResultsBridge> iterator() {
            return new SearchResultsBridgeIterator(this.f23342a);
        }
    }

    /* compiled from: SAVE_LH_AND_NOTIFICATION_SETTING */
    class SearchResultsBridgeIterator implements Iterator<SearchResultsBridge> {
        final /* synthetic */ SearchResultsFeedCollection f23343a;
        private int f23344b = -1;
        private SearchResultsBridge f23345c = null;

        public SearchResultsBridgeIterator(SearchResultsFeedCollection searchResultsFeedCollection) {
            this.f23343a = searchResultsFeedCollection;
            m27047a(0);
        }

        public boolean hasNext() {
            return this.f23345c != null;
        }

        public Object next() {
            SearchResultsBridge searchResultsBridge = this.f23345c;
            m27047a(this.f23344b + 1);
            return searchResultsBridge;
        }

        public void remove() {
            throw new UnsupportedOperationException("Removing is not supported.");
        }

        private void m27047a(int i) {
            while (i < this.f23343a.f23349d.size()) {
                FeedUnit feedUnit = (FeedUnit) this.f23343a.f23349d.get(i);
                if (feedUnit instanceof SearchResultsBridge) {
                    this.f23344b = i;
                    this.f23345c = (SearchResultsBridge) feedUnit;
                    return;
                }
                i++;
            }
            this.f23345c = null;
        }
    }

    public final /* synthetic */ Object m27058a(int i) {
        return m27065b(i);
    }

    static {
        Builder builder = new Builder();
        builder.b = true;
        builder = builder;
        builder.a = null;
        f23346a = builder.a();
    }

    @Inject
    public SearchResultsFeedCollection(@Assisted SearchResultsMutableContext searchResultsMutableContext, GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f23348c = searchResultsMutableContext;
        this.f23347b = graphSearchErrorReporter;
        this.f23350e = new WeakHashMap();
        this.f23351f = new HashMap();
        this.f23352g = new HashMap();
        this.f23353h = new ArrayList();
    }

    public final int m27051a() {
        return this.f23349d.size();
    }

    public final int m27063b() {
        return this.f23349d.size() - this.f23354i;
    }

    public final FeedUnit m27065b(int i) {
        return (FeedUnit) this.f23349d.get(i);
    }

    @Nullable
    public final FeedProps<GraphQLStory> m27053a(@Nullable String str) {
        return str != null ? (FeedProps) this.f23350e.get(str) : null;
    }

    @Nullable
    public final GraphQLGraphSearchResultRole m27054a(GraphQLStory graphQLStory) {
        return graphQLStory.g() != null ? (GraphQLGraphSearchResultRole) this.f23351f.get(graphQLStory.g()) : null;
    }

    @Nullable
    public final String m27066b(GraphQLStory graphQLStory) {
        return graphQLStory.g() != null ? (String) this.f23352g.get(graphQLStory.g()) : null;
    }

    public final int m27069c() {
        return this.f23353h.size();
    }

    public final <T> Optional<SearchResultsCollectionUnit<T>> m27057a(T t) {
        int size = this.f23353h.size();
        for (int i = 0; i < size; i++) {
            SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) this.f23353h.get(i);
            if (searchResultsCollectionUnit.f23463d.contains(t)) {
                return Optional.of(searchResultsCollectionUnit);
            }
        }
        return Absent.INSTANCE;
    }

    public final Optional<SearchResultsEntityUnit> m27056a(GraphQLNode graphQLNode) {
        for (FeedUnit feedUnit : this.f23349d) {
            if ((feedUnit instanceof SearchResultsEntityUnit) && graphQLNode.equals(((SearchResultsEntityUnit) feedUnit).f23487a)) {
                return Optional.of((SearchResultsEntityUnit) feedUnit);
            }
        }
        return Absent.INSTANCE;
    }

    public final Optional<SearchResultsGraphQLStoryFeedUnit> m27055a(FeedUnit feedUnit) {
        for (FeedUnit feedUnit2 : this.f23349d) {
            if (feedUnit2 instanceof SearchResultsGraphQLStoryFeedUnit) {
                SearchResultsGraphQLStoryFeedUnit searchResultsGraphQLStoryFeedUnit = (SearchResultsGraphQLStoryFeedUnit) feedUnit2;
                if (searchResultsGraphQLStoryFeedUnit.mo1333f().equals(feedUnit)) {
                    return Optional.of(searchResultsGraphQLStoryFeedUnit);
                }
            }
        }
        return Absent.INSTANCE;
    }

    private boolean m27049d(GraphQLStory graphQLStory) {
        if (this.f23350e.containsKey(graphQLStory.g())) {
            return false;
        }
        this.f23349d.add(0, graphQLStory);
        m27048c(graphQLStory);
        return true;
    }

    public final void m27060a(SearchResults searchResults) {
        ImmutableList immutableList = searchResults.f23327a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FeedUnit feedUnit = (FeedUnit) immutableList.get(i);
            this.f23349d.add(feedUnit);
            m27048c(feedUnit);
            if (feedUnit instanceof SearchResultsUnsupportedFeedUnit) {
                this.f23354i++;
            } else if (feedUnit instanceof SearchResultsCollectionUnit) {
                SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedUnit;
                if (searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLStory.class))) {
                    ImmutableList immutableList2 = searchResultsCollectionUnit.f23463d;
                    int size2 = immutableList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        m27050e((GraphQLStory) immutableList2.get(i2));
                    }
                }
                this.f23353h.add(searchResultsCollectionUnit);
            }
        }
        this.f23356k = (DefaultPageInfoFields) Optional.fromNullable(searchResults.f23328b).or(f23346a);
        if (m27063b() == 0 && !m27072f() && !this.f23355j) {
            if (this.f23349d.isEmpty() || this.f23349d.size() == this.f23354i) {
                this.f23349d.add(new SearchResultsResultsNoUnit(this.f23348c.mo1211a(), !this.f23353h.isEmpty()));
                this.f23354i++;
                this.f23355j = true;
            }
        }
    }

    public final void m27067b(SearchResults searchResults) {
        this.f23356k = (DefaultPageInfoFields) Optional.fromNullable(searchResults.f23328b).or(f23346a);
        if (m27063b() == 0 && !this.f23355j) {
            this.f23349d.add(new SearchResultsResultsNoUnit(this.f23348c.mo1211a(), !this.f23353h.isEmpty()));
            this.f23354i++;
            this.f23355j = true;
        }
    }

    public final int m27052a(ImmutableList<GraphQLStory> immutableList) {
        ImmutableList reverse = immutableList.reverse();
        int size = reverse.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (m27049d((GraphQLStory) reverse.get(i))) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public final boolean m27068b(int i, FeedUnit feedUnit) {
        if (i < 0 || i >= this.f23349d.size()) {
            return false;
        }
        this.f23349d.remove(i);
        this.f23349d.add(i, feedUnit);
        return true;
    }

    public final void m27061a(ImmutableList<GraphQLStory> immutableList, DefaultPageInfoFields defaultPageInfoFields) {
        this.f23356k = (DefaultPageInfoFields) Optional.fromNullable(defaultPageInfoFields).or(f23346a);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FeedUnit feedUnit = (FeedUnit) immutableList.get(i);
            m27048c(feedUnit);
            this.f23349d.add(feedUnit);
        }
    }

    public final void m27062a(ImmutableSet<Entry<String, GraphQLGraphSearchResultRole>> immutableSet, ImmutableSet<Entry<String, String>> immutableSet2) {
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            this.f23351f.put(entry.getKey(), entry.getValue());
        }
        it = immutableSet2.iterator();
        while (it.hasNext()) {
            entry = (Entry) it.next();
            this.f23352g.put(entry.getKey(), entry.getValue());
        }
    }

    public final void m27059a(FeedUnit feedUnit, FeedUnit feedUnit2) {
        int indexOf = this.f23349d.indexOf(feedUnit);
        if (indexOf != -1) {
            this.f23349d.set(indexOf, feedUnit2);
        }
        if ((feedUnit instanceof SearchResultsCollectionUnit) && (feedUnit2 instanceof SearchResultsCollectionUnit)) {
            int indexOf2 = this.f23353h.indexOf(feedUnit);
            this.f23353h.set(indexOf2, (SearchResultsCollectionUnit) feedUnit2);
            indexOf = indexOf2;
        }
        if (indexOf == -1) {
            int size = this.f23353h.size();
            indexOf2 = 0;
            while (indexOf2 < size) {
                SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) this.f23353h.get(indexOf2);
                int indexOf3 = searchResultsCollectionUnit.f23463d.indexOf(feedUnit);
                if (indexOf3 != -1) {
                    SearchResultsCollectionUnit a = SearchResultsCollectionUnit.m27147a(searchResultsCollectionUnit, feedUnit, feedUnit2);
                    indexOf = this.f23349d.indexOf(this.f23353h.get(indexOf2));
                    this.f23349d.set(indexOf, a);
                    this.f23353h.set(indexOf2, a);
                    break;
                }
                indexOf2++;
                indexOf = indexOf3;
            }
        }
        if (indexOf == -1) {
            throw new IllegalArgumentException("Item not found: " + feedUnit);
        }
        m27048c(feedUnit2);
    }

    public final Iterable<SearchResultsBridge> m27070d() {
        return new C25131(this);
    }

    public final int m27064b(FeedUnit feedUnit) {
        return this.f23349d.indexOf(feedUnit);
    }

    private void m27048c(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            m27050e((GraphQLStory) feedUnit);
        } else if (feedUnit instanceof SearchResultsGraphQLStoryFeedUnit) {
            m27050e(((SearchResultsGraphQLStoryFeedUnit) feedUnit).mo1333f());
        } else if (feedUnit instanceof SearchResultsVideoUnit) {
            m27050e(((SearchResultsVideoUnit) feedUnit).f23550a);
        }
    }

    private void m27050e(GraphQLStory graphQLStory) {
        if (graphQLStory.g() != null) {
            FeedProps c = FeedProps.c(graphQLStory);
            GraphQLStory graphQLStory2 = (GraphQLStory) c.a;
            if (!(graphQLStory2.aD() == 0 || StoryHierarchyHelper.a(graphQLStory2) == null || StoryHierarchyHelper.a(graphQLStory2).j() == null)) {
                ImmutableList j = StoryHierarchyHelper.a(graphQLStory2).j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    graphQLStory2 = (GraphQLStory) j.get(i);
                    if (graphQLStory2.g() != null) {
                        this.f23350e.put(graphQLStory2.g(), c.a(graphQLStory2));
                    }
                }
            }
            this.f23350e.put(graphQLStory.g(), c);
            return;
        }
        this.f23347b.a(GraphSearchError.FETCH_NO_CACHEID_FOR_STORY, "Story cacheId was null");
    }

    public final void m27071e() {
        this.f23349d.clear();
        this.f23350e.clear();
        this.f23351f.clear();
        this.f23352g.clear();
        this.f23353h.clear();
        this.f23356k = f23346a;
        this.f23354i = 0;
        this.f23355j = false;
    }

    public final boolean m27072f() {
        return this.f23356k.b();
    }

    public final String m27073g() {
        return this.f23356k.a();
    }

    public final boolean m27074i() {
        return this.f23349d.isEmpty();
    }

    public final boolean m27075j() {
        return this.f23355j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f23349d.size());
        stringBuilder.append(" FeedUnits:\n");
        for (int i = 0; i < this.f23349d.size(); i++) {
            FeedUnit feedUnit = (FeedUnit) this.f23349d.get(i);
            stringBuilder.append("FeedUnit ");
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(feedUnit);
            stringBuilder.append(feedUnit.getType());
            stringBuilder.append("\n");
        }
        return "SearchResultsFeedCollection{" + stringBuilder + '}';
    }
}
