package com.facebook.video.creativeediting.trimmer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.file.FileTree;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.creativeediting.ui.fresco.DraweeStripView;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;
import com.facebook.video.creativeediting.utilities.VideoMetadataExtractHelper;
import com.facebook.video.scrubber.GLFrameRetriever;
import com.facebook.video.scrubber.GLFrameRetrieverProvider;
import com.facebook.videocodec.effects.renderers.EffectsFactory;
import com.facebook.videocodec.effects.renderers.EffectsFactory.EffectsBuilder;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: downStateType */
public class VideoStripController {
    public static final CallerContext f15609a = CallerContext.a(VideoStripController.class, "video_editing_module");
    private final Context f15610b;
    public final Uri f15611c;
    private final ListeningExecutorService f15612d;
    private final Executor f15613e;
    public final PlatformBitmapFactory f15614f;
    private final FbDraweeControllerBuilder f15615g;
    public final GLFrameRetrieverProvider f15616h;
    public final EffectsFactory f15617i;
    private final long f15618j;
    private final int f15619k;
    private int f15620l;
    private int f15621m;
    public float f15622n;
    public Uri f15623o;
    public VideoMirroringMode f15624p;
    public ZoomableDraweeStripView f15625q;
    public int f15626r;
    public int f15627s;
    public int f15628t;
    public int f15629u;
    private ListenableFuture f15630v;

    /* compiled from: downStateType */
    class C11931 implements Runnable {
        final /* synthetic */ VideoStripController f15593a;

        C11931(VideoStripController videoStripController) {
            this.f15593a = videoStripController;
        }

        public void run() {
            FileTree.b(VideoStripController.m19584c(this.f15593a));
        }
    }

    /* compiled from: downStateType */
    class C11942 implements Runnable {
        final /* synthetic */ VideoStripController f15594a;

        C11942(VideoStripController videoStripController) {
            this.f15594a = videoStripController;
        }

        public void run() {
            if (this.f15594a.f15625q != null) {
                DraweeStripView draweeStripView = this.f15594a.f15625q;
                for (int i = 0; i < draweeStripView.f15633c; i++) {
                    ((DraweeHolder) draweeStripView.f15635e.valueAt(i)).a(draweeStripView.f15631a.m19575a(draweeStripView.f15635e.keyAt(i)));
                }
            }
        }
    }

    /* compiled from: downStateType */
    class BitmapData {
        public long f15598a;
        public Uri f15599b = Uri.fromFile(new File(this.f15600c));
        public String f15600c;
        public DraweeController f15601d;
        public DraweeController f15602e;
        public Rect f15603f;

        public BitmapData(long j, int i, int i2, File file, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
            this.f15598a = j;
            this.f15603f = new Rect(0, 0, i, i2);
            this.f15600c = file.getPath() + File.separator + j;
            this.f15602e = fbDraweeControllerBuilder.a(CallerContext.a(BitmapData.class)).b(this.f15599b).s();
            this.f15601d = this.f15602e;
        }

        public final void m19574a(FbDraweeControllerBuilder fbDraweeControllerBuilder, Uri uri) {
            this.f15601d = fbDraweeControllerBuilder.a(CallerContext.a(BitmapData.class)).b(uri).s();
        }

        public final void m19573a() {
            this.f15601d = this.f15602e;
        }
    }

    /* compiled from: downStateType */
    public class VideoStripAdapter {
        public final ImmutableList<BitmapData> f15604a;
        public int f15605b;
        public int f15606c;
        public int f15607d;
        private int f15608e;

        public VideoStripAdapter(ImmutableList<BitmapData> immutableList, int i, int i2, int i3) {
            int i4;
            this.f15604a = immutableList;
            this.f15607d = i;
            this.f15608e = i2;
            int size = immutableList.size();
            int i5 = i;
            for (i4 = 0; i4 < size; i4++) {
                BitmapData bitmapData = (BitmapData) immutableList.get(i4);
                Rect rect = bitmapData.f15603f;
                rect.left += i5;
                rect = bitmapData.f15603f;
                rect.right = i5 + rect.right;
                i5 = bitmapData.f15603f.right;
            }
            if (i3 > 0) {
                this.f15605b = i3;
                i4 = this.f15605b - i2;
                Rect rect2 = ((BitmapData) immutableList.get(immutableList.size() - 1)).f15603f;
                if (i4 > rect2.left) {
                    rect2.right = i4;
                }
            } else {
                this.f15605b = i5 + i;
            }
            this.f15606c = (this.f15605b - this.f15607d) - this.f15608e;
        }

