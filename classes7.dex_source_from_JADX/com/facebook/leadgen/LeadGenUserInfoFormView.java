package com.facebook.leadgen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.model.GraphQLLeadGenData;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.input.LeadGenInputTypesManager;
import com.facebook.leadgen.input.LeadGenTextInputView;
import com.facebook.leadgen.util.LeadGenFormValidator;
import com.facebook.leadgen.util.LeadGenInfoFieldUserData;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: place_delete_review_failed */
public class LeadGenUserInfoFormView extends LeadGenFormPageView {
    private static final CallerContext f6336g = CallerContext.a(LeadGenUserInfoFormView.class, "native_newsfeed");
    @Inject
    LeadGenFormValidator f6337a;
    @Inject
    LeadGenLogger f6338b;
    @Inject
    LeadGenInputTypesManager f6339c;
    @Inject
    LeadGenUIUtil f6340d;
    @Inject
    LeadGenInfoTextControllerProvider f6341e;
    @Inject
    LeadGenLinkHandlerProvider f6342f;
    private HashMap<String, LeadGenInfoFieldUserData> f6343h;
    private LinearLayout f6344i;
    private LeadGenInfoTextController f6345j;
    public LeadGenDataExtractor f6346k;
    private int f6347l;

    public static void m8170a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LeadGenUserInfoFormView) obj).m8169a(LeadGenFormValidator.m8500a(injectorLike), LeadGenLogger.m8134a(injectorLike), LeadGenInputTypesManager.m8239a(injectorLike), LeadGenUIUtil.m8504a(injectorLike), (LeadGenInfoTextControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenInfoTextControllerProvider.class), (LeadGenLinkHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenLinkHandlerProvider.class));
    }

    public LeadGenUserInfoFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f6347l = i;
        setOrientation(1);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131429041);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setContentView(2130905027);
        Class cls = LeadGenUserInfoFormView.class;
        m8170a((Object) this, getContext());
    }

    public final void mo345a(GraphQLLeadGenPage graphQLLeadGenPage, int i, LeadGenDataExtractor leadGenDataExtractor, int i2, OnDataChangeListener onDataChangeListener) {
        if (leadGenDataExtractor.m8200a()) {
            this.f6346k = leadGenDataExtractor;
            m8167a(graphQLLeadGenPage, i2);
            setUpProgressBar(i);
            this.f6344i = (LinearLayout) a(2131563403);
            this.f6344i.removeAllViews();
            ImmutableList a = graphQLLeadGenPage.a();
            int size = a.size();
            for (int i3 = 0; i3 < size; i3++) {
                GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData = (GraphQLLeadGenInfoFieldData) a.get(i3);
                if (GraphQLLeadGenInfoFieldInputType.MESSENGER_CHECKBOX == graphQLLeadGenInfoFieldData.l()) {
                    this.f6344i.addView(View.inflate(getContext(), 2130905005, null));
                }
                View a2 = LeadGenInputTypesManager.m8237a(this, graphQLLeadGenInfoFieldData);
                ((LeadGenFieldInput) a2).mo352a(graphQLLeadGenInfoFieldData, this.f6346k, i);
                ((LeadGenFieldInput) a2).setOnDataChangeListener(onDataChangeListener);
                this.f6344i.addView(a2);
            }
            m8171e();
        }
    }

    private void m8171e() {
        LeadGenFieldInput leadGenFieldInput = (LeadGenFieldInput) this.f6344i.getChildAt(this.f6344i.getChildCount() - 1);
        if (leadGenFieldInput instanceof LeadGenTextInputView) {
            ((LeadGenTextInputView) leadGenFieldInput).f6432d.setImeOptions(6);
        }
    }

    public final void mo344a() {
        ImmutableList leadGenFieldInputs = getLeadGenFieldInputs();
        int size = leadGenFieldInputs.size();
        for (int i = 0; i < size; i++) {
            ((LeadGenFieldInput) leadGenFieldInputs.get(i)).mo351a();
        }
        this.f6345j.f6284c.setOnClickListener(null);
    }

    public final LeadGenUtil$ValidationResult mo348c(int i) {
        m8172f();
        LeadGenUtil$ValidationResult leadGenUtil$ValidationResult = LeadGenUtil$ValidationResult.NO_ERROR;
        ImmutableList leadGenFieldInputs = getLeadGenFieldInputs();
        int size = leadGenFieldInputs.size();
        int i2 = 0;
        while (i2 < size) {
            LeadGenFieldInput leadGenFieldInput = (LeadGenFieldInput) leadGenFieldInputs.get(i2);
            LeadGenInfoFieldUserData leadGenInfoFieldUserData = (LeadGenInfoFieldUserData) this.f6343h.get(leadGenFieldInput.getBoundedInfoFieldData().j());
            if (leadGenInfoFieldUserData == null) {
                return LeadGenUtil$ValidationResult.UNKNOWN_ERROR;
            }
            LeadGenUtil$ValidationResult leadGenUtil$ValidationResult2;
            m8168a(leadGenFieldInput, leadGenInfoFieldUserData);
            if (LeadGenFormValidator.m8501a(leadGenInfoFieldUserData)) {
                leadGenFieldInput.mo354b();
                leadGenUtil$ValidationResult2 = leadGenUtil$ValidationResult;
            } else {
                GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData = leadGenInfoFieldUserData.f6563b;
                for (LeadGenUtil$ValidationResult leadGenUtil$ValidationResult3 : LeadGenUtil$ValidationResult.values()) {
                    if (leadGenUtil$ValidationResult3.fieldInputType == graphQLLeadGenInfoFieldData.l()) {
                        break;
                    }
                }
                LeadGenUtil$ValidationResult leadGenUtil$ValidationResult32 = LeadGenUtil$ValidationResult.UNKNOWN_ERROR;
                leadGenUtil$ValidationResult = leadGenUtil$ValidationResult32;
                leadGenFieldInput.mo353a(this.f6346k.m8199a(leadGenUtil$ValidationResult));
                this.f6338b.m8142a("cta_lead_gen_user_info_validation_error", leadGenInfoFieldUserData.f6563b.j(), i);
                leadGenUtil$ValidationResult2 = leadGenUtil$ValidationResult;
            }
            i2++;
            leadGenUtil$ValidationResult = leadGenUtil$ValidationResult2;
        }
        return leadGenUtil$ValidationResult;
    }

    public final ImmutableList<LeadGenInfoFieldUserData> mo347b() {
        m8172f();
        ImmutableList leadGenFieldInputs = getLeadGenFieldInputs();
        int size = leadGenFieldInputs.size();
        for (int i = 0; i < size; i++) {
            LeadGenFieldInput leadGenFieldInput = (LeadGenFieldInput) leadGenFieldInputs.get(i);
            String j = leadGenFieldInput.getBoundedInfoFieldData().j();
            if (this.f6343h.containsKey(j)) {
                m8168a(leadGenFieldInput, (LeadGenInfoFieldUserData) this.f6343h.get(j));
            }
        }
        return new Builder().b(this.f6343h.values()).b();
    }

    public final void mo346a(LeadGenFormPendingInputEntry leadGenFormPendingInputEntry) {
        ImmutableList leadGenFieldInputs = getLeadGenFieldInputs();
        int size = leadGenFieldInputs.size();
        for (int i = 0; i < size; i++) {
            String str;
            LeadGenFieldInput leadGenFieldInput = (LeadGenFieldInput) leadGenFieldInputs.get(i);
            String j = leadGenFieldInput.getBoundedInfoFieldData().j();
            if (leadGenFormPendingInputEntry.f6364c.containsKey(j)) {
                str = (String) leadGenFormPendingInputEntry.f6364c.get(j);
            } else {
                str = null;
            }
            j = str;
            if (j != null) {
                leadGenFieldInput.setInputValue(j);
            }
        }
    }

    private static void m8168a(LeadGenFieldInput leadGenFieldInput, LeadGenInfoFieldUserData leadGenInfoFieldUserData) {
        String inputValue = leadGenFieldInput.getInputValue();
        String inputCustomToken = leadGenFieldInput.getInputCustomToken();
        GraphQLLeadGenInfoFieldData boundedInfoFieldData = leadGenFieldInput.getBoundedInfoFieldData();
        leadGenInfoFieldUserData.f6562a = inputValue;
        leadGenInfoFieldUserData.f6563b = boundedInfoFieldData;
        leadGenInfoFieldUserData.f6564c = inputCustomToken;
    }

    private void m8172f() {
        if (this.f6343h == null) {
            this.f6343h = new HashMap();
        }
        ImmutableList leadGenFieldInputs = getLeadGenFieldInputs();
        int size = leadGenFieldInputs.size();
        for (int i = 0; i < size; i++) {
            String j = ((LeadGenFieldInput) leadGenFieldInputs.get(i)).getBoundedInfoFieldData().j();
            if (!this.f6343h.containsKey(j)) {
                this.f6343h.put(j, new LeadGenInfoFieldUserData());
            }
        }
    }

    private void m8167a(GraphQLLeadGenPage graphQLLeadGenPage, final int i) {
        FbDraweeView fbDraweeView = (FbDraweeView) a(2131563365);
        fbDraweeView.a(this.f6346k.m8204m(), f6336g);
        fbDraweeView.setVisibility(0);
        TextView textView = (TextView) a(2131563402);
        TextView textView2 = (TextView) a(2131563384);
        TextView textView3 = (TextView) a(2131563385);
        this.f6345j = new LeadGenInfoTextController(LeadGenUIUtil.m8504a(this.f6341e), textView, textView2, textView3);
        ((TextView) a(2131563385)).setTag(2131558543, "cta_lead_gen_visit_privacy_page_click");
        LeadGenInfoTextController leadGenInfoTextController = this.f6345j;
        leadGenInfoTextController.f6284c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LeadGenUserInfoFormView f6335b;

            public void onClick(View view) {
                String str;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1139723398);
                this.f6335b.f6338b.m8141a("cta_lead_gen_visit_privacy_page_click", i);
                LeadGenLinkHandler a2 = this.f6335b.f6342f.m8133a(this.f6335b.f6346k.f6367c);
                GraphQLLeadGenData M = LeadGenUtil.a(this.f6335b.f6346k.f6368d).M();
                if (M == null) {
                    str = "";
                } else {
                    str = M.o();
                }
                a2.m8132b(view, str, false);
                Logger.a(2, EntryType.UI_INPUT_END, -399896846, a);
            }
        });
        GraphQLLeadGenPage graphQLLeadGenPage2 = graphQLLeadGenPage;
        this.f6345j.m8127a(graphQLLeadGenPage2, this.f6346k.m8205s(), (GraphQLStoryAttachment) this.f6346k.f6367c.a, i, this.f6347l);
        this.f6345j.m8128a(this.f6346k, LeadGenUtil$ValidationResult.NO_ERROR, graphQLLeadGenPage, i, this.f6347l);
    }

    private void m8169a(LeadGenFormValidator leadGenFormValidator, LeadGenLogger leadGenLogger, LeadGenInputTypesManager leadGenInputTypesManager, LeadGenUIUtil leadGenUIUtil, LeadGenInfoTextControllerProvider leadGenInfoTextControllerProvider, LeadGenLinkHandlerProvider leadGenLinkHandlerProvider) {
        this.f6337a = leadGenFormValidator;
        this.f6338b = leadGenLogger;
        this.f6339c = leadGenInputTypesManager;
        this.f6340d = leadGenUIUtil;
        this.f6341e = leadGenInfoTextControllerProvider;
        this.f6342f = leadGenLinkHandlerProvider;
    }

    private ImmutableList<LeadGenFieldInput> getLeadGenFieldInputs() {
        Builder builder = new Builder();
        for (int i = 0; i < this.f6344i.getChildCount(); i++) {
            if (this.f6344i.getChildAt(i) instanceof LeadGenFieldInput) {
                builder.c((LeadGenFieldInput) this.f6344i.getChildAt(i));
            }
        }
        return builder.b();
    }

    private void setUpProgressBar(int i) {
        ProgressBar progressBar = (ProgressBar) a(2131559418);
        Object obj = 1;
        if (LeadGenUtil.v(this.f6346k.f6368d) <= 1) {
            obj = null;
        }
        if (obj == null) {
            progressBar.setVisibility(8);
            return;
        }
        progressBar.setMax(LeadGenUtil.v(this.f6346k.f6368d));
        progressBar.setVisibility(0);
        int i2 = i + 1;
        if (!this.f6346k.m8203e()) {
            i = i2;
        }
        progressBar.setProgress(i);
    }
}
