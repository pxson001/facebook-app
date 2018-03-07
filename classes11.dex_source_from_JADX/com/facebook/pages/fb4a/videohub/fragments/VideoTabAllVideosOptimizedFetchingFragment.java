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
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.fb4a.videohub.ui.PageVideoListItem;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL.VideosUploadedByUserDetailQueryString;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLInterfaces.VideoDetailFragment;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserDetailQueryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserDetailQueryModel.UploadedVideosModel;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: profile/{%s}/info/inner */
public class VideoTabAllVideosOptimizedFetchingFragment extends FbFragment implements PagesSurfaceTabFragment {
    public static final int[] ax = new int[2];
    @Inject
    public TasksManager f3074a;
    public List<VideoDetailFragment> al;
    public int am;
    public String an;
    public boolean ao;
    private VideoListsAdapter ap;
    private ReactionHeaderTouchDelegateView aq;
    private ReactionHeaderViewWithTouchDelegate ar;
    public View as;
    public PagesSurfaceFragment at;
    public int au;
    private int av;
    private int aw = -1;
    public boolean ay = false;
    public int az = -1;
    @Inject
    public AbstractFbErrorReporter f3075b;
    @Inject
    public GraphQLQueryExecutor f3076c;
    @Inject
    public ScreenUtil f3077d;
    private FrameLayout f3078e;
    public ListView f3079f;
    private ProgressBar f3080g;
    public LayoutInflater f3081h;
    public long f3082i;

    /* compiled from: profile/{%s}/info/inner */
    class C04221 implements OnScrollListener {
        final /* synthetic */ VideoTabAllVideosOptimizedFetchingFragment f3070a;

        C04221(VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment) {
            this.f3070a = videoTabAllVideosOptimizedFetchingFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int count = this.f3070a.f3079f.getAdapter() != null ? this.f3070a.f3079f.getAdapter().getCount() : 0;
            if (!(this.f3070a.ay && this.f3070a.az == count)) {
                Pair a = PagesScrollUtils.a(this.f3070a.as, this.f3070a.f3079f, i, VideoTabAllVideosOptimizedFetchingFragment.ax, this.f3070a.f3077d.d());
                this.f3070a.ay = ((Boolean) a.a).booleanValue();
                if (this.f3070a.ay) {
                    this.f3070a.E_(((Integer) a.b).intValue());
                    this.f3070a.az = count;
                }
            }
            int top = this.f3070a.f3079f.getChildAt(0).getTop();
            if (this.f3070a.at != null && this.f3070a.f3079f != null && this.f3070a.au != top && this.f3070a.D()) {
                this.f3070a.at.m5039a(this.f3070a.f3079f, i);
                this.f3070a.au = top;
            }
        }
    }

    /* compiled from: profile/{%s}/info/inner */
    class C04232 implements Callable<ListenableFuture<GraphQLResult<VideosUploadedByUserDetailQueryModel>>> {
        final /* synthetic */ VideoTabAllVideosOptimizedFetchingFragment f3071a;

        C04232(VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment) {
            this.f3071a = videoTabAllVideosOptimizedFetchingFragment;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f3071a.f3076c;
            VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment = this.f3071a;
            VideosUploadedByUserDetailQueryString a = VideosUploadedByUserGraphQL.a();
            a.a("node_id", Long.toString(videoTabAllVideosOptimizedFetchingFragment.f3082i)).a("media_type", MediaTypeInputMimeType.IMAGEWEBP).a("count", Integer.valueOf(9));
            if (videoTabAllVideosOptimizedFetchingFragment.an != null) {
                a.a("after", videoTabAllVideosOptimizedFetchingFragment.an);
            }
            return graphQLQueryExecutor.a(GraphQLRequest.a(a));
        }
    }

    /* compiled from: profile/{%s}/info/inner */
    class C04243 extends AbstractDisposableFutureCallback<GraphQLResult<VideosUploadedByUserDetailQueryModel>> {
        final /* synthetic */ VideoTabAllVideosOptimizedFetchingFragment f3072a;

        C04243(VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment) {
            this.f3072a = videoTabAllVideosOptimizedFetchingFragment;
        }

        protected final void m4128a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k() != null && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j() != null && !((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j().isEmpty() && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j().get(0) != null && ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().a() > 0) {
                this.f3072a.am = ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().a();
                UploadedVideosModel k = ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k();
                VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment = this.f3072a;
                if (k.k() != null) {
                    videoTabAllVideosOptimizedFetchingFragment.an = k.k().a();
                    videoTabAllVideosOptimizedFetchingFragment.ao = k.k().b();
                }
                VideoTabAllVideosOptimizedFetchingFragment.m4136b(this.f3072a, k);
            }
        }

