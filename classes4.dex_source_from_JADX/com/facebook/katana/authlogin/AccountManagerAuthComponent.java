package com.facebook.katana.authlogin;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.katana.platform.FacebookAuthenticationUtils;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sync_receiver */
public class AccountManagerAuthComponent extends AbstractAuthComponent {
    private static final Class<?> f1417a = AccountManagerAuthComponent.class;
    private final Context f1418b;
    private final FacebookAuthenticationUtils f1419c;
    private final BaseFbBroadcastManager f1420d;

    @Inject
    public AccountManagerAuthComponent(@ForAppContext Context context, FacebookAuthenticationUtils facebookAuthenticationUtils, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f1418b = context;
        this.f1419c = facebookAuthenticationUtils;
        this.f1420d = baseFbBroadcastManager;
    }

    public final void m1657a(@Nullable AuthenticationResult authenticationResult) {
        if (authenticationResult != null) {
            if ((authenticationResult.mo91d() != TriState.NO ? 1 : null) != null) {
                this.f1419c.m1664a(this.f1418b, authenticationResult.mo89b().f1494f);
                return;
            }
            return;
        }
        BLog.b(f1417a, "AuthenticationResult is unexpectedly null.");
    }

    public final void m1659c() {
        this.f1420d.a(new Intent(MessagesNotificationIntents.B));
    }

    public final void m1658b() {
        FacebookAuthenticationUtils.m1663b(this.f1418b, null);
    }

    public final void m1660f() {
        FacebookAuthenticationUtils.m1663b(this.f1418b, null);
    }
}
