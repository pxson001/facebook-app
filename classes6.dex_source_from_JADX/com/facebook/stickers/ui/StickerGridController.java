package com.facebook.stickers.ui;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.messaging.media.preview.MediaPreviewDialogManager;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.ui.ClickEventDebouncer.OnItemClickListenerWrapper;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_privacy_fragment_option_fetch_error */
public class StickerGridController {
    public final boolean f17050a;
    public final MediaPreviewDialogManager f17051b;
    public GridView f17052c;
    public StickerInterface f17053d;
    public Listener f17054e;
    public float f17055f;
    public float f17056g;
    public StickerView f17057h;
    public Sticker f17058i;

    /* compiled from: edit_privacy_fragment_option_fetch_error */
    public interface Listener {
        void mo1271a(Sticker sticker);
    }

    /* compiled from: edit_privacy_fragment_option_fetch_error */
    class C12301 implements OnTouchListener {
        final /* synthetic */ StickerGridController f17047a;

        C12301(StickerGridController stickerGridController) {
            this.f17047a = stickerGridController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f17047a.f17055f = motionEvent.getX();
            this.f17047a.f17056g = motionEvent.getY();
            if (motionEvent.getAction() == 0) {
                this.f17047a.f17057h = StickerGridController.m24755b(this.f17047a, this.f17047a.f17055f, this.f17047a.f17056g);
                if (this.f17047a.f17057h != null) {
                    this.f17047a.f17057h.m24778c();
                }
            } else if (this.f17047a.f17057h != null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
                    this.f17047a.f17057h.m24779d();
                    this.f17047a.f17057h = null;
                } else {
                    StickerView b = StickerGridController.m24755b(this.f17047a, this.f17047a.f17055f, this.f17047a.f17056g);
                    if (!(b == null || this.f17047a.f17057h == b)) {
                        this.f17047a.f17057h.m24779d();
                        this.f17047a.f17057h = b;
                        this.f17047a.f17057h.m24778c();
                    }
                }
            }
            if (!this.f17047a.f17050a || this.f17047a.f17053d == StickerInterface.COMPOSER) {
                this.f17047a.f17051b.m19029a();
                return false;
            } else if (!this.f17047a.f17051b.m19031b()) {
                return false;
            } else {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
                    this.f17047a.f17051b.m19029a();
                    this.f17047a.f17052c.requestDisallowInterceptTouchEvent(false);
                    return true;
                } else if (this.f17047a.f17055f < 0.0f || this.f17047a.f17056g < 0.0f || this.f17047a.f17055f > ((float) this.f17047a.f17052c.getWidth()) || this.f17047a.f17056g > ((float) this.f17047a.f17052c.getHeight())) {
                    return true;
                } else {
                    StickerGridController.m24756b(this.f17047a, StickerGridController.m24754a(this.f17047a, this.f17047a.f17055f, this.f17047a.f17056g));
                    return true;
                }
            }
        }
    }

    /* compiled from: edit_privacy_fragment_option_fetch_error */
    class C12312 implements OnItemLongClickListener {
        final /* synthetic */ StickerGridController f17048a;

        C12312(StickerGridController stickerGridController) {
            this.f17048a = stickerGridController;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            Sticker a = StickerGridController.m24754a(this.f17048a, this.f17048a.f17055f, this.f17048a.f17056g);
            if (this.f17048a.f17050a) {
                StickerGridController.m24756b(this.f17048a, a);
                this.f17048a.f17052c.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
    }

    /* compiled from: edit_privacy_fragment_option_fetch_error */
    class C12323 implements OnItemClickListener {
        final /* synthetic */ StickerGridController f17049a;

        C12323(StickerGridController stickerGridController) {
            this.f17049a = stickerGridController;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f17049a.f17054e != null) {
                this.f17049a.f17054e.mo1271a((Sticker) this.f17049a.f17052c.getAdapter().getItem(i));
            }
        }
    }

    @Inject
    public StickerGridController(Boolean bool, @ForStickerPreview MediaPreviewDialogManager mediaPreviewDialogManager, ClickEventDebouncer clickEventDebouncer, @Assisted GridView gridView, @Assisted StickerInterface stickerInterface) {
        this.f17050a = bool.booleanValue();
        this.f17051b = mediaPreviewDialogManager;
        this.f17053d = stickerInterface;
        this.f17052c = gridView;
        this.f17052c.setOnTouchListener(new C12301(this));
        this.f17052c.setOnItemLongClickListener(new C12312(this));
        this.f17052c.setOnItemClickListener(new OnItemClickListenerWrapper(clickEventDebouncer, new C12323(this)));
    }

    @Nullable
    public static Sticker m24754a(StickerGridController stickerGridController, float f, float f2) {
        int c = stickerGridController.m24757c(f, f2);
        return c != -1 ? (Sticker) stickerGridController.f17052c.getAdapter().getItem(c + stickerGridController.f17052c.getFirstVisiblePosition()) : null;
    }

    @Nullable
    public static StickerView m24755b(StickerGridController stickerGridController, float f, float f2) {
        int c = stickerGridController.m24757c(f, f2);
        return c != -1 ? (StickerView) stickerGridController.f17052c.getChildAt(c) : null;
    }

    private int m24757c(float f, float f2) {
        for (int i = 0; i < this.f17052c.getChildCount(); i++) {
            StickerView stickerView = (StickerView) this.f17052c.getChildAt(i);
            stickerView.getHitRect(new Rect());
            if (stickerView.m24777a(f, f2)) {
                return i;
            }
        }
        return -1;
    }

    public static void m24756b(StickerGridController stickerGridController, Sticker sticker) {
        if (sticker != null) {
            Object obj;
            if (stickerGridController.f17058i == null || !Objects.equal(stickerGridController.f17058i.f4938a, sticker.f4938a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                stickerGridController.f17058i = sticker;
                MediaPreviewDialogManager mediaPreviewDialogManager = stickerGridController.f17051b;
                Context context = stickerGridController.f17052c.getContext();
                Uri uri = sticker.f4940c;
                if (sticker.f4943f != null) {
                    uri = sticker.f4943f;
                } else if (sticker.f4942e != null) {
                    uri = sticker.f4942e;
                } else if (sticker.f4941d != null) {
                    uri = sticker.f4941d;
                }
                ImageRequestBuilder a = ImageRequestBuilder.a(uri);
                ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
                newBuilder.b = -1;
                a.e = newBuilder.h();
                mediaPreviewDialogManager.m19030a(context, a.m());
            }
        }
    }
}
