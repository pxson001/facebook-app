package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: V2_RECENT_LINKS */
public class AdInterfacesGenderView extends CustomLinearLayout {
    private RadioGroup f22730a;

    /* compiled from: V2_RECENT_LINKS */
    public enum Gender {
        ALL,
        MALE,
        FEMALE
    }

    public AdInterfacesGenderView(Context context) {
        super(context);
        m24648a();
    }

    public AdInterfacesGenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24648a();
    }

    protected AdInterfacesGenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24648a();
    }

    private void m24648a() {
        setContentView(2130903119);
        this.f22730a = (RadioGroup) a(2131559288);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f22730a.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setGender(Gender gender) {
        int i = 2131559289;
        switch (gender) {
            case MALE:
                i = 2131559290;
                break;
            case FEMALE:
                i = 2131559291;
                break;
        }
        this.f22730a.check(i);
    }

    public Gender getSelectedGender() {
        if (this.f22730a.getCheckedRadioButtonId() == 2131559290) {
            return Gender.MALE;
        }
        if (this.f22730a.getCheckedRadioButtonId() == 2131559291) {
            return Gender.FEMALE;
        }
        return Gender.ALL;
    }
}
