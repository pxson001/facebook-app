package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundAttributeResourceResolver;
import com.facebook.feed.rows.styling.BackgroundResourceResolver;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.BackgroundStyles;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
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
/* compiled from: ac-3 */
public class PhotosFeedBackgroundPartDefinition extends BaseSinglePartDefinition<StylingData, Drawable, HasPositionInformation, View> {
    private static PhotosFeedBackgroundPartDefinition f20191f;
    private static final Object f20192g = new Object();
    private final Context f20193a;
    private final PositionResolver f20194b;
    private final BackgroundResourceResolver f20195c;
    private final BasePaddingStyleResolver f20196d;
    private final ViewPaddingPartDefinition f20197e;

    /* compiled from: ac-3 */
    public class StylingData {
        public final FeedProps<? extends FeedUnit> f20189a;
        public final PaddingStyle f20190b;

        public StylingData(FeedProps<? extends FeedUnit> feedProps, PaddingStyle paddingStyle) {
            this.f20189a = feedProps;
            this.f20190b = paddingStyle;
        }
    }

    private static PhotosFeedBackgroundPartDefinition m23328b(InjectorLike injectorLike) {
        return new PhotosFeedBackgroundPartDefinition((Context) injectorLike.getInstance(Context.class), PositionResolver.a(injectorLike), (BackgroundResourceResolver) BackgroundAttributeResourceResolver.a(injectorLike), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike));
    }

    public final Object m23329a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StylingData stylingData = (StylingData) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        Rect rect = new Rect();
        Position a = BackgroundStyles.a(0, stylingData.f20189a, null, this.f20194b, hasPositionInformation.f(), hasPositionInformation.hK_(), hasPositionInformation.h(), hasPositionInformation.i(), hasPositionInformation.j());
        BackgroundStyles.a(a, 0, this.f20196d, stylingData.f20190b, this.f20193a, rect);
        Drawable a2 = BackgroundStyles.a(a, 0, -1, -1, this.f20195c, this.f20193a, rect, stylingData.f20190b, this.f20196d, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        subParts.a(this.f20197e, new PaddingData(rect.left, rect.top, rect.right, rect.bottom));
        return a2;
    }

    public final /* bridge */ /* synthetic */ void m23330a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2012696248);
        view.setBackgroundDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, 173812790, a);
    }

    @Inject
    public PhotosFeedBackgroundPartDefinition(Context context, PositionResolver positionResolver, BackgroundResourceResolver backgroundResourceResolver, BasePaddingStyleResolver basePaddingStyleResolver, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f20193a = context;
        this.f20194b = positionResolver;
        this.f20195c = backgroundResourceResolver;
        this.f20196d = basePaddingStyleResolver;
        this.f20197e = viewPaddingPartDefinition;
    }

    public static PhotosFeedBackgroundPartDefinition m23327a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20192g) {
                PhotosFeedBackgroundPartDefinition photosFeedBackgroundPartDefinition;
                if (a2 != null) {
                    photosFeedBackgroundPartDefinition = (PhotosFeedBackgroundPartDefinition) a2.a(f20192g);
                } else {
                    photosFeedBackgroundPartDefinition = f20191f;
                }
                if (photosFeedBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23328b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20192g, b3);
                        } else {
                            f20191f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
