package com.facebook.leadgen.input;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.input.LeadGenFieldInput.ViewType;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.facebook.resources.ui.FbAutoCompleteTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: photos_feed_list_visible_index */
public class LeadGenNonEditableTextInputView extends CustomRelativeLayout implements LeadGenFieldInput {
    public static final ViewType<LeadGenNonEditableTextInputView> f6404a = new C05851();
    @Inject
    public LeadGenUIUtil f6405b;
    public FbAutoCompleteTextView f6406c = ((FbAutoCompleteTextView) a(2131563390));
    public GraphQLLeadGenInfoFieldData f6407d;
    public FbTextView f6408e = ((FbTextView) a(2131563386));
    private TextView f6409f = ((TextView) a(2131563379));

    /* compiled from: photos_feed_list_visible_index */
    final class C05851 implements ViewType<LeadGenNonEditableTextInputView> {
        C05851() {
        }

        public final View mo350a(Context context) {
            return new LeadGenNonEditableTextInputView(context);
        }
    }

    public static void m8241a(Object obj, Context context) {
        ((LeadGenNonEditableTextInputView) obj).f6405b = LeadGenUIUtil.m8504a(FbInjector.get(context));
    }

    public LeadGenNonEditableTextInputView(Context context) {
        super(context);
        setContentView(2130905020);
        Class cls = LeadGenNonEditableTextInputView.class;
        m8241a(this, getContext());
    }

    public final void mo352a(GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, LeadGenDataExtractor leadGenDataExtractor, int i) {
        this.f6407d = graphQLLeadGenInfoFieldData;
        if (graphQLLeadGenInfoFieldData.r() == null || graphQLLeadGenInfoFieldData.r().isEmpty()) {
            this.f6406c.setVisibility(8);
            this.f6408e.setVisibility(8);
            return;
        }
        this.f6406c.setText((CharSequence) graphQLLeadGenInfoFieldData.r().get(0));
        this.f6406c.setKeyListener(null);
        if (this.f6407d.m()) {
            this.f6408e.setVisibility(0);
            this.f6408e.setText(this.f6407d.p());
            this.f6406c.setHintTextColor(getResources().getColor(2131363592));
            this.f6406c.setHint(this.f6407d.q());
            return;
        }
        this.f6406c.setHint(this.f6407d.p());
        this.f6408e.setVisibility(8);
    }

    public GraphQLLeadGenInfoFieldData getBoundedInfoFieldData() {
        return this.f6407d;
    }

    public final void mo351a() {
    }

    public String getInputValue() {
        return this.f6406c.getText().toString();
    }

    public final void mo353a(String str) {
        LeadGenUIUtil.m8506a(this.f6409f, str);
    }

    public final void mo354b() {
        LeadGenUIUtil.m8505a(this.f6409f);
    }

    public void setInputValue(String str) {
        this.f6406c.setText(str);
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
    }

    public String getInputCustomToken() {
        return getInputValue();
    }
}
