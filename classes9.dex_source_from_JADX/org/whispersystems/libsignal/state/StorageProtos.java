package org.whispersystems.libsignal.state;

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
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: actionId */
public final class StorageProtos {
    public static Descriptor f21447A;
    public static FieldAccessorTable f21448B;
    public static Descriptor f21449C;
    public static FieldAccessorTable f21450D;
    public static FileDescriptor f21451E;
    public static Descriptor f21452a;
    public static FieldAccessorTable f21453b;
    public static Descriptor f21454c;
    public static FieldAccessorTable f21455d;
    public static Descriptor f21456e;
    public static FieldAccessorTable f21457f;
    public static Descriptor f21458g;
    public static FieldAccessorTable f21459h;
    public static Descriptor f21460i;
    public static FieldAccessorTable f21461j;
    public static Descriptor f21462k;
    public static FieldAccessorTable f21463l;
    public static Descriptor f21464m;
    public static FieldAccessorTable f21465n;
    public static Descriptor f21466o;
    public static FieldAccessorTable f21467p;
    public static Descriptor f21468q;
    public static FieldAccessorTable f21469r;
    public static Descriptor f21470s;
    public static FieldAccessorTable f21471t;
    public static Descriptor f21472u;
    public static FieldAccessorTable f21473v;
    public static Descriptor f21474w;
    public static FieldAccessorTable f21475x;
    public static Descriptor f21476y;
    public static FieldAccessorTable f21477z;

    /* compiled from: actionId */
    final class C24641 implements InternalDescriptorAssigner {
        C24641() {
        }

        public final ExtensionRegistry mo858a(FileDescriptor fileDescriptor) {
            StorageProtos.f21451E = fileDescriptor;
            StorageProtos.f21452a = (Descriptor) StorageProtos.f21451E.m21254d().get(0);
            StorageProtos.f21453b = new FieldAccessorTable(StorageProtos.f21452a, new String[]{"SessionVersion", "LocalIdentityPublic", "RemoteIdentityPublic", "RootKey", "PreviousCounter", "SenderChain", "ReceiverChains", "PendingKeyExchange", "PendingPreKey", "RemoteRegistrationId", "LocalRegistrationId", "NeedsRefresh", "AliceBaseKey"});
            StorageProtos.f21454c = (Descriptor) StorageProtos.f21452a.m21197f().get(0);
            StorageProtos.f21455d = new FieldAccessorTable(StorageProtos.f21454c, new String[]{"SenderRatchetKey", "SenderRatchetKeyPrivate", "ChainKey", "MessageKeys"});
            StorageProtos.f21456e = (Descriptor) StorageProtos.f21454c.m21197f().get(0);
            StorageProtos.f21457f = new FieldAccessorTable(StorageProtos.f21456e, new String[]{"Index", "Key"});
            StorageProtos.f21458g = (Descriptor) StorageProtos.f21454c.m21197f().get(1);
            StorageProtos.f21459h = new FieldAccessorTable(StorageProtos.f21458g, new String[]{"Index", "CipherKey", "MacKey", "Iv"});
            StorageProtos.f21460i = (Descriptor) StorageProtos.f21452a.m21197f().get(1);
            StorageProtos.f21461j = new FieldAccessorTable(StorageProtos.f21460i, new String[]{"Sequence", "LocalBaseKey", "LocalBaseKeyPrivate", "LocalRatchetKey", "LocalRatchetKeyPrivate", "LocalIdentityKey", "LocalIdentityKeyPrivate"});
            StorageProtos.f21462k = (Descriptor) StorageProtos.f21452a.m21197f().get(2);
            StorageProtos.f21463l = new FieldAccessorTable(StorageProtos.f21462k, new String[]{"PreKeyId", "SignedPreKeyId", "BaseKey"});
            StorageProtos.f21464m = (Descriptor) StorageProtos.f21451E.m21254d().get(1);
            StorageProtos.f21465n = new FieldAccessorTable(StorageProtos.f21464m, new String[]{"CurrentSession", "PreviousSessions"});
            StorageProtos.f21466o = (Descriptor) StorageProtos.f21451E.m21254d().get(2);
            StorageProtos.f21467p = new FieldAccessorTable(StorageProtos.f21466o, new String[]{"Id", "PublicKey", "PrivateKey"});
            StorageProtos.f21468q = (Descriptor) StorageProtos.f21451E.m21254d().get(3);
            StorageProtos.f21469r = new FieldAccessorTable(StorageProtos.f21468q, new String[]{"Id", "PublicKey", "PrivateKey", "Signature", "Timestamp"});
            StorageProtos.f21470s = (Descriptor) StorageProtos.f21451E.m21254d().get(4);
            StorageProtos.f21471t = new FieldAccessorTable(StorageProtos.f21470s, new String[]{"PublicKey", "PrivateKey"});
            StorageProtos.f21472u = (Descriptor) StorageProtos.f21451E.m21254d().get(5);
            StorageProtos.f21473v = new FieldAccessorTable(StorageProtos.f21472u, new String[]{"SenderKeyId", "SenderChainKey", "SenderSigningKey", "SenderMessageKeys"});
            StorageProtos.f21474w = (Descriptor) StorageProtos.f21472u.m21197f().get(0);
            StorageProtos.f21475x = new FieldAccessorTable(StorageProtos.f21474w, new String[]{"Iteration", "Seed"});
            StorageProtos.f21476y = (Descriptor) StorageProtos.f21472u.m21197f().get(1);
            StorageProtos.f21477z = new FieldAccessorTable(StorageProtos.f21476y, new String[]{"Iteration", "Seed"});
            StorageProtos.f21447A = (Descriptor) StorageProtos.f21472u.m21197f().get(2);
            StorageProtos.f21448B = new FieldAccessorTable(StorageProtos.f21447A, new String[]{"Public", "Private"});
            StorageProtos.f21449C = (Descriptor) StorageProtos.f21451E.m21254d().get(6);
            StorageProtos.f21450D = new FieldAccessorTable(StorageProtos.f21449C, new String[]{"SenderKeyStates"});
            return null;
        }
    }

    public interface IdentityKeyPairStructureOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actionId */
    public final class IdentityKeyPairStructure extends GeneratedMessage implements IdentityKeyPairStructureOrBuilder {
        public static Parser<IdentityKeyPairStructure> f21367a = new C24651();
        public static final IdentityKeyPairStructure f21368c;
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public ByteString privateKey_;
        public ByteString publicKey_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actionId */
        final class C24651 extends AbstractParser<IdentityKeyPairStructure> {
            C24651() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new IdentityKeyPairStructure(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: actionId */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements IdentityKeyPairStructureOrBuilder {
            private int f21364a;
            private ByteString f21365b = ByteString.f20600a;
            private ByteString f21366c = ByteString.f20600a;

            public final Builder m21962a(IdentityKeyPairStructure identityKeyPairStructure) {
                if (identityKeyPairStructure != IdentityKeyPairStructure.f21368c) {
                    Object obj = 1;
                    if ((identityKeyPairStructure.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        m21961a(identityKeyPairStructure.publicKey_);
                    }
                    if ((identityKeyPairStructure.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m21966b(identityKeyPairStructure.privateKey_);
                    }
                    m20301c(identityKeyPairStructure.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return IdentityKeyPairStructure.f21368c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m21954d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21955d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m21957w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21955d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m21957w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m21954d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21955d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m21957w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m21957w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m21958y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m21977l();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m21958y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m21977l();
            }

            protected final FieldAccessorTable mo872d() {
                return StorageProtos.f21471t.m21368a(IdentityKeyPairStructure.class, Builder.class);
            }

            private Builder() {
                boolean z = GeneratedMessage.f20638b;
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                boolean z = GeneratedMessage.f20638b;
            }

            public static Builder m21956u() {
                return new Builder();
            }

            private Builder m21957w() {
                return m21956u().m21962a(m21958y());
            }

            public final Descriptor mo841e() {
                return StorageProtos.f21470s;
            }

            public final IdentityKeyPairStructure m21977l() {
                AbstractMessage y = m21958y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private IdentityKeyPairStructure m21958y() {
                int i = 1;
                IdentityKeyPairStructure identityKeyPairStructure = new IdentityKeyPairStructure(this);
                int i2 = this.f21364a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                identityKeyPairStructure.publicKey_ = this.f21365b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                identityKeyPairStructure.privateKey_ = this.f21366c;
                identityKeyPairStructure.bitField0_ = i;
                m20309p();
                return identityKeyPairStructure;
            }

            private Builder m21954d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof IdentityKeyPairStructure) {
                    return m21962a((IdentityKeyPairStructure) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m21955d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                IdentityKeyPairStructure identityKeyPairStructure;
                IdentityKeyPairStructure identityKeyPairStructure2;
                try {
                    identityKeyPairStructure2 = (IdentityKeyPairStructure) IdentityKeyPairStructure.f21367a.mo859a(codedInputStream, extensionRegistryLite);
                    if (identityKeyPairStructure2 != null) {
                        m21962a(identityKeyPairStructure2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    identityKeyPairStructure2 = (IdentityKeyPairStructure) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    identityKeyPairStructure = identityKeyPairStructure2;
                    th = th3;
                }
                if (identityKeyPairStructure != null) {
                    m21962a(identityKeyPairStructure);
                }
                throw th;
            }

            public final Builder m21961a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21364a |= 1;
                this.f21365b = byteString;
                m20312t();
                return this;
            }

            public final Builder m21966b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21364a |= 2;
                this.f21366c = byteString;
                m20312t();
                return this;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m21979a(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m21979a(this);
        }

        public IdentityKeyPairStructure(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private IdentityKeyPairStructure() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f21368c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public IdentityKeyPairStructure(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m21981q();
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
                            this.publicKey_ = codedInputStream.m20219k();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.privateKey_ = codedInputStream.m20219k();
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
            return StorageProtos.f21471t.m21368a(IdentityKeyPairStructure.class, Builder.class);
        }

        static {
            IdentityKeyPairStructure identityKeyPairStructure = new IdentityKeyPairStructure();
            f21368c = identityKeyPairStructure;
            identityKeyPairStructure.m21981q();
        }

        public final Parser<IdentityKeyPairStructure> mo857i() {
            return f21367a;
        }

        public final ByteString m21989l() {
            return this.publicKey_;
        }

        public final ByteString m21990n() {
            return this.privateKey_;
        }

        private void m21981q() {
            this.publicKey_ = ByteString.f20600a;
            this.privateKey_ = ByteString.f20600a;
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
                codedOutputStream.m20264a(1, this.publicKey_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20264a(2, this.privateKey_);
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
                i = CodedOutputStream.m20236c(1, this.publicKey_) + 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20236c(2, this.privateKey_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static IdentityKeyPairStructure m21980a(byte[] bArr) {
            return (IdentityKeyPairStructure) f21367a.m20167a(bArr);
        }

        public final Message$Builder mo882t() {
            return Builder.m21956u();
        }

        private static Builder m21979a(IdentityKeyPairStructure identityKeyPairStructure) {
            return Builder.m21956u().m21962a(identityKeyPairStructure);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface PreKeyRecordStructureOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actionId */
    public final class PreKeyRecordStructure extends GeneratedMessage implements PreKeyRecordStructureOrBuilder {
        public static Parser<PreKeyRecordStructure> f21373a = new C24661();
        public static final PreKeyRecordStructure f21374c;
        public int bitField0_;
        public int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public ByteString privateKey_;
        public ByteString publicKey_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actionId */
        final class C24661 extends AbstractParser<PreKeyRecordStructure> {
            C24661() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new PreKeyRecordStructure(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: actionId */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements PreKeyRecordStructureOrBuilder {
            private int f21369a;
            private int f21370b;
            private ByteString f21371c = ByteString.f20600a;
            private ByteString f21372d = ByteString.f20600a;

            public final Builder m22005a(PreKeyRecordStructure preKeyRecordStructure) {
                if (preKeyRecordStructure != PreKeyRecordStructure.f21374c) {
                    Object obj = 1;
                    if ((preKeyRecordStructure.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        m22003a(preKeyRecordStructure.id_);
                    }
                    if ((preKeyRecordStructure.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m22004a(preKeyRecordStructure.publicKey_);
                    }
                    if ((preKeyRecordStructure.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m22009b(preKeyRecordStructure.privateKey_);
                    }
                    m20301c(preKeyRecordStructure.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return PreKeyRecordStructure.f21374c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m21996d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21997d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m21999w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21997d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m21999w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m21996d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21997d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m21999w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m21999w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m22000y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m22020l();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m22000y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m22020l();
            }

            protected final FieldAccessorTable mo872d() {
                return StorageProtos.f21467p.m21368a(PreKeyRecordStructure.class, Builder.class);
            }

            private Builder() {
                boolean z = GeneratedMessage.f20638b;
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                boolean z = GeneratedMessage.f20638b;
            }

            public static Builder m21998u() {
                return new Builder();
            }

            private Builder m21999w() {
                return m21998u().m22005a(m22000y());
            }

            public final Descriptor mo841e() {
                return StorageProtos.f21466o;
            }

            public final PreKeyRecordStructure m22020l() {
                AbstractMessage y = m22000y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private PreKeyRecordStructure m22000y() {
                int i = 1;
                PreKeyRecordStructure preKeyRecordStructure = new PreKeyRecordStructure(this);
                int i2 = this.f21369a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                preKeyRecordStructure.id_ = this.f21370b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                preKeyRecordStructure.publicKey_ = this.f21371c;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                preKeyRecordStructure.privateKey_ = this.f21372d;
                preKeyRecordStructure.bitField0_ = i;
                m20309p();
                return preKeyRecordStructure;
            }

            private Builder m21996d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof PreKeyRecordStructure) {
                    return m22005a((PreKeyRecordStructure) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m21997d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                PreKeyRecordStructure preKeyRecordStructure;
                PreKeyRecordStructure preKeyRecordStructure2;
                try {
                    preKeyRecordStructure2 = (PreKeyRecordStructure) PreKeyRecordStructure.f21373a.mo859a(codedInputStream, extensionRegistryLite);
                    if (preKeyRecordStructure2 != null) {
                        m22005a(preKeyRecordStructure2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    preKeyRecordStructure2 = (PreKeyRecordStructure) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    preKeyRecordStructure = preKeyRecordStructure2;
                    th = th3;
                }
                if (preKeyRecordStructure != null) {
                    m22005a(preKeyRecordStructure);
                }
                throw th;
            }

            public final Builder m22003a(int i) {
                this.f21369a |= 1;
                this.f21370b = i;
                m20312t();
                return this;
            }

            public final Builder m22004a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21369a |= 2;
                this.f21371c = byteString;
                m20312t();
                return this;
            }

            public final Builder m22009b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21369a |= 4;
                this.f21372d = byteString;
                m20312t();
                return this;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m22022a(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m22022a(this);
        }

        public PreKeyRecordStructure(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private PreKeyRecordStructure() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f21374c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public PreKeyRecordStructure(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m22023w();
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
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.m20220l();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.publicKey_ = codedInputStream.m20219k();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.privateKey_ = codedInputStream.m20219k();
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
            return StorageProtos.f21467p.m21368a(PreKeyRecordStructure.class, Builder.class);
        }

        static {
            PreKeyRecordStructure preKeyRecordStructure = new PreKeyRecordStructure();
            f21374c = preKeyRecordStructure;
            preKeyRecordStructure.m22023w();
        }

        public final Parser<PreKeyRecordStructure> mo857i() {
            return f21373a;
        }

        public final ByteString m22031n() {
            return this.publicKey_;
        }

        public final ByteString m22032p() {
            return this.privateKey_;
        }

        private void m22023w() {
            this.id_ = 0;
            this.publicKey_ = ByteString.f20600a;
            this.privateKey_ = ByteString.f20600a;
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
                codedOutputStream.m20276c(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20264a(2, this.publicKey_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20264a(3, this.privateKey_);
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
                i = CodedOutputStream.m20246g(1, this.id_) + 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20236c(2, this.publicKey_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20236c(3, this.privateKey_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public final Message$Builder mo882t() {
            return Builder.m21998u();
        }

        private static Builder m22022a(PreKeyRecordStructure preKeyRecordStructure) {
            return Builder.m21998u().m22005a(preKeyRecordStructure);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface RecordStructureOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actionId */
    public final class RecordStructure extends GeneratedMessage implements RecordStructureOrBuilder {
        public static Parser<RecordStructure> f21380a = new C24671();
        public static final RecordStructure f21381c;
        public int bitField0_;
        public SessionStructure currentSession_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<SessionStructure> previousSessions_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actionId */
        final class C24671 extends AbstractParser<RecordStructure> {
            C24671() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new RecordStructure(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: actionId */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements RecordStructureOrBuilder {
            public int f21375a;
            public SessionStructure f21376b = SessionStructure.f21438c;
            public SingleFieldBuilder<SessionStructure, Builder, SessionStructureOrBuilder> f21377c;
            private List<SessionStructure> f21378d = Collections.emptyList();
            private RepeatedFieldBuilder<SessionStructure, Builder, SessionStructureOrBuilder> f21379e;

            public final AbstractMessage mo878v() {
                return RecordStructure.f21381c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m22040d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m22041d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m22044w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m22041d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m22044w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m22040d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m22041d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m22044w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m22044w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m22045y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m22064l();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m22045y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m22064l();
            }

            protected final FieldAccessorTable mo872d() {
                return StorageProtos.f21465n.m21368a(RecordStructure.class, Builder.class);
            }

            private Builder() {
                m22042n();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m22042n();
            }

            private void m22042n() {
                if (GeneratedMessage.f20638b) {
                    if (this.f21377c == null) {
                        this.f21377c = new SingleFieldBuilder(this.f21376b, m20311s(), this.f20619c);
                        this.f21376b = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f21377c;
                    m22039B();
                }
            }

            public static Builder m22043u() {
                return new Builder();
            }

            private Builder m22044w() {
                return m22043u().m22049a(m22045y());
            }

            public final Descriptor mo841e() {
                return StorageProtos.f21464m;
            }

            public final RecordStructure m22064l() {
                AbstractMessage y = m22045y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private RecordStructure m22045y() {
                int i = 0;
                RecordStructure recordStructure = new RecordStructure(this);
                if ((this.f21375a & 1) == 1) {
                    i = 1;
                }
                if (this.f21377c == null) {
                    recordStructure.currentSession_ = this.f21376b;
                } else {
                    recordStructure.currentSession_ = (SessionStructure) this.f21377c.m21442d();
                }
                if (this.f21379e == null) {
                    if ((this.f21375a & 2) == 2) {
                        this.f21378d = Collections.unmodifiableList(this.f21378d);
                        this.f21375a &= -3;
                    }
                    recordStructure.previousSessions_ = this.f21378d;
                } else {
                    recordStructure.previousSessions_ = this.f21379e.m21416f();
                }
                recordStructure.bitField0_ = i;
                m20309p();
                return recordStructure;
            }

            private Builder m22040d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof RecordStructure) {
                    return m22049a((RecordStructure) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m22049a(RecordStructure recordStructure) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (recordStructure != RecordStructure.f21381c) {
                    Object obj = 1;
                    if ((recordStructure.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        SessionStructure sessionStructure = recordStructure.currentSession_;
                        if (this.f21377c == null) {
                            if ((this.f21375a & 1) != 1 || this.f21376b == SessionStructure.f21438c) {
                                this.f21376b = sessionStructure;
                            } else {
                                this.f21376b = SessionStructure.m22338a(this.f21376b).m22094a(sessionStructure).m22117m();
                            }
                            m20312t();
                        } else {
                            this.f21377c.m21439b(sessionStructure);
                        }
                        this.f21375a |= 1;
                    }
                    if (this.f21379e == null) {
                        if (!recordStructure.previousSessions_.isEmpty()) {
                            if (this.f21378d.isEmpty()) {
                                this.f21378d = recordStructure.previousSessions_;
                                this.f21375a &= -3;
                            } else {
                                m22038A();
                                this.f21378d.addAll(recordStructure.previousSessions_);
                            }
                            m20312t();
                        }
                    } else if (!recordStructure.previousSessions_.isEmpty()) {
                        if (this.f21379e.m21414d()) {
                            this.f21379e.m21411b();
                            this.f21379e = null;
                            this.f21378d = recordStructure.previousSessions_;
                            this.f21375a &= -3;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m22039B();
                            }
                            this.f21379e = repeatedFieldBuilder;
                        } else {
                            this.f21379e.m21409a(recordStructure.previousSessions_);
                        }
                    }
                    m20301c(recordStructure.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m22041d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                RecordStructure recordStructure;
                Throwable th;
                RecordStructure recordStructure2;
                try {
                    recordStructure = (RecordStructure) RecordStructure.f21380a.mo859a(codedInputStream, extensionRegistryLite);
                    if (recordStructure != null) {
                        m22049a(recordStructure);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    recordStructure = (RecordStructure) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    recordStructure2 = recordStructure;
                    th = th3;
                }
                if (recordStructure2 != null) {
                    m22049a(recordStructure2);
                }
                throw th;
            }

            public final Builder m22050a(SessionStructure sessionStructure) {
                if (this.f21377c != null) {
                    this.f21377c.m21437a(sessionStructure);
                } else if (sessionStructure == null) {
                    throw new NullPointerException();
                } else {
                    this.f21376b = sessionStructure;
                    m20312t();
                }
                this.f21375a |= 1;
                return this;
            }

            private void m22038A() {
                if ((this.f21375a & 2) != 2) {
                    this.f21378d = new ArrayList(this.f21378d);
                    this.f21375a |= 2;
                }
            }

            public final Builder mo938a(Iterable<? extends SessionStructure> iterable) {
                if (this.f21379e == null) {
                    m22038A();
                    com.google.protobuf.AbstractMessageLite.Builder.m20091a((Iterable) iterable, this.f21378d);
                    m20312t();
                } else {
                    this.f21379e.m21409a((Iterable) iterable);
                }
                return this;
            }

            private RepeatedFieldBuilder<SessionStructure, Builder, SessionStructureOrBuilder> m22039B() {
                if (this.f21379e == null) {
                    boolean z;
                    List list = this.f21378d;
                    if ((this.f21375a & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f21379e = new RepeatedFieldBuilder(list, z, m20311s(), this.f20619c);
                    this.f21378d = null;
                }
                return this.f21379e;
            }
        }

        private void m22067q() {
            this.currentSession_ = SessionStructure.f21438c;
            this.previousSessions_ = Collections.emptyList();
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m22066b(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m22066b(this);
        }

        public RecordStructure(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private RecordStructure() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f21381c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RecordStructure(com.google.protobuf.CodedInputStream r9, com.google.protobuf.ExtensionRegistryLite r10) {
            /*
            r8 = this;
            r0 = 0;
            r1 = -1;
            r6 = 2;
            r4 = 1;
            r8.<init>();
            r8.memoizedIsInitialized = r1;
            r8.memoizedSerializedSize = r1;
            r8.m22067q();
            r5 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            r3 = r0;
            r1 = r0;
        L_0x0014:
            if (r3 != 0) goto L_0x008a;
        L_0x0016:
            r0 = r9.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            switch(r0) {
                case 0: goto L_0x0025;
                case 10: goto L_0x0027;
                case 18: goto L_0x0070;
                default: goto L_0x001d;
            };	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
        L_0x001d:
            r0 = r8.mo889a(r9, r5, r10, r0);	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            if (r0 != 0) goto L_0x00c3;
        L_0x0023:
            r3 = r4;
            goto L_0x0014;
        L_0x0025:
            r3 = r4;
            goto L_0x0014;
        L_0x0027:
            r0 = 0;
            r2 = r8.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r2 = r2 & 1;
            if (r2 != r4) goto L_0x00c0;
        L_0x002e:
            r0 = r8.currentSession_;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r0 = r0.m22342O();	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r2 = r0;
        L_0x0035:
            r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.f21437a;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r0 = r9.m20203a(r0, r10);	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure) r0;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r8.currentSession_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            if (r2 == 0) goto L_0x004c;
        L_0x0041:
            r0 = r8.currentSession_;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r2.m22094a(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r0 = r2.m22117m();	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r8.currentSession_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
        L_0x004c:
            r0 = r8.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            r0 = r0 | 1;
            r8.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0053, IOException -> 0x00a0 }
            goto L_0x0014;
        L_0x0053:
            r0 = move-exception;
        L_0x0054:
            r0 = r0.m21374a(r8);	 Catch:{ all -> 0x0059 }
            throw r0;	 Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception;
        L_0x005a:
            r1 = r1 & 2;
            if (r1 != r6) goto L_0x0066;
        L_0x005e:
            r1 = r8.previousSessions_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r8.previousSessions_ = r1;
        L_0x0066:
            r1 = r5.m21495b();
            r8.unknownFields = r1;
            r8.mo888E();
            throw r0;
        L_0x0070:
            r0 = r1 & 2;
            if (r0 == r6) goto L_0x00be;
        L_0x0074:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r8.previousSessions_ = r0;	 Catch:{  }
            r0 = r1 | 2;
        L_0x007d:
            r1 = r8.previousSessions_;	 Catch:{ InvalidProtocolBufferException -> 0x00b9, IOException -> 0x00b4, all -> 0x00af }
            r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.f21437a;	 Catch:{ InvalidProtocolBufferException -> 0x00b9, IOException -> 0x00b4, all -> 0x00af }
            r2 = r9.m20203a(r2, r10);	 Catch:{ InvalidProtocolBufferException -> 0x00b9, IOException -> 0x00b4, all -> 0x00af }
            r1.add(r2);	 Catch:{ InvalidProtocolBufferException -> 0x00b9, IOException -> 0x00b4, all -> 0x00af }
        L_0x0088:
            r1 = r0;
            goto L_0x0014;
        L_0x008a:
            r0 = r1 & 2;
            if (r0 != r6) goto L_0x0096;
        L_0x008e:
            r0 = r8.previousSessions_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r8.previousSessions_ = r0;
        L_0x0096:
            r0 = r5.m21495b();
            r8.unknownFields = r0;
            r8.mo888E();
            return;
        L_0x00a0:
            r0 = move-exception;
        L_0x00a1:
            r2 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{  }
            r0 = r0.getMessage();	 Catch:{  }
            r2.<init>(r0);	 Catch:{  }
            r0 = r2.m21374a(r8);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x00af:
            r1 = move-exception;
            r7 = r1;
            r1 = r0;
            r0 = r7;
            goto L_0x005a;
        L_0x00b4:
            r1 = move-exception;
            r7 = r1;
            r1 = r0;
            r0 = r7;
            goto L_0x00a1;
        L_0x00b9:
            r1 = move-exception;
            r7 = r1;
            r1 = r0;
            r0 = r7;
            goto L_0x0054;
        L_0x00be:
            r0 = r1;
            goto L_0x007d;
        L_0x00c0:
            r2 = r0;
            goto L_0x0035;
        L_0x00c3:
            r0 = r1;
            goto L_0x0088;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.RecordStructure.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }

        protected final FieldAccessorTable mo880h() {
            return StorageProtos.f21465n.m21368a(RecordStructure.class, Builder.class);
        }

        static {
            RecordStructure recordStructure = new RecordStructure();
            f21381c = recordStructure;
            recordStructure.m22067q();
        }

        public final Parser<RecordStructure> mo857i() {
            return f21380a;
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
                codedOutputStream.m20273b(1, this.currentSession_);
            }
            for (int i = 0; i < this.previousSessions_.size(); i++) {
                codedOutputStream.m20273b(2, (MessageLite) this.previousSessions_.get(i));
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20242e(1, this.currentSession_) + 0;
            } else {
                i2 = 0;
            }
            int i3 = i2;
            while (i < this.previousSessions_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(2, (MessageLite) this.previousSessions_.get(i)) + i3;
            }
            i2 = mo868g().mo855b() + i3;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public final Message$Builder mo882t() {
            return Builder.m22043u();
        }

        private static Builder m22066b(RecordStructure recordStructure) {
            return Builder.m22043u().m22049a(recordStructure);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface SessionStructureOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actionId */
    public final class SessionStructure extends GeneratedMessage implements SessionStructureOrBuilder {
        public static Parser<SessionStructure> f21437a = new C24681();
        public static final SessionStructure f21438c;
        public ByteString aliceBaseKey_;
        public int bitField0_;
        public ByteString localIdentityPublic_;
        public int localRegistrationId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public boolean needsRefresh_;
        public PendingKeyExchange pendingKeyExchange_;
        public PendingPreKey pendingPreKey_;
        public int previousCounter_;
        public List<Chain> receiverChains_;
        public ByteString remoteIdentityPublic_;
        public int remoteRegistrationId_;
        public ByteString rootKey_;
        public Chain senderChain_;
        public int sessionVersion_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actionId */
        final class C24681 extends AbstractParser<SessionStructure> {
            C24681() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.1.<init>():void");
            }

            public final java.lang.Object mo859a(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure;
                r1 = 0;
                r0.<init>(r3, r4);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.1.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object");
            }
        }

        /* compiled from: actionId */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements SessionStructureOrBuilder {
            public int f21382a;
            private int f21383b;
            private ByteString f21384c = ByteString.f20600a;
            private ByteString f21385d = ByteString.f20600a;
            private ByteString f21386e = ByteString.f20600a;
            private int f21387f;
            public Chain f21388g = Chain.f21420c;
            public SingleFieldBuilder<Chain, Builder, ChainOrBuilder> f21389h;
            private List<Chain> f21390i = Collections.emptyList();
            private RepeatedFieldBuilder<Chain, Builder, ChainOrBuilder> f21391j;
            public PendingKeyExchange f21392k = PendingKeyExchange.f21430c;
            public SingleFieldBuilder<PendingKeyExchange, Builder, PendingKeyExchangeOrBuilder> f21393l;
            public PendingPreKey f21394m = PendingPreKey.f21436c;
            public SingleFieldBuilder<PendingPreKey, Builder, PendingPreKeyOrBuilder> f21395n;
            private int f21396o;
            private int f21397p;
            public boolean f21398q;
            private ByteString f21399r = ByteString.f20600a;

            public final com.google.protobuf.AbstractMessage mo878v() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.f21438c;
                r0 = r1;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.v():com.google.protobuf.AbstractMessage");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(com.google.protobuf.AbstractMessage r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22082d(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(com.google.protobuf.AbstractMessage):com.google.protobuf.AbstractMessage$Builder");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22083d(r2, r3);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessage$Builder");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22086y();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.b():com.google.protobuf.AbstractMessage$Builder");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22083d(r2, r3);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.b(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22086y();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.c():com.google.protobuf.AbstractMessageLite$Builder");
            }

            public final /* synthetic */ com.google.protobuf.Message$Builder mo849c(com.google.protobuf.AbstractMessage r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22082d(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.c(com.google.protobuf.AbstractMessage):com.google.protobuf.Message$Builder");
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22083d(r2, r3);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.c(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder");
            }

            public final /* synthetic */ java.lang.Object clone() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22086y();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.clone():java.lang.Object");
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22086y();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.f():com.google.protobuf.GeneratedMessage$Builder");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage mo874h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22117m();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.h():com.google.protobuf.AbstractMessage");
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage mo875i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22116l();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.i():com.google.protobuf.AbstractMessage");
            }

            public final /* synthetic */ com.google.protobuf.MessageLite mo876j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22117m();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.j():com.google.protobuf.MessageLite");
            }

            public final /* synthetic */ com.google.protobuf.MessageLite mo877k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22116l();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.k():com.google.protobuf.MessageLite");
            }

            protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo872d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.f21453b;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.class;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.class;
                r0 = r0.m21368a(r1, r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.d():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
            }

            private Builder() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.<init>();
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21384c = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21385d = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21386e = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21420c;
                r0 = r1;
                r2.f21388g = r0;
                r0 = java.util.Collections.emptyList();
                r2.f21390i = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21430c;
                r0 = r1;
                r2.f21392k = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21436c;
                r0 = r1;
                r2.f21394m = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21399r = r0;
                r2.m22084w();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.<init>():void");
            }

            public Builder(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.<init>(r3);
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21384c = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21385d = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21386e = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21420c;
                r0 = r1;
                r2.f21388g = r0;
                r0 = java.util.Collections.emptyList();
                r2.f21390i = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21430c;
                r0 = r1;
                r2.f21392k = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21436c;
                r0 = r1;
                r2.f21394m = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.f21399r = r0;
                r2.m22084w();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.<init>(com.google.protobuf.GeneratedMessage$BuilderParent):void");
            }

            private void m22084w() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r0 = com.google.protobuf.GeneratedMessage.f20638b;
                if (r0 == 0) goto L_0x0052;
            L_0x0004:
                r1 = r6.f21389h;
                if (r1 != 0) goto L_0x001b;
            L_0x0008:
                r1 = new com.google.protobuf.SingleFieldBuilder;
                r2 = r6.f21388g;
                r3 = r6.m20311s();
                r5 = r6.f20619c;
                r4 = r5;
                r1.<init>(r2, r3, r4);
                r6.f21389h = r1;
                r1 = 0;
                r6.f21388g = r1;
            L_0x001b:
                r1 = r6.f21389h;
                r6.m22081C();
                r1 = r6.f21393l;
                if (r1 != 0) goto L_0x0037;
            L_0x0024:
                r1 = new com.google.protobuf.SingleFieldBuilder;
                r2 = r6.f21392k;
                r3 = r6.m20311s();
                r5 = r6.f20619c;
                r4 = r5;
                r1.<init>(r2, r3, r4);
                r6.f21393l = r1;
                r1 = 0;
                r6.f21392k = r1;
            L_0x0037:
                r1 = r6.f21393l;
                r1 = r6.f21395n;
                if (r1 != 0) goto L_0x0050;
            L_0x003d:
                r1 = new com.google.protobuf.SingleFieldBuilder;
                r2 = r6.f21394m;
                r3 = r6.m20311s();
                r5 = r6.f20619c;
                r4 = r5;
                r1.<init>(r2, r3, r4);
                r6.f21395n = r1;
                r1 = 0;
                r6.f21394m = r1;
            L_0x0050:
                r1 = r6.f21395n;
            L_0x0052:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.w():void");
            }

            public static Builder m22085x() {
                return new Builder();
            }

            private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22086y() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = m22085x();
                r1 = r2.m22117m();
                r0 = r0.m22094a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.y():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final com.google.protobuf.Descriptors.Descriptor mo841e() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.f21452a;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.e():com.google.protobuf.Descriptors$Descriptor");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure m22116l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.m22117m();
                r1 = r0.mo854a();
                if (r1 != 0) goto L_0x000f;
            L_0x000a:
                r0 = com.google.protobuf.AbstractMessage.Builder.m20123b(r0);
                throw r0;
            L_0x000f:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.l():org.whispersystems.libsignal.state.StorageProtos$SessionStructure");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure m22117m() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r0 = 1;
                r1 = 0;
                r2 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure;
                r2.<init>(r5);
                r3 = r5.f21382a;
                r4 = r3 & 1;
                if (r4 != r0) goto L_0x00f1;
            L_0x000d:
                r1 = r5.f21383b;
                r2.sessionVersion_ = r1;
                r1 = r3 & 2;
                r4 = 2;
                if (r1 != r4) goto L_0x0018;
            L_0x0016:
                r0 = r0 | 2;
            L_0x0018:
                r1 = r5.f21384c;
                r2.localIdentityPublic_ = r1;
                r1 = r3 & 4;
                r4 = 4;
                if (r1 != r4) goto L_0x0023;
            L_0x0021:
                r0 = r0 | 4;
            L_0x0023:
                r1 = r5.f21385d;
                r2.remoteIdentityPublic_ = r1;
                r1 = r3 & 8;
                r4 = 8;
                if (r1 != r4) goto L_0x002f;
            L_0x002d:
                r0 = r0 | 8;
            L_0x002f:
                r1 = r5.f21386e;
                r2.rootKey_ = r1;
                r1 = r3 & 16;
                r4 = 16;
                if (r1 != r4) goto L_0x003b;
            L_0x0039:
                r0 = r0 | 16;
            L_0x003b:
                r1 = r5.f21387f;
                r2.previousCounter_ = r1;
                r1 = r3 & 32;
                r4 = 32;
                if (r1 != r4) goto L_0x00ee;
            L_0x0045:
                r0 = r0 | 32;
                r1 = r0;
            L_0x0048:
                r0 = r5.f21389h;
                if (r0 != 0) goto L_0x00c4;
            L_0x004c:
                r0 = r5.f21388g;
                r2.senderChain_ = r0;
            L_0x0050:
                r0 = r5.f21391j;
                if (r0 != 0) goto L_0x00cf;
            L_0x0054:
                r0 = r5.f21382a;
                r0 = r0 & 64;
                r4 = 64;
                if (r0 != r4) goto L_0x006a;
            L_0x005c:
                r0 = r5.f21390i;
                r0 = java.util.Collections.unmodifiableList(r0);
                r5.f21390i = r0;
                r0 = r5.f21382a;
                r0 = r0 & -65;
                r5.f21382a = r0;
            L_0x006a:
                r0 = r5.f21390i;
                r2.receiverChains_ = r0;
            L_0x006e:
                r0 = r3 & 128;
                r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                if (r0 != r4) goto L_0x0076;
            L_0x0074:
                r1 = r1 | 64;
            L_0x0076:
                r0 = r5.f21393l;
                if (r0 != 0) goto L_0x00d8;
            L_0x007a:
                r0 = r5.f21392k;
                r2.pendingKeyExchange_ = r0;
            L_0x007e:
                r0 = r3 & 256;
                r4 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                if (r0 != r4) goto L_0x0086;
            L_0x0084:
                r1 = r1 | 128;
            L_0x0086:
                r0 = r5.f21395n;
                if (r0 != 0) goto L_0x00e3;
            L_0x008a:
                r0 = r5.f21394m;
                r2.pendingPreKey_ = r0;
            L_0x008e:
                r0 = r3 & 512;
                r4 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
                if (r0 != r4) goto L_0x0096;
            L_0x0094:
                r1 = r1 | 256;
            L_0x0096:
                r0 = r5.f21396o;
                r2.remoteRegistrationId_ = r0;
                r0 = r3 & 1024;
                r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
                if (r0 != r4) goto L_0x00a2;
            L_0x00a0:
                r1 = r1 | 512;
            L_0x00a2:
                r0 = r5.f21397p;
                r2.localRegistrationId_ = r0;
                r0 = r3 & 2048;
                r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                if (r0 != r4) goto L_0x00ae;
            L_0x00ac:
                r1 = r1 | 1024;
            L_0x00ae:
                r0 = r5.f21398q;
                r2.needsRefresh_ = r0;
                r0 = r3 & 4096;
                r3 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
                if (r0 != r3) goto L_0x00ba;
            L_0x00b8:
                r1 = r1 | 2048;
            L_0x00ba:
                r0 = r5.f21399r;
                r2.aliceBaseKey_ = r0;
                r2.bitField0_ = r1;
                r5.m20309p();
                return r2;
            L_0x00c4:
                r0 = r5.f21389h;
                r0 = r0.m21442d();
                r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain) r0;
                r2.senderChain_ = r0;
                goto L_0x0050;
            L_0x00cf:
                r0 = r5.f21391j;
                r0 = r0.m21416f();
                r2.receiverChains_ = r0;
                goto L_0x006e;
            L_0x00d8:
                r0 = r5.f21393l;
                r0 = r0.m21442d();
                r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange) r0;
                r2.pendingKeyExchange_ = r0;
                goto L_0x007e;
            L_0x00e3:
                r0 = r5.f21395n;
                r0 = r0.m21442d();
                r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey) r0;
                r2.pendingPreKey_ = r0;
                goto L_0x008e;
            L_0x00ee:
                r1 = r0;
                goto L_0x0048;
            L_0x00f1:
                r0 = r1;
                goto L_0x000d;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.m():org.whispersystems.libsignal.state.StorageProtos$SessionStructure");
            }

            private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22082d(com.google.protobuf.AbstractMessage r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r2 instanceof org.whispersystems.libsignal.state.StorageProtos.SessionStructure;
                if (r0 == 0) goto L_0x000b;
            L_0x0004:
                r2 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure) r2;
                r1 = r1.m22094a(r2);
            L_0x000a:
                return r1;
            L_0x000b:
                super.mo870a(r2);
                goto L_0x000a;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.d(com.google.protobuf.AbstractMessage):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22094a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r0 = 0;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.f21438c;
                r1 = r2;
                if (r6 != r1) goto L_0x0007;
            L_0x0006:
                return r5;
            L_0x0007:
                r2 = 1;
                r3 = r6.bitField0_;
                r3 = r3 & 1;
                if (r3 != r2) goto L_0x01b9;
            L_0x000e:
                r1 = r2;
                if (r1 == 0) goto L_0x0017;
            L_0x0011:
                r2 = r6.sessionVersion_;
                r1 = r2;
                r5.m22089a(r1);
            L_0x0017:
                r2 = r6.bitField0_;
                r2 = r2 & 2;
                r3 = 2;
                if (r2 != r3) goto L_0x01bc;
            L_0x001e:
                r2 = 1;
            L_0x001f:
                r1 = r2;
                if (r1 == 0) goto L_0x0028;
            L_0x0022:
                r2 = r6.localIdentityPublic_;
                r1 = r2;
                r5.m22091a(r1);
            L_0x0028:
                r1 = r6.m22351o();
                if (r1 == 0) goto L_0x0034;
            L_0x002e:
                r2 = r6.remoteIdentityPublic_;
                r1 = r2;
                r5.m22099b(r1);
            L_0x0034:
                r2 = r6.bitField0_;
                r2 = r2 & 8;
                r3 = 8;
                if (r2 != r3) goto L_0x01bf;
            L_0x003c:
                r2 = 1;
            L_0x003d:
                r1 = r2;
                if (r1 == 0) goto L_0x0046;
            L_0x0040:
                r2 = r6.rootKey_;
                r1 = r2;
                r5.m22105c(r1);
            L_0x0046:
                r2 = r6.bitField0_;
                r2 = r2 & 16;
                r3 = 16;
                if (r2 != r3) goto L_0x01c2;
            L_0x004e:
                r2 = 1;
            L_0x004f:
                r1 = r2;
                if (r1 == 0) goto L_0x0058;
            L_0x0052:
                r2 = r6.previousCounter_;
                r1 = r2;
                r5.m22098b(r1);
            L_0x0058:
                r1 = r6.m22357y();
                if (r1 == 0) goto L_0x008d;
            L_0x005e:
                r2 = r6.senderChain_;
                r1 = r2;
                r2 = r5.f21389h;
                if (r2 != 0) goto L_0x01c9;
            L_0x0065:
                r2 = r5.f21382a;
                r2 = r2 & 32;
                r3 = 32;
                if (r2 != r3) goto L_0x01c5;
            L_0x006d:
                r2 = r5.f21388g;
                r4 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21420c;
                r3 = r4;
                if (r2 == r3) goto L_0x01c5;
            L_0x0074:
                r2 = r5.f21388g;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.m22233a(r2);
                r2 = r2.m22134a(r1);
                r2 = r2.m22150m();
                r5.f21388g = r2;
            L_0x0084:
                r5.m20312t();
            L_0x0087:
                r2 = r5.f21382a;
                r2 = r2 | 32;
                r5.f21382a = r2;
            L_0x008d:
                r1 = r5.f21391j;
                if (r1 != 0) goto L_0x0183;
            L_0x0091:
                r0 = r6.receiverChains_;
                r0 = r0.isEmpty();
                if (r0 != 0) goto L_0x00ae;
            L_0x0099:
                r0 = r5.f21390i;
                r0 = r0.isEmpty();
                if (r0 == 0) goto L_0x0177;
            L_0x00a1:
                r0 = r6.receiverChains_;
                r5.f21390i = r0;
                r0 = r5.f21382a;
                r0 = r0 & -65;
                r5.f21382a = r0;
            L_0x00ab:
                r5.m20312t();
            L_0x00ae:
                r2 = r6.bitField0_;
                r2 = r2 & 64;
                r3 = 64;
                if (r2 != r3) goto L_0x01d0;
            L_0x00b6:
                r2 = 1;
            L_0x00b7:
                r0 = r2;
                if (r0 == 0) goto L_0x00e9;
            L_0x00ba:
                r2 = r6.pendingKeyExchange_;
                r0 = r2;
                r2 = r5.f21393l;
                if (r2 != 0) goto L_0x01d7;
            L_0x00c1:
                r2 = r5.f21382a;
                r2 = r2 & 128;
                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                if (r2 != r3) goto L_0x01d3;
            L_0x00c9:
                r2 = r5.f21392k;
                r4 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21430c;
                r3 = r4;
                if (r2 == r3) goto L_0x01d3;
            L_0x00d0:
                r2 = r5.f21392k;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.m22279a(r2);
                r2 = r2.m22262a(r0);
                r2 = r2.m22276l();
                r5.f21392k = r2;
            L_0x00e0:
                r5.m20312t();
            L_0x00e3:
                r2 = r5.f21382a;
                r2 = r2 | 128;
                r5.f21382a = r2;
            L_0x00e9:
                r0 = r6.m22340D();
                if (r0 == 0) goto L_0x011e;
            L_0x00ef:
                r2 = r6.pendingPreKey_;
                r0 = r2;
                r2 = r5.f21395n;
                if (r2 != 0) goto L_0x01e2;
            L_0x00f6:
                r2 = r5.f21382a;
                r2 = r2 & 256;
                r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                if (r2 != r3) goto L_0x01de;
            L_0x00fe:
                r2 = r5.f21394m;
                r4 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21436c;
                r3 = r4;
                if (r2 == r3) goto L_0x01de;
            L_0x0105:
                r2 = r5.f21394m;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.m22319a(r2);
                r2 = r2.m22301a(r0);
                r2 = r2.m22317m();
                r5.f21394m = r2;
            L_0x0115:
                r5.m20312t();
            L_0x0118:
                r2 = r5.f21382a;
                r2 = r2 | 256;
                r5.f21382a = r2;
            L_0x011e:
                r2 = r6.bitField0_;
                r2 = r2 & 256;
                r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                if (r2 != r3) goto L_0x01e9;
            L_0x0126:
                r2 = 1;
            L_0x0127:
                r0 = r2;
                if (r0 == 0) goto L_0x0130;
            L_0x012a:
                r2 = r6.remoteRegistrationId_;
                r0 = r2;
                r5.m22107d(r0);
            L_0x0130:
                r2 = r6.bitField0_;
                r2 = r2 & 512;
                r3 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
                if (r2 != r3) goto L_0x01ec;
            L_0x0138:
                r2 = 1;
            L_0x0139:
                r0 = r2;
                if (r0 == 0) goto L_0x0142;
            L_0x013c:
                r2 = r6.localRegistrationId_;
                r0 = r2;
                r5.m22110e(r0);
            L_0x0142:
                r2 = r6.bitField0_;
                r2 = r2 & 1024;
                r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
                if (r2 != r3) goto L_0x01ef;
            L_0x014a:
                r2 = 1;
            L_0x014b:
                r0 = r2;
                if (r0 == 0) goto L_0x015c;
            L_0x014e:
                r2 = r6.needsRefresh_;
                r0 = r2;
                r2 = r5.f21382a;
                r2 = r2 | 2048;
                r5.f21382a = r2;
                r5.f21398q = r0;
                r5.m20312t();
            L_0x015c:
                r2 = r6.bitField0_;
                r2 = r2 & 2048;
                r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                if (r2 != r3) goto L_0x01f2;
            L_0x0164:
                r2 = 1;
            L_0x0165:
                r0 = r2;
                if (r0 == 0) goto L_0x016e;
            L_0x0168:
                r2 = r6.aliceBaseKey_;
                r0 = r2;
                r5.m22108d(r0);
            L_0x016e:
                r0 = r6.mo868g();
                r5.m20301c(r0);
                goto L_0x0006;
            L_0x0177:
                r5.m22080B();
                r0 = r5.f21390i;
                r1 = r6.receiverChains_;
                r0.addAll(r1);
                goto L_0x00ab;
            L_0x0183:
                r1 = r6.receiverChains_;
                r1 = r1.isEmpty();
                if (r1 != 0) goto L_0x00ae;
            L_0x018b:
                r1 = r5.f21391j;
                r1 = r1.m21414d();
                if (r1 == 0) goto L_0x01b0;
            L_0x0193:
                r1 = r5.f21391j;
                r1.m21411b();
                r5.f21391j = r0;
                r1 = r6.receiverChains_;
                r5.f21390i = r1;
                r1 = r5.f21382a;
                r1 = r1 & -65;
                r5.f21382a = r1;
                r1 = com.google.protobuf.GeneratedMessage.f20638b;
                if (r1 == 0) goto L_0x01ac;
            L_0x01a8:
                r0 = r5.m22081C();
            L_0x01ac:
                r5.f21391j = r0;
                goto L_0x00ae;
            L_0x01b0:
                r0 = r5.f21391j;
                r1 = r6.receiverChains_;
                r0.m21409a(r1);
                goto L_0x00ae;
            L_0x01b9:
                r2 = 0;
                goto L_0x000e;
            L_0x01bc:
                r2 = 0;
                goto L_0x001f;
            L_0x01bf:
                r2 = 0;
                goto L_0x003d;
            L_0x01c2:
                r2 = 0;
                goto L_0x004f;
            L_0x01c5:
                r5.f21388g = r1;
                goto L_0x0084;
            L_0x01c9:
                r2 = r5.f21389h;
                r2.m21439b(r1);
                goto L_0x0087;
            L_0x01d0:
                r2 = 0;
                goto L_0x00b7;
            L_0x01d3:
                r5.f21392k = r0;
                goto L_0x00e0;
            L_0x01d7:
                r2 = r5.f21393l;
                r2.m21439b(r0);
                goto L_0x00e3;
            L_0x01de:
                r5.f21394m = r0;
                goto L_0x0115;
            L_0x01e2:
                r2 = r5.f21395n;
                r2.m21439b(r0);
                goto L_0x0118;
            L_0x01e9:
                r2 = 0;
                goto L_0x0127;
            L_0x01ec:
                r2 = 0;
                goto L_0x0139;
            L_0x01ef:
                r2 = 0;
                goto L_0x014b;
            L_0x01f2:
                r2 = 0;
                goto L_0x0165;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final boolean mo854a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a():boolean");
            }

            private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22083d(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r2 = 0;
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.f21437a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                r0 = r0.mo859a(r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                if (r0 == 0) goto L_0x000e;
            L_0x000b:
                r4.m22094a(r0);
            L_0x000e:
                return r4;
            L_0x000f:
                r0 = move-exception;
                r1 = r0;
                r0 = r1.m21375a();	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                throw r1;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
            L_0x0018:
                r1 = move-exception;
                r3 = r1;
                r1 = r0;
                r0 = r3;
            L_0x001c:
                if (r1 == 0) goto L_0x0021;
            L_0x001e:
                r4.m22094a(r1);
            L_0x0021:
                throw r0;
            L_0x0022:
                r0 = move-exception;
                r1 = r2;
                goto L_0x001c;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.d(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22089a(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21382a;
                r0 = r0 | 1;
                r1.f21382a = r0;
                r1.f21383b = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22091a(com.google.protobuf.ByteString r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                if (r2 != 0) goto L_0x0008;
            L_0x0002:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x0008:
                r0 = r1.f21382a;
                r0 = r0 | 2;
                r1.f21382a = r0;
                r1.f21384c = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22099b(com.google.protobuf.ByteString r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                if (r2 != 0) goto L_0x0008;
            L_0x0002:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x0008:
                r0 = r1.f21382a;
                r0 = r0 | 4;
                r1.f21382a = r0;
                r1.f21385d = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.b(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22105c(com.google.protobuf.ByteString r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                if (r2 != 0) goto L_0x0008;
            L_0x0002:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x0008:
                r0 = r1.f21382a;
                r0 = r0 | 8;
                r1.f21382a = r0;
                r1.f21386e = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.c(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22098b(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21382a;
                r0 = r0 | 16;
                r1.f21382a = r0;
                r1.f21387f = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.b(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22092a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21389h;
                if (r0 != 0) goto L_0x0018;
            L_0x0004:
                if (r2 != 0) goto L_0x000c;
            L_0x0006:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x000c:
                r1.f21388g = r2;
                r1.m20312t();
            L_0x0011:
                r0 = r1.f21382a;
                r0 = r0 | 32;
                r1.f21382a = r0;
                return r1;
            L_0x0018:
                r0 = r1.f21389h;
                r0.m21437a(r2);
                goto L_0x0011;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            private void m22080B() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f21382a;
                r0 = r0 & 64;
                r1 = 64;
                if (r0 == r1) goto L_0x0017;
            L_0x0008:
                r0 = new java.util.ArrayList;
                r1 = r2.f21390i;
                r0.<init>(r1);
                r2.f21390i = r0;
                r0 = r2.f21382a;
                r0 = r0 | 64;
                r2.f21382a = r0;
            L_0x0017:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.B():void");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22090a(int r2, org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21391j;
                if (r0 != 0) goto L_0x0018;
            L_0x0004:
                if (r3 != 0) goto L_0x000c;
            L_0x0006:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x000c:
                r1.m22080B();
                r0 = r1.f21390i;
                r0.set(r2, r3);
                r1.m20312t();
            L_0x0017:
                return r1;
            L_0x0018:
                r0 = r1.f21391j;
                r0.m21407a(r2, r3);
                goto L_0x0017;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(int, org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22100b(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21391j;
                if (r0 != 0) goto L_0x0018;
            L_0x0004:
                if (r2 != 0) goto L_0x000c;
            L_0x0006:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x000c:
                r1.m22080B();
                r0 = r1.f21390i;
                r0.add(r2);
                r1.m20312t();
            L_0x0017:
                return r1;
            L_0x0018:
                r0 = r1.f21391j;
                r0.m21408a(r2);
                goto L_0x0017;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.b(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22104c(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21391j;
                if (r0 != 0) goto L_0x0010;
            L_0x0004:
                r1.m22080B();
                r0 = r1.f21390i;
                r0.remove(r2);
                r1.m20312t();
            L_0x000f:
                return r1;
            L_0x0010:
                r0 = r1.f21391j;
                r0.m21413d(r2);
                goto L_0x000f;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.c(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            private com.google.protobuf.RepeatedFieldBuilder<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain, org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder, org.whispersystems.libsignal.state.StorageProtos.SessionStructure.ChainOrBuilder> m22081C() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r0 = r6.f21391j;
                if (r0 != 0) goto L_0x0020;
            L_0x0004:
                r1 = new com.google.protobuf.RepeatedFieldBuilder;
                r2 = r6.f21390i;
                r0 = r6.f21382a;
                r0 = r0 & 64;
                r3 = 64;
                if (r0 != r3) goto L_0x0023;
            L_0x0010:
                r0 = 1;
            L_0x0011:
                r3 = r6.m20311s();
                r5 = r6.f20619c;
                r4 = r5;
                r1.<init>(r2, r0, r3, r4);
                r6.f21391j = r1;
                r0 = 0;
                r6.f21390i = r0;
            L_0x0020:
                r0 = r6.f21391j;
                return r0;
            L_0x0023:
                r0 = 0;
                goto L_0x0011;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.C():com.google.protobuf.RepeatedFieldBuilder<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain, org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder, org.whispersystems.libsignal.state.StorageProtos$SessionStructure$ChainOrBuilder>");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22093a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21395n;
                if (r0 != 0) goto L_0x0018;
            L_0x0004:
                if (r2 != 0) goto L_0x000c;
            L_0x0006:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x000c:
                r1.f21394m = r2;
                r1.m20312t();
            L_0x0011:
                r0 = r1.f21382a;
                r0 = r0 | 256;
                r1.f21382a = r0;
                return r1;
            L_0x0018:
                r0 = r1.f21395n;
                r0.m21437a(r2);
                goto L_0x0011;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22107d(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21382a;
                r0 = r0 | 512;
                r1.f21382a = r0;
                r1.f21396o = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.d(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22110e(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f21382a;
                r0 = r0 | 1024;
                r1.f21382a = r0;
                r1.f21397p = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.e(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22108d(com.google.protobuf.ByteString r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                if (r2 != 0) goto L_0x0008;
            L_0x0002:
                r0 = new java.lang.NullPointerException;
                r0.<init>();
                throw r0;
            L_0x0008:
                r0 = r1.f21382a;
                r0 = r0 | 4096;
                r1.f21382a = r0;
                r1.f21399r = r2;
                r1.m20312t();
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.d(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
            }
        }

        public interface ChainOrBuilder extends MessageOrBuilder {
        }

        /* compiled from: actionId */
        public final class Chain extends GeneratedMessage implements ChainOrBuilder {
            public static Parser<Chain> f21419a = new C24691();
            public static final Chain f21420c;
            public int bitField0_;
            public ChainKey chainKey_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            public List<MessageKey> messageKeys_;
            public ByteString senderRatchetKeyPrivate_;
            public ByteString senderRatchetKey_;
            private final UnknownFieldSet unknownFields;

            /* compiled from: actionId */
            final class C24691 extends AbstractParser<Chain> {
                C24691() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.1.<init>():void");
                }

                public final java.lang.Object mo859a(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain;
                    r1 = 0;
                    r0.<init>(r3, r4);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.1.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object");
                }
            }

            /* compiled from: actionId */
            public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements ChainOrBuilder {
                public int f21400a;
                private ByteString f21401b = ByteString.f20600a;
                private ByteString f21402c = ByteString.f20600a;
                public ChainKey f21403d = ChainKey.f21411c;
                public SingleFieldBuilder<ChainKey, Builder, ChainKeyOrBuilder> f21404e;
                public List<MessageKey> f21405f = Collections.emptyList();
                public RepeatedFieldBuilder<MessageKey, Builder, MessageKeyOrBuilder> f21406g;

                public final com.google.protobuf.AbstractMessage mo878v() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21420c;
                    r0 = r1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.v():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22122d(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(com.google.protobuf.AbstractMessage):com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22123d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22126z();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.b():com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22123d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.b(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22126z();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.c():com.google.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ com.google.protobuf.Message$Builder mo849c(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22122d(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.c(com.google.protobuf.AbstractMessage):com.google.protobuf.Message$Builder");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22123d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.c(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder");
                }

                public final /* synthetic */ java.lang.Object clone() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22126z();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.clone():java.lang.Object");
                }

                public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22126z();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.f():com.google.protobuf.GeneratedMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage mo874h() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22150m();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.h():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage mo875i() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22149l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.i():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite mo876j() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22150m();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.j():com.google.protobuf.MessageLite");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite mo877k() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22149l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.k():com.google.protobuf.MessageLite");
                }

                protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo872d() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21455d;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.class;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.class;
                    r0 = r0.m21368a(r1, r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.d():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                }

                private Builder() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.<init>();
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21401b = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21402c = r0;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21411c;
                    r0 = r1;
                    r2.f21403d = r0;
                    r0 = java.util.Collections.emptyList();
                    r2.f21405f = r0;
                    r2.m22124x();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.<init>():void");
                }

                public Builder(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.<init>(r3);
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21401b = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21402c = r0;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21411c;
                    r0 = r1;
                    r2.f21403d = r0;
                    r0 = java.util.Collections.emptyList();
                    r2.f21405f = r0;
                    r2.m22124x();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.<init>(com.google.protobuf.GeneratedMessage$BuilderParent):void");
                }

                private void m22124x() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r0 = com.google.protobuf.GeneratedMessage.f20638b;
                    if (r0 == 0) goto L_0x0020;
                L_0x0004:
                    r1 = r6.f21404e;
                    if (r1 != 0) goto L_0x001b;
                L_0x0008:
                    r1 = new com.google.protobuf.SingleFieldBuilder;
                    r2 = r6.f21403d;
                    r3 = r6.m20311s();
                    r5 = r6.f20619c;
                    r4 = r5;
                    r1.<init>(r2, r3, r4);
                    r6.f21404e = r1;
                    r1 = 0;
                    r6.f21403d = r1;
                L_0x001b:
                    r1 = r6.f21404e;
                    r6.m22121D();
                L_0x0020:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.x():void");
                }

                public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22125y() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder;
                    r0.<init>();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.y():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22126z() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = m22125y();
                    r1 = r2.m22150m();
                    r0 = r0.m22134a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.z():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final com.google.protobuf.Descriptors.Descriptor mo841e() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21454c;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.e():com.google.protobuf.Descriptors$Descriptor");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain m22149l() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.m22150m();
                    r1 = r0.mo854a();
                    if (r1 != 0) goto L_0x000f;
                L_0x000a:
                    r0 = com.google.protobuf.AbstractMessage.Builder.m20123b(r0);
                    throw r0;
                L_0x000f:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.l():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain m22150m() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = 1;
                    r1 = 0;
                    r2 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain;
                    r2.<init>(r5);
                    r3 = r5.f21400a;
                    r4 = r3 & 1;
                    if (r4 != r0) goto L_0x0066;
                L_0x000d:
                    r1 = r5.f21401b;
                    r2.senderRatchetKey_ = r1;
                    r1 = r3 & 2;
                    r4 = 2;
                    if (r1 != r4) goto L_0x0018;
                L_0x0016:
                    r0 = r0 | 2;
                L_0x0018:
                    r1 = r5.f21402c;
                    r2.senderRatchetKeyPrivate_ = r1;
                    r1 = r3 & 4;
                    r3 = 4;
                    if (r1 != r3) goto L_0x0064;
                L_0x0021:
                    r0 = r0 | 4;
                    r1 = r0;
                L_0x0024:
                    r0 = r5.f21404e;
                    if (r0 != 0) goto L_0x0050;
                L_0x0028:
                    r0 = r5.f21403d;
                    r2.chainKey_ = r0;
                L_0x002c:
                    r0 = r5.f21406g;
                    if (r0 != 0) goto L_0x005b;
                L_0x0030:
                    r0 = r5.f21400a;
                    r0 = r0 & 8;
                    r3 = 8;
                    if (r0 != r3) goto L_0x0046;
                L_0x0038:
                    r0 = r5.f21405f;
                    r0 = java.util.Collections.unmodifiableList(r0);
                    r5.f21405f = r0;
                    r0 = r5.f21400a;
                    r0 = r0 & -9;
                    r5.f21400a = r0;
                L_0x0046:
                    r0 = r5.f21405f;
                    r2.messageKeys_ = r0;
                L_0x004a:
                    r2.bitField0_ = r1;
                    r5.m20309p();
                    return r2;
                L_0x0050:
                    r0 = r5.f21404e;
                    r0 = r0.m21442d();
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey) r0;
                    r2.chainKey_ = r0;
                    goto L_0x002c;
                L_0x005b:
                    r0 = r5.f21406g;
                    r0 = r0.m21416f();
                    r2.messageKeys_ = r0;
                    goto L_0x004a;
                L_0x0064:
                    r1 = r0;
                    goto L_0x0024;
                L_0x0066:
                    r0 = r1;
                    goto L_0x000d;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.m():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22122d(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r2 instanceof org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain;
                    if (r0 == 0) goto L_0x000b;
                L_0x0004:
                    r2 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain) r2;
                    r1 = r1.m22134a(r2);
                L_0x000a:
                    return r1;
                L_0x000b:
                    super.mo870a(r2);
                    goto L_0x000a;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.d(com.google.protobuf.AbstractMessage):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22134a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain r6) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = 0;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21420c;
                    r1 = r2;
                    if (r6 != r1) goto L_0x0007;
                L_0x0006:
                    return r5;
                L_0x0007:
                    r2 = 1;
                    r3 = r6.bitField0_;
                    r3 = r3 & 1;
                    if (r3 != r2) goto L_0x00ca;
                L_0x000e:
                    r1 = r2;
                    if (r1 == 0) goto L_0x0017;
                L_0x0011:
                    r2 = r6.senderRatchetKey_;
                    r1 = r2;
                    r5.m22130a(r1);
                L_0x0017:
                    r2 = r6.bitField0_;
                    r2 = r2 & 2;
                    r3 = 2;
                    if (r2 != r3) goto L_0x00cd;
                L_0x001e:
                    r2 = 1;
                L_0x001f:
                    r1 = r2;
                    if (r1 == 0) goto L_0x0028;
                L_0x0022:
                    r2 = r6.senderRatchetKeyPrivate_;
                    r1 = r2;
                    r5.m22138b(r1);
                L_0x0028:
                    r2 = r6.bitField0_;
                    r2 = r2 & 4;
                    r3 = 4;
                    if (r2 != r3) goto L_0x00d0;
                L_0x002f:
                    r2 = 1;
                L_0x0030:
                    r1 = r2;
                    if (r1 == 0) goto L_0x0061;
                L_0x0033:
                    r2 = r6.chainKey_;
                    r1 = r2;
                    r2 = r5.f21404e;
                    if (r2 != 0) goto L_0x00d6;
                L_0x003a:
                    r2 = r5.f21400a;
                    r2 = r2 & 4;
                    r3 = 4;
                    if (r2 != r3) goto L_0x00d3;
                L_0x0041:
                    r2 = r5.f21403d;
                    r4 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21411c;
                    r3 = r4;
                    if (r2 == r3) goto L_0x00d3;
                L_0x0048:
                    r2 = r5.f21403d;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.m22178a(r2);
                    r2 = r2.m22161a(r1);
                    r2 = r2.m22176m();
                    r5.f21403d = r2;
                L_0x0058:
                    r5.m20312t();
                L_0x005b:
                    r2 = r5.f21400a;
                    r2 = r2 | 4;
                    r5.f21400a = r2;
                L_0x0061:
                    r1 = r5.f21406g;
                    if (r1 != 0) goto L_0x0096;
                L_0x0065:
                    r0 = r6.messageKeys_;
                    r0 = r0.isEmpty();
                    if (r0 != 0) goto L_0x0082;
                L_0x006d:
                    r0 = r5.f21405f;
                    r0 = r0.isEmpty();
                    if (r0 == 0) goto L_0x008b;
                L_0x0075:
                    r0 = r6.messageKeys_;
                    r5.f21405f = r0;
                    r0 = r5.f21400a;
                    r0 = r0 & -9;
                    r5.f21400a = r0;
                L_0x007f:
                    r5.m20312t();
                L_0x0082:
                    r0 = r6.mo868g();
                    r5.m20301c(r0);
                    goto L_0x0006;
                L_0x008b:
                    r5.m22120C();
                    r0 = r5.f21405f;
                    r1 = r6.messageKeys_;
                    r0.addAll(r1);
                    goto L_0x007f;
                L_0x0096:
                    r1 = r6.messageKeys_;
                    r1 = r1.isEmpty();
                    if (r1 != 0) goto L_0x0082;
                L_0x009e:
                    r1 = r5.f21406g;
                    r1 = r1.m21414d();
                    if (r1 == 0) goto L_0x00c2;
                L_0x00a6:
                    r1 = r5.f21406g;
                    r1.m21411b();
                    r5.f21406g = r0;
                    r1 = r6.messageKeys_;
                    r5.f21405f = r1;
                    r1 = r5.f21400a;
                    r1 = r1 & -9;
                    r5.f21400a = r1;
                    r1 = com.google.protobuf.GeneratedMessage.f20638b;
                    if (r1 == 0) goto L_0x00bf;
                L_0x00bb:
                    r0 = r5.m22121D();
                L_0x00bf:
                    r5.f21406g = r0;
                    goto L_0x0082;
                L_0x00c2:
                    r0 = r5.f21406g;
                    r1 = r6.messageKeys_;
                    r0.m21409a(r1);
                    goto L_0x0082;
                L_0x00ca:
                    r2 = 0;
                    goto L_0x000e;
                L_0x00cd:
                    r2 = 0;
                    goto L_0x001f;
                L_0x00d0:
                    r2 = 0;
                    goto L_0x0030;
                L_0x00d3:
                    r5.f21403d = r1;
                    goto L_0x0058;
                L_0x00d6:
                    r2 = r5.f21404e;
                    r2.m21439b(r1);
                    goto L_0x005b;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final boolean mo854a() {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a():boolean");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22123d(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r2 = 0;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21419a;	 Catch:{ InvalidProtocolBufferException -> 0x000f }
                    r0 = r0.mo859a(r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x000f }
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f }
                    if (r0 == 0) goto L_0x000e;
                L_0x000b:
                    r4.m22134a(r0);
                L_0x000e:
                    return r4;
                L_0x000f:
                    r0 = move-exception;
                    r1 = r0;
                    r0 = r1.m21375a();	 Catch:{ all -> 0x0022 }
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain) r0;	 Catch:{ all -> 0x0022 }
                    throw r1;	 Catch:{ all -> 0x0018 }
                L_0x0018:
                    r1 = move-exception;
                    r3 = r1;
                    r1 = r0;
                    r0 = r3;
                L_0x001c:
                    if (r1 == 0) goto L_0x0021;
                L_0x001e:
                    r4.m22134a(r1);
                L_0x0021:
                    throw r0;
                L_0x0022:
                    r0 = move-exception;
                    r1 = r2;
                    goto L_0x001c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.d(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22130a(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21400a;
                    r0 = r0 | 1;
                    r1.f21400a = r0;
                    r1.f21401b = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22138b(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException
	at java.util.Collections$UnmodifiableCollection.clear(Collections.java:1074)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.markReturnBlocks(BlockProcessor.java:183)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:49)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21400a;
                    r0 = r0 | 2;
                    r1.f21400a = r0;
                    r1.f21402c = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.b(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22132a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f21404e;
                    if (r0 != 0) goto L_0x0018;
                L_0x0004:
                    if (r2 != 0) goto L_0x000c;
                L_0x0006:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x000c:
                    r1.f21403d = r2;
                    r1.m20312t();
                L_0x0011:
                    r0 = r1.f21400a;
                    r0 = r0 | 4;
                    r1.f21400a = r0;
                    return r1;
                L_0x0018:
                    r0 = r1.f21404e;
                    r0.m21437a(r2);
                    goto L_0x0011;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                private void m22120C() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f21400a;
                    r0 = r0 & 8;
                    r1 = 8;
                    if (r0 == r1) goto L_0x0017;
                L_0x0008:
                    r0 = new java.util.ArrayList;
                    r1 = r2.f21405f;
                    r0.<init>(r1);
                    r2.f21405f = r0;
                    r0 = r2.f21400a;
                    r0 = r0 | 8;
                    r2.f21400a = r0;
                L_0x0017:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.C():void");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22133a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f21406g;
                    if (r0 != 0) goto L_0x0018;
                L_0x0004:
                    if (r2 != 0) goto L_0x000c;
                L_0x0006:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x000c:
                    r1.m22120C();
                    r0 = r1.f21405f;
                    r0.add(r2);
                    r1.m20312t();
                L_0x0017:
                    return r1;
                L_0x0018:
                    r0 = r1.f21406g;
                    r0.m21408a(r2);
                    goto L_0x0017;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder mo938a(java.lang.Iterable<? extends org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey> r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f21406g;
                    if (r0 != 0) goto L_0x0010;
                L_0x0004:
                    r1.m22120C();
                    r0 = r1.f21405f;
                    com.google.protobuf.AbstractMessageLite.Builder.m20091a(r2, r0);
                    r1.m20312t();
                L_0x000f:
                    return r1;
                L_0x0010:
                    r0 = r1.f21406g;
                    r0.m21409a(r2);
                    goto L_0x000f;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(java.lang.Iterable):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22129a(int r2) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f21406g;
                    if (r0 != 0) goto L_0x0010;
                L_0x0004:
                    r1.m22120C();
                    r0 = r1.f21405f;
                    r0.remove(r2);
                    r1.m20312t();
                L_0x000f:
                    return r1;
                L_0x0010:
                    r0 = r1.f21406g;
                    r0.m21413d(r2);
                    goto L_0x000f;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.a(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
                }

                private com.google.protobuf.RepeatedFieldBuilder<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey, org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder, org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKeyOrBuilder> m22121D() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r0 = r6.f21406g;
                    if (r0 != 0) goto L_0x0020;
                L_0x0004:
                    r1 = new com.google.protobuf.RepeatedFieldBuilder;
                    r2 = r6.f21405f;
                    r0 = r6.f21400a;
                    r0 = r0 & 8;
                    r3 = 8;
                    if (r0 != r3) goto L_0x0023;
                L_0x0010:
                    r0 = 1;
                L_0x0011:
                    r3 = r6.m20311s();
                    r5 = r6.f20619c;
                    r4 = r5;
                    r1.<init>(r2, r0, r3, r4);
                    r6.f21406g = r1;
                    r0 = 0;
                    r6.f21405f = r0;
                L_0x0020:
                    r0 = r6.f21406g;
                    return r0;
                L_0x0023:
                    r0 = 0;
                    goto L_0x0011;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.D():com.google.protobuf.RepeatedFieldBuilder<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey, org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder, org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKeyOrBuilder>");
                }
            }

            public interface ChainKeyOrBuilder extends MessageOrBuilder {
            }

            /* compiled from: actionId */
            public final class ChainKey extends GeneratedMessage implements ChainKeyOrBuilder {
                public static Parser<ChainKey> f21410a = new C24701();
                public static final ChainKey f21411c;
                public int bitField0_;
                public int index_;
                public ByteString key_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private final UnknownFieldSet unknownFields;

                /* compiled from: actionId */
                final class C24701 extends AbstractParser<ChainKey> {
                    C24701() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.1.<init>():void");
                    }

                    public final java.lang.Object mo859a(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey;
                        r1 = 0;
                        r0.<init>(r3, r4);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.1.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object");
                    }
                }

                /* compiled from: actionId */
                public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements ChainKeyOrBuilder {
                    private int f21407a;
                    private int f21408b;
                    private ByteString f21409c = ByteString.f20600a;

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22161a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21411c;
                        r0 = r1;
                        if (r4 != r0) goto L_0x0006;
                    L_0x0005:
                        return r3;
                    L_0x0006:
                        r1 = 1;
                        r2 = r4.bitField0_;
                        r2 = r2 & 1;
                        if (r2 != r1) goto L_0x002f;
                    L_0x000d:
                        r0 = r1;
                        if (r0 == 0) goto L_0x0016;
                    L_0x0010:
                        r1 = r4.index_;
                        r0 = r1;
                        r3.m22159a(r0);
                    L_0x0016:
                        r1 = r4.bitField0_;
                        r1 = r1 & 2;
                        r2 = 2;
                        if (r1 != r2) goto L_0x0031;
                    L_0x001d:
                        r1 = 1;
                    L_0x001e:
                        r0 = r1;
                        if (r0 == 0) goto L_0x0027;
                    L_0x0021:
                        r1 = r4.key_;
                        r0 = r1;
                        r3.m22160a(r0);
                    L_0x0027:
                        r0 = r4.mo868g();
                        r3.m20301c(r0);
                        goto L_0x0005;
                    L_0x002f:
                        r1 = 0;
                        goto L_0x000d;
                    L_0x0031:
                        r1 = 0;
                        goto L_0x001e;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }

                    public final com.google.protobuf.AbstractMessage mo878v() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21411c;
                        r0 = r1;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.v():com.google.protobuf.AbstractMessage");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(com.google.protobuf.AbstractMessage r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22153d(r2);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.a(com.google.protobuf.AbstractMessage):com.google.protobuf.AbstractMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22154d(r2, r3);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22156x();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.b():com.google.protobuf.AbstractMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22154d(r2, r3);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.b(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22156x();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.c():com.google.protobuf.AbstractMessageLite$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.Message$Builder mo849c(com.google.protobuf.AbstractMessage r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22153d(r2);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.c(com.google.protobuf.AbstractMessage):com.google.protobuf.Message$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22154d(r2, r3);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.c(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder");
                    }

                    public final /* synthetic */ java.lang.Object clone() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22156x();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.clone():java.lang.Object");
                    }

                    public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22156x();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.f():com.google.protobuf.GeneratedMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage mo874h() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22176m();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.h():com.google.protobuf.AbstractMessage");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage mo875i() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22175l();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.i():com.google.protobuf.AbstractMessage");
                    }

                    public final /* synthetic */ com.google.protobuf.MessageLite mo876j() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22176m();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.j():com.google.protobuf.MessageLite");
                    }

                    public final /* synthetic */ com.google.protobuf.MessageLite mo877k() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22175l();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.k():com.google.protobuf.MessageLite");
                    }

                    protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo872d() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = org.whispersystems.libsignal.state.StorageProtos.f21457f;
                        r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.class;
                        r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.class;
                        r0 = r0.m21368a(r1, r2);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.d():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                    }

                    private Builder() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.<init>();
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21409c = r0;
                        r1 = com.google.protobuf.GeneratedMessage.f20638b;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.<init>():void");
                    }

                    public Builder(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.<init>(r3);
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21409c = r0;
                        r1 = com.google.protobuf.GeneratedMessage.f20638b;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.<init>(com.google.protobuf.GeneratedMessage$BuilderParent):void");
                    }

                    public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22155w() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder;
                        r0.<init>();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.w():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22156x() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = m22155w();
                        r1 = r2.m22176m();
                        r0 = r0.m22161a(r1);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.x():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }

                    public final com.google.protobuf.Descriptors.Descriptor mo841e() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = org.whispersystems.libsignal.state.StorageProtos.f21456e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.e():com.google.protobuf.Descriptors$Descriptor");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey m22175l() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.m22176m();
                        r1 = r0.mo854a();
                        if (r1 != 0) goto L_0x000f;
                    L_0x000a:
                        r0 = com.google.protobuf.AbstractMessage.Builder.m20123b(r0);
                        throw r0;
                    L_0x000f:
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.l():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey m22176m() {
                        /* JADX: method processing error */
/*
Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:57)
	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:47)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r5 = this;
                        r0 = 1;
                        r1 = 0;
                        r2 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey;
                        r2.<init>(r5);
                        r3 = r5.f21407a;
                        r4 = r3 & 1;
                        if (r4 != r0) goto L_0x0022;
                    L_0x000d:
                        r1 = r5.f21408b;
                        r2.index_ = r1;
                        r1 = r3 & 2;
                        r3 = 2;
                        if (r1 != r3) goto L_0x0018;
                    L_0x0016:
                        r0 = r0 | 2;
                    L_0x0018:
                        r1 = r5.f21409c;
                        r2.key_ = r1;
                        r2.bitField0_ = r0;
                        r5.m20309p();
                        return r2;
                    L_0x0022:
                        r0 = r1;
                        goto L_0x000d;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.m():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22153d(com.google.protobuf.AbstractMessage r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r2 instanceof org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey;
                        if (r0 == 0) goto L_0x000b;
                    L_0x0004:
                        r2 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey) r2;
                        r1 = r1.m22161a(r2);
                    L_0x000a:
                        return r1;
                    L_0x000b:
                        super.mo870a(r2);
                        goto L_0x000a;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.d(com.google.protobuf.AbstractMessage):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }

                    public final boolean mo854a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.a():boolean");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22154d(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r4 = this;
                        r2 = 0;
                        r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21410a;	 Catch:{ InvalidProtocolBufferException -> 0x000f }
                        r0 = r0.mo859a(r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x000f }
                        r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f }
                        if (r0 == 0) goto L_0x000e;
                    L_0x000b:
                        r4.m22161a(r0);
                    L_0x000e:
                        return r4;
                    L_0x000f:
                        r0 = move-exception;
                        r1 = r0;
                        r0 = r1.m21375a();	 Catch:{ all -> 0x0022 }
                        r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey) r0;	 Catch:{ all -> 0x0022 }
                        throw r1;	 Catch:{ all -> 0x0018 }
                    L_0x0018:
                        r1 = move-exception;
                        r3 = r1;
                        r1 = r0;
                        r0 = r3;
                    L_0x001c:
                        if (r1 == 0) goto L_0x0021;
                    L_0x001e:
                        r4.m22161a(r1);
                    L_0x0021:
                        throw r0;
                    L_0x0022:
                        r0 = move-exception;
                        r1 = r2;
                        goto L_0x001c;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.d(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22159a(int r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.f21407a;
                        r0 = r0 | 1;
                        r1.f21407a = r0;
                        r1.f21408b = r2;
                        r1.m20312t();
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.a(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22160a(com.google.protobuf.ByteString r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        if (r2 != 0) goto L_0x0008;
                    L_0x0002:
                        r0 = new java.lang.NullPointerException;
                        r0.<init>();
                        throw r0;
                    L_0x0008:
                        r0 = r1.f21407a;
                        r0 = r0 | 2;
                        r1.f21407a = r0;
                        r1.f21409c = r2;
                        r1.m20312t();
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.a(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                    }
                }

                public final /* synthetic */ com.google.protobuf.Message$Builder mo881s() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22187o();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.s():com.google.protobuf.Message$Builder");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22187o();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.u():com.google.protobuf.MessageLite$Builder");
                }

                public ChainKey(com.google.protobuf.GeneratedMessage.Builder<?> r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r1 = -1;
                    r0 = 0;
                    r2.<init>(r0);
                    r2.memoizedIsInitialized = r1;
                    r2.memoizedSerializedSize = r1;
                    r0 = r3.mo868g();
                    r2.unknownFields = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.<init>(com.google.protobuf.GeneratedMessage$Builder):void");
                }

                private ChainKey() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = -1;
                    r2.<init>();
                    r2.memoizedIsInitialized = r0;
                    r2.memoizedSerializedSize = r0;
                    r1 = com.google.protobuf.UnknownFieldSet.f21031a;
                    r0 = r1;
                    r2.unknownFields = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.<init>():void");
                }

                public final com.google.protobuf.AbstractMessage mo878v() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = f21411c;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.v():com.google.protobuf.AbstractMessage");
                }

                public final com.google.protobuf.UnknownFieldSet mo868g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.unknownFields;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.g():com.google.protobuf.UnknownFieldSet");
                }

                public ChainKey(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r1 = 1;
                    r0 = -1;
                    r4.<init>();
                    r4.memoizedIsInitialized = r0;
                    r4.memoizedSerializedSize = r0;
                    r4.m22179r();
                    r2 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                    r0 = 0;
                L_0x0011:
                    if (r0 != 0) goto L_0x005e;
                L_0x0013:
                    r3 = r5.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    switch(r3) {
                        case 0: goto L_0x0022;
                        case 8: goto L_0x0024;
                        case 18: goto L_0x0042;
                        default: goto L_0x001a;
                    };	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x001a:
                    r3 = r4.mo889a(r5, r2, r6, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    if (r3 != 0) goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0020:
                    r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0022:
                    r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0024:
                    r3 = r4.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r3 = r3 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r4.bitField0_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r3 = r5.m20220l();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r4.index_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    goto L_0x0011;
                L_0x0031:
                    r0 = move-exception;
                    r0 = r0.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0037:
                    r0 = move-exception;
                    r1 = r2.m21495b();
                    r4.unknownFields = r1;
                    r4.mo888E();
                    throw r0;
                L_0x0042:
                    r3 = r4.bitField0_;	 Catch:{  }
                    r3 = r3 | 2;	 Catch:{  }
                    r4.bitField0_ = r3;	 Catch:{  }
                    r3 = r5.m20219k();	 Catch:{  }
                    r4.key_ = r3;	 Catch:{  }
                    goto L_0x0011;
                L_0x004f:
                    r0 = move-exception;
                    r1 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r0 = r0.getMessage();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r1.<init>(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r0 = r1.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x005e:
                    r0 = r2.m21495b();
                    r4.unknownFields = r0;
                    r4.mo888E();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
                }

                protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo880h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21457f;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.class;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.class;
                    r0 = r0.m21368a(r1, r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.h():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$1;
                    r0.<init>();
                    f21410a = r0;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey;
                    r0.<init>();
                    f21411c = r0;
                    r0.m22179r();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.<clinit>():void");
                }

                public final com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey> mo857i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = f21410a;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.i():com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey>");
                }

                private void m22179r() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    r1.index_ = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r1.key_ = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.r():void");
                }

                public final boolean mo854a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = 1;
                    r1 = r3.memoizedIsInitialized;
                    r2 = -1;
                    if (r1 == r2) goto L_0x000b;
                L_0x0006:
                    if (r1 != r0) goto L_0x0009;
                L_0x0008:
                    return r0;
                L_0x0009:
                    r0 = 0;
                    goto L_0x0008;
                L_0x000b:
                    r3.memoizedIsInitialized = r0;
                    goto L_0x0008;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.a():boolean");
                }

                public final void mo853a(com.google.protobuf.CodedOutputStream r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r2 = 2;
                    r1 = 1;
                    r3.mo855b();
                    r0 = r3.bitField0_;
                    r0 = r0 & 1;
                    if (r0 != r1) goto L_0x0010;
                L_0x000b:
                    r0 = r3.index_;
                    r4.m20276c(r1, r0);
                L_0x0010:
                    r0 = r3.bitField0_;
                    r0 = r0 & 2;
                    if (r0 != r2) goto L_0x001b;
                L_0x0016:
                    r0 = r3.key_;
                    r4.m20264a(r2, r0);
                L_0x001b:
                    r0 = r3.mo868g();
                    r0.mo853a(r4);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.a(com.google.protobuf.CodedOutputStream):void");
                }

                public final int mo855b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r3 = 2;
                    r2 = 1;
                    r0 = r4.memoizedSerializedSize;
                    r1 = -1;
                    if (r0 == r1) goto L_0x0008;
                L_0x0007:
                    return r0;
                L_0x0008:
                    r0 = 0;
                    r1 = r4.bitField0_;
                    r1 = r1 & 1;
                    if (r1 != r2) goto L_0x0017;
                L_0x000f:
                    r0 = r4.index_;
                    r0 = com.google.protobuf.CodedOutputStream.m20246g(r2, r0);
                    r0 = r0 + 0;
                L_0x0017:
                    r1 = r4.bitField0_;
                    r1 = r1 & 2;
                    if (r1 != r3) goto L_0x0024;
                L_0x001d:
                    r1 = r4.key_;
                    r1 = com.google.protobuf.CodedOutputStream.m20236c(r3, r1);
                    r0 = r0 + r1;
                L_0x0024:
                    r1 = r4.mo868g();
                    r1 = r1.mo855b();
                    r0 = r0 + r1;
                    r4.memoizedSerializedSize = r0;
                    goto L_0x0007;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.b():int");
                }

                public final com.google.protobuf.Message$Builder mo882t() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.m22155w();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.t():com.google.protobuf.Message$Builder");
                }

                public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22178a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder.m22155w();
                    r0 = r0.m22161a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.Builder m22187o() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = m22178a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.o():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder");
                }

                protected final com.google.protobuf.Message$Builder mo879a(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$ChainKey$Builder;
                    r1 = 0;
                    r0.<init>(r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.a(com.google.protobuf.GeneratedMessage$BuilderParent):com.google.protobuf.Message$Builder");
                }
            }

            public interface MessageKeyOrBuilder extends MessageOrBuilder {
            }

            /* compiled from: actionId */
            public final class MessageKey extends GeneratedMessage implements MessageKeyOrBuilder {
                public static Parser<MessageKey> f21417a = new C24711();
                public static final MessageKey f21418c;
                public int bitField0_;
                public ByteString cipherKey_;
                public int index_;
                public ByteString iv_;
                public ByteString macKey_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private final UnknownFieldSet unknownFields;

                /* compiled from: actionId */
                final class C24711 extends AbstractParser<MessageKey> {
                    C24711() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.1.<init>():void");
                    }

                    public final java.lang.Object mo859a(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey;
                        r1 = 0;
                        r0.<init>(r3, r4);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.1.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object");
                    }
                }

                /* compiled from: actionId */
                public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements MessageKeyOrBuilder {
                    private int f21412a;
                    private int f21413b;
                    private ByteString f21414c = ByteString.f20600a;
                    private ByteString f21415d = ByteString.f20600a;
                    private ByteString f21416e = ByteString.f20600a;

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22202a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.f21418c;
                        r0 = r1;
                        if (r4 != r0) goto L_0x0006;
                    L_0x0005:
                        return r3;
                    L_0x0006:
                        r1 = 1;
                        r2 = r4.bitField0_;
                        r2 = r2 & 1;
                        if (r2 != r1) goto L_0x0052;
                    L_0x000d:
                        r0 = r1;
                        if (r0 == 0) goto L_0x0016;
                    L_0x0010:
                        r1 = r4.index_;
                        r0 = r1;
                        r3.m22200a(r0);
                    L_0x0016:
                        r1 = r4.bitField0_;
                        r1 = r1 & 2;
                        r2 = 2;
                        if (r1 != r2) goto L_0x0054;
                    L_0x001d:
                        r1 = 1;
                    L_0x001e:
                        r0 = r1;
                        if (r0 == 0) goto L_0x0027;
                    L_0x0021:
                        r1 = r4.cipherKey_;
                        r0 = r1;
                        r3.m22201a(r0);
                    L_0x0027:
                        r1 = r4.bitField0_;
                        r1 = r1 & 4;
                        r2 = 4;
                        if (r1 != r2) goto L_0x0056;
                    L_0x002e:
                        r1 = 1;
                    L_0x002f:
                        r0 = r1;
                        if (r0 == 0) goto L_0x0038;
                    L_0x0032:
                        r1 = r4.macKey_;
                        r0 = r1;
                        r3.m22206b(r0);
                    L_0x0038:
                        r1 = r4.bitField0_;
                        r1 = r1 & 8;
                        r2 = 8;
                        if (r1 != r2) goto L_0x0058;
                    L_0x0040:
                        r1 = 1;
                    L_0x0041:
                        r0 = r1;
                        if (r0 == 0) goto L_0x004a;
                    L_0x0044:
                        r1 = r4.iv_;
                        r0 = r1;
                        r3.m22210c(r0);
                    L_0x004a:
                        r0 = r4.mo868g();
                        r3.m20301c(r0);
                        goto L_0x0005;
                    L_0x0052:
                        r1 = 0;
                        goto L_0x000d;
                    L_0x0054:
                        r1 = 0;
                        goto L_0x001e;
                    L_0x0056:
                        r1 = 0;
                        goto L_0x002f;
                    L_0x0058:
                        r1 = 0;
                        goto L_0x0041;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final com.google.protobuf.AbstractMessage mo878v() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.f21418c;
                        r0 = r1;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.v():com.google.protobuf.AbstractMessage");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(com.google.protobuf.AbstractMessage r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22193d(r2);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.a(com.google.protobuf.AbstractMessage):com.google.protobuf.AbstractMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22194d(r2, r3);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22196w();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.b():com.google.protobuf.AbstractMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22194d(r2, r3);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.b(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22196w();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.c():com.google.protobuf.AbstractMessageLite$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.Message$Builder mo849c(com.google.protobuf.AbstractMessage r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22193d(r2);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.c(com.google.protobuf.AbstractMessage):com.google.protobuf.Message$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22194d(r2, r3);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.c(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder");
                    }

                    public final /* synthetic */ java.lang.Object clone() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22196w();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.clone():java.lang.Object");
                    }

                    public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22196w();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.f():com.google.protobuf.GeneratedMessage$Builder");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage mo874h() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22197y();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.h():com.google.protobuf.AbstractMessage");
                    }

                    public final /* synthetic */ com.google.protobuf.AbstractMessage mo875i() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22218l();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.i():com.google.protobuf.AbstractMessage");
                    }

                    public final /* synthetic */ com.google.protobuf.MessageLite mo876j() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22197y();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.j():com.google.protobuf.MessageLite");
                    }

                    public final /* synthetic */ com.google.protobuf.MessageLite mo877k() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.m22218l();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.k():com.google.protobuf.MessageLite");
                    }

                    protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo872d() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = org.whispersystems.libsignal.state.StorageProtos.f21459h;
                        r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.class;
                        r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.class;
                        r0 = r0.m21368a(r1, r2);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.d():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                    }

                    private Builder() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.<init>();
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21414c = r0;
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21415d = r0;
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21416e = r0;
                        r1 = com.google.protobuf.GeneratedMessage.f20638b;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.<init>():void");
                    }

                    public Builder(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.<init>(r3);
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21414c = r0;
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21415d = r0;
                        r0 = com.google.protobuf.ByteString.f20600a;
                        r2.f21416e = r0;
                        r1 = com.google.protobuf.GeneratedMessage.f20638b;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.<init>(com.google.protobuf.GeneratedMessage$BuilderParent):void");
                    }

                    public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22195u() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder;
                        r0.<init>();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.u():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22196w() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = m22195u();
                        r1 = r2.m22197y();
                        r0 = r0.m22202a(r1);
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.w():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final com.google.protobuf.Descriptors.Descriptor mo841e() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = org.whispersystems.libsignal.state.StorageProtos.f21458g;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.e():com.google.protobuf.Descriptors$Descriptor");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey m22218l() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.m22197y();
                        r1 = r0.mo854a();
                        if (r1 != 0) goto L_0x000f;
                    L_0x000a:
                        r0 = com.google.protobuf.AbstractMessage.Builder.m20123b(r0);
                        throw r0;
                    L_0x000f:
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.l():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey m22197y() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r5 = this;
                        r0 = 1;
                        r1 = 0;
                        r2 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey;
                        r2.<init>(r5);
                        r3 = r5.f21412a;
                        r4 = r3 & 1;
                        if (r4 != r0) goto L_0x0039;
                    L_0x000d:
                        r1 = r5.f21413b;
                        r2.index_ = r1;
                        r1 = r3 & 2;
                        r4 = 2;
                        if (r1 != r4) goto L_0x0018;
                    L_0x0016:
                        r0 = r0 | 2;
                    L_0x0018:
                        r1 = r5.f21414c;
                        r2.cipherKey_ = r1;
                        r1 = r3 & 4;
                        r4 = 4;
                        if (r1 != r4) goto L_0x0023;
                    L_0x0021:
                        r0 = r0 | 4;
                    L_0x0023:
                        r1 = r5.f21415d;
                        r2.macKey_ = r1;
                        r1 = r3 & 8;
                        r3 = 8;
                        if (r1 != r3) goto L_0x002f;
                    L_0x002d:
                        r0 = r0 | 8;
                    L_0x002f:
                        r1 = r5.f21416e;
                        r2.iv_ = r1;
                        r2.bitField0_ = r0;
                        r5.m20309p();
                        return r2;
                    L_0x0039:
                        r0 = r1;
                        goto L_0x000d;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.y():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22193d(com.google.protobuf.AbstractMessage r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r2 instanceof org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey;
                        if (r0 == 0) goto L_0x000b;
                    L_0x0004:
                        r2 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey) r2;
                        r1 = r1.m22202a(r2);
                    L_0x000a:
                        return r1;
                    L_0x000b:
                        super.mo870a(r2);
                        goto L_0x000a;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.d(com.google.protobuf.AbstractMessage):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final boolean mo854a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.a():boolean");
                    }

                    private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22194d(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r4 = this;
                        r2 = 0;
                        r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.f21417a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                        r0 = r0.mo859a(r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                        r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                        if (r0 == 0) goto L_0x000e;
                    L_0x000b:
                        r4.m22202a(r0);
                    L_0x000e:
                        return r4;
                    L_0x000f:
                        r0 = move-exception;
                        r1 = r0;
                        r0 = r1.m21375a();	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                        r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                        throw r1;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    L_0x0018:
                        r1 = move-exception;
                        r3 = r1;
                        r1 = r0;
                        r0 = r3;
                    L_0x001c:
                        if (r1 == 0) goto L_0x0021;
                    L_0x001e:
                        r4.m22202a(r1);
                    L_0x0021:
                        throw r0;
                    L_0x0022:
                        r0 = move-exception;
                        r1 = r2;
                        goto L_0x001c;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.d(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22200a(int r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = r1.f21412a;
                        r0 = r0 | 1;
                        r1.f21412a = r0;
                        r1.f21413b = r2;
                        r1.m20312t();
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.a(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22201a(com.google.protobuf.ByteString r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        if (r2 != 0) goto L_0x0008;
                    L_0x0002:
                        r0 = new java.lang.NullPointerException;
                        r0.<init>();
                        throw r0;
                    L_0x0008:
                        r0 = r1.f21412a;
                        r0 = r0 | 2;
                        r1.f21412a = r0;
                        r1.f21414c = r2;
                        r1.m20312t();
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.a(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22206b(com.google.protobuf.ByteString r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        if (r2 != 0) goto L_0x0008;
                    L_0x0002:
                        r0 = new java.lang.NullPointerException;
                        r0.<init>();
                        throw r0;
                    L_0x0008:
                        r0 = r1.f21412a;
                        r0 = r0 | 4;
                        r1.f21412a = r0;
                        r1.f21415d = r2;
                        r1.m20312t();
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.b(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }

                    public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22210c(com.google.protobuf.ByteString r2) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        if (r2 != 0) goto L_0x0008;
                    L_0x0002:
                        r0 = new java.lang.NullPointerException;
                        r0.<init>();
                        throw r0;
                    L_0x0008:
                        r0 = r1.f21412a;
                        r0 = r0 | 8;
                        r1.f21412a = r0;
                        r1.f21416e = r2;
                        r1.m20312t();
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.c(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                    }
                }

                public final /* synthetic */ com.google.protobuf.Message$Builder mo881s() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = m22220a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.s():com.google.protobuf.Message$Builder");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = m22220a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.u():com.google.protobuf.MessageLite$Builder");
                }

                public MessageKey(com.google.protobuf.GeneratedMessage.Builder<?> r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r1 = -1;
                    r0 = 0;
                    r2.<init>(r0);
                    r2.memoizedIsInitialized = r1;
                    r2.memoizedSerializedSize = r1;
                    r0 = r3.mo868g();
                    r2.unknownFields = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.<init>(com.google.protobuf.GeneratedMessage$Builder):void");
                }

                private MessageKey() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = -1;
                    r2.<init>();
                    r2.memoizedIsInitialized = r0;
                    r2.memoizedSerializedSize = r0;
                    r1 = com.google.protobuf.UnknownFieldSet.f21031a;
                    r0 = r1;
                    r2.unknownFields = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.<init>():void");
                }

                public final com.google.protobuf.AbstractMessage mo878v() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = f21418c;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.v():com.google.protobuf.AbstractMessage");
                }

                public final com.google.protobuf.UnknownFieldSet mo868g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.unknownFields;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.g():com.google.protobuf.UnknownFieldSet");
                }

                public MessageKey(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r1 = 1;
                    r0 = -1;
                    r4.<init>();
                    r4.memoizedIsInitialized = r0;
                    r4.memoizedSerializedSize = r0;
                    r4.m22221y();
                    r2 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                    r0 = 0;
                L_0x0011:
                    if (r0 != 0) goto L_0x0078;
                L_0x0013:
                    r3 = r5.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    switch(r3) {
                        case 0: goto L_0x0022;
                        case 8: goto L_0x0024;
                        case 18: goto L_0x0042;
                        case 26: goto L_0x005e;
                        case 34: goto L_0x006b;
                        default: goto L_0x001a;
                    };	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x001a:
                    r3 = r4.mo889a(r5, r2, r6, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    if (r3 != 0) goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0020:
                    r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0022:
                    r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0024:
                    r3 = r4.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r3 = r3 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r4.bitField0_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r3 = r5.m20220l();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r4.index_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    goto L_0x0011;
                L_0x0031:
                    r0 = move-exception;
                    r0 = r0.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x0037:
                    r0 = move-exception;
                    r1 = r2.m21495b();
                    r4.unknownFields = r1;
                    r4.mo888E();
                    throw r0;
                L_0x0042:
                    r3 = r4.bitField0_;	 Catch:{  }
                    r3 = r3 | 2;	 Catch:{  }
                    r4.bitField0_ = r3;	 Catch:{  }
                    r3 = r5.m20219k();	 Catch:{  }
                    r4.cipherKey_ = r3;	 Catch:{  }
                    goto L_0x0011;
                L_0x004f:
                    r0 = move-exception;
                    r1 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r0 = r0.getMessage();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r1.<init>(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    r0 = r1.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                    throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                L_0x005e:
                    r3 = r4.bitField0_;	 Catch:{  }
                    r3 = r3 | 4;	 Catch:{  }
                    r4.bitField0_ = r3;	 Catch:{  }
                    r3 = r5.m20219k();	 Catch:{  }
                    r4.macKey_ = r3;	 Catch:{  }
                    goto L_0x0011;	 Catch:{  }
                L_0x006b:
                    r3 = r4.bitField0_;	 Catch:{  }
                    r3 = r3 | 8;	 Catch:{  }
                    r4.bitField0_ = r3;	 Catch:{  }
                    r3 = r5.m20219k();	 Catch:{  }
                    r4.iv_ = r3;	 Catch:{  }
                    goto L_0x0011;
                L_0x0078:
                    r0 = r2.m21495b();
                    r4.unknownFields = r0;
                    r4.mo888E();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
                }

                protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo880h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21459h;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.class;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.class;
                    r0 = r0.m21368a(r1, r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.h():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$1;
                    r0.<init>();
                    f21417a = r0;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey;
                    r0.<init>();
                    f21418c = r0;
                    r0.m22221y();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.<clinit>():void");
                }

                public final com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey> mo857i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = f21417a;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.i():com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey>");
                }

                private void m22221y() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    r1.index_ = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r1.cipherKey_ = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r1.macKey_ = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r1.iv_ = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.y():void");
                }

                public final boolean mo854a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = 1;
                    r1 = r3.memoizedIsInitialized;
                    r2 = -1;
                    if (r1 == r2) goto L_0x000b;
                L_0x0006:
                    if (r1 != r0) goto L_0x0009;
                L_0x0008:
                    return r0;
                L_0x0009:
                    r0 = 0;
                    goto L_0x0008;
                L_0x000b:
                    r3.memoizedIsInitialized = r0;
                    goto L_0x0008;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.a():boolean");
                }

                public final void mo853a(com.google.protobuf.CodedOutputStream r5) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r3 = 4;
                    r2 = 2;
                    r1 = 1;
                    r4.mo855b();
                    r0 = r4.bitField0_;
                    r0 = r0 & 1;
                    if (r0 != r1) goto L_0x0011;
                L_0x000c:
                    r0 = r4.index_;
                    r5.m20276c(r1, r0);
                L_0x0011:
                    r0 = r4.bitField0_;
                    r0 = r0 & 2;
                    if (r0 != r2) goto L_0x001c;
                L_0x0017:
                    r0 = r4.cipherKey_;
                    r5.m20264a(r2, r0);
                L_0x001c:
                    r0 = r4.bitField0_;
                    r0 = r0 & 4;
                    if (r0 != r3) goto L_0x0028;
                L_0x0022:
                    r0 = 3;
                    r1 = r4.macKey_;
                    r5.m20264a(r0, r1);
                L_0x0028:
                    r0 = r4.bitField0_;
                    r0 = r0 & 8;
                    r1 = 8;
                    if (r0 != r1) goto L_0x0035;
                L_0x0030:
                    r0 = r4.iv_;
                    r5.m20264a(r3, r0);
                L_0x0035:
                    r0 = r4.mo868g();
                    r0.mo853a(r5);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.a(com.google.protobuf.CodedOutputStream):void");
                }

                public final int mo855b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r4 = 4;
                    r3 = 2;
                    r2 = 1;
                    r0 = r5.memoizedSerializedSize;
                    r1 = -1;
                    if (r0 == r1) goto L_0x0009;
                L_0x0008:
                    return r0;
                L_0x0009:
                    r0 = 0;
                    r1 = r5.bitField0_;
                    r1 = r1 & 1;
                    if (r1 != r2) goto L_0x0018;
                L_0x0010:
                    r0 = r5.index_;
                    r0 = com.google.protobuf.CodedOutputStream.m20246g(r2, r0);
                    r0 = r0 + 0;
                L_0x0018:
                    r1 = r5.bitField0_;
                    r1 = r1 & 2;
                    if (r1 != r3) goto L_0x0025;
                L_0x001e:
                    r1 = r5.cipherKey_;
                    r1 = com.google.protobuf.CodedOutputStream.m20236c(r3, r1);
                    r0 = r0 + r1;
                L_0x0025:
                    r1 = r5.bitField0_;
                    r1 = r1 & 4;
                    if (r1 != r4) goto L_0x0033;
                L_0x002b:
                    r1 = 3;
                    r2 = r5.macKey_;
                    r1 = com.google.protobuf.CodedOutputStream.m20236c(r1, r2);
                    r0 = r0 + r1;
                L_0x0033:
                    r1 = r5.bitField0_;
                    r1 = r1 & 8;
                    r2 = 8;
                    if (r1 != r2) goto L_0x0042;
                L_0x003b:
                    r1 = r5.iv_;
                    r1 = com.google.protobuf.CodedOutputStream.m20236c(r4, r1);
                    r0 = r0 + r1;
                L_0x0042:
                    r1 = r5.mo868g();
                    r1 = r1.mo855b();
                    r0 = r0 + r1;
                    r5.memoizedSerializedSize = r0;
                    goto L_0x0008;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.b():int");
                }

                public final com.google.protobuf.Message$Builder mo882t() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.m22195u();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.t():com.google.protobuf.Message$Builder");
                }

                private static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder m22220a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.Builder.m22195u();
                    r0 = r0.m22202a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder");
                }

                protected final com.google.protobuf.Message$Builder mo879a(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$MessageKey$Builder;
                    r1 = 0;
                    r0.<init>(r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.a(com.google.protobuf.GeneratedMessage$BuilderParent):com.google.protobuf.Message$Builder");
                }
            }

            public final /* synthetic */ com.google.protobuf.Message$Builder mo881s() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22243r();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.s():com.google.protobuf.Message$Builder");
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22243r();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.u():com.google.protobuf.MessageLite$Builder");
            }

            public Chain(com.google.protobuf.GeneratedMessage.Builder<?> r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = -1;
                r0 = 0;
                r2.<init>(r0);
                r2.memoizedIsInitialized = r1;
                r2.memoizedSerializedSize = r1;
                r0 = r3.mo868g();
                r2.unknownFields = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.<init>(com.google.protobuf.GeneratedMessage$Builder):void");
            }

            private Chain() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = -1;
                r2.<init>();
                r2.memoizedIsInitialized = r0;
                r2.memoizedSerializedSize = r0;
                r1 = com.google.protobuf.UnknownFieldSet.f21031a;
                r0 = r1;
                r2.unknownFields = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.<init>():void");
            }

            public final com.google.protobuf.AbstractMessage mo878v() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f21420c;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.v():com.google.protobuf.AbstractMessage");
            }

            public final com.google.protobuf.UnknownFieldSet mo868g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.unknownFields;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.g():com.google.protobuf.UnknownFieldSet");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Chain(com.google.protobuf.CodedInputStream r10, com.google.protobuf.ExtensionRegistryLite r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r9 = this;
                r4 = 1;
                r0 = 0;
                r1 = -1;
                r7 = 8;
                r9.<init>();
                r9.memoizedIsInitialized = r1;
                r9.memoizedSerializedSize = r1;
                r9.m22234z();
                r5 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                r3 = r0;
                r1 = r0;
            L_0x0015:
                if (r3 != 0) goto L_0x00b7;
            L_0x0017:
                r0 = r10.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                switch(r0) {
                    case 0: goto L_0x0026;
                    case 10: goto L_0x0028;
                    case 18: goto L_0x0052;
                    case 26: goto L_0x006e;
                    case 34: goto L_0x009c;
                    default: goto L_0x001e;
                };	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
            L_0x001e:
                r0 = r9.mo889a(r10, r5, r11, r0);	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                if (r0 != 0) goto L_0x00e2;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
            L_0x0024:
                r3 = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
            L_0x0026:
                r3 = r4;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                goto L_0x0015;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
            L_0x0028:
                r0 = r9.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                r0 = r0 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                r9.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                r0 = r10.m20219k();	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                r9.senderRatchetKey_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0035, IOException -> 0x005f }
                goto L_0x0015;
            L_0x0035:
                r0 = move-exception;
            L_0x0036:
                r0 = r0.m21374a(r9);	 Catch:{ all -> 0x003b }
                throw r0;	 Catch:{ all -> 0x003b }
            L_0x003b:
                r0 = move-exception;
            L_0x003c:
                r1 = r1 & 8;
                if (r1 != r7) goto L_0x0048;
            L_0x0040:
                r1 = r9.messageKeys_;
                r1 = java.util.Collections.unmodifiableList(r1);
                r9.messageKeys_ = r1;
            L_0x0048:
                r1 = r5.m21495b();
                r9.unknownFields = r1;
                r9.mo888E();
                throw r0;
            L_0x0052:
                r0 = r9.bitField0_;	 Catch:{  }
                r0 = r0 | 2;	 Catch:{  }
                r9.bitField0_ = r0;	 Catch:{  }
                r0 = r10.m20219k();	 Catch:{  }
                r9.senderRatchetKeyPrivate_ = r0;	 Catch:{  }
                goto L_0x0015;
            L_0x005f:
                r0 = move-exception;
            L_0x0060:
                r2 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{  }
                r0 = r0.getMessage();	 Catch:{  }
                r2.<init>(r0);	 Catch:{  }
                r0 = r2.m21374a(r9);	 Catch:{  }
                throw r0;	 Catch:{  }
            L_0x006e:
                r0 = 0;
                r2 = r9.bitField0_;	 Catch:{  }
                r2 = r2 & 4;	 Catch:{  }
                r6 = 4;	 Catch:{  }
                if (r2 != r6) goto L_0x00e0;	 Catch:{  }
            L_0x0076:
                r0 = r9.chainKey_;	 Catch:{  }
                r0 = r0.m22187o();	 Catch:{  }
                r2 = r0;	 Catch:{  }
            L_0x007d:
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21410a;	 Catch:{  }
                r0 = r10.m20203a(r0, r11);	 Catch:{  }
                r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey) r0;	 Catch:{  }
                r9.chainKey_ = r0;	 Catch:{  }
                if (r2 == 0) goto L_0x0094;	 Catch:{  }
            L_0x0089:
                r0 = r9.chainKey_;	 Catch:{  }
                r2.m22161a(r0);	 Catch:{  }
                r0 = r2.m22176m();	 Catch:{  }
                r9.chainKey_ = r0;	 Catch:{  }
            L_0x0094:
                r0 = r9.bitField0_;	 Catch:{  }
                r0 = r0 | 4;	 Catch:{  }
                r9.bitField0_ = r0;	 Catch:{  }
                goto L_0x0015;	 Catch:{  }
            L_0x009c:
                r0 = r1 & 8;	 Catch:{  }
                if (r0 == r7) goto L_0x00de;	 Catch:{  }
            L_0x00a0:
                r0 = new java.util.ArrayList;	 Catch:{  }
                r0.<init>();	 Catch:{  }
                r9.messageKeys_ = r0;	 Catch:{  }
                r0 = r1 | 8;
            L_0x00a9:
                r1 = r9.messageKeys_;	 Catch:{ InvalidProtocolBufferException -> 0x00d8, IOException -> 0x00d3, all -> 0x00cd }
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey.f21417a;	 Catch:{ InvalidProtocolBufferException -> 0x00d8, IOException -> 0x00d3, all -> 0x00cd }
                r2 = r10.m20203a(r2, r11);	 Catch:{ InvalidProtocolBufferException -> 0x00d8, IOException -> 0x00d3, all -> 0x00cd }
                r1.add(r2);	 Catch:{ InvalidProtocolBufferException -> 0x00d8, IOException -> 0x00d3, all -> 0x00cd }
            L_0x00b4:
                r1 = r0;
                goto L_0x0015;
            L_0x00b7:
                r0 = r1 & 8;
                if (r0 != r7) goto L_0x00c3;
            L_0x00bb:
                r0 = r9.messageKeys_;
                r0 = java.util.Collections.unmodifiableList(r0);
                r9.messageKeys_ = r0;
            L_0x00c3:
                r0 = r5.m21495b();
                r9.unknownFields = r0;
                r9.mo888E();
                return;
            L_0x00cd:
                r1 = move-exception;
                r8 = r1;
                r1 = r0;
                r0 = r8;
                goto L_0x003c;
            L_0x00d3:
                r1 = move-exception;
                r8 = r1;
                r1 = r0;
                r0 = r8;
                goto L_0x0060;
            L_0x00d8:
                r1 = move-exception;
                r8 = r1;
                r1 = r0;
                r0 = r8;
                goto L_0x0036;
            L_0x00de:
                r0 = r1;
                goto L_0x00a9;
            L_0x00e0:
                r2 = r0;
                goto L_0x007d;
            L_0x00e2:
                r0 = r1;
                goto L_0x00b4;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
            }

            protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo880h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.f21455d;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.class;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.class;
                r0 = r0.m21368a(r1, r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.h():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$1;
                r0.<init>();
                f21419a = r0;
                r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain;
                r0.<init>();
                f21420c = r0;
                r0.m22234z();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.<clinit>():void");
            }

            public final com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain> mo857i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f21419a;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.i():com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain>");
            }

            public final com.google.protobuf.ByteString m22242l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.senderRatchetKey_;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.l():com.google.protobuf.ByteString");
            }

            private void m22234z() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.senderRatchetKey_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r2.senderRatchetKeyPrivate_ = r0;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.ChainKey.f21411c;
                r0 = r1;
                r2.chainKey_ = r0;
                r0 = java.util.Collections.emptyList();
                r2.messageKeys_ = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.z():void");
            }

            public final boolean mo854a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 1;
                r1 = r3.memoizedIsInitialized;
                r2 = -1;
                if (r1 == r2) goto L_0x000b;
            L_0x0006:
                if (r1 != r0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r0 = 0;
                goto L_0x0008;
            L_0x000b:
                r3.memoizedIsInitialized = r0;
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.a():boolean");
            }

            public final void mo853a(com.google.protobuf.CodedOutputStream r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r3 = 4;
                r2 = 2;
                r1 = 1;
                r4.mo855b();
                r0 = r4.bitField0_;
                r0 = r0 & 1;
                if (r0 != r1) goto L_0x0011;
            L_0x000c:
                r0 = r4.senderRatchetKey_;
                r5.m20264a(r1, r0);
            L_0x0011:
                r0 = r4.bitField0_;
                r0 = r0 & 2;
                if (r0 != r2) goto L_0x001c;
            L_0x0017:
                r0 = r4.senderRatchetKeyPrivate_;
                r5.m20264a(r2, r0);
            L_0x001c:
                r0 = r4.bitField0_;
                r0 = r0 & 4;
                if (r0 != r3) goto L_0x0028;
            L_0x0022:
                r0 = 3;
                r1 = r4.chainKey_;
                r5.m20273b(r0, r1);
            L_0x0028:
                r0 = 0;
                r1 = r0;
            L_0x002a:
                r0 = r4.messageKeys_;
                r0 = r0.size();
                if (r1 >= r0) goto L_0x0041;
            L_0x0032:
                r0 = r4.messageKeys_;
                r0 = r0.get(r1);
                r0 = (com.google.protobuf.MessageLite) r0;
                r5.m20273b(r3, r0);
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x002a;
            L_0x0041:
                r0 = r4.mo868g();
                r0.mo853a(r5);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.a(com.google.protobuf.CodedOutputStream):void");
            }

            public final int mo855b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r5 = 4;
                r4 = 2;
                r3 = 1;
                r1 = 0;
                r0 = r6.memoizedSerializedSize;
                r2 = -1;
                if (r0 == r2) goto L_0x000a;
            L_0x0009:
                return r0;
            L_0x000a:
                r0 = r6.bitField0_;
                r0 = r0 & 1;
                if (r0 != r3) goto L_0x0059;
            L_0x0010:
                r0 = r6.senderRatchetKey_;
                r0 = com.google.protobuf.CodedOutputStream.m20236c(r3, r0);
                r0 = r0 + 0;
            L_0x0018:
                r2 = r6.bitField0_;
                r2 = r2 & 2;
                if (r2 != r4) goto L_0x0025;
            L_0x001e:
                r2 = r6.senderRatchetKeyPrivate_;
                r2 = com.google.protobuf.CodedOutputStream.m20236c(r4, r2);
                r0 = r0 + r2;
            L_0x0025:
                r2 = r6.bitField0_;
                r2 = r2 & 4;
                if (r2 != r5) goto L_0x0033;
            L_0x002b:
                r2 = 3;
                r3 = r6.chainKey_;
                r2 = com.google.protobuf.CodedOutputStream.m20242e(r2, r3);
                r0 = r0 + r2;
            L_0x0033:
                r2 = r0;
            L_0x0034:
                r0 = r6.messageKeys_;
                r0 = r0.size();
                if (r1 >= r0) goto L_0x004d;
            L_0x003c:
                r0 = r6.messageKeys_;
                r0 = r0.get(r1);
                r0 = (com.google.protobuf.MessageLite) r0;
                r0 = com.google.protobuf.CodedOutputStream.m20242e(r5, r0);
                r0 = r0 + r2;
                r1 = r1 + 1;
                r2 = r0;
                goto L_0x0034;
            L_0x004d:
                r0 = r6.mo868g();
                r0 = r0.mo855b();
                r0 = r0 + r2;
                r6.memoizedSerializedSize = r0;
                goto L_0x0009;
            L_0x0059:
                r0 = r1;
                goto L_0x0018;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.b():int");
            }

            public final com.google.protobuf.Message$Builder mo882t() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.m22125y();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.t():com.google.protobuf.Message$Builder");
            }

            public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22233a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder.m22125y();
                r0 = r0.m22134a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.Builder m22243r() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = m22233a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.r():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder");
            }

            protected final com.google.protobuf.Message$Builder mo879a(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain$Builder;
                r1 = 0;
                r0.<init>(r3);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.a(com.google.protobuf.GeneratedMessage$BuilderParent):com.google.protobuf.Message$Builder");
            }
        }

        public interface PendingKeyExchangeOrBuilder extends MessageOrBuilder {
        }

        /* compiled from: actionId */
        public final class PendingKeyExchange extends GeneratedMessage implements PendingKeyExchangeOrBuilder {
            public static Parser<PendingKeyExchange> f21429a = new C24721();
            public static final PendingKeyExchange f21430c;
            public int bitField0_;
            public ByteString localBaseKeyPrivate_;
            public ByteString localBaseKey_;
            public ByteString localIdentityKeyPrivate_;
            public ByteString localIdentityKey_;
            public ByteString localRatchetKeyPrivate_;
            public ByteString localRatchetKey_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            public int sequence_;
            private final UnknownFieldSet unknownFields;

            /* compiled from: actionId */
            final class C24721 extends AbstractParser<PendingKeyExchange> {
                C24721() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.1.<init>():void");
                }

                public final java.lang.Object mo859a(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange;
                    r1 = 0;
                    r0.<init>(r3, r4);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.1.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object");
                }
            }

            /* compiled from: actionId */
            public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements PendingKeyExchangeOrBuilder {
                public int f21421a;
                public int f21422b;
                private ByteString f21423c = ByteString.f20600a;
                private ByteString f21424d = ByteString.f20600a;
                private ByteString f21425e = ByteString.f20600a;
                private ByteString f21426f = ByteString.f20600a;
                private ByteString f21427g = ByteString.f20600a;
                private ByteString f21428h = ByteString.f20600a;

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22262a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21430c;
                    r0 = r1;
                    if (r4 != r0) goto L_0x0006;
                L_0x0005:
                    return r3;
                L_0x0006:
                    r1 = 1;
                    r2 = r4.bitField0_;
                    r2 = r2 & 1;
                    if (r2 != r1) goto L_0x0091;
                L_0x000d:
                    r0 = r1;
                    if (r0 == 0) goto L_0x001e;
                L_0x0010:
                    r1 = r4.sequence_;
                    r0 = r1;
                    r1 = r3.f21421a;
                    r1 = r1 | 1;
                    r3.f21421a = r1;
                    r3.f21422b = r0;
                    r3.m20312t();
                L_0x001e:
                    r1 = r4.bitField0_;
                    r1 = r1 & 2;
                    r2 = 2;
                    if (r1 != r2) goto L_0x0094;
                L_0x0025:
                    r1 = 1;
                L_0x0026:
                    r0 = r1;
                    if (r0 == 0) goto L_0x002f;
                L_0x0029:
                    r1 = r4.localBaseKey_;
                    r0 = r1;
                    r3.m22249a(r0);
                L_0x002f:
                    r1 = r4.bitField0_;
                    r1 = r1 & 4;
                    r2 = 4;
                    if (r1 != r2) goto L_0x0096;
                L_0x0036:
                    r1 = 1;
                L_0x0037:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0040;
                L_0x003a:
                    r1 = r4.localBaseKeyPrivate_;
                    r0 = r1;
                    r3.m22250b(r0);
                L_0x0040:
                    r1 = r4.bitField0_;
                    r1 = r1 & 8;
                    r2 = 8;
                    if (r1 != r2) goto L_0x0098;
                L_0x0048:
                    r1 = 1;
                L_0x0049:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0052;
                L_0x004c:
                    r1 = r4.localRatchetKey_;
                    r0 = r1;
                    r3.m22251c(r0);
                L_0x0052:
                    r1 = r4.bitField0_;
                    r1 = r1 & 16;
                    r2 = 16;
                    if (r1 != r2) goto L_0x009a;
                L_0x005a:
                    r1 = 1;
                L_0x005b:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0064;
                L_0x005e:
                    r1 = r4.localRatchetKeyPrivate_;
                    r0 = r1;
                    r3.m22253d(r0);
                L_0x0064:
                    r1 = r4.bitField0_;
                    r1 = r1 & 32;
                    r2 = 32;
                    if (r1 != r2) goto L_0x009c;
                L_0x006c:
                    r1 = 1;
                L_0x006d:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0076;
                L_0x0070:
                    r1 = r4.localIdentityKey_;
                    r0 = r1;
                    r3.m22255e(r0);
                L_0x0076:
                    r1 = r4.bitField0_;
                    r1 = r1 & 64;
                    r2 = 64;
                    if (r1 != r2) goto L_0x009e;
                L_0x007e:
                    r1 = 1;
                L_0x007f:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0088;
                L_0x0082:
                    r1 = r4.localIdentityKeyPrivate_;
                    r0 = r1;
                    r3.m22256f(r0);
                L_0x0088:
                    r0 = r4.mo868g();
                    r3.m20301c(r0);
                    goto L_0x0005;
                L_0x0091:
                    r1 = 0;
                    goto L_0x000d;
                L_0x0094:
                    r1 = 0;
                    goto L_0x0026;
                L_0x0096:
                    r1 = 0;
                    goto L_0x0037;
                L_0x0098:
                    r1 = 0;
                    goto L_0x0049;
                L_0x009a:
                    r1 = 0;
                    goto L_0x005b;
                L_0x009c:
                    r1 = 0;
                    goto L_0x006d;
                L_0x009e:
                    r1 = 0;
                    goto L_0x007f;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                public final com.google.protobuf.AbstractMessage mo878v() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21430c;
                    r0 = r1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.v():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22252d(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.a(com.google.protobuf.AbstractMessage):com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22254d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22258w();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.b():com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22254d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.b(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22258w();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.c():com.google.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ com.google.protobuf.Message$Builder mo849c(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22252d(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.c(com.google.protobuf.AbstractMessage):com.google.protobuf.Message$Builder");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22254d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.c(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder");
                }

                public final /* synthetic */ java.lang.Object clone() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22258w();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.clone():java.lang.Object");
                }

                public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22258w();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.f():com.google.protobuf.GeneratedMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage mo874h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22276l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.h():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage mo875i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22259y();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.i():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite mo876j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22276l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.j():com.google.protobuf.MessageLite");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite mo877k() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22259y();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.k():com.google.protobuf.MessageLite");
                }

                protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo872d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21461j;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.class;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.class;
                    r0 = r0.m21368a(r1, r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.d():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                }

                private Builder() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.<init>();
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21423c = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21424d = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21425e = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21426f = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21427g = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21428h = r0;
                    r1 = com.google.protobuf.GeneratedMessage.f20638b;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.<init>():void");
                }

                public Builder(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.<init>(r3);
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21423c = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21424d = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21425e = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21426f = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21427g = r0;
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21428h = r0;
                    r1 = com.google.protobuf.GeneratedMessage.f20638b;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.<init>(com.google.protobuf.GeneratedMessage$BuilderParent):void");
                }

                public static Builder m22257u() {
                    return new Builder();
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22258w() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = m22257u();
                    r1 = r2.m22276l();
                    r0 = r0.m22262a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.w():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                public final com.google.protobuf.Descriptors.Descriptor mo841e() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21460i;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.e():com.google.protobuf.Descriptors$Descriptor");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange m22259y() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.m22276l();
                    r1 = r0.mo854a();
                    if (r1 != 0) goto L_0x000f;
                L_0x000a:
                    r0 = com.google.protobuf.AbstractMessage.Builder.m20123b(r0);
                    throw r0;
                L_0x000f:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.y():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange m22276l() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = 1;
                    r1 = 0;
                    r2 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange;
                    r2.<init>(r5);
                    r3 = r5.f21421a;
                    r4 = r3 & 1;
                    if (r4 != r0) goto L_0x005d;
                L_0x000d:
                    r1 = r5.f21422b;
                    r2.sequence_ = r1;
                    r1 = r3 & 2;
                    r4 = 2;
                    if (r1 != r4) goto L_0x0018;
                L_0x0016:
                    r0 = r0 | 2;
                L_0x0018:
                    r1 = r5.f21423c;
                    r2.localBaseKey_ = r1;
                    r1 = r3 & 4;
                    r4 = 4;
                    if (r1 != r4) goto L_0x0023;
                L_0x0021:
                    r0 = r0 | 4;
                L_0x0023:
                    r1 = r5.f21424d;
                    r2.localBaseKeyPrivate_ = r1;
                    r1 = r3 & 8;
                    r4 = 8;
                    if (r1 != r4) goto L_0x002f;
                L_0x002d:
                    r0 = r0 | 8;
                L_0x002f:
                    r1 = r5.f21425e;
                    r2.localRatchetKey_ = r1;
                    r1 = r3 & 16;
                    r4 = 16;
                    if (r1 != r4) goto L_0x003b;
                L_0x0039:
                    r0 = r0 | 16;
                L_0x003b:
                    r1 = r5.f21426f;
                    r2.localRatchetKeyPrivate_ = r1;
                    r1 = r3 & 32;
                    r4 = 32;
                    if (r1 != r4) goto L_0x0047;
                L_0x0045:
                    r0 = r0 | 32;
                L_0x0047:
                    r1 = r5.f21427g;
                    r2.localIdentityKey_ = r1;
                    r1 = r3 & 64;
                    r3 = 64;
                    if (r1 != r3) goto L_0x0053;
                L_0x0051:
                    r0 = r0 | 64;
                L_0x0053:
                    r1 = r5.f21428h;
                    r2.localIdentityKeyPrivate_ = r1;
                    r2.bitField0_ = r0;
                    r5.m20309p();
                    return r2;
                L_0x005d:
                    r0 = r1;
                    goto L_0x000d;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.l():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22252d(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r2 instanceof org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange;
                    if (r0 == 0) goto L_0x000b;
                L_0x0004:
                    r2 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange) r2;
                    r1 = r1.m22262a(r2);
                L_0x000a:
                    return r1;
                L_0x000b:
                    super.mo870a(r2);
                    goto L_0x000a;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.d(com.google.protobuf.AbstractMessage):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                public final boolean mo854a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.a():boolean");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22254d(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r2 = 0;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21429a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    r0 = r0.mo859a(r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    if (r0 == 0) goto L_0x000e;
                L_0x000b:
                    r4.m22262a(r0);
                L_0x000e:
                    return r4;
                L_0x000f:
                    r0 = move-exception;
                    r1 = r0;
                    r0 = r1.m21375a();	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    throw r1;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                L_0x0018:
                    r1 = move-exception;
                    r3 = r1;
                    r1 = r0;
                    r0 = r3;
                L_0x001c:
                    if (r1 == 0) goto L_0x0021;
                L_0x001e:
                    r4.m22262a(r1);
                L_0x0021:
                    throw r0;
                L_0x0022:
                    r0 = move-exception;
                    r1 = r2;
                    goto L_0x001c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.d(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22249a(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21421a;
                    r0 = r0 | 2;
                    r1.f21421a = r0;
                    r1.f21423c = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.a(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22250b(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21421a;
                    r0 = r0 | 4;
                    r1.f21421a = r0;
                    r1.f21424d = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.b(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22251c(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21421a;
                    r0 = r0 | 8;
                    r1.f21421a = r0;
                    r1.f21425e = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.c(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22253d(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21421a;
                    r0 = r0 | 16;
                    r1.f21421a = r0;
                    r1.f21426f = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.d(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22255e(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21421a;
                    r0 = r0 | 32;
                    r1.f21421a = r0;
                    r1.f21427g = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.e(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22256f(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21421a;
                    r0 = r0 | 64;
                    r1.f21421a = r0;
                    r1.f21428h = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.f(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
                }
            }

            public final /* synthetic */ com.google.protobuf.Message$Builder mo881s() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22280C();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.s():com.google.protobuf.Message$Builder");
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22280C();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.u():com.google.protobuf.MessageLite$Builder");
            }

            public PendingKeyExchange(com.google.protobuf.GeneratedMessage.Builder<?> r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = -1;
                r0 = 0;
                r2.<init>(r0);
                r2.memoizedIsInitialized = r1;
                r2.memoizedSerializedSize = r1;
                r0 = r3.mo868g();
                r2.unknownFields = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.<init>(com.google.protobuf.GeneratedMessage$Builder):void");
            }

            private PendingKeyExchange() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = -1;
                r2.<init>();
                r2.memoizedIsInitialized = r0;
                r2.memoizedSerializedSize = r0;
                r1 = com.google.protobuf.UnknownFieldSet.f21031a;
                r0 = r1;
                r2.unknownFields = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.<init>():void");
            }

            public final com.google.protobuf.AbstractMessage mo878v() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f21430c;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.v():com.google.protobuf.AbstractMessage");
            }

            public final com.google.protobuf.UnknownFieldSet mo868g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.unknownFields;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.g():com.google.protobuf.UnknownFieldSet");
            }

            public PendingKeyExchange(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r1 = 1;
                r0 = -1;
                r4.<init>();
                r4.memoizedIsInitialized = r0;
                r4.memoizedSerializedSize = r0;
                r4.m22278G();
                r2 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                r0 = 0;
            L_0x0011:
                if (r0 != 0) goto L_0x00a0;
            L_0x0013:
                r3 = r5.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                switch(r3) {
                    case 0: goto L_0x0022;
                    case 8: goto L_0x0024;
                    case 18: goto L_0x0042;
                    case 26: goto L_0x005e;
                    case 34: goto L_0x006b;
                    case 42: goto L_0x0078;
                    case 58: goto L_0x0085;
                    case 66: goto L_0x0092;
                    default: goto L_0x001a;
                };	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x001a:
                r3 = r4.mo889a(r5, r2, r6, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                if (r3 != 0) goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0020:
                r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0022:
                r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0024:
                r3 = r4.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r3 = r3 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r4.bitField0_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r3 = r5.m20220l();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r4.sequence_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                goto L_0x0011;
            L_0x0031:
                r0 = move-exception;
                r0 = r0.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0037:
                r0 = move-exception;
                r1 = r2.m21495b();
                r4.unknownFields = r1;
                r4.mo888E();
                throw r0;
            L_0x0042:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 2;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.localBaseKey_ = r3;	 Catch:{  }
                goto L_0x0011;
            L_0x004f:
                r0 = move-exception;
                r1 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r0 = r0.getMessage();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r1.<init>(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r0 = r1.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x005e:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 4;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.localBaseKeyPrivate_ = r3;	 Catch:{  }
                goto L_0x0011;	 Catch:{  }
            L_0x006b:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 8;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.localRatchetKey_ = r3;	 Catch:{  }
                goto L_0x0011;	 Catch:{  }
            L_0x0078:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 16;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.localRatchetKeyPrivate_ = r3;	 Catch:{  }
                goto L_0x0011;	 Catch:{  }
            L_0x0085:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 32;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.localIdentityKey_ = r3;	 Catch:{  }
                goto L_0x0011;	 Catch:{  }
            L_0x0092:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 64;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.localIdentityKeyPrivate_ = r3;	 Catch:{  }
                goto L_0x0011;
            L_0x00a0:
                r0 = r2.m21495b();
                r4.unknownFields = r0;
                r4.mo888E();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
            }

            protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo880h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.f21461j;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.class;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.class;
                r0 = r0.m21368a(r1, r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.h():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
            }

            static {
                PendingKeyExchange pendingKeyExchange = new PendingKeyExchange();
                f21430c = pendingKeyExchange;
                pendingKeyExchange.m22278G();
            }

            public final com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange> mo857i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f21429a;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.i():com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange>");
            }

            private void m22278G() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.sequence_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.localBaseKey_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.localBaseKeyPrivate_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.localRatchetKey_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.localRatchetKeyPrivate_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.localIdentityKey_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.localIdentityKeyPrivate_ = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.G():void");
            }

            public final boolean mo854a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 1;
                r1 = r3.memoizedIsInitialized;
                r2 = -1;
                if (r1 == r2) goto L_0x000b;
            L_0x0006:
                if (r1 != r0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r0 = 0;
                goto L_0x0008;
            L_0x000b:
                r3.memoizedIsInitialized = r0;
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.a():boolean");
            }

            public final void mo853a(com.google.protobuf.CodedOutputStream r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r4 = 8;
                r3 = 4;
                r2 = 2;
                r1 = 1;
                r5.mo855b();
                r0 = r5.bitField0_;
                r0 = r0 & 1;
                if (r0 != r1) goto L_0x0013;
            L_0x000e:
                r0 = r5.sequence_;
                r6.m20276c(r1, r0);
            L_0x0013:
                r0 = r5.bitField0_;
                r0 = r0 & 2;
                if (r0 != r2) goto L_0x001e;
            L_0x0019:
                r0 = r5.localBaseKey_;
                r6.m20264a(r2, r0);
            L_0x001e:
                r0 = r5.bitField0_;
                r0 = r0 & 4;
                if (r0 != r3) goto L_0x002a;
            L_0x0024:
                r0 = 3;
                r1 = r5.localBaseKeyPrivate_;
                r6.m20264a(r0, r1);
            L_0x002a:
                r0 = r5.bitField0_;
                r0 = r0 & 8;
                if (r0 != r4) goto L_0x0035;
            L_0x0030:
                r0 = r5.localRatchetKey_;
                r6.m20264a(r3, r0);
            L_0x0035:
                r0 = r5.bitField0_;
                r0 = r0 & 16;
                r1 = 16;
                if (r0 != r1) goto L_0x0043;
            L_0x003d:
                r0 = 5;
                r1 = r5.localRatchetKeyPrivate_;
                r6.m20264a(r0, r1);
            L_0x0043:
                r0 = r5.bitField0_;
                r0 = r0 & 32;
                r1 = 32;
                if (r0 != r1) goto L_0x0051;
            L_0x004b:
                r0 = 7;
                r1 = r5.localIdentityKey_;
                r6.m20264a(r0, r1);
            L_0x0051:
                r0 = r5.bitField0_;
                r0 = r0 & 64;
                r1 = 64;
                if (r0 != r1) goto L_0x005e;
            L_0x0059:
                r0 = r5.localIdentityKeyPrivate_;
                r6.m20264a(r4, r0);
            L_0x005e:
                r0 = r5.mo868g();
                r0.mo853a(r6);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.a(com.google.protobuf.CodedOutputStream):void");
            }

            public final int mo855b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r5 = 8;
                r4 = 4;
                r3 = 2;
                r2 = 1;
                r0 = r6.memoizedSerializedSize;
                r1 = -1;
                if (r0 == r1) goto L_0x000b;
            L_0x000a:
                return r0;
            L_0x000b:
                r0 = 0;
                r1 = r6.bitField0_;
                r1 = r1 & 1;
                if (r1 != r2) goto L_0x001a;
            L_0x0012:
                r0 = r6.sequence_;
                r0 = com.google.protobuf.CodedOutputStream.m20246g(r2, r0);
                r0 = r0 + 0;
            L_0x001a:
                r1 = r6.bitField0_;
                r1 = r1 & 2;
                if (r1 != r3) goto L_0x0027;
            L_0x0020:
                r1 = r6.localBaseKey_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r3, r1);
                r0 = r0 + r1;
            L_0x0027:
                r1 = r6.bitField0_;
                r1 = r1 & 4;
                if (r1 != r4) goto L_0x0035;
            L_0x002d:
                r1 = 3;
                r2 = r6.localBaseKeyPrivate_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r1, r2);
                r0 = r0 + r1;
            L_0x0035:
                r1 = r6.bitField0_;
                r1 = r1 & 8;
                if (r1 != r5) goto L_0x0042;
            L_0x003b:
                r1 = r6.localRatchetKey_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r4, r1);
                r0 = r0 + r1;
            L_0x0042:
                r1 = r6.bitField0_;
                r1 = r1 & 16;
                r2 = 16;
                if (r1 != r2) goto L_0x0052;
            L_0x004a:
                r1 = 5;
                r2 = r6.localRatchetKeyPrivate_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r1, r2);
                r0 = r0 + r1;
            L_0x0052:
                r1 = r6.bitField0_;
                r1 = r1 & 32;
                r2 = 32;
                if (r1 != r2) goto L_0x0062;
            L_0x005a:
                r1 = 7;
                r2 = r6.localIdentityKey_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r1, r2);
                r0 = r0 + r1;
            L_0x0062:
                r1 = r6.bitField0_;
                r1 = r1 & 64;
                r2 = 64;
                if (r1 != r2) goto L_0x0071;
            L_0x006a:
                r1 = r6.localIdentityKeyPrivate_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r5, r1);
                r0 = r0 + r1;
            L_0x0071:
                r1 = r6.mo868g();
                r1 = r1.mo855b();
                r0 = r0 + r1;
                r6.memoizedSerializedSize = r0;
                goto L_0x000a;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.b():int");
            }

            public final com.google.protobuf.Message$Builder mo882t() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.m22257u();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.t():com.google.protobuf.Message$Builder");
            }

            public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22279a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder.m22257u();
                r0 = r0.m22262a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.Builder m22280C() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = m22279a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.C():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder");
            }

            protected final com.google.protobuf.Message$Builder mo879a(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingKeyExchange$Builder;
                r1 = 0;
                r0.<init>(r3);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.a(com.google.protobuf.GeneratedMessage$BuilderParent):com.google.protobuf.Message$Builder");
            }
        }

        public interface PendingPreKeyOrBuilder extends MessageOrBuilder {
        }

        /* compiled from: actionId */
        public final class PendingPreKey extends GeneratedMessage implements PendingPreKeyOrBuilder {
            public static Parser<PendingPreKey> f21435a = new C24731();
            public static final PendingPreKey f21436c;
            public ByteString baseKey_;
            public int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            public int preKeyId_;
            public int signedPreKeyId_;
            private final UnknownFieldSet unknownFields;

            /* compiled from: actionId */
            final class C24731 extends AbstractParser<PendingPreKey> {
                C24731() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.1.<init>():void");
                }

                public final java.lang.Object mo859a(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey;
                    r1 = 0;
                    r0.<init>(r3, r4);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.1.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):java.lang.Object");
                }
            }

            /* compiled from: actionId */
            public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements PendingPreKeyOrBuilder {
                private int f21431a;
                private int f21432b;
                private int f21433c;
                private ByteString f21434d = ByteString.f20600a;

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22301a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21436c;
                    r0 = r1;
                    if (r4 != r0) goto L_0x0006;
                L_0x0005:
                    return r3;
                L_0x0006:
                    r0 = r4.m22328k();
                    if (r0 == 0) goto L_0x0012;
                L_0x000c:
                    r1 = r4.preKeyId_;
                    r0 = r1;
                    r3.m22299a(r0);
                L_0x0012:
                    r1 = r4.bitField0_;
                    r1 = r1 & 2;
                    r2 = 2;
                    if (r1 != r2) goto L_0x003c;
                L_0x0019:
                    r1 = 1;
                L_0x001a:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0023;
                L_0x001d:
                    r1 = r4.signedPreKeyId_;
                    r0 = r1;
                    r3.m22305b(r0);
                L_0x0023:
                    r1 = r4.bitField0_;
                    r1 = r1 & 4;
                    r2 = 4;
                    if (r1 != r2) goto L_0x003e;
                L_0x002a:
                    r1 = 1;
                L_0x002b:
                    r0 = r1;
                    if (r0 == 0) goto L_0x0034;
                L_0x002e:
                    r1 = r4.baseKey_;
                    r0 = r1;
                    r3.m22300a(r0);
                L_0x0034:
                    r0 = r4.mo868g();
                    r3.m20301c(r0);
                    goto L_0x0005;
                L_0x003c:
                    r1 = 0;
                    goto L_0x001a;
                L_0x003e:
                    r1 = 0;
                    goto L_0x002b;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }

                public final com.google.protobuf.AbstractMessage mo878v() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21436c;
                    r0 = r1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.v():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22293d(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.a(com.google.protobuf.AbstractMessage):com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22294d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.a(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22296x();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.b():com.google.protobuf.AbstractMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22294d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.b(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22296x();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.c():com.google.protobuf.AbstractMessageLite$Builder");
                }

                public final /* synthetic */ com.google.protobuf.Message$Builder mo849c(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22293d(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.c(com.google.protobuf.AbstractMessage):com.google.protobuf.Message$Builder");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22294d(r2, r3);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.c(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite$Builder");
                }

                public final /* synthetic */ java.lang.Object clone() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22296x();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.clone():java.lang.Object");
                }

                public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22296x();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.f():com.google.protobuf.GeneratedMessage$Builder");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage mo874h() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22317m();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.h():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage mo875i() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22316l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.i():com.google.protobuf.AbstractMessage");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite mo876j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22317m();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.j():com.google.protobuf.MessageLite");
                }

                public final /* synthetic */ com.google.protobuf.MessageLite mo877k() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m22316l();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.k():com.google.protobuf.MessageLite");
                }

                protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo872d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21463l;
                    r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.class;
                    r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.class;
                    r0 = r0.m21368a(r1, r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.d():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
                }

                private Builder() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.<init>();
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21434d = r0;
                    r1 = com.google.protobuf.GeneratedMessage.f20638b;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.<init>():void");
                }

