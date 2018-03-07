package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.storyset.rows.StorySetLabelWithSocialContextPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.VideoSetsTextExtractor.GenericLabel;
import com.facebook.feedplugins.storyset.rows.ui.AutoPlayVideoAttachmentStylePageWithSocialContextView;
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
/* compiled from: jv_ID */
public class VideoSetsPageItemWithSocialContextPartDefinition<E extends CanShowVideoInFullScreen & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, AutoPlayVideoAttachmentStylePageWithSocialContextView> {
    public static final ViewType<AutoPlayVideoAttachmentStylePageWithSocialContextView> f18547a = new C07341();
    private static VideoSetsPageItemWithSocialContextPartDefinition f18548e;
    private static final Object f18549f = new Object();
    private final VideoSetsVideoPartDefinition f18550b;
    private final StorySetLabelWithSocialContextPartDefinition f18551c;
    private final VideoSetsTextExtractor f18552d;

    /* compiled from: jv_ID */
    final class C07341 extends ViewType<AutoPlayVideoAttachmentStylePageWithSocialContextView> {
        C07341() {
        }

        public final View mo1995a(Context context) {
            return new AutoPlayVideoAttachmentStylePageWithSocialContextView(context);
        }
    }

    private static VideoSetsPageItemWithSocialContextPartDefinition m26026b(InjectorLike injectorLike) {
        return new VideoSetsPageItemWithSocialContextPartDefinition(VideoSetsVideoPartDefinition.m26045a(injectorLike), StorySetLabelWithSocialContextPartDefinition.a(injectorLike), VideoSetsTextExtractor.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GenericLabel genericLabel;
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) storySetPageProps.b.f13444a;
        FeedProps a = FeedProps.m19801a(StoryAttachmentHelper.m28042o(graphQLStory), ImmutableList.of(graphQLStory));
        VideoSetsTextExtractor videoSetsTextExtractor = this.f18552d;
        if (graphQLStory == null || a.f13444a == null) {
            genericLabel = new GenericLabel();
        } else {
            String str;
            genericLabel = videoSetsTextExtractor.a(a);
            if (graphQLStory == null || graphQLStory.aA() == null || graphQLStory.aA().m24869o() == null || graphQLStory.aA().m24869o().mo2911a() == null) {
                str = "";
            } else {
                str = graphQLStory.aA().m24869o().mo2911a();
            }
            genericLabel.c = str;
        }
        GenericLabel genericLabel2 = genericLabel;
        subParts.mo2755a(2131567716, this.f18550b, storySetPageProps);
        subParts.mo2755a(2131567717, this.f18551c, new Props(genericLabel2.a, genericLabel2.b, genericLabel2.c));
        return null;
    }

    public static VideoSetsPageItemWithSocialContextPartDefinition m26025a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsPageItemWithSocialContextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18549f) {
                VideoSetsPageItemWithSocialContextPartDefinition videoSetsPageItemWithSocialContextPartDefinition;
                if (a2 != null) {
                    videoSetsPageItemWithSocialContextPartDefinition = (VideoSetsPageItemWithSocialContextPartDefinition) a2.mo818a(f18549f);
                } else {
                    videoSetsPageItemWithSocialContextPartDefinition = f18548e;
                }
                if (videoSetsPageItemWithSocialContextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26026b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18549f, b3);
                        } else {
                            f18548e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsPageItemWithSocialContextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VideoSetsPageItemWithSocialContextPartDefinition(VideoSetsVideoPartDefinition videoSetsVideoPartDefinition, StorySetLabelWithSocialContextPartDefinition storySetLabelWithSocialContextPartDefinition, VideoSetsTextExtractor videoSetsTextExtractor) {
        this.f18550b = videoSetsVideoPartDefinition;
        this.f18551c = storySetLabelWithSocialContextPartDefinition;
        this.f18552d = videoSetsTextExtractor;
    }

    public final ViewType<AutoPlayVideoAttachmentStylePageWithSocialContextView> mo2547a() {
        return f18547a;
    }
}
