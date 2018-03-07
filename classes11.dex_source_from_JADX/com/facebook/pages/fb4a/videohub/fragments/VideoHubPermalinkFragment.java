package com.facebook.pages.fb4a.videohub.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.fb4a.videohub.graphql.VideoHub;
import com.facebook.pages.fb4a.videohub.graphql.VideoHub.PageVideoHubQueryString;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoHubQueryModel;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.PageVideoListModel;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubModels.VideoCollectionFragmentModel.VideoListsModel;
import com.facebook.pages.fb4a.videohub.ui.PagesVideoHubAllVideosView;
import com.facebook.pages.fb4a.videohub.ui.PagesVideoHubAllVideosView.C04261;
import com.facebook.pages.fb4a.videohub.ui.PagesVideoHubVideoListView;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: profile_field_sections */
public class VideoHubPermalinkFragment extends FbFragment implements PagesSurfaceTabFragment {
    public static final int[] ay = new int[2];
    @Inject
    public TasksManager f3034a;
    public int aA = -1;
    public List<PageVideoListModel> al;
    public int am;
    public String an;
    public boolean ao;
    private VideoListsAdapter ap;
    private ReactionHeaderTouchDelegateView aq;
    private ReactionHeaderViewWithTouchDelegate ar;
    public View as;
    public PagesSurfaceFragment at;
    public boolean au = false;
    public int av;
    private int aw;
    private int ax = -1;
    public boolean az = false;
    @Inject
    public AbstractFbErrorReporter f3035b;
    @Inject
    public GraphQLQueryExecutor f3036c;
    @Inject
    public ScreenUtil f3037d;
    private FrameLayout f3038e;
    public ListView f3039f;
    private EmptyListViewItem f3040g;
    private ProgressBar f3041h;
    public long f3042i;

    /* compiled from: profile_field_sections */
    class C04131 implements OnScrollListener {
        final /* synthetic */ VideoHubPermalinkFragment f3030a;

        C04131(VideoHubPermalinkFragment videoHubPermalinkFragment) {
            this.f3030a = videoHubPermalinkFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int count = this.f3030a.f3039f.getAdapter() != null ? this.f3030a.f3039f.getAdapter().getCount() : 0;
            if (!(this.f3030a.az && this.f3030a.aA == count)) {
                Pair a = PagesScrollUtils.a(this.f3030a.as, this.f3030a.f3039f, i, VideoHubPermalinkFragment.ay, this.f3030a.f3037d.d());
                this.f3030a.az = ((Boolean) a.a).booleanValue();
                if (this.f3030a.az) {
                    this.f3030a.E_(((Integer) a.b).intValue());
                    this.f3030a.aA = count;
                }
            }
            int top = this.f3030a.f3039f.getChildAt(0).getTop();
            if (this.f3030a.at != null && this.f3030a.f3039f != null && this.f3030a.av != top && this.f3030a.D()) {
                this.f3030a.at.m5039a(this.f3030a.f3039f, i);
                this.f3030a.av = top;
            }
        }
    }

    /* compiled from: profile_field_sections */
    class C04142 implements Callable<ListenableFuture<GraphQLResult<PageVideoHubQueryModel>>> {
        final /* synthetic */ VideoHubPermalinkFragment f3031a;

        C04142(VideoHubPermalinkFragment videoHubPermalinkFragment) {
            this.f3031a = videoHubPermalinkFragment;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f3031a.f3036c;
            VideoHubPermalinkFragment videoHubPermalinkFragment = this.f3031a;
            PageVideoHubQueryString a = VideoHub.m4149a();
            a.a("page_id", String.valueOf(videoHubPermalinkFragment.f3042i)).a("video_list_entries_per_fetch", "3").a("page_video_list_max_videos", "3");
            if (videoHubPermalinkFragment.an != null) {
                a.a("after_video_list_page", videoHubPermalinkFragment.an);
            }
            return graphQLQueryExecutor.a(GraphQLRequest.a(a));
        }
    }

    /* compiled from: profile_field_sections */
    class C04153 extends AbstractDisposableFutureCallback<GraphQLResult<PageVideoHubQueryModel>> {
        final /* synthetic */ VideoHubPermalinkFragment f3032a;

        C04153(VideoHubPermalinkFragment videoHubPermalinkFragment) {
            this.f3032a = videoHubPermalinkFragment;
        }

        protected final void m4077a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((PageVideoHubQueryModel) graphQLResult.e).m4165k() != null && ((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j() != null) {
                Preconditions.checkNotNull(((PageVideoHubQueryModel) graphQLResult.e).m4164j());
                this.f3032a.am = ((PageVideoHubQueryModel) graphQLResult.e).m4164j().m4154a();
                VideoListsModel j = ((PageVideoHubQueryModel) graphQLResult.e).m4165k().m4195j();
                VideoHubPermalinkFragment videoHubPermalinkFragment = this.f3032a;
                if (j.m4190j() != null) {
                    videoHubPermalinkFragment.an = j.m4190j().a();
                    videoHubPermalinkFragment.ao = j.m4190j().b();
                }
                VideoHubPermalinkFragment.m4085b(this.f3032a, j);
            }
        }

