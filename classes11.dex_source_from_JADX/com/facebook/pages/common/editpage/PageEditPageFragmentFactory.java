package com.facebook.pages.common.editpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: show_suggested_tab */
public class PageEditPageFragmentFactory implements IFragmentFactory {
    private final GatekeeperStoreImpl f1573a;

    @Inject
    public PageEditPageFragmentFactory(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f1573a = gatekeeperStoreImpl;
    }

    public final Fragment m2260a(Intent intent) {
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
        if (this.f1573a.a(1046, false)) {
            Preconditions.checkArgument(longExtra > 0);
            Bundle bundle = new Bundle();
            bundle.putLong("com.facebook.katana.profile.id", longExtra);
            EditPageFragmentV2 editPageFragmentV2 = new EditPageFragmentV2();
            editPageFragmentV2.g(bundle);
            return editPageFragmentV2;
        }
        Preconditions.checkArgument(longExtra > 0);
        bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", longExtra);
        EditPageFragment editPageFragment = new EditPageFragment();
        editPageFragment.g(bundle);
        return editPageFragment;
    }
}
