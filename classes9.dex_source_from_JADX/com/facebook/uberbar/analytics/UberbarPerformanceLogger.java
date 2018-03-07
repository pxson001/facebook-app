package com.facebook.uberbar.analytics;

import com.facebook.common.time.MonotonicClock;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import javax.inject.Inject;

/* compiled from: transactionId */
public class UberbarPerformanceLogger {
    public final SequenceLogger f1402a;
    public final MonotonicClock f1403b;

    @Inject
    public UberbarPerformanceLogger(MonotonicClock monotonicClock, SequenceLogger sequenceLogger) {
        this.f1403b = monotonicClock;
        this.f1402a = sequenceLogger;
    }

    public final void m1513a() {
        m1509a(UberbarPerformanceConstants.f1400a);
    }

    public final void m1514b() {
        m1510a(UberbarPerformanceConstants.f1400a, "request_time_to_request_begin_time");
    }

    public final void m1515c() {
        m1511b(UberbarPerformanceConstants.f1400a, "request_time_to_request_begin_time");
    }

    public final void m1516d() {
        m1510a(UberbarPerformanceConstants.f1400a, "request_begin_to_response_end");
    }

    public final void m1517e() {
        m1511b(UberbarPerformanceConstants.f1400a, "request_begin_to_response_end");
    }

    public final void m1518f() {
        m1512c(UberbarPerformanceConstants.f1400a, "request_begin_to_response_end");
    }

    public final void m1519g() {
        m1509a(UberbarPerformanceConstants.f1401b);
    }

    public final void m1520h() {
        m1510a(UberbarPerformanceConstants.f1401b, "fetch_users_time");
    }

    public final void m1521i() {
        m1511b(UberbarPerformanceConstants.f1401b, "fetch_users_time");
    }

    public final void m1522j() {
        m1512c(UberbarPerformanceConstants.f1401b, "fetch_users_time");
    }

    public final void m1523k() {
        m1510a(UberbarPerformanceConstants.f1401b, "fetch_pages_time");
    }

    public final void m1524l() {
        m1511b(UberbarPerformanceConstants.f1401b, "fetch_pages_time");
    }

    public final void m1525m() {
        m1512c(UberbarPerformanceConstants.f1401b, "fetch_pages_time");
    }

    private void m1509a(AbstractSequenceDefinition abstractSequenceDefinition) {
        this.f1402a.a(abstractSequenceDefinition);
    }

    private void m1510a(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        Sequence e = this.f1402a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, -1546822372);
        }
    }

    private void m1511b(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        Sequence e = this.f1402a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, -1527160155);
        }
    }

    private void m1512c(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        Sequence e = this.f1402a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.c(e, str, 1736553566);
        }
    }
}
