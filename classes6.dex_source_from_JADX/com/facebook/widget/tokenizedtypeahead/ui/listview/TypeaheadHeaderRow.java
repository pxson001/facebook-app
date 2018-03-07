package com.facebook.widget.tokenizedtypeahead.ui.listview;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

/* compiled from: com.facebook.platform.protocol.PROTOCOL_VALIDATED */
public class TypeaheadHeaderRow extends CustomViewGroup {
    private final RelativeLayout f20136a = ((RelativeLayout) getView(2131562282));
    public final TextView f20137b = ((TextView) getView(2131560883));

    public TypeaheadHeaderRow(Context context) {
        super(context);
        setContentView(2130907574);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f20136a.setVisibility(i);
    }
}
