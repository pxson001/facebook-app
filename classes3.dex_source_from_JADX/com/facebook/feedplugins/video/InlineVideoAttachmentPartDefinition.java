package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.abtest.VideoInline;
import com.facebook.video.channelfeed.ChannelFeedFromVideoLauncherPartDefinition;
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
@Deprecated
/* compiled from: ufi/reactions/v2/24x24/anger */
public class InlineVideoAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, InlineVideoAttachmentView> {
    public static final ViewType f161a = new C00021();
    private static InlineVideoAttachmentPartDefinition f162f;
    private static final Object f163g = new Object();
    private final VideoAttachmentBackgroundPartDefinition<E> f164b;
    @VideoInline
    private final Provider<TriState> f165c;
    private final Lazy<InlineVideoPartDefinition<E, InlineVideoAttachmentView>> f166d;
    private final ChannelFeedFromVideoLauncherPartDefinition f167e;

    /* compiled from: ufi/reactions/v2/24x24/anger */
    final class C00021 extends ViewType {
        C00021() {
        }

        public final View m159a(Context context) {
            return new InlineVideoAttachmentView(context);
        }
    }

    private static InlineVideoAttachmentPartDefinition m154b(InjectorLike injectorLike) {
        return new InlineVideoAttachmentPartDefinition(VideoAttachmentBackgroundPartDefinition.m162a(injectorLike), IdBasedProvider.a(injectorLike, 807), IdBasedLazy.a(injectorLike, 6191), ChannelFeedFromVideoLauncherPartDefinition.m173a(injectorLike));
    }

    public final Object m156a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f164b, feedProps);
        AtomicReference atomicReference = new AtomicReference();
        subParts.a((SinglePartDefinition) this.f166d.get(), new Props(feedProps, -1, Absent.INSTANCE, atomicReference));
        subParts.a(this.f167e, new ChannelFeedFromVideoLauncherPartDefinition.Props(feedProps, atomicReference));
        return null;
    }

    public static InlineVideoAttachmentPartDefinition m153a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f163g) {
                InlineVideoAttachmentPartDefinition inlineVideoAttachmentPartDefinition;
                if (a2 != null) {
                    inlineVideoAttachmentPartDefinition = (InlineVideoAttachmentPartDefinition) a2.a(f163g);
                } else {
                    inlineVideoAttachmentPartDefinition = f162f;
                }
                if (inlineVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m154b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f163g, b3);
                        } else {
                            f162f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InlineVideoAttachmentPartDefinition(VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, Provider<TriState> provider, Lazy<InlineVideoPartDefinition> lazy, ChannelFeedFromVideoLauncherPartDefinition channelFeedFromVideoLauncherPartDefinition) {
        this.f164b = videoAttachmentBackgroundPartDefinition;
        this.f165c = provider;
        this.f166d = lazy;
        this.f167e = channelFeedFromVideoLauncherPartDefinition;
    }

    public final ViewType m155a() {
        return f161a;
    }

    public final boolean m157a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return ((TriState) this.f165c.get()).asBoolean(false) && !((GraphQLStoryAttachment) feedProps.a).q();
    }
}
