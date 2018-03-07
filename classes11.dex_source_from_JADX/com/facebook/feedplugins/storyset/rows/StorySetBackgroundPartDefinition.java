package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: battery level is unavailable */
public class StorySetBackgroundPartDefinition extends BaseSinglePartDefinition<Void, Void, HasPositionInformation, View> {
    private static StorySetBackgroundPartDefinition f9613c;
    private static final Object f9614d = new Object();
    private final BackgroundPartDefinition f9615a;
    private final PaddingStyle f9616b;

    private static StorySetBackgroundPartDefinition m10120b(InjectorLike injectorLike) {
        return new StorySetBackgroundPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m10121a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9615a, new StylingData(null, this.f9616b, 2130840264, -1, Position.DIVIDER_BOTTOM));
        return null;
    }

    @Inject
    public StorySetBackgroundPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f9615a = backgroundPartDefinition;
        Builder e = Builder.e();
        e.c = 1.0f - defaultPaddingStyleResolver.e();
        this.f9616b = e.i();
    }

    public static StorySetBackgroundPartDefinition m10119a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9614d) {
                StorySetBackgroundPartDefinition storySetBackgroundPartDefinition;
                if (a2 != null) {
                    storySetBackgroundPartDefinition = (StorySetBackgroundPartDefinition) a2.a(f9614d);
                } else {
                    storySetBackgroundPartDefinition = f9613c;
                }
                if (storySetBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10120b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9614d, b3);
                        } else {
                            f9613c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
