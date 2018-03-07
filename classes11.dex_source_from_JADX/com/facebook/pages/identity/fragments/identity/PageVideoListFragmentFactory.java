package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.fb4a.videohub.fragments.VideoPlaylistPermalinkFragment;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: pages_browser_list_data */
public class PageVideoListFragmentFactory implements IFragmentFactory {
    private final PagesAnalytics f3963a;

    @Inject
    public PageVideoListFragmentFactory(PagesAnalytics pagesAnalytics) {
        this.f3963a = pagesAnalytics;
    }

    public final Fragment m4908a(Intent intent) {
        String stringExtra = intent.getStringExtra("page_video_list_id");
        long parseLong = Long.parseLong(intent.getStringExtra("com.facebook.katana.profile.id"));
        this.f3963a.b(parseLong, stringExtra, intent.getStringExtra("pages_navigation_source"));
        long parseLong2 = Long.parseLong(stringExtra);
        Preconditions.checkArgument(parseLong2 != 0);
        VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment = new VideoPlaylistPermalinkFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("video_list_id", parseLong2);
        bundle.putLong("page_id", parseLong);
        videoPlaylistPermalinkFragment.g(bundle);
        return videoPlaylistPermalinkFragment;
    }
}
