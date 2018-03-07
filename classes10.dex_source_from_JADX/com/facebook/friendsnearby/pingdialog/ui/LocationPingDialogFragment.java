package com.facebook.friendsnearby.pingdialog.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.friendsnearby.pingdialog.LocationPingDeleteParams;
import com.facebook.friendsnearby.pingdialog.LocationPingParams;
import com.facebook.friendsnearby.pingdialog.LocationPingTime;
import com.facebook.friendsnearby.pingdialog.LocationPingTime.Type;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQL.FriendsNearbyLocationPingToUserString;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLModels.FriendsNearbyLocationPingToUserModel;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLModels.OutgoingLocationPingModel;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment.AnonymousClass28;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.user.module.UserNameUtil;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: [[learn_more]] */
public class LocationPingDialogFragment extends LocationPingDialog {
    public static final Class<?> am = LocationPingDialogFragment.class;
    private static final CallerContext an = CallerContext.b(LocationPingDialogFragment.class, "nearby_friends");
    private static final FbLocationOperationParams ao;
    public User aA;
    @Nullable
    public LocationPingParams aB;
    private boolean aC;
    private Dialog aD;
    public AnonymousClass28 aE;
    public ImmutableList<LocationPingOption> aF;
    public LocationPingOptionsAdapter aG;
    private View aH;
    private TextView aI;
    public BetterListView aJ;
    public LocationPingOptionView aK;
    public View aL;
    public EditText aM;
    private TextView aN;
    public View aO;
    private View aP;
    private TextView aQ;
    private Button aR;
    private Button aS;
    public Clock ap;
    public TasksManager<Task> aq;
    private InputMethodManager ar;
    private Provider<FbLocationOperation> as;
    private GraphQLQueryExecutor at;
    public DefaultBlueServiceOperationFactory au;
    private LocationPingOptionsGenerator av;
    public Toaster aw;
    public PerformanceLogger ax;
    private UserNameUtil ay;
    public FriendsNearbyPingDialogAnalyticsLogger az;

    /* compiled from: [[learn_more]] */
    class C29412 implements TextWatcher {
        final /* synthetic */ LocationPingDialogFragment f20649a;

