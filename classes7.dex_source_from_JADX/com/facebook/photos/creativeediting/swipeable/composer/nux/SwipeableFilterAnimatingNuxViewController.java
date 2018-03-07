package com.facebook.photos.creativeediting.swipeable.composer.nux;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: location_picker_setting */
public class SwipeableFilterAnimatingNuxViewController extends SwipeableAnimatingNuxViewController {
    @Nullable
    private ImageView f9945c;
    @Nullable
    private TextView f9946d;

    @Inject
    public SwipeableFilterAnimatingNuxViewController(Context context, SpringAlphaAnimator springAlphaAnimator) {
        super(context, springAlphaAnimator);
    }

    protected final ImageView mo527a() {
        if (this.f9945c == null) {
            this.f9945c = new ImageView(this.f9926a);
            this.f9945c.setImageDrawable(this.f9926a.getResources().getDrawable(2130838454));
            this.f9945c.setScaleX(-1.0f);
            this.f9945c.setAlpha(0.0f);
        }
        return this.f9945c;
    }

    protected final TextView mo528b() {
        if (this.f9946d == null) {
            this.f9946d = new TextView(new ContextThemeWrapper(this.f9926a, 2131625382));
            this.f9946d.setAlpha(0.0f);
            this.f9946d.setText(2131234492);
            this.f9946d.setGravity(17);
            this.f9946d.setTextColor(this.f9926a.getResources().getColor(17170443));
            this.f9946d.setTextSize(2, 15.0f);
        }
        return this.f9946d;
    }

    protected final float mo529c() {
        return (float) this.f9927b.getMeasuredWidth();
    }

    protected final float mo530d() {
        return (3.0f * ((float) this.f9927b.getMeasuredWidth())) / 4.0f;
    }

    protected final boolean mo531e() {
        return false;
    }

    protected final float mo526a(float f) {
        return f - ((float) this.f9945c.getMeasuredWidth());
    }

    protected final float mo532f() {
        return (float) this.f9927b.getMeasuredWidth();
    }

    protected final float mo533g() {
        return (this.f9945c.getResources().getDisplayMetrics().density * 4.0f) * -1.0f;
    }

    protected final boolean mo534h() {
        return false;
    }
}
