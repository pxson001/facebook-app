package com.facebook.socialgood.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.FundraiserCampaignDonationCreateInputData;
import com.facebook.graphql.calls.FundraiserCampaignDonationCreateInputData.DonationAmount;
import com.facebook.graphql.calls.FundraiserCampaignDonationCreateInputData.PaymentMethodType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLMobilePaymentOption;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.socialgood.protocol.FetchFundraiserCampaign.FetchDonationPaymentMethodsQueryString;
import com.facebook.socialgood.protocol.FetchFundraiserCampaign.FetchFundraiserCampaignQueryString;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.CurrencyAmountFieldsModel;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.CurrencyAmountFieldsModel.Builder;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.FetchDonationPaymentMethodsQueryModel;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.FetchDonationPaymentMethodsQueryModel.FundraiserPaymentInfoModel.MethodsModel;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.FundraiserCampaignFragmentModel;
import com.facebook.socialgood.protocol.FundraiserCampaignDonateMutation.FundraiserCampaignDonateMutationString;
import com.facebook.socialgood.protocol.FundraiserCampaignDonateMutationModels.FundraiserCampaignDonateMutationFieldsModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterEditTextView.TextInteractionListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: ONE_BIG_SIDE_SMALL_GRID */
public class FundraiserDonationFragment extends FbFragment {
    private static final String f12817a = FundraiserDonationFragment.class.getName();
    private static final CallerContext f12818b = CallerContext.a(FundraiserDonationFragment.class);
    private boolean aA = false;
    private boolean aB = true;
    private boolean aC = true;
    private FundraiserCampaignFragmentModel aD;
    private FetchDonationPaymentMethodsQueryModel aE;
    private LinearLayout aF;
    private int aG = 0;
    private ArrayList<PaymentMethodData> aH;
    private ArrayList<FundraiserDonationPaymentMethodView> aI;
    public OnClickListener aJ;
    private int aK = -1;
    public CurrencyAmountFieldsModel aL;
    public CurrencyAmountFieldsModel aM;
    private CurrencyAmountFieldsModel aN;
    private ArrayList<TextView> aO;
    private ImmutableList<CurrencyAmountFieldsModel> aP;
    public OnClickListener aQ;
    private boolean aR = false;
    public String aS;
    private Currency aT;
    public OnTouchListener aU;
    public TextInteractionListener aV;
    public SegmentedLinearLayout al;
    public LoadingIndicatorView am;
    private FbDraweeView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private BetterEditTextView as;
    private TextView at;
    private InterceptingFrameLayout au;
    private TextView av;
    private TextView aw;
    private FrameLayout ax;
    public CheckBox ay;
    private boolean az = false;
    @Inject
    public AllCapsTransformationMethod f12819c;
    @Inject
    public AbstractFbErrorReporter f12820d;
    @Inject
    public GraphQLQueryExecutor f12821e;
    @Inject
    @ForUiThreadImmediate
    public ExecutorService f12822f;
    private String f12823g;
    public String f12824h;
    private ViewGroup f12825i;

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class C15031 implements OnClickListener {
        final /* synthetic */ FundraiserDonationFragment f12802a;

        C15031(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12802a = fundraiserDonationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -280568435);
            this.f12802a.o().finish();
            Logger.a(2, EntryType.UI_INPUT_END, -1372046937, a);
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class C15042 implements OnClickListener {
        final /* synthetic */ FundraiserDonationFragment f12803a;

        C15042(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12803a = fundraiserDonationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -188346845);
            FundraiserDonationFragment.ar(this.f12803a);
            Logger.a(2, EntryType.UI_INPUT_END, 1130995154, a);
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class C15053 implements OnClickListener {
        final /* synthetic */ FundraiserDonationFragment f12804a;

        C15053(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12804a = fundraiserDonationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1915449290);
            this.f12804a.ay.setChecked(!this.f12804a.ay.isChecked());
            LogUtils.a(1614575136, a);
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    public class C15064 implements OnTouchListener {
        final /* synthetic */ FundraiserDonationFragment f12805a;

        public C15064(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12805a = fundraiserDonationFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            FundraiserDonationFragment.m13473a(this.f12805a, true);
            if (motionEvent.getAction() == 1) {
                view.performClick();
            }
            return false;
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    public class C15075 implements OnClickListener {
        final /* synthetic */ FundraiserDonationFragment f12806a;

        public C15075(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12806a = fundraiserDonationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1631300845);
            if (view.getTag() instanceof Integer) {
                FundraiserDonationFragment.m13479g(this.f12806a, ((Integer) view.getTag()).intValue());
                FundraiserDonationFragment.m13473a(this.f12806a, false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1674208691, a);
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    public class C15086 implements OnClickListener {
        final /* synthetic */ FundraiserDonationFragment f12807a;

        public C15086(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12807a = fundraiserDonationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -542229329);
            if (view.getTag() instanceof Integer) {
                FundraiserDonationFragment.m13482j(this.f12807a, ((Integer) view.getTag()).intValue());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1671926833, a);
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    public class C15097 implements TextInteractionListener {
        final /* synthetic */ FundraiserDonationFragment f12808a;

        public C15097(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12808a = fundraiserDonationFragment;
        }

        public final void m13465a(CharSequence charSequence) {
            this.f12808a.aS = charSequence.toString();
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class FundraiserCampaignDonateMutationCallback implements FutureCallback<GraphQLResult<FundraiserCampaignDonateMutationFieldsModel>> {
        final /* synthetic */ FundraiserDonationFragment f12809a;

        public FundraiserCampaignDonateMutationCallback(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12809a = fundraiserDonationFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FundraiserDonationFragment fundraiserDonationFragment = this.f12809a;
        }

        public void onFailure(Throwable th) {
            FundraiserDonationFragment fundraiserDonationFragment = this.f12809a;
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class FundraiserCampaignReceivedCallback implements FutureCallback<GraphQLResult<FundraiserCampaignFragmentModel>> {
        final /* synthetic */ FundraiserDonationFragment f12810a;

        public FundraiserCampaignReceivedCallback(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12810a = fundraiserDonationFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FundraiserDonationFragment.m13472a(this.f12810a, (FundraiserCampaignFragmentModel) graphQLResult.e);
            }
        }

        public void onFailure(Throwable th) {
            this.f12810a.f12820d.a("fundraiser_campaign_fragment_fetch_fail", "Failed to fetch fundraiser information (initial fetch)");
            FundraiserDonationFragment.av(this.f12810a);
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class PaymentMethodData {
        String f12811a;
        String f12812b;
        String f12813c;
        PaymentMethodDataType f12814d;
        GraphQLMobilePaymentOption f12815e;

        /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
        enum PaymentMethodDataType {
            NEW,
            EXISTING
        }

        public static PaymentMethodData m13466a() {
            return new PaymentMethodData(null, null, null, PaymentMethodDataType.NEW, null);
        }

        public static PaymentMethodData m13467a(MethodsModel methodsModel) {
            return new PaymentMethodData(methodsModel.m13234a(), methodsModel.m13235j(), methodsModel.m13236k(), PaymentMethodDataType.EXISTING, methodsModel.m13237l());
        }

        private PaymentMethodData(String str, String str2, String str3, PaymentMethodDataType paymentMethodDataType, GraphQLMobilePaymentOption graphQLMobilePaymentOption) {
            this.f12811a = str;
            this.f12812b = str2;
            this.f12813c = str3;
            this.f12814d = paymentMethodDataType;
            this.f12815e = graphQLMobilePaymentOption;
        }
    }

    /* compiled from: ONE_BIG_SIDE_SMALL_GRID */
    class PaymentMethodsReceivedCallback implements FutureCallback<GraphQLResult<FetchDonationPaymentMethodsQueryModel>> {
        final /* synthetic */ FundraiserDonationFragment f12816a;

        public PaymentMethodsReceivedCallback(FundraiserDonationFragment fundraiserDonationFragment) {
            this.f12816a = fundraiserDonationFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FundraiserDonationFragment.m13471a(this.f12816a, (FetchDonationPaymentMethodsQueryModel) graphQLResult.e);
            }
        }

        public void onFailure(Throwable th) {
            this.f12816a.f12820d.a("fundraiser_campaign_fragment_fetch_fail", "Failed to fetch payment methods (initial fetch)");
            FundraiserDonationFragment.ax(this.f12816a);
        }
    }

    public static void m13474a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FundraiserDonationFragment fundraiserDonationFragment = (FundraiserDonationFragment) obj;
        AllCapsTransformationMethod b = AllCapsTransformationMethod.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(fbInjector);
        fundraiserDonationFragment.f12819c = b;
        fundraiserDonationFragment.f12820d = abstractFbErrorReporter;
        fundraiserDonationFragment.f12821e = a;
        fundraiserDonationFragment.f12822f = executorService;
    }

    public final void m13488c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FundraiserDonationFragment.class;
        m13474a((Object) this, getContext());
        this.f12823g = this.s.getString("source");
        this.f12824h = this.s.getString("fundraiser_campaign_id");
        if (StringUtil.a(this.f12824h)) {
            this.f12820d.b("fundraiser_donation_fragment_no_campaign_id", "No campaign ID passed in");
        }
    }

    public final View m13486a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1439448034);
        this.f12825i = (ViewGroup) layoutInflater.inflate(2130904558, viewGroup, false);
        this.an = (FbDraweeView) this.f12825i.findViewById(2131562435);
        this.ao = (TextView) this.f12825i.findViewById(2131562436);
        this.ap = (TextView) this.f12825i.findViewById(2131562437);
        this.aq = (TextView) this.f12825i.findViewById(2131562438);
        this.aq.setText(this.f12819c.getTransformation(b(2131242330), this.f12825i));
        this.ar = (TextView) this.f12825i.findViewById(2131562440);
        this.as = (BetterEditTextView) this.f12825i.findViewById(2131562442);
        this.au = (InterceptingFrameLayout) this.f12825i.findViewById(2131562441);
        this.au.f12855a = this.as;
        this.at = (TextView) this.f12825i.findViewById(2131562443);
        this.at.setText(this.f12819c.getTransformation(b(2131242331), this.f12825i));
        this.aF = (LinearLayout) this.f12825i.findViewById(2131562444);
        this.av = (TextView) this.f12825i.findViewById(2131562447);
        this.av.setText(this.f12819c.getTransformation(b(2131230727), this.f12825i));
        this.av.setOnClickListener(new C15031(this));
        this.aw = (TextView) this.f12825i.findViewById(2131562448);
        this.aw.setText(this.f12819c.getTransformation(b(2131242334), this.f12825i));
        this.aw.setOnClickListener(new C15042(this));
        this.ay = (CheckBox) this.f12825i.findViewById(2131562446);
        this.ax = (FrameLayout) this.f12825i.findViewById(2131562445);
        this.ax.setOnClickListener(new C15053(this));
        this.am = (LoadingIndicatorView) this.f12825i.findViewById(2131562449);
        this.al = (SegmentedLinearLayout) this.f12825i.findViewById(2131562433);
        this.am.setVisibility(0);
        this.al.setVisibility(8);
        this.am.a();
        View view = this.f12825i;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1038324070, a);
        return view;
    }

    public final void m13489e(Bundle bundle) {
        super.e(bundle);
        FlatBufferModelHelper.a(bundle, "fundraiser_campaign_model", this.aD);
        FlatBufferModelHelper.a(bundle, "payment_methods_model", this.aE);
        bundle.putString("campaign_id", this.f12824h);
        bundle.putString("custom_field_value", this.aS);
        bundle.putBoolean("custom_field_active", this.aR);
        bundle.putInt("curr_selected_donation_amount_index", this.aK);
        bundle.putInt("curr_selected_payment_method_index", this.aG);
        bundle.putBoolean("should_fetch_fundraiser_information", this.aB);
        bundle.putBoolean("should_fetch_payment_methods", this.aC);
        if (this.ay != null) {
            bundle.putBoolean("allow_others_to_see_checked", this.ay.isChecked());
        }
    }

    public final void m13487a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.aU = new C15064(this);
        this.aQ = new C15075(this);
        this.aJ = new C15086(this);
        this.aV = new C15097(this);
        m13485n(bundle);
    }

    private void m13485n(Bundle bundle) {
        if (bundle == null || this.f12824h == null || !this.f12824h.equals(bundle.getString("campaign_id"))) {
            m13478e();
            aq();
        } else if (this.f12824h.equals(bundle.getString("campaign_id"))) {
            this.aK = bundle.getInt("curr_selected_donation_amount_index", 0);
            this.aG = bundle.getInt("curr_selected_payment_method_index", 0);
            this.aR = bundle.getBoolean("custom_field_active", false);
            this.aB = bundle.getBoolean("should_fetch_fundraiser_information", true);
            this.aC = bundle.getBoolean("should_fetch_payment_methods", true);
            if (this.aR) {
                this.aS = bundle.getString("custom_field_value", "");
                this.as.setText(this.aS);
            }
            this.ay.setChecked(bundle.getBoolean("allow_others_to_see_checked", false));
            if (bundle.getParcelable("fundraiser_campaign_model") != null) {
                m13472a(this, (FundraiserCampaignFragmentModel) FlatBufferModelHelper.a(bundle, "fundraiser_campaign_model"));
            } else {
                m13478e();
            }
            if (bundle.getParcelable("payment_methods_model") != null) {
                m13471a(this, (FetchDonationPaymentMethodsQueryModel) FlatBufferModelHelper.a(bundle, "payment_methods_model"));
            } else {
                aq();
            }
        }
    }

    private boolean m13478e() {
        if (!this.aB) {
            return false;
        }
        GraphQLRequest a = GraphQLRequest.a(new FetchFundraiserCampaignQueryString());
        a.a(new FetchFundraiserCampaignQueryString().a("node_id", this.f12824h).a("default_image_scale", GraphQlQueryDefaults.a()).a);
        Futures.a(this.f12821e.a(a), new FundraiserCampaignReceivedCallback(this), this.f12822f);
        return true;
    }

    private boolean aq() {
        if (!this.aC) {
            return false;
        }
        Futures.a(this.f12821e.a(GraphQLRequest.a(new FetchDonationPaymentMethodsQueryString())), new PaymentMethodsReceivedCallback(this), this.f12822f);
        return true;
    }

    public static void m13479g(FundraiserDonationFragment fundraiserDonationFragment, int i) {
        if (fundraiserDonationFragment.aK != i) {
            fundraiserDonationFragment.m13480h(fundraiserDonationFragment.aK);
            fundraiserDonationFragment.m13481i(i);
            fundraiserDonationFragment.aK = i;
        }
    }

    private void m13480h(int i) {
        TextView textView = (TextView) this.aO.get(i);
        if (textView != null) {
            textView.setSelected(false);
        }
    }

    private void m13481i(int i) {
        TextView textView = (TextView) this.aO.get(i);
        if (textView != null) {
            textView.setSelected(true);
        }
    }

    public static void ar(FundraiserDonationFragment fundraiserDonationFragment) {
        CurrencyAmountFieldsModel currencyAmountFieldsModel;
        if (fundraiserDonationFragment.aR) {
            if (!fundraiserDonationFragment.aS.isEmpty()) {
                try {
                    CurrencyAmountFieldsModel a = new Builder().m13218a(Integer.parseInt(fundraiserDonationFragment.aS) * 100).m13219a(fundraiserDonationFragment.aT.getCurrencyCode()).m13220a();
                    if (fundraiserDonationFragment.m13475a(a)) {
                        currencyAmountFieldsModel = a;
                    } else {
                        return;
                    }
                } catch (NumberFormatException e) {
                    fundraiserDonationFragment.f12820d.b("fundraiser_campaign_non_number_amount", "Custom amount entered is not a number: " + e.getMessage());
                    return;
                }
            }
            return;
        } else if (fundraiserDonationFragment.aP.get(fundraiserDonationFragment.aK) == null) {
            fundraiserDonationFragment.f12820d.b("fundraiser_campaign_fragment_no_selected_donation_amount", "No selected amount in donation amount picker, but custom field inactive");
            return;
        } else {
            currencyAmountFieldsModel = (CurrencyAmountFieldsModel) fundraiserDonationFragment.aP.get(fundraiserDonationFragment.aK);
        }
        if (fundraiserDonationFragment.aH.get(fundraiserDonationFragment.aG) == null) {
            fundraiserDonationFragment.f12820d.b("fundraiser_campaign_fragment_no_selected_payment_method", "No selected payment method");
            return;
        }
        String str = ((PaymentMethodData) fundraiserDonationFragment.aH.get(fundraiserDonationFragment.aG)).f12811a;
        if (((PaymentMethodData) fundraiserDonationFragment.aH.get(fundraiserDonationFragment.aG)).f12814d == PaymentMethodDataType.NEW) {
            return;
        }
        if (str == null) {
            throw new RuntimeException(f12817a + ": credential_id for selected method is null");
        }
        GraphQLMobilePaymentOption graphQLMobilePaymentOption = ((PaymentMethodData) fundraiserDonationFragment.aH.get(fundraiserDonationFragment.aG)).f12815e;
        if (graphQLMobilePaymentOption == null) {
            throw new RuntimeException(f12817a + ": payment_method_type for selected method is null");
        }
        Futures.a(fundraiserDonationFragment.m13469a(currencyAmountFieldsModel, str, graphQLMobilePaymentOption), new FundraiserCampaignDonateMutationCallback(fundraiserDonationFragment), fundraiserDonationFragment.f12822f);
    }

    private boolean m13475a(CurrencyAmountFieldsModel currencyAmountFieldsModel) {
        Preconditions.checkNotNull(currencyAmountFieldsModel);
        Preconditions.checkNotNull(currencyAmountFieldsModel.m13227j());
        Preconditions.checkArgument(currencyAmountFieldsModel.m13227j().equals(this.aL.m13227j()));
        if ((currencyAmountFieldsModel.m13223a() < this.aL.m13223a() ? 1 : null) != null) {
            return false;
        }
        Preconditions.checkNotNull(currencyAmountFieldsModel);
        Preconditions.checkNotNull(currencyAmountFieldsModel.m13227j());
        Preconditions.checkArgument(currencyAmountFieldsModel.m13227j().equals(this.aM.m13227j()));
        if ((currencyAmountFieldsModel.m13223a() > this.aM.m13223a() ? 1 : null) == null) {
            return true;
        }
        return false;
    }

    private ListenableFuture<GraphQLResult<FundraiserCampaignDonateMutationFieldsModel>> m13469a(CurrencyAmountFieldsModel currencyAmountFieldsModel, String str, GraphQLMobilePaymentOption graphQLMobilePaymentOption) {
        FundraiserCampaignDonationCreateInputData fundraiserCampaignDonationCreateInputData = new FundraiserCampaignDonationCreateInputData();
        DonationAmount donationAmount = new DonationAmount();
        donationAmount.a("amount_in_hundredths", Integer.valueOf(currencyAmountFieldsModel.m13223a()));
        GraphQlCallInput graphQlCallInput = donationAmount;
        graphQlCallInput.a("currency", currencyAmountFieldsModel.m13227j());
        fundraiserCampaignDonationCreateInputData.a("donation_amount", graphQlCallInput);
        GraphQlCallInput graphQlCallInput2 = fundraiserCampaignDonationCreateInputData;
        graphQlCallInput2.a("fundraiser_campaign_id", this.f12824h);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("payment_credential_id", str);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("payment_method_type", PaymentMethodType.valueOf(graphQLMobilePaymentOption.toString()));
        return this.f12821e.a(GraphQLRequest.a((FundraiserCampaignDonateMutationString) new FundraiserCampaignDonateMutationString().a("input", graphQlCallInput2)));
    }

    public static void m13472a(FundraiserDonationFragment fundraiserDonationFragment, FundraiserCampaignFragmentModel fundraiserCampaignFragmentModel) {
        if (fundraiserCampaignFragmentModel != null) {
            fundraiserDonationFragment.aD = fundraiserCampaignFragmentModel;
            fundraiserDonationFragment.ao.setText(fundraiserCampaignFragmentModel.m13256a());
            fundraiserDonationFragment.ap.setText(fundraiserCampaignFragmentModel.m13258k());
            if (fundraiserCampaignFragmentModel.m13259l() != null) {
                fundraiserDonationFragment.an.a(Uri.parse(fundraiserCampaignFragmentModel.m13259l().b()), f12818b);
                fundraiserDonationFragment.an.setVisibility(0);
            } else {
                fundraiserDonationFragment.an.setVisibility(8);
                fundraiserDonationFragment.f12820d.a("fundraiser_campaign_fragment_fundraiser_without_charity", StringFormatUtil.formatStrLocaleSafe("Encountered a fundraiser with no charities: %s", fundraiserCampaignFragmentModel.m13256a()));
            }
            fundraiserDonationFragment.aL = fundraiserCampaignFragmentModel.m13261n();
            fundraiserDonationFragment.aM = fundraiserCampaignFragmentModel.m13260m();
            fundraiserDonationFragment.aN = fundraiserCampaignFragmentModel.m13257j();
            fundraiserDonationFragment.aP = fundraiserCampaignFragmentModel.m13262o();
            fundraiserDonationFragment.at();
            fundraiserDonationFragment.as();
        } else {
            fundraiserDonationFragment.f12820d.a("fundraiser_campaign_fragment_model_null", "FundraiserCampaignFragmentModel returned from GraphQL request is null.");
        }
        fundraiserDonationFragment.az = true;
        fundraiserDonationFragment.ay();
    }

    public static void m13482j(FundraiserDonationFragment fundraiserDonationFragment, int i) {
        if (fundraiserDonationFragment.aG != i) {
            fundraiserDonationFragment.m13483k(fundraiserDonationFragment.aG);
            fundraiserDonationFragment.m13484l(i);
            fundraiserDonationFragment.aG = i;
        }
    }

    private void m13483k(int i) {
        FundraiserDonationPaymentMethodView fundraiserDonationPaymentMethodView = (FundraiserDonationPaymentMethodView) this.aI.get(i);
        if (fundraiserDonationPaymentMethodView != null) {
            fundraiserDonationPaymentMethodView.m13491c();
        }
    }

    private void m13484l(int i) {
        FundraiserDonationPaymentMethodView fundraiserDonationPaymentMethodView = (FundraiserDonationPaymentMethodView) this.aI.get(i);
        if (fundraiserDonationPaymentMethodView != null) {
            fundraiserDonationPaymentMethodView.setSelected(true);
            fundraiserDonationPaymentMethodView.f12829d.setChecked(true);
            fundraiserDonationPaymentMethodView.f12829d.setVisibility(0);
        }
    }

    private FundraiserDonationPaymentMethodView m13468a(PaymentMethodData paymentMethodData, OnClickListener onClickListener, int i) {
        FundraiserDonationPaymentMethodView fundraiserDonationPaymentMethodView = new FundraiserDonationPaymentMethodView(getContext());
        if (paymentMethodData.f12814d == PaymentMethodDataType.NEW) {
            fundraiserDonationPaymentMethodView.setText(jW_().getString(2131242332));
            fundraiserDonationPaymentMethodView.m13490a();
        } else {
            fundraiserDonationPaymentMethodView.setText(paymentMethodData.f12812b);
            String str = paymentMethodData.f12813c;
            if (str != null) {
                fundraiserDonationPaymentMethodView.f12827b.a(Uri.parse(str), FundraiserDonationPaymentMethodView.f12826a);
                fundraiserDonationPaymentMethodView.f12827b.setVisibility(0);
            } else {
                fundraiserDonationPaymentMethodView.m13490a();
            }
        }
        fundraiserDonationPaymentMethodView.setTag(Integer.valueOf(i));
        fundraiserDonationPaymentMethodView.m13491c();
        fundraiserDonationPaymentMethodView.setOnClickListener(onClickListener);
        return fundraiserDonationPaymentMethodView;
    }

    private void as() {
        this.ar.setText(this.aT.getSymbol());
        this.aO = new ArrayList();
        LinearLayout linearLayout = (LinearLayout) this.f12825i.findViewById(2131562439);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            double d;
            TextView textView = (TextView) ((FrameLayout) linearLayout.getChildAt(i)).getChildAt(0);
            int size = this.aO.size();
            CurrencyAmountFieldsModel currencyAmountFieldsModel = (CurrencyAmountFieldsModel) this.aP.get(size);
            if (currencyAmountFieldsModel == null) {
                d = 0.0d;
            } else {
                d = ((double) currencyAmountFieldsModel.m13223a()) / 100.0d;
            }
            double d2 = d;
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setCurrency(Currency.getInstance(currencyAmountFieldsModel.m13227j()));
            currencyInstance.setMaximumFractionDigits(0);
            textView.setText(StringFormatUtil.formatStrLocaleSafe("%s", currencyInstance.format(d2)));
            textView.setTag(Integer.valueOf(size));
            textView.setOnClickListener(this.aQ);
            this.aO.add(textView);
            if (this.aK == -1 && m13476a((CurrencyAmountFieldsModel) this.aP.get(size), this.aN)) {
                this.aK = size;
            }
            if (this.aK != size || this.aR) {
                m13480h(size);
            } else {
                m13481i(this.aK);
            }
        }
        m13473a(this, this.aR);
        this.as.setOnTouchListener(this.aU);
        this.as.setTextInteractionListener(this.aV);
    }

    private void at() {
        if (this.aP.isEmpty()) {
            throw new RuntimeException(f12817a + ": The preset donation amounts list is empty.");
        }
        int i;
        int i2;
        int size = this.aP.size();
        for (i = 0; i < size; i++) {
            m13477d((CurrencyAmountFieldsModel) this.aP.get(i));
        }
        if (this.aN == null) {
            this.aN = (CurrencyAmountFieldsModel) this.aP.get(0);
        }
        m13477d(this.aN);
        m13477d(this.aL);
        m13477d(this.aM);
        String j = this.aN.m13227j();
        int size2 = this.aP.size();
        for (i = 0; i < size2; i++) {
            m13470a((CurrencyAmountFieldsModel) this.aP.get(i), j);
        }
        m13470a(this.aL, j);
        m13470a(this.aM, j);
        this.aT = Currency.getInstance(j);
        size = this.aP.size();
        for (i = 0; i < size; i++) {
            if (m13476a((CurrencyAmountFieldsModel) this.aP.get(i), this.aN)) {
                i2 = 1;
                break;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            this.f12820d.a("fundraiser_campaign_fragment_default_amount_not_in_list", "The default donation amount is not in the list of donation amounts");
            this.aN = (CurrencyAmountFieldsModel) this.aP.get(0);
        }
    }

    public static void m13473a(FundraiserDonationFragment fundraiserDonationFragment, boolean z) {
        fundraiserDonationFragment.aR = z;
        if (fundraiserDonationFragment.aR) {
            fundraiserDonationFragment.ar.setEnabled(true);
            fundraiserDonationFragment.as.setEnabled(true);
            fundraiserDonationFragment.m13480h(fundraiserDonationFragment.aK);
            return;
        }
        fundraiserDonationFragment.ar.setEnabled(false);
        fundraiserDonationFragment.as.setEnabled(false);
        fundraiserDonationFragment.as.a();
        fundraiserDonationFragment.m13481i(fundraiserDonationFragment.aK);
        fundraiserDonationFragment.aS = "";
    }

    public static void av(FundraiserDonationFragment fundraiserDonationFragment) {
        if (fundraiserDonationFragment.m13478e()) {
            fundraiserDonationFragment.aB = false;
        }
    }

    public static void m13471a(FundraiserDonationFragment fundraiserDonationFragment, FetchDonationPaymentMethodsQueryModel fetchDonationPaymentMethodsQueryModel) {
        int i = 0;
        if (fetchDonationPaymentMethodsQueryModel != null) {
            fundraiserDonationFragment.aE = fetchDonationPaymentMethodsQueryModel;
            fundraiserDonationFragment.aI = new ArrayList();
            fundraiserDonationFragment.aH = new ArrayList();
            if (fetchDonationPaymentMethodsQueryModel.m13247a() != null) {
                ArrayList arrayList;
                ImmutableList a = fetchDonationPaymentMethodsQueryModel.m13247a().m13242a();
                if (a.isEmpty()) {
                    arrayList = new ArrayList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        MethodsModel methodsModel = (MethodsModel) a.get(i2);
                        if (methodsModel.m13234a() == null) {
                            fundraiserDonationFragment.f12820d.a("fundraiser_campaign_fragment_invalid_payment_method", "Payment method has a null credential_id");
                        } else if (methodsModel.m13235j() == null || methodsModel.m13235j().isEmpty()) {
                            fundraiserDonationFragment.f12820d.a("fundraiser_campaign_fragment_invalid_payment_method", "Payment method has a null or empty label");
                        } else if (methodsModel.m13236k() == null) {
                            fundraiserDonationFragment.f12820d.a("fundraiser_campaign_fragment_invalid_payment_method", "Payment method has a null logo url");
                        } else if (methodsModel.m13237l() == null) {
                            fundraiserDonationFragment.f12820d.a("fundraiser_campaign_fragment_invalid_payment_method", "Payment method has a null payment type");
                        } else {
                            arrayList2.add(methodsModel);
                        }
                    }
                    arrayList = arrayList2;
                }
                ArrayList arrayList3 = arrayList;
                int size2 = arrayList3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    fundraiserDonationFragment.aH.add(PaymentMethodData.m13467a((MethodsModel) arrayList3.get(i3)));
                }
                fundraiserDonationFragment.aH.add(PaymentMethodData.m13466a());
                while (i < fundraiserDonationFragment.aH.size()) {
                    FundraiserDonationPaymentMethodView a2 = fundraiserDonationFragment.m13468a((PaymentMethodData) fundraiserDonationFragment.aH.get(i), fundraiserDonationFragment.aJ, i);
                    fundraiserDonationFragment.aF.addView(a2);
                    fundraiserDonationFragment.aI.add(a2);
                    if (fundraiserDonationFragment.aG != i) {
                        fundraiserDonationFragment.m13483k(i);
                    } else {
                        fundraiserDonationFragment.m13484l(fundraiserDonationFragment.aG);
                    }
                    i++;
                }
            }
            fundraiserDonationFragment.aA = true;
            fundraiserDonationFragment.ay();
        }
    }

    public static void ax(FundraiserDonationFragment fundraiserDonationFragment) {
        if (fundraiserDonationFragment.aq()) {
            fundraiserDonationFragment.aC = false;
        }
    }

    private void ay() {
        if (this.az && this.aA) {
            this.am.setVisibility(8);
            this.al.setVisibility(0);
            this.am.b();
        }
    }

    private static void m13477d(CurrencyAmountFieldsModel currencyAmountFieldsModel) {
        if (currencyAmountFieldsModel == null || currencyAmountFieldsModel.m13227j() == null) {
            throw new RuntimeException(f12817a + ": One of the CurrencyAmounts is null or has a null currency.");
        }
    }

    private static void m13470a(CurrencyAmountFieldsModel currencyAmountFieldsModel, String str) {
        if (!str.equals(currencyAmountFieldsModel.m13227j())) {
            throw new RuntimeException("CurrencyAmount does not use the expected currency (" + str + ").");
        }
    }

    private static boolean m13476a(CurrencyAmountFieldsModel currencyAmountFieldsModel, CurrencyAmountFieldsModel currencyAmountFieldsModel2) {
        Preconditions.checkNotNull(currencyAmountFieldsModel);
        Preconditions.checkNotNull(currencyAmountFieldsModel2);
        Preconditions.checkNotNull(currencyAmountFieldsModel.m13227j());
        Preconditions.checkNotNull(currencyAmountFieldsModel2.m13227j());
        Preconditions.checkArgument(currencyAmountFieldsModel.m13227j().equals(currencyAmountFieldsModel2.m13227j()));
        return currencyAmountFieldsModel.m13223a() == currencyAmountFieldsModel2.m13223a();
    }
}
