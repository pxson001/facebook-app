package com.facebook.reviews.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import android.widget.ListView;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.binder.ReviewFeedOverallRatingBinder;
import com.facebook.reviews.environment.ReviewsFeedEnvironment;
import com.facebook.reviews.environment.ReviewsFeedEnvironmentProvider;
import com.facebook.reviews.feed.ReviewsFeedInlineReviewController;
import com.facebook.reviews.feed.ReviewsFeedInlineReviewController.C23051;
import com.facebook.reviews.feed.ReviewsFeedListType;
import com.facebook.reviews.feed.ReviewsFeedLoader;
import com.facebook.reviews.feed.ReviewsFeedStoryMenuHelperProvider;
import com.facebook.reviews.feed.ReviewsFeedSubscriber;
import com.facebook.reviews.feed.ReviewsItemCollection;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel.HistogramModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedHeaderModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel.ReviewFeedStoriesModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel.ReviewFeedStoriesModel.EdgesModel;
import com.facebook.reviews.ui.PageReviewsFeedFragment;
import com.facebook.reviews.ui.ReviewFeedOverallRatingView;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UNIT_ID_TAG must be present */
public class ReviewStoriesFeedController {
    private final ReviewsFeedEnvironmentProvider f21494a;
    private final MultiRowAdapterBuilder f21495b;
    private final Lazy<NewsFeedRootGroupPartDefinition> f21496c;
    private final MultipleRowsStoriesRecycleCallback f21497d;
    public final ReviewsFeedSubscriber f21498e;
    public final ReviewsFeedLoader f21499f;
    public final ReviewsLogger f21500g;
    private final ReviewsItemCollection f21501h;
    public final Toaster f21502i;
    private ReviewsFeedEnvironment f21503j;
    public boolean f21504k;
    public PageReviewsFeedFragment f21505l;
    public MultiRowAdapter f21506m;
    private boolean f21507n;
    private boolean f21508o;
    public Optional<String> f21509p = Absent.INSTANCE;
    private ReviewsFeedHeaderModel f21510q;
    private PageOverallStarRatingModel f21511r;
    private DefaultTextWithEntitiesLongFields f21512s;
    public String f21513t;

    /* compiled from: UNIT_ID_TAG must be present */
    class C22981 implements Runnable {
        final /* synthetic */ ReviewStoriesFeedController f21491a;

        C22981(ReviewStoriesFeedController reviewStoriesFeedController) {
            this.f21491a = reviewStoriesFeedController;
        }

        public void run() {
            this.f21491a.f21506m.notifyDataSetChanged();
        }
    }

    /* compiled from: UNIT_ID_TAG must be present */
    class C22992 implements RecyclerListener {
        final /* synthetic */ ReviewStoriesFeedController f21492a;

        C22992(ReviewStoriesFeedController reviewStoriesFeedController) {
            this.f21492a = reviewStoriesFeedController;
        }

        public void onMovedToScrapHeap(View view) {
            MultipleRowsStoriesRecycleCallback.a(view);
        }
    }

    /* compiled from: UNIT_ID_TAG must be present */
    class C23003 extends OnRefreshListener {
        final /* synthetic */ ReviewStoriesFeedController f21493a;

        C23003(ReviewStoriesFeedController reviewStoriesFeedController) {
            this.f21493a = reviewStoriesFeedController;
        }

        public final void m25079b(boolean z) {
            if (z) {
                this.f21493a.m25086f();
            }
        }
    }

