package com.facebook.messaging.notify;

import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.notify.MessageSnippetHelper.IncludeSenderPrefix;
import com.facebook.messaging.notify.NewMessageNotification.MessengerUserStatus;
import com.facebook.messaging.notify.NewMessageNotification.PresenceLevel;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.messaging.push.ServerMessageAlertFlags.Builder;
import com.facebook.push.PushProperty;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPopEnterAnim=# */
public class NewMessageNotificationFactory {
    private final EphemeralGatingUtil f15485a;
    private final MessageSnippetHelper f15486b;

    public static NewMessageNotificationFactory m22098b(InjectorLike injectorLike) {
        return new NewMessageNotificationFactory(EphemeralGatingUtil.m22102b(injectorLike), MessageSnippetHelper.m21978b(injectorLike));
    }

    @Inject
    public NewMessageNotificationFactory(EphemeralGatingUtil ephemeralGatingUtil, MessageSnippetHelper messageSnippetHelper) {
        this.f15485a = ephemeralGatingUtil;
        this.f15486b = messageSnippetHelper;
    }

    public static NewMessageNotificationFactory m22097a(InjectorLike injectorLike) {
        return m22098b(injectorLike);
    }

    public final NewMessageNotification m22099a(Message message, ThreadKey threadKey, ThreadCustomization threadCustomization, PushProperty pushProperty, TriState triState) {
        String a = this.f15486b.m21982a(message, threadCustomization, IncludeSenderPrefix.ALWAYS);
        Message a2 = m22096a(message, threadCustomization);
        Builder builder = new Builder();
        builder.d = triState.asBoolean(false);
        return m22100a(a, a2, threadKey, null, null, pushProperty, null, builder.a(), MessengerUserStatus.UNKNOWN);
    }

    public final NewMessageNotification m22100a(@Nullable String str, Message message, ThreadKey threadKey, @Nullable GroupMessageInfo groupMessageInfo, @Nullable PresenceLevel presenceLevel, PushProperty pushProperty, @Nullable AlertDisposition alertDisposition, ServerMessageAlertFlags serverMessageAlertFlags, MessengerUserStatus messengerUserStatus) {
        return (!MessageUtil.m22058V(message) || this.f15485a.m22103a()) ? new NewDefaultMessageNotification(str, message, threadKey, groupMessageInfo, presenceLevel, pushProperty, alertDisposition, serverMessageAlertFlags, messengerUserStatus) : new NewEphemeralMessageNotification(str, message, threadKey, groupMessageInfo, presenceLevel, pushProperty, alertDisposition, serverMessageAlertFlags, messengerUserStatus);
    }

    private Message m22096a(Message message, ThreadCustomization threadCustomization) {
        if (message.f != null) {
            return message;
        }
        MessageBuilder a = Message.newBuilder().a(message);
        a.f = this.f15486b.m21985b(message, threadCustomization);
        return a.R();
    }
}
