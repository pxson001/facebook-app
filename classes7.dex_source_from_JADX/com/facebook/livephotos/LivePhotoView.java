package com.facebook.livephotos;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.inject.FbInjector;
import com.facebook.livephotos.analytics.LivePhotosAnalytics;
import com.facebook.livephotos.downloader.LivePhotosPrefetcher;
import com.facebook.livephotos.downloader.LivePhotosPrefetcher.C06061;
import com.facebook.livephotos.downloader.LivePhotosPrefetcher.C06072;
import com.facebook.livephotos.downloader.LivePhotosPrefetcher.C06083;
import com.facebook.livephotos.player.LivePhotoVideoPlayer;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: phone_text */
public class LivePhotoView extends FrameLayout implements Callback, LivePhotoGestureListener, OnPlaybackStateChanged {
    public static final String f6598e = LivePhotoView.class.getSimpleName();
    public static final CallerContext f6599f = CallerContext.a(LivePhotoView.class);
    @Inject
    public FbDraweeControllerBuilder f6600a;
    @Inject
    public LivePhotosPrefetcher f6601b;
    @Inject
    public LivePhotosAnalytics f6602c;
    @Inject
    public LivePhotosConfig f6603d;
    public LivePhotoVideoPlayer f6604g;
    public SurfaceView f6605h;
    public FbDraweeView f6606i;
    private PlaybackState f6607j = PlaybackState.IDLE;
    public Handler f6608k;
    public LivePhotoViewGestureDetector f6609l;
    private OnPlaybackStateChanged f6610m;
    private boolean f6611n;
    private boolean f6612o;
    private ListenableFuture<String> f6613p;
    private String f6614q;
    public String f6615r;
    private Uri f6616s;
    public ImageView f6617t;
    private boolean f6618u;
    private boolean f6619v;
    private long f6620w;

    /* compiled from: phone_text */
    public enum PlaybackState {
        IDLE,
        PREPARING,
        PLAYING
    }

    /* compiled from: phone_text */
    class VideoReadyCallback implements FutureCallback<String> {
        private Message f6597a;

        public void onSuccess(@Nullable Object obj) {
            String str = (String) obj;
            String str2 = LivePhotoView.f6598e;
            this.f6597a.obj = str;
            this.f6597a.sendToTarget();
        }

        public VideoReadyCallback(Message message) {
            this.f6597a = message;
        }

        public void onFailure(Throwable th) {
            BLog.b(LivePhotoView.f6598e, "Failed to prepare video", th);
        }
    }

