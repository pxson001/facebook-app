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

/* compiled from: Url */
public class AdInterfacesSavedAudienceRadioButton extends FbRadioButton {
    public String f22917a;
    private TableLayout f22918b;
    private int f22919c = (getCompoundPaddingLeft() + getCompoundDrawablePadding());
    public List<String> f22920d;

    public AdInterfacesSavedAudienceRadioButton(Context context) {
        super(context);
    }

    public AdInterfacesSavedAudienceRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdInterfacesSavedAudienceRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        m24879b();
        if (this.f22918b != null) {
            this.f22918b.setVisibility(z ? 0 : 8);
        }
    }

    public String getAudienceId() {
        return this.f22917a;
    }

    public void setAudienceId(String str) {
        this.f22917a = str;
    }

    public void setDescription(List<String> list) {
        this.f22920d = list;
    }

    private void m24879b() {
        boolean z = true;
        if (this.f22918b == null && getParent() != null) {
            boolean z2;
            RadioGroup radioGroup = (RadioGroup) getParent();
            if (VERSION.SDK_INT >= 17) {
                if (radioGroup.getLayoutDirection() != 1) {
                    z = false;
                }
                z2 = z;
            } else {
                z2 = false;
            }
            this.f22918b = (TableLayout) LayoutInflater.from(getContext()).inflate(2130903102, radioGroup, false);
            this.f22918b.setId(ViewIdUtil.a());
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                if (radioGroup.getChildAt(i) == this) {
                    radioGroup.addView(this.f22918b, i + 1);
                    break;
                }
            }
            for (int i2 = 0; i2 < this.f22920d.size(); i2 += 2) {
                TableRow tableRow = (TableRow) LayoutInflater.from(getContext()).inflate(2130903103, this.f22918b, false);
                BetterTextView betterTextView = (BetterTextView) tableRow.findViewById(2131559255);
                betterTextView.setText((CharSequence) this.f22920d.get(i2));
                this.f22918b.addView(tableRow);
                betterTextView.setPadding(z2 ? 0 : this.f22919c, 0, z2 ? this.f22919c : 0, 0);
                ((BetterTextView) tableRow.findViewById(2131559256)).setText((CharSequence) this.f22920d.get(i2 + 1));
            }
        }
    }

    public final void m24880a() {
        RadioGroup radioGroup = (RadioGroup) getParent();
        radioGroup.removeView(this.f22918b);
        radioGroup.removeView(this);
    }
}
