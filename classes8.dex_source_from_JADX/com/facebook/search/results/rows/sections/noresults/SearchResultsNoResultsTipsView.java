package com.facebook.search.results.rows.sections.noresults;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: PULL_QUOTE */
public class SearchResultsNoResultsTipsView extends CustomLinearLayout {
    public ImageView f24711a = ((ImageView) a(2131564250));
    public BetterTextView f24712b = ((BetterTextView) a(2131564252));
    public BetterTextView f24713c = ((BetterTextView) a(2131564253));

    public SearchResultsNoResultsTipsView(Context context) {
        super(context);
        setContentView(2130905462);
        this.f24711a.setBackgroundDrawable(getResources().getDrawable(2130841705));
        this.f24713c.setText(getResources().getString(2131239026));
    }

    public String getQueryText() {
        return this.f24712b.getText().toString();
    }
}
