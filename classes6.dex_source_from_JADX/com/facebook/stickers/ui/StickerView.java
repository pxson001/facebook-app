package com.facebook.stickers.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: draw start */
public class StickerView extends FbDraweeView {
    private static final SpringConfig f17080d = SpringConfig.a(80.0d, 9.0d);
    @Inject
    public SpringSystem f17081c;
    private Spring f17082e;
    private boolean f17083f;
    private final Rect f17084g = new Rect();

    /* compiled from: draw start */
    class C12351 extends SimpleSpringListener {
        final /* synthetic */ StickerView f17079a;

        C12351(StickerView stickerView) {
            this.f17079a = stickerView;
        }

        public final void m24772a(Spring spring) {
            float d = (float) spring.d();
            this.f17079a.setScaleX(d);
            this.f17079a.setScaleY(d);
        }
    }

    private static <T extends View> void m24774a(Class<T> cls, T t) {
        m24775a((Object) t, t.getContext());
    }

    private static void m24775a(Object obj, Context context) {
        ((StickerView) obj).f17081c = SpringSystem.b(FbInjector.get(context));
    }

    public StickerView(Context context) {
        super(context);
        m24776e();
    }

    public StickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24776e();
    }

    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24776e();
    }

    public StickerView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        m24776e();
    }

    private void m24776e() {
        boolean z = false;
        m24774a(StickerView.class, (View) this);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(2130773100, typedValue, false);
        if (typedValue.type == 18 && Boolean.valueOf(typedValue.coerceToString().toString()).booleanValue()) {
            z = true;
        }
        this.f17083f = z;
        this.f17082e = this.f17081c.a();
        this.f17082e.a(f17080d);
        this.f17082e.a(1.0d);
        this.f17082e.a(new C12351(this));
    }

    private void m24773a(SpringSystem springSystem) {
        this.f17081c = springSystem;
    }

    public final void m24778c() {
        if (this.f17083f) {
            this.f17082e.b(0.8999999761581421d);
        }
    }

    public final void m24779d() {
        if (this.f17083f) {
            this.f17082e.b(1.0d);
        }
    }

    public final boolean m24777a(float f, float f2) {
        this.f17084g.set(getLeft(), getTop(), getRight(), getBottom());
        return this.f17084g.contains((int) f, (int) f2);
    }
}
