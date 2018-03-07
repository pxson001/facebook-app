package com.facebook.messaging.quickcam;

import android.graphics.RectF;
import com.facebook.common.quickcam.QuickCamVideoUtil;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: deltaPaymentEnable */
public class VideoParams {
    public final int f16597a;
    public final int f16598b;
    public final int f16599c;
    public final Source f16600d;
    public final boolean f16601e;
    public final RectF f16602f;
    public final String f16603g;

    /* compiled from: deltaPaymentEnable */
    public class Builder {
        public int f16592a;
        public int f16593b;
        public int f16594c;
        public Source f16595d;
        public boolean f16596e;

        public final Builder m16618a(int i, int i2) {
            this.f16592a = i;
            this.f16593b = i2;
            return this;
        }

        public final Builder m16617a(int i) {
            boolean z = true;
            if (!(i == 0 || i == 1 || i == 2 || i == 3)) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f16594c = i;
            return this;
        }

        public final Builder m16619a(Source source) {
            boolean z = source == Source.QUICKCAM_FRONT || source == Source.QUICKCAM_BACK;
            Preconditions.checkArgument(z);
            this.f16595d = source;
            return this;
        }

        public final VideoParams m16620a() {
            return new VideoParams(this);
        }
    }

    public VideoParams(Builder builder) {
        String str;
        this.f16597a = builder.f16592a;
        this.f16598b = builder.f16593b;
        this.f16599c = builder.f16594c;
        this.f16600d = builder.f16595d;
        this.f16601e = builder.f16596e;
        this.f16602f = m16621a(builder.f16592a, builder.f16593b, builder.f16594c, builder.f16596e);
        switch (builder.f16594c) {
            case 0:
            case 2:
                str = "landscape";
                break;
            case 1:
            case 3:
                str = "portrait";
                break;
            default:
                str = "unknown";
                break;
        }
        this.f16603g = str;
    }

    private static RectF m16621a(int i, int i2, int i3, boolean z) {
        if (z) {
            return QuickCamVideoUtil.f6108a;
        }
        if (i3 == 1 || i3 == 3) {
            int i4 = i;
            i = i2;
            i2 = i4;
        }
        float f = (0.75f * ((float) i)) / ((float) i2);
        return new RectF(0.0f, 0.5f - (f / 2.0f), 1.0f, (f / 2.0f) + 0.5f);
    }
}
