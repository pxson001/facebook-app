package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;

/* compiled from: VERIFICATION_REASON_COMPLIANCE_LIFETIME_2000 */
public class AdInterfacesBoostTypeRadioGroupView extends SegmentedLinearLayout {
    protected ImmutableList<CheckedContentView> f22606a;
    public OnCheckChangeListener f22607b;
    public int f22608c = -1;

    /* compiled from: VERIFICATION_REASON_COMPLIANCE_LIFETIME_2000 */
    public interface OnCheckChangeListener {
        void mo1011a(int i);
    }

    public AdInterfacesBoostTypeRadioGroupView(Context context) {
        super(context);
        mo1036a();
    }

    public AdInterfacesBoostTypeRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1036a();
    }

    protected void mo1036a() {
        setContentView(2130903425);
        setOrientation(1);
        setShowSegmentedDividers(2);
        setSegmentedDivider(getResources().getDrawable(2130837611));
        this.f22606a = ImmutableList.of((CheckedContentView) a(2131559971), (CheckedContentView) a(2131559972));
        m24532b();
    }

    protected final void m24532b() {
        for (int i = 0; i < this.f22606a.size(); i++) {
            ((CheckedContentView) this.f22606a.get(i)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AdInterfacesBoostTypeRadioGroupView f22605b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -444456661);
                    if (((CheckedContentView) this.f22605b.f22606a.get(i)).isChecked()) {
                        Logger.a(2, EntryType.UI_INPUT_END, -2091778306, a);
                        return;
                    }
                    this.f22605b.setSelected(i);
                    this.f22605b.f22607b.mo1011a(i);
                    LogUtils.a(1293933126, a);
                }
            });
        }
    }

    public void setOnCheckChangeListener(OnCheckChangeListener onCheckChangeListener) {
        this.f22607b = onCheckChangeListener;
    }

    public void setSelected(int i) {
        this.f22608c = i;
        for (int i2 = 0; i2 < this.f22606a.size(); i2++) {
            boolean z;
            CheckedContentView checkedContentView = (CheckedContentView) this.f22606a.get(i2);
            if (i == i2) {
                z = true;
            } else {
                z = false;
            }
            checkedContentView.setChecked(z);
        }
    }

    public final CheckedContentView m24533d(int i) {
        return (CheckedContentView) this.f22606a.get(i);
    }

    public int getCheckedIndex() {
        return this.f22608c;
    }

    public void setCheckedIndex(int i) {
        setSelected(i);
    }
}
