package com.facebook.leadgen.input;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.graphql.model.GraphQLStoryActionLink;
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
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: photos_feed_list_offset */
public class LeadGenSpinnerSelectInputView extends CustomRelativeLayout implements LeadGenFieldInput {
    public static final ViewType<LeadGenSpinnerSelectInputView> f6416a = new C05861();
    @Inject
    public LeadGenLogger f6417b;
    @Inject
    public LeadGenUtil f6418c;
    @Inject
    public LeadGenUIUtil f6419d;
    public GraphQLLeadGenInfoFieldData f6420e;
    public Spinner f6421f = ((Spinner) a(2131563392));
    private TextView f6422g = ((TextView) a(2131563391));
    public TextView f6423h = ((TextView) getRootView().findViewById(2131563379));
    public OnDataChangeListener f6424i;

    /* compiled from: photos_feed_list_offset */
    final class C05861 implements ViewType<LeadGenSpinnerSelectInputView> {
        C05861() {
        }

        public final View mo350a(Context context) {
            return new LeadGenSpinnerSelectInputView(context);
        }
    }

    /* compiled from: photos_feed_list_offset */
    public class C05894 implements OnItemSelectedListener {
        final /* synthetic */ int f6413a;
        final /* synthetic */ LeadGenSpinnerSelectInputView f6414b;

        public C05894(LeadGenSpinnerSelectInputView leadGenSpinnerSelectInputView, int i) {
            this.f6414b = leadGenSpinnerSelectInputView;
            this.f6413a = i;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            TextView textView = (TextView) this.f6414b.f6421f.getSelectedView();
            if (textView != null) {
                textView.setTextColor(this.f6414b.getResources().getColor(2131363584));
                LeadGenSpinnerSelectInputView.m8248c(this.f6414b);
            }
            if (this.f6414b.f6424i != null && j < ((long) this.f6414b.f6421f.getCount())) {
                OnDataChangeListener onDataChangeListener = this.f6414b.f6424i;
                this.f6414b.f6420e.j();
                this.f6414b.getInputValue();
            }
            this.f6414b.f6417b.m8142a("cta_lead_gen_field_edit_click", this.f6414b.f6420e.j(), this.f6413a);
            LeadGenUIUtil leadGenUIUtil = this.f6414b.f6419d;
            LeadGenUIUtil.m8505a(this.f6414b.f6423h);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: photos_feed_list_offset */
    class C05905 implements Runnable {
        final /* synthetic */ LeadGenSpinnerSelectInputView f6415a;

        C05905(LeadGenSpinnerSelectInputView leadGenSpinnerSelectInputView) {
            this.f6415a = leadGenSpinnerSelectInputView;
        }

        public void run() {
            TextView textView = (TextView) this.f6415a.f6421f.getSelectedView();
            if (textView != null) {
                Layout layout = textView.getLayout();
                if (layout == null || layout.getParagraphDirection(0) != -1) {
                    this.f6415a.f6421f.setBackgroundResource(2130843436);
                } else {
                    this.f6415a.f6421f.setBackgroundResource(2130843437);
                }
                if (textView.getHint().length() > 0) {
                    textView.setText("");
                }
            }
        }
    }

    public static void m8247a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenSpinnerSelectInputView leadGenSpinnerSelectInputView = (LeadGenSpinnerSelectInputView) obj;
        LeadGenLogger a = LeadGenLogger.m8134a(injectorLike);
        LeadGenUtil a2 = LeadGenUtil.a(injectorLike);
        LeadGenUIUtil a3 = LeadGenUIUtil.m8504a(injectorLike);
        leadGenSpinnerSelectInputView.f6417b = a;
        leadGenSpinnerSelectInputView.f6418c = a2;
        leadGenSpinnerSelectInputView.f6419d = a3;
    }

    public LeadGenSpinnerSelectInputView(Context context) {
        super(context);
        setContentView(2130905021);
        Class cls = LeadGenSpinnerSelectInputView.class;
        m8247a(this, getContext());
    }

    public final void mo352a(GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, LeadGenDataExtractor leadGenDataExtractor, final int i) {
        this.f6420e = graphQLLeadGenInfoFieldData;
        ImmutableList r = this.f6420e.r();
        if (!r.isEmpty()) {
            String str;
            this.f6422g.setText(this.f6420e.p());
            GraphQLStoryActionLink a = LeadGenUtil.a(leadGenDataExtractor.f6368d);
            if (a == null) {
                str = "";
            } else {
                str = a.am();
            }
            String str2 = str;
            List a2 = Lists.a();
            a2.addAll(r);
            a2.add(str2);
            ArrayAdapter c05872 = new ArrayAdapter<String>(this, getContext(), 17367048, a2) {
                final /* synthetic */ LeadGenSpinnerSelectInputView f6410a;

                public View getView(int i, View view, ViewGroup viewGroup) {
                    View view2 = super.getView(i, view, viewGroup);
                    ((TextView) view2.findViewById(16908308)).setHint(i == getCount() ? (String) getItem(getCount()) : "");
                    return view2;
                }

                public int getCount() {
                    return super.getCount() - 1;
                }
            };
            c05872.setDropDownViewResource(17367049);
            ArrayAdapter arrayAdapter = c05872;
            this.f6421f.setAdapter(arrayAdapter);
            this.f6421f.setSelection(arrayAdapter.getCount());
            m8248c(this);
            this.f6421f.post(new Runnable(this) {
                final /* synthetic */ LeadGenSpinnerSelectInputView f6412b;

                public void run() {
                    this.f6412b.f6421f.setOnItemSelectedListener(new C05894(this.f6412b, i));
                }
            });
        }
    }

    public GraphQLLeadGenInfoFieldData getBoundedInfoFieldData() {
        return this.f6420e;
    }

    public final void mo351a() {
        this.f6421f.setOnItemSelectedListener(null);
        this.f6424i = null;
    }

    public String getInputValue() {
        return this.f6421f.getSelectedItemPosition() == this.f6421f.getCount() ? "" : (String) this.f6421f.getSelectedItem();
    }

    public String getInputCustomToken() {
        ImmutableList a = this.f6420e.a();
        int selectedItemPosition = this.f6421f.getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition == this.f6421f.getCount() || a.isEmpty()) {
            return "";
        }
        return (String) a.get(selectedItemPosition);
    }

    public final void mo353a(String str) {
        LeadGenUIUtil.m8506a(this.f6423h, str);
    }

    public final void mo354b() {
        LeadGenUIUtil.m8505a(this.f6423h);
    }

    public void setInputValue(String str) {
        int a = LeadGenUtil.a(str, this.f6420e.r());
        if (a != -1) {
            this.f6421f.setSelection(a);
        }
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.f6424i = onDataChangeListener;
    }

    public static void m8248c(LeadGenSpinnerSelectInputView leadGenSpinnerSelectInputView) {
        leadGenSpinnerSelectInputView.post(new C05905(leadGenSpinnerSelectInputView));
    }
}
