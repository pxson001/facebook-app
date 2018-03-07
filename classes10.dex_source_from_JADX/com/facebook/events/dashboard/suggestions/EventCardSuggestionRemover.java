package com.facebook.events.dashboard.suggestions;

import android.content.Context;
import com.facebook.events.carousel.EventCardRemover;
import com.facebook.events.model.Event;
import com.facebook.events.mutators.EventsSuggestionMutator;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.users.ACTION_USERS_UPDATED */
public class EventCardSuggestionRemover extends EventCardRemover {
    private final EventsSuggestionMutator f17189a;

    public static EventCardSuggestionRemover m17511b(InjectorLike injectorLike) {
        return new EventCardSuggestionRemover(EventsSuggestionMutator.b(injectorLike));
    }

    @Inject
    public EventCardSuggestionRemover(EventsSuggestionMutator eventsSuggestionMutator) {
        this.f17189a = eventsSuggestionMutator;
    }

    public final String mo797a(Context context, Event event) {
        return context.getString(2131237156);
    }

    public final void mo798a(Event event) {
        this.f17189a.a(event.a, "MOBILE_SUGGESTIONS_DASHBOARD");
    }

    public final boolean mo799a() {
        return false;
    }
}
