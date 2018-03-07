package org.whispersystems.libsignal.protocol;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.BuilderParent;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

/* compiled from: actn_add_product_click */
public final class SignalProtos {
    public static Descriptor f21299a;
    public static FieldAccessorTable f21300b;
    public static Descriptor f21301c;
    public static FieldAccessorTable f21302d;
    public static Descriptor f21303e;
    public static FieldAccessorTable f21304f;
    public static Descriptor f21305g;
    public static FieldAccessorTable f21306h;
    public static Descriptor f21307i;
    public static FieldAccessorTable f21308j;
    public static FileDescriptor f21309k;

    /* compiled from: actn_add_product_click */
    final class C24611 implements InternalDescriptorAssigner {
        C24611() {
        }

        public final ExtensionRegistry mo858a(FileDescriptor fileDescriptor) {
            SignalProtos.f21309k = fileDescriptor;
            SignalProtos.f21299a = (Descriptor) SignalProtos.f21309k.m21254d().get(0);
            SignalProtos.f21300b = new FieldAccessorTable(SignalProtos.f21299a, new String[]{"RatchetKey", "Counter", "PreviousCounter", "Ciphertext"});
            SignalProtos.f21301c = (Descriptor) SignalProtos.f21309k.m21254d().get(1);
            SignalProtos.f21302d = new FieldAccessorTable(SignalProtos.f21301c, new String[]{"RegistrationId", "PreKeyId", "SignedPreKeyId", "BaseKey", "IdentityKey", "Message"});
            SignalProtos.f21303e = (Descriptor) SignalProtos.f21309k.m21254d().get(2);
            SignalProtos.f21304f = new FieldAccessorTable(SignalProtos.f21303e, new String[]{"Id", "BaseKey", "RatchetKey", "IdentityKey", "BaseKeySignature"});
            SignalProtos.f21305g = (Descriptor) SignalProtos.f21309k.m21254d().get(3);
            SignalProtos.f21306h = new FieldAccessorTable(SignalProtos.f21305g, new String[]{"Id", "Iteration", "Ciphertext"});
            SignalProtos.f21307i = (Descriptor) SignalProtos.f21309k.m21254d().get(4);
            SignalProtos.f21308j = new FieldAccessorTable(SignalProtos.f21307i, new String[]{"Id", "Iteration", "ChainKey", "SigningKey"});
            return null;
        }
    }

