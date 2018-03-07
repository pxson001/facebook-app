package com.facebook.messaging.sms.common;

/* compiled from: commerce_payment_eligible */
public class Constants {

    /* compiled from: commerce_payment_eligible */
    public enum MmsSmsErrorType {
        NO_ERROR,
        GENERIC,
        NO_CONNECTION,
        CONNECTION_ERROR,
        OVERSIZE,
        SERVER_ERROR,
        CONFIG_ERROR,
        APN_FAILURE,
        IO_ERROR,
        PROCESSING_ERROR,
        EXPIRED_MESSAGE,
        STICKER_FAIL,
        FILE_PROVIDER;

        public static MmsSmsErrorType fromOrdinal(int i) {
            return values()[i];
        }
    }
}
