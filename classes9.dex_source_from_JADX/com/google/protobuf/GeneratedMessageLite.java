package com.google.protobuf;

import com.google.protobuf.MessageLite.Builder;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* compiled from: amount_fb_discount */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* compiled from: amount_fb_discount */
    final class SerializedForm implements Serializable {
        private byte[] asBytes;
        private String messageClassName;

        SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.lP_();
        }

        protected final Object readResolve() {
            try {
                Builder builder = (Builder) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                builder.mo839b(this.asBytes);
                return builder.mo876j();
            } catch (Throwable e) {
                throw new RuntimeException("Unable to find proto buffer class", e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to find newBuilder method", e2);
            } catch (Throwable e22) {
                throw new RuntimeException("Unable to call newBuilder method", e22);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Error calling newBuilder", e3.getCause());
            } catch (Throwable e222) {
                throw new RuntimeException("Unable to understand proto buffer", e222);
            }
        }
    }

    protected GeneratedMessageLite() {
    }

    protected Object writeReplace() {
        return new SerializedForm(this);
    }
}
