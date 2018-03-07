package com.facebook.reaction.feed.styling;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver.BaseStyle;
import com.facebook.feed.rows.styling.HorizontalPadder;
import com.facebook.feed.rows.styling.HorizontalPadder.ConstantHorizontalPadder;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.PaddingValues;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.permission.ACCESS_COARSE_LOCATION */
public class ReactionPaddingStyleResolver extends BasePaddingStyleResolver {
    public static final HorizontalPadder f19522a = new ConstantHorizontalPadder(12.0f, 12.0f);
    public static final HorizontalPadder f19523b = new ConstantHorizontalPadder(0.0f, 0.0f);
    private static ReactionPaddingStyleResolver f19524e;
    private static final Object f19525f = new Object();
    private final PaddingValues f19526c = new PaddingValues(0.0f, 9.0f, 0.0f, f19523b);
    private final PaddingValues f19527d = new PaddingValues(9.0f, 0.0f, 0.0f, f19523b);

    /* compiled from: android.permission.ACCESS_COARSE_LOCATION */
    /* synthetic */ class C21141 {
        static final /* synthetic */ int[] f19521a = new int[Position.values().length];

        static {
            try {
                f19521a[Position.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19521a[Position.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19521a[Position.BOX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static ReactionPaddingStyleResolver m23464b(InjectorLike injectorLike) {
        return new ReactionPaddingStyleResolver(GraphQLStoryUtil.a(injectorLike));
    }

    @Inject
    public ReactionPaddingStyleResolver(GraphQLStoryUtil graphQLStoryUtil) {
        super(graphQLStoryUtil);
    }

    protected final EnumMap<BaseStyle, PaddingValues> m23466a() {
        EnumMap<BaseStyle, PaddingValues> enumMap = new EnumMap(BaseStyle.class);
        enumMap.put(BaseStyle.DEFAULT, new PaddingValues(9.0f, 9.0f, 0.0f, f19522a));
        enumMap.put(BaseStyle.ZERO, new PaddingValues(0.0f, 0.0f, 0.0f, f19522a));
        return enumMap;
    }

    public static ReactionPaddingStyleResolver m23463a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPaddingStyleResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19525f) {
                ReactionPaddingStyleResolver reactionPaddingStyleResolver;
                if (a2 != null) {
                    reactionPaddingStyleResolver = (ReactionPaddingStyleResolver) a2.a(f19525f);
                } else {
                    reactionPaddingStyleResolver = f19524e;
                }
                if (reactionPaddingStyleResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23464b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19525f, b3);
                        } else {
                            f19524e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPaddingStyleResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final PaddingValues m23465a(PaddingStyle paddingStyle, Position position, int i) {
        PaddingValues paddingValues = (PaddingValues) b().get(paddingStyle.r);
        Preconditions.checkNotNull(paddingValues, "Cannot resolve style %s.", new Object[]{paddingStyle.r});
        paddingValues = paddingStyle.s.a(paddingValues);
        switch (C21141.f19521a[position.ordinal()]) {
            case 1:
                return paddingValues.a(this.f19527d);
            case 2:
                return paddingValues.a(this.f19526c);
            case 3:
                return paddingValues.a(this.f19527d).a(this.f19526c);
            default:
                return paddingValues;
        }
    }

    public final PaddingValues m23467b(PaddingStyle paddingStyle, Position position, int i) {
        throw new UnsupportedOperationException();
    }
}
