package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ipc.media.MediaItem;
import com.facebook.widget.CustomFrameLayout;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: setColorFilter not implemented */
public abstract class PickerGridItemView extends CustomFrameLayout implements SelectableView {
    private static final AtomicInteger f3249a = new AtomicInteger(0);
    protected final View f3250b;
    protected final ImageView f3251c;
    protected final ColorDrawable f3252d;
    protected final Animation f3253e;
    protected Drawable f3254f;
    @Nullable
    public MediaItem f3255g;
    private final int f3256h;
    private ImageView f3257i;
    private TextView f3258j;
    public int f3259k;
    private int f3260l;
    private boolean f3261m;

    protected abstract void mo166a();

    protected abstract void mo167b();

    public abstract boolean mo168g();

    public abstract void hP_();

    public PickerGridItemView(Context context) {
        this(context, null);
    }

    private PickerGridItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3256h = f3249a.getAndIncrement();
        setContentView(getLayoutResourceId());
        this.f3250b = c(2131559119);
        this.f3251c = (ImageView) c(2131558448);
        this.f3252d = new ColorDrawable(getResources().getColor(2131362909));
        this.f3253e = AnimationUtils.loadAnimation(getContext(), 17432576);
        this.f3261m = true;
        mo167b();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public int getId() {
        return this.f3256h;
    }

    public int getIndex() {
        return this.f3259k;
    }

    public final void m3220i() {
        this.f3255g = null;
        m3213j();
    }

    public void setMediaItemWithFailedDecoding(MediaItem mediaItem) {
        this.f3255g = mediaItem;
        m3213j();
    }

    @Nullable
    public MediaItem getMediaItem() {
        return this.f3255g;
    }

    public int getSelectedOrder() {
        return this.f3260l;
    }

    public final void mo154a(int i, boolean z) {
        if (this.f3257i == null) {
            this.f3257i = (ImageView) ((ViewStub) c(2131565955)).inflate();
        }
        this.f3257i.setBackgroundResource(z ? 2130843324 : 2130843392);
        this.f3257i.setVisibility(0);
        this.f3260l = i;
        if (z) {
            if (this.f3258j == null) {
                this.f3258j = (TextView) ((ViewStub) c(2131565956)).inflate();
            } else {
                this.f3258j.setVisibility(0);
            }
            this.f3258j.setText(String.valueOf(i));
        }
    }

    public final void mo155e() {
        if (this.f3257i != null) {
            this.f3257i.setVisibility(4);
        }
        if (this.f3258j != null) {
            this.f3258j.setVisibility(4);
        }
        this.f3260l = 0;
    }

    public boolean isSelected() {
        return this.f3260l > 0;
    }

    public final boolean mo156f() {
        return this.f3255g != null && mo168g() && this.f3261m;
    }

    public void setViewEnabled(boolean z) {
        this.f3261m = z;
        setAlpha(this.f3261m ? 1.0f : 0.2f);
    }

    private void m3213j() {
        hP_();
        mo166a();
        if (this.f3254f == null) {
            this.f3254f = getResources().getDrawable(2130838291);
        }
        this.f3251c.setImageDrawable(this.f3254f);
    }
}
