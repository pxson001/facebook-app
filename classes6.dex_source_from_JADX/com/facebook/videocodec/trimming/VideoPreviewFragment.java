package com.facebook.videocodec.trimming;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.formatting.VideoStringsFormatter;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.common.VideoPreviewView;
import com.facebook.videocodec.common.VideoPreviewView.PlaybackState;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.policy.VideoSizeEstimator;
import com.facebook.videocodec.policy.VideoSizeEstimator$Estimate;
import com.facebook.videocodec.trimming.VideoTrimmingFilmStripView.Handle;
import com.facebook.videocodec.trimming.VideoTrimmingFilmStripView.Listener;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@TargetApi(10)
/* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
public class VideoPreviewFragment extends FbFragment {
    private static final Class<?> f19723a = VideoPreviewFragment.class;
    public VideoPreviewFragmentCallback aA;
    public ListenableFuture<VideoMetadata> aB;
    private View al;
    private LinearLayout am;
    public VideoTrimmingFilmStripView an;
    private VideoTrimmingMetadataView ao;
    private VideoTrimmingMetadataView ap;
    private VideoMetadata aq;
    public Uri ar;
    public int as = -1;
    private FutureAndCallbackHolder<VideoMetadata> at;
    private FutureAndCallbackHolder<Void> au;
    private int av;
    private int aw;
    private boolean ax;
    private boolean ay = false;
    private boolean az = false;
    private VideoSizeEstimator f19724b;
    private VideoStringsFormatter f19725c;
    public VideoMetadataExtractor f19726d;
    private ListeningExecutorService f19727e;
    private Executor f19728f;
    public AbstractFbErrorReporter f19729g;
    private EmptyListViewItem f19730h;
    public VideoTrimmingPreviewView f19731i;

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    public class C14701 {
        final /* synthetic */ VideoPreviewFragment f19708a;

        C14701(VideoPreviewFragment videoPreviewFragment) {
            this.f19708a = videoPreviewFragment;
        }

        public final void m28421d() {
            VideoPreviewFragment.av(this.f19708a);
        }

        public final void m28418a() {
            VideoPreviewFragment.aw(this.f19708a);
        }

        public final void m28419b() {
            VideoPreviewFragment.ax(this.f19708a);
        }

        public final void m28420c() {
            VideoPreviewFragment.ay(this.f19708a);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    class C14712 implements Listener {
        final /* synthetic */ VideoPreviewFragment f19709a;

        C14712(VideoPreviewFragment videoPreviewFragment) {
            this.f19709a = videoPreviewFragment;
        }

        public final void mo1497a(Handle handle) {
            this.f19709a.aC();
        }

        public final void mo1498b(Handle handle) {
            this.f19709a.m28450a(handle);
        }

        public final void mo1495a(int i) {
            VideoPreviewFragment.m28464h(this.f19709a, i);
        }

        public final void mo1496a(int i, int i2) {
            this.f19709a.at();
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    class C14723 implements Callable<VideoMetadata> {
        final /* synthetic */ VideoPreviewFragment f19710a;

        C14723(VideoPreviewFragment videoPreviewFragment) {
            this.f19710a = videoPreviewFragment;
        }

        public Object call() {
            return this.f19710a.f19726d.a(this.f19710a.ar);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    class C14734 extends AbstractDisposableFutureCallback<VideoMetadata> {
        final /* synthetic */ VideoPreviewFragment f19711a;

        C14734(VideoPreviewFragment videoPreviewFragment) {
            this.f19711a = videoPreviewFragment;
        }

        public final void m28430a(Object obj) {
            this.f19711a.m28442a((VideoMetadata) obj);
            VideoPreviewFragment.m28455b(this.f19711a, true);
            this.f19711a.aB = null;
        }

        public final void m28431a(Throwable th) {
            this.f19711a.f19729g.a("VideoTrimmingFragment_METADATA_EXTRACT_FAILED", th);
            VideoPreviewFragment.m28455b(this.f19711a, false);
            this.f19711a.aB = null;
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    class C14767 implements Runnable {
        final /* synthetic */ VideoPreviewFragment f19717a;

        C14767(VideoPreviewFragment videoPreviewFragment) {
            this.f19717a = videoPreviewFragment;
        }

        public void run() {
            VideoPreviewFragment.aA(this.f19717a);
            VideoPreviewFragment.az(this.f19717a);
            VideoPreviewFragment.aB(this.f19717a);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    class CancellableExecutor implements Executor {
        private final Executor f19721a;
        private volatile boolean f19722b;

        public CancellableExecutor(Executor executor) {
            this.f19721a = executor;
        }

        public void execute(Runnable runnable) {
            if (!this.f19722b) {
                ExecutorDetour.a(this.f19721a, runnable, -927113757);
            }
        }

        public final void m28435a() {
            this.f19722b = true;
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerDragListener */
    public interface VideoPreviewFragmentCallback {
        void m28436a(boolean z);
    }

    private static <T extends InjectableComponentWithContext> void m28451a(Class<T> cls, T t) {
        m28452a((Object) t, t.getContext());
    }

    private static void m28452a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((VideoPreviewFragment) obj).m28441a(VideoStringsFormatter.m27625a(injectorLike), DefaultVideoSizeEstimator.m28416a(injectorLike), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    private void m28441a(VideoStringsFormatter videoStringsFormatter, DefaultVideoSizeEstimator defaultVideoSizeEstimator, VideoMetadataExtractor videoMetadataExtractor, ListeningExecutorService listeningExecutorService, Executor executor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f19724b = defaultVideoSizeEstimator;
        this.f19725c = videoStringsFormatter;
        this.f19726d = videoMetadataExtractor;
        this.f19727e = listeningExecutorService;
        this.f19728f = executor;
        this.f19729g = abstractFbErrorReporter;
    }

    public final void m28475a(VideoPreviewFragmentCallback videoPreviewFragmentCallback) {
        this.aA = videoPreviewFragmentCallback;
    }

    public final void m28478c(Bundle bundle) {
        super.c(bundle);
        m28451a(VideoPreviewFragment.class, (InjectableComponentWithContext) this);
    }

    public final View m28471a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1425811980);
        View inflate = layoutInflater.inflate(2130907704, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1457170660, a);
        return inflate;
    }

    public final void m28473a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.al = e(2131568404);
        this.f19730h = (EmptyListViewItem) e(2131560591);
        this.f19731i = (VideoTrimmingPreviewView) e(2131568405);
        this.am = (LinearLayout) e(2131568406);
        this.an = (VideoTrimmingFilmStripView) e(2131568397);
        this.ao = (VideoTrimmingMetadataView) e(2131568398);
        this.ap = (VideoTrimmingMetadataView) e(2131568399);
        if (this.ay) {
            this.am.setVisibility(0);
            this.ao.setVisibility(0);
            this.ap.setVisibility(0);
        }
        this.f19731i.f19700c = new C14701(this);
        this.an.f19764z = new C14712(this);
    }

    public final void m28479d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 979081167);
        super.d(bundle);
        if (bundle != null) {
            this.az = bundle.getBoolean("is_video_playing");
        }
        this.f19730h.setVisibility(0);
        this.f19730h.m8598a(true);
        if (this.ar != null) {
            aq();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1466511172, a);
    }

    public final void m28481e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("is_video_playing", this.az);
    }

    public final void m28470I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -760168076);
        super.I();
        if (this.aB != null) {
            this.aB.cancel(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1621171387, a);
    }

    public final void m28469H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1860622886);
        super.H();
        this.f19731i.m28413c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1095876122, a);
    }

    public final void m28472a(Uri uri) {
        this.ar = uri;
        if (this.ar == null || !mx_()) {
            ar();
            return;
        }
        VideoPreviewView videoPreviewView = this.f19731i;
        videoPreviewView.f19698a.setVideoURI(uri);
        videoPreviewView.m28411a(PlaybackState.PREPARING);
        aq();
    }

    public final void m28474a(VideoSizeEstimator videoSizeEstimator) {
        Preconditions.checkNotNull(videoSizeEstimator);
        this.f19724b = videoSizeEstimator;
    }

    public final void m28482g(int i) {
        this.as = i;
    }

    public final int m28477b() {
        return this.an.f19761w;
    }

    public final int m28480e() {
        return this.an.f19762x;
    }

    private void aq() {
        ar();
        as();
    }

    private void ar() {
        if (this.at != null) {
            this.at.a(false);
            this.at = null;
        }
        if (this.au != null) {
            this.au.a(false);
            this.au = null;
        }
    }

    private void as() {
        this.aB = this.f19727e.a(new C14723(this));
        C14734 c14734 = new C14734(this);
        this.at = FutureAndCallbackHolder.a(this.aB, c14734);
        Futures.a(this.aB, c14734, this.f19728f);
    }

    private void m28442a(VideoMetadata videoMetadata) {
        int a;
        this.aq = videoMetadata;
        this.f19730h.setVisibility(8);
        this.f19731i.setVisibility(0);
        this.an.setVideoMetaData(videoMetadata);
        if (this.as > 0) {
            a = this.f19724b.a(videoMetadata, this.as);
            if (a > 0) {
                this.an.setMaximumDuration(a);
            }
        }
        String a2 = this.f19725c.m27628a(videoMetadata.f5480a);
        String a3 = m28439a(videoMetadata.f5485f, false);
        this.ao.setDurationString(a2);
        this.ao.setSizeString(a3);
        at();
        au();
        if (videoMetadata.f5483d == 90 || videoMetadata.f5483d == 270) {
            this.f19731i.m28410a(videoMetadata.f5482c, videoMetadata.f5481b);
        } else {
            this.f19731i.m28410a(videoMetadata.f5481b, videoMetadata.f5482c);
        }
        a = jW_().getConfiguration().orientation;
        if (!m28457b(videoMetadata) && a == 2) {
            LayoutParams layoutParams = (LayoutParams) this.al.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            this.al.setLayoutParams(layoutParams);
        }
    }

    private static boolean m28457b(VideoMetadata videoMetadata) {
        if (videoMetadata.f5481b > videoMetadata.f5482c) {
            if (videoMetadata.f5483d == 0 || videoMetadata.f5483d == 180) {
                return true;
            }
            return false;
        } else if (videoMetadata.f5483d == 90 || videoMetadata.f5483d == 270) {
            return true;
        } else {
            return false;
        }
    }

    private void at() {
        if (this.aq != null) {
            VideoSizeEstimator$Estimate a = this.f19724b.a(this.aq, this.an.f19761w, this.an.f19762x);
            String a2 = this.f19725c.m27628a((long) a.f5571d);
            String a3 = m28439a((long) a.f5570c, true);
            this.ap.setDurationString(a2);
            this.ap.setSizeString(a3);
        }
    }

    private String m28439a(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        String a = this.f19725c.m27627a((int) j);
        if (!z) {
            return a;
        }
        return getContext().getString(2131232848, new Object[]{a});
    }

    private void au() {
        final CancellableExecutor cancellableExecutor = new CancellableExecutor(this.f19728f);
        final int numPreviewImages = this.an.getNumPreviewImages();
        ListenableFuture a = this.f19727e.a(new Callable<Void>(this) {
            final /* synthetic */ VideoPreviewFragment f19714c;

            public Object call() {
                this.f19714c.m28440a(this.f19714c.ar, numPreviewImages, cancellableExecutor);
                return null;
            }
        });
        C14756 c14756 = new AbstractDisposableFutureCallback<Void>(this) {
            final /* synthetic */ VideoPreviewFragment f19716b;

            protected final void m28434a(CancellationException cancellationException) {
                cancellableExecutor.m28435a();
            }

            public final void m28433a(Throwable th) {
                this.f19716b.f19729g.a("VideoTrimmingFragment_PREVIEW_IMAGE_EXTRACT_FAILED", th);
            }
        };
        FutureAndCallbackHolder a2 = FutureAndCallbackHolder.a(a, c14756);
        Futures.a(a, c14756, MoreExecutors.a());
        this.au = a2;
    }

    public static void av(VideoPreviewFragment videoPreviewFragment) {
        int i = videoPreviewFragment.an.f19763y;
        int i2 = videoPreviewFragment.an.f19762x;
        if (i > 0 && i != i2) {
            videoPreviewFragment.f19731i.m28409a(i);
            if (videoPreviewFragment.az) {
                videoPreviewFragment.f19731i.m28412b();
            }
        }
    }

    public static void aw(VideoPreviewFragment videoPreviewFragment) {
        PlaybackState playbackState = videoPreviewFragment.f19731i.f19703g;
        if (playbackState == PlaybackState.PLAYING) {
            videoPreviewFragment.az = false;
            videoPreviewFragment.f19731i.m28413c();
        } else if (playbackState == PlaybackState.PAUSED) {
            int i = videoPreviewFragment.an.f19763y;
            int i2 = videoPreviewFragment.an.f19762x;
            if (videoPreviewFragment.ax || i == i2) {
                i = videoPreviewFragment.an.f19761w;
                videoPreviewFragment.f19731i.m28409a(i);
                videoPreviewFragment.an.setClipTimeMs(i);
            }
            videoPreviewFragment.az = true;
            videoPreviewFragment.f19731i.m28412b();
        }
    }

    public static void ax(VideoPreviewFragment videoPreviewFragment) {
        videoPreviewFragment.az = false;
        videoPreviewFragment.ax = true;
    }

    public static void ay(VideoPreviewFragment videoPreviewFragment) {
        videoPreviewFragment.ax = false;
        az(videoPreviewFragment);
    }

    public static void az(VideoPreviewFragment videoPreviewFragment) {
        if (videoPreviewFragment.f19731i.f19698a.isPlaying()) {
            ViewCompat.a(videoPreviewFragment.f19731i, new C14767(videoPreviewFragment));
        } else {
            aA(videoPreviewFragment);
        }
    }

    public static void aA(VideoPreviewFragment videoPreviewFragment) {
        int currentPosition = videoPreviewFragment.f19731i.getCurrentPosition();
        if (currentPosition > videoPreviewFragment.an.f19763y) {
            videoPreviewFragment.an.setClipTimeMs(currentPosition);
        }
    }

    public static void aB(VideoPreviewFragment videoPreviewFragment) {
        if (videoPreviewFragment.f19731i.getCurrentPosition() >= videoPreviewFragment.an.f19762x) {
            videoPreviewFragment.f19731i.m28413c();
            videoPreviewFragment.ax = true;
        }
    }

    private void aC() {
        this.av = this.an.f19761w;
        this.aw = this.an.f19762x;
    }

    private void m28450a(Handle handle) {
        if (handle == Handle.SCRUBBER) {
            this.ax = false;
        } else {
            m28456b(handle);
        }
    }

    private void m28456b(Handle handle) {
        int i = this.an.f19761w;
        int i2 = this.an.f19762x;
        if (i != this.av || i2 != this.aw) {
            int i3 = this.an.f19763y;
            if ((handle == Handle.LEFT_TRIM || handle == Handle.RIGHT_TRIM) && (i > i3 || this.av == i3)) {
                this.an.setClipTimeMs(i);
                this.f19731i.m28409a(i);
            }
            if (handle == Handle.RIGHT_TRIM) {
                if (i2 >= this.aw || (i3 <= i2 && this.aw - i3 >= 3000)) {
                    i = -1;
                } else {
                    i = MathUtil.a(i2 - (this.aw - i3), i, i2);
                }
                if (i != -1) {
                    this.an.setClipTimeMs(i);
                    this.f19731i.m28409a(i);
                }
                if (i2 > this.aw) {
                    this.ax = false;
                }
            }
        }
    }

    public static void m28464h(VideoPreviewFragment videoPreviewFragment, int i) {
        videoPreviewFragment.f19731i.m28409a(i);
    }

    private void aD() {
        at();
    }

    private void m28440a(Uri uri, int i, Executor executor) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(getContext(), uri);
        int i2 = 0;
        while (i2 < i) {
            try {
                final Bitmap a = m28437a((int) ((((long) i2) * this.aq.f5480a) / ((long) i)), mediaMetadataRetriever);
                ExecutorDetour.a(executor, new Runnable(this) {
                    final /* synthetic */ VideoPreviewFragment f19720c;

                    public void run() {
                        this.f19720c.an.m28494a(i2, a);
                        if (i2 == 0 && this.f19720c.an.f19763y == 0) {
                            VideoPreviewView videoPreviewView = this.f19720c.f19731i;
                            CustomViewUtils.b(videoPreviewView.f19698a, new BitmapDrawable(videoPreviewView.getResources(), a));
                        }
                    }
                }, -851724121);
                i2++;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
            }
        }
        mediaMetadataRetriever.release();
    }

    private Bitmap m28437a(int i, MediaMetadataRetriever mediaMetadataRetriever) {
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime((long) (i * 1000), 2);
        float filmStripHeight = ((float) this.an.getFilmStripHeight()) / ((float) frameAtTime.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(frameAtTime, (int) (((float) frameAtTime.getWidth()) * filmStripHeight), (int) (filmStripHeight * ((float) frameAtTime.getHeight())), false);
        frameAtTime.recycle();
        return createScaledBitmap;
    }

    public static void m28455b(VideoPreviewFragment videoPreviewFragment, boolean z) {
        if (videoPreviewFragment.aA != null) {
            videoPreviewFragment.aA.m28436a(z);
        }
    }

    public final void m28476a(boolean z) {
        boolean z2;
        if (this.T == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        this.ay = z;
    }
}
