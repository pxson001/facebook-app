package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.ThrowbackCollageAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackFeedFooterPartDefinition;
import com.facebook.goodwill.feed.rows.ThrowbackFeedStorySectionHeaderPartDefinition.Props;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackMissedMemoriesStory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_draft_dialog_seen */
public class ThrowbackMissedMemoriesStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackMissedMemoriesStory>, Void, FeedEnvironment> {
    private static ThrowbackMissedMemoriesStoryGroupPartDefinition f13738f;
    private static final Object f13739g = new Object();
    private final ThrowbackCollageAttachmentPartDefinition<FeedEnvironment> f13740a;
    private final ThrowbackPhotoStoriesHScrollPartDefinition<FeedEnvironment> f13741b;
    private final ThrowbackFeedStorySectionHeaderPartDefinition f13742c;
    private final PhotoAttachmentPartDefinition<FeedEnvironment> f13743d;
    private final ThrowbackFeedFooterPartDefinition f13744e;

    private static ThrowbackMissedMemoriesStoryGroupPartDefinition m15418b(InjectorLike injectorLike) {
        return new ThrowbackMissedMemoriesStoryGroupPartDefinition(ThrowbackPhotoStoriesHScrollPartDefinition.m15432a(injectorLike), ThrowbackFeedStorySectionHeaderPartDefinition.m15323a(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike), ThrowbackFeedFooterPartDefinition.a(injectorLike), ThrowbackCollageAttachmentPartDefinition.m14294a(injectorLike));
    }

    public final Object m15419a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory = (GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a;
        FeedProps a;
        if (graphQLGoodwillThrowbackMissedMemoriesStory.a().size() == 1 && graphQLGoodwillThrowbackMissedMemoriesStory.b().size() == 1) {
            a = feedProps.a((GraphQLStory) ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b().get(0));
            Props props = new Props(a, graphQLGoodwillThrowbackMissedMemoriesStory.Y_(), false);
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).a().get(0);
            baseMultiRowSubParts.a(this.f13742c, props);
            baseMultiRowSubParts.a(this.f13743d, a.a(graphQLStoryAttachment));
            baseMultiRowSubParts.a(this.f13744e, a);
        } else if ("collage".equals(graphQLGoodwillThrowbackMissedMemoriesStory.c()) && graphQLGoodwillThrowbackMissedMemoriesStory.a().size() > 1) {
            GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory2 = (GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a;
            Builder builder = new Builder();
            builder.r = graphQLGoodwillThrowbackMissedMemoriesStory2.a();
            builder = builder;
            builder.q = ImmutableList.of(GraphQLStoryAttachmentStyle.ALBUM);
            GraphQLStoryAttachment a2 = builder.a();
            GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
            builder2.o = graphQLGoodwillThrowbackMissedMemoriesStory2.g();
            builder2 = builder2;
            builder2.ay = null;
            builder2 = builder2;
            builder2.m = ImmutableList.of(a2);
            a = FeedProps.c(builder2.a());
            baseMultiRowSubParts.a(this.f13742c, new Props(a, graphQLGoodwillThrowbackMissedMemoriesStory.Y_(), false));
            baseMultiRowSubParts.a(this.f13740a, feedProps.a(a.a));
        } else if ("horizontal_scroll".equals(graphQLGoodwillThrowbackMissedMemoriesStory.c()) && graphQLGoodwillThrowbackMissedMemoriesStory.b().size() > 1) {
            baseMultiRowSubParts.a(this.f13742c, new Props(feedProps, graphQLGoodwillThrowbackMissedMemoriesStory.Y_(), false));
            baseMultiRowSubParts.a(this.f13741b, feedProps);
        }
        return null;
    }

    public final boolean m15420a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps == null || feedProps.a == null) {
            return false;
        }
        GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory = (GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a;
        if (graphQLGoodwillThrowbackMissedMemoriesStory.c() == null || graphQLGoodwillThrowbackMissedMemoriesStory.Y_() == null) {
            return false;
        }
        if (graphQLGoodwillThrowbackMissedMemoriesStory.a() == null || graphQLGoodwillThrowbackMissedMemoriesStory.a().isEmpty() || graphQLGoodwillThrowbackMissedMemoriesStory.b() == null || graphQLGoodwillThrowbackMissedMemoriesStory.b().isEmpty()) {
            return false;
        }
        GraphQLStoryAttachment o;
        if (graphQLGoodwillThrowbackMissedMemoriesStory.b().size() == 1 && graphQLGoodwillThrowbackMissedMemoriesStory.b().get(0) != null && graphQLGoodwillThrowbackMissedMemoriesStory.a().size() == 1 && graphQLGoodwillThrowbackMissedMemoriesStory.a().get(0) != null) {
            o = StoryAttachmentHelper.o((GraphQLStory) ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b().get(0));
            if (o == null) {
                return false;
            }
            if (o.r() != null) {
                return true;
            }
            return false;
        } else if ("horizontal_scroll".equals(graphQLGoodwillThrowbackMissedMemoriesStory.c())) {
            r4 = ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b();
            r5 = r4.size();
            for (r3 = 0; r3 < r5; r3++) {
                o = StoryAttachmentHelper.o((GraphQLStory) r4.get(r3));
                if (o != null && o.r() != null) {
                    return true;
                }
            }
            return false;
        } else if (!"collage".equals(graphQLGoodwillThrowbackMissedMemoriesStory.c())) {
            return false;
        } else {
            r4 = graphQLGoodwillThrowbackMissedMemoriesStory.a();
            r5 = r4.size();
            for (r3 = 0; r3 < r5; r3++) {
                o = (GraphQLStoryAttachment) r4.get(r3);
                if (o != null && o.a() != null) {
                    return true;
                }
            }
            return false;
        }
    }

    @Inject
    public ThrowbackMissedMemoriesStoryGroupPartDefinition(ThrowbackPhotoStoriesHScrollPartDefinition throwbackPhotoStoriesHScrollPartDefinition, ThrowbackFeedStorySectionHeaderPartDefinition throwbackFeedStorySectionHeaderPartDefinition, PhotoAttachmentPartDefinition photoAttachmentPartDefinition, ThrowbackFeedFooterPartDefinition throwbackFeedFooterPartDefinition, ThrowbackCollageAttachmentPartDefinition throwbackCollageAttachmentPartDefinition) {
        this.f13741b = throwbackPhotoStoriesHScrollPartDefinition;
        this.f13740a = throwbackCollageAttachmentPartDefinition;
        this.f13742c = throwbackFeedStorySectionHeaderPartDefinition;
        this.f13743d = photoAttachmentPartDefinition;
        this.f13744e = throwbackFeedFooterPartDefinition;
    }

    public static ThrowbackMissedMemoriesStoryGroupPartDefinition m15417a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackMissedMemoriesStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13739g) {
                ThrowbackMissedMemoriesStoryGroupPartDefinition throwbackMissedMemoriesStoryGroupPartDefinition;
                if (a2 != null) {
                    throwbackMissedMemoriesStoryGroupPartDefinition = (ThrowbackMissedMemoriesStoryGroupPartDefinition) a2.a(f13739g);
                } else {
                    throwbackMissedMemoriesStoryGroupPartDefinition = f13738f;
                }
                if (throwbackMissedMemoriesStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15418b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13739g, b3);
                        } else {
                            f13738f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackMissedMemoriesStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
