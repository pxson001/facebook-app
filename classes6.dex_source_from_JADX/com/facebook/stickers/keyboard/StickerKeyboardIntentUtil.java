package com.facebook.stickers.keyboard;

import android.content.Context;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import javax.inject.Inject;

/* compiled from: edits */
public class StickerKeyboardIntentUtil {
    public final Context f16630a;
    public final SecureContextHelper f16631b;
    public final StickerKeyboardLogger f16632c;
    private final MonotonicClock f16633d;
    public final SequenceLogger f16634e;

    public static StickerKeyboardIntentUtil m24475a(InjectorLike injectorLike) {
        return new StickerKeyboardIntentUtil((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), StickerKeyboardLogger.m24477b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public StickerKeyboardIntentUtil(Context context, SecureContextHelper secureContextHelper, StickerKeyboardLogger stickerKeyboardLogger, MonotonicClock monotonicClock, SequenceLogger sequenceLogger) {
        this.f16630a = context;
        this.f16631b = secureContextHelper;
        this.f16632c = stickerKeyboardLogger;
        this.f16633d = monotonicClock;
        this.f16634e = sequenceLogger;
    }
}
