package com.facebook.video.server;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.iolite.FbFilterOutputStream;
import com.facebook.common.iolite.ProgressOutputStream;
import com.facebook.common.iolite.ProgressOutputStream.Listener;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.PartialFileStorage;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.SourceType;
import com.facebook.video.abtest.ThrottlingConfig;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.server.AsyncWriter.Handler;
import com.facebook.video.server.VideoServerModule.1;
import com.facebook.video.server.prefetcher.VideoPrefetcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.TransferListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.inject.Provider;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.AbstractHttpEntity;

/* compiled from: payments/ */
public class VideoServer$VideoServerWorker {
    private final PartialFileStorage<VideoCacheKey> f5399a;
    private final DefaultAndroidThreadUtil f5400b;
    private final Provider<Boolean> f5401c;
    public final AbstractFbErrorReporter f5402d;
    public final VideoServerLogger f5403e;
    public final 1 f5404f;
    private final ScheduledExecutorService f5405g;
    private final MonotonicClock f5406h;
    private final ThrottlingPolicyFactory f5407i;
    private final FbDataConnectionManager f5408j;
    private final DefaultNetworkProcessor f5409k;
    public final Lazy<VideoPrefetcher> f5410l;
    private final BandwidthMeter f5411m;
    private final Provider<VideoDashConfig> f5412n;
    public final QeAccessor f5413o;
    public final VideoPlayerSessionManager f5414p;
    public final TypedEventBus f5415q;
    private final LoggedInUserSessionManager f5416r;
    private final ObjectMapper f5417s;
    private final TimeoutStreamHelper f5418t;
    public final SourceType f5419u;

    @VisibleForTesting
    /* compiled from: payments/ */
    public class RequestParams {
        public final boolean f5431a;
        public final long f5432b;
        public final long f5433c;
        public final Range f5434d;

        public RequestParams(boolean z, long j, long j2) {
            this.f5431a = z;
            this.f5432b = j;
            this.f5433c = j2;
            this.f5434d = j < j2 ? new Range(j, j2) : null;
        }
    }

    /* compiled from: payments/ */
    public class RangeTask {
        public final Uri f5435a;
        public final int f5436b;
        public final String f5437c;
        public final RequestParams f5438d;
        VideoServerLogger$RequestListenerImpl f5439e;
        final /* synthetic */ VideoServer$VideoServerWorker f5440f;
        private RequestLiveInfoImpl f5441g;
        private RangeWriter f5442h;
        private FileMetadata f5443i;
        public Range f5444j;

        public RangeTask(VideoServer$VideoServerWorker videoServer$VideoServerWorker, Uri uri, int i, String str, RequestParams requestParams) {
            this.f5440f = videoServer$VideoServerWorker;
            this.f5435a = uri;
            this.f5436b = i;
            this.f5437c = str;
            this.f5438d = requestParams;
        }

        public final Range m5908a() {
            return this.f5444j;
        }

