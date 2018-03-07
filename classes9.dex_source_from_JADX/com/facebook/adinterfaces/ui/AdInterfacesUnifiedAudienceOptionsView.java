package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;

/* compiled from: Upload failed at transcoding stage with sessionId %s and streamId %s */
public class AdInterfacesUnifiedAudienceOptionsView extends CustomLinearLayout {
    private RadioGroup f22961a;

    public AdInterfacesUnifiedAudienceOptionsView(Context context) {
        super(context);
        m24927a();
    }

    public AdInterfacesUnifiedAudienceOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24927a();
    }

    protected AdInterfacesUnifiedAudienceOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24927a();
    }

    private void m24927a() {
        setContentView(2130903150);
        this.f22961a = (RadioGroup) a(2131559257);
        AdInterfacesUiUtil.m25236a(this.f22961a);
    }

    public final void m24929a(GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption, String str) {
        for (int i = 0; i < this.f22961a.getChildCount(); i++) {
            View childAt = this.f22961a.getChildAt(i);
            if (childAt instanceof AdInterfacesRadioButtonWithDetails) {
                BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) childAt.getTag();
                if (boostedComponentAudienceModel != null && StringUtil.a(str, boostedComponentAudienceModel.m23232j()) && graphQLBoostedPostAudienceOption == boostedComponentAudienceModel.m23230a()) {
                    ((AdInterfacesRadioButtonWithDetails) childAt).setChecked(true);
                    return;
                }
            }
        }
    }

    public void setOnCheckChangedListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f22961a.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final AdInterfacesRadioButtonWithDetails m24928a(String str, List<String> list, int i) {
        AdInterfacesRadioButtonWithDetails adInterfacesRadioButtonWithDetails = (AdInterfacesRadioButtonWithDetails) LayoutInflater.from(getContext()).inflate(2130903136, this.f22961a, false);
        adInterfacesRadioButtonWithDetails.setId(ViewIdUtil.a());
        adInterfacesRadioButtonWithDetails.setText(str);
        adInterfacesRadioButtonWithDetails.f22885b = list;
        this.f22961a.addView(adInterfacesRadioButtonWithDetails, this.f22961a.getChildCount() - i);
        return adInterfacesRadioButtonWithDetails;
    }
}
