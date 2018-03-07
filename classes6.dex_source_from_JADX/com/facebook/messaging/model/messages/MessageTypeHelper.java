package com.facebook.messaging.model.messages;

/* compiled from: upload_session_id */
public class MessageTypeHelper {
    public static MessageType m3422a(Integer num) {
        if (num == null) {
            return MessageType.P2P_PAYMENT;
        }
        switch (num.intValue()) {
            case 1:
                return MessageType.P2P_PAYMENT_GROUP;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return MessageType.P2P_PAYMENT_CANCELED;
            default:
                return MessageType.P2P_PAYMENT;
        }
    }
}
