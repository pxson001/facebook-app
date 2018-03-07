package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: PlatformComposerTTI */
public class LiveFeedMainPhotoAttachmentPartDefinition<E extends HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, FbDraweeView> {
    public static final ViewType f24492a = new C25881();
    private static LiveFeedMainPhotoAttachmentPartDefinition f24493e;
    private static final Object f24494f = new Object();
    private final Resources f24495b;
    private final ViewPaddingPartDefinition f24496c;
    private final LiveFeedPhotoAttachmentPartDefinition<E> f24497d;

    /* compiled from: PlatformComposerTTI */
    final class C25881 extends ViewType {
        C25881() {
        }

        public final View m27957a(Context context) {
            return new FbDraweeView(context);
        }
    }

    private static LiveFeedMainPhotoAttachmentPartDefinition m27959b(InjectorLike injectorLike) {
        return new LiveFeedMainPhotoAttachmentPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), LiveFeedPhotoAttachmentPartDefinition.m27970a(injectorLike));
    }

    public final Object m27961a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24497d, (FeedProps) obj);
        int dimensionPixelSize = this.f24495b.getDimensionPixelSize(2131432592);
        subParts.a(this.f24496c, new PaddingData(this.f24495b.getDimensionPixelSize(2131432588), dimensionPixelSize, this.f24495b.getDimensionPixelSize(2131432589), dimensionPixelSize));
        return null;
    }

    public final boolean m27962a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return (StoryAttachmentHelper.o(graphQLStory) == null || GraphQLStoryAttachmentUtil.l(StoryAttachmentHelper.o(graphQLStory)) == null || !GraphQLStoryAttachmentUtil.a(StoryAttachmentHelper.o(graphQLStory), GraphQLStoryAttachmentStyle.PHOTO)) ? false : true;
    }

    @Inject
    public LiveFeedMainPhotoAttachmentPartDefinition(Resources resources, ViewPaddingPartDefinition viewPaddingPartDefinition, LiveFeedPhotoAttachmentPartDefinition liveFeedPhotoAttachmentPartDefinition) {
        this.f24495b = resources;
        this.f24496c = viewPaddingPartDefinition;
        this.f24497d = liveFeedPhotoAttachmentPartDefinition;
    }

    public final ViewType<FbDraweeView> m27960a() {
        return f24492a;
    }

    public static LiveFeedMainPhotoAttachmentPartDefinition m27958a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedMainPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24494f) {
                LiveFeedMainPhotoAttachmentPartDefinition liveFeedMainPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    liveFeedMainPhotoAttachmentPartDefinition = (LiveFeedMainPhotoAttachmentPartDefinition) a2.a(f24494f);
                } else {
                    liveFeedMainPhotoAttachmentPartDefinition = f24493e;
                }
                if (liveFeedMainPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27959b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24494f, b3);
                        } else {
                            f24493e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedMainPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
