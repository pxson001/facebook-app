package com.facebook.leadgen;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
import com.facebook.graphql.model.GraphQLLeadGenLegalContentCheckbox;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLLeadGenPrivacyNode;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.LeadGenReadMorePillController.C05732;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.event.LeadGenEventBus;
import com.facebook.leadgen.event.LeadGenEvents.SubmitButtonEnabledEvent;
import com.facebook.leadgen.input.LeadGenCheckBoxInputView;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.util.LeadGenInfoFieldUserData;
import com.facebook.widget.FbScrollView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: place_image */
public class LeadGenNewCustomDisclaimerView extends LeadGenFormPageView {
    @Inject
    public LeadGenEventBus f6307a;
    public FbScrollView f6308b = ((FbScrollView) a(2131563395));
    public TextView f6309c = ((TextView) a(2131563396));
    public TextView f6310d = ((TextView) a(2131563397));
    private LeadGenDataExtractor f6311e;
    public TextView f6312f = ((TextView) a(2131563399));
    public LinearLayout f6313g = ((LinearLayout) findViewById(2131563398));
    public List<LeadGenCheckBoxInputView> f6314h = new ArrayList();
    public List<LeadGenCheckBoxInputView> f6315i = new ArrayList();
    public View f6316j = ((ViewStub) a(2131563400)).inflate();
    public LeadGenReadMorePillController f6317k = new LeadGenReadMorePillController(getContext(), this.f6316j, this.f6308b);

    /* compiled from: place_image */
    class C05691 implements OnGlobalLayoutListener {
        final /* synthetic */ LeadGenNewCustomDisclaimerView f6304a;

        C05691(LeadGenNewCustomDisclaimerView leadGenNewCustomDisclaimerView) {
            this.f6304a = leadGenNewCustomDisclaimerView;
        }

        public void onGlobalLayout() {
            if (this.f6304a.f6308b.a()) {
                this.f6304a.f6307a.a(new SubmitButtonEnabledEvent(true));
            }
        }
    }

    /* compiled from: place_image */
    class C05702 implements OnScrollChangedListener {
        final /* synthetic */ LeadGenNewCustomDisclaimerView f6305a;

        C05702(LeadGenNewCustomDisclaimerView leadGenNewCustomDisclaimerView) {
            this.f6305a = leadGenNewCustomDisclaimerView;
        }

        public void onScrollChanged() {
            if (this.f6305a.f6308b.a()) {
                this.f6305a.f6307a.a(new SubmitButtonEnabledEvent(true));
            }
        }
    }

