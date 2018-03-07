package com.facebook.messaging.camerautil.gallery;

import android.net.Uri;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* compiled from: messenger_record_start */
public class ImageListUber implements IImageList {
    private static final Class<?> f9723a = ImageListUber.class;
    private final IImageList[] f9724b;
    private final PriorityQueue<MergeSlot> f9725c;
    private long[] f9726d;
    private int f9727e;
    private int[] f9728f;
    private int f9729g;

    /* compiled from: messenger_record_start */
    class AscendingComparator implements Comparator<MergeSlot> {
        public int compare(Object obj, Object obj2) {
            MergeSlot mergeSlot = (MergeSlot) obj;
            MergeSlot mergeSlot2 = (MergeSlot) obj2;
            if (mergeSlot.f9719b != mergeSlot2.f9719b) {
                return mergeSlot.f9719b < mergeSlot2.f9719b ? -1 : 1;
            } else {
                return mergeSlot.f9718a - mergeSlot2.f9718a;
            }
        }
    }

    /* compiled from: messenger_record_start */
    class DescendingComparator implements Comparator<MergeSlot> {
        public int compare(Object obj, Object obj2) {
            MergeSlot mergeSlot = (MergeSlot) obj;
            MergeSlot mergeSlot2 = (MergeSlot) obj2;
            if (mergeSlot.f9719b != mergeSlot2.f9719b) {
                return mergeSlot.f9719b < mergeSlot2.f9719b ? 1 : -1;
            } else {
                return mergeSlot.f9718a - mergeSlot2.f9718a;
            }
        }
    }

    /* compiled from: messenger_record_start */
    class MergeSlot {
        int f9718a;
        long f9719b;
        IImage f9720c;
        private int f9721d = -1;
        private final IImageList f9722e;

        public MergeSlot(IImageList iImageList, int i) {
            this.f9722e = iImageList;
            this.f9718a = i;
        }

        public final boolean m10305a() {
            if (this.f9721d >= this.f9722e.mo388b() - 1) {
                return false;
            }
            IImageList iImageList = this.f9722e;
            int i = this.f9721d + 1;
            this.f9721d = i;
            this.f9720c = iImageList.mo385a(i);
            this.f9719b = this.f9720c.mo391b();
            return true;
        }
    }

    public ImageListUber(IImageList[] iImageListArr, int i) {
        Comparator ascendingComparator;
        this.f9724b = (IImageList[]) iImageListArr.clone();
        if (i == 1) {
            ascendingComparator = new AscendingComparator();
        } else {
            ascendingComparator = new DescendingComparator();
        }
        this.f9725c = new PriorityQueue(4, ascendingComparator);
        this.f9726d = new long[16];
        this.f9727e = 0;
        this.f9728f = new int[this.f9724b.length];
        this.f9729g = -1;
        this.f9725c.clear();
        int length = this.f9724b.length;
        for (int i2 = 0; i2 < length; i2++) {
            MergeSlot mergeSlot = new MergeSlot(this.f9724b[i2], i2);
            if (mergeSlot.m10305a()) {
                this.f9725c.add(mergeSlot);
            }
        }
    }

    public final int mo388b() {
        int i = 0;
        IImageList[] iImageListArr = this.f9724b;
        int i2 = 0;
        while (i < iImageListArr.length) {
            i2 += iImageListArr[i].mo388b();
            i++;
        }
        return i2;
    }

    public final IImage mo385a(int i) {
        int i2 = 0;
        if (i < 0 || i > mo388b()) {
            throw new IndexOutOfBoundsException("index " + i + " out of range max is " + mo388b());
        }
        MergeSlot c;
        Arrays.fill(this.f9728f, 0);
        int i3 = this.f9727e;
        int i4 = 0;
        while (i4 < i3) {
            long j = this.f9726d[i4];
            int i5 = (int) (-1 & j);
            int i6 = (int) (j >> 32);
            if (i2 + i5 > i) {
                return this.f9724b[i6].mo385a((i - i2) + this.f9728f[i6]);
            }
            int i7 = i2 + i5;
            int[] iArr = this.f9728f;
            iArr[i6] = iArr[i6] + i5;
            i4++;
            i2 = i7;
        }
        while (true) {
            c = m10306c();
            if (c == null) {
                return null;
            }
            if (i2 == i) {
                break;
            }
            if (c.m10305a()) {
                this.f9725c.add(c);
            }
            i2++;
        }
        IImage iImage = c.f9720c;
        if (!c.m10305a()) {
            return iImage;
        }
        this.f9725c.add(c);
        return iImage;
    }

    private MergeSlot m10306c() {
        MergeSlot mergeSlot = (MergeSlot) this.f9725c.poll();
        if (mergeSlot == null) {
            return null;
        }
        if (mergeSlot.f9718a == this.f9729g) {
            int i = this.f9727e - 1;
            long[] jArr = this.f9726d;
            jArr[i] = jArr[i] + 1;
            return mergeSlot;
        }
        this.f9729g = mergeSlot.f9718a;
        if (this.f9726d.length == this.f9727e) {
            Object obj = new long[(this.f9727e * 2)];
            System.arraycopy(this.f9726d, 0, obj, 0, this.f9727e);
            this.f9726d = obj;
        }
        long[] jArr2 = this.f9726d;
        int i2 = this.f9727e;
        this.f9727e = i2 + 1;
        jArr2[i2] = (((long) this.f9729g) << 32) | 1;
        return mergeSlot;
    }

    public final IImage mo386a(Uri uri) {
        for (IImageList a : this.f9724b) {
            IImage a2 = a.mo386a(uri);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public final void mo387a() {
        for (IImageList a : this.f9724b) {
            a.mo387a();
        }
    }
}
