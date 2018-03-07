package com.facebook.feedplugins.placetips;

import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.common.abtest.ExperimentsForPlaceTipsCommonAbTestModule;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.EventsModel;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: maximumSize */
public class EventTipsManager {
    private final PagePresenceProvider f14801a;
    private final QeAccessor f14802b;
    @Nullable
    public LocationTriggerWithReactionUnitsModel f14803c;
    @Nullable
    public EventsModel f14804d;

    public static EventTipsManager m21200b(InjectorLike injectorLike) {
        return new EventTipsManager(PagePresenceManager.m21206a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public EventTipsManager(PagePresenceProvider pagePresenceProvider, QeAccessor qeAccessor) {
        this.f14801a = pagePresenceProvider;
        this.f14802b = qeAccessor;
    }

    @Nullable
    public final EventsModel m21202a() {
        Optional b = this.f14801a.mo2827b();
        if (b.isPresent()) {
            LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel = (LocationTriggerWithReactionUnitsModel) b.get();
            if (Objects.equal(locationTriggerWithReactionUnitsModel, this.f14803c)) {
                return this.f14804d;
            }
            if (locationTriggerWithReactionUnitsModel.a() == null) {
                return m21201c();
            }
            if (locationTriggerWithReactionUnitsModel.a().a().isEmpty()) {
                return m21201c();
            }
            EventsModel eventsModel = (EventsModel) locationTriggerWithReactionUnitsModel.a().a().get(0);
            if (eventsModel.a() == null) {
                return m21201c();
            }
            if (!this.f14802b.mo596a(ExperimentsForPlaceTipsCommonAbTestModule.f15114a, false)) {
                return m21201c();
            }
            this.f14803c = locationTriggerWithReactionUnitsModel;
            this.f14804d = eventsModel;
            return eventsModel;
        }
        this.f14803c = null;
        this.f14804d = null;
        return m21201c();
    }

    @Nullable
    private EventsModel m21201c() {
        this.f14803c = null;
        this.f14804d = null;
        return null;
    }
}
