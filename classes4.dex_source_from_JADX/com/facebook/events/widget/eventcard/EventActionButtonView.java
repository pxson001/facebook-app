package com.facebook.events.widget.eventcard;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: optimistic_model_update */
public class EventActionButtonView extends GlyphView {
    @Inject
    GlyphColorizer f6027b;
    private boolean f6028c;
    @Nullable
    private Paint f6029d;
    private int f6030e;
    private int f6031f;

    private static <T extends View> void m6491a(Class<T> cls, T t) {
        m6492a((Object) t, t.getContext());
    }

    private static void m6492a(Object obj, Context context) {
        ((EventActionButtonView) obj).m6496a(GlyphColorizer.a(FbInjector.get(context)));
    }

    final void m6496a(GlyphColorizer glyphColorizer) {
        this.f6027b = glyphColorizer;
    }

    public EventActionButtonView(Context context) {
        this(context, null);
    }

    public EventActionButtonView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m6491a(EventActionButtonView.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EventActionButtonAttrs);
            if (obtainStyledAttributes != null) {
                this.f6028c = obtainStyledAttributes.getBoolean(0, false);
                if (this.f6028c) {
                    m6493b();
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m6493b() {
        Resources resources = getResources();
        this.f6029d = new Paint();
        this.f6029d.setColor(resources.getColor(2131362842));
        this.f6031f = resources.getDimensionPixelSize(2131429246);
        this.f6029d.setStrokeWidth((float) this.f6031f);
        this.f6030e = resources.getDimensionPixelSize(2131429247);
    }

    public final void m6494a() {
        setVisibility(8);
        setOnClickListener(null);
    }

    public final void m6495a(EventActionButtonState eventActionButtonState) {
        setImageDrawable(eventActionButtonState.f6071a);
        setContentDescription(eventActionButtonState.f6072b);
        setOnClickListener(eventActionButtonState.f6073c);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f6028c && this.f6029d != null) {
            int width = ViewCompat.h(this) == 1 ? getWidth() - this.f6031f : 0;
            canvas.drawLine((float) width, (float) this.f6030e, (float) width, (float) (getHeight() - this.f6030e), this.f6029d);
        }
    }
}
