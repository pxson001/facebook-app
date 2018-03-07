package com.facebook.search.widget.resultspage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.impl.HasPositionInformationImpl;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.loadingindicator.LoadingIndicatorManager;
import com.facebook.feedplugins.loadingindicator.LoadingStory.Type;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.FilterType;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.SearchPivotsModel.NodesModel;
import com.facebook.search.results.model.SearchResultsNewsTitle;
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsContextTitlePartDefinition;
import com.facebook.search.util.toast.SearchResultsSizeUtil;
import com.facebook.search.widget.endofresultsmarker.EndOfResultsMarkerView;
import com.facebook.search.widget.resultspage.SearchResultsPage.LoadingIndicatorType;
import com.facebook.search.widget.resultspage.SearchResultsPage.NearEndOfResultsListener;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: user_favorite */
public class SearchResultsPageView extends CustomFrameLayout implements SearchResultsPage {
    private static final StylingData f724s = new StylingData(null, PaddingStyle.a, Position.BOTTOM);
    public NearEndOfResultsListener f725A;
    public int f726B;
    private OnScrollListener f727C;
    public SearchPivotClickListener f728D;
    public FilterButtonClickListener f729E;
    private LoadingIndicatorType f730F;
    public RetryClickedListener f731G;
    public int f732H;
    private int f733I;
    public boolean f734J;
    @Inject
    Lazy<LoadingIndicatorManager> f735a;
    @Inject
    SearchResultsNewsContextTitlePartDefinition f736b;
    @Inject
    BackgroundPartDefinition f737c;
    @Inject
    SearchResultsSizeUtil f738d;
    @Inject
    GatekeeperStoreImpl f739e;
    @Inject
    Provider<MultipleRowsStoriesRecycleCallback> f740f;
    @Inject
    GlyphColorizer f741g;
    protected LoadingIndicatorView f742h;
    protected LinearLayout f743i;
    protected TextView f744j;
    public ScrollingViewProxy f745k;
    protected ViewGroup f746l;
    protected LoadingIndicatorView f747m;
    protected EndOfResultsMarkerView f748n;
    public ContentView f749o;
    public FbSwipeRefreshLayout f750p;
    public LazyView<CustomLinearLayout> f751q;
    public State f752r;
    private String f753t;
    private SimpleRenderer<SearchResultsNewsTitle, HasPositionInformation, BetterTextView> f754u;
    private SimpleRenderer<StylingData, HasPositionInformation, View> f755v;
    private SearchResultsNewsTitle f756w;
    @Nullable
    private String f757x;
    private float f758y;
    private boolean f759z;

    /* compiled from: user_favorite */
    class C00641 implements OnInflateRunner<CustomLinearLayout> {
        final /* synthetic */ SearchResultsPageView f717a;

        /* compiled from: user_favorite */
        class C00631 implements OnClickListener {
            final /* synthetic */ C00641 f716a;

            C00631(C00641 c00641) {
                this.f716a = c00641;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -111078044);
                if (this.f716a.f717a.f729E != null) {
                    this.f716a.f717a.f729E.kP_();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1668572565, a);
            }
        }

        C00641(SearchResultsPageView searchResultsPageView) {
            this.f717a = searchResultsPageView;
        }

