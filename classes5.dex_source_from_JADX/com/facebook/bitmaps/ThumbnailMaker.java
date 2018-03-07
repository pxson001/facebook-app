package com.facebook.bitmaps;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.logging.BitmapSequences;
import com.facebook.bitmaps.logging.BitmapSequences.GenerateThumbnailMethod;
import com.facebook.bitmaps.logging.BitmapSequences.ThumbnailMakerSequence;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.Random;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: android.support.isGroupSummary */
public class ThumbnailMaker {
    private ContentResolver f10385a;
    private final Resources f10386b;
    private final ImageResizer f10387c;
    private final AndroidMediaThumbnails f10388d;
    private final SequenceLogger f10389e;
    private final MonotonicClock f10390f;
    private final Random f10391g;
    private final Lazy<BitmapUtils> f10392h;
    private Sequence<ThumbnailMakerSequence> f10393i;

    public static ThumbnailMaker m18488b(InjectorLike injectorLike) {
        return new ThumbnailMaker((Context) injectorLike.getInstance(Context.class), ImageResizerMethodAutoProvider.m18454b(injectorLike), new AndroidMediaThumbnails(), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 406));
    }

    @Inject
    public ThumbnailMaker(Context context, ImageResizer imageResizer, AndroidMediaThumbnails androidMediaThumbnails, SequenceLogger sequenceLogger, MonotonicClock monotonicClock, Random random, Lazy<BitmapUtils> lazy) {
        this.f10385a = context.getContentResolver();
        this.f10386b = context.getResources();
        this.f10387c = imageResizer;
        this.f10388d = androidMediaThumbnails;
        this.f10389e = sequenceLogger;
        this.f10390f = monotonicClock;
        this.f10391g = random;
        this.f10392h = lazy;
    }

    @Nullable
    public final Bitmap m18489a(MediaItem mediaItem, BitmapResizingParam bitmapResizingParam) {
        Bitmap thumbnail;
        Bitmap bitmap;
        if (this.f10391g.nextDouble() < 0.05d) {
            this.f10393i = this.f10389e.a(BitmapSequences.f10403a, mediaItem.m23455e(), ImmutableMap.of("MediaType", mediaItem.m23462l().toString(), "ThumbnailWidth", Integer.toString(bitmapResizingParam.f10356b), "ThumbnailHeight", Integer.toString(bitmapResizingParam.f10357c)), this.f10390f.now());
        }
        if (this.f10393i == null) {
            this.f10393i = BitmapSequences.f10404b;
        }
        try {
            switch (mediaItem.m23462l()) {
                case PHOTO:
                    if (bitmapResizingParam.f10358d && mediaItem.m23464n() > 0) {
                        SequenceLoggerDetour.a(this.f10393i, "GetThumbnail", 1341019127);
                        thumbnail = Thumbnails.getThumbnail(this.f10385a, mediaItem.m23453c(), 3, null);
                        if (!(thumbnail == null || mediaItem.m23457g() == 0)) {
                            this.f10392h.get();
                            thumbnail = BitmapUtils.a(thumbnail, mediaItem.m23457g(), true);
                        }
                        SequenceLoggerDetour.b(this.f10393i, "GetThumbnail", null, ImmutableBiMap.b("GenerateThumbnailMethod", GenerateThumbnailMethod.MEDIASTORE_IMAGE.toString()), 124011476);
                        bitmap = thumbnail;
                        break;
                    }
                    bitmap = m18487a(mediaItem.m23455e(), bitmapResizingParam);
                    break;
                default:
                    Options options = new Options();
                    options.inDither = true;
                    options.inSampleSize = 2;
                    options.inScaled = true;
                    SequenceLoggerDetour.a(this.f10393i, "GetThumbnail", 1722165982);
                    try {
                        thumbnail = AndroidMediaThumbnails.m18439a(this.f10385a, mediaItem.m23453c(), 1, false, options);
                        if (thumbnail == null) {
                            try {
                                thumbnail = ThumbnailUtils.createVideoThumbnail(mediaItem.m23455e(), 1);
                            } catch (OutOfMemoryError e) {
                                break;
                            }
                        }
                    } catch (IllegalStateException e2) {
                        thumbnail = ThumbnailUtils.createVideoThumbnail(mediaItem.m23455e(), 1);
                    } catch (OutOfMemoryError e3) {
                        thumbnail = ThumbnailUtils.createVideoThumbnail(mediaItem.m23455e(), 1);
                        break;
                    } catch (Throwable th) {
                    }
                    SequenceLoggerDetour.b(this.f10393i, "GetThumbnail", null, ImmutableBiMap.b("GenerateThumbnailMethod", GenerateThumbnailMethod.VIDEO.toString()), 981789055);
                    if (thumbnail == null) {
                        SequenceLoggerDetour.e(this.f10393i, "ReturnDefaultDrawable", 1984385582);
                        if (MediaUtils.f11099a.containsValue(mediaItem.m23459i())) {
                            thumbnail = FbBitmapFactory.a(this.f10386b, 2130838389);
                        }
                    }
                    bitmap = thumbnail;
                    break;
            }
        } catch (OutOfMemoryError e4) {
            thumbnail = null;
        }
        SequenceLoggerDetour.e(this.f10393i, "HasOutOfMemoryError", 2025978712);
        bitmap = thumbnail;
        this.f10389e.b(BitmapSequences.f10403a, mediaItem.m23455e(), null, this.f10390f.now());
        return bitmap;
    }

    @Nullable
    private Bitmap m18487a(String str, BitmapResizingParam bitmapResizingParam) {
        Bitmap bitmap = null;
        try {
            bitmap = this.f10387c.mo1116a(str, bitmapResizingParam);
        } catch (ImageResizingException e) {
        } catch (OutOfMemoryError e2) {
        }
        return bitmap;
    }
}
