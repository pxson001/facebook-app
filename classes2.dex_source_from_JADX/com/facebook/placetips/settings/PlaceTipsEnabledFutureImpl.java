package com.facebook.placetips.settings;

import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.facebook.placetips.bootstrap.PlaceTipsEnabledFuture;
import com.facebook.placetips.bootstrap.PulsarDetectionEnabledFuture;
import com.facebook.placetips.gpscore.abtest.ExperimentsForPlaceTipsGpsAbTestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reaction.abtest.ExperimentsForReactionAbtestModule;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: method/user.validateregistrationdata */
public class PlaceTipsEnabledFutureImpl extends ForwardingListenableFuture<Boolean> implements PlaceTipsEnabledFuture {
    private final Lazy<ListenableFuture<Boolean>> f13546a;
    public final QeAccessor f13547b;

    /* compiled from: method/user.validateregistrationdata */
    class C05411 implements Function<Boolean, Boolean> {
        final /* synthetic */ PlaceTipsEnabledFutureImpl f13548a;

        C05411(PlaceTipsEnabledFutureImpl placeTipsEnabledFutureImpl) {
            this.f13548a = placeTipsEnabledFutureImpl;
        }

        public Object apply(Object obj) {
            Boolean bool = (Boolean) obj;
            boolean z = false;
            if (this.f13548a.f13547b.mo596a(ExperimentsForPlaceTipsGpsAbTestModule.f13562a, false) || this.f13548a.f13547b.mo596a(ExperimentsForReactionAbtestModule.f13566c, false) || bool.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    protected final /* synthetic */ Future mo1830a() {
        return mo2648b();
    }

    protected final /* synthetic */ Object mo105e() {
        return mo2648b();
    }

    @Inject
    public PlaceTipsEnabledFutureImpl(Lazy<PulsarDetectionEnabledFuture> lazy, QeAccessor qeAccessor) {
        this.f13547b = qeAccessor;
        this.f13546a = LazyFutures.m19931a(lazy, new C05411(this), DirectExecutor.INSTANCE);
    }

    protected final ListenableFuture<Boolean> mo2648b() {
        return (ListenableFuture) this.f13546a.get();
    }
}
