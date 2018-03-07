package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ContentViewThumbnailUriStringPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentActionPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryTopicAttachmentFragmentModel.TopicModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: app_discovery_menu */
public class ReactionTopicBlocksAttachmentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, E, ContentView> {
    public static final ViewType<ContentView> f19388a = ViewType.a(2130906683);
    private static ReactionTopicBlocksAttachmentPartDefinition f19389h;
    private static final Object f19390i = new Object();
    private final ReactionAttachmentActionPartDefinition f19391b;
    private final ContentViewThumbnailUriStringPartDefinition f19392c;
    private final ContentViewTitlePartDefinition f19393d;
    private final HighlightViewOnTouchListenerPartDefinition f19394e;
    private final ReactionIntentFactory f19395f;
    private final StyleSpan f19396g = new StyleSpan(1);

    private static ReactionTopicBlocksAttachmentPartDefinition m23389b(InjectorLike injectorLike) {
        return new ReactionTopicBlocksAttachmentPartDefinition(ReactionAttachmentActionPartDefinition.m23324a(injectorLike), ContentViewThumbnailUriStringPartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23391a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        TopicModel aa = reactionAttachmentNode.f18832a.aa();
        String d = aa.d();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringFormatUtil.formatStrLocaleSafe("%s: %s", d, aa.g()));
        spannableStringBuilder.setSpan(this.f19396g, 0, d.length() + 1, 17);
        if (aa.c() != null) {
            subParts.a(this.f19391b, new Props(this.f19395f.m22772d(aa.c(), aa.d()), reactionAttachmentNode.f18833b, reactionAttachmentNode.f18834c));
        }
        subParts.a(this.f19392c, aa.fu_().b());
        subParts.a(this.f19393d, spannableStringBuilder);
        subParts.a(this.f19394e, null);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23392a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1814097195);
        ContentView contentView = (ContentView) view;
        contentView.setTitleTextAppearance(2131625837);
        contentView.setThumbnailPlaceholderResource(2131361970);
        contentView.setThumbnailSize(ThumbnailSize.MEDIUM);
        contentView.setMaxLinesFromThumbnailSize(false);
        Logger.a(8, EntryType.MARK_POP, 24998466, a);
    }

    public final boolean m23393a(Object obj) {
        TopicModel aa = ((ReactionAttachmentNode) obj).f18832a.aa();
        return (aa == null || Strings.isNullOrEmpty(aa.c()) || Strings.isNullOrEmpty(aa.d()) || aa.g() == null || aa.fu_() == null || Strings.isNullOrEmpty(aa.fu_().b())) ? false : true;
    }

    public static ReactionTopicBlocksAttachmentPartDefinition m23388a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTopicBlocksAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19390i) {
                ReactionTopicBlocksAttachmentPartDefinition reactionTopicBlocksAttachmentPartDefinition;
                if (a2 != null) {
                    reactionTopicBlocksAttachmentPartDefinition = (ReactionTopicBlocksAttachmentPartDefinition) a2.a(f19390i);
                } else {
                    reactionTopicBlocksAttachmentPartDefinition = f19389h;
                }
                if (reactionTopicBlocksAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23389b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19390i, b3);
                        } else {
                            f19389h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTopicBlocksAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionTopicBlocksAttachmentPartDefinition(ReactionAttachmentActionPartDefinition reactionAttachmentActionPartDefinition, ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, ReactionIntentFactory reactionIntentFactory) {
        this.f19391b = reactionAttachmentActionPartDefinition;
        this.f19392c = contentViewThumbnailUriStringPartDefinition;
        this.f19393d = contentViewTitlePartDefinition;
        this.f19394e = highlightViewOnTouchListenerPartDefinition;
        this.f19395f = reactionIntentFactory;
    }

    public final ViewType<ContentView> m23390a() {
        return f19388a;
    }
}
