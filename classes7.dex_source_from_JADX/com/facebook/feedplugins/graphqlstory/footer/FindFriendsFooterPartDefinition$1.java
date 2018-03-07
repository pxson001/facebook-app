package com.facebook.feedplugins.graphqlstory.footer;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Some helper functions for story injection */
class FindFriendsFooterPartDefinition$1 implements OnClickListener {
    final /* synthetic */ FindFriendsFooterPartDefinition f23240a;

    FindFriendsFooterPartDefinition$1(FindFriendsFooterPartDefinition findFriendsFooterPartDefinition) {
        this.f23240a = findFriendsFooterPartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 349557925);
        this.f23240a.b.a(view.getContext(), FindFriendsFooterPartDefinition.a);
        Logger.a(2, EntryType.UI_INPUT_END, 970827613, a);
    }
}
