package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
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
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PlatformComposerLaunch */
public class LiveFeedMainVideoAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, RichVideoAttachmentView> {
    public static final ViewType f24498a = new C25891();
    private static LiveFeedMainVideoAttachmentPartDefinition f24499f;
    private static final Object f24500g = new Object();
    private final Resources f24501b;
    private final ViewPaddingPartDefinition f24502c;
    private final VideoAttachmentsSelectorPartDefinition f24503d;
    private final LiveFeedVideoAttachmentPartDefinition<E> f24504e;

    /* compiled from: PlatformComposerLaunch */
    final class C25891 extends ViewType {
        C25891() {
        }

        public final View m27963a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static LiveFeedMainVideoAttachmentPartDefinition m27965b(InjectorLike injectorLike) {
        return new LiveFeedMainVideoAttachmentPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), VideoAttachmentsSelectorPartDefinition.a(injectorLike), LiveFeedVideoAttachmentPartDefinition.m28005a(injectorLike));
    }

    public final Object m27967a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24504e, (FeedProps) obj);
        int dimensionPixelSize = this.f24501b.getDimensionPixelSize(2131432592);
        subParts.a(this.f24502c, new PaddingData(this.f24501b.getDimensionPixelSize(2131432588), dimensionPixelSize, this.f24501b.getDimensionPixelSize(2131432589), dimensionPixelSize));
        return null;
    }

    public final boolean m27968a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        return StoryAttachmentHelper.o(graphQLStory) != null && GraphQLStoryAttachmentUtil.a(StoryAttachmentHelper.o(graphQLStory), GraphQLStoryAttachmentStyle.VIDEO) && this.f24503d.a(StoryProps.i(feedProps));
    }

    public static LiveFeedMainVideoAttachmentPartDefinition m27964a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedMainVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24500g) {
                LiveFeedMainVideoAttachmentPartDefinition liveFeedMainVideoAttachmentPartDefinition;
                if (a2 != null) {
                    liveFeedMainVideoAttachmentPartDefinition = (LiveFeedMainVideoAttachmentPartDefinition) a2.a(f24500g);
                } else {
                    liveFeedMainVideoAttachmentPartDefinition = f24499f;
                }
                if (liveFeedMainVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27965b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24500g, b3);
                        } else {
                            f24499f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedMainVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LiveFeedMainVideoAttachmentPartDefinition(Resources resources, ViewPaddingPartDefinition viewPaddingPartDefinition, VideoAttachmentsSelectorPartDefinition videoAttachmentsSelectorPartDefinition, LiveFeedVideoAttachmentPartDefinition liveFeedVideoAttachmentPartDefinition) {
        this.f24501b = resources;
        this.f24502c = viewPaddingPartDefinition;
        this.f24503d = videoAttachmentsSelectorPartDefinition;
        this.f24504e = liveFeedVideoAttachmentPartDefinition;
    }

    public final ViewType<RichVideoAttachmentView> m27966a() {
        return f24498a;
    }
}
