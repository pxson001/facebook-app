package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_thread_settings_opened_from_admin_message */
public class MessageItemGutterView extends CustomFrameLayout {
    @Inject
    public GlyphColorizer f7064a;
    private ViewStubHolder<ImageButton> f7065b;
    private ViewStubHolder<ProgressBar> f7066c;
    private ViewStubHolder<TextView> f7067d;
    private boolean f7068e;
    @Nullable
    public Listener f7069f;

    /* compiled from: messenger_thread_settings_opened_from_admin_message */
    class C10601 implements OnInflateListener<ImageButton> {
        final /* synthetic */ MessageItemGutterView f7063a;

        /* compiled from: messenger_thread_settings_opened_from_admin_message */
        class C10591 implements OnClickListener {
            final /* synthetic */ C10601 f7062a;

            C10591(C10601 c10601) {
                this.f7062a = c10601;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 139535433);
                if (this.f7062a.f7063a.f7069f != null) {
                    this.f7062a.f7063a.f7069f.mo253a();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 916459679, a);
            }
        }

        C10601(MessageItemGutterView messageItemGutterView) {
            this.f7063a = messageItemGutterView;
        }

        public final void m6634a(View view) {
            ((ImageButton) view).setOnClickListener(new C10591(this));
        }
    }

    /* compiled from: messenger_thread_settings_opened_from_admin_message */
    public interface Listener {
        void mo253a();
    }

    private static <T extends View> void m6639a(Class<T> cls, T t) {
        m6640a((Object) t, t.getContext());
    }

    private static void m6640a(Object obj, Context context) {
        ((MessageItemGutterView) obj).f7064a = GlyphColorizer.a(FbInjector.get(context));
    }

    public MessageItemGutterView(Context context) {
        super(context);
        m6637a(context, null, 0);
    }

    public MessageItemGutterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m6637a(context, attributeSet, 0);
    }

    public MessageItemGutterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6637a(context, attributeSet, i);
    }

    private void m6637a(Context context, @Nullable AttributeSet attributeSet, int i) {
        m6639a(MessageItemGutterView.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MessageItemGutterView, i, i);
            this.f7068e = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        setContentView(this.f7068e ? 2130905759 : 2130905741);
        this.f7065b = ViewStubHolder.a((ViewStubCompat) c(2131564927));
        this.f7065b.c = new C10601(this);
        this.f7067d = ViewStubHolder.a((ViewStubCompat) c(2131564929));
        if (this.f7068e) {
            this.f7066c = ViewStubHolder.a((ViewStubCompat) c(2131564938));
        }
    }

    public void setListener(Listener listener) {
        this.f7069f = listener;
    }

    private void m6638a(GlyphColorizer glyphColorizer) {
        this.f7064a = glyphColorizer;
    }

    public final void m6641a() {
        ((ImageButton) this.f7065b.a()).setImageDrawable(this.f7064a.a(2130841383, getResources().getColor(2131362281)));
        m6645f();
        this.f7065b.f();
    }

    public final void m6643b() {
        Preconditions.checkArgument(this.f7068e, "You can only show the progress bar for the me user");
        m6645f();
        this.f7066c.f();
    }

    public final void m6644e() {
        m6645f();
        this.f7067d.f();
    }

    public final boolean m6642a(String str) {
        if (!this.f7067d.c()) {
            return false;
        }
        ((TextView) this.f7067d.a()).setText(str);
        return true;
    }

    public final void m6645f() {
        this.f7065b.e();
        if (this.f7068e) {
            this.f7066c.e();
        }
        this.f7067d.e();
    }
}
