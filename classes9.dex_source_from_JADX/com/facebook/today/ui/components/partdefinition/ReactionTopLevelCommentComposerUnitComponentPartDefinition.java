package com.facebook.today.ui.components.partdefinition;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.today.common.HasNotifications;
import javax.inject.Inject;

@ContextScoped
/* compiled from: transition */
public class ReactionTopLevelCommentComposerUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasNotifications & HasReactionSession & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType f1349a = new C01341();
    private static ReactionTopLevelCommentComposerUnitComponentPartDefinition f1350c;
    private static final Object f1351d = new Object();
    private final BasicReactionActionPartDefinition f1352b;

    /* compiled from: transition */
    final class C01341 extends ViewType {
        C01341() {
        }

        public final View m1480a(Context context) {
            return LayoutInflater.from(new ContextThemeWrapper(context, 2131626277)).inflate(2130907509, null);
        }
    }

    private static ReactionTopLevelCommentComposerUnitComponentPartDefinition m1482b(InjectorLike injectorLike) {
        return new ReactionTopLevelCommentComposerUnitComponentPartDefinition(BasicReactionActionPartDefinition.a(injectorLike));
    }

    public final Object m1484a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        Props props = new Props(reactionUnitComponentNode.b.v(), null, reactionUnitComponentNode.c, reactionUnitComponentNode.d, new OnClickListener(this) {
            final /* synthetic */ ReactionTopLevelCommentComposerUnitComponentPartDefinition f1348c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1113627239);
                if (((HasNotifications) canLaunchReactionIntent).a(reactionUnitComponentNode.c, true)) {
                    ((HasInvalidate) canLaunchReactionIntent).a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode)});
                }
                Logger.a(2, EntryType.UI_INPUT_END, -947252308, a);
            }
        }, null);
        subParts.a(this.f1352b, props);
        subParts.a(2131568015, this.f1352b, props);
        return null;
    }

    public final boolean m1485a(Object obj) {
        return ((ReactionUnitComponentNode) obj).b.v() != null;
    }

    @Inject
    public ReactionTopLevelCommentComposerUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f1352b = basicReactionActionPartDefinition;
    }

    public static ReactionTopLevelCommentComposerUnitComponentPartDefinition m1481a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTopLevelCommentComposerUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1351d) {
                ReactionTopLevelCommentComposerUnitComponentPartDefinition reactionTopLevelCommentComposerUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionTopLevelCommentComposerUnitComponentPartDefinition = (ReactionTopLevelCommentComposerUnitComponentPartDefinition) a2.a(f1351d);
                } else {
                    reactionTopLevelCommentComposerUnitComponentPartDefinition = f1350c;
                }
                if (reactionTopLevelCommentComposerUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1482b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1351d, b3);
                        } else {
                            f1350c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTopLevelCommentComposerUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m1483a() {
        return f1349a;
    }
}
