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
import com.facebook.feed.rows.sections.attachments.linkshare.BaseAttachmentCoverPhotoPartDefinition.CoverPhotoImageProvider;
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
/* compiled from: Video360CastTitle */
public class StretchedCoverPhotoPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener & HasPersistentState, V extends View & AttachmentHasLargeImage> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    private static final CallerContext f21022a = CallerContext.a(CoverPhotoShareAttachmentBinderFactory.class, "newsfeed_angora_attachment_view", "large_photo", "native_newsfeed");
    private static StretchedCoverPhotoPartDefinition f21023d;
    private static final Object f21024e = new Object();
    private final BaseAttachmentCoverPhotoPartDefinition<E, AngoraAttachmentView> f21025b;
    private LegacyAngoraAttachmentUtil f21026c;

    /* compiled from: Video360CastTitle */
    public final class C17851 implements CoverPhotoImageProvider {
        public final GraphQLImage m23918a(GraphQLMedia graphQLMedia, float f) {
            return graphQLMedia.S();
        }
    }

    private static StretchedCoverPhotoPartDefinition m23920b(InjectorLike injectorLike) {
        return new StretchedCoverPhotoPartDefinition(LegacyAngoraAttachmentUtil.a(injectorLike), (BaseAttachmentCoverPhotoPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseAttachmentCoverPhotoPartDefinitionProvider.class));
    }

    public final Object m23921a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f21025b, (FeedProps) obj);
        return null;
    }

    @Inject
    public StretchedCoverPhotoPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, BaseAttachmentCoverPhotoPartDefinitionProvider baseAttachmentCoverPhotoPartDefinitionProvider) {
        this.f21026c = legacyAngoraAttachmentUtil;
        this.f21025b = baseAttachmentCoverPhotoPartDefinitionProvider.a(f21022a, 1.9318181f, new C17851());
    }

    public static StretchedCoverPhotoPartDefinition m23919a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StretchedCoverPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21024e) {
                StretchedCoverPhotoPartDefinition stretchedCoverPhotoPartDefinition;
                if (a2 != null) {
                    stretchedCoverPhotoPartDefinition = (StretchedCoverPhotoPartDefinition) a2.a(f21024e);
                } else {
                    stretchedCoverPhotoPartDefinition = f21023d;
                }
                if (stretchedCoverPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23920b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21024e, b3);
                        } else {
                            f21023d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = stretchedCoverPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
