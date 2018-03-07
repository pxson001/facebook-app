package com.facebook.feed.menu.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;

/* compiled from: analytics_extra_data */
public class BaseFeedStoryMenuHelper$4 implements OnClickListener {
    final /* synthetic */ GraphQLNegativeFeedbackActionsEdge f19383a;
    final /* synthetic */ FeedProps f19384b;
    final /* synthetic */ View f19385c;
    final /* synthetic */ BaseFeedStoryMenuHelper f19386d;

    public BaseFeedStoryMenuHelper$4(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge, FeedProps feedProps, View view) {
        this.f19386d = baseFeedStoryMenuHelper;
        this.f19383a = graphQLNegativeFeedbackActionsEdge;
        this.f19384b = feedProps;
        this.f19385c = view;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        BaseFeedStoryMenuHelper.a(this.f19386d, this.f19383a, this.f19384b, this.f19385c);
    }
}
