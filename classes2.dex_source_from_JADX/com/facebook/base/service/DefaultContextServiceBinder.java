package com.facebook.base.service;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import javax.inject.Inject;

/* compiled from: mKeyValues */
public class DefaultContextServiceBinder {
    private static final Class<?> f15541a = DefaultContextServiceBinder.class;
    private final Context f15542b;

    public static DefaultContextServiceBinder m22161b(InjectorLike injectorLike) {
        return new DefaultContextServiceBinder((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public DefaultContextServiceBinder(Context context) {
        this.f15542b = ContextUtils.m2497a(context);
    }

    public final boolean m22163a(Intent intent, ServiceConnection serviceConnection, int i) {
        this.f15542b.getClass();
        return ServiceConnectionDetour.a(this.f15542b, intent, serviceConnection, i, 1569482816);
    }

    public final void m22162a(ServiceConnection serviceConnection) {
        ServiceConnectionDetour.a(this.f15542b, serviceConnection, -810719460);
    }
}
