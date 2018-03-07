package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.IOException;

public final class zznt {
    public static void m12891a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }
}
