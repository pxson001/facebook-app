package com.facebook.events.sideshow;

import com.facebook.common.collect.ReentrantCallback;
import com.facebook.events.sideshow.EventsSideshowUnit.C29343;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TYPE_SFIXED64 */
public class EventsSideshowDataHolder {
    public final ReentrantCallback<Listener> f24428a = new ReentrantCallback();
    public int f24429b;
    public ImmutableList<BirthdayPersonModel> f24430c = null;
    public FetchEventsAndBirthdaysRequest f24431d;

    /* compiled from: TYPE_SFIXED64 */
    public class C29311 implements FutureCallback<GraphQLResult<SideshowEventsBirthdaysQueryModel>> {
        final /* synthetic */ 1 f24426a;
        final /* synthetic */ EventsSideshowDataHolder f24427b;

        public C29311(EventsSideshowDataHolder eventsSideshowDataHolder, 1 1) {
            this.f24427b = eventsSideshowDataHolder;
            this.f24426a = 1;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                onFailure(null);
                return;
            }
            SideshowEventsBirthdaysQueryModel sideshowEventsBirthdaysQueryModel = (SideshowEventsBirthdaysQueryModel) graphQLResult.e;
            if (sideshowEventsBirthdaysQueryModel == null) {
                onFailure(null);
                return;
            }
            this.f24427b.f24429b = 0;
            if (!(sideshowEventsBirthdaysQueryModel.m26355j() == null || sideshowEventsBirthdaysQueryModel.m26355j().m26347a() == null)) {
                this.f24427b.f24429b = sideshowEventsBirthdaysQueryModel.m26355j().m26347a().size();
            }
            if (!(sideshowEventsBirthdaysQueryModel.m26351a() == null || sideshowEventsBirthdaysQueryModel.m26351a().m26333a() == null || sideshowEventsBirthdaysQueryModel.m26351a().m26333a().isEmpty())) {
                this.f24427b.f24430c = sideshowEventsBirthdaysQueryModel.m26351a().m26333a();
            }
            if (this.f24427b.f24429b > 0 || this.f24427b.f24430c != null) {
                for (C29343 c29343 : this.f24427b.f24428a.a()) {
                    c29343.f24434a.m26295e();
                    c29343.f24434a.f24442h.f24428a.b(c29343);
                }
                this.f24426a.a(LoadResult.SUCCESS);
                return;
            }
            onFailure(null);
        }

        public void onFailure(Throwable th) {
            this.f24426a.a(LoadResult.ERROR);
        }
    }

    @Inject
    public EventsSideshowDataHolder(FetchEventsAndBirthdaysRequest fetchEventsAndBirthdaysRequest) {
        this.f24431d = fetchEventsAndBirthdaysRequest;
    }

    public final boolean m26282c() {
        return this.f24429b > 0 || !(this.f24430c == null || this.f24430c.isEmpty());
    }
}
