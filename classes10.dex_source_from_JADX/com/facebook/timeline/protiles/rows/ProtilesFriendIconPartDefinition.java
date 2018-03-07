package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: featured_container */
public class ProtilesFriendIconPartDefinition<E extends CanFriendPerson> extends BaseSinglePartDefinition<Props, Drawable, E, ImageView> {
    private static ProtilesFriendIconPartDefinition f12200c;
    private static final Object f12201d = new Object();
    private final ClickListenerPartDefinition f12202a;
    private final ProtilesFriendingUtil f12203b;

    private static ProtilesFriendIconPartDefinition m12297b(InjectorLike injectorLike) {
        return new ProtilesFriendIconPartDefinition(ClickListenerPartDefinition.a(injectorLike), ProtilesFriendingUtil.m12411a(injectorLike));
    }

    public final Object m12298a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        GraphQLFriendshipStatus m = props.f12275b.m12180b().m12156m();
        if (m != GraphQLFriendshipStatus.ARE_FRIENDS) {
            subParts.a(this.f12202a, this.f12203b.m12416a(props.f12274a, props.f12275b, canFriendPerson));
        }
        return this.f12203b.m12417b(m);
    }

    public final /* bridge */ /* synthetic */ void m12299a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 739294268);
        ((ImageView) view).setImageDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, -1370839545, a);
    }

    @Inject
    public ProtilesFriendIconPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ProtilesFriendingUtil protilesFriendingUtil) {
        this.f12202a = clickListenerPartDefinition;
        this.f12203b = protilesFriendingUtil;
    }

    public static ProtilesFriendIconPartDefinition m12296a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesFriendIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12201d) {
                ProtilesFriendIconPartDefinition protilesFriendIconPartDefinition;
                if (a2 != null) {
                    protilesFriendIconPartDefinition = (ProtilesFriendIconPartDefinition) a2.a(f12201d);
                } else {
                    protilesFriendIconPartDefinition = f12200c;
                }
                if (protilesFriendIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12297b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12201d, b3);
                        } else {
                            f12200c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesFriendIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
