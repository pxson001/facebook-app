package com.facebook.messaging.montage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.support.v7.graphics.Palette.Swatch;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageThumbnailController.Listener;
import com.facebook.user.model.UserKey;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: iso-2022-jp-2 */
public class MontageTileView extends CustomFrameLayout implements Listener {
    @Inject
    public MontageThumbnailControllerProvider f12425a;
    private final FbDraweeView f12426b;
    private final MontageThumbnailController f12427c;
    private final Paint f12428d;
    @ColorInt
    private int f12429e;
    private float f12430f;
    private float f12431g;
    private int f12432h;

    /* compiled from: iso-2022-jp-2 */
    class C13743 implements PaletteAsyncListener {
        final /* synthetic */ MontageTileView f12424a;

        C13743(MontageTileView montageTileView) {
            this.f12424a = montageTileView;
        }

        public final void mo467a(Palette palette) {
            this.f12424a.m12900a(palette);
        }
    }

    private static <T extends View> void m12903a(Class<T> cls, T t) {
        m12904a((Object) t, t.getContext());
    }

    private static void m12904a(Object obj, Context context) {
        ((MontageTileView) obj).f12425a = (MontageThumbnailControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(MontageThumbnailControllerProvider.class);
    }

    public MontageTileView(Context context) {
        this(context, null, 0);
    }

    public MontageTileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MontageTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12903a(MontageTileView.class, (View) this);
        setContentView(2130905342);
        this.f12426b = (FbDraweeView) c(2131563979);
        this.f12427c = this.f12425a.m12896a(this.f12426b);
        this.f12427c.f12415m = this;
        this.f12428d = new Paint(5);
        this.f12428d.setStrokeWidth((float) getResources().getDimensionPixelSize(2131433690));
        this.f12432h = getResources().getDimensionPixelSize(2131433691);
        setUnreadIndicatorColor(ContextCompat.b(getContext(), 2131362241));
        setBackgroundDrawable(new ColorDrawable(Color.argb(255, 220, 220, 220)));
    }

    public final void m12907a(final ThreadSummary threadSummary, final MessagesCollection messagesCollection) {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ MontageTileView f12421c;

                public boolean onPreDraw() {
                    this.f12421c.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.f12421c.m12907a(threadSummary, messagesCollection);
                    return true;
                }
            });
            return;
        }
        Message message;
        m12899a(width, height);
        MontageThumbnailController montageThumbnailController = this.f12427c;
        montageThumbnailController.f12417o = montageThumbnailController.f12409g.m12868b(messagesCollection, threadSummary.l);
        if (montageThumbnailController.f12417o) {
            ImmutableList a = montageThumbnailController.f12409g.m12864a(messagesCollection, threadSummary.l);
            message = (Message) a.get(a.size() - 1);
        } else {
            message = (Message) montageThumbnailController.f12409g.m12863a(messagesCollection).get(0);
        }
        montageThumbnailController.f12418p = ((UserKey) montageThumbnailController.f12413k.get()).equals(message.e.b);
        montageThumbnailController.m12895a(message);
    }

    public void setMessage(final Message message) {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ MontageTileView f12423b;

                public boolean onPreDraw() {
                    this.f12423b.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.f12423b.setMessage(message);
                    return true;
                }
            });
            return;
        }
        m12899a(width, height);
        this.f12427c.m12895a(message);
    }

    public final void mo468a() {
        setBackgroundDrawable(null);
        this.f12426b.setPadding(0, 0, 0, 0);
    }

    public final void mo469b() {
        setBackgroundDrawable(null);
        this.f12426b.setPadding(0, 0, 0, 0);
    }

    public final void mo470c() {
        setBackgroundDrawable(null);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433664);
        this.f12426b.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public final void mo471d() {
        m12905g();
    }

    public final void mo472e() {
        setBackgroundDrawable(new ColorDrawable(-16776961));
    }

    public final void mo473f() {
        setBackgroundDrawable(new ColorDrawable(-65536));
    }

    protected void dispatchDraw(Canvas canvas) {
        Object obj;
        super.dispatchDraw(canvas);
        MontageThumbnailController montageThumbnailController = this.f12427c;
        if (!montageThumbnailController.f12417o || montageThumbnailController.f12418p) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            float width = ((float) (canvas.getWidth() / 2)) + this.f12430f;
            float height = ((float) (canvas.getHeight() / 2)) + this.f12431g;
            this.f12428d.setStyle(Style.STROKE);
            this.f12428d.setColor(-1);
            canvas.drawCircle(width, height, (float) this.f12432h, this.f12428d);
            this.f12428d.setStyle(Style.FILL);
            this.f12428d.setColor(this.f12429e);
            canvas.drawCircle(width, height, ((float) this.f12432h) - (this.f12428d.getStrokeWidth() / 2.0f), this.f12428d);
        }
    }

    public void setUnreadIndicatorColor(@ColorInt int i) {
        this.f12429e = i;
        invalidate();
    }

    private void m12899a(int i, int i2) {
        int min = Math.min(i, i2);
        this.f12427c.f12416n = min;
        min /= 2;
        this.f12430f = (float) (((double) min) * Math.cos(Math.toRadians(-45.0d)));
        this.f12431g = (float) (((double) min) * Math.sin(Math.toRadians(-45.0d)));
    }

    private void m12905g() {
        Bitmap a = m12898a(this.f12426b.getTopLevelDrawable());
        if (a != null) {
            Palette.m3459a(a).m3451a(new C13743(this));
        } else {
            setBackgroundDrawable(new ColorDrawable(-1));
        }
    }

    @Nullable
    private Bitmap m12898a(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (drawable2 instanceof ForwardingDrawable) {
            drawable2 = drawable2.getCurrent();
        }
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        if (drawable2 instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable2;
            int a = arrayDrawable.a();
            for (int i = 0; i < a; i++) {
                Bitmap a2 = m12898a(arrayDrawable.a(i));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    private void m12900a(Palette palette) {
        Swatch swatch;
        Swatch c = palette.m3463c();
        if (c == null) {
            c = palette.m3462b();
        }
        if (c == null) {
            c = palette.m3464d();
        }
        if (c == null) {
            swatch = c;
            int i = 0;
            for (Swatch swatch2 : palette.m3461a()) {
                int i2;
                if (swatch2.f3729e > i) {
                    c = swatch2;
                    i2 = swatch2.f3729e;
                } else {
                    i2 = i;
                    c = swatch;
                }
                swatch = c;
                i = i2;
            }
        } else {
            swatch = c;
        }
        if (swatch != null) {
            setBackgroundDrawable(new ColorDrawable(swatch.f3728d));
        }
    }

    private void m12901a(MontageThumbnailControllerProvider montageThumbnailControllerProvider) {
        this.f12425a = montageThumbnailControllerProvider;
    }
}
