package com.facebook.today.ui.components.partdefinition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.parts.ContentViewMetaTextPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: travel/slideshow.* */
public class MessageBlockUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ContentView> {
    public static final ViewType f1283a = new C01241();
    private static MessageBlockUnitComponentPartDefinition f1284e;
    private static final Object f1285f = new Object();
    private final ContentViewTitlePartDefinition f1286b;
    private final ContentViewSubtitlePartDefinition f1287c;
    private final ContentViewMetaTextPartDefinition f1288d;

    /* compiled from: travel/slideshow.* */
    final class C01241 extends ViewType {
        C01241() {
        }

        public final View m1441a(Context context) {
            ContentView contentView = new ContentView(context);
            contentView.setMaxLinesFromThumbnailSize(false);
            contentView.e(2, 1);
            contentView.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(2131361920)));
            return contentView;
        }
    }

    private static MessageBlockUnitComponentPartDefinition m1443b(InjectorLike injectorLike) {
        return new MessageBlockUnitComponentPartDefinition(ContentViewTitlePartDefinition.a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewMetaTextPartDefinition.a(injectorLike));
    }

    public final Object m1445a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object a;
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        subParts.a(this.f1286b, reactionUnitComponentFields.bv() != null ? reactionUnitComponentFields.bv().a() : null);
        ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition = this.f1287c;
        if (reactionUnitComponentFields.cG() != null) {
            a = reactionUnitComponentFields.cG().a();
        } else {
            a = null;
        }
        subParts.a(contentViewSubtitlePartDefinition, a);
        ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition = this.f1288d;
        if (reactionUnitComponentFields.cO() != null) {
            a = reactionUnitComponentFields.cO().a();
        } else {
            a = null;
        }
        subParts.a(contentViewMetaTextPartDefinition, a);
        return null;
    }

    @Inject
    public MessageBlockUnitComponentPartDefinition(ContentViewTitlePartDefinition contentViewTitlePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition) {
        this.f1286b = contentViewTitlePartDefinition;
        this.f1287c = contentViewSubtitlePartDefinition;
        this.f1288d = contentViewMetaTextPartDefinition;
    }

    public static MessageBlockUnitComponentPartDefinition m1442a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageBlockUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1285f) {
                MessageBlockUnitComponentPartDefinition messageBlockUnitComponentPartDefinition;
                if (a2 != null) {
                    messageBlockUnitComponentPartDefinition = (MessageBlockUnitComponentPartDefinition) a2.a(f1285f);
                } else {
                    messageBlockUnitComponentPartDefinition = f1284e;
                }
                if (messageBlockUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1443b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1285f, b3);
                        } else {
                            f1284e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messageBlockUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentView> m1444a() {
        return f1283a;
    }

    public final boolean m1446a(Object obj) {
        return true;
    }
}
