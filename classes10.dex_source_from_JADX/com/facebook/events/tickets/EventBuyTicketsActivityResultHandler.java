package com.facebook.events.tickets;

import com.facebook.inject.InjectorLike;
import com.facebook.rapidfeedback.RapidFeedbackController;
import javax.inject.Inject;

/* compiled from: audio_clips_download_error */
public class EventBuyTicketsActivityResultHandler {
    public final RapidFeedbackController f19084a;

    public static EventBuyTicketsActivityResultHandler m19305a(InjectorLike injectorLike) {
        return new EventBuyTicketsActivityResultHandler(RapidFeedbackController.b(injectorLike));
    }

    @Inject
    public EventBuyTicketsActivityResultHandler(RapidFeedbackController rapidFeedbackController) {
        this.f19084a = rapidFeedbackController;
    }
}
