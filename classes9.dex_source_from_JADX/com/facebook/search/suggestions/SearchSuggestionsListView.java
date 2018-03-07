package com.facebook.search.suggestions;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.LazyView;

/* compiled from: 😮 */
public class SearchSuggestionsListView extends CustomFrameLayout {
    public final View f14a;
    public final LazyView<ProgressBar> f15b;

    public SearchSuggestionsListView(Context context, boolean z) {
        super(context);
        setContentView(z ? 2130907018 : 2130907019);
        this.f14a = z ? c(2131567298) : c(2131567300);
        this.f15b = new LazyView((ViewStub) c(2131567299));
    }
}
