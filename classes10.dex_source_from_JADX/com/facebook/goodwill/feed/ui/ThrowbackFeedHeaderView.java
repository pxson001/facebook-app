package com.facebook.goodwill.feed.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.goodwill.feed.data.ThrowbackFeedResources;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedFragmentModel.ThemeModel;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageUriFields;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: VIDEO_VIEW */
public class ThrowbackFeedHeaderView extends LinearLayout {
    public ThrowbackAnimatedHeaderView f21211a = ((ThrowbackAnimatedHeaderView) findViewById(2131562595));
    public LinearLayout f21212b = ((LinearLayout) findViewById(2131562596));
    public TextView f21213c = ((TextView) findViewById(2131567892));
    public TextView f21214d = ((TextView) findViewById(2131567891));
    public FbDraweeView f21215e;
    public Megaphone f21216f = ((Megaphone) findViewById(2131562599));
    public ThrowbackMegaphone f21217g = ((ThrowbackMegaphone) findViewById(2131562600));
    public FbRelativeLayout f21218h = ((FbRelativeLayout) findViewById(2131562594));
    public FbRelativeLayout f21219i;
    public TextView f21220j;
    public FbDraweeView f21221k;
    public boolean f21222l;
    public boolean f21223m;
    public boolean f21224n;

    /* compiled from: VIDEO_VIEW */
    class C30171 implements AnimationListener {
        final /* synthetic */ ThrowbackFeedHeaderView f21209a;

        C30171(ThrowbackFeedHeaderView throwbackFeedHeaderView) {
            this.f21209a = throwbackFeedHeaderView;
        }

        public void onAnimationStart(Animation animation) {
            this.f21209a.setVisibility(0);
        }