    public static void m8528a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LivePhotoView livePhotoView = (LivePhotoView) obj;
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        LivePhotosPrefetcher a = LivePhotosPrefetcher.m8556a(fbInjector);
        LivePhotosAnalytics a2 = LivePhotosAnalytics.m8548a(fbInjector);
        LivePhotosConfig a3 = LivePhotosConfig.m8542a(fbInjector);
        livePhotoView.f6600a = b;
        livePhotoView.f6601b = a;
        livePhotoView.f6602c = a2;
        livePhotoView.f6603d = a3;
    }

    public LivePhotoView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130905104, this, true);
        Class cls = LivePhotoView.class;
        m8528a((Object) this, getContext());
        this.f6606i = (FbDraweeView) findViewById(2131561583);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.d = 0;
        GenericDraweeHierarchy u = genericDraweeHierarchyBuilder.e(ScaleType.g).u();
        this.f6617t = (ImageView) findViewById(2131563530);
        this.f6606i.setHierarchy(u);
        this.f6608k = new Handler(this);
        this.f6604g = new LivePhotoVideoPlayer(getContext(), this.f6608k, this);
        this.f6609l = new LivePhotoViewGestureDetector(context, this);
        if (null != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.LivePhotoView);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Preconditions.checkNotNull(string);
                if (!string.equals(this.f6615r)) {
                    this.f6606i.setController(((FbDraweeControllerBuilder) this.f6600a.a(f6599f).a(string).b(this.f6606i.getController())).s());
                }
            }
            string = obtainStyledAttributes.getString(1);
            if (string != null) {
                setVideoUri(string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setListener(OnPlaybackStateChanged onPlaybackStateChanged) {
        this.f6610m = onPlaybackStateChanged;
    }

    private void m8529a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void mo360a() {
        this.f6612o = true;
        m8535h();
    }

    public final void mo361a(long j) {
        this.f6612o = false;
        this.f6620w = j;
        if (this.f6607j == PlaybackState.PLAYING) {
            m8533e();
            return;
        }
        m8536i();
        m8534g();
    }

    public void setIsLivePhoto(boolean z) {
        int i = 0;
        this.f6619v = z;
        if (this.f6618u != z) {
            this.f6618u = z;
            if (!z) {
                super.setLongClickable(false);
            }
            if (this.f6611n) {
                m8530a(!z, false);
                return;
            }
            ImageView imageView = this.f6617t;
            if (!z) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    private void m8531c() {
        if (this.f6619v) {
            this.f6619v = false;
            m8530a(true, true);
        }
    }

    private void m8532d() {
        if (!this.f6619v) {
            this.f6619v = true;
            m8530a(false, true);
        }
    }

    private void m8530a(boolean z, boolean z2) {
        float f;
        float f2 = 0.3f;
        float f3 = 0.0f;
        if (z) {
            f = 1.0f;
        } else {
            f = 0.3f;
            f2 = 1.0f;
        }
        this.f6617t.setVisibility(0);
        this.f6617t.setScaleX(f);
        this.f6617t.setScaleY(f);
        this.f6617t.setAlpha(z ? 1.0f : 0.0f);
        ViewPropertyAnimator scaleY = this.f6617t.animate().scaleX(f2).scaleY(f2);
        if (!z) {
            f3 = 1.0f;
        }
        scaleY.alpha(f3).setDuration(z2 ? 100 : 500).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void m8533e() {
        m8529a(false);
        LivePhotoVideoPlayer livePhotoVideoPlayer = this.f6604g;
        if (!(livePhotoVideoPlayer.f7763g == null || livePhotoVideoPlayer.f7764h == null)) {
            livePhotoVideoPlayer.f7763g.m8576a(livePhotoVideoPlayer.f7764h, 1, null);
        }
        this.f6606i.setAlpha(0.0f);
        this.f6606i.animate().alpha(1.0f).setDuration(500 / 2).setStartDelay(500 / 2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -818613573);
        LivePhotoViewGestureDetector livePhotoViewGestureDetector = this.f6609l;
        boolean z = false;
        switch (motionEvent.getAction()) {
            case 0:
                if (!(livePhotoViewGestureDetector.f6626f || motionEvent.getPointerCount() == 0 || motionEvent.getPointerId(0) != 0)) {
                    livePhotoViewGestureDetector.f6621a = (int) motionEvent.getX();
                    livePhotoViewGestureDetector.f6622b = (int) motionEvent.getY();
                    livePhotoViewGestureDetector.f6623c.sendEmptyMessageDelayed(1, LivePhotosConst.f6631a);
                    break;
                }
            case 1:
            case 3:
                livePhotoViewGestureDetector.f6623c.removeMessages(1);
                if (livePhotoViewGestureDetector.f6626f) {
                    livePhotoViewGestureDetector.f6626f = false;
                    livePhotoViewGestureDetector.f6625e.mo361a(LivePhotoViewGestureDetector.m8541a() - livePhotoViewGestureDetector.f6627g);
                    z = true;
                    break;
                }
                break;
            case 2:
                if (!livePhotoViewGestureDetector.f6626f) {
                    int x = ((int) motionEvent.getX()) - livePhotoViewGestureDetector.f6621a;
                    int y = ((int) motionEvent.getY()) - livePhotoViewGestureDetector.f6622b;
                    if ((x * x) + (y * y) > livePhotoViewGestureDetector.f6624d) {
                        livePhotoViewGestureDetector.f6626f = false;
                        livePhotoViewGestureDetector.f6623c.removeMessages(1);
                        break;
                    }
                }
                SystemClock.sleep(1);
                z = true;
                break;
                break;
        }
        boolean z2 = z || super.onTouchEvent(motionEvent);
        LogUtils.a(-1422976586, a);
        return z2;
    }

    public void setVideoUri(String str) {
        boolean z = true;
        if (this.f6603d.f6630a && VERSION.SDK_INT >= 21) {
            boolean z2 = str == null && this.f6614q != null;
            if (str == null || str.equals(this.f6614q)) {
                z = false;
            }
            if (z2 || r0) {
                this.f6614q = str;
                this.f6616s = null;
                if (str != null) {
                    m8537j();
                } else {
                    setIsLivePhoto(false);
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2056651948);
        super.onAttachedToWindow();
        this.f6611n = true;
        m8537j();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 237365324, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -470102421);
        m8536i();
        super.onDetachedFromWindow();
        this.f6611n = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 660790521, a);
    }

    private void m8534g() {
        if (this.f6605h != null) {
            removeView(this.f6605h);
            this.f6605h = null;
        }
    }

    private void m8535h() {
        boolean z = false;
        boolean z2 = this.f6607j == PlaybackState.IDLE;
        if (this.f6616s != null) {
            z = true;
        }
        if (z2 && r2 && this.f6612o) {
            m8529a(true);
            this.f6605h = new SurfaceView(getContext());
            this.f6605h.getHolder().addCallback(this.f6604g);
            addView(this.f6605h, 0);
            this.f6604g.m9383a(this.f6616s);
        }
    }

    private void m8536i() {
        if (this.f6607j != PlaybackState.IDLE) {
            this.f6604g.m9385b();
            m8534g();
        }
    }

    public final void mo362a(PlaybackState playbackState) {
        new StringBuilder("onPlaybackStateChanged - ").append(playbackState);
        this.f6607j = playbackState;
        switch (playbackState) {
            case IDLE:
                m8534g();
                LivePhotosAnalytics livePhotosAnalytics = this.f6602c;
                livePhotosAnalytics.f6634a.a(new HoneyClientEvent("live_photo_view").a("gesture_time_millis", this.f6620w));
                m8532d();
                return;
            case PLAYING:
                if (this.f6612o) {
                    this.f6606i.setAlpha(1.0f);
                    this.f6606i.animate().alpha(0.0f).setDuration(150).start();
                    m8531c();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                setIsLivePhoto(true);
                boolean z = this.f6614q != null && this.f6614q.hashCode() == message.arg1;
                if (this.f6611n && z) {
                    this.f6616s = Uri.parse((String) message.obj);
                    m8535h();
                    break;
                }
                break;
        }
        return true;
    }

    public void setLongClickable(boolean z) {
        if (!this.f6618u) {
            super.setLongClickable(z);
        }
    }

    private void m8537j() {
        if (this.f6611n && this.f6614q != null && this.f6616s == null) {
            ListenableFuture b;
            LivePhotosPrefetcher livePhotosPrefetcher = this.f6601b;
            String str = this.f6614q;
            Boolean.valueOf(false);
            HttpFutureWrapper httpFutureWrapper = (HttpFutureWrapper) livePhotosPrefetcher.f6655f.get(str);
            if (httpFutureWrapper == null || httpFutureWrapper.b.isCancelled()) {
                b = Futures.b(livePhotosPrefetcher.f6652c.a(new C06061(livePhotosPrefetcher, str)), new C06072(livePhotosPrefetcher, str, false), livePhotosPrefetcher.f6652c);
                b.a(new C06083(livePhotosPrefetcher, str), DirectExecutor.INSTANCE);
            } else {
                b = httpFutureWrapper.b;
            }
            this.f6613p = b;
            Futures.a(this.f6613p, new VideoReadyCallback(this.f6608k.obtainMessage(1, this.f6614q.hashCode(), 0)));
        }
    }

    protected void onMeasure(int i, int i2) {
        measureChildWithMargins(this.f6606i, i, 0, i2, 0);
        measureChildWithMargins(this.f6617t, i, 0, i2, 0);
        int max = Math.max(getSuggestedMinimumWidth(), this.f6606i.getMeasuredWidth());
        int max2 = Math.max(getSuggestedMinimumHeight(), this.f6606i.getMeasuredHeight());
        int measuredState = this.f6606i.getMeasuredState();
        setMeasuredDimension(View.resolveSizeAndState(max, i, measuredState), View.resolveSizeAndState(max2, i2, measuredState << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = (((i3 - i) - paddingLeft) - getPaddingRight()) + paddingLeft;
        int paddingBottom = (((i4 - i2) - paddingTop) - getPaddingBottom()) + paddingTop;
        this.f6606i.layout(paddingLeft, paddingTop, paddingRight, paddingBottom);
        if (this.f6605h != null) {
            this.f6605h.layout(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        this.f6617t.layout(paddingRight - this.f6617t.getMeasuredWidth(), paddingBottom - this.f6617t.getMeasuredHeight(), paddingRight, paddingBottom);
    }
}
