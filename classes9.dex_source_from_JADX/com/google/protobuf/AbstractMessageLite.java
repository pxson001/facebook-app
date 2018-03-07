package com.google.protobuf;

import java.util.Collection;

/* compiled from: android.intent.action.AIRPLANE_MODE */
public abstract class AbstractMessageLite implements MessageLite {

    /* compiled from: android.intent.action.AIRPLANE_MODE */
    public abstract class Builder<BuilderType extends Builder> implements com.google.protobuf.MessageLite.Builder {
        public abstract BuilderType mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        public abstract BuilderType mo848c();

        public BuilderType mo843a(CodedInputStream codedInputStream) {
            return mo846b(codedInputStream, ExtensionRegistryLite.f20905c);
        }

        public /* synthetic */ com.google.protobuf.MessageLite.Builder mo839b(byte[] bArr) {
            return mo844a(bArr);
        }

        public /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return mo846b(codedInputStream, extensionRegistryLite);
        }

        public /* synthetic */ Object clone() {
            return mo848c();
        }

        public BuilderType mo842a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            try {
                CodedInputStream h = byteString.mo918h();
                mo846b(h, extensionRegistryLite);
                h.m20204a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Throwable e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        public BuilderType mo844a(byte[] bArr) {
            return mo845a(bArr, 0, bArr.length);
        }

        public BuilderType mo845a(byte[] bArr, int i, int i2) {
            try {
                CodedInputStream a = CodedInputStream.m20192a(bArr, i, i2);
                mo843a(a);
                a.m20204a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Throwable e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        protected static <T> void m20091a(Iterable<T> iterable, Collection<? super T> collection) {
            if (iterable instanceof LazyStringList) {
                mo938a(((LazyStringList) iterable).mo906a());
            } else {
                mo938a((Iterable) iterable);
            }
            if (iterable instanceof Collection) {
                collection.addAll((Collection) iterable);
                return;
            }
            for (T add : iterable) {
                collection.add(add);
            }
        }

        private static void mo938a(Iterable<?> iterable) {
            for (Object obj : iterable) {
                if (obj == null) {
                    throw new NullPointerException();
                }
            }
        }
    }

    public final ByteString mo851d() {
        try {
            CodedBuilder b = ByteString.m20176b(mo855b());
            mo853a(b.m20172b());
            return b.m20171a();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] lP_() {
        try {
            byte[] bArr = new byte[mo855b()];
            CodedOutputStream a = CodedOutputStream.m20228a(bArr);
            mo853a(a);
            a.m20284h();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    UninitializedMessageException mo856c() {
        return new UninitializedMessageException();
    }
}
