package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedplugins.links.AttachmentLinkClickEventFactory.LinkClickType;
import com.facebook.feedplugins.links.ThirdPartyNativeAttachmentPartDefinition.Props;
import com.facebook.graphql.model.FeedAttachable;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_contacts */
public class AttachmentCallToActionButtonLinkPartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, Void, E, View> {
    private static final Map f24128a = ImmutableBiMap.m978b("cta_click", Boolean.valueOf(true));
    private static AttachmentCallToActionButtonLinkPartDefinition f24129f;
    private static final Object f24130g = new Object();
    private final DefaultAttachmentLinkPartDefinition<E> f24131b;
    private final ThirdPartyNativeAttachmentPartDefinition f24132c;
    private final AttachmentLinkInspector f24133d;
    private final AttachmentLinkClickEventFactoryProvider f24134e;

    private static AttachmentCallToActionButtonLinkPartDefinition m32499b(InjectorLike injectorLike) {
        return new AttachmentCallToActionButtonLinkPartDefinition(AttachmentLinkInspector.m32230a(injectorLike), DefaultAttachmentLinkPartDefinition.m32236a(injectorLike), ThirdPartyNativeAttachmentPartDefinition.m32307a(injectorLike), (AttachmentLinkClickEventFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AttachmentLinkClickEventFactoryProvider.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        if (props.b != null) {
            FeedProps feedProps = props.a.f13445b;
            if (!(feedProps != null && (feedProps.f13444a instanceof FeedAttachable) && TrackableFeedProps.m27452b(feedProps) == null)) {
                String a = AttachmentCallToActionButtonLinkUtils.a(props.a, this.f24133d);
                if (!Strings.isNullOrEmpty(a)) {
                    if (NativeThirdPartyUriHelper.m29571a(a)) {
                        subParts.mo2756a(this.f24132c, new Props(props.a, f24128a, props.c, a));
                    } else {
                        LinkEventFactory linkEventFactory = props.d;
                        if (linkEventFactory == null) {
                            linkEventFactory = this.f24134e.m32501a(LinkClickType.CTA_BUTTON);
                        }
                        subParts.mo2756a(this.f24131b, new DefaultAttachmentLinkPartDefinition.Props(props.a, linkEventFactory, props.c, a));
                    }
                }
            }
        }
        return null;
    }

    public static AttachmentCallToActionButtonLinkPartDefinition m32498a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentCallToActionButtonLinkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24130g) {
                AttachmentCallToActionButtonLinkPartDefinition attachmentCallToActionButtonLinkPartDefinition;
                if (a2 != null) {
                    attachmentCallToActionButtonLinkPartDefinition = (AttachmentCallToActionButtonLinkPartDefinition) a2.mo818a(f24130g);
                } else {
                    attachmentCallToActionButtonLinkPartDefinition = f24129f;
                }
                if (attachmentCallToActionButtonLinkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32499b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24130g, b3);
                        } else {
                            f24129f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentCallToActionButtonLinkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public AttachmentCallToActionButtonLinkPartDefinition(AttachmentLinkInspector attachmentLinkInspector, DefaultAttachmentLinkPartDefinition defaultAttachmentLinkPartDefinition, ThirdPartyNativeAttachmentPartDefinition thirdPartyNativeAttachmentPartDefinition, AttachmentLinkClickEventFactoryProvider attachmentLinkClickEventFactoryProvider) {
        this.f24133d = attachmentLinkInspector;
        this.f24131b = defaultAttachmentLinkPartDefinition;
        this.f24132c = thirdPartyNativeAttachmentPartDefinition;
        this.f24134e = attachmentLinkClickEventFactoryProvider;
    }
}
