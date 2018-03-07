package com.facebook.reviews.composer;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ratingbar.AnimatedRatingBar;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pull_quote_style */
public class ComposerRatingView extends CustomLinearLayout {
    @Inject
    public ReviewsRatingHelper f4895a;
    public ViewGroup f4896b;
    private TextView f4897c;
    private LinearLayout f4898d;
    public AnimatedRatingBar f4899e;
    public TextView f4900f;
    public Optional<RatingListener> f4901g;
    private String[] f4902h;

    /* compiled from: pull_quote_style */
    class C06521 implements AnimationListener {
        final /* synthetic */ ComposerRatingView f4886a;

        C06521(ComposerRatingView composerRatingView) {
            this.f4886a = composerRatingView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f4886a.f4896b.setVisibility(8);
            this.f4886a.f4900f.setVisibility(0);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: pull_quote_style */
    class C06532 implements RatingChangedListener {
        final /* synthetic */ ComposerRatingView f4887a;

        C06532(ComposerRatingView composerRatingView) {
            this.f4887a = composerRatingView;
        }

        public final void m4796a(int i, int i2) {
        }

        public final void m4795a(int i) {
            this.f4887a.m4814c(i);
            if (this.f4887a.f4901g.isPresent()) {
                ((RatingListener) this.f4887a.f4901g.get()).mo243b(i);
            }
        }
    }

    /* compiled from: pull_quote_style */
    public interface RatingListener {
        void mo242a(int i);

        void mo243b(int i);

        void mo244c(int i);

        void mo245d(int i);
    }

    private static <T extends View> void m4807a(Class<T> cls, T t) {
        m4808a((Object) t, t.getContext());
    }

    private static void m4808a(Object obj, Context context) {
        ((ComposerRatingView) obj).f4895a = ReviewsRatingHelper.m4932a(FbInjector.get(context));
    }

    private void m4806a(ReviewsRatingHelper reviewsRatingHelper) {
        this.f4895a = reviewsRatingHelper;
    }

    public ComposerRatingView(Context context) {
        super(context);
        m4804a();
    }

    public ComposerRatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4804a();
    }

    private void m4804a() {
        m4807a(ComposerRatingView.class, (View) this);
        setContentView(2130903719);
        setOrientation(1);
        this.f4896b = (ViewGroup) a(2131560607);
        this.f4897c = (TextView) a(2131560608);
        this.f4899e = (AnimatedRatingBar) a(2131560609);
        this.f4898d = (LinearLayout) a(2131560610);
        this.f4900f = (TextView) a(2131560611);
        this.f4902h = getResources().getStringArray(2131755075);
    }

    public void setRating(Integer num) {
        boolean z = num.intValue() >= 0 && num.intValue() <= 5;
        Preconditions.checkArgument(z);
        if (num.intValue() > 0) {
            m4813c();
            setRatingSelector(this, num.intValue());
            return;
        }
        m4810b();
    }

    public void setPageName(String str) {
        this.f4897c.setText(getResources().getString(2131235357, new Object[]{str}));
    }

    public void setOnRatingChangedListener(@Nullable RatingListener ratingListener) {
        this.f4901g = Optional.fromNullable(ratingListener);
    }

    private void m4810b() {
        m4819e();
        m4820f();
        this.f4896b.setVisibility(0);
        this.f4900f.setVisibility(8);
    }

    private void m4813c() {
        this.f4896b.setVisibility(8);
        this.f4900f.setVisibility(0);
    }

    private void m4817d() {
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, (float) (this.f4899e.getWidth() / 2), (float) ((int) ((getResources().getDimension(2131430080) + getResources().getDimension(2131428032)) - this.f4899e.getY())));
        scaleAnimation.setDuration(500);
        scaleAnimation.setAnimationListener(new C06521(this));
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        this.f4899e.startAnimation(scaleAnimation);
        this.f4898d.startAnimation(alphaAnimation);
        this.f4897c.startAnimation(alphaAnimation);
    }

    private void m4819e() {
        this.f4899e.setAccessibilityTextForEachStar(2131689506);
        this.f4899e.a(new C06532(this));
    }

    private void m4820f() {
        LayoutInflater from = LayoutInflater.from(getContext());
        for (int i = 1; i <= 5; i++) {
            final TextView textView = (TextView) from.inflate(2130906839, this.f4898d, false);
            textView.setText(m4801a(i, 2131361974));
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ComposerRatingView f4890c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2069644231);
                    textView.setTextColor(this.f4890c.getResources().getColor(2131361917));
                    textView.setText(this.f4890c.m4801a(i, 2131361917));
                    this.f4890c.f4899e.setRating(i);
                    this.f4890c.m4814c(i);
                    if (this.f4890c.f4901g.isPresent()) {
                        ((RatingListener) this.f4890c.f4901g.get()).mo245d(i);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -788064385, a);
                }
            });
            this.f4898d.addView(textView);
        }
    }

    private void m4814c(int i) {
        setRatingSelector(this, i);
        m4817d();
    }

    public static void setRatingSelector(ComposerRatingView composerRatingView, final int i) {
        boolean z = i > 0 && i <= 5;
        Preconditions.checkArgument(z);
        composerRatingView.f4900f.setText(composerRatingView.m4801a(i, 2131361917));
        composerRatingView.f4900f.setOnClickListener(new OnClickListener(composerRatingView) {
            final /* synthetic */ ComposerRatingView f4892b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 511544845);
                ComposerRatingView.m4818d(this.f4892b, i);
                if (this.f4892b.f4901g.isPresent()) {
                    ((RatingListener) this.f4892b.f4901g.get()).mo242a(i);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1512991799, a);
            }
        });
    }

    private SpannableStringBuilder m4801a(int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f4895a.m4936a(i, getResources().getDimensionPixelSize(2131427406), i2));
        spannableStringBuilder.append("  " + this.f4902h[i - 1]);
        return spannableStringBuilder;
    }

    public static void m4818d(ComposerRatingView composerRatingView, int i) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(composerRatingView.getContext());
        figPopoverMenuWindow.a(Position.BELOW);
        PopoverMenu c = figPopoverMenuWindow.c();
        int i2 = 1;
        while (i2 <= 5) {
            boolean z = i2 == i;
            c.a(composerRatingView.m4801a(i2, z ? 2131361917 : 2131361974)).setCheckable(true).setChecked(z).setOnMenuItemClickListener(new OnMenuItemClickListener(composerRatingView) {
                final /* synthetic */ ComposerRatingView f4894b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    ComposerRatingView.setRatingSelector(this.f4894b, i2);
                    if (this.f4894b.f4901g.isPresent()) {
                        ((RatingListener) this.f4894b.f4901g.get()).mo244c(i2);
                    }
                    return true;
                }
            });
            i2++;
        }
        figPopoverMenuWindow.f(composerRatingView.f4900f);
    }
}
