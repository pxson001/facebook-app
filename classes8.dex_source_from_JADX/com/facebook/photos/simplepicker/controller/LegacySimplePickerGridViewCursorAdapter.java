package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.bitmaps.BitmapResizingParam;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.log.BLog;
import com.facebook.feed.autoplay.VideoViewController;
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
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03828;
import com.facebook.photos.simplepicker.abtest.SimplePickerExperimentsUtil;
import com.facebook.photos.simplepicker.autoplay.MediaPickerVideoAutoplayManager;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences.LaunchSequence;
import com.facebook.photos.simplepicker.view.GridItemViewOnTouchListenerProvider;
import com.facebook.photos.simplepicker.view.PickerGridGifItemView;
import com.facebook.photos.simplepicker.view.PickerGridItemView;
import com.facebook.photos.simplepicker.view.PickerGridLiveCameraItemView;
import com.facebook.photos.simplepicker.view.PickerGridPhotoItemView;
import com.facebook.photos.simplepicker.view.PickerGridVideoItemView;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.simplepicker.view.SelectableView;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: shared_link */
public class LegacySimplePickerGridViewCursorAdapter extends CursorAdapter {
    private static final String f3034j = LegacySimplePickerGridViewCursorAdapter.class.getName();
    private final int f3035A;
    private final Map<Integer, BitmapResizingParam> f3036B;
    private final MediaPickerVideoAutoplayManager<PickerGridVideoItemView> f3037C;
    public Queue<MediaStoreQueryJob> f3038D;
    public Queue<MediaStoreQueryJob> f3039E;
    public AtomicBoolean f3040F;
    @Nullable
    private FramePackModel f3041G;
    @Nullable
    public C03828 f3042H;
    @Nullable
    private PickerGridLiveCameraItemView f3043I;
    private final QeAccessor f3044J;
    private final Photos360QEHelper f3045K;
    private SupportedMediaType f3046L;
    private final ThumbnailSource f3047k;
    public final LocalMediaCursorImp f3048l;
    public final CloseableReference f3049m = this.f3048l.a();
    private final C03817 f3050n;
    private final OnClickListener f3051o;
    private final PickerSelectionController f3052p;
    private final Optional<PickerLongPressProgressBar> f3053q;
    private final boolean f3054r;
    private final boolean f3055s;
    private final GridItemViewOnTouchListenerProvider f3056t;
    private final Sequence<LaunchSequence> f3057u;
    private final Lazy<FbErrorReporter> f3058v;
    public final int f3059w;
    private final ExecutorService f3060x;
    public final DefaultAndroidThreadUtil f3061y;
    private final long f3062z;

    /* compiled from: shared_link */
    class MediaStoreQueryJob {
        public long f3030a;
        public Cursor f3031b;
        public int f3032c;
        public View f3033d;

        private MediaStoreQueryJob(long j, Cursor cursor, int i, View view) {
            this.f3030a = j;
            this.f3031b = cursor;
            this.f3032c = i;
            this.f3033d = view;
        }

        private void m3083a(long j, Cursor cursor, int i, View view) {
            this.f3030a = j;
            this.f3031b = cursor;
            this.f3032c = i;
            this.f3033d = view;
        }
    }

