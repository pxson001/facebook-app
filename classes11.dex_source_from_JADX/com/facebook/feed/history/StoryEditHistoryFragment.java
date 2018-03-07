package com.facebook.feed.history;

import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ui.edithistory.EditHistoryAdapter;
import com.facebook.ui.edithistory.EditHistoryFragment;
import com.facebook.widget.titlebar.HasTitleBar;

/* compiled from: drawerState */
public class StoryEditHistoryFragment extends EditHistoryFragment {
    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1170642930);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131233290);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -63869083, a);
    }

    protected final int au() {
        return 2130904339;
    }

    protected final EditHistoryAdapter av() {
        FbInjector an = an();
        return (EditHistoryAdapter) new StoryEditHistoryAdapter((TimeFormatUtil) DefaultTimeFormatUtil.a(an), LinkifyUtil.a(an));
    }
}
