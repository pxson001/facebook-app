package com.facebook.analytics2.logger;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.analytics2.logger.CrossProcessBatchLockState.FailedFileCreationException;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: tab_src_position */
public final class EventProcessor {
    public final WriterHandler f3343a;
    @Nullable
    public final EventListener f3344b;
    public final EventBatchStoreManagerFactory f3345c;
    public final EventProcessorManager f3346d;
    @Nullable
    public EventBatchStoreManager f3347e;
    @Nullable
    public EventBatchStoreManager f3348f;

    /* compiled from: tab_src_position */
    class WriterHandler extends Handler {
        final /* synthetic */ EventProcessor f3365a;
        @Nullable
        private BatchSession f3366b;

        public WriterHandler(EventProcessor eventProcessor, Looper looper) {
            this.f3365a = eventProcessor;
            super(looper);
        }

        public void handleMessage(Message message) {
            TraceCompatDetour.a("handleMessage", -1130513750);
            try {
                switch (message.what) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        m5571c((ParamsCollectionMap) message.obj);
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        m5569b((SessionDelegate) message.obj);
                        break;
                    case 3:
                        m5568b((BatchSession) message.obj);
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        m5570b((String) message.obj);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown what=" + message.what);
                }
                TraceCompatDetour.a(-387304698);
            } catch (Throwable th) {
                TraceCompatDetour.a(-2083741862);
            }
        }

        private void m5571c(ParamsCollectionMap paramsCollectionMap) {
            TraceCompatDetour.a("doWrite", 1203759063);
            try {
                if (this.f3365a.f3344b != null) {
                    TraceCompatDetour.a("eventListener", -1734645126);
                    try {
                        int i = this.f3365a.f3344b;
                        i.mo733a();
                        TraceCompatDetour.a(i);
                    } finally {
                        TraceCompatDetour.a(71096490);
                    }
                }
                TraceCompatDetour.a("writeToDisk", -287191582);
                try {
                    this.f3365a.f3347e.m5601a((ParamsCollection) paramsCollectionMap);
                    TraceCompatDetour.a(-412207943);
                    paramsCollectionMap.m5434a();
                } catch (FailedFileCreationException e) {
                    try {
                        m5567b().m5601a((ParamsCollection) paramsCollectionMap);
                        TraceCompatDetour.a(2101329905);
                        paramsCollectionMap.m5434a();
                        TraceCompatDetour.a(542967924);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    } catch (Throwable th) {
                        TraceCompatDetour.a(137856704);
                        paramsCollectionMap.m5434a();
                    }
                } catch (IOException e3) {
                    m5567b().m5601a((ParamsCollection) paramsCollectionMap);
                    TraceCompatDetour.a(2101329905);
                    paramsCollectionMap.m5434a();
                    TraceCompatDetour.a(542967924);
                }
                TraceCompatDetour.a(542967924);
            } catch (Throwable th2) {
                TraceCompatDetour.a(-431400084);
            }
        }

        private void m5569b(SessionDelegate sessionDelegate) {
            TraceCompatDetour.a("doBootstrapNewSession", 650675213);
            try {
                this.f3366b = sessionDelegate.m5578a(this.f3365a.f3346d);
                m5566a().m5600a(this.f3366b);
                if (this.f3365a.f3348f != null) {
                    this.f3365a.f3348f.m5600a(this.f3366b);
                }
                TraceCompatDetour.a(-1944201874);
            } catch (Throwable th) {
                TraceCompatDetour.a(-1472758568);
            }
        }

        private void m5568b(BatchSession batchSession) {
            TraceCompatDetour.a("doStartNewSession", -720681176);
            try {
                this.f3366b = batchSession;
                m5566a().m5603b(batchSession);
                if (this.f3365a.f3348f != null) {
                    this.f3365a.f3348f.m5603b(this.f3366b);
                }
                TraceCompatDetour.a(325325462);
            } catch (Throwable th) {
                TraceCompatDetour.a(-786089343);
            }
        }

        private void m5570b(@Nullable String str) {
            TraceCompatDetour.a("doUserLogout", -1973842345);
            try {
                m5566a().m5602a(str);
                if (this.f3365a.f3348f != null) {
                    this.f3365a.f3348f.m5602a(str);
                }
                TraceCompatDetour.a(2144438379);
            } catch (Throwable th) {
                TraceCompatDetour.a(1592717642);
            }
        }

        private EventBatchStoreManager m5566a() {
            if (this.f3365a.f3347e == null) {
                this.f3365a.f3347e = this.f3365a.f3345c.m5565a();
            }
            return this.f3365a.f3347e;
        }

        private EventBatchStoreManager m5567b() {
            if (this.f3365a.f3348f == null) {
                EventProcessor eventProcessor = this.f3365a;
                EventBatchStoreManagerFactory eventBatchStoreManagerFactory = this.f3365a.f3345c;
                eventProcessor.f3348f = new EventBatchStoreManager(new EventBatchMemoryStore(eventBatchStoreManagerFactory.f3357d.mo737a(), eventBatchStoreManagerFactory.f3358e.mo737a(), eventBatchStoreManagerFactory.f3359f, eventBatchStoreManagerFactory.f3360g), new InProcessUploadBatchNotifier(eventBatchStoreManagerFactory.f3354a, eventBatchStoreManagerFactory.f3360g, eventBatchStoreManagerFactory.f3361h));
                this.f3365a.f3348f.m5600a(this.f3366b);
            }
            return this.f3365a.f3348f;
        }
    }

    EventProcessor(HandlerThread handlerThread, @Nullable EventListener eventListener, EventBatchStoreManagerFactory eventBatchStoreManagerFactory, EventProcessorManager eventProcessorManager) {
        this.f3343a = new WriterHandler(this, handlerThread.getLooper());
        this.f3344b = eventListener;
        this.f3345c = eventBatchStoreManagerFactory;
        this.f3346d = eventProcessorManager;
    }

    public final void m5557a(SessionDelegate sessionDelegate) {
        WriterHandler writerHandler = this.f3343a;
        writerHandler.sendMessage(writerHandler.obtainMessage(2, sessionDelegate));
    }

    public final void m5558a(@Nullable String str) {
        WriterHandler writerHandler = this.f3343a;
        writerHandler.sendMessage(writerHandler.obtainMessage(4, str));
    }
}
