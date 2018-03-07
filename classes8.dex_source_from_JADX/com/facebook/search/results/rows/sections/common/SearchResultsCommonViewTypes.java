package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.text.BetterTextView;

/* compiled from: REACTION_PAGE_LOAD */
public class SearchResultsCommonViewTypes {
    public static final ViewType f24003a = new C25551();
    public static final ViewType<BetterTextView> f24004b = ViewType.a(2130903799);
    public static final ViewType<ContentView> f24005c = new C25562();

    /* compiled from: REACTION_PAGE_LOAD */
    final class C25551 extends ViewType {
        C25551() {
        }

        public final View m27581a(Context context) {
            return new BetterTextView(context);
        }
    }

    /* compiled from: REACTION_PAGE_LOAD */
    final class C25562 extends ViewType<ContentView> {
        C25562() {
        }

        public final View m27582a(Context context) {
            return new ContentView(context);
        }
    }
}
