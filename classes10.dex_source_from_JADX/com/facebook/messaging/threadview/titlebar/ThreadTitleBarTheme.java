package com.facebook.messaging.threadview.titlebar;

import android.graphics.drawable.Drawable;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: platform_composer */
public class ThreadTitleBarTheme {
    public final Drawable f4818a;
    public final int f4819b;
    public final int f4820c;
    public final int f4821d;
    public final int f4822e;
    public final int f4823f;
    public final int f4824g;
    public final int f4825h;

    ThreadTitleBarTheme(Drawable drawable, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f4818a = drawable;
        this.f4822e = i;
        this.f4823f = i2;
        this.f4824g = i3;
        this.f4819b = i4;
        this.f4820c = i5;
        this.f4821d = i6;
        this.f4825h = i7;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ThreadTitleBarTheme)) {
            return false;
        }
        ThreadTitleBarTheme threadTitleBarTheme = (ThreadTitleBarTheme) obj;
        if (Objects.equal(this.f4818a, threadTitleBarTheme.f4818a) && this.f4822e == threadTitleBarTheme.f4822e && this.f4823f == threadTitleBarTheme.f4823f && this.f4824g == threadTitleBarTheme.f4824g && this.f4819b == threadTitleBarTheme.f4819b && this.f4820c == threadTitleBarTheme.f4820c && this.f4821d == threadTitleBarTheme.f4821d && this.f4825h == threadTitleBarTheme.f4825h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f4818a, Integer.valueOf(this.f4822e), Integer.valueOf(this.f4823f), Integer.valueOf(this.f4824g), Integer.valueOf(this.f4819b), Integer.valueOf(this.f4820c), Integer.valueOf(this.f4821d), Integer.valueOf(this.f4825h)});
    }

    public static ThreadTitleBarThemeBuilder newBuilder() {
        return new ThreadTitleBarThemeBuilder();
    }
}
