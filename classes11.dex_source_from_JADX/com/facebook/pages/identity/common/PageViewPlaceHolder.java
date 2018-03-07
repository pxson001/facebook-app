package com.facebook.pages.identity.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R;
import com.google.common.base.Preconditions;

/* compiled from: placeholder_no_content */
public class PageViewPlaceHolder extends View {
    public final int f3788a;
    private final boolean f3789b;
    private final boolean f3790c;
    public View f3791d;

    public PageViewPlaceHolder(Context context) {
        this(context, null, 0);
    }

    public PageViewPlaceHolder(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageViewPlaceHolder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomViewStub);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.PageViewPlaceholder);
        this.f3788a = obtainStyledAttributes.getResourceId(0, -1);
        this.f3789b = obtainStyledAttributes2.getBoolean(0, false);
        this.f3790c = obtainStyledAttributes2.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    @TargetApi(16)
    private static void m4756a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @SuppressLint({"DeprecatedMethod"})
    private static void m4757b(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public final void m4758a(View view) {
        Preconditions.checkNotNull(view);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("Placeholder has no parent or is in an invalid parent");
        }
        view.setId(this.f3788a);
        if (this.f3790c) {
            if (VERSION.SDK_INT < 16) {
                view.setBackgroundDrawable(getBackground());
            } else {
                view.setBackground(getBackground());
            }
        }
        if (this.f3789b) {
            view.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        int indexOfChild = ((ViewGroup) parent).indexOfChild(this);
        LayoutParams layoutParams = getLayoutParams() != null ? getLayoutParams() : new LayoutParams(-2, -2);
        ((ViewGroup) parent).removeViewAt(indexOfChild);
        ((ViewGroup) parent).addView(view, indexOfChild, layoutParams);
        this.f3791d = view;
    }

    public View getAttachedView() {
        return this.f3791d;
    }

    public int getInflatedLayoutId() {
        return this.f3788a;
    }
}
