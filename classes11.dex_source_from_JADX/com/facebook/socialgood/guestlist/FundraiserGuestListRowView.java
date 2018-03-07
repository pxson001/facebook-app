package com.facebook.socialgood.guestlist;

import android.content.Context;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;

/* compiled from: PAGES_REACTION_HOME_TAB_FIRST_CARD_TIMER */
public class FundraiserGuestListRowView extends ContentViewWithButton {
    public FundraiserGuestListRowView(Context context) {
        super(context);
        setThumbnailSize(ThumbnailSize.LARGE);
        setActionButtonTheme(Theme.NONE);
    }
}
