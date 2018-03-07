package com.facebook.adinterfaces.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AccountValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AccountValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateAccountEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateAccountsSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEvent;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel.Builder;
import com.facebook.adinterfaces.protocol.FetchAccountsMethod;
import com.facebook.adinterfaces.protocol.FetchAccountsMethod.C25421;
import com.facebook.adinterfaces.protocol.FetchAccountsMethod.Key;
import com.facebook.adinterfaces.protocol.FetchAccountsQuery.FetchAccountsQueryString;
import com.facebook.adinterfaces.ui.AdInterfacesSpinnerAdapter.SpinnerAdapterItem;
import com.facebook.adinterfaces.util.BoostPostMutationHelper;
import com.facebook.adinterfaces.util.PaymentsHelper;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.adinterfaces.abtest.ExperimentsForAdsPaymentsModule;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VOICE_WITH_ADD_CALLEE */
public class AdInterfacesAccountViewController extends BaseAdInterfacesViewController<AdInterfacesAccountView, AdInterfacesDataModel> {
    private AdInterfacesErrorReporter f22487a;
    private final Provider<FetchAccountsMethod> f22488b;
    private final AdInterfacesSpinnerAdapterProvider f22489c;
    private final TasksManager f22490d;
    public final BoostedComponentLogger f22491e;
    public final Provider<QuickPerformanceLogger> f22492f;
    public final PaymentsHelper f22493g;
    private final QeAccessor f22494h;
    public final AdsPaymentsExperimentsHelper f22495i;
    public final BoostPostMutationHelper f22496j;
    public ImmutableList<AdAccountModel> f22497k;
    public AdInterfacesCardLayout f22498l;
    public BaseAdInterfacesData f22499m;
    public AdInterfacesAccountView f22500n;
    public boolean f22501o = true;

    /* compiled from: VOICE_WITH_ADD_CALLEE */
    class C25681 extends InvalidateAccountsSubscriber {
        final /* synthetic */ AdInterfacesAccountViewController f22475a;

        C25681(AdInterfacesAccountViewController adInterfacesAccountViewController) {
            this.f22475a = adInterfacesAccountViewController;
        }

        public final void m24334b(FbEvent fbEvent) {
            this.f22475a.m24347a(((InvalidateAccountEvent) fbEvent).f21669a);
        }
    }

    /* compiled from: VOICE_WITH_ADD_CALLEE */
    class C25692 extends AccountValidationEventSubscriber {
        final /* synthetic */ AdInterfacesAccountViewController f22476a;

        C25692(AdInterfacesAccountViewController adInterfacesAccountViewController) {
            this.f22476a = adInterfacesAccountViewController;
        }

        public final void m24335b(FbEvent fbEvent) {
            this.f22476a.f22498l.m24584a(((AccountValidationEvent) fbEvent).f21655a);
        }
    }

    /* compiled from: VOICE_WITH_ADD_CALLEE */
    class C25747 implements Function<AdAccountModel, SpinnerAdapterItem> {
        final /* synthetic */ AdInterfacesAccountViewController f22485a;

        C25747(AdInterfacesAccountViewController adInterfacesAccountViewController) {
            this.f22485a = adInterfacesAccountViewController;
        }

        public Object apply(Object obj) {
            AdAccountModel adAccountModel = (AdAccountModel) obj;
            return new SpinnerAdapterItem(adAccountModel.m23149w(), adAccountModel.m23150x(), adAccountModel.m23137k());
        }
    }

    /* compiled from: VOICE_WITH_ADD_CALLEE */
    class C25758 implements OnItemSelectedListener {
        final /* synthetic */ AdInterfacesAccountViewController f22486a;

