package com.facebook.feed.annotations;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: report_afro */
public class TriState_IsCopyStoryEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m4266b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(46);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(46);
    }
}
