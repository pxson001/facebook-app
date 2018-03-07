package com.facebook.reaction.feed.styling;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.BackgroundStyles;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.FeedUnit;
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
/* compiled from: android.permission.READ_PHONE_STATE */
public class ReactionBackgroundPartDefinition<E extends HasContext & HasPositionInformation> extends BaseSinglePartDefinition<StylingData, Drawable, E, View> {
    private static ReactionBackgroundPartDefinition f19506e;
    private static final Object f19507f = new Object();
    private final ReactionBackgroundResourceResolver f19508a;
    private final ReactionPaddingStyleResolver f19509b;
    private final PositionResolver f19510c;
    private final ViewPaddingPartDefinition f19511d;

    /* compiled from: android.permission.READ_PHONE_STATE */
    public class StylingData {
        public final FeedProps<? extends FeedUnit> f19504a;
        public final PaddingStyle f19505b;

        public StylingData(FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle) {
            this.f19504a = feedProps;
            this.f19505b = paddingStyle;
        }
    }

    private static ReactionBackgroundPartDefinition m23452b(InjectorLike injectorLike) {
        return new ReactionBackgroundPartDefinition(ReactionBackgroundResourceResolver.m23455a(injectorLike), ReactionPaddingStyleResolver.m23463a(injectorLike), PositionResolver.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike));
    }

    public final Object m23453a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StylingData stylingData = (StylingData) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        Rect rect = new Rect();
        Position a = BackgroundStyles.a(0, stylingData.f19504a, null, this.f19510c, ((HasPositionInformation) hasContext).f(), ((HasPositionInformation) hasContext).hK_(), ((HasPositionInformation) hasContext).h(), ((HasPositionInformation) hasContext).i(), ((HasPositionInformation) hasContext).j());
        BackgroundStyles.a(a, 0, this.f19509b, stylingData.f19505b, hasContext.getContext(), rect);
        Drawable a2 = BackgroundStyles.a(a, 0, -1, -1, this.f19508a, hasContext.getContext(), rect, stylingData.f19505b, this.f19509b, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        subParts.a(this.f19511d, new PaddingData(rect.left, rect.top, rect.right, rect.bottom));
        return a2;
    }

    public final /* bridge */ /* synthetic */ void m23454a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -210709613);
        view.setBackgroundDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, 1108850126, a);
    }

    @Inject
    public ReactionBackgroundPartDefinition(ReactionBackgroundResourceResolver reactionBackgroundResourceResolver, ReactionPaddingStyleResolver reactionPaddingStyleResolver, PositionResolver positionResolver, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f19510c = positionResolver;
        this.f19508a = reactionBackgroundResourceResolver;
        this.f19509b = reactionPaddingStyleResolver;
        this.f19511d = viewPaddingPartDefinition;
    }

    public static ReactionBackgroundPartDefinition m23451a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19507f) {
                ReactionBackgroundPartDefinition reactionBackgroundPartDefinition;
                if (a2 != null) {
                    reactionBackgroundPartDefinition = (ReactionBackgroundPartDefinition) a2.a(f19507f);
                } else {
                    reactionBackgroundPartDefinition = f19506e;
                }
                if (reactionBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23452b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19507f, b3);
                        } else {
                            f19506e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
