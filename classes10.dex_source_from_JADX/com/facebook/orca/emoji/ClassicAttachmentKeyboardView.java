package com.facebook.orca.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.gridlayoututils.GridSizingCalculator;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.audio.record.IsAudioRecorderEnabled;
import com.facebook.messaging.emoji.DownloadableEmojiButtonBuilder;
import com.facebook.messaging.emoji.EmojiAttachmentLogger;
import com.facebook.messaging.emoji.EmojiButtonBuilder;
import com.facebook.messaging.emoji.EmojiGridSizingParams;
import com.facebook.messaging.emoji.EmojiKeyboardView;
import com.facebook.messaging.emoji.EmojiKeyboardView.EmojiPickerListener;
import com.facebook.messaging.emoji.EmojiViewHolder;
import com.facebook.messaging.emoji.KeyRepeaterTouchListener;
import com.facebook.messaging.emoji.KeyRepeaterTouchListener.Listener;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.orca.compose.ComposeFragmentAttachmentSection;
import com.facebook.orca.compose.ComposerKeyboardManager.ClassicAttachmentKeyboardFactory.C07691;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.emoji.model.EmojiSet;
import com.facebook.widget.CustomFrameLayout;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: nti */
public class ClassicAttachmentKeyboardView extends CustomFrameLayout {
    private static final Class<?> f6165g = ClassicAttachmentKeyboardView.class;
    @Inject
    AnalyticsTagger f6166a;
    @Inject
    EmojiAttachmentLogger f6167b;
    @Inject
    DownloadableEmojiButtonBuilder f6168c;
    @Inject
    Emojis f6169d;
    @Inject
    KeyRepeaterTouchListener f6170e;
    @Inject
    @IsAudioRecorderEnabled
    public Provider<Boolean> f6171f;
    private Context f6172h;
    public ComposeFragmentAttachmentSection f6173i;
    public C07691 f6174j;
    public View f6175k;
    private ViewGroup f6176l;
    private ViewGroup f6177m;
    public EmojiKeyboardView f6178n;
    public boolean f6179o;
    private Sizes f6180p;

    /* compiled from: nti */
    class C09431 implements Listener {
        final /* synthetic */ ClassicAttachmentKeyboardView f6159a;

        C09431(ClassicAttachmentKeyboardView classicAttachmentKeyboardView) {
            this.f6159a = classicAttachmentKeyboardView;
        }

        public final void m5900a() {
            ClassicAttachmentKeyboardView classicAttachmentKeyboardView = this.f6159a;
            if (classicAttachmentKeyboardView.f6174j != null) {
                classicAttachmentKeyboardView.f6174j.m5020b();
            }
        }
    }

    /* compiled from: nti */
    class C09442 implements ComposeFragmentAttachmentSection.Listener {
        final /* synthetic */ ClassicAttachmentKeyboardView f6160a;

        C09442(ClassicAttachmentKeyboardView classicAttachmentKeyboardView) {
            this.f6160a = classicAttachmentKeyboardView;
        }

        public final void mo230a() {
            this.f6160a.f6167b.a("gallery_button");
            ClassicAttachmentKeyboardView.m5909a(this.f6160a, PickMediaSource.GALLERY);
        }

        public final void mo231b() {
            this.f6160a.f6167b.a("camera_button");
            ClassicAttachmentKeyboardView.m5909a(this.f6160a, PickMediaSource.CAMERA);
        }

        public final void mo232c() {
            this.f6160a.f6167b.a("audio_recorder_button");
            this.f6160a.f6174j.f5444a.f5445a.m5101p();
        }
    }

    /* compiled from: nti */
    class C09453 implements OnClickListener {
        final /* synthetic */ ClassicAttachmentKeyboardView f6161a;

