package com.facebook.groups.docsandfiles.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.docsandfiles.adapter.GroupDocsAndFilesAdapter;
import com.facebook.groups.docsandfiles.adapter.GroupDocsAndFilesAdapterProvider;
import com.facebook.groups.docsandfiles.annotation.DocsAndFilesNavigationHandler;
import com.facebook.groups.docsandfiles.controller.GroupsDocsAndFilesDownloadController;
import com.facebook.groups.docsandfiles.controller.GroupsDocsAndFilesDownloadControllerProvider;
import com.facebook.groups.docsandfiles.controller.GroupsDocsAndFilesUploadController;
import com.facebook.groups.docsandfiles.controller.GroupsDocsAndFilesUploadControllerProvider;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileModel;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileState;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoader;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoader.C30541;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoader.C30552;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoader.C30563;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoader.Tasks;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoaderProvider;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.NodesModel;
import com.facebook.groups.docsandfiles.utils.FileUtils;
import com.facebook.groups.docsandfiles.view.DefaultGroupDocsAndFilesViewFactory;
import com.facebook.groups.docsandfiles.view.GroupDocsAndFilesViewFactory;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationSecondaryActionDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.text.BetterButton;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Update group header with null value. Looks wrong. */
public class GroupDocsAndFilesFragment extends FbFragment implements AnalyticsFragment {
    private static final String[] am = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    public static final String[] an = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String ao = GroupDocsAndFilesFragment.class.getName();
    @Inject
    Resources f21427a;
    private boolean aA;
    public boolean aB;
    @Inject
    Lazy<FbErrorReporter> al;
    public GroupDocsAndFilesAdapter ap;
    public GroupDocsAndFilesPagedListLoader aq;
    public GroupsDocsAndFilesDownloadController ar;
    public GroupsDocsAndFilesUploadController as;
    private String at;
    private BetterRecyclerView au;
    public GroupsNavigationSecondaryActionDelegate av;
    public BetterLinearLayoutManager aw;
    private LinearLayout ax;
    private BetterButton ay;
    public ActivityRuntimePermissionsManager az;
    @Inject
    GroupDocsAndFilesPagedListLoaderProvider f21428b;
    @Inject
    public GroupsDocsAndFilesDownloadControllerProvider f21429c;
    @Inject
    GroupsDocsAndFilesUploadControllerProvider f21430d;
    @Inject
    GroupDocsAndFilesAdapterProvider f21431e;
    @Inject
    ActivityRuntimePermissionsManagerProvider f21432f;
    @Inject
    @DocsAndFilesNavigationHandler
    GroupsNavigationHandler f21433g;
    @Inject
    DefaultGroupDocsAndFilesViewFactory f21434h;
    @Inject
    Lazy<Toaster> f21435i;

    /* compiled from: Update group header with null value. Looks wrong. */
    public class C30461 {
        final /* synthetic */ GroupDocsAndFilesFragment f21416a;

        C30461(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21416a = groupDocsAndFilesFragment;
        }

