package com.facebook.pages.identity.cards.chainsuggestions;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feedplugins.pyml.controllers.HScrollFeedUnitView;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.widget.CustomViewStub;
import com.facebook.widget.CustomViewUtils;

/* compiled from: privacy_checkup_review_step_previous */
public class PageIdentityPageSuggestionCardView extends CustomViewStub {
    public GraphQLPagesYouMayLikeFeedUnit f3315b;

    public PageIdentityPageSuggestionCardView(Context context) {
        this(context, null);
    }

    private PageIdentityPageSuggestionCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected View getInflatedLayout() {
        HScrollFeedUnitView hScrollFeedUnitView = new HScrollFeedUnitView(getContext());
        hScrollFeedUnitView.setLayoutParams(getLayoutParams());
        CustomViewUtils.b(hScrollFeedUnitView, new ColorDrawable(getResources().getColor(2131361920)));
        return hScrollFeedUnitView;
    }
}
