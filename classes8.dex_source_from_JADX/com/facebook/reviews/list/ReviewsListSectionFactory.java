package com.facebook.reviews.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.adapter.PlacesToReviewSection;
import com.facebook.reviews.adapter.SingleReviewSection;
import com.facebook.reviews.adapter.UserReviewsListBaseSection.SectionChangedListener;
import com.facebook.reviews.adapter.UserReviewsSection;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.controller.UserReviewsListController;
import com.facebook.reviews.event.ReviewEvents.ReviewFeedbackUpdatedEvent;
import com.facebook.reviews.event.ReviewEvents.ReviewFeedbackUpdatedEventSubscriber;
import com.facebook.reviews.event.ReviewEvents.UserPlaceToReviewEventSubscriber;
import com.facebook.reviews.event.ReviewEvents.UserReviewsEventSubscriber;
import com.facebook.reviews.event.ReviewEvents.ViewerReviewEventSubscriber;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.util.ReviewWithFeedbackMutator;
import com.facebook.reviews.util.helper.AuthoredReviewsMutator;
import com.facebook.reviews.util.helper.PageSaveStateMutator;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsModels.FetchSingleReviewQueryModel.RepresentedProfileModel;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: TitleBar is not set in Composer Fragment! */
public class ReviewsListSectionFactory {
    private static volatile ReviewsListSectionFactory f21680e;
    public final Provider<PlacesToReviewSection> f21681a;
    public final ReviewsLogger f21682b;
    public Provider<SingleReviewSection> f21683c;
    private final Provider<UserReviewsSection> f21684d;

    /* compiled from: TitleBar is not set in Composer Fragment! */
    public class C23251 extends ViewerReviewEventSubscriber {
        final /* synthetic */ SingleReviewSection f21651a;
        final /* synthetic */ SectionChangedListener f21652b;
        final /* synthetic */ ReviewsListSectionFactory f21653c;

        public C23251(ReviewsListSectionFactory reviewsListSectionFactory, SingleReviewSection singleReviewSection, SectionChangedListener sectionChangedListener) {
            this.f21653c = reviewsListSectionFactory;
            this.f21651a = singleReviewSection;
            this.f21652b = sectionChangedListener;
        }

        public final void mo1175a(String str, @Nullable ReviewWithFeedback reviewWithFeedback, @Nullable GraphQLStory graphQLStory) {
            String a;
            SingleReviewSection singleReviewSection = this.f21651a;
            if (singleReviewSection.f21361b.isPresent()) {
                a = ReviewsGraphQLHelper.m4912a((RepresentedProfileModel) singleReviewSection.f21361b.get());
            } else {
                a = null;
            }
            if (str.equals(a)) {
                this.f21651a.m24985a(reviewWithFeedback);
                this.f21652b.mo1169f();
            }
        }

        public final void mo1174a(String str) {
        }
    }

    /* compiled from: TitleBar is not set in Composer Fragment! */
    public class C23262 extends ReviewFeedbackUpdatedEventSubscriber {
        final /* synthetic */ SingleReviewSection f21654a;
        final /* synthetic */ SectionChangedListener f21655b;
        final /* synthetic */ ReviewsListSectionFactory f21656c;

        public C23262(ReviewsListSectionFactory reviewsListSectionFactory, SingleReviewSection singleReviewSection, SectionChangedListener sectionChangedListener) {
            this.f21656c = reviewsListSectionFactory;
            this.f21654a = singleReviewSection;
            this.f21655b = sectionChangedListener;
        }

        public final void m25188b(FbEvent fbEvent) {
            ReviewFeedbackUpdatedEvent reviewFeedbackUpdatedEvent = (ReviewFeedbackUpdatedEvent) fbEvent;
            GraphQLFeedback graphQLFeedback = reviewFeedbackUpdatedEvent.f4950a;
            Optional optional = this.f21654a.f21360a;
            if (reviewFeedbackUpdatedEvent.f4950a != null && optional.isPresent() && graphQLFeedback.z_() != null && graphQLFeedback.z_().equals(ReviewsGraphQLHelper.m4918c((ReviewWithFeedback) optional.get()))) {
                this.f21654a.m24985a(ReviewWithFeedbackMutator.m4906a((ReviewWithFeedback) optional.get(), graphQLFeedback));
                this.f21655b.mo1169f();
            }
        }
    }

