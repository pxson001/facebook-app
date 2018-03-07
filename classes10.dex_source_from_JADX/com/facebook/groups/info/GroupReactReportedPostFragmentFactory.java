package com.facebook.groups.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;

/* compiled from: ThreadItemView.init */
public class GroupReactReportedPostFragmentFactory implements IFragmentFactory {
    public final Fragment m23679a(Intent intent) {
        String string = intent.getExtras().getString("group_feed_id");
        Bundle bundle = new Bundle();
        bundle.putString("propertyToUpdate", "reported");
        bundle.putString("group", string);
        Builder newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.a = "/group_reported_posts";
        newBuilder = newBuilder;
        newBuilder.f = bundle;
        newBuilder = newBuilder;
        newBuilder.b = "GroupsReportedPostsRoute";
        return newBuilder.b();
    }
}
