package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.net.Uri;
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
import com.facebook.pages.common.reaction.ui.PageInfoWriteFirstReviewComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setFacecastInfo */
public class PageInfoWriteFirstReviewUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageInfoWriteFirstReviewComponentView> {
    public static final ViewType f1939a = new C02531();
    private static PageInfoWriteFirstReviewUnitComponentPartDefinition f1940c;
    private static final Object f1941d = new Object();
    private final PagesSurfaceReactionHelper<E> f1942b;

    /* compiled from: setFacecastInfo */
    final class C02531 extends ViewType {
        C02531() {
        }

        public final View m2984a(Context context) {
            return new PageInfoWriteFirstReviewComponentView(context);
        }
    }

    /* compiled from: setFacecastInfo */
    public class State {
        public final OnClickListener f1936a;
        public final String f1937b;
        public final String f1938c;

        public State(String str, String str2, OnClickListener onClickListener) {
            this.f1937b = str;
            this.f1938c = str2;
            this.f1936a = onClickListener;
        }
    }

    private static PageInfoWriteFirstReviewUnitComponentPartDefinition m2986b(InjectorLike injectorLike) {
        return new PageInfoWriteFirstReviewUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2988a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.cU().a(), reactionUnitComponentFields.bY().a().b(), this.f1942b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2989a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1576896992);
        State state = (State) obj2;
        PageInfoWriteFirstReviewComponentView pageInfoWriteFirstReviewComponentView = (PageInfoWriteFirstReviewComponentView) view;
        CharSequence charSequence = state.f1937b;
        String str = state.f1938c;
        pageInfoWriteFirstReviewComponentView.f2168c.setText(charSequence);
        pageInfoWriteFirstReviewComponentView.f2167b.a(Uri.parse(str), PageInfoWriteFirstReviewComponentView.f2166a);
        pageInfoWriteFirstReviewComponentView.setOnClickListener(state.f1936a);
        Logger.a(8, EntryType.MARK_POP, 1663516111, a);
    }

    public final boolean m2990a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.cU() == null || StringUtil.a(reactionUnitComponentFields.cU().a()) || reactionUnitComponentFields.bY() == null || reactionUnitComponentFields.bY().a() == null || reactionUnitComponentFields.bY().a().b() == null || reactionUnitComponentFields.v() == null) ? false : true;
    }

    public final void m2991b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageInfoWriteFirstReviewComponentView) view).setOnClickListener(null);
    }

    public final ViewType m2987a() {
        return f1939a;
    }

    public static PageInfoWriteFirstReviewUnitComponentPartDefinition m2985a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageInfoWriteFirstReviewUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1941d) {
                PageInfoWriteFirstReviewUnitComponentPartDefinition pageInfoWriteFirstReviewUnitComponentPartDefinition;
                if (a2 != null) {
                    pageInfoWriteFirstReviewUnitComponentPartDefinition = (PageInfoWriteFirstReviewUnitComponentPartDefinition) a2.a(f1941d);
                } else {
                    pageInfoWriteFirstReviewUnitComponentPartDefinition = f1940c;
                }
                if (pageInfoWriteFirstReviewUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2986b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1941d, b3);
                        } else {
                            f1940c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageInfoWriteFirstReviewUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageInfoWriteFirstReviewUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1942b = pagesSurfaceReactionHelper;
    }
}
