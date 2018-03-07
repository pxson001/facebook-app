package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.StartStopCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.MultiRowMultiAdapter;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.presence.Availability;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceManager.OnContactPresenceStateChangedListener;
import com.facebook.presence.PresenceState;
import com.facebook.redspace.data.RedSpaceHeaderCollection;
import com.facebook.redspace.model.PresenceActivitySharing;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: PageStoryCardsQuery */
public class RedSpacePresenceActivityController extends BaseController implements StartStopCallbacks, AdapterCreatedCallback {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PresenceManager> f12081a = UltralightRuntime.b;
    public RedSpaceFeedProfileFragmentModel f12082b;
    public TimelineContext f12083c;
    public boolean f12084d;
    public UserKey f12085e;
    public PresenceChanged f12086f;
    public RedSpaceHeaderCollection f12087g;
    private MultiRowMultiAdapter f12088h;

    /* compiled from: PageStoryCardsQuery */
    public class PresenceChanged extends OnContactPresenceStateChangedListener {
        final /* synthetic */ RedSpacePresenceActivityController f12080a;

        public PresenceChanged(RedSpacePresenceActivityController redSpacePresenceActivityController) {
            this.f12080a = redSpacePresenceActivityController;
        }

        public final void m12535a(UserKey userKey, PresenceState presenceState) {
            if (userKey.equals(this.f12080a.f12085e)) {
                RedSpacePresenceActivityController.m12536a(this.f12080a, presenceState);
            }
        }
    }

    public final void m12539e() {
        if (m12537b()) {
            ((DefaultPresenceManager) this.f12081a.get()).a(this);
            ((DefaultPresenceManager) this.f12081a.get()).a(this.f12085e);
            ((DefaultPresenceManager) this.f12081a.get()).a(this.f12085e, this.f12086f);
            m12536a(this, ((DefaultPresenceManager) this.f12081a.get()).c(this.f12085e));
        }
    }

    public final void m12540f() {
        if (m12537b()) {
            ((DefaultPresenceManager) this.f12081a.get()).b(this.f12085e, this.f12086f);
            ((DefaultPresenceManager) this.f12081a.get()).b(this);
        }
    }

    public final void m12538a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f12088h = (MultiRowMultiAdapter) hasMultiRow;
    }

    public final void kF_() {
    }

    private boolean m12537b() {
        return !this.f12083c.i() && this.f12084d;
    }

    public static void m12536a(RedSpacePresenceActivityController redSpacePresenceActivityController, PresenceState presenceState) {
        if (presenceState != null && ((DefaultPresenceManager) redSpacePresenceActivityController.f12081a.get()).d(redSpacePresenceActivityController.f12085e) != null) {
            boolean z;
            long j = ((DefaultPresenceManager) redSpacePresenceActivityController.f12081a.get()).d(redSpacePresenceActivityController.f12085e).a;
            PresenceActivitySharing presenceActivitySharing = redSpacePresenceActivityController.f12087g.f11812b.c.b;
            if (presenceState.b == Availability.AVAILABLE) {
                z = true;
            } else {
                z = false;
            }
            presenceActivitySharing.b = z;
            presenceActivitySharing.c = presenceState;
            presenceActivitySharing.d = j;
            presenceActivitySharing.a = true;
            AdapterDetour.a(redSpacePresenceActivityController.f12088h, 853155218);
        }
    }
}
