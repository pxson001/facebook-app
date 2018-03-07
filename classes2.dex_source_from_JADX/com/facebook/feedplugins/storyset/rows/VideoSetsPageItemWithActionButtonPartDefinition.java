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
import com.facebook.feedplugins.storyset.rows.StorySetLabelWithSocialContextAndButtonPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.VideoSetsTextExtractor.GenericLabel;
import com.facebook.feedplugins.storyset.rows.ui.AutoPlayVideoAttachmentStylePageWithActionButtonView;
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
/* compiled from: k */
public class VideoSetsPageItemWithActionButtonPartDefinition<E extends CanShowVideoInFullScreen & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, AutoPlayVideoAttachmentStylePageWithActionButtonView> {
    public static final ViewType<AutoPlayVideoAttachmentStylePageWithActionButtonView> f18541a = new C07331();
    private static VideoSetsPageItemWithActionButtonPartDefinition f18542e;
    private static final Object f18543f = new Object();
    private final VideoSetsVideoPartDefinition f18544b;
    private final StorySetLabelWithSocialContextAndButtonPartDefinition f18545c;
    private final VideoSetsTextExtractor f18546d;

    /* compiled from: k */
    final class C07331 extends ViewType<AutoPlayVideoAttachmentStylePageWithActionButtonView> {
        C07331() {
        }

        public final View mo1995a(Context context) {
            return new AutoPlayVideoAttachmentStylePageWithActionButtonView(context);
        }
    }

    private static VideoSetsPageItemWithActionButtonPartDefinition m26021b(InjectorLike injectorLike) {
        return new VideoSetsPageItemWithActionButtonPartDefinition(VideoSetsVideoPartDefinition.m26045a(injectorLike), StorySetLabelWithSocialContextAndButtonPartDefinition.a(injectorLike), VideoSetsTextExtractor.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) storySetPageProps.b.f13444a;
        FeedProps a = FeedProps.m19801a(StoryAttachmentHelper.m28042o(graphQLStory), ImmutableList.of(graphQLStory));
        GenericLabel a2 = this.f18546d.a(a);
        subParts.mo2755a(2131567716, this.f18544b, storySetPageProps);
        subParts.mo2755a(2131567715, this.f18545c, new Props(a2.a, a2.b, a));
        return null;
    }

    public static VideoSetsPageItemWithActionButtonPartDefinition m26020a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsPageItemWithActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18543f) {
                VideoSetsPageItemWithActionButtonPartDefinition videoSetsPageItemWithActionButtonPartDefinition;
                if (a2 != null) {
                    videoSetsPageItemWithActionButtonPartDefinition = (VideoSetsPageItemWithActionButtonPartDefinition) a2.mo818a(f18543f);
                } else {
                    videoSetsPageItemWithActionButtonPartDefinition = f18542e;
                }
                if (videoSetsPageItemWithActionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26021b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18543f, b3);
                        } else {
                            f18542e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsPageItemWithActionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VideoSetsPageItemWithActionButtonPartDefinition(VideoSetsVideoPartDefinition videoSetsVideoPartDefinition, StorySetLabelWithSocialContextAndButtonPartDefinition storySetLabelWithSocialContextAndButtonPartDefinition, VideoSetsTextExtractor videoSetsTextExtractor) {
        this.f18544b = videoSetsVideoPartDefinition;
        this.f18545c = storySetLabelWithSocialContextAndButtonPartDefinition;
        this.f18546d = videoSetsTextExtractor;
    }

    public final ViewType<AutoPlayVideoAttachmentStylePageWithActionButtonView> mo2547a() {
        return f18541a;
    }
}
