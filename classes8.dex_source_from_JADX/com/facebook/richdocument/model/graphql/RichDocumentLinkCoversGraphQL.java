package com.facebook.richdocument.model.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_menu_viewer_impression */
public final class RichDocumentLinkCoversGraphQL {

    /* compiled from: photo_menu_viewer_impression */
    public class RichDocumentLinkCoverConfigQueryString extends TypedGraphQlQueryString<InstantArticleLinkCoverConfigFragmentModel> {
        public RichDocumentLinkCoverConfigQueryString() {
            super(InstantArticleLinkCoverConfigFragmentModel.class, false, "RichDocumentLinkCoverConfigQuery", "738a4739a3fcc107739ae80a011dc6bd", "node", "10154160548981729", RegularImmutableSet.a);
        }

        public final String m6600a(String str) {
            switch (str.hashCode()) {
                case -641501232:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
