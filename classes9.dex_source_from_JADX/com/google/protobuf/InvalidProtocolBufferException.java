package com.google.protobuf;

import java.io.IOException;

/* compiled from: amountOffset */
public class InvalidProtocolBufferException extends IOException {
    public MessageLite unfinishedMessage = null;

    public InvalidProtocolBufferException(String str) {
        super(str);
    }

    public final InvalidProtocolBufferException m21374a(MessageLite messageLite) {
        this.unfinishedMessage = messageLite;
        return this;
    }

    public final MessageLite m21375a() {
        return this.unfinishedMessage;
    }

    static InvalidProtocolBufferException m21369b() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static InvalidProtocolBufferException m21370c() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static InvalidProtocolBufferException m21371d() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    static InvalidProtocolBufferException m21372g() {
        return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
    }

    static InvalidProtocolBufferException m21373h() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
