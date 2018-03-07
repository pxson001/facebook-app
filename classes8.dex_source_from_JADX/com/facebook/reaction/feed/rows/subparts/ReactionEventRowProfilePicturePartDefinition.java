package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventBaseFragment;
import com.facebook.events.widget.eventrow.EventRowProfilePictureView;
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

@ContextScoped
/* compiled from: annotation_rich_text */
public class ReactionEventRowProfilePicturePartDefinition extends BaseSinglePartDefinition<EventBaseFragment, Void, AnyEnvironment, EventRowProfilePictureView> {
    private static ReactionEventRowProfilePicturePartDefinition f19420a;
    private static final Object f19421b = new Object();

    private static ReactionEventRowProfilePicturePartDefinition m23404a() {
        return new ReactionEventRowProfilePicturePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23406a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -400939906);
        EventBaseFragment eventBaseFragment = (EventBaseFragment) obj;
        ((EventRowProfilePictureView) view).m13427a(Uri.parse(eventBaseFragment.c().b()), EventsDateUtil.b(eventBaseFragment.dN_()), "reaction_events");
        Logger.a(8, EntryType.MARK_POP, 1380122707, a);
    }

    public static ReactionEventRowProfilePicturePartDefinition m23405a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventRowProfilePicturePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19421b) {
                ReactionEventRowProfilePicturePartDefinition reactionEventRowProfilePicturePartDefinition;
                if (a3 != null) {
                    reactionEventRowProfilePicturePartDefinition = (ReactionEventRowProfilePicturePartDefinition) a3.a(f19421b);
                } else {
                    reactionEventRowProfilePicturePartDefinition = f19420a;
                }
                if (reactionEventRowProfilePicturePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23404a();
                        if (a3 != null) {
                            a3.a(f19421b, a2);
                        } else {
                            f19420a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionEventRowProfilePicturePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
