package com.facebook.confirmation.util;

import android.os.Bundle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: inline_confirm_friend_request */
public class ConfirmationUtil {
    private final DefaultBlueServiceOperationFactory f10811a;

    public static ConfirmationUtil m12750b(InjectorLike injectorLike) {
        return new ConfirmationUtil(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public ConfirmationUtil(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f10811a = defaultBlueServiceOperationFactory;
    }

    public final void m12751a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchAndUpdateInterstitialsParams", new FetchInterstitialsParams(ImmutableList.of("1907")));
        BlueServiceOperationFactoryDetour.a(this.f10811a, "interstitials_fetch_and_update", bundle, -991848451).a();
    }
}
