package com.facebook.redspace.fragment.controllercallbacks.controller;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.time.Clock;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnSaveInstanceStateCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.data.RedSpaceMutationsExecutor;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.C14031;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.C14042;
import com.facebook.redspace.data.RedSpaceMutator;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import java.util.concurrent.TimeUnit;

/* compiled from: PageVideoHubQuery */
public class RedSpaceFriendViewMutationController implements FragmentCreateDestroyCallbacks, OnSaveInstanceStateCallback, OnUserVisibleHintCallback {
    private static final long f12065a = TimeUnit.SECONDS.toMillis(0);
    @Inject
    public Clock f12066b;
    @Inject
    public QeAccessor f12067c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceMutationsExecutor> f12068d = UltralightRuntime.b;
    public RedSpaceFeedProfileFragmentModel f12069e;
    public TimelineContext f12070f;
    private long f12071g;
    public boolean f12072h;
    public boolean f12073i;
    private final Handler f12074j = new Handler();
    private final Runnable f12075k = new C14431(this);

    /* compiled from: PageVideoHubQuery */
    class C14431 implements Runnable {
        final /* synthetic */ RedSpaceFriendViewMutationController f12064a;

        C14431(RedSpaceFriendViewMutationController redSpaceFriendViewMutationController) {
            this.f12064a = redSpaceFriendViewMutationController;
        }

        public void run() {
            RedSpaceMutationsExecutor redSpaceMutationsExecutor = (RedSpaceMutationsExecutor) this.f12064a.f12068d.get();
            RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = this.f12064a.f12069e;
            RedSpaceFeedProfileFragmentModel a = RedSpaceMutator.m12291a(redSpaceFeedProfileFragmentModel);
            redSpaceMutationsExecutor.f11842c.a("friendsView" + redSpaceFeedProfileFragmentModel.k(), new C14031(redSpaceMutationsExecutor, redSpaceFeedProfileFragmentModel, a), new C14042(redSpaceMutationsExecutor, a));
            this.f12064a.f12072h = true;
        }
    }

    public final void m12529a(boolean z) {
        if (z) {
            this.f12071g = this.f12066b.a();
            m12527f();
        }
    }

    public final void m12531c() {
        this.f12073i = true;
        m12527f();
    }

    private void m12527f() {
        if (!this.f12072h && this.f12073i && this.f12071g != 0) {
            int a = this.f12067c.a(ExperimentsForRedSpaceExperimentsModule.j, (int) f12065a);
            long max = Math.max(this.f12066b.a() - this.f12071g, (long) a);
            if (max > ((long) a)) {
                this.f12075k.run();
            } else {
                HandlerDetour.b(this.f12074j, this.f12075k, ((long) a) - max, -1480679785);
            }
        }
    }

    public final void m12530b() {
    }

    public final void m12528a(Bundle bundle) {
        bundle.putBoolean("bundle_friend_view_sent", this.f12072h);
        bundle.putBoolean("bundle_friend_view_fetch", this.f12073i);
    }
}
