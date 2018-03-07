package android.support.v4.view;

import android.view.WindowInsets;

/* compiled from: vertex_inline_card */
public class WindowInsetsCompatApi21 extends WindowInsetsCompat {
    public final WindowInsets f374a;

    WindowInsetsCompatApi21(WindowInsets windowInsets) {
        this.f374a = windowInsets;
    }

    public final int mo90a() {
        return this.f374a.getSystemWindowInsetLeft();
    }

    public final int mo92b() {
        return this.f374a.getSystemWindowInsetTop();
    }

    public final int mo93c() {
        return this.f374a.getSystemWindowInsetRight();
    }

    public final int mo94d() {
        return this.f374a.getSystemWindowInsetBottom();
    }

    public final boolean mo95e() {
        return this.f374a.isConsumed();
    }

    public final WindowInsetsCompat mo96f() {
        return new WindowInsetsCompatApi21(this.f374a.consumeSystemWindowInsets());
    }

    public final WindowInsetsCompat mo91a(int i, int i2, int i3, int i4) {
        return new WindowInsetsCompatApi21(this.f374a.replaceSystemWindowInsets(i, i2, i3, i4));
    }
}
