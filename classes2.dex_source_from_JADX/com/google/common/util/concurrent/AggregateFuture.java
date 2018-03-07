package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture.Failure;
import com.google.common.util.concurrent.AbstractFuture.TrustedFuture;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: messenger_inbox_unit_hides_remaining */
public abstract class AggregateFuture<InputT, OutputT> extends TrustedFuture<OutputT> {
    public static final Logger f13935a = Logger.getLogger(AggregateFuture.class.getName());
    public RunningState f13936b;

    /* compiled from: messenger_inbox_unit_hides_remaining */
    public abstract class RunningState extends AggregateFutureState implements Runnable {
        final /* synthetic */ AggregateFuture f14009a;
        public ImmutableCollection<? extends ListenableFuture<? extends InputT>> f14010b;
        public final boolean f14011c;
        public final boolean f14012d;

        /* compiled from: messenger_inbox_unit_hides_remaining */
        public class C05871 implements Runnable {
            final /* synthetic */ int f14017a;
            final /* synthetic */ ListenableFuture f14018b;
            final /* synthetic */ RunningState f14019c;

            public C05871(RunningState runningState, int i, ListenableFuture listenableFuture) {
                this.f14019c = runningState;
                this.f14017a = i;
                this.f14018b = listenableFuture;
            }

            public void run() {
                try {
                    RunningState.m20335a(this.f14019c, this.f14017a, this.f14018b);
                } finally {
                    RunningState.m20337g(this.f14019c);
                }
            }
        }

        abstract void mo2696a(boolean z, int i, @Nullable InputT inputT);

        public abstract void mo2697b();

        RunningState(AggregateFuture aggregateFuture, ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            this.f14009a = aggregateFuture;
            super(immutableCollection.size());
            this.f14010b = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
            this.f14011c = z;
            this.f14012d = z2;
        }

        public static void m20337g(RunningState runningState) {
            int decrementAndGet = AggregateFutureState.f14014b.decrementAndGet(runningState);
            Preconditions.checkState(decrementAndGet >= 0, "Less than 0 remaining futures");
            if (decrementAndGet == 0) {
                int i;
                boolean z = runningState.f14012d;
                if (runningState.f14011c) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i & z) != 0) {
                    Iterator it = runningState.f14010b.iterator();
                    i = 0;
                    while (it.hasNext()) {
                        int i2 = i + 1;
                        m20335a(runningState, i, (ListenableFuture) it.next());
                        i = i2;
                    }
                }
                runningState.mo2697b();
            }
        }

        public final void run() {
            m20337g(this);
        }

        private void m20336a(Throwable th) {
            boolean a;
            int i;
            int i2 = 1;
            Preconditions.checkNotNull(th);
            if (this.f14011c) {
                a = this.f14009a.mo222a(th);
                if (a) {
                    mo2695a();
                    i = 1;
                } else {
                    Set set = this.f14015c;
                    if (set == null) {
                        set = Sets.m1325b();
                        mo2698a(set);
                        AggregateFutureState.f14013a.compareAndSet(this, null, set);
                        set = this.f14015c;
                    }
                    i = AggregateFuture.m20274b(set, th);
                }
            } else {
                i = 1;
                a = false;
            }
            boolean z = th instanceof Error;
            boolean z2 = this.f14011c;
            if (a) {
                i2 = 0;
            }
            if (((i & (i2 & z2)) | z) != 0) {
                AggregateFuture.f13935a.log(Level.SEVERE, th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
            }
        }

        final void mo2698a(Set<Throwable> set) {
            if (!this.f14009a.isCancelled()) {
                AggregateFuture.m20274b(set, ((Failure) this.f14009a.f784e).f816b);
            }
        }

        public static void m20335a(RunningState runningState, int i, Future future) {
            boolean z = false;
            if (runningState.f14011c || !runningState.f14009a.isDone() || runningState.f14009a.isCancelled()) {
                z = true;
            }
            Preconditions.checkState(z, "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (runningState.f14011c) {
                    if (future.isCancelled()) {
                        super.cancel(false);
                        return;
                    }
                    Object a = Uninterruptibles.m1584a(future);
                    if (runningState.f14012d) {
                        runningState.mo2696a(runningState.f14011c, i, a);
                    }
                } else if (runningState.f14012d && !future.isCancelled()) {
                    runningState.mo2696a(runningState.f14011c, i, Uninterruptibles.m1584a(future));
                }
            } catch (ExecutionException e) {
                runningState.m20336a(e.getCause());
            } catch (Throwable th) {
                runningState.m20336a(th);
            }
        }

        void mo2695a() {
            this.f14010b = null;
        }
    }

    AggregateFuture() {
    }

    final void mo2651c() {
        super.mo2651c();
        this.f13936b = null;
    }

    public final boolean cancel(boolean z) {
        RunningState runningState = this.f13936b;
        ImmutableCollection immutableCollection = runningState != null ? runningState.f14010b : null;
        boolean cancel = super.cancel(z);
        if (((immutableCollection != null ? 1 : 0) & cancel) != 0) {
            Iterator it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((ListenableFuture) it.next()).cancel(z);
            }
        }
        return cancel;
    }

    @GwtIncompatible("Interruption not supported")
    protected final void mo2679a() {
        if (this.f13936b == null) {
        }
    }

    public static boolean m20274b(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
