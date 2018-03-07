package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.cache.DynamicContactDataCache;
import com.facebook.contacts.cache.FavoriteContactsCache;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType;
import com.facebook.contacts.picker.ContactPickerHeaderViewManager;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerView.OnContactListScrollListener;
import com.facebook.contacts.picker.DivebarNearbyFriendsRow;
import com.facebook.contacts.picker.DivebarSearchableContactPickerView;
import com.facebook.contacts.picker.SearchableContactPickerView.4;
import com.facebook.contacts.picker.UserComparatorByName;
import com.facebook.contacts.server.FetchChatContextParams;
import com.facebook.contacts.server.FetchChatContextResult;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.contacts.loader.ContactListsCache;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.Result;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import com.facebook.messaging.graphql.divebar.FetchDivebarNearbyFriendsStatusGraphQL.DivebarNearbyFriendsStatusQueryString;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.contacts.divebar.DivebarNearbyFriendsController.C08531;
import com.facebook.orca.contacts.divebar.DivebarNearbyFriendsController.C08542;
import com.facebook.orca.contacts.divebar.DivebarNearbyFriendsController.C08563;
import com.facebook.orca.contacts.favorites.DivebarFavoritesSectionController;
import com.facebook.orca.contacts.picker.C0899x7b1ba9de;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceManager.PresenceListener;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: one_hour */
public class DivebarFragment extends DrawerContentFragment {
    public static final Class<?> f5818a = DivebarFragment.class;
    public static final FbLocationOperationParams f5819b;
    public static final CallerContext f5820c = CallerContext.a(DivebarFragment.class);
    public QuickPerformanceLogger aA;
    private Provider<Boolean> aB;
    private boolean aC;
    private GatekeeperStoreImpl aD;
    public DivebarPickerView aE;
    private RowCreator aF;
    public List<User> aG;
    public List<User> aH;
    public List<User> aI;
    private long aJ = 0;
    public long aK;
    public int aL = 0;
    private boolean aM;
    private boolean aN;
    private BaseFbBroadcastManager aO;
    private SelfRegistrableReceiverImpl aP;
    private DivebarFragmentBroadcastActionReceiver aQ;
    public ImmutableMap<UserKey, ChatContextForUser> aR;
    private ContactPickerUserRow aS;
    private DivebarNearbyFriendsRow aT;
    private UserComparatorByName al;
    private LoggedInUserSessionManager am;
    private TasksManager<Task> an;
    public Provider<FbLocationOperation> ao;
    public DefaultBlueServiceOperationFactory ap;
    private DynamicContactDataCache aq;
    public DivebarNearbyFriendsController ar;
    private DivebarSelfProfileController as;
    private ExecutorService at;
    private DivebarFavoritesSectionController au;
    private AnalyticsTagger av;
    private DivebarViewListener aw;
    private DefaultPresenceManager ax;
    private PresenceListener ay;
    public Provider<Boolean> az;
    private AddressBookPeriodicRunner f5821d;
    private ContactListsCache f5822e;
    private FavoriteContactsCache f5823f;
    public ContactPickerRowsFactory f5824g;
    private ContactsLoaderFactory f5825h;
    private ContactsLoader f5826i;

    /* compiled from: one_hour */
    class C08431 implements Callback<Void, Result, Throwable> {
        final /* synthetic */ DivebarFragment f5807a;

        C08431(DivebarFragment divebarFragment) {
            this.f5807a = divebarFragment;
        }

        public final void m5492a(@Nullable Object obj, Object obj2) {
            DivebarFragment.m5506a(this.f5807a, (Result) obj2);
        }

        public final /* bridge */ /* synthetic */ void m5493b(@Nullable Object obj, Object obj2) {
        }

        public final void m5494c(Object obj, Object obj2) {
            this.f5807a.aA.b(6225921, (short) 3);
        }
    }

    /* compiled from: one_hour */
    class C08442 implements RowCreator {
        final /* synthetic */ DivebarFragment f5808a;

        C08442(DivebarFragment divebarFragment) {
            this.f5808a = divebarFragment;
        }

