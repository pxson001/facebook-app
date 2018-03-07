package com.facebook.qrcode.analytics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.analytics.CameraUsageData;
import com.facebook.camera.utils.Orientation;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: listen */
public class QRCodeAnalyticsLogger implements CameraFlowLogger {
    private AnalyticsLogger f8631a;
    public String f8632b;

    public static QRCodeAnalyticsLogger m8550a(InjectorLike injectorLike) {
        return new QRCodeAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public QRCodeAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8631a = analyticsLogger;
    }

    private void m8553f(String str) {
        m8551a(m8554g(str));
    }

    private void m8552a(String str, String str2, boolean z) {
        HoneyClientEvent g = m8554g(str);
        g.a(str2, z);
        m8551a(g);
    }

    private HoneyClientEvent m8554g(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "qrcode";
        if (this.f8632b != null) {
            honeyClientEvent.f = this.f8632b;
        }
        return honeyClientEvent;
    }

    private void m8551a(HoneyClientEvent honeyClientEvent) {
        this.f8631a.a(honeyClientEvent);
    }

    public final void m8578d(String str) {
        HoneyClientEvent g = m8554g("qrcode_started");
        g.b("flow_name", str);
        m8551a(g);
    }

    public final void m8568b() {
        m8553f("qrcode_camera_not_loaded");
    }

    public final void m8576c(boolean z) {
        m8552a("qrcode_code_clicked", "vanity", z);
    }

    public final void m8583f() {
        m8553f("qrcode_import_exception");
    }

    public final void m8585g() {
        m8553f("qrcode_import_loaded");
    }

    public final void m8587h() {
        m8553f("qrcode_import_oom");
    }

    public final void m8588i() {
        m8553f("qrcode_import_pressed");
    }

    public final void m8589j() {
        m8553f("qrcode_code_rendered");
    }

    public final void m8590k() {
        m8553f("qrcode_scanner_rendered");
    }

    public final void m8572b(String str, boolean z) {
        HoneyClientEvent g = m8554g(z ? "qrcode_code_scanned" : "qrcode_code_imported");
        g.b("decoded_string", str);
        m8551a(g);
    }

    public final void m8575c(String str, boolean z) {
        HoneyClientEvent g = m8554g(z ? "qrcode_code_not_understood" : "qrcode_import_not_understood");
        g.b("decoded_string", str);
        m8551a(g);
    }

    public final void m8579d(boolean z) {
        m8552a("qrcode_saved", "vanity", z);
    }

    public final void m8582e(boolean z) {
        m8552a("qrcode_save_pressed", "vanity", z);
    }

    public final void m8584f(boolean z) {
        m8552a("qrcode_shared", "vanity", z);
    }

    public final void m8586g(boolean z) {
        m8552a("qrcode_share_pressed", "vanity", z);
    }

    public final void m8591l() {
        m8553f("qrcode_vanity_created");
    }

    public final void m8581e(String str) {
        HoneyClientEvent g = m8554g("qrcode_vanity_exception");
        g.b("message", str);
        m8551a(g);
    }

    public final void m8592o() {
        m8553f("qrcode_vanity_fetched");
    }

    public final void m8593p() {
        m8553f("qrcode_vanity_shown");
    }

    public final void m8560a(Bundle bundle, String str) {
    }

    public final void m8561a(CameraUsageData cameraUsageData) {
    }

    public final void m8555a() {
    }

    public final void m8562a(CameraUsageData cameraUsageData, int i) {
    }

    public final void m8574c() {
    }

    public final void m8577d() {
    }

    public final void m8564a(String str) {
    }

    public final void m8567a(boolean z) {
    }

    public final void m8557a(Intent intent) {
    }

    public final void m8559a(Bundle bundle) {
    }

    public final void m8571b(String str) {
    }

    public final void m8558a(Uri uri) {
    }

    public final void m8569b(Uri uri) {
    }

    public final void m8563a(Orientation orientation) {
    }

    public final void m8570b(Orientation orientation) {
    }

    public final void m8556a(int i, boolean z) {
    }

    public final void m8580e() {
    }

    public final void m8566a(String str, boolean z) {
    }

    public final void m8573b(boolean z) {
    }

    public final void m8565a(String str, Exception exception) {
        HoneyClientEvent g = m8554g("qrcode_camera_exception");
        g.b("message", str);
        m8551a(g);
    }
}
