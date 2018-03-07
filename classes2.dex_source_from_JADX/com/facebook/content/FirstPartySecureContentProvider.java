package com.facebook.content;

import android.content.Context;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: ~ */
public abstract class FirstPartySecureContentProvider extends AbstractContentProvider {
    @Inject
    @Sessionless
    public GatekeeperStoreImpl f26a;

    public static void m64a(Object obj, Context context) {
        ((FirstPartySecureContentProvider) obj).f26a = GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(FbInjector.get(context));
    }

    protected void mo10a() {
        Class cls = FirstPartySecureContentProvider.class;
        m64a(this, getContext());
    }

    protected final boolean mo9b() {
        if (PermissionChecks.a(getContext())) {
            return true;
        }
        if (this.f26a.m2189a(5, false) && PermissionChecks.b(getContext())) {
            return true;
        }
        return false;
    }
}
