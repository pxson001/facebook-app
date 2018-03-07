package com.facebook.entitycardsplugins.person.widget.actionbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.analytics.NavigationLogger;
import com.facebook.auth.annotations.IsMeUserAWorkUser;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.collectlite.ManagedIntArray;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardSurfaceConfigEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.EventStatus;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.TapSurfaces;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelChangedEvent;
import com.facebook.entitycards.model.event.EntityModelChangedEventSubscriber;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel.Builder;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEventSubscriber;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.Assisted;
import com.facebook.presenter.ViewPresenter;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindow;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindow$OnChangeListener;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindowProvider;
import com.facebook.timeline.services.ProfileServicesCallbackHelper;
import com.facebook.timeline.widget.actionbar.IsAddToGroupsMenuItemEnabled;
import com.facebook.timeline.widget.actionbar.PersonActionBarItemConsumer;
import com.facebook.timeline.widget.actionbar.PersonActionBarItems;
import com.facebook.timeline.widget.actionbar.PersonActionBarItemsAnalytics;
import com.facebook.timeline.widget.actionbar.TimelineActionBarItemFactory;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: heisman_profile_picture_set */
public class PersonCardActionBarPresenter extends ViewPresenter<PersonCardActionBarView> implements PersonActionBarItemConsumer {
    public final C11761 f11279A;
    @Inject
    volatile Provider<ProfileServicesCallbackHelper> f11280a = UltralightRuntime.a;
    @Inject
    @ForUiThread
    volatile Provider<Executor> f11281b = UltralightRuntime.a;
    @Inject
    volatile Provider<FriendingClient> f11282c = UltralightRuntime.a;
    @Inject
    volatile Provider<SecureContextHelper> f11283d = UltralightRuntime.a;
    @IsAddToGroupsMenuItemEnabled
    @Inject
    public volatile Provider<TriState> f11284e = UltralightRuntime.a;
    @Inject
    @IsMeUserAWorkUser
    public volatile Provider<TriState> f11285f = UltralightRuntime.a;
    @Inject
    public volatile Provider<TimelineActionBarItemFactory> f11286g = UltralightRuntime.a;
    @Inject
    volatile Provider<FbErrorReporter> f11287h = UltralightRuntime.a;
    public final C12151 f11288i = new C12151(this);
    public final FriendshipStatusChangedEventSubscriber f11289j = new C12162(this);
    public final SubscribeStatusChangedEventSubscriber f11290k = new C12173(this);
    public final EntityModelChangedEventSubscriber f11291l = new C12184(this);
    private final UserInteractionListener f11292m = new C12195(this);
    @Inject
    @LoggedInUserId
    public Provider<String> f11293n;
    public final FriendingLocation f11294o;
    public final FriendRequestMakeRef f11295p;
    @Inject
    private Provider<NavigationLogger> f11296q;
    @Inject
    private Provider<FbUriIntentHandler> f11297r;
    @Inject
    public PersonCardFriendingControllerProvider f11298s;
    @Inject
    private FollowSwitcherPopupWindowProvider f11299t;
    public final EntityCardsAnalyticsLogger f11300u;
    @Inject
    private DefaultUserInteractionController f11301v;
    public PersonCardModel f11302w;
    public final ManagedIntArray f11303x = ManagedIntArray.a(6);
    public EntityCardsDatasourceEventBus f11304y;
    @Inject
    public FriendingEventBus f11305z;

    /* compiled from: heisman_profile_picture_set */
    public class C12151 {
        public final /* synthetic */ PersonCardActionBarPresenter f11272a;

        C12151(PersonCardActionBarPresenter personCardActionBarPresenter) {
            this.f11272a = personCardActionBarPresenter;
        }

        public final void m13249a(GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z, boolean z2) {
            PersonCardActionBarPresenter personCardActionBarPresenter = this.f11272a;
            Builder a = Builder.m13175a(this.f11272a.f11302w);
            a.f11203d = z;
            a = a;
            a.f11204e = z2;
            personCardActionBarPresenter.f11302w = a.m13176a();
            this.f11272a.f11305z.a(new FriendshipStatusChangedEvent(Long.parseLong(this.f11272a.f11302w.m13204r()), graphQLFriendshipStatus, true));
            this.f11272a.f11305z.a(new SubscribeStatusChangedEvent(Long.parseLong(this.f11272a.f11302w.m13204r()), graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, true));
            PersonCardActionBarPresenter.m13258c(this.f11272a);
        }
    }

