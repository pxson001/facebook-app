package com.facebook.translation;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ratingbar.AnimatedRatingBar;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;
import com.google.common.base.Preconditions;

/* compiled from: data6 */
public class TranslationRatingView extends CustomLinearLayout {
    public AnimatedRatingBar f17938a = ((AnimatedRatingBar) a(2131568100));
    public TextView f17939b = ((TextView) a(2131568099));
    public TextView f17940c = ((TextView) a(2131568101));
    public String[] f17941d;
    public RatingListener f17942e;

    /* compiled from: data6 */
    public class C12971 implements RatingChangedListener {
        final /* synthetic */ TranslationRatingView f17937a;

        public C12971(TranslationRatingView translationRatingView) {
            this.f17937a = translationRatingView;
        }

        public final void mo1343a(int i, int i2) {
            TranslationRatingView.m26469c(this.f17937a, i2);
        }

        public final void mo1342a(int i) {
            this.f17937a.f17939b.setText(2131233181);
            this.f17937a.f17942e.m26468a(i);
        }
    }

    /* compiled from: data6 */
    public interface RatingListener {
        void m26468a(int i);
    }

    public TranslationRatingView(Context context) {
        super(context);
        setContentView(2130907536);
        this.f17938a.m28565a(new C12971(this));
        this.f17941d = getResources().getStringArray(2131755073);
    }

    public int getRating() {
        return this.f17938a.f19843f;
    }

    public void setRating(int i) {
        boolean z = i >= 0 && i <= 5;
        Preconditions.checkArgument(z);
        this.f17938a.setRating(i);
        m26469c(this, i);
    }

    public static void m26469c(TranslationRatingView translationRatingView, int i) {
        translationRatingView.f17940c.setText(Html.fromHtml(translationRatingView.f17941d[i]));
    }
}
