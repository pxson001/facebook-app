package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.fig.dialog.FigDialog;
import com.facebook.fig.dialog.FigDialog.Builder;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved2.ui.mutator.Saved2DbMutator;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.downloadmanager.DownloadException;
import com.facebook.video.downloadmanager.DownloadException.ExceptionCode;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.downloadmanager.VideoDownloadRequest;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.events.VideoDownloadEventBus;
import com.facebook.video.events.VideoDownloadEvents.DownloadStatusChangeEvent;
import com.facebook.video.events.VideoDownloadStatus;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.Utils;
import com.facebook.video.player.events.RVPPlayIconStateEvent;
import com.facebook.video.player.events.RVPPlayIconStateEvent.State;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TextWithEntities is null for poll  */
public class PlayDownloadPlugin extends RichVideoPlayerPlugin {
    public static final InterstitialTrigger f22287q = new InterstitialTrigger(Action.VIDEO_DOWNLOAD);
    private static final String f22288r = PlayDownloadPlugin.class.getSimpleName();
    private final View f22289A;
    private FigDialog f22290B;
    public final OnClickListener f22291C;
    public final OnClickListener f22292D;
    private final DialogInterface.OnClickListener f22293E;
    public String f22294F;
    public VideoDownloadStatus f22295G;
    private Uri f22296H;
    private String f22297I;
    private String f22298J;
    public State f22299K;
    private FeedProps<GraphQLStory> f22300L;
    private FeedProps<GraphQLStory> f22301M;
    private boolean f22302N;
    public long f22303O;
    @Inject
    DownloadManager f22304a;
    @Inject
    @FragmentChromeActivity
    Provider<ComponentName> f22305b;
    @Inject
    SecureContextHelper f22306c;
    @Inject
    DialtoneController f22307d;
    @Inject
    VideoDownloadEventBus f22308l;
    @Inject
    public InterstitialStartHelper f22309m;
    @Inject
    SaveButtonUtils f22310n;
    @Inject
    @ForUiThread
    Executor f22311o;
    @Inject
    Saved2DbMutator f22312p;
    private final VideoDownloadEventHandler f22313s;
    private final Handler f22314t;
    private final ImageView f22315u;
    public final GlyphView f22316v;
    private final BetterTextView f22317w;
    private final BetterTextView f22318x;
    private final BetterTextView f22319y;
    public final BetterTextView f22320z;

    /* compiled from: TextWithEntities is null for poll  */
    class C19041 implements OnClickListener {
        final /* synthetic */ PlayDownloadPlugin f22272a;

