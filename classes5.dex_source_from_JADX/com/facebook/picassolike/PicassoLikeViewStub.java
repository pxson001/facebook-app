package com.facebook.picassolike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.inject.FbInjector;
import com.facebook.picassolike.fresco.FrescoImpl;
import javax.inject.Inject;

/* compiled from: date_taken */
public class PicassoLikeViewStub extends View {
    @Inject
    public FrescoImpl f5213a;

    private static <T extends View> void m10072a(Class<T> cls, T t) {
        m10073a((Object) t, t.getContext());
    }

    private static void m10073a(Object obj, Context context) {
        ((PicassoLikeViewStub) obj).f5213a = FrescoImpl.a(FbInjector.get(context));
    }

    public PicassoLikeViewStub(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PicassoLikeViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10072a(PicassoLikeViewStub.class, (View) this);
    }

    public final View m10074a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("PicassoLikeViewStub must have a non-null ViewGroup viewParent: " + parent);
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater from = LayoutInflater.from(getContext());
        FrescoImpl frescoImpl = this.f5213a;
        View inflate = from.inflate(2130903930, viewGroup, false);
        inflate.setId(getId());
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        return inflate;
    }
}
