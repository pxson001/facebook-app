package com.facebook.camera.analytics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.camera.utils.Orientation;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;

/* compiled from: amount_raised_text */
public class DefaultCameraFlowLogger implements CameraFlowLogger {
    public static DefaultCameraFlowLogger m18857a(InjectorLike injectorLike) {
        return new DefaultCameraFlowLogger();
    }

    public final void mo1142a(Bundle bundle, String str) {
        new StringBuilder("Activity created, started by ").append(str);
    }

    public final void mo1143a(CameraUsageData cameraUsageData) {
        new StringBuilder("Activity stopped, ").append(cameraUsageData.f10791a).append(" pictures taken, ").append(cameraUsageData.f10792b).append(" touch-to-focus, ").append(cameraUsageData.f10793c).append(" last second autofocus, ").append(cameraUsageData.f10794d).append(" face detection autofocus, in ").append(cameraUsageData.m18856l()).append(" seconds.");
    }

    public final void mo1137a() {
    }

    public final void mo1144a(CameraUsageData cameraUsageData, int i) {
        new StringBuilder("Photo #").append(cameraUsageData.f10791a).append(" captured, ").append(i).append(" bytes");
    }

    public final void mo1154c() {
    }

    public final void mo1155d() {
    }

    public final void mo1149a(boolean z) {
        new StringBuilder("videoRecordingCompleted ").append(z ? " (success)" : " (no video)");
    }

    public final void mo1146a(String str) {
        new StringBuilder("cameraClosing: ").append(str);
    }

    public final void mo1139a(Intent intent) {
    }

    public final void mo1141a(Bundle bundle) {
    }

    public final void mo1152b(String str) {
    }

    public final void mo1140a(Uri uri) {
        new StringBuilder("Picked photo ").append(uri.toString());
    }

    public final void mo1150b(Uri uri) {
        new StringBuilder("Picked video ").append(uri.toString());
    }

    public final void mo1145a(Orientation orientation) {
        new StringBuilder("Layout orientation: ").append(orientation);
    }

    public final void mo1151b(Orientation orientation) {
        new StringBuilder("Device orientation: ").append(orientation);
    }

    public final void mo1138a(int i, boolean z) {
        new StringBuilder("Camera source set to index ").append(i).append(z ? " (user)" : " (init)");
    }

    public final void mo1156e() {
    }

    public final void mo1148a(String str, boolean z) {
        new StringBuilder("Flash mode ").append(str).append(z ? " (user)" : " (init)");
    }

    public final void mo1147a(String str, Exception exception) {
        BLog.b("DefaultCameraActivityFlowLogger", "Camera exception " + str + "\n" + exception.toString());
    }

    public final void mo1153b(boolean z) {
        new StringBuilder("Camera visible ").append(z);
    }
}
