package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.IsInlineVideoPlayerSupported;
import com.facebook.messaging.attachments.IsPopOutVideoPlayerSupported;
import com.facebook.messaging.attachments.IsShowVideoAttachmentSizeEnabled;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.formatting.VideoStringsFormatter;
import com.facebook.video.player.InlineVideoPlayer;
import com.facebook.video.settings.AutoPlaySettingValue_DefaultAutoPlaySettingsFromServerMethodAutoProvider;
import com.facebook.video.settings.DefaultAutoPlaySettingsFromServer;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.facebook.widget.ChildSharingFrameLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_status_change */
public class ThreadViewVideoAttachmentView extends ChildSharingFrameLayout {
    public static final CallerContext f8074w = CallerContext.a(InlineVideoPlayer.class, "video_cover");
    private SelfRegistrableReceiverImpl f8075A;
    public Message f8076B;
    public VideoAttachmentData f8077C;
    public Listener f8078D;
    public FbDraweeView f8079E;
    private ThreadViewVideoStateButton f8080F;
    public FbTextView f8081G;
    public ChildSharingFrameLayout f8082H;
    public ColorDrawable f8083I;
    public ImageView f8084J;
    public ProgressBar f8085K;
    public TextView f8086L;
    public FragmentManager f8087M;
    public Spring f8088N;
    public float f8089O = -1.0f;
    public float f8090P = -1.0f;
    public int f8091Q;
    public int f8092R;
    public int f8093S;
    public boolean f8094T;
    public boolean f8095U;
    public boolean f8096V;
    private boolean f8097W;
    @Inject
    AnalyticsTagger f8098a;
    public Optional<InlineVideoPlayer> aa = Absent.INSTANCE;
    private final VideoPlayerListener ab = new VideoPlayerListener(this);
    private final OnClickListener ac = new C12121(this);
    private final OnClickListener ad = new C12132(this);
    private final OnLongClickListener ae = new C12143(this);
    private final OnClickListener af = new C12154(this);
    @Inject
    AttachmentDataFactory f8099b;
    @Inject
    @DefaultAutoPlaySettingsFromServer
    AutoPlaySettingValue f8100c;
    @Inject
    FbDraweeControllerBuilder f8101d;
    @Inject
    FbSharedPreferences f8102e;
    @Inject
    @ForUiThread
    Handler f8103f;
    @Inject
    InputMethodManager f8104g;
    @Inject
    @IsInlineVideoPlayerSupported
    Provider<Boolean> f8105h;
    @Inject
    @IsPopOutVideoPlayerSupported
    Provider<Boolean> f8106i;
    @Inject
    @IsShowVideoAttachmentSizeEnabled
    Provider<Boolean> f8107j;
    @Inject
    LayoutInflater f8108k;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f8109l;
    @Inject
    MediaSizeUtil f8110m;
    @Inject
    MediaUploadManagerImpl f8111n;
    @Inject
    SoftInputDetector f8112o;
    @Inject
    SpringSystem f8113p;
    @Inject
    ThreadViewVideoAttachmentViewAnalyticsLogger f8114q;
    @Inject
    VideoStringsFormatter f8115r;
    @Inject
    ZeroDialogController f8116s;
    @Inject
    ZeroDialogController f8117t;
    @Inject
    ThreadViewLowDataModeUtils f8118u;
    @Inject
    EphemeralGatingUtil f8119v;
    public Runnable f8120x;
    public boolean f8121y;
    private boolean f8122z;

    /* compiled from: messenger_status_change */
    public interface Listener {
        void mo255a();

        void mo256a(VideoAttachmentData videoAttachmentData);

        void mo257a(String str);

        void mo258a(String str, EventTriggerType eventTriggerType);

        void mo259b();

        void mo260b(VideoAttachmentData videoAttachmentData);

        void mo261b(String str);
    }

