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
/* compiled from: fetch_blacklisted_sync_paths */
public class CoverPhotoShareAttachmentPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState, V extends View & AngoraAttachment & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f24153a = new AtomicReference();
    private static CoverPhotoShareAttachmentPartDefinition f24154h;
    private static final Object f24155i = new Object();
    private final CoverPhotoShareAttachmentBinderFactory f24156b;
    private final BaseShareAttachmentPartDefinition<E, V> f24157c;
    private final AttachmentCoverPhotoPartDefinition<E, V> f24158d;
    private final AngoraActionButtonController f24159e;
    private final ActionButtonPartDefinition<E, V> f24160f;
    private final QeAccessor f24161g;

    private static CoverPhotoShareAttachmentPartDefinition m32519b(InjectorLike injectorLike) {
        return new CoverPhotoShareAttachmentPartDefinition(CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), BaseShareAttachmentPartDefinition.m32218a(injectorLike), AttachmentCoverPhotoPartDefinition.m32326a(injectorLike), AngoraActionButtonController.m32349a(injectorLike), ActionButtonPartDefinition.m32346a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24157c, feedProps);
        if (this.f24159e.m32352b(feedProps)) {
            subParts.mo2756a(this.f24160f, feedProps);
        }
        subParts.mo2756a(this.f24158d, feedProps);
        return null;
    }

    public final boolean m32522a(Object obj) {
        return m32518a((FeedProps) obj, this.f24156b);
    }

    public static CoverPhotoShareAttachmentPartDefinition m32517a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverPhotoShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24155i) {
                CoverPhotoShareAttachmentPartDefinition coverPhotoShareAttachmentPartDefinition;
                if (a2 != null) {
                    coverPhotoShareAttachmentPartDefinition = (CoverPhotoShareAttachmentPartDefinition) a2.mo818a(f24155i);
                } else {
                    coverPhotoShareAttachmentPartDefinition = f24154h;
                }
                if (coverPhotoShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32519b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24155i, b3);
                        } else {
                            f24154h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = coverPhotoShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public CoverPhotoShareAttachmentPartDefinition(CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, AngoraActionButtonController angoraActionButtonController, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f24156b = coverPhotoShareAttachmentBinderFactory;
        this.f24157c = baseShareAttachmentPartDefinition;
        this.f24158d = attachmentCoverPhotoPartDefinition;
        this.f24159e = angoraActionButtonController;
        this.f24160f = actionButtonPartDefinition;
        this.f24161g = qeAccessor;
    }

    public final ViewType<V> mo2547a() {
        if (f24153a.get() == null) {
            f24153a.set(this.f24161g.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f24153a.get();
    }

    public static boolean m32518a(FeedProps<GraphQLStoryAttachment> feedProps, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        return graphQLStoryAttachment.m23979r() != null && coverPhotoShareAttachmentBinderFactory.m32333a(graphQLStoryAttachment.m23979r());
    }
}
