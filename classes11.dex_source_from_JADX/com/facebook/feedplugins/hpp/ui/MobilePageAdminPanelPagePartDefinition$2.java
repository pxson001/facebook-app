package com.facebook.feedplugins.hpp.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLEntityCardContextItem;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnitItem;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.constants.PagesFb4aConstants.PagesFb4aTabs;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: current_battery_level */
class MobilePageAdminPanelPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ MobilePageAdminPanelPagePartDefinition$Props f7814a;
    final /* synthetic */ GraphQLMobilePageAdminPanelFeedUnitItem f7815b;
    final /* synthetic */ GraphQLEntityCardContextItem f7816c;
    final /* synthetic */ MobilePageAdminPanelPagePartDefinition f7817d;

    MobilePageAdminPanelPagePartDefinition$2(MobilePageAdminPanelPagePartDefinition mobilePageAdminPanelPagePartDefinition, MobilePageAdminPanelPagePartDefinition$Props mobilePageAdminPanelPagePartDefinition$Props, GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem, GraphQLEntityCardContextItem graphQLEntityCardContextItem) {
        this.f7817d = mobilePageAdminPanelPagePartDefinition;
        this.f7814a = mobilePageAdminPanelPagePartDefinition$Props;
        this.f7815b = graphQLMobilePageAdminPanelFeedUnitItem;
        this.f7816c = graphQLEntityCardContextItem;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1230912510);
        MobilePageAdminPanelPagePartDefinition.a(this.f7817d, GraphQLHelper.a(this.f7815b, this.f7814a.f7837a), Long.parseLong((String) this.f7817d.g.get()), this.f7815b.o() != null ? Long.parseLong(this.f7815b.o().ae()) : 0, this.f7814a.f7837a.l().size() == 1);
        switch (MobilePageAdminPanelPagePartDefinition$4.f7821a[this.f7816c.l().ordinal()]) {
            case 1:
            case 2:
                Bundle bundle = new Bundle();
                bundle.putBoolean("extra_is_admin", true);
                bundle.putSerializable("extra_page_tab", PagesFb4aTabs.INSIGHTS);
                this.f7817d.b.a(view, LinkifyTargetBuilder.a(this.f7815b.o()), bundle);
                break;
            case 3:
                this.f7817d.b.a(view, LinkifyTargetBuilder.a(this.f7815b.o()), null);
                break;
            default:
                this.f7817d.c.m4775a(this.f7816c);
                break;
        }
        LogUtils.a(224318435, a);
    }
}
