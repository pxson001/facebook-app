package com.facebook.feed.rows.sections.attachments.linkshare;

import android.view.View;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

/* compiled from: fetch_recent_emoji */
public class BaseAttachmentCoverPhotoPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener, V extends View & AttachmentHasLargeImage> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, FbPipelineDraweeController, E, V> {
    private static final String f23951a = BaseAttachmentCoverPhotoPartDefinition.class.getName();
    private final AbstractFbErrorReporter f23952b;
    private final CoverPhotoImageProvider f23953c;
    private final FbDraweeControllerBuilder f23954d;
    private final CallerContext f23955e;
    public final float f23956f;
    public final GatekeeperStoreImpl f23957g;

    /* compiled from: fetch_recent_emoji */
    interface CoverPhotoImageProvider {
        GraphQLImage mo3511a(GraphQLMedia graphQLMedia, float f);
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        GraphQLMedia r = graphQLStoryAttachment.m23979r();
        if (r != null || c == null) {
            String a = m32337a(r, this.f23956f, this.f23953c);
            if (a == null) {
                return null;
            }
            ImageRequest imageRequest;
            Object a2 = ImageRequest.m18796a(a);
            ((HasPrefetcher) hasPositionInformation).mo2434a(a2, this.f23955e);
            if (c == null || r == null || !(this.f23957g.m2189a(832, false) || (this.f23957g.m2189a(833, false) && c.mo2895u()))) {
                imageRequest = null;
            } else {
                imageRequest = ImageRequest.m18796a(m32337a(r, this.f23956f, new 1(this)));
            }
            Object s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f23954d.m19452c(a2)).m19456d(imageRequest)).m19417a(this.f23955e).m19435s();
            ((HasImageLoadListener) hasPositionInformation).mo2426a(s, AttachmentProps.m28712a(feedProps).mo2507g(), a2);
            return s;
        }
        this.f23952b.m2350b(f23951a, "Story attachment without media " + c.S_());
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1499856494);
        m32338a((FbPipelineDraweeController) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -2076544928, a);
    }

    @Inject
    public BaseAttachmentCoverPhotoPartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl, FbDraweeControllerBuilder fbDraweeControllerBuilder, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted CallerContext callerContext, @Assisted float f, @Assisted CoverPhotoImageProvider coverPhotoImageProvider) {
        this.f23954d = fbDraweeControllerBuilder;
        this.f23952b = abstractFbErrorReporter;
        this.f23955e = callerContext;
        this.f23956f = f;
        this.f23953c = coverPhotoImageProvider;
        this.f23957g = gatekeeperStoreImpl;
    }

    public static String m32337a(GraphQLMedia graphQLMedia, float f, CoverPhotoImageProvider coverPhotoImageProvider) {
        GraphQLImage a = coverPhotoImageProvider.mo3511a(graphQLMedia, f);
        if (a == null || a.mo2924b() == null) {
            return null;
        }
        return a.mo2924b();
    }

    private void m32338a(FbPipelineDraweeController fbPipelineDraweeController, V v) {
        ((AttachmentHasLargeImage) v).setLargeImageController(fbPipelineDraweeController);
        ((AttachmentHasLargeImage) v).setLargeImageAspectRatio(this.f23956f);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasLargeImage) view).setLargeImageController(null);
    }
}
