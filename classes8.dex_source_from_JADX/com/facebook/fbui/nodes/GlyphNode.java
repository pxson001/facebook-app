package com.facebook.fbui.nodes;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.nodes.BaseThreadingModel;
import com.facebook.nodes.ImageNode;
import javax.inject.Inject;

/* compiled from: has_user_interacted */
public class GlyphNode extends ImageNode implements InjectableComponentWithoutContext {
    @Inject
    GlyphColorizer f11574a;
    private State f11575b = new State();

    /* compiled from: has_user_interacted */
    public final class State {
        private Drawable f11571a;
        private ColorStateList f11572b;
        public GlyphColorizer f11573c;

        State() {
        }

        public final void m13461a(int[] iArr) {
            this.f11571a.setColorFilter(this.f11573c.a(this.f11572b.getColorForState(iArr, 0)));
        }

        private void m13454a(ColorStateList colorStateList, BaseThreadingModel baseThreadingModel) {
            this.f11572b = colorStateList;
            m13458a(baseThreadingModel);
        }

        private void m13455a(Drawable drawable, BaseThreadingModel baseThreadingModel) {
            this.f11571a = drawable;
            m13458a(baseThreadingModel);
        }

        private void m13458a(BaseThreadingModel baseThreadingModel) {
            if (this.f11572b != null && this.f11571a != null) {
                if (m13459a()) {
                    m13461a(null);
                } else if (baseThreadingModel != null) {
                    m13461a(baseThreadingModel.d());
                }
            }
        }

        private boolean m13459a() {
            if (this.f11572b.isStateful()) {
                return false;
            }
            int defaultColor = this.f11572b.getDefaultColor();
            if (this.f11572b.getColorForState(null, defaultColor + 1) == defaultColor) {
                return true;
            }
            return false;
        }
    }

    public GlyphNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        FbInjector.a(GlyphNode.class, this, context);
        this.f11575b.f11573c = this.f11574a;
        this.f11575b.m13455a(a(), null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlyphColorizer, i, i2);
        m13462a(obtainStyledAttributes.getColorStateList(0));
        obtainStyledAttributes.recycle();
    }

    private void m13462a(ColorStateList colorStateList) {
        this.f11575b.m13454a(colorStateList, this.q);
    }

    protected final void m13464a(int[] iArr) {
        super.a(iArr);
        if (!this.f11575b.m13459a()) {
            this.f11575b.m13461a(iArr);
        }
    }

    public final void m13463a(Drawable drawable) {
        super.a(drawable);
        this.f11575b.m13455a(drawable, this.q);
    }
}