    /* compiled from: heisman_profile_picture_set */
    class C12162 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ PersonCardActionBarPresenter f11273a;

        C12162(PersonCardActionBarPresenter personCardActionBarPresenter) {
            this.f11273a = personCardActionBarPresenter;
        }

        public final void m13250b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (Objects.equal(String.valueOf(friendshipStatusChangedEvent.a), this.f11273a.f11302w.m13204r())) {
                PersonCardActionBarPresenter personCardActionBarPresenter = this.f11273a;
                Builder a = Builder.m13175a(this.f11273a.f11302w);
                a.f11209j = friendshipStatusChangedEvent.b;
                personCardActionBarPresenter.f11302w = a.m13176a();
                PersonCardActionBarPresenter.m13258c(this.f11273a);
            }
        }
    }

    /* compiled from: heisman_profile_picture_set */
    class C12173 extends SubscribeStatusChangedEventSubscriber {
        final /* synthetic */ PersonCardActionBarPresenter f11274a;

        C12173(PersonCardActionBarPresenter personCardActionBarPresenter) {
            this.f11274a = personCardActionBarPresenter;
        }

        public final void m13251b(FbEvent fbEvent) {
            SubscribeStatusChangedEvent subscribeStatusChangedEvent = (SubscribeStatusChangedEvent) fbEvent;
            if (Objects.equal(String.valueOf(subscribeStatusChangedEvent.a), this.f11274a.f11302w.m13204r())) {
                PersonCardActionBarPresenter personCardActionBarPresenter = this.f11274a;
                Builder a = Builder.m13175a(this.f11274a.f11302w);
                a.f11221v = subscribeStatusChangedEvent.b;
                a = a;
                a.f11219t = subscribeStatusChangedEvent.c;
                personCardActionBarPresenter.f11302w = a.m13176a();
                PersonCardActionBarPresenter.m13258c(this.f11274a);
            }
        }
    }

    /* compiled from: heisman_profile_picture_set */
    class C12184 extends EntityModelChangedEventSubscriber {
        final /* synthetic */ PersonCardActionBarPresenter f11275a;

        C12184(PersonCardActionBarPresenter personCardActionBarPresenter) {
            this.f11275a = personCardActionBarPresenter;
        }

        public final boolean m13252a(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            return entityModelChangedEvent.f11082c != null && (entityModelChangedEvent.f11082c instanceof PersonCardModel) && Objects.equal(this.f11275a.f11302w.m13204r(), entityModelChangedEvent.f11081b);
        }

        public final void m13253b(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            this.f11275a.f11302w = (PersonCardModel) entityModelChangedEvent.f11082c;
            PersonCardActionBarPresenter.m13258c(this.f11275a);
        }
    }

    /* compiled from: heisman_profile_picture_set */
    class C12195 implements UserInteractionListener {
        final /* synthetic */ PersonCardActionBarPresenter f11276a;

        C12195(PersonCardActionBarPresenter personCardActionBarPresenter) {
            this.f11276a = personCardActionBarPresenter;
        }

        public final void m13254a(boolean z) {
            PersonCardActionBarPresenter.m13258c(this.f11276a);
        }
    }

    public final /* synthetic */ void mo790b(Object obj) {
        m13262a((PersonCardActionBarView) obj);
    }

    @Inject
    public PersonCardActionBarPresenter(@Assisted PersonCardModel personCardModel, @Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted C11761 c11761, @Nullable @Assisted FriendingLocation friendingLocation, @Nullable @Assisted FriendRequestMakeRef friendRequestMakeRef) {
        this.f11302w = personCardModel;
        this.f11300u = entityCardsAnalyticsLogger;
        this.f11304y = entityCardsDatasourceEventBus;
        this.f11279A = c11761;
        this.f11294o = friendingLocation;
        this.f11295p = friendRequestMakeRef;
    }

    public final void m13263a(PersonCardActionBarView personCardActionBarView, @PersonActionBarItems int i) {
        if (m13032c(personCardActionBarView)) {
            ManagedIntArray managedIntArray = this.f11303x;
            int i2 = 0;
            while (i2 < managedIntArray.b) {
                if (managedIntArray.a[i2] == i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            int i3 = i2;
            if (i3 < 0) {
                ((AbstractFbErrorReporter) this.f11287h.get()).a("person_card_action_bar_clicked_removed_item", StringFormatUtil.formatStrLocaleSafe("Clicked on an action bar item that is no longer visible: %s", PersonActionBarItemsAnalytics.a(i)));
                return;
            }
            this.f11300u.m12795a(TapSurfaces.ACTION_BAR, this.f11302w.m13204r(), Optional.of(PersonActionBarItemsAnalytics.a(i)), Optional.of(Integer.valueOf(i3)));
            m13257b(personCardActionBarView, i);
        }
    }

    public static void m13258c(PersonCardActionBarPresenter personCardActionBarPresenter) {
        if (!personCardActionBarPresenter.f11301v.b()) {
            personCardActionBarPresenter.m13259d();
        }
    }

    private void m13259d() {
        Optional a = m13028a();
        if (a.isPresent()) {
            PersonCardActionBarView personCardActionBarView = (PersonCardActionBarView) a.get();
            personCardActionBarView.setPresenter(this);
            personCardActionBarView.b();
            personCardActionBarView.clear();
            this.f11303x.c();
            TimelineActionBarItemFactory timelineActionBarItemFactory = (TimelineActionBarItemFactory) this.f11286g.get();
            timelineActionBarItemFactory.a(Objects.equal(this.f11302w.m13204r(), this.f11293n.get()), this.f11302w, ((TriState) this.f11285f.get()).asBoolean(false), ((TriState) this.f11284e.get()).asBoolean(false), this);
            personCardActionBarView.d();
            this.f11300u.mo770a(CardSurfaceConfigEvent.ACTION_BAR, EventStatus.SUCCEEDED, this.f11302w.m13204r());
        }
    }

    public final void m13262a(PersonCardActionBarView personCardActionBarView) {
        this.f11301v.b(this.f11292m);
        this.f11303x.c();
        super.mo790b(personCardActionBarView);
    }

    public final void m13260a(int i, @StringRes int i2, @DrawableRes int i3, int i4, boolean z, boolean z2) {
        m13261a(i, i2, i3, i4, z, z2, false, false);
    }

    public final void m13261a(int i, @StringRes int i2, @DrawableRes int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        if (z2 && i != 10 && i != 11 && i != 9 && i != 3 && i != 6) {
            Optional a = m13028a();
            Preconditions.checkState(a.isPresent());
            PersonCardActionBarView personCardActionBarView = (PersonCardActionBarView) a.get();
            this.f11303x.b(i);
            personCardActionBarView.a(0, i, 0, i2).setShowAsActionFlags(i4).setIcon(i3).setEnabled(z).setCheckable(z3).setChecked(z4);
        }
    }

    private void m13257b(PersonCardActionBarView personCardActionBarView, @PersonActionBarItems int i) {
        boolean z = false;
        final Context context = personCardActionBarView.getContext();
        switch (i) {
            case 0:
                this.f11298s.m13285a(this.f11294o, this.f11295p).m13282a(context, this.f11302w, this.f11288i);
                return;
            case 1:
                boolean z2 = this.f11302w.m13200n() == GraphQLSubscribeStatus.IS_SUBSCRIBED;
                if (z2 && this.f11302w.m13199m() == GraphQLSecondarySubscribeStatus.SEE_FIRST) {
                    z = true;
                }
                FollowSwitcherPopupWindow a = this.f11299t.a(personCardActionBarView, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true));
                a.j = new FollowSwitcherPopupWindow$OnChangeListener(this) {
                    final /* synthetic */ PersonCardActionBarPresenter f11278b;

                    public final void mo797a(boolean z, boolean z2) {
                        GraphQLSubscribeStatus graphQLSubscribeStatus;
                        GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus;
                        if (z2) {
                            graphQLSubscribeStatus = GraphQLSubscribeStatus.IS_SUBSCRIBED;
                            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.SEE_FIRST;
                        } else if (z) {
                            graphQLSubscribeStatus = GraphQLSubscribeStatus.IS_SUBSCRIBED;
                            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
                        } else {
                            graphQLSubscribeStatus = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
                            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
                        }
                        this.f11278b.f11298s.m13285a(this.f11278b.f11294o, this.f11278b.f11295p).m13284a(this.f11278b.f11302w, this.f11278b.f11288i, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus);
                    }
                };
                a.a();
                a.e();
                return;
            case 2:
                ((NavigationLogger) this.f11296q.get()).a("person_card_message_button");
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, this.f11302w.m13204r());
                Intent intent = new Intent();
                intent.putExtra("trigger", "person_card");
                intent.setData(Uri.parse(formatStrLocaleSafe));
                ((SecureContextHelper) this.f11283d.get()).a(intent, context);
                return;
            case 4:
                Futures.a(((FriendingClient) this.f11282c.get()).b(Long.parseLong((String) this.f11293n.get()), Long.parseLong(this.f11302w.m13204r())), ((ProfileServicesCallbackHelper) this.f11280a.get()).a(context, this.f11302w.m13207u()), (Executor) this.f11281b.get());
                return;
            case 5:
                ((FbUriIntentHandler) this.f11297r.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dh, this.f11293n.get(), this.f11302w.m13204r()));
                return;
            case 7:
                this.f11298s.m13285a(this.f11294o, this.f11295p).m13283a(context, this.f11302w.m13207u(), Long.parseLong(this.f11302w.m13204r()), this.f11288i);
                return;
            case 8:
                ((FbUriIntentHandler) this.f11297r.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cB, this.f11302w.m13204r(), GraphQLNegativeFeedbackActionType.DONT_LIKE, NegativeFeedbackExperienceLocation.TIMELINE_SOMEONE_ELSE.stringValueOf()));
                return;
            case 12:
                ((FbUriIntentHandler) this.f11297r.get()).a(context, FBLinks.cF);
                return;
            case 13:
                ((FbUriIntentHandler) this.f11297r.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.bc, this.f11302w.m13204r()));
                return;
            case 14:
                ((FbUriIntentHandler) this.f11297r.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.z, this.f11302w.m13204r(), this.f11302w.m13207u()));
                return;
            default:
                throw new UnsupportedOperationException("Unknown item type for PersonCardActionBarPresenter.handlePersonActionBarItem " + i);
        }
    }

    final void m13264a(Provider<ProfileServicesCallbackHelper> provider, Provider<Executor> provider2, Provider<FriendingClient> provider3, Provider<SecureContextHelper> provider4, Provider<TriState> provider5, Provider<TriState> provider6, Provider<TimelineActionBarItemFactory> provider7, Provider<FbErrorReporter> provider8, Provider<String> provider9, Provider<NavigationLogger> provider10, Provider<FbUriIntentHandler> provider11, PersonCardFriendingControllerProvider personCardFriendingControllerProvider, FollowSwitcherPopupWindowProvider followSwitcherPopupWindowProvider, UserInteractionController userInteractionController, FriendingEventBus friendingEventBus) {
        this.f11280a = provider;
        this.f11281b = provider2;
        this.f11282c = provider3;
        this.f11283d = provider4;
        this.f11284e = provider5;
        this.f11285f = provider6;
        this.f11286g = provider7;
        this.f11287h = provider8;
        this.f11293n = provider9;
        this.f11296q = provider10;
        this.f11297r = provider11;
        this.f11298s = personCardFriendingControllerProvider;
        this.f11299t = followSwitcherPopupWindowProvider;
        this.f11301v = userInteractionController;
        this.f11305z = friendingEventBus;
    }

    protected final void mo789b() {
        this.f11304y.a(this.f11291l);
        FriendingEventBus friendingEventBus = this.f11305z;
        friendingEventBus.a(this.f11289j);
        friendingEventBus.a(this.f11290k);
        this.f11301v.a(this.f11292m);
        m13259d();
    }
}
