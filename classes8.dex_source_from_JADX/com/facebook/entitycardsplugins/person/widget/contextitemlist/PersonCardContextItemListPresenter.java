package com.facebook.entitycardsplugins.person.widget.contextitemlist;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.entitycards.analytics.EntityCardAnalyticsEventListener;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardSurfaceConfigEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.EventStatus;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.TapSurfaces;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.EntityCardFetchErrorService;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelChangedEvent;
import com.facebook.entitycards.model.event.EntityModelChangedEventSubscriber;
import com.facebook.entitycards.model.event.EntityModelLoadErrorEvent;
import com.facebook.entitycards.model.event.EntityModelLoadErrorEventSubscriber;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardContextItemModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemListView.State;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.presenter.ViewPresenter;
import com.facebook.timeline.services.ProfileContextItemNavigationHandler;
import com.facebook.timeline.services.data.ProfileContextItemNavigationData.Builder;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.uicontrib.contextitem.ContextualItemPresenter;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: heisman_navigate_to_page_sponsor */
public class PersonCardContextItemListPresenter extends ViewPresenter<PersonCardContextItemListView> implements ContextualItemPresenter<Void> {
    public final C11881 f11369a;
    private final PersonCardViewHelper f11370b;
    private final Lazy<ProfileContextItemNavigationHandler> f11371c;
    private final EntityCardsAnalyticsLogger f11372d;
    public final DefaultUserInteractionController f11373e;
    private final PersonCardContextItemsHelper f11374f;
    private final ViewHelperViewAnimatorFactory f11375g;
    private final DefaultTimeFormatUtil f11376h;
    public PersonCardModel f11377i;
    public IntroAnimationState f11378j = IntroAnimationState.BEFORE;
    private final int f11379k;
    public boolean f11380l;
    private final HashMap<PlutoniumContextualItemView, PersonCardContextItemModel> f11381m = Maps.c();
    public final EntityModelChangedEventSubscriber f11382n = new C12361(this);
    private final UserInteractionListener f11383o = new C12372(this);
    public final EntityModelLoadErrorEventSubscriber f11384p = new C12383(this);

    /* compiled from: heisman_navigate_to_page_sponsor */
    class C12361 extends EntityModelChangedEventSubscriber {
        final /* synthetic */ PersonCardContextItemListPresenter f11365a;

        C12361(PersonCardContextItemListPresenter personCardContextItemListPresenter) {
            this.f11365a = personCardContextItemListPresenter;
        }

        public final boolean m13292a(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            return entityModelChangedEvent.f11082c != null && (entityModelChangedEvent.f11082c instanceof PersonCardModel) && Objects.equal(this.f11365a.f11377i.m13204r(), entityModelChangedEvent.f11081b);
        }

        public final void m13293b(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            this.f11365a.f11377i = (PersonCardModel) entityModelChangedEvent.f11082c;
            this.f11365a.f11380l = true;
            if (!this.f11365a.f11373e.b()) {
                PersonCardContextItemListPresenter.m13304d(this.f11365a);
            }
        }
    }

    /* compiled from: heisman_navigate_to_page_sponsor */
    class C12372 implements UserInteractionListener {
        final /* synthetic */ PersonCardContextItemListPresenter f11366a;

        C12372(PersonCardContextItemListPresenter personCardContextItemListPresenter) {
            this.f11366a = personCardContextItemListPresenter;
        }

        public final void m13294a(boolean z) {
            switch (this.f11366a.f11378j) {
                case BEFORE:
                    if (z) {
                        this.f11366a.f11378j = IntroAnimationState.DURING;
                        break;
                    }
                    break;
                case DURING:
                    if (!z) {
                        this.f11366a.f11378j = IntroAnimationState.AFTER;
                        break;
                    }
                    break;
            }
            if (z) {
                Optional a = this.f11366a.m13028a();
                if (a.isPresent()) {
                    PersonCardContextItemListPresenter.m13302c(this.f11366a, (PersonCardContextItemListView) a.get());
                    return;
                }
                return;
            }
            PersonCardContextItemListPresenter.m13304d(this.f11366a);
        }
    }

    /* compiled from: heisman_navigate_to_page_sponsor */
    class C12383 extends EntityModelLoadErrorEventSubscriber {
        final /* synthetic */ PersonCardContextItemListPresenter f11367a;

        C12383(PersonCardContextItemListPresenter personCardContextItemListPresenter) {
            this.f11367a = personCardContextItemListPresenter;
        }

        public final boolean m13295a(FbEvent fbEvent) {
            return Objects.equal(this.f11367a.f11377i.m13204r(), ((EntityModelLoadErrorEvent) fbEvent).f11086a);
        }

