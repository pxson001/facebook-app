package com.facebook.sync;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: liked_profiles */
public class DefaultSyncContextChecker {
    private final LoggedInUserSessionManager f9358a;

    public static DefaultSyncContextChecker m9749b(InjectorLike injectorLike) {
        return new DefaultSyncContextChecker(LoggedInUserSessionManager.a(injectorLike));
    }

    @Inject
    DefaultSyncContextChecker(LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f9358a = loggedInUserSessionManager;
    }

    public final boolean m9750a() {
        return this.f9358a.b() && !this.f9358a.d();
    }
}
