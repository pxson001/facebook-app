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
/* compiled from: sentences */
public class PageSocialContextImageBlockUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageImageBlockComponentView> {
    public static final ViewType f2041a = new C02651();
    private static PageSocialContextImageBlockUnitComponentPartDefinition f2042c;
    private static final Object f2043d = new Object();
    private final PagesSurfaceReactionHelper<E> f2044b;

    /* compiled from: sentences */
    final class C02651 extends ViewType {
        C02651() {
        }

        public final View m3070a(Context context) {
            return new PageImageBlockComponentView(context);
        }
    }

    /* compiled from: sentences */
    public class State {
        public final OnClickListener f2037a;
        public final String f2038b;
        public final String f2039c;
        public final String f2040d;

        public State(String str, String str2, String str3, OnClickListener onClickListener) {
            this.f2038b = str;
            this.f2039c = str2;
            this.f2040d = str3;
            this.f2037a = onClickListener;
        }
    }

    private static PageSocialContextImageBlockUnitComponentPartDefinition m3072b(InjectorLike injectorLike) {
        return new PageSocialContextImageBlockUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3074a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.bv().a(), reactionUnitComponentFields.cG().a(), reactionUnitComponentFields.aU().b(), this.f2044b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3075a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1664327459);
        State state = (State) obj2;
        PageImageBlockComponentView pageImageBlockComponentView = (PageImageBlockComponentView) view;
        CharSequence charSequence = state.f2038b;
        int color = pageImageBlockComponentView.getResources().getColor(2131361921);
        pageImageBlockComponentView.m3167a(charSequence, state.f2039c, state.f2040d);
        pageImageBlockComponentView.f2154h.setTextColor(color);
        pageImageBlockComponentView.setOnClickListener(state.f2037a);
        Logger.a(8, EntryType.MARK_POP, -133017375, a);
    }

    public final boolean m3076a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cG() == null || StringUtil.a(reactionUnitComponentFields.cG().a()) || reactionUnitComponentFields.aU() == null || reactionUnitComponentFields.aU().b() == null) ? false : true;
    }

    public final void m3077b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageImageBlockComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3073a() {
        return f2041a;
    }

    public static PageSocialContextImageBlockUnitComponentPartDefinition m3071a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageSocialContextImageBlockUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2043d) {
                PageSocialContextImageBlockUnitComponentPartDefinition pageSocialContextImageBlockUnitComponentPartDefinition;
                if (a2 != null) {
                    pageSocialContextImageBlockUnitComponentPartDefinition = (PageSocialContextImageBlockUnitComponentPartDefinition) a2.a(f2043d);
                } else {
                    pageSocialContextImageBlockUnitComponentPartDefinition = f2042c;
                }
                if (pageSocialContextImageBlockUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3072b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2043d, b3);
                        } else {
                            f2042c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageSocialContextImageBlockUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageSocialContextImageBlockUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f2044b = pagesSurfaceReactionHelper;
    }
}
