package com.facebook.groups.info.navigation;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: This operation is not supported. */
public class DefaultGroupInfoSecondaryActionDelegate extends AbstractGroupInfoSecondaryActionDelegate {
    public final AnalyticsLogger f22717c;
    private final SecureContextHelper f22718d;
    private Resources f22719e;

    public static DefaultGroupInfoSecondaryActionDelegate m23685b(InjectorLike injectorLike) {
        return new DefaultGroupInfoSecondaryActionDelegate(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public DefaultGroupInfoSecondaryActionDelegate(AnalyticsLogger analyticsLogger, Resources resources, SecureContextHelper secureContextHelper) {
        this.f22717c = analyticsLogger;
        this.f22718d = secureContextHelper;
        this.f22719e = resources;
    }

    public final Drawable mo993a() {
        return this.f22719e.getDrawable(2130840095);
    }

    public final String mo994b() {
        return this.f22719e.getString(2131242198);
    }

    public final void mo995c() {
        HoneyClientEventFast a = this.f22717c.a("share_group", false);
        if (a.a()) {
            a.a("group_info");
            a.b();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.f22715a.m23869N());
        this.f22718d.b(Intent.createChooser(intent, this.f22716b.getString(2131242199)), this.f22716b);
    }
}
