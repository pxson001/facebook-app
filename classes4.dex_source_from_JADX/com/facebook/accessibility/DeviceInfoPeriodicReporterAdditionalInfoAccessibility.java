package com.facebook.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.view.accessibility.AccessibilityManager;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.reporters.periodic.DeviceInfoPeriodicReporterAdditionalInfo;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;

/* compiled from: image_data_width */
public class DeviceInfoPeriodicReporterAdditionalInfoAccessibility implements DeviceInfoPeriodicReporterAdditionalInfo {
    private static final Class<?> f10502a = DeviceInfoPeriodicReporterAdditionalInfoAccessibility.class;
    private final AccessibilityManager f10503b;
    private final AbstractFbErrorReporter f10504c;
    private final ContentResolver f10505d;
    private final Configuration f10506e = Resources.getSystem().getConfiguration();

    @Inject
    public DeviceInfoPeriodicReporterAdditionalInfoAccessibility(AccessibilityManager accessibilityManager, AbstractFbErrorReporter abstractFbErrorReporter, ContentResolver contentResolver, Resources resources) {
        this.f10503b = accessibilityManager;
        this.f10504c = abstractFbErrorReporter;
        this.f10505d = contentResolver;
    }

    public final void mo805a(HoneyClientEvent honeyClientEvent) {
        boolean z = true;
        try {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("font_scale", System.getFloat(this.f10505d, "font_scale", 1.0f));
            int i = this.f10506e.keyboard;
            if (this.f10506e.hardKeyboardHidden == 1 && (i == 2 || i == 3)) {
                objectNode.a("hardware_keyboard", i == 2 ? "qwerty" : "12key");
            }
            if (VERSION.SDK_INT >= 21) {
                String str = "display_inversion";
                if (Secure.getInt(this.f10505d, "accessibility_display_inversion_enabled", 0) == 0) {
                    z = false;
                }
                objectNode.a(str, z);
            }
            Boolean.valueOf(this.f10503b.isEnabled());
            if (this.f10503b.isEnabled()) {
                objectNode.a("accessibility_enabled", true);
                if (VERSION.SDK_INT >= 14) {
                    m11049a(objectNode);
                }
            }
            honeyClientEvent.a("accessibility", objectNode);
        } catch (Throwable th) {
            this.f10504c.a(f10502a.getSimpleName() + "_putAdditionalInfo_exception", th);
        }
    }

    private void m11049a(ObjectNode objectNode) {
        int i = 0;
        objectNode.a("touch_exploration_enabled", AccessibilityManagerCompat.b(this.f10503b));
        int i2 = 0;
        for (AccessibilityServiceInfo accessibilityServiceInfo : AccessibilityManagerCompat.a.a(this.f10503b, -1)) {
            accessibilityServiceInfo.toString();
            objectNode.c("enabled_service_" + i2, m11048a(accessibilityServiceInfo));
            i2++;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo2 : AccessibilityManagerCompat.a.a(this.f10503b)) {
            accessibilityServiceInfo2.toString();
            objectNode.c("installed_service_" + i, m11048a(accessibilityServiceInfo2));
            i++;
        }
    }

    private static ObjectNode m11048a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String str;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("event_type", accessibilityServiceInfo.eventTypes);
        objectNode.a("feedback_type", AccessibilityServiceInfoCompat.a(accessibilityServiceInfo.feedbackType));
        objectNode.a("id", accessibilityServiceInfo.getId());
        switch (accessibilityServiceInfo.flags) {
            case 1:
                str = "DEFAULT";
                break;
            case 2:
                str = "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
                break;
            case 4:
                str = "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
                break;
            case 8:
                str = "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                break;
            case 16:
                str = "FLAG_REPORT_VIEW_IDS";
                break;
            case 32:
                str = "FLAG_REQUEST_FILTER_KEY_EVENTS";
                break;
            default:
                str = null;
                break;
        }
        String str2 = str;
        if (str2 != null) {
            objectNode.a("flags", str2);
        }
        objectNode.a("notification_timeout", accessibilityServiceInfo.notificationTimeout);
        String[] strArr = accessibilityServiceInfo.packageNames;
        if (strArr != null && strArr.length > 0) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            for (int i = 0; i < strArr.length; i++) {
                objectNode2.a("package_name_" + i, strArr[i]);
            }
            objectNode.c("package_names", objectNode2);
        }
        return objectNode;
    }
}
