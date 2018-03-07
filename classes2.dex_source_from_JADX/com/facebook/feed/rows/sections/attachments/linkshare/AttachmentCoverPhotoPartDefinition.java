package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_region_tos_status */
public class AttachmentCoverPhotoPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener & HasPersistentState, V extends View & AttachmentHasLargeImage> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    private static final CallerContext f23942a = CallerContext.m9063a(CoverPhotoShareAttachmentBinderFactory.class, "newsfeed_angora_attachment_view", "large_photo", "native_newsfeed");
    private static AttachmentCoverPhotoPartDefinition f23943d;
    private static final Object f23944e = new Object();
    private final BaseAttachmentCoverPhotoPartDefinition<E, AngoraAttachmentView> f23945b;
    private LegacyAngoraAttachmentUtil f23946c;

    /* compiled from: fetch_region_tos_status */
    final class C09751 implements CoverPhotoImageProvider {
        final /* synthetic */ LegacyAngoraAttachmentUtil f23950a;

        C09751(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil) {
            this.f23950a = legacyAngoraAttachmentUtil;
        }

        public final GraphQLImage mo3511a(GraphQLMedia graphQLMedia, float f) {
            if (this.f23950a.m28836a(graphQLMedia.m24444W(), 1.9318181f)) {
                return graphQLMedia.m24444W();
            }
            if (this.f23950a.m28836a(graphQLMedia.m24440S(), 1.9318181f)) {
                return graphQLMedia.m24440S();
            }
            return null;
        }
    }

    private static AttachmentCoverPhotoPartDefinition m32328b(InjectorLike injectorLike) {
        return new AttachmentCoverPhotoPartDefinition(LegacyAngoraAttachmentUtil.m28831a(injectorLike), (BaseAttachmentCoverPhotoPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseAttachmentCoverPhotoPartDefinitionProvider.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f23945b, (FeedProps) obj);
        return null;
    }

    @Inject
    public AttachmentCoverPhotoPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, BaseAttachmentCoverPhotoPartDefinitionProvider baseAttachmentCoverPhotoPartDefinitionProvider) {
        this.f23946c = legacyAngoraAttachmentUtil;
        this.f23945b = baseAttachmentCoverPhotoPartDefinitionProvider.m32334a(f23942a, 1.9318181f, m32327a(this.f23946c));
    }

    public static AttachmentCoverPhotoPartDefinition m32326a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentCoverPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23944e) {
                AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition;
                if (a2 != null) {
                    attachmentCoverPhotoPartDefinition = (AttachmentCoverPhotoPartDefinition) a2.mo818a(f23944e);
                } else {
                    attachmentCoverPhotoPartDefinition = f23943d;
                }
                if (attachmentCoverPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32328b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23944e, b3);
                        } else {
                            f23943d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentCoverPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static CoverPhotoImageProvider m32327a(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil) {
        return new C09751(legacyAngoraAttachmentUtil);
    }
}
