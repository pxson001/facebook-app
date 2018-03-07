package com.facebook.messaging.business.common.calltoaction;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView.C09981.C09971;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.facebook.messaging.model.messagemetadata.IgnoreForWebhookPlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: newPaymentTransaction */
public class CTAPostbackActionHandler implements CallToActionTypeHandler {
    private final CTAPostbackMutationHelper f8710a;
    public final Lazy<OutgoingMessageFactory> f8711b;
    public final Lazy<SendMessageManager> f8712c;

    public static CTAPostbackActionHandler m8920b(InjectorLike injectorLike) {
        return new CTAPostbackActionHandler(new CTAPostbackMutationHelper(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike)), IdBasedLazy.a(injectorLike, 8341), IdBasedLazy.a(injectorLike, 8347));
    }

    @Inject
    public CTAPostbackActionHandler(CTAPostbackMutationHelper cTAPostbackMutationHelper, Lazy<OutgoingMessageFactory> lazy, Lazy<SendMessageManager> lazy2) {
        this.f8710a = cTAPostbackMutationHelper;
        this.f8711b = lazy;
        this.f8712c = lazy2;
    }

    public final boolean mo319a(CallToAction callToAction, ThreadKey threadKey, @Nullable C09971 c09971) {
        if (callToAction.b == null || !Type.POSTBACK.equals(callToAction.b) || Strings.isNullOrEmpty(callToAction.a())) {
            return false;
        }
        if (c09971 != null) {
            c09971.m8927a();
        }
        if (!callToAction.d) {
            ((SendMessageManager) this.f8712c.get()).m16803a(((OutgoingMessageFactory) this.f8711b.get()).m16691a(threadKey, callToAction.f, PlatformMetadataUtil.a(new PlatformMetadata[]{new IgnoreForWebhookPlatformMetadata(true)})), "MESSENGER_PLATFORM_POSTBACK", NavigationTrigger.m16841b("MESSENGER_PLATFORM_POSTBACK"), MessageSendTrigger.PLATFORM_POSTBACK);
        }
        this.f8710a.m8924a(callToAction.a(), c09971);
        return true;
    }
}