        public final FileMetadata m5911b() {
            return this.f5443i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m5910a(boolean r13, boolean r14) {
            /*
            r12 = this;
            r0 = new com.facebook.video.server.VideoServer$VideoServerWorker$RequestLiveInfoImpl;
            r0.<init>();
            r12.f5441g = r0;
            r0 = -1;
            r2 = r12.f5440f;	 Catch:{ IOException -> 0x0118 }
            r3 = r12.f5435a;	 Catch:{ IOException -> 0x0118 }
            r0 = r2.m5895a(r3);	 Catch:{ IOException -> 0x0118 }
        L_0x0011:
            r2 = r12.f5440f;
            r3 = r12.f5437c;
            r4 = new com.facebook.video.server.VideoServerEvents$RequestBeginEvent;
            r5 = r12.f5441g;
            r4.<init>(r5, r0);
            com.facebook.video.server.VideoServer$VideoServerWorker.m5890a(r2, r3, r4);
            r0 = r12.f5440f;
            r1 = r12.f5437c;
            r2 = new com.facebook.video.server.VideoServerEvents$RequestGrantedEvent;
            r2.<init>();
            com.facebook.video.server.VideoServer$VideoServerWorker.m5890a(r0, r1, r2);
            r0 = r12.f5440f;
            r0 = r0.f5403e;
            r1 = r12.f5437c;
            r2 = r12.f5435a;
            r3 = r12.f5436b;
            r0 = r0.a(r1, r2, r3);
            r12.f5439e = r0;
            r1 = new java.net.URL;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r12.f5435a;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.toString();	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r1.<init>(r0);	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r12.f5440f;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.f5404f;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r2 = r12.f5435a;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r7 = r0.a(r2);	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r12.f5440f;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.f5414p;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r2 = r12.f5436b;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.b(r2);	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            if (r0 == 0) goto L_0x0129;
        L_0x005c:
            r2 = r0.m6165e();	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
        L_0x0060:
            r0 = r12.f5440f;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r3 = r12.f5436b;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r3 = com.facebook.video.server.VideoServer$VideoServerWorker.m5886a(r0, r3);	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r12.f5440f;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.f5419u;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r4 = com.facebook.video.abtest.SourceType.HTTP_1RT_INTERCEPTING;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            if (r0 == r4) goto L_0x012c;
        L_0x0070:
            r0 = 1;
            r4 = r0;
        L_0x0072:
            r0 = r12.f5440f;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.f5410l;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r0.get();	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = (com.facebook.video.server.prefetcher.VideoPrefetcher) r0;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r5 = r12.f5435a;	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r9 = r0.a(r5, r4);	 Catch:{ InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a, Throwable -> 0x0174 }
            r0 = r12.f5440f;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r4 = r12.f5437c;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r5 = r12.f5439e;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r6 = r12.f5441g;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r8 = r12.f5438d;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r10 = r13;
            r11 = r14;
            r0 = r0.m5884a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r12.f5442h = r0;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r0 = r12.f5442h;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r0 = r0.mo526a();	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r12.f5443i = r0;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r0 = r12.f5443i;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r3.m5931a(r0);	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r0 = r12.f5443i;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r0 = r0.f5544a;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r2 = r12.f5438d;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r2 = r2.f5434d;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r12.f5444j = r2;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r2 = r12.f5444j;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            if (r2 != 0) goto L_0x013b;
        L_0x00af:
            r2 = r12.f5438d;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r4 = r2.f5432b;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
            if (r2 < 0) goto L_0x0130;
        L_0x00b7:
            if (r13 != 0) goto L_0x0130;
        L_0x00b9:
            r2 = new com.facebook.video.server.VideoServer$VideoServerWorker$InvalidRangeRequestedException;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r3.<init>();	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r4 = r12.f5438d;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r4 = r4.f5432b;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r4 = "-";
            r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r3 = r3.toString();	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            r2.<init>(r3, r0);	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
            throw r2;	 Catch:{ Throwable -> 0x00d6, InvalidRangeRequestedException -> 0x00ff, NetworkAccessException -> 0x0160, ThrottlingStopException -> 0x016a }
        L_0x00d6:
            r0 = move-exception;
            r1 = r0;
            if (r9 == 0) goto L_0x00e3;
        L_0x00da:
            r0 = r9.b;	 Catch:{ IOException -> 0x015b }
            r0 = r0.b();	 Catch:{ IOException -> 0x015b }
            r0.close();	 Catch:{ IOException -> 0x015b }
        L_0x00e3:
            r0 = r12.f5440f;	 Catch:{  }
            r0 = r0.f5410l;	 Catch:{  }
            r0 = r0.get();	 Catch:{  }
            r0 = (com.facebook.video.server.prefetcher.VideoPrefetcher) r0;	 Catch:{  }
            r2 = r12.f5435a;	 Catch:{  }
            r0.a(r2);	 Catch:{  }
            r0 = java.io.IOException.class;
            com.google.common.base.Throwables.propagateIfPossible(r1, r0);	 Catch:{  }
            r0 = new java.io.IOException;	 Catch:{  }
            r2 = "Unexpected exception!";
            r0.<init>(r2, r1);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x00ff:
            r0 = move-exception;
            r1 = com.facebook.video.server.VideoServer.c;
            r2 = "Invalid range specified";
            com.facebook.debug.log.BLog.a(r1, r2, r0);
            r1 = r12.f5440f;
            r1 = r1.f5402d;
            r2 = com.facebook.video.server.VideoServer.c;
            r3 = "Invalid range specified";
            r1.a(r2, r3, r0);
            r1 = r12.f5439e;
            r1.m5926b(r0);
            throw r0;
        L_0x0118:
            r2 = move-exception;
            com.facebook.video.server.VideoServer.d();
            r3 = r12.f5440f;
            r3 = r3.f5402d;
            r4 = com.facebook.video.server.VideoServer.c;
            r5 = "Error checking video cache for firing RequestBeginEvent";
            r3.a(r4, r5, r2);
            goto L_0x0011;
        L_0x0129:
            r2 = 0;
            goto L_0x0060;
        L_0x012c:
            r0 = 0;
            r4 = r0;
            goto L_0x0072;
        L_0x0130:
            r2 = new com.facebook.ui.media.cache.Range;	 Catch:{  }
            r4 = r12.f5438d;	 Catch:{  }
            r4 = r4.f5432b;	 Catch:{  }
            r2.<init>(r4, r0);	 Catch:{  }
            r12.f5444j = r2;	 Catch:{  }
        L_0x013b:
            com.facebook.video.server.VideoServer.d();	 Catch:{  }
            r0 = r12.f5438d;	 Catch:{  }
            r0 = r0.f5431a;	 Catch:{  }
            java.lang.Boolean.valueOf(r0);	 Catch:{  }
            r0 = r12.f5436b;	 Catch:{  }
            java.lang.Integer.valueOf(r0);	 Catch:{  }
            r0 = r12.f5444j;	 Catch:{  }
            r3.m5932a(r0);	 Catch:{  }
            r0 = r12.f5439e;	 Catch:{  }
            r1 = r12.f5438d;	 Catch:{  }
            r1 = r1.f5431a;	 Catch:{  }
            r2 = r12.f5444j;	 Catch:{  }
            r0.m5925a(r1, r2);	 Catch:{  }
            return;
        L_0x015b:
            r0 = move-exception;
            com.facebook.video.server.VideoServer.d();	 Catch:{  }
            goto L_0x00e3;
        L_0x0160:
            r0 = move-exception;
            com.facebook.video.server.VideoServer.d();
            r1 = r12.f5439e;
            r1.m5926b(r0);
            throw r0;
        L_0x016a:
            r0 = move-exception;
            com.facebook.video.server.VideoServer.d();
            r1 = r12.f5439e;
            r1.m5924a(r0);
            throw r0;
        L_0x0174:
            r0 = move-exception;
            r1 = com.facebook.video.server.VideoServer.c;
            r2 = "Error handling local request";
            com.facebook.debug.log.BLog.a(r1, r2, r0);
            r1 = r12.f5440f;
            r1 = r1.f5402d;
            r2 = com.facebook.video.server.VideoServer.c;
            r3 = "Error handling local request";
            r1.a(r2, r3, r0);
            r1 = r12.f5439e;
            r1.m5926b(r0);
            r1 = java.io.IOException.class;
            com.google.common.base.Throwables.propagateIfPossible(r0, r1);
            r1 = new java.io.IOException;
            r2 = "Unexpected exception";
            r1.<init>(r2, r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.VideoServer.VideoServerWorker.RangeTask.a(boolean, boolean):void");
        }

        public final void m5909a(OutputStream outputStream) {
            try {
                this.f5442h.mo525a(this.f5444j, m5905b(m5906c(new CheckedOutputStream(outputStream))));
                this.f5439e.m5927c();
                m5907d();
            } catch (Throwable e) {
                this.f5439e.m5924a(e);
                VideoServer.d();
                throw e;
            } catch (Throwable e2) {
                this.f5439e.m5924a(e2);
                VideoServer.d();
                throw e2;
            } catch (ThrottlingStopException e3) {
                this.f5439e.m5924a(e3);
                VideoServer.d();
                throw e3;
            } catch (Throwable e22) {
                BLog.a(VideoServer.c, "Error (not-network) when sending content to client", e22);
                this.f5439e.m5924a(e22);
                throw e22;
            } catch (Throwable th) {
                m5907d();
            }
        }

        private void m5907d() {
            ((VideoPrefetcher) this.f5440f.f5410l.get()).a(this.f5435a);
        }

        public final void m5912c() {
            m5907d();
        }

        private OutputStream m5905b(OutputStream outputStream) {
            Listener listener = this.f5439e.f5470p;
            if (listener != null) {
                return new ProgressOutputStream(outputStream, listener);
            }
            return outputStream;
        }

        private OutputStream m5906c(OutputStream outputStream) {
            return new ProgressOutputStream(outputStream, new ServedBytesListener(this.f5440f, this.f5441g));
        }
    }

    /* compiled from: payments/ */
    public class RequestLiveInfoImpl {
        private final AtomicLong f5445a = new AtomicLong(0);
        public final AtomicLong f5446b = new AtomicLong(0);
        private final AtomicInteger f5447c = new AtomicInteger(0);
        private final AtomicInteger f5448d = new AtomicInteger(0);
        private final AtomicInteger f5449e = new AtomicInteger(0);
        private final AtomicInteger f5450f = new AtomicInteger(0);
        private final AtomicLong f5451g = new AtomicLong(0);
        private final AtomicLong f5452h = new AtomicLong(0);

        public final long m5913a() {
            return this.f5445a.get();
        }

        public final long m5914b() {
            return this.f5446b.get();
        }

        public final int m5916c() {
            return 0;
        }

        public final int m5917d() {
            return 0;
        }

        public final int m5918e() {
            return 0;
        }

        public final int m5919f() {
            return 0;
        }

        public final long m5920g() {
            return 0;
        }

        public final long m5921h() {
            return 0;
        }

        public final void m5915b(long j) {
            this.f5445a.addAndGet(j);
        }
    }

    /* compiled from: payments/ */
    class InstrumentedRangeWriter implements RangeWriter {
        final /* synthetic */ VideoServer$VideoServerWorker f5499a;
        private final RangeWriter f5500b;
        @Nullable
        public final String f5501c;
        @Nullable
        private final TransferListener f5502d;

        public InstrumentedRangeWriter(VideoServer$VideoServerWorker videoServer$VideoServerWorker, RangeWriter rangeWriter, @Nullable String str, @Nullable TransferListener transferListener) {
            this.f5499a = videoServer$VideoServerWorker;
            this.f5500b = rangeWriter;
            this.f5501c = str;
            this.f5502d = transferListener;
        }

        public final FileMetadata mo526a() {
            this.f5499a.m5887a(-1, -1, this.f5501c);
            try {
                FileMetadata a = this.f5500b.mo526a();
                this.f5499a.m5892b(-1, -1, this.f5501c);
                return a;
            } finally {
                VideoServer$VideoServerWorker.m5889a(this.f5499a, this.f5501c);
            }
        }

        public final long mo525a(Range range, OutputStream outputStream) {
            long j = range.a;
            long j2 = range.b;
            if (this.f5502d != null) {
                this.f5502d.b();
            }
            this.f5499a.m5887a(j, j2, this.f5501c);
            try {
                final long j3 = j;
                final long j4 = j2;
                long a = this.f5500b.mo525a(range, new FbFilterOutputStream(this, outputStream) {
                    final /* synthetic */ InstrumentedRangeWriter f5564c;
                    private boolean f5565d;

                    public void write(byte[] bArr, int i, int i2) {
                        if (!this.f5565d) {
                            this.f5565d = true;
                            this.f5564c.f5499a.m5892b(j3, j4, this.f5564c.f5501c);
                        }
                        super.write(bArr, i, i2);
                    }
                });
                return a;
            } finally {
                if (this.f5502d != null) {
                    this.f5502d.c();
                }
                VideoServer$VideoServerWorker.m5889a(this.f5499a, this.f5501c);
            }
        }
    }

    /* compiled from: payments/ */
    class CheckedRangeWriter implements RangeWriter {
        private final RangeWriter f5533a;
        private FileMetadata f5534b;

        public CheckedRangeWriter(RangeWriter rangeWriter) {
            this.f5533a = rangeWriter;
        }

        public final long mo525a(Range range, OutputStream outputStream) {
            if (range.a >= 0) {
                return this.f5533a.mo525a(range, outputStream);
            }
            throw new InvalidRangeRequestedException(range.toString());
        }

        public final FileMetadata mo526a() {
            if (this.f5534b == null) {
                FileMetadata a = this.f5533a.mo526a();
                VideoServer$VideoServerWorker.m5893b(a);
                this.f5534b = a;
            }
            return this.f5534b;
        }
    }

    /* compiled from: payments/ */
    class RangeWriterEntity extends AbstractHttpEntity {
        private final RangeTask f5553a;

        public RangeWriterEntity(RangeTask rangeTask) {
            this.f5553a = rangeTask;
        }

        public boolean isRepeatable() {
            return false;
        }

        public long getContentLength() {
            return this.f5553a.f5444j.a();
        }

        public InputStream getContent() {
            throw new IllegalStateException("Cannot call getContent on a RangeWriterEntity");
        }

        public void writeTo(OutputStream outputStream) {
            try {
                this.f5553a.m5909a(outputStream);
            } catch (NetworkAccessException e) {
            } catch (ClientConnectionException e2) {
            } catch (ThrottlingStopException e3) {
            } catch (Throwable th) {
                VideoServer.d();
                Throwables.propagateIfPossible(th, IOException.class);
                IOException iOException = new IOException("wtf", th);
            }
        }

        public boolean isStreaming() {
            return true;
        }
    }

    /* compiled from: payments/ */
    class CheckedOutputStream extends FbFilterOutputStream {
        public CheckedOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public void write(byte[] bArr, int i, int i2) {
            try {
                super.write(bArr, i, i2);
            } catch (Throwable e) {
                throw new ClientConnectionException("Error writing to client", e);
            }
        }
    }

    /* compiled from: payments/ */
    class ServedBytesListener implements Listener {
        final /* synthetic */ VideoServer$VideoServerWorker f5556a;
        private final RequestLiveInfoImpl f5557b;

        public ServedBytesListener(VideoServer$VideoServerWorker videoServer$VideoServerWorker, RequestLiveInfoImpl requestLiveInfoImpl) {
            this.f5556a = videoServer$VideoServerWorker;
            this.f5557b = requestLiveInfoImpl;
        }

        public final void m5982a(long j, long j2) {
            this.f5557b.f5446b.addAndGet(j);
        }
    }

    /* compiled from: payments/ */
    class ClientConnectionException extends IOException {
        public ClientConnectionException(String str, Throwable th) {
            super(str, th);
        }
    }

    public VideoServer$VideoServerWorker(PartialFileStorage<VideoCacheKey> partialFileStorage, AndroidThreadUtil androidThreadUtil, TypedEventBus typedEventBus, FbErrorReporter fbErrorReporter, Provider<Boolean> provider, VideoServerListener videoServerListener, QeAccessor qeAccessor, Lazy<VideoPrefetcher> lazy, MonotonicClock monotonicClock, VideoPlayerSessionManager videoPlayerSessionManager, VideoKeyCreator videoKeyCreator, ScheduledExecutorService scheduledExecutorService, ThrottlingPolicyFactory throttlingPolicyFactory, FbDataConnectionManager fbDataConnectionManager, NetworkProcessor networkProcessor, LoggedInUserAuthDataStore loggedInUserAuthDataStore, ObjectMapper objectMapper, Provider<VideoDashConfig> provider2, SourceType sourceType, TimeoutStreamHelper timeoutStreamHelper) {
        this.f5399a = (PartialFileStorage) Preconditions.checkNotNull(partialFileStorage);
        this.f5400b = (DefaultAndroidThreadUtil) Preconditions.checkNotNull(androidThreadUtil);
        this.f5415q = (TypedEventBus) Preconditions.checkNotNull(typedEventBus);
        this.f5402d = (AbstractFbErrorReporter) Preconditions.checkNotNull(fbErrorReporter);
        this.f5401c = (Provider) Preconditions.checkNotNull(provider);
        this.f5403e = (VideoServerLogger) Preconditions.checkNotNull(videoServerListener);
        this.f5413o = (QeAccessor) Preconditions.checkNotNull(qeAccessor);
        this.f5410l = lazy;
        this.f5406h = monotonicClock;
        this.f5414p = videoPlayerSessionManager;
        this.f5404f = (1) Preconditions.checkNotNull(videoKeyCreator);
        this.f5405g = scheduledExecutorService;
        this.f5407i = throttlingPolicyFactory;
        this.f5408j = fbDataConnectionManager;
        this.f5409k = networkProcessor;
        this.f5416r = loggedInUserAuthDataStore;
        this.f5417s = objectMapper;
        this.f5419u = sourceType;
        this.f5418t = timeoutStreamHelper;
        this.f5411m = new CustomBandwidthMeter(monotonicClock);
        this.f5412n = provider2;
    }

    public final TypedEventBus m5896a() {
        return this.f5415q;
    }

    public final long m5895a(Uri uri) {
        PartialFile b = this.f5399a.b(this.f5404f.a(uri));
        if (b == null) {
            return 0;
        }
        List f = b.f();
        if (f == null || f.isEmpty()) {
            return -1;
        }
        return ((Range) f.get(0)).a;
    }

    public final void m5897a(Uri uri, long j, long j2, String str, int i, Handler handler) {
        boolean z = j > 0 || j2 > 0;
        RangeTask rangeTask = new RangeTask(this, uri, i, str, new RequestParams(z, j, j2));
        try {
            rangeTask.m5910a(false, false);
            OutputStream a = handler.a(rangeTask.m5911b());
            if (a == null) {
                rangeTask.m5912c();
                return;
            }
            try {
                rangeTask.m5909a(a);
                handler.a(a, null);
            } catch (IOException e) {
                handler.a(a, e);
            } catch (Throwable th) {
                handler.a(a, null);
            }
        } catch (IOException e2) {
            handler.a(e2);
        }
    }

    public final void m5898a(HttpRequest httpRequest, HttpResponse httpResponse) {
        Uri parse = Uri.parse(httpRequest.getRequestLine().getUri());
        String g = VideoServer.g(parse);
        int a = VideoServer.a(parse);
        Uri d = VideoServer.d(parse);
        boolean b = VideoServer.b(parse);
        boolean c = VideoServer.c(parse);
        VideoServer.d();
        Integer.valueOf(a);
        httpRequest.getRequestLine();
        try {
            RequestParams a2 = m5885a(httpRequest);
            VideoServer.d();
            Boolean.valueOf(a2.f5431a);
            Long.valueOf(a2.f5432b);
            Long.valueOf(a2.f5433c);
            RangeTask rangeTask = new RangeTask(this, d, a, g, a2);
            boolean z = c && this.f5413o.a(ExperimentsForVideoAbTestModule.bE, false);
            try {
                rangeTask.m5910a(b, z);
                try {
                    FileMetadata fileMetadata = (FileMetadata) Preconditions.checkNotNull(rangeTask.m5911b());
                    httpResponse.setStatusLine(new ProtocolVersion("HTTP", 1, 1), a2.f5431a ? 206 : 200, "OK");
                    m5891a(httpResponse);
                    httpResponse.setHeader("Content-Type", fileMetadata.f5545b);
                    if (a2.f5431a) {
                        Range a3 = rangeTask.m5908a();
                        httpResponse.addHeader("Content-Range", StringFormatUtil.formatStrLocaleSafe("bytes %d-%d/%d", Long.valueOf(a3.a), Long.valueOf(a3.b - 1), Long.valueOf(fileMetadata.f5544a)));
                    }
                    httpResponse.setEntity(new RangeWriterEntity(rangeTask));
                } catch (Throwable th) {
                    rangeTask.m5912c();
                    HttpException httpException = new HttpException("Error handling local request", th);
                }
            } catch (InvalidRangeRequestedException e) {
                httpResponse.setStatusCode(400);
            } catch (IOException e2) {
                httpResponse.setStatusCode(502);
            } catch (Throwable th2) {
                HttpException httpException2 = new HttpException("Error handling local request", th2);
            }
        } catch (InvalidRangeRequestedException e3) {
            BLog.a(VideoServer.c, e3, "Invalid range specification", new Object[0]);
            httpResponse.setStatusCode(400);
        }
    }

    private RangeWriter m5884a(URL url, CallerContext callerContext, VideoServerRequestIdentifier videoServerRequestIdentifier, String str, VideoServerLogger$RequestListenerImpl videoServerLogger$RequestListenerImpl, RequestLiveInfoImpl requestLiveInfoImpl, VideoCacheKey videoCacheKey, RequestParams requestParams, InterceptedReader interceptedReader, boolean z, boolean z2) {
        RangeWriter checkedRangeWriter;
        Uri parse = Uri.parse(url.toString());
        RequestPriority a = m5875a(z2);
        VideoServer.d();
        Boolean.valueOf(z2);
        if (this.f5419u == SourceType.HTTP) {
            checkedRangeWriter = new CheckedRangeWriter(m5882a(m5878a(m5881a(m5879a(new NetworkRangeWriter(url, a, callerContext, this.f5409k, this.f5402d, this.f5416r, this.f5417s), videoServerLogger$RequestListenerImpl.m5923a(), requestLiveInfoImpl, ((VideoDashConfig) this.f5412n.get()).y ? this.f5411m : null), str)), url, videoServerRequestIdentifier));
        } else {
            AsyncWriter a2 = m5877a(m5876a(new NetworkAsyncWriter(parse, this.f5409k, callerContext, a, "getVideo-1RT", this.f5402d, this.f5416r, this.f5417s, this.f5418t), videoServerLogger$RequestListenerImpl.m5923a(), requestLiveInfoImpl, ((VideoDashConfig) this.f5412n.get()).y ? this.f5411m : null), str);
            ThrottlingConfig throttlingConfig = new ThrottlingConfig(this.f5413o);
            ThrottlingAsyncWriter throttlingAsyncWriter = new ThrottlingAsyncWriter(videoServerRequestIdentifier, a2, this.f5405g, ThrottlingPolicyFactory.m5873a(throttlingConfig, this.f5406h, this.f5414p, this.f5408j), throttlingConfig.f5526v, 204800);
            long j = requestParams.f5433c;
            long j2 = ((VideoDashConfig) this.f5412n.get()).P;
            if (j2 > 0 && requestParams.f5434d != null && requestParams.f5434d.a() <= j2) {
                j = requestParams.f5432b + j2;
            }
            checkedRangeWriter = new AsyncWriterRangeWriter(requestParams.f5432b, j, throttlingAsyncWriter);
        }
        if (!z) {
            checkedRangeWriter = m5880a(checkedRangeWriter, this.f5399a, videoCacheKey);
        }
        if (interceptedReader == null) {
            return checkedRangeWriter;
        }
        VideoServer.d();
        return new InterceptingRangeWriter(interceptedReader, checkedRangeWriter);
    }

    private RangeWriter m5880a(RangeWriter rangeWriter, PartialFileStorage<VideoCacheKey> partialFileStorage, VideoCacheKey videoCacheKey) {
        if (!((Boolean) this.f5401c.get()).booleanValue()) {
            return rangeWriter;
        }
        return new CachingThroughRangeWriter(partialFileStorage, videoCacheKey, rangeWriter, ((VideoDashConfig) this.f5412n.get()).P);
    }

    public final BandwidthMeter m5899b() {
        return this.f5411m;
    }

    private AsyncWriter m5877a(AsyncWriter asyncWriter, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return asyncWriter;
        }
        return new InstrumentedAsyncWriter(this, asyncWriter, str, ((VideoDashConfig) this.f5412n.get()).y ? this.f5411m : null);
    }

    private RangeWriter m5881a(RangeWriter rangeWriter, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return rangeWriter;
        }
        return new InstrumentedRangeWriter(this, rangeWriter, str, ((VideoDashConfig) this.f5412n.get()).y ? this.f5411m : null);
    }

