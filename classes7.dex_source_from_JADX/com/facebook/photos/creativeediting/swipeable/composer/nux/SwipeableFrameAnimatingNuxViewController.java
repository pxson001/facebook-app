package com.facebook.photos.creativeediting.swipeable.composer.nux;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: local_id */
public class SwipeableFrameAnimatingNuxViewController extends SwipeableAnimatingNuxViewController {
    @Nullable
    private ImageView f9950c;

    @Inject
    public SwipeableFrameAnimatingNuxViewController(Context context, SpringAlphaAnimator springAlphaAnimator) {
        super(context, springAlphaAnimator);
    }

    protected final ImageView mo527a() {
        if (this.f9950c == null) {
            this.f9950c = new ImageView(this.f9926a);
            this.f9950c.setImageDrawable(this.f9926a.getResources().getDrawable(2130838454));
            this.f9950c.setAlpha(0.0f);
        }
        return this.f9950c;
    }

    @Nullable
    protected final TextView mo528b() {
        return null;
    }

    protected final float mo529c() {
        return 0.0f;
    }

    protected final float mo530d() {
        return (((float) this.f9927b.getMeasuredWidth()) / 2.0f) - 1.0f;
    }

    protected final boolean mo531e() {
        return true;
    }

    protected final float mo526a(float f) {
        return f;
    }

    protected final float mo532f() {
        return 0.0f;
    }

    protected final float mo533g() {
        return this.f9950c.getResources().getDisplayMetrics().density * 4.0f;
    }

    protected final boolean mo534h() {
        return false;
    }
}