        public final void m798a(View view) {
            ((CustomLinearLayout) view).setOnClickListener(new C00631(this));
        }
    }

    /* compiled from: user_favorite */
    public class C00652 implements OnClickListener {
        final /* synthetic */ SearchPivotsModel f718a;
        final /* synthetic */ SearchResultsPageView f719b;

        public C00652(SearchResultsPageView searchResultsPageView, SearchPivotsModel searchPivotsModel) {
            this.f719b = searchResultsPageView;
            this.f718a = searchPivotsModel;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -802242937);
            if (this.f719b.f728D != null) {
                this.f719b.f728D.a(((NodesModel) this.f718a.a().get(0)).a(), ((NodesModel) this.f718a.a().get(0)).b().a());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -217266124, a);
        }
    }

    /* compiled from: user_favorite */
    class C00663 implements OnScrollListener {
        final /* synthetic */ SearchResultsPageView f720a;

        C00663(SearchResultsPageView searchResultsPageView) {
            this.f720a = searchResultsPageView;
        }

        public final void m799a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m800a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            ListAdapter o = scrollingViewProxy.o();
            if (o != null) {
                int i4 = i + i2;
                if ((o instanceof MultiRowAdapter ? ((MultiRowAdapter) o).t_(i4) : i4) >= o.getCount() - this.f720a.f726B) {
                    this.f720a.f725A.a();
                }
            }
        }
    }

    /* compiled from: user_favorite */
    final class C00674 extends BaseAnimationListener {
        final /* synthetic */ View f721a;

        C00674(View view) {
            this.f721a = view;
        }

        public final void onAnimationEnd(Animation animation) {
            this.f721a.setVisibility(8);
        }
    }

    /* compiled from: user_favorite */
    /* synthetic */ class C00685 {
        static final /* synthetic */ int[] f723b = new int[FilterType.values().length];

        static {
            try {
                f723b[FilterType.People.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f723b[FilterType.Page.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f723b[FilterType.Group.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f723b[FilterType.Event.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f723b[FilterType.Photos.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f723b[FilterType.Places.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f723b[FilterType.App.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            f722a = new int[State.values().length];
            try {
                f722a[State.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f722a[State.LOADING_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f722a[State.LOADING_FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f722a[State.LOADING_FINISHED_NO_RESULTS.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f722a[State.EMPTY.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f722a[State.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f722a[State.ERROR_LOADING_MORE.ordinal()] = 7;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f722a[State.REQUEST_TIMED_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private static <T extends View> void m807a(Class<T> cls, T t) {
        m808a((Object) t, t.getContext());
    }

    private static void m808a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SearchResultsPageView) obj).m805a(IdBasedLazy.a(fbInjector, 6369), SearchResultsNewsContextTitlePartDefinition.a(fbInjector), BackgroundPartDefinition.a(fbInjector), SearchResultsSizeUtil.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 1489), GlyphColorizer.a(fbInjector));
    }

    public SearchResultsPageView(Context context) {
        super(context);
        m806a(FilterType.Search, LoadingIndicatorType.SPINNING_WHEEL);
    }

    public SearchResultsPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m806a(FilterType.Search, LoadingIndicatorType.SPINNING_WHEEL);
    }

    public SearchResultsPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m806a(FilterType.Search, LoadingIndicatorType.SPINNING_WHEEL);
    }

    public SearchResultsPageView(Context context, FilterType filterType) {
        super(context);
        m806a(filterType, LoadingIndicatorType.SPINNING_WHEEL);
    }

    public SearchResultsPageView(Context context, FilterType filterType, LoadingIndicatorType loadingIndicatorType) {
        super(context);
        m806a(filterType, loadingIndicatorType);
    }

    protected void setLayout(boolean z) {
        setContentView(z ? 2130907010 : 2130907014);
    }

    private void m806a(FilterType filterType, LoadingIndicatorType loadingIndicatorType) {
        ScrollingViewProxy recyclerViewProxy;
        m807a(SearchResultsPageView.class, (View) this);
        boolean a = this.f739e.a(SearchAbTestGatekeepers.v, false);
        this.f758y = this.f738d.e();
        this.f754u = new SimpleRenderer(this.f736b, new HasPositionInformationImpl());
        this.f755v = new SimpleRenderer(this.f737c, new HasPositionInformationImpl());
        this.f759z = true;
        this.f730F = loadingIndicatorType;
        setLayout(a);
        this.f742h = (LoadingIndicatorView) c(2131567288);
        this.f743i = (LinearLayout) c(2131560287);
        this.f750p = (FbSwipeRefreshLayout) c(2131561342);
        this.f750p.setEnabled(false);
        if (a) {
            recyclerViewProxy = new RecyclerViewProxy(getRecyclerView());
        } else {
            recyclerViewProxy = new ListViewProxy((BetterListView) c(2131559373));
        }
        this.f745k = recyclerViewProxy;
        this.f749o = (ContentView) c(2131567289);
        this.f751q = new LazyView((ViewStub) c(2131567290), new C00641(this));
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(filterType == FilterType.VideosBlended ? 2131363393 : 2131361864)));
        this.f747m = new LoadingIndicatorView(getContext());
        this.f733I = getResources().getDimensionPixelSize(2131431806);
        this.f747m.a(this.f733I, this.f733I);
        this.f748n = new EndOfResultsMarkerView(getContext());
        this.f745k.e(this.f747m);
        this.f745k.e(this.f748n);
        this.f744j = (TextView) c(2131563455);
        this.f753t = getResources().getString(2131237647);
        this.f732H = 0;
        this.f734J = true;
        setFilterType(filterType);
        setState(State.LOADING);
    }

    private BetterRecyclerView getRecyclerView() {
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) c(2131559373);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        return betterRecyclerView;
    }

    public final void m820a(View view) {
        this.f745k.d(view);
    }

    public final void m823b(View view) {
        this.f743i.addView(view, 0);
    }

    public final void m821a(SearchResultsNewsTitle searchResultsNewsTitle, String str) {
        this.f756w = searchResultsNewsTitle;
        this.f757x = str;
        this.f759z = true;
        if (this.f752r == State.LOADING) {
            m812b();
        }
    }

    public final void m819a() {
        if (this.f749o.getVisibility() != 0) {
            Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 48.0f, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            ((CustomLinearLayout) this.f751q.a()).setVisibility(0);
            ((CustomLinearLayout) this.f751q.a()).startAnimation(translateAnimation);
        }
    }

    public FbSwipeRefreshLayout getSwipeLayout() {
        return this.f750p;
    }

    public void setState(State state) {
        if (this.f752r != state) {
            this.f752r = state;
            m812b();
        }
    }

    private void m812b() {
        if (this.f759z) {
            m816e();
            this.f759z = false;
        }
        switch (this.f752r) {
            case LOADING:
                if (this.f746l != null) {
                    this.f742h.setVisibility(8);
                    m803a(this.f746l, 0);
                } else {
                    this.f742h.setVisibility(0);
                    m803a(this.f746l, 8);
                }
                this.f742h.a();
                this.f743i.setVisibility(8);
                this.f745k.a(8);
                this.f748n.m797b();
                this.f747m.b();
                return;
            case LOADING_MORE:
                this.f742h.b();
                m818g();
                this.f748n.m797b();
                this.f747m.a();
                return;
            case LOADING_FINISHED:
                m817f();
                this.f748n.f715a.setVisibility(0);
                return;
            case LOADING_FINISHED_NO_RESULTS:
                m817f();
                this.f748n.m797b();
                return;
            case EMPTY:
                m803a(this.f746l, 8);
                this.f742h.b();
                this.f742h.setVisibility(8);
                this.f745k.a(8);
                this.f743i.setVisibility(0);
                this.f750p.setRefreshing(false);
                requestLayout();
                return;
            case ERROR:
                m803a(this.f746l, 8);
                this.f742h.setVisibility(0);
                this.f742h.a(this.f753t, this.f731G);
                this.f743i.setVisibility(8);
                this.f745k.a(8);
                this.f750p.setRefreshing(false);
                return;
            case ERROR_LOADING_MORE:
                m809a(this.f753t);
                this.f750p.setRefreshing(false);
                return;
            case REQUEST_TIMED_OUT:
                m809a(getResources().getString(2131237656));
                this.f750p.setRefreshing(false);
                return;
            default:
                throw new IllegalStateException("Unimplemented state");
        }
    }

    private void m816e() {
        boolean z = this.f756w != null;
        if (z || this.f730F == LoadingIndicatorType.GLOWING_STORIES) {
            if (this.f746l != null) {
                removeView(this.f746l);
            }
            LoadingIndicatorManager loadingIndicatorManager;
            ViewGroup a;
            if (z) {
                if (this.f757x != null) {
                    loadingIndicatorManager = (LoadingIndicatorManager) this.f735a.get();
                    float f = this.f758y;
                    a = LoadingIndicatorManager.a(LayoutInflater.from(getContext()), this);
                    View view = (FbDraweeView) LayoutInflater.from(getContext()).inflate(2130903813, a, false);
                    loadingIndicatorManager.f.a(Float.valueOf(f));
                    loadingIndicatorManager.f.a(view);
                    a.addView(view);
                    this.f746l = a;
                } else {
                    this.f746l = LoadingIndicatorManager.a(LayoutInflater.from(getContext()), this);
                }
                BetterTextView betterTextView = (BetterTextView) SearchResultsNewsContextTitlePartDefinition.a.a(getContext());
                this.f754u.a(this.f756w);
                this.f754u.a(betterTextView);
                this.f746l.addView(betterTextView);
                View inflate = LayoutInflater.from(getContext()).inflate(2130903798, this.f746l, false);
                this.f755v.a(f724s);
                this.f755v.a(inflate);
                this.f746l.addView(inflate);
                if (this.f730F == LoadingIndicatorType.GLOWING_STORIES) {
                    ((LoadingIndicatorManager) this.f735a.get()).a(Type.GLOWING, this.f746l, LoadingIndicatorManager.a(getResources()) - 1);
                } else {
                    LoadingIndicatorView loadingIndicatorView = new LoadingIndicatorView(getContext());
                    loadingIndicatorView.a(this.f733I, this.f733I);
                    loadingIndicatorView.a();
                    this.f746l.addView(loadingIndicatorView);
                }
                addView(this.f746l);
                return;
            }
            loadingIndicatorManager = (LoadingIndicatorManager) this.f735a.get();
            Type type = Type.GLOWING;
            Resources resources = getResources();
            a = LoadingIndicatorManager.a(LayoutInflater.from(getContext()), this);
            loadingIndicatorManager.a(type, a, LoadingIndicatorManager.a(resources));
            this.f746l = a;
            addView(this.f746l);
        }
    }

    private void m809a(String str) {
        m803a(this.f746l, 8);
        this.f742h.setVisibility(8);
        this.f743i.setVisibility(8);
        this.f745k.a(0);
        this.f748n.m797b();
        this.f747m.a(str, this.f731G);
    }

    public void setResultPageFadeTransitionDuration(int i) {
        this.f732H = i;
    }

    public void setIsInitialLoad(boolean z) {
        this.f734J = z;
    }

    private static void m803a(@Nullable View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setNearEndOfResultsListener(@Nullable NearEndOfResultsListener nearEndOfResultsListener) {
        m822a(nearEndOfResultsListener, 3);
    }

    public final void m822a(@Nullable NearEndOfResultsListener nearEndOfResultsListener, int i) {
        if (this.f727C != null) {
            this.f745k.c(this.f727C);
        }
        this.f725A = nearEndOfResultsListener;
        this.f726B = i;
        if (this.f725A != null) {
            this.f727C = new C00663(this);
            this.f745k.b(this.f727C);
        }
    }

    public void setSearchPivotClickListener(SearchPivotClickListener searchPivotClickListener) {
        this.f728D = searchPivotClickListener;
    }

    public void setFilterButtonClickListener(FilterButtonClickListener filterButtonClickListener) {
        this.f729E = filterButtonClickListener;
    }

    public State getState() {
        return this.f752r;
    }

    public ScrollingViewProxy getScrollingViewProxy() {
        return this.f745k;
    }

    public void setRetryClickedListener(RetryClickedListener retryClickedListener) {
        this.f731G = retryClickedListener;
    }

    protected void setFilterType(FilterType filterType) {
        Drawable a;
        Preconditions.checkNotNull(filterType);
        Drawable[] compoundDrawables = this.f744j.getCompoundDrawables();
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(2130773630, typedValue, true) && typedValue.type == 28) {
            a = this.f741g.a(m801a(filterType), typedValue.data);
        } else {
            a = getResources().getDrawable(m801a(filterType));
        }
        a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
        this.f744j.setCompoundDrawables(compoundDrawables[0], a, compoundDrawables[2], compoundDrawables[3]);
        if (filterType == FilterType.VideosBlended) {
            typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130773632, typedValue, true) && typedValue.type == 28) {
                this.f742h.l = this.f741g.a(getResources().getDrawable(2130840507), typedValue.data);
            }
        }
        this.f744j.setText(getResources().getString(m810b(filterType)));
    }

    private static int m801a(FilterType filterType) {
        switch (C00685.f723b[filterType.ordinal()]) {
            case 1:
                return 2130839467;
            case 2:
                return 2130839466;
            case 3:
                return 2130839465;
            case 4:
                return 2130839464;
            case 5:
                return 2130839468;
            case 6:
                return 2130839469;
            case 7:
                return 2130839463;
            default:
                return 2130839462;
        }
    }

    private static int m810b(FilterType filterType) {
        switch (C00685.f723b[filterType.ordinal()]) {
            case 1:
                return 2131237649;
            case 2:
                return 2131237652;
            case 3:
                return 2131237651;
            case 4:
                return 2131237650;
            case 5:
                return 2131237653;
            case 6:
                return 2131237654;
            case 7:
                return 2131237655;
            default:
                return 2131237648;
        }
    }

    private void m817f() {
        m818g();
        this.f742h.b();
        this.f747m.b();
        this.f750p.setRefreshing(false);
    }

    private void m818g() {
        if (this.f732H == 0 || !this.f734J) {
            m803a(this.f746l, 8);
            this.f742h.setVisibility(8);
            this.f743i.setVisibility(8);
            this.f745k.a(0);
        } else if (this.f746l == null) {
            this.f743i.setVisibility(8);
            m813b(this.f742h, (long) this.f732H);
            m804a(this.f745k.ix_(), (long) this.f732H);
        } else {
            this.f743i.setVisibility(8);
            this.f742h.setVisibility(8);
            m813b(this.f746l, (long) this.f732H);
            m804a(this.f745k.ix_(), (long) this.f732H);
        }
    }

    private static void m804a(View view, long j) {
        if (view.getVisibility() != 0 && !(view.getAnimation() instanceof AlphaAnimation)) {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(j);
            view.setVisibility(0);
            view.startAnimation(alphaAnimation);
        }
    }

    private static void m813b(View view, long j) {
        if (view.getVisibility() != 8 && !(view.getAnimation() instanceof AlphaAnimation)) {
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(j);
            alphaAnimation.setAnimationListener(new C00674(view));
            view.startAnimation(alphaAnimation);
        }
    }

    private void m805a(Lazy<LoadingIndicatorManager> lazy, SearchResultsNewsContextTitlePartDefinition searchResultsNewsContextTitlePartDefinition, BackgroundPartDefinition backgroundPartDefinition, SearchResultsSizeUtil searchResultsSizeUtil, GatekeeperStore gatekeeperStore, Provider<MultipleRowsStoriesRecycleCallback> provider, GlyphColorizer glyphColorizer) {
        this.f735a = lazy;
        this.f736b = searchResultsNewsContextTitlePartDefinition;
        this.f737c = backgroundPartDefinition;
        this.f738d = searchResultsSizeUtil;
        this.f739e = gatekeeperStore;
        this.f740f = provider;
        this.f741g = glyphColorizer;
    }
}
