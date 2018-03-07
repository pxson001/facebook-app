package com.facebook.messaging.xma;

import com.facebook.commerce.invoices.xma.InvoicesStyleAssociation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.agent.xma.AgentItemReceiptStyleAssociation;
import com.facebook.messaging.business.commerceui.CommerceUIModule;
import com.facebook.messaging.business.commerceui.views.common.RetailItemStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleCancellationStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleReceiptStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleSubscriptionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleSupportedShipmentStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleTrackingEventDelayedStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleTrackingEventDeliveredStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleTrackingEventETAStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleTrackingEventInTransitStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleTrackingEventOutForDeliveryStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleUnsupportedShipmentStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.DefaultCommerceBubbleAgentItemSuggestionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.FallBackCommerceBubbleAgentItemSuggestionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.RetailPromotionStyleAssociation;
import com.facebook.messaging.business.ride.xma.RideOrderBubbleStyleAssociation;
import com.facebook.messaging.business.ride.xma.RideReceiptBubbleStyleAssociation;
import com.facebook.messaging.momentsinvite.ui.MomentsInviteStyleAssociation;
import com.facebook.messaging.momentsinvite.ui.MomentsPhotoRequestStyleAssociation;
import com.facebook.messaging.rtc.adminmsg.xma.RTCAdminMsgStyleAssociation;
import com.facebook.messaging.sharerendering.AttachedStoryStyleAssociation;
import com.facebook.messaging.sharerendering.ImageShareStyleAssociation;
import com.facebook.messaging.sharerendering.LinkShareStyleAssociation;
import com.facebook.messaging.sharerendering.ShareLargeImageStyleAssociation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$StyleAssociation implements MultiBindIndexedProvider<StyleAssociation>, Provider<Set<StyleAssociation>> {
    private final InjectorLike f1553a;

    private STATICDI_MULTIBIND_PROVIDER$StyleAssociation(InjectorLike injectorLike) {
        this.f1553a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1553a.getScopeAwareInjector(), this);
    }

    public static Set<StyleAssociation> m1724a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$StyleAssociation(injectorLike));
    }

    public final int size() {
        return 24;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new InvoicesStyleAssociation(IdBasedLazy.a(injector, 5059), IdBasedLazy.a(injector, 5057));
            case 1:
                return new AgentItemReceiptStyleAssociation(IdBasedLazy.a(injector, 7564), IdBasedLazy.a(injector, 7562));
            case 2:
                return new RetailItemStyleAssociation(IdBasedLazy.a(injector, 7579), IdBasedLazy.a(injector, 7577));
            case 3:
                return CommerceUIModule.a(DefaultCommerceBubbleAgentItemSuggestionStyleAssociation.b(injector), FallBackCommerceBubbleAgentItemSuggestionStyleAssociation.b(injector), IdBasedProvider.a(injector, 4119));
            case 4:
                return new CommerceBubbleCancellationStyleAssociation(IdBasedLazy.a(injector, 7593), IdBasedLazy.a(injector, 7591));
            case 5:
                return new CommerceBubbleReceiptStyleAssociation(IdBasedLazy.a(injector, 7593), IdBasedLazy.a(injector, 7594));
            case 6:
                return new CommerceBubbleSubscriptionStyleAssociation(IdBasedLazy.a(injector, 7605), IdBasedLazy.a(injector, 7603));
            case 7:
                return new CommerceBubbleSupportedShipmentStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 8:
                return new CommerceBubbleTrackingEventDelayedStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 9:
                return new CommerceBubbleTrackingEventDeliveredStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 10:
                return new CommerceBubbleTrackingEventETAStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 11:
                return new CommerceBubbleTrackingEventInTransitStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 12:
                return new CommerceBubbleTrackingEventOutForDeliveryStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 13:
                return new CommerceBubbleUnsupportedShipmentStyleAssociation(IdBasedLazy.a(injector, 7601), IdBasedLazy.a(injector, 7597));
            case 14:
                return new RetailPromotionStyleAssociation(IdBasedLazy.a(injector, 7617), IdBasedLazy.a(injector, 7615));
            case 15:
                return new RideOrderBubbleStyleAssociation(IdBasedLazy.a(injector, 7681), IdBasedLazy.a(injector, 7679));
            case 16:
                return new RideReceiptBubbleStyleAssociation(IdBasedLazy.a(injector, 7684), IdBasedLazy.a(injector, 7682));
            case 17:
                return new MomentsInviteStyleAssociation(IdBasedLazy.a(injector, 7985), IdBasedLazy.a(injector, 7983));
            case 18:
                return new MomentsPhotoRequestStyleAssociation(IdBasedLazy.a(injector, 7985), IdBasedLazy.a(injector, 7983));
            case 19:
                return new RTCAdminMsgStyleAssociation(IdBasedLazy.a(injector, 8330), IdBasedLazy.a(injector, 8331));
            case 20:
                return new AttachedStoryStyleAssociation(IdBasedLazy.a(injector, 8435), IdBasedLazy.a(injector, 8432));
            case 21:
                return new ImageShareStyleAssociation(IdBasedLazy.a(injector, 8431), IdBasedLazy.a(injector, 8429));
            case 22:
                return new LinkShareStyleAssociation(IdBasedLazy.a(injector, 8435), IdBasedLazy.a(injector, 8432));
            case 23:
                return new ShareLargeImageStyleAssociation(IdBasedLazy.a(injector, 8431), IdBasedLazy.a(injector, 8429));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
