package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.facebook.R;

/* compiled from: uiCompass */
public class CardView extends FrameLayout implements CardViewDelegate {
    private static final CardViewImpl f1325a;
    private boolean f1326b;
    private boolean f1327c;
    private final Rect f1328d = new Rect();
    private final Rect f1329e = new Rect();

    static {
        if (VERSION.SDK_INT >= 21) {
            f1325a = new CardViewApi21();
        } else if (VERSION.SDK_INT >= 17) {
            f1325a = new CardViewJellybeanMr1();
        } else {
            f1325a = new CardViewEclairMr1();
        }
        f1325a.mo434a();
    }

    public CardView(Context context) {
        super(context);
        m1815a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1815a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1815a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.f1326b;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1326b != z) {
            this.f1326b = z;
            f1325a.mo444f(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (f1325a instanceof CardViewApi21) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1325a.mo438b(this)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1325a.mo440c(this)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void m1815a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i, 2131625240);
        int color = obtainStyledAttributes.getColor(0, 0);
        float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(2, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(3, 0.0f);
        this.f1326b = obtainStyledAttributes.getBoolean(4, false);
        this.f1327c = obtainStyledAttributes.getBoolean(5, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f1328d.left = obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize);
        this.f1328d.top = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        this.f1328d.right = obtainStyledAttributes.getDimensionPixelSize(8, dimensionPixelSize);
        this.f1328d.bottom = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        obtainStyledAttributes.recycle();
        f1325a.mo437a(this, context, color, dimension, dimension2, dimension3);
    }

    public void setCardBackgroundColor(int i) {
        f1325a.mo436a((CardViewDelegate) this, i);
    }

    public int getContentPaddingLeft() {
        return this.f1328d.left;
    }

    public int getContentPaddingRight() {
        return this.f1328d.right;
    }

    public int getContentPaddingTop() {
        return this.f1328d.top;
    }

    public int getContentPaddingBottom() {
        return this.f1328d.bottom;
    }

    public void setRadius(float f) {
        f1325a.mo435a((CardViewDelegate) this, f);
    }

    public float getRadius() {
        return f1325a.mo442d(this);
    }

    public final void mo430a(int i, int i2, int i3, int i4) {
        this.f1329e.set(i, i2, i3, i4);
        super.setPadding(this.f1328d.left + i, this.f1328d.top + i2, this.f1328d.right + i3, this.f1328d.bottom + i4);
    }

    public void setCardElevation(float f) {
        f1325a.mo441c(this, f);
    }

    public float getCardElevation() {
        return f1325a.mo443e(this);
    }

    public void setMaxCardElevation(float f) {
        f1325a.mo439b(this, f);
    }

    public float getMaxCardElevation() {
        return f1325a.mo433a(this);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1327c;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1327c) {
            this.f1327c = z;
            f1325a.mo445g(this);
        }
    }
}
