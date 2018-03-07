package com.facebook.sensor;

import android.os.Build.VERSION;

/* compiled from: growthSetProfilePhotoParams */
public final class SensorType {
    public static String m11378a(int i, String str) {
        switch (i) {
            case 1:
                return "accelerometer";
            case 2:
                return "magnetic_field";
            case 3:
                return "orientation";
            case 4:
                return "gyroscope";
            case 5:
                return "light";
            case 6:
                return "pressure";
            case 7:
                return "temperature";
            case 8:
                return "proximity";
            case 9:
                return "gravity";
            case 10:
                return "linear_acceleration";
            case 11:
                return "rotation_vector";
            case 12:
                return "relative_humidity";
            case 13:
                return "ambient_temperature";
            default:
                if (VERSION.SDK_INT >= 18) {
                    switch (i) {
                        case 14:
                            return "magnetic_field_uncalibrated";
                        case 15:
                            return "game_rotation_vector";
                        case 16:
                            return "gyroscope_uncalibrated";
                        case 17:
                            return "significant_motion";
                    }
                }
                if (VERSION.SDK_INT >= 19) {
                    switch (i) {
                        case 18:
                            return "step_detector";
                        case 19:
                            return "step_counter";
                        case 20:
                            return "geomagnetic_rotation_vector";
                    }
                }
                if (VERSION.SDK_INT < 20) {
                    return str;
                }
                switch (i) {
                    case 21:
                        return "heart_rate";
                    default:
                        return str;
                }
        }
    }

    private SensorType() {
    }
}
