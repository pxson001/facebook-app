package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.MediaRouteButton;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.Toast;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.feed.annotations.IsInNewPlayerOldUIClosedCaptioningGateKeeper;
import com.facebook.feed.ui.VideoFeedStoryMenuHelper;
import com.facebook.feed.ui.fullscreenvideoplayer.SubtitleDialog;
import com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestCallback;
import com.facebook.feed.ui.fullscreenvideoplayer.service.VideoDeleteController;
import com.facebook.feed.ui.fullscreenvideoplayer.service.VideoDeleteController.C18971;
import com.facebook.feed.ui.fullscreenvideoplayer.service.VideoDeleteParams;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanHandleOnVideoDeleted;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.player.events.RVPActivityDialogEvent;
import com.facebook.video.player.events.RVPDialogEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesLanguageChangeEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesVisibilityChangeEvent;
import com.facebook.video.player.plugins.FullscreenSeekBarPlugin;
import com.facebook.video.player.plugins.OverflowMenuPlugin;
import com.facebook.video.subtitles.controller.Subtitles;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TimelineLoadCoverPhoto */
public class FeedFullscreenSeekBarPlugin<E extends CanHandleOnVideoDeleted & HasFeedMenuHelper> extends FullscreenSeekBarPlugin<E> {
    public SubtitleDialog f21989A;
    public ImmutableList<String> f21990B;
    private SeekBar f21991C;
    private FbTextView f21992D;
    private FbTextView f21993E;
    public MediaRouteButton f21994F;
    @Inject
    UriIntentMapper f21995l;
    @Inject
    SecureContextHelper f21996m;
    @Inject
    FragmentActivity f21997n;
    @Inject
    @IsInNewPlayerOldUIClosedCaptioningGateKeeper
    Provider<Boolean> f21998o;
    @Inject
    FbSharedPreferences f21999p;
    @Inject
    Lazy<VideoDeleteController> f22000q;
    @Inject
    @ForUiThread
    ListeningExecutorService f22001r;
    @Inject
    AbstractFbErrorReporter f22002s;
    @Inject
    FbAppType f22003t;
    private final OverflowMenuPlugin f22004u;
    private final View f22005v;
    private PopoverMenuWindow f22006w;
    private boolean f22007x;
    private boolean f22008y;
    public String f22009z;

    /* compiled from: TimelineLoadCoverPhoto */
    class C18661 implements OnClickListener {
        final /* synthetic */ FeedFullscreenSeekBarPlugin f21982a;

