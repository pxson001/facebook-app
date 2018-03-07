package com.facebook.messaging.business.ride.uri;

import android.content.Context;
import android.net.Uri;
import com.facebook.messaging.business.common.calltoaction.BusinessUriHandler;
import com.facebook.messaging.business.ride.helper.RideOauthHelper;
import com.facebook.messaging.business.ride.utils.RideshareUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_platform */
public class RideOrderUriHandler extends BusinessUriHandler {
    private final RideOauthHelper f9279a;
    private final RideshareUtil f9280b;

    @Inject
    public RideOrderUriHandler(RideOauthHelper rideOauthHelper, RideshareUtil rideshareUtil) {
        this.f9279a = rideOauthHelper;
        this.f9280b = rideshareUtil;
    }

    public final boolean mo329a(Context context, Uri uri, @Nullable ThreadKey threadKey) {
        this.f9279a.m9735a(this.f9280b.m9771a(uri));
        return true;
    }

    public final String mo330b() {
        return "order_ride";
    }
}
