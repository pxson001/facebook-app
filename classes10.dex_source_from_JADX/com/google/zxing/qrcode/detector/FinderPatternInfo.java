package com.google.zxing.qrcode.detector;

/* compiled from: event_discovery_open_filter_surface */
public final class FinderPatternInfo {
    private final FinderPattern f13573a;
    private final FinderPattern f13574b;
    private final FinderPattern f13575c;

    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.f13573a = finderPatternArr[0];
        this.f13574b = finderPatternArr[1];
        this.f13575c = finderPatternArr[2];
    }

    public final FinderPattern m13806a() {
        return this.f13573a;
    }

    public final FinderPattern m13807b() {
        return this.f13574b;
    }

    public final FinderPattern m13808c() {
        return this.f13575c;
    }
}
