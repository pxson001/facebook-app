package com.facebook.video.creativeediting.utilities;

/* compiled from: doodle_colors */
public class TrimmedVideoLengthChecker {
    private final int f15652a;
    private final int f15653b;

    public TrimmedVideoLengthChecker(int i, int i2) {
        this.f15652a = i;
        this.f15653b = i2;
    }

    public final boolean m19607a(int i) {
        if (this.f15652a > 0 && i < this.f15652a) {
            return false;
        }
        if (this.f15653b <= 0 || i <= this.f15653b) {
            return true;
        }
        return false;
    }
}
