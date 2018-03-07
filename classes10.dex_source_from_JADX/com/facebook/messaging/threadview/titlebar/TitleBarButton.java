package com.facebook.messaging.threadview.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.common.util.ContextUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import javax.annotation.Nullable;

/* compiled from: placements */
public class TitleBarButton extends CustomFrameLayout {
    private ImageView f4841a;
    private TextView f4842b;
    @Nullable
    public CharSequence f4843c;

    /* compiled from: placements */
    class C06601 implements OnLongClickListener {
        final /* synthetic */ TitleBarButton f4840a;

        C06601(TitleBarButton titleBarButton) {
            this.f4840a = titleBarButton;
        }

        public boolean onLongClick(View view) {
            if (this.f4840a.f4843c == null) {
                return false;
            }
            int[] iArr = new int[2];
            this.f4840a.getLocationOnScreen(iArr);
            Toast makeText = Toast.makeText(this.f4840a.getContext(), this.f4840a.f4843c, 0);
            makeText.setGravity(51, iArr[0], iArr[1] + this.f4840a.getHeight());
            makeText.show();
            return true;
        }
    }

    public TitleBarButton(Context context) {
        super(context);
        m4382a();
    }

    public TitleBarButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4382a();
    }

    public TitleBarButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4382a();
    }

    private void m4382a() {
        setContentView(2130907393);
        this.f4841a = (ImageView) c(2131567851);
        this.f4842b = (TextView) c(2131567852);
        setBackground(ContextUtils.f(getContext(), 2130772019, 0));
        setOnLongClickListener(new C06601(this));
    }

    public void setButtonIcon(int i) {
        this.f4841a.setImageResource(i);
        this.f4841a.setVisibility(0);
        this.f4842b.setVisibility(8);
    }

    public void setButtonIcon(@Nullable Drawable drawable) {
        int i;
        int i2 = 8;
        this.f4841a.setImageDrawable(drawable);
        ImageView imageView = this.f4841a;
        if (drawable != null) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        TextView textView = this.f4842b;
        if (drawable == null) {
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    public void setButtonText(@Nullable CharSequence charSequence) {
        this.f4843c = charSequence;
        this.f4842b.setText(charSequence);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4841a.setEnabled(z);
        this.f4842b.setEnabled(z);
    }

    public final void m4383a(TitleBarButtonSpec titleBarButtonSpec) {
        int i;
        if (titleBarButtonSpec.h > 0) {
            setButtonIcon(titleBarButtonSpec.h);
        } else {
            setButtonIcon(titleBarButtonSpec.d);
        }
        setId(titleBarButtonSpec.c);
        setButtonText(titleBarButtonSpec.i);
        this.f4842b.setAllCaps(titleBarButtonSpec.q);
        setContentDescription(titleBarButtonSpec.k);
        if (titleBarButtonSpec.f) {
            i = 4;
        } else {
            i = 0;
        }
        setVisibility(i);
        setSelected(titleBarButtonSpec.s);
        setEnabled(titleBarButtonSpec.t);
    }
}
