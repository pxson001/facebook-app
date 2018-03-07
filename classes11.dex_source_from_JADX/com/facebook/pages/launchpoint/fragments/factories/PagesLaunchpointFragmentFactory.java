package com.facebook.pages.launchpoint.fragments.factories;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.launchpoint.fragments.PagesLaunchpointFragment;

/* compiled from: page_context_rows_subscribe_to_nearby_events_fail */
public class PagesLaunchpointFragmentFactory implements IFragmentFactory {
    public final Fragment m5287a(Intent intent) {
        PagesLaunchpointFragment pagesLaunchpointFragment = new PagesLaunchpointFragment();
        pagesLaunchpointFragment.g(intent.getExtras());
        return pagesLaunchpointFragment;
    }
}
