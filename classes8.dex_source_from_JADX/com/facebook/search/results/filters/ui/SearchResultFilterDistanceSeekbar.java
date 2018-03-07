package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.uicontrib.seekbar.FbSeekBar;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: SINGLE_STATE */
public class SearchResultFilterDistanceSeekbar extends CustomLinearLayout {
    private final BetterTextView f22918a;
    private final FbSeekBar f22919b;

    public SearchResultFilterDistanceSeekbar(Context context) {
        this(context, null);
    }

    public SearchResultFilterDistanceSeekbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchResultFilterDistanceSeekbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setContentView(2130906992);
        this.f22918a = (BetterTextView) a(2131567281);
        this.f22919b = (FbSeekBar) a(2131567282);
    }

    public final void m26545c(int i) {
        String formatStrLocaleSafe = ((float) i) == 100.0f ? StringFormatUtil.formatStrLocaleSafe("%d+", Integer.valueOf(i)) : String.valueOf(i);
        this.f22918a.setText(getResources().getString(2131237398, new Object[]{formatStrLocaleSafe}));
    }
}
