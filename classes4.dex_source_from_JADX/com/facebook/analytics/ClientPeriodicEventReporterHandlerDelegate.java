package com.facebook.analytics;

import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.analytics.logger.ILegacyPeriodicEventReporter;
import com.facebook.inject.Lazy;

/* compiled from: image_srcs */
class ClientPeriodicEventReporterHandlerDelegate {
    ClientPeriodicEventReporterHandlerDelegate() {
    }

    static void m11023a(ClientPeriodicEventReporterManager clientPeriodicEventReporterManager, ClientPeriodicEventReporterManager$EventCollectionStatus clientPeriodicEventReporterManager$EventCollectionStatus, String str, long j, Lazy<? extends IAnalyticsPeriodicEventReporter> lazy, String str2, String str3, String str4, boolean z, long j2) {
        if (clientPeriodicEventReporterManager.a(str4, z)) {
            long a = clientPeriodicEventReporterManager.a(str2, j2, j, z, str3);
            if (j >= a) {
                IAnalyticsPeriodicEventReporter iAnalyticsPeriodicEventReporter = (IAnalyticsPeriodicEventReporter) lazy.get();
                long a2 = clientPeriodicEventReporterManager.a(str3, j2, z);
                HoneyAnalyticsEvent a3 = clientPeriodicEventReporterManager.a(iAnalyticsPeriodicEventReporter, j, str);
                if (a3 != null) {
                    clientPeriodicEventReporterManager.getClass();
                    clientPeriodicEventReporterManager$EventCollectionStatus.m11020a(a3);
                    clientPeriodicEventReporterManager$EventCollectionStatus.m11021a(str2, j);
                    clientPeriodicEventReporterManager$EventCollectionStatus.m11019a(j + a2);
                    return;
                }
                return;
            }
            clientPeriodicEventReporterManager$EventCollectionStatus.m11019a(a);
        }
    }

    static void m11022a(ClientPeriodicEventReporterManager clientPeriodicEventReporterManager, ClientPeriodicEventReporterManager$EventCollectionStatus clientPeriodicEventReporterManager$EventCollectionStatus, String str, long j, Lazy<? extends ILegacyPeriodicEventReporter> lazy, String str2, String str3, String str4, boolean z) {
        if (clientPeriodicEventReporterManager.a(str4, z)) {
            ILegacyPeriodicEventReporter iLegacyPeriodicEventReporter = (ILegacyPeriodicEventReporter) lazy.get();
            long a = iLegacyPeriodicEventReporter.mo803a();
            long a2 = clientPeriodicEventReporterManager.a(str2, a, j, z, str3);
            if (j >= a2) {
                a2 = clientPeriodicEventReporterManager.a(str3, a, z);
                HoneyAnalyticsEvent a3 = clientPeriodicEventReporterManager.a(iLegacyPeriodicEventReporter, j, str);
                if (a3 != null) {
                    clientPeriodicEventReporterManager.getClass();
                    clientPeriodicEventReporterManager$EventCollectionStatus.m11020a(a3);
                    clientPeriodicEventReporterManager$EventCollectionStatus.m11021a(str2, j);
                    clientPeriodicEventReporterManager$EventCollectionStatus.m11019a(a2 + j);
                    return;
                }
                return;
            }
            clientPeriodicEventReporterManager$EventCollectionStatus.m11019a(a2);
        }
    }
}
