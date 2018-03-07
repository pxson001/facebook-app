package com.facebook.video.subtitles.controller.compat;

import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.SubtitleText;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.controller.SubtitlesEntry;
import com.facebook.video.subtitles.controller.SubtitlesEntry.TimeCompareResult;
import java.util.Arrays;

/* compiled from: pending_story */
public class CustomSubtitleAdapter {
    public SubtitleListener f5193a;
    public Subtitles f5194b;
    public final FbHandlerThreadFactory f5195c;
    public boolean f5196d = false;
    public HandlerThread f5197e;
    public Handler f5198f;
    private int f5199g = 0;
    public SubtitleMediaTimeProvider f5200h;
    private boolean f5201i = false;
    private boolean f5202j = false;

    public CustomSubtitleAdapter(FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f5195c = fbHandlerThreadFactory;
    }

    public final void m5642a(SubtitleListener subtitleListener) {
        this.f5193a = subtitleListener;
    }

    public final boolean m5644a(Subtitles subtitles) {
        this.f5194b = subtitles;
        if (subtitles != null && this.f5202j) {
            this.f5202j = false;
            m5640f();
        }
        return true;
    }

    public final void m5643a(SubtitleMediaTimeProvider subtitleMediaTimeProvider) {
        this.f5200h = subtitleMediaTimeProvider;
    }

    public final void m5645b() {
        if (this.f5194b == null) {
            this.f5202j = true;
        } else {
            m5640f();
        }
    }

    public final void m5646c() {
        this.f5201i = true;
    }

    public final void m5647d() {
        if (this.f5196d) {
            this.f5197e.quit();
            this.f5196d = false;
        }
        this.f5199g = 0;
        this.f5202j = false;
    }

    public final void m5641a(int i) {
        this.f5199g = m5639d(i);
    }

    private void m5640f() {
        if (this.f5196d) {
            m5647d();
        }
        if (this.f5194b != null) {
            if (!(this.f5201i || this.f5200h == null)) {
                this.f5199g = 0;
            }
            this.f5201i = false;
            if (!this.f5196d) {
                this.f5197e = this.f5195c.a("background_video_subtitle_thread", ThreadPriority.BACKGROUND);
                this.f5197e.start();
                this.f5198f = new SubtitleThreadHandler(this.f5197e.getLooper(), this);
                this.f5196d = true;
            }
            this.f5198f.sendMessageDelayed(this.f5198f.obtainMessage(322420958), 0);
        }
    }

    public final void m5648e() {
        if (this.f5194b != null && !this.f5194b.b() && this.f5199g < this.f5194b.a() && this.f5199g >= 0) {
            TimeCompareResult timeCompareResult;
            SubtitlesEntry a = this.f5194b.a(this.f5199g);
            int a2 = this.f5200h.mo384a();
            if (a2 + 10 < a.a) {
                timeCompareResult = TimeCompareResult.EARLY;
            } else if (a2 > a.b + 10) {
                timeCompareResult = TimeCompareResult.LATE;
            } else {
                timeCompareResult = TimeCompareResult.IN_RANGE;
            }
            TimeCompareResult timeCompareResult2 = timeCompareResult;
            if (timeCompareResult2 == TimeCompareResult.IN_RANGE) {
                this.f5193a.mo482a(new SubtitleText(null, a.c, (long) (a.b - a.a)));
                this.f5199g++;
                m5637b(a2);
            } else if (timeCompareResult2 != TimeCompareResult.EARLY) {
                this.f5199g = m5638c(a2);
                if (this.f5199g >= 0) {
                    m5637b(a2);
                }
            } else if (!this.f5201i) {
                m5637b(a2);
            }
        }
    }

    private void m5637b(int i) {
        if (this.f5199g >= 0 && this.f5194b != null && this.f5199g < this.f5194b.a()) {
            long j = (long) (this.f5194b.a(this.f5199g).a - i);
            if (j > 0) {
                this.f5198f.sendMessageDelayed(this.f5198f.obtainMessage(322420958), j);
            }
        }
    }

    private int m5638c(int i) {
        if (this.f5199g < 0) {
            return m5639d(i);
        }
        for (int i2 = this.f5199g; i2 < this.f5194b.a(); i2++) {
            if (this.f5194b.a(i2).a >= i) {
                return i2;
            }
        }
        return -1;
    }

    private int m5639d(int i) {
        if (this.f5194b == null) {
            return -1;
        }
        int binarySearch = Arrays.binarySearch(this.f5194b.a, new SubtitlesEntry(i, i, ""));
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 1);
        }
        if (binarySearch >= this.f5194b.a()) {
            return -1;
        }
        if (this.f5194b.a(binarySearch).a < i) {
            binarySearch++;
        }
        if (binarySearch >= this.f5194b.a()) {
            return -1;
        }
        return binarySearch;
    }
}
