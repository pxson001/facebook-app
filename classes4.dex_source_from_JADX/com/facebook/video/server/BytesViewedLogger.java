package com.facebook.video.server;

import android.net.Uri;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.video.analytics.VideoPerformanceTracking;
import com.facebook.video.api.AsyncVideo$PlayPausedEvent;
import com.facebook.video.api.AsyncVideo$PlayStartedEvent;
import com.facebook.video.server.VideoServerModule.1;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescriptionParser;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.dash.mpd.Representation;
import com.google.android.exoplayer.dash.mpd.Representation.MultiSegmentRepresentation;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: people_tab */
public class BytesViewedLogger {
    public static final String f5182a = BytesViewedLogger.class.getName();
    private final 1 f5183b;
    private final FbNetworkManager f5184c;
    private final Lazy<VideoPerformanceTracking> f5185d;
    private final Handler f5186e = new Handler(this);
    private TypedEventBus f5187f;
    public VideoCacheKey f5188g;
    public int f5189h;
    public int f5190i = -1;
    private String f5191j = null;

    /* compiled from: people_tab */
    public class Handler implements TypedHandler, com.facebook.video.api.AsyncVideo$PlayStartedEvent.Handler {
        public final /* synthetic */ BytesViewedLogger f5192a;

        public Handler(BytesViewedLogger bytesViewedLogger) {
            this.f5192a = bytesViewedLogger;
        }

        public final void mo468a(AsyncVideo$PlayStartedEvent asyncVideo$PlayStartedEvent) {
            this.f5192a.f5190i = asyncVideo$PlayStartedEvent.f5278b;
        }
    }

    public static BytesViewedLogger m5630b(InjectorLike injectorLike) {
        return new BytesViewedLogger(VideoKeyCreatorMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3645));
    }

    public static BytesViewedLogger m5628a(InjectorLike injectorLike) {
        return m5630b(injectorLike);
    }

    @Inject
    public BytesViewedLogger(VideoKeyCreator videoKeyCreator, FbNetworkManager fbNetworkManager, Lazy<VideoPerformanceTracking> lazy) {
        this.f5183b = videoKeyCreator;
        this.f5184c = fbNetworkManager;
        this.f5185d = lazy;
    }

    public final void m5633a(Uri uri) {
        if (VideoServer.f(uri)) {
            this.f5191j = VideoServer.g(uri);
            uri = VideoServer.d(uri);
        }
        this.f5188g = uri == null ? null : this.f5183b.a(uri);
    }

    public final void m5631a(int i) {
        this.f5189h = i;
    }

    public final void m5632a(int i, int i2) {
        if (this.f5189h != i) {
            m5629a(this, (long) this.f5190i, (long) i2);
            this.f5189h = i;
            this.f5190i = i2;
        }
    }

    public final void m5634a(TypedEventBus typedEventBus) {
        Preconditions.checkArgument(this.f5187f == null, "Cannot register twice");
        this.f5187f = (TypedEventBus) Preconditions.checkNotNull(typedEventBus);
        this.f5187f.a(AsyncVideo$PlayStartedEvent.class, this.f5186e);
        this.f5187f.a(AsyncVideo$PlayPausedEvent.class, this.f5186e);
    }

    public static void m5629a(BytesViewedLogger bytesViewedLogger, long j, long j2) {
        boolean v = bytesViewedLogger.f5184c.v();
        Long.valueOf(j);
        Long.valueOf(j2);
        Integer.valueOf(bytesViewedLogger.f5189h);
        Boolean.valueOf(v);
        ((VideoPerformanceTracking) bytesViewedLogger.f5185d.get()).a(bytesViewedLogger.f5188g, j, j2, bytesViewedLogger.f5189h, v, bytesViewedLogger.f5191j);
    }

    public final void m5635a(String str, String str2) {
        InputStream byteArrayInputStream;
        Throwable e;
        InputStream inputStream = null;
        if (!StringUtil.a(str)) {
            MediaPresentationDescriptionParser mediaPresentationDescriptionParser = new MediaPresentationDescriptionParser();
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                try {
                    for (AdaptationSet adaptationSet : ((Period) mediaPresentationDescriptionParser.a(null, byteArrayInputStream).i.get(0)).d) {
                        for (Representation representation : adaptationSet.c) {
                            if (representation instanceof MultiSegmentRepresentation) {
                                MultiSegmentRepresentation multiSegmentRepresentation = (MultiSegmentRepresentation) representation;
                                for (int a = multiSegmentRepresentation.a(); a < multiSegmentRepresentation.b(); a++) {
                                    if (adaptationSet.b == 0) {
                                        hashMap.put(multiSegmentRepresentation.c(a).b(), Integer.valueOf(multiSegmentRepresentation.c.c));
                                    } else {
                                        hashMap2.put(multiSegmentRepresentation.c(a).b(), Integer.valueOf(multiSegmentRepresentation.c.c));
                                    }
                                }
                            } else if (adaptationSet.b == 0) {
                                hashMap.put(representation.e().b(), Integer.valueOf(representation.c.c));
                            } else {
                                hashMap2.put(representation.e().b(), Integer.valueOf(representation.c.c));
                            }
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e2) {
                        BLog.b(f5182a, e2, "Exception parsing DASH manifest", new Object[0]);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = byteArrayInputStream;
                    try {
                        BLog.b(f5182a, e2, "Exception parsing DASH manifest", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22) {
                                BLog.b(f5182a, e22, "Exception parsing DASH manifest", new Object[0]);
                            }
                        }
                        ((VideoPerformanceTracking) this.f5185d.get()).a(str2, hashMap, hashMap2);
                    } catch (Throwable th) {
                        e22 = th;
                        byteArrayInputStream = inputStream;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable e4) {
                                BLog.b(f5182a, e4, "Exception parsing DASH manifest", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw e22;
                }
            } catch (Exception e5) {
                e22 = e5;
                BLog.b(f5182a, e22, "Exception parsing DASH manifest", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
                ((VideoPerformanceTracking) this.f5185d.get()).a(str2, hashMap, hashMap2);
            } catch (Throwable th3) {
                e22 = th3;
                byteArrayInputStream = null;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw e22;
            }
            ((VideoPerformanceTracking) this.f5185d.get()).a(str2, hashMap, hashMap2);
        }
    }
}
