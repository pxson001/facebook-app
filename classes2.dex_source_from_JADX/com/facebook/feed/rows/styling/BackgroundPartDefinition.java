package com.facebook.feed.rows.styling;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: native_document */
public class BackgroundPartDefinition extends BaseSinglePartDefinition<StylingData, Drawable, HasPositionInformation, View> {
    private static BackgroundPartDefinition f13007h;
    private static final Object f13008i = new Object();
    private final Context f13009a;
    private final PositionResolver f13010b;
    private final BackgroundResourceResolver f13011c;
    private final BasePaddingStyleResolver f13012d;
    private final GraphQLStoryUtil f13013e;
    private final UnseenStoryManager f13014f;
    private final ViewPaddingPartDefinition f13015g;

    /* compiled from: native_document */
    public class StylingData {
        @Nullable
        public final FeedProps<? extends FeedUnit> f19251a;
        public final PaddingStyle f19252b;
        public final int f19253c;
        public final int f19254d;
        @Nullable
        public final BackgroundStyler$Position f19255e;

        public StylingData(PaddingStyle paddingStyle) {
            this(null, paddingStyle);
        }

        public StylingData(FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle) {
            this(feedProps, paddingStyle, null);
        }

        public StylingData(FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle, BackgroundStyler$Position backgroundStyler$Position) {
            this(feedProps, paddingStyle, -1, -1, backgroundStyler$Position);
        }

        public StylingData(FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle, int i, int i2) {
            this(feedProps, paddingStyle, i, i2, null);
        }

        public StylingData(@Nullable FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle, int i, int i2, @Nullable BackgroundStyler$Position backgroundStyler$Position) {
            this.f19255e = backgroundStyler$Position;
            this.f19251a = feedProps;
            this.f19252b = paddingStyle;
            this.f19253c = i;
            this.f19254d = i2;
        }
    }

    private static BackgroundPartDefinition m19136b(InjectorLike injectorLike) {
        return new BackgroundPartDefinition((Context) injectorLike.getInstance(Context.class), PositionResolver.m19143a(injectorLike), BackgroundAttributeResourceResolver.m19150a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), UnseenStoryManager.m19201a(injectorLike), ViewPaddingPartDefinition.m19207a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1594331625);
        view.setBackgroundDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, 1807055995, a);
    }

    public static BackgroundPartDefinition m19135a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13008i) {
                BackgroundPartDefinition backgroundPartDefinition;
                if (a2 != null) {
                    backgroundPartDefinition = (BackgroundPartDefinition) a2.mo818a(f13008i);
                } else {
                    backgroundPartDefinition = f13007h;
                }
                if (backgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19136b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13008i, b3);
                        } else {
                            f13007h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = backgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public BackgroundPartDefinition(Context context, PositionResolver positionResolver, BackgroundResourceResolver backgroundResourceResolver, BasePaddingStyleResolver basePaddingStyleResolver, GraphQLStoryUtil graphQLStoryUtil, UnseenStoryManager unseenStoryManager, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f13009a = context;
        this.f13010b = positionResolver;
        this.f13011c = backgroundResourceResolver;
        this.f13012d = basePaddingStyleResolver;
        this.f13013e = graphQLStoryUtil;
        this.f13014f = unseenStoryManager;
        this.f13015g = viewPaddingPartDefinition;
    }

    private Drawable m19134a(SubParts<HasPositionInformation> subParts, StylingData stylingData, HasPositionInformation hasPositionInformation) {
        Rect rect = new Rect();
        FeedUnit feedUnit = stylingData.f19251a == null ? null : (FeedUnit) stylingData.f19251a.m19804a();
        int a = BackgroundStyles.m26966a(stylingData.f19251a, this.f13013e);
        BackgroundStyler$Position a2 = BackgroundStyles.m26972a(a, stylingData.f19251a, stylingData.f19255e, this.f13010b, hasPositionInformation.mo2449f(), hasPositionInformation.hK_(), hasPositionInformation.mo2451h(), hasPositionInformation.mo2455i(), hasPositionInformation.mo2456j());
        BackgroundStyles.m26973a(a2, a, this.f13012d, stylingData.f19252b, this.f13009a, rect);
        Drawable a3 = BackgroundStyles.m26969a(a2, a, stylingData.f19253c, stylingData.f19254d, this.f13011c, this.f13009a, rect, stylingData.f19252b, this.f13012d, this.f13014f.m19203a(stylingData.f19251a));
        if (feedUnit instanceof GraphQLStory) {
            this.f13014f.m19204a(stylingData.f19251a, a3);
        }
        subParts.mo2756a(this.f13015g, new PaddingData(rect.left, rect.top, rect.right, rect.bottom));
        return a3;
    }
}
