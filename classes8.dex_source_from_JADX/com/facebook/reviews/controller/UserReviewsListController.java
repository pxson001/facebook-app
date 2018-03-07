package com.facebook.reviews.controller;

import android.content.res.Resources;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.adapter.PlacesToReviewSection;
import com.facebook.reviews.adapter.SingleReviewSection;
import com.facebook.reviews.adapter.UserReviewsListAdapter;
import com.facebook.reviews.adapter.UserReviewsListBaseSection.SectionChangedListener;
import com.facebook.reviews.adapter.UserReviewsSection;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.list.ReviewsListSectionFactory;
import com.facebook.reviews.list.ReviewsListSectionFactory.C23251;
import com.facebook.reviews.list.ReviewsListSectionFactory.C23262;
import com.facebook.reviews.list.ReviewsListSectionFactory.C23317;
import com.facebook.reviews.list.ReviewsListSectionFactory.C23328;
import com.facebook.reviews.list.ReviewsListSectionFactory.C23339;
import com.facebook.reviews.loader.UserReviewsListLoader;
import com.facebook.reviews.loader.UserReviewsListLoader.C23352;
import com.facebook.reviews.loader.UserReviewsListLoader.C23363;
import com.facebook.reviews.loader.UserReviewsListLoader.C23374;
import com.facebook.reviews.loader.UserReviewsListLoader.C23385;
import com.facebook.reviews.loader.UserReviewsListLoader.LoadUserReviewsCallback;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlacesToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel;
import com.facebook.reviews.ui.UserReviewsFragment;
import com.facebook.reviews.ui.UserReviewsFragment.C23441;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UNIT_ID */
public class UserReviewsListController implements LoadUserReviewsCallback, RetryClickedListener {
    public final FeedEventBus f21516a;
    public final Resources f21517b;
    public final ReviewEventBus f21518c;
    public final Provider<FbEventSubscriberListManager> f21519d;
    public final ReviewsListSectionFactory f21520e;
    public final Provider<String> f21521f;
    public final UserReviewsListLoader f21522g;
    private boolean f21523h;
    public boolean f21524i;
    public boolean f21525j;
    public PlacesToReviewSection f21526k;
    public Optional<String> f21527l;
    public String f21528m;
    public UserReviewsFragment f21529n;
    public FbEventSubscriberListManager f21530o;
    public FbEventSubscriberListManager f21531p;
    public SingleReviewSection f21532q;
    public UserReviewsListAdapter f21533r;
    public Optional<UserReviewsSection> f21534s;

    /* compiled from: UNIT_ID */
    public class C23011 implements OnScrollListener {
        final /* synthetic */ UserReviewsListController f21514a;

