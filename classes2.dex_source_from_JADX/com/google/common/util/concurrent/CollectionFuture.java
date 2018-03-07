package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.AggregateFuture.RunningState;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: messenger_inline_video_android */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    /* compiled from: messenger_inline_video_android */
    abstract class CollectionFutureRunningState extends RunningState {
        final /* synthetic */ CollectionFuture f14007b;
        private List<Optional<V>> f14008c;

        abstract C mo2694a(List<Optional<V>> list);

        CollectionFutureRunningState(CollectionFuture collectionFuture, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            ArrayList arrayList;
            this.f14007b = collectionFuture;
            super(collectionFuture, immutableCollection, z, true);
            if (immutableCollection.isEmpty()) {
                arrayList = RegularImmutableList.f535a;
            } else {
                arrayList = Lists.m1297a(immutableCollection.size());
            }
            this.f14008c = arrayList;
            for (int i = 0; i < immutableCollection.size(); i++) {
                this.f14008c.add(null);
            }
        }

        final void mo2696a(boolean z, int i, @Nullable V v) {
            List list = this.f14008c;
            if (list != null) {
                list.set(i, Optional.fromNullable(v));
                return;
            }
            boolean z2 = z || this.f14007b.isCancelled();
            Preconditions.checkState(z2, "Future was done before all dependencies completed");
        }

        final void mo2697b() {
            List list = this.f14008c;
            if (list != null) {
                this.f14007b.mo221a(mo2694a(list));
            } else {
                Preconditions.checkState(this.f14007b.isDone());
            }
        }

        final void mo2695a() {
            super.mo2695a();
            this.f14008c = null;
        }
    }

    CollectionFuture() {
    }
}
