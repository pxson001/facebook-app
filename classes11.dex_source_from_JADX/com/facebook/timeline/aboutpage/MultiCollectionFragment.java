package com.facebook.timeline.aboutpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.graphql.connection.ConnectionTailLoaderManager;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.Callbacks;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.ConnectionTailLoaderManagerProvider;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsPerformanceLogger.CollectionsFragmentType;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO */
public abstract class MultiCollectionFragment<T> extends BaseFeedFragment implements AnalyticsFragmentWithExtraData {
    @Inject
    @LoggedInUserId
    String f13039a;
    @Inject
    public CollectionsQueryExecutor al;
    @Inject
    public TasksManager am;
    public Adapter an;
    @Inject
    public CollectionsPerformanceLogger ao;
    @Inject
    CollectionsQeHelper ap;
    @Inject
    FbNetworkManager aq;
    @Inject
    ConnectionTailLoaderManagerProvider ar;
    @Inject
    LocalModelCursorLoaderManagerProvider as;
    public GenericNotificationBanner at;
    public View au;
    public boolean av = false;
    public boolean aw = false;
    public FeedNetworkConnectivityReceiver ax;
    public ConnectionTailLoaderManager ay;
    private LocalModelCursorLoaderManager az;
    public View f13040b;
    public Bundle f13041c;
    protected RefreshableViewContainerLike f13042d;
    protected ScrollingViewProxy f13043e;
    @Inject
    public AbstractFbErrorReporter f13044f;
    @Inject
    FbSharedPreferences f13045g;
    public ProfileViewerContext f13046h;
    protected MutualFriendsInfo f13047i;

    /* compiled from: NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO */
    class C15451 implements Callbacks {
        final /* synthetic */ MultiCollectionFragment f13031a;
        private boolean f13032b = true;

        C15451(MultiCollectionFragment multiCollectionFragment) {
            this.f13031a = multiCollectionFragment;
        }

        public final void m13798a(ModelCursor modelCursor) {
            CursorAdapter aw = this.f13031a.aw();
            if (aw != null) {
                aw.a(modelCursor);
                if (modelCursor != null && modelCursor.getCount() > 0) {
                    Object obj;
                    if (this.f13031a.f13042d != null) {
                        this.f13031a.f13042d.f();
                    }
                    if (this.f13032b) {
                        this.f13032b = false;
                        this.f13031a.ao.m13760c();
                        MultiCollectionFragment.aI(this.f13031a);
                    } else {
                        this.f13031a.aH();
                    }
                    ConnectionTailLoaderManager connectionTailLoaderManager = this.f13031a.ay;
                    if (connectionTailLoaderManager.m == null || connectionTailLoaderManager.m.c) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        this.f13031a.ao.m13761c(this.f13031a.aA());
                    }
                }
            }
        }

        public final void m13799a(Throwable th) {
            if (this.f13032b) {
                this.f13031a.m13816a(th);
            }
        }

