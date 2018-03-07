package com.facebook.feed.rows.sections.attachments.linkshare.components;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.facebook.attachments.angora.actionbutton.AngoraActionButton;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.ComponentLayout$ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.Text.Builder;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AngoraAttachmentUtil;
import com.facebook.feed.rows.sections.attachments.linkshare.AttachmentCoverPhotoPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseAttachmentCoverPhotoPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.CoverPhotoShareAttachmentBinderFactory;
import com.facebook.feed.rows.sections.attachments.linkshare.InstantArticleShareAttachmentPartDefinition;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowAuthorUtil;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentKey;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentPersistentState;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterKey;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterPersistentState;
import com.facebook.feedplugins.images.FbFeedFrescoComponent;
import com.facebook.feedplugins.links.DefaultAttachmentLinkClickHandler;
import com.facebook.feedplugins.links.ThirdPartyNativeAttachmentClickHandler;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.leadgen.LeadGenActionLinkOnClickListenerProvider;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: fetchZeroIndicator */
public class CoverPhotoShareComponentSpec<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey> {
    private static final CallerContext f24253a = CallerContext.m9063a(CoverPhotoShareComponentSpec.class, "newsfeed_angora_attachment_view", "large_photo", "native_newsfeed");
    private static CoverPhotoShareComponentSpec f24254k;
    private static final Object f24255l = new Object();
    public final LegacyAngoraAttachmentUtil f24256b;
    private final AngoraActionButtonController f24257c;
    private final CoverPhotoShareAttachmentBinderFactory f24258d;
    private final DefaultAttachmentLinkClickHandler f24259e;
    private final AttachmentLinkInspector f24260f;
    private final LeadGenActionLinkOnClickListenerProvider f24261g;
    private final ThirdPartyNativeAttachmentClickHandler f24262h;
    private final QeAccessor f24263i;
    private final FbFeedFrescoComponent f24264j;

