package com.facebook.feedplugins.video;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.CallToActionAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.LeadGenCallToActionAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.LinkShareActionPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.OpenPermalinkActionPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.PageLikeAttachmentPartDefinition;
import com.facebook.feedplugins.video.FollowVideosPromptPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.PartWithIsNeeded;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/24x24/like */
public class VideoAttachmentGroupDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> implements PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> {
    private static VideoAttachmentGroupDefinition f135i;
    private static final Object f136j = new Object();
    private final Lazy<VideoAttachmentsSelectorPartDefinition> f137a;
    private final Lazy<CallToActionAttachmentPartDefinition> f138b;
    private final Lazy<PageLikeAttachmentPartDefinition<FeedEnvironment, ?>> f139c;
    private final Lazy<LinkShareActionPartDefinition> f140d;
    private final Lazy<OpenPermalinkActionPartDefinition> f141e;
    private final Lazy<VideoAttachmentViewCountPartDefinition> f142f;
    private final Lazy<LeadGenCallToActionAttachmentPartDefinition> f143g;
    private final Lazy<FollowVideosPromptPartDefinition> f144h;

    private static VideoAttachmentGroupDefinition m137b(InjectorLike injectorLike) {
        return new VideoAttachmentGroupDefinition(IdBasedLazy.a(injectorLike, 2066), IdBasedLazy.a(injectorLike, 1537), IdBasedLazy.a(injectorLike, 1544), IdBasedLazy.a(injectorLike, 1540), IdBasedLazy.a(injectorLike, 1542), IdBasedLazy.a(injectorLike, 2065), IdBasedLazy.a(injectorLike, 1538), IdBasedLazy.a(injectorLike, 2052));
    }

    public final Object m138a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FollowVideosState followVideosState;
        FeedProps feedProps = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f137a.get(), feedProps);
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) this.f144h.get();
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c == null) {
            followVideosState = new FollowVideosState();
        } else {
            followVideosState = (FollowVideosState) feedEnvironment.a(new FollowVideosKey(c), c);
        }
        baseMultiRowSubParts.a(multiRowPartWithIsNeeded, new Props(feedProps, followVideosState));
        SubPartsSelector.a(baseMultiRowSubParts, (MultiRowSinglePartDefinition) this.f143g.get(), feedProps).a((MultiRowSinglePartDefinition) this.f138b.get(), feedProps);
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f139c.get(), feedProps);
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f140d.get(), feedProps);
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f141e.get(), feedProps);
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f142f.get(), feedProps);
        return null;
    }

    public static VideoAttachmentGroupDefinition m136a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoAttachmentGroupDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f136j) {
                VideoAttachmentGroupDefinition videoAttachmentGroupDefinition;
                if (a2 != null) {
                    videoAttachmentGroupDefinition = (VideoAttachmentGroupDefinition) a2.a(f136j);
                } else {
                    videoAttachmentGroupDefinition = f135i;
                }
                if (videoAttachmentGroupDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m137b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f136j, b3);
                        } else {
                            f135i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoAttachmentGroupDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoAttachmentGroupDefinition(Lazy<VideoAttachmentsSelectorPartDefinition> lazy, Lazy<CallToActionAttachmentPartDefinition> lazy2, Lazy<PageLikeAttachmentPartDefinition> lazy3, Lazy<LinkShareActionPartDefinition> lazy4, Lazy<OpenPermalinkActionPartDefinition> lazy5, Lazy<VideoAttachmentViewCountPartDefinition> lazy6, Lazy<LeadGenCallToActionAttachmentPartDefinition> lazy7, Lazy<FollowVideosPromptPartDefinition> lazy8) {
        this.f137a = lazy;
        this.f138b = lazy2;
        this.f139c = lazy3;
        this.f140d = lazy4;
        this.f141e = lazy5;
        this.f142f = lazy6;
        this.f143g = lazy7;
        this.f144h = lazy8;
    }

    public final boolean m139a(Object obj) {
        return true;
    }
}
