package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsVideoTaggingPromptShowing */
public class PageAdminFeedStoryComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ImageBlockLayout> {
    public static final ViewType f1866a = ViewType.a(2130903183);
    private static PageAdminFeedStoryComponentPartDefinition f1867c;
    private static final Object f1868d = new Object();
    private final PagesSurfaceReactionHelper f1869b;

    /* compiled from: setIsVideoTaggingPromptShowing */
    public class State {
        public String f1861a;
        public String f1862b;
        public String f1863c;
        public String f1864d;
        public final OnClickListener f1865e;

        public State(String str, String str2, String str3, String str4, OnClickListener onClickListener) {
            this.f1861a = str;
            this.f1862b = str2;
            this.f1863c = str3;
            this.f1864d = str4;
            this.f1865e = onClickListener;
        }
    }

    private static PageAdminFeedStoryComponentPartDefinition m2912b(InjectorLike injectorLike) {
        return new PageAdminFeedStoryComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2914a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.bv().a(), reactionUnitComponentFields.cG().a(), reactionUnitComponentFields.cO().a(), reactionUnitComponentFields.aV().b(), this.f1869b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2915a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 532185945);
        State state = (State) obj2;
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        ((BetterTextView) imageBlockLayout.findViewById(2131559428)).setText(state.f1861a);
        ((BetterTextView) imageBlockLayout.findViewById(2131559429)).setText(state.f1862b);
        ((BetterTextView) imageBlockLayout.findViewById(2131559430)).setText(state.f1863c);
        imageBlockLayout.setThumbnailUri(state.f1864d);
        imageBlockLayout.setOnClickListener(state.f1865e);
        Logger.a(8, EntryType.MARK_POP, -1191668116, a);
    }

    public final boolean m2916a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields == null || reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cG() == null || StringUtil.a(reactionUnitComponentFields.cG().a()) || reactionUnitComponentFields.cO() == null || StringUtil.a(reactionUnitComponentFields.cO().a()) || reactionUnitComponentFields.aV() == null || StringUtil.a(reactionUnitComponentFields.aV().b())) ? false : true;
    }

    public final void m2917b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ImageBlockLayout) view).setOnClickListener(null);
    }

    @Inject
    public PageAdminFeedStoryComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1869b = pagesSurfaceReactionHelper;
    }

    public static PageAdminFeedStoryComponentPartDefinition m2911a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageAdminFeedStoryComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1868d) {
                PageAdminFeedStoryComponentPartDefinition pageAdminFeedStoryComponentPartDefinition;
                if (a2 != null) {
                    pageAdminFeedStoryComponentPartDefinition = (PageAdminFeedStoryComponentPartDefinition) a2.a(f1868d);
                } else {
                    pageAdminFeedStoryComponentPartDefinition = f1867c;
                }
                if (pageAdminFeedStoryComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2912b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1868d, b3);
                        } else {
                            f1867c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageAdminFeedStoryComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2913a() {
        return f1866a;
    }
}
