package com.facebook.feedplugins.hpp.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: currentSearchSuggestion */
class C0991x82db968e implements OnClickListener {
    final /* synthetic */ MobilePageAdminPanelSeeAllPagesPartDefinition f7850a;

    public C0991x82db968e(MobilePageAdminPanelSeeAllPagesPartDefinition mobilePageAdminPanelSeeAllPagesPartDefinition) {
        this.f7850a = mobilePageAdminPanelSeeAllPagesPartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1145467030);
        this.f7850a.b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aK, "top"));
        Logger.a(2, EntryType.UI_INPUT_END, -1910517132, a);
    }
}
