package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.executor.RequestSubject;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.TimelineFirstUnits;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;

/* compiled from: group_create_dialog */
public class FirstUnitsReplayableBatchFetcher {

    /* compiled from: group_create_dialog */
    final class C15271 implements RequestObserver<TimelineFirstUnits> {
        final /* synthetic */ TimelineFirstUnitsQueryExecutor f10403a;
        final /* synthetic */ FetchTimelineFirstUnitsParams f10404b;
        final /* synthetic */ CallerContext f10405c;
        final /* synthetic */ RequestSubject f10406d;
        final /* synthetic */ RequestSubject f10407e;
        final /* synthetic */ RequestSubject f10408f;
        final /* synthetic */ RequestSubject f10409g;
        final /* synthetic */ RequestSubject f10410h;
        final /* synthetic */ RequestSubject f10411i;
        final /* synthetic */ RequestSubject f10412j;
        final /* synthetic */ RequestSubject f10413k;
        final /* synthetic */ RequestSubject f10414l;

        C15271(TimelineFirstUnitsQueryExecutor timelineFirstUnitsQueryExecutor, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext, RequestSubject requestSubject, RequestSubject requestSubject2, RequestSubject requestSubject3, RequestSubject requestSubject4, RequestSubject requestSubject5, RequestSubject requestSubject6, RequestSubject requestSubject7, RequestSubject requestSubject8, RequestSubject requestSubject9) {
            this.f10403a = timelineFirstUnitsQueryExecutor;
            this.f10404b = fetchTimelineFirstUnitsParams;
            this.f10405c = callerContext;
            this.f10406d = requestSubject;
            this.f10407e = requestSubject2;
            this.f10408f = requestSubject3;
            this.f10409g = requestSubject4;
            this.f10410h = requestSubject5;
            this.f10411i = requestSubject6;
            this.f10412j = requestSubject7;
            this.f10413k = requestSubject8;
            this.f10414l = requestSubject9;
        }

        public final void m10527a(Object obj) {
            if (((TimelineFirstUnits) obj).f10498c != DataFreshnessResult.FROM_SERVER) {
                FirstUnitsObservables a = this.f10403a.mo506a(true, this.f10404b, this.f10405c);
                a.f10485a.a(this.f10406d);
                if (a.f10486b != null) {
                    FirstUnitsReplayableBatchFetcher.m10530b(a.f10486b, this.f10407e);
                }
                FirstUnitsReplayableBatchFetcher.m10530b(a.f10488d, this.f10408f);
                FirstUnitsReplayableBatchFetcher.m10530b(a.f10487c, this.f10409g);
                FirstUnitsReplayableBatchFetcher.m10530b(a.f10489e, this.f10410h);
                if (a.f10490f != null) {
                    FirstUnitsReplayableBatchFetcher.m10530b(a.f10490f, this.f10411i);
                }
                if (a.f10491g != null) {
                    FirstUnitsReplayableBatchFetcher.m10530b(a.f10491g, this.f10412j);
                }
                if (a.f10493i != null) {
                    FirstUnitsReplayableBatchFetcher.m10530b(a.f10493i, this.f10413k);
                    return;
                }
                return;
            }
            this.f10406d.a();
            this.f10407e.a();
            this.f10408f.a();
            this.f10409g.a();
            this.f10410h.a();
            this.f10411i.a();
            this.f10412j.a();
            this.f10414l.a();
            this.f10413k.a();
        }

        public final void m10526a() {
        }

        public final void m10528a(Throwable th) {
        }
    }

    public static FirstUnitsObservables m10529a(FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext, FirstUnitsObservables firstUnitsObservables, TimelineFirstUnitsQueryExecutor timelineFirstUnitsQueryExecutor) {
        RequestSubject a = RequestSubject.a(1);
        RequestSubject a2 = RequestSubject.a(1);
        RequestSubject a3 = RequestSubject.a(1);
        RequestSubject a4 = RequestSubject.a(1);
        RequestSubject a5 = RequestSubject.a(1);
        RequestSubject a6 = RequestSubject.a(1);
        RequestSubject a7 = RequestSubject.a(1);
        RequestSubject a8 = RequestSubject.a(1);
        RequestSubject a9 = RequestSubject.a(1);
        firstUnitsObservables.f10485a.a(new C15271(timelineFirstUnitsQueryExecutor, fetchTimelineFirstUnitsParams, callerContext, a, a2, a3, a4, a5, a6, a7, a9, a8));
        return new FirstUnitsObservables(firstUnitsObservables.f10485a.b(a), firstUnitsObservables.f10486b != null ? firstUnitsObservables.f10486b.b(a2) : null, firstUnitsObservables.f10488d.b(a3), firstUnitsObservables.f10487c.b(a4), firstUnitsObservables.f10489e.b(a5), firstUnitsObservables.f10490f != null ? firstUnitsObservables.f10490f.b(a6) : null, firstUnitsObservables.f10491g != null ? firstUnitsObservables.f10491g.b(a7) : null, firstUnitsObservables.f10492h != null ? firstUnitsObservables.f10492h.b(a8) : null, firstUnitsObservables.f10493i != null ? firstUnitsObservables.f10493i.b(a9) : null);
    }

    public static <T> void m10530b(RequestObservable<T> requestObservable, RequestSubject<T> requestSubject) {
        new RequestObservable(requestObservable.a.c(RequestObservable.b().a)).a(requestSubject);
    }
}
