package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PageMessageBlockComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selectionColor */
public class PostCommentsModerationBlockUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageMessageBlockComponentView> {
    public static final ViewType f2086a = new C02711();
    private static PostCommentsModerationBlockUnitComponentPartDefinition f2087c;
    private static final Object f2088d = new Object();
    private final PagesSurfaceReactionHelper<E> f2089b;

    /* compiled from: selectionColor */
    final class C02711 extends ViewType {
        C02711() {
        }

        public final View m3116a(Context context) {
            return new PageMessageBlockComponentView(context);
        }
    }

    /* compiled from: selectionColor */
    public class State {
        public final String f2081a;
        public final String f2082b;
        public final String f2083c;
        public final long f2084d;
        public final OnClickListener f2085e;

        public State(String str, String str2, String str3, long j, OnClickListener onClickListener) {
            this.f2081a = str;
            this.f2082b = str2;
            this.f2083c = str3;
            this.f2084d = j;
            this.f2085e = onClickListener;
        }
    }

    private static PostCommentsModerationBlockUnitComponentPartDefinition m3118b(InjectorLike injectorLike) {
        return new PostCommentsModerationBlockUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3120a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.T().b().d(), reactionUnitComponentFields.T().b().gf_().a(), reactionUnitComponentFields.T().c().a(), reactionUnitComponentFields.T().d() * 1000, this.f2089b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3121a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1052328120);
        State state = (State) obj2;
        PageMessageBlockComponentView pageMessageBlockComponentView = (PageMessageBlockComponentView) view;
        pageMessageBlockComponentView.m3173a(state.f2083c, state.f2081a, state.f2082b, state.f2084d, null);
        pageMessageBlockComponentView.setOnClickListener(state.f2085e);
        Logger.a(8, EntryType.MARK_POP, -230793601, a);
    }

    public final boolean m3122a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.T() == null || reactionUnitComponentFields.T().b() == null || reactionUnitComponentFields.T().b().gf_() == null || reactionUnitComponentFields.T().c() == null) ? false : true;
    }

    public final void m3123b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageMessageBlockComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3119a() {
        return f2086a;
    }

    public static PostCommentsModerationBlockUnitComponentPartDefinition m3117a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PostCommentsModerationBlockUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2088d) {
                PostCommentsModerationBlockUnitComponentPartDefinition postCommentsModerationBlockUnitComponentPartDefinition;
                if (a2 != null) {
                    postCommentsModerationBlockUnitComponentPartDefinition = (PostCommentsModerationBlockUnitComponentPartDefinition) a2.a(f2088d);
                } else {
                    postCommentsModerationBlockUnitComponentPartDefinition = f2087c;
                }
                if (postCommentsModerationBlockUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3118b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2088d, b3);
                        } else {
                            f2087c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = postCommentsModerationBlockUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PostCommentsModerationBlockUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f2089b = pagesSurfaceReactionHelper;
    }
}
