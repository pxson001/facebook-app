package com.facebook.messaging.payment.ui.model;

import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: facebook_hmac */
public class MessengerPayNuxBannerViewParam {
    @Nullable
    public final Drawable f15148a;
    @Nullable
    public final String f15149b;
    @Nullable
    public final String f15150c;

    public MessengerPayNuxBannerViewParam(MessengerPayNuxBannerViewParamBuilder messengerPayNuxBannerViewParamBuilder) {
        this.f15148a = messengerPayNuxBannerViewParamBuilder.f15151a;
        this.f15149b = messengerPayNuxBannerViewParamBuilder.f15152b;
        this.f15150c = messengerPayNuxBannerViewParamBuilder.f15153c;
    }
}
