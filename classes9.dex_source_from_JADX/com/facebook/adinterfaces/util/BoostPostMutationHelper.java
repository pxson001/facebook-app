package com.facebook.adinterfaces.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesConstants.CampaignStatus;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.BoostInfoArchiveMutation.BoostInfotArchiveMutationString;
import com.facebook.adinterfaces.protocol.BoostInfoArchiveMutationModels.BoostInfoArchiveMutationFieldsModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostPostFooterViewController;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.calls.BoostInfoArchiveInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: UnitComponentTokenKey */
public class BoostPostMutationHelper implements BoostMutationHelper<AdInterfacesBoostPostDataModel> {
    private static BoostPostMutationHelper f23328j;
    private static final Object f23329k = new Object();
    private QuickExperimentController f23330a;
    public final Provider<QuickPerformanceLogger> f23331b;
    public final AdInterfacesDataHelper f23332c;
    private final DefaultBlueServiceOperationFactory f23333d;
    public final DefaultAndroidThreadUtil f23334e;
    public final BoostedComponentLogger f23335f;
    public final GraphQLQueryExecutor f23336g;
    public final AdInterfacesErrorReporter f23337h;
    public final PaymentsHelper f23338i;

    private static BoostPostMutationHelper m25271b(InjectorLike injectorLike) {
        return new BoostPostMutationHelper(AdInterfacesDataHelper.m22789a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3229), DefaultBlueServiceOperationFactory.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), BoostedComponentLogger.m22753a(injectorLike), GraphQLQueryExecutor.a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), PaymentsHelper.m25285a(injectorLike));
    }

    public static BoostPostMutationHelper m25269a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BoostPostMutationHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23329k) {
                BoostPostMutationHelper boostPostMutationHelper;
                if (a2 != null) {
                    boostPostMutationHelper = (BoostPostMutationHelper) a2.a(f23329k);
                } else {
                    boostPostMutationHelper = f23328j;
                }
                if (boostPostMutationHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25271b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23329k, b3);
                        } else {
                            f23328j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = boostPostMutationHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BoostPostMutationHelper(AdInterfacesDataHelper adInterfacesDataHelper, QuickExperimentController quickExperimentController, Provider<QuickPerformanceLogger> provider, BlueServiceOperationFactory blueServiceOperationFactory, AndroidThreadUtil androidThreadUtil, BoostedComponentLogger boostedComponentLogger, GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesErrorReporter adInterfacesErrorReporter, PaymentsHelper paymentsHelper) {
        this.f23330a = quickExperimentController;
        this.f23331b = provider;
        this.f23333d = blueServiceOperationFactory;
        this.f23334e = androidThreadUtil;
        this.f23335f = boostedComponentLogger;
        this.f23336g = graphQLQueryExecutor;
        this.f23337h = adInterfacesErrorReporter;
        this.f23332c = adInterfacesDataHelper;
        this.f23338i = paymentsHelper;
    }

    public final OnClickListener mo1052d(final Context context, final AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new OnClickListener(this) {
            final /* synthetic */ BoostPostMutationHelper f23298d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -905316840);
                ((QuickPerformanceLogger) this.f23298d.f23331b.get()).b(5898242);
                ((QuickPerformanceLogger) this.f23298d.f23331b.get()).a(5898242, adInterfacesBoostPostDataModel.mo962b().name());
                this.f23298d.f23335f.m22781k(adInterfacesBoostPostDataModel);
                AdInterfacesDataHelper adInterfacesDataHelper = this.f23298d.f23332c;
                AdAccountModel a2 = AdInterfacesDataHelper.m22792a(adInterfacesBoostPostDataModel, adInterfacesBoostPostDataModel.m22853i());
                if (a2.m23144r()) {
                    this.f23298d.m25275a(context, adInterfacesBoostPostDataModel, adInterfacesContext);
                    LogUtils.a(1742659793, a);
                    return;
                }
                this.f23298d.f23338i.m25297a(adInterfacesContext, adInterfacesBoostPostDataModel, a2, ((FragmentActivity) view.getContext()).kO_(), context);
                Logger.a(2, EntryType.UI_INPUT_END, 701026068, a);
            }
        };
    }

    public final void m25275a(Context context, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel, final AdInterfacesContext adInterfacesContext) {
        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(context, 2131234025);
        dialogBasedProgressIndicator.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("adInterfacesCreateStoryPromotionParams", adInterfacesBoostPostDataModel);
        this.f23334e.a(BlueServiceOperationFactoryDetour.a(this.f23333d, "ad_interfaces_create_story_promotion", bundle, -1062104575).a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ BoostPostMutationHelper f23302d;

            protected final void m25261a(ServiceException serviceException) {
                this.f23302d.f23337h.m22727a(AdInterfacesBoostPostFooterViewController.class, "Create Boost failed", serviceException);
                ((QuickPerformanceLogger) this.f23302d.f23331b.get()).b(5898242, (short) 3);
                dialogBasedProgressIndicator.b();
                adInterfacesContext.m22429a(BoostPostMutationHelper.m25268a(serviceException));
                this.f23302d.f23335f.m22767a(adInterfacesBoostPostDataModel, (Throwable) serviceException);
            }

            protected final void m25262a(Object obj) {
                ((QuickPerformanceLogger) this.f23302d.f23331b.get()).b(5898242, (short) 2);
                this.f23302d.f23335f.m22769b(adInterfacesBoostPostDataModel);
                adInterfacesContext.m22429a(new InvalidateEvent(dialogBasedProgressIndicator, ComponentType.PROMOTION_DETAILS));
                this.f23302d.f23335f.m22782l(adInterfacesBoostPostDataModel);
            }
        });
    }

    public final OnClickListener mo1049a(final AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new OnClickListener(this) {
            final /* synthetic */ BoostPostMutationHelper f23310c;

            /* compiled from: UnitComponentTokenKey */
            class C27711 implements DialogInterface.OnClickListener {
                final /* synthetic */ C27743 f23303a;

                C27711(C27743 c27743) {
                    this.f23303a = c27743;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 728235641);
                ((QuickPerformanceLogger) this.f23310c.f23331b.get()).b(5898244);
                ((QuickPerformanceLogger) this.f23310c.f23331b.get()).a(5898244, adInterfacesBoostPostDataModel.mo962b().name());
                final Context context = view.getContext();
                new FbAlertDialogBuilder(context).a(2131233974).b(2131233975).a(2131233989, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ C27743 f23307b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(context, 2131234034);
                        dialogBasedProgressIndicator.a();
                        BoostInfoArchiveInputData boostInfoArchiveInputData = new BoostInfoArchiveInputData();
                        boostInfoArchiveInputData.a("boost_info_id", adInterfacesBoostPostDataModel.f21780a.m23713l().m23674q());
                        GraphQlCallInput graphQlCallInput = boostInfoArchiveInputData;
                        graphQlCallInput.a("flow_id", this.f23307b.f23310c.f23335f.f21686e);
                        this.f23307b.f23310c.f23334e.a(this.f23307b.f23310c.f23336g.a(GraphQLRequest.a((BoostInfotArchiveMutationString) new BoostInfotArchiveMutationString().a("input", graphQlCallInput))), new FutureCallback<GraphQLResult<BoostInfoArchiveMutationFieldsModel>>(this) {
                            final /* synthetic */ C27732 f23305b;

                            public void onSuccess(Object obj) {
                                ((QuickPerformanceLogger) this.f23305b.f23307b.f23310c.f23331b.get()).b(5898244, (short) 2);
                                this.f23305b.f23307b.f23310c.f23335f.m22775e(adInterfacesBoostPostDataModel);
                                adInterfacesContext.m22429a(new InvalidateEvent(dialogBasedProgressIndicator));
                            }

                            public void onFailure(Throwable th) {
                                ((QuickPerformanceLogger) this.f23305b.f23307b.f23310c.f23331b.get()).b(5898244, (short) 3);
                                this.f23305b.f23307b.f23310c.f23337h.m22727a(AdInterfacesBoostPostFooterViewController.class, "Delete Boost failed", th);
                                dialogBasedProgressIndicator.b();
                                adInterfacesContext.m22429a(new ErrorDialogEvent());
                            }
                        });
                    }
                }).b(2131233976, new C27711(this)).a().show();
                Logger.a(2, EntryType.UI_INPUT_END, 598867898, a);
            }
        };
    }

    public final OnClickListener mo1051c(Context context, AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return m25267a(context, adInterfacesContext, adInterfacesBoostPostDataModel, CampaignStatus.UPDATE_BUDGET, 2131234036);
    }

    public final OnClickListener mo1050b(Context context, AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return m25267a(context, adInterfacesContext, adInterfacesBoostPostDataModel, CampaignStatus.RESUME, 2131234035);
    }

    public final OnClickListener mo1048a(final Context context, final AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new OnClickListener(this) {
            final /* synthetic */ BoostPostMutationHelper f23316d;

            /* compiled from: UnitComponentTokenKey */
            class C27751 implements DialogInterface.OnClickListener {
                final /* synthetic */ C27774 f23311a;

                C27751(C27774 c27774) {
                    this.f23311a = c27774;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            /* compiled from: UnitComponentTokenKey */
            class C27762 implements DialogInterface.OnClickListener {
                final /* synthetic */ C27774 f23312a;

                C27762(C27774 c27774) {
                    this.f23312a = c27774;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f23312a.f23316d.m25272b(context, adInterfacesContext, adInterfacesBoostPostDataModel, CampaignStatus.PAUSE, 2131234033);
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1857465257);
                new FbAlertDialogBuilder(view.getContext()).a(2131233996).b(2131233997).a(2131233987, new C27762(this)).b(2131233976, new C27751(this)).a().show();
                Logger.a(2, EntryType.UI_INPUT_END, -380144720, a);
            }
        };
    }

    private OnClickListener m25267a(Context context, AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel, CampaignStatus campaignStatus, int i) {
        final Context context2 = context;
        final AdInterfacesContext adInterfacesContext2 = adInterfacesContext;
        final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel2 = adInterfacesBoostPostDataModel;
        final CampaignStatus campaignStatus2 = campaignStatus;
        final int i2 = i;
        return new OnClickListener(this) {
            final /* synthetic */ BoostPostMutationHelper f23322f;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 847337924);
                this.f23322f.m25272b(context2, adInterfacesContext2, adInterfacesBoostPostDataModel2, campaignStatus2, i2);
                Logger.a(2, EntryType.UI_INPUT_END, -1529194990, a);
            }
        };
    }

    private void m25272b(Context context, final AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel, final CampaignStatus campaignStatus, int i) {
        ((QuickPerformanceLogger) this.f23331b.get()).b(m25265a(campaignStatus));
        ((QuickPerformanceLogger) this.f23331b.get()).a(m25265a(campaignStatus), adInterfacesBoostPostDataModel.mo962b().name());
        adInterfacesBoostPostDataModel.f21783d = campaignStatus;
        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(context, i);
        dialogBasedProgressIndicator.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("adInterfacesModifyStoryPromotionParams", adInterfacesBoostPostDataModel);
        this.f23334e.a(BlueServiceOperationFactoryDetour.a(this.f23333d, "ad_interfaces_modify_story_promotion", bundle, 364475845).a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ BoostPostMutationHelper f23326d;

            protected final void m25263a(ServiceException serviceException) {
                this.f23326d.f23337h.m22727a(AdInterfacesBoostPostFooterViewController.class, "Modify Boost failed", serviceException);
                ((QuickPerformanceLogger) this.f23326d.f23331b.get()).b(BoostPostMutationHelper.m25265a(campaignStatus), (short) 3);
                dialogBasedProgressIndicator.b();
                adInterfacesContext.m22429a(BoostPostMutationHelper.m25268a(serviceException));
            }

            protected final void m25264a(Object obj) {
                ((QuickPerformanceLogger) this.f23326d.f23331b.get()).b(BoostPostMutationHelper.m25265a(campaignStatus), (short) 2);
                adInterfacesContext.m22429a(new InvalidateEvent(dialogBasedProgressIndicator, campaignStatus == CampaignStatus.PAUSE ? ComponentType.FOOTER : ComponentType.PROMOTION_DETAILS));
            }
        });
    }

    private static int m25265a(CampaignStatus campaignStatus) {
        switch (campaignStatus) {
            case RESUME:
                return 5898245;
            case UPDATE_BUDGET:
                return 5898246;
            default:
                return 5898243;
        }
    }

    public static ErrorDialogEvent m25268a(ServiceException serviceException) {
        ApiException apiException = (ApiException) ExceptionUtil.a(serviceException, ApiException.class);
        if (apiException == null || apiException.c() == null || apiException.d() == null) {
            return new ErrorDialogEvent();
        }
        return new ErrorDialogEvent(apiException.c(), apiException.d());
    }
}
