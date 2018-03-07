package com.facebook.identitygrowth.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mCropRectTop */
public final class ProfileQuestionGraphQL {

    /* compiled from: mCropRectTop */
    public class ProfileQuestionQueryString extends TypedGraphQlQueryString<ProfileQuestionQueryModel> {
        public ProfileQuestionQueryString() {
            super(ProfileQuestionQueryModel.class, false, "ProfileQuestionQuery", "95274d9100a962d09d6334246d461429", "viewer", "10154358537661729", RegularImmutableSet.a);
        }

        public final TriState m17945g() {
            return TriState.NO;
        }

        public final String m17944a(String str) {
            switch (str.hashCode()) {
                case -1853231955:
                    return "0";
                case 112787:
                    return "3";
                case 109250890:
                    return "2";
                case 1984987798:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final ProfileQuestionQueryString m17946a() {
        return new ProfileQuestionQueryString();
    }
}
