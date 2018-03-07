package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.fb4a.videohub.fragments.VideoPlaylistAllVideosPermalinkFragment;
import com.facebook.pages.fb4a.videohub.fragments.VideoTabAllVideosOptimizedFetchingFragment;
import javax.inject.Inject;

/* compiled from: pages_browser_unlike_failure */
public class PageVideoListAllVideosFragmentFactory implements IFragmentFactory {
    private final PagesAnalytics f3961a;
    private final PagesExperimentUtils f3962b;

    @Inject
    public PageVideoListAllVideosFragmentFactory(PagesAnalytics pagesAnalytics, PagesExperimentUtils pagesExperimentUtils) {
        this.f3961a = pagesAnalytics;
        this.f3962b = pagesExperimentUtils;
    }

    public final Fragment m4907a(Intent intent) {
        long parseLong = Long.parseLong(intent.getStringExtra("com.facebook.katana.profile.id"));
        this.f3961a.a(TapEvent.EVENT_TAPPED_VIDEO_HUB_ALL_VIDEOS, parseLong);
        if (this.f3962b.a()) {
            return VideoTabAllVideosOptimizedFetchingFragment.m4133a(parseLong, true);
        }
        VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment = new VideoPlaylistAllVideosPermalinkFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("page_id", parseLong);
        bundle.putBoolean("extra_is_inside_page_surface_tab", false);
        videoPlaylistAllVideosPermalinkFragment.g(bundle);
        return videoPlaylistAllVideosPermalinkFragment;
    }
}
