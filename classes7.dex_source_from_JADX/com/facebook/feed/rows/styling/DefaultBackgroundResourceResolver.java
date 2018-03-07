package com.facebook.feed.rows.styling;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.propertybag.PropertyBag;
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
/* compiled from: show_aggregate_reshare_post_button */
public class DefaultBackgroundResourceResolver implements BackgroundResourceResolver {
    private static DefaultBackgroundResourceResolver f3741b;
    private static final Object f3742c = new Object();
    private final EnumMap<Position, BackgroundResourceDefinition> f3743a;

    private static DefaultBackgroundResourceResolver m4416b() {
        return new DefaultBackgroundResourceResolver();
    }

    @Inject
    public DefaultBackgroundResourceResolver() {
        EnumMap enumMap = new EnumMap(Position.class);
        enumMap.put(Position.TOP, new BackgroundResourceDefinition(2130840206, 2130840201, 2130843819, 2130843820));
        enumMap.put(Position.DIVIDER_TOP, new BackgroundResourceDefinition(2130840205, 2130840205, 2130843820, 2130843820));
        enumMap.put(Position.DIVIDER_BOTTOM, new BackgroundResourceDefinition(2130840194, 2130840322, 2130843820, 2130843820));
        enumMap.put(Position.DIVIDER_BOTTOM_NON_TOP, new BackgroundResourceDefinition(2130840322, 2130840322, 2130843820, 2130843820));
        enumMap.put(Position.MIDDLE, new BackgroundResourceDefinition(2130840203, 2130840200, 2130843820, 2130843820));
        enumMap.put(Position.BOX, new BackgroundResourceDefinition(2130840196, 2130840199, 2130843820, 2130843820));
        enumMap.put(Position.BOTTOM, new BackgroundResourceDefinition(2130840195, 2130840198, 2130843817, 2130843820));
        enumMap.put(Position.FOLLOW_UP, new BackgroundResourceDefinition(2130840203, 2130840203, 2130843820, 2130843820));
        this.f3743a = enumMap;
    }

    public static DefaultBackgroundResourceResolver m4415a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultBackgroundResourceResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3742c) {
                DefaultBackgroundResourceResolver defaultBackgroundResourceResolver;
                if (a2 != null) {
                    defaultBackgroundResourceResolver = (DefaultBackgroundResourceResolver) a2.a(f3742c);
                } else {
                    defaultBackgroundResourceResolver = f3741b;
                }
                if (defaultBackgroundResourceResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m4416b();
                        if (a2 != null) {
                            a2.a(f3742c, b3);
                        } else {
                            f3741b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultBackgroundResourceResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Drawable m4417a(Resources resources, Position position, int i, GraphQLStorySeenState graphQLStorySeenState) {
        return ((BackgroundResourceDefinition) this.f3743a.get(position)).a(resources, i, graphQLStorySeenState);
    }
}
