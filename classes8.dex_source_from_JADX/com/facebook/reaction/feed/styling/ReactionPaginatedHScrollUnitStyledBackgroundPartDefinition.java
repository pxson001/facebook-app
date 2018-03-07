package com.facebook.reaction.feed.styling;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.BackgroundStyles;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.intent.category.BROWSABLE */
public class ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition<E extends HasContext & HasPositionInformation> extends BaseSinglePartDefinition<StylingData, Integer, E, View> {
    private static ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition f19532f;
    private static final Object f19533g = new Object();
    private final GraphQLStoryUtil f19534a;
    private final BasePaddingStyleResolver f19535b;
    private final PositionResolver f19536c;
    private final ReactionPaginatedHScrollUnitBackgroundResolver f19537d;
    private final ViewPaddingPartDefinition f19538e;

    private static ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition m23472b(InjectorLike injectorLike) {
        return new ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition(GraphQLStoryUtil.a(injectorLike), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), PositionResolver.a(injectorLike), ReactionPaginatedHScrollUnitBackgroundResolver.m23468a(injectorLike), ViewPaddingPartDefinition.a(injectorLike));
    }

    public final Object m23473a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StylingData stylingData = (StylingData) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        Rect rect = new Rect();
        int a = BackgroundStyles.a(stylingData.a, this.f19534a);
        Position a2 = BackgroundStyles.a(a, stylingData.a, stylingData.e, this.f19536c, ((HasPositionInformation) hasContext).f(), ((HasPositionInformation) hasContext).hK_(), ((HasPositionInformation) hasContext).h(), ((HasPositionInformation) hasContext).i(), ((HasPositionInformation) hasContext).j());
        BackgroundStyles.a(a2, a, this.f19535b, stylingData.b, hasContext.getContext(), rect);
        subParts.a(this.f19538e, new PaddingData(rect.left, rect.top, rect.right, rect.bottom));
        TypedValue typedValue = new TypedValue();
        hasContext.getContext().getTheme().resolveAttribute(this.f19537d.m23470a(a2), typedValue, true);
        return Integer.valueOf(typedValue.resourceId);
    }

    public final /* bridge */ /* synthetic */ void m23474a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1330982039);
        view.setBackgroundResource(((Integer) obj2).intValue());
        Logger.a(8, EntryType.MARK_POP, -1863180523, a);
    }

    public static ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition m23471a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19533g) {
                ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition reactionPaginatedHScrollUnitStyledBackgroundPartDefinition;
                if (a2 != null) {
                    reactionPaginatedHScrollUnitStyledBackgroundPartDefinition = (ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition) a2.a(f19533g);
                } else {
                    reactionPaginatedHScrollUnitStyledBackgroundPartDefinition = f19532f;
                }
                if (reactionPaginatedHScrollUnitStyledBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23472b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19533g, b3);
                        } else {
                            f19532f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPaginatedHScrollUnitStyledBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition(GraphQLStoryUtil graphQLStoryUtil, BasePaddingStyleResolver basePaddingStyleResolver, PositionResolver positionResolver, ReactionPaginatedHScrollUnitBackgroundResolver reactionPaginatedHScrollUnitBackgroundResolver, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f19534a = graphQLStoryUtil;
        this.f19535b = basePaddingStyleResolver;
        this.f19536c = positionResolver;
        this.f19537d = reactionPaginatedHScrollUnitBackgroundResolver;
        this.f19538e = viewPaddingPartDefinition;
    }
}
