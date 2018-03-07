package com.facebook.events.create;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.protocol.EventCreationMutations;
import com.facebook.events.create.protocol.EventCreationMutations.EditEventCoreMutationString;
import com.facebook.events.create.protocol.EventCreationMutationsModels.EditEventCoreMutationFieldsModel;
import com.facebook.events.create.protocol.EventCreationMutationsModels.EditEventCoreMutationFieldsModel.EventModel;
import com.facebook.events.create.ui.CohostsSelector;
import com.facebook.events.create.ui.CoverPhotoSelector;
import com.facebook.events.create.ui.CoverPhotoSelector.CoverPhotoRemovedListener;
import com.facebook.events.create.ui.EventCategorySelector;
import com.facebook.events.create.ui.EventCohostsModel;
import com.facebook.events.create.ui.EventCoverPhotoModel;
import com.facebook.events.create.ui.EventCreationCoverPhotoView;
import com.facebook.events.create.ui.EventDescriptionText;
import com.facebook.events.create.ui.EventNameEditText;
import com.facebook.events.create.ui.EventsCreationCoverPhotoAnimationController;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.graphql.EventsConverter;
import com.facebook.events.model.Event;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.protocol.EditEventParams;
import com.facebook.events.protocol.EventsQueries;
import com.facebook.events.ui.date.EventTimeModel;
import com.facebook.events.ui.date.StartAndEndTimeNikumanPicker;
import com.facebook.events.ui.location.EventLocationModel;
import com.facebook.events.ui.location.LocationNikumanPicker;
import com.facebook.events.ui.location.LocationPickerLauncher;
import com.facebook.events.ui.privacy.PrivacyOptionCheckbox;
import com.facebook.events.ui.privacy.PrivacyOptionCheckbox.OnPrivacyOptionToggledListener;
import com.facebook.events.ui.privacy.PrivacyPickerNikumanController;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.EventEditInputData;
import com.facebook.graphql.calls.EventEditInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventEditInputData.CoverPhotoInfo;
import com.facebook.graphql.calls.EventEditInputData.PostApprovalRequired;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.resources.ui.FbCheckedTextView;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: contact_list_header_text */
public class EventEditNikumanActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    ViewerContextManager f16197A;
    public EventCompositionModel f16198B;
    public Event f16199C;
    public Event f16200D;
    private String f16201E;
    private EventAnalyticsParams f16202F;
    private String f16203G;
    private ActionMechanism f16204H;
    private PrivacyOptionCheckbox f16205I;
    private Fb4aTitleBar f16206J;
    private FrameLayout f16207K;
    private EventNameEditText f16208L;
    private EventDescriptionText f16209M;
    private LocationNikumanPicker f16210N;
    private EventCategorySelector f16211O;
    private FrameLayout f16212P;
    private BetterEditTextView f16213Q;
    private StartAndEndTimeNikumanPicker f16214R;
    private CoverPhotoSelector f16215S;
    private CohostsSelector f16216T;
    public EventCreationCoverPhotoView f16217U;
    private LinearLayout f16218V;
    @Nullable
    private FbCheckedTextView f16219W;
    private EventsCreationCoverPhotoAnimationController f16220X;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f16221p;
    @Inject
    EventsCommonContract f16222q;
    @Inject
    EventCoverPhotoUploadHandler f16223r;
    @Inject
    EventCreationAnimationHelper f16224s;
    @Inject
    EventsEventBus f16225t;
    @Inject
    EventsQueries f16226u;
    @Inject
    Provider<LocationPickerLauncher> f16227v;
    @Inject
    PrivacyPickerNikumanController f16228w;
    @Inject
    TasksManager f16229x;
    @Inject
    Toaster f16230y;
    @Inject
    GraphQLQueryExecutor f16231z;

    /* compiled from: contact_list_header_text */
    class C22601 implements OnClickListener {
        final /* synthetic */ EventEditNikumanActivity f16191a;

        C22601(EventEditNikumanActivity eventEditNikumanActivity) {
            this.f16191a = eventEditNikumanActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1980268196);
            this.f16191a.onBackPressed();
            EventEditNikumanActivity.m16621z(this.f16191a);
            Logger.a(2, EntryType.UI_INPUT_END, 1192055108, a);
        }
    }

    /* compiled from: contact_list_header_text */
    class C22612 extends OnToolbarButtonListener {
        final /* synthetic */ EventEditNikumanActivity f16192a;

        C22612(EventEditNikumanActivity eventEditNikumanActivity) {
            this.f16192a = eventEditNikumanActivity;
        }

        public final void m16578a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (StringUtil.a(this.f16192a.f16198B.f16045c)) {
                this.f16192a.f16230y.b(new ToastBuilder(2131236906));
                return;
            }
            EventEditNikumanActivity.m16621z(this.f16192a);
            EventEditNikumanActivity.m16617v(this.f16192a);
        }
    }

    /* compiled from: contact_list_header_text */
    class C22623 implements CoverPhotoRemovedListener {
        final /* synthetic */ EventEditNikumanActivity f16193a;

        C22623(EventEditNikumanActivity eventEditNikumanActivity) {
            this.f16193a = eventEditNikumanActivity;
        }

        public final void mo779a() {
            this.f16193a.f16198B.f16049g.m16806a();
            this.f16193a.f16217U.m16824a(true);
        }
    }

    /* compiled from: contact_list_header_text */
    class C22634 implements OnClickListener {
        final /* synthetic */ EventEditNikumanActivity f16194a;

        C22634(EventEditNikumanActivity eventEditNikumanActivity) {
            this.f16194a = eventEditNikumanActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 374066758);
            ((FbCheckedTextView) view).toggle();
            Logger.a(2, EntryType.UI_INPUT_END, 1464256798, a);
        }
    }

    /* compiled from: contact_list_header_text */
    class C22645 implements OnPrivacyOptionToggledListener {
        final /* synthetic */ EventEditNikumanActivity f16195a;

        C22645(EventEditNikumanActivity eventEditNikumanActivity) {
            this.f16195a = eventEditNikumanActivity;
        }

        public final void mo772a(boolean z) {
            if (this.f16195a.f16228w != null) {
                this.f16195a.f16228w.m19744a(null, z);
            }
        }
    }

    /* compiled from: contact_list_header_text */
    class C22656 extends AbstractDisposableFutureCallback<GraphQLResult<EditEventCoreMutationFieldsModel>> {
        final /* synthetic */ EventEditNikumanActivity f16196a;

        C22656(EventEditNikumanActivity eventEditNikumanActivity) {
            this.f16196a = eventEditNikumanActivity;
        }

        protected final void m16582a(Object obj) {
            EventModel a = ((EditEventCoreMutationFieldsModel) ((GraphQLResult) obj).e).m16668a();
            if (a == null || a.m16665j() == null || !a.m16665j().equals(this.f16196a.f16200D.a)) {
                m16581b();
            }
            this.f16196a.f16226u.m19295a(this.f16196a.getResources().getDimensionPixelSize(2131431107), this.f16196a.f16200D.a);
            EventEditNikumanActivity.m16585B(this.f16196a);
            this.f16196a.setResult(-1);
            this.f16196a.f16225t.a(new EventUpdatedEvent(this.f16196a.f16200D.a));
            this.f16196a.finish();
        }

        protected final void m16583a(Throwable th) {
            BLog.b(EventEditNikumanActivity.class, "Error editing event: ", th);
            m16581b();
            EventEditNikumanActivity.m16585B(this.f16196a);
            this.f16196a.setResult(-1);
            this.f16196a.finish();
        }

        private void m16581b() {
            EventsProvider.a(this.f16196a.getApplicationContext().getContentResolver(), this.f16196a.f16222q, this.f16196a.f16199C, this.f16196a.f16221p);
        }
    }

    private static <T extends Context> void m16591a(Class<T> cls, T t) {
        m16592a((Object) t, (Context) t);
    }

    public static void m16592a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventEditNikumanActivity) obj).m16590a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), EventsCommonContract.b(injectorLike), EventCoverPhotoUploadHandler.m16454a(injectorLike), EventCreationAnimationHelper.m16469b(injectorLike), EventsEventBus.a(injectorLike), EventsQueries.m19293a(injectorLike), IdBasedProvider.a(injectorLike, 5707), PrivacyPickerNikumanController.m19735b(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), ViewerContextManagerProvider.b(injectorLike));
    }

    private void m16590a(ListeningExecutorService listeningExecutorService, EventsCommonContract eventsCommonContract, EventCoverPhotoUploadHandler eventCoverPhotoUploadHandler, EventCreationAnimationHelper eventCreationAnimationHelper, EventsEventBus eventsEventBus, EventsQueries eventsQueries, Provider<LocationPickerLauncher> provider, PrivacyPickerNikumanController privacyPickerNikumanController, TasksManager tasksManager, Toaster toaster, GraphQLQueryExecutor graphQLQueryExecutor, ViewerContextManager viewerContextManager) {
        this.f16221p = listeningExecutorService;
        this.f16222q = eventsCommonContract;
        this.f16223r = eventCoverPhotoUploadHandler;
        this.f16224s = eventCreationAnimationHelper;
        this.f16225t = eventsEventBus;
        this.f16226u = eventsQueries;
        this.f16227v = provider;
        this.f16228w = privacyPickerNikumanController;
        this.f16229x = tasksManager;
        this.f16230y = toaster;
        this.f16231z = graphQLQueryExecutor;
        this.f16197A = viewerContextManager;
    }

    public static Intent m16586a(Context context, Event event, String str, String str2, ActionMechanism actionMechanism) {
        Intent intent = new Intent(context, EventEditNikumanActivity.class);
        intent.putExtra("extras_event", event);
        intent.putExtra("extras_event_ticket_url", str);
        intent.putExtra("extra_ref_module", str2);
        intent.putExtra("extras_event_action_mechanism", actionMechanism);
        return intent;
    }

    protected final void m16622b(Bundle bundle) {
        super.b(bundle);
        Class cls = EventEditNikumanActivity.class;
        m16592a((Object) this, (Context) this);
        overridePendingTransition(2130968739, 2130968614);
        setContentView(2130904014);
        this.f16199C = (Event) getIntent().getParcelableExtra("extras_event");
        if (bundle == null) {
            this.f16198B = new EventCompositionModel(this.f16199C);
            this.f16198B.m16447a();
        } else {
            this.f16198B = (EventCompositionModel) bundle.getParcelable("EVENT_COMPOSITION_MODEL");
        }
        this.f16201E = getIntent().getStringExtra("extras_event_ticket_url");
        m16597c(bundle);
        Bundle extras = getIntent().getExtras();
        m16616u();
        this.f16203G = extras.getString("extra_ref_module");
        this.f16202F = new EventAnalyticsParams(EventActionContext.a, this.f16203G, am_().toString(), null);
        this.f16204H = (ActionMechanism) extras.getParcelable("extras_event_action_mechanism");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("EVENT_COMPOSITION_MODEL", this.f16198B);
        String str = "event_admin_post_approval_required";
        boolean z = this.f16219W != null && this.f16219W.isChecked();
        bundle.putBoolean(str, z);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m16595b(this.f16198B.f16049g.m16809g());
    }

    @TargetApi(21)
    public void onEnterAnimationComplete() {
        this.f16224s.m16471b(this.f16208L);
    }

    public void onBackPressed() {
        m16621z(this);
        if (m16604i()) {
            EventDiscardConfirmationDialog.m16577a(this, null);
        } else {
            super.onBackPressed();
        }
    }

    private boolean m16604i() {
        if (!Objects.equal(this.f16199C.b, this.f16198B.f16045c) || !Objects.equal(MentionsUtils.a(this.f16199C.c), this.f16198B.f16046d)) {
            return true;
        }
        EventCoverPhotoModel eventCoverPhotoModel = this.f16198B.f16049g;
        if (eventCoverPhotoModel.m16811k() || eventCoverPhotoModel.m16807d() || !Objects.equal(this.f16199C.V, eventCoverPhotoModel.f16327a)) {
            return true;
        }
        EventLocationModel eventLocationModel = this.f16198B.f16051i;
        if (this.f16199C.O != eventLocationModel.f19462b || !Objects.equal(this.f16199C.P, eventLocationModel.f19463c)) {
            return true;
        }
        EventTimeModel eventTimeModel = this.f16198B.f16050h;
        boolean z = eventTimeModel.f19387b;
        if (z != this.f16199C.M) {
            return true;
        }
        if (z) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            if (!simpleDateFormat.format(eventTimeModel.m19540d()).equals(simpleDateFormat.format(this.f16199C.J()))) {
                return true;
            }
        } else if (!Objects.equal(this.f16199C.J(), eventTimeModel.m19540d())) {
            return true;
        } else {
            if (!Objects.equal(this.f16199C.L(), eventTimeModel.m19542g())) {
                return true;
            }
        }
        if (this.f16199C.h != this.f16228w.f19539f) {
            return true;
        }
        if (!m16612q() && this.f16198B.m16449j()) {
            return true;
        }
        if (this.f16219W == null || this.f16199C.j == this.f16219W.isChecked()) {
            return false;
        }
        return true;
    }

    private void m16597c(Bundle bundle) {
        FbTitleBarUtil.b(this);
        this.f16206J = (Fb4aTitleBar) a(2131558563);
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getString(2131236943);
        a = a;
        a.h = -2;
        this.f16206J.setButtonSpecs(ImmutableList.of(a.a()));
        this.f16206J.setTitlebarAsModal(new C22601(this));
        this.f16206J.setOnToolbarButtonListener(new C22612(this));
        this.f16218V = (LinearLayout) a(2131561254);
        this.f16207K = (FrameLayout) a(2131561265);
        this.f16208L = (EventNameEditText) a(2131561236);
        this.f16208L.f16380h = this.f16224s;
        this.f16208L.m16847a(this.f16198B);
        this.f16209M = (EventDescriptionText) a(2131561241);
        this.f16209M.m16829a(this.f16198B);
        m16605j();
        m16606k();
        m16607l();
        m16608m();
        m16614s();
        m16609n();
        m16610o();
        m16600d(bundle);
        this.f16220X = new EventsCreationCoverPhotoAnimationController(this, this.f16215S, this.f16218V, this.f16207K, 300);
        this.f16217U = (EventCreationCoverPhotoView) a(2131561253);
        this.f16217U.m16823a(this.f16198B.f16049g, this.f16220X);
        m16615t();
    }

    private void m16605j() {
        this.f16214R = (StartAndEndTimeNikumanPicker) a(2131561237);
        this.f16214R.m19588a(this.f16198B.f16050h);
    }

    private void m16606k() {
        this.f16210N = (LocationNikumanPicker) a(2131561240);
        this.f16210N.m19645a(this.f16198B.f16051i, this.f16227v, this, 102, m16611p());
    }

    private void m16607l() {
        boolean z;
        this.f16211O = (EventCategorySelector) a(2131561257);
        if (!m16611p() || this.f16199C.aj == null) {
            z = false;
        } else {
            z = true;
        }
        this.f16211O.m16804a(this.f16198B, this.f16199C.u, z, 109);
    }

    private void m16608m() {
        this.f16212P = (FrameLayout) a(2131561259);
        this.f16213Q = (BetterEditTextView) a(2131561260);
        this.f16212P.setVisibility(m16611p() ? 0 : 8);
    }

    private void m16609n() {
        this.f16215S = (CoverPhotoSelector) a(2131561233);
        this.f16215S.setEventCompositionModel(this.f16198B);
        this.f16215S.f16308g = new C22623(this);
    }

    private void m16595b(boolean z) {
        this.f16217U.m16824a(false);
        this.f16220X.m16851a(z);
        this.f16220X.m16853b(z);
        this.f16215S.m16792a(z, false);
    }

    private void m16610o() {
        boolean z;
        boolean z2 = true;
        this.f16216T = (CohostsSelector) a(2131561263);
        CohostsSelector cohostsSelector = this.f16216T;
        EventCohostsModel eventCohostsModel = this.f16198B.f16052j;
        if (m16612q()) {
            z = false;
        } else {
            z = true;
        }
        if (m16584A()) {
            z2 = false;
        }
        cohostsSelector.m16769a(eventCohostsModel, 105, z, z2);
    }

    private void m16600d(Bundle bundle) {
        if (this.f16199C.l == GraphQLConnectionStyle.INTERESTED && this.f16199C != null && this.f16199C.i) {
            if (this.f16219W == null) {
                this.f16219W = (FbCheckedTextView) a(2131561264);
                this.f16219W.setOnClickListener(new C22634(this));
                this.f16219W.setVisibility(0);
            }
            this.f16219W.setChecked(bundle != null ? ((Boolean) FlatBufferModelHelper.a(bundle, "event_admin_post_approval_required")).booleanValue() : this.f16199C.j);
        }
    }

    private boolean m16611p() {
        return this.f16199C.f != null && this.f16199C.f == PrivacyType.PAGE;
    }

    private boolean m16612q() {
        return this.f16199C.f != null && this.f16199C.f == PrivacyType.GROUP;
    }

    private boolean m16613r() {
        return this.f16199C.f != null && (this.f16199C.f == PrivacyType.PAGE || this.f16199C.f == PrivacyType.GROUP);
    }

    private void m16614s() {
        this.f16205I = (PrivacyOptionCheckbox) a(2131561245);
        this.f16228w.m19748a(null, this.f16205I);
    }

    private void m16615t() {
        if (this.f16205I != null) {
            this.f16205I.f19491a = new C22645(this);
        }
    }

    private static boolean m16593a(PrivacyType privacyType) {
        return privacyType != null && (privacyType == PrivacyType.INVITE_ONLY || privacyType == PrivacyType.GROUP || privacyType == PrivacyType.COMMUNITY);
    }

    private void m16616u() {
        this.f16206J.setTitle(this.f16199C.b);
        m16595b(this.f16198B.f16049g.m16809g());
        this.f16213Q.setText(this.f16201E);
        if (this.f16199C.f != null) {
            boolean z;
            PrivacyPickerNikumanController privacyPickerNikumanController = this.f16228w;
            if (this.f16199C.k || m16613r()) {
                z = true;
            } else {
                z = false;
            }
            privacyPickerNikumanController.m19751a(z);
            this.f16228w.f19546m = this.f16199C.t;
            this.f16228w.m19745a(this.f16199C.f, this.f16199C.h, false);
            this.f16205I.setChecked(this.f16199C.h);
        }
        this.f16215S.f16310i = m16593a(this.f16228w.f19538e);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 102:
                    this.f16210N.m19644a(intent);
                    return;
                case 103:
                case 104:
                case 9913:
                    this.f16217U.m16822a(i, intent);
                    return;
                case 105:
                    this.f16216T.m16768a(intent);
                    return;
                case 109:
                    this.f16211O.m16803a(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void m16589a(EventEditInputData eventEditInputData) {
        CoverPhotoInfo coverPhotoInfo = new CoverPhotoInfo();
        EventCoverPhotoModel eventCoverPhotoModel = this.f16198B.f16049g;
        coverPhotoInfo.a((String) MoreObjects.firstNonNull(eventCoverPhotoModel.f16327a, "0"));
        coverPhotoInfo.a("photo_url", (String) MoreObjects.firstNonNull(eventCoverPhotoModel.m16808f(), "0"));
        coverPhotoInfo.a("theme_photo_id", (String) MoreObjects.firstNonNull(eventCoverPhotoModel.f16328b, "0"));
        eventEditInputData.a(coverPhotoInfo);
    }

    public static void m16617v(EventEditNikumanActivity eventEditNikumanActivity) {
        eventEditNikumanActivity.m16620y();
        eventEditNikumanActivity.f16200D = eventEditNikumanActivity.m16619x();
        EventsProvider.a(eventEditNikumanActivity.getContentResolver(), eventEditNikumanActivity.f16222q, eventEditNikumanActivity.f16200D, eventEditNikumanActivity.f16221p);
        EditEventParams editEventParams = new EditEventParams(eventEditNikumanActivity.f16202F.b, eventEditNikumanActivity.f16199C, eventEditNikumanActivity.f16200D);
        EventEditInputData w = eventEditNikumanActivity.m16618w();
        EventCoverPhotoModel eventCoverPhotoModel = eventEditNikumanActivity.f16198B.f16049g;
        if (eventCoverPhotoModel.m16811k()) {
            eventEditNikumanActivity.f16223r.m16458a(eventEditNikumanActivity.f16217U.getHandler(), eventCoverPhotoModel.f16329c, Long.parseLong(eventEditNikumanActivity.f16200D.a), eventEditNikumanActivity.f16202F, eventEditNikumanActivity.f16204H);
        } else if (!Objects.equal(eventCoverPhotoModel.f16327a, eventEditNikumanActivity.f16199C.V) || eventCoverPhotoModel.m16807d()) {
            eventEditNikumanActivity.m16589a(w);
        }
        if (eventEditNikumanActivity.f16198B.m16449j()) {
            EventCompositionModel eventCompositionModel = eventEditNikumanActivity.f16198B;
            Preconditions.checkNotNull(eventCompositionModel.f16043a);
            ImmutableList a = EventCompositionModel.m16446a(eventCompositionModel.f16052j.f16324a, eventCompositionModel.f16043a.f16052j.f16324a);
            ImmutableList l = eventEditNikumanActivity.f16198B.m16450l();
            if (CollectionUtil.b(a)) {
                w.a("add_host_ids", a);
            }
            if (CollectionUtil.b(l)) {
                w.a("remove_host_ids", l);
            }
        }
        if (eventEditNikumanActivity.m16611p()) {
            w.a("category_name", eventEditNikumanActivity.f16198B.f16053k.f16316a);
            if (!(eventEditNikumanActivity.f16213Q.getText() == null || StringUtil.a(eventEditNikumanActivity.f16213Q.getText().toString()))) {
                String trim = eventEditNikumanActivity.f16213Q.getText().toString().trim();
                if (m16596b(trim)) {
                    w.a("event_buy_ticket_url", trim);
                } else {
                    Toast.makeText(eventEditNikumanActivity, eventEditNikumanActivity.getResources().getString(2131236940), 1).show();
                    m16585B(eventEditNikumanActivity);
                    return;
                }
            }
        }
        if (eventEditNikumanActivity.f16219W != null) {
            Enum enumR;
            if (eventEditNikumanActivity.f16219W.isChecked()) {
                enumR = PostApprovalRequired.TRUE;
            } else {
                enumR = PostApprovalRequired.FALSE;
            }
            w.a("post_approval_required", enumR);
        }
        editEventParams.m19258a(w);
        eventEditNikumanActivity.f16229x.a("tasks-editEvent:" + eventEditNikumanActivity.f16199C.a, eventEditNikumanActivity.f16231z.a(GraphQLRequest.a((EditEventCoreMutationString) EventCreationMutations.m16643b().a("input", w))), new C22656(eventEditNikumanActivity));
    }

    private EventEditInputData m16618w() {
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(this.f16202F.c);
        if (this.f16204H != null) {
            eventActionHistory.b(this.f16204H.toString());
        }
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(this.f16202F.d);
        EventEditInputData.Context context = new EventEditInputData.Context();
        context.a(ImmutableList.of(eventActionHistory, eventActionHistory2));
        return new EventEditInputData().a(context);
    }

    private Event m16619x() {
        PrivacyType privacyType;
        if (this.f16228w.f19538e == null || this.f16228w.f19538e == PrivacyType.GROUP) {
            privacyType = this.f16199C.f;
        } else {
            privacyType = this.f16228w.f19538e;
        }
        EventTimeModel eventTimeModel = this.f16198B.f16050h;
        Event.Builder builder = new Event.Builder(this.f16199C);
        builder.b = this.f16198B.f16045c;
        builder = builder;
        builder.c = EventsConverter.a(this.f16209M.getDescriptionAsTextWithEntities());
        builder = builder;
        builder.K = eventTimeModel.f19387b;
        builder = builder;
        builder.J = eventTimeModel.f19388c;
        builder = builder;
        builder.H = eventTimeModel.m19540d();
        builder = builder;
        builder.I = eventTimeModel.m19542g();
        Event.Builder builder2 = builder;
        builder2.g = privacyType;
        Event.Builder builder3 = builder2;
        builder3.h = this.f16228w.f19539f;
        builder3 = builder3;
        m16588a(builder3);
        return builder3.b();
    }

    private void m16588a(Event.Builder builder) {
        Object obj;
        Object obj2 = 1;
        EventLocationModel eventLocationModel = this.f16198B.f16051i;
        if (Event.b(this.f16199C.O) && Objects.equal(Long.valueOf(this.f16199C.O), Long.valueOf(eventLocationModel.f19462b))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (Event.b(this.f16199C.O) || Event.b(eventLocationModel.f19462b) || !Objects.equal(this.f16199C.P, eventLocationModel.f19463c)) {
            obj2 = null;
        }
        if (obj != null || r1 != null) {
            return;
        }
        if (Event.b(eventLocationModel.f19462b)) {
            builder.a();
            CheckinPlaceModel checkinPlaceModel = eventLocationModel.f19461a;
            if (checkinPlaceModel != null) {
                double a;
                double b;
                String str;
                LocationModel cg_ = checkinPlaceModel.cg_();
                builder.M = Long.parseLong(checkinPlaceModel.cf_());
                Event.Builder builder2 = builder;
                builder2.N = checkinPlaceModel.j();
                Event.Builder builder3 = builder2;
                if (cg_ != null) {
                    a = cg_.a();
                } else {
                    a = 0.0d;
                }
                if (cg_ != null) {
                    b = cg_.b();
                } else {
                    b = 0.0d;
                }
                Event.Builder a2 = builder3.a(a, b);
                if (checkinPlaceModel.c() == null) {
                    str = null;
                } else {
                    str = checkinPlaceModel.c().b();
                }
                a2.O = str;
                return;
            }
            return;
        }
        builder.a(eventLocationModel.f19462b, eventLocationModel.f19463c);
    }

    private void m16620y() {
        ProgressDialogFragment.a(getString(2131236907), true, false).a(kO_(), "edit_progress_dialog");
    }

    public static void m16621z(EventEditNikumanActivity eventEditNikumanActivity) {
        ((InputMethodManager) eventEditNikumanActivity.getSystemService("input_method")).hideSoftInputFromWindow(eventEditNikumanActivity.f16208L.getWindowToken(), 0);
    }

    private boolean m16584A() {
        String str = this.f16197A.d().mUserId;
        return !StringUtil.a(str) && Objects.equal(str, this.f16199C.u);
    }

    private static boolean m16596b(String str) {
        if (StringUtil.a(str)) {
            return true;
        }
        return Patterns.WEB_URL.matcher(str).find();
    }

    public static void m16585B(EventEditNikumanActivity eventEditNikumanActivity) {
        FragmentManager kO_ = eventEditNikumanActivity.kO_();
        if (kO_ != null) {
            DialogFragment dialogFragment = (DialogFragment) kO_.a("edit_progress_dialog");
            if (dialogFragment != null) {
                dialogFragment.b();
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968724, 2130968740);
    }

    public final String am_() {
        return "event_edit_composer";
    }
}
