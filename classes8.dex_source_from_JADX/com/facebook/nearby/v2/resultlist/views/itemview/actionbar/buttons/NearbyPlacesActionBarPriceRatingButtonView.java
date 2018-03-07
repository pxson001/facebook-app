package com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import java.util.Currency;
import java.util.Locale;

/* compiled from: d2b2d1ea64b94840eae865c4b49198d3 */
public class NearbyPlacesActionBarPriceRatingButtonView extends NearbyPlacesActionBarButtonView {
    private static final Class<?> f16017f = NearbyPlacesActionBarPriceRatingButtonView.class;
    private int f16018g;
    private int f16019h;

    public NearbyPlacesActionBarPriceRatingButtonView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarPriceRatingButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarPriceRatingButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = CallerContext.a(f16017f);
        this.f16007b.setVisibility(8);
        Resources resources = this.f16006a.getResources();
        this.f16018g = resources.getColor(2131361974);
        this.f16019h = resources.getColor(2131361972);
    }

    public final void m18811a(String str) {
        if (StringUtil.a(str)) {
            this.f16008c.setText("");
            return;
        }
        String symbol = Currency.getInstance(Locale.getDefault()).getSymbol();
        if (StringUtil.a(symbol) || symbol.length() > 1) {
            symbol = Currency.getInstance(Locale.US).getSymbol();
        }
        int max = Math.max(1, str.length() % 5);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(symbol);
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f16018g), 0, 4, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f16019h), 0, max, 17);
        this.f16008c.setText(spannableStringBuilder);
    }
}