                public Builder(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.<init>(r3);
                    r0 = com.google.protobuf.ByteString.f20600a;
                    r2.f21434d = r0;
                    r1 = com.google.protobuf.GeneratedMessage.f20638b;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.<init>(com.google.protobuf.GeneratedMessage$BuilderParent):void");
                }

                public static Builder m22295w() {
                    return new Builder();
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22296x() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = m22295w();
                    r1 = r2.m22317m();
                    r0 = r0.m22301a(r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.x():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }

                public final com.google.protobuf.Descriptors.Descriptor mo841e() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.f21462k;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.e():com.google.protobuf.Descriptors$Descriptor");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey m22316l() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.m22317m();
                    r1 = r0.mo854a();
                    if (r1 != 0) goto L_0x000f;
                L_0x000a:
                    r0 = com.google.protobuf.AbstractMessage.Builder.m20123b(r0);
                    throw r0;
                L_0x000f:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.l():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey m22317m() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = 1;
                    r1 = 0;
                    r2 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey;
                    r2.<init>(r5);
                    r3 = r5.f21431a;
                    r4 = r3 & 1;
                    if (r4 != r0) goto L_0x002d;
                L_0x000d:
                    r1 = r5.f21432b;
                    r2.preKeyId_ = r1;
                    r1 = r3 & 2;
                    r4 = 2;
                    if (r1 != r4) goto L_0x0018;
                L_0x0016:
                    r0 = r0 | 2;
                L_0x0018:
                    r1 = r5.f21433c;
                    r2.signedPreKeyId_ = r1;
                    r1 = r3 & 4;
                    r3 = 4;
                    if (r1 != r3) goto L_0x0023;
                L_0x0021:
                    r0 = r0 | 4;
                L_0x0023:
                    r1 = r5.f21434d;
                    r2.baseKey_ = r1;
                    r2.bitField0_ = r0;
                    r5.m20309p();
                    return r2;
                L_0x002d:
                    r0 = r1;
                    goto L_0x000d;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.m():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22293d(com.google.protobuf.AbstractMessage r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r2 instanceof org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey;
                    if (r0 == 0) goto L_0x000b;
                L_0x0004:
                    r2 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey) r2;
                    r1 = r1.m22301a(r2);
                L_0x000a:
                    return r1;
                L_0x000b:
                    super.mo870a(r2);
                    goto L_0x000a;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.d(com.google.protobuf.AbstractMessage):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }

