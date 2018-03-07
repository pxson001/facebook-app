package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.SimpleVariableTextLayoutView;

/* compiled from: p2p_group_send_confirm_send */
public class TitleBarDefaultTextTitle extends CustomViewGroup {
    private SimpleVariableTextLayoutView f5310a;
    private View f5311b;
    private ProgressBar f5312c;

    public TitleBarDefaultTextTitle(Context context) {
        super(context);
        m4711a();
    }

    public TitleBarDefaultTextTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4711a();
    }

    public TitleBarDefaultTextTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4711a();
    }

    private void m4711a() {
        setContentView(2130905898);
        this.f5311b = getView(2131565246);
        this.f5312c = (ProgressBar) getView(2131565247);
        this.f5310a = (SimpleVariableTextLayoutView) getView(2131565245);
    }

    public void setText(String str) {
        this.f5310a.setText(str);
    }
}
