package com.facebook.feed.rows.links;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: addressbook_contacts */
class ActionLinkFooterPartDefinition$1 implements OnClickListener {
    final /* synthetic */ String f19840a;
    final /* synthetic */ ActionLinkFooterPartDefinition f19841b;

    ActionLinkFooterPartDefinition$1(ActionLinkFooterPartDefinition actionLinkFooterPartDefinition, String str) {
        this.f19841b = actionLinkFooterPartDefinition;
        this.f19840a = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 224534066);
        this.f19841b.d.a(view.getContext(), this.f19840a, null, null);
        Logger.a(2, EntryType.UI_INPUT_END, -1210156054, a);
    }
}
