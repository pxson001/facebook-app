package com.facebook.feedplugins.sgny.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: buildTime */
class SaleGroupsNearYouPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition$Props f9389a;
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition f9390b;

    SaleGroupsNearYouPagePartDefinition$2(SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition, SaleGroupsNearYouPagePartDefinition$Props saleGroupsNearYouPagePartDefinition$Props) {
        this.f9390b = saleGroupsNearYouPagePartDefinition;
        this.f9389a = saleGroupsNearYouPagePartDefinition$Props;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -131250884);
        SaleGroupsNearYouPagePartDefinition.a(this.f9390b, this.f9389a.f9404a, this.f9389a.f9405b, "sgny_profile");
        this.f9390b.c.a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(this.f9389a.f9405b)), null);
        Logger.a(2, EntryType.UI_INPUT_END, -1134227873, a);
    }
}
