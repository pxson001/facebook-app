package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.graphql.model.GraphQLInstantArticle;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.linkcovers.AttachmentCoverLayoutSpec;
import com.facebook.richdocument.linkcovers.LinkCoverFetchParams;
import com.facebook.richdocument.linkcovers.LinkCoverFetchParams.LinkCoverFetchParamBuilder;
import com.facebook.richdocument.linkcovers.RichDocumentLinkCoverFetcher;
import com.facebook.richdocument.linkcovers.view.LinkCoverBasicView;
import com.facebook.richdocument.linkcovers.view.LinkCoverByLineView;
import com.facebook.richdocument.linkcovers.view.LinkCoverSpecView;
import com.facebook.richdocument.linkcovers.view.LinkCoverWithBorderView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_gql_notifications */
public class LinkCoverPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, LinkCoverWithBorderView> {
    private static LinkCoverPartDefinition f24073d;
    private static final Object f24074e = new Object();
    public final AbstractFbErrorReporter f24075a;
    public final RichDocumentLinkCoverFetcher f24076b;
    public final QeAccessor f24077c;

    private static LinkCoverPartDefinition m32479b(InjectorLike injectorLike) {
        return new LinkCoverPartDefinition(FbErrorReporterImpl.m2317a(injectorLike), RichDocumentLinkCoverFetcher.m32484a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLInstantArticle dB = props.b.m23987z().dB();
        State state = new State();
        if (dB == null) {
            this.f24075a.m2350b(props.a, "Story attachment without instant article " + AttachmentProps.m28714c(props.c).S_());
        } else {
            boolean z = false;
            if (this.f24077c != null && this.f24077c.mo596a(ExperimentsForRichDocumentAbtestModule.f24095h, false) && this.f24077c.mo596a(ExperimentsForRichDocumentAbtestModule.f24096i, false)) {
                z = true;
            }
            if (z && !StringUtil.m3590a(state.b, dB.m23349m())) {
                LinkCoverFetchParams linkCoverFetchParams = new LinkCoverFetchParams(new LinkCoverFetchParamBuilder(dB.m23349m()));
                state.b = null;
                this.f24076b.m32486a(linkCoverFetchParams, new 1(this, state, dB, props));
            }
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1184661987);
        m32477a((Props) obj, (State) obj2, (LinkCoverWithBorderView) view);
        Logger.a(8, EntryType.MARK_POP, -212999352, a);
    }

    public static LinkCoverPartDefinition m32476a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LinkCoverPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24074e) {
                LinkCoverPartDefinition linkCoverPartDefinition;
                if (a2 != null) {
                    linkCoverPartDefinition = (LinkCoverPartDefinition) a2.mo818a(f24074e);
                } else {
                    linkCoverPartDefinition = f24073d;
                }
                if (linkCoverPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32479b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24074e, b3);
                        } else {
                            f24073d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = linkCoverPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public LinkCoverPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, RichDocumentLinkCoverFetcher richDocumentLinkCoverFetcher, QeAccessor qeAccessor) {
        this.f24075a = abstractFbErrorReporter;
        this.f24076b = richDocumentLinkCoverFetcher;
        this.f24077c = qeAccessor;
    }

    public static String m32480b(Props props) {
        return props.b.m23987z().dB().m23349m();
    }

    private void m32477a(Props props, State state, LinkCoverWithBorderView linkCoverWithBorderView) {
        if (state.a == null || linkCoverWithBorderView == null || linkCoverWithBorderView.getMeasuredWidth() <= 0 || m32480b(props) == null || state.b == null || !m32480b(props).equals(state.b)) {
            m32478a(props, linkCoverWithBorderView);
            return;
        }
        Preconditions.checkNotNull(state.a);
        if (linkCoverWithBorderView != null && state.b != null && m32480b(props).equals(state.b)) {
            Object obj;
            Object obj2;
            int measuredWidth = linkCoverWithBorderView.getMeasuredWidth();
            AttachmentCoverLayoutSpec attachmentCoverLayoutSpec = state.a;
            String str = state.b;
            if (measuredWidth != attachmentCoverLayoutSpec.t || str == null || attachmentCoverLayoutSpec.i == null || !str.equals(attachmentCoverLayoutSpec.i)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                state.a.a(measuredWidth, state.b);
            }
            if (linkCoverWithBorderView.c) {
                linkCoverWithBorderView.removeAllViews();
                linkCoverWithBorderView.setContentView(2130905051);
                linkCoverWithBorderView.b = (LinkCoverSpecView) linkCoverWithBorderView.m16956c(2131563440);
                linkCoverWithBorderView.a = null;
                linkCoverWithBorderView.c = false;
            }
            LinkCoverSpecView linkCoverSpecView = linkCoverWithBorderView.b;
            linkCoverSpecView.a(state.a);
            linkCoverSpecView.setImageParams(m32481c(props));
            linkCoverSpecView.setTitleText(Strings.nullToEmpty(props.b.m23964A()));
            linkCoverSpecView.setDescriptionText(props.b.m23975n() != null ? props.b.m23975n().mo2911a() : "");
            LinkCoverByLineView linkCoverByLineView = linkCoverSpecView.d;
            linkCoverByLineView.setAuthorText(props.b.m23982u().mo2911a());
            AttachmentCoverLayoutSpec attachmentCoverLayoutSpec2 = state.a;
            if (attachmentCoverLayoutSpec2.l == null || !attachmentCoverLayoutSpec2.l.f) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                String str2;
                attachmentCoverLayoutSpec2 = state.a;
                if (attachmentCoverLayoutSpec2.l == null || !attachmentCoverLayoutSpec2.l.f) {
                    str2 = null;
                } else {
                    str2 = attachmentCoverLayoutSpec2.l.g;
                }
                linkCoverByLineView.a(Uri.parse(str2), (int) state.a.m().height());
            }
        }
    }

    private void m32478a(Props props, LinkCoverWithBorderView linkCoverWithBorderView) {
        if (linkCoverWithBorderView != null) {
            if (!linkCoverWithBorderView.c) {
                linkCoverWithBorderView.b();
            }
            LinkCoverBasicView linkCoverBasicView = linkCoverWithBorderView.a;
            if (linkCoverBasicView != null) {
                if (!(props.b.m23982u() == null || linkCoverBasicView.c == null)) {
                    linkCoverBasicView.c.setAuthorText(props.b.m23982u().mo2911a());
                }
                linkCoverBasicView.setTitleText(Strings.nullToEmpty(props.b.m23964A()));
                linkCoverBasicView.setDescriptionText(props.b.m23986y());
                Uri c = m32481c(props);
                if (c != null) {
                    linkCoverBasicView.setImageParams(c);
                }
            }
        }
    }

    public static Uri m32481c(Props props) {
        String o = GraphQLStoryAttachmentUtil.m28064o(props.b);
        return o == null ? null : Uri.parse(o);
    }
}
