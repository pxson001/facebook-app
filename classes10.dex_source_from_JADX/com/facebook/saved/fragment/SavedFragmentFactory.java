package com.facebook.saved.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.saved.gating.feature.SavedDashboardV2;
import com.facebook.saved2.ui.Saved2Fragment;
import javax.inject.Inject;

/* compiled from: invitedMemberMegaphone */
public class SavedFragmentFactory implements IFragmentFactory {
    private final GatekeeperStoreImpl f9143a;

    @Inject
    public SavedFragmentFactory(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f9143a = gatekeeperStoreImpl;
    }

    public final Fragment m9137a(Intent intent) {
        Fragment saved2Fragment;
        if (SavedDashboardV2.a(this.f9143a)) {
            saved2Fragment = new Saved2Fragment();
        } else {
            saved2Fragment = new SavedFragment();
        }
        saved2Fragment.g(intent.getExtras());
        return saved2Fragment;
    }
}
