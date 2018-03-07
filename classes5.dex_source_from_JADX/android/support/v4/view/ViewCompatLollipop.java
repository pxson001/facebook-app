package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: videoChainingTitle */
class ViewCompatLollipop {

    /* compiled from: videoChainingTitle */
    public final class C00241 implements OnApplyWindowInsetsListener {
        final /* synthetic */ OnApplyWindowInsetsListener f352a;

        public C00241(OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            this.f352a = onApplyWindowInsetsListener;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((WindowInsetsCompatApi21) this.f352a.mo226a(view, new WindowInsetsCompatApi21(windowInsets))).f374a;
        }
    }

    ViewCompatLollipop() {
    }

    public static WindowInsetsCompat m413a(View view, WindowInsetsCompat windowInsetsCompat) {
        if (!(windowInsetsCompat instanceof WindowInsetsCompatApi21)) {
            return windowInsetsCompat;
        }
        WindowInsets windowInsets = ((WindowInsetsCompatApi21) windowInsetsCompat).f374a;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            return new WindowInsetsCompatApi21(onApplyWindowInsets);
        }
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat m414b(View view, WindowInsetsCompat windowInsetsCompat) {
        if (!(windowInsetsCompat instanceof WindowInsetsCompatApi21)) {
            return windowInsetsCompat;
        }
        WindowInsets windowInsets = ((WindowInsetsCompatApi21) windowInsetsCompat).f374a;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            return new WindowInsetsCompatApi21(dispatchApplyWindowInsets);
        }
        return windowInsetsCompat;
    }
}
