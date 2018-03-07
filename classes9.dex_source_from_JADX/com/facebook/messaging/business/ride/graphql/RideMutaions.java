package com.facebook.messaging.business.ride.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideCancelMutationModel;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideRequestMutationModel;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideSignupMessageMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: moreCount */
public final class RideMutaions {

    /* compiled from: moreCount */
    public class RideCancelMutationString extends TypedGraphQLMutationString<RideCancelMutationModel> {
        public RideCancelMutationString() {
            super(RideCancelMutationModel.class, false, "RideCancelMutation", "bd4ff7cf1066d15af17312acac9e2680", "ride_cancel", "0", "10154204803911729", RegularImmutableSet.a);
        }

        public final String m9370a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: moreCount */
    public class RideRequestMutationString extends TypedGraphQLMutationString<RideRequestMutationModel> {
        public RideRequestMutationString() {
            super(RideRequestMutationModel.class, false, "RideRequestMutation", "078e8ddacbffa63982042d62a0496f18", "ride_request_create", "0", "10154204803941729", RegularImmutableSet.a);
        }

        public final String m9371a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: moreCount */
    public class RideSignupMessageMutationString extends TypedGraphQLMutationString<RideSignupMessageMutationModel> {
        public RideSignupMessageMutationString() {
            super(RideSignupMessageMutationModel.class, false, "RideSignupMessageMutation", "b294fb3f157946eb2c8b5e857ad27c0b", "signup_message", "0", "10154432284866729", RegularImmutableSet.a);
        }

        public final String m9372a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
