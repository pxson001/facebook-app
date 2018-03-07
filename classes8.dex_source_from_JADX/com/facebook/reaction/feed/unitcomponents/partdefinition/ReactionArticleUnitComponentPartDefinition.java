package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: anchor */
public class ReactionArticleUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ContentView> {
    public static final ViewType f19550a = new C21161();
    private static ReactionArticleUnitComponentPartDefinition f19551c;
    private static final Object f19552d = new Object();
    private final BasicReactionActionPartDefinition f19553b;

    /* compiled from: anchor */
    final class C21161 extends ViewType {
        C21161() {
        }

        public final View m23485a(Context context) {
            return (ContentView) LayoutInflater.from(context).inflate(2130906590, null);
        }
    }

    /* compiled from: anchor */
    public class State {
        public final String f19548a;
        public final String f19549b;

        public State(String str, String str2) {
            this.f19548a = str;
            this.f19549b = str2;
        }
    }

    private static ReactionArticleUnitComponentPartDefinition m23487b(InjectorLike injectorLike) {
        return new ReactionArticleUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    public final Object m23489a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        if (reactionUnitComponentFields.v() != null) {
            subParts.a(this.f19553b, new Props(reactionUnitComponentFields.v(), reactionUnitComponentFields.bv().a(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return new State(reactionUnitComponentFields.cG() == null ? null : reactionUnitComponentFields.cG().a(), reactionUnitComponentFields.bv().a());
    }

    public final /* bridge */ /* synthetic */ void m23490a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1618407813);
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(state.f19549b);
        if (!StringUtil.a(state.f19548a)) {
            contentView.setMetaText(state.f19548a);
        }
        Logger.a(8, EntryType.MARK_POP, -1959824734, a);
    }

    public final boolean m23491a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public static ReactionArticleUnitComponentPartDefinition m23486a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionArticleUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19552d) {
                ReactionArticleUnitComponentPartDefinition reactionArticleUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionArticleUnitComponentPartDefinition = (ReactionArticleUnitComponentPartDefinition) a2.a(f19552d);
                } else {
                    reactionArticleUnitComponentPartDefinition = f19551c;
                }
                if (reactionArticleUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23487b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19552d, b3);
                        } else {
                            f19551c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionArticleUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionArticleUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f19553b = basicReactionActionPartDefinition;
    }

    public final ViewType m23488a() {
        return f19550a;
    }
}
