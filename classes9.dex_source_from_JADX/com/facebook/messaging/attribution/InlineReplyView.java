package com.facebook.messaging.attribution;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: outputFormat */
public class InlineReplyView extends CustomFrameLayout {
    public View f7825a = c(2131563165);
    public View f7826b = c(2131562049);
    public FbTextView f7827c = ((FbTextView) c(2131560414));
    public MediaResourceView f7828d = ((MediaResourceView) c(2131563166));
    public FbTextView f7829e = ((FbTextView) c(2131558927));
    public FbTextView f7830f = ((FbTextView) c(2131559627));
    public Listener f7831g;

    /* compiled from: outputFormat */
    public interface Listener {
        void mo287a();

        void mo288b();
    }

    /* compiled from: outputFormat */
    public class C08701 implements OnClickListener {
        final /* synthetic */ InlineReplyView f7822a;

        public C08701(InlineReplyView inlineReplyView) {
            this.f7822a = inlineReplyView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -847606522);
            if (this.f7822a.f7831g != null) {
                this.f7822a.f7831g.mo287a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -763085286, a);
        }
    }

    /* compiled from: outputFormat */
    public class C08712 implements OnClickListener {
        final /* synthetic */ InlineReplyView f7823a;

        public C08712(InlineReplyView inlineReplyView) {
            this.f7823a = inlineReplyView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1557847845);
            if (this.f7823a.f7831g != null) {
                this.f7823a.f7831g.mo288b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -389755533, a);
        }
    }

    /* compiled from: outputFormat */
    public class C08723 implements OnClickListener {
        final /* synthetic */ InlineReplyView f7824a;

        public C08723(InlineReplyView inlineReplyView) {
            this.f7824a = inlineReplyView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -158833702);
            if (this.f7824a.f7831g != null) {
                this.f7824a.f7831g.mo287a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 873535797, a);
        }
    }

    public InlineReplyView(Context context) {
        super(context);
        setContentView(2130904908);
        this.f7825a.setOnClickListener(new C08701(this));
        this.f7826b.setOnClickListener(new C08712(this));
        this.f7827c.setOnClickListener(new C08723(this));
    }

    public void setMediaResource(MediaResource mediaResource) {
        this.f7828d.setMediaResource(mediaResource);
    }

    public final void m8068a() {
        this.f7826b.setEnabled(true);
        ((TextView) this.f7826b).setTextColor(getContext().getResources().getColor(2131362241));
    }
}
