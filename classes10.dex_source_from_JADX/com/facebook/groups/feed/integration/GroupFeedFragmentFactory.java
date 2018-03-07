package com.facebook.groups.feed.integration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import com.facebook.groups.feed.ui.GroupsFeedFragment;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TimelineSectionQuery */
public class GroupFeedFragmentFactory implements IFragmentFactory {
    private final QeAccessor f21988a;
    private final Provider<Boolean> f21989b;

    @Inject
    public GroupFeedFragmentFactory(QeAccessor qeAccessor, Provider<Boolean> provider) {
        this.f21988a = qeAccessor;
        this.f21989b = provider;
    }

    public final Fragment m23111a(Intent intent) {
        if (this.f21988a.a(Liveness.Live, ExperimentsForGroupsFeedIntegrationModule.f21987a, false) && ((Boolean) this.f21989b.get()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("group", intent.getExtras().getString("group_feed_id"));
            Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.c = "GroupsFeedApp";
            newBuilder = newBuilder;
            newBuilder.f = bundle;
            return newBuilder.b();
        }
        Fragment groupsFeedFragment = new GroupsFeedFragment();
        groupsFeedFragment.g(intent.getExtras());
        return groupsFeedFragment;
    }
}