        C29412(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20649a = locationPingDialogFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int length = editable.length();
            LocationPingDialogFragment.m21133g(this.f20649a, length);
            this.f20649a.aM.setGravity(length == 0 ? 1 : 3);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29423 implements OnFocusChangeListener {
        final /* synthetic */ LocationPingDialogFragment f20650a;

        C29423(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20650a = locationPingDialogFragment;
        }

        public void onFocusChange(View view, boolean z) {
            LocationPingDialogFragment.m21134h(this.f20650a, !z);
            LocationPingDialogFragment.m21135j(this.f20650a, z);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29434 implements OnItemClickListener {
        final /* synthetic */ LocationPingDialogFragment f20651a;

        C29434(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20651a = locationPingDialogFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            LocationPingOption a = this.f20651a.aG.m21143a(i);
            this.f20651a.aK.setPingOption(a);
            LocationPingDialogFragment.m21127a(this.f20651a, a);
            LocationPingDialogFragment.m21131b(this.f20651a, a);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29445 implements OnClickListener {
        final /* synthetic */ LocationPingDialogFragment f20652a;

        C29445(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20652a = locationPingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1425520711);
            LocationPingDialogFragment.m21134h(this.f20652a, true);
            LocationPingDialogFragment.ax(this.f20652a);
            this.f20652a.aM.clearFocus();
            Logger.a(2, EntryType.UI_INPUT_END, 1388273173, a);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29456 implements OnClickListener {
        final /* synthetic */ LocationPingDialogFragment f20653a;

        C29456(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20653a = locationPingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 674252485);
            FriendsNearbyPingDialogAnalyticsLogger friendsNearbyPingDialogAnalyticsLogger = this.f20653a.az;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("friends_nearby_dashboard_ping_cancel");
            honeyClientEvent.c = "background_location";
            friendsNearbyPingDialogAnalyticsLogger.f20642a.a(honeyClientEvent);
            Preconditions.checkNotNull(this.f20653a.aB);
            LocationPingDialogFragment.m21126a(this.f20653a, new LocationPingTime(Type.STOP, Absent.INSTANCE), (Optional) Absent.INSTANCE);
            Logger.a(2, EntryType.UI_INPUT_END, 939492059, a);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29467 implements OnClickListener {
        final /* synthetic */ LocationPingDialogFragment f20654a;

        C29467(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20654a = locationPingDialogFragment;
        }

        public void onClick(View view) {
            Optional optional;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -912766116);
            LocationPingDialogFragment locationPingDialogFragment = this.f20654a;
            LocationPingOption locationPingOption = (LocationPingOption) locationPingDialogFragment.aF.get(locationPingDialogFragment.aJ.getCheckedItemPosition());
            Editable text = this.f20654a.aM.getText();
            if (text == null) {
                optional = Absent.INSTANCE;
            } else {
                optional = Optional.of(text.toString());
            }
            Optional optional2 = optional;
            FriendsNearbyPingDialogAnalyticsLogger friendsNearbyPingDialogAnalyticsLogger;
            String str;
            HoneyClientEvent honeyClientEvent;
            if (this.f20654a.aB == null) {
                friendsNearbyPingDialogAnalyticsLogger = this.f20654a.az;
                str = locationPingOption.f20660d;
                honeyClientEvent = new HoneyClientEvent("friends_nearby_dashboard_ping_send");
                honeyClientEvent.c = "background_location";
                HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
                honeyClientEvent2.b("duration_option", str);
                if (optional2.isPresent()) {
                    honeyClientEvent2.b("message", (String) optional2.get());
                }
                friendsNearbyPingDialogAnalyticsLogger.f20642a.a(honeyClientEvent2);
            } else {
                friendsNearbyPingDialogAnalyticsLogger = this.f20654a.az;
                str = locationPingOption.f20660d;
                honeyClientEvent = new HoneyClientEvent("friends_nearby_dashboard_ping_edit");
                honeyClientEvent.c = "background_location";
                honeyClientEvent = honeyClientEvent;
                honeyClientEvent.b("duration_option", str);
                friendsNearbyPingDialogAnalyticsLogger.f20642a.a(honeyClientEvent);
            }
            LocationPingDialogFragment.m21126a(this.f20654a, locationPingOption.f20657a, optional2);
            LogUtils.a(-215594644, a);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29478 implements OnClickListener {
        final /* synthetic */ LocationPingDialogFragment f20655a;

        C29478(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20655a = locationPingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1732944590);
            this.f20655a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 459651465, a);
        }
    }

    /* compiled from: [[learn_more]] */
    class C29489 extends AbstractDisposableFutureCallback<GraphQLResult<FriendsNearbyLocationPingToUserModel>> {
        final /* synthetic */ LocationPingDialogFragment f20656a;

        C29489(LocationPingDialogFragment locationPingDialogFragment) {
            this.f20656a = locationPingDialogFragment;
        }

        protected final void m21120a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f20656a.ax.c(3145739, "FriendsNearbyPingFetchExist");
            LocationPingDialogFragment.au(this.f20656a);
            if (((FriendsNearbyLocationPingToUserModel) graphQLResult.e).m21072a().m21068a().m21065a().isEmpty()) {
                this.f20656a.aB = null;
            } else {
                Optional optional;
                OutgoingLocationPingModel outgoingLocationPingModel = (OutgoingLocationPingModel) ((FriendsNearbyLocationPingToUserModel) graphQLResult.e).m21072a().m21068a().m21065a().get(0);
                CharSequence j = outgoingLocationPingModel.m21095j();
                if (StringUtil.c(j)) {
                    optional = Absent.INSTANCE;
                } else {
                    optional = Optional.of(j);
                }
                this.f20656a.aB = new LocationPingParams(this.f20656a.aA.a, LocationPingTime.m21040a(outgoingLocationPingModel, this.f20656a.ap.a()), Absent.INSTANCE, optional);
            }
            LocationPingDialogFragment.as(this.f20656a);
        }

        protected final void m21121a(Throwable th) {
            this.f20656a.ax.f(3145739, "FriendsNearbyPingFetchExist");
            this.f20656a.a();
            this.f20656a.aw.b(new ToastBuilder(2131230758));
        }
    }

    /* compiled from: [[learn_more]] */
    public enum Task {
        OBTAIN_EXISTING_PING,
        GET_LOCATION,
        SEND_PING,
        DELETE_PING
    }

    public static void m21128a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LocationPingDialogFragment) obj).m21124a((Clock) SystemClockMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), IdBasedProvider.a(fbInjector, 2481), GraphQLQueryExecutor.a(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), LocationPingOptionsGenerator.m21154b(fbInjector), Toaster.b(fbInjector), (PerformanceLogger) DelegatingPerformanceLogger.a(fbInjector), UserNameUtil.a(fbInjector), new FriendsNearbyPingDialogAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector)));
    }

