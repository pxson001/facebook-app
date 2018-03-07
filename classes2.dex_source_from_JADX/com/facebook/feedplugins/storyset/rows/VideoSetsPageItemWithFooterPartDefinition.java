package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.storyset.rows.StorySetLabelPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.VideoSetsTextExtractor.GenericLabel;
import com.facebook.feedplugins.storyset.rows.ui.AutoPlayVideoAttachmentStylePageWithFooterView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: jv */
public class VideoSetsPageItemWithFooterPartDefinition<E extends CanFeedback & CanShowVideoInFullScreen & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, AutoPlayVideoAttachmentStylePageWithFooterView> {
    public static final ViewType<AutoPlayVideoAttachmentStylePageWithFooterView> f18553a = new C07351();
    private static VideoSetsPageItemWithFooterPartDefinition f18554f;
    private static final Object f18555g = new Object();
    private final VideoSetsVideoPartDefinition f18556b;
    private final StorySetLabelPartDefinition f18557c;
    private final VideoSetsFooterSelectorPartDefinition f18558d;
    private final VideoSetsTextExtractor f18559e;

    /* compiled from: jv */
    final class C07351 extends ViewType<AutoPlayVideoAttachmentStylePageWithFooterView> {
        C07351() {
        }

        public final View mo1995a(Context context) {
            return new AutoPlayVideoAttachmentStylePageWithFooterView(context);
        }
    }

    private static VideoSetsPageItemWithFooterPartDefinition m26031b(InjectorLike injectorLike) {
        return new VideoSetsPageItemWithFooterPartDefinition(VideoSetsVideoPartDefinition.m26045a(injectorLike), StorySetLabelPartDefinition.a(injectorLike), VideoSetsFooterSelectorPartDefinition.a(injectorLike), VideoSetsTextExtractor.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) storySetPageProps.b.f13444a;
        GenericLabel a = this.f18559e.a(FeedProps.m19801a(StoryAttachmentHelper.m28042o(graphQLStory), ImmutableList.of(graphQLStory)));
        subParts.mo2755a(2131567716, this.f18556b, storySetPageProps);
        subParts.mo2755a(2131567717, this.f18557c, new Props(a.a, a.b));
        subParts.mo2756a(this.f18558d, storySetPageProps.b);
        return null;
    }

    public static VideoSetsPageItemWithFooterPartDefinition m26030a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsPageItemWithFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18555g) {
                VideoSetsPageItemWithFooterPartDefinition videoSetsPageItemWithFooterPartDefinition;
                if (a2 != null) {
                    videoSetsPageItemWithFooterPartDefinition = (VideoSetsPageItemWithFooterPartDefinition) a2.mo818a(f18555g);
                } else {
                    videoSetsPageItemWithFooterPartDefinition = f18554f;
                }
                if (videoSetsPageItemWithFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26031b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18555g, b3);
                        } else {
                            f18554f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsPageItemWithFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VideoSetsPageItemWithFooterPartDefinition(VideoSetsVideoPartDefinition videoSetsVideoPartDefinition, StorySetLabelPartDefinition storySetLabelPartDefinition, VideoSetsFooterSelectorPartDefinition videoSetsFooterSelectorPartDefinition, VideoSetsTextExtractor videoSetsTextExtractor) {
        this.f18556b = videoSetsVideoPartDefinition;
        this.f18557c = storySetLabelPartDefinition;
        this.f18558d = videoSetsFooterSelectorPartDefinition;
        this.f18559e = videoSetsTextExtractor;
    }

    public final ViewType<AutoPlayVideoAttachmentStylePageWithFooterView> mo2547a() {
        return f18553a;
    }
}
