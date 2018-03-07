package com.facebook.events.permalink.actionbar;

import android.view.View;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;

/* compiled from: cache_age */
public class EventsActionBarMenuHandlerProvider extends AbstractAssistedProvider<EventsActionBarMenuHandler> {
    public final EventsActionBarMenuHandler m18475a(View view) {
        return new EventsActionBarMenuHandler(view, ActionItemDelete.m18340a((InjectorLike) this), ActionItemEdit.m18345a((InjectorLike) this), ActionItemRsvp.m18390a((InjectorLike) this), ActionItemSave.m18413a((InjectorLike) this), ActionItemPromoteEvent.m18376a((InjectorLike) this), (EventActionsHandlerUtilProvider) getOnDemandAssistedProviderForStaticDi(EventActionsHandlerUtilProvider.class), EventEventLogger.m18116a((InjectorLike) this), EventPermalinkController.m18257a((InjectorLike) this), EventsDashboardTimeFormatUtil.a(this), MessengerAppUtils.a(this), ProductMethodAutoProvider.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), SendAsMessageUtil.a(this), SaveButtonUtils.a(this), Boolean_IsWorkBuildMethodAutoProvider.a(this));
    }
}
