package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentActionPartDefinition.Props;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: appcache */
public class ReactionProfileStoryImageBlockPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends BaseSinglePartDefinition<ReactionAttachmentNode, Void, E, ImageBlockLayout> {
    private static ReactionProfileStoryImageBlockPartDefinition f19363g;
    private static final Object f19364h = new Object();
    private final ReactionAttachmentActionPartDefinition f19365a;
    private final DefaultTimeFormatUtil f19366b;
    private final HighlightViewOnTouchListenerPartDefinition f19367c;
    private final ImageBlockLayoutIconPartDefinition f19368d;
    private final ReactionIntentFactory f19369e;
    private final TextPartDefinition f19370f;

    private static ReactionProfileStoryImageBlockPartDefinition m23370b(InjectorLike injectorLike) {
        return new ReactionProfileStoryImageBlockPartDefinition(ReactionAttachmentActionPartDefinition.m23324a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), ReactionIntentFactory.m22683a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23371a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = reactionAttachmentNode.f18832a;
        subParts.a(2131566618, this.f19370f, m23369a(reactionStoryAttachmentFragmentModel, ((HasContext) canLaunchReactionIntent).getContext()));
        subParts.a(2131566619, this.f19370f, this.f19366b.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, reactionStoryAttachmentFragmentModel.W().d() * 1000));
        subParts.a(this.f19365a, new Props(m23367a(reactionStoryAttachmentFragmentModel), reactionAttachmentNode.f18833b, reactionAttachmentNode.f18834c));
        subParts.a(this.f19367c, null);
        ActorsModel actorsModel = (ActorsModel) reactionStoryAttachmentFragmentModel.W().b().get(0);
        if (!(actorsModel.c() == null || actorsModel.c().b() == null)) {
            subParts.a(this.f19368d, actorsModel.c().b());
        }
        return null;
    }

    @Inject
    public ReactionProfileStoryImageBlockPartDefinition(ReactionAttachmentActionPartDefinition reactionAttachmentActionPartDefinition, DefaultTimeFormatUtil defaultTimeFormatUtil, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, ReactionIntentFactory reactionIntentFactory, TextPartDefinition textPartDefinition) {
        this.f19365a = reactionAttachmentActionPartDefinition;
        this.f19366b = defaultTimeFormatUtil;
        this.f19367c = highlightViewOnTouchListenerPartDefinition;
        this.f19368d = imageBlockLayoutIconPartDefinition;
        this.f19369e = reactionIntentFactory;
        this.f19370f = textPartDefinition;
    }

    public static ReactionProfileStoryImageBlockPartDefinition m23368a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionProfileStoryImageBlockPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19364h) {
                ReactionProfileStoryImageBlockPartDefinition reactionProfileStoryImageBlockPartDefinition;
                if (a2 != null) {
                    reactionProfileStoryImageBlockPartDefinition = (ReactionProfileStoryImageBlockPartDefinition) a2.a(f19364h);
                } else {
                    reactionProfileStoryImageBlockPartDefinition = f19363g;
                }
                if (reactionProfileStoryImageBlockPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23370b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19364h, b3);
                        } else {
                            f19363g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionProfileStoryImageBlockPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private ReactionAttachmentIntent m23367a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ReactionStoryAttachmentStoryFragmentModel W = reactionStoryAttachmentFragmentModel.W();
        return this.f19369e.m22748a(W.g(), W.c(), W.eN_().a(), UnitInteractionType.STORY_TAP);
    }

    private static CharSequence m23369a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, Context context) {
        ReactionStoryAttachmentStoryFragmentModel W = reactionStoryAttachmentFragmentModel.W();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((ActorsModel) W.b().get(0)).b());
        CharSequence charSequence = null;
        if (reactionStoryAttachmentFragmentModel.z() != null && !Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.z().a())) {
            charSequence = reactionStoryAttachmentFragmentModel.z().a();
        } else if (!(W.eM_() == null || Strings.isNullOrEmpty(W.eM_().a()))) {
            charSequence = W.eM_().a();
        }
        if (charSequence != null) {
            spannableStringBuilder.append(" - ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625827), 0, length, 33);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625828), length, spannableStringBuilder.length(), 33);
        } else {
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625827), 0, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }
}
