package com.facebook.messaging.business.common.activity;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BasicBannerNotificationView;
import com.facebook.common.banner.BasicBannerNotificationView.Params;
import com.facebook.common.banner.BasicBannerNotificationView.Params.Builder;
import com.facebook.common.banner.BasicBannerNotificationView.Params.DisplayMode;
import javax.inject.Inject;

/* compiled from: new_user_signup */
public class BusinessRequestErrorBannerNotification extends AbstractBannerNotification {
    private final LayoutInflater f8688a;
    public final Resources f8689b;
    public final Context f8690c;
    private final Params f8691d;

    @Inject
    public BusinessRequestErrorBannerNotification(LayoutInflater layoutInflater, Resources resources, Context context) {
        String string;
        super("BusinessRequestErrorBannerNotification");
        this.f8688a = layoutInflater;
        this.f8689b = resources;
        this.f8690c = context;
        Builder builder = new Builder();
        builder.d = false;
        builder = builder;
        if (System.getInt(this.f8690c.getContentResolver(), "airplane_mode_on", 0) == 1) {
            string = this.f8689b.getString(2131236787);
        } else {
            string = this.f8689b.getString(2131236786);
        }
        builder.a = string;
        builder = builder;
        builder.c = this.f8689b.getDrawable(2131363299);
        builder = builder;
        builder.h = DisplayMode.ALWAYS;
        this.f8691d = builder.a();
    }

    public final View m8897a(ViewGroup viewGroup) {
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) this.f8688a.inflate(2130903387, viewGroup, false);
        basicBannerNotificationView.setParams(this.f8691d);
        return basicBannerNotificationView;
    }
}