        C25758(AdInterfacesAccountViewController adInterfacesAccountViewController) {
            this.f22486a = adInterfacesAccountViewController;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 0;
            if (this.f22486a.f22500n.f22474a.m24924a()) {
                Preconditions.checkNotNull(this.f22486a.f22497k);
                Preconditions.checkState(!this.f22486a.f22497k.isEmpty());
                if (i < this.f22486a.f22497k.size()) {
                    i2 = i;
                }
                String t = ((AdAccountModel) this.f22486a.f22497k.get(i2)).m23146t();
                if (!StringUtil.a(this.f22486a.f22499m.m22853i(), t)) {
                    String i3 = this.f22486a.f22499m.m22853i();
                    this.f22486a.f22499m.f21749e = t;
                    this.f22486a.f22440b.m22429a(new SelectedAdAccountChangeEvent(i3, t));
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static AdInterfacesAccountViewController m24352b(InjectorLike injectorLike) {
        return new AdInterfacesAccountViewController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), IdBasedProvider.a(injectorLike, 4646), (AdInterfacesSpinnerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AdInterfacesSpinnerAdapterProvider.class), TasksManager.b(injectorLike), PaymentsHelper.m25285a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3229), AdsPaymentsExperimentsHelper.m25609b(injectorLike), BoostPostMutationHelper.m25269a(injectorLike));
    }

