package com.facebook.pages.fb4a.videohub.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.fb4a.videohub.graphql.VideoHub;
import com.facebook.pages.fb4a.videohub.graphql.VideoHub.PageVideoHubQueryString;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoHubQueryModel;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoListModel;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoListModel.VideoListVideosModel;
import com.facebook.pages.fb4a.videohub.ui.PageVideoListCardWithVideos;
import com.facebook.pages.fb4a.videohub.ui.PageVideoListNavItem;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLInterfaces.VideoDetailFragment;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: profileExperienceDelete */
public class VideoPlaylistPermalinkFragment extends FbFragment {
    @Inject
    public TasksManager f3061a;
    public List<VideoDetailFragment> al;
    public String am = null;
    public String an = null;
    public String ao = null;
    private VideoListsVideosAdapter ap;
    @Inject
    AbstractFbErrorReporter f3062b;
    @Inject
    GraphQLQueryExecutor f3063c;
    @Inject
    FbUriIntentHandler f3064d;
    @Inject
    PagesAnalytics f3065e;
    private ListView f3066f;
    public EmptyListViewItem f3067g;
    public long f3068h;
    public long f3069i;

    /* compiled from: profileExperienceDelete */
    public class C04191 implements Callable<ListenableFuture<GraphQLResult<PageVideoHubQueryModel>>> {
        final /* synthetic */ VideoPlaylistPermalinkFragment f3057a;

        public C04191(VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment) {
            this.f3057a = videoPlaylistPermalinkFragment;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f3057a.f3063c;
            VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment = this.f3057a;
            PageVideoHubQueryString a = VideoHub.m4149a();
            a.a("page_id", String.valueOf(videoPlaylistPermalinkFragment.f3069i)).a("video_list_id_to_fetch", String.valueOf(videoPlaylistPermalinkFragment.f3068h));
            return graphQLQueryExecutor.a(GraphQLRequest.a(a));
        }
    }

    /* compiled from: profileExperienceDelete */
    public class C04202 extends AbstractDisposableFutureCallback<GraphQLResult<PageVideoHubQueryModel>> {
        final /* synthetic */ VideoPlaylistPermalinkFragment f3058a;

        public C04202(VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment) {
            this.f3058a = videoPlaylistPermalinkFragment;
        }

        protected final void m4114a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((PageVideoHubQueryModel) graphQLResult.e).m4165k() != null && ((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j() != null && ((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j().m4189a() != null && !((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j().m4189a().isEmpty() && ((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j().m4189a().get(0) != null) {
                PageVideoListModel pageVideoListModel = (PageVideoListModel) ((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j().m4189a().get(0);
                if (pageVideoListModel.m4181l() != null && pageVideoListModel.m4182m() != null && pageVideoListModel.m4182m().m4175j() != null) {
                    this.f3058a.am = ((PageVideoHubQueryModel) graphQLResult.e).m4161a();
                    this.f3058a.an = pageVideoListModel.m4181l();
                    this.f3058a.ao = pageVideoListModel.m4180k();
                    VideoPlaylistPermalinkFragment.m4118a(this.f3058a, pageVideoListModel.m4182m());
                    VideoPlaylistPermalinkFragment.m4121b(this.f3058a);
                }
            }
        }

        protected final void m4115a(Throwable th) {
            this.f3058a.f3062b.a(getClass().toString(), th);
        }
    }

    /* compiled from: profileExperienceDelete */
    public enum Tasks {
        FETCH_VIDEO_LISTS_WITH_VIDEOS
    }

    /* compiled from: profileExperienceDelete */
    class VideoListsVideosAdapter extends FbBaseAdapter {
        final /* synthetic */ VideoPlaylistPermalinkFragment f3060a;

        /* compiled from: profileExperienceDelete */
        class C04211 implements OnClickListener {
            final /* synthetic */ VideoListsVideosAdapter f3059a;

            C04211(VideoListsVideosAdapter videoListsVideosAdapter) {
                this.f3059a = videoListsVideosAdapter;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 429706099);
                this.f3059a.f3060a.f3064d.a(this.f3059a.f3060a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.au, Long.valueOf(this.f3059a.f3060a.f3069i)));
                this.f3059a.f3060a.f3065e.a(this.f3059a.f3060a.f3069i, "VideoPlaylistFragment");
                Logger.a(2, EntryType.UI_INPUT_END, 1732390315, a);
            }
        }

        public VideoListsVideosAdapter(VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment) {
            this.f3060a = videoPlaylistPermalinkFragment;
        }

        public int getCount() {
            return ViewType.values().length;
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            if (i < 0 || i >= getCount()) {
                return Long.MIN_VALUE;
            }
            return (long) i;
        }

        public final View m4116a(int i, ViewGroup viewGroup) {
            if (i == ViewType.PLAYLIST_INFO_AND_VIDEOS.ordinal()) {
                return new PageVideoListCardWithVideos(viewGroup.getContext(), 2130773403);
            }
            if (i == ViewType.NAV_ITEM.ordinal()) {
                return new PageVideoListNavItem(viewGroup.getContext(), 2130773403);
            }
            return null;
        }

        public final void m4117a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
            if (i2 == ViewType.PLAYLIST_INFO_AND_VIDEOS.ordinal()) {
                ((PageVideoListCardWithVideos) view).m4210a(this.f3060a.al, this.f3060a.an, this.f3060a.ao);
            } else if (i2 == ViewType.NAV_ITEM.ordinal()) {
                PageVideoListNavItem pageVideoListNavItem = (PageVideoListNavItem) view;
                pageVideoListNavItem.m4216a(VideoPlaylistPermalinkFragment.m4122e(this.f3060a));
                pageVideoListNavItem.setOnClickListener(new C04211(this));
            }
        }

        public int getItemViewType(int i) {
            Preconditions.checkPositionIndex(i, getCount());
            if (i == 0) {
                return ViewType.NAV_ITEM.ordinal();
            }
            return ViewType.PLAYLIST_INFO_AND_VIDEOS.ordinal();
        }

        public int getViewTypeCount() {
            return ViewType.values().length;
        }
    }

    /* compiled from: profileExperienceDelete */
    public enum ViewType {
        NAV_ITEM,
        PLAYLIST_INFO_AND_VIDEOS
    }

    public static void m4120a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoPlaylistPermalinkFragment) obj).m4119a(TasksManager.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), FbUriIntentHandler.a(fbInjector), PagesAnalytics.a(fbInjector));
    }

