package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.pages.common.reaction.persistentstate.PageActivityBadgeKey;
import com.facebook.pages.common.reaction.persistentstate.PageActivityBadgePersistentState;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsLocationAttached */
public class PageContextRowWithBadgeComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType f1898a = ViewType.a(2130905998);
    private static PageContextRowWithBadgeComponentPartDefinition f1899e;
    private static final Object f1900f = new Object();
    private final BasicReactionActionPartDefinition<E> f1901b;
    private final ImageBlockLayoutIconPartDefinition f1902c;
    private final TextPartDefinition f1903d;

    private static PageContextRowWithBadgeComponentPartDefinition m2946b(InjectorLike injectorLike) {
        return new PageContextRowWithBadgeComponentPartDefinition(BasicReactionActionPartDefinition.a(injectorLike), ImageBlockLayoutIconPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m2948a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        subParts.a(2131565413, this.f1903d, reactionUnitComponentFields.bv().a());
        final PageActivityBadgePersistentState pageActivityBadgePersistentState = (PageActivityBadgePersistentState) ((HasPersistentState) canLaunchReactionIntent).a(new PageActivityBadgeKey(reactionUnitComponentNode.c, reactionUnitComponentFields.bv().a()), reactionUnitComponentNode);
        if (!(pageActivityBadgePersistentState.f2131a != null || reactionUnitComponentFields.cG() == null || StringUtil.a(reactionUnitComponentFields.cG().a()))) {
            pageActivityBadgePersistentState.f2131a = reactionUnitComponentFields.cG().a();
        }
        subParts.a(2131565414, this.f1903d, pageActivityBadgePersistentState.f2131a);
        if (!(reactionUnitComponentFields.aP() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aP().b()))) {
            subParts.a(this.f1902c, reactionUnitComponentFields.aP().b());
        }
        subParts.a(this.f1901b, new Props(reactionUnitComponentFields.v(), reactionUnitComponentFields.bv().a(), reactionUnitComponentNode.c, reactionUnitComponentNode.d, new OnClickListener(this) {
            final /* synthetic */ PageContextRowWithBadgeComponentPartDefinition f1897d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2007966971);
                pageActivityBadgePersistentState.f2131a = "";
                ((HasInvalidate) canLaunchReactionIntent).a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode)});
                Logger.a(2, EntryType.UI_INPUT_END, -798270125, a);
            }
        }, null));
        return null;
    }

    public final boolean m2949a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields == null || reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.v() == null) ? false : true;
    }

    public static PageContextRowWithBadgeComponentPartDefinition m2945a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageContextRowWithBadgeComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1900f) {
                PageContextRowWithBadgeComponentPartDefinition pageContextRowWithBadgeComponentPartDefinition;
                if (a2 != null) {
                    pageContextRowWithBadgeComponentPartDefinition = (PageContextRowWithBadgeComponentPartDefinition) a2.a(f1900f);
                } else {
                    pageContextRowWithBadgeComponentPartDefinition = f1899e;
                }
                if (pageContextRowWithBadgeComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2946b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1900f, b3);
                        } else {
                            f1899e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageContextRowWithBadgeComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageContextRowWithBadgeComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, TextPartDefinition textPartDefinition) {
        this.f1901b = basicReactionActionPartDefinition;
        this.f1902c = imageBlockLayoutIconPartDefinition;
        this.f1903d = textPartDefinition;
    }

    public final ViewType m2947a() {
        return f1898a;
    }
}
