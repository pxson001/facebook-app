package com.facebook.feed.rows.styling;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
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
/* compiled from: native_article?article={%s}&canonical={%s} */
public class BackgroundAttributeResourceResolver implements BackgroundResourceResolver {
    private static BackgroundAttributeResourceResolver f13020b;
    private static final Object f13021c = new Object();
    private final EnumMap<BackgroundStyler$Position, BackgroundResourceDefinition> f13022a;

    private static BackgroundAttributeResourceResolver m19151b(InjectorLike injectorLike) {
        return new BackgroundAttributeResourceResolver((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BackgroundAttributeResourceResolver(Context context) {
        EnumMap enumMap = new EnumMap(BackgroundStyler$Position.class);
        enumMap.put(BackgroundStyler$Position.TOP, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772664, 2130840206), ContextUtils.m2501b(context, 2130772665, 2130840201), 2130843819, 2130843820));
        enumMap.put(BackgroundStyler$Position.DIVIDER_TOP, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772666, 2130840205), ContextUtils.m2501b(context, 2130772666, 2130840205), 2130843820, 2130843820));
        enumMap.put(BackgroundStyler$Position.DIVIDER_BOTTOM, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772667, 2130840194), ContextUtils.m2501b(context, 2130772668, 2130840322), 2130843820, 2130843820));
        enumMap.put(BackgroundStyler$Position.DIVIDER_BOTTOM_NON_TOP, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772669, 2130840322), ContextUtils.m2501b(context, 2130772669, 2130840322), 2130843820, 2130843820));
        enumMap.put(BackgroundStyler$Position.MIDDLE, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772670, 2130840203), ContextUtils.m2501b(context, 2130772671, 2130840200), 2130843820, 2130843820));
        enumMap.put(BackgroundStyler$Position.BOX, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772672, 2130840196), ContextUtils.m2501b(context, 2130772673, 2130840199), 2130843820, 2130843820));
        enumMap.put(BackgroundStyler$Position.BOTTOM, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772674, 2130840195), ContextUtils.m2501b(context, 2130772675, 2130840198), 2130843817, 2130843820));
        enumMap.put(BackgroundStyler$Position.FOLLOW_UP, new BackgroundResourceDefinition(ContextUtils.m2501b(context, 2130772676, 2130840203), ContextUtils.m2501b(context, 2130772676, 2130840203), 2130843820, 2130843820));
        this.f13022a = enumMap;
    }

    public static BackgroundAttributeResourceResolver m19150a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BackgroundAttributeResourceResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13021c) {
                BackgroundAttributeResourceResolver backgroundAttributeResourceResolver;
                if (a2 != null) {
                    backgroundAttributeResourceResolver = (BackgroundAttributeResourceResolver) a2.mo818a(f13021c);
                } else {
                    backgroundAttributeResourceResolver = f13020b;
                }
                if (backgroundAttributeResourceResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19151b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13021c, b3);
                        } else {
                            f13020b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = backgroundAttributeResourceResolver;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Drawable mo2548a(Resources resources, BackgroundStyler$Position backgroundStyler$Position, int i, GraphQLStorySeenState graphQLStorySeenState) {
        return ((BackgroundResourceDefinition) this.f13022a.get(backgroundStyler$Position)).m19155a(resources, i, graphQLStorySeenState);
    }
}
