package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zzd;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public final Object f10101a = new Object();
    public final zzm f10102b = new zzm(this, null) {
        final /* synthetic */ RemoteMediaPlayer f10083a;

        protected final void mo643a() {
            RemoteMediaPlayer remoteMediaPlayer = this.f10083a;
            if (remoteMediaPlayer.f10105e != null) {
                remoteMediaPlayer.f10105e.mo599a();
            }
        }

        protected final void mo644b() {
            RemoteMediaPlayer remoteMediaPlayer = this.f10083a;
            if (remoteMediaPlayer.f10104d != null) {
                remoteMediaPlayer.f10104d.mo600a();
            }
        }
    };
    public final zza f10103c = new zza(this);
    public OnMetadataUpdatedListener f10104d;
    public OnStatusUpdatedListener f10105e;

    public interface OnStatusUpdatedListener {
        void mo599a();
    }

    public interface OnMetadataUpdatedListener {
        void mo600a();
    }

    public abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo f10041i = new C10521(this);

        class C10521 implements zzo {
            final /* synthetic */ zzb f10096a;

            C10521(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.f10096a = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public final void mo647a() {
                this.f10096a.a(this.f10096a.m11801d(new Status(2103)));
            }

            public final void mo648a(int i, Object obj) {
                this.f10096a.a(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public final /* synthetic */ Result m11800c(Status status) {
            return m11801d(status);
        }

        public final MediaChannelResult m11801d(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ zzb f10098b;

                public final Status cp_() {
                    return status;
                }
            };
        }
    }

    public class AnonymousClass17 extends zzb {
        final /* synthetic */ GoogleApiClient f10049b;
        final /* synthetic */ JSONObject f10050c;
        final /* synthetic */ RemoteMediaPlayer f10051d;

        public AnonymousClass17(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.f10051d = remoteMediaPlayer;
            this.f10049b = googleApiClient2;
            this.f10050c = jSONObject;
            super(googleApiClient);
        }

        protected final void m11803b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
            synchronized (this.f10051d.f10101a) {
                this.f10051d.f10103c.m11839a(this.f10049b);
                try {
                    this.f10051d.f10102b.m11820a(this.f10041i, this.f10050c);
                } catch (IOException e) {
                    a(m11801d(new Status(2100)));
                } finally {
                    this.f10051d.f10103c.m11839a(null);
                }
            }
        }
    }

    public class AnonymousClass18 extends zzb {
        final /* synthetic */ GoogleApiClient f10052b;
        final /* synthetic */ JSONObject f10053c;
        final /* synthetic */ RemoteMediaPlayer f10054d;

        public AnonymousClass18(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.f10054d = remoteMediaPlayer;
            this.f10052b = googleApiClient2;
            this.f10053c = jSONObject;
            super(googleApiClient);
        }

        protected final void m11804b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
            synchronized (this.f10054d.f10101a) {
                this.f10054d.f10103c.m11839a(this.f10052b);
                try {
                    this.f10054d.f10102b.m11825b(this.f10041i, this.f10053c);
                } catch (IOException e) {
                    a(m11801d(new Status(2100)));
                } finally {
                    this.f10054d.f10103c.m11839a(null);
                }
            }
        }
    }

    public class AnonymousClass23 extends zzb {
        final /* synthetic */ GoogleApiClient f10089b;
        final /* synthetic */ RemoteMediaPlayer f10090c;

        public AnonymousClass23(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2) {
            this.f10090c = remoteMediaPlayer;
            this.f10089b = googleApiClient2;
            super(googleApiClient);
        }

        protected final void m11834b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
            synchronized (this.f10090c.f10101a) {
                this.f10090c.f10103c.m11839a(this.f10089b);
                try {
                    this.f10090c.f10102b.m11817a(this.f10041i);
                } catch (IOException e) {
                    a(m11801d(new Status(2100)));
                } finally {
                    this.f10090c.f10103c.m11839a(null);
                }
            }
        }
    }

    public interface MediaChannelResult extends Result {
    }

    class zza implements zzn {
        final /* synthetic */ RemoteMediaPlayer f10093a;
        private GoogleApiClient f10094b;
        private long f10095c = 0;

        final class zza implements ResultCallback<Status> {
            final /* synthetic */ zza f10091a;
            private final long f10092b;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.f10091a = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.f10092b = j;
            }

            public final void m11835a(Result result) {
                Status status = (Status) result;
                if (!status.e()) {
                    this.f10091a.f10093a.f10102b.mo640a(this.f10092b, status.g);
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.f10093a = remoteMediaPlayer;
        }

        public final long mo645a() {
            long j = this.f10095c + 1;
            this.f10095c = j;
            return j;
        }

        public final void m11839a(GoogleApiClient googleApiClient) {
            this.f10094b = googleApiClient;
        }

        public final void mo646a(String str, String str2, long j) {
            if (this.f10094b == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.f9969b.mo629a(this.f10094b, str, str2).a(new zza(this, j));
        }
    }

    final class zzc implements MediaChannelResult {
        private final Status f10099a;
        private final JSONObject f10100b;

        zzc(Status status, JSONObject jSONObject) {
            this.f10099a = status;
            this.f10100b = jSONObject;
        }

        public final Status cp_() {
            return this.f10099a;
        }
    }

    public RemoteMediaPlayer() {
        zzd com_google_android_gms_cast_internal_zzd = this.f10102b;
        com_google_android_gms_cast_internal_zzd.f10059b = this.f10103c;
        if (com_google_android_gms_cast_internal_zzd.f10059b == null) {
            com_google_android_gms_cast_internal_zzd.mo639c();
        }
    }

    private PendingResult<MediaChannelResult> m11845a(GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final long j2 = j;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.b(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer f10088f;

            protected final void m11833b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
                synchronized (this.f10088f.f10101a) {
                    this.f10088f.f10103c.m11839a(googleApiClient2);
                    try {
                        this.f10088f.f10102b.m11818a(this.f10041i, j2, i2, jSONObject2);
                    } catch (IOException e) {
                        a(m11801d(new Status(2100)));
                    } finally {
                        this.f10088f.f10103c.m11839a(null);
                    }
                }
            }
        });
    }

    public final long m11846a() {
        long f;
        synchronized (this.f10101a) {
            f = this.f10102b.m11829f();
        }
        return f;
    }

    public final PendingResult<MediaChannelResult> m11847a(GoogleApiClient googleApiClient, long j, int i) {
        return m11845a(googleApiClient, j, i, null);
    }

    public final PendingResult<MediaChannelResult> m11848a(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z2 = z;
        final long j2 = j;
        final long[] jArr2 = jArr;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.b(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer f10048h;

            protected final void m11802b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
                synchronized (this.f10048h.f10101a) {
                    this.f10048h.f10103c.m11839a(googleApiClient2);
                    try {
                        this.f10048h.f10102b.m11819a(this.f10041i, mediaInfo2, z2, j2, jArr2, jSONObject2);
                    } catch (IOException e) {
                        a(m11801d(new Status(2100)));
                    } finally {
                        this.f10048h.f10103c.m11839a(null);
                    }
                }
            }
        });
    }

    public final void m11849a(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.f10104d = onMetadataUpdatedListener;
    }

    public final void m11850a(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.f10105e = onStatusUpdatedListener;
    }

    public final void mo604a(String str, String str2) {
        this.f10102b.mo641a(str2);
    }

    public final MediaStatus m11852b() {
        MediaStatus g;
        synchronized (this.f10101a) {
            g = this.f10102b.m11830g();
        }
        return g;
    }

    public final PendingResult<MediaChannelResult> m11853c(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.b(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer f10057d;

            protected final void m11805b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
                synchronized (this.f10057d.f10101a) {
                    this.f10057d.f10103c.m11839a(googleApiClient);
                    try {
                        this.f10057d.f10102b.m11827c(this.f10041i, jSONObject);
                    } catch (IOException e) {
                        a(m11801d(new Status(2100)));
                    } finally {
                        this.f10057d.f10103c.m11839a(null);
                    }
                }
            }
        });
    }

    public final String m11854c() {
        return this.f10102b.f10058a;
    }
}
