package com.facebook.fbuploader;

import com.facebook.fbuploader.fbcommon.DefaultHttpRequestExecutor;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: new_api_player */
public final class FbUploaderImpl {
    private UploadJobFactory f10058a;
    public Map<FbUploaderListener, FbUploadJobHandleImpl> f10059b;

    /* compiled from: new_api_player */
    public final class FbUploadJobHandleImpl {
        public UploadJobImpl f10053a;
        public boolean f10054b = false;
        public UploadResult f10055c = null;
        public UploadFailureException f10056d = null;

        public FbUploadJobHandleImpl(UploadJobImpl uploadJobImpl) {
            this.f10053a = uploadJobImpl;
        }
    }

    /* compiled from: new_api_player */
    final class FbUploaderListener implements Listener {
        final /* synthetic */ FbUploaderImpl f10057a;

        public FbUploaderListener(FbUploaderImpl fbUploaderImpl) {
            this.f10057a = fbUploaderImpl;
        }

        public final void mo1026a() {
        }

        public final void mo1027a(float f) {
        }

        public final void mo1028a(UploadFailureException uploadFailureException) {
            FbUploaderImpl.m15752a(this.f10057a, this, uploadFailureException);
        }

        public final void mo1030b() {
            FbUploaderImpl fbUploaderImpl = this.f10057a;
            FbUploadJobHandleImpl fbUploadJobHandleImpl = (FbUploadJobHandleImpl) fbUploaderImpl.f10059b.get(this);
            if (fbUploadJobHandleImpl != null) {
                FbUploaderImpl.m15752a(fbUploaderImpl, this, new UploadFailureException("Cancellation", (long) fbUploadJobHandleImpl.f10053a.f10078g, true, null));
            }
        }

        public final void mo1029a(UploadResult uploadResult) {
            FbUploaderImpl.m15753a(this.f10057a, this, uploadResult);
        }
    }

    private FbUploaderImpl(UploadJobFactory uploadJobFactory) {
        this.f10058a = uploadJobFactory;
        this.f10059b = new HashMap();
    }

    public FbUploaderImpl(DefaultHttpRequestExecutor defaultHttpRequestExecutor) {
        this(new UploadJobFactory(defaultHttpRequestExecutor));
    }

    public final FbUploadJobHandleImpl m15754a(Content content, Config config, Listener listener) {
        if (content.f10052f == null || content.f10052f.isEmpty()) {
            throw new UploadFailureException("Empty file key", 0, false, null);
        }
        Listener listener2;
        FbUploaderListener fbUploaderListener = new FbUploaderListener(this);
        if (listener == null) {
            listener2 = fbUploaderListener;
        } else {
            listener2 = new CompositeListener(Arrays.asList(new Listener[]{fbUploaderListener, listener}));
        }
        FbUploadJobHandleImpl fbUploadJobHandleImpl = new FbUploadJobHandleImpl(new UploadJobImpl(content, config, listener2, this.f10058a.f10065a));
        this.f10059b.put(fbUploaderListener, fbUploadJobHandleImpl);
        fbUploadJobHandleImpl.f10053a.m15778a();
        return fbUploadJobHandleImpl;
    }

    public final void m15755a(FbUploadJobHandleImpl fbUploadJobHandleImpl) {
        UploadJobImpl uploadJobImpl = fbUploadJobHandleImpl.f10053a;
        if (uploadJobImpl.f10079h == null) {
            UploadJobImpl.m15777e(uploadJobImpl);
            return;
        }
        DefaultHttpRequestExecutor defaultHttpRequestExecutor = uploadJobImpl.f10074c;
        ListenableFuture listenableFuture = (ListenableFuture) defaultHttpRequestExecutor.f10100c.get(uploadJobImpl.f10079h);
        if (!(listenableFuture == null || listenableFuture.isDone())) {
            listenableFuture.cancel(true);
        }
    }

    public final UploadResult m15756b(FbUploadJobHandleImpl fbUploadJobHandleImpl) {
        while (!fbUploadJobHandleImpl.f10054b) {
            synchronized (fbUploadJobHandleImpl) {
                try {
                    ObjectDetour.a(fbUploadJobHandleImpl, -1740579994);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        UploadFailureException uploadFailureException = fbUploadJobHandleImpl.f10056d;
        if (uploadFailureException == null) {
            return fbUploadJobHandleImpl.f10055c;
        }
        throw uploadFailureException;
    }

    public static void m15753a(FbUploaderImpl fbUploaderImpl, FbUploaderListener fbUploaderListener, UploadResult uploadResult) {
        FbUploadJobHandleImpl fbUploadJobHandleImpl = (FbUploadJobHandleImpl) fbUploaderImpl.f10059b.get(fbUploaderListener);
        if (fbUploadJobHandleImpl != null) {
            FbUploadJobHandleImpl fbUploadJobHandleImpl2 = fbUploadJobHandleImpl;
            fbUploadJobHandleImpl2.f10055c = uploadResult;
            fbUploadJobHandleImpl2.f10056d = null;
            fbUploadJobHandleImpl2.f10054b = true;
            synchronized (fbUploadJobHandleImpl) {
                ObjectDetour.b(fbUploadJobHandleImpl, -7241502);
            }
            fbUploaderImpl.f10059b.remove(fbUploaderListener);
        }
    }

    public static void m15752a(FbUploaderImpl fbUploaderImpl, FbUploaderListener fbUploaderListener, UploadFailureException uploadFailureException) {
        FbUploadJobHandleImpl fbUploadJobHandleImpl = (FbUploadJobHandleImpl) fbUploaderImpl.f10059b.get(fbUploaderListener);
        if (fbUploadJobHandleImpl != null) {
            FbUploadJobHandleImpl fbUploadJobHandleImpl2 = fbUploadJobHandleImpl;
            fbUploadJobHandleImpl2.f10055c = null;
            fbUploadJobHandleImpl2.f10056d = uploadFailureException;
            fbUploadJobHandleImpl2.f10054b = true;
            synchronized (fbUploadJobHandleImpl) {
                ObjectDetour.b(fbUploadJobHandleImpl, -1929439446);
            }
            fbUploaderImpl.f10059b.remove(fbUploaderListener);
        }
    }
}
