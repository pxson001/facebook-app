package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.touch.TouchDelegateUtils;

/* compiled from: displayName */
public class GenericActionButtonView extends CustomLinearLayout implements AttachmentHasButton {
    public final GlyphWithTextView f13757a;
    private int f13758b;
    private int f13759c;
    private int f13760d;
    private int f13761e;
    private Paint f13762f;
    public boolean f13763g;
    private int f13764h;
    private int f13765i;
    private final int f13766j;
    private final int f13767k;

    public GenericActionButtonView(Context context) {
        this(context, null);
    }

    public GenericActionButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GenericActionButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13758b = 0;
        this.f13759c = 0;
        this.f13760d = 0;
        this.f13761e = 0;
        this.f13763g = false;
        setContentView(2130904581);
        this.f13757a = (GlyphWithTextView) a(2131562505);
        Resources resources = context.getResources();
        this.f13762f = new Paint();
        this.f13762f.setColor(resources.getColor(2131362055));
        this.f13765i = resources.getDimensionPixelSize(2131427528);
        this.f13762f.setStrokeWidth((float) this.f13765i);
        this.f13764h = resources.getDimensionPixelSize(2131427527);
        this.f13766j = resources.getDimensionPixelSize(2131427421);
        this.f13767k = resources.getColor(2131364066);
        this.f13758b = getPaddingLeft();
        this.f13759c = getPaddingTop();
        this.f13760d = getPaddingRight();
        this.f13761e = getPaddingBottom();
        m14490a();
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f13763g) {
            int width = ViewCompat.h(this) == 1 ? getWidth() - this.f13765i : 0;
            canvas.save();
            canvas.drawLine((float) width, (float) this.f13764h, (float) width, (float) (getHeight() - this.f13764h), this.f13762f);
            canvas.restore();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setTouchDelegate(TouchDelegateUtils.a(this.f13757a, -1));
    }

    public void setDividerEnabled(boolean z) {
        this.f13763g = z;
    }

    public GlyphWithTextView getTextView() {
        return this.f13757a;
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f13757a.setOnClickListener(onClickListener);
    }

    public final void m14490a() {
        setVisibility(8);
        this.f13763g = false;
        setPadding(this.f13758b, this.f13759c, this.f13760d, this.f13761e);
        this.f13757a.setOnClickListener(null);
        this.f13757a.setImageResource(0);
        this.f13757a.setGlyphColor(null);
        this.f13757a.setText("");
        this.f13757a.setContentDescription("");
        this.f13757a.setSelected(false);
        this.f13757a.setBackgroundResource(0);
        this.f13757a.setCompoundDrawablePadding(this.f13766j);
        this.f13757a.setTextColor(this.f13767k);
        this.f13757a.setCompoundDrawables(null, null, null, null);
    }

    public void setButtonBackgroundResource(int i) {
        m14488a(this.f13757a);
        this.f13757a.setBackgroundResource(i);
        m14489b(this.f13757a);
    }

    private void m14488a(View view) {
        this.f13758b = view.getPaddingLeft();
        this.f13759c = view.getPaddingTop();
        this.f13760d = view.getPaddingRight();
        this.f13761e = view.getPaddingBottom();
    }

    private void m14489b(View view) {
        view.setPadding(this.f13758b, this.f13759c, this.f13760d, this.f13761e);
    }

    public GenericActionButtonView getActionButton() {
        return this;
    }
}
