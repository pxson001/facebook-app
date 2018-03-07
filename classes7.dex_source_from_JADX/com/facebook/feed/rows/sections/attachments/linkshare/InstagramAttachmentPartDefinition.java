package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseAttachmentCoverPhotoPartDefinition.CoverPhotoImageProvider;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ViewHelper */
public class InstagramAttachmentPartDefinition<E extends HasInvalidate & HasImageLoadListener & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20965a = new AtomicReference();
    private static final CallerContext f20966b = CallerContext.a(InstagramAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "large_square_photo", "native_newsfeed");
    private static InstagramAttachmentPartDefinition f20967g;
    private static final Object f20968h = new Object();
    public final LegacyAngoraAttachmentUtil f20969c;
    private final BaseAttachmentCoverPhotoPartDefinition<E, AngoraAttachmentView> f20970d;
    private final BaseShareAttachmentPartDefinition<E, AngoraAttachmentView> f20971e;
    private final QeAccessor f20972f;

    /* compiled from: ViewHelper */
    public class C17841 implements CoverPhotoImageProvider {
        final /* synthetic */ InstagramAttachmentPartDefinition f20964a;

        public C17841(InstagramAttachmentPartDefinition instagramAttachmentPartDefinition) {
            this.f20964a = instagramAttachmentPartDefinition;
        }

        public final GraphQLImage m23877a(GraphQLMedia graphQLMedia, float f) {
            if (this.f20964a.f20969c.a(graphQLMedia.W(), f)) {
                return graphQLMedia.W();
            }
            if (this.f20964a.f20969c.a(graphQLMedia.bh(), f)) {
                return graphQLMedia.bh();
            }
            if (this.f20964a.f20969c.a(graphQLMedia.T(), f)) {
                return graphQLMedia.T();
            }
            return null;
        }
    }

    private static InstagramAttachmentPartDefinition m23879b(InjectorLike injectorLike) {
        return new InstagramAttachmentPartDefinition(LegacyAngoraAttachmentUtil.a(injectorLike), BaseShareAttachmentPartDefinition.a(injectorLike), (BaseAttachmentCoverPhotoPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseAttachmentCoverPhotoPartDefinitionProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23881a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20971e, feedProps);
        subParts.a(this.f20970d, feedProps);
        return null;
    }

    public static InstagramAttachmentPartDefinition m23878a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20968h) {
                InstagramAttachmentPartDefinition instagramAttachmentPartDefinition;
                if (a2 != null) {
                    instagramAttachmentPartDefinition = (InstagramAttachmentPartDefinition) a2.a(f20968h);
                } else {
                    instagramAttachmentPartDefinition = f20967g;
                }
                if (instagramAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23879b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20968h, b3);
                        } else {
                            f20967g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InstagramAttachmentPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, BaseAttachmentCoverPhotoPartDefinitionProvider baseAttachmentCoverPhotoPartDefinitionProvider, QeAccessor qeAccessor) {
        this.f20971e = baseShareAttachmentPartDefinition;
        this.f20969c = legacyAngoraAttachmentUtil;
        this.f20970d = baseAttachmentCoverPhotoPartDefinitionProvider.a(f20966b, 1.0f, new C17841(this));
        this.f20972f = qeAccessor;
    }

    public final ViewType m23880a() {
        if (f20965a.get() == null) {
            f20965a.set(this.f20972f.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20965a.get();
    }

    public final boolean m23882a(Object obj) {
        return true;
    }
}
