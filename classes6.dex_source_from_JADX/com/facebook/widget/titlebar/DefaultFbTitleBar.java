package com.facebook.widget.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.google.common.base.Strings;
import java.util.List;

/* compiled from: reaction_attachments */
public class DefaultFbTitleBar extends LinearLayout implements FbTitleBar {
    private FbTextView f6227a;
    private ImageButton f6228b;
    private FbButton f6229c;
    public OnToolbarButtonListener f6230d;
    public TitleBarButtonSpec f6231e;

    /* compiled from: reaction_attachments */
    class C03741 implements OnClickListener {
        final /* synthetic */ DefaultFbTitleBar f6226a;

        C03741(DefaultFbTitleBar defaultFbTitleBar) {
            this.f6226a = defaultFbTitleBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1716162039);
            if (this.f6226a.f6230d != null) {
                this.f6226a.f6230d.a(view, this.f6226a.f6231e);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1562022615, a);
        }
    }

    public DefaultFbTitleBar(Context context) {
        super(context, null);
        m8775b();
    }

    public DefaultFbTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8775b();
    }

    public DefaultFbTitleBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
    }

    private void m8775b() {
        LayoutInflater.from(getContext()).inflate(2130903874, this);
        this.f6227a = (FbTextView) findViewById(2131559370);
        this.f6228b = (ImageButton) findViewById(2131560942);
        this.f6229c = (FbButton) findViewById(2131558414);
        OnClickListener c03741 = new C03741(this);
        this.f6228b.setOnClickListener(c03741);
        this.f6229c.setOnClickListener(c03741);
    }

    public void setTitle(String str) {
        this.f6227a.setText(str);
    }

    public void setTitle(int i) {
        this.f6227a.setText(i);
    }

    public void setHasBackButton(boolean z) {
    }

    public void setCustomTitleView(View view) {
    }

    public final View f_(int i) {
        return null;
    }

    public final boolean m8777a() {
        return false;
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        TitleBarButtonSpec titleBarButtonSpec = (list == null || list.isEmpty()) ? null : (TitleBarButtonSpec) list.get(0);
        this.f6231e = titleBarButtonSpec;
        if (this.f6231e == null || this.f6231e == TitleBarButtonSpec.b) {
            this.f6228b.setVisibility(8);
            this.f6229c.setVisibility(8);
            return;
        }
        if (this.f6231e.h != -1) {
            this.f6228b.setImageResource(this.f6231e.h);
            this.f6228b.setVisibility(0);
            this.f6229c.setVisibility(8);
        } else if (this.f6231e.d != null) {
            this.f6228b.setImageDrawable(this.f6231e.d);
            this.f6228b.setVisibility(0);
            this.f6229c.setVisibility(8);
        } else if (!Strings.isNullOrEmpty(this.f6231e.i)) {
            this.f6228b.setVisibility(8);
            this.f6229c.setText(this.f6231e.i);
            this.f6229c.setVisibility(0);
        }
        this.f6229c.setSelected(this.f6231e.s);
        this.f6229c.setEnabled(this.f6231e.t);
        this.f6228b.setSelected(this.f6231e.s);
        this.f6228b.setEnabled(this.f6231e.t);
        if (this.f6231e.k != null) {
            this.f6229c.setContentDescription(this.f6231e.k);
            this.f6228b.setContentDescription(this.f6231e.k);
        }
    }

    public void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        this.f6230d = onToolbarButtonListener;
    }

    public void setOnBackPressedListener(FbTitleBar$OnBackPressedListener fbTitleBar$OnBackPressedListener) {
    }

    public void setShowDividers(boolean z) {
    }

    public void setHasFbLogo(boolean z) {
    }

    public final void m8776a(OnClickListener onClickListener) {
    }

    public void setTitlebarAsModal(OnClickListener onClickListener) {
    }
}
