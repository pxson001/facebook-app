package com.facebook.pages.fb4a.videohub.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.fb4a.videohub.ui.PageVideoListCardWithVideos;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL.VideosUploadedByUserDetailQueryString;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLInterfaces.VideoDetailFragment;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserDetailQueryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserDetailQueryModel.UploadedVideosModel;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
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

/* compiled from: profile_about_item_vpv */
public class VideoPlaylistAllVideosPermalinkFragment extends FbFragment implements PagesSurfaceTabFragment {
    @Inject
    public TasksManager f3048a;
    private VideoListsAllVideosAdapter al;
    private ReactionHeaderTouchDelegateView am;
    private ReactionHeaderViewWithTouchDelegate an;
    private View ao;
    public PagesSurfaceFragment ap;
    public boolean aq = false;
    public int ar;
    private int as;
    private int at = 0;
    @Inject
    public AbstractFbErrorReporter f3049b;
    @Inject
    public GraphQLQueryExecutor f3050c;
    private FrameLayout f3051d;
    public ListView f3052e;
    public EmptyListViewItem f3053f;
    public long f3054g;
    public List<VideoDetailFragment> f3055h;
    public String f3056i = null;

    /* compiled from: profile_about_item_vpv */
    class C04161 implements OnScrollListener {
        final /* synthetic */ VideoPlaylistAllVideosPermalinkFragment f3043a;

