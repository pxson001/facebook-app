package com.facebook.feed.util.composer.sprout;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.ViewProvider;
import javax.annotation.Nullable;

/* compiled from: TRIM */
public class SproutSpec {
    @ColorRes
    public final int f22463a;
    @DrawableRes
    public final int f22464b;
    public final String f22465c;
    @Nullable
    public final String f22466d;
    public final String f22467e;
    public final Runnable f22468f;
    public final Style f22469g;
    @Nullable
    @ColorRes
    public final Integer f22470h;
    public final boolean f22471i;
    @Nullable
    public final SproutNuxProvider f22472j;
    @Nullable
    public final ViewProvider f22473k;

    /* compiled from: TRIM */
    public class Builder {
        @ColorRes
        private final int f22452a;
        @DrawableRes
        private final int f22453b;
        private final String f22454c;
        @Nullable
        public String f22455d;
        private final String f22456e;
        private final Runnable f22457f;
        public Style f22458g;
        @Nullable
        @ColorRes
        public Integer f22459h;
        public boolean f22460i;
        @Nullable
        public SproutNuxProvider f22461j;
        @Nullable
        public ViewProvider f22462k;

        private Builder(@ColorRes int i, @DrawableRes int i2, String str, String str2, Runnable runnable) {
            this.f22458g = Style.FILL;
            this.f22459h = Integer.valueOf(2131361920);
            this.f22460i = false;
            this.f22452a = i;
            this.f22453b = i2;
            this.f22454c = str;
            this.f22456e = str2;
            this.f22457f = runnable;
        }

        public final SproutSpec m25060a() {
            return new SproutSpec(this.f22452a, this.f22453b, this.f22454c, this.f22455d, this.f22456e, this.f22457f, this.f22458g, this.f22459h, this.f22460i, this.f22461j, this.f22462k);
        }
    }

    /* compiled from: TRIM */
    public enum Style {
        FILL,
        OUTLINE
    }

    public static Builder m25061a(@ColorRes int i, @DrawableRes int i2, String str, String str2, Runnable runnable) {
        return new Builder(i, i2, str, str2, runnable);
    }

    private SproutSpec(@ColorRes int i, @DrawableRes int i2, String str, @Nullable String str2, String str3, Runnable runnable, Style style, @Nullable @ColorRes Integer num, boolean z, @Nullable SproutNuxProvider sproutNuxProvider, ViewProvider viewProvider) {
        this.f22469g = style;
        this.f22463a = i;
        this.f22464b = i2;
        this.f22465c = str;
        this.f22466d = str2;
        this.f22467e = str3;
        this.f22468f = runnable;
        this.f22470h = num;
        this.f22471i = z;
        this.f22472j = sproutNuxProvider;
        this.f22473k = viewProvider;
    }
}
