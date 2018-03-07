package com.facebook.video.creativeediting;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSource.VideoMirroringMode;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.plugins.OverlayImagePlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;

/* compiled from: easeOut */
public class VideoEditGalleryVideoPreviewView extends CustomViewGroup {
    public LinearLayout f15458a;
    private GlyphView f15459b;
    private FbTextView f15460c;
    private RichVideoPlayer f15461d;
    private Matrix f15462e;
    public Listener f15463f;
    public VideoEditGalleryTrimmerFilmstripView f15464g;
    public ImageView f15465h;
    public Uri f15466i;
    @Nullable
    public Uri f15467j;
    private int f15468k;
    private int f15469l;
    public int f15470m;
    private final float[] f15471n;
    public boolean f15472o;
    public boolean f15473p;
    public boolean f15474q;
    public boolean f15475r;

    /* compiled from: easeOut */
    public interface Listener {
        void mo1195a(int i);

        void mo1196a(boolean z);

        void mo1197b(boolean z);
    }

    /* compiled from: easeOut */
    class C11751 implements OnClickListener {
        final /* synthetic */ VideoEditGalleryVideoPreviewView f15455a;

        C11751(VideoEditGalleryVideoPreviewView videoEditGalleryVideoPreviewView) {
            this.f15455a = videoEditGalleryVideoPreviewView;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -649486287);
            VideoEditGalleryVideoPreviewView videoEditGalleryVideoPreviewView = this.f15455a;
            if (this.f15455a.f15472o) {
                z = false;
            } else {
                z = true;
            }
            videoEditGalleryVideoPreviewView.f15472o = z;
            this.f15455a.f15470m;
            this.f15455a.f15463f.mo1196a(this.f15455a.f15472o);
            LogUtils.a(225236108, a);
        }
    }

    /* compiled from: easeOut */
    class C11762 implements OnClickListener {
        final /* synthetic */ VideoEditGalleryVideoPreviewView f15456a;

        C11762(VideoEditGalleryVideoPreviewView videoEditGalleryVideoPreviewView) {
            this.f15456a = videoEditGalleryVideoPreviewView;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -855225507);
            VideoEditGalleryVideoPreviewView videoEditGalleryVideoPreviewView = this.f15456a;
            if (this.f15456a.f15473p) {
                z = false;
            } else {
                z = true;
            }
            videoEditGalleryVideoPreviewView.f15473p = z;
            if (this.f15456a.f15473p) {
                this.f15456a.f15465h.setVisibility(0);
            }
            this.f15456a.f15463f.mo1197b(this.f15456a.f15473p);
            LogUtils.a(-1242577420, a);
        }
    }

    /* compiled from: easeOut */
    class C11773 implements AnimatorListener {
        final /* synthetic */ VideoEditGalleryVideoPreviewView f15457a;

        C11773(VideoEditGalleryVideoPreviewView videoEditGalleryVideoPreviewView) {
            this.f15457a = videoEditGalleryVideoPreviewView;
        }

        public void onAnimationStart(Animator animator) {
            this.f15457a.f15458a.setVisibility(8);
        }

        public void onAnimationEnd(Animator animator) {
            this.f15457a.f15458a.setVisibility(0);
            this.f15457a.f15463f.mo1195a((this.f15457a.f15470m + 360) % 360);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public VideoEditGalleryVideoPreviewView(Context context) {
        super(context);
        this.f15471n = new float[2];
        this.f15472o = false;
        this.f15473p = false;
        this.f15474q = false;
        this.f15475r = false;
        m19493f();
    }

    public VideoEditGalleryVideoPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15471n = new float[2];
        this.f15472o = false;
        this.f15473p = false;
        this.f15474q = false;
        this.f15475r = false;
        m19493f();
    }

    public VideoEditGalleryVideoPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15471n = new float[2];
        this.f15472o = false;
        this.f15473p = false;
        this.f15474q = false;
        this.f15475r = false;
        m19493f();
    }

    private void m19493f() {
        setContentView(2130907669);
        this.f15461d = (RichVideoPlayer) getView(2131560290);
        this.f15461d.a(new VideoPlugin(getContext()));
        this.f15461d.a(new OverlayImagePlugin(getContext()));
        this.f15458a = (LinearLayout) getView(2131568324);
        this.f15459b = (GlyphView) getView(2131568325);
        this.f15460c = (FbTextView) getView(2131568326);
        this.f15465h = (ImageView) getView(2131563867);
        this.f15458a.setVisibility(4);
        this.f15465h.setVisibility(4);
        this.f15470m = 0;
        this.f15462e = new Matrix();
        this.f15458a.setOnClickListener(new C11751(this));
        this.f15461d.setOnClickListener(new C11762(this));
    }

    public void setFilmstrip(VideoEditGalleryTrimmerFilmstripView videoEditGalleryTrimmerFilmstripView) {
        this.f15464g = videoEditGalleryTrimmerFilmstripView;
    }

    public static void m19495g(VideoEditGalleryVideoPreviewView videoEditGalleryVideoPreviewView) {
        if (videoEditGalleryVideoPreviewView.f15472o) {
            videoEditGalleryVideoPreviewView.f15461d.a(true, EventTriggerType.BY_USER);
            videoEditGalleryVideoPreviewView.f15459b.setImageDrawable(videoEditGalleryVideoPreviewView.getResources().getDrawable(2130840151));
            videoEditGalleryVideoPreviewView.f15460c.setText(videoEditGalleryVideoPreviewView.getResources().getString(2131234513));
            return;
        }
        videoEditGalleryVideoPreviewView.f15461d.a(false, EventTriggerType.BY_USER);
        videoEditGalleryVideoPreviewView.f15459b.setImageDrawable(videoEditGalleryVideoPreviewView.getResources().getDrawable(2130840150));
        videoEditGalleryVideoPreviewView.f15460c.setText(videoEditGalleryVideoPreviewView.getResources().getString(2131234512));
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        float viewAspectRatio = getViewAspectRatio();
        if (((float) size) / viewAspectRatio < ((float) size2)) {
            size2 = (int) (((float) size) / viewAspectRatio);
        } else {
            size = (int) (((float) size2) * viewAspectRatio);
        }
        if (this.f15470m % 180 == 0) {
            int i3 = size2;
            size2 = size;
            size = i3;
        }
        setMeasuredDimension(View.resolveSize(size2, i), View.resolveSize(size, i2));
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, 1073741824);
        size = MeasureSpec.makeMeasureSpec(size, 1073741824);
        for (size2 = 0; size2 < getChildCount(); size2++) {
            View childAt = getChildAt(size2);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, makeMeasureSpec, size);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        super.onLayout(z, i, i2, i3, i4);
        this.f15471n[0] = this.f15461d.getX();
        this.f15471n[1] = this.f15461d.getY();
        this.f15462e.reset();
        this.f15462e.postRotate((float) this.f15470m, this.f15461d.getX() + ((float) (this.f15461d.getWidth() / 2)), this.f15461d.getY() + ((float) (this.f15461d.getHeight() / 2)));
        this.f15462e.mapPoints(this.f15471n);
        if (this.f15470m == -90) {
            f = this.f15471n[0];
            f2 = this.f15471n[1];
        } else if (this.f15470m == -270) {
            f = this.f15471n[0] - ((float) this.f15461d.getHeight());
            f2 = this.f15471n[1] + ((float) this.f15461d.getWidth());
        } else {
            f = this.f15461d.getX();
            f2 = this.f15461d.getY() + ((float) this.f15461d.getHeight());
        }
        float dimension = getResources().getDimension(2131429584);
        this.f15458a.setX(f + dimension);
        this.f15458a.setY((f2 - ((float) this.f15458a.getHeight())) - dimension);
        if (this.f15464g != null) {
            this.f15464g.setY(f2 + ((float) getResources().getDimensionPixelSize(2131429608)));
        }
    }

    public final void m19496a() {
        VideoMirroringMode videoMirroringMode;
        this.f15461d.setPlayerOrigin(PlayerOrigin.VIDEO_EDITING_GALLERY);
        this.f15461d.setShouldCropToFit(this.f15474q);
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = this.f15466i;
        newBuilder = newBuilder;
        newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
        if (this.f15475r) {
            videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
        } else {
            videoMirroringMode = VideoMirroringMode.NONE;
        }
        videoDataSourceBuilder.h = videoMirroringMode;
        VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(videoDataSourceBuilder.i());
        a.r = true;
        a = a;
        a.g = false;
        a = a;
        a.n = false;
        a = a;
        Builder builder = new Builder();
        builder.a = a.m();
        builder.a("VideoAspectRatioKey", Double.valueOf((double) getOriginalVideoAspectRatio()));
        if (this.f15467j != null) {
            builder.a("OverlayImageParamsKey", this.f15467j);
        }
        this.f15461d.a(builder.b());
        this.f15458a.setVisibility(0);
        this.f15470m;
    }

    public void setVideoUri(Uri uri) {
        this.f15466i = uri;
    }

    public void setOverlayImageUri(@Nullable Uri uri) {
        this.f15467j = uri;
    }

    public final void m19498a(int i, int i2) {
        this.f15468k = i;
        this.f15469l = i2;
        requestLayout();
    }

    public void setListener(Listener listener) {
        this.f15463f = listener;
    }

    public void setVideoMuted(boolean z) {
        this.f15472o = z;
        this.f15470m;
    }

    public void setShouldCenterSquareCrop(boolean z) {
        this.f15474q = z;
    }

    public void setShouldFlipHorizontally(boolean z) {
        this.f15475r = z;
    }

    public void setRotationAngle(int i) {
        if (i != 0) {
            if (i > 0) {
                i = (i - 360) % 360;
            }
            m19486b(i);
        }
    }

    public final void m19499b() {
        m19486b(this.f15470m - 90);
    }

    private void m19486b(int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15461d, "rotation", new float[]{(float) this.f15470m, (float) i});
        ofFloat.setDuration(100);
        ofFloat.addListener(new C11773(this));
        if (i <= -360) {
            i = 0;
        }
        this.f15470m = i;
        ofFloat.start();
    }

    public final void m19500c() {
        this.f15473p = false;
        this.f15465h.setVisibility(4);
        if (!this.f15461d.u.l.isPlayingState()) {
            this.f15461d.a(EventTriggerType.BY_PLAYER);
        }
    }

    public final void m19497a(int i) {
        this.f15461d.a(i, EventTriggerType.BY_USER);
    }

    public final void m19501d() {
        if (this.f15461d.u.l.isPlayingState()) {
            this.f15461d.b(EventTriggerType.BY_USER);
        }
    }

    public int getCurrentPositionMs() {
        if (this.f15461d.p()) {
            return this.f15461d.getVideoDurationMs();
        }
        if (this.f15461d.m()) {
            return this.f15461d.getCurrentPositionMs();
        }
        return this.f15461d.getLastStartPosition();
    }

    public final boolean m19502e() {
        return this.f15461d.p();
    }

    public int getVideoDurationMs() {
        return this.f15461d.getVideoDurationMs();
    }

    private int getVideoWidth() {
        return this.f15470m % 180 == 0 ? this.f15468k : this.f15469l;
    }

    private int getVideoHeight() {
        return this.f15470m % 180 == 0 ? this.f15469l : this.f15468k;
    }

    private float getViewAspectRatio() {
        return this.f15474q ? 1.0f : getViewAspectRatioAfterRotation();
    }

    private float getViewAspectRatioAfterRotation() {
        return ((float) getVideoWidth()) / ((float) getVideoHeight());
    }

    private float getOriginalVideoAspectRatio() {
        return ((float) this.f15468k) / ((float) this.f15469l);
    }
}
