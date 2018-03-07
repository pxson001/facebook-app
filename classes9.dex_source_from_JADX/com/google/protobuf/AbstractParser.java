package com.google.protobuf;

/* compiled from: android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED */
public abstract class AbstractParser<MessageType extends MessageLite> {
    private static final ExtensionRegistryLite f20597a = ExtensionRegistryLite.f20905c;

    public abstract MessageType mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

    public final /* synthetic */ Object m20165a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return m20162c(byteString, extensionRegistryLite);
    }

    public final /* synthetic */ Object m20168a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return m20161b(bArr, extensionRegistryLite);
    }

    public final /* synthetic */ Object m20169b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return m20163d(byteString, extensionRegistryLite);
    }

    private static UninitializedMessageException m20158a(MessageType messageType) {
        if (messageType instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messageType).mo856c();
        }
        return new UninitializedMessageException();
    }

    private MessageType m20159b(MessageType messageType) {
        if (messageType == null || messageType.mo854a()) {
            return messageType;
        }
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(m20158a((MessageLite) messageType).getMessage());
        invalidProtocolBufferException.unfinishedMessage = messageType;
        throw invalidProtocolBufferException;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MessageType m20162c(com.google.protobuf.ByteString r4, com.google.protobuf.ExtensionRegistryLite r5) {
        /*
        r3 = this;
        r1 = r4.mo918h();	 Catch:{ InvalidProtocolBufferException -> 0x0015, IOException -> 0x0017 }
        r0 = r3.mo859a(r1, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0015, IOException -> 0x0017 }
        r0 = (com.google.protobuf.MessageLite) r0;	 Catch:{ InvalidProtocolBufferException -> 0x0015, IOException -> 0x0017 }
        r2 = 0;
        r1.m20204a(r2);	 Catch:{ InvalidProtocolBufferException -> 0x000f, IOException -> 0x0017 }
        return r0;
    L_0x000f:
        r1 = move-exception;
        r0 = r1.m21374a(r0);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0015:
        r0 = move-exception;
        throw r0;
    L_0x0017:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "Reading from a ByteString threw an IOException (should never happen).";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractParser.c(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):MessageType");
    }

    private MessageType m20163d(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return m20159b(m20162c(byteString, extensionRegistryLite));
    }

    public final Object m20164a(ByteString byteString) {
        return m20163d(byteString, f20597a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MessageType m20157a(byte[] r4, int r5, int r6, com.google.protobuf.ExtensionRegistryLite r7) {
        /*
        r3 = this;
        r1 = com.google.protobuf.CodedInputStream.m20192a(r4, r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x0015, IOException -> 0x0017 }
        r0 = r3.mo859a(r1, r7);	 Catch:{ InvalidProtocolBufferException -> 0x0015, IOException -> 0x0017 }
        r0 = (com.google.protobuf.MessageLite) r0;	 Catch:{ InvalidProtocolBufferException -> 0x0015, IOException -> 0x0017 }
        r2 = 0;
        r1.m20204a(r2);	 Catch:{ InvalidProtocolBufferException -> 0x000f, IOException -> 0x0017 }
        return r0;
    L_0x000f:
        r1 = move-exception;
        r0 = r1.m21374a(r0);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0015:
        r0 = move-exception;
        throw r0;
    L_0x0017:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "Reading from a byte array threw an IOException (should never happen).";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractParser.a(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):MessageType");
    }

    private MessageType m20160b(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
        return m20159b(m20157a(bArr, i, i2, extensionRegistryLite));
    }

    private MessageType m20161b(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return m20160b(bArr, 0, bArr.length, extensionRegistryLite);
    }

    public final Object m20167a(byte[] bArr) {
        return m20161b(bArr, f20597a);
    }
}