    private static CoverPhotoShareComponentSpec m32600b(InjectorLike injectorLike) {
        return new CoverPhotoShareComponentSpec(LegacyAngoraAttachmentUtil.m28831a(injectorLike), AngoraActionButtonController.m32349a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), DefaultAttachmentLinkClickHandler.m32288a(injectorLike), AttachmentLinkInspector.m32230a(injectorLike), (LeadGenActionLinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenActionLinkOnClickListenerProvider.class), ThirdPartyNativeAttachmentClickHandler.m32312a(injectorLike), FbFeedFrescoComponent.m28159a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static CoverPhotoShareComponentSpec m32597a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverPhotoShareComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24255l) {
                CoverPhotoShareComponentSpec coverPhotoShareComponentSpec;
                if (a2 != null) {
                    coverPhotoShareComponentSpec = (CoverPhotoShareComponentSpec) a2.mo818a(f24255l);
                } else {
                    coverPhotoShareComponentSpec = f24254k;
                }
                if (coverPhotoShareComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32600b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24255l, b3);
                        } else {
                            f24254k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = coverPhotoShareComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Nullable
    private ComponentLayout$Builder m32601c(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        if (((GraphQLStoryAttachment) feedProps.f13444a).m23979r() == null || !this.f24258d.m32333a(((GraphQLStoryAttachment) feedProps.f13444a).m23979r())) {
            return null;
        }
        ComponentLayout$Builder h;
        ComponentLayout$ContainerBuilder a = Container.m30723a(componentContext).mo3314a(this.f24264j.m28161a(componentContext).m30957a(f24253a).m30959a(AttachmentProps.m28715e(feedProps)).m30956a(Uri.parse(BaseAttachmentCoverPhotoPartDefinition.m32337a(((GraphQLStoryAttachment) feedProps.f13444a).m23979r(), 1.9318181f, AttachmentCoverPhotoPartDefinition.m32327a(this.f24256b)))).m30962b(1.9318181f).m30958a((HasFeedListType) e));
        if (InstantArticleShareAttachmentPartDefinition.m32524a((GraphQLStoryAttachment) feedProps.f13444a)) {
            h = Image.m31069a(componentContext).m31092h(2130840803).m31088a(ScaleType.CENTER_CROP).m30663c().mo3346l(2131430185).mo3354p(2131430185).mo3320b(1).mo3333f(2131427635).mo3337h(2131427634);
        } else {
            h = null;
        }
        return a.mo3316a(h).mo3342j(1, 2131427617);
    }

    @Inject
    public CoverPhotoShareComponentSpec(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, AngoraActionButtonController angoraActionButtonController, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, DefaultAttachmentLinkClickHandler defaultAttachmentLinkClickHandler, AttachmentLinkInspector attachmentLinkInspector, LeadGenActionLinkOnClickListenerProvider leadGenActionLinkOnClickListenerProvider, ThirdPartyNativeAttachmentClickHandler thirdPartyNativeAttachmentClickHandler, FbFeedFrescoComponent fbFeedFrescoComponent, QeAccessor qeAccessor) {
        this.f24256b = legacyAngoraAttachmentUtil;
        this.f24257c = angoraActionButtonController;
        this.f24258d = coverPhotoShareAttachmentBinderFactory;
        this.f24259e = defaultAttachmentLinkClickHandler;
        this.f24260f = attachmentLinkInspector;
        this.f24261g = leadGenActionLinkOnClickListenerProvider;
        this.f24262h = thirdPartyNativeAttachmentClickHandler;
        this.f24264j = fbFeedFrescoComponent;
        this.f24263i = qeAccessor;
    }

    protected final ComponentLayout m32602a(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        ComponentLayout$ContainerBuilder a = Container.m30723a(componentContext).mo3300C(0).mo3302E(4).mo3351n(5, 2131427509).mo3316a(m32601c(componentContext, feedProps, e));
        ComponentLayout$ContainerBuilder A = Container.m30723a(componentContext).mo3300C(2).mo3298A(2131427531);
        ComponentLayout$ContainerBuilder b = Container.m30723a(componentContext).mo3300C(0).mo3302E(4).mo3301D(1).mo3351n(5, 2131427530).mo3353o(1, 4).mo3322b(1.0f);
        Builder j = Text.m31011a(componentContext).m31042a((CharSequence) BaseShareAttachmentPartDefinition.m32217a(this.f24256b, (GraphQLStoryAttachment) feedProps.f13444a)).m31058o(2131430351).m31055l(2131362056).m31053j(2);
        j.f22942a.f22916o = 0.5f;
        return Container.m30723a(componentContext).mo3324b(CoverPhotoShareComponent.m32593b(componentContext)).mo3316a(a.mo3316a(A.mo3316a(b.mo3314a(j.m31040a(TruncateAt.END).m31043a(false)).mo3316a(m32598b(componentContext, feedProps))).mo3317a(m32599b(componentContext, feedProps, e)))).mo3343j();
    }

    protected final void m32603a(View view, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.m19804a();
        if (AngoraAttachmentUtil.b(graphQLStoryAttachment)) {
            this.f24261g.m32319a(feedProps, view.getContext(), (HasInvalidate) e).onClick(view);
            return;
        }
        String a = this.f24260f.m32235a((FeedProps) feedProps);
        if (!Strings.isNullOrEmpty(a)) {
            if (NativeThirdPartyUriHelper.m29571a(a)) {
                this.f24262h.m32314a(view, feedProps, a, null, (HasInvalidate) e);
                return;
            }
            GraphQLStoryActionLink a2 = ActionLinkHelper.m22935a(graphQLStoryAttachment);
            Object obj = (a2 == null || !NativeThirdPartyUriHelper.m29571a(a2.aE())) ? null : 1;
            Object obj2 = (obj == null || a2.m22896W() != GraphQLCallToActionType.CALL_NOW) ? null : 1;
            if (obj == null || obj2 != null) {
                CacheableEntity c = AttachmentProps.m28714c(feedProps);
                this.f24259e.m32295a(view, feedProps, this.f24259e.m32294a(), a, (FollowShareAttachmentPersistentState) ((HasPersistentState) e).mo2425a(new FollowShareAttachmentKey(feedProps), c), (OfflineAttachmentSaveFooterPersistentState) ((HasPersistentState) e).mo2425a(new OfflineAttachmentSaveFooterKey(feedProps), c), FollowAuthorUtil.a(graphQLStoryAttachment), (HasInvalidate) e);
                return;
            }
            this.f24262h.m32314a(view, feedProps, a2.aE(), null, (HasInvalidate) e);
        }
    }

    private ComponentLayout$Builder m32598b(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps) {
        return Text.m31011a(componentContext).m31042a((CharSequence) LegacyAngoraAttachmentUtil.m28833b((GraphQLStoryAttachment) feedProps.f13444a)).m31058o(2131427400).m31055l(2131362057).m31053j(1).m31040a(TruncateAt.END).m31043a(false).m30663c().mo3330d(1, 2);
    }

    @Nullable
    private ComponentLayout m32599b(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        AngoraActionButton a = this.f24257c.m32351a((FeedProps) feedProps);
        if (a == null) {
            return null;
        }
        return Container.m30723a(componentContext).mo3302E(2).mo3301D(1).mo3359u(4).mo3315a(a.mo3512a(componentContext, e, feedProps)).mo3343j();
    }
}
