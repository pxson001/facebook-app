package com.facebook.leadgen.input;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.input.LeadGenFieldInput.ViewType;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.facebook.resources.ui.FbCheckBox;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: photos_number */
public class LeadGenCheckBoxInputView extends CustomRelativeLayout implements LeadGenFieldInput {
    public static final ViewType<LeadGenCheckBoxInputView> f6383a = new C05801();
    @Inject
    public LeadGenUIUtil f6384b;
    private FbCheckBox f6385c = ((FbCheckBox) a(2131563378));
    private TextView f6386d = ((TextView) a(2131563379));
    public boolean f6387e;
    public String f6388f;
    private GraphQLLeadGenInfoFieldData f6389g;

    /* compiled from: photos_number */
    final class C05801 implements ViewType<LeadGenCheckBoxInputView> {
        C05801() {
        }

        public final View mo350a(Context context) {
            return new LeadGenCheckBoxInputView(context);
        }
    }

    /* compiled from: photos_number */
    class C05812 implements OnCheckedChangeListener {
        final /* synthetic */ LeadGenCheckBoxInputView f6382a;

        C05812(LeadGenCheckBoxInputView leadGenCheckBoxInputView) {
            this.f6382a = leadGenCheckBoxInputView;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f6382a.mo354b();
            } else if (this.f6382a.f6387e) {
                this.f6382a.mo353a(this.f6382a.getErrorMessage());
            }
        }
    }

    public static void m8224a(Object obj, Context context) {
        ((LeadGenCheckBoxInputView) obj).f6384b = LeadGenUIUtil.m8504a(FbInjector.get(context));
    }

    public LeadGenCheckBoxInputView(Context context) {
        super(context);
        setContentView(2130905014);
        Class cls = LeadGenCheckBoxInputView.class;
        m8224a(this, getContext());
    }

    public final void mo352a(GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, LeadGenDataExtractor leadGenDataExtractor, int i) {
        this.f6389g = graphQLLeadGenInfoFieldData;
        if (graphQLLeadGenInfoFieldData.p() != null) {
            m8228a(graphQLLeadGenInfoFieldData.p());
        }
        if (!(graphQLLeadGenInfoFieldData.r() == null || graphQLLeadGenInfoFieldData.r().isEmpty())) {
            setChecked(Boolean.parseBoolean((String) graphQLLeadGenInfoFieldData.r().get(0)));
        }
        m8225c();
    }

    public GraphQLLeadGenInfoFieldData getBoundedInfoFieldData() {
        return this.f6389g;
    }

    public final void mo351a() {
        this.f6385c.setOnCheckedChangeListener(null);
    }

    public String getInputValue() {
        return String.valueOf(this.f6385c.isChecked());
    }

    public final void mo353a(String str) {
        LeadGenUIUtil.m8506a(this.f6386d, str);
    }

    public final void mo354b() {
        LeadGenUIUtil.m8505a(this.f6386d);
    }

    public void setInputValue(String str) {
        setChecked(Boolean.parseBoolean(str));
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
    }

    public String getErrorMessage() {
        return getResources().getString(2131238115);
    }

    public final void m8228a(CharSequence charSequence) {
        this.f6385c.setText(charSequence);
        m8225c();
    }

    public void setChecked(boolean z) {
        this.f6385c.setChecked(z);
    }

    private void m8225c() {
        this.f6385c.setOnCheckedChangeListener(new C05812(this));
    }

    public String getInputCustomToken() {
        return "";
    }
}
