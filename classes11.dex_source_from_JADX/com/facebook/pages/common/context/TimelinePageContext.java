package com.facebook.pages.common.context;

import android.os.ParcelUuid;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.ipc.profile.TimelineContext.TimelineType;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: spotify_save_song */
public class TimelinePageContext extends TimelineContext {
    private final String f1463a;
    private final PageProfilePermissionsProvider f1464b;

    /* compiled from: spotify_save_song */
    public interface PageProfilePermissionsProvider {
        @Nullable
        ProfilePermissions mo28a();
    }

    /* compiled from: spotify_save_song */
    final class C02011 implements PageProfilePermissionsProvider {
        final /* synthetic */ ProfilePermissions f1462a;

        C02011(ProfilePermissions profilePermissions) {
            this.f1462a = profilePermissions;
        }

        @Nullable
        public final ProfilePermissions mo28a() {
            return this.f1462a;
        }
    }

    public static TimelinePageContext m2141a(long j, long j2, String str, ParcelUuid parcelUuid, String str2, ProfilePermissions profilePermissions) {
        return new TimelinePageContext(j, j2, str, TimelineType.PAGE, parcelUuid, str2, new C02011(profilePermissions));
    }

    public static TimelinePageContext m2142a(long j, long j2, String str, ParcelUuid parcelUuid, String str2, PageProfilePermissionsProvider pageProfilePermissionsProvider) {
        return new TimelinePageContext(j, j2, str, TimelineType.PAGE_IDENTITY, parcelUuid, str2, pageProfilePermissionsProvider);
    }

    private TimelinePageContext(long j, long j2, String str, TimelineType timelineType, ParcelUuid parcelUuid, String str2, PageProfilePermissionsProvider pageProfilePermissionsProvider) {
        super(j, j2, str, timelineType, parcelUuid);
        this.f1463a = str2;
        this.f1464b = pageProfilePermissionsProvider;
    }

    public final Optional<String> m2147e() {
        return Optional.of(this.f1463a);
    }

    public final boolean m2143a() {
        return (this.f1464b == null || this.f1464b.mo28a() == null || !this.f1464b.mo28a().a(Permission.MODERATE_CONTENT)) ? false : true;
    }

    public final boolean m2144b() {
        return (this.f1464b == null || this.f1464b.mo28a() == null || !this.f1464b.mo28a().a(Permission.EDIT_PROFILE)) ? false : true;
    }

    public final boolean m2145c() {
        return true;
    }

    public final boolean m2146d() {
        return false;
    }
}
