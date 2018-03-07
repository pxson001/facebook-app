package com.facebook.feed.rows.styling;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
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
/* compiled from: show_end_screen */
public class ChannelFeedBackgroundPartDefinition extends BaseSinglePartDefinition<StylingData, Drawable, HasPositionInformation, View> {
    private static ChannelFeedBackgroundPartDefinition f3731f;
    private static final Object f3732g = new Object();
    private final Context f3733a;
    private final PositionResolver f3734b;
    private final ChannelFeedBackgroundResourceResolver f3735c;
    private final BasePaddingStyleResolver f3736d;
    private final ViewPaddingPartDefinition f3737e;

    /* compiled from: show_end_screen */
    public class StylingData {
        public final FeedProps<? extends FeedUnit> f3729a;
        public final PaddingStyle f3730b;

        public StylingData(FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle) {
            this.f3729a = feedProps;
            this.f3730b = paddingStyle;
        }
    }

    private static ChannelFeedBackgroundPartDefinition m4409b(InjectorLike injectorLike) {
        return new ChannelFeedBackgroundPartDefinition((Context) injectorLike.getInstance(Context.class), PositionResolver.a(injectorLike), ChannelFeedBackgroundResourceResolver.m4413a(injectorLike), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike));
    }

    public final Object m4410a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StylingData stylingData = (StylingData) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        Rect rect = new Rect();
        Position a = BackgroundStyles.a(0, stylingData.f3729a, null, this.f3734b, hasPositionInformation.f(), hasPositionInformation.hK_(), hasPositionInformation.h(), hasPositionInformation.i(), hasPositionInformation.j());
        BackgroundStyles.a(a, 0, this.f3736d, stylingData.f3730b, this.f3733a, rect);
        Drawable a2 = BackgroundStyles.a(a, 0, -1, -1, this.f3735c, this.f3733a, rect, stylingData.f3730b, this.f3736d, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        subParts.a(this.f3737e, new PaddingData(rect.left, rect.top, rect.right, rect.bottom));
        return a2;
    }

    public final /* bridge */ /* synthetic */ void m4411a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -754924239);
        view.setBackgroundDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, -1390522882, a);
    }

    @Inject
    public ChannelFeedBackgroundPartDefinition(Context context, PositionResolver positionResolver, ChannelFeedBackgroundResourceResolver channelFeedBackgroundResourceResolver, BasePaddingStyleResolver basePaddingStyleResolver, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f3733a = context;
        this.f3734b = positionResolver;
        this.f3735c = channelFeedBackgroundResourceResolver;
        this.f3736d = basePaddingStyleResolver;
        this.f3737e = viewPaddingPartDefinition;
    }

    public static ChannelFeedBackgroundPartDefinition m4408a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3732g) {
                ChannelFeedBackgroundPartDefinition channelFeedBackgroundPartDefinition;
                if (a2 != null) {
                    channelFeedBackgroundPartDefinition = (ChannelFeedBackgroundPartDefinition) a2.a(f3732g);
                } else {
                    channelFeedBackgroundPartDefinition = f3731f;
                }
                if (channelFeedBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4409b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3732g, b3);
                        } else {
                            f3731f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
