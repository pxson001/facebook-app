package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
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
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowHScrollPartDefinition.C17673;
import javax.inject.Inject;

@ContextScoped
/* compiled from: facewebmodal/f?href={%s} */
public class PeopleYouMayKnowBlacklistPartDefinition<E extends HasPersistentState> extends BaseSinglePartDefinition<Props, GraphQLFriendshipStatus, E, SmartButtonLite> {
    public static final CallerContext f12478a = CallerContext.a(PeopleYouMayKnowBlacklistPartDefinition.class);
    private static PeopleYouMayKnowBlacklistPartDefinition f12479h;
    private static final Object f12480i = new Object();
    private final AllCapsTransformationMethod f12481b;
    private final ClickListenerPartDefinition f12482c;
    public final FriendingClient f12483d;
    public final FriendingEventBus f12484e;
    private final Resources f12485f;
    private final SmartButtonPartDefinition f12486g;

    /* compiled from: facewebmodal/f?href={%s} */
    public class Props {
        public final String f12474a;
        public final GraphQLFriendshipStatus f12475b;
        public final C17673 f12476c;
        public final CacheableEntity f12477d;

        public Props(String str, GraphQLFriendshipStatus graphQLFriendshipStatus, C17673 c17673, CacheableEntity cacheableEntity) {
            this.f12474a = str;
            this.f12475b = graphQLFriendshipStatus;
            this.f12476c = c17673;
            this.f12477d = cacheableEntity;
        }
    }

    private static PeopleYouMayKnowBlacklistPartDefinition m12501b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowBlacklistPartDefinition(AllCapsTransformationMethod.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), FriendingClient.b(injectorLike), FriendingEventBus.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), SmartButtonPartDefinition.a(injectorLike));
    }

    public final Object m12502a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        ClickListenerPartDefinition clickListenerPartDefinition = this.f12482c;
        final String str = props.f12474a;
        final C17673 c17673 = props.f12476c;
        subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ PeopleYouMayKnowBlacklistPartDefinition f12473c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1591201623);
                C17673 c17673 = c17673;
                PeopleYouMayKnowModel peopleYouMayKnowModel = c17673.f12522a;
                peopleYouMayKnowModel.f12468a.remove(c17673.f12523b);
                ((HasInvalidate) c17673.f12524c).a(new Object[]{c17673.f12522a});
                this.f12473c.f12483d.a(Long.parseLong(str), PeopleYouMayKnowBlacklistPartDefinition.f12478a);
                this.f12473c.f12484e.a(new PYMKBlacklistedEvent(Long.parseLong(str)));
                Logger.a(2, EntryType.UI_INPUT_END, 242181159, a);
            }
        });
        subParts.a(this.f12486g, new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(this.f12481b.getTransformation(this.f12485f.getString(2131235588), null), null, 2130839818, Integer.valueOf(this.f12485f.getColor(2131362106)), 0, 2130840353));
        return ((FriendshipPersistentState) hasPersistentState.a(new FriendshipContextStateKey(props.f12474a, props.f12475b), props.f12477d)).a;
    }

    public final /* bridge */ /* synthetic */ void m12503a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1894333973);
        SmartButtonLite smartButtonLite = (SmartButtonLite) view;
        if (((GraphQLFriendshipStatus) obj2) == GraphQLFriendshipStatus.CAN_REQUEST) {
            smartButtonLite.setVisibility(0);
        } else {
            smartButtonLite.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, -10146113, a);
    }

    public static PeopleYouMayKnowBlacklistPartDefinition m12500a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowBlacklistPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12480i) {
                PeopleYouMayKnowBlacklistPartDefinition peopleYouMayKnowBlacklistPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowBlacklistPartDefinition = (PeopleYouMayKnowBlacklistPartDefinition) a2.a(f12480i);
                } else {
                    peopleYouMayKnowBlacklistPartDefinition = f12479h;
                }
                if (peopleYouMayKnowBlacklistPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12501b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12480i, b3);
                        } else {
                            f12479h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowBlacklistPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowBlacklistPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, ClickListenerPartDefinition clickListenerPartDefinition, FriendingClient friendingClient, FriendingEventBus friendingEventBus, Resources resources, SmartButtonPartDefinition smartButtonPartDefinition) {
        this.f12481b = allCapsTransformationMethod;
        this.f12482c = clickListenerPartDefinition;
        this.f12483d = friendingClient;
        this.f12484e = friendingEventBus;
        this.f12485f = resources;
        this.f12486g = smartButtonPartDefinition;
    }
}
