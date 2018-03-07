package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feedplugins.friendingcommon.ProfilePicturePartDefinition;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.PageSwitcherContextStateKey;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowTextContainerPartDefinition;
import com.facebook.feedplugins.pymk.views.rows.PersonYouMayKnowView;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowHScrollPartDefinition.C17673;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: facewebPhotoButton */
public class PeopleYouMayKnowPagePartDefinition<E extends CanFriendPerson & HasPersistentState & HasPrefetcher & HasRowKey & HasInvalidate> extends BaseSinglePartDefinitionWithViewType<Props, PageSwitcherContextStateKey, E, PersonYouMayKnowView> {
    public static ViewType<PersonYouMayKnowView> f12558a = new C17711();
    private static PeopleYouMayKnowPagePartDefinition f12559h;
    private static final Object f12560i = new Object();
    private final FriendingEventBus f12561b;
    private final PeopleYouMayKnowTextContainerPartDefinition f12562c;
    private final ProfilePicturePartDefinition<E> f12563d;
    private final PeopleYouMayKnowBlacklistPartDefinition<E> f12564e;
    private final PeopleYouMayKnowFriendingButtonPartDefinition<E> f12565f;
    private final Resources f12566g;

    /* compiled from: facewebPhotoButton */
    final class C17711 extends ViewType<PersonYouMayKnowView> {
        C17711() {
        }

        public final View m12542a(Context context) {
            return new PersonYouMayKnowView(context, null, 1);
        }
    }

    /* compiled from: facewebPhotoButton */
    class FriendshipSubscriber<E extends HasInvalidate & HasPersistentState> extends FriendshipStatusChangedEventSubscriber {
        private final WeakReference<E> f12551a;
        private final GraphQLFriendshipStatus f12552b;
        private final WeakReference<CacheableEntity> f12553c;

        public final void m12543b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null) {
                HasInvalidate hasInvalidate = (HasInvalidate) this.f12551a.get();
                CacheableEntity cacheableEntity = (CacheableEntity) this.f12553c.get();
                FriendshipContextStateKey friendshipContextStateKey = new FriendshipContextStateKey(String.valueOf(friendshipStatusChangedEvent.a), this.f12552b);
                if (friendshipStatusChangedEvent.b != ((FriendshipPersistentState) ((HasPersistentState) hasInvalidate).a(friendshipContextStateKey, cacheableEntity)).a) {
                    ((HasPersistentState) hasInvalidate).a(friendshipContextStateKey, new FriendshipPersistentState(friendshipStatusChangedEvent.b, false));
                    hasInvalidate.a(new Object[]{cacheableEntity});
                }
            }
        }

        public FriendshipSubscriber(E e, GraphQLFriendshipStatus graphQLFriendshipStatus, CacheableEntity cacheableEntity) {
            this.f12551a = new WeakReference(e);
            this.f12552b = graphQLFriendshipStatus;
            this.f12553c = new WeakReference(cacheableEntity);
        }
    }

    /* compiled from: facewebPhotoButton */
    public class Props {
        public final PersonYouMayKnow f12554a;
        public final C17673 f12555b;
        public final Controller f12556c;
        public final CacheableEntity f12557d;

        public Props(PersonYouMayKnow personYouMayKnow, C17673 c17673, Controller controller, CacheableEntity cacheableEntity) {
            this.f12554a = personYouMayKnow;
            this.f12555b = c17673;
            this.f12556c = controller;
            this.f12557d = cacheableEntity;
        }
    }

    private static PeopleYouMayKnowPagePartDefinition m12547b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowPagePartDefinition(FriendingEventBus.a(injectorLike), PeopleYouMayKnowTextContainerPartDefinition.a(injectorLike), ProfilePicturePartDefinition.a(injectorLike), PeopleYouMayKnowBlacklistPartDefinition.m12500a(injectorLike), PeopleYouMayKnowFriendingButtonPartDefinition.m12511a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m12549a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        String valueOf = String.valueOf(props.f12554a.a());
        String b = props.f12554a.b();
        String a = m12545a(props.f12554a.e());
        String d = props.f12554a.d();
        GraphQLFriendshipStatus f = props.f12554a.f();
        subParts.a(2131561960, this.f12562c, new com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowTextContainerPartDefinition.Props(valueOf, b, a, d, (FriendshipPersistentState) ((HasPersistentState) canFriendPerson).a(new FriendshipContextStateKey(valueOf, f), props.f12557d)));
        subParts.a(2131561959, this.f12563d, new com.facebook.feedplugins.friendingcommon.ProfilePicturePartDefinition.Props(d, b));
        subParts.a(2131561964, this.f12564e, new com.facebook.timeline.pymk.rows.PeopleYouMayKnowBlacklistPartDefinition.Props(valueOf, f, props.f12555b, props.f12557d));
        subParts.a(2131561963, this.f12565f, new com.facebook.timeline.pymk.rows.PeopleYouMayKnowFriendingButtonPartDefinition.Props(valueOf, b, f, props.f12557d));
        this.f12561b.a(new FriendshipSubscriber((HasInvalidate) canFriendPerson, f, props.f12557d));
        return new PageSwitcherContextStateKey(props.f12557d.g());
    }

    public final /* bridge */ /* synthetic */ void m12550a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2076196173);
        m12546a((Props) obj, (PageSwitcherContextStateKey) obj2, (CanFriendPerson) anyEnvironment);
        Logger.a(8, EntryType.MARK_POP, 117240671, a);
    }

    public static PeopleYouMayKnowPagePartDefinition m12544a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12560i) {
                PeopleYouMayKnowPagePartDefinition peopleYouMayKnowPagePartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowPagePartDefinition = (PeopleYouMayKnowPagePartDefinition) a2.a(f12560i);
                } else {
                    peopleYouMayKnowPagePartDefinition = f12559h;
                }
                if (peopleYouMayKnowPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12547b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12560i, b3);
                        } else {
                            f12559h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowPagePartDefinition(FriendingEventBus friendingEventBus, PeopleYouMayKnowTextContainerPartDefinition peopleYouMayKnowTextContainerPartDefinition, ProfilePicturePartDefinition profilePicturePartDefinition, PeopleYouMayKnowBlacklistPartDefinition peopleYouMayKnowBlacklistPartDefinition, PeopleYouMayKnowFriendingButtonPartDefinition peopleYouMayKnowFriendingButtonPartDefinition, Resources resources) {
        this.f12561b = friendingEventBus;
        this.f12562c = peopleYouMayKnowTextContainerPartDefinition;
        this.f12563d = profilePicturePartDefinition;
        this.f12564e = peopleYouMayKnowBlacklistPartDefinition;
        this.f12565f = peopleYouMayKnowFriendingButtonPartDefinition;
        this.f12566g = resources;
    }

    public final ViewType<PersonYouMayKnowView> m12548a() {
        return f12558a;
    }

    private static void m12546a(Props props, PageSwitcherContextStateKey pageSwitcherContextStateKey, E e) {
        if (((Boolean) ((HasPersistentState) e).a(pageSwitcherContextStateKey, props.f12557d)).booleanValue()) {
            ((HasPersistentState) e).a(pageSwitcherContextStateKey, Boolean.valueOf(false));
            props.f12556c.a();
        }
    }

    private String m12545a(int i) {
        if (i <= 0) {
            return "";
        }
        return this.f12566g.getQuantityString(2131689520, i, new Object[]{Integer.valueOf(i)});
    }
}