                public final boolean mo854a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.a():boolean");
                }

                private org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22294d(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r2 = 0;
                    r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21435a;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    r0 = r0.mo859a(r5, r6);	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    if (r0 == 0) goto L_0x000e;
                L_0x000b:
                    r4.m22301a(r0);
                L_0x000e:
                    return r4;
                L_0x000f:
                    r0 = move-exception;
                    r1 = r0;
                    r0 = r1.m21375a();	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey) r0;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                    throw r1;	 Catch:{ InvalidProtocolBufferException -> 0x000f, InvalidProtocolBufferException -> 0x000f, all -> 0x0022, all -> 0x0018, all -> 0x0022, all -> 0x0018 }
                L_0x0018:
                    r1 = move-exception;
                    r3 = r1;
                    r1 = r0;
                    r0 = r3;
                L_0x001c:
                    if (r1 == 0) goto L_0x0021;
                L_0x001e:
                    r4.m22301a(r1);
                L_0x0021:
                    throw r0;
                L_0x0022:
                    r0 = move-exception;
                    r1 = r2;
                    goto L_0x001c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.d(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22299a(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f21431a;
                    r0 = r0 | 1;
                    r1.f21431a = r0;
                    r1.f21432b = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.a(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22305b(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.f21431a;
                    r0 = r0 | 2;
                    r1.f21431a = r0;
                    r1.f21433c = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.b(int):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }

                public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22300a(com.google.protobuf.ByteString r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    if (r2 != 0) goto L_0x0008;
                L_0x0002:
                    r0 = new java.lang.NullPointerException;
                    r0.<init>();
                    throw r0;
                L_0x0008:
                    r0 = r1.f21431a;
                    r0 = r0 | 4;
                    r1.f21431a = r0;
                    r1.f21434d = r2;
                    r1.m20312t();
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.a(com.google.protobuf.ByteString):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
                }
            }

            public final /* synthetic */ com.google.protobuf.Message$Builder mo881s() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22332q();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.s():com.google.protobuf.Message$Builder");
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m22332q();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.u():com.google.protobuf.MessageLite$Builder");
            }

            public PendingPreKey(com.google.protobuf.GeneratedMessage.Builder<?> r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = -1;
                r0 = 0;
                r2.<init>(r0);
                r2.memoizedIsInitialized = r1;
                r2.memoizedSerializedSize = r1;
                r0 = r3.mo868g();
                r2.unknownFields = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.<init>(com.google.protobuf.GeneratedMessage$Builder):void");
            }

            private PendingPreKey() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = -1;
                r2.<init>();
                r2.memoizedIsInitialized = r0;
                r2.memoizedSerializedSize = r0;
                r1 = com.google.protobuf.UnknownFieldSet.f21031a;
                r0 = r1;
                r2.unknownFields = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.<init>():void");
            }

