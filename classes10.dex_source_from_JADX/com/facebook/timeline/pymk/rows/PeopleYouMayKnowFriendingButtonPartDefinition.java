package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.PageSwitcherContextStateKey;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.ui.SmartButtonLite;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ContentDescriptionPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: faceweb_view */
public class PeopleYouMayKnowFriendingButtonPartDefinition<E extends CanFriendPerson & HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, GraphQLFriendshipStatus, E, SmartButtonLite> {
    private static PeopleYouMayKnowFriendingButtonPartDefinition f12505f;
    private static final Object f12506g = new Object();
    public final AllCapsTransformationMethod f12507a;
    private final ClickListenerPartDefinition f12508b;
    private final ContentDescriptionPartDefinition f12509c;
    private final SmartButtonPartDefinition f12510d;
    public final Resources f12511e;

    /* compiled from: faceweb_view */
    public /* synthetic */ class C17642 {
        public static final /* synthetic */ int[] f12500a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f12500a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12500a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12500a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12500a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: faceweb_view */
    public class Props {
        public final String f12501a;
        public final String f12502b;
        public final GraphQLFriendshipStatus f12503c;
        public final CacheableEntity f12504d;

        public Props(String str, String str2, GraphQLFriendshipStatus graphQLFriendshipStatus, CacheableEntity cacheableEntity) {
            this.f12501a = str;
            this.f12502b = str2;
            this.f12503c = graphQLFriendshipStatus;
            this.f12504d = cacheableEntity;
        }
    }

    private static PeopleYouMayKnowFriendingButtonPartDefinition m12513b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowFriendingButtonPartDefinition(AllCapsTransformationMethod.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), ContentDescriptionPartDefinition.a(injectorLike), SmartButtonPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m12514a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        FriendshipContextStateKey friendshipContextStateKey = new FriendshipContextStateKey(props.f12501a, props.f12503c);
        GraphQLFriendshipStatus graphQLFriendshipStatus = ((FriendshipPersistentState) ((HasPersistentState) canFriendPerson).a(friendshipContextStateKey, props.f12504d)).a;
        if (m12512a(graphQLFriendshipStatus)) {
            com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props props2;
            switch (C17642.f12500a[graphQLFriendshipStatus.ordinal()]) {
                case 1:
                case 2:
                    props2 = new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(this.f12507a.getTransformation(this.f12511e.getString(2131233212), null), this.f12507a.getTransformation(this.f12511e.getString(2131233213), null), 2130840447, Integer.valueOf(this.f12511e.getColor(2131361920)), 0, 2130840349);
                    break;
                case 3:
                    props2 = new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(this.f12507a.getTransformation(this.f12511e.getString(2131233214), null), this.f12507a.getTransformation(this.f12511e.getString(2131230727), null), 2130839891, Integer.valueOf(this.f12511e.getColor(2131362106)), 0, 2130840353);
                    break;
                case 4:
                    props2 = new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(this.f12507a.getTransformation(this.f12511e.getString(2131233209), null), null, 2130840452, Integer.valueOf(this.f12511e.getColor(2131362106)), 0, 2130840353);
                    break;
                default:
                    props2 = new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(null, null, 0, null, 0, 0);
                    break;
            }
            com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props props3 = props2;
            subParts.a(this.f12509c, props3.a);
            subParts.a(this.f12508b, m12510a(props, canFriendPerson, friendshipContextStateKey));
            subParts.a(this.f12510d, props3);
        }
        return graphQLFriendshipStatus;
    }

    public final /* bridge */ /* synthetic */ void m12515a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 496634102);
        SmartButtonLite smartButtonLite = (SmartButtonLite) view;
        if (m12512a((GraphQLFriendshipStatus) obj2)) {
            smartButtonLite.setVisibility(0);
        } else {
            smartButtonLite.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, -1352856738, a);
    }

    public static PeopleYouMayKnowFriendingButtonPartDefinition m12511a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowFriendingButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12506g) {
                PeopleYouMayKnowFriendingButtonPartDefinition peopleYouMayKnowFriendingButtonPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowFriendingButtonPartDefinition = (PeopleYouMayKnowFriendingButtonPartDefinition) a2.a(f12506g);
                } else {
                    peopleYouMayKnowFriendingButtonPartDefinition = f12505f;
                }
                if (peopleYouMayKnowFriendingButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12513b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12506g, b3);
                        } else {
                            f12505f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowFriendingButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowFriendingButtonPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, ClickListenerPartDefinition clickListenerPartDefinition, ContentDescriptionPartDefinition contentDescriptionPartDefinition, SmartButtonPartDefinition smartButtonPartDefinition, Resources resources) {
        this.f12507a = allCapsTransformationMethod;
        this.f12508b = clickListenerPartDefinition;
        this.f12509c = contentDescriptionPartDefinition;
        this.f12510d = smartButtonPartDefinition;
        this.f12511e = resources;
    }

    public static boolean m12512a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        return graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS || graphQLFriendshipStatus == GraphQLFriendshipStatus.INCOMING_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST;
    }

    private OnClickListener m12510a(final Props props, final E e, final FriendshipContextStateKey friendshipContextStateKey) {
        return new OnClickListener(this) {
            final /* synthetic */ PeopleYouMayKnowFriendingButtonPartDefinition f12499d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 568466807);
                final FriendshipPersistentState friendshipPersistentState = (FriendshipPersistentState) ((HasPersistentState) e).a(friendshipContextStateKey, props.f12504d);
                if (friendshipPersistentState.a == GraphQLFriendshipStatus.CAN_REQUEST) {
                    ((HasPersistentState) e).a(new PageSwitcherContextStateKey(props.f12504d.g()), Boolean.valueOf(true));
                }
                FriendshipStatus a2 = e.a(props.f12501a, props.f12502b, FriendingLocation.PYMK_TIMELINE, friendshipPersistentState.a, new FriendingButtonControllerCallback(this) {
                    final /* synthetic */ C17631 f12495b;

                    public final void m12509a() {
                        ((HasPersistentState) e).a(friendshipContextStateKey, friendshipPersistentState);
                        ((HasInvalidate) e).a(new Object[]{props.f12504d});
                    }
                });
                ((HasPersistentState) e).a(friendshipContextStateKey, new FriendshipPersistentState(a2.a, a2.b));
                ((HasInvalidate) e).a(new Object[]{props.f12504d});
                Logger.a(2, EntryType.UI_INPUT_END, -1328357162, a);
            }
        };
    }
}