        public final void m13296b(FbEvent fbEvent) {
            if (!this.f11367a.f11373e.b()) {
                PersonCardContextItemListPresenter.m13304d(this.f11367a);
            }
        }
    }

    /* compiled from: heisman_navigate_to_page_sponsor */
    enum IntroAnimationState {
        BEFORE,
        DURING,
        AFTER
    }

    private void m13301b(PersonCardContextItemListView personCardContextItemListView) {
        personCardContextItemListView.f11392g = this;
        m13302c(this, personCardContextItemListView);
        m13305d(personCardContextItemListView);
    }

    public final /* synthetic */ void mo790b(Object obj) {
        m13306a((PersonCardContextItemListView) obj);
    }

    @Inject
    public PersonCardContextItemListPresenter(@Assisted PersonCardModel personCardModel, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted EntityCardFetchErrorService entityCardFetchErrorService, PersonCardViewHelper personCardViewHelper, Lazy<ProfileContextItemNavigationHandler> lazy, @Assisted EntityCardAnalyticsEventListener entityCardAnalyticsEventListener, UserInteractionController userInteractionController, PersonCardContextItemsHelper personCardContextItemsHelper, PersonCardViewHelper personCardViewHelper2, ViewAnimatorFactory viewAnimatorFactory, DefaultTimeFormatUtil defaultTimeFormatUtil) {
        this.f11377i = personCardModel;
        this.f11369a = entityCardFetchErrorService;
        this.f11370b = personCardViewHelper;
        this.f11371c = lazy;
        this.f11372d = entityCardAnalyticsEventListener;
        this.f11373e = userInteractionController;
        this.f11374f = personCardContextItemsHelper;
        this.f11375g = viewAnimatorFactory;
        this.f11376h = defaultTimeFormatUtil;
        this.f11379k = personCardViewHelper2.m13246e();
        entityCardsDatasourceEventBus.a(this.f11382n);
        entityCardsDatasourceEventBus.a(this.f11384p);
    }

    protected final void mo789b() {
        this.f11380l = true;
        this.f11373e.a(this.f11383o);
        m13304d(this);
    }

    public static void m13304d(PersonCardContextItemListPresenter personCardContextItemListPresenter) {
        Optional a = personCardContextItemListPresenter.m13028a();
        if (a.isPresent()) {
            personCardContextItemListPresenter.m13301b((PersonCardContextItemListView) a.get());
        }
    }

    public final void m13306a(PersonCardContextItemListView personCardContextItemListView) {
        int i = 0;
        this.f11380l = false;
        Optional a = m13028a();
        this.f11373e.b(this.f11383o);
        if (a.isPresent() && a.get() == personCardContextItemListView) {
            while (i < personCardContextItemListView.getItemViewCount()) {
                mo798a(personCardContextItemListView.m13314a(i));
                i++;
            }
            personCardContextItemListView.m13315a();
            this.f11381m.clear();
        }
        super.mo790b(personCardContextItemListView);
    }

    private boolean m13303c(PlutoniumContextualItemView plutoniumContextualItemView) {
        Uri parse;
        Integer num;
        boolean z;
        plutoniumContextualItemView.c = this;
        PersonCardContextItemModel personCardContextItemModel = (PersonCardContextItemModel) this.f11381m.get(plutoniumContextualItemView);
        int dimensionPixelSize = this.f11370b.f11261b.getDimensionPixelSize(2131433177);
        Resources resources = plutoniumContextualItemView.getResources();
        int i = 0;
        if (personCardContextItemModel.m13119l() == null && personCardContextItemModel.m13118k() != null) {
            i = Math.max(0, (dimensionPixelSize - personCardContextItemModel.m13118k().c()) / 2);
        }
        int i2 = i;
        i = 0;
        if (personCardContextItemModel.m13119l() == null && personCardContextItemModel.m13118k() != null) {
            i = Math.max(0, (dimensionPixelSize - personCardContextItemModel.m13118k().a()) / 2);
        }
        int i3 = i;
        if (personCardContextItemModel.m13119l() != null) {
            parse = Uri.parse(personCardContextItemModel.m13119l().b());
        } else if (personCardContextItemModel.m13118k() != null) {
            parse = Uri.parse(personCardContextItemModel.m13118k().b());
        } else {
            parse = null;
        }
        plutoniumContextualItemView.a(dimensionPixelSize, i2, i3, parse, "entity_cards");
        plutoniumContextualItemView.getContext();
        String a = m13299a(personCardContextItemModel, plutoniumContextualItemView.getUnformattedSubtitleDatetimeApplication(), plutoniumContextualItemView.getUnformattedSubtitleApplication());
        plutoniumContextualItemView.a(personCardContextItemModel.m13124q().a(), a != null ? 1 : 2, SizeUtil.c(resources, 2131427401));
        plutoniumContextualItemView.a(a, 1, SizeUtil.c(resources, 2131427400));
        if (personCardContextItemModel.m13117j() == null) {
            num = null;
        } else {
            num = Integer.valueOf(personCardContextItemModel.m13117j().m13107a());
        }
        plutoniumContextualItemView.a(num);
        plutoniumContextualItemView.b(resources.getDimensionPixelSize(2131433181));
        plutoniumContextualItemView.m = plutoniumContextualItemView.getResources().getDimensionPixelSize(2131433180);
        if (personCardContextItemModel.m13126s() != null || (personCardContextItemModel.m13122o() != null && personCardContextItemModel.m13122o().equals(GraphQLTimelineContextListTargetType.COMPOSER))) {
            z = true;
        } else {
            z = false;
        }
        plutoniumContextualItemView.a(z, null);
        return true;
    }

