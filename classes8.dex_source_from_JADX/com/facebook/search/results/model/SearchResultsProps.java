package com.facebook.search.results.model;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: RichDocumentQuery */
public class SearchResultsProps<T> {
    public final T f23388a;
    public final int f23389b;
    public final SearchResultsEdgeModel f23390c;
    public final Optional<String> f23391d;

    private SearchResultsProps(T t, int i, SearchResultsEdge searchResultsEdge, @Nullable String str) {
        this.f23388a = t;
        this.f23389b = i;
        this.f23390c = searchResultsEdge;
        this.f23391d = Optional.fromNullable(str);
    }

    public static <T> SearchResultsProps<T> m27103a(T t, SearchResultsEdge searchResultsEdge) {
        return new SearchResultsProps(t, -1, searchResultsEdge, null);
    }

    public final <C> SearchResultsProps<C> m27105a(C c, int i) {
        return new SearchResultsProps(c, i, this.f23390c, null);
    }

    public final <C> SearchResultsProps<C> m27104a(C c) {
        return new SearchResultsProps(c, this.f23389b, this.f23390c, null);
    }

    public final GraphQLGraphSearchResultRole m27106d() {
        return SearchResultsEdgeUtil.m9799a(this.f23390c);
    }

    public final GraphQLGraphSearchResultsDisplayStyle m27107e() {
        return SearchResultsEdgeUtil.m9801c(this.f23390c);
    }

    public final boolean m27108f() {
        return SearchResultsEdgeUtil.m9803e(this.f23390c).size() > 1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SearchResultsProps)) {
            return false;
        }
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        if (!searchResultsProps.f23388a.equals(this.f23388a)) {
            return false;
        }
        SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        SearchResultsEdgeModel searchResultsEdgeModel2 = this.f23390c;
        Object obj2 = (!(searchResultsEdgeModel == null && searchResultsEdgeModel2 == null) && (searchResultsEdgeModel == null || searchResultsEdgeModel2 == null || !searchResultsEdgeModel.equals(searchResultsEdgeModel2))) ? null : 1;
        if (obj2 == null || searchResultsProps.f23389b != this.f23389b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f23390c == null ? 0 : this.f23390c.hashCode()) + (this.f23388a.hashCode() * 31);
    }
}
