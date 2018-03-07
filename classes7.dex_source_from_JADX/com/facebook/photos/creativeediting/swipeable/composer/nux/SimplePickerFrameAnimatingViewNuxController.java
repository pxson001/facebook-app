package com.facebook.photos.creativeediting.swipeable.composer.nux;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import javax.inject.Inject;

/* compiled from: lockscreen_notification_count */
public class SimplePickerFrameAnimatingViewNuxController extends SwipeableAnimatingNuxViewController {
    @Inject
    public SimplePickerFrameAnimatingViewNuxController(Context context, SpringAlphaAnimator springAlphaAnimator) {
        super(context, springAlphaAnimator);
    }

    protected final ImageView mo527a() {
        ImageView imageView = new ImageView(this.f9926a);
        imageView.setVisibility(8);
        return imageView;
    }

    @Nullable
    protected final TextView mo528b() {
        return null;
    }

    protected final float mo529c() {
        return 0.0f;
    }

    protected final float mo530d() {
        return (float) this.f9927b.getMeasuredWidth();
    }

    protected final boolean mo531e() {
        return false;
    }

    protected final float mo526a(float f) {
        return 0.0f;
    }

    protected final float mo532f() {
        return 0.0f;
    }

    protected final float mo533g() {
        return 0.0f;
    }

    protected final boolean mo534h() {
        return true;
    }

    protected final long mo535i() {
        return 500;
    }

    protected final long mo536j() {
        return 250;
    }
}
