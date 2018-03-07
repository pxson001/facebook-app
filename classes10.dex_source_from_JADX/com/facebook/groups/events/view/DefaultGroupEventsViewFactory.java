package com.facebook.groups.events.view;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: U */
public class DefaultGroupEventsViewFactory {
    public Resources f21882a;

    public static DefaultGroupEventsViewFactory m23043b(InjectorLike injectorLike) {
        return new DefaultGroupEventsViewFactory(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultGroupEventsViewFactory(Resources resources) {
        this.f21882a = resources;
    }
}
