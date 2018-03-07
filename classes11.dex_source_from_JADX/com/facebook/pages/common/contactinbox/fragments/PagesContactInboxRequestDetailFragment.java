package com.facebook.pages.common.contactinbox.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friends.protocol.BlockUserMethod.Params;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PageLeadgenInfoUpdateInputData;
import com.facebook.graphql.calls.PageLeadgenInfoUpdateInputData.State;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PageContactUsLeadFieldsModel;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxLeadUpdateMutations.PagesContactInboxLeadUpdateStateMutationString;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxLeadUpdateMutationsModels.PagesContactInboxLeadUpdateStateMutationModel;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxCache;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxTimeUtils;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxTimeUtils.AlertType;
import com.facebook.pages.common.logging.analytics.AdminContactInboxEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: step_description */
public class PagesContactInboxRequestDetailFragment extends PagesContactInboxBaseFragment {
    @Inject
    Lazy<SecureContextHelper> f1412a;
    public PageContactUsLeadFieldsModel al;
    public String am;
    public String an;
    private String ao;
    private final OnClickListener ap = new C01901(this);
    private final OnClickListener aq = new C01912(this);
    @Inject
    TimeFormatUtil f1413b;
    @Inject
    PagesContactInboxTimeUtils f1414c;
    @Inject
    public Lazy<TasksManager> f1415d;
    @Inject
    Lazy<BlueServiceOperationFactory> f1416e;
    @Inject
    Lazy<Toaster> f1417f;
    @Inject
    Lazy<GraphQLQueryExecutor> f1418g;
    @Inject
    public Lazy<PagesAnalytics> f1419h;
    @Inject
    PagesContactInboxCache f1420i;

    /* compiled from: step_description */
    class C01901 implements OnClickListener {
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1399a;

