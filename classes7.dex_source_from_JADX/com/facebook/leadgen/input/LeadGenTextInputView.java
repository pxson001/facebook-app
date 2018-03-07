package com.facebook.leadgen.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.LeadGenLogger;
import com.facebook.leadgen.LeadGenUtil$1;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.input.LeadGenFieldInput.ViewType;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.facebook.resources.ui.FbAutoCompleteTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: photos_feed_extra_media */
public class LeadGenTextInputView extends CustomRelativeLayout implements LeadGenFieldInput {
    public static final ViewType<LeadGenTextInputView> f6429a = new C05911();
    @Inject
    public LeadGenLogger f6430b;
    @Inject
    public LeadGenUIUtil f6431c;
    public FbAutoCompleteTextView f6432d = ((FbAutoCompleteTextView) a(2131563387));
    public GraphQLLeadGenInfoFieldData f6433e;
    public OnDataChangeListener f6434f;
    public FbTextView f6435g = ((FbTextView) a(2131563386));
    public TextView f6436h = ((TextView) a(2131563379));

    /* compiled from: photos_feed_extra_media */
    final class C05911 implements ViewType<LeadGenTextInputView> {
        C05911() {
        }

        public final View mo350a(Context context) {
            return new LeadGenTextInputView(context);
        }
    }

    /* compiled from: photos_feed_extra_media */
    public class C05933 implements OnEditorActionListener {
        final /* synthetic */ LeadGenTextInputView f6427a;

        public C05933(LeadGenTextInputView leadGenTextInputView) {
            this.f6427a = leadGenTextInputView;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                textView.clearFocus();
            }
            return false;
        }
    }

    /* compiled from: photos_feed_extra_media */
    public class C05944 implements TextWatcher {
        final /* synthetic */ LeadGenTextInputView f6428a;

        public C05944(LeadGenTextInputView leadGenTextInputView) {
            this.f6428a = leadGenTextInputView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            Object obj;
            if (this.f6428a.f6434f != null) {
                OnDataChangeListener onDataChangeListener = this.f6428a.f6434f;
                this.f6428a.f6433e.j();
                this.f6428a.getInputValue();
            }
            if (this.f6428a.f6436h.getVisibility() == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                LeadGenTextInputView.m8256e(this.f6428a);
                LeadGenUIUtil leadGenUIUtil = this.f6428a.f6431c;
                LeadGenUIUtil.m8505a(this.f6428a.f6436h);
            }
        }
    }

    public static void m8254a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenTextInputView leadGenTextInputView = (LeadGenTextInputView) obj;
        LeadGenLogger a = LeadGenLogger.m8134a(injectorLike);
        LeadGenUIUtil a2 = LeadGenUIUtil.m8504a(injectorLike);
        leadGenTextInputView.f6430b = a;
        leadGenTextInputView.f6431c = a2;
    }

    public LeadGenTextInputView(Context context) {
        super(context);
        setContentView(2130905017);
        Class cls = LeadGenTextInputView.class;
        m8254a(this, getContext());
    }

    public final void mo352a(GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, LeadGenDataExtractor leadGenDataExtractor, final int i) {
        int i2;
        this.f6433e = graphQLLeadGenInfoFieldData;
        if (this.f6433e.m()) {
            this.f6435g.setVisibility(0);
            this.f6435g.setText(this.f6433e.p());
            this.f6432d.setHintTextColor(getResources().getColor(2131363592));
            this.f6432d.setHint(this.f6433e.q());
        } else {
            this.f6432d.setHint(this.f6433e.p());
            this.f6435g.setVisibility(8);
        }
        if (!(graphQLLeadGenInfoFieldData.r() == null || graphQLLeadGenInfoFieldData.r().isEmpty())) {
            String str = (String) graphQLLeadGenInfoFieldData.r().get(0);
            if (graphQLLeadGenInfoFieldData.k() == GraphQLLeadGenInfoFieldInputDomain.EMAIL) {
                Object obj;
                if (Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    this.f6432d.setText("");
                    this.f6432d.setAdapter(new ArrayAdapter(getContext(), 17367057, graphQLLeadGenInfoFieldData.r()));
                }
            }
            this.f6432d.setText(str);
            this.f6432d.setAdapter(new ArrayAdapter(getContext(), 17367057, graphQLLeadGenInfoFieldData.r()));
        }
        FbAutoCompleteTextView fbAutoCompleteTextView = this.f6432d;
        switch (LeadGenUtil$1.f6359a[graphQLLeadGenInfoFieldData.k().ordinal()]) {
            case 1:
                i2 = 33;
                break;
            case 2:
                i2 = 3;
                break;
            default:
                i2 = 1;
                break;
        }
        fbAutoCompleteTextView.setInputType(i2 | 524288);
        m8256e(this);
        this.f6432d.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ LeadGenTextInputView f6426b;

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    this.f6426b.f6430b.m8142a("cta_lead_gen_field_edit_click", this.f6426b.f6433e.j(), i);
                    LeadGenTextInputView.m8256e(this.f6426b);
                    LeadGenUIUtil leadGenUIUtil = this.f6426b.f6431c;
                    LeadGenUIUtil.m8505a(this.f6426b.f6436h);
                }
            }
        });
        this.f6432d.setOnEditorActionListener(new C05933(this));
        this.f6432d.addTextChangedListener(new C05944(this));
    }

    public GraphQLLeadGenInfoFieldData getBoundedInfoFieldData() {
        return this.f6433e;
    }

    public final void mo351a() {
        this.f6432d.setOnClickListener(null);
        this.f6432d.setOnFocusChangeListener(null);
        this.f6432d.setOnEditorActionListener(null);
    }

    public String getInputValue() {
        return this.f6432d.getText().toString();
    }

    public String getInputCustomToken() {
        return getInputValue();
    }

    public final void mo353a(String str) {
        this.f6432d.requestFocus();
        m8255d();
        LeadGenUIUtil.m8506a(this.f6436h, str);
    }

    public final void mo354b() {
        m8256e(this);
        LeadGenUIUtil.m8505a(this.f6436h);
    }

    public void setInputValue(String str) {
        this.f6432d.setText(str);
        this.f6432d.clearFocus();
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.f6434f = onDataChangeListener;
    }

    private void m8255d() {
        setIconDrawable(2130841031);
    }

    public static void m8256e(LeadGenTextInputView leadGenTextInputView) {
        leadGenTextInputView.setIconDrawable(2130841030);
    }

    private void setIconDrawable(int i) {
        this.f6432d.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(i), null);
    }
}
