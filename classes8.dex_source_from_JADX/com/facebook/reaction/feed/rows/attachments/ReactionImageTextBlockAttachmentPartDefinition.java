package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: apply_mutation_ */
public class ReactionImageTextBlockAttachmentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, E, ContentView> {
    public static final ViewType<ContentView> f19347a = ViewType.a(2130906683);
    private static ReactionImageTextBlockAttachmentPartDefinition f19348d;
    private static final Object f19349e = new Object();
    private final ContentViewThumbnailUriStringPartDefinition f19350b;
    private final ContentViewTitlePartDefinition f19351c;

    private static ReactionImageTextBlockAttachmentPartDefinition m23347b(InjectorLike injectorLike) {
        return new ReactionImageTextBlockAttachmentPartDefinition(ContentViewThumbnailUriStringPartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike));
    }

    public final Object m23349a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        subParts.a(this.f19350b, reactionAttachmentNode.f18832a.r().b());
        subParts.a(this.f19351c, reactionAttachmentNode.f18832a.z().a());
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23350a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1210164909);
        ContentView contentView = (ContentView) view;
        contentView.setGravity(48);
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.setThumbnailSize(ThumbnailSize.LARGE);
        contentView.setTitleTextAppearance(2131625826);
        Logger.a(8, EntryType.MARK_POP, -1847857536, a);
    }

    public final boolean m23351a(Object obj) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        return (reactionAttachmentNode.f18832a.z() == null || Strings.isNullOrEmpty(reactionAttachmentNode.f18832a.z().a()) || reactionAttachmentNode.f18832a.r() == null || Strings.isNullOrEmpty(reactionAttachmentNode.f18832a.r().b())) ? false : true;
    }

    @Inject
    public ReactionImageTextBlockAttachmentPartDefinition(ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition) {
        this.f19350b = contentViewThumbnailUriStringPartDefinition;
        this.f19351c = contentViewTitlePartDefinition;
    }

    public final ViewType<ContentView> m23348a() {
        return f19347a;
    }

    public static ReactionImageTextBlockAttachmentPartDefinition m23346a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionImageTextBlockAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19349e) {
                ReactionImageTextBlockAttachmentPartDefinition reactionImageTextBlockAttachmentPartDefinition;
                if (a2 != null) {
                    reactionImageTextBlockAttachmentPartDefinition = (ReactionImageTextBlockAttachmentPartDefinition) a2.a(f19349e);
                } else {
                    reactionImageTextBlockAttachmentPartDefinition = f19348d;
                }
                if (reactionImageTextBlockAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23347b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19349e, b3);
                        } else {
                            f19348d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionImageTextBlockAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