        C19041(PlayDownloadPlugin playDownloadPlugin) {
            this.f22272a = playDownloadPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1294068443);
            PlayDownloadPlugin.m24929k(this.f22272a);
            this.f22272a.f22316v.setImageResource(2130839815);
            this.f22272a.f22316v.setOnClickListener(this.f22272a.f22292D);
            Logger.a(2, EntryType.UI_INPUT_END, -915491239, a);
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    class C19052 implements OnClickListener {
        final /* synthetic */ PlayDownloadPlugin f22273a;

        C19052(PlayDownloadPlugin playDownloadPlugin) {
            this.f22273a = playDownloadPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -196489359);
            this.f22273a.f22304a.b(this.f22273a.f22294F);
            this.f22273a.f22316v.setImageResource(2130839834);
            this.f22273a.f22316v.setOnClickListener(this.f22273a.f22291C);
            Logger.a(2, EntryType.UI_INPUT_END, 898747897, a);
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    class C19063 implements DialogInterface.OnClickListener {
        final /* synthetic */ PlayDownloadPlugin f22274a;

        C19063(PlayDownloadPlugin playDownloadPlugin) {
            this.f22274a = playDownloadPlugin;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent component = new Intent().setComponent((ComponentName) this.f22274a.f22305b.get());
            component.putExtra("target_fragment", ContentFragmentType.SAVED_FRAGMENT.ordinal());
            this.f22274a.f22306c.a(component, this.f22274a.getContext());
            PlayDownloadPlugin.m24927d(this.f22274a);
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    class C19096 implements Runnable {
        final /* synthetic */ PlayDownloadPlugin f22280a;

        C19096(PlayDownloadPlugin playDownloadPlugin) {
            this.f22280a = playDownloadPlugin;
        }

        public void run() {
            PlayDownloadPlugin.m24919a(this.f22280a, new DownloadException("Aborting download after multiple attempts", ExceptionCode.DOWNLOAD_ABORTED));
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    /* synthetic */ class C19107 {
        static final /* synthetic */ int[] f22281a = new int[State.values().length];
        static final /* synthetic */ int[] f22282b = new int[DownloadStatus.values().length];
        static final /* synthetic */ int[] f22283c = new int[ExceptionCode.values().length];

        static {
            try {
                f22283c[ExceptionCode.INSUFFICIENT_SPACE_INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22283c[ExceptionCode.INSUFFICIENT_SPACE_DEVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22282b[DownloadStatus.DOWNLOAD_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22282b[DownloadStatus.DOWNLOAD_NOT_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22282b[DownloadStatus.DOWNLOAD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22282b[DownloadStatus.DOWNLOAD_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22282b[DownloadStatus.DOWNLOAD_NOT_REQUESTED.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22281a[State.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f22281a[State.HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    class PlayIconStateEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayIconStateEvent> {
        final /* synthetic */ PlayDownloadPlugin f22284a;

        public PlayIconStateEventSubscriber(PlayDownloadPlugin playDownloadPlugin) {
            this.f22284a = playDownloadPlugin;
        }

        public final void m24913b(FbEvent fbEvent) {
            RVPPlayIconStateEvent rVPPlayIconStateEvent = (RVPPlayIconStateEvent) fbEvent;
            this.f22284a.f22299K = rVPPlayIconStateEvent.a;
            if (this.f22284a.h != null) {
                PlayDownloadPlugin.m24917a(this.f22284a, this.f22284a.h.l);
            }
        }

        public final Class<RVPPlayIconStateEvent> m24912a() {
            return RVPPlayIconStateEvent.class;
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ PlayDownloadPlugin f22285a;

        public PlayerStateChangedEventSubscriber(PlayDownloadPlugin playDownloadPlugin) {
            this.f22285a = playDownloadPlugin;
        }

        public final void m24915b(FbEvent fbEvent) {
            PlayDownloadPlugin.m24917a(this.f22285a, ((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m24914a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: TextWithEntities is null for poll  */
    class VideoDownloadEventHandler implements DownloadStatusChangeEvent.Handler {
        final /* synthetic */ PlayDownloadPlugin f22286a;

        public VideoDownloadEventHandler(PlayDownloadPlugin playDownloadPlugin) {
            this.f22286a = playDownloadPlugin;
        }

        public final void m24916a(DownloadStatusChangeEvent downloadStatusChangeEvent) {
            PlayDownloadPlugin.m24918a(this.f22286a, downloadStatusChangeEvent.b, downloadStatusChangeEvent.a);
        }
    }

    public static void m24922a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlayDownloadPlugin) obj).m24920a(DownloadManager.a(fbInjector), IdBasedProvider.a(fbInjector, 12), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), VideoDownloadEventBus.a(fbInjector), InterstitialStartHelper.b(fbInjector), SaveButtonUtils.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), Saved2DbMutator.b(fbInjector));
    }

    private void m24920a(DownloadManager downloadManager, Provider<ComponentName> provider, SecureContextHelper secureContextHelper, DialtoneController dialtoneController, VideoDownloadEventBus videoDownloadEventBus, InterstitialStartHelper interstitialStartHelper, SaveButtonUtils saveButtonUtils, Executor executor, Saved2DbMutator saved2DbMutator) {
        this.f22304a = downloadManager;
        this.f22305b = provider;
        this.f22306c = secureContextHelper;
        this.f22307d = dialtoneController;
        this.f22308l = videoDownloadEventBus;
        this.f22309m = interstitialStartHelper;
        this.f22310n = saveButtonUtils;
        this.f22311o = executor;
        this.f22312p = saved2DbMutator;
    }

    private static boolean m24923a(FeedProps<GraphQLStory> feedProps) {
        return (((GraphQLStory) feedProps.a).as().m() == GraphQLSavedState.SAVED || ((GraphQLStory) feedProps.a).as().m() == GraphQLSavedState.ARCHIVED) ? false : true;
    }

    public PlayDownloadPlugin(Context context) {
        this(context, null);
    }

    private PlayDownloadPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PlayDownloadPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22313s = new VideoDownloadEventHandler(this);
        this.f22291C = new C19041(this);
        this.f22292D = new C19052(this);
        this.f22293E = new C19063(this);
        this.f22299K = State.DEFAULT;
        Class cls = PlayDownloadPlugin.class;
        m24922a((Object) this, getContext());
        setContentView(2130906330);
        this.f22314t = new Handler(Looper.getMainLooper());
        this.f22289A = a(2131566150);
        this.f22315u = (ImageView) a(2131561882);
        this.f22315u.setBackgroundResource(2130842699);
        this.f22316v = (GlyphView) a(2131566153);
        this.f22316v.setBackgroundResource(2130842699);
        this.f22318x = (BetterTextView) a(2131566152);
        this.f22317w = (BetterTextView) a(2131566151);
        this.f22319y = (BetterTextView) a(2131566154);
        this.f22320z = (BetterTextView) a(2131566155);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f.add(new PlayIconStateEventSubscriber(this));
        this.f22308l.a(DownloadStatusChangeEvent.class, this.f22313s);
        this.f22303O = -1;
    }

    protected final void m24930a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        VideoDataSource videoDataSource;
        if (z) {
            this.f22299K = State.DEFAULT;
        }
        this.f22300L = RichVideoPlayerParamsUtil.f(richVideoPlayerParams);
        this.f22301M = RichVideoPlayerParamsUtil.g(richVideoPlayerParams);
        if (this.f22300L != null) {
            Object obj;
            if (richVideoPlayerParams.a == null || richVideoPlayerParams.a.a.isEmpty() || RichVideoPlayerParamsUtil.a(richVideoPlayerParams).bn() == 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f22302N = true;
                this.f22303O = (long) RichVideoPlayerParamsUtil.a(richVideoPlayerParams).bn();
                this.f22320z.setText(Utils.b(this.f22303O));
                videoDataSource = (VideoDataSource) richVideoPlayerParams.a.a.get(0);
                this.f22296H = videoDataSource.b;
                this.f22297I = videoDataSource.f;
                this.f22294F = richVideoPlayerParams.a.b;
                this.f22298J = this.i.x.origin;
                this.f22295G = this.f22304a.d(this.f22294F);
                Preconditions.checkNotNull(this.h);
                m24917a(this, this.h.l);
            }
        }
        this.f22302N = false;
        g();
        videoDataSource = (VideoDataSource) richVideoPlayerParams.a.a.get(0);
        this.f22296H = videoDataSource.b;
        this.f22297I = videoDataSource.f;
        this.f22294F = richVideoPlayerParams.a.b;
        this.f22298J = this.i.x.origin;
        this.f22295G = this.f22304a.d(this.f22294F);
        Preconditions.checkNotNull(this.h);
        m24917a(this, this.h.l);
    }

    public static void m24917a(PlayDownloadPlugin playDownloadPlugin, PlaybackController.State state) {
        if (playDownloadPlugin.f22307d.j()) {
            m24927d(playDownloadPlugin);
            return;
        }
        switch (C19107.f22281a[playDownloadPlugin.f22299K.ordinal()]) {
            case 1:
                if (!state.isPlayingState()) {
                    playDownloadPlugin.m24928e();
                    return;
                }
                break;
            case 2:
                break;
            default:
                return;
        }
        m24927d(playDownloadPlugin);
    }

    public static void m24927d(PlayDownloadPlugin playDownloadPlugin) {
        playDownloadPlugin.f22289A.setVisibility(8);
    }

    private String m24926c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getText(i));
        stringBuilder.append(" ");
        stringBuilder.append(Utils.b(this.f22303O));
        return stringBuilder.toString();
    }

    public static String getProgressString(PlayDownloadPlugin playDownloadPlugin) {
        long j;
        StringBuilder stringBuilder = new StringBuilder();
        Preconditions.checkArgument(playDownloadPlugin.f22303O != 0);
        if (playDownloadPlugin.f22295G != null) {
            j = playDownloadPlugin.f22295G.b;
        } else {
            j = 0;
        }
        stringBuilder.append((j * 100) / playDownloadPlugin.f22303O);
        stringBuilder.append("%");
        return stringBuilder.toString();
    }

    private void setDownloadOptionVisibility(int i) {
        this.f22316v.setVisibility(i);
        this.f22319y.setVisibility(i);
        this.f22320z.setVisibility(i);
    }

    private void m24921a(DownloadStatus downloadStatus) {
        switch (C19107.f22282b[downloadStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f22316v.setImageResource(2130839815);
                this.f22316v.setOnClickListener(this.f22292D);
                this.f22319y.setText(m24926c(2131232824));
                this.f22320z.setText(getProgressString(this));
                return;
            case 4:
                setDownloadOptionVisibility(8);
                return;
            default:
                setDownloadOptionVisibility(0);
                this.f22316v.setImageResource(2130839834);
                this.f22316v.setOnClickListener(this.f22291C);
                this.f22319y.setText(2131232823);
                this.f22320z.setText(Utils.b(this.f22303O));
                return;
        }
    }

    private void m24925b(DownloadStatus downloadStatus) {
        switch (C19107.f22282b[downloadStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f22318x.setText(2131232820);
                return;
            case 4:
                this.f22317w.setText(2131232821);
                this.f22318x.setText(m24926c(2131232822));
                return;
            default:
                this.f22317w.setText(2131232818);
                this.f22318x.setText(2131232819);
                return;
        }
    }

    private void m24928e() {
        this.f22289A.setVisibility(0);
        if (this.f22302N) {
            DownloadStatus downloadStatus;
            if (this.f22295G == null) {
                downloadStatus = DownloadStatus.DOWNLOAD_NOT_REQUESTED;
            } else {
                downloadStatus = this.f22295G.c;
            }
            m24925b(downloadStatus);
            m24921a(downloadStatus);
            return;
        }
        setDownloadOptionVisibility(8);
    }

    private void m24924b(FeedProps<GraphQLStory> feedProps) {
        if (m24923a((FeedProps) feedProps)) {
            this.f22310n.a(feedProps, CurationMechanism.VIDEO_DOWNLOAD_BUTTON, CurationSurface.NATIVE_STORY);
        }
    }

    public static void m24919a(PlayDownloadPlugin playDownloadPlugin, Throwable th) {
        ExceptionCode exceptionCode;
        if (th instanceof DownloadException) {
            exceptionCode = ((DownloadException) th).mExceptionCode;
        } else {
            exceptionCode = null;
        }
        if (playDownloadPlugin.f22290B == null) {
            Builder b;
            Builder builder = new Builder(playDownloadPlugin.getContext());
            builder.a.q = true;
            builder = builder;
            if (exceptionCode != null) {
                switch (C19107.f22283c[exceptionCode.ordinal()]) {
                    case 1:
                        b = builder.a(2131232828).b(2131232829);
                        b.b("CANCEL", null);
                        DialogInterface.OnClickListener onClickListener = playDownloadPlugin.f22293E;
                        b.a.k = "VIEW VIDEOS";
                        b.a.l = onClickListener;
                        break;
                    case 2:
                        b = builder.a(2131232828).b(2131232830);
                        b.b("OK", null);
                        break;
                    default:
                        b = builder.a(2131232826).b(2131232827);
                        b.b("OK", null);
                        break;
                }
            }
            b = builder.a(2131232826).b(2131232827);
            b.b("OK", null);
            playDownloadPlugin.f22290B = b.a();
        } else if (playDownloadPlugin.f22290B.isShowing()) {
            return;
        }
        playDownloadPlugin.f22290B.show();
    }

    public static void m24929k(PlayDownloadPlugin playDownloadPlugin) {
        final String str = playDownloadPlugin.f22294F;
        Futures.a(playDownloadPlugin.f22304a.a(new VideoDownloadRequest(playDownloadPlugin.f22296H, playDownloadPlugin.f22294F, playDownloadPlugin.f22297I, playDownloadPlugin.f22298J, playDownloadPlugin.f22303O)), new FutureCallback(playDownloadPlugin) {
            final /* synthetic */ PlayDownloadPlugin f22276b;

            public void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                PlayDownloadPlugin.m24919a(this.f22276b, th);
                PlayDownloadPlugin.m24918a(this.f22276b, str, new VideoDownloadStatus(this.f22276b.f22303O, 0, DownloadStatus.DOWNLOAD_ABORTED));
            }
        }, playDownloadPlugin.f22311o);
        playDownloadPlugin.f22295G.c = DownloadStatus.DOWNLOAD_NOT_STARTED;
        Preconditions.checkNotNull(playDownloadPlugin.h);
        m24917a(playDownloadPlugin, playDownloadPlugin.h.l);
        playDownloadPlugin.f22309m.a(playDownloadPlugin.getContext(), f22287q, InterstitialController.class, null);
        playDownloadPlugin.m24924b(playDownloadPlugin.f22300L);
        if (m24923a(playDownloadPlugin.f22300L)) {
            String A;
            GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) playDownloadPlugin.f22301M.a);
            String aa = ((GraphQLActor) ((GraphQLStory) playDownloadPlugin.f22300L.a).b().get(0)).aa();
            if (o.A() != null) {
                A = o.A();
            } else {
                GraphQLTextWithEntities b = StoryHierarchyHelper.b((GraphQLStory) playDownloadPlugin.f22301M.a);
                A = b != null ? b.a() : StringFormatUtil.formatStrLocaleSafe("%s's video", aa);
            }
            playDownloadPlugin.f22312p.a(str, o.r().S() != null ? o.r().S().b() : "", A, aa, o.r().aO(), playDownloadPlugin.f22303O);
        }
    }

    public static void m24918a(PlayDownloadPlugin playDownloadPlugin, final String str, final VideoDownloadStatus videoDownloadStatus) {
        if (str.equals(playDownloadPlugin.f22294F)) {
            HandlerDetour.a(playDownloadPlugin.f22314t, new Runnable(playDownloadPlugin) {
                final /* synthetic */ PlayDownloadPlugin f22279c;

                public void run() {
                    if (this.f22279c.h != null && str.equals(this.f22279c.f22294F)) {
                        Object obj = null;
                        if (videoDownloadStatus.c == DownloadStatus.DOWNLOAD_IN_PROGRESS && videoDownloadStatus.c == this.f22279c.f22295G.c) {
                            obj = 1;
                        }
                        this.f22279c.f22295G = videoDownloadStatus;
                        if (obj != null) {
                            this.f22279c.f22320z.setText(PlayDownloadPlugin.getProgressString(this.f22279c));
                        } else {
                            PlayDownloadPlugin.m24917a(this.f22279c, this.f22279c.h.l);
                        }
                    }
                }
            }, 1938210679);
        }
        if (videoDownloadStatus.c == DownloadStatus.DOWNLOAD_ABORTED) {
            HandlerDetour.a(playDownloadPlugin.f22314t, new C19096(playDownloadPlugin), 1780678307);
        }
    }
}
