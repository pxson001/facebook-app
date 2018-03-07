package com.facebook.feedplugins.musicpreview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: composer_write_inline_sprout */
public class MusicButton extends ImageButton {
    private static final int f8038a = 2130840510;
    private static final int f8039b = 2130840511;
    private PlayingStatus f8040c = PlayingStatus.STOPPED;
    private Paint f8041d;
    private float f8042e = 0.0f;
    private float f8043f = 0.0f;
    private float f8044g = 0.0f;
    private RectF f8045h;
    public ProgressBar f8046i;

    /* compiled from: composer_write_inline_sprout */
    class C10101 implements OnGlobalLayoutListener {
        final /* synthetic */ MusicButton f8037a;

        C10101(MusicButton musicButton) {
            this.f8037a = musicButton;
        }

        public void onGlobalLayout() {
            ViewGroup viewGroup = (ViewGroup) this.f8037a.f8046i.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f8037a.f8046i);
            }
            ((ViewGroup) this.f8037a.getParent()).addView(this.f8037a.f8046i);
            if (VERSION.SDK_INT < 16) {
                this.f8037a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.f8037a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: composer_write_inline_sprout */
    enum PlayingStatus {
        PLAYING,
        PAUSED,
        STOPPED,
        BUFFERING
    }

    public MusicButton(Context context) {
        super(context);
        m9090a();
    }

    public MusicButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9090a();
    }

    public MusicButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9090a();
    }

    private void m9090a() {
        this.f8041d = new Paint();
        this.f8041d.setAntiAlias(true);
        setBackgroundResource(0);
        setScaleType(ScaleType.FIT_XY);
        setImageResource(f8039b);
        this.f8046i = new ProgressBar(getContext());
        this.f8046i.setVisibility(8);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f8046i.setLayoutParams(layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(new C10101(this));
    }

    public void setPlayingStatus(PlayingStatus playingStatus) {
        this.f8040c = playingStatus;
        if (this.f8040c == PlayingStatus.PLAYING) {
            setImageResource(f8038a);
            this.f8046i.setVisibility(8);
        } else if (this.f8040c == PlayingStatus.BUFFERING) {
            setImageResource(0);
            this.f8046i.setVisibility(0);
        } else {
            setImageResource(f8039b);
            this.f8046i.setVisibility(8);
        }
        invalidate();
    }

    public PlayingStatus getPlayingStatus() {
        return this.f8040c;
    }

    public void setProgress(float f) {
        this.f8042e = f;
        invalidate();
    }

    public float getProgress() {
        return this.f8042e;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1606138419);
        super.onSizeChanged(i, i, i3, i4);
        this.f8043f = ((float) i) / 2.0f;
        this.f8044g = this.f8043f * 0.1f;
        int width = (int) (((double) getWidth()) * 0.28d);
        setPadding(width, width, width, width);
        this.f8045h = new RectF(this.f8044g / 2.0f, this.f8044g / 2.0f, (this.f8043f * 2.0f) - (this.f8044g / 2.0f), (this.f8043f * 2.0f) - (this.f8044g / 2.0f));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -751432003, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1267042937);
        float x = motionEvent.getX();
        boolean onTouchEvent = ((float) Math.sqrt(Math.pow((double) Math.abs(motionEvent.getY() - this.f8043f), 2.0d) + Math.pow((double) Math.abs(x - this.f8043f), 2.0d))) <= this.f8043f ? super.onTouchEvent(motionEvent) : false;
        LogUtils.a(-1952676857, a);
        return onTouchEvent;
    }

    protected void onDraw(Canvas canvas) {
        m9091a(canvas);
        m9092b(canvas);
        super.onDraw(canvas);
    }

    private void m9091a(Canvas canvas) {
        this.f8041d.setColor(getResources().getColor(2131363073));
        this.f8041d.setStyle(Style.FILL);
        this.f8041d.setStrokeWidth(this.f8044g);
        canvas.drawCircle(this.f8043f, this.f8043f, this.f8043f - this.f8044g, this.f8041d);
    }

    private void m9092b(Canvas canvas) {
        float f = (this.f8040c == PlayingStatus.STOPPED ? 0.0f : this.f8042e) * 360.0f;
        this.f8041d.setColor(getResources().getColor(2131363074));
        this.f8041d.setStyle(Style.STROKE);
        this.f8041d.setStrokeWidth(this.f8044g);
        canvas.drawArc(this.f8045h, -90.0f, f, false, this.f8041d);
    }
}