    public static AdInterfacesAccountViewController m24341a(InjectorLike injectorLike) {
        return m24352b(injectorLike);
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesAccountView adInterfacesAccountView = (AdInterfacesAccountView) view;
        super.mo982a(adInterfacesAccountView, adInterfacesCardLayout);
        this.f22500n = adInterfacesAccountView;
        this.f22498l = adInterfacesCardLayout;
        AdAccountModel e = AdInterfacesDataHelper.m22806e(this.f22499m);
        AdInterfacesStatus adInterfacesStatus = this.f22499m.f21748d;
        final AdInterfacesContext adInterfacesContext = this.f22440b;
        adInterfacesContext.m22430a(new C25681(this));
        adInterfacesContext.m22430a(new C25692(this));
        adInterfacesContext.m22428a(3, m24350b(adInterfacesContext));
        adInterfacesContext.m22428a(10, m24350b(adInterfacesContext));
        adInterfacesContext.m22428a(301, m24355c(adInterfacesContext));
        if (m24348a(e)) {
            this.f22498l.setCallToActionText(2131240173);
            this.f22498l.setCallToActionClickListener(new OnClickListener(this) {
                final /* synthetic */ AdInterfacesAccountViewController f22478b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1244795829);
                    this.f22478b.f22493g.m25296a(this.f22478b.f22500n.getContext(), this.f22478b.f22499m, AdInterfacesDataHelper.m22806e(this.f22478b.f22499m), adInterfacesContext);
                    Logger.a(2, EntryType.UI_INPUT_END, 6184715, a);
                }
            });
        }
        if (m24354b(adInterfacesStatus)) {
            m24345a(this.f22499m.mo956q());
        } else if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.FINISHED || adInterfacesStatus == AdInterfacesStatus.REJECTED) {
            boolean z;
            Preconditions.checkNotNull(this.f22499m.f21745a.m23183a());
            if (this.f22499m.f21745a.m23183a().m23158a().isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z);
            this.f22497k = this.f22499m.f21745a.m23183a().m23158a();
            this.f22500n;
        } else {
            m24344a(adInterfacesStatus);
        }
    }

    @Inject
    public AdInterfacesAccountViewController(QeAccessor qeAccessor, AdInterfacesErrorReporter adInterfacesErrorReporter, Provider<FetchAccountsMethod> provider, AdInterfacesSpinnerAdapterProvider adInterfacesSpinnerAdapterProvider, TasksManager tasksManager, PaymentsHelper paymentsHelper, BoostedComponentLogger boostedComponentLogger, Provider<QuickPerformanceLogger> provider2, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, BoostPostMutationHelper boostPostMutationHelper) {
        this.f22494h = qeAccessor;
        this.f22487a = adInterfacesErrorReporter;
        this.f22488b = provider;
        this.f22489c = adInterfacesSpinnerAdapterProvider;
        this.f22490d = tasksManager;
        this.f22493g = paymentsHelper;
        this.f22491e = boostedComponentLogger;
        this.f22492f = provider2;
        this.f22495i = adsPaymentsExperimentsHelper;
        this.f22496j = boostPostMutationHelper;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22499m = baseAdInterfacesData;
    }

    @VisibleForTesting
    private boolean m24348a(AdAccountModel adAccountModel) {
        return PaymentsHelper.m25287a(adAccountModel).isLockedIntoPrepay() && this.f22494h.a(Liveness.Live, ExperimentsForAdsPaymentsModule.f23626e, false);
    }

    private void m24344a(AdInterfacesStatus adInterfacesStatus) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported status for account component");
        stringBuilder.append("\n");
        if (adInterfacesStatus != null) {
            stringBuilder.append("status: ");
            stringBuilder.append(adInterfacesStatus.name());
        }
        stringBuilder.append("page id: ");
        stringBuilder.append(this.f22499m.f21747c);
        stringBuilder.append("\n");
        if (this.f22499m.mo962b() != null) {
            stringBuilder.append("objective:");
            stringBuilder.append(this.f22499m.mo962b().name());
        }
        this.f22487a.m22726a(getClass(), stringBuilder.toString());
    }

    private boolean m24354b(AdInterfacesStatus adInterfacesStatus) {
        return adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.PENDING || adInterfacesStatus == AdInterfacesStatus.CREATING || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || ((adInterfacesStatus == AdInterfacesStatus.FINISHED && !this.f22499m.mo957r()) || adInterfacesStatus == AdInterfacesStatus.PAUSED);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22490d.c(Key.FETCH_AD_ACCOUNTS);
        this.f22500n = null;
        this.f22498l = null;
    }

    private IntentHandler m24350b(final AdInterfacesContext adInterfacesContext) {
        return new IntentHandler(this) {
            final /* synthetic */ AdInterfacesAccountViewController f22480b;

            public final void mo980a(int i, Intent intent) {
                this.f22480b.f22491e.m22779i(this.f22480b.f22499m);
                adInterfacesContext.m22429a(new InvalidateAccountEvent(AdInterfacesDataHelper.m22792a(this.f22480b.f22499m, this.f22480b.f22499m.m22853i()).m23146t()));
            }
        };
    }

    private IntentHandler m24355c(final AdInterfacesContext adInterfacesContext) {
        return new IntentHandler(this) {
            final /* synthetic */ AdInterfacesAccountViewController f22482b;

            public final void mo980a(int i, Intent intent) {
                if (i == -1) {
                    PaymentsFlowContext paymentsFlowContext = (PaymentsFlowContext) intent.getParcelableExtra("payments_flow_context_key");
                    this.f22482b.f22493g.m25298a(paymentsFlowContext, adInterfacesContext, AdInterfacesDataHelper.m22792a(this.f22482b.f22499m, this.f22482b.f22499m.m22853i()), this.f22482b.f22500n.getContext(), false);
                }
            }
        };
    }

    private void m24347a(final String str) {
        ((QuickPerformanceLogger) this.f22492f.get()).b(5898247);
        ((QuickPerformanceLogger) this.f22492f.get()).a(5898247, this.f22499m.mo962b().name());
        this.f22498l.m24586a(true);
        TasksManager tasksManager = this.f22490d;
        Key key = Key.FETCH_AD_ACCOUNTS;
        FetchAccountsMethod fetchAccountsMethod = (FetchAccountsMethod) this.f22488b.get();
        String str2 = this.f22499m.f21747c;
        Preconditions.checkNotNull(str2);
        tasksManager.a(key, Futures.a(fetchAccountsMethod.f22332a.a(GraphQLRequest.a((FetchAccountsQueryString) new FetchAccountsQueryString().a("page_id", str2).a("fetch_saved_audiences", Boolean.valueOf(true)).a("num_of_saved_audiences_to_fetch", Integer.valueOf(2)))), new C25421(fetchAccountsMethod), MoreExecutors.a()), new AbstractDisposableFutureCallback<AdAccountsModel>(this) {
            final /* synthetic */ AdInterfacesAccountViewController f22484b;

            protected final void m24338a(Object obj) {
                AdAccountsModel adAccountsModel = (AdAccountsModel) obj;
                if (adAccountsModel == null) {
                    this.f22484b.f22498l.m24586a(false);
                    this.f22484b.f22440b.m22429a(new ErrorDialogEvent());
                    ((QuickPerformanceLogger) this.f22484b.f22492f.get()).b(5898247, (short) 3);
                    return;
                }
                boolean z;
                ((QuickPerformanceLogger) this.f22484b.f22492f.get()).b(5898247, (short) 2);
                this.f22484b.f22498l.m24586a(false);
                AdAccountModel e = AdInterfacesDataHelper.m22806e(this.f22484b.f22499m);
                AdInterfacesAccountViewController adInterfacesAccountViewController = this.f22484b;
                if (this.f22484b.f22501o && e != null && e.m23144r()) {
                    z = true;
                } else {
                    z = false;
                }
                adInterfacesAccountViewController.f22501o = z;
                this.f22484b.f22497k = adAccountsModel.m23158a();
                BaseAdInterfacesData baseAdInterfacesData = this.f22484b.f22499m;
                Builder a = Builder.m23178a(this.f22484b.f22499m.f21745a);
                a.f21989a = adAccountsModel;
                baseAdInterfacesData.f21745a = a.m23179a();
                this.f22484b.f22500n;
                if (AdInterfacesDataHelper.m22788a(this.f22484b.f22497k, str) != -1) {
                    this.f22484b.f22500n.f22474a.setSelected(AdInterfacesDataHelper.m22788a(this.f22484b.f22497k, str));
                }
                e = AdInterfacesDataHelper.m22806e(this.f22484b.f22499m);
                if (!(this.f22484b.f22501o || e == null)) {
                    if (e.m23144r()) {
                        this.f22484b.f22491e.m22778h(this.f22484b.f22499m);
                        if (this.f22484b.f22499m.mo962b() == ObjectiveType.BOOST_POST && this.f22484b.f22440b.m22432a() && this.f22484b.f22495i.m25613a()) {
                            this.f22484b.f22496j.m25275a(this.f22484b.f22500n.getContext(), (AdInterfacesBoostPostDataModel) this.f22484b.f22499m, this.f22484b.f22440b);
                        }
                    } else {
                        this.f22484b.f22491e.m22780j(this.f22484b.f22499m);
                    }
                }
                this.f22484b.f22440b.m22429a(new SelectedAdAccountChangeEvent(this.f22484b.f22499m.m22853i(), this.f22484b.f22499m.m22853i()));
            }

            protected final void m24339a(Throwable th) {
                ((QuickPerformanceLogger) this.f22484b.f22492f.get()).b(5898247, (short) 3);
                this.f22484b.f22498l.m24586a(false);
                this.f22484b.f22440b.m22429a(new ErrorDialogEvent());
            }

            protected final void m24340a(CancellationException cancellationException) {
                ((QuickPerformanceLogger) this.f22484b.f22492f.get()).b(5898247, (short) 4);
            }
        });
    }

    public static void m24353b(AdInterfacesAccountViewController adInterfacesAccountViewController) {
        adInterfacesAccountViewController.f22500n.f22474a.m24922a(adInterfacesAccountViewController.f22489c.m24920a(Lists.a(adInterfacesAccountViewController.f22497k, new C25747(adInterfacesAccountViewController))), new C25758(adInterfacesAccountViewController));
    }

    private void m24345a(AdAccountBasicFieldsModel adAccountBasicFieldsModel) {
        this.f22500n.f22474a.m24923a(adAccountBasicFieldsModel.m23121k(), adAccountBasicFieldsModel.m23122l());
    }

    public final void mo984a(Bundle bundle) {
        bundle.putString("selected_ad_account_id", this.f22499m.m22853i());
        bundle.putBoolean("selected_ad_account_has_payment_method", m24357c());
    }

    private boolean m24357c() {
        AdAccountModel e = AdInterfacesDataHelper.m22806e(this.f22499m);
        return e != null && e.m23144r();
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            String i = this.f22499m.m22853i();
            String string = bundle.getString("selected_ad_account_id");
            this.f22499m.f21749e = string;
            this.f22500n.f22474a.setSelected(AdInterfacesDataHelper.m22788a(this.f22499m.f21745a.m23183a().m23158a(), string));
            this.f22501o = bundle.getBoolean("selected_ad_account_has_payment_method");
            this.f22440b.m22429a(new SelectedAdAccountChangeEvent(i, string));
        }
    }
}
