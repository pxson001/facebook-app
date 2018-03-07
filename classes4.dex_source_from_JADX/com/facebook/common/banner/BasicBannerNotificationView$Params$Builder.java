package com.facebook.common.banner;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.banner.BasicBannerNotificationView.Params;
import com.google.common.base.Preconditions;

/* compiled from: mTimeCreated */
public class BasicBannerNotificationView$Params$Builder {
    public CharSequence f8493a;
    public boolean f8494b;
    public Drawable f8495c;
    public boolean f8496d;
    public CharSequence f8497e;
    public int f8498f;
    public Drawable f8499g;
    public BasicBannerNotificationView$Params$DisplayMode f8500h = BasicBannerNotificationView$Params$DisplayMode.ONLY_WHEN_SPACE_AVAILABLE;
    public ColorDrawable f8501i;

    public final BasicBannerNotificationView$Params$Builder m8755a(CharSequence charSequence) {
        this.f8493a = charSequence;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8756a(boolean z) {
        this.f8494b = z;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8752a(ColorDrawable colorDrawable) {
        this.f8501i = colorDrawable;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8753a(Drawable drawable) {
        this.f8495c = drawable;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8760b(boolean z) {
        this.f8496d = z;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8759b(CharSequence charSequence) {
        this.f8497e = charSequence;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8751a(int i) {
        this.f8498f = i;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8758b(Drawable drawable) {
        this.f8499g = drawable;
        return this;
    }

    public final BasicBannerNotificationView$Params$Builder m8754a(BasicBannerNotificationView$Params$DisplayMode basicBannerNotificationView$Params$DisplayMode) {
        this.f8500h = basicBannerNotificationView$Params$DisplayMode;
        return this;
    }

    public final Params m8757a() {
        Preconditions.checkNotNull(this.f8493a);
        return new Params(this);
    }
}
