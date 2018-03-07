package com.facebook.pages.common.surface.ui.relatedpages;

import android.os.Bundle;
import android.os.ParcelUuid;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.NeedToShowSuggestedPagesEventSubscriber;
import com.facebook.pages.common.surface.fragments.reaction.PagesGenericReactionSurfaceTabFragment;
import com.facebook.pages.common.surfaceinterfaces.HasPagesSurfaceTabs;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: refresh_next_resume */
public class PageRelatedPagesHelper {
    public final Lazy<BlueServiceOperationFactory> f2689a;
    public final TasksManager f2690b;
    public final PagesGenericReactionSurfaceTabFragment f2691c;
    public final String f2692d;
    public final Lazy<FbErrorReporter> f2693e;
    public final PageRelatedPagesDataStore f2694f;
    private final ParcelUuid f2695g;
    public final PageScopedEventBus f2696h;
    public final NeedToShowSuggestedPagesEventSubscriber f2697i = new NeedToShowSuggestedPagesEventSubscriber(this, this.f2695g) {
        final /* synthetic */ PageRelatedPagesHelper f2688b;

        /* compiled from: refresh_next_resume */
        class C03571 extends OperationResultFutureCallback {
            final /* synthetic */ C03581 f2687a;

            C03571(C03581 c03581) {
                this.f2687a = c03581;
            }

            protected final void m3632a(Object obj) {
                FeedUnit feedUnit = (FeedUnit) ((OperationResult) obj).k();
                if (this.f2687a.f2688b.f2691c != null && (feedUnit instanceof GraphQLPagesYouMayLikeFeedUnit)) {
                    PageRelatedPagesDataStore pageRelatedPagesDataStore = this.f2687a.f2688b.f2694f;
                    pageRelatedPagesDataStore.f2686a.put(this.f2687a.f2688b.f2692d, (GraphQLPagesYouMayLikeFeedUnit) feedUnit);
                    PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment = this.f2687a.f2688b.f2691c;
                    if (pagesGenericReactionSurfaceTabFragment.at == null) {
                        ((AbstractFbErrorReporter) pagesGenericReactionSurfaceTabFragment.ay.get()).b(pagesGenericReactionSurfaceTabFragment.getClass().getSimpleName(), "Null adapter when onRelatedPageDataReady called");
                        return;
                    }
                    pagesGenericReactionSurfaceTabFragment.at.k();
                    HasPagesSurfaceTabs hasPagesSurfaceTabs = (HasPagesSurfaceTabs) pagesGenericReactionSurfaceTabFragment.a(HasPagesSurfaceTabs.class);
                    if (hasPagesSurfaceTabs != null && hasPagesSurfaceTabs.mo99c(GraphQLPagePresenceTabType.HOME)) {
                        hasPagesSurfaceTabs.mo100d(GraphQLPagePresenceTabType.HOME);
                    }
                }
            }

            protected final void m3631a(ServiceException serviceException) {
                ((AbstractFbErrorReporter) this.f2687a.f2688b.f2693e.get()).b("like_chaining_fetch_failed", serviceException);
            }
        }

        public final void m3633b(FbEvent fbEvent) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchFollowUpFeedUnitParamsKey", new FetchFollowUpFeedUnitParams(String.valueOf(this.f2688b.f2692d), null, GraphQLFollowUpFeedUnitActionType.PAGE_LIKE));
            this.f2688b.f2690b.a("related_pages_fetch_task", BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f2688b.f2689a.get(), "feed_fetch_followup_feed_unit", bundle, CallerContext.a(getClass()), -417741287).a(), new C03571(this));
        }
    };

    @Inject
    public PageRelatedPagesHelper(@Assisted String str, @Assisted PageRelatedPagesDataListener pageRelatedPagesDataListener, @Assisted ParcelUuid parcelUuid, PageScopedEventBus pageScopedEventBus, Lazy<BlueServiceOperationFactory> lazy, TasksManager tasksManager, Lazy<FbErrorReporter> lazy2, PageRelatedPagesDataStore pageRelatedPagesDataStore) {
        this.f2692d = str;
        this.f2691c = pageRelatedPagesDataListener;
        this.f2695g = parcelUuid;
        this.f2696h = pageScopedEventBus;
        this.f2689a = lazy;
        this.f2690b = tasksManager;
        this.f2693e = lazy2;
        this.f2694f = pageRelatedPagesDataStore;
    }

    public final void m3634a() {
        this.f2694f.m3628a(this.f2692d);
        this.f2696h.a(this.f2697i);
    }
}
