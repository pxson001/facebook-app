package com.facebook.messaging.business.ride.helper;

import android.content.Context;
import android.os.Bundle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.SignupMessageInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.location.Coordinates;
import com.facebook.messaging.business.nativesignup.helpers.BusinessNativeSignUpResultHandler;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.business.ride.graphql.RideMutaions.RideSignupMessageMutationString;
import com.facebook.messaging.business.ride.helper.RideMutationHelper.C10543;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.business.ride.view.RideRequestFragment;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: moments_invite */
public class RideNativeSignUpResultHandler implements BusinessNativeSignUpResultHandler {
    private final Context f9207a;
    private final SecureContextHelper f9208b;
    private final RideMutationHelper f9209c;

    public static RideNativeSignUpResultHandler m9718b(InjectorLike injectorLike) {
        return new RideNativeSignUpResultHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), RideMutationHelper.m9712b(injectorLike));
    }

    @Inject
    public RideNativeSignUpResultHandler(Context context, SecureContextHelper secureContextHelper, RideMutationHelper rideMutationHelper) {
        this.f9207a = context;
        this.f9208b = secureContextHelper;
        this.f9209c = rideMutationHelper;
    }

    public final String mo321a() {
        return "RideNativeSignUpResultHandler";
    }

    public final boolean mo322a(NativeSignUpParams nativeSignUpParams) {
        String str = nativeSignUpParams.f8884a;
        ThreadKey threadKey = nativeSignUpParams.f8888e;
        Bundle bundle = nativeSignUpParams.f8889f;
        if (Strings.isNullOrEmpty(str) || threadKey == null || bundle == null) {
            return false;
        }
        String string = bundle.getString("entry_point");
        String string2 = bundle.getString("provider_display_name");
        if (Strings.isNullOrEmpty(string) || Strings.isNullOrEmpty(string2)) {
            return false;
        }
        SecureContextHelper secureContextHelper = this.f9208b;
        Context context = this.f9207a;
        RideServiceParamsBuilder newBuilder = RideServiceParams.newBuilder();
        newBuilder.f9302d = str;
        newBuilder = newBuilder;
        newBuilder.f9303e = string2;
        newBuilder = newBuilder;
        newBuilder.f9300b = threadKey;
        newBuilder = newBuilder;
        newBuilder.f9299a = string;
        newBuilder = newBuilder;
        newBuilder.f9304f = bundle.getString("request_tag");
        newBuilder = newBuilder;
        newBuilder.f9301c = bundle.getString("address");
        RideServiceParamsBuilder rideServiceParamsBuilder = newBuilder;
        rideServiceParamsBuilder.f9305g = (Coordinates) bundle.getParcelable("dest_coordinates");
        newBuilder = rideServiceParamsBuilder;
        newBuilder.f9307i = bundle.getBoolean("is_dest_optional");
        secureContextHelper.a(RideRequestFragment.m9841a(context, newBuilder.m9767j()), this.f9207a);
        return true;
    }

    public final boolean mo323b(NativeSignUpParams nativeSignUpParams) {
        RideMutationHelper rideMutationHelper = this.f9209c;
        String str = nativeSignUpParams.f8884a;
        if (rideMutationHelper.f9204k == null) {
            SignupMessageInputData signupMessageInputData = new SignupMessageInputData();
            signupMessageInputData.a("provider_name", str);
            GraphQlQueryString rideSignupMessageMutationString = new RideSignupMessageMutationString();
            rideSignupMessageMutationString.a("input", signupMessageInputData);
            rideMutationHelper.f9204k = rideMutationHelper.f9197d.a(GraphQLRequest.a(rideSignupMessageMutationString));
            Futures.a(rideMutationHelper.f9204k, new C10543(rideMutationHelper), rideMutationHelper.f9198e);
        }
        return true;
    }
}
