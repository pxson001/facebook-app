package com.facebook.feedplugins.pymi.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: cleanup */
public class PeopleYouMayInvitePagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition$Props f8776a;
    final /* synthetic */ HasInvalidate f8777b;
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition f8778c;

    public PeopleYouMayInvitePagePartDefinition$2(PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, PeopleYouMayInvitePagePartDefinition$Props peopleYouMayInvitePagePartDefinition$Props, HasInvalidate hasInvalidate) {
        this.f8778c = peopleYouMayInvitePagePartDefinition;
        this.f8776a = peopleYouMayInvitePagePartDefinition$Props;
        this.f8777b = hasInvalidate;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1562297374);
        PeopleYouMayInvitePagePartDefinition.b(this.f8778c, this.f8776a, this.f8777b);
        Logger.a(2, EntryType.UI_INPUT_END, 1544554758, a);
    }
}