    private static RequestPriority m5875a(boolean z) {
        return z ? RequestPriority.INTERACTIVE : RequestPriority.NON_INTERACTIVE;
    }

    private RangeWriter m5882a(RangeWriter rangeWriter, URL url, VideoServerRequestIdentifier videoServerRequestIdentifier) {
        Object obj = 1;
        String path = url.getPath();
        Object obj2 = (path == null || !path.endsWith(".mpd")) ? null : 1;
        if (!(obj2 == null && new ThrottlingConfig(this.f5413o).f5505a)) {
            obj = null;
        }
        if (obj == null) {
            return rangeWriter;
        }
        return new ThrottlingRangeWriter(rangeWriter, videoServerRequestIdentifier, ThrottlingPolicyFactory.m5873a(new ThrottlingConfig(this.f5413o), this.f5406h, this.f5414p, this.f5408j));
    }

    private static RangeWriter m5878a(RangeWriter rangeWriter) {
        return new ChunkedRangeWriter(rangeWriter, 204800);
    }

    public static VideoServerRequestIdentifier m5886a(VideoServer$VideoServerWorker videoServer$VideoServerWorker, int i) {
        return new VideoServerRequestIdentifier(i, videoServer$VideoServerWorker.f5406h.now());
    }

    private RangeWriter m5879a(final RangeWriter rangeWriter, final Listener listener, final RequestLiveInfoImpl requestLiveInfoImpl, final TransferListener transferListener) {
        final C02281 c02281 = new Listener(this) {
            final /* synthetic */ VideoServer$VideoServerWorker f5495d;

            public final void m5949a(long j, long j2) {
                listener.a(j, j2);
                requestLiveInfoImpl.m5915b(j);
                if (transferListener != null) {
                    transferListener.a((int) j);
                }
            }
        };
        return new RangeWriter(this) {
            final /* synthetic */ VideoServer$VideoServerWorker f5498c;

            public final long mo525a(Range range, OutputStream outputStream) {
                return rangeWriter.mo525a(range, new ProgressOutputStream(outputStream, c02281));
            }

            public final FileMetadata mo526a() {
                return rangeWriter.mo526a();
            }
        };
    }

