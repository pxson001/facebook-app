package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.links.DefaultAttachmentLinkClickHandler;
import com.facebook.feedplugins.links.DefaultAttachmentLinkClickHandler.AttachmentLinkFactory;
import com.facebook.feedplugins.links.DefaultAttachmentLinkPartDefinition;
import com.facebook.feedplugins.links.DefaultLinkedViewAdapter;
import com.facebook.feedplugins.links.LinkEventFactory;
import com.facebook.feedplugins.links.ThirdPartyNativeAttachmentPartDefinition;
import com.facebook.feedplugins.links.ThirdPartyNativeAttachmentPartDefinition.Props;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.leadgen.LeadGenActionLinkOnClickListenerProvider;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_users */
public class AttachmentLinkPartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, Void, E, View> {
    private static AttachmentLinkPartDefinition f23832j;
    private static final Object f23833k = new Object();
    private final QeAccessor f23834a;
    private final AttachmentLinkInspector f23835b;
    private final DefaultAttachmentLinkPartDefinition<E> f23836c;
    private final ThirdPartyNativeAttachmentPartDefinition f23837d;
    private final LinkEventFactory<FeedProps<GraphQLStoryAttachment>> f23838e = this.f23842i.m32294a();
    private final DefaultLinkedViewAdapter f23839f;
    private final ClickListenerPartDefinition f23840g;
    private final LeadGenActionLinkOnClickListenerProvider f23841h;
    private final DefaultAttachmentLinkClickHandler f23842i;

    private static AttachmentLinkPartDefinition m32228b(InjectorLike injectorLike) {
        return new AttachmentLinkPartDefinition(QeInternalImplMethodAutoProvider.m3744a(injectorLike), AttachmentLinkInspector.m32230a(injectorLike), DefaultAttachmentLinkPartDefinition.m32236a(injectorLike), ThirdPartyNativeAttachmentPartDefinition.m32307a(injectorLike), DefaultLinkedViewAdapter.m32316a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), (LeadGenActionLinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenActionLinkOnClickListenerProvider.class), DefaultAttachmentLinkClickHandler.m32288a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        Object obj2 = 1;
        if (props.b != null) {
            if (AngoraAttachmentUtil.b(props.b)) {
                subParts.mo2756a(this.f23840g, this.f23841h.m32319a(props.a, null, hasInvalidate));
            } else {
                String a = this.f23835b.m32235a(props.a);
                if (!Strings.isNullOrEmpty(a)) {
                    if (NativeThirdPartyUriHelper.m29571a(a)) {
                        subParts.mo2756a(this.f23837d, new Props(props.a, null, this.f23839f, a));
                    } else {
                        Object obj3;
                        GraphQLStoryActionLink a2 = ActionLinkHelper.m22935a(props.b);
                        if (a2 == null || !NativeThirdPartyUriHelper.m29571a(a2.aE())) {
                            obj3 = null;
                        } else {
                            obj3 = 1;
                        }
                        if (obj3 == null || a2.m22896W() != GraphQLCallToActionType.CALL_NOW) {
                            obj2 = null;
                        }
                        if (obj3 == null || obj2 != null) {
                            LinkEventFactory linkEventFactory;
                            if (obj2 != null) {
                                subParts.mo2755a(2131559573, this.f23837d, m32227a(props, a2.aE()));
                            }
                            if (props.c == null) {
                                linkEventFactory = this.f23838e;
                            } else {
                                obj2 = new AttachmentLinkFactory(this.f23842i, props.c);
                            }
                            subParts.mo2756a(this.f23836c, new DefaultAttachmentLinkPartDefinition.Props(props.a, linkEventFactory, this.f23839f, a));
                        } else {
                            subParts.mo2756a(this.f23837d, m32227a(props, a2.aE()));
                        }
                    }
                }
            }
        }
        return null;
    }

    public static AttachmentLinkPartDefinition m32226a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentLinkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23833k) {
                AttachmentLinkPartDefinition attachmentLinkPartDefinition;
                if (a2 != null) {
                    attachmentLinkPartDefinition = (AttachmentLinkPartDefinition) a2.mo818a(f23833k);
                } else {
                    attachmentLinkPartDefinition = f23832j;
                }
                if (attachmentLinkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32228b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23833k, b3);
                        } else {
                            f23832j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentLinkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public AttachmentLinkPartDefinition(QeAccessor qeAccessor, AttachmentLinkInspector attachmentLinkInspector, DefaultAttachmentLinkPartDefinition defaultAttachmentLinkPartDefinition, ThirdPartyNativeAttachmentPartDefinition thirdPartyNativeAttachmentPartDefinition, DefaultLinkedViewAdapter defaultLinkedViewAdapter, ClickListenerPartDefinition clickListenerPartDefinition, LeadGenActionLinkOnClickListenerProvider leadGenActionLinkOnClickListenerProvider, DefaultAttachmentLinkClickHandler defaultAttachmentLinkClickHandler) {
        this.f23834a = qeAccessor;
        this.f23835b = attachmentLinkInspector;
        this.f23836c = defaultAttachmentLinkPartDefinition;
        this.f23837d = thirdPartyNativeAttachmentPartDefinition;
        this.f23840g = clickListenerPartDefinition;
        this.f23841h = leadGenActionLinkOnClickListenerProvider;
        this.f23842i = defaultAttachmentLinkClickHandler;
        this.f23839f = defaultLinkedViewAdapter;
    }

    private Props m32227a(Props props, String str) {
        return new Props(props.a, null, this.f23839f, str);
    }
}
