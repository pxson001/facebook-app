package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.CameraDevice.CameraFacing;
import com.facebook.optic.CameraPreviewView;
import com.facebook.photos.base.media.SphericalMediaItemUtil;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.local.LocalMediaCursor;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03828;
import com.facebook.photos.simplepicker.abtest.SimplePickerExperimentsUtil;
import com.facebook.photos.simplepicker.autoplay.MediaPickerVideoAutoplayManager;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences.LaunchSequence;
import com.facebook.photos.simplepicker.view.GridItemViewOnTouchListenerProvider;
import com.facebook.photos.simplepicker.view.PickerGridGifItemDraweeView;
import com.facebook.photos.simplepicker.view.PickerGridItemDraweeView;
import com.facebook.photos.simplepicker.view.PickerGridLiveCameraItemDraweeView;
import com.facebook.photos.simplepicker.view.PickerGridPhotoItemDraweeView;
import com.facebook.photos.simplepicker.view.PickerGridVideoItemDraweeView;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.simplepicker.view.SelectableView;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Optional;
import com.google.common.collect.Queues;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: show_border */
public class DraweeSimplePickerGridViewCursorAdapter extends CursorAdapter {
    private static final String f2947j = DraweeSimplePickerGridViewCursorAdapter.class.getName();
    private static final CallerContext f2948k = CallerContext.a(DraweeSimplePickerGridViewCursorAdapter.class, "simple_picker");
    private final Photos360QEHelper f2949A;
    private final boolean f2950B;
    private final MediaPickerVideoAutoplayManager<PickerGridVideoItemDraweeView> f2951C;
    public Queue<MediaStoreQueryJob> f2952D;
    public Queue<MediaStoreQueryJob> f2953E;
    public AtomicBoolean f2954F;
    @Nullable
    private FramePackModel f2955G;
    @Nullable
    public C03828 f2956H;
    @Nullable
    private PickerGridLiveCameraItemDraweeView f2957I;
    private SupportedMediaType f2958J;
    public final LocalMediaCursorImp f2959l;
    public final CloseableReference f2960m = this.f2959l.a();
    private final C03817 f2961n;
    private final OnClickListener f2962o;
    private final PickerSelectionController f2963p;
    private final Optional<PickerLongPressProgressBar> f2964q;
    private final boolean f2965r;
    private final GridItemViewOnTouchListenerProvider f2966s;
    private final Sequence<LaunchSequence> f2967t;
    private final Lazy<FbErrorReporter> f2968u;
    public final int f2969v;
    private final ExecutorService f2970w;
    public final DefaultAndroidThreadUtil f2971x;
    private final FbDraweeControllerBuilder f2972y;
    private final QeAccessor f2973z;

    /* compiled from: show_border */
    class MediaStoreQueryJob {
        public long f2943a;
        public Cursor f2944b;
        public int f2945c;
        public PickerGridItemDraweeView f2946d;

        private MediaStoreQueryJob(long j, Cursor cursor, int i, PickerGridItemDraweeView pickerGridItemDraweeView) {
            this.f2943a = j;
            this.f2944b = cursor;
            this.f2945c = i;
            this.f2946d = pickerGridItemDraweeView;
        }

        private void m3023a(long j, Cursor cursor, int i, PickerGridItemDraweeView pickerGridItemDraweeView) {
            this.f2943a = j;
            this.f2944b = cursor;
            this.f2945c = i;
            this.f2946d = pickerGridItemDraweeView;
        }
    }

