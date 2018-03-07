package com.facebook.tigon.httpclientadapter;

import com.facebook.tigon.tigonapi.TigonBodyProvider;
import com.facebook.tigon.tigonapi.TigonBodyStream;
import com.facebook.tigon.tigonapi.TigonError;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.apache.http.HttpEntity;

/* compiled from: not_tried */
public class TigonHttpEntityBodyProvider implements TigonBodyProvider {
    public final HttpEntity f4969a;
    private final Executor f4970b;

    /* compiled from: not_tried */
    class EntityOutputStream extends OutputStream {
        final /* synthetic */ TigonHttpEntityBodyProvider f4963a;
        private final TigonBodyStream f4964b;
        private ByteBuffer f4965c = ByteBuffer.allocateDirect(4096);
        private boolean f4966d;

        public EntityOutputStream(TigonHttpEntityBodyProvider tigonHttpEntityBodyProvider, TigonBodyStream tigonBodyStream) {
            this.f4963a = tigonHttpEntityBodyProvider;
            this.f4964b = tigonBodyStream;
        }

        public void write(int i) {
            m6241c();
            if (!this.f4966d) {
                Preconditions.checkState(this.f4965c.hasRemaining());
                this.f4965c.put((byte) i);
            }
        }

        public void write(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                m6241c();
                if (!this.f4966d) {
                    Preconditions.checkState(this.f4965c.hasRemaining());
                    int min = Math.min(this.f4965c.remaining(), i2);
                    this.f4965c.put(bArr, i, min);
                    i += min;
                    i2 -= min;
                } else {
                    return;
                }
            }
        }

        private void m6241c() {
            if (!this.f4965c.hasRemaining()) {
                m6242a();
                this.f4965c = ByteBuffer.allocateDirect(4096);
            }
        }

        public final void m6242a() {
            if (this.f4965c.position() > 0 && 1 == this.f4964b.mo129a(this.f4965c, this.f4965c.position())) {
                this.f4966d = true;
            }
        }

        public final boolean m6243b() {
            return this.f4966d;
        }
    }

    /* compiled from: not_tried */
    class EntityReader implements Runnable {
        final /* synthetic */ TigonHttpEntityBodyProvider f4967a;
        private final TigonBodyStream f4968b;

        public EntityReader(TigonHttpEntityBodyProvider tigonHttpEntityBodyProvider, TigonBodyStream tigonBodyStream) {
            this.f4967a = tigonHttpEntityBodyProvider;
            this.f4968b = tigonBodyStream;
        }

        public void run() {
            try {
                OutputStream entityOutputStream = new EntityOutputStream(this.f4967a, this.f4968b);
                this.f4967a.f4969a.writeTo(entityOutputStream);
                entityOutputStream.m6242a();
                if (!entityOutputStream.m6243b()) {
                    this.f4968b.mo130a();
                }
            } catch (IOException e) {
                this.f4968b.mo131a(new TigonError(3, "TigonHttpEntityBodyProviderDomain", 0, e.toString()));
            }
        }
    }

    public TigonHttpEntityBodyProvider(HttpEntity httpEntity, Executor executor) {
        this.f4969a = httpEntity;
        this.f4970b = executor;
    }

    public void beginStream(TigonBodyStream tigonBodyStream) {
        ExecutorDetour.a(this.f4970b, new EntityReader(this, tigonBodyStream), -784179982);
    }
}