        public final void m19576a(int i, Rect rect) {
            rect.set(((BitmapData) this.f15604a.get(i)).f15603f);
        }

        public final DraweeController m19575a(int i) {
            return ((BitmapData) this.f15604a.get(i)).f15601d;
        }
    }

    @Inject
    public VideoStripController(Context context, @Assisted Uri uri, @Assisted Uri uri2, @Assisted boolean z, @Assisted VideoMirroringMode videoMirroringMode, ListeningExecutorService listeningExecutorService, Executor executor, PlatformBitmapFactory platformBitmapFactory, FbDraweeControllerBuilder fbDraweeControllerBuilder, GLFrameRetrieverProvider gLFrameRetrieverProvider, EffectsFactory effectsFactory) {
        this.f15610b = context;
        this.f15611c = uri;
        this.f15623o = uri2;
        this.f15624p = videoMirroringMode;
        this.f15612d = listeningExecutorService;
        this.f15613e = executor;
        this.f15614f = platformBitmapFactory;
        this.f15615g = fbDraweeControllerBuilder;
        this.f15616h = gLFrameRetrieverProvider;
        this.f15617i = effectsFactory;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.f15610b, this.f15611c);
        this.f15618j = VideoMetadataExtractHelper.m19609a(mediaMetadataRetriever);
        this.f15619k = VideoMetadataExtractHelper.m19613e(mediaMetadataRetriever);
        this.f15620l = VideoMetadataExtractHelper.m19611c(mediaMetadataRetriever);
        this.f15621m = VideoMetadataExtractHelper.m19612d(mediaMetadataRetriever);
        if (this.f15619k % 180 != 0) {
            int i = this.f15620l;
            this.f15620l = this.f15621m;
            this.f15621m = i;
        }
        this.f15622n = z ? 1.0f : ((float) this.f15620l) / ((float) this.f15621m);
        mediaMetadataRetriever.release();
    }

    public final void m19588a(ZoomableDraweeStripView zoomableDraweeStripView, int i, int i2) {
        if (this.f15625q == null) {
            this.f15625q = zoomableDraweeStripView;
            this.f15626r = this.f15625q.getWidth();
            this.f15627s = this.f15625q.getHeight();
            this.f15629u = this.f15627s;
            this.f15628t = (int) (((float) this.f15629u) * this.f15622n);
            m19579a(i, i2);
        }
    }

    public final void m19587a() {
        this.f15625q = null;
        ExecutorDetour.a(this.f15612d, new C11931(this), -233854383);
        m19586g();
    }

    private void m19581a(ImmutableList<BitmapData> immutableList, ImmutableList<BitmapData> immutableList2) {
        int i = 0;
        if (immutableList.size() >= 2) {
            Uri uri = ((BitmapData) immutableList.get(0)).f15599b;
            int size = immutableList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((BitmapData) immutableList.get(i2)).m19574a(this.f15615g, uri);
            }
            long j = ((BitmapData) immutableList.get(1)).f15598a;
            int size2 = immutableList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                BitmapData bitmapData = (BitmapData) immutableList2.get(i3);
                if (bitmapData.f15598a > j && i + 1 < immutableList.size()) {
                    int i4 = i + 1;
                    Uri uri2 = ((BitmapData) immutableList.get(i4)).f15599b;
                    if (i4 + 1 < immutableList.size()) {
                        j = ((BitmapData) immutableList.get(i4 + 1)).f15598a;
                        i = i4;
                        uri = uri2;
                    } else {
                        i = i4;
                        uri = uri2;
                    }
                }
                bitmapData.m19574a(this.f15615g, uri);
            }
        }
    }

    public static File m19584c(VideoStripController videoStripController) {
        return new File(videoStripController.f15610b.getCacheDir(), "video-creative-editing");
    }

    private void m19579a(int i, int i2) {
        File file = new File(m19584c(this), "strip-" + hashCode());
        file.mkdirs();
        File file2 = file;
        int i3 = ((((this.f15626r - i) - i2) + this.f15628t) - 1) / this.f15628t;
        int max = Math.max(i3 * 2, (int) ((this.f15618j + 999) / 1000));
        ImmutableList a = m19578a(i3, this.f15628t, this.f15629u, file2);
        ImmutableList a2 = m19578a(max, this.f15628t, this.f15629u, file2);
        m19581a(a, a2);
        this.f15625q.m19598a(new VideoStripAdapter(a, i, i2, this.f15626r), new VideoStripAdapter(a2, i, i2, 0));
        m19583b(a, a2);
    }

    private ImmutableList<BitmapData> m19578a(int i, int i2, int i3, File file) {
        Builder builder = new Builder();
        for (int i4 = 0; i4 < i; i4++) {
            builder.c(new BitmapData((((long) i4) * this.f15618j) / ((long) i), i2, i3, file, this.f15615g));
        }
        return builder.b();
    }

    public static void m19585f(VideoStripController videoStripController) {
        ExecutorDetour.a(videoStripController.f15613e, new C11942(videoStripController), -1205294733);
    }

    private void m19586g() {
        if (this.f15630v != null) {
            if (!(this.f15630v.isDone() || this.f15630v.isCancelled())) {
                this.f15630v.cancel(true);
            }
            this.f15630v = null;
        }
    }

    private void m19583b(final ImmutableList<BitmapData> immutableList, final ImmutableList<BitmapData> immutableList2) {
        m19586g();
        this.f15630v = this.f15612d.a(new Runnable(this) {
            final /* synthetic */ VideoStripController f15597c;

            public void run() {
                int i = 0;
                EffectsBuilder a = this.f15597c.f15617i.m19783a();
                if (this.f15597c.f15623o != null) {
                    a.m19779a(this.f15597c.f15623o, VideoStripController.f15609a);
                }
                GLFrameRetriever a2 = this.f15597c.f15616h.m19672a(this.f15597c.f15611c, null, a.m19780a(), this.f15597c.f15624p);
                try {
                    BitmapData bitmapData;
                    int size = immutableList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        bitmapData = (BitmapData) immutableList.get(i2);
                        if (!Thread.currentThread().isInterrupted()) {
                            VideoStripController.m19582b(a2, this.f15597c.f15614f, bitmapData.f15598a, this.f15597c.f15622n, this.f15597c.f15628t, this.f15597c.f15629u, bitmapData.f15600c);
                            bitmapData.m19573a();
                            VideoStripController.m19585f(this.f15597c);
                            i2++;
                        } else {
                            return;
                        }
                    }
                    i2 = immutableList2.size();
                    while (i < i2) {
                        bitmapData = (BitmapData) immutableList2.get(i);
                        if (Thread.currentThread().isInterrupted()) {
                            a2.m19671a();
                            return;
                        }
                        VideoStripController.m19582b(a2, this.f15597c.f15614f, bitmapData.f15598a, this.f15597c.f15622n, this.f15597c.f15628t, this.f15597c.f15629u, bitmapData.f15600c);
                        bitmapData.m19573a();
                        if (this.f15597c.f15625q != null && this.f15597c.f15625q.m19600b()) {
                            VideoStripController.m19585f(this.f15597c);
                        }
                        i++;
                    }
                    VideoStripController.m19585f(this.f15597c);
                    a2.m19671a();
                } finally {
                    a2.m19671a();
                }
            }
        });
    }

    private static CloseableReference<Bitmap> m19577a(GLFrameRetriever gLFrameRetriever, int i, float f) {
        int i2 = 0;
        while (i2 < 2) {
            try {
                CloseableReference<Bitmap> a = gLFrameRetriever.m19670a(i, f);
                if (a != null && a.a() != null) {
                    return a;
                }
                i2++;
            } catch (Throwable e) {
                BLog.b("VideoStripController", "Unable to extract frame", e);
                return null;
            }
        }
        return null;
    }

    private static void m19582b(GLFrameRetriever gLFrameRetriever, PlatformBitmapFactory platformBitmapFactory, long j, float f, int i, int i2, String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                CloseableReference a = m19577a(gLFrameRetriever, (int) j, f);
                if (a != null && a.a() != null) {
                    Bitmap bitmap = (Bitmap) a.a();
                    float width = ((float) i) / ((float) bitmap.getWidth());
                    Matrix matrix = new Matrix();
                    matrix.setScale(width, width);
                    CloseableReference a2 = platformBitmapFactory.a(i, i2, Config.RGB_565);
                    Bitmap bitmap2 = (Bitmap) a2.a();
                    new Canvas(bitmap2).drawBitmap(bitmap, matrix, null);
                    File file2 = new File(str + ".tmp");
                    OutputStream fileOutputStream = new FileOutputStream(file2);
                    bitmap2.compress(CompressFormat.JPEG, 50, fileOutputStream);
                    fileOutputStream.close();
                    file2.renameTo(file);
                    a.close();
                    a2.close();
                }
            } catch (Throwable e) {
                BLog.b("VideoStripController", "No video file found at given location", e);
            } catch (Throwable e2) {
                BLog.b("VideoStripController", "Ran into a problem extracting thumbnail", e2);
            }
        }
    }
}
