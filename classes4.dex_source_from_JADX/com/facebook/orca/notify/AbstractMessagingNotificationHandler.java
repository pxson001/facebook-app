package com.facebook.orca.notify;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.CalleeReadyNotification;
import com.facebook.messaging.notify.FailedToSendMessageNotification;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.IncomingCallNotification;
import com.facebook.messaging.notify.JoinRequestNotification;
import com.facebook.messaging.notify.LoggedOutMessageNotification;
import com.facebook.messaging.notify.MessageRequestNotification;
import com.facebook.messaging.notify.MessagingNotification;
import com.facebook.messaging.notify.MessagingNotification$Type;
import com.facebook.messaging.notify.MissedCallNotification;
import com.facebook.messaging.notify.MultipleAccountsNewMessagesNotification;
import com.facebook.messaging.notify.NewBuildNotification;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PromotionNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.messaging.notify.SimpleMessageNotification;
import com.facebook.messaging.notify.StaleNotification;
import com.facebook.messaging.notify.TincanMessageRequestNotification;
import java.util.List;

/* compiled from: shares */
public class AbstractMessagingNotificationHandler {
    public final void m2453a(MessagingNotification messagingNotification) {
        switch (1.a[messagingNotification.j.ordinal()]) {
            case 1:
                mo156a((NewMessageNotification) messagingNotification);
                return;
            case 3:
                mo183a((LoggedOutNotification) messagingNotification);
                return;
            default:
                return;
        }
    }

    public final void m2468b(MessagingNotification messagingNotification) {
        switch (1.a[messagingNotification.j.ordinal()]) {
            case 1:
                mo159b((NewMessageNotification) messagingNotification);
                return;
            case 2:
                mo162a((LoggedOutMessageNotification) messagingNotification);
                return;
            case 3:
                mo183a((LoggedOutNotification) messagingNotification);
                return;
            case 4:
                mo161a((FriendInstallNotification) messagingNotification);
                return;
            case 5:
                mo178a((PaymentNotification) messagingNotification);
                return;
            case 6:
                mo160a((FailedToSendMessageNotification) messagingNotification);
                return;
            case 7:
                mo157a((ReadThreadNotification) messagingNotification);
                return;
            case 8:
                mo177a((NewBuildNotification) messagingNotification);
                return;
            case 9:
                mo179a((PromotionNotification) messagingNotification);
                return;
            case 10:
                mo181a((StaleNotification) messagingNotification);
                return;
            case 11:
                mo173a((MessageRequestNotification) messagingNotification);
                return;
            case 12:
                mo182a((TincanMessageRequestNotification) messagingNotification);
                return;
            case 13:
                mo176a((MultipleAccountsNewMessagesNotification) messagingNotification);
                return;
            case 14:
                mo172a((JoinRequestNotification) messagingNotification);
                return;
            case 15:
                mo184a((SwitchToFbAccountNotification) messagingNotification);
                return;
            case 16:
                mo180a((SimpleMessageNotification) messagingNotification);
                return;
            case 17:
                mo175a((MissedCallNotification) messagingNotification);
                return;
            case 18:
                mo171a((IncomingCallNotification) messagingNotification);
                return;
            case 19:
                mo170a((CalleeReadyNotification) messagingNotification);
                return;
            case 20:
                mo186b((SimpleMessageNotification) messagingNotification);
                return;
            default:
                return;
        }
    }

    public void mo174a(MessagingNotification$Type messagingNotification$Type) {
    }

    public void mo158a(String str) {
    }

    public void mo155a(ThreadKey threadKey, String str) {
    }

    public void mo169a(ThreadKey threadKey) {
    }

    public void mo187b(String str) {
    }

    public void mo185a(List<String> list) {
    }

    public void mo168a() {
    }

    protected void mo156a(NewMessageNotification newMessageNotification) {
    }

    protected void mo159b(NewMessageNotification newMessageNotification) {
    }

    protected void mo162a(LoggedOutMessageNotification loggedOutMessageNotification) {
    }

    protected void mo183a(LoggedOutNotification loggedOutNotification) {
    }

    protected void mo161a(FriendInstallNotification friendInstallNotification) {
    }

    protected void mo178a(PaymentNotification paymentNotification) {
    }

    protected void mo160a(FailedToSendMessageNotification failedToSendMessageNotification) {
    }

    protected void mo157a(ReadThreadNotification readThreadNotification) {
    }

    protected void mo177a(NewBuildNotification newBuildNotification) {
    }

    protected void mo179a(PromotionNotification promotionNotification) {
    }

    protected void mo181a(StaleNotification staleNotification) {
    }

    protected void mo180a(SimpleMessageNotification simpleMessageNotification) {
    }

    protected void mo175a(MissedCallNotification missedCallNotification) {
    }

    protected void mo171a(IncomingCallNotification incomingCallNotification) {
    }

    protected void mo170a(CalleeReadyNotification calleeReadyNotification) {
    }

    protected void mo173a(MessageRequestNotification messageRequestNotification) {
    }

    protected void mo182a(TincanMessageRequestNotification tincanMessageRequestNotification) {
    }

    protected void mo186b(SimpleMessageNotification simpleMessageNotification) {
    }

    protected void mo176a(MultipleAccountsNewMessagesNotification multipleAccountsNewMessagesNotification) {
    }

    protected void mo172a(JoinRequestNotification joinRequestNotification) {
    }

    protected void mo184a(SwitchToFbAccountNotification switchToFbAccountNotification) {
    }
}
