package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.AttachmentCoverPhotoPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.CoverPhotoShareAttachmentBinderFactory;
import com.facebook.feed.rows.sections.attachments.linkshare.StretchedCoverPhotoPartDefinition;
import com.facebook.feedplugins.richmedia.abtest.ExperimentsForRichMediaAbTestModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: button_positive */
public class RichMediaImageAttachmentPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener & HasPersistentState & HasScrollListenerSupport> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, RichMediaImageAttachmentView> {
    public static final ViewType f9164a = new C11061();
    private static final String f9165j = RichMediaImageAttachmentPartDefinition.class.getSimpleName();
    private static RichMediaImageAttachmentPartDefinition f9166m;
    private static final Object f9167n = new Object();
    private final AttachmentCoverPhotoPartDefinition<E, RichMediaImageAttachmentView> f9168b;
    private final StretchedCoverPhotoPartDefinition<E, RichMediaImageAttachmentView> f9169c;
    private final RichMediaTapPromptPartDefinition<?> f9170d;
    private final RichMediaLightningBoltAnimationPartDefinition<E, RichMediaImageAttachmentView> f9171e;
    private final AttachmentLinkPartDefinition f9172f;
    private final AngoraAttachmentBackgroundPartDefinition f9173g;
    private final RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition f9174h;
    private final AbstractFbErrorReporter f9175i;
    private final CoverPhotoShareAttachmentBinderFactory f9176k;
    public final QeAccessor f9177l;

    /* compiled from: button_positive */
    final class C11061 extends ViewType {
        C11061() {
        }

        public final View m9845a(Context context) {
            return new RichMediaImageAttachmentView(context);
        }
    }

    private static RichMediaImageAttachmentPartDefinition m9847b(InjectorLike injectorLike) {
        return new RichMediaImageAttachmentPartDefinition(AttachmentCoverPhotoPartDefinition.a(injectorLike), StretchedCoverPhotoPartDefinition.a(injectorLike), RichMediaTapPromptPartDefinition.m9869a(injectorLike), RichMediaLightningBoltAnimationPartDefinition.m9860a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition.m9833a(injectorLike), CoverPhotoShareAttachmentBinderFactory.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m9849a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) {
            this.f9175i.a(SoftError.a(f9165j + ".prepare", "Error attempting to get Image. Attachment (" + graphQLStoryAttachment + ")").g());
        }
        if (graphQLStoryAttachment.r() != null) {
            if (this.f9176k.a(graphQLStoryAttachment.r())) {
                subParts.a(this.f9168b, feedProps);
            } else {
                subParts.a(this.f9169c, feedProps);
            }
        }
        if (this.f9177l.a(ExperimentsForRichMediaAbTestModule.f9254c, false)) {
            subParts.a(this.f9171e, feedProps);
        } else {
            subParts.a(this.f9170d, feedProps);
        }
        if (this.f9177l.a(ExperimentsForRichMediaAbTestModule.f9253b, false)) {
            subParts.a(this.f9174h, feedProps);
        } else {
            subParts.a(this.f9173g, feedProps);
        }
        subParts.a(this.f9172f, new Props(feedProps));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9850a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1906645402);
        RichMediaImageAttachmentView richMediaImageAttachmentView = (RichMediaImageAttachmentView) view;
        richMediaImageAttachmentView.f9185d.setText(((GraphQLStoryAttachment) ((FeedProps) obj).a).A());
        Logger.a(8, EntryType.MARK_POP, 2059577507, a);
    }

    public final boolean m9851a(Object obj) {
        return ((GraphQLStoryAttachment) ((FeedProps) obj).a).r() != null;
    }

    public static RichMediaImageAttachmentPartDefinition m9846a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaImageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9167n) {
                RichMediaImageAttachmentPartDefinition richMediaImageAttachmentPartDefinition;
                if (a2 != null) {
                    richMediaImageAttachmentPartDefinition = (RichMediaImageAttachmentPartDefinition) a2.a(f9167n);
                } else {
                    richMediaImageAttachmentPartDefinition = f9166m;
                }
                if (richMediaImageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9847b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9167n, b3);
                        } else {
                            f9166m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaImageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RichMediaImageAttachmentPartDefinition(AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, StretchedCoverPhotoPartDefinition stretchedCoverPhotoPartDefinition, RichMediaTapPromptPartDefinition richMediaTapPromptPartDefinition, RichMediaLightningBoltAnimationPartDefinition richMediaLightningBoltAnimationPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AbstractFbErrorReporter abstractFbErrorReporter, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, RichMediaAttachmentEdgeToEdgeBackgroundPartDefinition richMediaAttachmentEdgeToEdgeBackgroundPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, QeAccessor qeAccessor) {
        this.f9168b = attachmentCoverPhotoPartDefinition;
        this.f9169c = stretchedCoverPhotoPartDefinition;
        this.f9175i = abstractFbErrorReporter;
        this.f9170d = richMediaTapPromptPartDefinition;
        this.f9171e = richMediaLightningBoltAnimationPartDefinition;
        this.f9172f = attachmentLinkPartDefinition;
        this.f9173g = angoraAttachmentBackgroundPartDefinition;
        this.f9174h = richMediaAttachmentEdgeToEdgeBackgroundPartDefinition;
        this.f9176k = coverPhotoShareAttachmentBinderFactory;
        this.f9177l = qeAccessor;
    }

    public final ViewType m9848a() {
        return f9164a;
    }
}
