package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.today.common.HasNotifications;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [J */
public class ReactionHideRichNotifActionPartDefinition<E extends HasContext & HasInvalidate & HasNotifications & HasReactionInteractionTracker> extends BaseSinglePartDefinition<Props, Void, E, View> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionHideRichNotifActionPartDefinition f20624f;
    private static final Object f20625g = new Object();
    private final ClickListenerPartDefinition f20626a;
    private final ReactionDrawableIconPartDefinition f20627b;
    public final Handler f20628c;
    private final HighlightViewOnTouchListenerPartDefinition f20629d;
    private final TextPartDefinition f20630e;

    private static ReactionHideRichNotifActionPartDefinition m24322b(InjectorLike injectorLike) {
        return new ReactionHideRichNotifActionPartDefinition(Handler_ForUiThreadMethodAutoProvider.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), ReactionDrawableIconPartDefinition.m24306a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m24323a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        final String str = props.f20671b.f18863c;
        final FeedProps c = FeedProps.c(props.f20671b);
        final HasContext hasContext2 = hasContext;
        final Props props2 = props;
        subParts.a(this.f20626a, new OnClickListener(this) {
            final /* synthetic */ ReactionHideRichNotifActionPartDefinition f20623e;

            /* compiled from: [J */
            class C21871 implements Runnable {
                final /* synthetic */ C21881 f20618a;

                C21871(C21881 c21881) {
                    this.f20618a = c21881;
                }

                public void run() {
                    if (((HasNotifications) hasContext2).mo977a(str, true)) {
                        ((HasInvalidate) hasContext2).a(new FeedProps[]{c});
                    }
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1993223327);
                HandlerDetour.b(this.f20623e.f20628c, new C21871(this), 2000, 1399998440);
                ((HasInvalidate) hasContext2).a(new FeedProps[]{c});
                ((HasNotifications) hasContext2).mo978b(props2.f20671b.f18863c);
                ((HasReactionInteractionTracker) hasContext2).kE_().mo984a(props2.f20671b.f18863c, props2.f20671b.f18864d, null, UnitInteractionType.UNHIGHLIGHT_RICH_NOTIFICATION_TAP);
                Logger.a(2, EntryType.UI_INPUT_END, -1285715720, a);
            }
        });
        subParts.a(2131566666, this.f20630e, hasContext.getContext().getString(2131237293));
        subParts.a(this.f20629d, null);
        subParts.a(2131566665, this.f20627b, new ReactionDrawableIconPartDefinition.Props(null));
        return null;
    }

    public final boolean m24324a(Object obj) {
        return ((Props) obj).f20670a.j() == GraphQLReactionStoryActionStyle.UNHIGHLIGHT_RICH_NOTIF;
    }

    @Inject
    public ReactionHideRichNotifActionPartDefinition(Handler handler, ClickListenerPartDefinition clickListenerPartDefinition, ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, TextPartDefinition textPartDefinition) {
        this.f20628c = handler;
        this.f20626a = clickListenerPartDefinition;
        this.f20627b = reactionDrawableIconPartDefinition;
        this.f20629d = highlightViewOnTouchListenerPartDefinition;
        this.f20630e = textPartDefinition;
    }

    public static ReactionHideRichNotifActionPartDefinition m24321a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHideRichNotifActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20625g) {
                ReactionHideRichNotifActionPartDefinition reactionHideRichNotifActionPartDefinition;
                if (a2 != null) {
                    reactionHideRichNotifActionPartDefinition = (ReactionHideRichNotifActionPartDefinition) a2.a(f20625g);
                } else {
                    reactionHideRichNotifActionPartDefinition = f20624f;
                }
                if (reactionHideRichNotifActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24322b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20625g, b3);
                        } else {
                            f20624f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHideRichNotifActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
