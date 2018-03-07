package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntitiesRange;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: send_invites */
public class PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageImageBlockComponentView> {
    public static final ViewType f2049a = new C02661();
    private static PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition f2050d;
    private static final Object f2051e = new Object();
    private final PagesSurfaceReactionHelper<E> f2052b;
    private final QeAccessor f2053c;

    /* compiled from: send_invites */
    final class C02661 extends ViewType {
        C02661() {
        }

        public final View m3078a(Context context) {
            return new PageImageBlockComponentView(context);
        }
    }

    /* compiled from: send_invites */
    public class State {
        public final CharSequence f2045a;
        public final String f2046b;
        public final String f2047c;
        public final OnClickListener f2048d;

        public State(CharSequence charSequence, String str, String str2, OnClickListener onClickListener) {
            this.f2045a = charSequence;
            this.f2046b = str;
            this.f2047c = str2;
            this.f2048d = onClickListener;
        }
    }

    private static PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition m3081b(InjectorLike injectorLike) {
        return new PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m3083a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(m3080a(Color.parseColor("#" + reactionUnitComponentFields.cn()), reactionUnitComponentFields.cm()), reactionUnitComponentFields.cl().a(), reactionUnitComponentFields.J().a().b(), this.f2052b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3084a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1966925916);
        State state = (State) obj2;
        PageImageBlockComponentView pageImageBlockComponentView = (PageImageBlockComponentView) view;
        pageImageBlockComponentView.m3167a(state.f2045a, state.f2046b, state.f2047c);
        pageImageBlockComponentView.setOnClickListener(state.f2048d);
        Logger.a(8, EntryType.MARK_POP, -511271498, a);
    }

    public final boolean m3085a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        if (reactionUnitComponentFields.cm() == null || StringUtil.a(reactionUnitComponentFields.cm().a()) || reactionUnitComponentFields.cm().b() == null || reactionUnitComponentFields.cm().b().size() != 1 || reactionUnitComponentFields.cl() == null || StringUtil.a(reactionUnitComponentFields.cl().a()) || reactionUnitComponentFields.J() == null || reactionUnitComponentFields.J().a() == null || StringUtil.a(reactionUnitComponentFields.J().a().b()) || reactionUnitComponentFields.cn() == null || reactionUnitComponentFields.cn().startsWith("#")) {
            return false;
        }
        return true;
    }

    public final void m3086b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageImageBlockComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3082a() {
        return f2049a;
    }

    public static PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition m3079a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2051e) {
                PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition pageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition;
                if (a2 != null) {
                    pageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition = (PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition) a2.a(f2051e);
                } else {
                    pageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition = f2050d;
                }
                if (pageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3081b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2051e, b3);
                        } else {
                            f2050d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageVeryResponsiveToMessagesBadgeUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper, QeAccessor qeAccessor) {
        this.f2052b = pagesSurfaceReactionHelper;
        this.f2053c = qeAccessor;
    }

    private static CharSequence m3080a(int i, LinkableTextWithEntities linkableTextWithEntities) {
        CharSequence spannableString = new SpannableString(linkableTextWithEntities.a());
        LinkableTextWithEntitiesRange linkableTextWithEntitiesRange = (LinkableTextWithEntitiesRange) linkableTextWithEntities.b().get(0);
        spannableString.setSpan(new ForegroundColorSpan(i), linkableTextWithEntitiesRange.c(), linkableTextWithEntitiesRange.b() + linkableTextWithEntitiesRange.c(), 33);
        return spannableString;
    }
}
