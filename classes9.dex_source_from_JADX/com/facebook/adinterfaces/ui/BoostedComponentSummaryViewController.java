package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.CallToActionWrapper;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper.ScheduleOption;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.protocol.DeleteBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unsupported bubble type */
public class BoostedComponentSummaryViewController extends BaseAdInterfacesViewController<AdInterfacesPromotionDetailsView, AdInterfacesDataModel> {
    public String f23109a;
    public final AdInterfacesReactUtil f23110b;
    private final AdInterfacesDataHelper f23111c;
    public final Provider<QuickPerformanceLogger> f23112d;
    public final DeleteBoostedComponentMethod f23113e;
    public final EditBoostedComponentMethod f23114f;
    public final OnClickListener f23115g = new C27131(this);
    private final OnClickListener f23116h = new C27142(this);
    private IntentHandler f23117i;
    public AdInterfacesPromotionDetailsView f23118j;
    public InsightsModel f23119k;
    private long f23120l;
    public String f23121m;
    public AdInterfacesBoostedComponentDataModel f23122n;
    private final OnClickListener f23123o = new C27173(this);
    private final OnClickListener f23124p = new C27204(this);

    /* compiled from: Unsupported bubble type */
    class C27131 implements OnClickListener {
        final /* synthetic */ BoostedComponentSummaryViewController f23099a;

