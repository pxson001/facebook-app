package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
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
/* compiled from: Photo */
public class LiveFeedResharedAttachmentPhotoPartDefinition<E extends HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, FbDraweeView> {
    public static final ViewType f24543a = new C25941();
    private static LiveFeedResharedAttachmentPhotoPartDefinition f24544d;
    private static final Object f24545e = new Object();
    private final LiveFeedPhotoAttachmentPartDefinition<E> f24546b;
    private final LiveFeedResharedAttachmentBackgroundPartDefinition f24547c;

    /* compiled from: Photo */
    final class C25941 extends ViewType {
        C25941() {
        }

        public final View m27993a(Context context) {
            return new FbDraweeView(context);
        }
    }

    private static LiveFeedResharedAttachmentPhotoPartDefinition m27995b(InjectorLike injectorLike) {
        return new LiveFeedResharedAttachmentPhotoPartDefinition(LiveFeedPhotoAttachmentPartDefinition.m27970a(injectorLike), LiveFeedResharedAttachmentBackgroundPartDefinition.m27979a(injectorLike));
    }

    public final Object m27997a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24546b, (FeedProps) obj);
        subParts.a(this.f24547c, Position.MIDDLE);
        return null;
    }

    public final boolean m27998a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return (StoryAttachmentHelper.o(graphQLStory) == null || GraphQLStoryAttachmentUtil.l(StoryAttachmentHelper.o(graphQLStory)) == null || !GraphQLStoryAttachmentUtil.a(StoryAttachmentHelper.o(graphQLStory), GraphQLStoryAttachmentStyle.PHOTO)) ? false : true;
    }

    @Inject
    public LiveFeedResharedAttachmentPhotoPartDefinition(LiveFeedPhotoAttachmentPartDefinition liveFeedPhotoAttachmentPartDefinition, LiveFeedResharedAttachmentBackgroundPartDefinition liveFeedResharedAttachmentBackgroundPartDefinition) {
        this.f24546b = liveFeedPhotoAttachmentPartDefinition;
        this.f24547c = liveFeedResharedAttachmentBackgroundPartDefinition;
    }

    public final ViewType<FbDraweeView> m27996a() {
        return f24543a;
    }

    public static LiveFeedResharedAttachmentPhotoPartDefinition m27994a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedResharedAttachmentPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24545e) {
                LiveFeedResharedAttachmentPhotoPartDefinition liveFeedResharedAttachmentPhotoPartDefinition;
                if (a2 != null) {
                    liveFeedResharedAttachmentPhotoPartDefinition = (LiveFeedResharedAttachmentPhotoPartDefinition) a2.a(f24545e);
                } else {
                    liveFeedResharedAttachmentPhotoPartDefinition = f24544d;
                }
                if (liveFeedResharedAttachmentPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27995b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24545e, b3);
                        } else {
                            f24544d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedResharedAttachmentPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
