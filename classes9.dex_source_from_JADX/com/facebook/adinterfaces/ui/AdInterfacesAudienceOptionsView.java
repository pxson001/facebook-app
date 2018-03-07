package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.resources.ui.FbRadioButton;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: VIDEO_REQUEST */
public class AdInterfacesAudienceOptionsView extends CustomLinearLayout {
    public static final int f22545a = 2131559260;
    public static final int f22546b = 2131559258;
    private RadioGroup f22547c;
    private ImmutableList<FbRadioButton> f22548d;

    public AdInterfacesAudienceOptionsView(Context context) {
        super(context);
        m24413a();
    }

    public AdInterfacesAudienceOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24413a();
    }

    protected AdInterfacesAudienceOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24413a();
    }

    private void m24413a() {
        setContentView(2130903104);
        this.f22547c = (RadioGroup) a(2131559257);
        this.f22548d = ImmutableList.of((FbRadioButton) a(2131559258), (FbRadioButton) a(2131559260));
        for (int i = 0; i < this.f22548d.size(); i++) {
            ((FbRadioButton) this.f22548d.get(i)).setTag(Integer.valueOf(i));
        }
        AdInterfacesUiUtil.m25236a(this.f22547c);
    }

    public final void m24415c(int i) {
        this.f22547c.check(i);
    }

    public void setOnCheckChangedListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f22547c.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final AdInterfacesSavedAudienceRadioButton m24414a(String str, String str2, List<String> list) {
        AdInterfacesSavedAudienceRadioButton adInterfacesSavedAudienceRadioButton = (AdInterfacesSavedAudienceRadioButton) LayoutInflater.from(getContext()).inflate(2130903139, this.f22547c, false);
        adInterfacesSavedAudienceRadioButton.setId(ViewIdUtil.a());
        adInterfacesSavedAudienceRadioButton.f22917a = str;
        adInterfacesSavedAudienceRadioButton.setText(str2);
        adInterfacesSavedAudienceRadioButton.f22920d = list;
        this.f22547c.addView(adInterfacesSavedAudienceRadioButton, this.f22547c.getChildCount() - 2);
        return adInterfacesSavedAudienceRadioButton;
    }
}
