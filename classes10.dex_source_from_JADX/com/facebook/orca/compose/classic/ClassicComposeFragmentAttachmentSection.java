package com.facebook.orca.compose.classic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.orca.compose.ComposeFragmentAttachmentSection;
import com.facebook.orca.compose.ComposeFragmentAttachmentSection.Listener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: openFileDescriptor not supported on live listener */
public class ClassicComposeFragmentAttachmentSection extends CustomLinearLayout implements ComposeFragmentAttachmentSection {
    private final LayoutInflater f5729a;
    private final Handler f5730b;
    private final int f5731c;
    public Listener f5732d;
    private boolean f5733e;
    private boolean f5734f;
    private boolean f5735g;
    private View f5736h;
    private View f5737i;

    /* compiled from: openFileDescriptor not supported on live listener */
    class C08253 implements OnClickListener {
        final /* synthetic */ ClassicComposeFragmentAttachmentSection f5727a;

        C08253(ClassicComposeFragmentAttachmentSection classicComposeFragmentAttachmentSection) {
            this.f5727a = classicComposeFragmentAttachmentSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -185629041);
            if (this.f5727a.f5732d == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1896792527, a);
                return;
            }
            this.f5727a.f5732d.mo232c();
            LogUtils.a(254079720, a);
        }
    }

    /* compiled from: openFileDescriptor not supported on live listener */
    /* synthetic */ class C08264 {
        static final /* synthetic */ int[] f5728a = new int[PickMediaSource.values().length];

        static {
            try {
                f5728a[PickMediaSource.GALLERY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5728a[PickMediaSource.CAMERA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ClassicComposeFragmentAttachmentSection(Context context) {
        this(context, null);
    }

    public ClassicComposeFragmentAttachmentSection(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5729a = LayoutInflaterMethodAutoProvider.b(getInjector());
        this.f5731c = SizeUtil.a(getContext().getResources(), 2.0f);
        this.f5730b = new Handler(Looper.getMainLooper());
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1253877047);
        super.onDetachedFromWindow();
        this.f5730b.removeCallbacksAndMessages(null);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1530995579, a);
    }

    public final void mo163a() {
        if (!this.f5734f) {
            this.f5734f = true;
            View a = m5405a(2131230973, 2130841931, 0, PickMediaSource.GALLERY);
            View e = m5407e();
            addView(a);
            addView(e);
        }
    }

    public final void mo164b() {
        if (!this.f5733e) {
            this.f5733e = true;
            View a = m5405a(2131230967, 2130841930, 0, PickMediaSource.CAMERA);
            View e = m5407e();
            addView(a);
            addView(e);
        }
    }

    public final void mo165c() {
        if (!this.f5735g) {
            this.f5735g = true;
            if (this.f5736h == null) {
                this.f5736h = m5404a(2131230978, 2130841932, 1);
                this.f5737i = m5407e();
                addView(this.f5736h);
                addView(this.f5737i);
                return;
            }
            this.f5736h.setVisibility(0);
            this.f5737i.setVisibility(0);
        }
    }

    public final void mo166d() {
        if (this.f5735g) {
            this.f5735g = false;
            this.f5736h.setVisibility(8);
            this.f5737i.setVisibility(8);
        }
    }

    public void setListener(Listener listener) {
        this.f5732d = listener;
    }

    private View m5404a(int i, int i2, int i3) {
        return m5405a(i, i2, i3, null);
    }

    private View m5405a(int i, final int i2, int i3, @Nullable final PickMediaSource pickMediaSource) {
        TracerDetour.a("generateAttachmentButton", 1830542811);
        try {
            View inflate = this.f5729a.inflate(2130905692, this, false);
            SimpleVariableTextLayoutView simpleVariableTextLayoutView = (SimpleVariableTextLayoutView) inflate.findViewById(2131564855);
            CharSequence string = getContext().getString(i);
            simpleVariableTextLayoutView.setText(string);
            simpleVariableTextLayoutView.setContentDescription(null);
            final ImageButton imageButton = (ImageButton) inflate.findViewById(2131564854);
            imageButton.setContentDescription(string);
            final Resources resources = getResources();
            HandlerDetour.b(this.f5730b, new Runnable(this) {
                final /* synthetic */ ClassicComposeFragmentAttachmentSection f5724d;

                public void run() {
                    imageButton.setImageDrawable(resources.getDrawable(i2));
                }
            }, 10, 1292219810);
            switch (i3) {
                case 0:
                    Preconditions.checkNotNull(pickMediaSource);
                    imageButton.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ ClassicComposeFragmentAttachmentSection f5726b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -1406470082);
                            if (this.f5726b.f5732d == null) {
                                Logger.a(2, EntryType.UI_INPUT_END, -778325560, a);
                                return;
                            }
                            switch (C08264.f5728a[pickMediaSource.ordinal()]) {
                                case 1:
                                    this.f5726b.f5732d.mo230a();
                                    break;
                                case 2:
                                    this.f5726b.f5732d.mo231b();
                                    break;
                            }
                            LogUtils.a(-1900246292, a);
                        }
                    });
                    break;
                case 1:
                    imageButton.setOnClickListener(new C08253(this));
                    break;
            }
            TracerDetour.a(-1320136929);
            return inflate;
        } catch (Throwable th) {
            TracerDetour.a(-781413109);
        }
    }

    private View m5407e() {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f5731c, -1);
        View view = new View(getContext());
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(2130841964);
        return view;
    }
}
