package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import java.text.NumberFormat;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SINGLE_MEDIA_STORY */
public class SearchResultFilterPriceRangeSeekbar extends CustomRelativeLayout {
    @Inject
    public Locales f22926a;
    private final BetterTextView f22927b;
    private final BetterTextView f22928c;
    private final NumberFormat f22929d;

    private static <T extends View> void m26550a(Class<T> cls, T t) {
        m26551a((Object) t, t.getContext());
    }

    private static void m26551a(Object obj, Context context) {
        ((SearchResultFilterPriceRangeSeekbar) obj).f22926a = Locales.a(FbInjector.get(context));
    }

    public SearchResultFilterPriceRangeSeekbar(Context context) {
        this(context, null);
    }

    public SearchResultFilterPriceRangeSeekbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchResultFilterPriceRangeSeekbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26550a(SearchResultFilterPriceRangeSeekbar.class, (View) this);
        setContentView(2130906991);
        this.f22927b = (BetterTextView) a(2131567278);
        this.f22928c = (BetterTextView) a(2131567279);
        this.f22929d = NumberFormat.getCurrencyInstance(this.f22926a.a());
        this.f22929d.setMinimumFractionDigits(0);
    }

    private void m26549a(Locales locales) {
        this.f22926a = locales;
    }

    public final void m26552a(int i, int i2) {
        this.f22927b.setText(this.f22929d.format((long) i));
        this.f22928c.setText(this.f22929d.format((long) i2));
    }
}
