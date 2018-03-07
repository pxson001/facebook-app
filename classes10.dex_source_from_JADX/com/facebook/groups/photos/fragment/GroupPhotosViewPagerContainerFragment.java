package com.facebook.groups.photos.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.constants.GroupsConstants.GroupMallType;
import com.facebook.groups.draggable.AbstractGroupsDraggableViewPagerContainerFragment;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationSecondaryActionDelegate;
import com.facebook.groups.photos.adapter.GroupsPhotosPagerAdapter;
import com.facebook.groups.photos.annotation.GroupPhotosNavigationHandler;
import com.facebook.groups.photos.navigation.GroupsDefaultPhotosNavigationHandler;
import com.facebook.groups.photos.protocol.FetchGroupPhotosHeader.FetchGroupPhotosHeaderString;
import com.facebook.groups.photos.protocol.FetchGroupPhotosHeaderModels.FetchGroupPhotosHeaderModel;
import com.facebook.groups.photos.view.GroupPhotosDefaultViewFactory;
import com.facebook.groups.photos.view.GroupPhotosViewFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TOXICLE_PRIVATE_MAYBE */
public class GroupPhotosViewPagerContainerFragment extends AbstractGroupsDraggableViewPagerContainerFragment implements AnalyticsFragment {
    @Inject
    Resources f23021a;
    public String al;
    private GroupsPhotosPagerAdapter am;
    private int an;
    public FetchGroupPhotosHeaderModel ao;
    public GroupsNavigationSecondaryActionDelegate ap;
    @Inject
    @GroupPhotosNavigationHandler
    GroupsNavigationHandler f23022b;
    @Inject
    Lazy<ComposerIntentLauncher> f23023c;
    @Inject
    GroupPhotosDefaultViewFactory f23024d;
    @Inject
    public TasksManager f23025e;
    @Inject
    GraphQLQueryExecutor f23026f;
    private ViewPager f23027g;
    private TabbedViewPagerIndicator f23028h;
    public String f23029i;

    /* compiled from: TOXICLE_PRIVATE_MAYBE */
    class C33231 implements GroupsNavigationSecondaryActionDelegate {
        final /* synthetic */ GroupPhotosViewPagerContainerFragment f23018a;

        C33231(GroupPhotosViewPagerContainerFragment groupPhotosViewPagerContainerFragment) {
            this.f23018a = groupPhotosViewPagerContainerFragment;
        }

        public final Drawable m24239a() {
            return this.f23018a.f23024d.m24422e();
        }

        public final String m24240b() {
            return this.f23018a.f23021a.getString(2131242208);
        }

        public final void m24241c() {
            String string = Strings.isNullOrEmpty(this.f23018a.al) ? this.f23018a.f23021a.getString(2131242209) : this.f23018a.al;
            ComposerIntentLauncher composerIntentLauncher = (ComposerIntentLauncher) this.f23018a.f23023c.get();
            String str = this.f23018a.f23029i;
            Context context = this.f23018a.getContext();
            Builder builder = new Builder(Long.parseLong(str), TargetType.GROUP);
            if (!Strings.isNullOrEmpty(string)) {
                builder.c = string;
            }
            SimplePickerLauncherConfiguration.Builder builder2 = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.GROUP);
            builder2.a = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupPhoto").setIsFireAndForget(true).setInitialTargetData(builder.a()).a();
            composerIntentLauncher.a(SimplePickerIntent.a(context, builder2), 1756, this.f23018a);
        }

        public final boolean m24242d() {
            if (this.f23018a.ao == null || this.f23018a.ao.m24385j() == GraphQLGroupPostStatus.CANNOT_POST) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: TOXICLE_PRIVATE_MAYBE */
    public class C33242 implements Callable<ListenableFuture> {
        final /* synthetic */ GroupPhotosViewPagerContainerFragment f23019a;

        public Object call() {
            GraphQlQueryString fetchGroupPhotosHeaderString = new FetchGroupPhotosHeaderString();
            fetchGroupPhotosHeaderString.a("group_id", this.f23019a.f23029i);
            return this.f23019a.f23026f.a(GraphQLRequest.a(fetchGroupPhotosHeaderString).a(GraphQLCachePolicy.d));
        }

        public C33242(GroupPhotosViewPagerContainerFragment groupPhotosViewPagerContainerFragment) {
            this.f23019a = groupPhotosViewPagerContainerFragment;
        }
    }

    /* compiled from: TOXICLE_PRIVATE_MAYBE */
    public class C33253 extends AbstractDisposableFutureCallback {
        final /* synthetic */ GroupPhotosViewPagerContainerFragment f23020a;

        public C33253(GroupPhotosViewPagerContainerFragment groupPhotosViewPagerContainerFragment) {
            this.f23020a = groupPhotosViewPagerContainerFragment;
        }

        protected final void m24243a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f23020a.ao = (FetchGroupPhotosHeaderModel) graphQLResult.e;
            this.f23020a.f23022b.a(this.f23020a, this.f23020a.ap);
        }

        protected final void m24244a(Throwable th) {
        }
    }

    public static void m24246a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupPhotosViewPagerContainerFragment) obj).m24245a(ResourcesMethodAutoProvider.a(fbInjector), (GroupsNavigationHandler) GroupsDefaultPhotosNavigationHandler.m24266a(fbInjector), IdBasedLazy.a(fbInjector, 2371), GroupPhotosDefaultViewFactory.m24419b(fbInjector), TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector));
    }

    private void m24245a(Resources resources, GroupsNavigationHandler groupsNavigationHandler, Lazy<ComposerIntentLauncher> lazy, GroupPhotosViewFactory groupPhotosViewFactory, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f23021a = resources;
        this.f23022b = groupsNavigationHandler;
        this.f23023c = lazy;
        this.f23024d = groupPhotosViewFactory;
        this.f23025e = tasksManager;
        this.f23026f = graphQLQueryExecutor;
    }

    public final void m24250c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = GroupPhotosViewPagerContainerFragment.class;
        m24246a((Object) this, getContext());
        this.f23029i = this.s.getString("group_feed_id");
        this.al = this.s.getString("group_name");
        this.an = this.s.getInt("group_mall_type", GroupMallType.WITHOUT_TABS_LEGACY.ordinal());
    }

    public final View m24248a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -432370394);
        View inflate = layoutInflater.inflate(2130904684, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -283478332, a);
        return inflate;
    }

    public final void m24249a(View view, @Nullable Bundle bundle) {
        String string;
        super.a(view, bundle);
        this.f23027g = (ViewPager) e(2131562711);
        this.f23028h = (TabbedViewPagerIndicator) e(2131562710);
        if (Strings.isNullOrEmpty(this.al)) {
            string = jW_().getString(2131242202);
        } else {
            string = jW_().getString(2131242200, new Object[]{this.al});
        }
        this.ap = new C33231(this);
        if (o() != null) {
            o().setRequestedOrientation(1);
        }
        this.f23022b.a(this, string, this.ap);
        this.f23025e.a("fetch_photos_header", new C33242(this), new C33253(this));
    }

    public final void m24251d(@android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 220944855);
        super.d(bundle);
        this.am = new GroupsPhotosPagerAdapter(s(), this.f23029i, this.al, this.f23021a);
        this.f23027g.setAdapter(this.am);
        this.f23028h.setViewPager(this.f23027g);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1818953112, a);
    }

    public final String am_() {
        return "group_photos";
    }

    public final void m24247H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1181060088);
        super.H();
        this.f23025e.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -455740475, a);
    }
}
