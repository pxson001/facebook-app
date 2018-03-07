package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.directinstall.util.DirectInstallButtonHelper;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AngoraClearPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.CallToActionAttachmentBasePartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.SidePhotoPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.ui.RatingBarShareAttachmentView;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.links.AttachmentCallToActionButtonLinkPartDefinition;
import com.facebook.feedplugins.links.DefaultLinkedViewAdapter;
import com.facebook.feedplugins.links.LinkedViewAdapter;
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
/* compiled from: fetch_download_preview_sticker_packs */
public class RatingBarShareAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPrefetcher & HasImageLoadListener & HasPersistentState, V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasRating & AttachmentHasSubcontext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f24111a = new AtomicReference();
    private static RatingBarShareAttachmentPartDefinition f24112o;
    private static final Object f24113p = new Object();
    private final AttachmentCoverPhotoPartDefinition<E, V> f24114b;
    private final LegacyAngoraAttachmentUtil f24115c;
    private final AngoraClearPartDefinition<V> f24116d;
    private final CoverPhotoShareAttachmentBinderFactory f24117e;
    private final AttachmentCallToActionButtonLinkPartDefinition<E> f24118f;
    private final DefaultLinkedViewAdapter f24119g;
    private final CallToActionAttachmentLinkedViewAdapter f24120h = new CallToActionAttachmentLinkedViewAdapter(this);
    private final DirectInstallButtonHelper f24121i;
    private final CallToActionAttachmentBasePartDefinition<E, V> f24122j;
    private final AngoraAttachmentBackgroundPartDefinition f24123k;
    private final SidePhotoPartDefinition<E, V> f24124l;
    private final int f24125m;
    private final QeAccessor f24126n;

    /* compiled from: fetch_download_preview_sticker_packs */
    class CallToActionAttachmentLinkedViewAdapter implements LinkedViewAdapter<V> {
        final /* synthetic */ RatingBarShareAttachmentPartDefinition f24140a;

        public CallToActionAttachmentLinkedViewAdapter(RatingBarShareAttachmentPartDefinition ratingBarShareAttachmentPartDefinition) {
            this.f24140a = ratingBarShareAttachmentPartDefinition;
        }

        public final View mo3509a(V v) {
            return ((AttachmentHasButton) v).getActionButton();
        }
    }

    private static RatingBarShareAttachmentPartDefinition m32490b(InjectorLike injectorLike) {
        return new RatingBarShareAttachmentPartDefinition(LegacyAngoraAttachmentUtil.m28831a(injectorLike), AngoraClearPartDefinition.m32224a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), DefaultLinkedViewAdapter.m32316a(injectorLike), DirectInstallButtonHelper.m32495b(injectorLike), SidePhotoPartDefinition.m32360a(injectorLike), AttachmentCoverPhotoPartDefinition.m32326a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), AttachmentCallToActionButtonLinkPartDefinition.m32498a(injectorLike), CallToActionAttachmentBasePartDefinition.m32503a(injectorLike), AngoraAttachmentBackgroundPartDefinition.m32423a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        if (!(graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24440S() == null)) {
            if (this.f24117e.m32333a(graphQLStoryAttachment.m23979r())) {
                subParts.mo2756a(this.f24114b, feedProps);
            } else {
                subParts.mo2756a(this.f24124l, new Props(graphQLStoryAttachment, this.f24125m));
            }
        }
        subParts.mo2756a(this.f24122j, new CallToActionAttachmentBasePartDefinition.Props(feedProps, this.f24115c, this.f24121i));
        subParts.mo2756a(this.f24118f, new AttachmentCallToActionButtonLinkPartDefinition.Props(feedProps, this.f24119g));
        subParts.mo2756a(this.f24118f, new AttachmentCallToActionButtonLinkPartDefinition.Props(feedProps, this.f24120h));
        subParts.mo2756a(this.f24123k, feedProps);
        subParts.mo2756a(this.f24116d, null);
        return null;
    }

    public final boolean m32493a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        return (graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().gq() == null) ? false : true;
    }

    public static RatingBarShareAttachmentPartDefinition m32489a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RatingBarShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24113p) {
                RatingBarShareAttachmentPartDefinition ratingBarShareAttachmentPartDefinition;
                if (a2 != null) {
                    ratingBarShareAttachmentPartDefinition = (RatingBarShareAttachmentPartDefinition) a2.mo818a(f24113p);
                } else {
                    ratingBarShareAttachmentPartDefinition = f24112o;
                }
                if (ratingBarShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32490b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24113p, b3);
                        } else {
                            f24112o = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = ratingBarShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public RatingBarShareAttachmentPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, AngoraClearPartDefinition angoraClearPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, DefaultLinkedViewAdapter defaultLinkedViewAdapter, DirectInstallButtonHelper directInstallButtonHelper, SidePhotoPartDefinition sidePhotoPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, Resources resources, AttachmentCallToActionButtonLinkPartDefinition attachmentCallToActionButtonLinkPartDefinition, CallToActionAttachmentBasePartDefinition callToActionAttachmentBasePartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, QeAccessor qeAccessor) {
        this.f24115c = legacyAngoraAttachmentUtil;
        this.f24116d = angoraClearPartDefinition;
        this.f24117e = coverPhotoShareAttachmentBinderFactory;
        this.f24118f = attachmentCallToActionButtonLinkPartDefinition;
        this.f24119g = defaultLinkedViewAdapter;
        this.f24114b = attachmentCoverPhotoPartDefinition;
        this.f24122j = callToActionAttachmentBasePartDefinition;
        this.f24123k = angoraAttachmentBackgroundPartDefinition;
        this.f24121i = directInstallButtonHelper;
        this.f24124l = sidePhotoPartDefinition;
        this.f24125m = resources.getDimensionPixelSize(2131427517);
        this.f24126n = qeAccessor;
    }

    public final ViewType<V> mo2547a() {
        if (f24111a.get() == null) {
            f24111a.set(this.f24126n.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : RatingBarShareAttachmentView.a);
        }
        return (ViewType) f24111a.get();
    }
}
