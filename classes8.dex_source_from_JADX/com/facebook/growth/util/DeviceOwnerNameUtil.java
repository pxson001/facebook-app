package com.facebook.growth.util;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: edit_location */
public class DeviceOwnerNameUtil {
    private final Context f14919a;
    private final AbstractFbErrorReporter f14920b;

    private static DeviceOwnerNameUtil m17383b(InjectorLike injectorLike) {
        return new DeviceOwnerNameUtil((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DeviceOwnerNameUtil(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f14919a = context.getApplicationContext();
        this.f14920b = abstractFbErrorReporter;
    }
}
