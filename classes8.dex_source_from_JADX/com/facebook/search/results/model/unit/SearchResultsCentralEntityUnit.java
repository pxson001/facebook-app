package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: Reset stored client data for Learning Nux. */
public class SearchResultsCentralEntityUnit extends SearchResultsEntityWithCoverPhotoFeedUnit implements SearchResultsFeedImpressionTrackable {
    private final GraphQLNode f23454a;
    private final String f23455b;
    private final Optional<String> f23456c;

    public final GraphQLGraphSearchResultRole mo1321k() {
        return GraphQLGraphSearchResultRole.CENTRAL;
    }

    public final Optional<String> mo1322l() {
        return this.f23456c;
    }

    public final String mo1324f() {
        return this.f23454a.eP();
    }

    public final String mo1325m() {
        return this.f23455b;
    }

    public final GraphQLNode mo1326n() {
        return this.f23454a;
    }

    public final String mo1327o() {
        GraphQLFocusedPhoto ak = this.f23454a.ak();
        if (ak != null) {
            GraphQLPhoto j = ak.j();
            if (j != null) {
                GraphQLImage L = j.L();
                if (L != null) {
                    return L.b();
                }
            }
        }
        return null;
    }
}