        C04161(VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment) {
            this.f3043a = videoPlaylistAllVideosPermalinkFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f3043a.f3052e.getChildCount() != 0) {
                int top = this.f3043a.f3052e.getChildAt(0).getTop();
                if (this.f3043a.ap != null && this.f3043a.f3052e != null && this.f3043a.ar != top && this.f3043a.D()) {
                    this.f3043a.ap.m5039a(this.f3043a.f3052e, i);
                    this.f3043a.ar = top;
                }
            }
        }
    }

    /* compiled from: profile_about_item_vpv */
    public class C04172 implements Callable<ListenableFuture<GraphQLResult<VideosUploadedByUserDetailQueryModel>>> {
        final /* synthetic */ VideoPlaylistAllVideosPermalinkFragment f3044a;

        public C04172(VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment) {
            this.f3044a = videoPlaylistAllVideosPermalinkFragment;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f3044a.f3050c;
            VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment = this.f3044a;
            VideosUploadedByUserDetailQueryString a = VideosUploadedByUserGraphQL.a();
            a.a("node_id", Long.toString(videoPlaylistAllVideosPermalinkFragment.f3054g)).a("media_type", MediaTypeInputMimeType.IMAGEWEBP);
            return graphQLQueryExecutor.a(GraphQLRequest.a(a));
        }
    }

    /* compiled from: profile_about_item_vpv */
    public class C04183 extends AbstractDisposableFutureCallback<GraphQLResult<VideosUploadedByUserDetailQueryModel>> {
        final /* synthetic */ VideoPlaylistAllVideosPermalinkFragment f3045a;

        public C04183(VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment) {
            this.f3045a = videoPlaylistAllVideosPermalinkFragment;
        }

        protected final void m4097a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k() != null && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j() != null && !((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j().isEmpty() && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j().get(0) != null) {
                this.f3045a.f3056i = ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).j();
                VideoPlaylistAllVideosPermalinkFragment.m4101a(this.f3045a, ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k());
                VideoPlaylistAllVideosPermalinkFragment.m4103b(this.f3045a);
            }
        }

        protected final void m4098a(Throwable th) {
            this.f3045a.f3049b.a(getClass().toString(), th);
        }
    }

    /* compiled from: profile_about_item_vpv */
    public enum Tasks {
        FETCH_VIDEO_LISTS_WITH_VIDEOS
    }

    /* compiled from: profile_about_item_vpv */
    public class VideoListsAllVideosAdapter extends FbBaseAdapter {
        final /* synthetic */ VideoPlaylistAllVideosPermalinkFragment f3046a;
        public boolean f3047b = false;

        public VideoListsAllVideosAdapter(VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment) {
            this.f3046a = videoPlaylistAllVideosPermalinkFragment;
        }

        public int getCount() {
            return this.f3047b ? 1 : 0;
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public final View m4099a(int i, ViewGroup viewGroup) {
            return new PageVideoListCardWithVideos(viewGroup.getContext(), this.f3046a.aq ? 0 : 2130773403);
        }

        public final void m4100a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
            PageVideoListCardWithVideos pageVideoListCardWithVideos = (PageVideoListCardWithVideos) view;
            pageVideoListCardWithVideos.m4210a(this.f3046a.f3055h, this.f3046a.jW_().getString(2131235507), null);
            if (this.f3046a.aq) {
                pageVideoListCardWithVideos.setBackgroundResource(2131361864);
            }
        }
    }

    public static void m4102a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment = (VideoPlaylistAllVideosPermalinkFragment) obj;
        TasksManager b = TasksManager.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        videoPlaylistAllVideosPermalinkFragment.f3048a = b;
        videoPlaylistAllVideosPermalinkFragment.f3049b = abstractFbErrorReporter;
        videoPlaylistAllVideosPermalinkFragment.f3050c = a;
    }

    public final void m4111c(Bundle bundle) {
        boolean z = true;
        super.c(bundle);
        Class cls = VideoPlaylistAllVideosPermalinkFragment.class;
        m4102a((Object) this, getContext());
        if (ao() != null) {
            ao().getTheme().applyStyle(2131625518, true);
            if (this.s == null) {
                z = false;
            }
            Preconditions.checkState(z, "The arguments for the fragment should have a long value for user id which is missing");
            Bundle bundle2 = this.s;
            this.f3054g = bundle2.getLong("page_id");
            this.aq = bundle2.getBoolean("extra_is_inside_page_surface_tab", false);
            this.f3055h = new ArrayList();
        }
    }

    public final View m4106a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -164737461);
        View inflate = layoutInflater.inflate(2130906132, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1166070507, a);
        return inflate;
    }

    public final void m4107a(View view, Bundle bundle) {
        Resources resources = view.getResources();
        this.f3051d = (FrameLayout) view.findViewById(2131565751);
        this.f3052e = (ListView) view.findViewById(2131565754);
        this.f3053f = (EmptyListViewItem) view.findViewById(2131565755);
        this.al = new VideoListsAllVideosAdapter(this);
        if (this.am != null) {
            this.f3052e.addHeaderView(this.am);
        }
        if (this.aq) {
            this.f3052e.setVerticalScrollBarEnabled(false);
            this.f3052e.setPadding(0, 0, 0, 0);
            this.f3051d.removeView(this.f3053f);
            this.f3053f.setLayoutParams(new LayoutParams(-1, -2));
            this.f3052e.addFooterView(this.f3053f);
            this.f3052e.setDivider(resources.getDrawable(2131361871));
            this.f3052e.setDividerHeight(resources.getDimensionPixelSize(2131427418));
        }
        this.ao = new View(getContext());
        E_(this.at);
        this.f3052e.addFooterView(this.ao);
        this.f3052e.setAdapter(this.al);
        this.f3052e.setOnScrollListener(new C04161(this));
        ar();
        D_(this.as);
    }

    public final void m4112d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1287207006);
        super.d(bundle);
        m4113j();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1180133752, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -341143603);
        super.mi_();
        m4103b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1626786115, a);
    }

    public static void m4103b(VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment) {
        if (!videoPlaylistAllVideosPermalinkFragment.aq) {
            HasTitleBar hasTitleBar = (HasTitleBar) videoPlaylistAllVideosPermalinkFragment.a(HasTitleBar.class);
            if (hasTitleBar != null) {
                String string = videoPlaylistAllVideosPermalinkFragment.f3056i != null ? videoPlaylistAllVideosPermalinkFragment.f3056i : videoPlaylistAllVideosPermalinkFragment.jW_().getString(2131235463);
                hasTitleBar.a_(videoPlaylistAllVideosPermalinkFragment.jW_().getString(2131235462, new Object[]{string}));
            }
        }
    }

    public final void m4104G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1538399752);
        super.G();
        m4113j();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -635549701, a);
    }

    public final void m4105H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -118207554);
        super.H();
        this.f3048a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -913383171, a);
    }

    public final void m4113j() {
        if (this.f3055h.isEmpty()) {
            this.f3055h.clear();
            this.f3053f.a(true);
            this.f3048a.a(Tasks.FETCH_VIDEO_LISTS_WITH_VIDEOS, new C04172(this), new C04183(this));
            return;
        }
        at();
    }

    private void ar() {
        if (this.an != null && this.am == null) {
            this.am = new ReactionHeaderTouchDelegateView(this.an);
            this.am.c = true;
        }
        if (this.an != null && this.f3052e != null) {
            this.am.a = this.an;
            this.an.a(this.am);
        }
    }

    public final void m4109a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.ap = pagesSurfaceFragment;
    }

    public final void m4110a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.an = reactionHeaderViewWithTouchDelegate;
        ar();
    }

    public final void D_(int i) {
        this.as = i;
        PagesScrollUtils.a(this.f3052e, this.as);
    }

    public final void E_(int i) {
        this.at = i;
        if (this.ao != null) {
            this.ao.setLayoutParams(new LayoutParams(-1, this.at));
        }
    }

    public final void m4108a(C05581 c05581) {
    }

    public static void m4101a(VideoPlaylistAllVideosPermalinkFragment videoPlaylistAllVideosPermalinkFragment, UploadedVideosModel uploadedVideosModel) {
        videoPlaylistAllVideosPermalinkFragment.f3055h.addAll(uploadedVideosModel.j());
        videoPlaylistAllVideosPermalinkFragment.at();
    }

    private void at() {
        this.f3053f.a(false);
        this.f3053f.setVisibility(8);
        VideoListsAllVideosAdapter videoListsAllVideosAdapter = this.al;
        videoListsAllVideosAdapter.f3047b = true;
        AdapterDetour.a(videoListsAllVideosAdapter, 1299199783);
    }
}
