package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feedplugins.friendingcommon.ProfilePicturePartDefinition;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.feedplugins.pymk.fetcher.PaginatedPYMKFeedUnitFetcher;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowTextContainerPartDefinition.Props;
import com.facebook.feedplugins.pymk.rows.components.PeopleYouMayKnowFeedUnitItems;
import com.facebook.feedplugins.pymk.views.rows.PersonYouMayKnowView;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItemUtil;
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
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifs_inline_actions_seen */
public class PersonYouMayKnowPagePartDefinition<E extends CanFriendPerson & HasInvalidate & HasPersistentState & HasRowKey & HasPrefetcher> extends BaseSinglePartDefinitionWithViewType<Props, FriendingStatusChanged<E>, E, PersonYouMayKnowView> {
    public static final ViewType<PersonYouMayKnowView> f6691a = new C03081();
    private static PersonYouMayKnowPagePartDefinition f6692h;
    private static final Object f6693i = new Object();
    private final PaginatedPYMKFeedUnitFetcher f6694b;
    private final FriendingEventBus f6695c;
    private final PeopleYouMayKnowFriendButtonPartDefinition<E> f6696d;
    private final PeopleYouMayKnowTextContainerPartDefinition f6697e;
    private final PeopleYouMayKnowBlacklistPartDefinition<E> f6698f;
    private final ProfilePicturePartDefinition<E> f6699g;

    /* compiled from: notifs_inline_actions_seen */
    final class C03081 extends ViewType<PersonYouMayKnowView> {
        C03081() {
        }

        public final View m7094a(Context context) {
            return new PersonYouMayKnowView(context);
        }
    }

    private static PersonYouMayKnowPagePartDefinition m7090b(InjectorLike injectorLike) {
        return new PersonYouMayKnowPagePartDefinition(PaginatedPYMKFeedUnitFetcher.a(injectorLike), FriendingEventBus.a(injectorLike), PeopleYouMayKnowFriendButtonPartDefinition.a(injectorLike), PeopleYouMayKnowTextContainerPartDefinition.a(injectorLike), PeopleYouMayKnowBlacklistPartDefinition.a(injectorLike), ProfilePicturePartDefinition.a(injectorLike));
    }

    public final Object m7092a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        Props props = (Props) obj;
        CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        FriendshipPersistentState friendshipPersistentState = (FriendshipPersistentState) ((HasPersistentState) canFriendPerson).a(new FriendshipContextStateKey(props.b.l(), PeopleYouMayKnowFeedUnitItemUtil.a(props.b)), props.a);
        PeopleYouMayKnowTextContainerPartDefinition peopleYouMayKnowTextContainerPartDefinition = this.f6697e;
        String l = props.b.l();
        String c = PeopleYouMayKnowFeedUnitItems.c(props.b);
        GraphQLTextWithEntities n = props.b.n();
        if (n == null) {
            str = "";
        } else {
            str = n.a();
        }
        subParts.a(2131561960, peopleYouMayKnowTextContainerPartDefinition, new Props(l, c, str, PeopleYouMayKnowFeedUnitItems.a(props.b), friendshipPersistentState));
        subParts.a(2131561963, this.f6696d, new PeopleYouMayKnowFriendButtonPartDefinition.Props(props.a, props.b, friendshipPersistentState, props.c));
        subParts.a(2131561964, this.f6698f, new PeopleYouMayKnowBlacklistPartDefinition.Props(props.a, props.b, friendshipPersistentState));
        subParts.a(2131561959, this.f6699g, new ProfilePicturePartDefinition.Props(PeopleYouMayKnowFeedUnitItems.a(props.b), PeopleYouMayKnowFeedUnitItems.c(props.b)));
        FriendingStatusChanged friendingStatusChanged = new FriendingStatusChanged(new WeakReference(props.a), new WeakReference(props.b), new WeakReference(canFriendPerson));
        this.f6695c.a(friendingStatusChanged);
        return friendingStatusChanged;
    }

    public final /* bridge */ /* synthetic */ void m7093a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 950444551);
        m7088a((Props) obj);
        Logger.a(8, EntryType.MARK_POP, 43398664, a);
    }

    public static PersonYouMayKnowPagePartDefinition m7087a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonYouMayKnowPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6693i) {
                PersonYouMayKnowPagePartDefinition personYouMayKnowPagePartDefinition;
                if (a2 != null) {
                    personYouMayKnowPagePartDefinition = (PersonYouMayKnowPagePartDefinition) a2.a(f6693i);
                } else {
                    personYouMayKnowPagePartDefinition = f6692h;
                }
                if (personYouMayKnowPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7090b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6693i, b3);
                        } else {
                            f6692h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = personYouMayKnowPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PersonYouMayKnowPagePartDefinition(PaginatedPYMKFeedUnitFetcher paginatedPYMKFeedUnitFetcher, FriendingEventBus friendingEventBus, PeopleYouMayKnowFriendButtonPartDefinition peopleYouMayKnowFriendButtonPartDefinition, PeopleYouMayKnowTextContainerPartDefinition peopleYouMayKnowTextContainerPartDefinition, PeopleYouMayKnowBlacklistPartDefinition peopleYouMayKnowBlacklistPartDefinition, ProfilePicturePartDefinition profilePicturePartDefinition) {
        this.f6694b = paginatedPYMKFeedUnitFetcher;
        this.f6695c = friendingEventBus;
        this.f6696d = peopleYouMayKnowFriendButtonPartDefinition;
        this.f6697e = peopleYouMayKnowTextContainerPartDefinition;
        this.f6698f = peopleYouMayKnowBlacklistPartDefinition;
        this.f6699g = profilePicturePartDefinition;
    }

    public final ViewType<PersonYouMayKnowView> m7091a() {
        return f6691a;
    }

    private void m7088a(Props props) {
        m7089a(props.a);
    }

    private void m7089a(PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit) {
        int ac_ = peopleYouMayKnowFeedUnit.ac_();
        if (peopleYouMayKnowFeedUnit instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) peopleYouMayKnowFeedUnit;
            if (!this.f6694b.a(graphQLPaginatedPeopleYouMayKnowFeedUnit, ac_)) {
                return;
            }
            if (PaginatedPYMKFeedUnitFetcher.a(graphQLPaginatedPeopleYouMayKnowFeedUnit)) {
                this.f6694b.b(graphQLPaginatedPeopleYouMayKnowFeedUnit);
            } else {
                this.f6694b.c(graphQLPaginatedPeopleYouMayKnowFeedUnit);
            }
        }
    }
}
