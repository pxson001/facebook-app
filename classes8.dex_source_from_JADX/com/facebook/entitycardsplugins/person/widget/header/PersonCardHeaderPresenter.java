package com.facebook.entitycardsplugins.person.widget.header;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.entitycards.analytics.EntityCardAnalyticsEventListener;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardSurfaceConfigEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.EventStatus;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelChangedEvent;
import com.facebook.entitycards.model.event.EntityModelChangedEventSubscriber;
import com.facebook.entitycardsplugins.person.TimelineLauncher;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardCoverPhotoFieldsModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel.Builder;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.minipreview.MiniPreviewCoverPhotoProcessor;
import com.facebook.presenter.ViewPresenter;
import com.facebook.timeline.header.util.TimelineHeaderViewHelper;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: heisman_creative_cam_fragment */
public class PersonCardHeaderPresenter extends ViewPresenter<PersonCardHeaderView> {
    private final ControllerListener f11410a = new C12431(this);
    public final ControllerListener f11411b = new C12442(this);
    public final TimelineLauncher f11412c;
    private final PersonCardViewHelper f11413d;
    public final DefaultUserInteractionController f11414e;
    public final EntityCardsAnalyticsLogger f11415f;
    public final Provider<MiniPreviewCoverPhotoProcessor> f11416g;
    @ForUiThreadImmediate
    public final Executor f11417h;
    public PersonCardModel f11418i;
    @Nullable
    private String f11419j;
    public final EntityModelChangedEventSubscriber f11420k = new C12453(this);
    private final UserInteractionListener f11421l = new C12464(this);

    /* compiled from: heisman_creative_cam_fragment */
    class C12431 extends BaseControllerListener {
        final /* synthetic */ PersonCardHeaderPresenter f11403a;

        C12431(PersonCardHeaderPresenter personCardHeaderPresenter) {
            this.f11403a = personCardHeaderPresenter;
        }

        public final void m13327a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            PersonCardHeaderPresenter.m13336a(this.f11403a, CardSurfaceConfigEvent.COVER_PHOTO, EventStatus.SUCCEEDED);
        }

        public final void m13328b(String str, Throwable th) {
            PersonCardHeaderPresenter.m13336a(this.f11403a, CardSurfaceConfigEvent.COVER_PHOTO, EventStatus.FAILED);
        }