    public final void mo798a(PlutoniumContextualItemView plutoniumContextualItemView) {
        this.f11381m.remove(plutoniumContextualItemView);
    }

    public final void mo799b(PlutoniumContextualItemView plutoniumContextualItemView) {
        String str = null;
        if (plutoniumContextualItemView != null && this.f11381m.containsKey(plutoniumContextualItemView)) {
            PersonCardContextItemModel personCardContextItemModel = (PersonCardContextItemModel) this.f11381m.get(plutoniumContextualItemView);
            if (personCardContextItemModel != null && this.f11377i != null) {
                String k;
                String j;
                int i;
                String str2;
                String b;
                String graphQLFriendshipStatus;
                Optional a = m13028a();
                Preconditions.checkState(a.isPresent(), "tried to handle an input event after dropping the view");
                int a2 = ((PersonCardContextItemListView) a.get()).m13313a(plutoniumContextualItemView);
                Preconditions.checkArgument(a2 != -1);
                this.f11372d.m12795a(TapSurfaces.CONTEXT_ITEM, this.f11377i.m13204r(), Optional.of((personCardContextItemModel.m13122o() != null ? personCardContextItemModel.m13122o() : GraphQLTimelineContextListTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE).name()), Optional.of(Integer.valueOf(a2)));
                if (personCardContextItemModel.m13120m() != null) {
                    String b2;
                    int jK_ = personCardContextItemModel.m13120m().jK_();
                    k = personCardContextItemModel.m13120m().m13146k();
                    if (personCardContextItemModel.m13120m().m13147l() != null) {
                        b2 = personCardContextItemModel.m13120m().m13147l().b();
                    } else {
                        b2 = null;
                    }
                    if (personCardContextItemModel.m13120m().m13145j() != null) {
                        j = personCardContextItemModel.m13120m().m13145j().m13132j();
                        i = jK_;
                        str2 = k;
                        k = b2;
                    } else {
                        j = null;
                        i = jK_;
                        str2 = k;
                        k = b2;
                    }
                } else {
                    k = null;
                    str2 = null;
                    i = 0;
                    j = null;
                }
                if (this.f11377i.m13210x() != null) {
                    b = this.f11377i.m13210x().b();
                } else {
                    b = null;
                }
                ProfileContextItemNavigationHandler profileContextItemNavigationHandler = (ProfileContextItemNavigationHandler) this.f11371c.get();
                Context context = plutoniumContextualItemView.getContext();
                Builder builder = new Builder();
                builder.a = i;
                Builder builder2 = builder;
                builder2.b = str2;
                Builder builder3 = builder2;
                builder3.c = k;
                Builder builder4 = builder3;
                builder4.d = j;
                Builder builder5 = builder4;
                builder5.e = FullscreenGallerySource.PERSON_CARD_CONTEXT_ITEM;
                builder5 = builder5;
                builder5.f = personCardContextItemModel.m13122o();
                builder5 = builder5;
                builder5.g = this.f11377i.m13204r();
                builder5 = builder5;
                builder5.h = this.f11377i.m13207u();
                builder5 = builder5;
                builder5.i = b;
                builder5 = builder5;
                builder5.j = this.f11377i.m13208v();
                builder5 = builder5;
                builder5.k = "person_card_context_item";
                builder5 = builder5;
                builder5.l = personCardContextItemModel.m13126s();
                Builder builder6 = builder5;
                builder6.o = m13300a(this.f11377i.m13212z());
                builder5 = builder6;
                if (this.f11377i.m13196j() != null) {
                    graphQLFriendshipStatus = this.f11377i.m13196j().toString();
                } else {
                    graphQLFriendshipStatus = null;
                }
                builder5.m = graphQLFriendshipStatus;
                builder6 = builder5;
                if (this.f11377i.m13200n() != null) {
                    str = this.f11377i.m13200n().toString();
                }
                builder6.n = str;
                profileContextItemNavigationHandler.a(context, builder6.a());
            }
        }
    }

