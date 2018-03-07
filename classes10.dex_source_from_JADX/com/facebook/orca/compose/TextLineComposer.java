package com.facebook.orca.compose;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ProgressBar;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.composer.edit.MessageComposerEditorProvider;
import com.facebook.messaging.composer.triggers.ContentSearchType;
import com.facebook.messaging.composershortcuts.BuiltinComposerShortcuts;
import com.facebook.messaging.composershortcuts.ComposerButton;
import com.facebook.messaging.composershortcuts.ComposerShortcutItem;
import com.facebook.messaging.composershortcuts.ComposerShortcutItemBuilder;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: open_fullscreen_dialog */
public class TextLineComposer extends CustomLinearLayout {
    @Inject
    BuiltinComposerShortcuts f5580a;
    @Inject
    MessageComposerEditorProvider f5581b;
    private ViewStubHolder<View> f5582c;
    private BetterEditTextView f5583d;
    private ViewStubHolder<View> f5584e;
    private ViewStubHolder<View> f5585f;
    private ViewStubHolder<ProgressBar> f5586g;
    private ViewStubHolder<ComposerButton> f5587h;
    private ViewStubHolder<BetterTextView> f5588i;
    private ViewStubHolder<ComposerButton> f5589j;
    private ViewStubHolder<ComposerButton> f5590k;
    public MessageComposerEditor f5591l;
    private ComposerShortcutItem f5592m;
    public Listener f5593n;
    private boolean f5594o;
    private boolean f5595p;
    private boolean f5596q;
    @Nullable
    private ContentSearchType f5597r;
    private final Map<ViewStubHolder<? extends View>, Boolean> f5598s = new HashMap();
    private int f5599t;
    private String f5600u;

    /* compiled from: open_fullscreen_dialog */
    class C07911 implements OnInflateListener<View> {
        final /* synthetic */ TextLineComposer f5571a;

        C07911(TextLineComposer textLineComposer) {
            this.f5571a = textLineComposer;
        }

