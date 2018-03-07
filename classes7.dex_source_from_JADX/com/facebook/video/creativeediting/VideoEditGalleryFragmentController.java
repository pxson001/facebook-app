package com.facebook.video.creativeediting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bitmaps.BitmapException;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.debug.log.BLog;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.videoeditgallery.VideoEditFeature;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.photos.editgallery.animations.EditGalleryAnimation;
import com.facebook.photos.editgallery.common.FeatureSelectorController;
import com.facebook.photos.editgallery.common.FeatureSelectorController.FeatureSelectorControllerCallback;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.VideoEditGalleryVideoPreviewView.Listener;
import com.facebook.video.creativeediting.analytics.AudioLoggingParams;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger.CreativeToolsParams;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger.Params;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData.Builder;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
public class VideoEditGalleryFragmentController {
    private static final String f15414a = VideoEditGalleryFragmentController.class.getName();
    private final VideoEditGalleryLaunchConfiguration f15415b;
    private final DefaultAndroidThreadUtil f15416c;
    public final ListeningExecutorService f15417d;
    public final VideoMetadataExtractor f15418e;
    public final VideoEditGalleryFragment f15419f;
    public final AbstractFbErrorReporter f15420g;
    public final VideoEditGalleryPerformanceLogger f15421h;
    public final AllCapsTransformationMethod f15422i;
    public final Uri f15423j;
    public VideoMetadata f15424k;
    public final VideoTrimmingController f15425l;
    private final VideoCropController f15426m;
    public final List<FeatureSelectorController> f15427n = new ArrayList();
    public final ScreenUtil f15428o;
    @Nullable
    public final AnimationParam f15429p;
    public Optional<EditGalleryAnimation> f15430q = Absent.withType();
    private Context f15431r;
    private BitmapUtils f15432s;
    private Lazy<TempFileManager> f15433t;
    public final AudioLoggingParams f15434u = new AudioLoggingParams();
    public VideoCreativeEditingLogger f15435v;
    public State f15436w;
    public VideoEditGalleryCallback f15437x;
    private final FeatureSelectorControllerCallback f15438y = new C11681(this);
    public final Listener f15439z = new C11692(this);

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    class C11681 implements FeatureSelectorControllerCallback {
        final /* synthetic */ VideoEditGalleryFragmentController f15405a;

        C11681(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
            this.f15405a = videoEditGalleryFragmentController;
        }

        public final void mo577a(FeatureSelectorController featureSelectorController) {
            for (FeatureSelectorController featureSelectorController2 : this.f15405a.f15427n) {
                if (featureSelectorController2 != featureSelectorController) {
                    featureSelectorController2.m12367a(false);
                }
            }
            VideoEditGalleryFragmentController.m19467a(this.f15405a, featureSelectorController);
        }

        public final boolean mo578a() {
            return true;
        }
    }

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    class C11692 implements Listener {
        final /* synthetic */ VideoEditGalleryFragmentController f15406a;

        C11692(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
            this.f15406a = videoEditGalleryFragmentController;
        }

        public final void mo1196a(boolean z) {
            AudioLoggingParams audioLoggingParams = this.f15406a.f15434u;
            audioLoggingParams.f15530a++;
            State state = this.f15406a.f15436w;
            Builder builder = new Builder(this.f15406a.f15436w.f15412b);
            builder.c = z;
            state.f15412b = builder.a();
        }

        public final void mo1195a(int i) {
            State state = this.f15406a.f15436w;
            Builder builder = new Builder(this.f15406a.f15436w.f15412b);
            builder.b = i;
            state.f15412b = builder.a();
        }

        public final void mo1197b(boolean z) {
            VideoTrimmingController videoTrimmingController = this.f15406a.f15425l;
            if (z) {
                videoTrimmingController.f15521r.m19563c();
                videoTrimmingController.f15505b.m19475h();
                return;
            }
            videoTrimmingController.f15496I.setVisibility(0);
            if (videoTrimmingController.f15506c.m19476j()) {
                VideoTrimmingController.m19527u(videoTrimmingController);
                return;
            }
            VideoTrimmingController.m19529y(videoTrimmingController);
            videoTrimmingController.f15521r.m19562b();
        }
    }

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    public class C11703 implements OnClickListener {
        final /* synthetic */ VideoEditGalleryFragmentController f15407a;

        public C11703(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
            this.f15407a = videoEditGalleryFragmentController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 841246686);
            VideoCreativeEditingData n = VideoEditGalleryFragmentController.m19470n(this.f15407a);
            this.f15407a.f15435v.m19552b(this.f15407a.f15423j.toString(), this.f15407a.f15419f.aw(), this.f15407a.f15419f.at, this.f15407a.f15419f.as().getVideoDurationMs(), n.i(), n.c(), n.b());
            VideoEditGalleryFragmentController.m19469m(this.f15407a);
            VideoEditGalleryFragmentController.m19468k(this.f15407a);
            this.f15407a.f15419f.f.cancel();
            Logger.a(2, EntryType.UI_INPUT_END, 1145689694, a);
        }
    }

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    public class C11714 extends OnToolbarButtonListener {
        final /* synthetic */ VideoEditGalleryFragmentController f15408a;

        public C11714(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
            this.f15408a = videoEditGalleryFragmentController;
        }

        public final void m19463a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            VideoCreativeEditingData n = VideoEditGalleryFragmentController.m19470n(this.f15408a);
            this.f15408a.f15436w.f15412b = n;
            this.f15408a.f15435v.m19551a(this.f15408a.f15423j.toString(), this.f15408a.f15419f.aw(), this.f15408a.f15419f.at, this.f15408a.f15419f.as().getVideoDurationMs(), n.i(), n.c(), n.b());
            VideoEditGalleryFragmentController.m19469m(this.f15408a);
            VideoEditGalleryFragmentController.m19468k(this.f15408a);
            this.f15408a.f15437x.mo1169a(this.f15408a.f15436w.f15412b, this.f15408a.f15419f.as().getCurrentPositionMs());
            this.f15408a.f15419f.b();
        }
    }

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    public class C11725 implements Runnable {
        final /* synthetic */ VideoEditGalleryFragmentController f15409a;

        public C11725(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
            this.f15409a = videoEditGalleryFragmentController;
        }

        public void run() {
            try {
                this.f15409a.f15424k = this.f15409a.f15418e.a(this.f15409a.f15423j);
                VideoEditGalleryFragmentController.m19472p(this.f15409a);
            } catch (Throwable e) {
                this.f15409a.f15420g.a("Failed to extract video metadata", e);
            }
        }
    }

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    class C11736 implements Runnable {
        final /* synthetic */ VideoEditGalleryFragmentController f15410a;

        C11736(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
            this.f15410a = videoEditGalleryFragmentController;
        }

        public void run() {
            VideoEditGalleryFragmentController videoEditGalleryFragmentController = this.f15410a;
            VideoEditGalleryVideoPreviewView as = videoEditGalleryFragmentController.f15419f.as();
            as.f15466i = videoEditGalleryFragmentController.f15423j;
            as.f15467j = UriUtil.a(videoEditGalleryFragmentController.f15436w.f15412b.f());
            as.f15463f = videoEditGalleryFragmentController.f15439z;
            as.setVideoMuted(videoEditGalleryFragmentController.f15436w.f15412b.c());
            as.setRotationAngle(videoEditGalleryFragmentController.f15436w.f15412b.b());
            as.f15474q = videoEditGalleryFragmentController.f15419f.ao.f6207g;
            as.f15475r = videoEditGalleryFragmentController.f15436w.f15412b.h();
            if (videoEditGalleryFragmentController.f15424k.d % 180 == 0) {
                as.m19498a(videoEditGalleryFragmentController.f15424k.b, videoEditGalleryFragmentController.f15424k.c);
            } else {
                as.m19498a(videoEditGalleryFragmentController.f15424k.c, videoEditGalleryFragmentController.f15424k.b);
            }
            as.m19496a();
            VideoEditGalleryVideoPreviewView as2 = videoEditGalleryFragmentController.f15419f.as();
            if (!(videoEditGalleryFragmentController.f15430q.isPresent() || videoEditGalleryFragmentController.f15429p == null)) {
                RectF rectF = new RectF();
                if (as2 instanceof VideoEditGalleryVideoPreviewView) {
                    rectF.bottom = (float) as2.getBottom();
                    rectF.right = (float) as2.getRight();
                    rectF.left = (float) as2.getLeft();
                    rectF.top = (float) as2.getTop();
                }
                videoEditGalleryFragmentController.f15430q = Optional.of(new EditGalleryAnimation(videoEditGalleryFragmentController.f15429p, AnimationParam.m12363a(as2, rectF), new PointF((float) as2.getLeft(), (float) as2.getTop()), videoEditGalleryFragmentController.f15428o.d()));
                ((EditGalleryAnimation) videoEditGalleryFragmentController.f15430q.get()).m12365a(as2, null);
            }
            VideoEditGalleryFragmentController.m19473r(this.f15410a);
        }
    }

    /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
    public class State implements Parcelable {
        public static final Creator<State> CREATOR = new C11741();
        public VideoEditFeature f15411a;
        public VideoCreativeEditingData f15412b;
        public boolean f15413c;

        /* compiled from: ebc9239c8710f5fd6673e0f70e3d970f */
        final class C11741 implements Creator<State> {
            C11741() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            public final Object[] newArray(int i) {
                return new State[i];
            }
        }

        public State(Parcel parcel) {
            this.f15411a = VideoEditFeature.values()[parcel.readInt()];
            this.f15412b = (VideoCreativeEditingData) parcel.readParcelable(VideoCreativeEditingData.class.getClassLoader());
            this.f15413c = ParcelUtil.a(parcel);
        }

        public State(VideoCreativeEditingData videoCreativeEditingData, VideoEditFeature videoEditFeature) {
            this.f15412b = videoCreativeEditingData;
            this.f15411a = videoEditFeature;
        }

        public final VideoCreativeEditingData m19464a() {
            return this.f15412b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f15411a.ordinal());
            parcel.writeParcelable(this.f15412b, i);
            ParcelUtil.a(parcel, this.f15413c);
        }
    }

    @Inject
    public VideoEditGalleryFragmentController(VideoMetadataExtractor videoMetadataExtractor, FbErrorReporter fbErrorReporter, VideoEditGalleryPerformanceLogger videoEditGalleryPerformanceLogger, AndroidThreadUtil androidThreadUtil, VideoTrimmingControllerProvider videoTrimmingControllerProvider, Context context, BitmapUtils bitmapUtils, Lazy<TempFileManager> lazy, VideoCreativeEditingLogger videoCreativeEditingLogger, VideoCropController videoCropController, ListeningExecutorService listeningExecutorService, @Assisted VideoEditGalleryFragment videoEditGalleryFragment, @Assisted Uri uri, @Assisted State state, @Assisted VideoEditGalleryCallback videoEditGalleryCallback, @Nullable @Assisted AnimationParam animationParam, @Assisted VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration, ScreenUtil screenUtil, AllCapsTransformationMethod allCapsTransformationMethod) {
        Preconditions.checkNotNull(videoEditGalleryFragment);
        this.f15418e = videoMetadataExtractor;
        this.f15420g = fbErrorReporter;
        this.f15421h = videoEditGalleryPerformanceLogger;
        this.f15416c = androidThreadUtil;
        this.f15415b = videoEditGalleryLaunchConfiguration;
        VideoMirroringMode videoMirroringMode = VideoMirroringMode.NONE;
        if (state.m19464a() != null && state.m19464a().h()) {
            videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
        }
        this.f15425l = videoTrimmingControllerProvider.m19543a(uri, UriUtil.a(state.m19464a().f()), videoMirroringMode, videoEditGalleryFragment.aw(), videoEditGalleryFragment.au(), state.m19464a().a(), videoEditGalleryFragment.av(), videoEditGalleryFragment.at(), videoEditGalleryFragment.ax(), this, this);
        this.f15426m = videoCropController;
        this.f15417d = listeningExecutorService;
        this.f15419f = videoEditGalleryFragment;
        this.f15423j = uri;
        this.f15436w = state;
        this.f15437x = videoEditGalleryCallback;
        this.f15429p = animationParam;
        this.f15428o = screenUtil;
        this.f15431r = context;
        this.f15432s = bitmapUtils;
        this.f15433t = lazy;
        this.f15422i = allCapsTransformationMethod;
        this.f15435v = videoCreativeEditingLogger;
    }

    public static void m19468k(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
        for (FeatureSelectorController featureSelectorController : videoEditGalleryFragmentController.f15427n) {
            if (featureSelectorController.f10488b.mo572j() == videoEditGalleryFragmentController.f15436w.f15411a) {
                featureSelectorController.f10488b.mo571i();
                return;
            }
        }
    }

    public static void m19469m(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
        for (FeatureSelectorController featureSelectorController : videoEditGalleryFragmentController.f15427n) {
            ((VideoEditFeatureController) featureSelectorController.f10488b).mo1194k();
        }
        VideoCreativeEditingLogger videoCreativeEditingLogger = videoEditGalleryFragmentController.f15435v;
        String uri = videoEditGalleryFragmentController.f15423j.toString();
        String aw = videoEditGalleryFragmentController.f15419f.aw();
        VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint = videoEditGalleryFragmentController.f15419f.at;
        AudioLoggingParams audioLoggingParams = videoEditGalleryFragmentController.f15434u;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("video_editing_audio_interactions");
        honeyClientEvent.c = "video_editing_module";
        videoCreativeEditingLogger.f15536a.a(honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), uri).b(Params.SESSION_ID.getParamKey(), aw).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).a(CreativeToolsParams.AUDIO_BUTTON_CLICKS.getParamKey(), audioLoggingParams.f15530a));
    }

    public static VideoCreativeEditingData m19470n(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
        Builder builder = new Builder(videoEditGalleryFragmentController.f15436w.f15412b);
        if (videoEditGalleryFragmentController.f15425l.f15502O) {
            VideoTrimParams.Builder newBuilder = VideoTrimParams.newBuilder();
            int m = videoEditGalleryFragmentController.f15425l.m19542m();
            VideoTrimmingController videoTrimmingController = videoEditGalleryFragmentController.f15425l;
            builder.a = newBuilder.a(m, videoTrimmingController.f15518o.m19604a(videoTrimmingController.f15520q.m19557b(), false)).a();
        }
        if (videoEditGalleryFragmentController.f15436w.f15413c) {
            builder.d = videoEditGalleryFragmentController.m19471o().toString();
        }
        return builder.a();
    }

    private Uri m19471o() {
        Bitmap a;
        Preconditions.checkNotNull(this.f15436w.m19464a());
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.f15431r, this.f15423j);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros((long) this.f15425l.m19542m()));
        int b = this.f15436w.m19464a().b();
        if (b != 0) {
            a = BitmapUtils.a(frameAtTime, b, true);
        } else {
            a = frameAtTime;
        }
        File a2 = ((TempFileManager) this.f15433t.get()).a("FB_VCT_" + Files.b(this.f15423j.getPath()) + "_", "." + CompressFormat.JPEG.name(), Privacy.REQUIRE_PRIVATE);
        try {
            BitmapUtils.a(a, CompressFormat.JPEG, 80, a2);
        } catch (BitmapException e) {
            BLog.c(f15414a, "Could not save thumbnail for edited video", e);
        } finally {
            a.recycle();
            mediaMetadataRetriever.release();
        }
        return Uri.fromFile(a2);
    }

    public static void m19472p(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
        videoEditGalleryFragmentController.f15416c.a(new C11736(videoEditGalleryFragmentController));
    }

    public static void m19473r(VideoEditGalleryFragmentController videoEditGalleryFragmentController) {
        View view = videoEditGalleryFragmentController.f15419f.aq;
        View b = FindViewUtil.b(view, 2131568313);
        videoEditGalleryFragmentController.f15427n.add(new FeatureSelectorController(videoEditGalleryFragmentController.f15419f.getContext(), b, videoEditGalleryFragmentController.f15438y, videoEditGalleryFragmentController.f15425l, videoEditGalleryFragmentController.f15419f.av, (ImageButton) b.findViewById(2131561104), (FbTextView) b.findViewById(2131561105)));
        FeatureSelectorController a = videoEditGalleryFragmentController.m19465a(view);
        if (a != null) {
            videoEditGalleryFragmentController.f15427n.add(a);
        }
        if (videoEditGalleryFragmentController.f15427n.size() <= 1) {
            view.setVisibility(8);
        }
        for (FeatureSelectorController a2 : videoEditGalleryFragmentController.f15427n) {
            if (a2.f10488b.mo572j() == videoEditGalleryFragmentController.f15436w.f15411a) {
                m19467a(videoEditGalleryFragmentController, a2);
                return;
            }
        }
    }

    @Nullable
    private FeatureSelectorController m19465a(View view) {
        if (!this.f15415b.f6204d) {
            return null;
        }
        View b = FindViewUtil.b(view, 2131568314);
        return new FeatureSelectorController(this.f15419f.getContext(), b, this.f15438y, this.f15426m, this.f15419f.av, (ImageButton) b.findViewById(2131561104), (FbTextView) b.findViewById(2131561105));
    }

    public static void m19467a(VideoEditGalleryFragmentController videoEditGalleryFragmentController, FeatureSelectorController featureSelectorController) {
        Preconditions.checkState(videoEditGalleryFragmentController.f15427n.contains(featureSelectorController));
        Preconditions.checkNotNull(featureSelectorController.f10488b);
        videoEditGalleryFragmentController.f15419f.av.setTitle(featureSelectorController.f10488b.mo559a());
        featureSelectorController.f10488b.mo570h();
        featureSelectorController.m12367a(true);
    }

    public final void m19474a(int i) {
        this.f15436w.f15413c = true;
        this.f15419f.as().m19501d();
        this.f15419f.as().m19497a(i);
    }

    public final void m19475h() {
        this.f15419f.as().m19501d();
    }

    public final boolean m19476j() {
        return this.f15419f.as().m19502e();
    }
}
