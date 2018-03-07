package com.facebook.timeline.header;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.TimelineIntroCardAdapter.C16533;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fragment_id */
public class TimelineIntroMegaphoneViewBinder {
    private final TimelineBioNuxController f11526a;
    public final Provider<TimelineAnalyticsLogger> f11527b;

    private static TimelineIntroMegaphoneViewBinder m11565b(InjectorLike injectorLike) {
        return new TimelineIntroMegaphoneViewBinder(TimelineBioNuxController.m11672a(injectorLike), IdBasedProvider.a(injectorLike, 11293));
    }

    @Inject
    public TimelineIntroMegaphoneViewBinder(TimelineBioNuxController timelineBioNuxController, Provider<TimelineAnalyticsLogger> provider) {
        this.f11526a = timelineBioNuxController;
        this.f11527b = provider;
    }

    public final void m11566a(TimelineIntroMegaphoneView timelineIntroMegaphoneView, final C16533 c16533, final TimelineUserContext timelineUserContext) {
        timelineIntroMegaphoneView.setBackgroundResource(2131361920);
        timelineIntroMegaphoneView.setOnDismissListener(new OnClickListener(this) {
            final /* synthetic */ TimelineIntroMegaphoneViewBinder f11525c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1707609468);
                TimelineIntroCardAdapter.m11502k(c16533.f11443a);
                ((TimelineAnalyticsLogger) this.f11525c.f11527b.get()).c(timelineUserContext.b, timelineUserContext.c);
                Logger.a(2, EntryType.UI_INPUT_END, -270014587, a);
            }
        });
        this.f11526a.f11631a.a().a("3621");
        ((TimelineAnalyticsLogger) this.f11527b.get()).b(timelineUserContext.b, timelineUserContext.c);
    }

    public static TimelineIntroMegaphoneViewBinder m11563a(InjectorLike injectorLike) {
        return m11565b(injectorLike);
    }
}