    static {
        Builder c = FbLocationOperationParams.a(Priority.HIGH_ACCURACY).c(300000);
        c.b = 60000;
        c = c;
        c.c = 200.0f;
        c = c;
        c.d = 7000;
        ao = c.a();
    }

    public static LocationPingDialogFragment m21122a(User user, @Nullable LocationPingParams locationPingParams, boolean z) {
        Preconditions.checkNotNull(user);
        LocationPingDialogFragment locationPingDialogFragment = new LocationPingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("user", user);
        bundle.putParcelable("existing_ping", locationPingParams);
        bundle.putBoolean("ping_status_fetch", z);
        locationPingDialogFragment.g(bundle);
        return locationPingDialogFragment;
    }

    @Inject
    private void m21124a(Clock clock, TasksManager tasksManager, InputMethodManager inputMethodManager, Provider<FbLocationOperation> provider, GraphQLQueryExecutor graphQLQueryExecutor, BlueServiceOperationFactory blueServiceOperationFactory, LocationPingOptionsGenerator locationPingOptionsGenerator, Toaster toaster, PerformanceLogger performanceLogger, UserNameUtil userNameUtil, FriendsNearbyPingDialogAnalyticsLogger friendsNearbyPingDialogAnalyticsLogger) {
        this.ap = clock;
        this.aq = tasksManager;
        this.ar = inputMethodManager;
        this.as = provider;
        this.at = graphQLQueryExecutor;
        this.au = blueServiceOperationFactory;
        this.av = locationPingOptionsGenerator;
        this.aw = toaster;
        this.ax = performanceLogger;
        this.ay = userNameUtil;
        this.az = friendsNearbyPingDialogAnalyticsLogger;
    }

    public final void mo923a(AnonymousClass28 anonymousClass28) {
        this.aE = anonymousClass28;
    }