    private AsyncWriter m5876a(AsyncWriter asyncWriter, Listener listener, RequestLiveInfoImpl requestLiveInfoImpl, TransferListener transferListener) {
        return new 4(this, asyncWriter, new 3(this, listener, requestLiveInfoImpl, transferListener));
    }

    private void m5887a(long j, long j2, String str) {
        if (str != null) {
            m5890a(this, str, new VideoServerEvents$NetworkAccessRequestedEvent(j, j2));
        }
    }

    private void m5892b(long j, long j2, String str) {
        if (str != null) {
            m5890a(this, str, new VideoServerEvents$NetworkAccessRetrievedEvent(j, j2));
        }
    }

    public static void m5889a(VideoServer$VideoServerWorker videoServer$VideoServerWorker, String str) {
        if (str != null) {
            m5890a(videoServer$VideoServerWorker, str, new VideoServerEvents$NetworkAccessEndedEvent());
        }
    }

    public static void m5890a(VideoServer$VideoServerWorker videoServer$VideoServerWorker, String str, TypedEvent typedEvent) {
        final VideoServer$VideoIdEvent videoServer$VideoIdEvent = new VideoServer$VideoIdEvent(str, typedEvent);
        videoServer$VideoServerWorker.f5400b.a(new Runnable(videoServer$VideoServerWorker) {
            final /* synthetic */ VideoServer$VideoServerWorker f5454b;

            public void run() {
                this.f5454b.f5415q.a(videoServer$VideoIdEvent);
            }
        });
    }

