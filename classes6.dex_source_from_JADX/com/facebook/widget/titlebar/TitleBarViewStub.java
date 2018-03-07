package com.facebook.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.common.CommonProcessModule;
import com.facebook.resources.utils.ResourceUtils;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: quickcamfront */
public class TitleBarViewStub extends View {
    private final String f6252a;
    private final Boolean f6253b;
    private final Boolean f6254c;
    private Product f6255d;
    private WeakReference<View> f6256e;
    private Integer f6257f;

    private static <T extends View> void m8807a(Class<T> cls, T t) {
        m8808a((Object) t, t.getContext());
    }

    private static void m8808a(Object obj, Context context) {
        ((TitleBarViewStub) obj).m8806a(ProductMethodAutoProvider.b(FbInjector.get(context)), CommonProcessModule.a());
    }

    public TitleBarViewStub(Context context) {
        this(context, null);
    }

    public TitleBarViewStub(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBarViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8807a(TitleBarViewStub.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleBarViewStub, i, 0);
        this.f6252a = ResourceUtils.a(context, obtainStyledAttributes, 0);
        this.f6253b = m8804a(obtainStyledAttributes, 1);
        this.f6254c = m8804a(obtainStyledAttributes, 4);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
    }

    @Inject
    private void m8806a(Product product, Integer num) {
        this.f6255d = product;
        this.f6257f = num;
    }

    private static Boolean m8804a(TypedArray typedArray, int i) {
        return typedArray.hasValue(i) ? Boolean.valueOf(typedArray.getBoolean(i, false)) : null;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f6256e != null) {
            View view = (View) this.f6256e.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m8805a();
        }
    }

    private void m8805a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            View inflate;
            FbTitleBar fbTitleBar;
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater from = LayoutInflater.from(getContext());
            if (this.f6255d == Product.FB4A && Boolean.TRUE.equals(this.f6254c)) {
                inflate = from.inflate(2130907495, viewGroup, false);
            } else {
                inflate = from.inflate(this.f6257f.intValue(), viewGroup, false);
            }
            if (inflate instanceof FbTitleBar) {
                fbTitleBar = (FbTitleBar) inflate;
            } else {
                fbTitleBar = (FbTitleBar) inflate.findViewById(2131558563);
            }
            if (this.f6252a != null) {
                fbTitleBar.setTitle(this.f6252a);
            }
            if (this.f6253b != null) {
                fbTitleBar.setHasBackButton(this.f6253b.booleanValue());
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f6256e = new WeakReference(inflate);
            return;
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }
}