            public final com.google.protobuf.AbstractMessage mo878v() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f21436c;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.v():com.google.protobuf.AbstractMessage");
            }

            public final com.google.protobuf.UnknownFieldSet mo868g() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.unknownFields;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.g():com.google.protobuf.UnknownFieldSet");
            }

            public PendingPreKey(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r1 = 1;
                r0 = -1;
                r4.<init>();
                r4.memoizedIsInitialized = r0;
                r4.memoizedSerializedSize = r0;
                r4.m22320x();
                r2 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                r0 = 0;
            L_0x0011:
                if (r0 != 0) goto L_0x006b;
            L_0x0013:
                r3 = r5.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                switch(r3) {
                    case 0: goto L_0x0022;
                    case 8: goto L_0x0024;
                    case 18: goto L_0x0042;
                    case 24: goto L_0x005e;
                    default: goto L_0x001a;
                };	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x001a:
                r3 = r4.mo889a(r5, r2, r6, r3);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                if (r3 != 0) goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0020:
                r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0022:
                r0 = r1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                goto L_0x0011;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0024:
                r3 = r4.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r3 = r3 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r4.bitField0_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r3 = r5.m20220l();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r4.preKeyId_ = r3;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                goto L_0x0011;
            L_0x0031:
                r0 = move-exception;
                r0 = r0.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x0037:
                r0 = move-exception;
                r1 = r2.m21495b();
                r4.unknownFields = r1;
                r4.mo888E();
                throw r0;
            L_0x0042:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 4;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20219k();	 Catch:{  }
                r4.baseKey_ = r3;	 Catch:{  }
                goto L_0x0011;
            L_0x004f:
                r0 = move-exception;
                r1 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r0 = r0.getMessage();	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r1.<init>(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                r0 = r1.m21374a(r4);	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
                throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, InvalidProtocolBufferException -> 0x0031, IOException -> 0x004f, all -> 0x0037, all -> 0x0037 }
            L_0x005e:
                r3 = r4.bitField0_;	 Catch:{  }
                r3 = r3 | 2;	 Catch:{  }
                r4.bitField0_ = r3;	 Catch:{  }
                r3 = r5.m20214f();	 Catch:{  }
                r4.signedPreKeyId_ = r3;	 Catch:{  }
                goto L_0x0011;
            L_0x006b:
                r0 = r2.m21495b();
                r4.unknownFields = r0;
                r4.mo888E();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
            }

            protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo880h() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.f21463l;
                r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.class;
                r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.class;
                r0 = r0.m21368a(r1, r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.h():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
            }

            static {
                PendingPreKey pendingPreKey = new PendingPreKey();
                f21436c = pendingPreKey;
                pendingPreKey.m22320x();
            }

            public final com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey> mo857i() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = f21435a;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.i():com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey>");
            }

            public final boolean m22328k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 1;
                r1 = r2.bitField0_;
                r1 = r1 & 1;
                if (r1 != r0) goto L_0x0008;
            L_0x0007:
                return r0;
            L_0x0008:
                r0 = 0;
                goto L_0x0007;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.k():boolean");
            }

            public final int m22329l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.preKeyId_;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.l():int");
            }

            public final int m22330n() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.signedPreKeyId_;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.n():int");
            }

            public final com.google.protobuf.ByteString m22331p() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.baseKey_;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.p():com.google.protobuf.ByteString");
            }

            private void m22320x() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.preKeyId_ = r0;
                r1.signedPreKeyId_ = r0;
                r0 = com.google.protobuf.ByteString.f20600a;
                r1.baseKey_ = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.x():void");
            }

            public final boolean mo854a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 1;
                r1 = r3.memoizedIsInitialized;
                r2 = -1;
                if (r1 == r2) goto L_0x000b;
            L_0x0006:
                if (r1 != r0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r0 = 0;
                goto L_0x0008;
            L_0x000b:
                r3.memoizedIsInitialized = r0;
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.a():boolean");
            }

            public final void mo853a(com.google.protobuf.CodedOutputStream r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r2 = 2;
                r1 = 1;
                r3.mo855b();
                r0 = r3.bitField0_;
                r0 = r0 & 1;
                if (r0 != r1) goto L_0x0010;
            L_0x000b:
                r0 = r3.preKeyId_;
                r4.m20276c(r1, r0);
            L_0x0010:
                r0 = r3.bitField0_;
                r0 = r0 & 4;
                r1 = 4;
                if (r0 != r1) goto L_0x001c;
            L_0x0017:
                r0 = r3.baseKey_;
                r4.m20264a(r2, r0);
            L_0x001c:
                r0 = r3.bitField0_;
                r0 = r0 & 2;
                if (r0 != r2) goto L_0x0028;
            L_0x0022:
                r0 = 3;
                r1 = r3.signedPreKeyId_;
                r4.m20262a(r0, r1);
            L_0x0028:
                r0 = r3.mo868g();
                r0.mo853a(r4);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.a(com.google.protobuf.CodedOutputStream):void");
            }

            public final int mo855b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r3 = 2;
                r2 = 1;
                r0 = r4.memoizedSerializedSize;
                r1 = -1;
                if (r0 == r1) goto L_0x0008;
            L_0x0007:
                return r0;
            L_0x0008:
                r0 = 0;
                r1 = r4.bitField0_;
                r1 = r1 & 1;
                if (r1 != r2) goto L_0x0017;
            L_0x000f:
                r0 = r4.preKeyId_;
                r0 = com.google.protobuf.CodedOutputStream.m20246g(r2, r0);
                r0 = r0 + 0;
            L_0x0017:
                r1 = r4.bitField0_;
                r1 = r1 & 4;
                r2 = 4;
                if (r1 != r2) goto L_0x0025;
            L_0x001e:
                r1 = r4.baseKey_;
                r1 = com.google.protobuf.CodedOutputStream.m20236c(r3, r1);
                r0 = r0 + r1;
            L_0x0025:
                r1 = r4.bitField0_;
                r1 = r1 & 2;
                if (r1 != r3) goto L_0x0033;
            L_0x002b:
                r1 = 3;
                r2 = r4.signedPreKeyId_;
                r1 = com.google.protobuf.CodedOutputStream.m20241e(r1, r2);
                r0 = r0 + r1;
            L_0x0033:
                r1 = r4.mo868g();
                r1 = r1.mo855b();
                r0 = r0 + r1;
                r4.memoizedSerializedSize = r0;
                goto L_0x0007;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.b():int");
            }

            public final com.google.protobuf.Message$Builder mo882t() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.m22295w();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.t():com.google.protobuf.Message$Builder");
            }

            public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22319a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder.m22295w();
                r0 = r0.m22301a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
            }

            public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.Builder m22332q() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = m22319a(r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.q():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder");
            }

            protected final com.google.protobuf.Message$Builder mo879a(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey$Builder;
                r1 = 0;
                r0.<init>(r3);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.a(com.google.protobuf.GeneratedMessage$BuilderParent):com.google.protobuf.Message$Builder");
            }
        }

        public final /* synthetic */ com.google.protobuf.Message$Builder mo881s() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m22342O();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.s():com.google.protobuf.Message$Builder");
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m22342O();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.u():com.google.protobuf.MessageLite$Builder");
        }

        public SessionStructure(com.google.protobuf.GeneratedMessage.Builder<?> r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r1 = -1;
            r0 = 0;
            r2.<init>(r0);
            r2.memoizedIsInitialized = r1;
            r2.memoizedSerializedSize = r1;
            r0 = r3.mo868g();
            r2.unknownFields = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.<init>(com.google.protobuf.GeneratedMessage$Builder):void");
        }

        private SessionStructure() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = -1;
            r2.<init>();
            r2.memoizedIsInitialized = r0;
            r2.memoizedSerializedSize = r0;
            r1 = com.google.protobuf.UnknownFieldSet.f21031a;
            r0 = r1;
            r2.unknownFields = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.<init>():void");
        }

        public final com.google.protobuf.AbstractMessage mo878v() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = f21438c;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.v():com.google.protobuf.AbstractMessage");
        }

        public final com.google.protobuf.UnknownFieldSet mo868g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.unknownFields;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.g():com.google.protobuf.UnknownFieldSet");
        }

        public SessionStructure(com.google.protobuf.CodedInputStream r9, com.google.protobuf.ExtensionRegistryLite r10) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r8 = this;
            r5 = 1;
            r0 = 0;
            r1 = -1;
            r3 = 0;
            r7 = 64;
            r8.<init>();
            r8.memoizedIsInitialized = r1;
            r8.memoizedSerializedSize = r1;
            r8.m22337S();
            r6 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            r4 = r0;
            r1 = r0;
        L_0x0016:
            if (r4 != 0) goto L_0x0170;
        L_0x0018:
            r0 = r9.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            switch(r0) {
                case 0: goto L_0x0027;
                case 8: goto L_0x0029;
                case 18: goto L_0x0053;
                case 26: goto L_0x006f;
                case 34: goto L_0x007c;
                case 40: goto L_0x0089;
                case 50: goto L_0x0096;
                case 58: goto L_0x00c4;
                case 66: goto L_0x00de;
                case 74: goto L_0x010a;
                case 80: goto L_0x0138;
                case 88: goto L_0x0146;
                case 96: goto L_0x0154;
                case 106: goto L_0x0162;
                default: goto L_0x001f;
            };	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
        L_0x001f:
            r0 = r8.mo889a(r9, r6, r10, r0);	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            if (r0 != 0) goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
        L_0x0025:
            r4 = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
        L_0x0027:
            r4 = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            goto L_0x0016;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
        L_0x0029:
            r0 = r8.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r0 = r0 | 1;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r8.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r0 = r9.m20220l();	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r8.sessionVersion_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            goto L_0x0016;
        L_0x0036:
            r0 = move-exception;
            r0 = r0.m21374a(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
        L_0x003c:
            r0 = move-exception;
            r1 = r1 & 64;
            if (r1 != r7) goto L_0x0049;
        L_0x0041:
            r1 = r8.receiverChains_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r8.receiverChains_ = r1;
        L_0x0049:
            r1 = r6.m21495b();
            r8.unknownFields = r1;
            r8.mo888E();
            throw r0;
        L_0x0053:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 2;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20219k();	 Catch:{  }
            r8.localIdentityPublic_ = r0;	 Catch:{  }
            goto L_0x0016;
        L_0x0060:
            r0 = move-exception;
            r2 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r0 = r0.getMessage();	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r2.<init>(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            r0 = r2.m21374a(r8);	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
            throw r0;	 Catch:{ InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, InvalidProtocolBufferException -> 0x0036, IOException -> 0x0060, all -> 0x003c, all -> 0x003c }
        L_0x006f:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 4;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20219k();	 Catch:{  }
            r8.remoteIdentityPublic_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x007c:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 8;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20219k();	 Catch:{  }
            r8.rootKey_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x0089:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 16;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20220l();	 Catch:{  }
            r8.previousCounter_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x0096:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 & 32;	 Catch:{  }
            r2 = 32;	 Catch:{  }
            if (r0 != r2) goto L_0x018b;	 Catch:{  }
        L_0x009e:
            r0 = r8.senderChain_;	 Catch:{  }
            r0 = r0.m22243r();	 Catch:{  }
            r2 = r0;	 Catch:{  }
        L_0x00a5:
            r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21419a;	 Catch:{  }
            r0 = r9.m20203a(r0, r10);	 Catch:{  }
            r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain) r0;	 Catch:{  }
            r8.senderChain_ = r0;	 Catch:{  }
            if (r2 == 0) goto L_0x00bc;	 Catch:{  }
        L_0x00b1:
            r0 = r8.senderChain_;	 Catch:{  }
            r2.m22134a(r0);	 Catch:{  }
            r0 = r2.m22150m();	 Catch:{  }
            r8.senderChain_ = r0;	 Catch:{  }
        L_0x00bc:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 32;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x00c4:
            r0 = r1 & 64;	 Catch:{  }
            if (r0 == r7) goto L_0x00d1;	 Catch:{  }
        L_0x00c8:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r8.receiverChains_ = r0;	 Catch:{  }
            r1 = r1 | 64;	 Catch:{  }
        L_0x00d1:
            r0 = r8.receiverChains_;	 Catch:{  }
            r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21419a;	 Catch:{  }
            r2 = r9.m20203a(r2, r10);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x00de:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 & 64;	 Catch:{  }
            if (r0 != r7) goto L_0x0188;	 Catch:{  }
        L_0x00e4:
            r0 = r8.pendingKeyExchange_;	 Catch:{  }
            r0 = r0.m22280C();	 Catch:{  }
            r2 = r0;	 Catch:{  }
        L_0x00eb:
            r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21429a;	 Catch:{  }
            r0 = r9.m20203a(r0, r10);	 Catch:{  }
            r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange) r0;	 Catch:{  }
            r8.pendingKeyExchange_ = r0;	 Catch:{  }
            if (r2 == 0) goto L_0x0102;	 Catch:{  }
        L_0x00f7:
            r0 = r8.pendingKeyExchange_;	 Catch:{  }
            r2.m22262a(r0);	 Catch:{  }
            r0 = r2.m22276l();	 Catch:{  }
            r8.pendingKeyExchange_ = r0;	 Catch:{  }
        L_0x0102:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 64;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x010a:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 & 128;	 Catch:{  }
            r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{  }
            if (r0 != r2) goto L_0x0186;	 Catch:{  }
        L_0x0112:
            r0 = r8.pendingPreKey_;	 Catch:{  }
            r0 = r0.m22332q();	 Catch:{  }
            r2 = r0;	 Catch:{  }
        L_0x0119:
            r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21435a;	 Catch:{  }
            r0 = r9.m20203a(r0, r10);	 Catch:{  }
            r0 = (org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey) r0;	 Catch:{  }
            r8.pendingPreKey_ = r0;	 Catch:{  }
            if (r2 == 0) goto L_0x0130;	 Catch:{  }
        L_0x0125:
            r0 = r8.pendingPreKey_;	 Catch:{  }
            r2.m22301a(r0);	 Catch:{  }
            r0 = r2.m22317m();	 Catch:{  }
            r8.pendingPreKey_ = r0;	 Catch:{  }
        L_0x0130:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 128;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x0138:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 256;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20220l();	 Catch:{  }
            r8.remoteRegistrationId_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x0146:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 512;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20220l();	 Catch:{  }
            r8.localRegistrationId_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x0154:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 1024;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20217i();	 Catch:{  }
            r8.needsRefresh_ = r0;	 Catch:{  }
            goto L_0x0016;	 Catch:{  }
        L_0x0162:
            r0 = r8.bitField0_;	 Catch:{  }
            r0 = r0 | 2048;	 Catch:{  }
            r8.bitField0_ = r0;	 Catch:{  }
            r0 = r9.m20219k();	 Catch:{  }
            r8.aliceBaseKey_ = r0;	 Catch:{  }
            goto L_0x0016;
        L_0x0170:
            r0 = r1 & 64;
            if (r0 != r7) goto L_0x017c;
        L_0x0174:
            r0 = r8.receiverChains_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r8.receiverChains_ = r0;
        L_0x017c:
            r0 = r6.m21495b();
            r8.unknownFields = r0;
            r8.mo888E();
            return;
        L_0x0186:
            r2 = r3;
            goto L_0x0119;
        L_0x0188:
            r2 = r3;
            goto L_0x00eb;
        L_0x018b:
            r2 = r3;
            goto L_0x00a5;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }

        protected final com.google.protobuf.GeneratedMessage.FieldAccessorTable mo880h() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = org.whispersystems.libsignal.state.StorageProtos.f21453b;
            r1 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.class;
            r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.class;
            r0 = r0.m21368a(r1, r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.h():com.google.protobuf.GeneratedMessage$FieldAccessorTable");
        }

        static {
            SessionStructure sessionStructure = new SessionStructure();
            f21438c = sessionStructure;
            sessionStructure.m22337S();
        }

        public final com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos.SessionStructure> mo857i() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = f21437a;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.i():com.google.protobuf.Parser<org.whispersystems.libsignal.state.StorageProtos$SessionStructure>");
        }

        public final com.google.protobuf.ByteString m22350n() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.localIdentityPublic_;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.n():com.google.protobuf.ByteString");
        }

        public final boolean m22351o() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.bitField0_;
            r0 = r0 & 4;
            r1 = 4;
            if (r0 != r1) goto L_0x0009;
        L_0x0007:
            r0 = 1;
        L_0x0008:
            return r0;
        L_0x0009:
            r0 = 0;
            goto L_0x0008;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.o():boolean");
        }

        public final com.google.protobuf.ByteString m22352p() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.remoteIdentityPublic_;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.p():com.google.protobuf.ByteString");
        }

        public final boolean m22357y() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.bitField0_;
            r0 = r0 & 32;
            r1 = 32;
            if (r0 != r1) goto L_0x000a;
        L_0x0008:
            r0 = 1;
        L_0x0009:
            return r0;
        L_0x000a:
            r0 = 0;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.y():boolean");
        }

        public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain m22358z() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.senderChain_;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.z():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain");
        }

        public final java.util.List<org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain> m22339A() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.receiverChains_;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.A():java.util.List<org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Chain>");
        }

        public final boolean m22340D() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.bitField0_;
            r0 = r0 & 128;
            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r0 != r1) goto L_0x000a;
        L_0x0008:
            r0 = 1;
        L_0x0009:
            return r0;
        L_0x000a:
            r0 = 0;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.D():boolean");
        }

        public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey m22341F() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.pendingPreKey_;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.F():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$PendingPreKey");
        }

        private void m22337S() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.sessionVersion_ = r1;
            r0 = com.google.protobuf.ByteString.f20600a;
            r3.localIdentityPublic_ = r0;
            r0 = com.google.protobuf.ByteString.f20600a;
            r3.remoteIdentityPublic_ = r0;
            r0 = com.google.protobuf.ByteString.f20600a;
            r3.rootKey_ = r0;
            r3.previousCounter_ = r1;
            r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.f21420c;
            r0 = r2;
            r3.senderChain_ = r0;
            r0 = java.util.Collections.emptyList();
            r3.receiverChains_ = r0;
            r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingKeyExchange.f21430c;
            r0 = r2;
            r3.pendingKeyExchange_ = r0;
            r2 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey.f21436c;
            r0 = r2;
            r3.pendingPreKey_ = r0;
            r3.remoteRegistrationId_ = r1;
            r3.localRegistrationId_ = r1;
            r3.needsRefresh_ = r1;
            r0 = com.google.protobuf.ByteString.f20600a;
            r3.aliceBaseKey_ = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.S():void");
        }

        public final boolean mo854a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = 1;
            r1 = r3.memoizedIsInitialized;
            r2 = -1;
            if (r1 == r2) goto L_0x000b;
        L_0x0006:
            if (r1 != r0) goto L_0x0009;
        L_0x0008:
            return r0;
        L_0x0009:
            r0 = 0;
            goto L_0x0008;
        L_0x000b:
            r3.memoizedIsInitialized = r0;
            goto L_0x0008;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.a():boolean");
        }

        public final void mo853a(com.google.protobuf.CodedOutputStream r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r5 = this;
            r4 = 8;
            r3 = 4;
            r2 = 2;
            r1 = 1;
            r5.mo855b();
            r0 = r5.bitField0_;
            r0 = r0 & 1;
            if (r0 != r1) goto L_0x0013;
        L_0x000e:
            r0 = r5.sessionVersion_;
            r6.m20276c(r1, r0);
        L_0x0013:
            r0 = r5.bitField0_;
            r0 = r0 & 2;
            if (r0 != r2) goto L_0x001e;
        L_0x0019:
            r0 = r5.localIdentityPublic_;
            r6.m20264a(r2, r0);
        L_0x001e:
            r0 = r5.bitField0_;
            r0 = r0 & 4;
            if (r0 != r3) goto L_0x002a;
        L_0x0024:
            r0 = 3;
            r1 = r5.remoteIdentityPublic_;
            r6.m20264a(r0, r1);
        L_0x002a:
            r0 = r5.bitField0_;
            r0 = r0 & 8;
            if (r0 != r4) goto L_0x0035;
        L_0x0030:
            r0 = r5.rootKey_;
            r6.m20264a(r3, r0);
        L_0x0035:
            r0 = r5.bitField0_;
            r0 = r0 & 16;
            r1 = 16;
            if (r0 != r1) goto L_0x0043;
        L_0x003d:
            r0 = 5;
            r1 = r5.previousCounter_;
            r6.m20276c(r0, r1);
        L_0x0043:
            r0 = r5.bitField0_;
            r0 = r0 & 32;
            r1 = 32;
            if (r0 != r1) goto L_0x0051;
        L_0x004b:
            r0 = 6;
            r1 = r5.senderChain_;
            r6.m20273b(r0, r1);
        L_0x0051:
            r0 = 0;
            r1 = r0;
        L_0x0053:
            r0 = r5.receiverChains_;
            r0 = r0.size();
            if (r1 >= r0) goto L_0x006b;
        L_0x005b:
            r2 = 7;
            r0 = r5.receiverChains_;
            r0 = r0.get(r1);
            r0 = (com.google.protobuf.MessageLite) r0;
            r6.m20273b(r2, r0);
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0053;
        L_0x006b:
            r0 = r5.bitField0_;
            r0 = r0 & 64;
            r1 = 64;
            if (r0 != r1) goto L_0x0078;
        L_0x0073:
            r0 = r5.pendingKeyExchange_;
            r6.m20273b(r4, r0);
        L_0x0078:
            r0 = r5.bitField0_;
            r0 = r0 & 128;
            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r0 != r1) goto L_0x0087;
        L_0x0080:
            r0 = 9;
            r1 = r5.pendingPreKey_;
            r6.m20273b(r0, r1);
        L_0x0087:
            r0 = r5.bitField0_;
            r0 = r0 & 256;
            r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r0 != r1) goto L_0x0096;
        L_0x008f:
            r0 = 10;
            r1 = r5.remoteRegistrationId_;
            r6.m20276c(r0, r1);
        L_0x0096:
            r0 = r5.bitField0_;
            r0 = r0 & 512;
            r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r0 != r1) goto L_0x00a5;
        L_0x009e:
            r0 = 11;
            r1 = r5.localRegistrationId_;
            r6.m20276c(r0, r1);
        L_0x00a5:
            r0 = r5.bitField0_;
            r0 = r0 & 1024;
            r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r0 != r1) goto L_0x00b4;
        L_0x00ad:
            r0 = 12;
            r1 = r5.needsRefresh_;
            r6.m20266a(r0, r1);
        L_0x00b4:
            r0 = r5.bitField0_;
            r0 = r0 & 2048;
            r1 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
            if (r0 != r1) goto L_0x00c3;
        L_0x00bc:
            r0 = 13;
            r1 = r5.aliceBaseKey_;
            r6.m20264a(r0, r1);
        L_0x00c3:
            r0 = r5.mo868g();
            r0.mo853a(r6);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.a(com.google.protobuf.CodedOutputStream):void");
        }

        public final int mo855b() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r6 = 8;
            r5 = 4;
            r4 = 2;
            r3 = 1;
            r1 = 0;
            r0 = r7.memoizedSerializedSize;
            r2 = -1;
            if (r0 == r2) goto L_0x000c;
        L_0x000b:
            return r0;
        L_0x000c:
            r0 = r7.bitField0_;
            r0 = r0 & 1;
            if (r0 != r3) goto L_0x00ee;
        L_0x0012:
            r0 = r7.sessionVersion_;
            r0 = com.google.protobuf.CodedOutputStream.m20246g(r3, r0);
            r0 = r0 + 0;
        L_0x001a:
            r2 = r7.bitField0_;
            r2 = r2 & 2;
            if (r2 != r4) goto L_0x0027;
        L_0x0020:
            r2 = r7.localIdentityPublic_;
            r2 = com.google.protobuf.CodedOutputStream.m20236c(r4, r2);
            r0 = r0 + r2;
        L_0x0027:
            r2 = r7.bitField0_;
            r2 = r2 & 4;
            if (r2 != r5) goto L_0x0035;
        L_0x002d:
            r2 = 3;
            r3 = r7.remoteIdentityPublic_;
            r2 = com.google.protobuf.CodedOutputStream.m20236c(r2, r3);
            r0 = r0 + r2;
        L_0x0035:
            r2 = r7.bitField0_;
            r2 = r2 & 8;
            if (r2 != r6) goto L_0x0042;
        L_0x003b:
            r2 = r7.rootKey_;
            r2 = com.google.protobuf.CodedOutputStream.m20236c(r5, r2);
            r0 = r0 + r2;
        L_0x0042:
            r2 = r7.bitField0_;
            r2 = r2 & 16;
            r3 = 16;
            if (r2 != r3) goto L_0x0052;
        L_0x004a:
            r2 = 5;
            r3 = r7.previousCounter_;
            r2 = com.google.protobuf.CodedOutputStream.m20246g(r2, r3);
            r0 = r0 + r2;
        L_0x0052:
            r2 = r7.bitField0_;
            r2 = r2 & 32;
            r3 = 32;
            if (r2 != r3) goto L_0x0062;
        L_0x005a:
            r2 = 6;
            r3 = r7.senderChain_;
            r2 = com.google.protobuf.CodedOutputStream.m20242e(r2, r3);
            r0 = r0 + r2;
        L_0x0062:
            r2 = r0;
        L_0x0063:
            r0 = r7.receiverChains_;
            r0 = r0.size();
            if (r1 >= r0) goto L_0x007d;
        L_0x006b:
            r3 = 7;
            r0 = r7.receiverChains_;
            r0 = r0.get(r1);
            r0 = (com.google.protobuf.MessageLite) r0;
            r0 = com.google.protobuf.CodedOutputStream.m20242e(r3, r0);
            r0 = r0 + r2;
            r1 = r1 + 1;
            r2 = r0;
            goto L_0x0063;
        L_0x007d:
            r0 = r7.bitField0_;
            r0 = r0 & 64;
            r1 = 64;
            if (r0 != r1) goto L_0x008c;
        L_0x0085:
            r0 = r7.pendingKeyExchange_;
            r0 = com.google.protobuf.CodedOutputStream.m20242e(r6, r0);
            r2 = r2 + r0;
        L_0x008c:
            r0 = r7.bitField0_;
            r0 = r0 & 128;
            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r0 != r1) goto L_0x009d;
        L_0x0094:
            r0 = 9;
            r1 = r7.pendingPreKey_;
            r0 = com.google.protobuf.CodedOutputStream.m20242e(r0, r1);
            r2 = r2 + r0;
        L_0x009d:
            r0 = r7.bitField0_;
            r0 = r0 & 256;
            r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r0 != r1) goto L_0x00ae;
        L_0x00a5:
            r0 = 10;
            r1 = r7.remoteRegistrationId_;
            r0 = com.google.protobuf.CodedOutputStream.m20246g(r0, r1);
            r2 = r2 + r0;
        L_0x00ae:
            r0 = r7.bitField0_;
            r0 = r0 & 512;
            r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r0 != r1) goto L_0x00bf;
        L_0x00b6:
            r0 = 11;
            r1 = r7.localRegistrationId_;
            r0 = com.google.protobuf.CodedOutputStream.m20246g(r0, r1);
            r2 = r2 + r0;
        L_0x00bf:
            r0 = r7.bitField0_;
            r0 = r0 & 1024;
            r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r0 != r1) goto L_0x00d0;
        L_0x00c7:
            r0 = 12;
            r1 = r7.needsRefresh_;
            r0 = com.google.protobuf.CodedOutputStream.m20231b(r0, r1);
            r2 = r2 + r0;
        L_0x00d0:
            r0 = r7.bitField0_;
            r0 = r0 & 2048;
            r1 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
            if (r0 != r1) goto L_0x00e1;
        L_0x00d8:
            r0 = 13;
            r1 = r7.aliceBaseKey_;
            r0 = com.google.protobuf.CodedOutputStream.m20236c(r0, r1);
            r2 = r2 + r0;
        L_0x00e1:
            r0 = r7.mo868g();
            r0 = r0.mo855b();
            r0 = r0 + r2;
            r7.memoizedSerializedSize = r0;
            goto L_0x000b;
        L_0x00ee:
            r0 = r1;
            goto L_0x001a;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.b():int");
        }

        public final com.google.protobuf.Message$Builder mo882t() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.m22085x();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.t():com.google.protobuf.Message$Builder");
        }

        public static org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22338a(org.whispersystems.libsignal.state.StorageProtos.SessionStructure r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder.m22085x();
            r0 = r0.m22094a(r1);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.a(org.whispersystems.libsignal.state.StorageProtos$SessionStructure):org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
        }

        public final org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder m22342O() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = m22338a(r1);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.O():org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder");
        }

        protected final com.google.protobuf.Message$Builder mo879a(com.google.protobuf.GeneratedMessage.BuilderParent r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = new org.whispersystems.libsignal.state.StorageProtos$SessionStructure$Builder;
            r1 = 0;
            r0.<init>(r3);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.whispersystems.libsignal.state.StorageProtos.SessionStructure.a(com.google.protobuf.GeneratedMessage$BuilderParent):com.google.protobuf.Message$Builder");
        }
    }

    public interface SignedPreKeyRecordStructureOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: actionId */
    public final class SignedPreKeyRecordStructure extends GeneratedMessage implements SignedPreKeyRecordStructureOrBuilder {
        public static Parser<SignedPreKeyRecordStructure> f21445a = new C24741();
        public static final SignedPreKeyRecordStructure f21446c;
        public int bitField0_;
        public int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public ByteString privateKey_;
        public ByteString publicKey_;
        public ByteString signature_;
        public long timestamp_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: actionId */
        final class C24741 extends AbstractParser<SignedPreKeyRecordStructure> {
            C24741() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new SignedPreKeyRecordStructure(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: actionId */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements SignedPreKeyRecordStructureOrBuilder {
            private int f21439a;
            private int f21440b;
            private ByteString f21441c = ByteString.f20600a;
            private ByteString f21442d = ByteString.f20600a;
            private ByteString f21443e = ByteString.f20600a;
            private long f21444f;

            public final Builder m22370a(SignedPreKeyRecordStructure signedPreKeyRecordStructure) {
                if (signedPreKeyRecordStructure != SignedPreKeyRecordStructure.f21446c) {
                    Object obj = 1;
                    if ((signedPreKeyRecordStructure.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        m22367a(signedPreKeyRecordStructure.id_);
                    }
                    if ((signedPreKeyRecordStructure.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m22369a(signedPreKeyRecordStructure.publicKey_);
                    }
                    if ((signedPreKeyRecordStructure.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m22374b(signedPreKeyRecordStructure.privateKey_);
                    }
                    if ((signedPreKeyRecordStructure.bitField0_ & 8) == 8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m22378c(signedPreKeyRecordStructure.signature_);
                    }
                    if ((signedPreKeyRecordStructure.bitField0_ & 16) == 16) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m22368a(signedPreKeyRecordStructure.timestamp_);
                    }
                    m20301c(signedPreKeyRecordStructure.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return SignedPreKeyRecordStructure.f21446c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m22360d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m22361d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m22363w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m22361d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m22363w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m22360d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m22361d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m22363w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m22363w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m22364y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m22386l();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m22364y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m22386l();
            }

            protected final FieldAccessorTable mo872d() {
                return StorageProtos.f21469r.m21368a(SignedPreKeyRecordStructure.class, Builder.class);
            }

            private Builder() {
                boolean z = GeneratedMessage.f20638b;
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                boolean z = GeneratedMessage.f20638b;
            }

            public static Builder m22362u() {
                return new Builder();
            }

            private Builder m22363w() {
                return m22362u().m22370a(m22364y());
            }

            public final Descriptor mo841e() {
                return StorageProtos.f21468q;
            }

            public final SignedPreKeyRecordStructure m22386l() {
                AbstractMessage y = m22364y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private SignedPreKeyRecordStructure m22364y() {
                int i = 1;
                SignedPreKeyRecordStructure signedPreKeyRecordStructure = new SignedPreKeyRecordStructure(this);
                int i2 = this.f21439a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                signedPreKeyRecordStructure.id_ = this.f21440b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                signedPreKeyRecordStructure.publicKey_ = this.f21441c;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                signedPreKeyRecordStructure.privateKey_ = this.f21442d;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                signedPreKeyRecordStructure.signature_ = this.f21443e;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                signedPreKeyRecordStructure.timestamp_ = this.f21444f;
                signedPreKeyRecordStructure.bitField0_ = i;
                m20309p();
                return signedPreKeyRecordStructure;
            }

            private Builder m22360d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof SignedPreKeyRecordStructure) {
                    return m22370a((SignedPreKeyRecordStructure) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m22361d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                SignedPreKeyRecordStructure signedPreKeyRecordStructure;
                SignedPreKeyRecordStructure signedPreKeyRecordStructure2;
                try {
                    signedPreKeyRecordStructure2 = (SignedPreKeyRecordStructure) SignedPreKeyRecordStructure.f21445a.mo859a(codedInputStream, extensionRegistryLite);
                    if (signedPreKeyRecordStructure2 != null) {
                        m22370a(signedPreKeyRecordStructure2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    signedPreKeyRecordStructure2 = (SignedPreKeyRecordStructure) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    signedPreKeyRecordStructure = signedPreKeyRecordStructure2;
                    th = th3;
                }
                if (signedPreKeyRecordStructure != null) {
                    m22370a(signedPreKeyRecordStructure);
                }
                throw th;
            }

            public final Builder m22367a(int i) {
                this.f21439a |= 1;
                this.f21440b = i;
                m20312t();
                return this;
            }

            public final Builder m22369a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21439a |= 2;
                this.f21441c = byteString;
                m20312t();
                return this;
            }

            public final Builder m22374b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21439a |= 4;
                this.f21442d = byteString;
                m20312t();
                return this;
            }

            public final Builder m22378c(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f21439a |= 8;
                this.f21443e = byteString;
                m20312t();
                return this;
            }

            public final Builder m22368a(long j) {
                this.f21439a |= 16;
                this.f21444f = j;
                m20312t();
                return this;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m22389a(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m22389a(this);
        }

        public SignedPreKeyRecordStructure(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private SignedPreKeyRecordStructure() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f21446c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public SignedPreKeyRecordStructure(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m22388A();
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
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.m20220l();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.publicKey_ = codedInputStream.m20219k();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.privateKey_ = codedInputStream.m20219k();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.signature_ = codedInputStream.m20219k();
                            break;
                        case 41:
                            this.bitField0_ |= 16;
                            this.timestamp_ = codedInputStream.m20215g();
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
            return StorageProtos.f21469r.m21368a(SignedPreKeyRecordStructure.class, Builder.class);
        }

        static {
            SignedPreKeyRecordStructure signedPreKeyRecordStructure = new SignedPreKeyRecordStructure();
            f21446c = signedPreKeyRecordStructure;
            signedPreKeyRecordStructure.m22388A();
        }

        public final Parser<SignedPreKeyRecordStructure> mo857i() {
            return f21445a;
        }

        public final ByteString m22397n() {
            return this.publicKey_;
        }

        public final ByteString m22398p() {
            return this.privateKey_;
        }

        private void m22388A() {
            this.id_ = 0;
            this.publicKey_ = ByteString.f20600a;
            this.privateKey_ = ByteString.f20600a;
            this.signature_ = ByteString.f20600a;
            this.timestamp_ = 0;
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
                codedOutputStream.m20276c(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20264a(2, this.publicKey_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20264a(3, this.privateKey_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20264a(4, this.signature_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m20277c(5, this.timestamp_);
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
                i = CodedOutputStream.m20246g(1, this.id_) + 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20236c(2, this.publicKey_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20236c(3, this.privateKey_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.m20236c(4, this.signature_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.m20243f(5, this.timestamp_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public final Message$Builder mo882t() {
            return Builder.m22362u();
        }

        private static Builder m22389a(SignedPreKeyRecordStructure signedPreKeyRecordStructure) {
            return Builder.m22362u().m22370a(signedPreKeyRecordStructure);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    private StorageProtos() {
    }

    static {
        FileDescriptor.m21250a(new String[]{"\n\u001aLocalStorageProtocol.proto\u0012\ntextsecure\"Ó\b\n\u0010SessionStructure\u0012\u0016\n\u000esessionVersion\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013localIdentityPublic\u0018\u0002 \u0001(\f\u0012\u001c\n\u0014remoteIdentityPublic\u0018\u0003 \u0001(\f\u0012\u000f\n\u0007rootKey\u0018\u0004 \u0001(\f\u0012\u0017\n\u000fpreviousCounter\u0018\u0005 \u0001(\r\u00127\n\u000bsenderChain\u0018\u0006 \u0001(\u000b2\".textsecure.SessionStructure.Chain\u0012:\n\u000ereceiverChains\u0018\u0007 \u0003(\u000b2\".textsecure.SessionStructure.Chain\u0012K\n\u0012pendingKeyExchange\u0018\b \u0001(\u000b2/.textsecure.SessionStructure.PendingKeyExchange\u0012A\n\rpendingPreKey\u0018\t ", "\u0001(\u000b2*.textsecure.SessionStructure.PendingPreKey\u0012\u001c\n\u0014remoteRegistrationId\u0018\n \u0001(\r\u0012\u001b\n\u0013localRegistrationId\u0018\u000b \u0001(\r\u0012\u0014\n\fneedsRefresh\u0018\f \u0001(\b\u0012\u0014\n\faliceBaseKey\u0018\r \u0001(\f\u001a¹\u0002\n\u0005Chain\u0012\u0018\n\u0010senderRatchetKey\u0018\u0001 \u0001(\f\u0012\u001f\n\u0017senderRatchetKeyPrivate\u0018\u0002 \u0001(\f\u0012=\n\bchainKey\u0018\u0003 \u0001(\u000b2+.textsecure.SessionStructure.Chain.ChainKey\u0012B\n\u000bmessageKeys\u0018\u0004 \u0003(\u000b2-.textsecure.SessionStructure.Chain.MessageKey\u001a&\n\bChainKey\u0012\r\n\u0005index\u0018\u0001 \u0001(\r\u0012\u000b\n\u0003key\u0018\u0002 \u0001(\f\u001aJ\n\nMessag", "eKey\u0012\r\n\u0005index\u0018\u0001 \u0001(\r\u0012\u0011\n\tcipherKey\u0018\u0002 \u0001(\f\u0012\u000e\n\u0006macKey\u0018\u0003 \u0001(\f\u0012\n\n\u0002iv\u0018\u0004 \u0001(\f\u001aÍ\u0001\n\u0012PendingKeyExchange\u0012\u0010\n\bsequence\u0018\u0001 \u0001(\r\u0012\u0014\n\flocalBaseKey\u0018\u0002 \u0001(\f\u0012\u001b\n\u0013localBaseKeyPrivate\u0018\u0003 \u0001(\f\u0012\u0017\n\u000flocalRatchetKey\u0018\u0004 \u0001(\f\u0012\u001e\n\u0016localRatchetKeyPrivate\u0018\u0005 \u0001(\f\u0012\u0018\n\u0010localIdentityKey\u0018\u0007 \u0001(\f\u0012\u001f\n\u0017localIdentityKeyPrivate\u0018\b \u0001(\f\u001aJ\n\rPendingPreKey\u0012\u0010\n\bpreKeyId\u0018\u0001 \u0001(\r\u0012\u0016\n\u000esignedPreKeyId\u0018\u0003 \u0001(\u0005\u0012\u000f\n\u0007baseKey\u0018\u0002 \u0001(\f\"\n\u000fRecordStructure\u00124\n\u000ecurrentSession\u0018\u0001 \u0001(\u000b2\u001c.text", "secure.SessionStructure\u00126\n\u0010previousSessions\u0018\u0002 \u0003(\u000b2\u001c.textsecure.SessionStructure\"J\n\u0015PreKeyRecordStructure\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0011\n\tpublicKey\u0018\u0002 \u0001(\f\u0012\u0012\n\nprivateKey\u0018\u0003 \u0001(\f\"v\n\u001bSignedPreKeyRecordStructure\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0011\n\tpublicKey\u0018\u0002 \u0001(\f\u0012\u0012\n\nprivateKey\u0018\u0003 \u0001(\f\u0012\u0011\n\tsignature\u0018\u0004 \u0001(\f\u0012\u0011\n\ttimestamp\u0018\u0005 \u0001(\u0006\"A\n\u0018IdentityKeyPairStructure\u0012\u0011\n\tpublicKey\u0018\u0001 \u0001(\f\u0012\u0012\n\nprivateKey\u0018\u0002 \u0001(\f\"¸\u0003\n\u0017SenderKeyStateStructure\u0012\u0013\n\u000bsenderKeyId\u0018\u0001 \u0001(\r\u0012J\n\u000esende", "rChainKey\u0018\u0002 \u0001(\u000b22.textsecure.SenderKeyStateStructure.SenderChainKey\u0012N\n\u0010senderSigningKey\u0018\u0003 \u0001(\u000b24.textsecure.SenderKeyStateStructure.SenderSigningKey\u0012O\n\u0011senderMessageKeys\u0018\u0004 \u0003(\u000b24.textsecure.SenderKeyStateStructure.SenderMessageKey\u001a1\n\u000eSenderChainKey\u0012\u0011\n\titeration\u0018\u0001 \u0001(\r\u0012\f\n\u0004seed\u0018\u0002 \u0001(\f\u001a3\n\u0010SenderMessageKey\u0012\u0011\n\titeration\u0018\u0001 \u0001(\r\u0012\f\n\u0004seed\u0018\u0002 \u0001(\f\u001a3\n\u0010SenderSigningKey\u0012\u000e\n\u0006public\u0018\u0001 \u0001(\f\u0012\u000f\n\u0007private\u0018\u0002 \u0001(\f\"X\n\u0018SenderKeyRe", "cordStructure\u0012<\n\u000fsenderKeyStates\u0018\u0001 \u0003(\u000b2#.textsecure.SenderKeyStateStructureB3\n\"org.whispersystems.libsignal.stateB\rStorageProtos"}, new FileDescriptor[0], new C24641());
    }
}
