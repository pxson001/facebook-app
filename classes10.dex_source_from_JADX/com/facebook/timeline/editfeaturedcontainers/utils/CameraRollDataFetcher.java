package com.facebook.timeline.editfeaturedcontainers.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Files;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.photoreminder.model.MediaModel.MediaType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: geofence_notification_responsiveness_ms */
public class CameraRollDataFetcher {
    public static final Uri f10948a = Files.getContentUri("external");
    public static final String[] f10949b = new String[]{"date_added", "_data"};
    public static final String f10950c = StringFormatUtil.a("%s = %d AND (LOWER(%s) LIKE '%%dcim%%' or LOWER(%s) LIKE '%%camera%%')", new Object[]{"media_type", Integer.valueOf(1), "_data", "_data"});
    private static CameraRollDataFetcher f10951f;
    private static final Object f10952g = new Object();
    public final ListeningExecutorService f10953d;
    public final Context f10954e;

    /* compiled from: geofence_notification_responsiveness_ms */
    public class C15901 implements Callable<List<MediaModel>> {
        final /* synthetic */ CameraRollDataFetcher f10947a;

        public C15901(CameraRollDataFetcher cameraRollDataFetcher) {
            this.f10947a = cameraRollDataFetcher;
        }

        public Object call() {
            String[] strArr = null;
            Cursor query = this.f10947a.f10954e.getContentResolver().query(CameraRollDataFetcher.f10948a, CameraRollDataFetcher.f10949b, CameraRollDataFetcher.f10950c, null, "date_added DESC LIMIT 10");
            if (query != null) {
                strArr = new ArrayList(10);
                while (query.moveToNext()) {
                    strArr.add(new MediaModel(query.getString(1), MediaType.PHOTO));
                }
                query.close();
            }
            List list = strArr;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            return list;
        }
    }

    private static CameraRollDataFetcher m11082b(InjectorLike injectorLike) {
        return new CameraRollDataFetcher(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public CameraRollDataFetcher(ListeningExecutorService listeningExecutorService, Context context) {
        this.f10953d = listeningExecutorService;
        this.f10954e = context;
    }

    public static CameraRollDataFetcher m11081a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CameraRollDataFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10952g) {
                CameraRollDataFetcher cameraRollDataFetcher;
                if (a2 != null) {
                    cameraRollDataFetcher = (CameraRollDataFetcher) a2.a(f10952g);
                } else {
                    cameraRollDataFetcher = f10951f;
                }
                if (cameraRollDataFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11082b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10952g, b3);
                        } else {
                            f10951f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = cameraRollDataFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
