package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoRowPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodfriends_picker_open */
public class ThrowbackResharedVideoAttachmentPartDefinition<E extends HasFeedListType & HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, RichVideoAttachmentView> {
    public static final PaddingStyle f12518a;
    private static ThrowbackResharedVideoAttachmentPartDefinition f12519d;
    private static final Object f12520e = new Object();
    private final BackgroundPartDefinition f12521b;
    private final RichVideoRowPartDefinition f12522c;

    private static ThrowbackResharedVideoAttachmentPartDefinition m14400b(InjectorLike injectorLike) {
        return new ThrowbackResharedVideoAttachmentPartDefinition(RichVideoRowPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14402a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12522c, feedProps);
        subParts.a(this.f12521b, new StylingData(AttachmentProps.e(feedProps), f12518a));
        return null;
    }

    public final boolean m14403a(Object obj) {
        return this.f12522c.a((FeedProps) obj);
    }

    static {
        Builder a = Builder.a();
        a.c = -9.0f;
        a = a;
        a.d = -11.0f;
        f12518a = a.i();
    }

    @Inject
    public ThrowbackResharedVideoAttachmentPartDefinition(RichVideoRowPartDefinition richVideoRowPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12522c = richVideoRowPartDefinition;
        this.f12521b = backgroundPartDefinition;
    }

    public final ViewType m14401a() {
        return RichVideoRowPartDefinition.a;
    }

    public static ThrowbackResharedVideoAttachmentPartDefinition m14399a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackResharedVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12520e) {
                ThrowbackResharedVideoAttachmentPartDefinition throwbackResharedVideoAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackResharedVideoAttachmentPartDefinition = (ThrowbackResharedVideoAttachmentPartDefinition) a2.a(f12520e);
                } else {
                    throwbackResharedVideoAttachmentPartDefinition = f12519d;
                }
                if (throwbackResharedVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14400b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12520e, b3);
                        } else {
                            f12519d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackResharedVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
