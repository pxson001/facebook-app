package com.facebook.feed.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: group_suggest_admin */
class NewsFeedFragmentDsmController$1 implements OnClickListener {
    final /* synthetic */ NewsFeedFragmentDsmController f11876a;

    NewsFeedFragmentDsmController$1(NewsFeedFragmentDsmController newsFeedFragmentDsmController) {
        this.f11876a = newsFeedFragmentDsmController;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 159500439);
        this.f11876a.f.a(view.getContext(), FBLinks.eO);
        Logger.a(2, EntryType.UI_INPUT_END, 2141639815, a);
    }
}