    public interface PreKeySignalMessageOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actn_add_product_click */
    public final class PreKeySignalMessage extends GeneratedMessage implements PreKeySignalMessageOrBuilder {
        public static Parser<PreKeySignalMessage> f21290a = new C24621();
        public static final PreKeySignalMessage f21291c;
        public ByteString baseKey_;
        public int bitField0_;
        public ByteString identityKey_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public ByteString message_;
        public int preKeyId_;
        public int registrationId_;
        public int signedPreKeyId_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actn_add_product_click */
        final class C24621 extends AbstractParser<PreKeySignalMessage> {
            C24621() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new PreKeySignalMessage(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: actn_add_product_click */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements PreKeySignalMessageOrBuilder {
            private int f21283a;
            private int f21284b;
            private int f21285c;
            private int f21286d;
            private ByteString f21287e = ByteString.f20600a;
            private ByteString f21288f = ByteString.f20600a;
            private ByteString f21289g = ByteString.f20600a;

            public final Builder m21770a(PreKeySignalMessage preKeySignalMessage) {
                if (preKeySignalMessage != PreKeySignalMessage.f21291c) {
                    Object obj = 1;
                    if ((preKeySignalMessage.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        m21768a(preKeySignalMessage.registrationId_);
                    }
                    if (preKeySignalMessage.m21801m()) {
                        m21774b(preKeySignalMessage.preKeyId_);
                    }
                    if (preKeySignalMessage.m21803o()) {
                        m21779c(preKeySignalMessage.signedPreKeyId_);
                    }
                    if (preKeySignalMessage.m21805q()) {
                        m21769a(preKeySignalMessage.baseKey_);
                    }
                    if (preKeySignalMessage.m21811w()) {
                        m21775b(preKeySignalMessage.identityKey_);
                    }
                    if (preKeySignalMessage.m21813y()) {
                        m21780c(preKeySignalMessage.message_);
                    }
                    m20301c(preKeySignalMessage.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return PreKeySignalMessage.f21291c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m21761d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21762d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m21764w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21762d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m21764w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m21761d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21762d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m21764w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m21764w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m21765y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m21788l();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m21765y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m21788l();
            }

            protected final FieldAccessorTable mo872d() {
                return SignalProtos.f21302d.m21368a(PreKeySignalMessage.class, Builder.class);
            }

            private Builder() {
                boolean z = GeneratedMessage.f20638b;
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                boolean z = GeneratedMessage.f20638b;
            }

            public static Builder m21763u() {
                return new Builder();
            }

            private Builder m21764w() {
                return m21763u().m21770a(m21765y());
            }

            public final Descriptor mo841e() {
                return SignalProtos.f21301c;
            }

            public final PreKeySignalMessage m21788l() {
                AbstractMessage y = m21765y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private PreKeySignalMessage m21765y() {
                int i = 1;
                PreKeySignalMessage preKeySignalMessage = new PreKeySignalMessage(this);
                int i2 = this.f21283a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                preKeySignalMessage.registrationId_ = this.f21284b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                preKeySignalMessage.preKeyId_ = this.f21285c;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                preKeySignalMessage.signedPreKeyId_ = this.f21286d;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                preKeySignalMessage.baseKey_ = this.f21287e;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                preKeySignalMessage.identityKey_ = this.f21288f;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                preKeySignalMessage.message_ = this.f21289g;
                preKeySignalMessage.bitField0_ = i;
                m20309p();
                return preKeySignalMessage;
            }

            private Builder m21761d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof PreKeySignalMessage) {
                    return m21770a((PreKeySignalMessage) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m21762d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                PreKeySignalMessage preKeySignalMessage;
                Throwable th;
                PreKeySignalMessage preKeySignalMessage2;
                try {
                    preKeySignalMessage = (PreKeySignalMessage) PreKeySignalMessage.f21290a.mo859a(codedInputStream, extensionRegistryLite);
                    if (preKeySignalMessage != null) {
                        m21770a(preKeySignalMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    preKeySignalMessage = (PreKeySignalMessage) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    preKeySignalMessage2 = preKeySignalMessage;
                    th = th3;
                }
                if (preKeySignalMessage2 != null) {
                    m21770a(preKeySignalMessage2);
                }
                throw th;
            }

            public final Builder m21768a(int i) {
                this.f21283a |= 1;
                this.f21284b = i;
                m20312t();
                return this;
            }

            public final Builder m21774b(int i) {
                this.f21283a |= 2;
                this.f21285c = i;
                m20312t();
                return this;
            }

            public final Builder m21779c(int i) {
                this.f21283a |= 4;
                this.f21286d = i;
                m20312t();
                return this;
            }

            public final Builder m21769a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21283a |= 8;
                this.f21287e = byteString;
                m20312t();
                return this;
            }

            public final Builder m21775b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21283a |= 16;
                this.f21288f = byteString;
                m20312t();
                return this;
            }

            public final Builder m21780c(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21283a |= 32;
                this.f21289g = byteString;
                m20312t();
                return this;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m21791a(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m21791a(this);
        }

        public PreKeySignalMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private PreKeySignalMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f21291c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public PreKeySignalMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m21790C();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.preKeyId_ = codedInputStream.m20220l();
                            break;
                        case 18:
                            this.bitField0_ |= 8;
                            this.baseKey_ = codedInputStream.m20219k();
                            break;
                        case 26:
                            this.bitField0_ |= 16;
                            this.identityKey_ = codedInputStream.m20219k();
                            break;
                        case 34:
                            this.bitField0_ |= 32;
                            this.message_ = codedInputStream.m20219k();
                            break;
                        case 40:
                            this.bitField0_ |= 1;
                            this.registrationId_ = codedInputStream.m20220l();
                            break;
                        case 48:
                            this.bitField0_ |= 4;
                            this.signedPreKeyId_ = codedInputStream.m20220l();
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return SignalProtos.f21302d.m21368a(PreKeySignalMessage.class, Builder.class);
        }

        static {
            PreKeySignalMessage preKeySignalMessage = new PreKeySignalMessage();
            f21291c = preKeySignalMessage;
            preKeySignalMessage.m21790C();
        }

        public final Parser<PreKeySignalMessage> mo857i() {
            return f21290a;
        }

        public final int m21800l() {
            return this.registrationId_;
        }

        public final boolean m21801m() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int m21802n() {
            return this.preKeyId_;
        }

        public final boolean m21803o() {
            return (this.bitField0_ & 4) == 4;
        }

        public final int m21804p() {
            return this.signedPreKeyId_;
        }

        public final boolean m21805q() {
            return (this.bitField0_ & 8) == 8;
        }

        public final ByteString m21806r() {
            return this.baseKey_;
        }

        public final boolean m21811w() {
            return (this.bitField0_ & 16) == 16;
        }

        public final ByteString m21812x() {
            return this.identityKey_;
        }

        public final boolean m21813y() {
            return (this.bitField0_ & 32) == 32;
        }

        public final ByteString m21814z() {
            return this.message_;
        }

        private void m21790C() {
            this.registrationId_ = 0;
            this.preKeyId_ = 0;
            this.signedPreKeyId_ = 0;
            this.baseKey_ = ByteString.f20600a;
            this.identityKey_ = ByteString.f20600a;
            this.message_ = ByteString.f20600a;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20276c(1, this.preKeyId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20264a(2, this.baseKey_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m20264a(3, this.identityKey_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m20264a(4, this.message_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20276c(5, this.registrationId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20276c(6, this.signedPreKeyId_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 2) == 2) {
                i = CodedOutputStream.m20246g(1, this.preKeyId_) + 0;
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.m20236c(2, this.baseKey_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.m20236c(3, this.identityKey_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.m20236c(4, this.message_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i += CodedOutputStream.m20246g(5, this.registrationId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20246g(6, this.signedPreKeyId_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static PreKeySignalMessage m21792a(ByteString byteString) {
            return (PreKeySignalMessage) f21290a.m20164a(byteString);
        }

        public final Message$Builder mo882t() {
            return Builder.m21763u();
        }

        private static Builder m21791a(PreKeySignalMessage preKeySignalMessage) {
            return Builder.m21763u().m21770a(preKeySignalMessage);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface SignalMessageOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actn_add_product_click */
    public final class SignalMessage extends GeneratedMessage implements SignalMessageOrBuilder {
        public static Parser<SignalMessage> f21297a = new C24631();
        public static final SignalMessage f21298c;
        public int bitField0_;
        public ByteString ciphertext_;
        public int counter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public int previousCounter_;
        public ByteString ratchetKey_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actn_add_product_click */
        final class C24631 extends AbstractParser<SignalMessage> {
            C24631() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new SignalMessage(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: actn_add_product_click */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements SignalMessageOrBuilder {
            private int f21292a;
            private ByteString f21293b = ByteString.f20600a;
            private int f21294c;
            private int f21295d;
            private ByteString f21296e = ByteString.f20600a;

            public final Builder m21825a(SignalMessage signalMessage) {
                if (signalMessage != SignalMessage.f21298c) {
                    Object obj;
                    if (signalMessage.m21853k()) {
                        m21824a(signalMessage.ratchetKey_);
                    }
                    if (signalMessage.m21855m()) {
                        m21823a(signalMessage.counter_);
                    }
                    if ((signalMessage.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m21829b(signalMessage.previousCounter_);
                    }
                    if (signalMessage.m21858q()) {
                        m21830b(signalMessage.ciphertext_);
                    }
                    m20301c(signalMessage.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return SignalMessage.f21298c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m21816d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21817d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m21819w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21817d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m21819w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m21816d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21817d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m21819w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m21819w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m21820y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m21841l();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m21820y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m21841l();
            }

            protected final FieldAccessorTable mo872d() {
                return SignalProtos.f21300b.m21368a(SignalMessage.class, Builder.class);
            }

            private Builder() {
                boolean z = GeneratedMessage.f20638b;
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                boolean z = GeneratedMessage.f20638b;
            }

            public static Builder m21818u() {
                return new Builder();
            }

            private Builder m21819w() {
                return m21818u().m21825a(m21820y());
            }

            public final Descriptor mo841e() {
                return SignalProtos.f21299a;
            }

            public final SignalMessage m21841l() {
                AbstractMessage y = m21820y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private SignalMessage m21820y() {
                int i = 1;
                SignalMessage signalMessage = new SignalMessage(this);
                int i2 = this.f21292a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                signalMessage.ratchetKey_ = this.f21293b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                signalMessage.counter_ = this.f21294c;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                signalMessage.previousCounter_ = this.f21295d;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                signalMessage.ciphertext_ = this.f21296e;
                signalMessage.bitField0_ = i;
                m20309p();
                return signalMessage;
            }

            private Builder m21816d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof SignalMessage) {
                    return m21825a((SignalMessage) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m21817d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                SignalMessage signalMessage;
                SignalMessage signalMessage2;
                try {
                    signalMessage2 = (SignalMessage) SignalMessage.f21297a.mo859a(codedInputStream, extensionRegistryLite);
                    if (signalMessage2 != null) {
                        m21825a(signalMessage2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    signalMessage2 = (SignalMessage) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    signalMessage = signalMessage2;
                    th = th3;
                }
                if (signalMessage != null) {
                    m21825a(signalMessage);
                }
                throw th;
            }

            public final Builder m21824a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21292a |= 1;
                this.f21293b = byteString;
                m20312t();
                return this;
            }

            public final Builder m21823a(int i) {
                this.f21292a |= 2;
                this.f21294c = i;
                m20312t();
                return this;
            }

            public final Builder m21829b(int i) {
                this.f21292a |= 4;
                this.f21295d = i;
                m20312t();
                return this;
            }

            public final Builder m21830b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21292a |= 8;
                this.f21296e = byteString;
                m20312t();
                return this;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m21843a(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m21843a(this);
        }

        public SignalMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private SignalMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f21298c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public SignalMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m21845y();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.ratchetKey_ = codedInputStream.m20219k();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.counter_ = codedInputStream.m20220l();
                            break;
                        case 24:
                            this.bitField0_ |= 4;
                            this.previousCounter_ = codedInputStream.m20220l();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.ciphertext_ = codedInputStream.m20219k();
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return SignalProtos.f21300b.m21368a(SignalMessage.class, Builder.class);
        }

        static {
            SignalMessage signalMessage = new SignalMessage();
            f21298c = signalMessage;
            signalMessage.m21845y();
        }

        public final Parser<SignalMessage> mo857i() {
            return f21297a;
        }

        public final boolean m21853k() {
            return (this.bitField0_ & 1) == 1;
        }

        public final ByteString m21854l() {
            return this.ratchetKey_;
        }

        public final boolean m21855m() {
            return (this.bitField0_ & 2) == 2;
        }

        public final int m21856n() {
            return this.counter_;
        }

        public final int m21857p() {
            return this.previousCounter_;
        }

        public final boolean m21858q() {
            return (this.bitField0_ & 8) == 8;
        }

        public final ByteString m21859r() {
            return this.ciphertext_;
        }

        private void m21845y() {
            this.ratchetKey_ = ByteString.f20600a;
            this.counter_ = 0;
            this.previousCounter_ = 0;
            this.ciphertext_ = ByteString.f20600a;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, this.ratchetKey_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20276c(2, this.counter_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20276c(3, this.previousCounter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20264a(4, this.ciphertext_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = CodedOutputStream.m20236c(1, this.ratchetKey_) + 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20246g(2, this.counter_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20246g(3, this.previousCounter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.m20236c(4, this.ciphertext_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static SignalMessage m21844a(byte[] bArr) {
            return (SignalMessage) f21297a.m20167a(bArr);
        }

        public final Message$Builder mo882t() {
            return Builder.m21818u();
        }

        private static Builder m21843a(SignalMessage signalMessage) {
            return Builder.m21818u().m21825a(signalMessage);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    private SignalProtos() {
    }

    static {
        FileDescriptor.m21250a(new String[]{"\n\u0019WhisperTextProtocol.proto\u0012\ntextsecure\"a\n\rSignalMessage\u0012\u0012\n\nratchetKey\u0018\u0001 \u0001(\f\u0012\u000f\n\u0007counter\u0018\u0002 \u0001(\r\u0012\u0017\n\u000fpreviousCounter\u0018\u0003 \u0001(\r\u0012\u0012\n\nciphertext\u0018\u0004 \u0001(\f\"\u0001\n\u0013PreKeySignalMessage\u0012\u0016\n\u000eregistrationId\u0018\u0005 \u0001(\r\u0012\u0010\n\bpreKeyId\u0018\u0001 \u0001(\r\u0012\u0016\n\u000esignedPreKeyId\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007baseKey\u0018\u0002 \u0001(\f\u0012\u0013\n\u000bidentityKey\u0018\u0003 \u0001(\f\u0012\u000f\n\u0007message\u0018\u0004 \u0001(\f\"t\n\u0012KeyExchangeMessage\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007baseKey\u0018\u0002 \u0001(\f\u0012\u0012\n\nratchetKey\u0018\u0003 \u0001(\f\u0012\u0013\n\u000bidentityKey\u0018\u0004 \u0001(\f\u0012\u0018\n\u0010baseKeySignature\u0018\u0005 \u0001(", "\f\"E\n\u0010SenderKeyMessage\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0011\n\titeration\u0018\u0002 \u0001(\r\u0012\u0012\n\nciphertext\u0018\u0003 \u0001(\f\"c\n\u001cSenderKeyDistributionMessage\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0011\n\titeration\u0018\u0002 \u0001(\r\u0012\u0010\n\bchainKey\u0018\u0003 \u0001(\f\u0012\u0012\n\nsigningKey\u0018\u0004 \u0001(\fB5\n%org.whispersystems.libsignal.protocolB\fSignalProtos"}, new FileDescriptor[0], new C24611());
    }
}