        protected final void m4129a(Throwable th) {
            this.f3072a.f3075b.a("VideoTabAllVideosOptimizedFetchingFragment", th);
        }
    }

    /* compiled from: profile/{%s}/info/inner */
    enum Tasks {
        FETCH_ALL_VIDEOS
    }

    /* compiled from: profile/{%s}/info/inner */
    class VideoListsAdapter extends FbBaseAdapter {
        final /* synthetic */ VideoTabAllVideosOptimizedFetchingFragment f3073a;

        public VideoListsAdapter(VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment) {
            this.f3073a = videoTabAllVideosOptimizedFetchingFragment;
        }

        public /* synthetic */ Object getItem(int i) {
            return m4130a(i);
        }

        public int getCount() {
            return this.f3073a.al.size() + 1;
        }

        private VideoDetailFragmentModel m4130a(int i) {
            if (i >= this.f3073a.al.size() + 1 || i <= 0) {
                return null;
            }
            return (VideoDetailFragmentModel) this.f3073a.al.get(i - 1);
        }

        public long getItemId(int i) {
            if (i < this.f3073a.al.size() + 1) {
                return (long) i;
            }
            return Long.MIN_VALUE;
        }

        public final View m4131a(int i, ViewGroup viewGroup) {
            View inflate;
            int i2 = 0;
            Resources jW_ = this.f3073a.jW_();
            int dimensionPixelSize = jW_.getDimensionPixelSize(2131427416);
            if (i == ViewType.VIDEOS_HEADER.ordinal()) {
                inflate = this.f3073a.f3081h.inflate(2130907735, viewGroup, false);
                i2 = jW_.getDimensionPixelSize(2131427416);
            } else {
                inflate = new PageVideoListItem(this.f3073a.getContext());
            }
            inflate.setBackgroundResource(2131361864);
            inflate.setPadding(dimensionPixelSize, i2, dimensionPixelSize, i2);
            return inflate;
        }

