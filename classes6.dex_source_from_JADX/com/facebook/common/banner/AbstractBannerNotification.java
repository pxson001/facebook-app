package com.facebook.common.banner;

/* compiled from: place_types */
public abstract class AbstractBannerNotification implements BannerNotification {
    public BannerNotificationController f7685a;
    private final String f7686b;

    public AbstractBannerNotification(String str) {
        this.f7686b = str;
    }

    public final void mo918a(BannerNotificationController bannerNotificationController) {
        this.f7685a = bannerNotificationController;
    }

    public void mo919b() {
    }

    public void mo920c() {
    }

    public String mo921d() {
        return this.f7686b;
    }
}
