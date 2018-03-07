package com.facebook.react.views.scroll;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: background_noise */
public class ReactScrollViewCommandHelper {

    /* compiled from: background_noise */
    public interface ScrollCommandHandler<T> {
        void mo770a(T t, ScrollToCommandData scrollToCommandData);
    }

    /* compiled from: background_noise */
    public class ScrollToCommandData {
        public final int f19091a;
        public final int f19092b;
        public final boolean f19093c;

        ScrollToCommandData(int i, int i2, boolean z) {
            this.f19091a = i;
            this.f19092b = i2;
            this.f19093c = z;
        }
    }

    public static Map<String, Integer> m19057a() {
        return MapBuilder.a("scrollTo", Integer.valueOf(1));
    }

    public static <T> void m19058a(ScrollCommandHandler<T> scrollCommandHandler, T t, int i, @Nullable ReadableArray readableArray) {
        Assertions.b(scrollCommandHandler);
        Assertions.b(t);
        Assertions.b(readableArray);
        switch (i) {
            case 1:
                scrollCommandHandler.mo770a(t, new ScrollToCommandData(Math.round(PixelUtil.a(readableArray.getDouble(0))), Math.round(PixelUtil.a(readableArray.getDouble(1))), readableArray.getBoolean(2)));
                return;
            default:
                throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), scrollCommandHandler.getClass().getSimpleName()}));
        }
    }
}
