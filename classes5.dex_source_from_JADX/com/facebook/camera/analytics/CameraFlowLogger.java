package com.facebook.camera.analytics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.camera.utils.Orientation;

/* compiled from: analytics4a */
public interface CameraFlowLogger {
    void mo1137a();

    void mo1138a(int i, boolean z);

    void mo1139a(Intent intent);

    void mo1140a(Uri uri);

    void mo1141a(Bundle bundle);

    void mo1142a(Bundle bundle, String str);

    void mo1143a(CameraUsageData cameraUsageData);

    void mo1144a(CameraUsageData cameraUsageData, int i);

    void mo1145a(Orientation orientation);

    void mo1146a(String str);

    void mo1147a(String str, Exception exception);

    void mo1148a(String str, boolean z);

    void mo1149a(boolean z);

    void mo1150b(Uri uri);

    void mo1151b(Orientation orientation);

    void mo1152b(String str);

    void mo1153b(boolean z);

    void mo1154c();

    void mo1155d();

    void mo1156e();
}
