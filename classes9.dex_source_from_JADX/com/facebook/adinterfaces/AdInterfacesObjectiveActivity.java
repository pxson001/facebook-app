package com.facebook.adinterfaces;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.ValidationComponent;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DialogEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScrollEvent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEventBus;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEvents.BoostedPostStatusChangedEvent;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper.C25081;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.objective.AdInterfacesObjective;
import com.facebook.adinterfaces.objective.AdInterfacesObjectiveRegistry;
import com.facebook.adinterfaces.objective.HasNavbarButtonSpec;
import com.facebook.adinterfaces.survey.AdInterfacesSurveyController;
import com.facebook.adinterfaces.ui.AdInterfacesCardLayout;
import com.facebook.adinterfaces.ui.BaseAdInterfacesViewController;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.analytics.activityidentifier.AnalyticsActivityContentUri;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.error.GenericErrorViewStub;
import com.facebook.widget.scrollview.LockableScrollView;
import com.facebook.widget.scrollview.ScrollViewLocker;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: accept_participants_dialog */
public class AdInterfacesObjectiveActivity extends FbFragmentActivity implements AnalyticsActivityContentUri {
    @Inject
    QuickPerformanceLogger f21505A;
    @Inject
    AdInterfacesContext f21506B;
    @Inject
    public BoostedComponentLogger f21507C;
    @Inject
    ScrollViewLocker f21508D;
    @Inject
    AdInterfacesExternalEventBus f21509E;
    @Inject
    AdInterfacesSurveyController f21510F;
    private AdInterfacesObjective<?> f21511G;
    private ImmutableList<? extends AdInterfacesComponent> f21512H;
    private int f21513I;
    public ComponentType f21514J;
    private Bundle f21515K;
    private boolean f21516L = false;
    private int f21517M;
    private int f21518N;
    private Intent f21519O;
    public boolean f21520P = false;
    private boolean f21521Q = false;
    public String f21522R = null;
    private View f21523S = null;
    public ProgressBar f21524T;
    public DialogBasedProgressIndicator f21525U;
    public GenericErrorView f21526V;
    private AppCompatActivityOverrider f21527W;
    private FbNetworkManager f21528X;
    public BaseAdInterfacesData f21529Y;
    private ErrorDialogs f21530Z;
    public FbTitleBar aa;
    @Inject
    QeAccessor f21531p;
    @Inject
    AdInterfacesObjectiveRegistry f21532q;
    @Inject
    AdInterfacesEventBus f21533r;
    @Inject
    SecureContextHelper f21534s;
    @Inject
    FbEventSubscriberListManager f21535t;
    @Inject
    Product f21536u;
    @Inject
    InputMethodManager f21537v;
    @Inject
    Provider<AppCompatActivityOverrider> f21538w;
    @Inject
    AdInterfacesErrorReporter f21539x;
    @Inject
    Provider<FbNetworkManager> f21540y;
    @Inject
    Provider<ErrorDialogs> f21541z;

    /* compiled from: accept_participants_dialog */
    class C24792 implements OnClickListener {
        final /* synthetic */ AdInterfacesObjectiveActivity f21493a;