    /* compiled from: TitleBar is not set in Composer Fragment! */
    public class C23317 implements OnClickListener {
        final /* synthetic */ UserReviewsListController f21670a;
        final /* synthetic */ ReviewsListSectionFactory f21671b;

        public C23317(ReviewsListSectionFactory reviewsListSectionFactory, UserReviewsListController userReviewsListController) {
            this.f21671b = reviewsListSectionFactory;
            this.f21670a = userReviewsListController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1808187962);
            AnalyticsLogger analyticsLogger = this.f21671b.f21682b.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("user_reviews_see_more_places_to_review_tap");
            honeyClientEvent.c = "user_reviews_list";
            analyticsLogger.a(honeyClientEvent);
            this.f21670a.m25097a(3);
            Logger.a(2, EntryType.UI_INPUT_END, -378379305, a);
        }
    }

    /* compiled from: TitleBar is not set in Composer Fragment! */
    public class C23328 extends ViewerReviewEventSubscriber {
        final /* synthetic */ PlacesToReviewSection f21672a;
        final /* synthetic */ UserReviewsListController f21673b;
        final /* synthetic */ SectionChangedListener f21674c;
        final /* synthetic */ ReviewsListSectionFactory f21675d;

        public C23328(ReviewsListSectionFactory reviewsListSectionFactory, PlacesToReviewSection placesToReviewSection, UserReviewsListController userReviewsListController, SectionChangedListener sectionChangedListener) {
            this.f21675d = reviewsListSectionFactory;
            this.f21672a = placesToReviewSection;
            this.f21673b = userReviewsListController;
            this.f21674c = sectionChangedListener;
        }

        public final void mo1175a(String str, @Nullable ReviewWithFeedback reviewWithFeedback, @Nullable GraphQLStory graphQLStory) {
            if (reviewWithFeedback == null && this.f21672a.m24978b(str)) {
                this.f21673b.m25097a(1);
            }
            this.f21674c.mo1169f();
        }

        public final void mo1174a(String str) {
        }
    }

    /* compiled from: TitleBar is not set in Composer Fragment! */
    public class C23339 extends UserPlaceToReviewEventSubscriber {
        final /* synthetic */ PlacesToReviewSection f21676a;
        final /* synthetic */ UserReviewsListController f21677b;
        final /* synthetic */ SectionChangedListener f21678c;
        final /* synthetic */ ReviewsListSectionFactory f21679d;

        public C23339(ReviewsListSectionFactory reviewsListSectionFactory, PlacesToReviewSection placesToReviewSection, UserReviewsListController userReviewsListController, SectionChangedListener sectionChangedListener) {
            this.f21679d = reviewsListSectionFactory;
            this.f21676a = placesToReviewSection;
            this.f21677b = userReviewsListController;
            this.f21678c = sectionChangedListener;
        }

        public final void mo1179a(String str, @Nullable PlaceToReviewModel placeToReviewModel) {
            if (placeToReviewModel != null && Strings.isNullOrEmpty(ReviewsGraphQLHelper.m4913b(placeToReviewModel.bR_()))) {
                PlacesToReviewSection placesToReviewSection = this.f21676a;
                if (placesToReviewSection.f21355c.containsKey(str)) {
                    placesToReviewSection.f21354b.set(placesToReviewSection.f21354b.indexOf((PlaceToReviewModel) placesToReviewSection.f21355c.get(str)), placeToReviewModel);
                } else {
                    placesToReviewSection.f21354b.add(0, placeToReviewModel);
                }
                placesToReviewSection.f21355c.put(str, placeToReviewModel);
            } else if (this.f21676a.m24978b(str)) {
                this.f21677b.m25097a(1);
            }
            this.f21678c.mo1169f();
        }
    }

    public static com.facebook.reviews.list.ReviewsListSectionFactory m25197a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f21680e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.list.ReviewsListSectionFactory.class;
        monitor-enter(r1);
        r0 = f21680e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25198b(r0);	 Catch:{ all -> 0x0035 }
        f21680e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21680e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.list.ReviewsListSectionFactory.a(com.facebook.inject.InjectorLike):com.facebook.reviews.list.ReviewsListSectionFactory");
    }

    private static ReviewsListSectionFactory m25198b(InjectorLike injectorLike) {
        return new ReviewsListSectionFactory(IdBasedProvider.a(injectorLike, 10248), ReviewsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 10249), IdBasedProvider.a(injectorLike, 10253));
    }

    @Inject
    public ReviewsListSectionFactory(Provider<PlacesToReviewSection> provider, ReviewsLogger reviewsLogger, Provider<SingleReviewSection> provider2, Provider<UserReviewsSection> provider3) {
        this.f21681a = provider;
        this.f21682b = reviewsLogger;
        this.f21683c = provider2;
        this.f21684d = provider3;
    }

    public final UserReviewsSection m25199a(@Nullable AuthoredReviewsModel authoredReviewsModel, String str, final SectionChangedListener sectionChangedListener, FbEventSubscriberListManager fbEventSubscriberListManager, FbEventSubscriberListManager fbEventSubscriberListManager2, final UserReviewsListController userReviewsListController) {
        final UserReviewsSection userReviewsSection = (UserReviewsSection) this.f21684d.get();
        userReviewsSection.m25023a(authoredReviewsModel);
        userReviewsSection.f21384h = str;
        userReviewsSection.f21378b.m24991a(sectionChangedListener);
        userReviewsSection.f21378b.m24992b();
        fbEventSubscriberListManager.a(new FbEventSubscriber[]{new ViewerReviewEventSubscriber(this) {
            final /* synthetic */ ReviewsListSectionFactory f21659c;

            public final void mo1175a(String str, @Nullable ReviewWithFeedback reviewWithFeedback, @Nullable GraphQLStory graphQLStory) {
                if (reviewWithFeedback == null) {
                    userReviewsSection.m25024a(str);
                }
                sectionChangedListener.mo1169f();
            }

            public final void mo1174a(String str) {
            }
        }, new UserReviewsEventSubscriber(this) {
            final /* synthetic */ ReviewsListSectionFactory f21663d;

            public final void mo1178a(String str, EdgesModel edgesModel) {
                int a = userReviewsSection.m25020a(str, edgesModel);
                sectionChangedListener.mo1169f();
                UserReviewsListController userReviewsListController = userReviewsListController;
                userReviewsListController.f21529n.f21803g.smoothScrollToPosition(userReviewsListController.f21533r.getPositionForSection(userReviewsListController.f21533r.getCount()) + (a + 1));
            }
        }, new ReviewFeedbackUpdatedEventSubscriber(this) {
            final /* synthetic */ ReviewsListSectionFactory f21666c;

            public final void m25192b(FbEvent fbEvent) {
                ReviewFeedbackUpdatedEvent reviewFeedbackUpdatedEvent = (ReviewFeedbackUpdatedEvent) fbEvent;
                UserReviewsSection userReviewsSection = userReviewsSection;
                EdgesModel edgesModel = (EdgesModel) userReviewsSection.f21381e.get(reviewFeedbackUpdatedEvent.f4950a.z_());
                if (edgesModel != null) {
                    userReviewsSection.m25020a(ReviewsGraphQLHelper.m4916b(edgesModel), AuthoredReviewsMutator.m4907a(edgesModel, ReviewWithFeedbackMutator.m4906a(edgesModel.b(), reviewFeedbackUpdatedEvent.f4950a)));
                    sectionChangedListener.mo1169f();
                }
            }
        }});
        fbEventSubscriberListManager2.a(new FeedUnitMutatedEventSubscriber(this) {
            final /* synthetic */ ReviewsListSectionFactory f21669c;

            public final void m25193b(FbEvent fbEvent) {
                FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
                if (feedUnitMutatedEvent.a != null) {
                    UserReviewsSection userReviewsSection = userReviewsSection;
                    GraphQLStory graphQLStory = (GraphQLStory) feedUnitMutatedEvent.a;
                    String a = ReviewsGraphQLHelper.m4910a(StoryAttachmentHelper.o(graphQLStory));
                    if (userReviewsSection.f21382f.containsKey(a)) {
                        EdgesModel edgesModel = (EdgesModel) userReviewsSection.f21382f.get(a);
                        EdgesModel a2 = PageSaveStateMutator.m4908a(edgesModel, graphQLStory);
                        userReviewsSection.f21379c.set(userReviewsSection.f21379c.indexOf(edgesModel), a2);
                        userReviewsSection.f21382f.put(a, a2);
                    }
                    sectionChangedListener.mo1169f();
                }
            }
        });
        return userReviewsSection;
    }
}
