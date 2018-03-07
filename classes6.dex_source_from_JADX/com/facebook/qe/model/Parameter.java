package com.facebook.qe.model;

import com.facebook.qe.schema.LocatorUtils;

/* compiled from: simplePhotoUploadParams */
public class Parameter implements Comparable<Parameter> {
    private final String f4346a;
    private final String f4347b;
    private final int f4348c;
    private int f4349d;

    public int compareTo(Object obj) {
        return this.f4346a.compareTo(((Parameter) obj).f4346a);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Parameter) && ((Parameter) obj).f4346a.equals(this.f4346a);
    }

    public int hashCode() {
        return this.f4346a.hashCode();
    }

    public final String m6442a() {
        return this.f4347b;
    }

    public final int m6443b() {
        return this.f4348c;
    }

    public final int m6444c() {
        switch (this.f4348c) {
            case 100:
                return ((char) this.f4349d) >> 1;
            case 101:
                return LocatorUtils.b((short) this.f4349d);
            case 102:
                return this.f4349d >> 1;
            case 103:
                return LocatorUtils.b((long) this.f4349d);
            case 104:
                return LocatorUtils.b((float) this.f4349d);
            case 105:
                return LocatorUtils.b((double) this.f4349d);
            default:
                throw new IllegalStateException("Unrecognized type " + this.f4348c);
        }
    }
}
