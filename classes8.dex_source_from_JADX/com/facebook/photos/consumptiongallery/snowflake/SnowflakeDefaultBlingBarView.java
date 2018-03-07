package com.facebook.photos.consumptiongallery.snowflake;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.facebook.friendsharing.souvenirs.fragment.SouvenirsFragment.7;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.consumptiongallery.Feedback;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listeners.BaseAnimationListener;

/* compiled from: state_menu_popover */
public class SnowflakeDefaultBlingBarView extends CustomLinearLayout {
    private final TextView f2115a;
    private final TextView f2116b;
    private final View f2117c;
    private final String f2118d;
    private final String f2119e;
    private final String f2120f;
    private final String f2121g;
    private final Animation f2122h;
    private final Animation f2123i;
    public 7 f2124j;
    public Feedback f2125k;
    public boolean f2126l;

    /* compiled from: state_menu_popover */
    class C02411 implements OnClickListener {
        final /* synthetic */ SnowflakeDefaultBlingBarView f2112a;

        C02411(SnowflakeDefaultBlingBarView snowflakeDefaultBlingBarView) {
            this.f2112a = snowflakeDefaultBlingBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1192559288);
            if (this.f2112a.f2125k != null && this.f2112a.f2125k.m2308h() && this.f2112a.f2125k.f2110i && this.f2112a.f2124j != null) {
                this.f2112a.f2124j.a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 971913038, a);
        }
    }

    /* compiled from: state_menu_popover */
    class C02422 extends BaseAnimationListener {
        final /* synthetic */ SnowflakeDefaultBlingBarView f2113a;

        C02422(SnowflakeDefaultBlingBarView snowflakeDefaultBlingBarView) {
            this.f2113a = snowflakeDefaultBlingBarView;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2113a.f2126l = true;
            this.f2113a.setVisibility(8);
        }
    }

    /* compiled from: state_menu_popover */
    class C02433 extends BaseAnimationListener {
        final /* synthetic */ SnowflakeDefaultBlingBarView f2114a;

        C02433(SnowflakeDefaultBlingBarView snowflakeDefaultBlingBarView) {
            this.f2114a = snowflakeDefaultBlingBarView;
        }

        public void onAnimationStart(Animation animation) {
            this.f2114a.setVisibility(0);
        }

        public void onAnimationEnd(Animation animation) {
            this.f2114a.f2126l = true;
        }
    }

    public SnowflakeDefaultBlingBarView(Context context) {
        this(context, null);
    }

    public SnowflakeDefaultBlingBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2126l = true;
        setContentView(2130903391);
        Resources resources = getResources();
        CustomViewUtils.b(this, new ColorDrawable(resources.getColor(2131361920)));
        this.f2115a = (TextView) a(2131559915);
        this.f2116b = (TextView) a(2131559916);
        this.f2117c = a(2131559918);
        this.f2118d = resources.getString(2131233554);
        this.f2119e = resources.getString(2131233555);
        this.f2120f = resources.getString(2131233556);
        this.f2121g = resources.getString(2131233557);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131428946);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131428947);
        this.f2117c.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        CustomViewUtils.b(this.f2117c, new ColorDrawable(resources.getColor(2131361920)));
        this.f2117c.setOnClickListener(new C02411(this));
        this.f2122h = m2316b();
        this.f2123i = m2318c();
    }

    public final boolean m2320a() {
        return this.f2126l;
    }

    public void setLikesCount(int i) {
        m2314a(this.f2115a, i, this.f2118d, this.f2119e);
    }

    public void setCommentsCount(int i) {
        m2314a(this.f2116b, i, this.f2120f, this.f2121g);
    }

    public void setIsExpanded(boolean z) {
        if (this.f2126l) {
            this.f2126l = false;
            startAnimation(z ? this.f2123i : this.f2122h);
        }
    }

    public final void m2319a(Feedback feedback) {
        this.f2125k = feedback;
        if (feedback == null || !feedback.m2308h()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setLikesCount(feedback.f2107f);
        setCommentsCount(feedback.f2108g);
    }

    private static void m2314a(TextView textView, int i, String str, String str2) {
        if (i == 0) {
            textView.setText("");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.getResources();
        textView.setText(ResourceUtils.a(str, str2, i));
    }

    private Animation m2316b() {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(400);
        alphaAnimation.setAnimationListener(new C02422(this));
        return alphaAnimation;
    }

    private Animation m2318c() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setAnimationListener(new C02433(this));
        return alphaAnimation;
    }
}