        C09453(ClassicAttachmentKeyboardView classicAttachmentKeyboardView) {
            this.f6161a = classicAttachmentKeyboardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -119560611);
            ClassicAttachmentKeyboardView classicAttachmentKeyboardView = this.f6161a;
            if (classicAttachmentKeyboardView.f6178n == null) {
                ((ViewStub) classicAttachmentKeyboardView.c(2131564513)).inflate();
                classicAttachmentKeyboardView.f6178n = (EmojiKeyboardView) classicAttachmentKeyboardView.c(2131564514);
                classicAttachmentKeyboardView.f6178n.l = new C09464(classicAttachmentKeyboardView);
            }
            classicAttachmentKeyboardView.f6175k.setVisibility(8);
            classicAttachmentKeyboardView.f6178n.setVisibility(0);
            this.f6161a.f6167b.a("backside_button");
            Logger.a(2, EntryType.UI_INPUT_END, -2075476554, a);
        }
    }

    /* compiled from: nti */
    public class C09464 implements EmojiPickerListener {
        final /* synthetic */ ClassicAttachmentKeyboardView f6162a;

        public C09464(ClassicAttachmentKeyboardView classicAttachmentKeyboardView) {
            this.f6162a = classicAttachmentKeyboardView;
        }

        public final void m5904a() {
            this.f6162a.f6174j.m5020b();
        }

        public final void m5905a(Emoji emoji) {
            this.f6162a.f6174j.m5019a(emoji);
        }
    }

    /* compiled from: nti */
    enum EmojiRowPosition {
        FIRST_ROW,
        SECOND_ROW
    }

    private static <T extends View> void m5910a(Class<T> cls, T t) {
        m5911a((Object) t, t.getContext());
    }

    private static void m5911a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ClassicAttachmentKeyboardView) obj).m5908a(AnalyticsTagger.a(fbInjector), EmojiAttachmentLogger.a(fbInjector), DownloadableEmojiButtonBuilder.a(fbInjector), Emojis.a(fbInjector), KeyRepeaterTouchListener.a(fbInjector), IdBasedProvider.a(fbInjector, 4108));
    }

    public ClassicAttachmentKeyboardView(Context context) {
        super(context);
        m5910a(ClassicAttachmentKeyboardView.class, (View) this);
        TracerDetour.a("ClassicAttachmentKeyboard create view", -1630684373);
        try {
            this.f6172h = ContextUtils.a(getContext(), 2130773114, 2131625139);
            TracerDetour.a("layoutInflation", 599770796);
            try {
                int cloneInContext = LayoutInflater.from(getContext()).cloneInContext(this.f6172h);
                cloneInContext.inflate(2130905586, this);
                TracerDetour.a(cloneInContext);
                this.f6175k = c(2131564506);
                this.f6166a.a(this, "emoji_popup", getClass());
                this.f6170e.a(new C09431(this));
            } finally {
                TracerDetour.a(196219502);
            }
        } finally {
            TracerDetour.a(-1843927808);
        }
    }

    private void m5908a(AnalyticsTagger analyticsTagger, EmojiAttachmentLogger emojiAttachmentLogger, EmojiButtonBuilder emojiButtonBuilder, Emojis emojis, KeyRepeaterTouchListener keyRepeaterTouchListener, Provider<Boolean> provider) {
        this.f6166a = analyticsTagger;
        this.f6167b = emojiAttachmentLogger;
        this.f6168c = emojiButtonBuilder;
        this.f6169d = emojis;
        this.f6170e = keyRepeaterTouchListener;
        this.f6171f = provider;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size > 0 && size2 > 0) {
            boolean z = this.f6180p == null;
            Resources resources = getResources();
            this.f6180p = new GridSizingCalculator(resources, new EmojiGridSizingParams()).a(size, size2 - resources.getDimensionPixelSize(2131427864), false);
            if (z) {
                m5912b();
            }
        }
        super.onMeasure(i, i2);
    }

    private void m5912b() {
        ((ViewStub) c(2131564507)).inflate();
        this.f6176l = (ViewGroup) c(2131564509);
        this.f6177m = (ViewGroup) c(2131564510);
        this.f6173i = (ComposeFragmentAttachmentSection) c(2131560486);
        this.f6173i.setListener(new C09442(this));
        m5913f();
        c(2131564511).setOnClickListener(new C09453(this));
        c(2131564512).setOnTouchListener(this.f6170e);
        m5914g();
    }

    private void m5913f() {
        TracerDetour.a("addAttachmentOperationItems", -1641643422);
        try {
            this.f6173i.mo164b();
            this.f6173i.mo163a();
            if (((Boolean) this.f6171f.get()).booleanValue() && this.f6179o) {
                this.f6173i.mo165c();
            }
            TracerDetour.a(-1966458504);
        } catch (Throwable th) {
            TracerDetour.a(889098037);
        }
    }

    private void m5914g() {
        int i = 0;
        TracerDetour.a("loadAndSetEmojiAndButtonOnFront", -1719322559);
        try {
            EmojiSet b = this.f6169d.b();
            if (getResources().getConfiguration().orientation == 1) {
                m5907a(this.f6176l, b, 0, this.f6180p.a(), EmojiRowPosition.FIRST_ROW);
                i = this.f6180p.a();
            } else {
                this.f6176l.setVisibility(8);
            }
            m5907a(this.f6177m, b, i, this.f6180p.a() - 2, EmojiRowPosition.SECOND_ROW);
        } finally {
            TracerDetour.a(-1867001979);
        }
    }

    private void m5907a(ViewGroup viewGroup, EmojiSet emojiSet, int i, int i2, EmojiRowPosition emojiRowPosition) {
        List list = emojiSet.c;
        for (final Emoji emoji : list.subList(i, Math.min(list.size(), i + i2))) {
            EmojiViewHolder a = this.f6168c.a(viewGroup);
            a.b(emoji);
            a.a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ClassicAttachmentKeyboardView f6164b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1021053070);
                    this.f6164b.performHapticFeedback(3);
                    ClassicAttachmentKeyboardView classicAttachmentKeyboardView = this.f6164b;
                    Emoji emoji = emoji;
                    if (classicAttachmentKeyboardView.f6174j != null) {
                        classicAttachmentKeyboardView.f6174j.m5019a(emoji);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 1869125839, a);
                }
            });
            m5906a(viewGroup, a.a, -1, emojiRowPosition);
        }
        if (emojiRowPosition == EmojiRowPosition.SECOND_ROW) {
            m5906a(viewGroup, new View(getContext()), 0, emojiRowPosition);
            m5906a(viewGroup, new View(getContext()), -1, emojiRowPosition);
        }
    }

    private void m5906a(ViewGroup viewGroup, View view, int i, EmojiRowPosition emojiRowPosition) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 80;
        if (emojiRowPosition == EmojiRowPosition.SECOND_ROW) {
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(ContextUtils.b(this.f6172h, 2130773119, 2131428494));
        }
        viewGroup.addView(view, i, layoutParams);
    }

    public static void m5909a(ClassicAttachmentKeyboardView classicAttachmentKeyboardView, PickMediaSource pickMediaSource) {
        if (classicAttachmentKeyboardView.f6174j != null) {
            C07691 c07691 = classicAttachmentKeyboardView.f6174j;
            if (c07691.f5444a.f5445a.f5489s != null) {
                c07691.f5444a.f5445a.f5489s.m4804a(pickMediaSource);
            }
        }
    }
}
