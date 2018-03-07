package com.facebook.video.subtitles.controller;

/* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback */
public class SubtitlesEntry implements Comparable<SubtitlesEntry> {
    public final int f19663a;
    public final int f19664b;
    public final String f19665c;

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback */
    public enum TimeCompareResult {
        EARLY,
        IN_RANGE,
        LATE
    }

    public int compareTo(Object obj) {
        SubtitlesEntry subtitlesEntry = (SubtitlesEntry) obj;
        int i = this.f19663a - subtitlesEntry.f19663a;
        if (i != 0) {
            return i;
        }
        i = this.f19664b - subtitlesEntry.f19664b;
        return i == 0 ? this.f19665c.compareTo(subtitlesEntry.f19665c) : i;
    }

    public SubtitlesEntry(int i, int i2, String str) {
        this.f19663a = i;
        this.f19664b = i2;
        this.f19665c = str;
    }

    public SubtitlesEntry(SubtitlesEntry subtitlesEntry) {
        this(subtitlesEntry.f19663a, subtitlesEntry.f19664b, subtitlesEntry.f19665c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SubtitlesEntry)) {
            return false;
        }
        SubtitlesEntry subtitlesEntry = (SubtitlesEntry) obj;
        if (this.f19663a == subtitlesEntry.f19663a && this.f19664b == subtitlesEntry.f19664b && this.f19665c.equals(subtitlesEntry.f19665c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f19663a + 629) * 37) + this.f19664b) * 37) + this.f19665c.hashCode();
    }
}
