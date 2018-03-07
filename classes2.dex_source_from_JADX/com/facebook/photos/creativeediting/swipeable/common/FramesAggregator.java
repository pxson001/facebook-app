package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.common.executors.C0275x5d33d28;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.photos.creativeediting.abtest.IsEligibleForFramePrompts;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

/* compiled from: mp_android_device_based_login_nux_v2 */
public class FramesAggregator {
    @Inject
    public Set<FramePackProvider> f13293a;
    @Inject
    @IsEligibleForFramePrompts
    public Provider<Boolean> f13294b;
    @Inject
    @ForegroundExecutorService
    public ExecutorService f13295c;

    public static FramesAggregator m19559b(InjectorLike injectorLike) {
        FramesAggregator framesAggregator = new FramesAggregator();
        MultiBinderSet multiBinderSet = new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$FramePackProvider(injectorLike));
        Provider a = IdBasedProvider.m1811a(injectorLike, 4248);
        ExecutorService a2 = C0275x5d33d28.m10458a(injectorLike);
        framesAggregator.f13293a = multiBinderSet;
        framesAggregator.f13294b = a;
        framesAggregator.f13295c = a2;
        return framesAggregator;
    }

    public final ListenableFuture<ImmutableList<FramePack>> m19560a() {
        Iterable arrayList = new ArrayList();
        if (((Boolean) this.f13294b.get()).booleanValue()) {
            for (FramePackProvider a : this.f13293a) {
                ListenableFuture a2 = a.a();
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return Futures.m2450a(Futures.m2451a(arrayList), new 1(this), this.f13295c);
    }

    public static FramesAggregator m19558a(InjectorLike injectorLike) {
        return m19559b(injectorLike);
    }
}
