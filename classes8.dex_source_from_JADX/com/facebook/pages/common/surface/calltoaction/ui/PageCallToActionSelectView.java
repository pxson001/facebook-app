package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLInterfaces.CallToActionConfigCommonFields.Options;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigCommonFieldsModel.OptionsModel;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFactory.CallToActionFieldLogger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.collect.ImmutableList;

/* compiled from: could not extract id declaration from =  */
public class PageCallToActionSelectView extends CustomRelativeLayout implements PageCallToActionInput {
    private RadioGroup f16864a;
    public ImmutableList<? extends Options> f16865b;

    public PageCallToActionSelectView(Context context) {
        super(context);
        m20123f();
    }

    public PageCallToActionSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20123f();
    }

    public PageCallToActionSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20123f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return false;
    }

    public String getValue() {
        int checkedRadioButtonId = this.f16864a.getCheckedRadioButtonId();
        return checkedRadioButtonId >= this.f16865b.size() ? "" : ((OptionsModel) this.f16865b.get(checkedRadioButtonId)).m19795a();
    }

    public final PageCallToActionErrorState mo1033b() {
        return PageCallToActionErrorState.NONE;
    }

    public final void mo1034c() {
    }

    public final void mo1035d() {
    }

    public final void mo1036e() {
    }

    private void m20123f() {
        setContentView(2130905986);
        this.f16864a = (RadioGroup) a(2131565397);
    }

    public final void m20124a(ImmutableList<? extends Options> immutableList, String str, final CallToActionFieldLogger callToActionFieldLogger) {
        this.f16865b = immutableList;
        this.f16864a.removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext());
        for (int i = 0; i < immutableList.size(); i++) {
            RadioButton radioButton = (RadioButton) from.inflate(2130905985, this.f16864a, false);
            radioButton.setId(i);
            radioButton.setText(((OptionsModel) immutableList.get(i)).m19796b());
            this.f16864a.addView(radioButton);
            from.inflate(2130904787, this.f16864a, true);
        }
        setCheck(str);
        this.f16864a.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ PageCallToActionSelectView f16863b;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                callToActionFieldLogger.mo1039a(((OptionsModel) this.f16863b.f16865b.get(i)).m19795a());
            }
        });
    }

    private void setCheck(String str) {
        for (int i = 0; i < this.f16865b.size(); i++) {
            if (((OptionsModel) this.f16865b.get(i)).m19795a().equals(str)) {
                this.f16864a.check(i);
                return;
            }
        }
        this.f16864a.check(0);
    }
}
