package android.support.v4.view;

import android.content.res.ColorStateList;
import android.support.v4.view.ViewCompat.KitKatViewCompatImpl;
import android.support.v4.view.ViewCompatLollipop.C00241;
import android.view.View;

/* compiled from: videoThumbnail */
class ViewCompat$LollipopViewCompatImpl extends KitKatViewCompatImpl {
    public final void m408y(View view) {
        view.requestApplyInsets();
    }

    public final void m407g(View view, float f) {
        view.setElevation(f);
    }

    public final float m409z(View view) {
        return view.getElevation();
    }

    public final float m400A(View view) {
        return view.getTranslationZ();
    }

    public final void m405a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        view.setOnApplyWindowInsetsListener(new C00241(onApplyWindowInsetsListener));
    }

    public final void m404a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public final void m401E(View view) {
        view.stopNestedScroll();
    }

    public final float m402G(View view) {
        return view.getZ();
    }

    ViewCompat$LollipopViewCompatImpl() {
    }

    public final WindowInsetsCompat m403a(View view, WindowInsetsCompat windowInsetsCompat) {
        return ViewCompatLollipop.m413a(view, windowInsetsCompat);
    }

    public final WindowInsetsCompat m406b(View view, WindowInsetsCompat windowInsetsCompat) {
        return ViewCompatLollipop.m414b(view, windowInsetsCompat);
    }
}