        public final void m5156a(View view) {
            this.f5571a.m5169a(view, "overflow");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07922 implements OnInflateListener<ComposerButton> {
        final /* synthetic */ TextLineComposer f5572a;

        C07922(TextLineComposer textLineComposer) {
            this.f5572a = textLineComposer;
        }

        public final void m5157a(View view) {
            ComposerButton composerButton = (ComposerButton) view;
            composerButton.setComposerShortcut(this.f5572a.f5580a.a("emoji"));
            this.f5572a.m5169a((View) composerButton, "emoji");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07933 implements OnInflateListener<BetterTextView> {
        final /* synthetic */ TextLineComposer f5573a;

        C07933(TextLineComposer textLineComposer) {
            this.f5573a = textLineComposer;
        }

        public final void m5158a(View view) {
            this.f5573a.m5169a((View) (BetterTextView) view, "message_cap");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07944 implements OnInflateListener<ComposerButton> {
        final /* synthetic */ TextLineComposer f5574a;

        C07944(TextLineComposer textLineComposer) {
            this.f5574a = textLineComposer;
        }

        public final void m5159a(View view) {
            ComposerButton composerButton = (ComposerButton) view;
            composerButton.setComposerShortcut(TextLineComposer.getLikeComposerShortcutItem(this.f5574a));
            this.f5574a.m5169a((View) composerButton, "like");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07955 implements OnInflateListener<ComposerButton> {
        final /* synthetic */ TextLineComposer f5575a;

        C07955(TextLineComposer textLineComposer) {
            this.f5575a = textLineComposer;
        }

        public final void m5160a(View view) {
            ComposerButton composerButton = (ComposerButton) view;
            composerButton.setComposerShortcut(this.f5575a.f5580a.a("send"));
            this.f5575a.m5169a((View) composerButton, "send");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07966 implements OnInflateListener<View> {
        final /* synthetic */ TextLineComposer f5576a;

        C07966(TextLineComposer textLineComposer) {
            this.f5576a = textLineComposer;
        }

        public final void m5161a(View view) {
            this.f5576a.m5169a(view, "content_search_back");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07977 implements OnInflateListener<View> {
        final /* synthetic */ TextLineComposer f5577a;

        C07977(TextLineComposer textLineComposer) {
            this.f5577a = textLineComposer;
        }

        public final void m5162a(View view) {
            this.f5577a.m5169a(view, "content_search_clear");
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07988 implements OnTouchListener {
        final /* synthetic */ TextLineComposer f5578a;

        C07988(TextLineComposer textLineComposer) {
            this.f5578a = textLineComposer;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5578a.f5593n != null) {
                return this.f5578a.f5593n.mo170a();
            }
            return false;
        }
    }

    /* compiled from: open_fullscreen_dialog */
    class C07999 implements OnFocusChangeListener {
        final /* synthetic */ TextLineComposer f5579a;

        C07999(TextLineComposer textLineComposer) {
            this.f5579a = textLineComposer;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f5579a.f5593n != null) {
                this.f5579a.f5593n.mo169a(z);
            }
        }
    }

    /* compiled from: open_fullscreen_dialog */
    abstract class Listener {
        abstract void mo168a(String str, View view);

        abstract void mo169a(boolean z);

        abstract boolean mo170a();

        abstract boolean mo171a(String str, View view, MotionEvent motionEvent);

        abstract void mo172b(String str, View view);

        Listener() {
        }
    }

    private static <T extends View> void m5172a(Class<T> cls, T t) {
        m5173a((Object) t, t.getContext());
    }

    private static void m5173a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TextLineComposer) obj).m5170a(BuiltinComposerShortcuts.a(fbInjector), (MessageComposerEditorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MessageComposerEditorProvider.class));
    }

    private void m5170a(BuiltinComposerShortcuts builtinComposerShortcuts, MessageComposerEditorProvider messageComposerEditorProvider) {
        this.f5580a = builtinComposerShortcuts;
        this.f5581b = messageComposerEditorProvider;
    }

    public TextLineComposer(Context context) {
        super(context);
        m5175c();
    }

    public TextLineComposer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m5175c();
    }

    protected TextLineComposer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5175c();
    }

    private void m5175c() {
        m5172a(TextLineComposer.class, (View) this);
        setContentView(2130905873);
        this.f5582c = ViewStubHolder.a((ViewStubCompat) a(2131565178));
        this.f5582c.c = new C07911(this);
        this.f5587h = ViewStubHolder.a((ViewStubCompat) a(2131565182));
        this.f5587h.c = new C07922(this);
        this.f5588i = ViewStubHolder.a((ViewStubCompat) a(2131565183));
        this.f5588i.c = new C07933(this);
        this.f5589j = ViewStubHolder.a((ViewStubCompat) a(2131565184));
        this.f5589j.c = new C07944(this);
        this.f5590k = ViewStubHolder.a((ViewStubCompat) a(2131565185));
        this.f5590k.c = new C07955(this);
        this.f5584e = ViewStubHolder.a((ViewStubCompat) a(2131565179));
        this.f5584e.c = new C07966(this);
        this.f5586g = ViewStubHolder.a((ViewStubCompat) a(2131565181));
        this.f5585f = ViewStubHolder.a((ViewStubCompat) a(2131565180));
        this.f5585f.c = new C07977(this);
        this.f5583d = (BetterEditTextView) a(2131559443);
        this.f5583d.setOnTouchListener(new C07988(this));
        this.f5583d.setOnFocusChangeListener(new C07999(this));
        this.f5598s.put(this.f5587h, Boolean.valueOf(this.f5587h.d()));
        this.f5598s.put(this.f5584e, Boolean.valueOf(this.f5584e.d()));
        this.f5598s.put(this.f5585f, Boolean.valueOf(this.f5585f.d()));
        this.f5598s.put(this.f5588i, Boolean.valueOf(this.f5588i.d()));
        this.f5598s.put(this.f5589j, Boolean.valueOf(this.f5589j.d()));
        this.f5598s.put(this.f5590k, Boolean.valueOf(this.f5590k.d()));
        this.f5598s.put(this.f5582c, Boolean.valueOf(this.f5582c.d()));
        this.f5591l = this.f5581b.a(this.f5583d);
    }

    void setListener(Listener listener) {
        this.f5593n = listener;
    }

    public void setComposerButtonActiveColorFilterOverride(int i) {
        this.f5599t = i;
        if (this.f5587h.c()) {
            ((ComposerButton) this.f5587h.a()).setSelectedColorFilterColorOverride(i);
        }
        if (this.f5590k.c()) {
            ((ComposerButton) this.f5590k.a()).setDefaultColorFilterColorOverride(i);
        }
        if (this.f5589j.c() && this.f5592m == null) {
            ((ComposerButton) this.f5589j.a()).setDefaultColorFilterColorOverride(i);
        }
    }

    void setLikeIconIdOverride(int i) {
        if (i != 0 || this.f5592m != null) {
            if (i == 0 || this.f5592m == null || this.f5592m.d != i) {
                if (i == 0) {
                    this.f5592m = null;
                } else {
                    ComposerShortcutItemBuilder a = ComposerShortcutItem.newBuilder().a(this.f5580a.a("like"));
                    a.f = null;
                    a = a;
                    a.e = null;
                    a = a;
                    a.d = i;
                    a = a;
                    a.o = false;
                    this.f5592m = a.s();
                }
                if (this.f5589j.c()) {
                    ((ComposerButton) this.f5589j.a()).setComposerShortcut(getLikeComposerShortcutItem(this));
                }
            }
        }
    }

    public static ComposerShortcutItem getLikeComposerShortcutItem(TextLineComposer textLineComposer) {
        return textLineComposer.f5592m != null ? textLineComposer.f5592m : textLineComposer.f5580a.a("like");
    }

    MessageComposerEditor getEditor() {
        return this.f5591l;
    }

    String getUnsentMessageText() {
        if (this.f5600u != null) {
            return this.f5600u;
        }
        return this.f5591l.a().toString();
    }

    final boolean m5183a(String str) {
        return m5179g(str).c();
    }

    final void m5185b(String str) {
        ViewStubHolder g = m5179g(str);
        this.f5598s.put(g, Boolean.valueOf(true));
        g.f();
    }

    final void m5187c(String str) {
        ViewStubHolder g = m5179g(str);
        this.f5598s.put(g, Boolean.valueOf(false));
        g.e();
    }

    final void m5180a() {
        for (ViewStubHolder viewStubHolder : this.f5598s.keySet()) {
            this.f5598s.put(viewStubHolder, Boolean.valueOf(viewStubHolder.d()));
            viewStubHolder.e();
        }
        this.f5584e.f();
        this.f5598s.put(this.f5584e, Boolean.valueOf(true));
        this.f5600u = this.f5583d.getText().toString();
        this.f5583d.setText("");
        this.f5586g.f();
        m5182a(true, ContentSearchType.ANIMATION);
    }

    final void m5184b() {
        this.f5584e.e();
        this.f5598s.put(this.f5584e, Boolean.valueOf(false));
        this.f5585f.e();
        this.f5598s.put(this.f5585f, Boolean.valueOf(false));
        this.f5586g.e();
        for (ViewStubHolder viewStubHolder : this.f5598s.keySet()) {
            if (((Boolean) this.f5598s.get(viewStubHolder)).booleanValue()) {
                viewStubHolder.f();
            }
        }
        this.f5583d.setText(this.f5600u);
        this.f5600u = null;
        m5182a(false, null);
    }

    final void m5182a(boolean z, @Nullable ContentSearchType contentSearchType) {
        this.f5594o = z;
        this.f5597r = contentSearchType;
        m5176d();
    }

    void setIsSecretMode(boolean z) {
        this.f5595p = z;
        m5176d();
    }

    void setIsSmsThread(boolean z) {
        this.f5596q = z;
        m5176d();
    }

    final void m5181a(String str, boolean z) {
        if (z) {
            m5185b(str);
        } else {
            m5187c(str);
        }
    }

    final void m5186b(String str, boolean z) {
        ViewStubHolder g = m5179g(str);
        if (z || g.c()) {
            View a = g.a();
            a.setEnabled(z);
            this.f5598s.put(g, Boolean.valueOf(g.d()));
            if (!z) {
                return;
            }
            if (str.equals("send") || str.equals("like")) {
                ((ComposerButton) a).setDefaultColorFilterColorOverride(this.f5599t);
            }
        }
    }

    final void m5188c(String str, boolean z) {
        ViewStubHolder g = m5179g(str);
        if (z || g.c()) {
            g.a().setSelected(z);
            this.f5598s.put(g, Boolean.valueOf(g.d()));
        }
    }

    final boolean m5189d(String str) {
        ViewStubHolder g = m5179g(str);
        return g.c() && g.a().isSelected();
    }

    void setEnableComposerContentSearchLoadingProgress(boolean z) {
        String str;
        String str2;
        boolean z2;
        if (z) {
            this.f5586g.f();
            str = "content_search_clear";
        } else {
            this.f5586g.e();
            str = "content_search_clear";
            if (!StringUtil.c(this.f5583d.getText().toString())) {
                str2 = str;
                z2 = true;
                m5181a(str2, z2);
            }
        }
        str2 = str;
        z2 = false;
        m5181a(str2, z2);
    }

    private void m5169a(View view, String str) {
        view.setOnClickListener(m5177e(str));
        view.setOnTouchListener(m5178f(str));
        if (this.f5593n != null) {
            this.f5593n.mo168a(str, view);
        }
    }

    private OnClickListener m5177e(final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ TextLineComposer f5568b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2129938530);
                if (this.f5568b.f5593n != null) {
                    this.f5568b.f5593n.mo172b(str, view);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1335427498, a);
            }
        };
    }

    private OnTouchListener m5178f(final String str) {
        return new OnTouchListener(this) {
            final /* synthetic */ TextLineComposer f5570b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.f5570b.f5593n != null) {
                    return this.f5570b.f5593n.mo171a(str, view, motionEvent);
                }
                return false;
            }
        };
    }

    private ViewStubHolder<?> m5179g(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -872787046:
                if (str.equals("message_cap")) {
                    obj = 4;
                    break;
                }
                break;
            case -231258536:
                if (str.equals("content_search_back")) {
                    obj = 5;
                    break;
                }
                break;
            case 3321751:
                if (str.equals("like")) {
                    obj = 2;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    obj = 3;
                    break;
                }
                break;
            case 96632902:
                if (str.equals("emoji")) {
                    obj = null;
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    obj = 1;
                    break;
                }
                break;
            case 1422172924:
                if (str.equals("content_search_clear")) {
                    obj = 6;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return this.f5587h;
            case 1:
                return this.f5582c;
            case 2:
                return this.f5589j;
            case 3:
                return this.f5590k;
            case 4:
                return this.f5588i;
            case 5:
                return this.f5584e;
            case 6:
                return this.f5585f;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void m5176d() {
        CharSequence string = getResources().getString(2131230968);
        if (this.f5594o) {
            string = this.f5597r == ContentSearchType.STICKER ? getResources().getString(2131230970) : getResources().getString(2131230969);
        } else if (this.f5595p) {
            string = getResources().getString(2131230971);
        } else if (this.f5596q) {
            string = getResources().getString(2131230972);
        }
        this.f5583d.setHint(string);
    }
}
