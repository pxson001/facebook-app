package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
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
/* compiled from: Video Editing Icon not initialized */
public class VideoShareHighlightedAttachmentPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState, V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasPlayIcon> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f21027a = new AtomicReference();
    private static VideoShareHighlightedAttachmentPartDefinition f21028i;
    private static final Object f21029j = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f21030b;
    private final AttachmentCoverPhotoPartDefinition<E, V> f21031c;
    private final CoverPhotoShareAttachmentBinderFactory f21032d;
    private final PlayIconPartDefinition f21033e;
    private final ActionButtonPartDefinition<E, V> f21034f;
    private final AngoraActionButtonController f21035g;
    private final QeAccessor f21036h;

    private static VideoShareHighlightedAttachmentPartDefinition m23923b(InjectorLike injectorLike) {
        return new VideoShareHighlightedAttachmentPartDefinition(BaseShareAttachmentPartDefinition.a(injectorLike), AttachmentCoverPhotoPartDefinition.a(injectorLike), CoverPhotoShareAttachmentBinderFactory.a(injectorLike), PlayIconPartDefinition.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), AngoraActionButtonController.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23925a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f21030b, feedProps);
        subParts.a(this.f21031c, feedProps);
        subParts.a(this.f21033e, graphQLStoryAttachment);
        if (this.f21035g.b(feedProps)) {
            subParts.a(this.f21034f, feedProps);
        }
        return null;
    }

    public final boolean m23926a(Object obj) {
        return this.f21032d.a(((GraphQLStoryAttachment) ((FeedProps) obj).a).r());
    }

    public static VideoShareHighlightedAttachmentPartDefinition m23922a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoShareHighlightedAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21029j) {
                VideoShareHighlightedAttachmentPartDefinition videoShareHighlightedAttachmentPartDefinition;
                if (a2 != null) {
                    videoShareHighlightedAttachmentPartDefinition = (VideoShareHighlightedAttachmentPartDefinition) a2.a(f21029j);
                } else {
                    videoShareHighlightedAttachmentPartDefinition = f21028i;
                }
                if (videoShareHighlightedAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23923b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21029j, b3);
                        } else {
                            f21028i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoShareHighlightedAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoShareHighlightedAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, PlayIconPartDefinition playIconPartDefinition, ActionButtonPartDefinition actionButtonPartDefinition, AngoraActionButtonController angoraActionButtonController, QeAccessor qeAccessor) {
        this.f21030b = baseShareAttachmentPartDefinition;
        this.f21031c = attachmentCoverPhotoPartDefinition;
        this.f21032d = coverPhotoShareAttachmentBinderFactory;
        this.f21033e = playIconPartDefinition;
        this.f21034f = actionButtonPartDefinition;
        this.f21035g = angoraActionButtonController;
        this.f21036h = qeAccessor;
    }

    public final ViewType m23924a() {
        if (f21027a.get() == null) {
            f21027a.set(this.f21036h.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f21027a.get();
    }
}
