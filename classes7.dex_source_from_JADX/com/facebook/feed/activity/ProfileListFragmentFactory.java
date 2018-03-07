package com.facebook.feed.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.feed.ui.PermalinkProfileListFragment;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ufiservices.flyout.ProfileListParams.Builder;

/* compiled from: args_feedback_id */
public class ProfileListFragmentFactory implements IFragmentFactory {
    public final Fragment m22675a(Intent intent) {
        ProfileListParamType profileListParamType = ProfileListParamType.values()[Integer.valueOf(intent.getIntExtra("profile_list_type", ProfileListParamType.PROFILES.ordinal())).intValue()];
        String stringExtra = intent.getStringExtra("fragment_title");
        if (profileListParamType == ProfileListParamType.PROFILES) {
            Builder builder = new Builder();
            builder.h = stringExtra;
            ProfileListParams a = builder.a();
            PermalinkProfileListFragment permalinkProfileListFragment = new PermalinkProfileListFragment();
            permalinkProfileListFragment.g(a.k());
            return permalinkProfileListFragment;
        }
        String stringExtra2;
        if (profileListParamType == ProfileListParamType.VOTERS_FOR_POLL_OPTION_ID) {
            stringExtra2 = intent.getStringExtra("graphql_poll_option_id");
        } else {
            stringExtra2 = intent.getStringExtra("graphql_feedback_id");
        }
        Builder builder2 = new Builder();
        builder2.a = stringExtra2;
        builder = builder2;
        builder.d = profileListParamType;
        builder = builder;
        builder.h = stringExtra;
        a = builder.a();
        Fragment permalinkProfileListFragment2 = new PermalinkProfileListFragment();
        permalinkProfileListFragment2.g(a.k());
        return permalinkProfileListFragment2;
    }
}
