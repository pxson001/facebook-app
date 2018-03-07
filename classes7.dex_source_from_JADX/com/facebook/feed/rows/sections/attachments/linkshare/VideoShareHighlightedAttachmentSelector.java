package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Version */
public class VideoShareHighlightedAttachmentSelector<E extends HasImageLoadListener & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasPlayIcon> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E> {
    private static VideoShareHighlightedAttachmentSelector f21037c;
    private static final Object f21038d = new Object();
    private final VideoShareHighlightedAttachmentPartDefinition<E, V> f21039a;
    private final VideoShareAttachmentPartDefinition<E, V> f21040b;

    private static VideoShareHighlightedAttachmentSelector m23928b(InjectorLike injectorLike) {
        return new VideoShareHighlightedAttachmentSelector(VideoShareHighlightedAttachmentPartDefinition.m23922a(injectorLike), VideoShareAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m23929a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f21039a, feedProps).a(this.f21040b, feedProps);
        return null;
    }

    public final boolean m23930a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) ? false : true;
    }

    @Inject
    public VideoShareHighlightedAttachmentSelector(VideoShareHighlightedAttachmentPartDefinition videoShareHighlightedAttachmentPartDefinition, VideoShareAttachmentPartDefinition videoShareAttachmentPartDefinition) {
        this.f21040b = videoShareAttachmentPartDefinition;
        this.f21039a = videoShareHighlightedAttachmentPartDefinition;
    }

    public static VideoShareHighlightedAttachmentSelector m23927a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoShareHighlightedAttachmentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21038d) {
                VideoShareHighlightedAttachmentSelector videoShareHighlightedAttachmentSelector;
                if (a2 != null) {
                    videoShareHighlightedAttachmentSelector = (VideoShareHighlightedAttachmentSelector) a2.a(f21038d);
                } else {
                    videoShareHighlightedAttachmentSelector = f21037c;
                }
                if (videoShareHighlightedAttachmentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23928b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21038d, b3);
                        } else {
                            f21037c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoShareHighlightedAttachmentSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
