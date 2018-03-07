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
/* compiled from: setLocationInfo */
public class LargeProfileImageBlockComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f1850a = ViewType.a(2130905004);
    private static LargeProfileImageBlockComponentPartDefinition f1851c;
    private static final Object f1852d = new Object();
    private final PagesSurfaceReactionHelper f1853b;

    /* compiled from: setLocationInfo */
    public class State {
        public String f1846a;
        public String f1847b;
        public String f1848c;
        public final OnClickListener f1849d;

        public State(String str, String str2, String str3, OnClickListener onClickListener) {
            this.f1846a = str;
            this.f1847b = str2;
            this.f1848c = str3;
            this.f1849d = onClickListener;
        }
    }

    private static LargeProfileImageBlockComponentPartDefinition m2897b(InjectorLike injectorLike) {
        return new LargeProfileImageBlockComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2899a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.bv().a(), reactionUnitComponentFields.cG().a(), reactionUnitComponentFields.aV().b(), this.f1853b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2900a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 938049055);
        State state = (State) obj2;
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        BetterTextView betterTextView = (BetterTextView) imageBlockLayout.findViewById(2131563352);
        ((BetterTextView) imageBlockLayout.findViewById(2131563351)).setText(state.f1846a);
        betterTextView.setText(state.f1847b);
        imageBlockLayout.setThumbnailUri(state.f1848c);
        imageBlockLayout.setOnClickListener(state.f1849d);
        Logger.a(8, EntryType.MARK_POP, -21092304, a);
    }

    public final boolean m2901a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cG() == null || StringUtil.a(reactionUnitComponentFields.cG().a()) || reactionUnitComponentFields.aV() == null || StringUtil.a(reactionUnitComponentFields.aV().b())) ? false : true;
    }

    public final void m2902b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ImageBlockLayout) view).setOnClickListener(null);
    }

    @Inject
    public LargeProfileImageBlockComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1853b = pagesSurfaceReactionHelper;
    }

    public static LargeProfileImageBlockComponentPartDefinition m2896a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LargeProfileImageBlockComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1852d) {
                LargeProfileImageBlockComponentPartDefinition largeProfileImageBlockComponentPartDefinition;
                if (a2 != null) {
                    largeProfileImageBlockComponentPartDefinition = (LargeProfileImageBlockComponentPartDefinition) a2.a(f1852d);
                } else {
                    largeProfileImageBlockComponentPartDefinition = f1851c;
                }
                if (largeProfileImageBlockComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2897b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1852d, b3);
                        } else {
                            f1851c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = largeProfileImageBlockComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2898a() {
        return f1850a;
    }
}
