package com.facebook.composer.ui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.text.TextUtilsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.text.TextViewUtils;
import java.util.Locale;

/* compiled from: tapped_invite_friends */
public class FbTitleViewWithTriangle extends FbTextView {
    private int f2099a;
    private int f2100b;
    private int f2101c;
    private int f2102d;
    private Path f2103e;
    private Paint f2104f;
    private boolean f2105g = true;
    public boolean f2106h;
    public Tooltip f2107i;

    public FbTitleViewWithTriangle(Context context) {
        super(context);
        m2072a(context);
    }

    public FbTitleViewWithTriangle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2072a(context);
    }

    public FbTitleViewWithTriangle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2072a(context);
    }

    public void setShouldShowTriangle(boolean z) {
        if (z != this.f2105g) {
            this.f2105g = z;
            invalidate();
        }
    }

    private void m2072a(Context context) {
        setCursorVisible(false);
        setFocusable(false);
        setLines(1);
        m2078c(context);
        m2077b(context);
    }

    private void m2077b(final Context context) {
        setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ FbTitleViewWithTriangle f2098b;

            public boolean onLongClick(View view) {
                if (!this.f2098b.f2106h) {
                    return false;
                }
                if (this.f2098b.f2107i == null) {
                    this.f2098b.f2107i = new Tooltip(context, 1);
                    this.f2098b.f2107i.s = 2010;
                    this.f2098b.f2107i.b(0.0f);
                    this.f2098b.f2107i.a(Position.BELOW);
                    this.f2098b.f2107i.r = context.getResources().getDimensionPixelSize(2131429238);
                }
                this.f2098b.f2107i.a(this.f2098b.getText());
                this.f2098b.f2107i.f(this.f2098b);
                return true;
            }
        });
    }

    private void m2078c(Context context) {
        Resources resources = context.getResources();
        this.f2099a = resources.getDimensionPixelSize(2131429677);
        this.f2100b = resources.getDimensionPixelSize(2131429678);
        this.f2101c = resources.getDimensionPixelSize(2131429679);
        this.f2102d = resources.getDimensionPixelSize(2131429680);
        this.f2104f = new Paint();
        this.f2104f.setColor(getResources().getColor(2131361920));
        this.f2103e = m2070a(this.f2101c, this.f2100b);
    }

    private static Path m2070a(int i, int i2) {
        Path path = new Path();
        path.lineTo((float) i2, 0.0f);
        path.lineTo(((float) i2) / 2.0f, (float) i);
        path.close();
        return path;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2105g) {
            m2073a(canvas);
        }
    }

    private void m2073a(Canvas canvas) {
        canvas.save();
        int i = this.f2100b;
        int width = getWidth();
        int height = getHeight();
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        int compoundPaddingRight = super.getCompoundPaddingRight();
        canvas.translate((float) getScrollX(), (float) getScrollY());
        int lineWidth = (int) getLayout().getLineWidth(0);
        canvas.translate((float) (m2074a() ? (lineWidth + compoundPaddingLeft) + this.f2099a : (((width - lineWidth) - compoundPaddingRight) - i) - this.f2099a), (float) (((((getTotalPaddingTop() + height) - getTotalPaddingBottom()) - this.f2101c) / 2) + this.f2102d));
        canvas.drawPath(this.f2103e, this.f2104f);
        canvas.restore();
    }

    private static boolean m2074a() {
        return TextUtilsCompat.a(Locale.getDefault()) == 0;
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (m2074a()) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft + this.f2099a) + this.f2100b;
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight();
        if (m2074a()) {
            return (compoundPaddingRight + this.f2099a) + this.f2100b;
        }
        return compoundPaddingRight;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2106h = TextViewUtils.a(this);
    }
}
