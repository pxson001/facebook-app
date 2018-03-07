package com.google.protobuf;

/* compiled from: android.intent.action.BADGE_COUNT_UPDATE */
public interface MessageLite extends MessageLiteOrBuilder {

    /* compiled from: android.intent.action.BADGE_COUNT_UPDATE */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        Builder mo839b(byte[] bArr);

        Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        MessageLite mo876j();

        MessageLite mo877k();
    }

    void mo853a(CodedOutputStream codedOutputStream);

    int mo855b();

    ByteString mo851d();

    Parser<? extends MessageLite> mo857i();

    byte[] lP_();

    Builder mo883u();
}
