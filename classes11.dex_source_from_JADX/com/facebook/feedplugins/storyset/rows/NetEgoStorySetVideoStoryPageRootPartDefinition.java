package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
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
/* compiled from: became_invisible */
public class NetEgoStorySetVideoStoryPageRootPartDefinition extends BaseSinglePartDefinitionWithViewType<NetEgoStorySetPageProps, Void, FeedEnvironment, NetEgoStoryPageView> {
    public static final StorySetPageWithPageNetEgoStoryViewType f9581a = new StorySetPageWithPageNetEgoStoryViewType();
    private static NetEgoStorySetVideoStoryPageRootPartDefinition f9582e;
    private static final Object f9583f = new Object();
    private final StorySetAttachmentImagePartDefinition f9584b;
    private final StorySetPageVideoAttachmentPartDefinition f9585c;
    private final NetEgoStorySetStoryPageRootPartDefinition f9586d;

    /* compiled from: became_invisible */
    class StorySetPageWithPageNetEgoStoryViewType extends StorySetEmbededHeaderViewType<NetEgoStoryPageView> {
        public final View m10098a(Context context) {
            return (NetEgoStoryPageView) a(new NetEgoStoryPageView(context, 2130907278));
        }
    }

    private static NetEgoStorySetVideoStoryPageRootPartDefinition m10100b(InjectorLike injectorLike) {
        return new NetEgoStorySetVideoStoryPageRootPartDefinition(StorySetAttachmentImagePartDefinition.m10105a(injectorLike), StorySetPageVideoAttachmentPartDefinition.m10196a(injectorLike), NetEgoStorySetStoryPageRootPartDefinition.m10094a(injectorLike));
    }

    public final Object m10102a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        NetEgoStorySetPageProps netEgoStorySetPageProps = (NetEgoStorySetPageProps) obj;
        FeedProps i = StoryProps.i(netEgoStorySetPageProps.f9564b);
        subParts.a(this.f9586d, netEgoStorySetPageProps);
        subParts.a(2131567716, this.f9584b, i.a);
        subParts.a(2131567716, this.f9585c, i);
        return null;
    }

    @Inject
    public NetEgoStorySetVideoStoryPageRootPartDefinition(StorySetAttachmentImagePartDefinition storySetAttachmentImagePartDefinition, StorySetPageVideoAttachmentPartDefinition storySetPageVideoAttachmentPartDefinition, NetEgoStorySetStoryPageRootPartDefinition netEgoStorySetStoryPageRootPartDefinition) {
        this.f9584b = storySetAttachmentImagePartDefinition;
        this.f9585c = storySetPageVideoAttachmentPartDefinition;
        this.f9586d = netEgoStorySetStoryPageRootPartDefinition;
    }

    public static NetEgoStorySetVideoStoryPageRootPartDefinition m10099a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NetEgoStorySetVideoStoryPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9583f) {
                NetEgoStorySetVideoStoryPageRootPartDefinition netEgoStorySetVideoStoryPageRootPartDefinition;
                if (a2 != null) {
                    netEgoStorySetVideoStoryPageRootPartDefinition = (NetEgoStorySetVideoStoryPageRootPartDefinition) a2.a(f9583f);
                } else {
                    netEgoStorySetVideoStoryPageRootPartDefinition = f9582e;
                }
                if (netEgoStorySetVideoStoryPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10100b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9583f, b3);
                        } else {
                            f9582e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = netEgoStorySetVideoStoryPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<NetEgoStoryPageView> m10101a() {
        f9581a.a = this.f9586d.m10097a();
        return f9581a;
    }
}
