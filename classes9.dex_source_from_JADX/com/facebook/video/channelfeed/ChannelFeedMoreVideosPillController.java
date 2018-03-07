package com.facebook.video.channelfeed;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.autoplay.CenteredVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator.VideoDisplayedChangedListener;
import com.facebook.feedback.ui.AbstractPillController;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.video.channelfeed.ChannelFeedRootView.AnonymousClass10;
import com.facebook.video.player.RichVideoPlayerScheduledRunnable;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: synchronizeAfterServerChange */
public class ChannelFeedMoreVideosPillController extends AbstractPillController {
    public final VideoDisplayedCoordinator f2356a;
    private final VideoDisplayedChangedListener<ChannelFeedVideoAttachmentView> f2357b = new C02131(this);
    @Nullable
    public LazyView<View> f2358c;
    @Nullable
    public AnonymousClass10 f2359d;
    private boolean f2360e;
    public String f2361f;
    public ChannelFeedVideoAttachmentView f2362g;
    private RichVideoPlayerScheduledRunnable f2363h;
    public OnClickListener f2364i;

    /* compiled from: synchronizeAfterServerChange */
    class C02131 implements VideoDisplayedChangedListener<ChannelFeedVideoAttachmentView> {
        final /* synthetic */ ChannelFeedMoreVideosPillController f2353a;

        C02131(ChannelFeedMoreVideosPillController channelFeedMoreVideosPillController) {
            this.f2353a = channelFeedMoreVideosPillController;
        }

        public final void m2314a(@Nullable View view, @Nullable View view2) {
            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) view2;
            if (this.f2353a.f2361f == null || (channelFeedVideoAttachmentView != null && this.f2353a.f2361f.equals(channelFeedVideoAttachmentView.f2524h))) {
                this.f2353a.f2361f = channelFeedVideoAttachmentView.f2524h;
                this.f2353a.f2362g = channelFeedVideoAttachmentView;
                ChannelFeedMoreVideosPillController.m2316j(this.f2353a);
                return;
            }
            ChannelFeedMoreVideosPillController.m2315i(this.f2353a);
        }
    }

    /* compiled from: synchronizeAfterServerChange */
    public class C02153 implements OnClickListener {
        final /* synthetic */ ChannelFeedMoreVideosPillController f2355a;

        public C02153(ChannelFeedMoreVideosPillController channelFeedMoreVideosPillController) {
            this.f2355a = channelFeedMoreVideosPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 249222420);
            View view2 = this.f2355a.f2356a.k;
            if (!(view2 == null || this.f2355a.f2359d == null)) {
                AnonymousClass10 anonymousClass10 = this.f2355a.f2359d;
                anonymousClass10.f2406a.f2447P.a(view2.getBottom(), 300);
            }
            ChannelFeedMoreVideosPillController.m2315i(this.f2355a);
            Logger.a(2, EntryType.UI_INPUT_END, 1013196707, a);
        }
    }

    @Inject
    public ChannelFeedMoreVideosPillController(@Assisted LazyView<View> lazyView, @Assisted ViewCallback viewCallback, CenteredVideoAutoplayManager centeredVideoAutoplayManager, SpringSystem springSystem, ViewAnimatorFactory viewAnimatorFactory) {
        super(springSystem, viewAnimatorFactory);
        this.f2358c = (LazyView) Preconditions.checkNotNull(lazyView);
        this.f2359d = (AnonymousClass10) Preconditions.checkNotNull(viewCallback);
        this.f2356a = centeredVideoAutoplayManager.a;
        this.f2356a.a(this.f2357b);
    }

    public final void m2317a(int i) {
        this.f2360e = true;
        if (i <= 1) {
            m2315i(this);
        } else {
            m2316j(this);
        }
    }

    public static void m2315i(ChannelFeedMoreVideosPillController channelFeedMoreVideosPillController) {
        channelFeedMoreVideosPillController.f2356a.b(channelFeedMoreVideosPillController.f2357b);
        if (!(channelFeedMoreVideosPillController.f2362g == null || channelFeedMoreVideosPillController.f2363h == null)) {
            channelFeedMoreVideosPillController.f2362g.getRichVideoPlayer().b(channelFeedMoreVideosPillController.f2363h);
            channelFeedMoreVideosPillController.f2363h = null;
            channelFeedMoreVideosPillController.f2362g = null;
        }
        channelFeedMoreVideosPillController.b();
    }

    public static void m2316j(ChannelFeedMoreVideosPillController channelFeedMoreVideosPillController) {
        if (channelFeedMoreVideosPillController.f2360e && channelFeedMoreVideosPillController.f2362g != null) {
            channelFeedMoreVideosPillController.f2363h = new RichVideoPlayerScheduledRunnable(channelFeedMoreVideosPillController, 0.7f, 1.0f) {
                final /* synthetic */ ChannelFeedMoreVideosPillController f2354a;

                public void run() {
                    if (this.f2354a.f2362g != null) {
                        this.f2354a.f2362g.getRichVideoPlayer().b(this);
                        if (this.f2354a.f2358c != null) {
                            View a = this.f2354a.f2358c.a();
                            ChannelFeedMoreVideosPillController channelFeedMoreVideosPillController = this.f2354a;
                            if (channelFeedMoreVideosPillController.f2364i == null) {
                                channelFeedMoreVideosPillController.f2364i = new C02153(channelFeedMoreVideosPillController);
                            }
                            a.setOnClickListener(channelFeedMoreVideosPillController.f2364i);
                            boolean a2 = this.f2354a.a();
                        }
                    }
                }
            };
            channelFeedMoreVideosPillController.f2362g.getRichVideoPlayer().a(channelFeedMoreVideosPillController.f2363h);
        }
    }

    @Nullable
    protected final LazyView<? extends View> m2318g() {
        return this.f2358c;
    }
}
