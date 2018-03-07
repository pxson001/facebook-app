package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.util.ReactionOpenBottomActionSheetHelper;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [%s]  */
public class ReactionOpenBottomActionSheetPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker & HasReactionSession> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> {
    private static ReactionOpenBottomActionSheetPartDefinition f20663c;
    private static final Object f20664d = new Object();
    private final ClickListenerPartDefinition f20665a;
    public final ReactionOpenBottomActionSheetHelper f20666b;

    /* compiled from: [%s]  */
    public class Props {
        public final ReactionStoryAttachmentActionFragmentModel f20660a;
        public final String f20661b;
        public final String f20662c;

        public Props(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, String str, String str2) {
            this.f20660a = reactionStoryAttachmentActionFragmentModel;
            this.f20661b = str;
            this.f20662c = str2;
        }
    }

    private static ReactionOpenBottomActionSheetPartDefinition m24342b(InjectorLike injectorLike) {
        return new ReactionOpenBottomActionSheetPartDefinition(ClickListenerPartDefinition.a(injectorLike), new ReactionOpenBottomActionSheetHelper(ReactionActionHandler.m22673a(injectorLike)));
    }

    public final Object m24343a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        subParts.a(this.f20665a, new OnClickListener(this) {
            final /* synthetic */ ReactionOpenBottomActionSheetPartDefinition f20659c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2075408562);
                this.f20659c.f20666b.m24367a(props.f20660a, canLaunchReactionIntent, ((HasContext) canLaunchReactionIntent).getContext(), (HasReactionInteractionTracker) canLaunchReactionIntent, (HasReactionSession) canLaunchReactionIntent, props.f20661b, props.f20662c);
                Logger.a(2, EntryType.UI_INPUT_END, 236670881, a);
            }
        });
        return null;
    }

    @Inject
    public ReactionOpenBottomActionSheetPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ReactionOpenBottomActionSheetHelper reactionOpenBottomActionSheetHelper) {
        this.f20665a = clickListenerPartDefinition;
        this.f20666b = reactionOpenBottomActionSheetHelper;
    }

    public static ReactionOpenBottomActionSheetPartDefinition m24341a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionOpenBottomActionSheetPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20664d) {
                ReactionOpenBottomActionSheetPartDefinition reactionOpenBottomActionSheetPartDefinition;
                if (a2 != null) {
                    reactionOpenBottomActionSheetPartDefinition = (ReactionOpenBottomActionSheetPartDefinition) a2.a(f20664d);
                } else {
                    reactionOpenBottomActionSheetPartDefinition = f20663c;
                }
                if (reactionOpenBottomActionSheetPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24342b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20664d, b3);
                        } else {
                            f20663c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionOpenBottomActionSheetPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
