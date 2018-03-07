package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: by */
public class RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition<V extends View & AttachmentEdgeToEdge> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, V> {
    private static RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition f9154b;
    private static final Object f9155c = new Object();
    private final BackgroundPartDefinition f9156a;

    private static RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition m9835b(InjectorLike injectorLike) {
        return new RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m9836a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f9156a, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.f, 2130840176, -1));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9837a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 577800645);
        m9834a(view);
        Logger.a(8, EntryType.MARK_POP, 1503393150, a);
    }

    @Inject
    public RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f9156a = backgroundPartDefinition;
    }

    public static RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition m9833a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9155c) {
                RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition richMediaAttachmentEdgeToEdgeBackgroundPartDefinition;
                if (a2 != null) {
                    richMediaAttachmentEdgeToEdgeBackgroundPartDefinition = (RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition) a2.a(f9155c);
                } else {
                    richMediaAttachmentEdgeToEdgeBackgroundPartDefinition = f9154b;
                }
                if (richMediaAttachmentEdgeToEdgeBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9835b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9155c, b3);
                        } else {
                            f9154b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaAttachmentEdgeToEdgeBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m9834a(V v) {
        ((AttachmentEdgeToEdge) v).mo249a();
    }
}
