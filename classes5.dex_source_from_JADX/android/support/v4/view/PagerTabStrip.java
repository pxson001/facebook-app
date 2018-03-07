package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: video_campaign */
public class PagerTabStrip extends PagerTitleStrip {
    private int f331f;
    private int f332g;
    private int f333h;
    private int f334i;
    private int f335j;
    private int f336k;
    private final Paint f337l;
    private final Rect f338m;
    private int f339n;
    private boolean f340o;
    private boolean f341p;
    private int f342q;
    private boolean f343r;
    private float f344s;
    private float f345t;
    private int f346u;

    /* compiled from: video_campaign */
    class C00221 implements OnClickListener {
        final /* synthetic */ PagerTabStrip f312a;

        C00221(PagerTabStrip pagerTabStrip) {
            this.f312a = pagerTabStrip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1137814738);
            this.f312a.f317a.setCurrentItem(this.f312a.f317a.k - 1);
            Logger.a(2, EntryType.UI_INPUT_END, -946384917, a);
        }
    }

    /* compiled from: video_campaign */
    class C00232 implements OnClickListener {
        final /* synthetic */ PagerTabStrip f313a;

        C00232(PagerTabStrip pagerTabStrip) {
            this.f313a = pagerTabStrip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1618877517);
            this.f313a.f317a.setCurrentItem(this.f313a.f317a.k + 1);
            Logger.a(2, EntryType.UI_INPUT_END, 59794778, a);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f337l = new Paint();
        this.f338m = new Rect();
        this.f339n = 255;
        this.f340o = false;
        this.f341p = false;
        this.f331f = this.f321e;
        this.f337l.setColor(this.f331f);
        float f = context.getResources().getDisplayMetrics().density;
        this.f332g = (int) ((3.0f * f) + 0.5f);
        this.f333h = (int) ((6.0f * f) + 0.5f);
        this.f334i = (int) (64.0f * f);
        this.f336k = (int) ((16.0f * f) + 0.5f);
        this.f342q = (int) ((1.0f * f) + 0.5f);
        this.f335j = (int) ((f * 32.0f) + 0.5f);
        this.f346u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(this.f324h);
        setWillNotDraw(false);
        this.f318b.setFocusable(true);
        this.f318b.setOnClickListener(new C00221(this));
        this.f320d.setFocusable(true);
        this.f320d.setOnClickListener(new C00232(this));
        if (getBackground() == null) {
            this.f340o = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.f331f = i;
        this.f337l.setColor(this.f331f);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public int getTabIndicatorColor() {
        return this.f331f;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f333h) {
            i4 = this.f333h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.f334i) {
            i = this.f334i;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f341p) {
            this.f340o = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f341p) {
            this.f340o = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.f341p) {
            this.f340o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f340o = z;
        this.f341p = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.f340o;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f335j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1474865299);
        int action = motionEvent.getAction();
        if (action == 0 || !this.f343r) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (action) {
                case 0:
                    this.f344s = x;
                    this.f345t = y;
                    this.f343r = false;
                    break;
                case 1:
                    if (x >= ((float) (this.f319c.getLeft() - this.f336k))) {
                        if (x > ((float) (this.f319c.getRight() + this.f336k))) {
                            this.f317a.setCurrentItem(this.f317a.k + 1);
                            break;
                        }
                    }
                    this.f317a.setCurrentItem(this.f317a.k - 1);
                    break;
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (Math.abs(x - this.f344s) > ((float) this.f346u) || Math.abs(y - this.f345t) > ((float) this.f346u)) {
                        this.f343r = true;
                        break;
                    }
            }
            LogUtils.a(-1980610150, a);
            return true;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1900237771, a);
        return false;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f319c.getLeft() - this.f336k;
        int right = this.f319c.getRight() + this.f336k;
        int i = height - this.f332g;
        this.f337l.setColor((this.f339n << 24) | (this.f331f & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f337l);
        if (this.f340o) {
            this.f337l.setColor(-16777216 | (this.f331f & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f342q), (float) (getWidth() - getPaddingRight()), (float) height, this.f337l);
        }
    }

    final void mo65a(int i, float f, boolean z) {
        Rect rect = this.f338m;
        int height = getHeight();
        int i2 = height - this.f332g;
        rect.set(this.f319c.getLeft() - this.f336k, i2, this.f319c.getRight() + this.f336k, height);
        super.mo65a(i, f, z);
        this.f339n = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.f319c.getLeft() - this.f336k, i2, this.f319c.getRight() + this.f336k, height);
        invalidate(rect);
    }
}
