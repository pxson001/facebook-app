package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCardFragment;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentActionPartDefinition.Props;
import com.facebook.reaction.feed.rows.subparts.ReactionEventRowProfilePicturePartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ar_code_submitted */
public class ReactionEventBlocksAttachmentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, E, ContentView> {
    public static final ViewType<ContentView> f19337a = ViewType.a(2130906688);
    private static ReactionEventBlocksAttachmentPartDefinition f19338i;
    private static final Object f19339j = new Object();
    private final ContentViewSubtitlePartDefinition f19340b;
    private final ContentViewTitlePartDefinition f19341c;
    public final EventsDashboardTimeFormatUtil f19342d;
    private final ReactionEventRowProfilePicturePartDefinition f19343e;
    private final HighlightViewOnTouchListenerPartDefinition f19344f;
    private final ReactionAttachmentActionPartDefinition f19345g;
    private final ReactionIntentFactory f19346h;

    private static ReactionEventBlocksAttachmentPartDefinition m23342b(InjectorLike injectorLike) {
        return new ReactionEventBlocksAttachmentPartDefinition(ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), EventsDashboardTimeFormatUtil.a(injectorLike), ReactionEventRowProfilePicturePartDefinition.m23405a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), ReactionAttachmentActionPartDefinition.m23324a(injectorLike), ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23344a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        EventCardFragment n = reactionAttachmentNode.f18832a.n();
        subParts.a(this.f19344f, null);
        subParts.a(this.f19341c, n.dM_());
        subParts.a(this.f19340b, this.f19342d.a(n.g(), EventsDateUtil.b(n.dN_()), EventsDateUtil.c(n.b())));
        subParts.a(2131566741, this.f19343e, n);
        subParts.a(this.f19345g, new Props(this.f19346h.m22738a(n.dL_()), reactionAttachmentNode.f18833b, reactionAttachmentNode.f18834c));
        return null;
    }

    public final boolean m23345a(Object obj) {
        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = ((ReactionAttachmentNode) obj).f18832a;
        return (reactionStoryAttachmentFragmentModel.n() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dL_()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().dM_()) || !EventsDateUtil.a(reactionStoryAttachmentFragmentModel.n().dN_()) || reactionStoryAttachmentFragmentModel.n().c() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.n().c().b())) ? false : true;
    }

    public static ReactionEventBlocksAttachmentPartDefinition m23341a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventBlocksAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19339j) {
                ReactionEventBlocksAttachmentPartDefinition reactionEventBlocksAttachmentPartDefinition;
                if (a2 != null) {
                    reactionEventBlocksAttachmentPartDefinition = (ReactionEventBlocksAttachmentPartDefinition) a2.a(f19339j);
                } else {
                    reactionEventBlocksAttachmentPartDefinition = f19338i;
                }
                if (reactionEventBlocksAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23342b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19339j, b3);
                        } else {
                            f19338i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionEventBlocksAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionEventBlocksAttachmentPartDefinition(ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, ReactionEventRowProfilePicturePartDefinition reactionEventRowProfilePicturePartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, ReactionAttachmentActionPartDefinition reactionAttachmentActionPartDefinition, ReactionIntentFactory reactionIntentFactory) {
        this.f19340b = contentViewSubtitlePartDefinition;
        this.f19341c = contentViewTitlePartDefinition;
        this.f19342d = eventsDashboardTimeFormatUtil;
        this.f19343e = reactionEventRowProfilePicturePartDefinition;
        this.f19344f = highlightViewOnTouchListenerPartDefinition;
        this.f19345g = reactionAttachmentActionPartDefinition;
        this.f19346h = reactionIntentFactory;
    }

    public final ViewType<ContentView> m23343a() {
        return f19337a;
    }
}
