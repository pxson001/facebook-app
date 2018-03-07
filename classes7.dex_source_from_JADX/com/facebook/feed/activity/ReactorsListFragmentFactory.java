package com.facebook.feed.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.feedback.reactions.ui.PermalinkReactorsListFragment;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ufiservices.flyout.ProfileListParams.Builder;
import java.util.HashMap;

/* compiled from: args */
public class ReactorsListFragmentFactory implements IFragmentFactory {
    public final Fragment m22676a(Intent intent) {
        String stringExtra = intent.getStringExtra("fragment_title");
        String stringExtra2 = intent.getStringExtra("graphql_feedback_id");
        String stringExtra3 = intent.getStringExtra("module_name");
        boolean booleanExtra = intent.getBooleanExtra("reaction_can_viewer_ban_user", false);
        HashMap hashMap = (HashMap) intent.getSerializableExtra("reaction_type_count_map");
        Builder builder = new Builder();
        builder.a = stringExtra2;
        Builder builder2 = builder;
        builder2.h = stringExtra;
        Builder builder3 = builder2;
        builder3.i = stringExtra3;
        builder3 = builder3;
        builder3.j = hashMap;
        builder3 = builder3;
        builder3.g = booleanExtra;
        ProfileListParams a = builder3.a();
        PermalinkReactorsListFragment permalinkReactorsListFragment = new PermalinkReactorsListFragment();
        permalinkReactorsListFragment.g(a.k());
        return permalinkReactorsListFragment;
    }
}
