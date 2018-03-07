package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
import com.facebook.pages.common.reaction.ui.PageImageBlockComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsBackoutDraft */
public class PageInfoRowUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageImageBlockComponentView> {
    public static final ViewType f1932a = new C02521();
    private static PageInfoRowUnitComponentPartDefinition f1933c;
    private static final Object f1934d = new Object();
    private final PagesSurfaceReactionHelper<E> f1935b;

    /* compiled from: setIsBackoutDraft */
    final class C02521 extends ViewType {
        C02521() {
        }

        public final View m2976a(Context context) {
            return new PageImageBlockComponentView(context);
        }
    }

    /* compiled from: setIsBackoutDraft */
    public class State {
        public final String f1928a;
        public final String f1929b;
        public final String f1930c;
        public final OnClickListener f1931d;

        public State(String str, String str2, String str3, OnClickListener onClickListener) {
            this.f1928a = str;
            this.f1929b = str2;
            this.f1930c = str3;
            this.f1931d = onClickListener;
        }
    }

    private static PageInfoRowUnitComponentPartDefinition m2978b(InjectorLike injectorLike) {
        return new PageInfoRowUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2980a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        String a = (reactionUnitComponentFields.cL() == null || StringUtil.a(reactionUnitComponentFields.cL().a())) ? null : reactionUnitComponentFields.cL().a();
        return new State(reactionUnitComponentFields.cU().a(), a, reactionUnitComponentFields.bY().a().b(), this.f1935b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2981a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 263790584);
        State state = (State) obj2;
        PageImageBlockComponentView pageImageBlockComponentView = (PageImageBlockComponentView) view;
        pageImageBlockComponentView.m3167a(state.f1928a, state.f1929b, state.f1930c);
        pageImageBlockComponentView.setOnClickListener(state.f1931d);
        Logger.a(8, EntryType.MARK_POP, -1925942731, a);
    }

    public final boolean m2982a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.cU() == null || StringUtil.a(reactionUnitComponentFields.cU().a()) || reactionUnitComponentFields.bY() == null || reactionUnitComponentFields.bY().a() == null) ? false : true;
    }

    public final void m2983b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageImageBlockComponentView) view).setOnClickListener(null);
    }

    public final ViewType m2979a() {
        return f1932a;
    }

    public static PageInfoRowUnitComponentPartDefinition m2977a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageInfoRowUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1934d) {
                PageInfoRowUnitComponentPartDefinition pageInfoRowUnitComponentPartDefinition;
                if (a2 != null) {
                    pageInfoRowUnitComponentPartDefinition = (PageInfoRowUnitComponentPartDefinition) a2.a(f1934d);
                } else {
                    pageInfoRowUnitComponentPartDefinition = f1933c;
                }
                if (pageInfoRowUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2978b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1934d, b3);
                        } else {
                            f1933c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageInfoRowUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageInfoRowUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1935b = pagesSurfaceReactionHelper;
    }
}
