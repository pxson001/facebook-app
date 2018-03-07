package com.facebook.ufiservices.flyout.history;

import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ui.edithistory.EditHistoryAdapter;
import javax.inject.Inject;

/* compiled from: event_feed */
public class CommentEditHistoryAdapter extends EditHistoryAdapter {
    @Inject
    public CommentEditHistoryAdapter(TimeFormatUtil timeFormatUtil, LinkifyUtil linkifyUtil) {
        super(timeFormatUtil, linkifyUtil);
    }

    protected final int mo1173a() {
        return 2130904385;
    }
}
