package com.facebook.entitycardsplugins.person.widget.footer;

import com.facebook.content.event.FbEvent;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelChangedEvent;
import com.facebook.entitycards.model.event.EntityModelChangedEventSubscriber;
import com.facebook.entitycardsplugins.person.TimelineLauncher;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.inject.Assisted;
import com.facebook.presenter.ViewPresenter;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: heisman_fetch_image_overlay_failed */
public class PersonCardFooterPresenter extends ViewPresenter<PersonCardFooterView> {
    public final TimelineLauncher f11395a;
    public final EntityCardsAnalyticsLogger f11396b;
    public PersonCardModel f11397c;
    public final EntityModelChangedEventSubscriber f11398d = new C12411(this);

    /* compiled from: heisman_fetch_image_overlay_failed */
    class C12411 extends EntityModelChangedEventSubscriber {
        final /* synthetic */ PersonCardFooterPresenter f11394a;

        C12411(PersonCardFooterPresenter personCardFooterPresenter) {
            this.f11394a = personCardFooterPresenter;
        }

        public final boolean m13320a(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            return entityModelChangedEvent.f11082c != null && (entityModelChangedEvent.f11082c instanceof PersonCardModel) && Objects.equal(this.f11394a.f11397c.m13204r(), entityModelChangedEvent.f11081b);
        }

        public final void m13321b(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            this.f11394a.f11397c = (PersonCardModel) entityModelChangedEvent.f11082c;
        }
    }

    @Inject
    public PersonCardFooterPresenter(@Assisted PersonCardModel personCardModel, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, TimelineLauncher timelineLauncher) {
        this.f11397c = personCardModel;
        this.f11395a = timelineLauncher;
        this.f11396b = entityCardsAnalyticsLogger;
        entityCardsDatasourceEventBus.a(this.f11398d);
    }

    protected final void mo789b() {
        Optional a = m13028a();
        if (a.isPresent()) {
            PersonCardFooterView personCardFooterView = (PersonCardFooterView) a.get();
            personCardFooterView.f11400a = this;
            personCardFooterView.setupFooter(personCardFooterView.getResources().getString(2131239870));
        }
    }
}
