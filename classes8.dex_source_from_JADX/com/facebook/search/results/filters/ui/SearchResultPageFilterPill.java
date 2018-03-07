package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: SINGLE_LINE */
public class SearchResultPageFilterPill extends CustomLinearLayout {
    public final GlyphView f22935a;
    public final BetterTextView f22936b;
    public final GlyphView f22937c;

    public SearchResultPageFilterPill(Context context) {
        this(context, null);
    }

    public SearchResultPageFilterPill(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchResultPageFilterPill(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906989);
        setOrientation(0);
        this.f22935a = (GlyphView) a(2131559122);
        this.f22936b = (BetterTextView) a(2131558927);
        this.f22937c = (GlyphView) a(2131561099);
    }

    public void setFilterIcon(Drawable drawable) {
        this.f22935a.setImageDrawable(drawable);
        this.f22935a.setVisibility(0);
    }

    public void setFilterTitle(CharSequence charSequence) {
        this.f22936b.setText(charSequence);
    }

    public final void m26560a(OnClickListener onClickListener, Filters filters) {
        this.f22937c.setTag(filters);
        this.f22937c.setOnClickListener(onClickListener);
    }
}
