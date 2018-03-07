package com.facebook.events.permalink.calltoaction;

import com.facebook.common.time.SystemClock;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPhaseSelector;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

/* compiled from: button1Title */
public class EventCallToActionController {
    private final CheckinCallToAction f18277a;
    private final BuyTicketsCallToAction f18278b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: button1Title */
    public @interface CallToActionType {
    }

    public static EventCallToActionController m18631a(InjectorLike injectorLike) {
        return new EventCallToActionController(BuyTicketsCallToAction.m18625b(injectorLike), new CheckinCallToAction(EventPhaseSelector.m18299a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public EventCallToActionController(BuyTicketsCallToAction buyTicketsCallToAction, CheckinCallToAction checkinCallToAction) {
        this.f18278b = buyTicketsCallToAction;
        this.f18277a = checkinCallToAction;
    }

    public final int m18632a(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        Object obj;
        Object obj2;
        CheckinCallToAction checkinCallToAction = this.f18277a;
        if (event.d == GraphQLEventPrivacyType.PUBLIC_TYPE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && checkinCallToAction.f18274a.m18304b(event) && event.P() && checkinCallToAction.f18275b.a(ExperimentsForEventsGatingModule.k, false)) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return 1;
        }
        if (this.f18278b.m18629b(event, fetchEventPermalinkFragmentModel)) {
            int i;
            if (((NodesModel) fetchEventPermalinkFragmentModel.ac().a().get(0)).eb_() * 1000 > SystemClock.a.a()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 && (fetchEventPermalinkFragmentModel.T() || Strings.isNullOrEmpty(fetchEventPermalinkFragmentModel.U()))) {
                obj2 = 1;
                if (obj2 == null) {
                    return 2;
                }
                return 0;
            }
        }
        obj2 = null;
        if (obj2 == null) {
            return 0;
        }
        return 2;
    }

    public final BuyTicketsCallToAction m18633a() {
        return this.f18278b;
    }
}