        C01901(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment) {
            this.f1399a = pagesContactInboxRequestDetailFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2116479960);
            ((PagesAnalytics) this.f1399a.f1419h.get()).a(AdminContactInboxEvent.EVENT_ADMIN_CONTACT_INBOX_TAPPED_PHONE_NUMBER, Long.parseLong(this.f1399a.am));
            ((SecureContextHelper) this.f1399a.f1412a.get()).b(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + this.f1399a.al.m2072q().m2059j())), this.f1399a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -814952223, a);
        }
    }

    /* compiled from: step_description */
    class C01912 implements OnClickListener {
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1400a;

        C01912(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment) {
            this.f1400a = pagesContactInboxRequestDetailFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -214918153);
            ((PagesAnalytics) this.f1400a.f1419h.get()).a(AdminContactInboxEvent.EVENT_ADMIN_CONTACT_INBOX_TAPPED_SEND_EMAIL, Long.parseLong(this.f1400a.am));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(268435456);
            intent.setType("vnd.android.cursor.item/email");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{this.f1400a.al.m2067l()});
            intent.putExtra("android.intent.extra.SUBJECT", this.f1400a.jW_().getString(2131241673, new Object[]{this.f1400a.an}));
            intent.putExtra("android.intent.extra.TEXT", PagesContactInboxRequestDetailFragment.m2041b(this.f1400a));
            ((SecureContextHelper) this.f1400a.f1412a.get()).b(Intent.createChooser(intent, this.f1400a.jW_().getString(2131241677)), view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1037558217, a);
        }
    }

    /* compiled from: step_description */
    class C01923 implements OnCheckedChangeListener {
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1401a;

        C01923(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment) {
            this.f1401a = pagesContactInboxRequestDetailFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PagesContactInboxRequestDetailFragment.m2039a(this.f1401a, z ? State.RESPONDED : State.READ);
        }
    }

    /* compiled from: step_description */
    class C01944 implements OnClickListener {
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1403a;

        /* compiled from: step_description */
        class C01931 implements DialogInterface.OnClickListener {
            final /* synthetic */ C01944 f1402a;

            C01931(C01944 c01944) {
                this.f1402a = c01944;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment = this.f1402a.f1403a;
                String r = this.f1402a.f1403a.al.m2073r();
                ((PagesAnalytics) pagesContactInboxRequestDetailFragment.f1419h.get()).i(Long.parseLong(pagesContactInboxRequestDetailFragment.am), r);
                ProgressDialog progressDialog = new ProgressDialog(pagesContactInboxRequestDetailFragment.getContext());
                progressDialog.a(pagesContactInboxRequestDetailFragment.jW_().getString(2131235122));
                progressDialog.show();
                Bundle bundle = new Bundle();
                bundle.putParcelable("blockUser", new Params(Long.parseLong(pagesContactInboxRequestDetailFragment.am), Long.parseLong(r)));
                ((TasksManager) pagesContactInboxRequestDetailFragment.f1415d.get()).a("contact_us_inbox_ban_person_with_id_" + r, new C01966(pagesContactInboxRequestDetailFragment, bundle), new C01977(pagesContactInboxRequestDetailFragment, progressDialog));
            }
        }

        C01944(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment) {
            this.f1403a = pagesContactInboxRequestDetailFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1460452254);
            new FbAlertDialogBuilder(this.f1403a.getContext()).a(this.f1403a.jW_().getString(2131235120)).b(this.f1403a.jW_().getString(2131235121, new Object[]{this.f1403a.al.m2069n(), this.f1403a.an})).a(2131230729, new C01931(this)).b(2131230727, null).b();
            Logger.a(2, EntryType.UI_INPUT_END, 1214044248, a);
        }
    }

    /* compiled from: step_description */
    public class C01966 implements Callable<ListenableFuture> {
        final /* synthetic */ Bundle f1406a;
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1407b;

        public C01966(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment, Bundle bundle) {
            this.f1407b = pagesContactInboxRequestDetailFragment;
            this.f1406a = bundle;
        }

        public Object call() {
            return BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f1407b.f1416e.get(), "friending_block_user", this.f1406a, ErrorPropagation.BY_EXCEPTION, CallerContext.a(PagesContactInboxRequestDetailFragment.class), 2097573892).a();
        }
    }

    /* compiled from: step_description */
    public class C01977 extends OperationResultFutureCallback {
        final /* synthetic */ ProgressDialog f1408a;
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1409b;

        public C01977(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment, ProgressDialog progressDialog) {
            this.f1409b = pagesContactInboxRequestDetailFragment;
            this.f1408a = progressDialog;
        }

        public final void m2032a(ServiceException serviceException) {
            this.f1408a.dismiss();
            ((Toaster) this.f1409b.f1417f.get()).a(new ToastBuilder(2131235124));
        }

        public final void m2033a(Object obj) {
            this.f1408a.dismiss();
            ((Toaster) this.f1409b.f1417f.get()).a(new ToastBuilder(2131235123, new Object[]{this.f1409b.al.m2069n(), this.f1409b.an}));
        }
    }

    /* compiled from: step_description */
    class C01988 extends AbstractDisposableFutureCallback<GraphQLResult<PagesContactInboxLeadUpdateStateMutationModel>> {
        final /* synthetic */ PagesContactInboxRequestDetailFragment f1410a;

        C01988(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment) {
            this.f1410a = pagesContactInboxRequestDetailFragment;
        }

        protected final void m2034a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (((PagesContactInboxLeadUpdateStateMutationModel) graphQLResult.e).m2123a() != null) {
                this.f1410a.f1420i.m2132a(this.f1410a.al.m2070o(), ((PagesContactInboxLeadUpdateStateMutationModel) graphQLResult.e).m2123a().m2119j());
            }
        }

        protected final void m2035a(Throwable th) {
        }
    }

    /* compiled from: step_description */
    enum ContactInfoType {
        EMAIL,
        PHONE
    }

    public static void m2040a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PagesContactInboxRequestDetailFragment) obj).m2038a(IdBasedSingletonScopeProvider.b(injectorLike, 968), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), PagesContactInboxTimeUtils.m2134b(injectorLike), IdBasedLazy.a(injectorLike, 3561), IdBasedLazy.a(injectorLike, 1144), IdBasedLazy.a(injectorLike, 3588), IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 8930), PagesContactInboxCache.m2129a(injectorLike));
    }

    private void m2038a(Lazy<SecureContextHelper> lazy, TimeFormatUtil timeFormatUtil, PagesContactInboxTimeUtils pagesContactInboxTimeUtils, Lazy<TasksManager> lazy2, Lazy<BlueServiceOperationFactory> lazy3, Lazy<Toaster> lazy4, Lazy<GraphQLQueryExecutor> lazy5, Lazy<PagesAnalytics> lazy6, PagesContactInboxCache pagesContactInboxCache) {
        this.f1412a = lazy;
        this.f1413b = timeFormatUtil;
        this.f1414c = pagesContactInboxTimeUtils;
        this.f1415d = lazy2;
        this.f1416e = lazy3;
        this.f1417f = lazy4;
        this.f1418g = lazy5;
        this.f1419h = lazy6;
        this.f1420i = pagesContactInboxCache;
    }

    public static PagesContactInboxRequestDetailFragment m2037a(PageContactUsLeadFieldsModel pageContactUsLeadFieldsModel, String str, String str2) {
        PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment = new PagesContactInboxRequestDetailFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "extra_request_key", pageContactUsLeadFieldsModel);
        bundle.putString("extra_page_id", str);
        bundle.putString("extra_page_name", str2);
        pagesContactInboxRequestDetailFragment.g(bundle);
        return pagesContactInboxRequestDetailFragment;
    }

    public final void m2046c(@Nullable Bundle bundle) {
        boolean z;
        boolean z2 = true;
        super.c(bundle);
        Class cls = PagesContactInboxRequestDetailFragment.class;
        m2040a((Object) this, getContext());
        this.al = (PageContactUsLeadFieldsModel) FlatBufferModelHelper.a(this.s, "extra_request_key");
        this.am = this.s.getString("extra_page_id");
        if (Strings.isNullOrEmpty(this.am)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        this.an = this.s.getString("extra_page_name");
        if (Strings.isNullOrEmpty(this.an)) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    public final View m2044a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View a;
        boolean z = false;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 813021941);
        View inflate = layoutInflater.inflate(2130906109, viewGroup, false);
        ((FbTextView) inflate.findViewById(2131565702)).setText(this.al.m2069n());
        ((FbTextView) inflate.findViewById(2131565704)).setText(this.al.m2065j());
        ((FbTextView) inflate.findViewById(2131565703)).setText(this.f1413b.a(TimeFormatStyle.SHORT_DATE_STYLE, this.al.m2066k() * 1000));
        LinearLayout linearLayout = (LinearLayout) inflate;
        if (this.f1414c.m2138b(this.al.m2068m() * 1000)) {
            m2042b(inflate);
        }
        if (!Strings.isNullOrEmpty(this.al.m2067l())) {
            a = m2036a(layoutInflater, linearLayout, ContactInfoType.EMAIL, this.al.m2067l());
            if (a != null) {
                a.setOnClickListener(this.aq);
                linearLayout.addView(a);
            }
        }
        if (!Strings.isNullOrEmpty(this.al.m2067l()) && m2043e()) {
            linearLayout.addView(layoutInflater.inflate(2130905994, linearLayout, false));
        }
        if (m2043e()) {
            a = m2036a(layoutInflater, linearLayout, ContactInfoType.PHONE, this.al.m2072q().m2058a());
            if (a != null) {
                a.setOnClickListener(this.ap);
                linearLayout.addView(a);
            }
        }
        View inflate2 = layoutInflater.inflate(2130906107, linearLayout, false);
        SwitchCompat switchCompat = (SwitchCompat) inflate2.findViewById(2131565694);
        if (aq() == GraphQLPageLeadGenInfoState.RESPONDED) {
            z = true;
        }
        switchCompat.setChecked(z);
        switchCompat.setOnCheckedChangeListener(new C01923(this));
        inflate2.findViewById(2131565695).setOnClickListener(new C01944(this));
        linearLayout.addView(inflate2);
        LogUtils.f(911115779, a2);
        return inflate;
    }

    public final void m2045a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (aq() == GraphQLPageLeadGenInfoState.UNREAD) {
            m2039a(this, State.READ);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2550397);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(this.al.m2069n());
            hasTitleBar.kg_();
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 188390085, a);
    }

    private View m2036a(LayoutInflater layoutInflater, ViewGroup viewGroup, ContactInfoType contactInfoType, String str) {
        int i;
        switch (contactInfoType) {
            case EMAIL:
                i = 2130839845;
                break;
            case PHONE:
                i = 2130840014;
                break;
            default:
                return null;
        }
        View inflate = layoutInflater.inflate(2130906108, viewGroup, false);
        ((GlyphView) inflate.findViewById(2131565696)).setImageDrawable(getContext().getResources().getDrawable(i));
        ((FbTextView) inflate.findViewById(2131565697)).setText(str);
        return inflate;
    }

    private void m2042b(View view) {
        final CustomRelativeLayout customRelativeLayout = (CustomRelativeLayout) view.findViewById(2131565698);
        int a = this.f1414c.m2135a(getContext(), this.al.m2068m() * 1000);
        GradientDrawable gradientDrawable = (GradientDrawable) jW_().getDrawable(2130842500);
        gradientDrawable.setStroke(jW_().getDimensionPixelSize(2131427380), a);
        CustomViewUtils.b(customRelativeLayout, gradientDrawable);
        CustomViewUtils.b(customRelativeLayout.findViewById(2131565699), new ColorDrawable(a));
        FbTextView fbTextView = (FbTextView) customRelativeLayout.findViewById(2131565700);
        PagesContactInboxTimeUtils pagesContactInboxTimeUtils = this.f1414c;
        Context context = getContext();
        long m = this.al.m2068m() * 1000;
        AlertType alertType = AlertType.DETAIL;
        fbTextView.setText(pagesContactInboxTimeUtils.m2137b(context, m));
        customRelativeLayout.findViewById(2131565701).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesContactInboxRequestDetailFragment f1405b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -29807713);
                customRelativeLayout.setVisibility(8);
                Logger.a(2, EntryType.UI_INPUT_END, 957701627, a);
            }
        });
        customRelativeLayout.setVisibility(0);
    }

    public static void m2039a(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment, State state) {
        if (!Strings.isNullOrEmpty(pagesContactInboxRequestDetailFragment.al.m2070o())) {
            Object obj = "pages_contact_inbox_update_state_mutation_" + pagesContactInboxRequestDetailFragment.al.m2070o();
            if (pagesContactInboxRequestDetailFragment.aq() != GraphQLPageLeadGenInfoState.UNREAD) {
                ((PagesAnalytics) pagesContactInboxRequestDetailFragment.f1419h.get()).c(Long.parseLong(pagesContactInboxRequestDetailFragment.am), state == State.RESPONDED);
            } else {
                String str = obj + "_from_UNREAD_to_READ";
            }
            PageLeadgenInfoUpdateInputData pageLeadgenInfoUpdateInputData = new PageLeadgenInfoUpdateInputData();
            pageLeadgenInfoUpdateInputData.a("id", pagesContactInboxRequestDetailFragment.al.m2070o());
            GraphQlCallInput graphQlCallInput = pageLeadgenInfoUpdateInputData;
            graphQlCallInput.a("state", state);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString pagesContactInboxLeadUpdateStateMutationString = new PagesContactInboxLeadUpdateStateMutationString();
            pagesContactInboxLeadUpdateStateMutationString.a("input", graphQlCallInput);
            ((TasksManager) pagesContactInboxRequestDetailFragment.f1415d.get()).a(obj, ((GraphQLQueryExecutor) pagesContactInboxRequestDetailFragment.f1418g.get()).a(GraphQLRequest.a(pagesContactInboxLeadUpdateStateMutationString)), new C01988(pagesContactInboxRequestDetailFragment));
        }
    }

    public static String m2041b(PagesContactInboxRequestDetailFragment pagesContactInboxRequestDetailFragment) {
        if (pagesContactInboxRequestDetailFragment.ao == null) {
            String property = System.getProperty("line.separator");
            pagesContactInboxRequestDetailFragment.ao = pagesContactInboxRequestDetailFragment.jW_().getString(2131241674, new Object[]{pagesContactInboxRequestDetailFragment.al.m2069n()}) + property + property + pagesContactInboxRequestDetailFragment.jW_().getString(2131241675, new Object[]{pagesContactInboxRequestDetailFragment.an, pagesContactInboxRequestDetailFragment.f1413b.a(TimeFormatStyle.MONTH_DAY_YEAR_STYLE, pagesContactInboxRequestDetailFragment.al.m2066k() * 1000)}) + property + pagesContactInboxRequestDetailFragment.jW_().getString(2131241676) + property + pagesContactInboxRequestDetailFragment.al.m2065j() + property + pagesContactInboxRequestDetailFragment.jW_().getString(2131241676) + property;
        }
        return pagesContactInboxRequestDetailFragment.ao;
    }

    private boolean m2043e() {
        return (this.al.m2072q() == null || Strings.isNullOrEmpty(this.al.m2072q().m2059j()) || Strings.isNullOrEmpty(this.al.m2072q().m2058a())) ? false : true;
    }

    private GraphQLPageLeadGenInfoState aq() {
        return this.f1420i.m2131a(this.al.m2070o()) == null ? this.al.m2071p() : this.f1420i.m2131a(this.al.m2070o());
    }
}
