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
import com.facebook.feedplugins.storyset.rows.StorySetLabelWithSimpleBlingbarPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.VideoSetsTextExtractor.GenericLabel;
import com.facebook.feedplugins.storyset.rows.ui.AutoPlayVideoAttachmentStylePageWithSimpleBlingbarView;
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
/* compiled from: jump_to_top */
public class VideoSetsPageItemWithSimpleBlingbarPartDefinition<E extends CanShowVideoInFullScreen & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, AutoPlayVideoAttachmentStylePageWithSimpleBlingbarView> {
    public static final ViewType<AutoPlayVideoAttachmentStylePageWithSimpleBlingbarView> f18560a = new C07361();
    private static VideoSetsPageItemWithSimpleBlingbarPartDefinition f18561e;
    private static final Object f18562f = new Object();
    private final Lazy<VideoSetsVideoPartDefinition> f18563b;
    private final StorySetLabelWithSimpleBlingbarPartDefinition f18564c;
    private final VideoSetsTextExtractor f18565d;

    /* compiled from: jump_to_top */
    final class C07361 extends ViewType<AutoPlayVideoAttachmentStylePageWithSimpleBlingbarView> {
        C07361() {
        }

        public final View mo1995a(Context context) {
            return new AutoPlayVideoAttachmentStylePageWithSimpleBlingbarView(context);
        }
    }

    private static VideoSetsPageItemWithSimpleBlingbarPartDefinition m26036b(InjectorLike injectorLike) {
        return new VideoSetsPageItemWithSimpleBlingbarPartDefinition(IdBasedLazy.m1808a(injectorLike, 2047), StorySetLabelWithSimpleBlingbarPartDefinition.a(injectorLike), VideoSetsTextExtractor.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) storySetPageProps.b.f13444a;
        GenericLabel a = this.f18565d.a(FeedProps.m19801a(StoryAttachmentHelper.m28042o(graphQLStory), ImmutableList.of(graphQLStory)));
        subParts.mo2755a(2131567716, (SinglePartDefinition) this.f18563b.get(), storySetPageProps);
        subParts.mo2755a(2131567717, this.f18564c, new Props(a.a, a.b, graphQLStory));
        return null;
    }

    public static VideoSetsPageItemWithSimpleBlingbarPartDefinition m26035a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsPageItemWithSimpleBlingbarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18562f) {
                VideoSetsPageItemWithSimpleBlingbarPartDefinition videoSetsPageItemWithSimpleBlingbarPartDefinition;
                if (a2 != null) {
                    videoSetsPageItemWithSimpleBlingbarPartDefinition = (VideoSetsPageItemWithSimpleBlingbarPartDefinition) a2.mo818a(f18562f);
                } else {
                    videoSetsPageItemWithSimpleBlingbarPartDefinition = f18561e;
                }
                if (videoSetsPageItemWithSimpleBlingbarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26036b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18562f, b3);
                        } else {
                            f18561e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsPageItemWithSimpleBlingbarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VideoSetsPageItemWithSimpleBlingbarPartDefinition(Lazy<VideoSetsVideoPartDefinition> lazy, StorySetLabelWithSimpleBlingbarPartDefinition storySetLabelWithSimpleBlingbarPartDefinition, VideoSetsTextExtractor videoSetsTextExtractor) {
        this.f18563b = lazy;
        this.f18564c = storySetLabelWithSimpleBlingbarPartDefinition;
        this.f18565d = videoSetsTextExtractor;
    }

    public final ViewType<AutoPlayVideoAttachmentStylePageWithSimpleBlingbarView> mo2547a() {
        return f18560a;
    }
}
