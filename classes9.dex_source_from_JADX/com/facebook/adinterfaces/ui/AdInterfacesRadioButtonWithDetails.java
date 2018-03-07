package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.resources.ui.FbRadioButton;
import com.facebook.widget.text.BetterTextView;
import java.util.List;

/* compiled from: UserRefreshBatch */
public class AdInterfacesRadioButtonWithDetails extends FbRadioButton {
    private TableLayout f22884a;
    public List<String> f22885b;

    public AdInterfacesRadioButtonWithDetails(Context context) {
        super(context);
    }

    public AdInterfacesRadioButtonWithDetails(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdInterfacesRadioButtonWithDetails(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        m24847b();
        if (this.f22884a != null) {
            this.f22884a.setVisibility(z ? 0 : 8);
        }
    }

    public void setDescription(List<String> list) {
        this.f22885b = list;
    }

    private void m24847b() {
        boolean z = true;
        if (this.f22884a == null && getParent() != null) {
            boolean z2;
            int compoundPaddingLeft;
            int i;
            TableRow tableRow;
            BetterTextView betterTextView;
            RadioGroup radioGroup = (RadioGroup) getParent();
            if (VERSION.SDK_INT >= 17) {
                if (radioGroup.getLayoutDirection() != 1) {
                    z = false;
                }
                z2 = z;
            } else {
                z2 = false;
            }
            this.f22884a = (TableLayout) LayoutInflater.from(getContext()).inflate(2130903102, radioGroup, false);
            this.f22884a.setId(ViewIdUtil.a());
            int i2 = 0;
            while (i2 < radioGroup.getChildCount()) {
                if (radioGroup.getChildAt(i2) != this) {
                    i2++;
                } else if (i2 != radioGroup.getChildCount() - 1) {
                    radioGroup.addView(this.f22884a, i2 + 1);
                    compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundDrawablePadding();
                    for (i = 0; i < this.f22885b.size(); i += 2) {
                        tableRow = (TableRow) LayoutInflater.from(getContext()).inflate(2130903103, this.f22884a, false);
                        betterTextView = (BetterTextView) tableRow.findViewById(2131559255);
                        betterTextView.setText((CharSequence) this.f22885b.get(i));
                        this.f22884a.addView(tableRow);
                        betterTextView.setPadding(z2 ? 0 : compoundPaddingLeft, 0, z2 ? compoundPaddingLeft : 0, 0);
                        ((BetterTextView) tableRow.findViewById(2131559256)).setText((CharSequence) this.f22885b.get(i + 1));
                    }
                } else {
                    return;
                }
            }
            compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundDrawablePadding();
            for (i = 0; i < this.f22885b.size(); i += 2) {
                tableRow = (TableRow) LayoutInflater.from(getContext()).inflate(2130903103, this.f22884a, false);
                betterTextView = (BetterTextView) tableRow.findViewById(2131559255);
                betterTextView.setText((CharSequence) this.f22885b.get(i));
                this.f22884a.addView(tableRow);
                if (z2) {
                }
                if (z2) {
                }
                betterTextView.setPadding(z2 ? 0 : compoundPaddingLeft, 0, z2 ? compoundPaddingLeft : 0, 0);
                ((BetterTextView) tableRow.findViewById(2131559256)).setText((CharSequence) this.f22885b.get(i + 1));
            }
        }
    }

    public final void m24848a() {
        RadioGroup radioGroup = (RadioGroup) getParent();
        radioGroup.removeView(this.f22884a);
        radioGroup.removeView(this);
    }
}
