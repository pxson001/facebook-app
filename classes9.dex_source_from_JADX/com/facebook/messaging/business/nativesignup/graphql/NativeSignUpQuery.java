package com.facebook.messaging.business.nativesignup.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.NativeSignUpNewUserSignUpQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: name_input_controller_fragment_tag */
public final class NativeSignUpQuery {

    /* compiled from: name_input_controller_fragment_tag */
    public class NativeSignUpNewUserSignUpQueryString extends TypedGraphQlQueryString<NativeSignUpNewUserSignUpQueryModel> {
        public NativeSignUpNewUserSignUpQueryString() {
            super(NativeSignUpNewUserSignUpQueryModel.class, false, "NativeSignUpNewUserSignUpQuery", "7b3290ef3d4f2befac64b0653947f6a8", "me", "10154681999936729", RegularImmutableSet.a);
        }

        public final String m9055a(String str) {
            switch (str.hashCode()) {
                case 974663898:
                    return "1";
                case 2064701993:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
