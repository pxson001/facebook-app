package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.view.View;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.multirow.api.ViewType;

/* compiled from: REACTION_OVERLAY_ERROR */
public abstract class SearchResultsEmptyPartDefinition<T> extends MultiRowSinglePartDefinition<T, Void, HasPositionInformation, View> {
    public static final ViewType f24007a = new C25571();

    /* compiled from: REACTION_OVERLAY_ERROR */
    final class C25571 extends ViewType {
        C25571() {
        }

        public final View m27584a(Context context) {
            return new View(context);
        }
    }

    public final ViewType m27585a() {
        return f24007a;
    }

    public final boolean m27586a(T t) {
        return true;
    }
}