    public static ReviewStoriesFeedController m25081b(InjectorLike injectorLike) {
        return new ReviewStoriesFeedController((ReviewsFeedEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReviewsFeedEnvironmentProvider.class), MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 1480), MultipleRowsStoriesRecycleCallback.a(injectorLike), ReviewsFeedSubscriber.m25148b(injectorLike), ReviewsFeedLoader.m25123b(injectorLike), ReviewsLogger.a(injectorLike), new ReviewsItemCollection((Clock) SystemClockMethodAutoProvider.a(injectorLike)), Toaster.b(injectorLike));
    }

    @Inject
    public ReviewStoriesFeedController(ReviewsFeedEnvironmentProvider reviewsFeedEnvironmentProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<NewsFeedRootGroupPartDefinition> lazy, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, ReviewsFeedSubscriber reviewsFeedSubscriber, ReviewsFeedLoader reviewsFeedLoader, ReviewsLogger reviewsLogger, ReviewsItemCollection reviewsItemCollection, Toaster toaster) {
        this.f21494a = reviewsFeedEnvironmentProvider;
        this.f21495b = multiRowAdapterBuilder;
        this.f21496c = lazy;
        this.f21497d = multipleRowsStoriesRecycleCallback;
        this.f21498e = reviewsFeedSubscriber;
        this.f21499f = reviewsFeedLoader;
        this.f21500g = reviewsLogger;
        this.f21501h = reviewsItemCollection;
        this.f21502i = toaster;
    }

    public final void m25085a(@Nullable ReviewFeedStoriesModel reviewFeedStoriesModel) {
        this.f21504k = false;
        this.f21500g.b(this.f21513t);
        if (reviewFeedStoriesModel != null) {
            ReviewsItemCollection reviewsItemCollection = this.f21501h;
            long a = reviewsItemCollection.f21606a.a();
            ImmutableList a2 = reviewFeedStoriesModel.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                GraphQLStory a3 = ((EdgesModel) a2.get(i)).a();
                if (!(a3 == null || a3.c() == null)) {
                    Builder a4 = Builder.a(a3);
                    a4.F = a;
                    a3 = a4.a();
                    reviewsItemCollection.f21607b.add(a3);
                    reviewsItemCollection.f21608c.put(a3.c(), Integer.valueOf(reviewsItemCollection.f21607b.size() - 1));
                }
            }
            this.f21506m.notifyDataSetChanged();
            this.f21498e.m25149a(reviewFeedStoriesModel, this.f21503j, this.f21501h);
            if (reviewFeedStoriesModel.b() == null || !reviewFeedStoriesModel.b().b()) {
                this.f21509p = Absent.INSTANCE;
            } else {
                this.f21509p = Optional.fromNullable(reviewFeedStoriesModel.b().a());
            }
        }
        this.f21505l.ay();
    }

    public final void m25084a(@Nullable ReviewsFeedHeaderModel reviewsFeedHeaderModel, boolean z) {
        DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields = null;
        this.f21500g.d(this.f21513t);
        this.f21510q = reviewsFeedHeaderModel;
        this.f21511r = reviewsFeedHeaderModel == null ? null : reviewsFeedHeaderModel.b();
        if (reviewsFeedHeaderModel != null) {
            defaultTextWithEntitiesLongFields = reviewsFeedHeaderModel.c();
        }
        this.f21512s = defaultTextWithEntitiesLongFields;
        m25080a(this.f21511r, this.f21512s);
        this.f21507n = reviewsFeedHeaderModel.a();
        if (this.f21508o && this.f21507n && reviewsFeedHeaderModel.d() == null) {
            PageReviewsFeedFragment pageReviewsFeedFragment = this.f21505l;
            pageReviewsFeedFragment.at.removeAllViews();
            ReviewsFeedInlineReviewController reviewsFeedInlineReviewController = pageReviewsFeedFragment.f21746d;
            ViewGroup viewGroup = pageReviewsFeedFragment.at;
            ImageBlockLayout imageBlockLayout = (ImageBlockLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130906849, viewGroup, false);
            imageBlockLayout.setThumbnailUri(((User) reviewsFeedInlineReviewController.f21554a.get()).x());
            ImageBlockLayout imageBlockLayout2 = imageBlockLayout;
            imageBlockLayout2.setOnClickListener(new C23051(pageReviewsFeedFragment.f21746d, pageReviewsFeedFragment.f21751i, pageReviewsFeedFragment.o(), pageReviewsFeedFragment.al));
            pageReviewsFeedFragment.at.addView(imageBlockLayout2);
        }
        this.f21505l.au();
        this.f21505l.ax();
        if (z) {
            this.f21504k = false;
            this.f21505l.ay();
            return;
        }
        this.f21501h.f21607b.clear();
        this.f21506m.notifyDataSetChanged();
        this.f21499f.m25124a(this.f21513t, 10, this, null);
    }

    public final void m25082a(double d, int i, ImmutableList<HistogramModel> immutableList) {
        PageOverallStarRatingModel a = PageOverallStarRatingModel.a(this.f21511r);
        PageOverallStarRatingModel.Builder builder = new PageOverallStarRatingModel.Builder();
        if (a != null) {
            PageOverallStarRatingModel.Builder builder2 = new PageOverallStarRatingModel.Builder();
            builder2.a = a.a();
            builder2.b = a.b();
            builder2.c = a.c();
            builder2.d = a.d();
            builder = builder2;
        } else {
            builder.c = 5;
            builder = builder;
        }
        builder.d = d;
        builder = builder;
        builder.b = i;
        builder = builder;
        builder.a = immutableList;
        this.f21511r = builder.a();
        m25080a(this.f21511r, this.f21512s);
    }

    public final void m25083a(ListView listView, String str, boolean z, PageReviewsFeedFragment pageReviewsFeedFragment) {
        this.f21513t = str;
        this.f21508o = z;
        this.f21505l = pageReviewsFeedFragment;
        ReviewsFeedEnvironmentProvider reviewsFeedEnvironmentProvider = this.f21494a;
        this.f21503j = new ReviewsFeedEnvironment((ReviewsFeedStoryMenuHelperProvider) reviewsFeedEnvironmentProvider.getOnDemandAssistedProviderForStaticDi(ReviewsFeedStoryMenuHelperProvider.class), listView.getContext(), ReviewsFeedListType.f21557a, new C22981(this), this);
        MultiRowAdapterBuilder.Builder a = this.f21495b.a(this.f21496c, this.f21501h);
        a.f = this.f21503j;
        this.f21506m = a.e();
        listView.setAdapter(this.f21506m);
        listView.setRecyclerListener(new C22992(this));
        this.f21498e.m25150a(this.f21513t, this.f21503j, this.f21501h, this);
        this.f21505l.mo1184a(new C23003(this));
        if (this.f21510q != null) {
            m25084a(this.f21510q, true);
        } else {
            m25086f();
        }
    }

    public final void m25086f() {
        this.f21504k = true;
        m25087g();
        this.f21505l.at();
        this.f21499f.f21567b.c();
        this.f21499f.m25125a(this.f21513t, this);
    }

    public final void m25087g() {
        this.f21505l.at.removeAllViews();
    }

    private void m25080a(PageOverallStarRatingModel pageOverallStarRatingModel, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (pageOverallStarRatingModel == null) {
            this.f21505l.aw().setVisibility(8);
            return;
        }
        this.f21505l.aw().setVisibility(0);
        ReviewFeedOverallRatingView aw = this.f21505l.aw();
        String str = this.f21513t;
        if (defaultTextWithEntitiesLongFields == null || Strings.isNullOrEmpty(defaultTextWithEntitiesLongFields.a())) {
            ReviewFeedOverallRatingBinder.m25031b(aw, pageOverallStarRatingModel);
            aw.m25262a(pageOverallStarRatingModel.d(), pageOverallStarRatingModel.b());
        } else {
            ReviewFeedOverallRatingBinder.m25031b(aw, pageOverallStarRatingModel);
            aw.m25264a(defaultTextWithEntitiesLongFields, "reviews_feed", str);
        }
    }
}
