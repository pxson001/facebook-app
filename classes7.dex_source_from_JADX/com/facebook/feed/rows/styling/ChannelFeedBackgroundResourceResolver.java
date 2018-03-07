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
/* compiled from: show_debug_overlay */
public class ChannelFeedBackgroundResourceResolver implements BackgroundResourceResolver {
    private static ChannelFeedBackgroundResourceResolver f3738b;
    private static final Object f3739c = new Object();
    private final EnumMap<Position, BackgroundResourceDefinition> f3740a = new EnumMap(Position.class);

    private static ChannelFeedBackgroundResourceResolver m4412a() {
        return new ChannelFeedBackgroundResourceResolver();
    }

    @Inject
    public ChannelFeedBackgroundResourceResolver() {
        BackgroundResourceDefinition backgroundResourceDefinition = new BackgroundResourceDefinition(17170445, 17170445, 17170445, 17170445);
        this.f3740a.put(Position.TOP, backgroundResourceDefinition);
        this.f3740a.put(Position.DIVIDER_TOP, backgroundResourceDefinition);
        this.f3740a.put(Position.DIVIDER_BOTTOM, backgroundResourceDefinition);
        this.f3740a.put(Position.DIVIDER_BOTTOM_NON_TOP, backgroundResourceDefinition);
        this.f3740a.put(Position.MIDDLE, backgroundResourceDefinition);
        this.f3740a.put(Position.BOX, backgroundResourceDefinition);
        this.f3740a.put(Position.BOTTOM, backgroundResourceDefinition);
        this.f3740a.put(Position.FOLLOW_UP, backgroundResourceDefinition);
    }

    public static ChannelFeedBackgroundResourceResolver m4413a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedBackgroundResourceResolver a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f3739c) {
                ChannelFeedBackgroundResourceResolver channelFeedBackgroundResourceResolver;
                if (a3 != null) {
                    channelFeedBackgroundResourceResolver = (ChannelFeedBackgroundResourceResolver) a3.a(f3739c);
                } else {
                    channelFeedBackgroundResourceResolver = f3738b;
                }
                if (channelFeedBackgroundResourceResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m4412a();
                        if (a3 != null) {
                            a3.a(f3739c, a2);
                        } else {
                            f3738b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = channelFeedBackgroundResourceResolver;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    public final Drawable m4414a(Resources resources, Position position, int i, GraphQLStorySeenState graphQLStorySeenState) {
        return ((BackgroundResourceDefinition) this.f3740a.get(position)).a(resources, i, graphQLStorySeenState);
    }
}