    public static void m5893b(FileMetadata fileMetadata) {
        long j = fileMetadata.f5544a;
        if (j <= 0) {
            throw new InvalidResourceLengthException(j);
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    @VisibleForTesting
    private static RequestParams m5885a(HttpRequest httpRequest) {
        Header firstHeader = httpRequest.getFirstHeader("Range");
        if (firstHeader == null) {
            return new RequestParams(false, 0, -1);
        }
        String value = firstHeader.getValue();
        if (!value.startsWith("bytes=")) {
            return new RequestParams(false, 0, -1);
        }
        String substring = value.substring(6);
        int indexOf = substring.indexOf(45);
        if (indexOf < 0) {
            indexOf = substring.length();
        }
        try {
            long parseLong = Long.parseLong(substring.substring(0, indexOf));
            value = substring.substring(indexOf + 1);
            if (value.length() <= 0) {
                return new RequestParams(true, parseLong, -1);
            }
            long parseLong2 = 1 + Long.parseLong(value);
            if (parseLong < parseLong2) {
                return new RequestParams(true, parseLong, parseLong2);
            }
            throw new InvalidRangeRequestedException(substring);
        } catch (NumberFormatException e) {
            throw new InvalidRangeRequestedException(substring);
        }
    }

    private static void m5891a(HttpResponse httpResponse) {
        httpResponse.addHeader("Connection", "keep-alive");
        httpResponse.addHeader("Accept-Ranges", "bytes");
    }
}
