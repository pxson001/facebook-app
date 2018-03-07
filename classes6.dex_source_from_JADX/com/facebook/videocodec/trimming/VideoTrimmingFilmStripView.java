package com.facebook.videocodec.trimming;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.facebook.common.util.MathUtil;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.common.VideoTrimmingFilmStripClipsLayout;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
public class VideoTrimmingFilmStripView extends CustomRelativeLayout {
    private static final Class<?> f19739a = VideoTrimmingFilmStripView.class;
    private ImageView f19740b;
    private ImageView f19741c;
    private ImageView f19742d;
    private VideoTrimmingFilmStripClipsLayout f19743e;
    private VideoTrimmingSelectionMaskView f19744f;
    private VideoTrimmingSelectionMaskView f19745g;
    private List<ImageView> f19746h;
    public GestureDetectorCompat f19747i;
    private int f19748j;
    private int f19749k;
    private int f19750l;
    private int f19751m;
    private int f19752n;
    private int f19753o = -1;
    private int f19754p;
    private int f19755q;
    private int f19756r;
    private int f19757s;
    private Handle f19758t;
    private View f19759u;
    private ScrollInfo f19760v;
    public int f19761w = -1;
    public int f19762x = -2;
    public int f19763y;
    public Listener f19764z;

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
    public interface Listener {
        void mo1495a(int i);

        void mo1496a(int i, int i2);

        void mo1497a(Handle handle);

        void mo1498b(Handle handle);
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
    class C14781 extends SimpleOnGestureListener {
        final /* synthetic */ VideoTrimmingFilmStripView f19732a;

        C14781(VideoTrimmingFilmStripView videoTrimmingFilmStripView) {
            this.f19732a = videoTrimmingFilmStripView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return this.f19732a.m28488a(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.f19732a.m28487a(f);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
    class C14792 implements OnTouchListener {
        final /* synthetic */ VideoTrimmingFilmStripView f19733a;

        C14792(VideoTrimmingFilmStripView videoTrimmingFilmStripView) {
            this.f19733a = videoTrimmingFilmStripView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    this.f19733a.m28483a();
                    break;
            }
            return this.f19733a.f19747i.a(motionEvent);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
    public enum Handle {
        LEFT_TRIM,
        RIGHT_TRIM,
        SCRUBBER
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C14801();
        final int f19734a;
        final int f19735b;
        final int f19736c;

        /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
        final class C14801 implements Creator<SavedState> {
            C14801() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.f19734a = i;
            this.f19735b = i2;
            this.f19736c = i3;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f19734a = parcel.readInt();
            this.f19735b = parcel.readInt();
            this.f19736c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f19734a);
            parcel.writeInt(this.f19735b);
            parcel.writeInt(this.f19736c);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMarkerClickListener */
    class ScrollInfo {
        final int f19737a;
        float f19738b;

        public ScrollInfo(int i) {
            this.f19737a = i;
        }
    }

    public VideoTrimmingFilmStripView(Context context) {
        super(context);
        m28484a(context);
    }

    public VideoTrimmingFilmStripView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28484a(context);
    }

    public VideoTrimmingFilmStripView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28484a(context);
    }

    private void m28484a(Context context) {
        setContentView(2130907703);
        this.f19746h = Lists.a();
        this.f19740b = (ImageView) a(2131568319);
        this.f19741c = (ImageView) a(2131568320);
        this.f19742d = (ImageView) a(2131568403);
        this.f19743e = (VideoTrimmingFilmStripClipsLayout) a(2131568400);
        this.f19744f = (VideoTrimmingSelectionMaskView) a(2131568401);
        this.f19745g = (VideoTrimmingSelectionMaskView) a(2131568402);
        this.f19746h.add(this.f19740b);
        this.f19746h.add(this.f19741c);
        this.f19746h.add(this.f19742d);
        Resources resources = getResources();
        this.f19748j = resources.getDimensionPixelOffset(2131428332);
        this.f19749k = resources.getDimensionPixelOffset(2131428333);
        this.f19747i = new GestureDetectorCompat(context, new C14781(this));
        setOnTouchListener(new C14792(this));
        setWillNotDraw(false);
        this.f19744f.setSelectedColor(0);
        this.f19744f.setUnselectedColor(resources.getColor(2131362654));
        this.f19745g.setSelectedColor(resources.getColor(2131362652));
        this.f19745g.setUnselectedColor(resources.getColor(2131362653));
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f19761w, this.f19762x, this.f19763y);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f19761w = savedState.f19734a;
        this.f19762x = savedState.f19735b;
        this.f19763y = savedState.f19736c;
    }

    void setListener(Listener listener) {
        this.f19764z = listener;
    }

    int getStartTimeMs() {
        return this.f19761w;
    }

    int getEndTimeMs() {
        return this.f19762x;
    }

    int getVideoDurationMs() {
        return this.f19752n;
    }

    void setVideoMetaData(VideoMetadata videoMetadata) {
        this.f19750l = videoMetadata.f5481b;
        this.f19751m = videoMetadata.f5482c;
        this.f19752n = (int) videoMetadata.f5480a;
        if (this.f19761w == -1) {
            this.f19761w = 0;
        } else if (this.f19761w > this.f19752n) {
            this.f19761w = MathUtil.a(this.f19761w, 0, this.f19752n);
        }
        if (this.f19762x == -2) {
            this.f19762x = this.f19752n;
        } else if (this.f19762x > this.f19752n) {
            this.f19762x = MathUtil.a(this.f19762x, this.f19761w, this.f19752n);
        }
        m28486a(false);
        requestLayout();
    }

    public int getFilmStripHeight() {
        return this.f19743e.getHeight();
    }

    void setMaximumDuration(int i) {
        this.f19753o = i * 1000;
        m28486a(false);
        requestLayout();
    }

    private void m28486a(boolean z) {
        int min;
        if (this.f19753o > 0) {
            min = Math.min(this.f19753o, this.f19752n);
            if (this.f19762x - this.f19761w > min) {
                if (z) {
                    this.f19761w = this.f19762x - min;
                } else {
                    this.f19762x = min + this.f19761w;
                }
            }
        }
        min = this.f19762x - this.f19761w;
        if (min >= 1000) {
            return;
        }
        if (z) {
            this.f19761w -= 1000 - min;
            if (this.f19761w < 0) {
                this.f19761w = 0;
                this.f19762x = 1000;
                return;
            }
            return;
        }
        this.f19762x = (1000 - min) + this.f19762x;
        if (this.f19762x > this.f19752n) {
            this.f19762x = this.f19752n;
            this.f19761w = this.f19752n - 1000;
        }
    }

    void setClipTimeMs(int i) {
        if (this.f19763y != i) {
            this.f19763y = MathUtil.a(i, this.f19761w, this.f19762x);
            m28492b();
        }
    }

    int getClipTimeMs() {
        return this.f19763y;
    }

    int getNumPreviewImages() {
        VideoTrimmingFilmStripClipsLayout videoTrimmingFilmStripClipsLayout = this.f19743e;
        return 7;
    }

    final void m28494a(int i, Bitmap bitmap) {
        this.f19743e.m28415a(i, bitmap);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f19752n != 0) {
            this.f19754p = this.f19743e.getWidth();
            this.f19755q = (this.f19743e.getLeft() - this.f19740b.getWidth()) + this.f19748j;
            this.f19756r = (this.f19743e.getRight() + this.f19741c.getWidth()) - this.f19749k;
            this.f19757s = this.f19743e.getLeft() - (this.f19742d.getWidth() / 2);
            m28492b();
            m28493c();
        }
    }

