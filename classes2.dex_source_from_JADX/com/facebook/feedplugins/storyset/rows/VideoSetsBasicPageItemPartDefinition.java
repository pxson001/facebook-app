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
import com.facebook.feedplugins.storyset.rows.StorySetLabelPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.VideoSetsTextExtractor.GenericLabel;
import com.facebook.feedplugins.storyset.rows.ui.AutoPlayVideoAttachmentStyleBasicPageView;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: json */
public class VideoSetsBasicPageItemPartDefinition<E extends CanShowVideoInFullScreen & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, AutoPlayVideoAttachmentStyleBasicPageView> {
    public static final ViewType<AutoPlayVideoAttachmentStyleBasicPageView> f18566a = new C07371();
    private static VideoSetsBasicPageItemPartDefinition f18567e;
    private static final Object f18568f = new Object();
    private final Lazy<VideoSetsVideoPartDefinition> f18569b;
    private final StorySetLabelPartDefinition f18570c;
    private final VideoSetsTextExtractor f18571d;

    /* compiled from: json */
    final class C07371 extends ViewType<AutoPlayVideoAttachmentStyleBasicPageView> {
        C07371() {
        }

        public final View mo1995a(Context context) {
            return new AutoPlayVideoAttachmentStyleBasicPageView(context);
        }
    }

    private static VideoSetsBasicPageItemPartDefinition m26041b(InjectorLike injectorLike) {
        return new VideoSetsBasicPageItemPartDefinition(IdBasedLazy.m1808a(injectorLike, 2047), StorySetLabelPartDefinition.a(injectorLike), VideoSetsTextExtractor.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) storySetPageProps.b.f13444a;
        GenericLabel a = this.f18571d.a(FeedProps.m19801a(StoryAttachmentHelper.m28042o(graphQLStory), ImmutableList.of(graphQLStory)));
        subParts.mo2755a(2131567716, (SinglePartDefinition) this.f18569b.get(), storySetPageProps);
        subParts.mo2755a(2131567717, this.f18570c, new Props(a.a, a.b));
        return null;
    }

    public static VideoSetsBasicPageItemPartDefinition m26040a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsBasicPageItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18568f) {
                VideoSetsBasicPageItemPartDefinition videoSetsBasicPageItemPartDefinition;
                if (a2 != null) {
                    videoSetsBasicPageItemPartDefinition = (VideoSetsBasicPageItemPartDefinition) a2.mo818a(f18568f);
                } else {
                    videoSetsBasicPageItemPartDefinition = f18567e;
                }
                if (videoSetsBasicPageItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26041b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18568f, b3);
                        } else {
                            f18567e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsBasicPageItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VideoSetsBasicPageItemPartDefinition(Lazy<VideoSetsVideoPartDefinition> lazy, StorySetLabelPartDefinition storySetLabelPartDefinition, VideoSetsTextExtractor videoSetsTextExtractor) {
        this.f18569b = lazy;
        this.f18570c = storySetLabelPartDefinition;
        this.f18571d = videoSetsTextExtractor;
    }

    public final ViewType<AutoPlayVideoAttachmentStyleBasicPageView> mo2547a() {
        return f18566a;
    }
}
