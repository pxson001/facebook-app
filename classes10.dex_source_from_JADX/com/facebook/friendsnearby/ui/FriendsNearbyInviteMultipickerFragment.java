package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Toast;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.apptab.ui.chrome.FinishHandler;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.friendsnearby.server.FriendsNearbyInviteParams;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery.FriendsNearbyInviteStatusQueryString;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyInviteFriendModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyInviteFriendModel.RequestableFieldsModel.NodesModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyInviteStatusQueryModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Weinre Server */
public class FriendsNearbyInviteMultipickerFragment extends GenericFriendsSelectorFragment implements AnalyticsFragment {
    public static String au = "all_friends_suggestion_section";
    public static final Class<?> av = FriendsNearbyInviteMultipickerFragment.class;
    public FriendsNearbyInviteAdapterViewFactory aA;
    public GraphQLQueryExecutor aB;
    private ExecutorService aC;
    public ImmutableSet<String> aD = RegularImmutableSet.a;
    public ImmutableSet<String> aE = RegularImmutableSet.a;
    public TasksManager aw;
    public Toaster ax;
    public DefaultBlueServiceOperationFactory ay;
    private FriendsNearbyInviteAnalyticsLogger az;

    /* compiled from: Weinre Server */
    public class C29671 extends OnToolbarButtonListener {
        final /* synthetic */ FriendsNearbyInviteMultipickerFragment f20925a;

        public C29671(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment) {
            this.f20925a = friendsNearbyInviteMultipickerFragment;
        }

