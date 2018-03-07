package com.facebook.facecast.plugin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.facecastdisplay.FacecastUiUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderTopLeftRadius */
public class FacecastEndTimerView extends CustomLinearLayout {
    @Inject
    public GatekeeperStoreImpl f18396a;
    private final long f18397b;
    private final long f18398c;
    private final FbTextView f18399d;
    public final ObjectAnimator f18400e;
    @Nullable
    private FacecastEndTimerViewListener f18401f;
    private boolean f18402g;
    private long f18403h;

    /* compiled from: borderTopLeftRadius */
    public interface FacecastEndTimerViewListener {
        void mo1421a(boolean z);

        void hC_();
    }

    private static <T extends View> void m22072a(Class<T> cls, T t) {
        m22073a((Object) t, t.getContext());
    }

    private static void m22073a(Object obj, Context context) {
        ((FacecastEndTimerView) obj).f18396a = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public FacecastEndTimerView(Context context) {
        this(context, null);
    }

    public FacecastEndTimerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastEndTimerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18397b = 7000;
        this.f18398c = 200;
        m22072a(FacecastEndTimerView.class, (View) this);
        this.f18402g = this.f18396a.a(VideoAbTestGatekeepers.f, false);
        setOrientation(0);
        if (this.f18402g) {
            setContentView(2130904233);
        } else {
            setContentView(2130904216);
            setBackgroundResource(2130839606);
        }
        this.f18399d = (FbTextView) a(2131561678);
        this.f18400e = FacecastUiUtil.m3098a(this.f18399d);
    }

    public final void m22077a(long j, FacecastEndTimerViewListener facecastEndTimerViewListener) {
        this.f18403h = j;
        this.f18401f = facecastEndTimerViewListener;
    }

    public ObjectAnimator getLiveAnimator() {
        return this.f18400e;
    }

    public final void m22076a(long j) {
        long j2 = (this.f18403h * 1000) - j;
        String a = FacecastUiUtil.m3100a(Math.max(j2, 0));
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(getResources().getString(2131238246));
        m22074a(a, styledStringBuilder);
        this.f18399d.setText(styledStringBuilder.b());
        m22075b(j2);
        if (j2 < -7000 && this.f18401f != null) {
            this.f18401f.hC_();
        }
    }

    private void setTimerVisibity(int i) {
        if (!(getVisibility() == i || this.f18401f == null)) {
            this.f18401f.mo1421a(i == 0);
        }
        setVisibility(i);
    }

    private void m22074a(String str, StyledStringBuilder styledStringBuilder) {
        CharSequence spannableString = new SpannableString(str);
        if (!this.f18402g) {
            for (Object span : ImmutableList.of(new StyleSpan(1), new ForegroundColorSpan(getResources().getColor(2131361920)))) {
                spannableString.setSpan(span, 0, str.length(), 33);
            }
        }
        styledStringBuilder.a("%1$s", spannableString);
    }

    private void m22075b(long j) {
        int i = 1;
        if (j < m22071a(5, 0) && j > m22071a(4, 55)) {
            setTimerVisibity(0);
        } else if (j <= m22071a(4, 0) && j >= m22071a(3, 55)) {
            setTimerVisibity(0);
        } else if (j <= m22071a(3, 0) && j >= m22071a(2, 55)) {
            setTimerVisibity(0);
        } else if (j <= m22071a(2, 0) && j >= m22071a(1, 55)) {
            setTimerVisibity(0);
        } else if (j <= m22071a(1, 0) && j >= m22071a(0, 55)) {
            setTimerVisibity(0);
        } else if (j <= m22071a(0, 10) && j >= m22071a(0, 1)) {
            setTimerVisibity(0);
        } else if (j <= m22071a(0, 1)) {
            setTimerVisibity(0);
            if (!this.f18402g) {
                if (((j - 1000) / 1000) % 2 != 0) {
                    i = 0;
                }
                if (i != 0 && this.f18399d.getAlpha() == 1.0f) {
                    this.f18399d.animate().setDuration(200).alpha(0.0f);
                } else if (i == 0 && this.f18399d.getAlpha() == 0.0f) {
                    this.f18399d.animate().setDuration(200).alpha(1.0f);
                }
            }
        } else {
            setTimerVisibity(8);
        }
    }

    private static long m22071a(int i, int i2) {
        return (((long) i) * 60000) + (((long) i2) * 1000);
    }
}
