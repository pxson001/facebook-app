package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.media.MediaItem;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: server_draft */
public class PickerLongPressProgressBar extends View {
    private static final SpringConfig f3311a = SpringConfig.a(30.0d, 8.0d);
    public SpringSystem f3312b;
    private Spring f3313c;
    private Paint f3314d;
    @Nullable
    public MediaItem f3315e;

    /* compiled from: server_draft */
    class ProgressBarSpringListener extends SimpleSpringListener {
        final /* synthetic */ PickerLongPressProgressBar f3310a;

        public ProgressBarSpringListener(PickerLongPressProgressBar pickerLongPressProgressBar) {
            this.f3310a = pickerLongPressProgressBar;
        }

        public final void m3256a(Spring spring) {
            this.f3310a.invalidate();
        }
    }

    private static <T extends View> void m3258a(Class<T> cls, T t) {
        m3259a((Object) t, t.getContext());
    }

    private static void m3259a(Object obj, Context context) {
        ((PickerLongPressProgressBar) obj).f3312b = SpringSystem.b(FbInjector.get(context));
    }

    public PickerLongPressProgressBar(Context context) {
        super(context);
        m3260b();
    }

    public PickerLongPressProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3260b();
    }

    private void m3260b() {
        m3258a(PickerLongPressProgressBar.class, (View) this);
        this.f3314d = new Paint();
        this.f3314d.setColor(getResources().getColor(2131362907));
        this.f3314d.setStyle(Style.FILL);
        Spring a = this.f3312b.a().a(f3311a).a(0.0d);
        a.c = true;
        this.f3313c = a.l();
        this.f3313c.a(new ProgressBarSpringListener(this));
    }

    @Inject
    private void m3257a(SpringSystem springSystem) {
        this.f3312b = springSystem;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = (float) this.f3313c.d();
        if (d > 0.0f) {
            float width = ((1.0f - d) * ((float) getWidth())) / 2.0f;
            canvas.drawRect(width, 0.0f, ((float) getWidth()) - width, (float) getHeight(), this.f3314d);
        }
    }

    public final boolean m3263a(@Nonnull MediaItem mediaItem) {
        if (this.f3315e != null && this.f3315e != mediaItem) {
            return false;
        }
        this.f3315e = mediaItem;
        this.f3313c.b(1.0d);
        return true;
    }

    public final boolean m3264b(@Nonnull MediaItem mediaItem) {
        if (this.f3315e != mediaItem) {
            return false;
        }
        this.f3315e = null;
        this.f3313c.b(0.0d);
        return true;
    }

    @Nullable
    public MediaItem getMediaItem() {
        return this.f3315e;
    }

    public final boolean m3262a() {
        return this.f3313c.d() == 1.0d;
    }

    public final void m3261a(SpringListener springListener) {
        this.f3313c.a(springListener);
    }
}
