package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.google.common.collect.ImmutableList;

/* compiled from: Unknown payload found in connection request */
public class PacingOptionsView extends AdInterfacesBoostTypeRadioGroupView {
    public AdInterfacesBidAmountEditView f23161b;

    public PacingOptionsView(Context context) {
        super(context);
    }

    public PacingOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void mo1036a() {
        setContentView(2130905950);
        setShowSegmentedDividers(2);
        setSegmentedDivider(getResources().getDrawable(2130837611));
        this.f23161b = (AdInterfacesBidAmountEditView) a(2131565312);
        this.a = ImmutableList.of((CheckedContentView) a(2131565310), (CheckedContentView) a(2131565311));
        m24532b();
        setSelected(0);
    }

    public AdInterfacesBidAmountEditView getBidAmountEditView() {
        return this.f23161b;
    }
}
