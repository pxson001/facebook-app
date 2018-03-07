package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AttributionPartDefinition;
import com.facebook.feed.rows.sections.FeedAttachedStoryPartDefinition;
import com.facebook.feed.rows.sections.StoryPostFooterSelectorPartDefinition;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.offline.OfflineAnimationGroupPartDefinition.Props;
import com.facebook.feed.rows.sections.text.TextSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.offline.rows.MediaUploadProcessingPartDefinition;
import com.facebook.feedplugins.offline.rows.MediaUploadProgressPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineFailedPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineFailedV2PartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineProgressPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineProgressV2PartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineRetryPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineSuccessPartDefinition;
import com.facebook.feedplugins.prompts.SocialPromptFeedEntryPointPartDefinition;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: injectComponent should only be called on ContextScope */
public class OfflineStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static OfflineStoryPartDefinition f19954y;
    private static final Object f19955z = new Object();
    private final MediaUploadProgressPartDefinition<FeedEnvironment> f19956a;
    public final MediaUploadProcessingPartDefinition<FeedEnvironment> f19957b;
    private final OfflineSuccessPartDefinition f19958c;
    private final OfflineProgressPartDefinition<FeedEnvironment> f19959d;
    private final OfflineProgressV2PartDefinition<FeedEnvironment> f19960e;
    private final OfflineRetryPartDefinition f19961f;
    private final OfflineFailedPartDefinition f19962g;
    private final OfflineFailedV2PartDefinition f19963h;
    public final DefaultHeaderSelectorPartDefinition f19964i;
    public final StickerRootPartDefinition<FeedEnvironment> f19965j;
    public final MinutiaeAttachmentGroupPartDefinition f19966k;
    public final TextSelectorPartDefinition f19967l;
    public final AttachmentsPartDefinition f19968m;
    public final StoryPostFooterSelectorPartDefinition f19969n;
    public final BlingBarRootPartDefinition<FeedEnvironment> f19970o;
    private final OfflineFooterSelector f19971p;
    public final FeedAttachedStoryPartDefinition f19972q;
    private final OfflineAnimationGroupPartDefinition<FeedEnvironment> f19973r;
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f19974s;
    public final AttributionPartDefinition f19975t;
    private final OptimisticStoryStateCache f19976u;
    private final SocialPromptFeedEntryPointPartDefinition f19977v;
    private final QeAccessor f19978w;
    private final Clock f19979x;

    private static OfflineStoryPartDefinition m27735b(InjectorLike injectorLike) {
        return new OfflineStoryPartDefinition(OfflineAnimationGroupPartDefinition.a(injectorLike), MediaUploadProgressPartDefinition.a(injectorLike), MediaUploadProcessingPartDefinition.a(injectorLike), OfflineFooterSelector.a(injectorLike), OfflineSuccessPartDefinition.a(injectorLike), OfflineProgressPartDefinition.a(injectorLike), OfflineProgressV2PartDefinition.a(injectorLike), OfflineRetryPartDefinition.a(injectorLike), OfflineFailedPartDefinition.a(injectorLike), OfflineFailedV2PartDefinition.a(injectorLike), DefaultHeaderSelectorPartDefinition.m28532a(injectorLike), StickerRootPartDefinition.m27781a(injectorLike), TextSelectorPartDefinition.m28559a(injectorLike), AttachmentsPartDefinition.m27796a(injectorLike), MinutiaeAttachmentGroupPartDefinition.m27828a(injectorLike), StoryPostFooterSelectorPartDefinition.m27844a(injectorLike), BlingBarRootPartDefinition.a(injectorLike), FeedAttachedStoryPartDefinition.m32655a(injectorLike), AttributionPartDefinition.a(injectorLike), InlineCommentComposerPartDefinition.m27906a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike), SocialPromptFeedEntryPointPartDefinition.m28011a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        Object obj2 = (GraphQLStory) obj.f13444a;
        baseMultiRowSubParts.m19112a(this.f19956a, obj);
        boolean a = baseMultiRowSubParts.m19112a(this.f19957b, obj2);
        SubPartsSelector.m19114a(baseMultiRowSubParts, this.f19960e, obj).m19118a(this.f19959d, obj);
        SubPartsSelector.m19114a(baseMultiRowSubParts, this.f19961f, obj);
        SubPartsSelector.m19114a(baseMultiRowSubParts, this.f19963h, obj).m19118a(this.f19962g, obj);
        SubPartsSelector.m19114a(baseMultiRowSubParts, this.f19958c, obj);
        baseMultiRowSubParts.m19112a(this.f19973r, new Props(obj, new 1(this)));
        if (!a) {
            baseMultiRowSubParts.m19112a(this.f19971p, obj);
            baseMultiRowSubParts.m19112a(this.f19974s, obj);
        }
        baseMultiRowSubParts.m19112a(this.f19977v, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        long a = this.f19978w.mo575a(ExperimentsForCompostAbTestModule.q, -1);
        if (a != -1) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
            if (StoryAttachmentHelper.m28029a(graphQLStory) && !StoryAttachmentHelper.m28037j(graphQLStory) && (graphQLStory.m22336V() * 1000) + a < this.f19979x.mo211a()) {
                return false;
            }
        }
        return m27734a(feedProps, this.f19976u);
    }

    public static OfflineStoryPartDefinition m27733a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19955z) {
                OfflineStoryPartDefinition offlineStoryPartDefinition;
                if (a2 != null) {
                    offlineStoryPartDefinition = (OfflineStoryPartDefinition) a2.mo818a(f19955z);
                } else {
                    offlineStoryPartDefinition = f19954y;
                }
                if (offlineStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27735b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19955z, b3);
                        } else {
                            f19954y = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public OfflineStoryPartDefinition(OfflineAnimationGroupPartDefinition offlineAnimationGroupPartDefinition, MediaUploadProgressPartDefinition mediaUploadProgressPartDefinition, MediaUploadProcessingPartDefinition mediaUploadProcessingPartDefinition, OfflineFooterSelector offlineFooterSelector, OfflineSuccessPartDefinition offlineSuccessPartDefinition, OfflineProgressPartDefinition offlineProgressPartDefinition, OfflineProgressV2PartDefinition offlineProgressV2PartDefinition, OfflineRetryPartDefinition offlineRetryPartDefinition, OfflineFailedPartDefinition offlineFailedPartDefinition, OfflineFailedV2PartDefinition offlineFailedV2PartDefinition, DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, TextSelectorPartDefinition textSelectorPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, MinutiaeAttachmentGroupPartDefinition minutiaeAttachmentGroupPartDefinition, StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition, BlingBarRootPartDefinition blingBarRootPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, AttributionPartDefinition attributionPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, OptimisticStoryStateCache optimisticStoryStateCache, SocialPromptFeedEntryPointPartDefinition socialPromptFeedEntryPointPartDefinition, QeAccessor qeAccessor, Clock clock) {
        this.f19958c = offlineSuccessPartDefinition;
        this.f19973r = offlineAnimationGroupPartDefinition;
        this.f19956a = mediaUploadProgressPartDefinition;
        this.f19957b = mediaUploadProcessingPartDefinition;
        this.f19971p = offlineFooterSelector;
        this.f19959d = offlineProgressPartDefinition;
        this.f19960e = offlineProgressV2PartDefinition;
        this.f19961f = offlineRetryPartDefinition;
        this.f19962g = offlineFailedPartDefinition;
        this.f19963h = offlineFailedV2PartDefinition;
        this.f19964i = defaultHeaderSelectorPartDefinition;
        this.f19965j = stickerRootPartDefinition;
        this.f19968m = attachmentsPartDefinition;
        this.f19966k = minutiaeAttachmentGroupPartDefinition;
        this.f19969n = storyPostFooterSelectorPartDefinition;
        this.f19970o = blingBarRootPartDefinition;
        this.f19972q = feedAttachedStoryPartDefinition;
        this.f19975t = attributionPartDefinition;
        this.f19974s = inlineCommentComposerPartDefinition;
        this.f19976u = optimisticStoryStateCache;
        this.f19967l = textSelectorPartDefinition;
        this.f19977v = socialPromptFeedEntryPointPartDefinition;
        this.f19978w = qeAccessor;
        this.f19979x = clock;
    }

    public static boolean m27734a(FeedProps<GraphQLStory> feedProps, OptimisticStoryStateCache optimisticStoryStateCache) {
        GraphQLFeedOptimisticPublishState a = optimisticStoryStateCache.m9728a((GraphQLStory) feedProps.f13444a);
        return (a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || a == GraphQLFeedOptimisticPublishState.DELETED) ? false : true;
    }
}
