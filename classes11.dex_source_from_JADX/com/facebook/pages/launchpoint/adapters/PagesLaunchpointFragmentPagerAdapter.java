package com.facebook.pages.launchpoint.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.base.fragment.FbFragment;
import com.facebook.feed.fragment.NewsFeedFragment.Builder;
import com.facebook.inject.Assisted;
import com.facebook.pages.launchpoint.fragments.PagesLaunchpointDiscoverFragment;
import com.facebook.pages.launchpoint.fragments.PagesReactionLaunchpointHomeFragment;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: page_identity_create_page_fail */
public class PagesLaunchpointFragmentPagerAdapter extends FragmentPagerAdapter {
    private final String f4304a;
    private final Context f4305b;
    private final SparseArray<WeakReference<FbFragment>> f4306c = new SparseArray();

    @Inject
    public PagesLaunchpointFragmentPagerAdapter(String str, @Assisted FragmentManager fragmentManager, @Assisted Context context) {
        super(fragmentManager);
        this.f4304a = str;
        this.f4305b = context;
    }

    public final CharSequence J_(int i) {
        PagesLaunchpointFragmentType pagesLaunchpointFragmentType = PagesLaunchpointFragmentType.values()[i];
        switch (pagesLaunchpointFragmentType) {
            case PAGES_LAUNCHPOINT_HOME_FRAGMENT:
                return this.f4305b.getString(2131239346);
            case PAGES_LAUNCHPOINT_DISCOVER_FRAGMENT:
                return this.f4305b.getString(2131239347);
            case PAGES_LAUNCHPOINT_FEED_FRAGMENT:
                return this.f4305b.getString(2131239348);
            default:
                throw new IllegalStateException("Unknown Pages Launchpoint Fragment Type: " + pagesLaunchpointFragmentType);
        }
    }

    public final Fragment m5248a(int i) {
        PagesLaunchpointFragmentType pagesLaunchpointFragmentType = PagesLaunchpointFragmentType.values()[i];
        switch (pagesLaunchpointFragmentType) {
            case PAGES_LAUNCHPOINT_HOME_FRAGMENT:
                Bundle bundle = new Bundle();
                PagesReactionLaunchpointHomeFragment pagesReactionLaunchpointHomeFragment = new PagesReactionLaunchpointHomeFragment();
                bundle.putBoolean("ptr_enabled", true);
                pagesReactionLaunchpointHomeFragment.g(bundle);
                return pagesReactionLaunchpointHomeFragment;
            case PAGES_LAUNCHPOINT_DISCOVER_FRAGMENT:
                return new PagesLaunchpointDiscoverFragment();
            case PAGES_LAUNCHPOINT_FEED_FRAGMENT:
                Builder builder = new Builder();
                builder.a = new FeedType(this.f4304a, Name.g);
                builder = builder;
                builder.c = false;
                return builder.d();
            default:
                throw new IllegalStateException("Unknown Pages Launchpoint Fragment Type: " + pagesLaunchpointFragmentType);
        }
    }

    public final int m5251b() {
        return PagesLaunchpointFragmentType.values().length;
    }

    public final Object m5249a(ViewGroup viewGroup, int i) {
        FbFragment fbFragment = (FbFragment) super.a(viewGroup, i);
        this.f4306c.put(i, new WeakReference(fbFragment));
        return fbFragment;
    }

    public final void m5250a(ViewGroup viewGroup, int i, Object obj) {
        this.f4306c.remove(i);
        super.a(viewGroup, i, obj);
    }
}