    public final void m21139a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -769780217);
        super.a(bundle);
        Bundle bundle2 = this.s;
        this.aA = (User) bundle2.getParcelable("user");
        this.aB = (LocationPingParams) bundle2.getParcelable("existing_ping");
        this.aC = bundle2.getBoolean("ping_status_fetch");
        Class cls = LocationPingDialogFragment.class;
        m21128a((Object) this, getContext());
        a(2, 2131624481);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 753385302, a);
    }

    public final Dialog m21141c(Bundle bundle) {
        this.aD = new Dialog(this, getContext(), d()) {
            final /* synthetic */ LocationPingDialogFragment f20648a;

            public boolean onTouchEvent(MotionEvent motionEvent) {
                Rect rect = new Rect();
                getWindow().getDecorView().getHitRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return super.onTouchEvent(motionEvent);
                }
                this.f20648a.a();
                return true;
            }
        };
        DialogWindowUtils.a(this.aD);
        return this.aD;
    }

    public final View m21137a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -965025907);
        View inflate = layoutInflater.inflate(2130905126, viewGroup, false);
        this.aH = FindViewUtil.b(inflate, 2131563558);
        this.aI = (TextView) FindViewUtil.b(inflate, 2131563559);
        this.aJ = (BetterListView) FindViewUtil.b(inflate, 2131563560);
        this.aK = (LocationPingOptionView) FindViewUtil.b(inflate, 2131563561);
        this.aL = FindViewUtil.b(inflate, 2131563562);
        this.aM = (EditText) FindViewUtil.b(inflate, 2131563563);
        this.aN = (TextView) FindViewUtil.b(inflate, 2131563564);
        this.aO = FindViewUtil.b(inflate, 2131563565);
        this.aP = FindViewUtil.b(inflate, 2131563568);
        this.aQ = (TextView) FindViewUtil.b(inflate, 2131563569);
        this.aR = (Button) FindViewUtil.b(inflate, 2131563567);
        this.aS = (Button) FindViewUtil.b(inflate, 2131563566);
        m21133g(this, 0);
        this.aM.addTextChangedListener(new C29412(this));
        this.aM.setOnFocusChangeListener(new C29423(this));
        this.aM.clearFocus();
        this.aJ.setOnItemClickListener(new C29434(this));
        this.aK.setOnClickListener(new C29445(this));
        this.aK.setChecked(false);
        this.aO.setOnClickListener(new C29456(this));
        this.aR.setOnClickListener(new C29467(this));
        this.aS.setOnClickListener(new C29478(this));
        if (this.aC) {
            at();
        } else {
            as(this);
        }
        LogUtils.f(227727320, a);
        return inflate;
    }

    public final void m21136I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -857017639);
        this.aq.c();
        ar();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -44041354, a);
    }

    public final void m21138a() {
        ax(this);
        super.b();
    }

    private void ar() {
        m21123a(3145739, "FriendsNearbyPingFetchExist");
        m21123a(3145738, "FriendsNearbyPingWrite");
        m21123a(3145737, "FriendsNearbyPingDelete");
    }

    private void m21123a(int i, String str) {
        this.ax.b(i, str);
    }

    public static void as(LocationPingDialogFragment locationPingDialogFragment) {
        Optional optional;
        int i;
        boolean z;
        boolean z2 = true;
        if (locationPingDialogFragment.aB == null) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(locationPingDialogFragment.aB.f20621b);
        }
        ImmutableList a = locationPingDialogFragment.av.m21158a(optional, locationPingDialogFragment.ay.a(locationPingDialogFragment.aA));
        if (locationPingDialogFragment.aB != null) {
            int size = a.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && !locationPingDialogFragment.m21129a(((LocationPingOption) a.get(i2)).f20657a)) {
                i3++;
                i2++;
            }
            optional = locationPingDialogFragment.aB.f20623d;
            locationPingDialogFragment.aM.setText((CharSequence) optional.orNull());
            m21133g(locationPingDialogFragment, optional.isPresent() ? ((String) optional.get()).length() : 0);
            i = i3;
        } else {
            m21133g(locationPingDialogFragment, 0);
            i = 0;
        }
        LocationPingOption locationPingOption = (LocationPingOption) a.get(i);
        locationPingDialogFragment.aF = a;
        locationPingDialogFragment.aG = new LocationPingOptionsAdapter(locationPingDialogFragment.getContext());
        LocationPingOptionsAdapter locationPingOptionsAdapter = locationPingDialogFragment.aG;
        locationPingOptionsAdapter.f20665b = a;
        AdapterDetour.a(locationPingOptionsAdapter, 1904188012);
        locationPingDialogFragment.aJ.setAdapter(locationPingDialogFragment.aG);
        locationPingDialogFragment.aJ.setItemChecked(i, true);
        locationPingDialogFragment.aK.setPingOption(locationPingOption);
        m21127a(locationPingDialogFragment, locationPingOption);
        m21131b(locationPingDialogFragment, locationPingOption);
        if (locationPingDialogFragment.aB == null) {
            z = true;
        } else {
            z = false;
        }
        locationPingDialogFragment.aL.setVisibility(z ? 0 : 8);
        m21135j(locationPingDialogFragment, false);
        if (locationPingDialogFragment.aB == null) {
            z2 = false;
        }
        locationPingDialogFragment.aO.setVisibility(z2 ? 0 : 8);
    }

    public static void m21126a(LocationPingDialogFragment locationPingDialogFragment, LocationPingTime locationPingTime, Optional optional) {
        if (locationPingDialogFragment.m21129a(locationPingTime)) {
            locationPingDialogFragment.a();
        } else if (locationPingTime.f20625a == Type.STOP) {
            Parcelable locationPingDeleteParams = new LocationPingDeleteParams(locationPingDialogFragment.aA.a);
            Bundle bundle = new Bundle();
            bundle.putParcelable("locationPingDeleteParams", locationPingDeleteParams);
            locationPingDialogFragment.ax.d(3145737, "FriendsNearbyPingDelete");
            locationPingDialogFragment.aq.a(Task.DELETE_PING, BlueServiceOperationFactoryDetour.a(locationPingDialogFragment.au, "delete_ping", bundle, 1926421163).a(), new AbstractDisposableFutureCallback<OperationResult>(locationPingDialogFragment) {
                final /* synthetic */ LocationPingDialogFragment f20647a;

                {
                    this.f20647a = r1;
                }

                protected final void m21118a(Object obj) {
                    this.f20647a.ax.c(3145737, "FriendsNearbyPingDelete");
                    this.f20647a.a();
                    if (this.f20647a.aE != null) {
                        AnonymousClass28 anonymousClass28 = this.f20647a.aE;
                        anonymousClass28.f20869b.ba.m20887b(anonymousClass28.f20868a);
                    }
                }

                protected final void m21119a(Throwable th) {
                    this.f20647a.ax.f(3145737, "FriendsNearbyPingDelete");
                    BLog.a(LocationPingDialogFragment.am, "Could not delete location ping", th);
                    this.f20647a.a();
                    this.f20647a.aw.b(new ToastBuilder(2131230758));
                }
            });
        } else {
            LocationPingParams locationPingParams = new LocationPingParams(locationPingDialogFragment.aA.a, locationPingTime, Absent.INSTANCE, optional);
            if (locationPingDialogFragment.aB == null) {
                locationPingDialogFragment.m21125a(locationPingParams);
            } else {
                m21130b(locationPingDialogFragment, locationPingParams);
            }
        }
    }

    private void at() {
        m21132f(2131230739);
        this.ax.d(3145739, "FriendsNearbyPingFetchExist");
        this.aq.a(Task.OBTAIN_EXISTING_PING, this.at.a(GraphQLRequest.a((FriendsNearbyLocationPingToUserString) new FriendsNearbyLocationPingToUserString().a("uid", this.aA.a))), new C29489(this));
    }

    private boolean m21129a(LocationPingTime locationPingTime) {
        if (this.aB != null) {
            LocationPingTime locationPingTime2 = this.aB.f20621b;
            if (locationPingTime2.f20625a != locationPingTime.f20625a) {
                return false;
            }
            if (locationPingTime2.f20625a == Type.FOREVER || locationPingTime2.f20626b.equals(locationPingTime.f20626b)) {
                return true;
            }
            return false;
        } else if (locationPingTime.f20625a == Type.STOP) {
            return true;
        } else {
            return false;
        }
    }

    private void m21125a(final LocationPingParams locationPingParams) {
        m21132f(2131242056);
        this.ax.d(3145738, "FriendsNearbyPingWrite");
        FbLocationOperation fbLocationOperation = (FbLocationOperation) this.as.get();
        fbLocationOperation.a(ao, an);
        this.aq.a(Task.GET_LOCATION, fbLocationOperation, new AbstractDisposableFutureCallback<ImmutableLocation>(this) {
            final /* synthetic */ LocationPingDialogFragment f20644b;

            protected final void m21114a(Object obj) {
                ImmutableLocation immutableLocation = (ImmutableLocation) obj;
                this.f20644b.ax.c(3145738, "FriendsNearbyPingWrite");
                LocationPingDialogFragment.m21130b(this.f20644b, new LocationPingParams(locationPingParams.f20620a, locationPingParams.f20621b, Optional.of(immutableLocation), locationPingParams.f20623d));
            }

            protected final void m21115a(Throwable th) {
                this.f20644b.ax.f(3145738, "FriendsNearbyPingWrite");
                BLog.a(LocationPingDialogFragment.am, "Could not get location for ping", th);
                this.f20644b.aw.b(new ToastBuilder(2131242057));
                LocationPingDialogFragment.au(this.f20644b);
            }
        });
    }

    public static void m21130b(LocationPingDialogFragment locationPingDialogFragment, final LocationPingParams locationPingParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("locationPingParams", locationPingParams);
        locationPingDialogFragment.m21132f(locationPingDialogFragment.aB == null ? 2131230740 : 2131230741);
        locationPingDialogFragment.ax.d(3145738, "FriendsNearbyPingWrite");
        locationPingDialogFragment.aq.a(Task.SEND_PING, BlueServiceOperationFactoryDetour.a(locationPingDialogFragment.au, "location_ping", bundle, 952583197).a(), new AbstractDisposableFutureCallback<OperationResult>(locationPingDialogFragment) {
            final /* synthetic */ LocationPingDialogFragment f20646b;

            protected final void m21116a(Object obj) {
                this.f20646b.ax.c(3145738, "FriendsNearbyPingWrite");
                this.f20646b.a();
                if (this.f20646b.aE != null) {
                    AnonymousClass28 anonymousClass28;
                    if (this.f20646b.aB == null) {
                        anonymousClass28 = this.f20646b.aE;
                        anonymousClass28.f20869b.ba.m20882a(anonymousClass28.f20868a, locationPingParams);
                        return;
                    }
                    anonymousClass28 = this.f20646b.aE;
                    anonymousClass28.f20869b.ba.m20882a(anonymousClass28.f20868a, locationPingParams);
                }
            }

            protected final void m21117a(Throwable th) {
                this.f20646b.ax.f(3145738, "FriendsNearbyPingWrite");
                BLog.a(LocationPingDialogFragment.am, "Could not send location ping", th);
                this.f20646b.aw.b(new ToastBuilder(2131230758));
                LocationPingDialogFragment.au(this.f20646b);
            }
        });
    }

    private void m21132f(int i) {
        this.aP.setVisibility(0);
        this.aH.setVisibility(4);
        this.aQ.setText(i);
    }

    public static void au(LocationPingDialogFragment locationPingDialogFragment) {
        locationPingDialogFragment.aP.setVisibility(4);
        locationPingDialogFragment.aH.setVisibility(0);
    }

    public static void m21127a(LocationPingDialogFragment locationPingDialogFragment, LocationPingOption locationPingOption) {
        locationPingDialogFragment.aI.setText(locationPingOption.f20658b);
    }

    public static void m21134h(LocationPingDialogFragment locationPingDialogFragment, boolean z) {
        int i;
        int i2 = 8;
        BetterListView betterListView = locationPingDialogFragment.aJ;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        betterListView.setVisibility(i);
        LocationPingOptionView locationPingOptionView = locationPingDialogFragment.aK;
        if (!z) {
            i2 = 0;
        }
        locationPingOptionView.setVisibility(i2);
    }

    public static void m21133g(LocationPingDialogFragment locationPingDialogFragment, int i) {
        locationPingDialogFragment.aN.setText(locationPingDialogFragment.jW_().getString(2131242045, new Object[]{Integer.valueOf(i), Integer.valueOf(locationPingDialogFragment.jW_().getInteger(2131492962))}));
    }

    public static void m21135j(LocationPingDialogFragment locationPingDialogFragment, boolean z) {
        locationPingDialogFragment.aN.setVisibility(z ? 0 : 8);
    }

    public static void m21131b(LocationPingDialogFragment locationPingDialogFragment, LocationPingOption locationPingOption) {
        if (locationPingDialogFragment.m21129a(locationPingOption.f20657a)) {
            locationPingDialogFragment.aR.setText(2131230726);
        } else if (locationPingDialogFragment.aB == null) {
            locationPingDialogFragment.aR.setText(2131242046);
        } else {
            locationPingDialogFragment.aR.setText(2131242047);
        }
    }

    public static void ax(LocationPingDialogFragment locationPingDialogFragment) {
        locationPingDialogFragment.ar.hideSoftInputFromWindow(locationPingDialogFragment.aM.getWindowToken(), 0);
    }
}