        public final void m4132a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
            Resources jW_ = this.f3073a.jW_();
            if (i2 == ViewType.VIDEOS_HEADER.ordinal()) {
                BadgeTextView badgeTextView = (BadgeTextView) view;
                badgeTextView.setText(jW_.getString(2131235507));
                int i3 = this.f3073a.am;
                Object[] objArr = new Object[1];
                objArr[0] = StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(this.f3073a.am)});
                badgeTextView.setBadgeText(jW_.getQuantityString(2131689620, i3, objArr));
            } else if (i2 == ViewType.VIDEO_ITEM.ordinal()) {
                VideoDetailFragmentModel videoDetailFragmentModel = (VideoDetailFragmentModel) obj;
                if (videoDetailFragmentModel == m4130a(getCount() - 1)) {
                    VideoTabAllVideosOptimizedFetchingFragment.m4134a(this.f3073a, false);
                }
                ((PageVideoListItem) view).m4214a(videoDetailFragmentModel);
            }
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return ViewType.VIDEOS_HEADER.ordinal();
            }
            return ViewType.VIDEO_ITEM.ordinal();
        }

        public int getViewTypeCount() {
            return ViewType.values().length;
        }
    }

    /* compiled from: profile/{%s}/info/inner */
    public enum ViewType {
        VIDEOS_HEADER,
        VIDEO_ITEM
    }

    public static void m4135a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment = (VideoTabAllVideosOptimizedFetchingFragment) obj;
        TasksManager b = TasksManager.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        ScreenUtil a2 = ScreenUtil.a(fbInjector);
        videoTabAllVideosOptimizedFetchingFragment.f3074a = b;
        videoTabAllVideosOptimizedFetchingFragment.f3075b = abstractFbErrorReporter;
        videoTabAllVideosOptimizedFetchingFragment.f3076c = a;
        videoTabAllVideosOptimizedFetchingFragment.f3077d = a2;
    }

    public final void m4147j() {
    }

    private void m4137e() {
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

    public final void m4143a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.at = pagesSurfaceFragment;
    }

    public final void m4144a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.ar = reactionHeaderViewWithTouchDelegate;
        m4137e();
    }

    public final void D_(int i) {
        this.av = i;
        if (this.f3079f != null) {
            this.f3079f.setSelectionFromTop(0, i);
        }
    }

    public final void E_(int i) {
        if (this.aw < 0 || i <= this.aw) {
            this.aw = i;
            if (this.as != null) {
                this.as.setLayoutParams(new LayoutParams(-1, this.aw));
            }
        }
    }

    public final void m4142a(C05581 c05581) {
    }

    public static VideoTabAllVideosOptimizedFetchingFragment m4133a(long j, boolean z) {
        Preconditions.checkArgument(j != 0);
        Preconditions.checkState(z);
        VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment = new VideoTabAllVideosOptimizedFetchingFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("page_id", j);
        videoTabAllVideosOptimizedFetchingFragment.g(bundle);
        return videoTabAllVideosOptimizedFetchingFragment;
    }

    public final void m4145c(Bundle bundle) {
        boolean z;
        super.c(bundle);
        Class cls = VideoTabAllVideosOptimizedFetchingFragment.class;
        m4135a((Object) this, getContext());
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
        this.f3082i = this.s.getLong("page_id");
        this.al = Lists.a();
        this.ao = true;
    }

    public final View m4140a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1550879007);
        this.f3081h = layoutInflater;
        this.f3080g = (ProgressBar) layoutInflater.inflate(2130907681, viewGroup, false);
        this.f3080g.setLayoutParams(new LayoutParams(-1, -2));
        View inflate = layoutInflater.inflate(2130906131, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1157682580, a);
        return inflate;
    }

    public final void m4141a(View view, Bundle bundle) {
        Resources resources = view.getResources();
        this.f3078e = (FrameLayout) view.findViewById(2131565751);
        this.f3079f = (ListView) view.findViewById(2131565752);
        this.f3079f.addFooterView(this.f3080g);
        this.ap = new VideoListsAdapter(this);
        m4137e();
        if (this.aq != null) {
            this.f3079f.addHeaderView(this.aq);
        }
        this.f3079f.setVerticalScrollBarEnabled(false);
        this.f3079f.setPadding(0, 0, 0, 0);
        this.f3078e.removeView(view.findViewById(2131565753));
        this.f3079f.setDivider(resources.getDrawable(2131361871));
        this.f3079f.setDividerHeight(resources.getDimensionPixelSize(2131427418));
        this.as = new View(getContext());
        E_(this.aw);
        this.f3079f.addFooterView(this.as);
        this.f3079f.setAdapter(this.ap);
        this.f3079f.setOnScrollListener(new C04221(this));
        D_(this.av);
    }

    public final void m4146d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 863586429);
        super.d(bundle);
        if (this.al.isEmpty()) {
            m4134a(this, true);
        } else {
            ar();
        }
        LogUtils.f(-1168943982, a);
    }

    public final void m4138G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -422694714);
        super.G();
        m4134a(this, this.al.isEmpty());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1975426450, a);
    }

    public final void m4139H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1356333379);
        super.H();
        this.f3074a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 985210371, a);
    }

    public static void m4134a(VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment, boolean z) {
        if (z || videoTabAllVideosOptimizedFetchingFragment.ao) {
            if (z) {
                videoTabAllVideosOptimizedFetchingFragment.ao = true;
                videoTabAllVideosOptimizedFetchingFragment.an = null;
                videoTabAllVideosOptimizedFetchingFragment.al.clear();
            }
            videoTabAllVideosOptimizedFetchingFragment.f3074a.a(Tasks.FETCH_ALL_VIDEOS, new C04232(videoTabAllVideosOptimizedFetchingFragment), new C04243(videoTabAllVideosOptimizedFetchingFragment));
        } else if (videoTabAllVideosOptimizedFetchingFragment.f3079f.getFooterViewsCount() > 0) {
            videoTabAllVideosOptimizedFetchingFragment.f3079f.removeFooterView(videoTabAllVideosOptimizedFetchingFragment.f3080g);
        }
    }

    public static void m4136b(VideoTabAllVideosOptimizedFetchingFragment videoTabAllVideosOptimizedFetchingFragment, UploadedVideosModel uploadedVideosModel) {
        ImmutableList j = uploadedVideosModel.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            videoTabAllVideosOptimizedFetchingFragment.al.add((VideoDetailFragmentModel) j.get(i));
        }
        videoTabAllVideosOptimizedFetchingFragment.ar();
    }

    private void ar() {
        AdapterDetour.a(this.ap, -1304685962);
    }
}
