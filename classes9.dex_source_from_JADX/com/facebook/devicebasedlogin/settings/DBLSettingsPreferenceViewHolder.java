package com.facebook.devicebasedlogin.settings;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.util.StringUtil;
import com.facebook.resources.ui.FbTextView;

/* compiled from: The field 'transferType' has been assigned the invalid value  */
public class DBLSettingsPreferenceViewHolder extends DBLSettingsViewHolder {
    private final FbTextView f24202l;
    private final FbTextView f24203m;
    private final FbTextView f24204n;
    private final Context f24205o;
    private final View f24206p;

    public DBLSettingsPreferenceViewHolder(View view, Context context) {
        super(view);
        this.f24206p = view;
        this.f24202l = (FbTextView) view.findViewById(2131560922);
        this.f24203m = (FbTextView) view.findViewById(2131560923);
        this.f24204n = (FbTextView) view.findViewById(2131560924);
        this.f24205o = context;
    }

    public final void mo1135a(DBLSettingsItem dBLSettingsItem) {
        LayoutParams layoutParams;
        this.f24202l.setText(dBLSettingsItem.f24195a);
        if (StringUtil.a(dBLSettingsItem.f24196b)) {
            this.f24203m.setVisibility(8);
            layoutParams = (LayoutParams) this.f24202l.getLayoutParams();
            int d = m26169d(17);
            layoutParams.bottomMargin = d;
            layoutParams.topMargin = d;
            this.f24202l.setLayoutParams(layoutParams);
        } else {
            this.f24203m.setText(dBLSettingsItem.f24196b);
            this.f24203m.setVisibility(0);
            layoutParams = (LayoutParams) this.f24202l.getLayoutParams();
            layoutParams.topMargin = m26169d(14);
            layoutParams.bottomMargin = m26169d(2);
            this.f24202l.setLayoutParams(layoutParams);
        }
        if (StringUtil.a(dBLSettingsItem.f24197c)) {
            this.f24204n.setVisibility(8);
            layoutParams = (LayoutParams) this.f24203m.getLayoutParams();
            layoutParams.bottomMargin = m26169d(14);
            this.f24203m.setLayoutParams(layoutParams);
        } else {
            this.f24204n.setVisibility(0);
            layoutParams = (LayoutParams) this.f24203m.getLayoutParams();
            layoutParams.bottomMargin = m26169d(2);
            this.f24203m.setLayoutParams(layoutParams);
            this.f24204n.setText(dBLSettingsItem.f24197c);
        }
        if (dBLSettingsItem.f24198d) {
            this.f24202l.setTextColor(this.f24205o.getResources().getColor(2131361918));
        } else {
            this.f24202l.setTextColor(this.f24205o.getResources().getColor(2131361932));
        }
    }

    public final void mo1136c(int i) {
        this.f24206p.setTag(Integer.valueOf(i));
    }

    private int m26169d(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, this.f24205o.getResources().getDisplayMetrics());
    }
}
