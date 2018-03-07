package com.facebook.feed.awesomizer.ui;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: gysc_click */
public class FeedAwesomizerLogger {
    public final AnalyticsLogger f11835a;
    public final Clock f11836b;
    private final String f11837c = "feed_awesomizer";
    public int f11838d = 0;
    public long f11839e;
    public long f11840f = 0;
    public long f11841g;
    private long f11842h;
    public long f11843i;
    public long f11844j = 0;
    public long f11845k = 0;
    public long f11846l = 0;
    public final List f11847m = new ArrayList();
    private final List f11848n = new ArrayList();
    public final Set f11849o = new HashSet();
    public final Set f11850p = new HashSet();

    public static FeedAwesomizerLogger m13942b(InjectorLike injectorLike) {
        return new FeedAwesomizerLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedAwesomizerLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f11835a = analyticsLogger;
        this.f11836b = clock;
    }

    public final void m13944a(AwesomizerCards awesomizerCards, double d, int i, int i2, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("feed_awesomizer_card_close");
        honeyClientEvent.c = "feed_awesomizer";
        honeyClientEvent.b("awesomizer_session_identifier", str);
        honeyClientEvent.a("card_time_spent", ((double) this.f11846l) / 1000.0d);
        honeyClientEvent.a("identifier", awesomizerCards.getIndex());
        honeyClientEvent.a("initial_network_load_time", ((double) this.f11840f) / 1000.0d);
        honeyClientEvent.a("max_scroll_distance", d);
        honeyClientEvent.b("name", awesomizerCards.getName());
        honeyClientEvent.a("profiles_appeared_count", i2);
        honeyClientEvent.a("profiles_selected_count", this.f11849o.size());
        honeyClientEvent.a("profiles_selected_array", this.f11849o);
        honeyClientEvent.a("profiles_tapped_array", this.f11848n);
        honeyClientEvent.a("profiles_tapped_count", this.f11848n.size());
        honeyClientEvent.a("profiles_total_count", i);
        honeyClientEvent.a("profiles_unselected_count", this.f11850p.size());
        honeyClientEvent.a("profiles_unselected_array", this.f11850p);
        honeyClientEvent.a("total_time_spent", ((double) this.f11846l) / 1000.0d);
        this.f11835a.a(honeyClientEvent);
    }

    public final void m13943a(int i, boolean z) {
        if (z) {
            this.f11848n.add(i + "_s");
            if (this.f11850p.contains(Integer.valueOf(i))) {
                this.f11850p.remove(Integer.valueOf(i));
                return;
            } else {
                this.f11849o.add(Integer.valueOf(i));
                return;
            }
        }
        this.f11848n.add(i + "_u");
        if (this.f11849o.contains(Integer.valueOf(i))) {
            this.f11849o.remove(Integer.valueOf(i));
        } else {
            this.f11850p.add(Integer.valueOf(i));
        }
    }

    public final void m13945d() {
        this.f11846l = (this.f11846l + this.f11836b.a()) - this.f11842h;
        this.f11844j = (this.f11844j + this.f11836b.a()) - this.f11843i;
    }

    public final void m13946e() {
        this.f11842h = this.f11836b.a();
        this.f11843i = this.f11836b.a();
    }

    public final long m13947g() {
        return this.f11846l;
    }
}
