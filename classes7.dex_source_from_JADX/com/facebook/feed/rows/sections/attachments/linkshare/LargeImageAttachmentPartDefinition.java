package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
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
/* compiled from: View sticker pack failed (id =  */
public class LargeImageAttachmentPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState, V extends View & AngoraAttachment & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20977a = new AtomicReference();
    private static LargeImageAttachmentPartDefinition f20978h;
    private static final Object f20979i = new Object();
    private final CoverPhotoShareAttachmentBinderFactory f20980b;
    private final AttachmentCoverPhotoPartDefinition<E, V> f20981c;
    private final AngoraActionButtonController f20982d;
    private final ActionButtonPartDefinition<E, V> f20983e;
    private final BaseShareAttachmentPartDefinition<E, V> f20984f;
    private final QeAccessor f20985g;

    private static LargeImageAttachmentPartDefinition m23886b(InjectorLike injectorLike) {
        return new LargeImageAttachmentPartDefinition(CoverPhotoShareAttachmentBinderFactory.a(injectorLike), AttachmentCoverPhotoPartDefinition.a(injectorLike), AngoraActionButtonController.a(injectorLike), BaseShareAttachmentPartDefinition.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23888a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f20984f, feedProps);
        GraphQLMedia r = graphQLStoryAttachment.r();
        if (r != null && this.f20980b.a(r)) {
            subParts.a(this.f20981c, feedProps);
        }
        if (this.f20982d.b(feedProps)) {
            subParts.a(this.f20983e, feedProps);
        }
        return null;
    }

    public static LargeImageAttachmentPartDefinition m23885a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LargeImageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20979i) {
                LargeImageAttachmentPartDefinition largeImageAttachmentPartDefinition;
                if (a2 != null) {
                    largeImageAttachmentPartDefinition = (LargeImageAttachmentPartDefinition) a2.a(f20979i);
                } else {
                    largeImageAttachmentPartDefinition = f20978h;
                }
                if (largeImageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23886b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20979i, b3);
                        } else {
                            f20978h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = largeImageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LargeImageAttachmentPartDefinition(CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, AngoraActionButtonController angoraActionButtonController, BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f20984f = baseShareAttachmentPartDefinition;
        this.f20980b = coverPhotoShareAttachmentBinderFactory;
        this.f20981c = attachmentCoverPhotoPartDefinition;
        this.f20982d = angoraActionButtonController;
        this.f20983e = actionButtonPartDefinition;
        this.f20985g = qeAccessor;
    }

    public final ViewType<V> m23887a() {
        if (f20977a.get() == null) {
            f20977a.set(this.f20985g.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20977a.get();
    }

    public final boolean m23889a(Object obj) {
        return true;
    }
}
