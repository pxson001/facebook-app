package com.facebook.notifications.util;

/* compiled from: minutiae_image_size_large */
class NotificationsConnectionControllerManager$2 implements Runnable {
    final /* synthetic */ NotificationsConnectionControllerManager f8871a;

    NotificationsConnectionControllerManager$2(NotificationsConnectionControllerManager notificationsConnectionControllerManager) {
        this.f8871a = notificationsConnectionControllerManager;
    }

    public void run() {
        if (this.f8871a.f != null) {
            this.f8871a.f.b(this.f8871a.g);
            this.f8871a.g = null;
            this.f8871a.f.b();
            this.f8871a.f = null;
        }
    }
}
