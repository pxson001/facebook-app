package com.facebook.reaction.feed.styling;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BackgroundResourceResolver;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.EnumMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.permission.READ_CONTACTS */
public class ReactionBackgroundResourceResolver implements BackgroundResourceResolver {
    private static ReactionBackgroundResourceResolver f19512c;
    private static final Object f19513d = new Object();
    public final AbstractFbErrorReporter f19514a;
    public final EnumMap<Position, Integer> f19515b;

    private static ReactionBackgroundResourceResolver m23456b(InjectorLike injectorLike) {
        return new ReactionBackgroundResourceResolver((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ReactionBackgroundResourceResolver(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f19514a = abstractFbErrorReporter;
        EnumMap enumMap = new EnumMap(Position.class);
        enumMap.put(Position.BOX, Integer.valueOf(2130842911));
        enumMap.put(Position.TOP, Integer.valueOf(2130842912));
        enumMap.put(Position.MIDDLE, Integer.valueOf(2131361920));
        enumMap.put(Position.BOTTOM, Integer.valueOf(2130842910));
        enumMap.put(Position.DIVIDER_TOP, Integer.valueOf(2131361920));
        enumMap.put(Position.DIVIDER_BOTTOM, Integer.valueOf(2131361920));
        enumMap.put(Position.DIVIDER_BOTTOM_NON_TOP, Integer.valueOf(2131361920));
        enumMap.put(Position.FOLLOW_UP, Integer.valueOf(2131361920));
        this.f19515b = enumMap;
    }

    public final Drawable m23457a(Resources resources, Position position, int i, GraphQLStorySeenState graphQLStorySeenState) {
        if (!(position == Position.BOX || position == Position.TOP || position == Position.MIDDLE || position == Position.BOTTOM)) {
            this.f19514a.b(getClass().getSimpleName(), "Unsupported position: " + position.toString() + " is passed");
        }
        return resources.getDrawable(((Integer) this.f19515b.get(position)).intValue());
    }

    public static ReactionBackgroundResourceResolver m23455a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionBackgroundResourceResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19513d) {
                ReactionBackgroundResourceResolver reactionBackgroundResourceResolver;
                if (a2 != null) {
                    reactionBackgroundResourceResolver = (ReactionBackgroundResourceResolver) a2.a(f19513d);
                } else {
                    reactionBackgroundResourceResolver = f19512c;
                }
                if (reactionBackgroundResourceResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23456b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19513d, b3);
                        } else {
                            f19512c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionBackgroundResourceResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
