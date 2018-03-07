package com.facebook.messaging.media.imageurirequest.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentModels.DownloadImageFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: is_forwardable */
public final class DownloadImageFragment {

    /* compiled from: is_forwardable */
    public class DownloadImageFragmentString extends TypedGraphQlQueryString<DownloadImageFragmentModel> {
        public DownloadImageFragmentString() {
            super(DownloadImageFragmentModel.class, false, "DownloadImageFragment", "1fd5cdb5f2addcc9d1e38f21f8c2b755", "node", "10154358537956729", RegularImmutableSet.a);
        }

        public final String m18998a(String str) {
            switch (str.hashCode()) {
                case -694787331:
                    return "1";
                case 3136215:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