    @Inject
    public DraweeSimplePickerGridViewCursorAdapter(@Assisted Cursor cursor, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted final PickerSelectionController pickerSelectionController, @Assisted Optional<PickerLongPressProgressBar> optional, @Assisted boolean z, @Assisted boolean z2, @ForAppContext Context context, LocalMediaCursor localMediaCursor, GridItemViewOnTouchListenerProvider gridItemViewOnTouchListenerProvider, SequenceLogger sequenceLogger, Lazy<FbErrorReporter> lazy, SimplePickerGridViewUtil simplePickerGridViewUtil, ExecutorService executorService, AndroidThreadUtil androidThreadUtil, FbDraweeControllerBuilder fbDraweeControllerBuilder, MediaPickerVideoAutoplayManager mediaPickerVideoAutoplayManager, QeAccessor qeAccessor, Photos360QEHelper photos360QEHelper) {
        super(context, cursor, false);
        this.f2961n = bitmapRenderedCallback;
        this.f2963p = pickerSelectionController;
        this.f2964q = optional;
        this.f2965r = z;
        this.f2950B = z2;
        this.d = context;
        this.f2959l = localMediaCursor;
        this.f2966s = gridItemViewOnTouchListenerProvider;
        this.f2968u = lazy;
        this.f2969v = simplePickerGridViewUtil.m3144a() * 5;
        this.f2962o = new OnClickListener(this) {
            final /* synthetic */ DraweeSimplePickerGridViewCursorAdapter f2933b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1600796061);
                pickerSelectionController.m3134b((PickerGridItemDraweeView) view);
                Logger.a(2, EntryType.UI_INPUT_END, -1161651070, a);
            }
        };
        this.f2967t = sequenceLogger.e(SimplePickerSequences.f3186a);
        this.f2970w = executorService;
        this.f2971x = androidThreadUtil;
        if (this.f2967t != null) {
            SequenceLoggerDetour.b(this.f2967t, "LoadMediaItems", -1219481744);
            SequenceLoggerDetour.a(this.f2967t, "RenderThumbnails", 1675170505);
        }
        this.f2952D = Queues.a();
        this.f2953E = Queues.a();
        this.f2954F = new AtomicBoolean(false);
        this.f2972y = fbDraweeControllerBuilder;
        this.f2951C = mediaPickerVideoAutoplayManager;
        this.f2973z = qeAccessor;
        this.f2949A = photos360QEHelper;
    }

    public final View m3029a(Context context, Cursor cursor, ViewGroup viewGroup) {
        int position = cursor.getPosition();
        PickerGridItemType fromOrdinal = PickerGridItemType.fromOrdinal(getItemViewType(position));
        if (fromOrdinal == null) {
            BLog.c(f2947j, "Unknown item type");
            return new PickerGridPhotoItemDraweeView(context);
        }
        View pickerGridVideoItemDraweeView;
        switch (fromOrdinal) {
            case VIDEO:
                pickerGridVideoItemDraweeView = new PickerGridVideoItemDraweeView(context);
                break;
            case GIF:
                pickerGridVideoItemDraweeView = new PickerGridGifItemDraweeView(context);
                break;
            case LIVE_CAMERA:
                pickerGridVideoItemDraweeView = new PickerGridLiveCameraItemDraweeView(context);
                break;
            default:
                boolean z;
                pickerGridVideoItemDraweeView = new PickerGridPhotoItemDraweeView(context);
                PickerGridPhotoItemDraweeView pickerGridPhotoItemDraweeView = (PickerGridPhotoItemDraweeView) pickerGridVideoItemDraweeView;
                if (this.f2950B && this.f2949A.j()) {
                    z = true;
                } else {
                    z = false;
                }
                pickerGridPhotoItemDraweeView.f3246c = z;
                break;
        }
        cursor.moveToPosition(position);
        return pickerGridVideoItemDraweeView;
    }

    public int getItemViewType(int i) {
        if (this.c == null || this.c.isClosed()) {
            return -1;
        }
        try {
            if (!this.c.moveToPosition(i)) {
                String str = "Trying to access invalid index of position = %d, cursor length = %s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.c != null ? String.valueOf(this.c.getCount()) : "null";
                ((AbstractFbErrorReporter) this.f2968u.get()).a(f2947j, StringFormatUtil.a(str, objArr));
                return -1;
            } else if (this.c == null) {
                return -1;
            } else {
                if (this.c.getColumnIndex("camera_entry") != -1 && 1 == this.c.getInt(this.c.getColumnIndex("camera_entry"))) {
                    return PickerGridItemType.LIVE_CAMERA.ordinal();
                }
                if (this.c.getLong(1) == 3) {
                    return PickerGridItemType.VIDEO.ordinal();
                }
                String string = this.c.isNull(2) ? null : this.c.getString(2);
                if (string == null || !string.equals(MimeType.d.toString())) {
                    return PickerGridItemType.PHOTO.ordinal();
                }
                return PickerGridItemType.GIF.ordinal();
            }
        } catch (Exception e) {
            Exception exception = e;
            if ((exception instanceof CursorIndexOutOfBoundsException) || (exception instanceof IllegalStateException)) {
                ((AbstractFbErrorReporter) this.f2968u.get()).a(f2947j, exception.getClass().getSimpleName());
                return -1;
            }
            throw exception;
        }
    }

    public int getViewTypeCount() {
        return PickerGridItemType.values().length;
    }

    public final void m3033c() {
        this.f2960m.close();
    }

    public final void m3034d() {
        if (this.c != null) {
            this.c.close();
        }
    }

    public long getItemId(int i) {
        String str;
        Object[] objArr;
        int i2 = 3;
        try {
            return super.getItemId(i);
        } catch (Throwable e) {
            str = "Exception = %s, position = %d, cursor count = %s";
            objArr = new Object[i2];
            objArr[0] = e.getClass().getSimpleName();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = this.c != null ? String.valueOf(this.c.getCount()) : "null";
            ((AbstractFbErrorReporter) this.f2968u.get()).a(f2947j, StringFormatUtil.a(str, objArr), e);
            return 0;
        } catch (Throwable e2) {
            str = "Cursor Exception = %s, position = %d, cursor length = %s";
            objArr = new Object[i2];
            objArr[0] = e2.getClass().getSimpleName();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = this.c != null ? String.valueOf(this.c.getCount()) : "null";
            ((AbstractFbErrorReporter) this.f2968u.get()).b(f2947j, StringFormatUtil.a(str, objArr), e2);
            return 0;
        } catch (Throwable e22) {
            str = "Cursor Exception = %s, position = %d, cursor length = %s";
            objArr = new Object[i2];
            objArr[0] = e22.getClass().getSimpleName();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = this.c != null ? String.valueOf(this.c.getCount()) : "null";
            ((AbstractFbErrorReporter) this.f2968u.get()).b(f2947j, StringFormatUtil.a(str, objArr), e22);
            return 0;
        }
    }

    public final void m3031a(SupportedMediaType supportedMediaType, boolean z) {
        if (this.f2958J != supportedMediaType) {
            this.f2958J = supportedMediaType;
            if (z) {
                AdapterDetour.a(this, 1699485655);
            }
        }
    }

    public final void m3030a(View view, Cursor cursor) {
        PickerGridItemDraweeView pickerGridItemDraweeView = (PickerGridItemDraweeView) view;
        try {
            long j;
            if (cursor.getColumnIndex("camera_entry") == -1) {
                j = cursor.getLong(0);
            } else {
                j = -1;
            }
            int position = cursor.getPosition();
            PickerGridItemType fromOrdinal = PickerGridItemType.fromOrdinal(getItemViewType(position));
            ((PickerGridItemDraweeView) view).setViewEnabled(EnabledMediaTypeUtil.m3066a(this.f2958J, fromOrdinal));
            if (fromOrdinal == PickerGridItemType.LIVE_CAMERA) {
                m3026a((View) pickerGridItemDraweeView);
                return;
            }
            MediaItem a = this.f2959l.a(j);
            if (a != null) {
                m3028a(this, pickerGridItemDraweeView, a, cursor.getPosition());
            } else if (this.f2952D.isEmpty() && !this.f2954F.get()) {
                m3025a(j, cursor, position, pickerGridItemDraweeView);
            } else if (this.f2952D.size() >= 40) {
                r1 = (MediaStoreQueryJob) this.f2952D.remove();
                r1.m3023a(j, cursor, position, pickerGridItemDraweeView);
                this.f2952D.add(r1);
            } else if (this.f2953E.isEmpty()) {
                this.f2952D.add(new MediaStoreQueryJob(j, cursor, position, pickerGridItemDraweeView));
            } else {
                r1 = (MediaStoreQueryJob) this.f2953E.remove();
                r1.m3023a(j, cursor, position, pickerGridItemDraweeView);
                this.f2952D.add(r1);
            }
        } catch (Exception e) {
            Exception exception = e;
            if ((exception instanceof CursorIndexOutOfBoundsException) || (exception instanceof IllegalStateException)) {
                ((AbstractFbErrorReporter) this.f2968u.get()).a(f2947j, exception.getClass().getSimpleName());
                pickerGridItemDraweeView.setController(null);
                return;
            }
            throw exception;
        }
    }

    public final void m3032a(FramePackModel framePackModel) {
        this.f2955G = framePackModel;
        if (this.f2957I != null) {
            this.f2957I.setFramePack(this.f2955G);
            AdapterDetour.a(this, -1116609788);
        }
    }

    private synchronized void m3025a(long j, Cursor cursor, int i, PickerGridItemDraweeView pickerGridItemDraweeView) {
        this.f2954F.set(true);
        pickerGridItemDraweeView.setTag(2131558574, Integer.valueOf(i));
        if (this.f2960m.d() && getItemViewType(i) != PickerGridItemType.LIVE_CAMERA.ordinal()) {
            final long j2 = j;
            final Cursor cursor2 = cursor;
            final int i2 = i;
            final PickerGridItemDraweeView pickerGridItemDraweeView2 = pickerGridItemDraweeView;
            ExecutorDetour.a(this.f2970w, new Runnable(this) {
                final /* synthetic */ DraweeSimplePickerGridViewCursorAdapter f2940e;

                public void run() {
                    final MediaItem a = this.f2940e.f2959l.a(j2, cursor2, i2, this.f2940e.f2969v);
                    this.f2940e.f2971x.a(new Runnable(this) {
                        final /* synthetic */ C03862 f2935b;

                        public void run() {
                            if (!this.f2935b.f2940e.c.isClosed() && this.f2935b.f2940e.f2960m.d() && ((Integer) pickerGridItemDraweeView2.getTag(2131558574)).intValue() == i2) {
                                DraweeSimplePickerGridViewCursorAdapter.m3028a(this.f2935b.f2940e, pickerGridItemDraweeView2, a, i2);
                            }
                            this.f2935b.f2940e.f2954F.set(false);
                            if (!this.f2935b.f2940e.f2952D.isEmpty()) {
                                MediaStoreQueryJob mediaStoreQueryJob = (MediaStoreQueryJob) this.f2935b.f2940e.f2952D.remove();
                                this.f2935b.f2940e.m3025a(mediaStoreQueryJob.f2943a, mediaStoreQueryJob.f2944b, mediaStoreQueryJob.f2945c, mediaStoreQueryJob.f2946d);
                                this.f2935b.f2940e.f2953E.add(mediaStoreQueryJob);
                            }
                        }
                    });
                }
            }, -744966681);
        }
    }

    public static void m3028a(DraweeSimplePickerGridViewCursorAdapter draweeSimplePickerGridViewCursorAdapter, PickerGridItemDraweeView pickerGridItemDraweeView, MediaItem mediaItem, int i) {
        if (mediaItem == null || mediaItem.e() == null) {
            ((AbstractFbErrorReporter) draweeSimplePickerGridViewCursorAdapter.f2968u.get()).a(f2947j, mediaItem == null ? "mediaItem is null" : "mediaItem path is null");
            pickerGridItemDraweeView.setController(null);
            return;
        }
        PickerGridItemType fromOrdinal = PickerGridItemType.fromOrdinal(draweeSimplePickerGridViewCursorAdapter.getItemViewType(i));
        if (fromOrdinal == null) {
            ((AbstractFbErrorReporter) draweeSimplePickerGridViewCursorAdapter.f2968u.get()).a(f2947j, "unknown grid item type");
            pickerGridItemDraweeView.setController(null);
            return;
        }
        switch (fromOrdinal) {
            case VIDEO:
            case GIF:
            case PHOTO:
                pickerGridItemDraweeView.f3241g = i;
                pickerGridItemDraweeView.f3237b = mediaItem;
                Uri f = mediaItem.f();
                int dimensionPixelSize = draweeSimplePickerGridViewCursorAdapter.d.getResources().getDimensionPixelSize(2131429470);
                ImageRequestBuilder a = ImageRequestBuilder.a(f);
                a.c = true;
                a = a;
                a.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
                pickerGridItemDraweeView.m3204a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) draweeSimplePickerGridViewCursorAdapter.f2972y.a(f2948k).b(pickerGridItemDraweeView.getController())).c(a.m())).s(), draweeSimplePickerGridViewCursorAdapter.f2961n);
                if (fromOrdinal == PickerGridItemType.VIDEO && (pickerGridItemDraweeView instanceof PickerGridVideoItemDraweeView) && SimplePickerExperimentsUtil.m2990b(draweeSimplePickerGridViewCursorAdapter.f2973z)) {
                    draweeSimplePickerGridViewCursorAdapter.f2951C.m2993a((PickerGridVideoItemDraweeView) pickerGridItemDraweeView, new VideoViewController<PickerGridVideoItemDraweeView>(draweeSimplePickerGridViewCursorAdapter, mediaItem.e()) {
                        final /* synthetic */ DraweeSimplePickerGridViewCursorAdapter f2941a;

                        public final void m3021a(Object obj) {
                            PickerGridVideoItemDraweeView pickerGridVideoItemDraweeView = (PickerGridVideoItemDraweeView) obj;
                            pickerGridVideoItemDraweeView.hN_();
                            pickerGridVideoItemDraweeView.mo173a(Integer.MIN_VALUE);
                        }

                        public final void m3022b(Object obj) {
                            ((PickerGridVideoItemDraweeView) obj).mo175h();
                        }
                    });
                }
                pickerGridItemDraweeView.setOnClickListener(draweeSimplePickerGridViewCursorAdapter.f2962o);
                if (draweeSimplePickerGridViewCursorAdapter.f2964q.isPresent()) {
                    if (SphericalMediaItemUtil.a(mediaItem)) {
                        pickerGridItemDraweeView.setOnTouchListener(null);
                    } else {
                        pickerGridItemDraweeView.setOnTouchListener(draweeSimplePickerGridViewCursorAdapter.f2966s.m3197a(draweeSimplePickerGridViewCursorAdapter.f2963p, (PickerLongPressProgressBar) draweeSimplePickerGridViewCursorAdapter.f2964q.get(), pickerGridItemDraweeView));
                    }
                }
                draweeSimplePickerGridViewCursorAdapter.f2963p.m3131a((SelectableView) pickerGridItemDraweeView);
                return;
            default:
                ((AbstractFbErrorReporter) draweeSimplePickerGridViewCursorAdapter.f2968u.get()).a(f2947j, "unknown grid item type");
                return;
        }
    }

    private void m3026a(View view) {
        this.f2957I = (PickerGridLiveCameraItemDraweeView) view;
        this.f2957I.f3276h = this.f2956H;
        this.f2957I.setFramePack(this.f2955G);
        this.f2957I.setController(null);
        if (this.f2965r) {
            ((CameraPreviewView) FindViewUtil.b(this.f2957I, 2131560152)).p = CameraFacing.FRONT;
        }
    }
}
