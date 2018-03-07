package com.facebook.feedplugins.hpp.ui;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import com.facebook.nodes.NodeView;
import com.facebook.nodes.TextNode;

/* compiled from: current_step */
public class MobilePageAdminPanelBodyContextRowsItemView extends NodeView {
    public TextNode f7799a;
    public int f7800b = 2130842709;

    public MobilePageAdminPanelBodyContextRowsItemView(Context context) {
        super(context);
        setContentNode(2130904806);
        this.f7799a = (TextNode) a(2131562957);
    }

    public final void m8967a(CharSequence charSequence, int i, int i2) {
        boolean z = true;
        this.f7799a.a(getResources(), (float) i2);
        TextNode textNode = this.f7799a;
        if (i != 1) {
            z = false;
        }
        textNode.a(z);
        this.f7799a.g(i);
        this.f7799a.a(TruncateAt.END);
        this.f7799a.a(charSequence);
    }
}