        public void onAnimationEnd(Animation animation) {
            this.f21209a.f21211a.m22114a(this.f21209a.f21222l ? this.f21209a.f21215e.getWidth() : Math.max(this.f21209a.f21214d.getWidth(), this.f21209a.f21213c.getWidth()));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: VIDEO_VIEW */
    class C30182 implements AnimationListener {
        final /* synthetic */ ThrowbackFeedHeaderView f21210a;

        C30182(ThrowbackFeedHeaderView throwbackFeedHeaderView) {
            this.f21210a = throwbackFeedHeaderView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            (this.f21210a.f21223m ? this.f21210a.f21217g : this.f21210a.f21216f).setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public ThrowbackFeedHeaderView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130904620, this, true);
        setOrientation(1);
        CustomFontHelper.a(this.f21214d, FontFamily.ROBOTO, FontWeight.LIGHT, this.f21214d.getTypeface());
        this.f21215e = (FbDraweeView) findViewById(2131567890);
        this.f21219i = (FbRelativeLayout) findViewById(2131567889);
        this.f21220j = (TextView) findViewById(2131567893);
        this.f21221k = (FbDraweeView) findViewById(2131562576);
    }

    @SuppressLint({"SimpleDateFormat"})
    public final void m22150a(ThrowbackFeedResources throwbackFeedResources, CallerContext callerContext) {
        DefaultImageUriFields defaultImageUriFields;
        boolean z;
        this.f21222l = "ipb_v1".equals(throwbackFeedResources.f21096n);
        this.f21211a.f21175z = this.f21222l;
        if (this.f21222l) {
            this.f21218h.getLayoutParams().height = getResources().getDimensionPixelSize(2131433049);
            defaultImageUriFields = throwbackFeedResources.f21097o;
            if (!(defaultImageUriFields == null || ImageUtil.a(defaultImageUriFields) == null)) {
                this.f21215e.a(ImageUtil.a(defaultImageUriFields), callerContext);
                this.f21215e.setVisibility(0);
                ((LayoutParams) this.f21213c.getLayoutParams()).addRule(14);
                ((LayoutParams) this.f21214d.getLayoutParams()).addRule(14);
                ((LayoutParams) this.f21213c.getLayoutParams()).addRule(3, 0);
                ((LayoutParams) this.f21214d.getLayoutParams()).addRule(3, 2131567892);
                ((LayoutParams) this.f21219i.getLayoutParams()).addRule(14);
                ((LayoutParams) this.f21215e.getLayoutParams()).addRule(14);
                this.f21214d.setPadding(this.f21214d.getPaddingLeft(), -getResources().getDimensionPixelSize(2131433093), this.f21214d.getPaddingRight(), this.f21214d.getPaddingBottom());
                this.f21213c.setPadding(this.f21213c.getPaddingLeft(), getResources().getDimensionPixelSize(2131433092), this.f21213c.getPaddingRight(), this.f21213c.getPaddingBottom());
                this.f21214d.setTextColor(getResources().getColor(2131361918));
                this.f21213c.setTextColor(getResources().getColor(2131361921));
                CustomFontHelper.a(this.f21213c, FontFamily.ROBOTO, FontWeight.LIGHT, this.f21213c.getTypeface());
            }
        }
        if (TextUtils.isEmpty(throwbackFeedResources.f21098p)) {
            this.f21220j.setVisibility(8);
            this.f21221k.setVisibility(8);
        } else {
            this.f21220j.setText(throwbackFeedResources.f21098p);
            this.f21220j.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.f21218h.getLayoutParams();
            layoutParams.height = -2;
            this.f21218h.setLayoutParams(layoutParams);
            int paddingTop = this.f21220j.getPaddingTop();
            int paddingBottom = this.f21220j.getPaddingBottom();
            if (this.f21222l) {
                this.f21211a.getLayoutParams().height = getResources().getDimensionPixelSize(2131433054);
            } else {
                this.f21211a.getLayoutParams().height = getResources().getDimensionPixelSize(2131433053);
                paddingTop = getResources().getDimensionPixelSize(2131433055);
            }
            if (this.f21224n) {
                paddingBottom = getResources().getDimensionPixelSize(2131433059);
            }
            this.f21220j.setPadding(this.f21220j.getPaddingLeft(), paddingTop, this.f21220j.getPaddingRight(), paddingBottom);
            defaultImageUriFields = throwbackFeedResources.f21099q;
            if (!(defaultImageUriFields == null || ImageUtil.a(defaultImageUriFields) == null)) {
                this.f21221k.a(ImageUtil.a(defaultImageUriFields), callerContext);
                this.f21221k.setVisibility(0);
            }
        }
        this.f21211a.setImageURLs(throwbackFeedResources.f21095m);
        this.f21213c.setText(m22148a(new Date(throwbackFeedResources.f21083a * 1000)));
        this.f21214d.setText(getResources().getString(2131239675, new Object[]{new SimpleDateFormat("d").format(r2)}));
        ThemeModel themeModel = throwbackFeedResources.f21085c;
        if (themeModel != null) {
            if (themeModel.a().g() == 1065444639 && themeModel.m() != null && themeModel.l() != null) {
                this.f21212b.setVisibility(0);
                ((TextView) findViewById(2131562597)).setText(themeModel.m().a());
                ((TextView) findViewById(2131562598)).setText(themeModel.l().a());
            } else if (!(themeModel.a().g() != -2088231066 || themeModel.k() == null || themeModel.j() == null)) {
                this.f21213c.setTextColor(Color.parseColor("#" + themeModel.k()));
                this.f21214d.setTextColor(Color.parseColor("#" + themeModel.j()));
            }
        }
        String str = throwbackFeedResources.f21090h;
        String str2 = throwbackFeedResources.f21093k;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z = false;
        } else {
            z = true;
        }
        this.f21223m = z;
        if (this.f21223m) {
            this.f21217g.m22154a(Color.parseColor("#" + throwbackFeedResources.f21090h), Color.parseColor("#" + throwbackFeedResources.f21093k));
            this.f21217g.setImage(throwbackFeedResources.f21088f);
            this.f21217g.setTitle(throwbackFeedResources.f21089g);
            this.f21217g.setSubtitle(throwbackFeedResources.f21091i);
            this.f21217g.setPrimaryButtonText(throwbackFeedResources.f21092j);
            return;
        }
        this.f21216f.setTitle(throwbackFeedResources.f21089g);
        this.f21216f.setSubtitle(throwbackFeedResources.f21091i);
        this.f21216f.setPrimaryButtonText(throwbackFeedResources.f21092j);
    }

    @SuppressLint({"SimpleDateFormat"})
    private String m22148a(Date date) {
        String toUpperCase = new SimpleDateFormat("MMM").format(date).toUpperCase(Locale.getDefault());
        if (toUpperCase.matches("\\d*")) {
            toUpperCase = new SimpleDateFormat("MMMM").format(date).toUpperCase(Locale.getDefault());
        }
        return getResources().getString(2131239674, new Object[]{toUpperCase});
    }

    public final void m22151a(boolean z) {
        (this.f21223m ? this.f21217g : this.f21216f).setVisibility(z ? 0 : 8);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968635);
        loadAnimation.setAnimationListener(new C30171(this));
        startAnimation(loadAnimation);
    }

    public final void m22149a() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968779);
        loadAnimation.setAnimationListener(new C30182(this));
        (this.f21223m ? this.f21217g : this.f21216f).startAnimation(loadAnimation);
    }
}
