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
import com.facebook.pages.common.reaction.ui.PageInfoDescriptionComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsFeedOnlyPost */
public class PageInfoDescriptionUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageInfoDescriptionComponentView> {
    public static final ViewType f1913a = new C02501();
    private static PageInfoDescriptionUnitComponentPartDefinition f1914c;
    private static final Object f1915d = new Object();
    private final PagesSurfaceReactionHelper<E> f1916b;

    /* compiled from: setIsFeedOnlyPost */
    final class C02501 extends ViewType {
        C02501() {
        }

        public final View m2958a(Context context) {
            return new PageInfoDescriptionComponentView(context);
        }
    }

    /* compiled from: setIsFeedOnlyPost */
    public class State {
        public final OnClickListener f1911a;
        public final String f1912b;

        public State(String str, OnClickListener onClickListener) {
            this.f1912b = str;
            this.f1911a = onClickListener;
        }
    }

    private static PageInfoDescriptionUnitComponentPartDefinition m2960b(InjectorLike injectorLike) {
        return new PageInfoDescriptionUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2962a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.bv().a(), this.f1916b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2963a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1702662603);
        State state = (State) obj2;
        PageInfoDescriptionComponentView pageInfoDescriptionComponentView = (PageInfoDescriptionComponentView) view;
        pageInfoDescriptionComponentView.f2157a.setText(state.f1912b);
        pageInfoDescriptionComponentView.setOnClickListener(state.f1911a);
        Logger.a(8, EntryType.MARK_POP, 91421755, a);
    }

    public final boolean m2964a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public final void m2965b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageInfoDescriptionComponentView) view).setOnClickListener(null);
    }

    public final ViewType m2961a() {
        return f1913a;
    }

    public static PageInfoDescriptionUnitComponentPartDefinition m2959a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageInfoDescriptionUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1915d) {
                PageInfoDescriptionUnitComponentPartDefinition pageInfoDescriptionUnitComponentPartDefinition;
                if (a2 != null) {
                    pageInfoDescriptionUnitComponentPartDefinition = (PageInfoDescriptionUnitComponentPartDefinition) a2.a(f1915d);
                } else {
                    pageInfoDescriptionUnitComponentPartDefinition = f1914c;
                }
                if (pageInfoDescriptionUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2960b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1915d, b3);
                        } else {
                            f1914c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageInfoDescriptionUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageInfoDescriptionUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1916b = pagesSurfaceReactionHelper;
    }
}
