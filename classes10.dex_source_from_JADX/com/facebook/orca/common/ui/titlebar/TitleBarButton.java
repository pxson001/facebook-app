package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: placements */
public class TitleBarButton extends CustomFrameLayout {
    private final ImageButton f5301a;
    private final ProgressBar f5302b;
    private final TextView f5303c;
    private final View f5304d;
    private Drawable f5305e;
    private int f5306f;
    private String f5307g;
    private int f5308h;
    private boolean f5309i;

    /* compiled from: placements */
    class C07481 implements OnClickListener {
        final /* synthetic */ TitleBarButton f5300a;

        C07481(TitleBarButton titleBarButton) {
            this.f5300a = titleBarButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 984136706);
            this.f5300a.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, -1769981415, a);
        }
    }

    public TitleBarButton(Context context) {
        this(context, null);
    }

    private TitleBarButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TitleBarButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5306f = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleBarButton);
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        if (resourceId != -1) {
            this.f5305e = obtainStyledAttributes.getResources().getDrawable(resourceId);
        }
        this.f5308h = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        setContentView(2130905897);
        this.f5301a = (ImageButton) c(2131565241);
        this.f5301a.setImageDrawable(this.f5305e);
        this.f5301a.setOnClickListener(new C07481(this));
        this.f5303c = (TextView) c(2131565244);
        this.f5302b = (ProgressBar) c(2131565243);
        this.f5304d = findViewById(2131564816);
        setDividerPosition(this.f5308h);
    }

    @Nullable
    public void setImageButtonContentDescription(CharSequence charSequence) {
        this.f5301a.setContentDescription(charSequence);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f5307g = null;
        this.f5305e = drawable;
        this.f5306f = -1;
        this.f5301a.setImageDrawable(drawable);
        m4710a();
    }

    public void setIconResId(int i) {
        this.f5307g = null;
        this.f5305e = null;
        this.f5306f = i;
        this.f5301a.setImageResource(i);
        m4710a();
    }

    public void setText(String str) {
        this.f5305e = null;
        this.f5306f = -1;
        this.f5307g = str;
        this.f5303c.setText(str);
        m4710a();
    }

    public void setButtonWidth(int i) {
        if (i > 0 || i == -1 || i == -2) {
            FrameLayout frameLayout = (FrameLayout) findViewById(2131565242);
            LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.width = i;
            frameLayout.setLayoutParams(layoutParams);
            m4710a();
        }
    }

    public void setDividerPosition(int i) {
        boolean z;
        this.f5308h = i;
        FrameLayout.LayoutParams layoutParams;
        if ((i & 1) == 1) {
            layoutParams = (FrameLayout.LayoutParams) this.f5304d.getLayoutParams();
            layoutParams.gravity = 3;
            this.f5304d.setLayoutParams(layoutParams);
            this.f5304d.setVisibility(0);
        } else if ((i & 2) == 2) {
            layoutParams = (FrameLayout.LayoutParams) this.f5304d.getLayoutParams();
            layoutParams.gravity = 5;
            this.f5304d.setLayoutParams(layoutParams);
            this.f5304d.setVisibility(0);
        } else {
            this.f5304d.setVisibility(8);
        }
        ImageButton imageButton = this.f5301a;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        imageButton.setEnabled(z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f5301a.setEnabled(z);
        this.f5303c.setEnabled(z);
    }

    public void setShowProgress(boolean z) {
        int i;
        int i2 = 0;
        this.f5309i = z;
        ProgressBar progressBar = this.f5302b;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        progressBar.setVisibility(i);
        ImageButton imageButton = this.f5301a;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        imageButton.setVisibility(i);
        TextView textView = this.f5303c;
        if (z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    private void m4710a() {
        if (this.f5309i) {
            this.f5302b.setVisibility(0);
            this.f5301a.setVisibility(8);
            this.f5303c.setVisibility(8);
            return;
        }
        this.f5302b.setVisibility(8);
        if (this.f5307g != null) {
            this.f5303c.setVisibility(0);
        } else if (this.f5305e != null || this.f5306f != -1) {
            this.f5301a.setVisibility(0);
        }
    }
}
