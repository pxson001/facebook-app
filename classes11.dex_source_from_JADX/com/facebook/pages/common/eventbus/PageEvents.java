package com.facebook.pages.common.eventbus;

import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.google.common.collect.ImmutableList;

/* compiled from: sharers */
public class PageEvents {

    /* compiled from: sharers */
    public class PageActionBarDrawnEvent extends PageEvent {
    }

    /* compiled from: sharers */
    public abstract class PageActionBarDrawnEventSubscriber extends PageEventSubscriber<PageActionBarDrawnEvent> {
        public final Class<PageActionBarDrawnEvent> m2424a() {
            return PageActionBarDrawnEvent.class;
        }
    }

    /* compiled from: sharers */
    public interface PageIdentityDataUpdateParams {
        ImmutableList<PageCardType> mo40a();
    }

    /* compiled from: sharers */
    public class PagesActivityDataChangeEvent extends PageEvent {
    }

    /* compiled from: sharers */
    public abstract class PagesActivityDataChangeEventSubscriber extends PageEventSubscriber<PagesActivityDataChangeEvent> {
        public final Class<PagesActivityDataChangeEvent> m2426a() {
            return PagesActivityDataChangeEvent.class;
        }
    }

    /* compiled from: sharers */
    public class PagesContextRowsPmaGoToMessagesTabEvent extends PageEvent {
    }

    /* compiled from: sharers */
    public class PagesSurfaceAddTabEvent extends PageEvent {
        public final GraphQLPagePresenceTabType f1614a;
    }

    /* compiled from: sharers */
    public abstract class PagesSurfaceAddTabEventSubscriber extends PageEventSubscriber<PagesSurfaceAddTabEvent> {
        public final Class<PagesSurfaceAddTabEvent> m2427a() {
            return PagesSurfaceAddTabEvent.class;
        }
    }

    /* compiled from: sharers */
    public class PagesSurfaceDeleteTabEvent extends PageEvent {
        public final GraphQLPagePresenceTabType f1615a;

        public PagesSurfaceDeleteTabEvent(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
            this.f1615a = graphQLPagePresenceTabType;
        }
    }

    /* compiled from: sharers */
    public abstract class PagesSurfaceDeleteTabEventSubscriber extends PageEventSubscriber<PagesSurfaceDeleteTabEvent> {
        public final Class<PagesSurfaceDeleteTabEvent> m2428a() {
            return PagesSurfaceDeleteTabEvent.class;
        }
    }

    /* compiled from: sharers */
    public class PagesSurfaceSwitchToTabEvent extends PageEvent {
        public final GraphQLPagePresenceTabType f1616a;

        public PagesSurfaceSwitchToTabEvent(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
            this.f1616a = graphQLPagePresenceTabType;
        }
    }

    /* compiled from: sharers */
    public abstract class PagesSurfaceSwitchToTabEventSubscriber extends PageEventSubscriber<PagesSurfaceSwitchToTabEvent> {
        public final Class<PagesSurfaceSwitchToTabEvent> m2429a() {
            return PagesSurfaceSwitchToTabEvent.class;
        }
    }

    /* compiled from: sharers */
    public class ScrollToReviewsCardEvent extends PageEvent {
    }

    /* compiled from: sharers */
    public abstract class ScrollToReviewsCardEventSubscriber extends PageEventSubscriber<ScrollToReviewsCardEvent> {
        public final Class<ScrollToReviewsCardEvent> m2430a() {
            return ScrollToReviewsCardEvent.class;
        }
    }

    /* compiled from: sharers */
    public class UpdatePageDataEvent extends PageEvent {
        public final PageIdentityDataUpdateParams f1617a;

        /* compiled from: sharers */
        public final class C02211 implements PageIdentityDataUpdateParams {
            public final ImmutableList<PageCardType> mo40a() {
                return ImmutableList.of(PageCardType.REVIEWS);
            }
        }

        /* compiled from: sharers */
        final class C02222 implements PageIdentityDataUpdateParams {
            C02222() {
            }

            public final ImmutableList<PageCardType> mo40a() {
                return ImmutableList.of(PageCardType.REVIEWS, PageCardType.REVIEW_NEEDY_PLACE_CARD);
            }
        }

        /* compiled from: sharers */
        final class C02233 implements PageIdentityDataUpdateParams {
            C02233() {
            }

            public final ImmutableList<PageCardType> mo40a() {
                return ImmutableList.of(PageCardType.REVIEWS, PageCardType.REVIEW_NEEDY_PLACE_CARD);
            }
        }

        /* compiled from: sharers */
        final class C02244 implements PageIdentityDataUpdateParams {
            C02244() {
            }

            public final ImmutableList<PageCardType> mo40a() {
                return ImmutableList.of(PageCardType.COMMERCE);
            }
        }

        public UpdatePageDataEvent(PageIdentityDataUpdateParams pageIdentityDataUpdateParams) {
            this.f1617a = pageIdentityDataUpdateParams;
        }

        public static PageEvent m2435b() {
            return new UpdatePageDataEvent(new C02222());
        }

        public static PageEvent m2436c() {
            return new UpdatePageDataEvent(new C02233());
        }

        public static PageEvent m2437d() {
            return new UpdatePageDataEvent(new C02244());
        }
    }

    /* compiled from: sharers */
    public abstract class UpdatePageDataEventSubscriber extends PageEventSubscriber<UpdatePageDataEvent> {
        public final Class<UpdatePageDataEvent> m2438a() {
            return UpdatePageDataEvent.class;
        }
    }

    /* compiled from: sharers */
    public class UpdatePageSurfaceTabEvent extends PageEvent {
        public final C02251 f1618a;

        /* compiled from: sharers */
        public final class C02251 {
            C02251() {
            }
        }

        /* compiled from: sharers */
        public abstract class UpdatePageSurfaceTabEventSubscriber extends PageEventSubscriber<UpdatePageSurfaceTabEvent> {
            public final Class<UpdatePageSurfaceTabEvent> m2439a() {
                return UpdatePageSurfaceTabEvent.class;
            }
        }

        private UpdatePageSurfaceTabEvent(C02251 c02251) {
            this.f1618a = c02251;
        }

        public static PageEvent m2440b() {
            return new UpdatePageSurfaceTabEvent(new C02251());
        }
    }
}