    /* compiled from: place_image */
    /* synthetic */ class C05713 {
        static final /* synthetic */ int[] f6306a = new int[GraphQLLeadGenPrivacyType.values().length];

        static {
            try {
                f6306a[GraphQLLeadGenPrivacyType.DISCLAIMER_PAGE_TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6306a[GraphQLLeadGenPrivacyType.CUSTOMIZED_DISCLAIMER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6306a[GraphQLLeadGenPrivacyType.PRIVACY_LINK_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m8145a(Object obj, Context context) {
        ((LeadGenNewCustomDisclaimerView) obj).f6307a = LeadGenEventBus.m8217a(FbInjector.get(context));
    }

    public LeadGenNewCustomDisclaimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = LeadGenNewCustomDisclaimerView.class;
        m8145a(this, getContext());
        setContentView(2130905025);
        LeadGenReadMorePillController leadGenReadMorePillController = this.f6317k;
        leadGenReadMorePillController.f6330a.a(leadGenReadMorePillController.f6333d);
        leadGenReadMorePillController.f6331b.setOnClickListener(new C05732(leadGenReadMorePillController));
    }

    public final void mo345a(GraphQLLeadGenPage graphQLLeadGenPage, int i, LeadGenDataExtractor leadGenDataExtractor, int i2, OnDataChangeListener onDataChangeListener) {
        this.f6311e = leadGenDataExtractor;
        String str = null;
        if (this.f6311e.m8200a()) {
            if (LeadGenUtil.b(graphQLLeadGenPage)) {
                ImmutableList j = graphQLLeadGenPage.j();
                int size = j.size();
                int i3 = 0;
                while (i3 < size) {
                    String str2;
                    GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode = (GraphQLLeadGenPrivacyNode) j.get(i3);
                    String a = graphQLLeadGenPrivacyNode.a();
                    switch (C05713.f6306a[graphQLLeadGenPrivacyNode.j().ordinal()]) {
                        case 1:
                            this.f6309c.setText(a);
                            str2 = str;
                            break;
                        case 2:
                            this.f6310d.setText(Html.fromHtml(a));
                            str2 = str;
                            break;
                        case 3:
                            str2 = a;
                            break;
                        default:
                            str2 = str;
                            break;
                    }
                    i3++;
                    str = str2;
                }
            } else if (this.f6311e.m8197L()) {
                this.f6309c.setText(this.f6311e.f6370f.M().l().l());
                this.f6310d.setText(this.f6311e.m8196J());
                this.f6310d.setMovementMethod(LinkMovementMethod.getInstance());
                this.f6313g.removeAllViews();
                ImmutableList j2 = this.f6311e.f6370f.M().l().j();
                if (!(j2 == null && j2.isEmpty())) {
                    int size2 = j2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox = (GraphQLLeadGenLegalContentCheckbox) j2.get(i4);
                        Object leadGenCheckBoxInputView = new LeadGenCheckBoxInputView(getContext());
                        leadGenCheckBoxInputView.m8228a(m8144a(graphQLLeadGenLegalContentCheckbox));
                        leadGenCheckBoxInputView.setChecked(graphQLLeadGenLegalContentCheckbox.l());
                        leadGenCheckBoxInputView.f6387e = graphQLLeadGenLegalContentCheckbox.m();
                        leadGenCheckBoxInputView.f6388f = graphQLLeadGenLegalContentCheckbox.n();
                        this.f6315i.add(leadGenCheckBoxInputView);
                        if (graphQLLeadGenLegalContentCheckbox.m()) {
                            this.f6314h.add(leadGenCheckBoxInputView);
                        }
                        this.f6313g.addView(leadGenCheckBoxInputView);
                    }
                }
            }
            this.f6312f.setText(this.f6311e.m8198a(str));
            this.f6312f.setMovementMethod(LinkMovementMethod.getInstance());
            this.f6308b.getViewTreeObserver().addOnGlobalLayoutListener(new C05691(this));
            this.f6308b.getViewTreeObserver().addOnScrollChangedListener(new C05702(this));
        }
    }

    private SpannableString m8144a(GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox) {
        String a = graphQLLeadGenLegalContentCheckbox.j().a();
        String str = "";
        if (!graphQLLeadGenLegalContentCheckbox.m()) {
            str = " (" + getResources().getString(2131238114) + ")";
        }
        SpannableString spannableString = new SpannableString(a + str);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131363584)), 0, StringLengthHelper.a(a), 18);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131363589)), StringLengthHelper.a(a), StringLengthHelper.a(str) + StringLengthHelper.a(a), 18);
        return spannableString;
    }

    public final void mo344a() {
        if (this.f6317k != null) {
            LeadGenReadMorePillController leadGenReadMorePillController = this.f6317k;
            leadGenReadMorePillController.f6331b.setOnClickListener(null);
            leadGenReadMorePillController.f6330a.b(leadGenReadMorePillController.f6333d);
        }
    }

    public final LeadGenUtil$ValidationResult mo348c(int i) {
        LeadGenUtil$ValidationResult leadGenUtil$ValidationResult = LeadGenUtil$ValidationResult.NO_ERROR;
        for (int i2 = 0; i2 < this.f6314h.size(); i2++) {
            LeadGenCheckBoxInputView leadGenCheckBoxInputView = (LeadGenCheckBoxInputView) this.f6314h.get(i2);
            if (Boolean.valueOf(leadGenCheckBoxInputView.getInputValue()).booleanValue()) {
                leadGenCheckBoxInputView.mo354b();
            } else {
                leadGenCheckBoxInputView.mo353a(leadGenCheckBoxInputView.getErrorMessage());
                leadGenUtil$ValidationResult = LeadGenUtil$ValidationResult.PRIVACY_CHECKBOX_ERROR;
            }
        }
        return leadGenUtil$ValidationResult;
    }

    public final ImmutableList<LeadGenInfoFieldUserData> mo347b() {
        return null;
    }

    public final void mo346a(LeadGenFormPendingInputEntry leadGenFormPendingInputEntry) {
    }

    public final ImmutableMap<String, String> mo349c() {
        Map hashMap = new HashMap();
        for (LeadGenCheckBoxInputView leadGenCheckBoxInputView : this.f6315i) {
            if (!this.f6314h.contains(leadGenCheckBoxInputView)) {
                hashMap.put(leadGenCheckBoxInputView.f6388f, leadGenCheckBoxInputView.getInputValue());
            }
        }
        return ImmutableMap.copyOf(hashMap);
    }
}
