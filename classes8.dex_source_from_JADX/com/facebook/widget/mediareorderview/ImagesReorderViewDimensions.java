package com.facebook.widget.mediareorderview;

import com.facebook.springs.SpringUtil;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: location_opt_in_google_play_location_status_check_dialog_is_possible */
public class ImagesReorderViewDimensions {
    public final int f9873a;
    public final int f9874b;
    public final int f9875c;
    public final int f9876d;
    public final int f9877e;
    public final int f9878f;
    public final int f9879g;
    public final int f9880h;
    public final int f9881i;

    public ImagesReorderViewDimensions(int i, int i2, int i3, int i4, int i5, int i6, List<Float> list) {
        int size = (i3 + i4) + ((list.size() - 1) * i5);
        this.f9873a = i;
        this.f9874b = i2;
        this.f9877e = i5;
        this.f9878f = m11590a(list, size);
        size = m11591b(list, size);
        if (size < this.f9874b) {
            this.f9875c = (((this.f9874b - size) + 1) / 2) + i3;
            this.f9876d = ((this.f9874b - size) / 2) + i4;
            this.f9879g = this.f9874b;
        } else {
            this.f9875c = i3;
            this.f9876d = i4;
            this.f9879g = size;
        }
        this.f9880h = m11589a();
        this.f9881i = m11592c(list, i6);
    }

    private int m11590a(List<Float> list, int i) {
        int i2 = (int) (((double) this.f9873a) * 0.4d);
        int i3 = (int) (((double) this.f9873a) * 0.75d);
        if (i >= this.f9874b) {
            return i2;
        }
        double d = 0.0d;
        for (int i4 = 0; i4 < list.size(); i4++) {
            d += (double) (1.0f / ((Float) list.get(i4)).floatValue());
        }
        return (int) SpringUtil.a(((double) (this.f9874b - i)) / d, (double) i2, (double) i3);
    }

    private int m11591b(List<Float> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            i = (int) ((((float) this.f9878f) / ((Float) list.get(i2)).floatValue()) + ((float) i));
        }
        return i;
    }

    private int m11589a() {
        return this.f9879g - this.f9874b;
    }

    private int m11592c(List<Float> list, int i) {
        int i2 = this.f9875c;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int floatValue = ((int) (((float) this.f9878f) / ((Float) list.get(i3)).floatValue())) + this.f9877e;
            if (i == i3) {
                if (this.f9874b > floatValue) {
                    i2 -= (this.f9874b - floatValue) / 2;
                }
                return Math.min(Math.max(i2, 0), this.f9880h);
            }
            i2 += floatValue;
        }
        return Math.min(Math.max(i2, 0), this.f9880h);
    }
}