        public final void m13326a(String str) {
        }
    }

    /* compiled from: heisman_creative_cam_fragment */
    class C12442 extends BaseControllerListener {
        final /* synthetic */ PersonCardHeaderPresenter f11404a;

        C12442(PersonCardHeaderPresenter personCardHeaderPresenter) {
            this.f11404a = personCardHeaderPresenter;
        }

        public final void m13330a(String str, Object obj) {
        }

        public final void m13331a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            PersonCardHeaderPresenter.m13336a(this.f11404a, CardSurfaceConfigEvent.PROFILE_PICTURE, EventStatus.SUCCEEDED);
        }

        public final void m13332b(String str, Throwable th) {
            PersonCardHeaderPresenter.m13336a(this.f11404a, CardSurfaceConfigEvent.PROFILE_PICTURE, EventStatus.FAILED);
        }

        public final void m13329a(String str) {
        }
    }

    /* compiled from: heisman_creative_cam_fragment */
    class C12453 extends EntityModelChangedEventSubscriber {
        final /* synthetic */ PersonCardHeaderPresenter f11405a;

        C12453(PersonCardHeaderPresenter personCardHeaderPresenter) {
            this.f11405a = personCardHeaderPresenter;
        }

        public final boolean m13333a(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            return entityModelChangedEvent.f11082c != null && (entityModelChangedEvent.f11082c instanceof PersonCardModel) && Objects.equal(this.f11405a.f11418i.m13204r(), entityModelChangedEvent.f11081b);
        }

        public final void m13334b(FbEvent fbEvent) {
            PersonCardModel personCardModel = (PersonCardModel) ((EntityModelChangedEvent) fbEvent).f11082c;
            PersonCardHeaderPresenter personCardHeaderPresenter = this.f11405a;
            Builder a = Builder.m13175a(personCardModel);
            a.f11216q = this.f11405a.f11418i.m13209w();
            personCardHeaderPresenter.f11418i = a.m13176a();
            if (!this.f11405a.f11414e.b()) {
                PersonCardHeaderPresenter.m13337c(this.f11405a);
            }
        }
    }

    /* compiled from: heisman_creative_cam_fragment */
    class C12464 implements UserInteractionListener {
        final /* synthetic */ PersonCardHeaderPresenter f11406a;

        C12464(PersonCardHeaderPresenter personCardHeaderPresenter) {
            this.f11406a = personCardHeaderPresenter;
        }

        public final void m13335a(boolean z) {
            if (!z) {
                PersonCardHeaderPresenter.m13337c(this.f11406a);
            }
        }
    }

    private void m13338d(PersonCardHeaderView personCardHeaderView) {
        personCardHeaderView.f11426d = this;
        personCardHeaderView.setContentDescription(this.f11418i.m13207u());
        LayoutParams layoutParams = personCardHeaderView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f11413d.m13244b();
        } else {
            layoutParams = new LayoutParams(-1, this.f11413d.m13244b());
        }
        personCardHeaderView.setLayoutParams(layoutParams);
        m13339e(personCardHeaderView);
        personCardHeaderView.m13358a(this.f11418i.m13209w(), this.f11418i.m13210x(), this.f11411b);
        personCardHeaderView.m13360a(this.f11418i.m13207u(), this.f11418i.m13201o(), this.f11418i.m13205s(), this.f11418i.m13206t());
    }

    @Inject
    public PersonCardHeaderPresenter(@Assisted PersonCardModel personCardModel, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted EntityCardAnalyticsEventListener entityCardAnalyticsEventListener, PersonCardViewHelper personCardViewHelper, TimelineLauncher timelineLauncher, UserInteractionController userInteractionController, Provider<MiniPreviewCoverPhotoProcessor> provider, Executor executor) {
        this.f11418i = personCardModel;
        this.f11415f = entityCardAnalyticsEventListener;
        this.f11413d = personCardViewHelper;
        this.f11412c = timelineLauncher;
        this.f11414e = userInteractionController;
        this.f11416g = provider;
        this.f11417h = executor;
        entityCardsDatasourceEventBus.a(this.f11420k);
    }

    public final void m13341b(PersonCardHeaderView personCardHeaderView) {
        this.f11415f.mo770a(CardSurfaceConfigEvent.CARD_RECYCLED, EventStatus.SUCCEEDED, this.f11418i.m13204r());
        this.f11414e.b(this.f11421l);
        Optional a = m13028a();
        if (a.isPresent() && a.get() == personCardHeaderView) {
            personCardHeaderView.setContentDescription(null);
            personCardHeaderView.m13355a();
        }
        this.f11419j = null;
        super.mo790b(personCardHeaderView);
    }

    protected final void mo789b() {
        this.f11415f.mo770a(CardSurfaceConfigEvent.BEGIN_CARD_CONFIG, EventStatus.SUCCEEDED, this.f11418i.m13204r());
        this.f11414e.a(this.f11421l);
    }

    public static void m13337c(PersonCardHeaderPresenter personCardHeaderPresenter) {
        Optional a = personCardHeaderPresenter.m13028a();
        if (a.isPresent()) {
            personCardHeaderPresenter.m13338d((PersonCardHeaderView) a.get());
        }
    }

    private void m13339e(final PersonCardHeaderView personCardHeaderView) {
        this.f11413d.m13243a();
        int b = this.f11413d.m13244b();
        PersonCardCoverPhotoFieldsModel p = this.f11418i.m13202p();
        if (p == null || p.m13174j() == null || p.m13174j().m13168j() == null) {
            personCardHeaderView.m13359a(this.f11418i.m13207u(), b);
            m13336a(this, CardSurfaceConfigEvent.COVER_PHOTO, EventStatus.SUCCEEDED);
            return;
        }
        DefaultImageFieldsModel j = p.m13174j().m13168j();
        if (!Objects.equal(this.f11419j, j.b())) {
            Uri parse = Uri.parse(j.b());
            DefaultVect2FieldsModel a = p.m13172a();
            final PointF pointF = a != null ? new PointF((float) a.a(), (float) a.b()) : null;
            String k = p.m13174j().m13169k();
            if (k == null) {
                personCardHeaderView.m13357a(null, null);
            } else {
                Futures.a(((MiniPreviewCoverPhotoProcessor) this.f11416g.get()).m1810a(k, TimelineHeaderViewHelper.a(personCardHeaderView.getContext())), new FutureCallback<Drawable>(this) {
                    final /* synthetic */ PersonCardHeaderPresenter f11409c;

                    public void onSuccess(Object obj) {
                        personCardHeaderView.m13357a((Drawable) obj, pointF);
                    }

                    public void onFailure(Throwable th) {
                    }
                }, this.f11417h);
            }
            personCardHeaderView.m13356a(b, parse, this.f11418i.m13207u(), pointF, this.f11410a);
            this.f11419j = j.b();
        }
    }

    public static void m13336a(PersonCardHeaderPresenter personCardHeaderPresenter, CardSurfaceConfigEvent cardSurfaceConfigEvent, EventStatus eventStatus) {
        personCardHeaderPresenter.f11415f.mo770a(cardSurfaceConfigEvent, eventStatus, personCardHeaderPresenter.f11418i.m13204r());
    }
}
