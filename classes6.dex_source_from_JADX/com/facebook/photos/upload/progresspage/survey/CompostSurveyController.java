package com.facebook.photos.upload.progresspage.survey;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.ultralight.Inject;

/* compiled from: getPriceLevel */
public class CompostSurveyController {
    public final Context f13961a;
    public final RapidFeedbackController f13962b;
    public final Clock f13963c;

    @Inject
    public CompostSurveyController(Context context, RapidFeedbackController rapidFeedbackController, Clock clock) {
        this.f13961a = context;
        this.f13962b = rapidFeedbackController;
        this.f13963c = clock;
    }
}
