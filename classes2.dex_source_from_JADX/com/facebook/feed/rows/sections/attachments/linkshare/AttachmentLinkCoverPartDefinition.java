package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.linkcovers.view.LinkCoverWithBorderView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_group_members */
public class AttachmentLinkCoverPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, LinkCoverWithBorderView> {
    public static final String f24065a = AttachmentLinkCoverPartDefinition.class.getName();
    public static final ViewType f24066b = new C09821();
    private static AttachmentLinkCoverPartDefinition f24067g;
    private static final Object f24068h = new Object();
    private final LinkCoverPartDefinition f24069c;
    private final BackgroundPartDefinition f24070d;
    private final AttachmentLinkPartDefinition<E> f24071e;
    public final QeAccessor f24072f;

    /* compiled from: fetch_group_members */
    final class C09821 extends ViewType {
        C09821() {
        }

        public final View mo1995a(Context context) {
            return new LinkCoverWithBorderView(context);
        }
    }

    private static AttachmentLinkCoverPartDefinition m32471b(InjectorLike injectorLike) {
        return new AttachmentLinkCoverPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), LinkCoverPartDefinition.m32476a(injectorLike), AttachmentLinkPartDefinition.m32226a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24070d, new StylingData(AttachmentProps.m28715e(feedProps), PaddingStyle.f13072b));
        subParts.mo2756a(this.f24071e, new Props(feedProps));
        subParts.mo2756a(this.f24069c, new LinkCoverPartDefinition.Props(feedProps, f24065a));
        return null;
    }

    public final boolean m32474a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        boolean z = false;
        if (this.f24072f != null && this.f24072f.mo596a(ExperimentsForRichDocumentAbtestModule.f24095h, false)) {
            z = true;
        }
        if (z) {
            if ((graphQLStoryAttachment.m23987z().dB() != null ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public AttachmentLinkCoverPartDefinition(BackgroundPartDefinition backgroundPartDefinition, LinkCoverPartDefinition linkCoverPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, QeAccessor qeAccessor) {
        this.f24070d = backgroundPartDefinition;
        this.f24069c = linkCoverPartDefinition;
        this.f24071e = attachmentLinkPartDefinition;
        this.f24072f = qeAccessor;
    }

    public static AttachmentLinkCoverPartDefinition m32470a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentLinkCoverPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24068h) {
                AttachmentLinkCoverPartDefinition attachmentLinkCoverPartDefinition;
                if (a2 != null) {
                    attachmentLinkCoverPartDefinition = (AttachmentLinkCoverPartDefinition) a2.mo818a(f24068h);
                } else {
                    attachmentLinkCoverPartDefinition = f24067g;
                }
                if (attachmentLinkCoverPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32471b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24068h, b3);
                        } else {
                            f24067g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentLinkCoverPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return f24066b;
    }
}