        public final void m22350a(ImmutableList<NodesModel> immutableList) {
            List arrayList = new ArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new FileModel((NodesModel) immutableList.get(i), FileState.NORMAL));
            }
            GroupDocsAndFilesAdapter groupDocsAndFilesAdapter = this.f21416a.ap;
            if (arrayList != null) {
                groupDocsAndFilesAdapter.f21327a = arrayList;
                Collection arrayList2 = new ArrayList(groupDocsAndFilesAdapter.f21331e.values());
                Collections.reverse(arrayList2);
                groupDocsAndFilesAdapter.f21327a.addAll(0, arrayList2);
                groupDocsAndFilesAdapter.notifyDataSetChanged();
            }
        }

        public final void m22351a(boolean z) {
            GroupDocsAndFilesAdapter groupDocsAndFilesAdapter = this.f21416a.ap;
            if (z != groupDocsAndFilesAdapter.f21328b) {
                groupDocsAndFilesAdapter.f21328b = z;
                groupDocsAndFilesAdapter.notifyDataSetChanged();
            }
        }

        public final void m22352b(boolean z) {
            this.f21416a.aB = z;
            GroupDocsAndFilesFragment.m22366a(this.f21416a, z);
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    class C30472 extends OnScrollListener {
        final /* synthetic */ GroupDocsAndFilesFragment f21417a;

        C30472(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21417a = groupDocsAndFilesFragment;
        }

        public final void m22353a(RecyclerView recyclerView, int i) {
        }

        public final void m22354a(RecyclerView recyclerView, int i, int i2) {
            Object obj;
            GroupDocsAndFilesFragment groupDocsAndFilesFragment = this.f21417a;
            int n = this.f21417a.aw.n();
            int D = this.f21417a.aw.D();
            if (groupDocsAndFilesFragment.ap.f21327a.isEmpty() || D <= 0 || n + 4 <= D) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                GroupDocsAndFilesFragment.as(this.f21417a);
            }
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    public class C30483 {
        public final /* synthetic */ GroupDocsAndFilesFragment f21418a;

        C30483(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21418a = groupDocsAndFilesFragment;
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    public class C30494 implements GroupsNavigationSecondaryActionDelegate {
        final /* synthetic */ GroupDocsAndFilesFragment f21419a;

        public C30494(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21419a = groupDocsAndFilesFragment;
        }

        public final Drawable m22355a() {
            return this.f21419a.f21434h.f21502a.getDrawable(2130840032);
        }

        public final String m22356b() {
            return this.f21419a.b(2131242077);
        }

        public final void m22357c() {
            GroupDocsAndFilesFragment.aq(this.f21419a);
        }

        public final boolean m22358d() {
            return true;
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    class C30505 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ GroupDocsAndFilesFragment f21420a;

        C30505(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21420a = groupDocsAndFilesFragment;
        }

        public final void m22359a() {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
            this.f21420a.a(Intent.createChooser(intent, this.f21420a.b(2131242070)), 1);
        }

        public final void m22360a(String[] strArr, String[] strArr2) {
            ((Toaster) this.f21420a.f21435i.get()).a(new ToastBuilder(2131237936));
        }

        public final void m22361b() {
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    class C30516 implements OnClickListener {
        final /* synthetic */ GroupDocsAndFilesFragment f21421a;

        C30516(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21421a = groupDocsAndFilesFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1203271749);
            GroupDocsAndFilesFragment.aq(this.f21421a);
            Logger.a(2, EntryType.UI_INPUT_END, -475159734, a);
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    public class C30527 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ String f21422a;
        final /* synthetic */ String f21423b;
        final /* synthetic */ int f21424c;
        final /* synthetic */ GroupDocsAndFilesFragment f21425d;

        public C30527(GroupDocsAndFilesFragment groupDocsAndFilesFragment, String str, String str2, int i) {
            this.f21425d = groupDocsAndFilesFragment;
            this.f21422a = str;
            this.f21423b = str2;
            this.f21424c = i;
        }

        public final void m22362a() {
            GroupDocsAndFilesFragment groupDocsAndFilesFragment = this.f21425d;
            String str = this.f21422a;
            String str2 = this.f21423b;
            int i = this.f21424c;
            groupDocsAndFilesFragment.ap.m22312a(i, FileState.DOWNLOADING_IS_IN_PROGRESS);
            if (groupDocsAndFilesFragment.ar == null) {
                groupDocsAndFilesFragment.ar = groupDocsAndFilesFragment.f21429c.m22321a(groupDocsAndFilesFragment.getContext(), new C30538(groupDocsAndFilesFragment));
            }
            groupDocsAndFilesFragment.ar.m22320a(str, str2, i);
        }

        public final void m22363a(String[] strArr, String[] strArr2) {
            ((Toaster) this.f21425d.f21435i.get()).a(new ToastBuilder(2131237936));
        }

        public final void m22364b() {
        }
    }

    /* compiled from: Update group header with null value. Looks wrong. */
    public class C30538 {
        public final /* synthetic */ GroupDocsAndFilesFragment f21426a;

        public C30538(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
            this.f21426a = groupDocsAndFilesFragment;
        }
    }

    public static void m22367a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupDocsAndFilesFragment) obj).m22365a(ResourcesMethodAutoProvider.a(fbInjector), (GroupDocsAndFilesPagedListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupDocsAndFilesPagedListLoaderProvider.class), (GroupsDocsAndFilesDownloadControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsDocsAndFilesDownloadControllerProvider.class), (GroupsDocsAndFilesUploadControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsDocsAndFilesUploadControllerProvider.class), (GroupDocsAndFilesAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupDocsAndFilesAdapterProvider.class), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (GroupsNavigationHandler) DefaultGroupsNavigationHandler.a(fbInjector), DefaultGroupDocsAndFilesViewFactory.m22522b(fbInjector), IdBasedLazy.a(fbInjector, 3588), IdBasedSingletonScopeProvider.b(fbInjector, 494));
    }

    public final void m22371c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupDocsAndFilesFragment.class;
        m22367a((Object) this, getContext());
        this.at = this.s.getString("group_feed_id");
        this.aA = this.s.getBoolean("groups_launch_file_selector", false);
        this.ap = new GroupDocsAndFilesAdapter(this.at, (GroupDocOrFileListViewItemProvider) this.f21431e.getOnDemandAssistedProviderForStaticDi(GroupDocOrFileListViewItemProvider.class));
        this.ap.f21330d = this;
        GroupDocsAndFilesPagedListLoaderProvider groupDocsAndFilesPagedListLoaderProvider = this.f21428b;
        this.aq = new GroupDocsAndFilesPagedListLoader(GraphQLQueryExecutor.a(groupDocsAndFilesPagedListLoaderProvider), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(groupDocsAndFilesPagedListLoaderProvider), TasksManager.b(groupDocsAndFilesPagedListLoaderProvider), this.at, new C30461(this));
    }

    public final View m22368a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1086254319);
        View inflate = layoutInflater.inflate(2130904659, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 540413542, a);
        return inflate;
    }

    public final void m22370a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.az = this.f21432f.a(o());
        this.av = new C30494(this);
        this.f21433g.a(this, this.f21427a.getString(2131242067), this.av);
        this.au = (BetterRecyclerView) e(2131562683);
        this.au.setAdapter(this.ap);
        this.aw = new BetterLinearLayoutManager(getContext());
        this.au.setLayoutManager(this.aw);
        this.au.setOnScrollListener(new C30472(this));
        as(this);
        if (this.aA) {
            this.aA = false;
            aq(this);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1532922660);
        super.mY_();
        GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader = this.aq;
        groupDocsAndFilesPagedListLoader.f21448g = null;
        groupDocsAndFilesPagedListLoader.f21446e = null;
        groupDocsAndFilesPagedListLoader.f21449h = false;
        groupDocsAndFilesPagedListLoader.f21444c.c();
        this.ax = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1658507816, a);
    }

    public final void m22369a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String a = FileUtils.m22518a(getContext(), intent.getData());
                    if (a == null) {
                        ((AbstractFbErrorReporter) this.al.get()).a(ao, "Invalid file path. Original uri is: " + intent.getData());
                        return;
                    }
                    Object obj;
                    if (a == null || a.startsWith("http://") || a.startsWith("https://")) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        File file = new File(a);
                        if (this.as == null) {
                            this.as = this.f21430d.m22342a(this.at, getContext(), new C30483(this));
                        }
                        this.as.m22340a(file);
                        return;
                    }
                    ((AbstractFbErrorReporter) this.al.get()).a(ao, "Non local file is selected. Original uri is: " + intent.getData());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void aq(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
        groupDocsAndFilesFragment.az.a(am, new C30505(groupDocsAndFilesFragment));
    }

    public static void m22366a(GroupDocsAndFilesFragment groupDocsAndFilesFragment, boolean z) {
        if (z) {
            if (groupDocsAndFilesFragment.ax == null) {
                groupDocsAndFilesFragment.ax = (LinearLayout) ((ViewStub) groupDocsAndFilesFragment.e(2131562684)).inflate();
                groupDocsAndFilesFragment.ay = (BetterButton) groupDocsAndFilesFragment.ax.findViewById(2131562780);
                groupDocsAndFilesFragment.ay.setOnClickListener(new C30516(groupDocsAndFilesFragment));
            }
            groupDocsAndFilesFragment.ax.setVisibility(0);
            groupDocsAndFilesFragment.au.setVisibility(8);
            return;
        }
        if (groupDocsAndFilesFragment.ax != null) {
            groupDocsAndFilesFragment.ax.setVisibility(8);
        }
        groupDocsAndFilesFragment.au.setVisibility(0);
    }

    public final String am_() {
        return "group_files_and_docs";
    }

    public static void as(GroupDocsAndFilesFragment groupDocsAndFilesFragment) {
        GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader = groupDocsAndFilesFragment.aq;
        if (!groupDocsAndFilesPagedListLoader.f21449h) {
            TasksManager tasksManager = groupDocsAndFilesPagedListLoader.f21444c;
            Tasks tasks = Tasks.FETCH_GROUP_DOCS_AND_FILES;
            ExecutorDetour.a(groupDocsAndFilesPagedListLoader.f21443b, new C30552(groupDocsAndFilesPagedListLoader), 1132995430);
            tasksManager.a(tasks, new C30563(groupDocsAndFilesPagedListLoader), new C30541(groupDocsAndFilesPagedListLoader));
        }
    }

    private void m22365a(Resources resources, GroupDocsAndFilesPagedListLoaderProvider groupDocsAndFilesPagedListLoaderProvider, GroupsDocsAndFilesDownloadControllerProvider groupsDocsAndFilesDownloadControllerProvider, GroupsDocsAndFilesUploadControllerProvider groupsDocsAndFilesUploadControllerProvider, GroupDocsAndFilesAdapterProvider groupDocsAndFilesAdapterProvider, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, GroupsNavigationHandler groupsNavigationHandler, GroupDocsAndFilesViewFactory groupDocsAndFilesViewFactory, Lazy<Toaster> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f21427a = resources;
        this.f21428b = groupDocsAndFilesPagedListLoaderProvider;
        this.f21429c = groupsDocsAndFilesDownloadControllerProvider;
        this.f21430d = groupsDocsAndFilesUploadControllerProvider;
        this.f21431e = groupDocsAndFilesAdapterProvider;
        this.f21432f = activityRuntimePermissionsManagerProvider;
        this.f21433g = groupsNavigationHandler;
        this.f21434h = groupDocsAndFilesViewFactory;
        this.f21435i = lazy;
        this.al = lazy2;
    }
}
