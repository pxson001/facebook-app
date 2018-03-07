package com.facebook.videocodec.common;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.VideoView;
import com.facebook.videocodec.trimming.VideoPreviewFragment.C14701;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.CustomViewUtils;

/* compiled from: com.google.android.gms.maps.internal.IOnPoiClickListener */
public abstract class VideoPreviewView extends CustomViewGroup {
    private static final Class<?> f19697d = VideoPreviewView.class;
    public VideoView f19698a;
    public ImageView f19699b;
    public C14701 f19700c;
    private int f19701e = -1;
    private int f19702f = -1;
    public PlaybackState f19703g = PlaybackState.INIT;

    /* compiled from: com.google.android.gms.maps.internal.IOnPoiClickListener */
    public enum PlaybackState {
        INIT,
        PREPARING,
        PAUSED,
        PLAYING,
        ERROR
    }

    public VideoPreviewView(Context context) {
        super(context);
        m28408f();
    }

    public VideoPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28408f();
    }

    public VideoPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28408f();
    }

    private void m28408f() {
        setContentView(2130907699);
        this.f19698a = (VideoView) getView(2131559900);
        this.f19699b = (ImageView) getView(2131562409);
    }

    public final void m28410a(int i, int i2) {
        this.f19701e = i;
        this.f19702f = i2;
        requestLayout();
    }

    public int getCurrentPosition() {
        return this.f19698a.getCurrentPosition();
    }

    public final void m28409a(int i) {
        if (VERSION.SDK_INT >= 21 && this.f19703g == PlaybackState.PAUSED) {
            this.f19698a.start();
            this.f19698a.seekTo(i);
            this.f19698a.pause();
            CustomViewUtils.b(this.f19698a, null);
        } else if (this.f19703g == PlaybackState.PAUSED || this.f19703g == PlaybackState.PLAYING) {
            this.f19698a.seekTo(i);
            CustomViewUtils.b(this.f19698a, null);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f19701e == -1 || this.f19702f == -1) {
            super.onMeasure(i, i2);
            return;
        }
        int size = MeasureSpec.getSize(i);
        int paddingLeft = size - (getPaddingLeft() + getPaddingRight());
        size = MeasureSpec.getSize(i2) - (getPaddingTop() + getPaddingBottom());
        float f = ((float) this.f19701e) / ((float) this.f19702f);
        paddingLeft = Math.min(paddingLeft, this.f19701e * 2);
        int i3 = (int) (((float) paddingLeft) / f);
        if (i3 > size) {
            i3 = (int) (((float) size) * f);
        } else {
            size = i3;
            i3 = paddingLeft;
        }
        setMeasuredDimension(View.resolveSize(i3, i), View.resolveSize(size, i2));
        paddingLeft = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(size, 1073741824);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, paddingLeft, 0, makeMeasureSpec, 0);
            }
        }
    }

    public final void m28412b() {
        if (this.f19703g == PlaybackState.PAUSED) {
            m28407b(PlaybackState.PLAYING);
        }
    }

    public final void m28413c() {
        if (this.f19703g == PlaybackState.PLAYING) {
            m28407b(PlaybackState.PAUSED);
        }
    }

    private void m28407b(PlaybackState playbackState) {
        if (playbackState != this.f19703g) {
            if (this.f19703g != PlaybackState.PAUSED && this.f19703g != PlaybackState.PLAYING) {
                return;
            }
            if (playbackState == PlaybackState.PAUSED) {
                if (this.f19699b.isEnabled()) {
                    this.f19699b.setVisibility(0);
                }
                this.f19698a.pause();
                m28411a(PlaybackState.PAUSED);
            } else if (playbackState == PlaybackState.PLAYING) {
                this.f19699b.setVisibility(4);
                this.f19698a.start();
                m28411a(PlaybackState.PLAYING);
            }
        }
    }

    public final void m28411a(PlaybackState playbackState) {
        this.f19703g = playbackState;
        if (this.f19700c != null) {
            this.f19700c.m28420c();
        }
        if (playbackState == PlaybackState.ERROR) {
            CustomViewUtils.b(this.f19698a, new ColorDrawable(-16777216));
        } else {
            CustomViewUtils.b(this.f19698a, null);
        }
    }
}