    /* compiled from: messenger_status_change */
    /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] f8061b = new int[UploadState.values().length];

        static {
            try {
                f8061b[UploadState.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8061b[UploadState.NOT_ALL_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8061b[UploadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8061b[UploadState.NO_MEDIA_ITEMS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8061b[UploadState.SUCCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            f8060a = new int[VideoState.values().length];
            try {
                f8060a[VideoState.NEEDS_USER_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8060a[VideoState.UPLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8060a[VideoState.SENDING.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8060a[VideoState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8060a[VideoState.PLAYABLE.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8060a[VideoState.NO_DATA.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* compiled from: messenger_status_change */
    class C12121 implements OnClickListener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8062a;

        C12121(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8062a = threadViewVideoAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2113985700);
            this.f8062a.m8022q();
            if (this.f8062a.aa.isPresent() && ((Boolean) this.f8062a.f8105h.get()).booleanValue()) {
                InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) this.f8062a.aa.get();
                if (inlineVideoPlayer.b()) {
                    inlineVideoPlayer.a(EventTriggerType.BY_USER, VideoMediaState.PAUSED);
                } else {
                    this.f8062a.f8116s.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f8062a.f8087M);
                }
            } else if (this.f8062a.f8078D != null) {
                this.f8062a.f8117t.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f8062a.f8087M);
            }
            this.f8062a.f8114q.m8047a("play_tapped", this.f8062a.f8076B, this.f8062a.f8077C);
            LogUtils.a(-1329724513, a);
        }
    }

    /* compiled from: messenger_status_change */
    class C12132 implements OnClickListener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8063a;

        C12132(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8063a = threadViewVideoAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1429297271);
            if (this.f8063a.aa.isPresent()) {
                InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) this.f8063a.aa.get();
                if (this.f8063a.f8088N.i == 0.0d) {
                    if (!inlineVideoPlayer.b()) {
                        this.f8063a.f8116s.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f8063a.f8087M);
                    }
                    this.f8063a.f8095U = true;
                    if (this.f8063a.f8094T || inlineVideoPlayer.b()) {
                        this.f8063a.f8094T = false;
                        this.f8063a.f8095U = false;
                        this.f8063a.m8026s();
                    }
                } else {
                    this.f8063a.f8089O;
                }
                this.f8063a.f8114q.m8047a("video_tapped", this.f8063a.f8076B, this.f8063a.f8077C);
            }
            LogUtils.a(1181391047, a);
        }
    }

    /* compiled from: messenger_status_change */
    class C12143 implements OnLongClickListener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8064a;

        C12143(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8064a = threadViewVideoAttachmentView;
        }

        public boolean onLongClick(View view) {
            if (this.f8064a.f8078D == null || this.f8064a.f8077C == null) {
                return false;
            }
            this.f8064a.f8078D.mo260b(this.f8064a.f8077C);
            return true;
        }
    }

    /* compiled from: messenger_status_change */
    class C12154 implements OnClickListener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8065a;

        C12154(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8065a = threadViewVideoAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1951180979);
            this.f8065a.f8079E;
            Logger.a(2, EntryType.UI_INPUT_END, -84000204, a);
        }
    }

    /* compiled from: messenger_status_change */
    class C12165 implements ActionReceiver {
        final /* synthetic */ ThreadViewVideoAttachmentView f8066a;

        C12165(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8066a = threadViewVideoAttachmentView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 566236818);
            MediaResource mediaResource = (MediaResource) intent.getParcelableExtra("resource");
            if (!(mediaResource == null || this.f8066a.f8077C == null || this.f8066a.f8077C.j == null || !MessageUtil.a(this.f8066a.f8076B))) {
                if (MediaUploadKey.b(mediaResource).equals(MediaUploadKey.b(this.f8066a.f8077C.j))) {
                    ThreadViewVideoAttachmentView.m8016n(this.f8066a);
                    if (this.f8066a.f8081G) {
                        this.f8066a.m8010k();
                    }
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -921998690, a);
        }
    }

    /* compiled from: messenger_status_change */
    class C12176 implements ActionReceiver {
        final /* synthetic */ ThreadViewVideoAttachmentView f8067a;

        C12176(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8067a = threadViewVideoAttachmentView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1908584105);
            this.f8067a.m8010k();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1154039167, a);
        }
    }

    /* compiled from: messenger_status_change */
    class C12187 implements Runnable {
        final /* synthetic */ ThreadViewVideoAttachmentView f8068a;

        C12187(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8068a = threadViewVideoAttachmentView;
        }

        public void run() {
            if (this.f8068a.f8121y) {
                this.f8068a.f8083I;
                this.f8068a.f8084J;
                HandlerDetour.b(this.f8068a.f8103f, this.f8068a.f8120x, 42, -700897324);
            }
        }
    }

    /* compiled from: messenger_status_change */
    class C12198 implements com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8069a;

        C12198(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8069a = threadViewVideoAttachmentView;
        }

        public final void m7957a(Object obj) {
            ((InlineVideoPlayer) this.f8069a.aa.get()).a(EventTriggerType.BY_USER);
        }

        public final void m7956a() {
        }
    }

    /* compiled from: messenger_status_change */
    class C12209 implements com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8070a;

        C12209(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8070a = threadViewVideoAttachmentView;
        }

        public final void m7959a(Object obj) {
            this.f8070a.f8078D.mo256a(this.f8070a.f8077C);
        }

        public final void m7958a() {
        }
    }

    /* compiled from: messenger_status_change */
    class PopOutInlineVideoSpringListener extends SimpleSpringListener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8071a;

        public PopOutInlineVideoSpringListener(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8071a = threadViewVideoAttachmentView;
        }

        public final void m7960a(Spring spring) {
            if (this.f8071a.aa.isPresent()) {
                InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) this.f8071a.aa.get();
                if (this.f8071a.f8089O == -1.0f || this.f8071a.f8090P == -1.0f) {
                    int[] iArr = new int[2];
                    inlineVideoPlayer.getLocationInWindow(iArr);
                    this.f8071a.f8089O = (float) iArr[0];
                    this.f8071a.f8090P = (float) iArr[1];
                }
                float d = (float) spring.d();
                if (d != 0.0f) {
                    this.f8071a.m7987a(inlineVideoPlayer);
                    if (this.f8071a.f8092R != 0 && this.f8071a.f8091Q != 0) {
                        int a;
                        int i;
                        float a2;
                        float width = ((float) (this.f8071a.f8082H.getWidth() - ((this.f8071a.f8091Q * this.f8071a.f8082H.getHeight()) / this.f8071a.f8092R))) / 2.0f;
                        float height = (((float) (this.f8071a.f8082H.getHeight() - ((this.f8071a.f8092R * this.f8071a.f8082H.getWidth()) / this.f8071a.f8091Q))) / 2.0f) + ((float) this.f8071a.f8093S);
                        int i2 = this.f8071a.f8091Q;
                        int i3 = this.f8071a.f8092R;
                        double d2 = ((double) i3) / ((double) i2);
                        if (this.f8071a.f8082H.getWidth() == 0 || d2 <= ((double) this.f8071a.f8082H.getHeight()) / ((double) this.f8071a.f8082H.getWidth())) {
                            a = MathUtil.a(i2, this.f8071a.f8082H.getWidth(), d);
                            i = (i3 * a) / i2;
                            a2 = MathUtil.a(this.f8071a.f8089O, 0.0f, d);
                            width = MathUtil.a(this.f8071a.f8090P, height, d);
                        } else {
                            i = MathUtil.a(i3, this.f8071a.f8082H.getHeight(), d);
                            a = (i2 * i) / i3;
                            a2 = MathUtil.a(this.f8071a.f8089O, width, d);
                            width = MathUtil.a(this.f8071a.f8090P, (float) this.f8071a.f8093S, d);
                        }
                        inlineVideoPlayer.a(a, i);
                        LayoutParamsUtil.a(inlineVideoPlayer, a, i);
                        inlineVideoPlayer.setX(a2);
                        inlineVideoPlayer.setY(width - ((float) this.f8071a.f8093S));
                        if (this.f8071a.f8083I != null) {
                            float b = MathUtil.b(d, 0.0f, 1.0f);
                            this.f8071a.f8084J.setAlpha(b);
                            this.f8071a.f8085K.setAlpha(b);
                            this.f8071a.f8086L.setAlpha(b);
                            this.f8071a.f8083I.mutate().setAlpha((int) (b * 255.0f));
                        }
                    }
                }
            }
        }

        public final void m7961b(Spring spring) {
            if (spring.d() == 0.0d) {
                this.f8071a.f8090P;
            } else if (spring.d() == 1.0d) {
                this.f8071a.m8028t();
            }
        }
    }

    /* compiled from: messenger_status_change */
    public class VideoPlayerListener extends AbstractVideoPlayerListener {
        final /* synthetic */ ThreadViewVideoAttachmentView f8072a;
        public String f8073b;

        public VideoPlayerListener(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
            this.f8072a = threadViewVideoAttachmentView;
        }

        public final void m7964a(int i) {
            if (this.f8072a.f8077C != null) {
                this.f8072a.f8079E.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f8072a.f8101d.a(ThreadViewVideoAttachmentView.f8074w).a(ThreadViewVideoAttachmentView.m7996b(this.f8072a.f8077C))).b(this.f8072a.f8079E.getController())).s());
                ((GenericDraweeHierarchy) this.f8072a.f8079E.getHierarchy()).b(2131361871);
            }
            if (this.f8072a.aa.isPresent()) {
                this.f8072a.f8089O;
                if (this.f8072a.f8078D != null) {
                    this.f8072a.f8078D.mo258a(this.f8073b, EventTriggerType.BY_ANDROID);
                }
            }
        }

        public final void m7965a(Bitmap bitmap) {
            if (bitmap != null) {
                this.f8072a.f8079E.setController(null);
                ((GenericDraweeHierarchy) this.f8072a.f8079E.getHierarchy()).b(new BitmapDrawable(this.f8072a.getResources(), bitmap));
            }
        }

        public final void m7967a(String str, VideoError videoError) {
            this.f8072a.f8079E.setController(null);
            ((GenericDraweeHierarchy) this.f8072a.f8079E.getHierarchy()).b(2131361848);
            this.f8072a.f8081G.setText(2131230758);
        }

        public final void m7969c(EventTriggerType eventTriggerType) {
            if (this.f8072a.aa.isPresent()) {
                this.f8072a.f8094T = true;
                if (this.f8072a.f8095U) {
                    this.f8072a.f8094T = false;
                    this.f8072a.f8095U = false;
                    this.f8072a.m8026s();
                }
            }
        }

        public final void m7966a(EventTriggerType eventTriggerType, boolean z) {
            super.a(eventTriggerType, z);
            if (this.f8072a.aa.isPresent() && this.f8072a.f8078D != null) {
                this.f8072a.f8078D.mo257a(this.f8073b);
            }
        }

        public final void m7968b(EventTriggerType eventTriggerType, boolean z) {
            super.b(eventTriggerType, z);
            if (this.f8072a.aa.isPresent() && this.f8072a.f8078D != null) {
                this.f8072a.f8078D.mo258a(this.f8073b, eventTriggerType);
            }
        }

        public static void m7963b(VideoPlayerListener videoPlayerListener, String str) {
            videoPlayerListener.f8073b = str;
        }
    }

    /* compiled from: messenger_status_change */
    enum VideoState {
        UPLOADING,
        SENDING,
        FAILED,
        PLAYABLE,
        NEEDS_USER_REQUEST,
        NO_DATA
    }

    private static <T extends View> void m7988a(Class<T> cls, T t) {
        m7989a((Object) t, t.getContext());
    }

    private static void m7989a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThreadViewVideoAttachmentView) obj).m7984a(AnalyticsTagger.a(fbInjector), AttachmentDataFactory.a(fbInjector), AutoPlaySettingValue_DefaultAutoPlaySettingsFromServerMethodAutoProvider.a(fbInjector), FbDraweeControllerBuilder.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), Handler_ForUiThreadMethodAutoProvider.a(fbInjector), InputMethodManagerMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4102), IdBasedProvider.a(fbInjector, 4104), IdBasedProvider.a(fbInjector, 4105), LayoutInflaterMethodAutoProvider.a(fbInjector), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), MediaSizeUtil.a(fbInjector), MediaUploadManagerImpl.a(fbInjector), SoftInputDetector.a(fbInjector), SpringSystem.a(fbInjector), ThreadViewVideoAttachmentViewAnalyticsLogger.m8045a(fbInjector), VideoStringsFormatter.a(fbInjector), (ZeroDialogController) FbZeroDialogController.a(fbInjector), (ZeroDialogController) FbZeroDialogController.a(fbInjector), ThreadViewLowDataModeUtils.m7358a(fbInjector), EphemeralGatingUtil.a(fbInjector));
    }

    private void m7984a(AnalyticsTagger analyticsTagger, AttachmentDataFactory attachmentDataFactory, AutoPlaySettingValue autoPlaySettingValue, FbDraweeControllerBuilder fbDraweeControllerBuilder, FbSharedPreferences fbSharedPreferences, Handler handler, InputMethodManager inputMethodManager, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, LayoutInflater layoutInflater, FbBroadcastManager fbBroadcastManager, MediaSizeUtil mediaSizeUtil, MediaUploadManager mediaUploadManager, SoftInputDetector softInputDetector, SpringSystem springSystem, ThreadViewVideoAttachmentViewAnalyticsLogger threadViewVideoAttachmentViewAnalyticsLogger, VideoStringsFormatter videoStringsFormatter, ZeroDialogController zeroDialogController, ZeroDialogController zeroDialogController2, ThreadViewLowDataModeUtils threadViewLowDataModeUtils, EphemeralGatingUtil ephemeralGatingUtil) {
        this.f8098a = analyticsTagger;
        this.f8099b = attachmentDataFactory;
        this.f8100c = autoPlaySettingValue;
        this.f8101d = fbDraweeControllerBuilder;
        this.f8102e = fbSharedPreferences;
        this.f8103f = handler;
        this.f8104g = inputMethodManager;
        this.f8105h = provider;
        this.f8106i = provider2;
        this.f8107j = provider3;
        this.f8108k = layoutInflater;
        this.f8109l = fbBroadcastManager;
        this.f8110m = mediaSizeUtil;
        this.f8111n = mediaUploadManager;
        this.f8112o = softInputDetector;
        this.f8113p = springSystem;
        this.f8114q = threadViewVideoAttachmentViewAnalyticsLogger;
        this.f8115r = videoStringsFormatter;
        this.f8116s = zeroDialogController;
        this.f8117t = zeroDialogController2;
        this.f8118u = threadViewLowDataModeUtils;
        this.f8119v = ephemeralGatingUtil;
    }

    public ThreadViewVideoAttachmentView(Context context) {
        super(context);
        m8003g();
    }

    public ThreadViewVideoAttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8003g();
    }

    public ThreadViewVideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8003g();
    }

    private void m8003g() {
        m7988a(ThreadViewVideoAttachmentView.class, (View) this);
        C12165 c12165 = new C12165(this);
        this.f8075A = this.f8109l.a().a("com.facebook.orca.media.upload.PROCESS_MEDIA_TOTAL_PROGRESS", c12165).a("com.facebook.orca.media.upload.MEDIA_UPLOAD_STATUS_CHANGED", new C12176(this)).a();
        if (((Boolean) this.f8105h.get()).booleanValue()) {
            setContentView(2130905731);
            InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) c(2131564915);
            inlineVideoPlayer.P = this.ae;
            inlineVideoPlayer.setVideoListener(this.ab);
            inlineVideoPlayer.y = false;
            inlineVideoPlayer.z = true;
            inlineVideoPlayer.setPauseMediaPlayerOnVideoPause(true);
            inlineVideoPlayer.g();
            this.aa = Optional.of(inlineVideoPlayer);
            this.f8079E = inlineVideoPlayer.getCoverImage();
            this.f8080F = (ThreadViewVideoStateButton) inlineVideoPlayer.findViewById(2131561882);
            this.f8081G = inlineVideoPlayer.p;
            if (((Boolean) this.f8106i.get()).booleanValue()) {
                this.f8080F.setOnClickListener(this.af);
                inlineVideoPlayer.setOnClickPlayerListener(this.ad);
            } else {
                inlineVideoPlayer.setOnClickPlayerListener(this.ac);
            }
            this.f8088N = this.f8113p.a().a(SpringConfig.a(230.2d, 25.0d)).a(new PopOutInlineVideoSpringListener(this));
            this.f8120x = new C12187(this);
        } else {
            setContentView(2130905732);
            this.aa = Absent.INSTANCE;
            this.f8079E = (FbDraweeView) c(2131564916);
            this.f8080F = (ThreadViewVideoStateButton) c(2131564917);
            this.f8081G = (FbTextView) c(2131564918);
        }
        this.f8080F.setOnClickListener(this.af);
        if (((Boolean) this.f8106i.get()).booleanValue()) {
            this.f8079E.setOnClickListener(this.ad);
        } else {
            this.f8079E.setOnClickListener(this.ac);
        }
        this.f8079E.setOnLongClickListener(this.ae);
        this.f8116s.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, getContext().getString(2131232932), new C12198(this));
        this.f8117t.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, getContext().getString(2131232932), new C12209(this));
        this.f8098a.a(this, "video_cover", getClass());
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f8087M = fragmentManager;
    }

    public void setMessage(@Nullable Message message) {
        if (this.f8076B != message || this.f8096V != this.f8097W) {
            this.f8097W = this.f8096V;
            this.f8076B = message;
            setVideoAttachmentData(this.f8099b.j(message));
            if (this.f8076B != null) {
                this.ab.f8073b = this.f8076B.n;
                if (this.f8096V) {
                    this.f8080F.m8054f();
                    this.f8079E.setOnClickListener(null);
                    return;
                }
                this.f8080F.setOnClickListener(this.af);
                if (((Boolean) this.f8106i.get()).booleanValue()) {
                    this.f8079E.setOnClickListener(this.ad);
                } else {
                    this.f8079E.setOnClickListener(this.ac);
                }
            }
        }
    }

    private void m8004h() {
        if (this.aa.isPresent()) {
            m8006i();
        }
        m8008j();
        m8010k();
    }

    private void setVideoAttachmentData(@Nullable VideoAttachmentData videoAttachmentData) {
        this.f8077C = videoAttachmentData;
        m8004h();
    }

    public void setSendingAnimationProgress(float f) {
        this.f8079E.setAlpha((0.5f * f) + 0.5f);
    }

    public void setListener(Listener listener) {
        this.f8078D = listener;
    }

    public void setNeedsUserRequestToLoad(boolean z) {
        boolean z2 = z && this.f8118u.m7360a();
        this.f8096V = z2;
    }

    public final boolean m8042a() {
        return this.f8096V;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f8077C != null) {
            m7982a(MeasureSpec.getSize(i), this.f8077C.a, this.f8077C.b);
        }
        super.onMeasure(i, i2);
        if (((Boolean) this.f8106i.get()).booleanValue() && this.aa.isPresent() && this.f8088N.d() != 0.0d) {
            setMeasuredDimension(this.f8091Q, this.f8092R);
        }
        if (this.f8122z && !this.f8112o.f) {
            this.f8122z = false;
            m8026s();
        }
    }

    private void m7982a(int i, int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            int c;
            if (i2 > i3) {
                c = this.f8110m.c();
            } else {
                c = this.f8110m.d();
            }
            int i4 = (int) (((double) c) * (((double) i2) / ((double) i3)));
            int min = Math.min(i, this.f8110m.e());
            int suggestedMinimumWidth = getSuggestedMinimumWidth();
            if (i4 > min) {
                suggestedMinimumWidth = (int) ((((double) min) / ((double) i4)) * ((double) c));
            } else if (i4 < suggestedMinimumWidth) {
                min = suggestedMinimumWidth;
                suggestedMinimumWidth = (int) (((double) c) * (((double) suggestedMinimumWidth) / ((double) i4)));
            } else {
                min = i4;
                suggestedMinimumWidth = c;
            }
            if (this.aa.isPresent()) {
                LayoutParamsUtil.a((View) this.aa.get(), min, suggestedMinimumWidth);
            }
            LayoutParamsUtil.a(this.f8079E, min, suggestedMinimumWidth);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 458745614);
        super.onAttachedToWindow();
        this.f8075A.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -268394411, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 871165385);
        super.onDetachedFromWindow();
        m8039y();
        this.f8075A.c();
        HandlerDetour.a(this.f8103f, this.f8120x);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1442606293, a);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4 && this.aa.isPresent() && this.f8088N.i == 1.0d) {
            this.f8089O;
            return true;
        } else if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 82) {
            return true;
        } else {
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    public final void m8043b() {
        m8004h();
    }

    public void setOnLoadClickListener(OnClickListener onClickListener) {
        this.f8080F.setOnClickListener(onClickListener);
    }

    public final void m8044e() {
        this.f8089O;
    }

    private void m8006i() {
        InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) this.aa.get();
        inlineVideoPlayer.b(EventTriggerType.BY_PLAYER);
        if (this.f8077C != null) {
            VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(ImmutableList.copyOf(this.f8077C.f));
            a.b = this.f8077C.i;
            a = a;
            a.c = this.f8077C.d;
            a = a;
            a.o = this.f8077C.k;
            a = a;
            a.p = this.f8077C.l;
            inlineVideoPlayer.setVideoData(a.m());
        }
    }

    private void m8008j() {
        if (this.f8077C != null) {
            if (this.f8096V) {
                this.f8079E.setController(null);
                ((GenericDraweeHierarchy) this.f8079E.getHierarchy()).b(2131362420);
            } else {
                this.f8079E.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f8101d.a(f8074w).a(m7996b(this.f8077C))).b(this.f8079E.getController())).s());
                ((GenericDraweeHierarchy) this.f8079E.getHierarchy()).b(2131361871);
            }
            m8018o();
        }
    }

    private void m8010k() {
        VideoState currentVideoState = getCurrentVideoState();
        switch (currentVideoState) {
            case NEEDS_USER_REQUEST:
                this.f8080F.m8054f();
                this.f8079E.setOnClickListener(null);
                break;
            case UPLOADING:
                this.f8080F.m8055g();
                m8016n(this);
                break;
            case SENDING:
                this.f8080F.m8051a();
                m8016n(this);
                break;
            case FAILED:
                this.f8080F.m8052b();
                break;
            case PLAYABLE:
                this.f8080F.m8053e();
                break;
            default:
                this.f8080F.m8055g();
                break;
        }
        if (currentVideoState == VideoState.NO_DATA) {
            m8020p();
            return;
        }
        m8018o();
        m8022q();
    }

    public static void m8013l(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        switch (threadViewVideoAttachmentView.getCurrentVideoState()) {
            case SENDING:
                threadViewVideoAttachmentView.ac.onClick(threadViewVideoAttachmentView.f8080F);
                return;
            case FAILED:
                if (threadViewVideoAttachmentView.f8078D != null) {
                    threadViewVideoAttachmentView.f8078D.mo259b();
                }
                threadViewVideoAttachmentView.f8114q.m8047a("retry_tapped", threadViewVideoAttachmentView.f8076B, threadViewVideoAttachmentView.f8077C);
                return;
            case PLAYABLE:
                threadViewVideoAttachmentView.ac.onClick(threadViewVideoAttachmentView.f8080F);
                return;
            default:
                return;
        }
    }

    private VideoState getCurrentVideoState() {
        if (this.f8096V) {
            return VideoState.NEEDS_USER_REQUEST;
        }
        VideoState videoState = VideoState.PLAYABLE;
        if (this.f8077C == null) {
            return VideoState.NO_DATA;
        }
        UploadState uploadState = this.f8111n.b(this.f8076B).b;
        if (MessageUtil.a(this.f8076B)) {
            switch (AnonymousClass12.f8061b[uploadState.ordinal()]) {
                case 1:
                case 2:
                    if (this.f8081G) {
                        return VideoState.SENDING;
                    }
                    return VideoState.UPLOADING;
                case 3:
                    return VideoState.FAILED;
                default:
                    return VideoState.SENDING;
            }
        } else if (MessageUtil.b(this.f8076B)) {
            return VideoState.FAILED;
        } else {
            return videoState;
        }
    }

    public static boolean m8015m(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        return threadViewVideoAttachmentView.f8111n.d(threadViewVideoAttachmentView.f8077C.j) == 1.0d;
    }

    public static void m8016n(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        if (!threadViewVideoAttachmentView.f8076B.t.isEmpty()) {
            threadViewVideoAttachmentView.f8080F.setUploadProgress(threadViewVideoAttachmentView.f8111n.d((MediaResource) threadViewVideoAttachmentView.f8076B.t.get(0)));
        }
    }

    @Nullable
    public static ImageRequest[] m7996b(VideoAttachmentData videoAttachmentData) {
        Builder builder = ImmutableList.builder();
        MediaResource mediaResource = videoAttachmentData.j;
        if (!(mediaResource == null || mediaResource.f == null)) {
            builder.c(mediaResource.f);
        }
        if (videoAttachmentData.g != null) {
            builder.c(videoAttachmentData.g);
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            return null;
        }
        ImageRequest[] imageRequestArr = new ImageRequest[b.size()];
        for (int i = 0; i < b.size(); i++) {
            imageRequestArr[i] = ImageRequest.a((Uri) b.get(i));
        }
        return imageRequestArr;
    }

    private void m8018o() {
        if (this.aa.isPresent()) {
            ((InlineVideoPlayer) this.aa.get()).setVisibility(0);
            return;
        }
        this.f8079E.setVisibility(0);
        this.f8080F.setVisibility(0);
        this.f8081G.setVisibility(0);
    }

    private void m8020p() {
        if (this.aa.isPresent()) {
            ((InlineVideoPlayer) this.aa.get()).setVisibility(8);
            return;
        }
        this.f8079E.setVisibility(8);
        this.f8080F.setVisibility(8);
        this.f8081G.setVisibility(8);
    }

    private void m8022q() {
        if (this.f8077C != null) {
            this.f8081G.setText(m7981a(this.f8077C.d, this.f8077C.e));
        } else {
            this.f8081G.setText(null);
        }
    }

    private String m7981a(int i, int i2) {
        String a;
        String a2 = this.f8115r.a((long) i);
        if (((Boolean) this.f8107j.get()).booleanValue()) {
            a = this.f8115r.a(i2);
        } else {
            a = null;
        }
        if (a == null || getCurrentVideoState() != VideoState.PLAYABLE) {
            return a2;
        }
        return getResources().getString(2131231719, new Object[]{a2, a});
    }

    private void m8024r() {
        this.f8091Q = getWidth();
        this.f8092R = getHeight();
        Rect rect = new Rect();
        getRootView().findViewById(16908290).getWindowVisibleDisplayFrame(rect);
        this.f8093S = rect.top;
        if (this.aa.isPresent()) {
            ((InlineVideoPlayer) this.aa.get()).P = null;
        }
        if (this.f8084J != null) {
            this.f8084J.setImageResource(2130842100);
            this.f8084J.setVisibility(0);
        }
        if (this.f8085K != null) {
            m7971A();
            this.f8083I;
            this.f8085K.setVisibility(0);
        }
        if (this.f8086L != null) {
            this.f8084J;
            this.f8086L.setVisibility(0);
        }
        if (this.f8082H != null) {
            this.f8082H.setOnClickListener(this.ad);
        }
        setFocusableInTouchMode(true);
        requestFocus();
    }

    private void m8026s() {
        if (this.f8112o.f) {
            m8037x();
        } else if (this.f8088N.i != 1.0d) {
            if (this.f8078D != null) {
                this.f8078D.mo261b(this.f8076B.n);
            }
            m8024r();
            this.f8088N.b(1.0d);
        }
    }

    private void m8028t() {
        this.f8121y = true;
        HandlerDetour.a(this.f8103f, this.f8120x, 2103438479);
    }

    private void m8031u() {
        this.f8121y = false;
        if (this.f8082H != null) {
            this.f8082H.setClickable(false);
        }
        if (this.f8084J != null) {
            this.f8084J.setVisibility(8);
        }
        if (this.f8085K != null) {
            this.f8085K.setVisibility(8);
        }
        if (this.f8086L != null) {
            this.f8086L.setVisibility(8);
        }
    }

    public static void m8033v(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        if (threadViewVideoAttachmentView.f8088N.i != 0.0d) {
            threadViewVideoAttachmentView.m8031u();
            threadViewVideoAttachmentView.f8088N.b(0.0d);
        }
    }

    public static void m8035w(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        if (threadViewVideoAttachmentView.aa.isPresent()) {
            InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) threadViewVideoAttachmentView.aa.get();
            if (threadViewVideoAttachmentView.f8082H != null) {
                float height = ((float) (threadViewVideoAttachmentView.f8082H.getHeight() - threadViewVideoAttachmentView.f8092R)) / 2.0f;
                inlineVideoPlayer.setX(((float) (threadViewVideoAttachmentView.f8082H.getWidth() - threadViewVideoAttachmentView.f8091Q)) / 2.0f);
                inlineVideoPlayer.setY(height);
                threadViewVideoAttachmentView.m8041z();
            }
            inlineVideoPlayer.P = threadViewVideoAttachmentView.ae;
            threadViewVideoAttachmentView.f8089O = -1.0f;
            threadViewVideoAttachmentView.f8090P = -1.0f;
            if (inlineVideoPlayer.k()) {
                inlineVideoPlayer.b(EventTriggerType.BY_USER);
                threadViewVideoAttachmentView.m8008j();
            }
            threadViewVideoAttachmentView.clearFocus();
            if (threadViewVideoAttachmentView.f8078D != null) {
                threadViewVideoAttachmentView.f8078D.mo255a();
            }
        }
    }

    private void m8037x() {
        this.f8122z = true;
        this.f8104g.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private void m7987a(final InlineVideoPlayer inlineVideoPlayer) {
        if (this.f8082H == null) {
            this.f8082H = new ChildSharingFrameLayout(getContext());
            this.f8083I = new ColorDrawable(getResources().getColor(2131362417));
            CustomViewUtils.b(this.f8082H, this.f8083I);
            this.f8108k.inflate(2130905736, this.f8082H, true);
            this.f8084J = (ImageView) this.f8082H.findViewById(2131564921);
            this.f8084J.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ThreadViewVideoAttachmentView f8057b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1799379868);
                    if (inlineVideoPlayer.j()) {
                        inlineVideoPlayer.a(EventTriggerType.BY_USER, VideoMediaState.PLAYING);
                        this.f8057b.f8084J.setImageResource(2130842101);
                        this.f8057b.f8084J.setContentDescription(this.f8057b.getResources().getString(2131231723));
                    } else {
                        inlineVideoPlayer.a(EventTriggerType.BY_USER);
                        this.f8057b.f8084J.setImageResource(2130842100);
                        this.f8057b.f8084J.setContentDescription(this.f8057b.getResources().getString(2131231725));
                    }
                    LogUtils.a(234264719, a);
                }
            });
            this.f8085K = (ProgressBar) this.f8082H.findViewById(2131564923);
            m7971A();
            this.f8083I;
            this.f8086L = (TextView) this.f8082H.findViewById(2131564922);
            this.f8084J;
            this.f8082H.setOnClickListener(this.ad);
            if (getRootView().findViewById(16908290) == null) {
                this.f8088N.a(0.0d).l();
                return;
            }
            ((ViewGroup) getRootView().findViewById(16908290)).addView(this.f8082H);
        }
        m7983a((View) inlineVideoPlayer);
    }

    private void m8039y() {
        if (this.f8082H != null) {
            final ChildSharingFrameLayout childSharingFrameLayout = this.f8082H;
            post(new Runnable(this) {
                final /* synthetic */ ThreadViewVideoAttachmentView f8059b;

                public void run() {
                    ViewParent parent = childSharingFrameLayout.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(childSharingFrameLayout);
                    }
                }
            });
            this.f8082H = null;
        }
    }

    private void m8041z() {
        if (this.aa.isPresent()) {
            m7994b((InlineVideoPlayer) this.aa.get());
        }
    }

    private void m7983a(View view) {
        if (view.getParent() != this.f8082H) {
            this.f8082H.a(view, new LayoutParams(view.getWidth(), view.getHeight(), 17));
        }
    }

    private void m7994b(View view) {
        a(view, new LayoutParams(-2, -2));
    }

    private void m7971A() {
        if (this.f8077C != null) {
            int i = this.f8077C.d;
            if (i > 0) {
                this.f8085K.setMax(i);
            }
        }
    }

    public static void m7973B(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        if (threadViewVideoAttachmentView.aa.isPresent()) {
            InlineVideoPlayer inlineVideoPlayer = (InlineVideoPlayer) threadViewVideoAttachmentView.aa.get();
            if (threadViewVideoAttachmentView.f8077C != null) {
                threadViewVideoAttachmentView.f8085K.setProgress(inlineVideoPlayer.getCurrentPosition());
            } else {
                threadViewVideoAttachmentView.f8085K.setVisibility(8);
            }
        }
    }

    public static void m7975C(ThreadViewVideoAttachmentView threadViewVideoAttachmentView) {
        if (threadViewVideoAttachmentView.aa.isPresent()) {
            threadViewVideoAttachmentView.f8086L.setText(threadViewVideoAttachmentView.f8115r.a((long) ((InlineVideoPlayer) threadViewVideoAttachmentView.aa.get()).getCurrentPosition()));
        }
    }
}
