package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import javax.inject.Inject;

@ContextScoped
/* compiled from: survey_shown */
public class ChannelFeedSocialContextHeaderPartDefinition extends MultiRowSinglePartDefinition<GraphQLStory, Void, AnyEnvironment, ChannelFeedSocialContextHeaderView> {
    public static final ViewType f2483a = new C02271();
    private static ChannelFeedSocialContextHeaderPartDefinition f2484d;
    private static final Object f2485e = new Object();
    private final ChannelFeedSocialContextHeaderTitlePartDefinition f2486b;
    private final ChannelFeedConfig f2487c;

    /* compiled from: survey_shown */
    final class C02271 extends ViewType {
        C02271() {
        }

        public final View m2414a(Context context) {
            return new ChannelFeedSocialContextHeaderView(context);
        }
    }

    private static ChannelFeedSocialContextHeaderPartDefinition m2416b(InjectorLike injectorLike) {
        return new ChannelFeedSocialContextHeaderPartDefinition(ChannelFeedSocialContextHeaderTitlePartDefinition.m2421a(injectorLike), ChannelFeedConfig.a(injectorLike));
    }

    public final Object m2418a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131558927, this.f2486b, (GraphQLStory) obj);
        return null;
    }

    public final boolean m2419a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        if (!this.f2487c.k || graphQLStory.l() != null || graphQLStory.L() == null || graphQLStory.aH() == null || graphQLStory.aH().a() == null || graphQLStory.aH().a().isEmpty()) {
            return false;
        }
        return true;
    }

    @Inject
    public ChannelFeedSocialContextHeaderPartDefinition(ChannelFeedSocialContextHeaderTitlePartDefinition channelFeedSocialContextHeaderTitlePartDefinition, ChannelFeedConfig channelFeedConfig) {
        this.f2486b = channelFeedSocialContextHeaderTitlePartDefinition;
        this.f2487c = channelFeedConfig;
    }

    public final ViewType m2417a() {
        return f2483a;
    }

    public static ChannelFeedSocialContextHeaderPartDefinition m2415a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedSocialContextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2485e) {
                ChannelFeedSocialContextHeaderPartDefinition channelFeedSocialContextHeaderPartDefinition;
                if (a2 != null) {
                    channelFeedSocialContextHeaderPartDefinition = (ChannelFeedSocialContextHeaderPartDefinition) a2.a(f2485e);
                } else {
                    channelFeedSocialContextHeaderPartDefinition = f2484d;
                }
                if (channelFeedSocialContextHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2416b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2485e, b3);
                        } else {
                            f2484d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedSocialContextHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
