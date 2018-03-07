package com.facebook.redspace.adapter;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.fragment.RedSpaceStoriesFragment;
import com.facebook.redspace.pagerindicator.SwipeImagePagerAdapter;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.titlebar.RedSpaceTitleAdapter;
import com.facebook.user.model.User;
import javax.inject.Inject;

/* compiled from: Pulsar detection disabled in settings */
public class RedSpaceUserCollectionAdapter extends FragmentStatePagerAdapter implements SwipeImagePagerAdapter, RedSpaceTitleAdapter {
    public final RedSpaceFriendsCollection f11736a;
    private final int f11737b;
    private final Resources f11738c;
    private final String f11739d;
    private final RedSpaceFeedProfileUnreadStoriesHelper f11740e;
    private final RedSpaceStrings f11741f;
    private final User f11742g;

    @Inject
    public RedSpaceUserCollectionAdapter(String str, LoggedInUserSessionManager loggedInUserSessionManager, Resources resources, RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper, RedSpaceStrings redSpaceStrings, @Assisted FragmentManager fragmentManager, @Assisted RedSpaceFriendsCollection redSpaceFriendsCollection, @Assisted int i) {
        super(fragmentManager);
        this.f11739d = str;
        this.f11742g = loggedInUserSessionManager.c();
        this.f11738c = resources;
        this.f11740e = redSpaceFeedProfileUnreadStoriesHelper;
        this.f11741f = redSpaceStrings;
        this.f11736a = redSpaceFriendsCollection;
        this.f11737b = i;
    }

    public final Fragment m12169a(int i) {
        RedSpaceFeedProfileFragmentModel a = this.f11736a.m12213a(i);
        int i2 = this.f11737b;
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "bundle_profile_model", a);
        bundle.putInt("bundle_feed_padding_top", i2);
        RedSpaceStoriesFragment redSpaceStoriesFragment = new RedSpaceStoriesFragment();
        redSpaceStoriesFragment.g(bundle);
        return redSpaceStoriesFragment;
    }

    public final Uri mo329b(int i) {
        RedSpaceFeedProfileFragmentModel a = this.f11736a.m12213a(i);
        if (this.f11742g != null && StringUtil.a(this.f11742g.a, a.k()) && this.f11742g.x() != null) {
            return UriUtil.a(this.f11742g.x());
        }
        if (a.l() == null) {
            return null;
        }
        return UriUtil.a(a.l().b());
    }

    public final Uri mo330c(int i) {
        RedSpaceFeedProfileFragmentModel a = this.f11736a.m12213a(i);
        if (this.f11742g != null && StringUtil.a(this.f11742g.a, a.k()) && this.f11742g.j != null) {
            return UriUtil.a(this.f11742g.j);
        }
        if (a.j() == null || a.j().a() == null || a.j().a().a() == null) {
            return null;
        }
        return UriUtil.a(a.j().a().a().b());
    }

    public final int I_(int i) {
        return this.f11740e.m12204a(this.f11736a.m12213a(i));
    }

    public final String mo331e(int i) {
        RedSpaceFeedProfileFragmentModel a = this.f11736a.m12213a(i);
        if (StringUtil.a(this.f11739d, a.k())) {
            return this.f11741f.d();
        }
        return this.f11741f.a(GraphQLHelper.a(a.n()));
    }

    public final int mo328b() {
        return this.f11736a == null ? 0 : this.f11736a.m12222d();
    }
}
