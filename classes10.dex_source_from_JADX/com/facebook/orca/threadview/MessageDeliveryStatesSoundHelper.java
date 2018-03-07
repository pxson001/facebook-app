package com.facebook.orca.threadview;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: meta_ranges */
public class MessageDeliveryStatesSoundHelper {
    public final MessengerSoundUtil f7026a;
    @Nullable
    public Message f7027b;

    public static MessageDeliveryStatesSoundHelper m6608a(InjectorLike injectorLike) {
        return new MessageDeliveryStatesSoundHelper(MessengerSoundUtil.a(injectorLike));
    }

    @Inject
    public MessageDeliveryStatesSoundHelper(MessengerSoundUtil messengerSoundUtil) {
        this.f7026a = messengerSoundUtil;
    }
}
