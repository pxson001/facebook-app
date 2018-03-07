package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
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
import com.facebook.timeline.protiles.rows.ProtilesListRowPartDefinition.Props;
import com.facebook.timeline.protiles.util.ProtilesFriendingUtil;
import com.facebook.ufiservices.ui.SmartFriendingButtonBinder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: featured_containers */
public class ProtilesFriendButtonPartDefinition<E extends CanFriendPerson> extends BaseSinglePartDefinition<Props, GraphQLFriendshipStatus, E, SmartButtonLite> {
    private static ProtilesFriendButtonPartDefinition f12195d;
    private static final Object f12196e = new Object();
    private final ClickListenerPartDefinition f12197a;
    private final ProtilesFriendingUtil f12198b;
    private final SmartFriendingButtonBinder f12199c = new SmartFriendingButtonBinder();

    private static ProtilesFriendButtonPartDefinition m12293b(InjectorLike injectorLike) {
        return new ProtilesFriendButtonPartDefinition(ClickListenerPartDefinition.a(injectorLike), ProtilesFriendingUtil.m12411a(injectorLike));
    }

    public final Object m12294a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        GraphQLFriendshipStatus m = props.f12275b.m12180b().m12156m();
        if (m != GraphQLFriendshipStatus.ARE_FRIENDS) {
            subParts.a(this.f12197a, this.f12198b.m12416a(props.f12274a, props.f12275b, canFriendPerson));
        }
        return m;
    }

    public final /* bridge */ /* synthetic */ void m12295a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 232220190);
        GraphQLFriendshipStatus graphQLFriendshipStatus = (GraphQLFriendshipStatus) obj2;
        SmartButtonLite smartButtonLite = (SmartButtonLite) view;
        SmartFriendingButtonBinder.a(smartButtonLite, graphQLFriendshipStatus);
        smartButtonLite.setClickable(graphQLFriendshipStatus != GraphQLFriendshipStatus.ARE_FRIENDS);
        Logger.a(8, EntryType.MARK_POP, -626681046, a);
    }

    @Inject
    public ProtilesFriendButtonPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ProtilesFriendingUtil protilesFriendingUtil) {
        this.f12197a = clickListenerPartDefinition;
        this.f12198b = protilesFriendingUtil;
    }

    public static ProtilesFriendButtonPartDefinition m12292a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesFriendButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12196e) {
                ProtilesFriendButtonPartDefinition protilesFriendButtonPartDefinition;
                if (a2 != null) {
                    protilesFriendButtonPartDefinition = (ProtilesFriendButtonPartDefinition) a2.a(f12196e);
                } else {
                    protilesFriendButtonPartDefinition = f12195d;
                }
                if (protilesFriendButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12293b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12196e, b3);
                        } else {
                            f12195d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesFriendButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
