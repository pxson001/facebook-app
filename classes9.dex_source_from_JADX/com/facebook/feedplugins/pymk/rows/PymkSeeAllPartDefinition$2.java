package com.facebook.feedplugins.pymk.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: THREAD_SINGLE */
public class PymkSeeAllPartDefinition$2 implements OnClickListener {
    final /* synthetic */ PymkSeeAllPartDefinition f24853a;

    public PymkSeeAllPartDefinition$2(PymkSeeAllPartDefinition pymkSeeAllPartDefinition) {
        this.f24853a = pymkSeeAllPartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -213940134);
        this.f24853a.c.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cc, FriendsCenterSource.FEED_PYMK.name()));
        Logger.a(2, EntryType.UI_INPUT_END, 1908363592, a);
    }
}
