package com.facebook.privacy.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.privacy.protocol.PrivacyMutationsModels.SetStoryPrivacyCoreMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sticker_pack_downloaded */
public final class PrivacyMutations {

    /* compiled from: sticker_pack_downloaded */
    public class SetStoryPrivacyCoreMutationString extends TypedGraphQLMutationString<SetStoryPrivacyCoreMutationFieldsModel> {
        public SetStoryPrivacyCoreMutationString() {
            super(SetStoryPrivacyCoreMutationFieldsModel.class, false, "SetStoryPrivacyCoreMutation", "00b2abf9070ad39595bddddc5b127393", "privacy_scope_edit", "0", "10154343227206729", RegularImmutableSet.a);
        }

        public final String m6074a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
