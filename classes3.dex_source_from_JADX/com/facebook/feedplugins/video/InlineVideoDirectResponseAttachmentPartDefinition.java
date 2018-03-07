package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
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
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: tap_photo */
public class InlineVideoDirectResponseAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, InlineVideoAttachmentView> {
    public static final ViewType f232a = new C00061();
    private static InlineVideoDirectResponseAttachmentPartDefinition f233e;
    private static final Object f234f = new Object();
    private final VideoAttachmentBackgroundPartDefinition<E> f235b;
    @VideoInline
    private final Provider<TriState> f236c;
    private final Lazy<InlineVideoPartDefinition<E, InlineVideoAttachmentView>> f237d;

    /* compiled from: tap_photo */
    final class C00061 extends ViewType {
        C00061() {
        }

        public final View m217a(Context context) {
            return new InlineVideoAttachmentView(context);
        }
    }

    private static InlineVideoDirectResponseAttachmentPartDefinition m213b(InjectorLike injectorLike) {
        return new InlineVideoDirectResponseAttachmentPartDefinition(VideoAttachmentBackgroundPartDefinition.m162a(injectorLike), IdBasedProvider.a(injectorLike, 807), IdBasedLazy.a(injectorLike, 6191));
    }

    public final Object m215a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f235b, feedProps);
        subParts.a((SinglePartDefinition) this.f237d.get(), new Props(feedProps, -1, Absent.INSTANCE, new AtomicReference()));
        return null;
    }

    public final boolean m216a(Object obj) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        if (!((TriState) this.f236c.get()).asBoolean(false) || ((GraphQLStoryAttachment) feedProps.a).q()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return CallToActionUtil.n((GraphQLStoryAttachment) feedProps.a);
        }
        return false;
    }

    public static InlineVideoDirectResponseAttachmentPartDefinition m212a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineVideoDirectResponseAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f234f) {
                InlineVideoDirectResponseAttachmentPartDefinition inlineVideoDirectResponseAttachmentPartDefinition;
                if (a2 != null) {
                    inlineVideoDirectResponseAttachmentPartDefinition = (InlineVideoDirectResponseAttachmentPartDefinition) a2.a(f234f);
                } else {
                    inlineVideoDirectResponseAttachmentPartDefinition = f233e;
                }
                if (inlineVideoDirectResponseAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m213b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f234f, b3);
                        } else {
                            f233e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineVideoDirectResponseAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InlineVideoDirectResponseAttachmentPartDefinition(VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, Provider<TriState> provider, Lazy<InlineVideoPartDefinition> lazy) {
        this.f235b = videoAttachmentBackgroundPartDefinition;
        this.f236c = provider;
        this.f237d = lazy;
    }

    public final ViewType m214a() {
        return f232a;
    }
}