        C18661(FeedFullscreenSeekBarPlugin feedFullscreenSeekBarPlugin) {
            this.f21982a = feedFullscreenSeekBarPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 452816654);
            this.f21982a.m24609a(view);
            Logger.a(2, EntryType.UI_INPUT_END, 1954528486, a);
        }
    }

    /* compiled from: TimelineLoadCoverPhoto */
    class C18672 implements OnDismissListener {
        final /* synthetic */ FeedFullscreenSeekBarPlugin f21983a;

        C18672(FeedFullscreenSeekBarPlugin feedFullscreenSeekBarPlugin) {
            this.f21983a = feedFullscreenSeekBarPlugin;
        }

        public final boolean m24603a(PopoverWindow popoverWindow) {
            this.f21983a.g.a(new RVPDialogEvent(false));
            return true;
        }
    }

    /* compiled from: TimelineLoadCoverPhoto */
    class OverflowMenuClickListener implements OnMenuItemClickListener {
        final /* synthetic */ FeedFullscreenSeekBarPlugin f21988a;

        /* compiled from: TimelineLoadCoverPhoto */
        class C18681 implements DialogInterface.OnDismissListener {
            final /* synthetic */ OverflowMenuClickListener f21984a;

            C18681(OverflowMenuClickListener overflowMenuClickListener) {
                this.f21984a = overflowMenuClickListener;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                this.f21984a.f21988a.g.a(new RVPDialogEvent(false));
            }
        }

        /* compiled from: TimelineLoadCoverPhoto */
        class C18692 implements SubtitlesRequestCallback {
            final /* synthetic */ OverflowMenuClickListener f21985a;

            C18692(OverflowMenuClickListener overflowMenuClickListener) {
                this.f21985a = overflowMenuClickListener;
            }

            public final void mo1511a(Subtitles subtitles) {
                this.f21985a.f21988a.g.a(new RVPRequestSubtitlesLanguageChangeEvent(subtitles));
            }

            public final void mo1510a() {
                this.f21985a.f21988a.g.a(new RVPRequestSubtitlesVisibilityChangeEvent(false));
            }
        }

        /* compiled from: TimelineLoadCoverPhoto */
        class C18713 implements DialogInterface.OnClickListener {
            final /* synthetic */ OverflowMenuClickListener f21987a;

            /* compiled from: TimelineLoadCoverPhoto */
            class C18701 implements FutureCallback<Void> {
                final /* synthetic */ C18713 f21986a;

                C18701(C18713 c18713) {
                    this.f21986a = c18713;
                }

                public void onSuccess(@Nullable Object obj) {
                    if (this.f21986a.f21987a.f21988a.c != null) {
                        ((CanHandleOnVideoDeleted) this.f21986a.f21987a.f21988a.c).a();
                    }
                }

                public void onFailure(Throwable th) {
                    if (!(th instanceof IOException)) {
                        this.f21986a.f21987a.f21988a.f22002s.a("video_delete_fail", th);
                    }
                    Toast.makeText(this.f21986a.f21987a.f21988a.getContext(), 2131230758, 1).show();
                }
            }

            C18713(OverflowMenuClickListener overflowMenuClickListener) {
                this.f21987a = overflowMenuClickListener;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                VideoDeleteController videoDeleteController = (VideoDeleteController) this.f21987a.f21988a.f22000q.get();
                Futures.a(videoDeleteController.f22192c.a(new C18971(videoDeleteController, new VideoDeleteParams(this.f21987a.f21988a.f22009z))), new C18701(this), this.f21987a.f21988a.f22001r);
            }
        }

        public OverflowMenuClickListener(FeedFullscreenSeekBarPlugin feedFullscreenSeekBarPlugin) {
            this.f21988a = feedFullscreenSeekBarPlugin;
        }

        public final boolean m24606a(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case 1:
                    Intent a = this.f21988a.f21995l.a(this.f21988a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cB, this.f21988a.f22009z, GraphQLNegativeFeedbackActionType.DONT_LIKE, NegativeFeedbackExperienceLocation.FULLSCREEN_VIDEO_PLAYER.stringValueOf()));
                    if (a != null) {
                        this.f21988a.f21996m.a(a, this.f21988a.getContext());
                    }
                    this.f21988a.g.a(new RVPActivityDialogEvent());
                    return true;
                case 2:
                    if (this.f21988a.f21989A == null) {
                        this.f21988a.f21989A = SubtitleDialog.m24553a(this.f21988a.f22009z, new C18681(this), new C18692(this), this.f21988a.f21990B, this.f21988a.f21999p);
                    }
                    this.f21988a.f21989A.a(this.f21988a.f21997n.kO_(), null);
                    this.f21988a.g.a(new RVPDialogEvent(true));
                    return true;
                case 3:
                    new Builder(this.f21988a.getContext()).a(2131233441).b(2131233444).b(2131230727, null).a(2131230732, new C18713(this)).b();
                    return true;
                default:
                    return false;
            }
        }
    }

    private static <T extends View> void m24612a(Class<T> cls, T t) {
        m24613a((Object) t, t.getContext());
    }

    private static void m24613a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FeedFullscreenSeekBarPlugin) obj).m24610a((UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), FragmentActivityMethodAutoProvider.b(fbInjector), IdBasedProvider.a(fbInjector, 3985), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 6081), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (FbAppType) fbInjector.getInstance(FbAppType.class));
    }

    private void m24610a(UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, FragmentActivity fragmentActivity, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, Lazy<VideoDeleteController> lazy, ListeningExecutorService listeningExecutorService, FbErrorReporter fbErrorReporter, FbAppType fbAppType) {
        this.f21995l = uriIntentMapper;
        this.f21996m = secureContextHelper;
        this.f21997n = fragmentActivity;
        this.f21998o = provider;
        this.f21999p = fbSharedPreferences;
        this.f22000q = lazy;
        this.f22001r = listeningExecutorService;
        this.f22002s = fbErrorReporter;
        this.f22003t = fbAppType;
    }

    public FeedFullscreenSeekBarPlugin(Context context) {
        this(context, null);
    }

    public FeedFullscreenSeekBarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedFullscreenSeekBarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24612a(FeedFullscreenSeekBarPlugin.class, (View) this);
        this.f22004u = (OverflowMenuPlugin) a(2131561908);
        this.f22005v = a(2131561907);
        this.f21991C = (SeekBar) a(2131562401);
        this.f21992D = (FbTextView) a(2131562402);
        this.f21993E = (FbTextView) a(2131562400);
        this.f21994F = (MediaRouteButton) a(2131561906);
        this.f21989A = null;
        this.f21990B = null;
    }

    protected final void m24628a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        if (richVideoPlayerParams.b != null) {
            this.f21990B = (ImmutableList) richVideoPlayerParams.b.get("SubtitlesLocalesKey");
            this.f22007x = m24614a(richVideoPlayerParams.b.get("ShowDeleteOptionKey"));
            this.f22008y = m24614a(richVideoPlayerParams.b.get("ShowReportOptionKey"));
        }
        if (z) {
            m24625p();
        }
        this.f22009z = richVideoPlayerParams.a.b;
        if ((this.c instanceof HasFeedMenuHelper) && (((HasFeedMenuHelper) ((CanHandleOnVideoDeleted) this.c)).l() instanceof VideoFeedStoryMenuHelper)) {
            VideoFeedStoryMenuHelper videoFeedStoryMenuHelper = (VideoFeedStoryMenuHelper) ((HasFeedMenuHelper) ((CanHandleOnVideoDeleted) this.c)).l();
            videoFeedStoryMenuHelper.f21812z = this.f21990B;
            videoFeedStoryMenuHelper.f21803A = this.g;
        }
        this.f22004u.setEnvironment(this.c);
        this.f22004u.a(this.h, this.i, richVideoPlayerParams);
    }

    private static boolean m24614a(Object obj) {
        return obj != null ? ((Boolean) obj).booleanValue() : false;
    }

    protected final void m24629c() {
        super.c();
        this.f21989A = null;
        if (this.f22006w != null) {
            this.f22006w.l();
        }
        this.f22004u.b();
    }

    protected int getContentView() {
        return 2130904299;
    }

    private void m24625p() {
        int i;
        int i2 = 1;
        if (this.f22003t.j == Product.FB4A) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0 || !(this.c instanceof HasFeedMenuHelper)) {
            this.f22006w = new FigPopoverMenuWindow(getContext());
            if (this.f22008y) {
                this.f22006w.c().a(1, 0, 2131233432).setIcon(2130839815);
                i = 1;
            } else {
                i = 0;
            }
            if (m24626q() && m24627r()) {
                this.f22006w.c().a(2, 1, 2131233433).setIcon(2130839802);
                i = 1;
            }
            if (this.f22007x) {
                this.f22006w.c().a(3, 2, 2131233440).setIcon(2130840135);
            } else {
                i2 = i;
            }
            if (i2 != 0) {
                this.f22005v.setVisibility(0);
                this.f22005v.setOnClickListener(new C18661(this));
                this.f22006w.p = new OverflowMenuClickListener(this);
                return;
            }
            this.f22005v.setVisibility(8);
            return;
        }
        this.f22004u.setVisibility(0);
        this.f22005v.setVisibility(8);
    }

    private void m24609a(View view) {
        this.f22006w.H = new C18672(this);
        this.g.a(new RVPDialogEvent(true));
        this.f22006w.f(view);
    }

    private boolean m24626q() {
        return ((Boolean) this.f21998o.get()).equals(Boolean.TRUE);
    }

    private boolean m24627r() {
        return (this.f21990B == null || this.f21990B.isEmpty()) ? false : true;
    }

    protected MediaRouteButton getMediaRouteButton() {
        return this.f21994F;
    }

    protected final void m24630d(int i) {
        this.f21991C.setVisibility(i);
        this.f21992D.setVisibility(i);
        this.f21993E.setVisibility(i);
    }
}
