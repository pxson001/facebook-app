package com.facebook.orca.threadview.sms;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.text.SimpleVariableTextLayoutView;

/* compiled from: mTraceTimeoutMs */
public class SmsGroupContactsListItem extends FbRelativeLayout {
    public UserTileView f8339a = ((UserTileView) findViewById(2131564423));
    public SimpleVariableTextLayoutView f8340b = ((SimpleVariableTextLayoutView) findViewById(2131564424));
    public FbTextView f8341c = ((FbTextView) findViewById(2131564425));

    public SmsGroupContactsListItem(Context context) {
        super(context, null);
        LayoutInflater.from(context).inflate(2130907142, this);
    }
}