        protected final void m4078a(Throwable th) {
            this.f3032a.f3035b.a("VideoHubPermalinkFragment", th);
        }
    }

    /* compiled from: profile_field_sections */
    enum Tasks {
        FETCH_VIDEO_LISTS_WITH_VIDEOS
    }

    /* compiled from: profile_field_sections */
    class VideoListsAdapter extends FbBaseAdapter {
        final /* synthetic */ VideoHubPermalinkFragment f3033a;

        public VideoListsAdapter(VideoHubPermalinkFragment videoHubPermalinkFragment) {
            this.f3033a = videoHubPermalinkFragment;
        }

        public /* synthetic */ Object getItem(int i) {
            return m4079a(i);
        }

        public int getCount() {
            return this.f3033a.al.size() + 1;
        }

        private PageVideoListModel m4079a(int i) {
            if (i >= this.f3033a.al.size() + 1 || i <= 0) {
                return null;
            }
            return (PageVideoListModel) this.f3033a.al.get(i - 1);
        }

        public long getItemId(int i) {
            if (i < this.f3033a.al.size() + 1) {
                return (long) i;
            }
            return Long.MIN_VALUE;
        }

        public final View m4080a(int i, ViewGroup viewGroup) {
            int i2 = this.f3033a.au ? 0 : 2130773403;
            return i == ViewType.ALL_VIDEOS.ordinal() ? new PagesVideoHubAllVideosView(this.f3033a.getContext(), i2) : new PagesVideoHubVideoListView(this.f3033a.getContext(), i2);
        }

