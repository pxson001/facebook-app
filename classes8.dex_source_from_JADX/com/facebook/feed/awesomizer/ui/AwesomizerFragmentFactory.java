package com.facebook.feed.awesomizer.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import com.facebook.feed.awesomizer.abtest.ExperimentsForFeedAwesomizerTestModule;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: has_faces */
public class AwesomizerFragmentFactory implements IFragmentFactory {
    private final Provider<Boolean> f11746a;
    private final QeAccessor f11747b;

    @Inject
    public AwesomizerFragmentFactory(Provider<Boolean> provider, QeAccessor qeAccessor) {
        this.f11746a = provider;
        this.f11747b = qeAccessor;
    }

    public final Fragment m13845a(Intent intent) {
        if (!((Boolean) this.f11746a.get()).booleanValue() || !this.f11747b.a(ExperimentsForFeedAwesomizerTestModule.f11604b, false)) {
            return new AwesomizerFragment();
        }
        Builder newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.a = "/feed_awesomizer";
        newBuilder = newBuilder;
        newBuilder.b = "AwesomizerRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131236138;
        return newBuilder.b();
    }
}
