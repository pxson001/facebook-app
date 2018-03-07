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
import com.facebook.pages.common.reaction.ui.PageInlineComposerComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setDrawerElevation is not available in this version of the support lib. */
public class PageInlineComposerUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageInlineComposerComponentView> {
    public static final ViewType f1946a = new C02541();
    private static PageInlineComposerUnitComponentPartDefinition f1947c;
    private static final Object f1948d = new Object();
    private final PagesSurfaceReactionHelper<E> f1949b;

    /* compiled from: setDrawerElevation is not available in this version of the support lib. */
    final class C02541 extends ViewType {
        C02541() {
        }

        public final View m2992a(Context context) {
            return new PageInlineComposerComponentView(context);
        }
    }

    /* compiled from: setDrawerElevation is not available in this version of the support lib. */
    public class State {
        public final String f1943a;
        public final String f1944b;
        public final OnClickListener f1945c;

        public State(String str, String str2, OnClickListener onClickListener) {
            this.f1943a = str;
            this.f1944b = str2;
            this.f1945c = onClickListener;
        }
    }

    private static PageInlineComposerUnitComponentPartDefinition m2994b(InjectorLike injectorLike) {
        return new PageInlineComposerUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2996a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.bv().a(), reactionUnitComponentFields.aV().b(), this.f1949b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2997a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1902204733);
        State state = (State) obj2;
        PageInlineComposerComponentView pageInlineComposerComponentView = (PageInlineComposerComponentView) view;
        CharSequence charSequence = state.f1943a;
        String str = state.f1944b;
        pageInlineComposerComponentView.f2171j.setText(charSequence);
        pageInlineComposerComponentView.setThumbnailUri(str);
        pageInlineComposerComponentView.setOnClickListener(state.f1945c);
        Logger.a(8, EntryType.MARK_POP, 1854414471, a);
    }

    public final boolean m2998a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bv() == null || reactionUnitComponentFields.aV() == null || reactionUnitComponentFields.aV().b() == null || reactionUnitComponentFields.v() == null) ? false : true;
    }

    public final void m2999b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageInlineComposerComponentView) view).setOnClickListener(null);
    }

    public final ViewType<PageInlineComposerComponentView> m2995a() {
        return f1946a;
    }

    public static PageInlineComposerUnitComponentPartDefinition m2993a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageInlineComposerUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1948d) {
                PageInlineComposerUnitComponentPartDefinition pageInlineComposerUnitComponentPartDefinition;
                if (a2 != null) {
                    pageInlineComposerUnitComponentPartDefinition = (PageInlineComposerUnitComponentPartDefinition) a2.a(f1948d);
                } else {
                    pageInlineComposerUnitComponentPartDefinition = f1947c;
                }
                if (pageInlineComposerUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2994b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1948d, b3);
                        } else {
                            f1947c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageInlineComposerUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageInlineComposerUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1949b = pagesSurfaceReactionHelper;
    }
}