        public final void m4081a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
            if (this.f3033a.au) {
                view.setBackgroundResource(2131361864);
            }
            PageVideoListModel pageVideoListModel = (PageVideoListModel) obj;
            if (i2 == ViewType.ALL_VIDEOS.ordinal()) {
                PagesVideoHubAllVideosView pagesVideoHubAllVideosView = (PagesVideoHubAllVideosView) view;
                long j = this.f3033a.f3042i;
                int i3 = this.f3033a.am;
                pagesVideoHubAllVideosView.f3124c.setText(pagesVideoHubAllVideosView.getContext().getString(2131235507));
                pagesVideoHubAllVideosView.f3124c.setBadgeText(PagesVideoHubVideoListView.m4228a(i3));
                pagesVideoHubAllVideosView.f3124c.setOnClickListener(new C04261(pagesVideoHubAllVideosView, j));
            } else if (i2 == ViewType.VIDEO_LIST.ordinal()) {
                PagesVideoHubVideoListView pagesVideoHubVideoListView = (PagesVideoHubVideoListView) view;
                if (pageVideoListModel == m4079a(getCount() - 1)) {
                    VideoHubPermalinkFragment.m4083a(this.f3033a, false);
                }
                pagesVideoHubVideoListView.m4232a(this.f3033a.f3042i, pageVideoListModel);
            }
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return ViewType.ALL_VIDEOS.ordinal();
            }
            return ViewType.VIDEO_LIST.ordinal();
        }

        public int getViewTypeCount() {
            return ViewType.values().length;
        }
    }

    /* compiled from: profile_field_sections */
    public enum ViewType {
        ALL_VIDEOS,
        VIDEO_LIST
    }

    public static void m4084a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoHubPermalinkFragment videoHubPermalinkFragment = (VideoHubPermalinkFragment) obj;
        TasksManager b = TasksManager.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        ScreenUtil a2 = ScreenUtil.a(fbInjector);
        videoHubPermalinkFragment.f3034a = b;
        videoHubPermalinkFragment.f3035b = abstractFbErrorReporter;
        videoHubPermalinkFragment.f3036c = a;
        videoHubPermalinkFragment.f3037d = a2;
    }

    public final void m4096j() {
    }

    private void m4086e() {
        if (this.aq == null) {
            if (this.ar == null) {
                this.aq = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.aq = new ReactionHeaderTouchDelegateView(this.ar);
                this.ar.a(this.aq);
            }
            this.aq.c = true;
        } else if (this.ar != null) {
            this.aq.a = this.ar;
            this.ar.a(this.aq);
            this.aq.requestLayout();
        }
    }

    public final void m4092a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.at = pagesSurfaceFragment;
    }

    public final void m4093a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.ar = reactionHeaderViewWithTouchDelegate;
        m4086e();
    }

    public final void D_(int i) {
        this.aw = i;
        PagesScrollUtils.a(this.f3039f, this.aw);
    }

    public final void E_(int i) {
        if (this.ax < 0 || i <= this.ax) {
            this.ax = i;
            if (this.as != null) {
                this.as.setLayoutParams(new LayoutParams(-1, this.ax));
            }
        }
    }

    public final void m4091a(C05581 c05581) {
    }

    public static VideoHubPermalinkFragment m4082a(long j, boolean z) {
        Preconditions.checkArgument(j != 0);
        VideoHubPermalinkFragment videoHubPermalinkFragment = new VideoHubPermalinkFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("page_id", j);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z);
        videoHubPermalinkFragment.g(bundle);
        return videoHubPermalinkFragment;
    }

    public final void m4094c(Bundle bundle) {
        boolean z;
        super.c(bundle);
        Class cls = VideoHubPermalinkFragment.class;
        m4084a((Object) this, getContext());
        Activity ao = ao();
        if (ao != null) {
            ao.getTheme().applyStyle(2131625518, true);
        }
        if (this.s != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "The arguments for the fragment should have a long value for user id which is missing");
        Bundle bundle2 = this.s;
        this.f3042i = bundle2.getLong("page_id");
        this.au = bundle2.getBoolean("extra_is_inside_page_surface_tab", false);
        this.al = Lists.a();
        this.ao = true;
    }

    public final View m4089a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1392728425);
        this.f3041h = (ProgressBar) layoutInflater.inflate(2130907681, viewGroup, false);
        this.f3041h.setLayoutParams(new LayoutParams(-1, -2));
        View inflate = layoutInflater.inflate(2130906131, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2124869806, a);
        return inflate;
    }

    public final void m4090a(View view, Bundle bundle) {
        Resources resources = view.getResources();
        this.f3038e = (FrameLayout) view.findViewById(2131565751);
        this.f3039f = (ListView) view.findViewById(2131565752);
        this.f3039f.addFooterView(this.f3041h);
        this.f3040g = (EmptyListViewItem) view.findViewById(2131565753);
        this.ap = new VideoListsAdapter(this);
        m4086e();
        if (this.aq != null) {
            this.f3039f.addHeaderView(this.aq);
        }
        if (this.au) {
            this.f3039f.setVerticalScrollBarEnabled(false);
            this.f3039f.setPadding(0, 0, 0, 0);
            this.f3038e.removeView(this.f3040g);
            this.f3040g = null;
            this.f3039f.setDivider(resources.getDrawable(2131361871));
            this.f3039f.setDividerHeight(resources.getDimensionPixelSize(2131427418));
        }
        this.as = new View(getContext());
        E_(this.ax);
        this.f3039f.addFooterView(this.as);
        this.f3039f.setAdapter(this.ap);
        this.f3039f.setOnScrollListener(new C04131(this));
        D_(this.aw);
    }

    public final void m4095d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 801332138);
        super.d(bundle);
        if (this.al.isEmpty()) {
            m4083a(this, true);
        } else {
            ar();
        }
        LogUtils.f(-1290519015, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -743390610);
        super.mi_();
        if (this.au) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1132149671, a);
            return;
        }
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131235461);
        }
        LogUtils.f(-41526651, a);
    }

    public final void m4087G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2043363085);
        super.G();
        m4083a(this, this.al.isEmpty());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -109826577, a);
    }

    public final void m4088H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1154181393);
        super.H();
        this.f3034a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1453350053, a);
    }

    public static void m4083a(VideoHubPermalinkFragment videoHubPermalinkFragment, boolean z) {
        if (z || videoHubPermalinkFragment.ao) {
            if (z) {
                videoHubPermalinkFragment.ao = true;
                videoHubPermalinkFragment.an = null;
                videoHubPermalinkFragment.al.clear();
                if (videoHubPermalinkFragment.f3040g != null) {
                    videoHubPermalinkFragment.f3040g.a(true);
                }
            }
            videoHubPermalinkFragment.f3034a.a(Tasks.FETCH_VIDEO_LISTS_WITH_VIDEOS, new C04142(videoHubPermalinkFragment), new C04153(videoHubPermalinkFragment));
        } else if (videoHubPermalinkFragment.f3039f.getFooterViewsCount() > 0) {
            videoHubPermalinkFragment.f3039f.removeFooterView(videoHubPermalinkFragment.f3041h);
        }
    }

    public static void m4085b(VideoHubPermalinkFragment videoHubPermalinkFragment, VideoListsModel videoListsModel) {
        ImmutableList a = videoListsModel.m4189a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            videoHubPermalinkFragment.al.add((PageVideoListModel) a.get(i));
        }
        videoHubPermalinkFragment.ar();
    }

    private void ar() {
        if (this.f3040g != null) {
            this.f3040g.a(false);
            this.f3040g.setVisibility(8);
        }
        AdapterDetour.a(this.ap, 1760258375);
    }
}
