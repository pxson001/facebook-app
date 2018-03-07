package com.facebook.quickpromotion.filter;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.counters.UiCounters;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: reaction_page_surface_context_items_row_limit */
public class QuickPromotionThreadActivityEvent {
    public static long f4723a = 30000;
    public static long f4724b = 180000;
    private final UiCounters f4725c;
    private final Clock f4726d;

    public static QuickPromotionThreadActivityEvent m4591b(InjectorLike injectorLike) {
        return new QuickPromotionThreadActivityEvent(UiCounters.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public QuickPromotionThreadActivityEvent(UiCounters uiCounters, Clock clock) {
        this.f4725c = uiCounters;
        this.f4726d = clock;
    }

    public final void m4592a(long j) {
        Preconditions.checkArgument(j > 0, "Should only be called for One-to-one threads!");
        String valueOf = String.valueOf(j);
        if (this.f4726d.a() - this.f4725c.b(QuickPromotionUserEvent.THREAD_ACTIVITY.toEventName(), valueOf) > f4723a) {
            this.f4725c.a(QuickPromotionUserEvent.THREAD_ACTIVITY.toEventName(), valueOf, 1);
        } else {
            this.f4725c.c(QuickPromotionUserEvent.THREAD_ACTIVITY.toEventName(), valueOf);
        }
    }

    public static QuickPromotionThreadActivityEvent m4590a(InjectorLike injectorLike) {
        return m4591b(injectorLike);
    }
}