    public final void m4126c(Bundle bundle) {
        boolean z = true;
        super.c(bundle);
        Class cls = VideoPlaylistPermalinkFragment.class;
        m4120a((Object) this, getContext());
        if (ao() != null) {
            ao().getTheme().applyStyle(2131625518, true);
            if (this.s == null) {
                z = false;
            }
            Preconditions.checkState(z, "The arguments for the fragment should have a long value for user id which is missing");
            Bundle bundle2 = this.s;
            this.f3068h = bundle2.getLong("video_list_id");
            this.f3069i = bundle2.getLong("page_id");
            this.al = new ArrayList();
        }
    }

    public final View m4125a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1624210290);
        View inflate = layoutInflater.inflate(2130906132, viewGroup, false);
        this.f3066f = (ListView) inflate.findViewById(2131565754);
        this.f3067g = (EmptyListViewItem) inflate.findViewById(2131565755);
        this.ap = new VideoListsVideosAdapter(this);
        this.f3066f.setAdapter(this.ap);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2003669338, a);
        return inflate;
    }

    private void m4119a(TasksManager tasksManager, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, FbUriIntentHandler fbUriIntentHandler, PagesAnalytics pagesAnalytics) {
        this.f3061a = tasksManager;
        this.f3062b = abstractFbErrorReporter;
        this.f3063c = graphQLQueryExecutor;
        this.f3064d = fbUriIntentHandler;
        this.f3065e = pagesAnalytics;
    }

    public final void m4127d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1122962168);
        super.d(bundle);
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 293847729, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -53573124);
        super.mi_();
        m4121b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 90229189, a);
    }

    public static void m4121b(VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment) {
        HasTitleBar hasTitleBar = (HasTitleBar) videoPlaylistPermalinkFragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            String e = m4122e(videoPlaylistPermalinkFragment);
            hasTitleBar.a_(videoPlaylistPermalinkFragment.jW_().getString(2131235462, new Object[]{e}));
        }
    }

    public static String m4122e(VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment) {
        return videoPlaylistPermalinkFragment.am != null ? videoPlaylistPermalinkFragment.am : videoPlaylistPermalinkFragment.jW_().getString(2131235463);
    }

    public final void m4123G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -979131225);
        super.G();
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2128116510, a);
    }

    public final void m4124H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1633795634);
        super.H();
        this.f3061a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1894599268, a);
    }

    private void ar() {
        if (this.al.isEmpty()) {
            this.al.clear();
            this.f3067g.a(true);
            this.f3061a.a(Tasks.FETCH_VIDEO_LISTS_WITH_VIDEOS, new C04191(this), new C04202(this));
            return;
        }
        at();
    }

    public static void m4118a(VideoPlaylistPermalinkFragment videoPlaylistPermalinkFragment, VideoListVideosModel videoListVideosModel) {
        videoPlaylistPermalinkFragment.al.addAll(videoListVideosModel.m4175j());
        videoPlaylistPermalinkFragment.at();
    }

    private void at() {
        this.f3067g.a(false);
        this.f3067g.setVisibility(8);
        AdapterDetour.a(this.ap, -2088594639);
    }
}
