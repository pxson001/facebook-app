package com.facebook.feedplugins.sgny.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupLeaveInputData.Source;
import com.facebook.graphql.calls.GroupRequestToJoinInputData;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: buildTime */
class SaleGroupsNearYouPagePartDefinition$4 implements OnClickListener {
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState f9394a;
    final /* synthetic */ GraphQLSaleGroupsNearYouFeedUnitGroupsEdge f9395b;
    final /* synthetic */ GraphQLSaleGroupsNearYouFeedUnit f9396c;
    final /* synthetic */ HasInvalidate f9397d;
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition f9398e;

    SaleGroupsNearYouPagePartDefinition$4(SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition, SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState saleGroupsNearYouPagePartDefinition$SgnyItemPersistentState, GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge, GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, HasInvalidate hasInvalidate) {
        this.f9398e = saleGroupsNearYouPagePartDefinition;
        this.f9394a = saleGroupsNearYouPagePartDefinition$SgnyItemPersistentState;
        this.f9395b = graphQLSaleGroupsNearYouFeedUnitGroupsEdge;
        this.f9396c = graphQLSaleGroupsNearYouFeedUnit;
        this.f9397d = hasInvalidate;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 814541171);
        boolean z = this.f9394a.f9408a;
        ListenableFuture a2 = z ? this.f9398e.d.a(FeedUnitItemProfileHelper.a(this.f9395b).b(), Source.SGNY, ReaddPolicy.ALLOW_READD) : this.f9398e.d.a(FeedUnitItemProfileHelper.a(this.f9395b).b(), GroupRequestToJoinInputData.Source.SGNY);
        if (!z) {
            SaleGroupsNearYouPagePartDefinition.a(this.f9398e, this.f9396c, this.f9395b, "sgny_join");
        }
        Futures.a(a2, SaleGroupsNearYouPagePartDefinition.a(this.f9398e, this.f9397d, this.f9396c, this.f9395b, z, this.f9394a), this.f9398e.e);
        LogUtils.a(357583071, a);
    }
}
