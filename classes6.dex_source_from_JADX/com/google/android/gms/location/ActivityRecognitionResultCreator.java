package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static ActivityRecognitionResult m8833a(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int i = 0;
        int b = zza.b(parcel);
        long j2 = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    list = zza.c(parcel, a, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = zza.g(parcel, a);
                    break;
                case 3:
                    j = zza.g(parcel, a);
                    break;
                case 4:
                    i = zza.e(parcel, a);
                    break;
                case 5:
                    bundle = zza.p(parcel, a);
                    break;
                case 1000:
                    i2 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ActivityRecognitionResult(i2, list, j2, j, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8833a(parcel);
    }

    public Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
