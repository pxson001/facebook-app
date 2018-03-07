package com.facebook.composer.attachments;

import android.content.ContentResolver;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.photos.tagging.store.FaceBoxStore;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: place_picker_app_location_niem_retry */
public class MediaItemMetaDataExtractor {
    private static final SimpleDateFormat f7811a = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private static final SimpleDateFormat f7812b;
    private final MediaStorage f7813c;
    public final ContentResolver f7814d;
    private final MoreFileUtils f7815e;
    private final FaceBoxStore f7816f;

    public static MediaItemMetaDataExtractor m11253b(InjectorLike injectorLike) {
        return new MediaItemMetaDataExtractor(MediaStorage.a(injectorLike), MoreFileUtils.a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike.getApplicationInjector()), FaceBoxStore.m21127a(injectorLike));
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f7812b = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Inject
    public MediaItemMetaDataExtractor(MediaStorage mediaStorage, MoreFileUtils moreFileUtils, @NeedsApplicationInjector ContentResolver contentResolver, FaceBoxStore faceBoxStore) {
        this.f7813c = mediaStorage;
        this.f7815e = moreFileUtils;
        this.f7814d = contentResolver;
        this.f7816f = faceBoxStore;
    }

    public static long m11252b(Uri uri) {
        try {
            Date parse;
            ExifInterface exifInterface = new ExifInterface(uri.getPath());
            String attribute = exifInterface.getAttribute("GPSDateStamp");
            String attribute2 = exifInterface.getAttribute("GPSTimeStamp");
            if (attribute == null || attribute2 == null) {
                String attribute3 = exifInterface.getAttribute("DateTime");
                parse = attribute3 == null ? null : f7811a.parse(attribute3);
            } else {
                parse = f7812b.parse(attribute + ' ' + attribute2);
            }
            if (parse != null) {
                return parse.getTime();
            }
            return -1;
        } catch (IOException e) {
            return -1;
        } catch (ParseException e2) {
            return -1;
        }
    }

    public static Location m11251a(Uri uri) {
        float[] fArr = new float[2];
        try {
            if (!new ExifInterface(uri.getPath()).getLatLong(fArr)) {
                return null;
            }
            Location location = new Location("photo-exif");
            location.setLatitude((double) fArr[0]);
            location.setLongitude((double) fArr[1]);
            return location;
        } catch (IOException e) {
            return null;
        }
    }
}