        C24792(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
            this.f21493a = adInterfacesObjectiveActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 341921711);
            this.f21493a.f21526V.setVisibility(8);
            AdInterfacesObjectiveActivity.m22483c(this.f21493a, null);
            Logger.a(2, EntryType.UI_INPUT_END, -215345190, a);
        }
    }

    /* compiled from: accept_participants_dialog */
    class C24825 extends DataValidationEventSubscriber {
        final /* synthetic */ AdInterfacesObjectiveActivity f21498a;

        C24825(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
            this.f21498a = adInterfacesObjectiveActivity;
        }

        public final void m22450b(FbEvent fbEvent) {
            DataValidationEvent dataValidationEvent = (DataValidationEvent) fbEvent;
            AdInterfacesObjective r = AdInterfacesObjectiveActivity.m22501r(this.f21498a);
            if (r != null && (r instanceof HasNavbarButtonSpec)) {
                TitleBarButtonSpec b = ((HasNavbarButtonSpec) r).mo971b();
                if (b != null) {
                    b.t = dataValidationEvent.f21658a;
                    this.f21498a.aa.setButtonSpecs(ImmutableList.of(b));
                }
            }
        }
    }

    /* compiled from: accept_participants_dialog */
    class C24836 extends InvalidateEventSubscriber {
        final /* synthetic */ AdInterfacesObjectiveActivity f21499a;

        C24836(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
            this.f21499a = adInterfacesObjectiveActivity;
        }

        public final void m22452b(FbEvent fbEvent) {
            InvalidateEvent invalidateEvent = (InvalidateEvent) fbEvent;
            this.f21499a.f21514J = invalidateEvent.f21671b;
            this.f21499a.f21520P = false;
            this.f21499a.f21525U = invalidateEvent.f21670a;
            if (VERSION.SDK_INT >= 11) {
                ((LinearLayout) this.f21499a.a(2131558429)).setLayoutTransition(null);
            }
            AdInterfacesObjectiveActivity.m22483c(this.f21499a, null);
        }
    }

    /* compiled from: accept_participants_dialog */
    class C24847 extends IntentEventSubscriber {
        final /* synthetic */ AdInterfacesObjectiveActivity f21500a;

        C24847(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
            this.f21500a = adInterfacesObjectiveActivity;
        }

        public final void m22454b(FbEvent fbEvent) {
            IntentEvent intentEvent = (IntentEvent) fbEvent;
            Intent intent = intentEvent.f21665a;
            if (intentEvent.f21668d) {
                this.f21500a.setResult(-1, intentEvent.f21665a);
                this.f21500a.finish();
                return;
            }
            if (intentEvent.f21667c) {
                intent.putExtra("flow_id", this.f21500a.f21522R);
            }
            if (intentEvent.f21666b != null && intentEvent.f21667c) {
                this.f21500a.f21534s.a(intent, intentEvent.f21666b.intValue(), this.f21500a);
            } else if (intentEvent.f21666b != null && !intentEvent.f21667c) {
                this.f21500a.f21534s.b(intent, intentEvent.f21666b.intValue(), this.f21500a);
            } else if (intentEvent.f21667c) {
                this.f21500a.f21534s.a(intent, this.f21500a);
            } else {
                this.f21500a.f21534s.b(intent, this.f21500a);
            }
        }
    }

    /* compiled from: accept_participants_dialog */
    class C24858 extends DialogEventSubscriber {
        final /* synthetic */ AdInterfacesObjectiveActivity f21501a;

        C24858(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
            this.f21501a = adInterfacesObjectiveActivity;
        }

        public final void m22456b(FbEvent fbEvent) {
            DialogEvent dialogEvent = (DialogEvent) fbEvent;
            dialogEvent.f21659a.a(this.f21501a.kO_(), dialogEvent.f21660b);
        }
    }

    /* compiled from: accept_participants_dialog */
    class C24879 extends ErrorDialogEventSubscriber {
        final /* synthetic */ AdInterfacesObjectiveActivity f21504a;

        C24879(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
            this.f21504a = adInterfacesObjectiveActivity;
        }

        public final void m22460b(FbEvent fbEvent) {
            final ErrorDialogEvent errorDialogEvent = (ErrorDialogEvent) fbEvent;
            this.f21504a.f21524T.post(new Runnable(this) {
                final /* synthetic */ C24879 f21503b;

                public void run() {
                    this.f21503b.m22459a(errorDialogEvent.f21662a, errorDialogEvent.f21663b);
                }
            });
        }

        private void m22459a(@Nullable String str, @Nullable String str2) {
            if (StringUtil.a(str)) {
                str = this.f21504a.getResources().getString(2131230761);
            }
            if (StringUtil.a(str2)) {
                str2 = this.f21504a.getResources().getString(AdInterfacesObjectiveActivity.m22495l(this.f21504a).d() ? 2131230758 : 2131230759);
            }
            ErrorDialogs m = AdInterfacesObjectiveActivity.m22496m(this.f21504a);
            ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f21504a.getResources());
            a.b = str;
            a = a;
            a.c = str2;
            m.a(a.l());
        }
    }

    private static <T extends Context> void m22470a(Class<T> cls, T t) {
        m22471a((Object) t, (Context) t);
    }

    public static void m22471a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AdInterfacesObjectiveActivity) obj).m22469a((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AdInterfacesObjectiveRegistry.m22913a(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FbEventSubscriberListManager.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), InputMethodManagerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4577), AdInterfacesErrorReporter.m22724a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 585), IdBasedProvider.a(injectorLike, 3559), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), AdInterfacesContext.m22427a(injectorLike), BoostedComponentLogger.m22753a(injectorLike), ScrollViewLocker.a(injectorLike), AdInterfacesExternalEventBus.a(injectorLike), AdInterfacesSurveyController.m24300a(injectorLike));
    }

    private void m22469a(QeAccessor qeAccessor, AdInterfacesObjectiveRegistry adInterfacesObjectiveRegistry, AdInterfacesEventBus adInterfacesEventBus, SecureContextHelper secureContextHelper, FbEventSubscriberListManager fbEventSubscriberListManager, Product product, InputMethodManager inputMethodManager, Provider<AppCompatActivityOverrider> provider, AdInterfacesErrorReporter adInterfacesErrorReporter, Provider<FbNetworkManager> provider2, Provider<ErrorDialogs> provider3, QuickPerformanceLogger quickPerformanceLogger, AdInterfacesContext adInterfacesContext, BoostedComponentLogger boostedComponentLogger, ScrollViewLocker scrollViewLocker, AdInterfacesExternalEventBus adInterfacesExternalEventBus, AdInterfacesSurveyController adInterfacesSurveyController) {
        this.f21531p = qeAccessor;
        this.f21532q = adInterfacesObjectiveRegistry;
        this.f21533r = adInterfacesEventBus;
        this.f21534s = secureContextHelper;
        this.f21535t = fbEventSubscriberListManager;
        this.f21536u = product;
        this.f21537v = inputMethodManager;
        this.f21538w = provider;
        this.f21539x = adInterfacesErrorReporter;
        this.f21540y = provider2;
        this.f21541z = provider3;
        this.f21505A = quickPerformanceLogger;
        this.f21506B = adInterfacesContext;
        this.f21507C = boostedComponentLogger;
        this.f21508D = scrollViewLocker;
        this.f21509E = adInterfacesExternalEventBus;
        this.f21510F = adInterfacesSurveyController;
    }

    protected final void m22507a(Bundle bundle) {
        super.a(bundle);
        Class cls = AdInterfacesObjectiveActivity.class;
        m22471a((Object) this, (Context) this);
        Intent intent = getIntent();
        ObjectiveType objectiveType = (ObjectiveType) intent.getSerializableExtra("objective");
        this.f21505A.b(5898241);
        this.f21505A.a(5898241, objectiveType != null ? objectiveType.name() : "unknown");
        this.f21513I = intent.getIntExtra("title", -1);
        if (this.f21513I != -1 && this.f21536u == Product.PAA) {
            if (this.f21527W == null) {
                this.f21527W = (AppCompatActivityOverrider) this.f21538w.get();
            }
            a(this.f21527W);
        }
        AdInterfacesSurveyController adInterfacesSurveyController = this.f21510F;
        if (AdInterfacesSurveyController.m24302b(objectiveType)) {
            ((StructuredSurveyController) adInterfacesSurveyController.f22433c.get()).a("186440775060762");
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (this.aa instanceof ActionBarBasedFbTitleBar) {
            ((ActionBarBasedFbTitleBar) this.aa).a(menuItem);
        }
        return false;
    }

    public void onBackPressed() {
        Optional c = c(2131568503);
        if (c.isPresent()) {
            Object tag = ((View) c.get()).getTag();
            String obj = tag != null ? tag.toString() : null;
            this.f21507C.m22770b(obj);
            this.f21507C.m22772c(obj);
            ((ViewGroup) ((View) c.get()).getParent()).removeView((View) c.get());
            findViewById(2131559287).setVisibility(0);
            return;
        }
        Object obj2;
        BaseAdInterfacesData baseAdInterfacesData = this.f21529Y;
        if (baseAdInterfacesData != null) {
            if (baseAdInterfacesData.mo962b() == ObjectiveType.BOOST_POST_INSIGHTS) {
                this.f21507C.m22784n(baseAdInterfacesData);
            } else if (AdInterfacesDataHelper.m22814j(baseAdInterfacesData)) {
                this.f21507C.m22776f(baseAdInterfacesData);
            } else if (AdInterfacesDataHelper.m22815k(baseAdInterfacesData)) {
                this.f21507C.m22771c(baseAdInterfacesData);
            }
        }
        AdInterfacesSurveyController adInterfacesSurveyController = this.f21510F;
        BaseAdInterfacesData baseAdInterfacesData2 = this.f21529Y;
        ObjectiveType s = m22502s();
        if (!adInterfacesSurveyController.f22434d) {
            Object obj3;
            if (AdInterfacesSurveyController.m24302b(s)) {
                Object obj4 = null;
                if (baseAdInterfacesData2 != null) {
                    AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData2.f21748d;
                    if (adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.INACTIVE) {
                        obj4 = 1;
                    }
                }
                if (obj4 != null) {
                    obj3 = 1;
                    if (obj3 != null) {
                        if (((StructuredSurveyController) adInterfacesSurveyController.f22433c.get()).b("186440775060762") && !((StructuredSurveyController) ((RapidFeedbackController) adInterfacesSurveyController.f22432b.get()).d.get()).m()) {
                            obj2 = 1;
                            if (obj2 != null) {
                                adInterfacesSurveyController = this.f21510F;
                                ((RapidFeedbackController) adInterfacesSurveyController.f22432b.get()).c("186440775060762", adInterfacesSurveyController.f22431a);
                                adInterfacesSurveyController.f22434d = true;
                                return;
                            }
                            adInterfacesSurveyController = this.f21510F;
                            ((StructuredSurveyController) adInterfacesSurveyController.f22433c.get()).l();
                            adInterfacesSurveyController.f22434d = false;
                            super.onBackPressed();
                        }
                    }
                }
            }
            obj3 = null;
            if (obj3 != null) {
                obj2 = 1;
                if (obj2 != null) {
                    adInterfacesSurveyController = this.f21510F;
                    ((StructuredSurveyController) adInterfacesSurveyController.f22433c.get()).l();
                    adInterfacesSurveyController.f22434d = false;
                    super.onBackPressed();
                }
                adInterfacesSurveyController = this.f21510F;
                ((RapidFeedbackController) adInterfacesSurveyController.f22432b.get()).c("186440775060762", adInterfacesSurveyController.f22431a);
                adInterfacesSurveyController.f22434d = true;
                return;
            }
        }
        obj2 = null;
        if (obj2 != null) {
            adInterfacesSurveyController = this.f21510F;
            ((RapidFeedbackController) adInterfacesSurveyController.f22432b.get()).c("186440775060762", adInterfacesSurveyController.f22431a);
            adInterfacesSurveyController.f22434d = true;
            return;
        }
        adInterfacesSurveyController = this.f21510F;
        ((StructuredSurveyController) adInterfacesSurveyController.f22433c.get()).l();
        adInterfacesSurveyController.f22434d = false;
        super.onBackPressed();
    }

    protected final void m22509b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905525);
        m22492i();
        this.f21524T = (ProgressBar) a(2131564323);
        m22504u();
        m22503t();
    }

    private void m22492i() {
        final LockableScrollView lockableScrollView = (LockableScrollView) a(2131564321);
        lockableScrollView.setDescendantFocusability(131072);
        lockableScrollView.setFocusable(true);
        lockableScrollView.setFocusableInTouchMode(true);
        lockableScrollView.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AdInterfacesObjectiveActivity f21492b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.requestFocusFromTouch();
                switch (motionEvent.getAction()) {
                    case 1:
                        lockableScrollView.performClick();
                        break;
                    case 2:
                        AdInterfacesObjectiveActivity.m22505v(this.f21492b);
                        this.f21492b.f21533r.a(new ScrollEvent());
                        break;
                }
                return lockableScrollView.onTouchEvent(motionEvent);
            }
        });
        this.f21508D.b = lockableScrollView;
    }

    private void m22467a(BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData.f21748d != null) {
            switch (baseAdInterfacesData.f21748d) {
                case INACTIVE:
                case NEVER_BOOSTED:
                case FINISHED:
                    this.f21514J = ComponentType.TARGETING;
                    if (this.f21529Y.mo962b() == ObjectiveType.LOCAL_AWARENESS) {
                        this.f21514J = null;
                    }
                    if (this.f21529Y.mo962b() == ObjectiveType.BOOST_EVENT) {
                        this.f21514J = ComponentType.BOOST_TYPE;
                        return;
                    }
                    return;
                case CREATING:
                case PAUSED:
                case PENDING:
                case EXTENDABLE:
                    this.f21514J = ComponentType.INFO_CARD;
                    return;
                case ACTIVE:
                    this.f21514J = ComponentType.INSIGHTS_SUMMARY;
                    if (this.f21529Y instanceof AdInterfacesBoostedComponentDataModel) {
                        this.f21514J = ComponentType.PROMOTION_DETAILS;
                        return;
                    }
                    return;
                case ERROR:
                case REJECTED:
                    this.f21514J = ComponentType.ERROR_CARD;
                    return;
                default:
                    return;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f21508D.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f21522R = bundle.getString("ad_interfaces_flow_id");
        if (this.f21522R == null) {
            this.f21522R = m22494k();
        }
        this.f21507C.f21686e = this.f21522R;
        this.f21515K = bundle;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f21516L = true;
        this.f21517M = i2;
        this.f21519O = intent;
        this.f21518N = i;
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 2120690552);
        super.onResume();
        m22494k();
        m22483c(this, this.f21515K);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 424558605, a);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f21512H != null) {
            int size = this.f21512H.size();
            for (int i = 0; i < size; i++) {
                m22480b((AdInterfacesComponent) this.f21512H.get(i), bundle);
            }
        }
        ScrollViewLocker scrollViewLocker = this.f21508D;
        String str = "adinterfaces_objective";
        bundle.putInt(str + ".scrollViewId", scrollViewLocker.b == null ? 0 : scrollViewLocker.b.getId());
        ArrayList arrayList = new ArrayList();
        for (View id : scrollViewLocker.a) {
            arrayList.add(Integer.valueOf(id.getId()));
        }
        bundle.putIntegerArrayList(str + ".lockingViewIds", arrayList);
        bundle.putString("ad_interfaces_flow_id", this.f21522R);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 433428688);
        super.onPause();
        m22505v(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 945630024, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -555266541);
        super.onDestroy();
        this.f21521Q = true;
        m22493j();
        this.f21511G = null;
        this.f21512H = null;
        if (this.f21535t != null) {
            this.f21535t.b(this.f21533r);
            this.f21535t = null;
        }
        AdInterfacesContext adInterfacesContext = this.f21506B;
        adInterfacesContext.f21485c.b(adInterfacesContext.f21483a);
        adInterfacesContext.f21483a.f21653a.clear();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -952613613, a);
    }

    private void m22468a(BaseAdInterfacesData baseAdInterfacesData, Bundle bundle) {
        if (this.f21521Q) {
            this.f21505A.b(5898241, (short) 4);
        } else if (baseAdInterfacesData == null) {
            m22498o();
            this.f21505A.b(5898241, (short) 3);
        } else {
            m22467a(baseAdInterfacesData);
            LinearLayout linearLayout = (LinearLayout) a(2131558429);
            LayoutInflater layoutInflater = getLayoutInflater();
            linearLayout.setPadding(0, 0, 0, 0);
            linearLayout.removeAllViews();
            if (this.f21523S != null) {
                ((ViewGroup) this.f21523S.getParent()).removeView(this.f21523S);
                this.f21523S = null;
            }
            ((LinearLayout) a(2131564322)).removeAllViews();
            m22497n();
            Builder builder = new Builder();
            ImmutableList a = m22501r(this).mo968a();
            int size = a.size();
            int i = 0;
            View view = null;
            while (i < size) {
                View view2;
                AdInterfacesComponent adInterfacesComponent = (AdInterfacesComponent) a.get(i);
                if (m22476a(adInterfacesComponent, baseAdInterfacesData)) {
                    View a2 = m22462a(adInterfacesComponent, baseAdInterfacesData, layoutInflater, linearLayout);
                    if (a2 != null) {
                        if (m22475a(adInterfacesComponent, bundle)) {
                            builder.c(adInterfacesComponent);
                            if (adInterfacesComponent.mo949c() == this.f21514J) {
                                view2 = a2;
                            }
                        } else {
                            m22474a(adInterfacesComponent);
                            view2 = view;
                        }
                        i++;
                        view = view2;
                    }
                }
                view2 = view;
                i++;
                view = view2;
            }
            m22499p();
            this.f21512H = builder.b();
            if (VERSION.SDK_INT >= 11) {
                linearLayout.setLayoutTransition(new LayoutTransition());
            }
            this.f21505A.b(5898241, (short) 2);
            if (view != null) {
                AdInterfacesUiUtil.m25239b(view);
            }
            this.f21514J = null;
        }
    }

    private boolean m22481b(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData == null) {
            return false;
        }
        if (baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) {
            return true;
        }
        if ((baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) && this.f21531p.a(ExperimentsForAdInterfacesModule.f21607d, false)) {
            return true;
        }
        return false;
    }

    private boolean m22476a(AdInterfacesComponent adInterfacesComponent, BaseAdInterfacesData baseAdInterfacesData) {
        try {
            return adInterfacesComponent.mo947a(baseAdInterfacesData);
        } catch (Throwable e) {
            this.f21539x.m22727a(AdInterfacesObjectiveActivity.class, "isNeeded for " + adInterfacesComponent.getClass().getCanonicalName() + " failed", e);
            return false;
        }
    }

    private View m22462a(AdInterfacesComponent adInterfacesComponent, BaseAdInterfacesData baseAdInterfacesData, LayoutInflater layoutInflater, LinearLayout linearLayout) {
        try {
            if (adInterfacesComponent.mo948b() != null) {
                adInterfacesComponent.mo948b().mo988a(this.f21506B);
            }
            return m22477b(adInterfacesComponent, baseAdInterfacesData, layoutInflater, linearLayout);
        } catch (Throwable e) {
            this.f21539x.m22727a(AdInterfacesObjectiveActivity.class, "bindComponent for " + adInterfacesComponent.getClass().getCanonicalName() + " failed", e);
            return null;
        }
    }

    private View m22477b(AdInterfacesComponent adInterfacesComponent, BaseAdInterfacesData baseAdInterfacesData, LayoutInflater layoutInflater, LinearLayout linearLayout) {
        View inflate = layoutInflater.inflate(adInterfacesComponent.mo946a(), linearLayout, false);
        if (adInterfacesComponent.mo949c() == ComponentType.FOOTER && m22481b(baseAdInterfacesData)) {
            ((LinearLayout) a(2131564322)).addView(inflate);
        } else if (adInterfacesComponent instanceof ValidationComponent) {
            View a = a(2131564320);
            ViewGroup viewGroup = (ViewGroup) a.getParent();
            int indexOfChild = viewGroup.indexOfChild(a);
            if (indexOfChild >= 0) {
                this.f21523S = inflate;
                viewGroup.addView(inflate, indexOfChild);
            }
        } else {
            linearLayout.addView(inflate);
        }
        if (inflate instanceof AdInterfacesCardLayout) {
            AdInterfacesCardLayout adInterfacesCardLayout = (AdInterfacesCardLayout) inflate;
            a = adInterfacesCardLayout.getChildAt(6);
            inflate = adInterfacesCardLayout;
        } else {
            a = inflate;
            inflate = null;
        }
        BaseAdInterfacesViewController b = adInterfacesComponent.mo948b();
        if (b != null) {
            try {
                b.mo983a(baseAdInterfacesData);
                b.mo982a(a, inflate);
            } catch (Throwable e) {
                Throwable th = e;
                if (adInterfacesComponent.mo949c() == ComponentType.FOOTER && m22481b(baseAdInterfacesData)) {
                    ((LinearLayout) a(2131564322)).removeAllViews();
                    if (inflate == null) {
                        inflate = a;
                    }
                    linearLayout.removeView(inflate);
                    this.f21539x.m22727a(getClass(), "bindComponent for " + adInterfacesComponent.getClass().getCanonicalName() + " failed", th);
                    return null;
                }
                if (inflate == null) {
                    inflate = a;
                }
                linearLayout.removeView(inflate);
                this.f21539x.m22727a(getClass(), "bindComponent for " + adInterfacesComponent.getClass().getCanonicalName() + " failed", th);
                return null;
            }
        }
        if (inflate != null) {
            return inflate;
        }
        return a;
    }

    private boolean m22475a(AdInterfacesComponent adInterfacesComponent, Bundle bundle) {
        if (adInterfacesComponent.mo948b() == null) {
            return true;
        }
        try {
            adInterfacesComponent.mo948b().mo985b(bundle);
            return true;
        } catch (Throwable e) {
            this.f21539x.m22727a(AdInterfacesObjectiveActivity.class, "restore for " + adInterfacesComponent.getClass().getCanonicalName() + " failed", e);
            return false;
        }
    }

    private boolean m22474a(AdInterfacesComponent adInterfacesComponent) {
        try {
            BaseAdInterfacesViewController b = adInterfacesComponent.mo948b();
            if (b != null) {
                b.mo981a();
            }
            return true;
        } catch (Throwable e) {
            this.f21539x.m22727a(AdInterfacesObjectiveActivity.class, "Exception Caught in unbind of component " + adInterfacesComponent.getClass().getCanonicalName(), e);
            return false;
        }
    }

    private void m22493j() {
        if (this.f21508D != null) {
            this.f21508D.a();
        }
        this.f21529Y = null;
        if (this.f21512H != null) {
            int size = this.f21512H.size();
            for (int i = 0; i < size; i++) {
                m22474a((AdInterfacesComponent) this.f21512H.get(i));
            }
        }
    }

    private boolean m22480b(AdInterfacesComponent adInterfacesComponent, Bundle bundle) {
        try {
            BaseAdInterfacesViewController b = adInterfacesComponent.mo948b();
            if (b != null) {
                b.mo984a(bundle);
            }
            return true;
        } catch (Throwable e) {
            this.f21539x.m22727a(AdInterfacesObjectiveActivity.class, "Exception Caught in save of component " + adInterfacesComponent.getClass().getCanonicalName(), e);
            return false;
        }
    }

    private String m22494k() {
        if (this.f21522R == null) {
            this.f21522R = getIntent().getStringExtra("flow_id");
            if (this.f21522R == null) {
                this.f21522R = SafeUUIDGenerator.a().toString();
            }
            this.f21507C.f21686e = this.f21522R;
        }
        return this.f21522R;
    }

    public static FbNetworkManager m22495l(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
        if (adInterfacesObjectiveActivity.f21528X == null) {
            adInterfacesObjectiveActivity.f21528X = (FbNetworkManager) adInterfacesObjectiveActivity.f21540y.get();
        }
        return adInterfacesObjectiveActivity.f21528X;
    }

    public static ErrorDialogs m22496m(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
        if (adInterfacesObjectiveActivity.f21530Z == null) {
            adInterfacesObjectiveActivity.f21530Z = (ErrorDialogs) adInterfacesObjectiveActivity.f21541z.get();
        }
        return adInterfacesObjectiveActivity.f21530Z;
    }

    private void m22497n() {
        this.f21524T.setVisibility(8);
        if (this.f21525U != null) {
            this.f21525U.b();
            this.f21525U = null;
        }
    }

    private void m22498o() {
        m22497n();
        if (this.f21526V == null) {
            this.f21526V = (GenericErrorView) ((GenericErrorViewStub) a(2131564319)).a();
        }
        this.f21526V.setVisibility(0);
        if (m22495l(this).d()) {
            this.f21526V.b();
        } else {
            this.f21526V.a();
        }
        this.f21526V.setOnClickListener(new C24792(this));
    }

    private boolean m22499p() {
        if (!this.f21516L) {
            return false;
        }
        AdInterfacesEventBus adInterfacesEventBus = this.f21533r;
        int i = this.f21517M;
        int i2 = this.f21518N;
        Intent intent = this.f21519O;
        IntentHandler intentHandler = (IntentHandler) adInterfacesEventBus.f21653a.get(i2);
        if (intentHandler != null) {
            intentHandler.mo980a(i, intent);
        }
        this.f21519O = null;
        this.f21516L = false;
        return true;
    }

    public static void m22483c(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity, final Bundle bundle) {
        if (adInterfacesObjectiveActivity.f21520P) {
            m22485d(adInterfacesObjectiveActivity, bundle);
            adInterfacesObjectiveActivity.m22499p();
            return;
        }
        adInterfacesObjectiveActivity.f21524T.setVisibility(0);
        adInterfacesObjectiveActivity.m22500q();
        m22501r(adInterfacesObjectiveActivity).mo969a(adInterfacesObjectiveActivity.getIntent(), new AdInterfacesDataModel$AdInterfacesDataModelCallback(adInterfacesObjectiveActivity) {
            final /* synthetic */ AdInterfacesObjectiveActivity f21495b;

            public final void mo941a(BaseAdInterfacesData baseAdInterfacesData) {
                this.f21495b.f21520P = true;
                if (AdInterfacesObjectiveActivity.m22487e(this.f21495b, baseAdInterfacesData)) {
                    baseAdInterfacesData.f21755k = "confirmation_dialogue";
                }
                this.f21495b.f21529Y = baseAdInterfacesData;
                this.f21495b.f21507C.f21687f = this.f21495b.f21529Y;
                this.f21495b.m22468a(baseAdInterfacesData, bundle);
                AdInterfacesObjectiveActivity adInterfacesObjectiveActivity = this.f21495b;
                if (baseAdInterfacesData != null) {
                    if (baseAdInterfacesData.mo962b() == ObjectiveType.BOOST_POST_INSIGHTS) {
                        adInterfacesObjectiveActivity.f21507C.m22783m(baseAdInterfacesData);
                    } else if (AdInterfacesDataHelper.m22814j(baseAdInterfacesData)) {
                        adInterfacesObjectiveActivity.f21507C.m22773d(baseAdInterfacesData);
                    } else {
                        adInterfacesObjectiveActivity.f21507C.m22765a(baseAdInterfacesData);
                    }
                }
                AdInterfacesObjectiveActivity.m22485d(this.f21495b, bundle);
                if ((baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) && baseAdInterfacesData.f21748d != null) {
                    GraphQLBoostedPostStatus graphQLBoostedPostStatus;
                    String str = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21781b;
                    AdInterfacesExternalEventBus adInterfacesExternalEventBus = this.f21495b.f21509E;
                    switch (C25081.f21690c[baseAdInterfacesData.f21748d.ordinal()]) {
                        case 1:
                        case 2:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.INACTIVE;
                            break;
                        case 3:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.ACTIVE;
                            break;
                        case 4:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.PAUSED;
                            break;
                        case 5:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.FINISHED;
                            break;
                        case 6:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.EXTENDABLE;
                            break;
                        case 7:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.REJECTED;
                            break;
                        case 8:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.PENDING;
                            break;
                        case 9:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.ERROR;
                            break;
                        default:
                            graphQLBoostedPostStatus = GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                            break;
                    }
                    adInterfacesExternalEventBus.a(new BoostedPostStatusChangedEvent(str, graphQLBoostedPostStatus));
                }
            }
        });
    }

    private void m22500q() {
        AdInterfacesObjective r = m22501r(this);
        if (r instanceof HasNavbarButtonSpec) {
            final HasNavbarButtonSpec hasNavbarButtonSpec = (HasNavbarButtonSpec) r;
            TitleBarButtonSpec b = hasNavbarButtonSpec.mo971b();
            if (this.f21531p.a(ExperimentsForAdInterfacesModule.f21606c, false)) {
                this.aa.setButtonSpecs(ImmutableList.of(b));
                this.aa.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
                    final /* synthetic */ AdInterfacesObjectiveActivity f21497b;

                    public final void m22448a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        hasNavbarButtonSpec.mo972c().mo970a(this.f21497b);
                    }
                });
            }
        }
    }

    public static void m22485d(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity, Bundle bundle) {
        ScrollViewLocker scrollViewLocker = adInterfacesObjectiveActivity.f21508D;
        String str = "adinterfaces_objective";
        View a = adInterfacesObjectiveActivity.a(2131564321);
        if (bundle != null) {
            View findViewById;
            scrollViewLocker.a();
            int i = bundle.getInt(str + ".scrollViewId");
            if (i != 0) {
                findViewById = a.findViewById(i);
                if (findViewById != null && (findViewById instanceof LockableScrollView)) {
                    scrollViewLocker.b = (LockableScrollView) findViewById;
                }
            }
            ArrayList integerArrayList = bundle.getIntegerArrayList(str + ".lockingViewIds");
            int size = integerArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                findViewById = a.findViewById(((Integer) integerArrayList.get(i2)).intValue());
                if (findViewById != null) {
                    scrollViewLocker.a.add(findViewById);
                }
            }
        }
    }

    public static AdInterfacesObjective m22501r(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
        if (adInterfacesObjectiveActivity.f21511G == null) {
            AdInterfacesObjectiveRegistry adInterfacesObjectiveRegistry = adInterfacesObjectiveActivity.f21532q;
            adInterfacesObjectiveActivity.f21511G = (AdInterfacesObjective) ((Provider) adInterfacesObjectiveRegistry.f21838a.get(adInterfacesObjectiveActivity.m22502s())).get();
        }
        return adInterfacesObjectiveActivity.f21511G;
    }

    private ObjectiveType m22502s() {
        return (ObjectiveType) getIntent().getSerializableExtra("objective");
    }

    private void m22503t() {
        C24825 c24825 = new C24825(this);
        C24836 c24836 = new C24836(this);
        C24847 c24847 = new C24847(this);
        C24858 c24858 = new C24858(this);
        C24879 c24879 = new C24879(this);
        this.f21535t.a(new FbEventSubscriber[]{c24836, c24847, c24858, c24879, c24825});
        this.f21535t.a(this.f21533r);
    }

    private void m22504u() {
        if (this.f21513I != -1) {
            if (this.f21536u == Product.PAA) {
                this.aa = new ActionBarBasedFbTitleBar(this, this.f21527W.g());
            } else if (this.f21536u == Product.FB4A) {
                FbTitleBarUtil.b(this);
                this.aa = (FbTitleBar) a(2131558563);
            }
            this.aa.setHasBackButton(true);
            this.aa.a(new OnClickListener(this) {
                final /* synthetic */ AdInterfacesObjectiveActivity f21489a;

                {
                    this.f21489a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1540304216);
                    this.f21489a.onBackPressed();
                    Logger.a(2, EntryType.UI_INPUT_END, 2112381285, a);
                }
            });
            this.aa.setTitle(this.f21513I);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (this.aa instanceof ActionBarBasedFbTitleBar) {
            ((ActionBarBasedFbTitleBar) this.aa).a(menu);
        }
        return onCreateOptionsMenu;
    }

    public static void m22505v(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity) {
        if (adInterfacesObjectiveActivity.getCurrentFocus() != null) {
            adInterfacesObjectiveActivity.f21537v.hideSoftInputFromWindow(adInterfacesObjectiveActivity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public final String m22506a() {
        return getIntent() == null ? null : getIntent().getStringExtra("uri_extra");
    }

    public static boolean m22487e(AdInterfacesObjectiveActivity adInterfacesObjectiveActivity, BaseAdInterfacesData baseAdInterfacesData) {
        if (adInterfacesObjectiveActivity.f21529Y == null) {
            return false;
        }
        switch (adInterfacesObjectiveActivity.f21529Y.f21748d) {
            case INACTIVE:
            case NEVER_BOOSTED:
                if (baseAdInterfacesData.f21748d == AdInterfacesStatus.ACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PENDING || baseAdInterfacesData.f21748d == AdInterfacesStatus.CREATING) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final void m22508b(int i) {
        if (m22481b(this.f21529Y)) {
            ((LinearLayout) a(2131558429)).setPadding(0, 0, 0, i);
        }
    }
}
