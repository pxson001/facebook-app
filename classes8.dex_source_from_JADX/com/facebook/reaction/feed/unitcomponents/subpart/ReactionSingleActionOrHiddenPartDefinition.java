package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [%s] */
public class ReactionSingleActionOrHiddenPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasPersistentState & HasReactionAnalyticsParams & HasReactionInteractionTracker & HasReactionSession & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionSingleActionOrHiddenPartDefinition f20667b;
    private static final Object f20668c = new Object();
    private final ReactionSingleActionSelectorPartDefinition<E> f20669a;

    private static ReactionSingleActionOrHiddenPartDefinition m24345b(InjectorLike injectorLike) {
        return new ReactionSingleActionOrHiddenPartDefinition(ReactionSingleActionSelectorPartDefinition.m24351a(injectorLike));
    }

    public final Object m24346a(SubParts subParts, @Nullable Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        if (props != null) {
            subParts.a(this.f20669a, props);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m24347a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 356605773);
        ((LinearLayout) view).setVisibility(((Props) obj) == null ? 8 : 0);
        Logger.a(8, EntryType.MARK_POP, 1837238611, a);
    }

    @Inject
    public ReactionSingleActionOrHiddenPartDefinition(ReactionSingleActionSelectorPartDefinition reactionSingleActionSelectorPartDefinition) {
        this.f20669a = reactionSingleActionSelectorPartDefinition;
    }

    public final boolean m24348a(@Nullable Props props) {
        return props == null || this.f20669a.m24354a(props);
    }

    public static ReactionSingleActionOrHiddenPartDefinition m24344a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleActionOrHiddenPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20668c) {
                ReactionSingleActionOrHiddenPartDefinition reactionSingleActionOrHiddenPartDefinition;
                if (a2 != null) {
                    reactionSingleActionOrHiddenPartDefinition = (ReactionSingleActionOrHiddenPartDefinition) a2.a(f20668c);
                } else {
                    reactionSingleActionOrHiddenPartDefinition = f20667b;
                }
                if (reactionSingleActionOrHiddenPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24345b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20668c, b3);
                        } else {
                            f20667b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleActionOrHiddenPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
