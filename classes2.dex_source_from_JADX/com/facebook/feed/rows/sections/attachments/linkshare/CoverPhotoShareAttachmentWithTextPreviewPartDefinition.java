package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraInstantPreviewAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.browser.prefetch.ArticlePreviewer;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchZeroInterstitialEligibility */
public class CoverPhotoShareAttachmentWithTextPreviewPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState, V extends View & AngoraAttachment & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<Props, Void, E, V> {
    private static CoverPhotoShareAttachmentWithTextPreviewPartDefinition f24232h;
    private static final Object f24233i = new Object();
    private final CoverPhotoShareAttachmentBinderFactory f24234a;
    private final BaseShareAttachmentPartDefinition<E, V> f24235b;
    private final AttachmentCoverPhotoPartDefinition<E, V> f24236c;
    private final AngoraActionButtonController f24237d;
    private final ActionButtonPartDefinition<E, V> f24238e;
    private final TextPartDefinition f24239f;
    private final ArticlePreviewer f24240g;

    /* compiled from: fetchZeroInterstitialEligibility */
    public class Props implements HasFeedProps<FeedUnit>, HasFeedUnit {
        public FeedProps<GraphQLStoryAttachment> f24230a;
        public boolean f24231b;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, boolean z) {
            this.f24230a = feedProps;
            this.f24231b = z;
        }

        public final FeedUnit mo2540c() {
            Flattenable c = this.f24230a.m19807c();
            if (c instanceof FeedUnit) {
                return (FeedUnit) c;
            }
            return null;
        }

        @Nullable
        public final FeedProps<FeedUnit> mo2637f() {
            return this.f24230a.m19807c() instanceof FeedUnit ? this.f24230a.f13445b : null;
        }
    }

    private static CoverPhotoShareAttachmentWithTextPreviewPartDefinition m32577b(InjectorLike injectorLike) {
        return new CoverPhotoShareAttachmentWithTextPreviewPartDefinition(CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), BaseShareAttachmentPartDefinition.m32218a(injectorLike), AttachmentCoverPhotoPartDefinition.m32326a(injectorLike), AngoraActionButtonController.m32349a(injectorLike), ActionButtonPartDefinition.m32346a(injectorLike), TextPartDefinition.m19379a(injectorLike), ArticlePreviewer.m14323a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) props.f24230a.f13444a;
        ArticlePreviewer articlePreviewer = this.f24240g;
        String str = (String) articlePreviewer.f9356a.get(FacebookUriUtil.m20918b(Uri.parse(graphQLStoryAttachment.m23966C())).toString());
        subParts.mo2756a(this.f24235b, props.f24230a);
        subParts.mo2756a(this.f24236c, props.f24230a);
        subParts.mo2755a(2131559578, this.f24239f, str);
        if (this.f24237d.m32352b(props.f24230a)) {
            subParts.mo2756a(this.f24238e, props.f24230a);
        }
        return null;
    }

    public final boolean m32580a(Object obj) {
        Props props = (Props) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) props.f24230a.f13444a;
        if (graphQLStoryAttachment.m23979r() != null && this.f24234a.m32333a(graphQLStoryAttachment.m23979r()) && props.f24231b) {
            ArticlePreviewer articlePreviewer = this.f24240g;
            if (articlePreviewer.f9356a.containsKey(FacebookUriUtil.m20918b(Uri.parse(graphQLStoryAttachment.m23966C())).toString())) {
                return true;
            }
        }
        return false;
    }

    public static CoverPhotoShareAttachmentWithTextPreviewPartDefinition m32576a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverPhotoShareAttachmentWithTextPreviewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24233i) {
                CoverPhotoShareAttachmentWithTextPreviewPartDefinition coverPhotoShareAttachmentWithTextPreviewPartDefinition;
                if (a2 != null) {
                    coverPhotoShareAttachmentWithTextPreviewPartDefinition = (CoverPhotoShareAttachmentWithTextPreviewPartDefinition) a2.mo818a(f24233i);
                } else {
                    coverPhotoShareAttachmentWithTextPreviewPartDefinition = f24232h;
                }
                if (coverPhotoShareAttachmentWithTextPreviewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32577b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24233i, b3);
                        } else {
                            f24232h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = coverPhotoShareAttachmentWithTextPreviewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public CoverPhotoShareAttachmentWithTextPreviewPartDefinition(CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, AngoraActionButtonController angoraActionButtonController, ActionButtonPartDefinition actionButtonPartDefinition, TextPartDefinition textPartDefinition, ArticlePreviewer articlePreviewer) {
        this.f24234a = coverPhotoShareAttachmentBinderFactory;
        this.f24235b = baseShareAttachmentPartDefinition;
        this.f24236c = attachmentCoverPhotoPartDefinition;
        this.f24237d = angoraActionButtonController;
        this.f24238e = actionButtonPartDefinition;
        this.f24239f = textPartDefinition;
        this.f24240g = articlePreviewer;
    }

    public final ViewType<V> mo2547a() {
        return AngoraInstantPreviewAttachmentView.c;
    }
}