    @Inject
    public LegacySimplePickerGridViewCursorAdapter(@Assisted ThumbnailSource thumbnailSource, @Assisted Cursor cursor, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted final PickerSelectionController pickerSelectionController, @Assisted Optional<PickerLongPressProgressBar> optional, @Assisted boolean z, @Assisted boolean z2, @ForAppContext Context context, LocalMediaCursor localMediaCursor, GridItemViewOnTouchListenerProvider gridItemViewOnTouchListenerProvider, SequenceLogger sequenceLogger, Lazy<FbErrorReporter> lazy, SimplePickerGridViewUtil simplePickerGridViewUtil, ExecutorService executorService, AndroidThreadUtil androidThreadUtil, FbSharedPreferences fbSharedPreferences, MediaPickerVideoAutoplayManager mediaPickerVideoAutoplayManager, QeAccessor qeAccessor, Photos360QEHelper photos360QEHelper) {
        super(context, cursor, false);
        this.f3047k = thumbnailSource;
        this.f3050n = bitmapRenderedCallback;
        this.f3052p = pickerSelectionController;
        this.f3053q = optional;
        this.f3054r = z;
        this.f3055s = z2;
        this.d = context;
        this.f3048l = localMediaCursor;
        this.f3056t = gridItemViewOnTouchListenerProvider;
        this.f3058v = lazy;
        this.f3037C = mediaPickerVideoAutoplayManager;
        this.f3059w = simplePickerGridViewUtil.m3144a() * 5;
        this.f3051o = new OnClickListener(this) {
            final /* synthetic */ LegacySimplePickerGridViewCursorAdapter f3020b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 783247923);
                pickerSelectionController.m3134b((PickerGridItemView) view);
                Logger.a(2, EntryType.UI_INPUT_END, -1572708924, a);
            }
        };
        this.f3057u = sequenceLogger.e(SimplePickerSequences.f3186a);
        this.f3060x = executorService;
        this.f3061y = androidThreadUtil;
        if (this.f3057u != null) {
            SequenceLoggerDetour.b(this.f3057u, "LoadMediaItems", 59844317);
            SequenceLoggerDetour.a(this.f3057u, "RenderThumbnails", -1661946998);
        }
        this.f3036B = Maps.c();
        this.f3035A = this.d.getResources().getDimensionPixelSize(2131429470);
        this.f3062z = fbSharedPreferences.a(PhotosPrefKeys.b, -1);
        this.f3038D = Queues.a();
        this.f3039E = Queues.a();
        this.f3040F = new AtomicBoolean(false);
        this.f3044J = qeAccessor;
        this.f3045K = photos360QEHelper;
    }

    public final View m3090a(Context context, Cursor cursor, ViewGroup viewGroup) {
        int position = cursor.getPosition();
        PickerGridItemType fromOrdinal = PickerGridItemType.fromOrdinal(getItemViewType(position));
        if (fromOrdinal == null) {
            BLog.c(f3034j, "Unknown item type");
            return new PickerGridPhotoItemView(context);
        }
        View pickerGridVideoItemView;
        switch (fromOrdinal) {
            case VIDEO:
                pickerGridVideoItemView = new PickerGridVideoItemView(context);
                break;
            case GIF:
                pickerGridVideoItemView = new PickerGridGifItemView(context);
                break;
            case LIVE_CAMERA:
                pickerGridVideoItemView = new PickerGridLiveCameraItemView(context);
                break;
            default:
                boolean z;
                pickerGridVideoItemView = new PickerGridPhotoItemView(context);
                PickerGridPhotoItemView pickerGridPhotoItemView = (PickerGridPhotoItemView) pickerGridVideoItemView;
                if (this.f3055s && this.f3045K.j()) {
                    z = true;
                } else {
                    z = false;
                }
                pickerGridPhotoItemView.f3264i = z;
                break;
        }
        cursor.moveToPosition(position);
        return pickerGridVideoItemView;
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
                ((AbstractFbErrorReporter) this.f3058v.get()).a(f3034j, StringFormatUtil.a(str, objArr));
                return -1;
            } else if (this.c == null) {
                return -1;
            } else {
                if (this.c.getColumnIndex("camera_entry") != -1 && 1 == this.c.getInt(this.c.getColumnIndex("camera_entry"))) {
                    return PickerGridItemType.LIVE_CAMERA.ordinal();
                }
                if ((this.c.isNull(1) ? 0 : this.c.getLong(1)) == 3) {
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
            if ((exception instanceof CursorIndexOutOfBoundsException) || (exception instanceof IllegalStateException) || (exception instanceof NullPointerException)) {
                ((AbstractFbErrorReporter) this.f3058v.get()).a(f3034j, exception.getClass().getSimpleName());
                return -1;
            }
            throw exception;
        }
    }

    public int getViewTypeCount() {
        return PickerGridItemType.values().length;
    }

    public final void m3094c() {
        this.f3049m.close();
    }

    public final void m3095d() {
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
            ((AbstractFbErrorReporter) this.f3058v.get()).a(f3034j, StringFormatUtil.a(str, objArr), e);
            return 0;
        } catch (Throwable e2) {
            str = "Cursor Exception = %s, position = %d, cursor length = %s";
            objArr = new Object[i2];
            objArr[0] = e2.getClass().getSimpleName();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = this.c != null ? String.valueOf(this.c.getCount()) : "null";
            ((AbstractFbErrorReporter) this.f3058v.get()).b(f3034j, StringFormatUtil.a(str, objArr), e2);
            return 0;
        } catch (Throwable e22) {
            str = "Cursor Exception = %s, position = %d, cursor length = %s";
            objArr = new Object[i2];
            objArr[0] = e22.getClass().getSimpleName();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = this.c != null ? String.valueOf(this.c.getCount()) : "null";
            ((AbstractFbErrorReporter) this.f3058v.get()).b(f3034j, StringFormatUtil.a(str, objArr), e22);
            return 0;
        }
    }

    public final void m3092a(SupportedMediaType supportedMediaType, boolean z) {
        if (this.f3046L != supportedMediaType) {
            this.f3046L = supportedMediaType;
            if (z) {
                AdapterDetour.a(this, 315606028);
            }
        }
    }

    public final void m3091a(View view, Cursor cursor) {
        try {
            long j;
            if (cursor.getColumnIndex("camera_entry") == -1) {
                j = cursor.getLong(0);
            } else {
                j = -1;
            }
            int position = cursor.getPosition();
            PickerGridItemType fromOrdinal = PickerGridItemType.fromOrdinal(getItemViewType(position));
            ((PickerGridItemView) view).setViewEnabled(EnabledMediaTypeUtil.m3066a(this.f3046L, fromOrdinal));
            if (fromOrdinal == PickerGridItemType.LIVE_CAMERA) {
                m3087a(view);
                return;
            }
            MediaItem a = this.f3048l.a(j);
            if (a != null) {
                m3089a(this, view, a, cursor.getPosition());
            } else if (this.f3038D.isEmpty() && !this.f3040F.get()) {
                m3086a(j, cursor, position, view);
            } else if (this.f3038D.size() >= 40) {
                r1 = (MediaStoreQueryJob) this.f3038D.remove();
                r1.m3083a(j, cursor, position, view);
                this.f3038D.add(r1);
            } else if (this.f3039E.isEmpty()) {
                this.f3038D.add(new MediaStoreQueryJob(j, cursor, position, view));
            } else {
                r1 = (MediaStoreQueryJob) this.f3039E.remove();
                r1.m3083a(j, cursor, position, view);
                this.f3038D.add(r1);
            }
        } catch (Exception e) {
            Exception exception = e;
            if ((exception instanceof CursorIndexOutOfBoundsException) || (exception instanceof IllegalStateException)) {
                ((AbstractFbErrorReporter) this.f3058v.get()).a(f3034j, exception.getClass().getSimpleName());
                ((PickerGridItemView) view).m3220i();
                return;
            }
            throw exception;
        }
    }

    public final void m3093a(FramePackModel framePackModel) {
        this.f3041G = framePackModel;
        if (this.f3043I != null) {
            this.f3043I.setFramePack(this.f3041G);
            AdapterDetour.a(this, -1006526800);
        }
    }

    private synchronized void m3086a(long j, Cursor cursor, int i, View view) {
        this.f3040F.set(true);
        view.setTag(2131558574, Integer.valueOf(i));
        if (this.f3049m.d() && getItemViewType(i) != PickerGridItemType.LIVE_CAMERA.ordinal()) {
            final long j2 = j;
            final Cursor cursor2 = cursor;
            final int i2 = i;
            final View view2 = view;
            ExecutorDetour.a(this.f3060x, new Runnable(this) {
                final /* synthetic */ LegacySimplePickerGridViewCursorAdapter f3027e;

                public void run() {
                    final MediaItem a = this.f3027e.f3048l.a(j2, cursor2, i2, this.f3027e.f3059w);
                    this.f3027e.f3061y.a(new Runnable(this) {
                        final /* synthetic */ C03932 f3022b;

                        public void run() {
                            if (!this.f3022b.f3027e.c.isClosed() && this.f3022b.f3027e.f3049m.d() && ((Integer) view2.getTag(2131558574)).intValue() == i2) {
                                LegacySimplePickerGridViewCursorAdapter.m3089a(this.f3022b.f3027e, view2, a, i2);
                            }
                            this.f3022b.f3027e.f3040F.set(false);
                            if (!this.f3022b.f3027e.f3038D.isEmpty()) {
                                MediaStoreQueryJob mediaStoreQueryJob = (MediaStoreQueryJob) this.f3022b.f3027e.f3038D.remove();
                                this.f3022b.f3027e.m3086a(mediaStoreQueryJob.f3030a, mediaStoreQueryJob.f3031b, mediaStoreQueryJob.f3032c, mediaStoreQueryJob.f3033d);
                                this.f3022b.f3027e.f3039E.add(mediaStoreQueryJob);
                            }
                        }
                    });
                }
            }, 1499703634);
        }
    }

    public static void m3089a(LegacySimplePickerGridViewCursorAdapter legacySimplePickerGridViewCursorAdapter, View view, MediaItem mediaItem, int i) {
        if (mediaItem == null || mediaItem.e() == null) {
            ((AbstractFbErrorReporter) legacySimplePickerGridViewCursorAdapter.f3058v.get()).a(f3034j, mediaItem == null ? "mediaItem is null" : "mediaItem path is null");
            ((PickerGridItemView) view).m3220i();
            return;
        }
        PickerGridItemType fromOrdinal = PickerGridItemType.fromOrdinal(legacySimplePickerGridViewCursorAdapter.getItemViewType(i));
        if (fromOrdinal == null) {
            ((AbstractFbErrorReporter) legacySimplePickerGridViewCursorAdapter.f3058v.get()).a(f3034j, "unknown grid item type");
            ((PickerGridItemView) view).m3220i();
            return;
        }
        switch (fromOrdinal) {
            case VIDEO:
            case GIF:
            case PHOTO:
                SelectableView selectableView = (PickerGridPhotoItemView) view;
                selectableView.f3259k = i;
                ThumbnailSource thumbnailSource = legacySimplePickerGridViewCursorAdapter.f3047k;
                int id = selectableView.getId();
                BitmapResizingParam a = legacySimplePickerGridViewCursorAdapter.m3085a(mediaItem);
                boolean z = legacySimplePickerGridViewCursorAdapter.f3062z < 0 || mediaItem.j() < legacySimplePickerGridViewCursorAdapter.f3062z;
                Bitmap a2 = thumbnailSource.m3435a(mediaItem, id, a, z);
                selectableView.mo178a(mediaItem, a2);
                if (a2 != null) {
                    legacySimplePickerGridViewCursorAdapter.f3050n.m2977a(mediaItem, true);
                }
                if (fromOrdinal == PickerGridItemType.VIDEO && (selectableView instanceof PickerGridVideoItemView) && SimplePickerExperimentsUtil.m2990b(legacySimplePickerGridViewCursorAdapter.f3044J)) {
                    legacySimplePickerGridViewCursorAdapter.f3037C.m2993a((PickerGridVideoItemView) selectableView, new VideoViewController<PickerGridVideoItemView>(legacySimplePickerGridViewCursorAdapter, mediaItem.e()) {
                        final /* synthetic */ LegacySimplePickerGridViewCursorAdapter f3028a;

                        public final void m3081a(Object obj) {
                            PickerGridVideoItemView pickerGridVideoItemView = (PickerGridVideoItemView) obj;
                            pickerGridVideoItemView.hN_();
                            pickerGridVideoItemView.mo173a(Integer.MIN_VALUE);
                        }

                        public final void m3082b(Object obj) {
                            ((PickerGridVideoItemView) obj).mo175h();
                        }
                    });
                }
                view.setOnClickListener(legacySimplePickerGridViewCursorAdapter.f3051o);
                if (legacySimplePickerGridViewCursorAdapter.f3053q.isPresent()) {
                    if (SphericalMediaItemUtil.a(mediaItem)) {
                        view.setOnTouchListener(null);
                    } else {
                        view.setOnTouchListener(legacySimplePickerGridViewCursorAdapter.f3056t.m3197a(legacySimplePickerGridViewCursorAdapter.f3052p, (PickerLongPressProgressBar) legacySimplePickerGridViewCursorAdapter.f3053q.get(), selectableView));
                    }
                }
                legacySimplePickerGridViewCursorAdapter.f3052p.m3131a(selectableView);
                return;
            default:
                ((AbstractFbErrorReporter) legacySimplePickerGridViewCursorAdapter.f3058v.get()).a(f3034j, "unknown grid item type");
                return;
        }
    }

    private void m3087a(View view) {
        this.f3043I = (PickerGridLiveCameraItemView) view;
        this.f3043I.f3289m = this.f3042H;
        this.f3043I.setFramePack(this.f3041G);
        this.f3043I.mo178a(null, null);
        if (this.f3054r) {
            ((CameraPreviewView) FindViewUtil.b(this.f3043I, 2131560152)).p = CameraFacing.FRONT;
        }
    }

    private BitmapResizingParam m3085a(MediaItem mediaItem) {
        if (this.f3036B.containsKey(Integer.valueOf(mediaItem.g()))) {
            return (BitmapResizingParam) this.f3036B.get(Integer.valueOf(mediaItem.g()));
        }
        BitmapResizingParam bitmapResizingParam = new BitmapResizingParam(mediaItem.g(), this.f3035A, true);
        this.f3036B.put(Integer.valueOf(mediaItem.g()), bitmapResizingParam);
        return bitmapResizingParam;
    }
}
