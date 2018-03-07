package com.facebook.messaging.business.nativesignup.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsModels.NativeSignUpConfirmPhoneCodeMutationModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsModels.NativeSignUpSendConfirmationMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: native_plutonium_header */
public final class NativeSignUpPhoneVerificationMutations {

    /* compiled from: native_plutonium_header */
    public class NativeSignUpConfirmPhoneCodeMutationString extends TypedGraphQLMutationString<NativeSignUpConfirmPhoneCodeMutationModel> {
        public NativeSignUpConfirmPhoneCodeMutationString() {
            super(NativeSignUpConfirmPhoneCodeMutationModel.class, false, "NativeSignUpConfirmPhoneCodeMutation", "1e33f8ad346c7d899c31f478b3926902", "confirm_phone_code", "0", "10154346623701729", RegularImmutableSet.a);
        }

        public final String m9040a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: native_plutonium_header */
    public class NativeSignUpSendConfirmationMutationString extends TypedGraphQLMutationString<NativeSignUpSendConfirmationMutationModel> {
        public NativeSignUpSendConfirmationMutationString() {
            super(NativeSignUpSendConfirmationMutationModel.class, false, "NativeSignUpSendConfirmationMutation", "e8fb3868ed98621bb7fd0c8673024326", "send_confirmation_code", "0", "10154346623696729", RegularImmutableSet.a);
        }

        public final String m9041a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
