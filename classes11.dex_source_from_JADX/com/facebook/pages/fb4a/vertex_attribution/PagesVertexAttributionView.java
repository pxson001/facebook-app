package com.facebook.pages.fb4a.vertex_attribution;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.graphql.model.GraphQLAttributionEntry;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;

/* compiled from: profile_field_sections_after */
public class PagesVertexAttributionView extends CustomFrameLayout implements PageSecondaryCardView {
    private final PageIdentityVertexAttributionList f3029a;

    public PagesVertexAttributionView(Context context) {
        this(context, null);
    }

    public PagesVertexAttributionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagesVertexAttributionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906039);
        this.f3029a = (PageIdentityVertexAttributionList) c(2131565541);
    }

    public void setAttribtutions(ImmutableList<GraphQLAttributionEntry> immutableList) {
        this.f3029a.removeAllViews();
        this.f3029a.setAttributions(immutableList);
    }

    public final void setCardDataFromGraphQLInterfaceModel$5a2846f3(ImmutableList<GraphQLAttributionEntry> immutableList) {
        setAttribtutions(immutableList);
    }
}
