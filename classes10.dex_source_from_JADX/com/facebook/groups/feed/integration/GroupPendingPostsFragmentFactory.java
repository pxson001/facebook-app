package com.facebook.groups.feed.integration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import com.facebook.groups.abtest.ExperimentsForGroupsExperimentationModule;
import com.facebook.groups.feed.ui.GroupPendingPostsFragment;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TimelineInflateHeader */
public class GroupPendingPostsFragmentFactory implements IFragmentFactory {
    private final QeAccessor f21992a;
    private final Provider<Boolean> f21993b;

    @Inject
    public GroupPendingPostsFragmentFactory(QeAccessor qeAccessor, Provider<Boolean> provider) {
        this.f21992a = qeAccessor;
        this.f21993b = provider;
    }

    public final Fragment m23117a(Intent intent) {
        if (this.f21992a.a(Liveness.Live, ExperimentsForGroupsExperimentationModule.a, false) && ((Boolean) this.f21993b.get()).booleanValue()) {
            String string = intent.getExtras().getString("group_feed_id");
            Bundle bundle = new Bundle();
            bundle.putString("propertyToUpdate", "pending");
            bundle.putString("group", string);
            Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.a = "/group_pending_posts";
            newBuilder = newBuilder;
            newBuilder.b = "GroupsPendingPostsRoute";
            newBuilder = newBuilder;
            newBuilder.f = bundle;
            newBuilder = newBuilder;
            newBuilder.d = 2131237993;
            return newBuilder.b();
        }
        Fragment groupPendingPostsFragment = new GroupPendingPostsFragment();
        groupPendingPostsFragment.g(intent.getExtras());
        return groupPendingPostsFragment;
    }
}
