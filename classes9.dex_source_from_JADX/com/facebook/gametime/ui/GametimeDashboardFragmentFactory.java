package com.facebook.gametime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.gametime.ui.reaction.GametimeDashboardFragment;

/* compiled from: TD;II) */
public class GametimeDashboardFragmentFactory implements IFragmentFactory {
    public final Fragment m27076a(Intent intent) {
        GametimeDashboardFragment gametimeDashboardFragment = new GametimeDashboardFragment();
        Bundle bundle = intent.getExtras() == null ? new Bundle() : intent.getExtras();
        bundle.putBoolean("ptr_enabled", true);
        gametimeDashboardFragment.g(bundle);
        return gametimeDashboardFragment;
    }
}
