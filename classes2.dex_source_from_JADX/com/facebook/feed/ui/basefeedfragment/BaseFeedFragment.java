package com.facebook.feed.ui.basefeedfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.content.event.FbEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents$FlyoutOnDismissEventSubscriber;
import com.facebook.ufiservices.event.FlyoutEvents$FlyoutOnResumeEventSubscriber;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.player.PlayerActivityManager;
import javax.annotation.Nullable;

/* compiled from: processName cannot be null if specified explicitly */
public abstract class BaseFeedFragment extends FbFragment implements IRefreshableFragment {
    private OnBackStackChangedListener f9011a;
    public VideoPlayerManager f9012b;
    public PlayerActivityManager f9013c;
    private FlyoutEventBus f9014d;
    private final FeedFlyoutOnResumeEventSubscriber f9015e = new FeedFlyoutOnResumeEventSubscriber(this);
    private final FeedFlyoutOnDismissEventSubscriber f9016f = new FeedFlyoutOnDismissEventSubscriber(this);

    /* compiled from: processName cannot be null if specified explicitly */
    class FeedFlyoutOnResumeEventSubscriber extends FlyoutEvents$FlyoutOnResumeEventSubscriber {
        final /* synthetic */ BaseFeedFragment f9017a;

        public FeedFlyoutOnResumeEventSubscriber(BaseFeedFragment baseFeedFragment) {
            this.f9017a = baseFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f9017a.as();
            if (this.f9017a.f9012b != null) {
                this.f9017a.f9012b.m13933a(true);
                if (this.f9017a.f9013c != null) {
                    this.f9017a.f9013c.m12998a(EventTriggerType.BY_FLYOUT);
                }
            }
        }
    }

    /* compiled from: processName cannot be null if specified explicitly */
    class FeedFlyoutOnDismissEventSubscriber extends FlyoutEvents$FlyoutOnDismissEventSubscriber {
        final /* synthetic */ BaseFeedFragment f9018a;

        public FeedFlyoutOnDismissEventSubscriber(BaseFeedFragment baseFeedFragment) {
            this.f9018a = baseFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f9018a.ar();
            if (this.f9018a.f9012b != null) {
                this.f9018a.f9012b.m13933a(false);
                if (this.f9018a.hn_()) {
                    this.f9018a.f9013c.m13002b(EventTriggerType.BY_FLYOUT);
                }
            }
        }
    }

    /* compiled from: processName cannot be null if specified explicitly */
    class C04021 implements OnBackStackChangedListener {
        final /* synthetic */ BaseFeedFragment f9020a;

        C04021(BaseFeedFragment baseFeedFragment) {
            this.f9020a = baseFeedFragment;
        }

        public final void le_() {
            this.f9020a.aq();
        }
    }

    public void mo1859c(@Nullable Bundle bundle) {
        super.mo1859c(bundle);
        this.f9011a = new C04021(this);
        this.f9012b = VideoPlayerManager.m13903a(an());
        this.f9013c = PlayerActivityManager.m12995a(an());
        this.f9014d = FlyoutEventBus.m14086a(an());
    }

    protected void aq() {
    }

    public void mo1884G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 739322213);
        super.mo1884G();
        aq();
        if (this.f9011a != null) {
            this.f100D.mo845a(this.f9011a);
        }
        if (this.f9013c != null) {
            this.f9013c.m13002b(EventTriggerType.BY_NEWSFEED_ONPAUSE);
        }
        if (this.f9014d != null) {
            this.f9014d.m4568a(this.f9015e);
            this.f9014d.m4568a(this.f9016f);
        }
        if (this.f9012b != null) {
            this.f9012b.m13933a(false);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2110925008, a);
    }

    public void mo1885H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1020390963);
        if (this.f9011a != null) {
            this.f100D.mo848b(this.f9011a);
        }
        if (this.f9012b != null) {
            this.f9013c.m12998a(EventTriggerType.BY_NEWSFEED_ONPAUSE);
        }
        if (this.f9014d != null) {
            this.f9014d.m4569b(this.f9015e);
            this.f9014d.m4569b(this.f9016f);
        }
        super.mo1885H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1584500043, a);
    }

    public void mo1856I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1570153169);
        super.mo1856I();
        this.f9011a = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -850913323, a);
    }

    public void mo1860g(boolean z) {
        if (!z && m225D() && this.f9013c != null) {
            this.f9013c.m12998a(EventTriggerType.BY_NEWSFEED_OCCLUSION);
        } else if (z && this.f9013c != null) {
            this.f9013c.m13002b(EventTriggerType.BY_NEWSFEED_OCCLUSION);
        }
        super.mo1860g(z);
    }

    protected void ar() {
    }

    protected void as() {
    }
}
