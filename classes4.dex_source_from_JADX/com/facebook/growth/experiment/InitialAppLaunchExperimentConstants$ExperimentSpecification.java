package com.facebook.growth.experiment;

import com.facebook.growth.experiment.InitialAppLaunchExperiment.Condition;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.Nullable;

/* compiled from: 어금 */
public enum InitialAppLaunchExperimentConstants$ExperimentSpecification {
    AR_BOUNCE_FROM_MSITE(5000, new GregorianCalendar(2015, 4, 5).getTime(), new GregorianCalendar(2015, 5, 18).getTime(), null);
    
    @Nullable
    final Condition condition;
    final Date endDate;
    final Date startDate;
    final int threshold;

    private InitialAppLaunchExperimentConstants$ExperimentSpecification(int i, Date date, Date date2, Condition condition) {
        if (i < 0 || i > 10000) {
            throw new IllegalArgumentException("Invalid IALExperiment threshold specified");
        }
        this.startDate = date;
        this.endDate = date2;
        this.condition = condition;
        if (date == null || date2 == null) {
            i = 0;
        }
        this.threshold = i;
    }
}
