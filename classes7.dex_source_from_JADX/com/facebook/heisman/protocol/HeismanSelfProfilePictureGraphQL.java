package com.facebook.heisman.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLModels.SelfProfilePictureFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: positive_action */
public final class HeismanSelfProfilePictureGraphQL {

    /* compiled from: positive_action */
    public class SelfProfilePictureQueryString extends TypedGraphQlQueryString<SelfProfilePictureFieldsModel> {
        public SelfProfilePictureQueryString() {
            super(SelfProfilePictureFieldsModel.class, false, "SelfProfilePictureQuery", "2a55324c4bef9ffa4d4308248337fde7", "node", "10154609788416729", RegularImmutableSet.a);
        }

        public final String m7922a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case -1102636175:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
