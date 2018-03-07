package com.facebook.feedplugins.placetips;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.calls.SuggestifierQuestionVoteInputData.Sentiment;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: friend_search_viewed */
public class PlaceTipsFooterQuestionView extends CustomLinearLayout {
    private final TextWithEntitiesView f12933a = ((TextWithEntitiesView) a(2131566032));
    private final TextWithEntitiesView f12934b = ((TextWithEntitiesView) a(2131566033));
    private final View f12935c = a(2131566034);
    private final View f12936d = a(2131566035);
    private final View f12937e = a(2131566036);

    public PlaceTipsFooterQuestionView(Context context, DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields2, boolean z, final PlaceTipsFeedUnitBinder$1 placeTipsFeedUnitBinder$1) {
        super(context);
        setContentView(2130906275);
        PlaceTipsUtils.m14663a(this.f12933a, defaultTextWithEntitiesLongFields);
        PlaceTipsUtils.m14663a(this.f12934b, defaultTextWithEntitiesLongFields2);
        this.f12935c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsFooterQuestionView f12928b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1599161860);
                placeTipsFeedUnitBinder$1.m14659a(true);
                Logger.a(2, EntryType.UI_INPUT_END, 828746804, a);
            }
        });
        this.f12936d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsFooterQuestionView f12930b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1990310294);
                placeTipsFeedUnitBinder$1.m14659a(false);
                Logger.a(2, EntryType.UI_INPUT_END, 2107927955, a);
            }
        });
        if (z) {
            this.f12937e.setVisibility(0);
            this.f12937e.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PlaceTipsFooterQuestionView f12932b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1986572238);
                    PlaceTipsFeedUnitBinder$1 placeTipsFeedUnitBinder$1 = placeTipsFeedUnitBinder$1;
                    placeTipsFeedUnitBinder$1.f12915a.m3687a(false);
                    PlaceTipsFeedUnitBinder.a(placeTipsFeedUnitBinder$1.f12917c, placeTipsFeedUnitBinder$1.f12915a, Sentiment.DISMISS);
                    placeTipsFeedUnitBinder$1.f12916b.setFooterView(null);
                    Logger.a(2, EntryType.UI_INPUT_END, 470418917, a);
                }
            });
            return;
        }
        this.f12937e.setVisibility(8);
    }
}
