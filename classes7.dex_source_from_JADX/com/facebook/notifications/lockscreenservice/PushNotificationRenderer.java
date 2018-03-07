package com.facebook.notifications.lockscreenservice;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.katana.push.fbpushdata.Fb4aPushNotificationIntentHelper;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationsUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: network_lagging */
public class PushNotificationRenderer {
    private static final Class f8360a = PushNotificationRenderer.class;
    public static final CallerContext f8361b = CallerContext.a(PushNotificationRenderer.class, "lockscreen_notifications");
    private static PushNotificationRenderer f8362l;
    private static final Object f8363m = new Object();
    public final Context f8364c;
    private final Resources f8365d;
    public final NotificationStoryHelper f8366e;
    public final NotificationsUtils f8367f;
    public final ViewPermalinkIntentFactory f8368g;
    public final SecureContextHelper f8369h;
    public final UriIntentMapper f8370i;
    public final Fb4aPushNotificationIntentHelper f8371j;
    public final Drawable f8372k = this.f8365d.getDrawable(2130841720);

    private static PushNotificationRenderer m9966b(InjectorLike injectorLike) {
        return new PushNotificationRenderer((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), NotificationStoryHelper.a(injectorLike), NotificationsUtils.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), Fb4aPushNotificationIntentHelper.b(injectorLike));
    }

    public static PushNotificationRenderer m9965a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PushNotificationRenderer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8363m) {
                PushNotificationRenderer pushNotificationRenderer;
                if (a2 != null) {
                    pushNotificationRenderer = (PushNotificationRenderer) a2.a(f8363m);
                } else {
                    pushNotificationRenderer = f8362l;
                }
                if (pushNotificationRenderer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9966b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8363m, b3);
                        } else {
                            f8362l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pushNotificationRenderer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PushNotificationRenderer(Context context, Resources resources, NotificationStoryHelper notificationStoryHelper, NotificationsUtils notificationsUtils, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, Fb4aPushNotificationIntentHelper fb4aPushNotificationIntentHelper) {
        this.f8364c = context;
        this.f8365d = resources;
        this.f8366e = notificationStoryHelper;
        this.f8367f = notificationsUtils;
        this.f8368g = viewPermalinkIntentFactory;
        this.f8369h = secureContextHelper;
        this.f8370i = uriIntentMapper;
        this.f8371j = fb4aPushNotificationIntentHelper;
    }
}
