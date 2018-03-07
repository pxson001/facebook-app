package com.facebook.feed.photoreminder.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: percent_time_dropped_frames_1 */
public class PhotoReminderGatekeeperHelper {
    public GatekeeperStoreImpl f10222a;

    public static PhotoReminderGatekeeperHelper m15318b(InjectorLike injectorLike) {
        return new PhotoReminderGatekeeperHelper(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public PhotoReminderGatekeeperHelper(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10222a = gatekeeperStoreImpl;
    }

    public final boolean m15319c() {
        return this.f10222a.m2189a(PhotoReminderGatekeepers.f13993a, false);
    }
}
