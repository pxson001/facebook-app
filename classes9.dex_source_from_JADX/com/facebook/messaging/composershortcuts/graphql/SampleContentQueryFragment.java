package com.facebook.messaging.composershortcuts.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentModels.SampleContentQueryFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: message_block_tap_unblock_on_facebook */
public final class SampleContentQueryFragment {

    /* compiled from: message_block_tap_unblock_on_facebook */
    public class SampleContentQueryFragmentString extends TypedGraphQlQueryString<SampleContentQueryFragmentModel> {
        public SampleContentQueryFragmentString() {
            super(SampleContentQueryFragmentModel.class, false, "SampleContentQueryFragment", "619119e434166e0f0ad008cf10d5e362", "messenger_more_apps", "10153970214791729", RegularImmutableSet.a);
        }

        public final String m10695a(String str) {
            switch (str.hashCode()) {
                case 1095692943:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
