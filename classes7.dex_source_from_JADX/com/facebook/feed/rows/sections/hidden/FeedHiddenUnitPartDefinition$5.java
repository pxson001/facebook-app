package com.facebook.feed.rows.sections.hidden;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitActionItemView;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Unable to provide an image due to stuck input/output */
class FeedHiddenUnitPartDefinition$5 implements OnClickListener {
    final /* synthetic */ FeedHiddenUnitActionItemView f21441a;
    final /* synthetic */ FeedHiddenUnitView f21442b;
    final /* synthetic */ GraphQLNegativeFeedbackActionType f21443c;
    final /* synthetic */ FeedProps f21444d;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21445e;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21446f;

    FeedHiddenUnitPartDefinition$5(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedHiddenUnitActionItemView feedHiddenUnitActionItemView, FeedHiddenUnitView feedHiddenUnitView, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, FeedProps feedProps, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State) {
        this.f21446f = feedHiddenUnitPartDefinition;
        this.f21441a = feedHiddenUnitActionItemView;
        this.f21442b = feedHiddenUnitView;
        this.f21443c = graphQLNegativeFeedbackActionType;
        this.f21444d = feedProps;
        this.f21445e = feedHiddenUnitPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1453736802);
        FeedHiddenUnitPartDefinition.a(this.f21446f, this.f21441a, this.f21442b, this.f21443c, this.f21444d, this.f21445e);
        Logger.a(2, EntryType.UI_INPUT_END, -1884480462, a);
    }
}
