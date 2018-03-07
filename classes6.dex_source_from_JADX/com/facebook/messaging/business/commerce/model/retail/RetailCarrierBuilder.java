package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: video_time */
public class RetailCarrierBuilder {
    public String f649a;
    @Nullable
    public LogoImage f650b;
    @Nullable
    public Uri f651c;
    @Nullable
    public String f652d;

    public final RetailCarrierBuilder m700b(@Nullable String str) {
        this.f651c = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final RetailCarrier m701e() {
        return new RetailCarrier(this);
    }
}