        public final ContactPickerRow m5495a(Object obj) {
            if (obj instanceof User) {
                return this.f5808a.f5824g.m1790a((User) obj, ContactRowSectionType.SEARCH_RESULT, (ChatContextForUser) this.f5808a.aR.get(((User) obj).T));
            }
            if (obj instanceof ThreadSummary) {
                return this.f5808a.f5824g.m1787a((ThreadSummary) obj, GroupRowSectionType.SEARCH_RESULT);
            }
            BLog.a(DivebarFragment.f5818a, "unexpected rowData of type: " + obj.getClass());
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: one_hour */
    class C08453 extends PresenceListener {
        final /* synthetic */ DivebarFragment f5809a;

        C08453(DivebarFragment divebarFragment) {
            this.f5809a = divebarFragment;
        }

        public final void m5496a() {
            if (((Boolean) this.f5809a.az.get()).booleanValue()) {
                DivebarFragment.aw(this.f5809a);
            }
        }

        public final void m5497b() {
            if (((Boolean) this.f5809a.az.get()).booleanValue()) {
                DivebarFragment.aw(this.f5809a);
            }
        }
    }

    /* compiled from: one_hour */
    class C08464 implements OnContactListScrollListener {
        final /* synthetic */ DivebarFragment f5810a;

        C08464(DivebarFragment divebarFragment) {
            this.f5810a = divebarFragment;
        }

        public final void m5498a(int i) {
            this.f5810a.aL = i;
            this.f5810a.aK = SystemClock.uptimeMillis();
        }
    }

    /* compiled from: one_hour */
    class C08475 implements Callable<ListenableFuture<ImmutableLocation>> {
        final /* synthetic */ DivebarFragment f5811a;

        C08475(DivebarFragment divebarFragment) {
            this.f5811a = divebarFragment;
        }

        public Object call() {
            FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f5811a.ao.get();
            fbLocationOperation.a(DivebarFragment.f5819b, DivebarFragment.f5820c);
            return fbLocationOperation;
        }
    }

    /* compiled from: one_hour */
    class C08486 extends AbstractDisposableFutureCallback<ImmutableLocation> {
        final /* synthetic */ DivebarFragment f5812a;

        C08486(DivebarFragment divebarFragment) {
            this.f5812a = divebarFragment;
        }

        protected final void m5499a(Object obj) {
            DivebarFragment.m5505a(this.f5812a, (ImmutableLocation) obj);
        }

        protected final void m5500a(Throwable th) {
            BLog.b(DivebarFragment.f5818a, "Failed to get location", th);
            DivebarFragment.m5505a(this.f5812a, null);
        }
    }

    /* compiled from: one_hour */
    class C08508 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ DivebarFragment f5815a;

        C08508(DivebarFragment divebarFragment) {
            this.f5815a = divebarFragment;
        }

        protected final void m5501a(Object obj) {
            DivebarFragment.m5507a(this.f5815a, ((FetchChatContextResult) ((OperationResult) obj).h()).a);
        }

        protected final void m5502a(Throwable th) {
            BLog.b(DivebarFragment.f5818a, "Failed to load chat contexts", th);
        }
    }

    /* compiled from: one_hour */
    class C08519 implements Function<OperationResult, Map<UserKey, ChatContextForUser>> {
        final /* synthetic */ DivebarFragment f5816a;

        C08519(DivebarFragment divebarFragment) {
            this.f5816a = divebarFragment;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            return ((FetchChatContextResult) operationResult.h()).a;
        }
    }

    /* compiled from: one_hour */
    class DivebarFragmentBroadcastActionReceiver implements ActionReceiver {
        final /* synthetic */ DivebarFragment f5817a;

        public DivebarFragmentBroadcastActionReceiver(DivebarFragment divebarFragment) {
            this.f5817a = divebarFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1914107882);
            DivebarFragment divebarFragment = this.f5817a;
            Object obj = 1;
            String action = intent.getAction();
            if (!("com.facebook.presence.PRESENCE_MANAGER_SETTINGS_CHANGED".equals(action) || "com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS".equals(action) || "com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS".equals(action))) {
                obj = null;
            }
            if (obj != null) {
                DivebarFragment.aw(divebarFragment);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 481129920, a);
        }
    }

