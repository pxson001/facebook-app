package com.facebook.search.results.model;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoTailFields;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: SAVE_PAGE_TAP */
public class SearchResultsCollection implements ListItemCollection<SearchResult> {
    private static final DefaultPageInfoTailFields f23337a = new C25111();
    public final ArrayList<SearchResult> f23338b = new ArrayList();
    public int f23339c = 0;
    private DefaultPageInfoTailFields f23340d;

    /* compiled from: SAVE_PAGE_TAP */
    final class C25111 implements DefaultPageInfoTailFields {
        C25111() {
        }

        @Nullable
        public final String m27034a() {
            return null;
        }

        public final boolean m27035b() {
            return false;
        }
    }

    /* compiled from: SAVE_PAGE_TAP */
    class C25122 implements Iterable<SearchResultUnit> {
        final /* synthetic */ SearchResultsCollection f23333a;

        C25122(SearchResultsCollection searchResultsCollection) {
            this.f23333a = searchResultsCollection;
        }

        public Iterator<SearchResultUnit> iterator() {
            return new SearchResultUnitIterator(this.f23333a);
        }
    }

    /* compiled from: SAVE_PAGE_TAP */
    class SearchResultUnitIterator implements Iterator<SearchResultUnit> {
        final /* synthetic */ SearchResultsCollection f23334a;
        private int f23335b = -1;
        private SearchResultUnit f23336c = null;

        public SearchResultUnitIterator(SearchResultsCollection searchResultsCollection) {
            this.f23334a = searchResultsCollection;
            m27036a(0);
        }

        public boolean hasNext() {
            return this.f23336c != null;
        }

        public Object next() {
            SearchResultUnit searchResultUnit = this.f23336c;
            m27036a(this.f23335b + 1);
            return searchResultUnit;
        }

        public void remove() {
            throw new UnsupportedOperationException("Removing is not supported.");
        }

        private void m27036a(int i) {
            while (i < this.f23334a.f23338b.size()) {
                SearchResultUnit searchResultUnit = (SearchResultUnit) this.f23334a.f23338b.get(i);
                if (searchResultUnit instanceof SearchResultUnit) {
                    this.f23335b = i;
                    this.f23336c = searchResultUnit;
                    return;
                }
                i++;
            }
            this.f23336c = null;
        }
    }

    public final /* synthetic */ Object m27038a(int i) {
        return m27040b(i);
    }

    public final int m27037a() {
        return this.f23338b.size();
    }

    public final SearchResultUnit m27040b(int i) {
        return (SearchResultUnit) this.f23338b.get(i);
    }

    public final boolean m27041b() {
        return this.f23338b.isEmpty();
    }

    public final void m27039a(ImmutableList<? extends SearchResult> immutableList, DefaultPageInfoTailFields defaultPageInfoTailFields) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f23338b.add((SearchResultUnit) immutableList.get(i));
        }
        this.f23340d = defaultPageInfoTailFields;
    }

    public final DefaultPageInfoTailFields m27042e() {
        return this.f23340d != null ? this.f23340d : f23337a;
    }

    public final void m27043f() {
        this.f23338b.clear();
        this.f23340d = f23337a;
        this.f23339c = 0;
    }

    public final Iterable<SearchResultUnit> m27044g() {
        return new C25122(this);
    }
}
