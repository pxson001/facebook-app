package com.facebook.feedplugins.placetips;

import android.content.Context;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: friend_search_sent */
public class PlaceTipsFooterThankYouView extends CustomLinearLayout {
    private final TextWithEntitiesView f12938a = ((TextWithEntitiesView) a(2131566031));

    public PlaceTipsFooterThankYouView(Context context, Runnable runnable, DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        super(context);
        setContentView(2130906274);
        PlaceTipsUtils.m14663a(this.f12938a, defaultTextWithEntitiesLongFields);
        postDelayed(runnable, 10000);
    }
}
