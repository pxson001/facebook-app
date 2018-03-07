package com.facebook.feedplugins.hpp.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnitItem;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: current_battery_level */
class MobilePageAdminPanelPagePartDefinition$3 implements OnClickListener {
    final /* synthetic */ MobilePageAdminPanelPagePartDefinition$Props f7818a;
    final /* synthetic */ GraphQLMobilePageAdminPanelFeedUnitItem f7819b;
    final /* synthetic */ MobilePageAdminPanelPagePartDefinition f7820c;

    MobilePageAdminPanelPagePartDefinition$3(MobilePageAdminPanelPagePartDefinition mobilePageAdminPanelPagePartDefinition, MobilePageAdminPanelPagePartDefinition$Props mobilePageAdminPanelPagePartDefinition$Props, GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem) {
        this.f7820c = mobilePageAdminPanelPagePartDefinition;
        this.f7818a = mobilePageAdminPanelPagePartDefinition$Props;
        this.f7819b = graphQLMobilePageAdminPanelFeedUnitItem;
    }

    public void onClick(View view) {
        boolean z = true;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -344244196);
        if (this.f7818a.f7837a.l().size() != 1) {
            z = false;
        }
        MobilePageAdminPanelPagePartDefinition.b(this.f7820c, GraphQLHelper.a(this.f7819b, this.f7818a.f7837a), Long.parseLong((String) this.f7820c.g.get()), this.f7819b.o() != null ? Long.parseLong(this.f7819b.o().ae()) : 0, z);
        this.f7820c.b.a(view, LinkifyTargetBuilder.a(this.f7819b.o()), null);
        LogUtils.a(-509855680, a);
    }
}
