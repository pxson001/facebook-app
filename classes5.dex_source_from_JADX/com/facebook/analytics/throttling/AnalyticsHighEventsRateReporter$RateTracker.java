package com.facebook.analytics.throttling;

/* compiled from: tile_key */
class AnalyticsHighEventsRateReporter$RateTracker {
    private long f1912a;
    private double f1913b;
    private double f1914c;

    AnalyticsHighEventsRateReporter$RateTracker(long j) {
        this(j, 0.08333333333333333d);
    }

    private AnalyticsHighEventsRateReporter$RateTracker(long j, double d) {
        this.f1913b = 0.0d;
        this.f1912a = j;
        this.f1914c = d;
    }

    final double m2598a(long j) {
        m2597c(j);
        double d = this.f1913b + 1.0d;
        this.f1913b = d;
        return d;
    }

    final double m2599b(long j) {
        m2597c(j);
        return this.f1913b;
    }

    private void m2597c(long j) {
        if (j < this.f1912a) {
            this.f1912a = j;
        }
        this.f1913b = Math.max(0.0d, this.f1913b - ((((double) (j - this.f1912a)) / 1000.0d) * this.f1914c));
        this.f1912a = j;
    }
}
