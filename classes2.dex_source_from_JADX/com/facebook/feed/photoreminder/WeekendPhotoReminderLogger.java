package com.facebook.feed.photoreminder;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.photoreminder.abtest.ExperimentsForPhotoReminderAbTestModule;
import com.facebook.feed.photoreminder.model.MediaModel$MediaType;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Calendar;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: network_info_enqueued_req */
public class WeekendPhotoReminderLogger {
    private final AnalyticsLogger f12623a;
    private final QeAccessor f12624b;
    private final MediaReminderUtil f12625c;
    private final Clock f12626d;
    private long f12627e = 0;

    public static WeekendPhotoReminderLogger m18716b(InjectorLike injectorLike) {
        return new WeekendPhotoReminderLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), MediaReminderUtil.m18699a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public WeekendPhotoReminderLogger(AnalyticsLogger analyticsLogger, QeAccessor qeAccessor, MediaReminderUtil mediaReminderUtil, Clock clock) {
        this.f12624b = qeAccessor;
        this.f12623a = analyticsLogger;
        this.f12625c = mediaReminderUtil;
        this.f12626d = clock;
    }

    public final void m18717a() {
        boolean z = false;
        Calendar.getInstance(TimeZone.getDefault());
        if (this.f12624b.mo596a(ExperimentsForPhotoReminderAbTestModule.f12809l, false) && MediaReminderUtil.m18703g()) {
            long a = this.f12626d.mo211a();
            if (a - this.f12627e > 86400000) {
                this.f12627e = a;
                AnalyticsLogger analyticsLogger = this.f12623a;
                HoneyClientEvent b = new HoneyClientEvent("fb4a_photo_reminder").m5090b("event_name", "weekend_photo_reminder_data");
                String str = "has_three_photos";
                if (m18715b() < 3) {
                    z = true;
                }
                analyticsLogger.mo526a(b.m5087a(str, z));
            }
        }
    }

    private int m18715b() {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        long timeInMillis = instance.getTimeInMillis();
        int i = instance.get(11);
        return this.f12625c.m18705a(timeInMillis - (((((long) i) + 48) + 7) * 3600000), timeInMillis - (((long) i) * 3600000), MediaModel$MediaType.PHOTO);
    }
}