        C27131(BoostedComponentSummaryViewController boostedComponentSummaryViewController) {
            this.f23099a = boostedComponentSummaryViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1519723793);
            Context context = view.getContext();
            BaseAdInterfacesData baseAdInterfacesData = this.f23099a.f23122n;
            Intent a2 = AdInterfacesIntentUtil.a(context, ObjectiveType.BOOSTED_COMPONENT_EDIT_BUDGET, Integer.valueOf(BudgetHelper.m25102b(baseAdInterfacesData) ? 2131234003 : 2131233986), null);
            AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) new Builder().mo950a();
            adInterfacesBoostedComponentDataModel.f21748d = baseAdInterfacesData.f21748d;
            adInterfacesBoostedComponentDataModel.f21747c = baseAdInterfacesData.f21747c;
            adInterfacesBoostedComponentDataModel.f21753i = baseAdInterfacesData.f21753i;
            adInterfacesBoostedComponentDataModel.f21799d = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21799d;
            adInterfacesBoostedComponentDataModel.f21746b = baseAdInterfacesData.mo962b();
            adInterfacesBoostedComponentDataModel.f21754j = baseAdInterfacesData.f21754j;
            adInterfacesBoostedComponentDataModel.f21797b = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21797b;
            adInterfacesBoostedComponentDataModel.m22848b(baseAdInterfacesData.f21750f, baseAdInterfacesData.f21752h);
            adInterfacesBoostedComponentDataModel.f21749e = baseAdInterfacesData.m22853i();
            AdminInfoModel.Builder builder = new AdminInfoModel.Builder();
            builder.f21995g = baseAdInterfacesData.f21745a.m23191o();
            builder = builder;
            AdAccountsModel.Builder builder2 = new AdAccountsModel.Builder();
            builder2.f21981a = ImmutableList.of(AdInterfacesDataHelper.m22806e(baseAdInterfacesData));
            builder.f21989a = builder2.m23153a();
            adInterfacesBoostedComponentDataModel.f21745a = builder.m23179a();
            a2.putExtra("data", adInterfacesBoostedComponentDataModel);
            this.f23099a.f22440b.m22429a(new IntentEvent(a2, 8, true));
            Logger.a(2, EntryType.UI_INPUT_END, 1391734177, a);
        }
    }

    /* compiled from: Unsupported bubble type */
    class C27142 implements OnClickListener {
        final /* synthetic */ BoostedComponentSummaryViewController f23100a;

        C27142(BoostedComponentSummaryViewController boostedComponentSummaryViewController) {
            this.f23100a = boostedComponentSummaryViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1611540944);
            Context context = view.getContext();
            BaseAdInterfacesData baseAdInterfacesData = this.f23100a.f23122n;
            Intent a2 = AdInterfacesIntentUtil.a(context, ObjectiveType.BOOSTED_COMPONENT_EDIT_DURATION, Integer.valueOf(2131233910), null);
            AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) new Builder().mo950a();
            adInterfacesBoostedComponentDataModel.f21748d = baseAdInterfacesData.f21748d;
            adInterfacesBoostedComponentDataModel.f21747c = baseAdInterfacesData.f21747c;
            adInterfacesBoostedComponentDataModel.f21799d = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21799d;
            adInterfacesBoostedComponentDataModel.f21746b = baseAdInterfacesData.mo962b();
            adInterfacesBoostedComponentDataModel.f21797b = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21797b;
            adInterfacesBoostedComponentDataModel.m22848b(baseAdInterfacesData.f21750f, baseAdInterfacesData.f21752h);
            AdminInfoModel.Builder builder = new AdminInfoModel.Builder();
            AdAccountsModel.Builder builder2 = new AdAccountsModel.Builder();
            builder2.f21981a = ImmutableList.of(AdInterfacesDataHelper.m22806e(baseAdInterfacesData));
            builder.f21989a = builder2.m23153a();
            adInterfacesBoostedComponentDataModel.f21745a = builder.m23179a();
            adInterfacesBoostedComponentDataModel.f21753i = baseAdInterfacesData.f21753i;
            a2.putExtra("data", adInterfacesBoostedComponentDataModel);
            this.f23100a.f22440b.m22429a(new IntentEvent(a2, 7, true));
            Logger.a(2, EntryType.UI_INPUT_END, 1140408240, a);
        }
    }

    /* compiled from: Unsupported bubble type */
    class C27173 implements OnClickListener {
        final /* synthetic */ BoostedComponentSummaryViewController f23103a;

        /* compiled from: Unsupported bubble type */
        class C27151 implements DialogInterface.OnClickListener {
            final /* synthetic */ C27173 f23101a;

            C27151(C27173 c27173) {
                this.f23101a = c27173;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* compiled from: Unsupported bubble type */
        class C27162 implements DialogInterface.OnClickListener {
            final /* synthetic */ C27173 f23102a;

            C27162(C27173 c27173) {
                this.f23102a = c27173;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f23102a.f23103a.f23113e.m24065a(this.f23102a.f23103a.f23122n, this.f23102a.f23103a.f23118j.getContext());
            }
        }

        C27173(BoostedComponentSummaryViewController boostedComponentSummaryViewController) {
            this.f23103a = boostedComponentSummaryViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1395456791);
            ((QuickPerformanceLogger) this.f23103a.f23112d.get()).b(5898244);
            ((QuickPerformanceLogger) this.f23103a.f23112d.get()).a(5898244, this.f23103a.f23122n.mo962b().name());
            new FbAlertDialogBuilder(view.getContext()).a(2131233998).b(2131233999).a(2131233989, new C27162(this)).b(2131233976, new C27151(this)).a().show();
            Logger.a(2, EntryType.UI_INPUT_END, -2013721334, a);
        }
    }

    /* compiled from: Unsupported bubble type */
    class C27204 implements OnClickListener {
        final /* synthetic */ BoostedComponentSummaryViewController f23106a;

        /* compiled from: Unsupported bubble type */
        class C27181 implements DialogInterface.OnClickListener {
            final /* synthetic */ C27204 f23104a;

            C27181(C27204 c27204) {
                this.f23104a = c27204;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* compiled from: Unsupported bubble type */
        class C27192 implements DialogInterface.OnClickListener {
            final /* synthetic */ C27204 f23105a;

            C27192(C27204 c27204) {
                this.f23105a = c27204;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f23105a.f23106a.f23122n.f21748d = AdInterfacesStatus.PAUSED;
                this.f23105a.f23106a.f23114f.m24070a(this.f23105a.f23106a.f23122n, this.f23105a.f23106a.f23118j.getContext());
            }
        }

        C27204(BoostedComponentSummaryViewController boostedComponentSummaryViewController) {
            this.f23106a = boostedComponentSummaryViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -147190543);
            ((QuickPerformanceLogger) this.f23106a.f23112d.get()).b(5898243);
            ((QuickPerformanceLogger) this.f23106a.f23112d.get()).a(5898243, this.f23106a.f23122n.mo962b().name());
            new FbAlertDialogBuilder(view.getContext()).a(2131233996).b(2131233997).a(2131233987, new C27192(this)).b(2131233976, new C27181(this)).a().show();
            Logger.a(2, EntryType.UI_INPUT_END, 1398090979, a);
        }
    }

    /* compiled from: Unsupported bubble type */
    class C27215 implements IntentHandler {
        final /* synthetic */ BoostedComponentSummaryViewController f23107a;

        C27215(BoostedComponentSummaryViewController boostedComponentSummaryViewController) {
            this.f23107a = boostedComponentSummaryViewController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                this.f23107a.f22440b.m22429a(new InvalidateEvent());
            }
        }
    }

    public static BoostedComponentSummaryViewController m25084b(InjectorLike injectorLike) {
        return new BoostedComponentSummaryViewController(AdInterfacesReactUtil.m24849b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3229), DeleteBoostedComponentMethod.m24062a(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesPromotionDetailsView adInterfacesPromotionDetailsView = (AdInterfacesPromotionDetailsView) view;
        super.mo982a(adInterfacesPromotionDetailsView, adInterfacesCardLayout);
        this.f23118j = adInterfacesPromotionDetailsView;
        Context context = adInterfacesPromotionDetailsView.getContext();
        adInterfacesPromotionDetailsView.setColumnsActive(false);
        if (!this.f23110b.m24851a()) {
            adInterfacesPromotionDetailsView.setColumnsActive(true);
            adInterfacesPromotionDetailsView.setSpentText(this.f23121m);
            adInterfacesPromotionDetailsView.setPaidReach(AdInterfacesDataHelper.m22797a(this.f23119k.m23331k(), context));
        }
        if (!this.f23119k.m23328a().isEmpty() && this.f23122n.mo962b() == ObjectiveType.LOCAL_AWARENESS) {
            ImmutableList a = this.f23119k.m23328a();
            CtaClicksModel ctaClicksModel = (CtaClicksModel) a.get(0);
            CallToActionWrapper fromGraphQLTypeCallToAction = CallToActionWrapper.fromGraphQLTypeCallToAction(((CtaClicksModel) a.get(0)).m23323j());
            adInterfacesPromotionDetailsView.setPaidReach(String.valueOf(this.f23119k.m23331k()));
            adInterfacesPromotionDetailsView.m24846c(StringFormatUtil.a(context.getString(2131234055), new Object[]{fromGraphQLTypeCallToAction.getText(context)}), String.valueOf(ctaClicksModel.m23319a()));
        }
        if (this.f23122n.mo962b() == ObjectiveType.PAGE_LIKE) {
            adInterfacesPromotionDetailsView.m24846c(context.getString(2131234056), String.valueOf(this.f23119k.m23330j()));
        }
        if (this.f23122n.mo962b() == ObjectiveType.PROMOTE_WEBSITE) {
            adInterfacesPromotionDetailsView.m24846c(context.getString(2131234071), String.valueOf(this.f23119k.m23332l()));
        }
        if (this.f23110b.m24851a()) {
            adInterfacesCardLayout.setHeaderTitleResource(2131234105);
        }
        if (AdInterfacesDataHelper.m22814j(this.f23122n)) {
            m25086c();
            m25087c(adInterfacesPromotionDetailsView);
        } else {
            m25085b(adInterfacesPromotionDetailsView);
        }
        switch (this.f23122n.f21748d) {
            case ACTIVE:
            case PENDING:
                adInterfacesPromotionDetailsView.setActionButtonText(adInterfacesPromotionDetailsView.getResources().getString(2131233987));
                adInterfacesPromotionDetailsView.setActionButtonVisibility(0);
                adInterfacesPromotionDetailsView.setActionButtonListener(this.f23124p);
                return;
            case PAUSED:
                adInterfacesPromotionDetailsView.setActionButtonText(adInterfacesPromotionDetailsView.getResources().getString(2131233989));
                adInterfacesPromotionDetailsView.setActionButtonVisibility(0);
                adInterfacesPromotionDetailsView.setActionButtonListener(this.f23123o);
                return;
            default:
                return;
        }
    }

    public static BoostedComponentSummaryViewController m25082a(InjectorLike injectorLike) {
        return m25084b(injectorLike);
    }

    @Inject
    public BoostedComponentSummaryViewController(AdInterfacesReactUtil adInterfacesReactUtil, AdInterfacesDataHelper adInterfacesDataHelper, Provider<QuickPerformanceLogger> provider, DeleteBoostedComponentMethod deleteBoostedComponentMethod, EditBoostedComponentMethod editBoostedComponentMethod) {
        this.f23110b = adInterfacesReactUtil;
        this.f23111c = adInterfacesDataHelper;
        this.f23113e = deleteBoostedComponentMethod;
        this.f23112d = provider;
        this.f23114f = editBoostedComponentMethod;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f23122n = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        BoostedComponentModel boostedComponentModel = this.f23122n.f21797b;
        CurrencyQuantityModel l = boostedComponentModel.m23345l();
        this.f23109a = BudgetHelper.m25097a(l.m23421j(), BudgetHelper.m25098a(l).longValue(), BudgetHelper.m25107g(baseAdInterfacesData));
        l = boostedComponentModel.m23353t();
        this.f23121m = BudgetHelper.m25097a(l.m23421j(), BudgetHelper.m25098a(l).longValue(), BudgetHelper.m25107g(baseAdInterfacesData));
        this.f23120l = boostedComponentModel.m23354u();
        this.f23119k = boostedComponentModel.m23351r();
        this.f23122n.f21753i = this.f23111c.m22820a(this.f23120l * 1000);
    }

    private void m25086c() {
        this.f23117i = new C27215(this);
        this.f22440b.m22428a(8, this.f23117i);
        this.f22440b.m22428a(7, this.f23117i);
    }

    private String m25083a(Context context) {
        return this.f23120l == ((long) ScheduleOption.CONTINUOUS.getDuration()) ? context.getString(2131234054) : AdInterfacesDataHelper.m22798a(this.f23120l, context);
    }

    private void m25085b(AdInterfacesPromotionDetailsView adInterfacesPromotionDetailsView) {
        Context context = adInterfacesPromotionDetailsView.getContext();
        if (this.f23110b.m24851a()) {
            adInterfacesPromotionDetailsView.m24846c(context.getString(2131233960), this.f23121m);
        }
        adInterfacesPromotionDetailsView.m24846c(context.getString(2131233986), this.f23109a);
        adInterfacesPromotionDetailsView.m24846c(context.getString(2131234001), m25083a(context));
    }

    private void m25087c(AdInterfacesPromotionDetailsView adInterfacesPromotionDetailsView) {
        Context context = adInterfacesPromotionDetailsView.getContext();
        if (BudgetHelper.m25102b(this.f23122n) && !BudgetHelper.m25100a(this.f23122n)) {
            adInterfacesPromotionDetailsView.m24846c(context.getString(2131234003), this.f23109a);
        } else if (BudgetHelper.m25102b(this.f23122n) && BudgetHelper.m25100a(this.f23122n)) {
            adInterfacesPromotionDetailsView.m24844a(context.getString(2131234003), this.f23109a, this.f23115g);
        } else if (BudgetHelper.m25102b(this.f23122n) || BudgetHelper.m25100a(this.f23122n)) {
            adInterfacesPromotionDetailsView.m24844a(context.getString(2131233986), this.f23109a, this.f23115g);
        } else {
            adInterfacesPromotionDetailsView.m24846c(context.getString(2131233986), this.f23109a);
        }
        adInterfacesPromotionDetailsView.m24844a(context.getString(2131234001), m25083a(context), this.f23116h);
    }

    public final void mo981a() {
        super.mo981a();
        this.f23118j = null;
        this.f23114f.m24050a();
        this.f23113e.m24050a();
    }
}
