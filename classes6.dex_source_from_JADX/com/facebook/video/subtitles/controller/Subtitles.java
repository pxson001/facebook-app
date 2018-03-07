package com.facebook.video.subtitles.controller;

import java.util.Arrays;

/* compiled from: com.google.android.gms.maps.internal.IProjectionDelegate */
public class Subtitles {
    public SubtitlesEntry[] f19662a;

    public Subtitles() {
        this.f19662a = new SubtitlesEntry[0];
    }

    public Subtitles(SubtitlesEntry[] subtitlesEntryArr) {
        if (subtitlesEntryArr == null) {
            this.f19662a = new SubtitlesEntry[0];
            return;
        }
        this.f19662a = subtitlesEntryArr;
        Arrays.sort(this.f19662a);
    }

    public Subtitles(Subtitles subtitles) {
        int a = subtitles.m28381a();
        this.f19662a = new SubtitlesEntry[a];
        for (int i = 0; i < a; i++) {
            this.f19662a[i] = new SubtitlesEntry(subtitles.m28382a(i));
        }
    }

    public final int m28381a() {
        return this.f19662a.length;
    }

    public final boolean m28383b() {
        return this.f19662a.length == 0;
    }

    public final SubtitlesEntry m28382a(int i) {
        return this.f19662a[i];
    }
}