        public final void m21884a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            FriendsNearbyInviteMultipickerFragment.aR(this.f20925a);
        }
    }

    /* compiled from: Weinre Server */
    class C29693 implements Function<List<?>, ImmutableMap<String, ImmutableList<User>>> {
        final /* synthetic */ FriendsNearbyInviteMultipickerFragment f20928a;

        C29693(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment) {
            this.f20928a = friendsNearbyInviteMultipickerFragment;
        }

        public Object apply(@Nullable Object obj) {
            List list = (List) obj;
            Builder builder = ImmutableMap.builder();
            if (list == null || list.size() != 3) {
                return builder.b();
            }
            ImmutableList immutableList;
            FriendsNearbyInviteMultipickerFragment.m21889a(this.f20928a, (GraphQLResult) list.get(2));
            this.f20928a.aA.f20922a = this.f20928a.aD;
            builder.a(FriendsNearbyInviteMultipickerFragment.m21888a(this.f20928a, (ImmutableMap) list.get(0), this.f20928a.aE));
            ImmutableList immutableList2 = (ImmutableList) list.get(1);
            String str = FriendsNearbyInviteMultipickerFragment.au;
            FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment = this.f20928a;
            ImmutableSet immutableSet = this.f20928a.aE;
            if (immutableList2 == null) {
                immutableList = RegularImmutableList.a;
            } else {
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                int size = immutableList2.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    int i3;
                    User user = (User) immutableList2.get(i);
                    if (immutableSet.contains(user.a)) {
                        builder2.c(user);
                        i3 = i2 + 1;
                        if (i3 >= 10) {
                            break;
                        }
                    } else {
                        i3 = i2;
                    }
                    i++;
                    i2 = i3;
                }
                immutableList = builder2.b();
            }
            builder.b(str, immutableList);
            return builder.b();
        }
    }

    /* compiled from: Weinre Server */
    public class C29704 implements Callable<ImmutableList<User>> {
        final /* synthetic */ FriendsNearbyInviteMultipickerFragment f20929a;

        public C29704(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment) {
            this.f20929a = friendsNearbyInviteMultipickerFragment;
        }

        public Object call() {
            return FriendsNearbyInviteMultipickerFragment.m21887a(this.f20929a, this.f20929a.aq);
        }
    }

    /* compiled from: Weinre Server */
    public enum Task {
        SEND_INVITE
    }

    public static void m21891a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendsNearbyInviteMultipickerFragment) obj).m21890a(TasksManager.b(fbInjector), Toaster.b(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), new FriendsNearbyInviteAdapterViewFactory(), GraphQLQueryExecutor.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), FriendsNearbyInviteAnalyticsLogger.m21882a(fbInjector));
    }

    @Inject
    private void m21890a(TasksManager tasksManager, Toaster toaster, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FriendsNearbyInviteAdapterViewFactory friendsNearbyInviteAdapterViewFactory, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, FriendsNearbyInviteAnalyticsLogger friendsNearbyInviteAnalyticsLogger) {
        this.aw = tasksManager;
        this.ax = toaster;
        this.ay = defaultBlueServiceOperationFactory;
        this.aA = friendsNearbyInviteAdapterViewFactory;
        this.aB = graphQLQueryExecutor;
        this.aC = executorService;
        this.az = friendsNearbyInviteAnalyticsLogger;
    }

    public final void m21895c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendsNearbyInviteMultipickerFragment.class;
        m21891a((Object) this, getContext());
    }

    public final void m21892G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1116406762);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131242027);
            TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.a();
            a2.g = b(2131242025);
            hasTitleBar.a(a2.a());
            hasTitleBar.a(new C29671(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1589403194, a);
    }

    protected final boolean m21893a(String str) {
        return !this.aD.contains(str);
    }

    protected final ViewFactory ar() {
        return this.aA;
    }

    protected final boolean at() {
        return true;
    }

    protected final void aH() {
        aR(this);
    }

    public static void aR(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment) {
        if (friendsNearbyInviteMultipickerFragment.ax().isEmpty()) {
            friendsNearbyInviteMultipickerFragment.ax.b(new ToastBuilder(2131242028));
            return;
        }
        Parcelable friendsNearbyInviteParams = new FriendsNearbyInviteParams(friendsNearbyInviteMultipickerFragment.ax());
        final DialogFragment a = ProgressDialogFragment.a(2131230739, true, false, true);
        a.a(friendsNearbyInviteMultipickerFragment.kO_(), "friends_nearby_invite_send");
        Bundle bundle = new Bundle();
        bundle.putParcelable("friendsNearbyInviteParams", friendsNearbyInviteParams);
        friendsNearbyInviteMultipickerFragment.aw.a(Task.SEND_INVITE, BlueServiceOperationFactoryDetour.a(friendsNearbyInviteMultipickerFragment.ay, "send_invite", bundle, -1465892667).a(), new AbstractDisposableFutureCallback<OperationResult>(friendsNearbyInviteMultipickerFragment) {
            final /* synthetic */ FriendsNearbyInviteMultipickerFragment f20927b;

            protected final void m21885a(Object obj) {
                a.a();
                Toast.makeText(this.f20927b.getContext(), 2131242012, 0).show();
                FinishHandler finishHandler = (FinishHandler) this.f20927b.a(FinishHandler.class);
                if (finishHandler != null) {
                    finishHandler.b();
                }
            }

            protected final void m21886a(Throwable th) {
                a.a();
                this.f20927b.ax.b(new ToastBuilder(2131230758));
                BLog.a(FriendsNearbyInviteMultipickerFragment.av, "fail to send invite.", th);
            }
        });
        FriendsNearbyInviteAnalyticsLogger friendsNearbyInviteAnalyticsLogger = friendsNearbyInviteMultipickerFragment.az;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("friends_nearby_invite_send");
        honeyClientEvent.c = "background_location";
        friendsNearbyInviteAnalyticsLogger.f20924a.a(honeyClientEvent);
    }

    protected final int m21894b(String str) {
        if (au.equals(str)) {
            return 2131242029;
        }
        return super.b(str);
    }

    protected final ImmutableList<String> aD() {
        return ImmutableList.of(au, GenericFriendsSelectorFragment.a);
    }

    protected final ListenableFuture<ImmutableMap<String, ImmutableList<User>>> ay() {
        ListenableFuture ay = super.ay();
        ListenableFuture a = this.c.a(new C29704(this));
        ListenableFuture a2 = this.aB.a(GraphQLRequest.a(new FriendsNearbyInviteStatusQueryString()).a(GraphQLCachePolicy.c));
        return Futures.a(Futures.a(new ListenableFuture[]{ay, a, a2}), new C29693(this), this.aC);
    }

    public static void m21889a(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment, GraphQLResult graphQLResult) {
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        ImmutableSet.Builder builder2 = new ImmutableSet.Builder();
        ImmutableList a = ((FriendsNearbyInviteStatusQueryModel) graphQLResult.e).m21247a().m21243a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FriendsNearbyInviteFriendModel friendsNearbyInviteFriendModel = (FriendsNearbyInviteFriendModel) a.get(i);
            if (!(friendsNearbyInviteFriendModel.m21238k() == null || friendsNearbyInviteFriendModel.m21238k().m21230a().isEmpty())) {
                NodesModel nodesModel = (NodesModel) friendsNearbyInviteFriendModel.m21238k().m21230a().get(0);
                if (!(nodesModel == null || nodesModel.m21225a() == null || nodesModel.m21225a().name() == null)) {
                    String name = nodesModel.m21225a().name();
                    if ("REQUESTABLE".equals(name)) {
                        builder.c(friendsNearbyInviteFriendModel.m21237j());
                    } else if ("REQUESTED".equals(name)) {
                        builder.c(friendsNearbyInviteFriendModel.m21237j());
                        builder2.c(friendsNearbyInviteFriendModel.m21237j());
                    }
                }
            }
        }
        friendsNearbyInviteMultipickerFragment.aE = builder.b();
        friendsNearbyInviteMultipickerFragment.aD = builder2.b();
    }

    static /* synthetic */ ImmutableMap m21888a(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment, ImmutableMap immutableMap, ImmutableSet immutableSet) {
        ImmutableMap immutableMap2;
        if (immutableMap == null) {
            immutableMap2 = RegularImmutableBiMap.a;
        } else {
            Builder builder = new Builder();
            Iterator it = immutableMap.keySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ImmutableList immutableList = (ImmutableList) immutableMap.get(str);
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    User user = (User) immutableList.get(i);
                    if (immutableSet.contains(user.a)) {
                        builder2.c(user);
                    }
                }
                immutableList = builder2.b();
                if (!immutableList.isEmpty()) {
                    builder.b(str, immutableList);
                }
            }
            immutableMap2 = builder.b();
        }
        return immutableMap2;
    }

    public static ImmutableList m21887a(FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment, ImmutableSet immutableSet) {
        UserIterator a = friendsNearbyInviteMultipickerFragment.e.a(ContactCursorsQuery.a().d(ContactLinkType.FRIENDS).a(SortKey.COMMUNICATION_RANK).f(true));
        ImmutableList.Builder builder = ImmutableList.builder();
        while (a.hasNext()) {
            try {
                User user = (User) a.next();
                if (!immutableSet.contains(user.d())) {
                    builder.c(user);
                }
            } finally {
                a.close();
            }
        }
        ImmutableList b = builder.b();
        return b;
    }

    public final String am_() {
        return "friends_nearby_invite";
    }
}