        public final void m13800a(boolean z) {
            CursorAdapter aw = this.f13031a.aw();
            if (aw != null && aw.a() != null) {
                ((Adapter) aw).mo405a(z);
            }
        }
    }

    /* compiled from: NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO */
    class C15462 extends OnRefreshListener {
        final /* synthetic */ MultiCollectionFragment f13033a;

        C15462(MultiCollectionFragment multiCollectionFragment) {
            this.f13033a = multiCollectionFragment;
        }

        public final void m13801b(boolean z) {
            if (z) {
                this.f13033a.m13819e();
            }
        }
    }

    /* compiled from: NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO */
    public class C15473 implements OnClickListener {
        final /* synthetic */ MultiCollectionFragment f13034a;

        public C15473(MultiCollectionFragment multiCollectionFragment) {
            this.f13034a = multiCollectionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1065313892);
            this.f13034a.au.setVisibility(8);
            this.f13034a.m13819e();
            Logger.a(2, EntryType.UI_INPUT_END, -2061159063, a);
        }
    }

    /* compiled from: NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO */
    class C15506 extends AbstractDisposableFutureCallback<T> {
        final /* synthetic */ MultiCollectionFragment f13038a;

        C15506(MultiCollectionFragment multiCollectionFragment) {
            this.f13038a = multiCollectionFragment;
        }

        protected final void m13803a(T t) {
            this.f13038a.mo419b((Object) t);
        }

        protected final void m13804a(Throwable th) {
            this.f13038a.m13816a(th);
        }
    }

    /* compiled from: NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO */
    public interface Adapter extends ListAdapter {
        void mo405a(boolean z);

        void notifyDataSetChanged();
    }

    public static void m13806a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MultiCollectionFragment) obj).m13807a(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), CollectionsQueryExecutor.m13769a(injectorLike), TasksManager.b(injectorLike), CollectionsPerformanceLogger.m13751a(injectorLike), CollectionsQeHelper.m13763b(injectorLike), FbNetworkManager.a(injectorLike), (ConnectionTailLoaderManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionTailLoaderManagerProvider.class), (LocalModelCursorLoaderManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LocalModelCursorLoaderManagerProvider.class));
    }

    protected abstract ListenableFuture<T> mo409a(boolean z);

    protected abstract void mo410a(T t);

    protected abstract CollectionsFragmentType aA();

    protected abstract CollectionsAnalyticsLogger aG();

    protected abstract String at();

    protected abstract BatchConfiguration au();

    protected abstract RowIterator av();

    protected abstract CursorAdapter aw();

    public abstract Adapter ay();

    protected abstract T az();

    public void mo420c(Bundle bundle) {
        GraphQLSubscribeStatus fromString;
        boolean z = true;
        super.c(bundle);
        Class cls = MultiCollectionFragment.class;
        m13806a(this, getContext());
        this.ao.m13756a(aA());
        if (this.f13039a == null) {
            this.f13044f.a("timeline_invalid_meuser", "logged in user: " + this.f13039a);
        }
        Bundle bundle2 = this.s;
        String str = this.f13039a;
        GraphQLFriendshipStatus graphQLFriendshipStatus = null;
        this.f13041c = bundle2;
        Object string = this.f13041c.getString("profile_id");
        if (StringUtil.a(string)) {
            string = str;
        }
        Preconditions.checkArgument(!StringUtil.a(string));
        if (this.f13041c != null) {
            graphQLFriendshipStatus = GraphQLFriendshipStatus.fromString(this.f13041c.getString("friendship_status"));
            fromString = GraphQLSubscribeStatus.fromString(this.f13041c.getString("subscribe_status"));
        } else {
            fromString = null;
        }
        this.f13046h = new ProfileViewerContext(string, str, graphQLFriendshipStatus, fromString);
        this.f13047i = new MutualFriendsInfo();
        this.an = ay();
        Preconditions.checkNotNull(this.an);
        if (!aB()) {
            this.an.mo405a(true);
        }
        Object az = az();
        if (!(az == null || aB())) {
            mo410a(az);
            this.an.notifyDataSetChanged();
        }
        CollectionsPerformanceLogger collectionsPerformanceLogger = this.ao;
        CollectionsFragmentType aA = aA();
        if (az == null) {
            z = false;
        }
        collectionsPerformanceLogger.m13757a(aA, z);
        if (aB()) {
            this.ay = this.ar.a(at(), au(), new C15451(this), av());
            this.az = this.as.a(at(), this.ay);
            this.az.a();
        }
        m13809b(false);
    }

    protected final boolean ax() {
        if (this.ay != null) {
            return this.ay.b();
        }
        return false;
    }

    protected final boolean aB() {
        return this.ap.m13764a();
    }

    protected void aH() {
    }

    public void mo421I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -511891048);
        if (this.am != null) {
            this.am.c();
            this.am = null;
        }
        if (this.az != null) {
            this.az.close();
            this.az = null;
        }
        this.f13044f = null;
        this.f13045g = null;
        this.an = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 695764756, a);
    }

    public void mo406G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 343041870);
        if (this.ax != null) {
            this.ax.a();
        }
        super.G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1083295303, a);
    }

    public void mo407H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1947004237);
        this.ao.m13759b(aA());
        if (this.ax != null) {
            this.ax.b();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1761099754, a);
    }

    public View mo408a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 147240645);
        this.f13040b = layoutInflater.inflate(2130903605, viewGroup, false);
        this.f13042d = (RefreshableViewContainerLike) this.f13040b.findViewById(2131560405);
        this.f13042d.setOnRefreshListener(new C15462(this));
        this.f13043e = new ListViewProxy((BetterListView) this.f13042d.c().findViewById(16908298));
        this.f13043e.f(this.f13040b.findViewById(16908292));
        this.f13043e.d(true);
        View b = m13808b(getContext());
        View b2 = m13808b(getContext());
        this.f13043e.a(b, null, false);
        this.f13043e.b(b2, null, false);
        this.au = this.f13040b.findViewById(2131560227);
        this.au.findViewById(2131561897).setOnClickListener(new C15473(this));
        this.at = (GenericNotificationBanner) this.f13040b.findViewById(2131560231);
        this.ax = new FeedNetworkConnectivityReceiver(this, getContext()) {
            final /* synthetic */ MultiCollectionFragment f13035a;

            public final void m13802a(Context context, Intent intent) {
                if (this == this.f13035a.ax && this.f13035a.an != null) {
                    boolean d = this.f13035a.aq.d();
                    if (!(this.f13035a.au == null || this.f13035a.au.getVisibility() == 0 || this.f13035a.at == null)) {
                        if (d) {
                            this.f13035a.at.a();
                        } else {
                            this.f13035a.at.a(NotificationBannerType.NO_CONNECTION);
                        }
                    }
                    if (d && this.f13035a.av && !this.f13035a.aw) {
                        this.f13035a.av = false;
                        this.f13035a.aw = true;
                        this.f13035a.m13819e();
                    }
                }
            }
        };
        b = this.f13040b;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1838196713, a);
        return b;
    }

    private void m13807a(String str, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, CollectionsQueryExecutor collectionsQueryExecutor, TasksManager tasksManager, CollectionsPerformanceLogger collectionsPerformanceLogger, CollectionsQeHelper collectionsQeHelper, FbNetworkManager fbNetworkManager, ConnectionTailLoaderManagerProvider connectionTailLoaderManagerProvider, LocalModelCursorLoaderManagerProvider localModelCursorLoaderManagerProvider) {
        this.f13039a = str;
        this.f13044f = abstractFbErrorReporter;
        this.f13045g = fbSharedPreferences;
        this.al = collectionsQueryExecutor;
        this.am = tasksManager;
        this.ao = collectionsPerformanceLogger;
        this.ap = collectionsQeHelper;
        this.aq = fbNetworkManager;
        this.ar = connectionTailLoaderManagerProvider;
        this.as = localModelCursorLoaderManagerProvider;
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1346834758);
        super.mY_();
        if (this.f13042d != null) {
            this.f13042d.setOnRefreshListener(null);
        }
        if (this.f13043e != null) {
            this.f13043e.a(null);
        }
        this.ao.m13759b(aA());
        this.f13040b = null;
        this.f13042d = null;
        this.f13043e = null;
        this.at = null;
        this.au = null;
        this.ax = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 403161354, a);
    }

    public final void m13819e() {
        if (this.ay != null) {
            this.ay.a();
        }
        m13809b(true);
    }

    private void m13809b(final boolean z) {
        if (!aB()) {
            this.am.a("initial fetch", new Callable<ListenableFuture<T>>(this) {
                final /* synthetic */ MultiCollectionFragment f13037b;

                public Object call() {
                    return this.f13037b.mo409a(z);
                }
            }, new C15506(this));
        }
    }

    protected void mo419b(T t) {
        if (this.an != null && this.f13046h != null) {
            mo410a((Object) t);
            aI(this);
        }
    }

    public static void aI(MultiCollectionFragment multiCollectionFragment) {
        if (!multiCollectionFragment.aG().f12998b) {
            multiCollectionFragment.aG().m13740a(multiCollectionFragment.f13046h.a, CollectionsAnalyticsLogger.m13739a(multiCollectionFragment.f13046h));
        }
        if (multiCollectionFragment.at != null && multiCollectionFragment.aq != null) {
            if (multiCollectionFragment.aq.d()) {
                multiCollectionFragment.av = false;
                multiCollectionFragment.at.a();
                return;
            }
            multiCollectionFragment.at.a(NotificationBannerType.NO_CONNECTION);
        }
    }

    public final void m13816a(Throwable th) {
        if (this.an != null && !(th instanceof CancellationException)) {
            this.av = true;
            if (this.au != null && this.at != null && this.f13042d != null) {
                if (this.an.getCount() == 0) {
                    ((TextView) this.au.findViewById(2131561899)).setText(2131230758);
                    this.au.setVisibility(0);
                } else {
                    this.at.a(this.aq.d() ? NotificationBannerType.FETCH_TIMELINE_FAILED : NotificationBannerType.NO_CONNECTION);
                }
                if (this.f13042d != null) {
                    this.f13042d.f();
                }
            }
        }
    }

    private static View m13808b(Context context) {
        return CollectionsViewFactory.m14937a(context, context.getResources().getDimensionPixelSize(2131434518));
    }
}
