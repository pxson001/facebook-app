package com.facebook.messaging.photoreminders;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: remaining_duration */
public class LocalMediaLoader {
    public static final Uri f3519a = Media.EXTERNAL_CONTENT_URI;
    private static final String f3520b = LocalMediaLoader.class.getSimpleName();
    private static final Uri f3521c = Uri.parse("content://media/external/images/media");
    private static final String[] f3522d = new String[]{"_id", "_data", "date_added", "latitude", "longitude", "datetaken", "orientation", "width", "height"};
    private static final String f3523e = StringFormatUtil.a("%s = 'image/jpeg' AND (LOWER(%s) LIKE '%%dcim%%' OR LOWER(%s) LIKE '%%camera%%')", new Object[]{"mime_type", "_data", "_data"});
    private final BitmapUtils f3524f;
    private final ContentResolver f3525g;
    private final ListeningExecutorService f3526h;
    private final RuntimePermissionsUtil f3527i;

    private static LocalMediaLoader m3387b(InjectorLike injectorLike) {
        return new LocalMediaLoader(BitmapUtils.a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public LocalMediaLoader(BitmapUtils bitmapUtils, ContentResolver contentResolver, ListeningExecutorService listeningExecutorService, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f3524f = bitmapUtils;
        this.f3525g = contentResolver;
        this.f3526h = listeningExecutorService;
        this.f3527i = runtimePermissionsUtil;
    }
}
