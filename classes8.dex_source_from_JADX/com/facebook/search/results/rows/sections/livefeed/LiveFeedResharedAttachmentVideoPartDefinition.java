package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.VideoAttachmentsSelectorPartDefinition;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
/* compiled from: PersonCardFetchCard */
public class LiveFeedResharedAttachmentVideoPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, RichVideoAttachmentView> {
    public static final ViewType f24548a = new C25951();
    private static LiveFeedResharedAttachmentVideoPartDefinition f24549e;
    private static final Object f24550f = new Object();
    private final LiveFeedResharedAttachmentBackgroundPartDefinition f24551b;
    private final VideoAttachmentsSelectorPartDefinition f24552c;
    private final LiveFeedVideoAttachmentPartDefinition<E> f24553d;

    /* compiled from: PersonCardFetchCard */
    final class C25951 extends ViewType {
        C25951() {
        }

        public final View m27999a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static LiveFeedResharedAttachmentVideoPartDefinition m28001b(InjectorLike injectorLike) {
        return new LiveFeedResharedAttachmentVideoPartDefinition(LiveFeedResharedAttachmentBackgroundPartDefinition.m27979a(injectorLike), VideoAttachmentsSelectorPartDefinition.a(injectorLike), LiveFeedVideoAttachmentPartDefinition.m28005a(injectorLike));
    }

    public final Object m28003a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24553d, (FeedProps) obj);
        subParts.a(this.f24551b, Position.MIDDLE);
        return null;
    }

    public final boolean m28004a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return GraphQLStoryAttachmentUtil.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a), GraphQLStoryAttachmentStyle.VIDEO) && this.f24552c.a(StoryProps.i(feedProps));
    }

    @Inject
    public LiveFeedResharedAttachmentVideoPartDefinition(LiveFeedResharedAttachmentBackgroundPartDefinition liveFeedResharedAttachmentBackgroundPartDefinition, VideoAttachmentsSelectorPartDefinition videoAttachmentsSelectorPartDefinition, LiveFeedVideoAttachmentPartDefinition liveFeedVideoAttachmentPartDefinition) {
        this.f24551b = liveFeedResharedAttachmentBackgroundPartDefinition;
        this.f24552c = videoAttachmentsSelectorPartDefinition;
        this.f24553d = liveFeedVideoAttachmentPartDefinition;
    }

    public static LiveFeedResharedAttachmentVideoPartDefinition m28000a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedResharedAttachmentVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24550f) {
                LiveFeedResharedAttachmentVideoPartDefinition liveFeedResharedAttachmentVideoPartDefinition;
                if (a2 != null) {
                    liveFeedResharedAttachmentVideoPartDefinition = (LiveFeedResharedAttachmentVideoPartDefinition) a2.a(f24550f);
                } else {
                    liveFeedResharedAttachmentVideoPartDefinition = f24549e;
                }
                if (liveFeedResharedAttachmentVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28001b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24550f, b3);
                        } else {
                            f24549e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedResharedAttachmentVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<RichVideoAttachmentView> m28002a() {
        return f24548a;
    }
}
