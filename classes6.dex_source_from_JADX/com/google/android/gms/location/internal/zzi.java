package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzml;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzd;
import java.util.List;

public interface zzi extends IInterface {
    Location mo456a();

    ActivityRecognitionResult mo457a(String str);

    void mo458a(long j, boolean z, PendingIntent pendingIntent);

    void mo459a(PendingIntent pendingIntent);

    void mo460a(PendingIntent pendingIntent, zzml com_google_android_gms_internal_zzml);

    void mo461a(PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh, String str);

    void mo462a(Location location);

    void mo463a(Location location, int i);

    void mo464a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh);

    void mo465a(GestureRequest gestureRequest, PendingIntent pendingIntent, zzml com_google_android_gms_internal_zzml);

    void mo466a(LocationRequest locationRequest, PendingIntent pendingIntent);

    void mo467a(LocationRequest locationRequest, zzd com_google_android_gms_location_zzd);

    void mo468a(LocationRequest locationRequest, zzd com_google_android_gms_location_zzd, String str);

    void mo469a(LocationSettingsRequest locationSettingsRequest, zzj com_google_android_gms_location_internal_zzj, String str);

    void mo470a(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent);

    void mo471a(LocationRequestInternal locationRequestInternal, zzd com_google_android_gms_location_zzd);

    void mo472a(LocationRequestUpdateData locationRequestUpdateData);

    void mo473a(zzg com_google_android_gms_location_internal_zzg);

    void mo474a(zzh com_google_android_gms_location_internal_zzh, String str);

    void mo475a(zzd com_google_android_gms_location_zzd);

    void mo476a(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh, String str);

    void mo477a(boolean z);

    void mo478a(String[] strArr, zzh com_google_android_gms_location_internal_zzh, String str);

    Location mo479b(String str);

    Status mo480b(PendingIntent pendingIntent);

    Status mo481c(PendingIntent pendingIntent);

    LocationAvailability mo482c(String str);

    void mo483d(PendingIntent pendingIntent);
}
