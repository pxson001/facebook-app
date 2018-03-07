package com.facebook.placetips.presence;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.settings.PlaceTipsSettingsChangedListener;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: redirect_intent */
public class PresenceResetListener implements IHaveUserData, PlaceTipsSettingsChangedListener {
    private final Lazy<PagePresenceManager> f3541a;

    public static PresenceResetListener m3931b(InjectorLike injectorLike) {
        return new PresenceResetListener(IdBasedSingletonScopeProvider.b(injectorLike, 3009));
    }

    @Inject
    public PresenceResetListener(Lazy<PagePresenceManager> lazy) {
        this.f3541a = lazy;
    }

    public void clearUserData() {
        ((PagePresenceManager) this.f3541a.get()).a(true);
    }

    public final void m3932a(@Nullable GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel2) {
        boolean a = GravitySettingsUtil.a(gravitySettingsGraphQlFragmentModel2);
        boolean b = GravitySettingsUtil.b(gravitySettingsGraphQlFragmentModel2);
        boolean a2 = GravitySettingsUtil.a(gravitySettingsGraphQlFragmentModel);
        boolean b2 = GravitySettingsUtil.b(gravitySettingsGraphQlFragmentModel);
        if ((!b && b2) || (!a && a2)) {
            ((PagePresenceManager) this.f3541a.get()).a(false);
        }
    }
}