    /* compiled from: one_hour */
    enum Task {
        LOCATION,
        CHAT_CONTEXTS,
        NEARBY_FRIENDS
    }

    public static void m5508a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DivebarFragment) obj).m5503a(AddressBookPeriodicRunner.a(injectorLike), ContactListsCache.a(injectorLike), ContactsLoaderFactory.a(injectorLike), FavoriteContactsCache.a(injectorLike), ContactPickerRowsFactory.m1785a(injectorLike), LoggedInUserSessionManager.a(injectorLike), TasksManager.a(injectorLike), IdBasedProvider.a(injectorLike, 2481), DefaultBlueServiceOperationFactory.a(injectorLike), DynamicContactDataCache.a(injectorLike), DivebarNearbyFriendsController.m5521a(injectorLike), DivebarSelfProfileController.m5541a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DivebarFavoritesSectionController.m5624a(injectorLike), AnalyticsTagger.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), DivebarViewListener.m5542a(injectorLike), DefaultPresenceManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4236), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4237), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    static {
        Builder a = FbLocationOperationParams.a(Priority.BALANCED_POWER_AND_ACCURACY);
        a.b = 900000;
        f5819b = a.a();
    }

    @Inject
    private void m5503a(AddressBookPeriodicRunner addressBookPeriodicRunner, ContactListsCache contactListsCache, ContactsLoaderFactory contactsLoaderFactory, FavoriteContactsCache favoriteContactsCache, ContactPickerRowsFactory contactPickerRowsFactory, LoggedInUserAuthDataStore loggedInUserAuthDataStore, TasksManager tasksManager, Provider<FbLocationOperation> provider, BlueServiceOperationFactory blueServiceOperationFactory, DynamicContactDataCache dynamicContactDataCache, DivebarNearbyFriendsController divebarNearbyFriendsController, DivebarSelfProfileController divebarSelfProfileController, ExecutorService executorService, DivebarFavoritesSectionController divebarFavoritesSectionController, AnalyticsTagger analyticsTagger, FbBroadcastManager fbBroadcastManager, DivebarViewListener divebarViewListener, PresenceManager presenceManager, Provider<Boolean> provider2, QuickPerformanceLogger quickPerformanceLogger, Provider<Boolean> provider3, Boolean bool, GatekeeperStore gatekeeperStore) {
        this.f5821d = addressBookPeriodicRunner;
        this.f5822e = contactListsCache;
        this.f5825h = contactsLoaderFactory;
        this.f5823f = favoriteContactsCache;
        this.f5824g = contactPickerRowsFactory;
        this.am = loggedInUserAuthDataStore;
        this.an = tasksManager;
        this.ao = provider;
        this.ap = blueServiceOperationFactory;
        this.aq = dynamicContactDataCache;
        this.ar = divebarNearbyFriendsController;
        this.as = divebarSelfProfileController;
        this.at = executorService;
        this.au = divebarFavoritesSectionController;
        this.av = analyticsTagger;
        this.aw = divebarViewListener;
        this.aO = fbBroadcastManager;
        this.ax = presenceManager;
        this.az = provider2;
        this.aA = quickPerformanceLogger;
        this.aB = provider3;
        this.aC = bool.booleanValue();
        this.aD = gatekeeperStore;
    }

    public final void m5513c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = DivebarFragment.class;
        m5508a((Object) this, getContext());
        this.al = new UserComparatorByName();
        this.f5826i = this.f5825h.a();
        this.f5826i.a(new C08431(this));
        this.aF = new C08442(this);
        this.aQ = new DivebarFragmentBroadcastActionReceiver(this);
        this.aP = this.aO.a().a("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED", this.aQ).a("com.facebook.presence.PRESENCE_MANAGER_SETTINGS_CHANGED", this.aQ).a("com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS", this.aQ).a("com.facebook.contacts.FAVORITE_CONTACT_SYNC_PROGRESS", this.aQ).a();
        this.ay = new C08453(this);
        this.ax.a(this.ay);
        this.ar.f5846i.f5902a = this;
        this.au.f5968d.f5902a = this;
        this.aA.a(6225921, (short) 44);
        this.aN = true;
    }

    public final View m5511a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1566812601);
        Context a2 = ContextUtils.a(getContext(), 2130772966, 2131625115);
        BaseSearchableContactPickerListAdapter b = C0899x7b1ba9de.m5653b(FbInjector.get(a2));
        b.d().a(this.aF);
        this.aE = new DivebarPickerView(a2, b);
        this.av.a(this.aE, "contacts_divebar", this);
        DivebarPickerView divebarPickerView = this.aE;
        C08464 c08464 = new C08464(this);
        DivebarSearchableContactPickerView divebarSearchableContactPickerView = divebarPickerView.f5873a;
        divebarSearchableContactPickerView.g.d = new 4(divebarSearchableContactPickerView, c08464);
        DivebarPickerView divebarPickerView2 = this.aE;
        if (this.aC) {
            i = 2131231204;
        } else {
            i = 2131231203;
        }
        divebarPickerView2.f5873a.setSearchHint(b(i));
        this.aA.a(6225921, (short) 45);
        divebarPickerView = this.aE;
        LogUtils.f(1208946343, a);
        return divebarPickerView;
    }

    public final void m5512a(View view, @Nullable Bundle bundle) {
        if (this.aE != null) {
            this.aE.f5881i = this.aw;
        }
        if (this.ar != null) {
            DivebarNearbyFriendsController divebarNearbyFriendsController = this.ar;
            DivebarViewListener divebarViewListener = this.aw;
            divebarNearbyFriendsController.f5847j = divebarViewListener;
            DivebarNearbyFriendsFragment divebarNearbyFriendsFragment = (DivebarNearbyFriendsFragment) divebarNearbyFriendsController.f5846i.m5564a("nearbyFriends");
            if (divebarNearbyFriendsFragment != null) {
                divebarNearbyFriendsFragment.f5858h = divebarViewListener;
            }
        }
    }

    public final void m5514d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1875782697);
        super.d(bundle);
        this.f5821d.a();
        ImmutableList b = this.f5823f.b();
        if (b != null) {
            this.aG = Lists.a(b);
        }
        b = this.f5822e.b();
        if (b != null) {
            this.aH = Lists.a(b);
        }
        b = this.f5822e.a();
        if (b != null) {
            this.aI = Lists.a(b);
        }
        if (this.aD.a(905, false)) {
            this.aR = this.aq.a();
        } else {
            this.aR = RegularImmutableBiMap.a;
        }
        DivebarSelfProfileController divebarSelfProfileController = this.as;
        this.aS = ((ContactPickerRowsFactory) divebarSelfProfileController.f5883a.get()).m1788a((User) divebarSelfProfileController.f5884b.get());
        this.aT = this.ar.m5524a();
        this.aE.m5539a();
        az();
        this.f5826i.a();
        ay();
        this.aP.b();
        LogUtils.f(437033088, a);
    }

    public final void m5510I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 623896903);
        super.I();
        this.ax.b(this.ay);
        this.f5826i.b();
        if (this.aP != null) {
            this.aP.c();
        }
        if (this.aE != null) {
            this.aE.f5875c.a();
        }
        this.aA.b(6225921, (short) 4);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 276112305, a);
    }

    private boolean av() {
        boolean z;
        boolean z2;
        if (this.aG == null || this.aH == null) {
            z = false;
        } else {
            z = true;
        }
        if (this.aM) {
            int i = 0;
            for (List list : Lists.a(new List[]{this.aG, this.aH, this.aI})) {
                int size;
                if (list != null) {
                    size = list.size();
                } else {
                    size = 0;
                }
                i = size + i;
            }
            if (i == 0) {
                z2 = true;
                if (z || r3) {
                    return true;
                }
                return false;
            }
        }
        z2 = false;
        if (z) {
        }
        return true;
    }

    public static void aw(DivebarFragment divebarFragment) {
        if (divebarFragment.am.b() && !divebarFragment.am.d()) {
            if (divebarFragment.aN || !((Boolean) divebarFragment.aB.get()).booleanValue()) {
                if (divebarFragment.av() && divebarFragment.aE != null) {
                    divebarFragment.aE.m5539a();
                }
                divebarFragment.f5826i.a();
            }
        }
    }

    public final void ar() {
        super.ar();
        this.aN = true;
        this.ax.a(this);
    }

    public final void as() {
        super.as();
        this.aN = false;
        if (this.ax != null) {
            this.ax.b(this);
        }
    }

    public final void m5509G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1813678277);
        super.G();
        this.ax.a(this);
        ax();
        ay();
        DivebarPickerView divebarPickerView = this.aE;
        ContactPickerHeaderViewManager contactPickerHeaderViewManager = divebarPickerView.f5875c;
        QuickPromotionDiveBarViewController quickPromotionDiveBarViewController = divebarPickerView.f5877e;
        if (!contactPickerHeaderViewManager.b.contains(quickPromotionDiveBarViewController)) {
            contactPickerHeaderViewManager.b.add(quickPromotionDiveBarViewController);
        }
        if (contactPickerHeaderViewManager.d == null) {
            ContactPickerHeaderViewManager.b(contactPickerHeaderViewManager);
        }
        this.aA.a(6225921, (short) 42);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -787155224, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -134372195);
        super.mj_();
        this.aA.a(6225921, (short) 47);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -778913238, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1719639283);
        super.mY_();
        this.an.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1598293744, a);
    }

    public final void m5515g(boolean z) {
        super.g(z);
        if (!z && this.aE != null) {
            DivebarPickerView divebarPickerView = this.aE;
            String str = "";
            if (str.length() == 0) {
                divebarPickerView.f5873a.a();
            } else {
                divebarPickerView.f5873a.setSearchBoxText(str);
            }
        }
    }

    private void ax() {
        Object obj = null;
        long c = this.f5823f.c();
        if (c > 0 && c != this.aJ) {
            ImmutableList b = this.f5823f.b();
            if (b != null) {
                this.aG = Lists.a(b);
                this.aJ = c;
                obj = 1;
            }
        }
        DivebarNearbyFriendsRow a = this.ar.m5524a();
        if ((this.aT == null && a != null) || (this.aT != null && a == null)) {
            this.aT = a;
            obj = 1;
        }
        if (obj != null) {
            az();
        }
    }

    private void ay() {
        if (this.aD.a(905, false)) {
            this.an.a(Task.LOCATION, new C08475(this), new C08486(this));
        }
    }

    public static void m5505a(@Nullable DivebarFragment divebarFragment, final ImmutableLocation immutableLocation) {
        divebarFragment.an.a(Task.CHAT_CONTEXTS, new Callable<ListenableFuture<OperationResult>>(divebarFragment) {
            final /* synthetic */ DivebarFragment f5814b;

            public Object call() {
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchChatContextParams", new FetchChatContextParams(Optional.fromNullable(immutableLocation), false));
                return BlueServiceOperationFactoryDetour.a(this.f5814b.ap, "sync_chat_context", bundle, DivebarFragment.f5820c, 669176301).a();
            }
        }, new C08508(divebarFragment));
        final ListenableFuture a = Futures.a(divebarFragment.an.b(Task.CHAT_CONTEXTS), new C08519(divebarFragment), divebarFragment.at);
        if (divebarFragment.aT != null) {
            divebarFragment.an.a(Task.NEARBY_FRIENDS, new Callable<ListenableFuture<DivebarNearbyFriendsRow>>(divebarFragment) {
                final /* synthetic */ DivebarFragment f5803b;

                public Object call() {
                    DivebarNearbyFriendsController divebarNearbyFriendsController = this.f5803b.ar;
                    ListenableFuture listenableFuture = a;
                    Preconditions.checkState(divebarNearbyFriendsController.f5845h.a(516, false));
                    return Futures.a(Futures.b(new ListenableFuture[]{Futures.a(divebarNearbyFriendsController.f5840c.a(GraphQLRequest.a(new DivebarNearbyFriendsStatusQueryString())), new C08542(divebarNearbyFriendsController), divebarNearbyFriendsController.f5843f), Futures.b(listenableFuture, new C08563(divebarNearbyFriendsController), divebarNearbyFriendsController.f5843f)}), new C08531(divebarNearbyFriendsController), divebarNearbyFriendsController.f5843f);
                }
            }, new AbstractDisposableFutureCallback<DivebarNearbyFriendsRow>(divebarFragment) {
                final /* synthetic */ DivebarFragment f5804a;

                {
                    this.f5804a = r1;
                }

                protected final void m5488a(Object obj) {
                    DivebarFragment.m5504a(this.f5804a, (DivebarNearbyFriendsRow) obj);
                }

                protected final void m5489a(Throwable th) {
                    BLog.b(DivebarFragment.f5818a, "Failed to load nearby friends row", th);
                }
            });
        }
    }

    public static void m5507a(DivebarFragment divebarFragment, ImmutableMap immutableMap) {
        divebarFragment.aR = immutableMap;
        divebarFragment.az();
    }

    public static void m5504a(DivebarFragment divebarFragment, DivebarNearbyFriendsRow divebarNearbyFriendsRow) {
        Preconditions.checkNotNull(divebarFragment.aT);
        divebarFragment.aT = divebarNearbyFriendsRow;
        divebarFragment.az();
    }

    public static void m5506a(DivebarFragment divebarFragment, Result result) {
        Object obj = 1;
        if (!divebarFragment.mx_() || result == null) {
            return;
        }
        if (divebarFragment.aL == 0 || divebarFragment.aK <= 0 || SystemClock.uptimeMillis() - divebarFragment.aK >= 120000) {
            Object obj2 = null;
            divebarFragment.aM = result.w;
            if (result.g != null) {
                divebarFragment.aH = Lists.a(result.g);
                obj2 = 1;
            }
            if (result.d != null) {
                divebarFragment.aI = Lists.a(result.d);
                obj2 = 1;
            }
            if (result.b != null) {
                divebarFragment.aG = Lists.a(result.b);
            } else {
                obj = obj2;
            }
            if ((obj != null || !result.w) && divebarFragment.aE != null) {
                divebarFragment.az();
                divebarFragment.aA.a(6225921, (short) 31);
                divebarFragment.aE.f5882j = new Object(divebarFragment) {
                    public final /* synthetic */ DivebarFragment f5805a;

                    {
                        this.f5805a = r1;
                    }
                };
            }
        }
    }

    private void az() {
        if (this.aE != null) {
            List list = this.aG;
            List list2 = this.aH;
            Collection collection = this.aI;
            ImmutableList.Builder builder = ImmutableList.builder();
            if (av()) {
                this.aE.m5540a(builder.b());
                this.aE.m5539a();
                return;
            }
            if (this.aS != null) {
                builder.c(this.aS);
            }
            if (this.aT != null) {
                builder.c(this.aT);
            }
            Set a = Sets.a();
            this.au.m5625a(builder, new Object(this) {
                final /* synthetic */ DivebarFragment f5806a;

                {
                    this.f5806a = r1;
                }

                public final ContactPickerUserRow m5490a(User user, ContactRowSectionType contactRowSectionType) {
                    return this.f5806a.f5824g.m1790a(user, contactRowSectionType, (ChatContextForUser) this.f5806a.aR.get(user.T));
                }
            }, list, list2, a);
            List<User> a2 = Lists.a();
            if (collection != null) {
                a2.addAll(collection);
            }
            if (!a2.isEmpty()) {
                Collections.sort(a2, this.al);
                Object obj = null;
                for (User user : a2) {
                    if (!a.contains(user.T)) {
                        Object obj2;
                        if (obj == null) {
                            builder.c(new ContactPickerSectionHeaderRow(getContext().getString(2131231224)));
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        builder.c(this.f5824g.m1790a(user, ContactRowSectionType.UNKNOWN, (ChatContextForUser) this.aR.get(user.T)));
                        a.add(user.T);
                        obj = obj2;
                    }
                }
            }
            this.aE.m5540a(builder.b());
        }
    }
}
