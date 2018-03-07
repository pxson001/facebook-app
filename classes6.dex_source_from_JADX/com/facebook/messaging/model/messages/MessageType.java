package com.facebook.messaging.model.messages;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: upload_setting_properties */
public enum MessageType {
    BEFORE_FIRST_SENTINEL(-1),
    REGULAR(0),
    ADD_MEMBERS(1),
    REMOVE_MEMBERS(2),
    SET_NAME(3),
    SET_IMAGE(4),
    VIDEO_CALL(5),
    MISSED_VIDEO_CALL(6),
    REMOVED_IMAGE(7),
    ADMIN(8),
    CALL_LOG(9),
    GLOBALLY_DELETED_MESSAGE_PLACEHOLDER(10),
    P2P_PAYMENT(50),
    P2P_PAYMENT_CANCELED(51),
    P2P_PAYMENT_GROUP(52),
    INCOMING_CALL(100),
    MISSED_CALL(101),
    OUTGOING_CALL(102),
    COMMERCE_LINK(150),
    COMMERCE_UNLINK(151),
    ACTIVITY_REPLY(152),
    TELEPHONE_CALL_LOG(200),
    SMS_LOG(201),
    PENDING_SEND(900),
    FAILED_SEND(901),
    UNKNOWN(1000);
    
    private static final ImmutableMap<Integer, MessageType> DB_KEY_VALUE_TO_MESSAGE_TYPE = null;
    public final int dbKeyValue;

    static {
        Builder builder = ImmutableMap.builder();
        MessageType[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            MessageType messageType = values[i];
            builder.b(Integer.valueOf(messageType.dbKeyValue), messageType);
            i++;
        }
        DB_KEY_VALUE_TO_MESSAGE_TYPE = builder.b();
    }

    private MessageType(int i) {
        this.dbKeyValue = i;
    }

    public static MessageType fromDbKeyValue(int i) {
        return (MessageType) DB_KEY_VALUE_TO_MESSAGE_TYPE.get(Integer.valueOf(i));
    }
}
