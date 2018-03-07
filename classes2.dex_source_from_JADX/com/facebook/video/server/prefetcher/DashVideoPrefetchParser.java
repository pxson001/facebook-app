package com.facebook.video.server.prefetcher;

import android.net.Uri;
import android.os.Handler;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.qe.schema.Locators;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoResourceMetadata.VideoResourceType;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.dash.DashSegmentIndex;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescriptionParser;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.dash.mpd.Representation;
import com.google.common.base.Strings;
import java.io.ByteArrayInputStream;
import java.util.List;

/* compiled from: is_indexed = 1 */
public class DashVideoPrefetchParser {
    private static final String f19126a = DashVideoPrefetchParser.class.getSimpleName();
    private final Handler f19127b;
    public final VideoDashConfig f19128c;
    private final DeviceConditionHelper f19129d;

    public DashVideoPrefetchParser(Handler handler, VideoDashConfig videoDashConfig, DeviceConditionHelper deviceConditionHelper) {
        this.f19127b = handler;
        this.f19128c = videoDashConfig;
        this.f19129d = deviceConditionHelper;
    }

    private VideoResourceMetadata m26860a(Uri uri, VideoResourceMetadata videoResourceMetadata, int i, long j) {
        VideoResourceMetadata videoResourceMetadata2 = new VideoResourceMetadata(uri, videoResourceMetadata.a);
        videoResourceMetadata2.g = VideoResourceType.DASH;
        if (this.f19128c.f6880g > 0) {
            videoResourceMetadata2.e = (long) i;
            videoResourceMetadata2.f = j;
            videoResourceMetadata2.d = Locators.dm;
        } else {
            videoResourceMetadata2.e = videoResourceMetadata.e;
            videoResourceMetadata2.d = videoResourceMetadata.d;
            videoResourceMetadata2.f = videoResourceMetadata.f;
        }
        videoResourceMetadata2.h = videoResourceMetadata.h;
        return videoResourceMetadata2;
    }

    private int m26859a(Format format) {
        return this.f19128c.f6865J ? Math.max(format.d, format.e) : format.d;
    }

    public static void m26862b(DashVideoPrefetchParser dashVideoPrefetchParser, String str, VideoPrefetchList videoPrefetchList, VideoResourceMetadata videoResourceMetadata) {
        MediaPresentationDescriptionParser mediaPresentationDescriptionParser = new MediaPresentationDescriptionParser();
        try {
            MediaPresentationDescription a = mediaPresentationDescriptionParser.a("", new ByteArrayInputStream(str.getBytes("UTF-8")));
            if (!a.i.isEmpty()) {
                List list = a.i;
                if (!((Period) list.get(0)).d.isEmpty()) {
                    AdaptationSet adaptationSet = null;
                    AdaptationSet adaptationSet2 = null;
                    for (AdaptationSet adaptationSet3 : ((Period) list.get(0)).d) {
                        List list2 = adaptationSet3.c;
                        if (adaptationSet2 == null && !list2.isEmpty() && ((Representation) list2.get(0)).c.b.startsWith("video/")) {
                            adaptationSet2 = adaptationSet3;
                        } else if (adaptationSet != null || list2.isEmpty() || !((Representation) list2.get(0)).c.b.startsWith("audio/")) {
                            if (!(adaptationSet == null || adaptationSet2 == null)) {
                                break;
                            }
                        } else {
                            adaptationSet = adaptationSet3;
                        }
                    }
                    if (adaptationSet2 != null) {
                        dashVideoPrefetchParser.m26861a(videoPrefetchList, videoResourceMetadata, adaptationSet2);
                    }
                    if (adaptationSet != null) {
                        dashVideoPrefetchParser.m26861a(videoPrefetchList, videoResourceMetadata, adaptationSet);
                    }
                }
            }
        } catch (Throwable e) {
            BLog.a(f19126a, "Exception is thrown", e);
        }
    }

    private void m26861a(VideoPrefetchList videoPrefetchList, VideoResourceMetadata videoResourceMetadata, AdaptationSet adaptationSet) {
        Representation representation;
        Representation representation2;
        List<Representation> list = adaptationSet.c;
        Representation representation3 = null;
        if (this.f19128c.m11516d()) {
            int a = this.f19128c.m11511a(this.f19129d, videoResourceMetadata.f());
            if (a <= 0) {
                for (Representation representation4 : list) {
                    if (!representation4.c.a.endsWith("vd")) {
                        if (representation4.c.a.endsWith("ad")) {
                            break;
                        }
                    }
                    break;
                }
                representation4 = null;
            } else {
                for (Representation representation42 : list) {
                    if (m26859a(representation42.c) > a || (representation3 != null && m26859a(representation42.c) <= m26859a(representation3.c))) {
                        representation42 = representation3;
                    }
                    representation3 = representation42;
                }
                representation42 = representation3;
            }
        } else {
            representation42 = null;
        }
        if (representation42 != null || list.isEmpty()) {
            representation2 = representation42;
        } else {
            representation2 = (Representation) list.get(0);
        }
        if (representation2 != null) {
            Integer.valueOf(representation2.c.d);
            RangedUri d = representation2.d();
            if (BLog.b(3)) {
                d.b();
            }
            DashSegmentIndex f = representation2.f();
            VideoResourceMetadata a2;
            if (f != null) {
                m26860a(d.a(), videoResourceMetadata, 0, 0).i = representation2.g();
                videoPrefetchList.mo2178b(a2);
                int a3 = f.a();
                RangedUri c = f.c(a3);
                if (BLog.b(3)) {
                    c.b();
                }
                m26860a(c.a(), videoResourceMetadata, representation2.c.c, 1000 * f.b(a3)).i = representation2.g();
                videoPrefetchList.mo2178b(a2);
            } else if (this.f19128c.f6864I) {
                a2 = m26860a(d.a(), videoResourceMetadata, representation2.c.c, representation2.e);
                a2.i = representation2.g();
                videoPrefetchList.mo2178b(a2);
                Long.valueOf(a2.c());
                Long.valueOf(a2.d());
                a2.a();
            }
        }
    }

    public final void m26863a(String str, VideoPrefetchList videoPrefetchList, VideoResourceMetadata videoResourceMetadata) {
        if (!Strings.isNullOrEmpty(str) && this.f19128c.f6877d) {
            HandlerDetour.a(this.f19127b, new 1(this, str, videoPrefetchList, videoResourceMetadata), 998930660);
        }
    }
}
