package android.support.v7.graphics;

import java.util.Arrays;

/* compiled from: share_attachment_count */
public final class ColorHistogram {
    public final int[] f3707a;
    public final int[] f3708b;
    public final int f3709c;

    public ColorHistogram(int[] iArr) {
        int length;
        Arrays.sort(iArr);
        int i = 1;
        if (iArr.length < 2) {
            length = iArr.length;
        } else {
            int i2 = iArr[0];
            length = 1;
            while (i < iArr.length) {
                if (iArr[i] != i2) {
                    i2 = iArr[i];
                    length++;
                }
                i++;
            }
        }
        this.f3709c = length;
        this.f3707a = new int[this.f3709c];
        this.f3708b = new int[this.f3709c];
        if (iArr.length != 0) {
            i = iArr[0];
            this.f3707a[0] = i;
            this.f3708b[0] = 1;
            if (iArr.length != 1) {
                int i3 = 0;
                length = i;
                for (i = 1; i < iArr.length; i++) {
                    if (iArr[i] == length) {
                        int[] iArr2 = this.f3708b;
                        iArr2[i3] = iArr2[i3] + 1;
                    } else {
                        length = iArr[i];
                        i3++;
                        this.f3707a[i3] = length;
                        this.f3708b[i3] = 1;
                    }
                }
            }
        }
    }
}
