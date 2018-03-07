package com.facebook.feed.menu.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$2 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19377a;
    final /* synthetic */ String f19378b;
    final /* synthetic */ GraphQLNegativeFeedbackActionsEdge f19379c;
    final /* synthetic */ View f19380d;
    final /* synthetic */ BaseFeedStoryMenuHelper f19381e;

    BaseFeedStoryMenuHelper$2(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, FeedProps feedProps, String str, GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge, View view) {
        this.f19381e = baseFeedStoryMenuHelper;
        this.f19377a = feedProps;
        this.f19378b = str;
        this.f19379c = graphQLNegativeFeedbackActionsEdge;
        this.f19380d = view;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19381e.a(this.f19377a, menuItem.getItemId(), this.f19378b, true);
        GraphQLNegativeFeedbackActionType b = this.f19379c.a().b();
        if (b == GraphQLNegativeFeedbackActionType.HIDE || b == GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM || b == GraphQLNegativeFeedbackActionType.DONT_LIKE || !this.f19381e.h()) {
            BaseFeedStoryMenuHelper.a(this.f19381e, this.f19379c, this.f19377a, this.f19380d);
        } else {
            BaseFeedStoryMenuHelper baseFeedStoryMenuHelper = this.f19381e;
            GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = this.f19379c;
            FeedProps feedProps = this.f19377a;
            View view = this.f19380d;
            new Builder(view.getContext()).a(2131233436).b(graphQLNegativeFeedbackActionsEdge.a().p().a()).a(2131233564, new BaseFeedStoryMenuHelper$4(baseFeedStoryMenuHelper, graphQLNegativeFeedbackActionsEdge, feedProps, view)).b(2131233563, new BaseFeedStoryMenuHelper$3(baseFeedStoryMenuHelper)).b();
        }
        return true;
    }
}
