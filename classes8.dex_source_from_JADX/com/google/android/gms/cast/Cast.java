package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.cast.internal.zzb;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> f9968a = new Api("Cast.API", f9970c, zzk.f10173a);
    public static final CastApi f9969b = new zza();
    private static final com.google.android.gms.common.api.Api.zza<zze, CastOptions> f9970c = new C10451();

    public class Listener {
        public void mo601a() {
        }

        public void mo602a(int i) {
        }

        public void mo603b() {
        }
    }

    public interface MessageReceivedCallback {
        void mo604a(String str, String str2);
    }

    final class C10451 extends com.google.android.gms.common.api.Api.zza<zze, CastOptions> {
        C10451() {
        }

        private static zze m11735a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.a(castOptions, "Setting the API options is required.");
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, castOptions.f9963a, (long) castOptions.f9965c, castOptions.f9964b, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata mo635b();

        String mo636c();

        String mo637d();

        boolean mo638e();
    }

    abstract class zza extends zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public final Result m11745c(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ zza f9967b;

                public final ApplicationMetadata mo635b() {
                    return null;
                }

                public final String mo636c() {
                    return null;
                }

                public final Status cp_() {
                    return status;
                }

                public final String mo637d() {
                    return null;
                }

                public final boolean mo638e() {
                    return false;
                }
            };
        }
    }

    public interface CastApi {

        public final class zza implements CastApi {
            public final PendingResult<Status> mo628a(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.b(new zzh(this, googleApiClient) {
                    final /* synthetic */ zza f9959c;

                    protected final void m11748b(Api.zzb com_google_android_gms_common_api_Api_zzb) {
                        zze com_google_android_gms_cast_internal_zze = (zze) com_google_android_gms_common_api_Api_zzb;
                        if (TextUtils.isEmpty(str)) {
                            m11742a(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            com_google_android_gms_cast_internal_zze.m11911a(str, (zzlx.zzb) this);
                        } catch (IllegalStateException e) {
                            m11741a(2001);
                        }
                    }
                });
            }

            public final PendingResult<Status> mo629a(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.b(new zzh(this, googleApiClient) {
                    final /* synthetic */ zza f9950d;

                    protected final void m11744b(Api.zzb com_google_android_gms_common_api_Api_zzb) {
                        try {
                            ((zze) com_google_android_gms_common_api_Api_zzb).m11913a(str, str2, (zzlx.zzb) this);
                            return;
                        } catch (IllegalArgumentException e) {
                        } catch (IllegalStateException e2) {
                        }
                        m11741a(2001);
                    }
                });
            }

            @Deprecated
            public final PendingResult<ApplicationConnectionResult> mo630a(GoogleApiClient googleApiClient, final String str, boolean z) {
                Builder builder = new Builder();
                builder.f9984a.f9986b = z;
                final LaunchOptions launchOptions = builder.f9984a;
                return googleApiClient.b(new zza(this, googleApiClient) {
                    final /* synthetic */ zza f9953d;

                    protected final void m11746b(Api.zzb com_google_android_gms_common_api_Api_zzb) {
                        try {
                            ((zze) com_google_android_gms_common_api_Api_zzb).m11910a(str, launchOptions, (zzlx.zzb) this);
                        } catch (IllegalStateException e) {
                            m11741a(2001);
                        }
                    }
                });
            }

            public final void mo631a(GoogleApiClient googleApiClient) {
                try {
                    ((zze) googleApiClient.a(zzk.f10173a)).m11918r();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final void mo632a(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) {
                try {
                    ((zze) googleApiClient.a(zzk.f10173a)).m11909a(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final PendingResult<ApplicationConnectionResult> mo633b(GoogleApiClient googleApiClient, String str, String str2) {
                final String str3 = str;
                final String str4 = str2;
                final JoinOptions joinOptions = null;
                return googleApiClient.b(new zza(this, googleApiClient) {
                    final /* synthetic */ zza f9957e;

                    protected final void m11747b(Api.zzb com_google_android_gms_common_api_Api_zzb) {
                        try {
                            ((zze) com_google_android_gms_common_api_Api_zzb).m11912a(str3, str4, joinOptions, (zzlx.zzb) this);
                        } catch (IllegalStateException e) {
                            m11741a(2001);
                        }
                    }
                });
            }

            public final void mo634b(GoogleApiClient googleApiClient, String str) {
                try {
                    ((zze) googleApiClient.a(zzk.f10173a)).m11908a(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }
        }

        PendingResult<Status> mo628a(GoogleApiClient googleApiClient, String str);

        PendingResult<Status> mo629a(GoogleApiClient googleApiClient, String str, String str2);

        @Deprecated
        PendingResult<ApplicationConnectionResult> mo630a(GoogleApiClient googleApiClient, String str, boolean z);

        void mo631a(GoogleApiClient googleApiClient);

        void mo632a(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback);

        PendingResult<ApplicationConnectionResult> mo633b(GoogleApiClient googleApiClient, String str, String str2);

        void mo634b(GoogleApiClient googleApiClient, String str);
    }

    public final class CastOptions implements HasOptions {
        final CastDevice f9963a;
        final Listener f9964b;
        public final int f9965c;

        public final class Builder {
            CastDevice f9960a;
            Listener f9961b;
            public int f9962c = 0;

            public Builder(CastDevice castDevice, Listener listener) {
                zzx.a(castDevice, "CastDevice parameter cannot be null");
                zzx.a(listener, "CastListener parameter cannot be null");
                this.f9960a = castDevice;
                this.f9961b = listener;
            }
        }

        public CastOptions(Builder builder) {
            this.f9963a = builder.f9960a;
            this.f9964b = builder.f9961b;
            this.f9965c = builder.f9962c;
        }
    }

    private Cast() {
    }
}
