package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.katana.constants.Constants.URL;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Key;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: timeline_scroll_animation */
public class AsyncFacewebComponentsStoreSerialization {
    private ExecutorService f1245a;
    public Context f1246b;

    @Inject
    public AsyncFacewebComponentsStoreSerialization(Context context, ExecutorService executorService) {
        this.f1246b = context;
        this.f1245a = executorService;
    }

    public final void m1280a(final FacewebComponentsStore facewebComponentsStore) {
        ExecutorDetour.a(this.f1245a, new Runnable(this) {
            final /* synthetic */ AsyncFacewebComponentsStoreSerialization f1244b;

            public void run() {
                Context context = this.f1244b.f1246b;
                FacewebComponentsStore facewebComponentsStore = facewebComponentsStore;
                String a = MFacewebVersion.m1348a(context);
                if (a == null) {
                    a = "";
                }
                FacewebComponentsStoreCache.m1297a(context, new Key(URL.n(context), a), facewebComponentsStore);
            }
        }, -1082575174);
    }
}
