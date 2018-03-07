package com.facebook.feedplugins.sgny.rows;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: buildTime */
public class SaleGroupsNearYouPagePartDefinition$5 implements FutureCallback<Void> {
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState f9399a;
    final /* synthetic */ boolean f9400b;
    final /* synthetic */ GraphQLSaleGroupsNearYouFeedUnit f9401c;
    final /* synthetic */ HasInvalidate f9402d;
    final /* synthetic */ SaleGroupsNearYouPagePartDefinition f9403e;

    public SaleGroupsNearYouPagePartDefinition$5(SaleGroupsNearYouPagePartDefinition saleGroupsNearYouPagePartDefinition, SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState saleGroupsNearYouPagePartDefinition$SgnyItemPersistentState, boolean z, GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, HasInvalidate hasInvalidate) {
        this.f9403e = saleGroupsNearYouPagePartDefinition;
        this.f9399a = saleGroupsNearYouPagePartDefinition$SgnyItemPersistentState;
        this.f9400b = z;
        this.f9401c = graphQLSaleGroupsNearYouFeedUnit;
        this.f9402d = hasInvalidate;
    }

    public void onSuccess(Object obj) {
        boolean z;
        SaleGroupsNearYouPagePartDefinition$SgnyItemPersistentState saleGroupsNearYouPagePartDefinition$SgnyItemPersistentState = this.f9399a;
        if (this.f9400b) {
            z = false;
        } else {
            z = true;
        }
        saleGroupsNearYouPagePartDefinition$SgnyItemPersistentState.f9408a = z;
        FetchTimeMsHelper.a(this.f9401c, this.f9401c.T_() + 1);
        this.f9402d.a(new Object[]{this.f9401c});
    }

    public void onFailure(Throwable th) {
        this.f9403e.f.a(th);
    }
}
