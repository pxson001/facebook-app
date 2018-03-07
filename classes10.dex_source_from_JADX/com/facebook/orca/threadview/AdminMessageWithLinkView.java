package com.facebook.orca.threadview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.MessageListAdapter.C10774;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: multipart/form-data; boundary=%s */
public class AdminMessageWithLinkView extends CustomLinearLayout {
    public final LinkClickListener f6837a = new LinkClickListener(this);
    public final ThemeListener f6838b = new ThemeListener(this);
    public ImageWithTextView f6839c;
    public TextView f6840d;
    @Nullable
    public C10774 f6841e;
    @Nullable
    public RowMessageItem f6842f;
    @Nullable
    public DefaultThreadViewTheme f6843g;

    /* compiled from: multipart/form-data; boundary=%s */
    class LinkClickListener implements OnClickListener {
        final /* synthetic */ AdminMessageWithLinkView f6835a;

        public LinkClickListener(AdminMessageWithLinkView adminMessageWithLinkView) {
            this.f6835a = adminMessageWithLinkView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1847132935);
            if (!(this.f6835a.f6841e == null || this.f6835a.f6842f == null)) {
                C10774 c10774 = this.f6835a.f6841e;
                RowMessageItem rowMessageItem = this.f6835a.f6842f;
                if (c10774.f7168a.f7175A != null) {
                    c10774.f7168a.f7175A.mo284a(rowMessageItem);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -496315967, a);
        }
    }

    /* compiled from: multipart/form-data; boundary=%s */
    class ThemeListener implements Listener {
        final /* synthetic */ AdminMessageWithLinkView f6836a;

        public ThemeListener(AdminMessageWithLinkView adminMessageWithLinkView) {
            this.f6836a = adminMessageWithLinkView;
        }

        public final void m6498a() {
            AdminMessageWithLinkView.m6499b(this.f6836a);
        }
    }

    public AdminMessageWithLinkView(Context context) {
        super(context);
        setContentView(2130905309);
        setOrientation(1);
        this.f6839c = (ImageWithTextView) a(2131563941);
        this.f6840d = (TextView) a(2131563942);
        this.f6840d.setOnClickListener(this.f6837a);
    }

    public static void m6499b(AdminMessageWithLinkView adminMessageWithLinkView) {
        Preconditions.checkNotNull(adminMessageWithLinkView.f6843g);
        adminMessageWithLinkView.f6839c.setTextColor(adminMessageWithLinkView.f6843g.d());
        adminMessageWithLinkView.f6840d.setTextColor(adminMessageWithLinkView.f6843g.e());
    }
}