        public C23011(UserReviewsListController userReviewsListController) {
            this.f21514a = userReviewsListController;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 2 && !this.f21514a.f21524i && this.f21514a.f21534s.isPresent()) {
                ((UserReviewsSection) this.f21514a.f21534s.get()).f21378b.m24992b();
                UserReviewsListController.m25094j(this.f21514a);
            }
        }
    }

    /* compiled from: UNIT_ID */
    public class C23022 extends OnRefreshListener {
        final /* synthetic */ UserReviewsListController f21515a;

        public C23022(UserReviewsListController userReviewsListController) {
            this.f21515a = userReviewsListController;
        }

        public final void m25089b(boolean z) {
            if (z) {
                this.f21515a.m25100b();
            }
        }

        public final void m25088a() {
            this.f21515a.m25103f();
        }
    }

    public static UserReviewsListController m25092b(InjectorLike injectorLike) {
        return new UserReviewsListController(FeedEventBus.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ReviewEventBus.m4876a(injectorLike), IdBasedProvider.a(injectorLike, 973), ReviewsListSectionFactory.m25197a(injectorLike), IdBasedProvider.a(injectorLike, 4442), UserReviewsListLoader.m25210a(injectorLike));
    }

    @Inject
    public UserReviewsListController(FeedEventBus feedEventBus, Resources resources, ReviewEventBus reviewEventBus, Provider<FbEventSubscriberListManager> provider, ReviewsListSectionFactory reviewsListSectionFactory, Provider<String> provider2, UserReviewsListLoader userReviewsListLoader) {
        this.f21516a = feedEventBus;
        this.f21517b = resources;
        this.f21518c = reviewEventBus;
        this.f21519d = provider;
        this.f21520e = reviewsListSectionFactory;
        this.f21521f = provider2;
        this.f21522g = userReviewsListLoader;
    }

    public final void m25100b() {
        this.f21523h = false;
        this.f21524i = false;
        this.f21534s = Absent.INSTANCE;
        this.f21529n.m25284a(null);
        this.f21529n.aq();
        Object obj = this.f21533r;
        obj.f21371g.clear();
        AdapterDetour.a(obj, 1857121896);
        this.f21522g.m25214a();
        if (this.f21525j) {
            ReviewsListSectionFactory reviewsListSectionFactory = this.f21520e;
            SectionChangedListener sectionChangedListener = this.f21533r;
            FbEventSubscriberListManager fbEventSubscriberListManager = this.f21530o;
            SingleReviewSection singleReviewSection = (SingleReviewSection) reviewsListSectionFactory.f21683c.get();
            singleReviewSection.f21363d = sectionChangedListener;
            fbEventSubscriberListManager.a(new FbEventSubscriber[]{new C23251(reviewsListSectionFactory, singleReviewSection, sectionChangedListener), new C23262(reviewsListSectionFactory, singleReviewSection, sectionChangedListener)});
            this.f21532q = singleReviewSection;
            reviewsListSectionFactory = this.f21520e;
            SectionChangedListener sectionChangedListener2 = this.f21533r;
            FbEventSubscriberListManager fbEventSubscriberListManager2 = this.f21530o;
            PlacesToReviewSection placesToReviewSection = (PlacesToReviewSection) reviewsListSectionFactory.f21681a.get();
            placesToReviewSection.m24975a(null);
            placesToReviewSection.f21353a.f21374b = Optional.fromNullable(new C23317(reviewsListSectionFactory, this));
            fbEventSubscriberListManager2.a(new FbEventSubscriber[]{new C23328(reviewsListSectionFactory, placesToReviewSection, this, sectionChangedListener2), new C23339(reviewsListSectionFactory, placesToReviewSection, this, sectionChangedListener2)});
            placesToReviewSection.f21353a.m24991a(sectionChangedListener2);
            this.f21526k = placesToReviewSection;
            this.f21526k.f21358f = this.f21517b.getString(2131235350);
            this.f21526k.f21353a.m24992b();
            this.f21533r.m25003a(ImmutableList.of(this.f21532q, this.f21526k));
            this.f21530o.a(this.f21518c);
            if (this.f21527l.isPresent()) {
                this.f21522g.m25217a((String) this.f21527l.get(), this.f21528m, 10, this, this);
                return;
            } else {
                this.f21522g.m25215a(this.f21528m, 3, this);
                return;
            }
        }
        m25093h();
    }

    public final void m25098a(@Nullable PlacesToReviewModel placesToReviewModel) {
        this.f21526k.f21353a.m24993c();
        this.f21526k.m24975a(placesToReviewModel.a());
        this.f21529n.m25286e();
        AdapterDetour.a(this.f21533r, -1366079018);
        if (!this.f21523h) {
            m25093h();
        }
    }

    public final void m25101d() {
        this.f21526k.f21353a.m24993c();
        if (!this.f21523h) {
            m25093h();
        }
    }

    public final void mo1170a(UserReviewsModel userReviewsModel) {
        this.f21524i = false;
        if (this.f21534s.isPresent()) {
            UserReviewsSection userReviewsSection = (UserReviewsSection) this.f21534s.get();
            userReviewsSection.f21378b.m24993c();
            userReviewsSection.m25023a(userReviewsModel.a());
            if (!userReviewsSection.f21386j) {
                this.f21529n.m25284a(null);
            }
        }
        this.f21529n.aq();
        m25103f();
    }

    public final void mo1171e() {
        if (this.f21534s.isPresent()) {
            ((UserReviewsSection) this.f21534s.get()).f21378b.m24993c();
        }
        UserReviewsFragment userReviewsFragment = this.f21529n;
        userReviewsFragment.f21804h.setVisibility(0);
        userReviewsFragment.f21804h.a(userReviewsFragment.b(2131235347), this, new C23441(userReviewsFragment));
    }

    public final void m25097a(int i) {
        this.f21526k.f21353a.m24992b();
        UserReviewsListLoader userReviewsListLoader = this.f21522g;
        String str = this.f21528m;
        userReviewsListLoader.f21711f.a("key_load_more_places_to_review" + str, new C23352(userReviewsListLoader, str, i, this.f21526k.f21357e), new C23363(userReviewsListLoader, this));
    }

    public final void m25103f() {
        Object obj;
        if (this.f21526k != null && this.f21526k.f21354b.isEmpty() && this.f21526k.f21356d) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            m25095l();
        }
    }

    private void m25093h() {
        if (!this.f21527l.isPresent()) {
            this.f21523h = true;
            UserReviewsSection a = this.f21520e.m25199a(null, this.f21525j ? this.f21517b.getString(2131235351) : null, this.f21533r, this.f21530o, this.f21531p, this);
            a.f21387k = false;
            this.f21534s = Optional.of(a);
            this.f21533r.m25003a(ImmutableList.of(a));
            this.f21530o.a(this.f21518c);
            this.f21531p.a(this.f21516a);
            this.f21529n.m25284a(new C23011(this));
        }
    }

    public static void m25094j(UserReviewsListController userReviewsListController) {
        userReviewsListController.f21524i = true;
        userReviewsListController.f21529n.m25286e();
        if (userReviewsListController.f21534s.isPresent()) {
            UserReviewsListLoader userReviewsListLoader = userReviewsListController.f21522g;
            String str = userReviewsListController.f21528m;
            userReviewsListLoader.f21711f.a("key_load_initial_user_reviews_data" + str, new C23374(userReviewsListLoader, str, 3, ((UserReviewsSection) userReviewsListController.f21534s.get()).f21385i), new C23385(userReviewsListLoader, userReviewsListController));
        }
    }

    public final void m25096a() {
        this.f21529n.aq();
        m25095l();
        m25094j(this);
    }

    private void m25095l() {
        if (this.f21534s.isPresent()) {
            ((UserReviewsSection) this.f21534s.get()).f21387k = true;
            ((UserReviewsSection) this.f21534s.get()).f21378b.m24992b();
        }
    }
}