    private boolean m28488a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        for (ImageView imageView : this.f19746h) {
            imageView.getHitRect(rect);
            if (rect.contains(x, y)) {
                int i;
                this.f19759u = imageView;
                if (imageView == this.f19740b) {
                    i = this.f19761w;
                    this.f19758t = Handle.LEFT_TRIM;
                } else if (imageView == this.f19741c) {
                    i = this.f19762x;
                    this.f19758t = Handle.RIGHT_TRIM;
                } else if (imageView == this.f19742d) {
                    i = this.f19763y;
                    this.f19758t = Handle.SCRUBBER;
                } else {
                    i = -1;
                }
                if (i != -1) {
                    this.f19760v = new ScrollInfo(i);
                    this.f19759u.setPressed(true);
                    ViewCompat.a(this, 2, null);
                    if (this.f19764z != null) {
                        this.f19764z.mo1497a(this.f19758t);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m28487a(float f) {
        ScrollInfo scrollInfo;
        if (this.f19758t == Handle.LEFT_TRIM) {
            scrollInfo = this.f19760v;
            scrollInfo.f19738b += -f;
            this.f19761w = (int) (((float) this.f19760v.f19737a) + ((this.f19760v.f19738b / ((float) this.f19754p)) * ((float) this.f19752n)));
            this.f19761w = MathUtil.a(this.f19761w, 0, this.f19762x);
            m28486a(false);
            if (this.f19764z != null) {
                this.f19764z.mo1496a(this.f19761w, this.f19762x);
            }
            m28492b();
            m28493c();
        } else if (this.f19758t == Handle.RIGHT_TRIM) {
            scrollInfo = this.f19760v;
            scrollInfo.f19738b += -f;
            this.f19762x = (int) (((float) this.f19760v.f19737a) + ((this.f19760v.f19738b / ((float) this.f19754p)) * ((float) this.f19752n)));
            this.f19762x = MathUtil.a(this.f19762x, this.f19761w, this.f19752n);
            m28486a(true);
            if (this.f19764z != null) {
                this.f19764z.mo1496a(this.f19761w, this.f19762x);
            }
            m28492b();
            m28493c();
        } else if (this.f19758t == Handle.SCRUBBER) {
            scrollInfo = this.f19760v;
            scrollInfo.f19738b += -f;
            this.f19763y = (int) (((float) this.f19760v.f19737a) + ((this.f19760v.f19738b / ((float) this.f19754p)) * ((float) this.f19752n)));
            this.f19763y = MathUtil.a(this.f19763y, this.f19761w, this.f19762x);
            m28492b();
            if (this.f19764z != null) {
                this.f19764z.mo1495a(this.f19763y);
            }
        }
        return true;
    }

    private void m28483a() {
        if (this.f19759u != null) {
            this.f19759u.setPressed(false);
            this.f19759u = null;
        }
        if (this.f19764z != null) {
            this.f19764z.mo1498b(this.f19758t);
        }
        ViewCompat.a(this, 0, null);
    }

    private void m28492b() {
        if (this.f19752n != 0) {
            this.f19740b.offsetLeftAndRight((this.f19755q + ((this.f19761w * this.f19754p) / this.f19752n)) - this.f19740b.getLeft());
            this.f19741c.offsetLeftAndRight((this.f19756r - (((this.f19752n - this.f19762x) * this.f19754p) / this.f19752n)) - this.f19741c.getRight());
            this.f19742d.offsetLeftAndRight((this.f19757s + ((this.f19763y * this.f19754p) / this.f19752n)) - this.f19742d.getLeft());
        }
    }

    private void m28493c() {
        if (this.f19752n != 0) {
            int width = (this.f19761w * this.f19744f.getWidth()) / this.f19752n;
            int width2 = (this.f19762x * this.f19744f.getWidth()) / this.f19752n;
            this.f19744f.m28510a(width, width2);
            this.f19745g.m28510a(width, width2);
        }
    }
}
