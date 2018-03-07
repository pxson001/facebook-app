package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.ThrowbackCollageAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.ThrowbackSimplePhotoAttachmentPartDefinition;
import com.facebook.feedplugins.video.VideoAttachmentsSelectorPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLGoodwillFriendversaryCampaign;
import com.facebook.graphql.model.GraphQLGoodwillVideoCampaign;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fbacore_ */
public class ThrowbackFriendversaryAttachmentPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLGoodwillFriendversaryCampaign, Void, FeedEnvironment> {
    private static ThrowbackFriendversaryAttachmentPartDefinition f13630f;
    private static final Object f13631g = new Object();
    private final Lazy<ThrowbackCollageAttachmentPartDefinition> f13632a;
    private final Lazy<PhotoAttachmentPartDefinition> f13633b;
    private final Lazy<ThrowbackSimplePhotoAttachmentPartDefinition> f13634c;
    private final Lazy<VideoAttachmentsSelectorPartDefinition> f13635d;
    private final GatekeeperStoreImpl f13636e;

    private static ThrowbackFriendversaryAttachmentPartDefinition m15360b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryAttachmentPartDefinition(IdBasedLazy.a(injectorLike, 6264), IdBasedLazy.a(injectorLike, 6285), IdBasedLazy.a(injectorLike, 1530), IdBasedLazy.a(injectorLike, 2066), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m15361a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = (GraphQLGoodwillFriendversaryCampaign) obj;
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded;
        if (ThrowbackFeedUtils.m15330a(graphQLGoodwillFriendversaryCampaign)) {
            multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) this.f13635d.get();
            GraphQLGoodwillVideoCampaign x = graphQLGoodwillFriendversaryCampaign.x();
            Builder builder = new Builder();
            builder.r = x.l();
            builder.q = ((GraphQLStoryAttachment) x.l().get(0)).w();
            GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
            builder2.o = graphQLGoodwillFriendversaryCampaign.g();
            builder2 = builder2;
            builder2.ay = graphQLGoodwillFriendversaryCampaign.v();
            builder2 = builder2;
            builder2.m = ImmutableList.of(builder.a());
            GraphQLStory a = builder2.a();
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(a);
            baseMultiRowSubParts.a(multiRowPartWithIsNeeded, FeedProps.c(graphQLGoodwillFriendversaryCampaign).a(a).a(o).a((Flattenable) o.x().get(0)));
        } else if (ThrowbackFeedUtils.m15331b(graphQLGoodwillFriendversaryCampaign)) {
            if (graphQLGoodwillFriendversaryCampaign.o().size() != 1) {
                multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) this.f13632a.get();
                Builder builder3 = new Builder();
                builder3.r = graphQLGoodwillFriendversaryCampaign.o();
                GraphQLStoryAttachment a2 = builder3.a();
                GraphQLStory.Builder builder4 = new GraphQLStory.Builder();
                builder4.o = graphQLGoodwillFriendversaryCampaign.g();
                builder4 = builder4;
                builder4.ay = graphQLGoodwillFriendversaryCampaign.v();
                builder4 = builder4;
                builder4.m = ImmutableList.of(a2);
                baseMultiRowSubParts.a(multiRowPartWithIsNeeded, FeedProps.c(graphQLGoodwillFriendversaryCampaign).a(builder4.a()));
            } else if (this.f13636e.a(858, false)) {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f13634c.get(), m15359b(graphQLGoodwillFriendversaryCampaign));
            } else {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f13633b.get(), m15359b(graphQLGoodwillFriendversaryCampaign));
            }
        }
        return null;
    }

    public final boolean m15362a(Object obj) {
        GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = (GraphQLGoodwillFriendversaryCampaign) obj;
        return ThrowbackFeedUtils.m15331b(graphQLGoodwillFriendversaryCampaign) || ThrowbackFeedUtils.m15330a(graphQLGoodwillFriendversaryCampaign);
    }

    @Inject
    public ThrowbackFriendversaryAttachmentPartDefinition(Lazy<ThrowbackCollageAttachmentPartDefinition> lazy, Lazy<ThrowbackSimplePhotoAttachmentPartDefinition> lazy2, Lazy<PhotoAttachmentPartDefinition> lazy3, Lazy<VideoAttachmentsSelectorPartDefinition> lazy4, GatekeeperStore gatekeeperStore) {
        this.f13632a = lazy;
        this.f13634c = lazy2;
        this.f13633b = lazy3;
        this.f13635d = lazy4;
        this.f13636e = gatekeeperStore;
    }

    public static ThrowbackFriendversaryAttachmentPartDefinition m15358a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13631g) {
                ThrowbackFriendversaryAttachmentPartDefinition throwbackFriendversaryAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryAttachmentPartDefinition = (ThrowbackFriendversaryAttachmentPartDefinition) a2.a(f13631g);
                } else {
                    throwbackFriendversaryAttachmentPartDefinition = f13630f;
                }
                if (throwbackFriendversaryAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15360b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13631g, b3);
                        } else {
                            f13630f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static FeedProps<GraphQLStoryAttachment> m15359b(GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign) {
        Builder builder = new Builder();
        builder.r = graphQLGoodwillFriendversaryCampaign.o();
        GraphQLStoryAttachment a = builder.a();
        GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
        builder2.o = graphQLGoodwillFriendversaryCampaign.g();
        builder2 = builder2;
        builder2.ay = graphQLGoodwillFriendversaryCampaign.v();
        builder2 = builder2;
        builder2.m = ImmutableList.of(a);
        GraphQLStory a2 = builder2.a();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(a2);
        return FeedProps.c(graphQLGoodwillFriendversaryCampaign).a(a2).a(o).a((Flattenable) o.x().get(0));
    }
}
