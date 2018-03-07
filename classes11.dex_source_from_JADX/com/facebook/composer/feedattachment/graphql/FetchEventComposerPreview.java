package com.facebook.composer.feedattachment.graphql;

import com.facebook.composer.feedattachment.graphql.FetchEventComposerPreviewModels.FetchEventComposerPreviewModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: getgames_scrolled_event */
public final class FetchEventComposerPreview {

    /* compiled from: getgames_scrolled_event */
    public class FetchEventComposerPreviewString extends TypedGraphQlQueryString<FetchEventComposerPreviewModel> {
        public FetchEventComposerPreviewString() {
            super(FetchEventComposerPreviewModel.class, false, "FetchEventComposerPreview", "c6d32153b0019b3d9c984dc70d441e93", "node", "10154429037801729", RegularImmutableSet.a);
        }

        public final String m7947a(String str) {
            switch (str.hashCode()) {
                case -1849402738:
                    return "1";
                case 278118624:
                    return "0";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
