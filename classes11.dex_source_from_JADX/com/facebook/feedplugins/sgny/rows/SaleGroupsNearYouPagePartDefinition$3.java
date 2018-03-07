package com.facebook.feedplugins.sgny.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: buildTime */
public class SaleGroupsNearYouPagePartDefinition$3 implements OnClickListener {
    final /* synthetic */ GraphQLSaleGroupsNearYouFeedUnit f9391a;
    final /* synthetic */ GraphQLSaleGroupsNearYouFeedUnitGroupsEdge f9392b;
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition f9393c;

    public SaleGroupsNearYouPagePartDefinition$3(SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition, GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge) {
        this.f9393c = saleGroupsNearYouPagePartDefinition;
        this.f9391a = graphQLSaleGroupsNearYouFeedUnit;
        this.f9392b = graphQLSaleGroupsNearYouFeedUnitGroupsEdge;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2130227846);
        SaleGroupsNearYouPagePartDefinition.a(this.f9393c, this.f9391a, this.f9392b, "sgny_xout");
        this.f9393c.h.a(this.f9391a, FeedUnitItemProfileHelper.a(this.f9392b).b());
        Logger.a(2, EntryType.UI_INPUT_END, 1689326620, a);
    }
}
