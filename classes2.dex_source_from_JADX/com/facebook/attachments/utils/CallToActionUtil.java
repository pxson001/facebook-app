package com.facebook.attachments.utils;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetch_group_threads */
public class CallToActionUtil {
    private final GatekeeperStoreImpl f24064a;

    public static CallToActionUtil m32455b(InjectorLike injectorLike) {
        return new CallToActionUtil(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public CallToActionUtil(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f24064a = gatekeeperStoreImpl;
    }

    public static CallToActionUtil m32452a(InjectorLike injectorLike) {
        return m32455b(injectorLike);
    }

    public final boolean m32469c(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(graphQLStoryAttachment);
        boolean z = false;
        if (m32456b(a)) {
            GraphQLCallToActionStyle T = a.m22893T();
            if (m32468a()) {
                if (T == GraphQLCallToActionStyle.VIDEO_DR_STYLE) {
                    z = true;
                }
            } else if (T == GraphQLCallToActionStyle.HIDE_FROM_FEED || T == GraphQLCallToActionStyle.ATTACHMENT_AND_ENDSCREEN || T == GraphQLCallToActionStyle.SHOW_SPONSORSHIP || T == GraphQLCallToActionStyle.VIDEO_DR_STYLE) {
                z = true;
            }
        }
        return z;
    }

    public static boolean m32456b(@Nullable GraphQLStoryActionLink graphQLStoryActionLink) {
        return (graphQLStoryActionLink == null || GraphQLCallToActionType.NO_BUTTON.equals(graphQLStoryActionLink.m22896W())) ? false : true;
    }

    public static boolean m32457d(GraphQLStoryAttachment graphQLStoryAttachment) {
        return ActionLinkHelper.m22936a(graphQLStoryAttachment, 1185006756) != null;
    }

    public static boolean m32458e(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m32456b(ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748));
    }

    public static boolean m32459f(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748);
        return (a == null || graphQLStoryAttachment.m23972k() == null || (a.m22916u() != GraphQLStoryActionLinkDestinationType.APP && a.m22916u() != GraphQLStoryActionLinkDestinationType.APP_WITH_PRODUCT)) ? false : true;
    }

    public static boolean m32460g(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748);
        if (a == null || Strings.isNullOrEmpty(a.aE())) {
            return false;
        }
        GraphQLCallToActionStyle T = a.m22893T();
        if (T == GraphQLCallToActionStyle.BUTTON_WITH_TEXT_ONLY || T == GraphQLCallToActionStyle.ATTACHMENT_AND_ENDSCREEN || T == GraphQLCallToActionStyle.VIDEO_DR_STYLE) {
            return true;
        }
        return false;
    }

    public static boolean m32461h(GraphQLStoryAttachment graphQLStoryAttachment) {
        return ActionLinkHelper.m22936a(graphQLStoryAttachment, -581184810) != null;
    }

    public static boolean m32462i(GraphQLStoryAttachment graphQLStoryAttachment) {
        return ActionLinkHelper.m22936a(graphQLStoryAttachment, 41461717) != null;
    }

    public static boolean m32463j(GraphQLStoryAttachment graphQLStoryAttachment) {
        return ActionLinkHelper.m22936a(graphQLStoryAttachment, -1580386863) != null;
    }

    public static boolean m32464k(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m32460g(graphQLStoryAttachment) || m32462i(graphQLStoryAttachment) || m32463j(graphQLStoryAttachment) || m32457d(graphQLStoryAttachment);
    }

    public static String m32453a(Context context, String str) {
        if (Strings.isNullOrEmpty(str) || str.length() <= 25) {
            return str;
        }
        return str.substring(0, 25).trim() + context.getResources().getString(2131230738);
    }

    public static boolean m32465l(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748);
        if (a == null || a.m22893T() != GraphQLCallToActionStyle.VIDEO_DR_STYLE) {
            return false;
        }
        return true;
    }

    public static boolean m32466m(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748);
        if (a == null || a.m22896W() != GraphQLCallToActionType.DONATE_NOW || a.m22916u() == GraphQLStoryActionLinkDestinationType.INTERNAL_FLOW) {
            return false;
        }
        return true;
    }

    public static String m32454a(Resources resources) {
        return resources.getString(2131233629);
    }

    public static boolean m32467n(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList w = graphQLStoryAttachment.m23984w();
        return w.contains(GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE) || w.contains(GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE_AUTOPLAY);
    }

    public final boolean m32468a() {
        return this.f24064a.m2189a(415, false);
    }
}
