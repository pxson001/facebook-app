package com.facebook.groups.groupsections.noncursored;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.BookmarkAddToFavoritesInputData;
import com.facebook.graphql.calls.BookmarkAddToFavoritesInputData.Source;
import com.facebook.graphql.calls.BookmarkRemoveFromFavoritesInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ViewerUpdateGroupOrderingInputData;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupGridFragment.C11959.C11941;
import com.facebook.groups.groupsections.Enums.FilteredGroupsSectionOrdering;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager.SectionRequeryListener;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager.SectionTailLoadListener;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSectionModels.FetchGroupSectionModel;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSectionModels.FetchGroupSectionModel.ActorModel.GroupsModel;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSectionModels.FetchGroupSectionModel.ActorModel.GroupsModel.NodesModel;
import com.facebook.groups.groupsections.noncursored.sections.FavoritesSection;
import com.facebook.groups.groupsections.noncursored.sections.HiddenGroupsSection;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutations.GroupsBookmarkAddToFavoritesMutationString;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutations.GroupsBookmarkRemoveFromFavoritesMutationString;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutationsModels.GroupsBookmarkAddToFavoritesMutationModel;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutationsModels.GroupsBookmarkRemoveFromFavoritesMutationModel;
import com.facebook.groups.groupsgrid.mutations.GroupHiddenStatusUpdater;
import com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper;
import com.facebook.groups.groupsgrid.mutations.GroupsFavoriteUpdater;
import com.facebook.groups.groupsgrid.mutations.GroupsOrderUpdateMutation.GroupCacheUpdateOrderMutationString;
import com.facebook.groups.groupsgrid.mutations.GroupsOrderUpdater;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutationsModels.GroupHideMutationModel;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutationsModels.GroupUnhideMutationModel;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.groups.settings.AbstractGroupSubscriptionController;
import com.facebook.groups.settings.GroupSubscriptionController;
import com.facebook.groups.settings.GroupSubscriptionController.GroupSubscriptionChangeListener;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: [\s'";] */
public class SectionGraphQLQueryManager implements SectionedGroupsQueryManager {
    public static final String f10269a = SectionGraphQLQueryManager.class.getName();
    public final Toaster f10270b;
    private final Clock f10271c;
    public SectionRequeryListener f10272d;
    public int f10273e;
    private ImmutableList<GroupSections> f10274f;
    public HashMap<GroupSections, GroupsSectionInterface> f10275g = new HashMap();
    private FavoritesSection f10276h;
    public SortSection f10277i;
    private HiddenGroupsSection f10278j;
    private RecentlyJoinedSection f10279k;
    public GraphQLQueryExecutor f10280l;
    public TasksManager f10281m;
    public GroupsClient f10282n;
    private Lazy<GroupsFavoriteUpdater> f10283o;
    private Lazy<GroupsOrderUpdater> f10284p;
    private Lazy<GroupSubscriptionController> f10285q;
    public Lazy<GroupHiddenStatusUpdater> f10286r;

    /* compiled from: [\s'";] */
    public class AnonymousClass11 extends AbstractDisposableFutureCallback {
        final /* synthetic */ C11941 f10239a;
        final /* synthetic */ String f10240b;
        final /* synthetic */ SectionGraphQLQueryManager f10241c;

        public AnonymousClass11(SectionGraphQLQueryManager sectionGraphQLQueryManager, C11941 c11941, String str) {
            this.f10241c = sectionGraphQLQueryManager;
            this.f10239a = c11941;
            this.f10240b = str;
        }

        protected final void m10628a(Object obj) {
            C11941 c11941 = this.f10239a;
            GroupLeaveDialogHelper groupLeaveDialogHelper = c11941.f10167b.f10171d.as;
            GroupLeaveDialogHelper.a(c11941.f10166a);
            SectionGraphQLQueryManager sectionGraphQLQueryManager = this.f10241c;
            HashMap hashMap = this.f10241c.f10275g;
            GroupPogGridData b = GroupSectionsOptimisiticMutationsHelper.m10619b(hashMap, this.f10240b);
            if (b != null) {
                GroupSections a = GroupSectionsOptimisiticMutationsHelper.m10617a(b);
                if (a != null) {
                    AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) hashMap.get(a);
                    if (abstractGraphQLBackedSection != null && (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection)) {
                        abstractGraphQLBackedSection.m10606a(b);
                    }
                }
            }
            sectionGraphQLQueryManager.f10275g = hashMap;
            SectionGraphQLQueryManager.m10651g(this.f10241c);
        }

        protected final void m10629a(Throwable th) {
            C11941 c11941 = this.f10239a;
            GroupLeaveDialogHelper groupLeaveDialogHelper = c11941.f10167b.f10171d.as;
            GroupLeaveDialogHelper.a(c11941.f10166a);
            c11941.f10167b.f10171d.as.a(c11941.f10167b.f10169b).a().show();
        }
    }

    /* compiled from: [\s'";] */
    class C11991 implements Callable<ListenableFuture<List<GraphQLResult<FetchGroupSectionModel>>>> {
        final /* synthetic */ SectionGraphQLQueryManager f10243a;

        C11991(SectionGraphQLQueryManager sectionGraphQLQueryManager) {
            this.f10243a = sectionGraphQLQueryManager;
        }

        public Object call() {
            GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("GroupsSection");
            Builder builder = ImmutableList.builder();
            for (AbstractGraphQLBackedSection abstractGraphQLBackedSection : this.f10243a.f10275g.values()) {
                if (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection) {
                    GraphQLRequest a = GraphQLRequest.a(abstractGraphQLBackedSection.mo285b(this.f10243a.f10273e)).a(GraphQLCachePolicy.d);
                    a.b = true;
                    builder.c(graphQLBatchRequest.b(a.a(1800)));
                }
            }
            this.f10243a.f10280l.a(graphQLBatchRequest);
            return Futures.a(builder.b());
        }
    }

    /* compiled from: [\s'";] */
    class C12002 extends AbstractDisposableFutureCallback<List<GraphQLResult<FetchGroupSectionModel>>> {
        final /* synthetic */ SectionGraphQLQueryManager f10244a;

        C12002(SectionGraphQLQueryManager sectionGraphQLQueryManager) {
            this.f10244a = sectionGraphQLQueryManager;
        }

        protected final void m10630a(Object obj) {
            List list = (List) obj;
            int i = 0;
            Preconditions.checkArgument(list.size() == this.f10244a.f10275g.size());
            for (AbstractGraphQLBackedSection abstractGraphQLBackedSection : this.f10244a.f10275g.values()) {
                if (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection) {
                    int i2 = i + 1;
                    SectionGraphQLQueryManager.m10647b(abstractGraphQLBackedSection, (GraphQLResult) list.get(i));
                    i = i2;
                }
            }
            SectionGraphQLQueryManager.m10651g(this.f10244a);
        }

        protected final void m10631a(Throwable th) {
            this.f10244a.f10272d.mo257a();
        }
    }

    /* compiled from: [\s'";] */
    class C12013 extends AbstractDisposableFutureCallback<GraphQLResult<FetchGroupSectionModel>> {
        final /* synthetic */ SectionGraphQLQueryManager f10245a;

        C12013(SectionGraphQLQueryManager sectionGraphQLQueryManager) {
            this.f10245a = sectionGraphQLQueryManager;
        }

        protected final void m10632a(Object obj) {
            if (SectionGraphQLQueryManager.m10647b(this.f10245a.f10277i, (GraphQLResult) obj)) {
                this.f10245a.f10275g.put(this.f10245a.f10277i.mo287i(), this.f10245a.f10277i);
                SectionGraphQLQueryManager.m10651g(this.f10245a);
            }
        }

        protected final void m10633a(Throwable th) {
            BLog.b(SectionGraphQLQueryManager.f10269a, "Failed to load groups for sort section on reorder");
        }
    }

    /* compiled from: [\s'";] */
    public class C12046 extends AbstractDisposableFutureCallback<GraphQLResult<GroupHideMutationModel>> {
        final /* synthetic */ String f10254a;
        final /* synthetic */ boolean f10255b;
        final /* synthetic */ boolean f10256c;
        final /* synthetic */ SectionGraphQLQueryManager f10257d;

        public C12046(SectionGraphQLQueryManager sectionGraphQLQueryManager, String str, boolean z, boolean z2) {
            this.f10257d = sectionGraphQLQueryManager;
            this.f10254a = str;
            this.f10255b = z;
            this.f10256c = z2;
        }

        protected final void m10639a(Throwable th) {
            boolean z;
            this.f10257d.f10270b.b(new ToastBuilder(2131237824));
            SectionGraphQLQueryManager sectionGraphQLQueryManager = this.f10257d;
            HashMap hashMap = this.f10257d.f10275g;
            String str = this.f10254a;
            boolean z2 = this.f10255b;
            if (this.f10256c) {
                z = false;
            } else {
                z = true;
            }
            sectionGraphQLQueryManager.f10275g = GroupSectionsOptimisiticMutationsHelper.m10618a(hashMap, str, z2, z);
            SectionGraphQLQueryManager.m10651g(this.f10257d);
        }
    }

    /* compiled from: [\s'";] */
    public class C12057 extends AbstractDisposableFutureCallback<GraphQLResult<GroupUnhideMutationModel>> {
        final /* synthetic */ String f10258a;
        final /* synthetic */ boolean f10259b;
        final /* synthetic */ boolean f10260c;
        final /* synthetic */ SectionGraphQLQueryManager f10261d;

        public C12057(SectionGraphQLQueryManager sectionGraphQLQueryManager, String str, boolean z, boolean z2) {
            this.f10261d = sectionGraphQLQueryManager;
            this.f10258a = str;
            this.f10259b = z;
            this.f10260c = z2;
        }

        protected final void m10641a(Throwable th) {
            boolean z;
            this.f10261d.f10270b.b(new ToastBuilder(2131237824));
            SectionGraphQLQueryManager sectionGraphQLQueryManager = this.f10261d;
            HashMap hashMap = this.f10261d.f10275g;
            String str = this.f10258a;
            boolean z2 = this.f10259b;
            if (this.f10260c) {
                z = false;
            } else {
                z = true;
            }
            sectionGraphQLQueryManager.f10275g = GroupSectionsOptimisiticMutationsHelper.m10618a(hashMap, str, z2, z);
            SectionGraphQLQueryManager.m10651g(this.f10261d);
        }
    }

    /* compiled from: [\s'";] */
    public enum GraphQLTasks {
        INITIAL_FETCH_TASK,
        EDIT_FAVORITES,
        EDIT_HIDDEN,
        LEAVE_GROUP
    }

    public static SectionGraphQLQueryManager m10646b(InjectorLike injectorLike) {
        return new SectionGraphQLQueryManager(FavoritesSection.m10731b(injectorLike), SortSection.m10665b(injectorLike), HiddenGroupsSection.m10736b(injectorLike), RecentlyJoinedSection.m10620b(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), GroupsClient.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7024), IdBasedLazy.a(injectorLike, 7025), IdBasedLazy.a(injectorLike, 7096), IdBasedSingletonScopeProvider.b(injectorLike, 7022));
    }

    @Inject
    public SectionGraphQLQueryManager(FavoritesSection favoritesSection, SortSection sortSection, HiddenGroupsSection hiddenGroupsSection, RecentlyJoinedSection recentlyJoinedSection, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Toaster toaster, Clock clock, GroupsClient groupsClient, Lazy<GroupsFavoriteUpdater> lazy, Lazy<GroupsOrderUpdater> lazy2, Lazy<GroupSubscriptionController> lazy3, Lazy<GroupHiddenStatusUpdater> lazy4) {
        this.f10276h = favoritesSection;
        this.f10277i = sortSection;
        this.f10278j = hiddenGroupsSection;
        this.f10279k = recentlyJoinedSection;
        this.f10280l = graphQLQueryExecutor;
        this.f10281m = tasksManager;
        this.f10270b = toaster;
        this.f10271c = clock;
        this.f10283o = lazy;
        this.f10284p = lazy2;
        this.f10285q = lazy3;
        this.f10286r = lazy4;
        this.f10282n = groupsClient;
    }

    public final void mo282a(ImmutableList<GroupSections> immutableList) {
        this.f10274f = immutableList;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            switch ((GroupSections) immutableList.get(i)) {
                case FILTERED_GROUPS_SECTION:
                    this.f10275g.put(GroupSections.FILTERED_GROUPS_SECTION, this.f10277i);
                    break;
                case RECENTLY_JOINED_SECTION:
                    this.f10275g.put(GroupSections.RECENTLY_JOINED_SECTION, this.f10279k);
                    break;
                case FAVORITES_SECTION:
                    this.f10275g.put(GroupSections.FAVORITES_SECTION, this.f10276h);
                    break;
                case HIDDEN_GROUPS_SECTION:
                    this.f10278j.f10219c = true;
                    this.f10275g.put(GroupSections.HIDDEN_GROUPS_SECTION, this.f10278j);
                    break;
                default:
                    break;
            }
        }
    }

    public final void mo276a() {
        this.f10281m.c();
        for (AbstractGraphQLBackedSection abstractGraphQLBackedSection : this.f10275g.values()) {
            if (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection) {
                abstractGraphQLBackedSection.m10616j();
            }
        }
    }

    public final void mo280a(FilteredGroupsSectionOrdering filteredGroupsSectionOrdering, int i, SectionRequeryListener sectionRequeryListener) {
        this.f10272d = sectionRequeryListener;
        this.f10273e = i;
        this.f10277i.f10294e = filteredGroupsSectionOrdering;
        m10648d();
    }

    private void m10648d() {
        this.f10281m.a(GraphQLTasks.INITIAL_FETCH_TASK, new C11991(this), new C12002(this));
    }

    public final void mo279a(FilteredGroupsSectionOrdering filteredGroupsSectionOrdering) {
        this.f10277i.m10616j();
        m10651g(this);
        this.f10277i.f10294e = filteredGroupsSectionOrdering;
        TasksManager tasksManager = this.f10281m;
        String name = this.f10277i.mo287i().name();
        GraphQLQueryExecutor graphQLQueryExecutor = this.f10280l;
        GraphQLRequest a = GraphQLRequest.a(this.f10277i.mo285b(this.f10273e)).a(GraphQLCachePolicy.d);
        a.b = true;
        tasksManager.a(name, graphQLQueryExecutor.a(a.a(1800)), new C12013(this));
    }

    public final void mo281a(GroupSections groupSections, boolean z) {
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10275g.get(groupSections);
        if (abstractGraphQLBackedSection != null && (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection)) {
            abstractGraphQLBackedSection = abstractGraphQLBackedSection;
            if (abstractGraphQLBackedSection.f10219c != z) {
                abstractGraphQLBackedSection.f10219c = z;
                m10651g(this);
            }
        }
    }

    public final void mo278a(int i, SectionTailLoadListener sectionTailLoadListener) {
        if (m10650f()) {
            int e = m10649e() + i;
            int size = this.f10274f.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10275g.get((GroupSections) this.f10274f.get(i2));
                if (abstractGraphQLBackedSection != null && (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection)) {
                    abstractGraphQLBackedSection = abstractGraphQLBackedSection;
                    if (abstractGraphQLBackedSection.m10612d() && !abstractGraphQLBackedSection.f10219c) {
                        m10645a(abstractGraphQLBackedSection, e - m10649e(), sectionTailLoadListener);
                        return;
                    }
                }
            }
        }
    }

    private void m10644a(String str, @Nullable Integer num) {
        if (this.f10276h != null && this.f10276h.m10614f()) {
            this.f10276h.m10608a(str, num);
            m10651g(this);
            AbstractGraphQLBackedSection abstractGraphQLBackedSection = this.f10276h;
            ArrayList arrayList = new ArrayList(abstractGraphQLBackedSection.f10218b.size());
            for (int i = 0; i < abstractGraphQLBackedSection.f10218b.size(); i++) {
                arrayList.add(i, ((GroupPogGridData) abstractGraphQLBackedSection.f10218b.get(i)).f10223a);
            }
            ArrayList arrayList2 = arrayList;
            GroupsOrderUpdater groupsOrderUpdater = (GroupsOrderUpdater) this.f10284p.get();
            ViewerUpdateGroupOrderingInputData viewerUpdateGroupOrderingInputData = new ViewerUpdateGroupOrderingInputData();
            viewerUpdateGroupOrderingInputData.a("actor_id", groupsOrderUpdater.b);
            GraphQlCallInput graphQlCallInput = viewerUpdateGroupOrderingInputData;
            graphQlCallInput.a("group_ids", arrayList2);
            groupsOrderUpdater.a.a(GraphQLRequest.a((GroupCacheUpdateOrderMutationString) new GroupCacheUpdateOrderMutationString().a("input", graphQlCallInput)));
        }
    }

    public final void mo277a(int i, int i2) {
        if (this.f10276h.m10614f() && !this.f10276h.m10613e()) {
            GroupPogGridData a = this.f10276h.m10604a(i);
            if (a == null) {
                BLog.b(f10269a, "Unable to find group model to reorder, favorite group does not exist.");
            } else {
                m10644a(a.f10223a, Integer.valueOf(i2));
            }
        }
    }

    public final void mo283a(final String str, final boolean z, final boolean z2) {
        this.f10275g = GroupSectionsOptimisiticMutationsHelper.m10618a(this.f10275g, str, z, z ? false : z2);
        String str2 = GraphQLTasks.EDIT_FAVORITES + str;
        if (z) {
            m10644a(str, null);
            TasksManager tasksManager = this.f10281m;
            GroupsFavoriteUpdater groupsFavoriteUpdater = (GroupsFavoriteUpdater) this.f10283o.get();
            BookmarkAddToFavoritesInputData bookmarkAddToFavoritesInputData = new BookmarkAddToFavoritesInputData();
            bookmarkAddToFavoritesInputData.a(Source.TREEHOUSE_ANDROID_GROUPS_TAB).a((String) groupsFavoriteUpdater.a.get()).b(str);
            GraphQlQueryString groupsBookmarkAddToFavoritesMutationString = new GroupsBookmarkAddToFavoritesMutationString();
            groupsBookmarkAddToFavoritesMutationString.a("input", bookmarkAddToFavoritesInputData);
            tasksManager.a(str2, groupsFavoriteUpdater.b.a(GraphQLRequest.a(groupsBookmarkAddToFavoritesMutationString)), new AbstractDisposableFutureCallback<GraphQLResult<GroupsBookmarkAddToFavoritesMutationModel>>(this) {
                final /* synthetic */ SectionGraphQLQueryManager f10249d;

                protected final void m10635a(Throwable th) {
                    boolean z;
                    this.f10249d.f10270b.b(new ToastBuilder(2131237824));
                    SectionGraphQLQueryManager sectionGraphQLQueryManager = this.f10249d;
                    HashMap hashMap = this.f10249d.f10275g;
                    String str = str;
                    if (z) {
                        z = false;
                    } else {
                        z = true;
                    }
                    sectionGraphQLQueryManager.f10275g = GroupSectionsOptimisiticMutationsHelper.m10618a(hashMap, str, z, z2);
                    SectionGraphQLQueryManager.m10651g(this.f10249d);
                }
            });
            return;
        }
        m10651g(this);
        tasksManager = this.f10281m;
        groupsFavoriteUpdater = (GroupsFavoriteUpdater) this.f10283o.get();
        BookmarkRemoveFromFavoritesInputData bookmarkRemoveFromFavoritesInputData = new BookmarkRemoveFromFavoritesInputData();
        bookmarkRemoveFromFavoritesInputData.a(BookmarkRemoveFromFavoritesInputData.Source.TREEHOUSE_ANDROID_GROUPS_TAB).a((String) groupsFavoriteUpdater.a.get()).b(str);
        groupsBookmarkAddToFavoritesMutationString = new GroupsBookmarkRemoveFromFavoritesMutationString();
        groupsBookmarkAddToFavoritesMutationString.a("input", bookmarkRemoveFromFavoritesInputData);
        tasksManager.a(str2, groupsFavoriteUpdater.b.a(GraphQLRequest.a(groupsBookmarkAddToFavoritesMutationString)), new AbstractDisposableFutureCallback<GraphQLResult<GroupsBookmarkRemoveFromFavoritesMutationModel>>(this) {
            final /* synthetic */ SectionGraphQLQueryManager f10253d;

            protected final void m10637a(Throwable th) {
                boolean z;
                this.f10253d.f10270b.b(new ToastBuilder(2131237824));
                SectionGraphQLQueryManager sectionGraphQLQueryManager = this.f10253d;
                HashMap hashMap = this.f10253d.f10275g;
                String str = str;
                if (z) {
                    z = false;
                } else {
                    z = true;
                }
                sectionGraphQLQueryManager.f10275g = GroupSectionsOptimisiticMutationsHelper.m10618a(hashMap, str, z, z2);
                SectionGraphQLQueryManager.m10651g(this.f10253d);
            }
        });
    }

    public final void m10657a(GroupSections groupSections, SectionTailLoadListener sectionTailLoadListener) {
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) this.f10275g.get(groupSections);
        if (abstractGraphQLBackedSection != null && (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection)) {
            abstractGraphQLBackedSection = abstractGraphQLBackedSection;
            int b = abstractGraphQLBackedSection.m10609b();
            abstractGraphQLBackedSection.m10616j();
            m10651g(this);
            m10645a(abstractGraphQLBackedSection, b, sectionTailLoadListener);
        }
    }

    public final void m10663b() {
        mo276a();
        m10651g(this);
        m10648d();
    }

    private int m10649e() {
        int i = 0;
        for (AbstractGraphQLBackedSection abstractGraphQLBackedSection : this.f10275g.values()) {
            int a;
            if (abstractGraphQLBackedSection.m10614f()) {
                a = abstractGraphQLBackedSection.m10603a() + i;
            } else {
                a = i;
            }
            i = a;
        }
        return i;
    }

    private boolean m10650f() {
        for (AbstractGraphQLBackedSection abstractGraphQLBackedSection : this.f10275g.values()) {
            if ((abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection) && abstractGraphQLBackedSection.m10614f()) {
                return true;
            }
        }
        return false;
    }

    private boolean m10645a(final AbstractGraphQLBackedSection abstractGraphQLBackedSection, final int i, final SectionTailLoadListener sectionTailLoadListener) {
        if (!abstractGraphQLBackedSection.m10612d()) {
            return false;
        }
        this.f10281m.a(abstractGraphQLBackedSection.mo287i().name(), new Callable<ListenableFuture<GraphQLResult<FetchGroupSectionModel>>>(this) {
            final /* synthetic */ SectionGraphQLQueryManager f10265d;

            public Object call() {
                sectionTailLoadListener.mo259a(abstractGraphQLBackedSection.mo287i(), true);
                GraphQLQueryExecutor graphQLQueryExecutor = this.f10265d.f10280l;
                GraphQLRequest a = GraphQLRequest.a(abstractGraphQLBackedSection.mo285b(i)).a(GraphQLCachePolicy.d);
                a.b = true;
                return graphQLQueryExecutor.a(a.a(1800));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchGroupSectionModel>>(this) {
            final /* synthetic */ SectionGraphQLQueryManager f10268c;

            protected final void m10642a(Object obj) {
                if (SectionGraphQLQueryManager.m10647b(abstractGraphQLBackedSection, (GraphQLResult) obj)) {
                    this.f10268c.f10275g.put(abstractGraphQLBackedSection.mo287i(), abstractGraphQLBackedSection);
                    SectionGraphQLQueryManager.m10651g(this.f10268c);
                }
                sectionTailLoadListener.mo259a(abstractGraphQLBackedSection.mo287i(), false);
            }

            protected final void m10643a(Throwable th) {
                BLog.b(SectionGraphQLQueryManager.f10269a, "Failed to load groups for section: ", new Object[]{abstractGraphQLBackedSection.mo287i().name()});
                sectionTailLoadListener.mo259a(abstractGraphQLBackedSection.mo287i(), false);
            }
        });
        return true;
    }

    public static boolean m10647b(AbstractGraphQLBackedSection abstractGraphQLBackedSection, GraphQLResult<FetchGroupSectionModel> graphQLResult) {
        int i = 0;
        if (graphQLResult == null || graphQLResult.e == null) {
            return false;
        }
        if (((FetchGroupSectionModel) graphQLResult.e).m10721a() == null || ((FetchGroupSectionModel) graphQLResult.e).m10721a().m10714a() == null) {
            return false;
        }
        GroupsModel a = ((FetchGroupSectionModel) graphQLResult.e).m10721a().m10714a();
        Builder builder = ImmutableList.builder();
        ImmutableList a2 = a.m10708a();
        int size = a2.size();
        while (i < size) {
            builder.c(new GroupPogGridData((NodesModel) a2.get(i)));
            i++;
        }
        abstractGraphQLBackedSection.m10607a(builder.b(), a.m10709j());
        return true;
    }

    public static void m10651g(SectionGraphQLQueryManager sectionGraphQLQueryManager) {
        sectionGraphQLQueryManager.f10272d.mo258a(sectionGraphQLQueryManager.f10275g, !sectionGraphQLQueryManager.m10650f(), sectionGraphQLQueryManager.m10649e());
    }

    public final void m10661a(String str, com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupGridFragment.AnonymousClass10 anonymousClass10) {
        HashMap hashMap = this.f10275g;
        long a = this.f10271c.a();
        GroupPogGridData b = GroupSectionsOptimisiticMutationsHelper.m10619b(hashMap, str);
        if (b != null) {
            b.f10228f = 0;
            b.f10226d = a;
        }
        this.f10275g = hashMap;
        anonymousClass10.m10491a();
    }

    public final void m10660a(final String str, GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel, final com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupGridFragment.AnonymousClass10 anonymousClass10) {
        ((AbstractGroupSubscriptionController) this.f10285q.get()).h = new GroupSubscriptionChangeListener(this) {
            final /* synthetic */ SectionGraphQLQueryManager f10238c;

            public final void m10627a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
                SectionGraphQLQueryManager sectionGraphQLQueryManager = this.f10238c;
                HashMap hashMap = this.f10238c.f10275g;
                GroupPogGridData b = GroupSectionsOptimisiticMutationsHelper.m10619b(hashMap, str);
                if (b != null) {
                    b.f10233k = graphQLGroupSubscriptionLevel;
                }
                sectionGraphQLQueryManager.f10275g = hashMap;
                anonymousClass10.m10491a();
            }

            public final void m10625a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            }

            public final void m10626a(GraphQLGroupRequestToJoinSubscriptionLevel graphQLGroupRequestToJoinSubscriptionLevel) {
            }
        };
        ((AbstractGroupSubscriptionController) this.f10285q.get()).a(str, graphQLGroupSubscriptionLevel, GraphQLGroupSubscriptionLevel.OFF);
    }
}
