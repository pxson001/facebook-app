package com.facebook.messaging.business.messengerextensions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: threadViewLoader.serviceException.throwableMessage */
public final class MessengerExtensionsManager {
    private static MessengerExtensionsManager f1642d;
    private static final Object f1643e = new Object();
    @Nullable
    private MessengerExtensionsEventListener f1644a;
    @Nullable
    private MessengerExtensionsPresenter f1645b;
    private final MessengerExtensionsGatekeepers f1646c;

    private static MessengerExtensionsManager m1595b(InjectorLike injectorLike) {
        return new MessengerExtensionsManager(new MessengerExtensionsGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public MessengerExtensionsManager(MessengerExtensionsGatekeepers messengerExtensionsGatekeepers) {
        this.f1646c = messengerExtensionsGatekeepers;
    }

    public final boolean m1596a(Context context, String str, ThreadKey threadKey) {
        if (!this.f1646c.f1620a.a(269, false)) {
            return false;
        }
        if (this.f1645b != null) {
            MessengerExtensionsPresenter messengerExtensionsPresenter = this.f1645b;
            if (messengerExtensionsPresenter.f1654d != null) {
                messengerExtensionsPresenter.f1654d.dismiss();
                messengerExtensionsPresenter.f1654d = null;
            }
            this.f1645b = null;
        }
        this.f1645b = new MessengerExtensionsPresenter(context, str, threadKey);
        this.f1645b.f1655e = this.f1644a;
        return true;
    }

    public static MessengerExtensionsManager m1594a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessengerExtensionsManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1643e) {
                MessengerExtensionsManager messengerExtensionsManager;
                if (a2 != null) {
                    messengerExtensionsManager = (MessengerExtensionsManager) a2.a(f1643e);
                } else {
                    messengerExtensionsManager = f1642d;
                }
                if (messengerExtensionsManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1595b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1643e, b3);
                        } else {
                            f1642d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messengerExtensionsManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
