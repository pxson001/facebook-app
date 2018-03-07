package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoRowPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: grammar */
public class RichVideoWithBackgroundOverridePartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, RichVideoAttachmentView> {
    private static final PaddingStyle f12333a = Builder.d().i();
    private static RichVideoWithBackgroundOverridePartDefinition f12334d;
    private static final Object f12335e = new Object();
    private final Lazy<RichVideoRowPartDefinition> f12336b;
    private final BackgroundPartDefinition f12337c;

    private static RichVideoWithBackgroundOverridePartDefinition m14272b(InjectorLike injectorLike) {
        return new RichVideoWithBackgroundOverridePartDefinition(VisibilityPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 2062));
    }

    public final Object m14274a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a((SinglePartDefinition) this.f12336b.get(), feedProps);
        subParts.a(this.f12337c, new StylingData(AttachmentProps.e(feedProps), f12333a, Position.MIDDLE));
        return null;
    }

    @Inject
    public RichVideoWithBackgroundOverridePartDefinition(VisibilityPartDefinition visibilityPartDefinition, BackgroundPartDefinition backgroundPartDefinition, Lazy<RichVideoRowPartDefinition> lazy) {
        this.f12336b = lazy;
        this.f12337c = backgroundPartDefinition;
    }

    public final boolean m14275a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return ((RichVideoRowPartDefinition) this.f12336b.get()).a(feedProps);
    }

    public static RichVideoWithBackgroundOverridePartDefinition m14271a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichVideoWithBackgroundOverridePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12335e) {
                RichVideoWithBackgroundOverridePartDefinition richVideoWithBackgroundOverridePartDefinition;
                if (a2 != null) {
                    richVideoWithBackgroundOverridePartDefinition = (RichVideoWithBackgroundOverridePartDefinition) a2.a(f12335e);
                } else {
                    richVideoWithBackgroundOverridePartDefinition = f12334d;
                }
                if (richVideoWithBackgroundOverridePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14272b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12335e, b3);
                        } else {
                            f12334d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richVideoWithBackgroundOverridePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<RichVideoAttachmentView> m14273a() {
        return RichVideoRowPartDefinition.a;
    }
}
