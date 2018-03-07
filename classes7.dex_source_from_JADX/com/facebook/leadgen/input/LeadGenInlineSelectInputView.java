package com.facebook.leadgen.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.LeadGenLogger;
import com.facebook.leadgen.LeadGenUtil;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.input.LeadGenFieldInput.ViewType;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: photos_feed_ufi */
public class LeadGenInlineSelectInputView extends CustomRelativeLayout implements LeadGenFieldInput {
    public static final ViewType<LeadGenInlineSelectInputView> f6392a = new C05821();
    @Inject
    public LeadGenLogger f6393b;
    @Inject
    public LeadGenUtil f6394c;
    @Inject
    public LeadGenUIUtil f6395d;
    public GraphQLLeadGenInfoFieldData f6396e;
    public RadioGroup f6397f = ((RadioGroup) a(2131563389));
    private TextView f6398g = ((TextView) a(2131563388));
    public TextView f6399h = ((TextView) a(2131563379));
    public OnDataChangeListener f6400i;

    /* compiled from: photos_feed_ufi */
    final class C05821 implements ViewType<LeadGenInlineSelectInputView> {
        C05821() {
        }

        public final View mo350a(Context context) {
            return new LeadGenInlineSelectInputView(context);
        }
    }

    public static void m8232a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenInlineSelectInputView leadGenInlineSelectInputView = (LeadGenInlineSelectInputView) obj;
        LeadGenLogger a = LeadGenLogger.m8134a(injectorLike);
        LeadGenUtil a2 = LeadGenUtil.a(injectorLike);
        LeadGenUIUtil a3 = LeadGenUIUtil.m8504a(injectorLike);
        leadGenInlineSelectInputView.f6393b = a;
        leadGenInlineSelectInputView.f6394c = a2;
        leadGenInlineSelectInputView.f6395d = a3;
    }

    public LeadGenInlineSelectInputView(Context context) {
        super(context);
        setContentView(2130905019);
        Class cls = LeadGenInlineSelectInputView.class;
        m8232a(this, getContext());
    }

    public final void mo352a(GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, LeadGenDataExtractor leadGenDataExtractor, final int i) {
        this.f6396e = graphQLLeadGenInfoFieldData;
        ImmutableList r = this.f6396e.r();
        if (!r.isEmpty()) {
            this.f6398g.setText(this.f6396e.p());
            this.f6397f.removeAllViews();
            for (int i2 = 0; i2 < r.size(); i2++) {
                RadioButton radioButton = (RadioButton) ((RadioGroup) LayoutInflater.from(getContext()).inflate(2130905018, this.f6397f)).getChildAt(i2);
                radioButton.setId(i2);
                radioButton.setText((CharSequence) r.get(i2));
            }
            this.f6397f.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ LeadGenInlineSelectInputView f6391b;

                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (this.f6391b.f6400i != null) {
                        OnDataChangeListener onDataChangeListener = this.f6391b.f6400i;
                        this.f6391b.f6396e.j();
                        this.f6391b.getInputValue();
                    }
                    this.f6391b.f6393b.m8142a("cta_lead_gen_field_edit_click", this.f6391b.f6396e.j(), i);
                    this.f6391b.f6399h.setVisibility(8);
                }
            });
        }
    }

    public GraphQLLeadGenInfoFieldData getBoundedInfoFieldData() {
        return this.f6396e;
    }

    public final void mo351a() {
        this.f6397f.setOnCheckedChangeListener(null);
        this.f6400i = null;
    }

    public String getInputValue() {
        int checkedRadioButtonId = this.f6397f.getCheckedRadioButtonId();
        ImmutableList r = this.f6396e.r();
        return (checkedRadioButtonId < 0 || r.isEmpty()) ? "" : (String) r.get(checkedRadioButtonId);
    }

    public String getInputCustomToken() {
        ImmutableList a = this.f6396e.a();
        int checkedRadioButtonId = this.f6397f.getCheckedRadioButtonId();
        if (checkedRadioButtonId < 0 || a.isEmpty()) {
            return "";
        }
        return (String) a.get(checkedRadioButtonId);
    }

    public final void mo353a(String str) {
        LeadGenUIUtil.m8506a(this.f6399h, str);
    }

    public final void mo354b() {
        LeadGenUIUtil.m8505a(this.f6399h);
    }

    public void setInputValue(String str) {
        int a = LeadGenUtil.a(str, this.f6396e.r());
        if (a != -1) {
            this.f6397f.check(a);
        }
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.f6400i = onDataChangeListener;
    }
}
