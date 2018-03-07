package com.facebook.widget.prefs;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.widget.SwitchCompat;

/* compiled from: com.facebook.versioncontrol.revision */
public class SwitchCompatPreference extends OrcaCheckBoxPreference {
    public boolean f5825a;

    /* compiled from: com.facebook.versioncontrol.revision */
    class C05321 implements OnCheckedChangeListener {
        final /* synthetic */ SwitchCompatPreference f5846a;

        C05321(SwitchCompatPreference switchCompatPreference) {
            this.f5846a = switchCompatPreference;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f5846a.callChangeListener(Boolean.valueOf(z))) {
                this.f5846a.setChecked(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchCompatPreference(Context context) {
        super(context);
        setWidgetLayoutResource(2130907355);
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(2130772842, typedValue, true) && typedValue.type == 18) {
            this.f5825a = Boolean.valueOf(typedValue.coerceToString().toString()).booleanValue();
        } else {
            this.f5825a = true;
        }
    }

    protected void onBindView(View view) {
        String string;
        super.onBindView(view);
        View findViewById = view.findViewById(16908289);
        CharSequence charSequence = null;
        if (this.f5825a) {
            charSequence = ((TextView) view.findViewById(16908304)).getText().toString();
        }
        if (TextUtils.isEmpty(charSequence)) {
            int i;
            if (isChecked()) {
                i = 2131231960;
            } else {
                i = 2131231959;
            }
            string = view.getResources().getString(i, new Object[]{getTitle()});
        } else {
            int i2;
            if (isChecked()) {
                i2 = 2131231962;
            } else {
                i2 = 2131231961;
            }
            string = view.getResources().getString(i2, new Object[]{getTitle(), charSequence});
        }
        view.setContentDescription(string);
        if (findViewById != null && (findViewById instanceof SwitchCompat)) {
            SwitchCompat switchCompat = (SwitchCompat) findViewById;
            switchCompat.setClickable(false);
            switchCompat.setChecked(isChecked());
            switchCompat.setOnCheckedChangeListener(new C05321(this));
        }
    }

    public void setSummary(CharSequence charSequence) {
        if (this.f5825a) {
            super.setSummary(charSequence);
        }
    }

    public void setSummaryOn(CharSequence charSequence) {
        if (this.f5825a) {
            super.setSummaryOn(charSequence);
        }
    }

    public void setSummaryOff(CharSequence charSequence) {
        if (this.f5825a) {
            super.setSummaryOff(charSequence);
        }
    }
}
