package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: clear_icon */
public class PacketType {
    public static final IntRangeSet f18167a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6, 7, 10, 11, 20, 21, 30, 31, 32, 40, 41, 42, 50, 51, 100, 300, 400, 450, 451, 452, 453, 499, 2000, 2010, 2020, 3000, 3010, 3020, 3999, 4000, 4010, 4020, 4030, 4040, 4999, 5000, 6000, 6100, 6500, 6520, 6530, 6540, 6550, 6600, 6999, 7000, 8000});
    public static final Map<Integer, String> f18168b = new C21151();

    /* compiled from: clear_icon */
    final class C21151 extends HashMap<Integer, String> {
        C21151() {
            put(Integer.valueOf(1), "SALAMANDER_PLAINTEXT_UNSAFE");
            put(Integer.valueOf(2), "SALAMANDER_SIGNED_ENCRYPTED");
            put(Integer.valueOf(3), "REQUEST");
            put(Integer.valueOf(4), "ACCEPT");
            put(Integer.valueOf(5), "REQUEST_CANCEL");
            put(Integer.valueOf(6), "BACKEND_PACKET_BOUNCED");
            put(Integer.valueOf(7), "PING");
            put(Integer.valueOf(10), "REGISTER");
            put(Integer.valueOf(11), "REGISTER_RESULT");
            put(Integer.valueOf(20), "LOOKUP");
            put(Integer.valueOf(21), "LOOKUP_RESPONSE");
            put(Integer.valueOf(30), "SET_PRIMARY_DEVICE");
            put(Integer.valueOf(31), "SET_PRIMARY_DEVICE_RESULT");
            put(Integer.valueOf(32), "PRIMARY_DEVICE_CHANGE");
            put(Integer.valueOf(40), "LINK_CLOSED_BY_PARTICIPANT");
            put(Integer.valueOf(41), "LINK_NEEDS_NEW_LOOKUP");
            put(Integer.valueOf(42), "LINK_YOU_ARE_NOT_PRIMARY");
            put(Integer.valueOf(50), "RECEIPT_DELIVERED");
            put(Integer.valueOf(51), "RECEIPT_SEEN");
            put(Integer.valueOf(100), "CALLER_ID_INFO");
            put(Integer.valueOf(300), "STATUS_REFRESH_REGISTRATION");
            put(Integer.valueOf(400), "STATUS_PACKET_ERROR");
            put(Integer.valueOf(450), "STATUS_PACKET_BLOCK_INSECURE");
            put(Integer.valueOf(451), "STATUS_PACKET_BLOCK_COUNTRY");
            put(Integer.valueOf(452), "STATUS_PACKET_VERSION_TOO_OLD");
            put(Integer.valueOf(453), "STATUS_PACKET_VERSION_TOO_NEW");
            put(Integer.valueOf(499), "MAX_VALUE_PACKET_ERROR");
            put(Integer.valueOf(2000), "STATUS_REQUEST_BOUNCED");
            put(Integer.valueOf(2010), "STATUS_REQUEST_TIMED_OUT");
            put(Integer.valueOf(2020), "STATUS_REQUEST_CALLEE_BUSY");
            put(Integer.valueOf(3000), "STATUS_REQUEST_ERROR");
            put(Integer.valueOf(3010), "STATUS_REQUEST_ERROR_NOT_PREKEY");
            put(Integer.valueOf(3020), "STATUS_REQUEST_ERROR_BAD_PREKEY");
            put(Integer.valueOf(3999), "MAX_VALUE_STATUS_REQUEST_ERROR");
            put(Integer.valueOf(4000), "STATUS_ACCEPT_ERROR");
            put(Integer.valueOf(4010), "STATUS_ACCEPT_ERROR_NOT_PREKEY");
            put(Integer.valueOf(4020), "STATUS_ACCEPT_ERROR_BAD_PREKEY");
            put(Integer.valueOf(4030), "STATUS_ACCEPT_ERROR_NOT_LINK_ACCEPTED");
            put(Integer.valueOf(4040), "STATUS_ACCEPT_ERROR_NO_SESSION");
            put(Integer.valueOf(4999), "MAX_VALUE_STATUS_ACCEPT_ERROR");
            put(Integer.valueOf(5000), "STATUS_CANCEL_ERROR");
            put(Integer.valueOf(6000), "STATUS_SALAMANDER_ERROR");
            put(Integer.valueOf(6100), "STATUS_SALAMANDER_ERROR_NONSPECIFIC");
            put(Integer.valueOf(6500), "STATUS_SALAMANDER_ERROR_OUTER_DECRYPT");
            put(Integer.valueOf(6520), "STATUS_SALAMANDER_ERROR_SIGNATURE_FAIL");
            put(Integer.valueOf(6530), "STATUS_SALAMANDER_ERROR_INNER_DESERIALIZE");
            put(Integer.valueOf(6540), "STATUS_SALAMANDER_ERROR_INVALID_TYPE");
            put(Integer.valueOf(6550), "STATUS_SALAMANDER_ERROR_INVALID_BODY");
            put(Integer.valueOf(6600), "STATUS_SALAMANDER_TYPE_UNRECOGNIZED");
            put(Integer.valueOf(6999), "MAX_VALUE_STATUS_SALAMANDER_ERROR");
            put(Integer.valueOf(7000), "STATUS_SALAMANDER_BOUNCED");
            put(Integer.valueOf(8000), "STATUS_SI_RATE_LIMIT_EXCEEDED");
        }
    }
}
