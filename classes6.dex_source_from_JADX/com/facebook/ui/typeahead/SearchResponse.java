package com.facebook.ui.typeahead;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: createPageAlbumParams */
public class SearchResponse<T> {
    public static final SearchResponse f18412a = new SearchResponse(RegularImmutableList.a);
    public ImmutableList<T> f18413b;
    public int f18414c;

    public SearchResponse(ImmutableList<T> immutableList, int i) {
        this.f18413b = immutableList;
        this.f18414c = i;
    }

    public SearchResponse(ImmutableList<T> immutableList) {
        this.f18413b = immutableList;
        this.f18414c = 0;
    }

    public static <T> SearchResponse<T> m27031a(SearchResponse<T> searchResponse, ImmutableList<T> immutableList) {
        return new SearchResponse(immutableList, searchResponse.f18414c);
    }

    public final ImmutableList<T> m27032b() {
        return this.f18413b;
    }

    public final int m27033c() {
        return this.f18414c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SearchResponse) && ((SearchResponse) obj).f18413b.equals(this.f18413b) && ((SearchResponse) obj).f18414c == this.f18414c;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f18413b, Integer.valueOf(this.f18414c)});
    }
}
