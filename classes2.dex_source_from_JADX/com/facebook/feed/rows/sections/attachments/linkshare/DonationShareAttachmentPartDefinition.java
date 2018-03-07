package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentWithSubcontextView;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.attachments.utils.CallToActionUtil;
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
/* compiled from: fetch_layout_and_tiles */
public class DonationShareAttachmentPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState, V extends View & AttachmentHasLabel & AttachmentHasSubcontext & AttachmentHasClear & AttachmentHasLargeImage & AttachmentHasButton> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    private static final AtomicReference<ViewType> f24049a = new AtomicReference();
    private static DonationShareAttachmentPartDefinition f24050h;
    private static final Object f24051i = new Object();
    private final BaseShareAttachmentWithSubcontextPartDefinition<E, V> f24052b;
    private final AttachmentCoverPhotoPartDefinition<E, V> f24053c;
    private final CoverPhotoShareAttachmentBinderFactory f24054d;
    private final AngoraActionButtonController f24055e;
    private final ActionButtonPartDefinition<E, V> f24056f;
    private final QeAccessor f24057g;

    private static DonationShareAttachmentPartDefinition m32440b(InjectorLike injectorLike) {
        return new DonationShareAttachmentPartDefinition(BaseShareAttachmentWithSubcontextPartDefinition.m32444a(injectorLike), AttachmentCoverPhotoPartDefinition.m32326a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), AngoraActionButtonController.m32349a(injectorLike), ActionButtonPartDefinition.m32346a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24052b, feedProps);
        if (this.f24055e.m32352b(feedProps)) {
            subParts.mo2756a(this.f24056f, feedProps);
        }
        subParts.mo2756a(this.f24053c, feedProps);
        return null;
    }

    public final boolean m32443a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        return CallToActionUtil.m32466m(graphQLStoryAttachment) && graphQLStoryAttachment.m23979r() != null && this.f24054d.m32333a(graphQLStoryAttachment.m23979r()) && 1 != 0;
    }

    public static DonationShareAttachmentPartDefinition m32439a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DonationShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24051i) {
                DonationShareAttachmentPartDefinition donationShareAttachmentPartDefinition;
                if (a2 != null) {
                    donationShareAttachmentPartDefinition = (DonationShareAttachmentPartDefinition) a2.mo818a(f24051i);
                } else {
                    donationShareAttachmentPartDefinition = f24050h;
                }
                if (donationShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32440b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24051i, b3);
                        } else {
                            f24050h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = donationShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DonationShareAttachmentPartDefinition(BaseShareAttachmentWithSubcontextPartDefinition baseShareAttachmentWithSubcontextPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, AngoraActionButtonController angoraActionButtonController, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f24052b = baseShareAttachmentWithSubcontextPartDefinition;
        this.f24053c = attachmentCoverPhotoPartDefinition;
        this.f24054d = coverPhotoShareAttachmentBinderFactory;
        this.f24055e = angoraActionButtonController;
        this.f24056f = actionButtonPartDefinition;
        this.f24057g = qeAccessor;
    }

    public final ViewType mo2547a() {
        if (f24049a.get() == null) {
            f24049a.set(this.f24057g.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentWithSubcontextView.c);
        }
        return (ViewType) f24049a.get();
    }
}
