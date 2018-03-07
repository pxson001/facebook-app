package com.facebook.ui.typeahead;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: createAsPhotoItem */
public class TypeaheadResponse<T> {
    public final TypeaheadRequest f18439a;
    public final SearchResponse<T> f18440b;
    public final FetchSource f18441c;
    public final MatchType f18442d;

    public TypeaheadResponse(TypeaheadRequest typeaheadRequest, SearchResponse<T> searchResponse, FetchSource fetchSource, MatchType matchType) {
        Preconditions.checkNotNull(typeaheadRequest);
        Preconditions.checkNotNull(searchResponse);
        Preconditions.checkNotNull(fetchSource);
        Preconditions.checkNotNull(matchType);
        this.f18439a = typeaheadRequest;
        this.f18440b = searchResponse;
        this.f18441c = fetchSource;
        this.f18442d = matchType;
    }

    public final SearchResponse<T> m27053b() {
        return this.f18440b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TypeaheadResponse) && ((TypeaheadResponse) obj).f18439a.equals(this.f18439a) && ((TypeaheadResponse) obj).f18440b.equals(this.f18440b) && ((TypeaheadResponse) obj).f18441c == this.f18441c && ((TypeaheadResponse) obj).f18442d == this.f18442d;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f18439a, this.f18440b, this.f18441c, this.f18442d});
    }
}
