package com.facebook.common.ui.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: short_description */
public class ViewOrientationLockHelper {
    private final Activity f2773a;
    private final ViewOrientationAwareContext f2774b;
    public final BetterRotationManager f2775c;
    private final AnalyticsLogger f2776d;

    @Inject
    public ViewOrientationLockHelper(@Assisted View view, BetterRotationManager betterRotationManager, AnalyticsLogger analyticsLogger) {
        Context context = view.getContext();
        this.f2773a = (Activity) ContextUtils.a(context, Activity.class);
        this.f2774b = (ViewOrientationAwareContext) ContextUtils.a(context, ViewOrientationAwareContext.class);
        this.f2775c = betterRotationManager;
        this.f2776d = analyticsLogger;
    }

    public final void m3881a() {
        int i;
        int a = this.f2775c.m3863a();
        switch (this.f2775c.m3863a()) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 0;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                i = 9;
                break;
            case 3:
                i = 8;
                break;
            default:
                i = -1;
                break;
        }
        m3880a(i);
        int a2 = this.f2775c.m3863a();
        if (a2 != a) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("rotation_lock_changed_rotation");
            honeyClientEvent.c = "view_orientation_lock_helper";
            this.f2776d.a(honeyClientEvent.a("original_rotation", a).a("new_rotation", a2).b("model_name", Build.MODEL));
        }
    }

    public final void m3882b() {
        m3880a(-1);
    }

    private void m3880a(int i) {
        if (this.f2773a != null) {
            this.f2773a.setRequestedOrientation(i);
        }
    }
}
