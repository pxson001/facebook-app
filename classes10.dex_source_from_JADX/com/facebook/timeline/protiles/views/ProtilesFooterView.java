package com.facebook.timeline.protiles.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.widget.TextView;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: favorite_photos_batch */
public class ProtilesFooterView extends CustomFrameLayout {
    @Inject
    public RTLUtil f12400a;
    public Paint f12401b = new Paint(1);
    public int f12402c;
    public boolean f12403d;
    public TextView f12404e;

    public static void m12447a(Object obj, Context context) {
        ((ProtilesFooterView) obj).f12400a = RTLUtil.a(FbInjector.get(context));
    }

    public ProtilesFooterView(Context context) {
        super(context);
        Class cls = ProtilesFooterView.class;
        m12447a(this, getContext());
        setContentView(2130906500);
        setBackgroundResource(2130842804);
        this.f12401b.setColor(getResources().getColor(2131361938));
        this.f12401b.setStrokeWidth((float) getResources().getDimensionPixelSize(2131427379));
        this.f12402c = getResources().getDimensionPixelSize(2131433949);
        this.f12404e = (TextView) c(2131566436);
        Drawable a = this.f12400a.a(2130838069);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433960);
        Drawable insetDrawable = new InsetDrawable(a, 0, dimensionPixelSize, 0, -dimensionPixelSize);
        if (this.f12400a.a()) {
            this.f12404e.setCompoundDrawablesWithIntrinsicBounds(insetDrawable, null, null, null);
        } else {
            this.f12404e.setCompoundDrawablesWithIntrinsicBounds(null, null, insetDrawable, null);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12403d) {
            canvas.drawLine((float) this.f12402c, 0.0f, (float) (getWidth() - this.f12402c), 0.0f, this.f12401b);
        }
    }
}
