package com.facebook.messaging.media.externalmedia.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mContactInfoId */
public final class ExternalMediaQueryFragment {

    /* compiled from: mContactInfoId */
    public class ExternalMediaQueryFragmentString extends TypedGraphQlQueryString<ExternalMediaQueryFragmentModel> {
        public ExternalMediaQueryFragmentString() {
            super(ExternalMediaQueryFragmentModel.class, false, "ExternalMediaQueryFragment", "f4c7e81c0a583a15ff822112c69c2d9a", "messenger_external_media", "10153858388671729", RegularImmutableSet.a);
        }

        public final String m12246a(String str) {
            switch (str.hashCode()) {
                case 1095692943:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final ExternalMediaQueryFragmentString m12247a() {
        return new ExternalMediaQueryFragmentString();
    }
}