    public static void m13302c(PersonCardContextItemListPresenter personCardContextItemListPresenter, PersonCardContextItemListView personCardContextItemListView) {
        State state;
        C11881 c11881 = personCardContextItemListPresenter.f11369a;
        if (c11881.f11028a.mo780a(personCardContextItemListPresenter.f11377i.m13204r())) {
            state = State.ERROR;
        } else if (personCardContextItemListPresenter.f11377i.m13185A() == null) {
            switch (personCardContextItemListPresenter.f11378j) {
                case BEFORE:
                case DURING:
                    state = State.LOADING_STATIC_SPINNER;
                    break;
                case AFTER:
                    state = State.LOADING_MOVING_SPINNER;
                    break;
                default:
                    throw new IllegalStateException();
            }
        } else {
            state = State.READY;
        }
        if (personCardContextItemListPresenter.f11380l) {
            if (state == State.READY) {
                personCardContextItemListPresenter.f11372d.mo770a(CardSurfaceConfigEvent.CONTEXT_ROWS, EventStatus.SUCCEEDED, personCardContextItemListPresenter.f11377i.m13204r());
                personCardContextItemListPresenter.f11380l = false;
            } else if (state == State.ERROR) {
                personCardContextItemListPresenter.f11372d.mo770a(CardSurfaceConfigEvent.CONTEXT_ROWS, EventStatus.FAILED, personCardContextItemListPresenter.f11377i.m13204r());
                personCardContextItemListPresenter.f11380l = false;
            }
        }
        personCardContextItemListView.setState(state);
    }

    private void m13305d(PersonCardContextItemListView personCardContextItemListView) {
        boolean isEmpty = this.f11381m.isEmpty();
        personCardContextItemListView.m13315a();
        this.f11381m.clear();
        ImmutableList a = this.f11374f.m13319a(this.f11377i);
        if (a != null) {
            int min = Math.min(a.size(), this.f11379k);
            for (int i = 0; i < min; i++) {
                boolean z;
                PersonCardContextItemModel personCardContextItemModel = (PersonCardContextItemModel) a.get(i);
                PlutoniumContextualItemView a2 = personCardContextItemListView.m13314a(i);
                Preconditions.checkNotNull(a2);
                a2.setVisibility(0);
                this.f11381m.put(a2, personCardContextItemModel);
                m13303c(a2);
                if (i + 1 < this.f11379k) {
                    z = true;
                } else {
                    z = false;
                }
                a2.n = z;
            }
            if (isEmpty) {
                VisibilityAnimator visibilityAnimator = new VisibilityAnimator(personCardContextItemListView, (long) personCardContextItemListView.getResources().getInteger(17694721), false, this.f11375g, 1.0f, 0.0f);
                visibilityAnimator.a(0.0f);
                visibilityAnimator.c();
            }
        }
    }

    @Nullable
    private String m13299a(PersonCardContextItemModel personCardContextItemModel, String str, String str2) {
        String str3 = null;
        if (personCardContextItemModel.m13121n() != null && !StringUtil.a(personCardContextItemModel.m13121n().a())) {
            return personCardContextItemModel.m13121n().a();
        }
        if (personCardContextItemModel.m13123p() == 0 && personCardContextItemModel.m13114a() == null) {
            return null;
        }
        String a;
        if (personCardContextItemModel.m13123p() != 0) {
            a = this.f11376h.a(TimeFormatStyle.EVENTS_RELATIVE_STYLE, personCardContextItemModel.m13123p() * 1000);
        } else {
            a = null;
        }
        if (personCardContextItemModel.m13114a() != null) {
            str3 = personCardContextItemModel.m13114a().m13104j();
        }
        if (a != null && str3 != null) {
            a = StringLocaleUtil.a(str, new Object[]{a, str3});
        } else if (a == null) {
            a = StringLocaleUtil.a(str2, new Object[]{str3});
        }
        return a;
    }

    private static String m13300a(DefaultNameFieldsModel defaultNameFieldsModel) {
        if (defaultNameFieldsModel == null || defaultNameFieldsModel.a() == null) {
            return null;
        }
        ImmutableList a = defaultNameFieldsModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            DefaultNamePartFieldsModel defaultNamePartFieldsModel = (DefaultNamePartFieldsModel) a.get(i);
            if (defaultNamePartFieldsModel.c().equals(GraphQLStructuredNamePart.FIRST)) {
                String s_ = defaultNameFieldsModel.s_();
                i = s_.offsetByCodePoints(0, defaultNamePartFieldsModel.t_());
                return s_.substring(i, s_.offsetByCodePoints(i, defaultNamePartFieldsModel.a()));
            }
        }
        return null;
    }
}
