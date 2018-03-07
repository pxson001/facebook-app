package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.launcherhelper.PhotoGalleryLauncherHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PlaceCreationErrorHandler */
public class LiveFeedPhotoAttachmentPartDefinition<E extends HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, FbDraweeView> {
    private static final CallerContext f24513a = CallerContext.a(LiveFeedPhotoAttachmentPartDefinition.class, "graph_search_results_live_conversation_fragment");
    private static LiveFeedPhotoAttachmentPartDefinition f24514e;
    private static final Object f24515f = new Object();
    private final FbDraweePartDefinition<E> f24516b;
    private final ClickListenerPartDefinition f24517c;
    public final Lazy<PhotoGalleryLauncherHelper> f24518d;

    private static LiveFeedPhotoAttachmentPartDefinition m27971b(InjectorLike injectorLike) {
        return new LiveFeedPhotoAttachmentPartDefinition(FbDraweePartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 4891));
    }

    public final Object m27972a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        GraphQLImage graphQLImage = (GraphQLImage) Preconditions.checkNotNull(GraphQLStoryAttachmentUtil.l((GraphQLStoryAttachment) Preconditions.checkNotNull(StoryAttachmentHelper.o((GraphQLStory) feedProps.a))));
        float c = (graphQLImage.a() == 0 || graphQLImage.c() == 0) ? 1.9318181f : ((float) graphQLImage.c()) / ((float) graphQLImage.a());
        FbDraweePartDefinition fbDraweePartDefinition = this.f24516b;
        Builder a = FbDraweePartDefinition.a().a(graphQLImage.b());
        a.b = c;
        a = a;
        a.c = f24513a;
        subParts.a(fbDraweePartDefinition, a.a());
        subParts.a(this.f24517c, new OnClickListener(this) {
            final /* synthetic */ LiveFeedPhotoAttachmentPartDefinition f24512b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -293558370);
                LiveFeedPhotoAttachmentPartDefinition liveFeedPhotoAttachmentPartDefinition = this.f24512b;
                FeedProps feedProps = feedProps;
                GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                ((PhotoGalleryLauncherHelper) liveFeedPhotoAttachmentPartDefinition.f24518d.get()).a(feedProps.a((GraphQLStoryAttachment) Preconditions.checkNotNull(StoryAttachmentHelper.o(graphQLStory))), (FbDraweeView) view, ImageRequest.a(Uri.parse(GraphQLStoryAttachmentUtil.o(StoryAttachmentHelper.o(graphQLStory)))), false);
                Logger.a(2, EntryType.UI_INPUT_END, 1890609777, a);
            }
        });
        return null;
    }

    @Inject
    public LiveFeedPhotoAttachmentPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Lazy<PhotoGalleryLauncherHelper> lazy) {
        this.f24516b = fbDraweePartDefinition;
        this.f24517c = clickListenerPartDefinition;
        this.f24518d = lazy;
    }

    public static LiveFeedPhotoAttachmentPartDefinition m27970a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24515f) {
                LiveFeedPhotoAttachmentPartDefinition liveFeedPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    liveFeedPhotoAttachmentPartDefinition = (LiveFeedPhotoAttachmentPartDefinition) a2.a(f24515f);
                } else {
                    liveFeedPhotoAttachmentPartDefinition = f24514e;
                }
                if (liveFeedPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27971b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24515f, b3);
                        } else {
                            f24514e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
