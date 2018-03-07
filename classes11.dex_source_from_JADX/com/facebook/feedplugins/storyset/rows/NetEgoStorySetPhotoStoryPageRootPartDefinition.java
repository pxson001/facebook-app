package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.ui.NetEgoStoryPageView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: before_timeout */
public class NetEgoStorySetPhotoStoryPageRootPartDefinition extends BaseSinglePartDefinitionWithViewType<NetEgoStorySetPageProps, Void, FeedEnvironment, NetEgoStoryPageView> {
    public static final StorySetPageWithPageNetEgoStoryViewType f9568a = new StorySetPageWithPageNetEgoStoryViewType();
    private static NetEgoStorySetPhotoStoryPageRootPartDefinition f9569e;
    private static final Object f9570f = new Object();
    private final StorySetAttachmentImagePartDefinition f9571b;
    private final AttachmentLinkPartDefinition f9572c;
    private final NetEgoStorySetStoryPageRootPartDefinition f9573d;

    /* compiled from: before_timeout */
    class StorySetPageWithPageNetEgoStoryViewType extends StorySetEmbededHeaderViewType<NetEgoStoryPageView> {
        public final View m10089a(Context context) {
            return (NetEgoStoryPageView) a(new NetEgoStoryPageView(context, 2130907277));
        }
    }

    private static NetEgoStorySetPhotoStoryPageRootPartDefinition m10091b(InjectorLike injectorLike) {
        return new NetEgoStorySetPhotoStoryPageRootPartDefinition(StorySetAttachmentImagePartDefinition.m10105a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), NetEgoStorySetStoryPageRootPartDefinition.m10094a(injectorLike));
    }

    public final Object m10093a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        NetEgoStorySetPageProps netEgoStorySetPageProps = (NetEgoStorySetPageProps) obj;
        FeedProps i = StoryProps.i(netEgoStorySetPageProps.f9564b);
        subParts.a(this.f9573d, netEgoStorySetPageProps);
        subParts.a(2131567724, this.f9571b, i.a);
        subParts.a(2131567724, this.f9572c, new Props(i));
        return null;
    }

    @Inject
    public NetEgoStorySetPhotoStoryPageRootPartDefinition(StorySetAttachmentImagePartDefinition storySetAttachmentImagePartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, NetEgoStorySetStoryPageRootPartDefinition netEgoStorySetStoryPageRootPartDefinition) {
        this.f9571b = storySetAttachmentImagePartDefinition;
        this.f9572c = attachmentLinkPartDefinition;
        this.f9573d = netEgoStorySetStoryPageRootPartDefinition;
    }

    public static NetEgoStorySetPhotoStoryPageRootPartDefinition m10090a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NetEgoStorySetPhotoStoryPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9570f) {
                NetEgoStorySetPhotoStoryPageRootPartDefinition netEgoStorySetPhotoStoryPageRootPartDefinition;
                if (a2 != null) {
                    netEgoStorySetPhotoStoryPageRootPartDefinition = (NetEgoStorySetPhotoStoryPageRootPartDefinition) a2.a(f9570f);
                } else {
                    netEgoStorySetPhotoStoryPageRootPartDefinition = f9569e;
                }
                if (netEgoStorySetPhotoStoryPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10091b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9570f, b3);
                        } else {
                            f9569e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = netEgoStorySetPhotoStoryPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<NetEgoStoryPageView> m10092a() {
        f9568a.a = this.f9573d.m10097a();
        return f9568a;
    }
}
