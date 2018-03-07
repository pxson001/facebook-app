package com.facebook.feedplugins.pymi.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger.Events;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: clear_system_tray_on_zero_count */
public class PeopleYouMayInviteMorePartDefinition$2 implements OnClickListener {
    final /* synthetic */ PeopleYouMayInviteMorePartDefinition f8775a;

    public PeopleYouMayInviteMorePartDefinition$2(PeopleYouMayInviteMorePartDefinition peopleYouMayInviteMorePartDefinition) {
        this.f8775a = peopleYouMayInviteMorePartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1479254068);
        this.f8775a.d.m9514a();
        this.f8775a.d.m9515a(Events.INVITE_MORE);
        this.f8775a.d.m9516a("invite_more");
        this.f8775a.c.a(view.getContext(), StringFormatUtil.a(FBLinks.dR, new Object[]{CIFlow.NEWS_FEED_PYMI.value}));
        Logger.a(2, EntryType.UI_INPUT_END, -505461944, a);
    }
}
