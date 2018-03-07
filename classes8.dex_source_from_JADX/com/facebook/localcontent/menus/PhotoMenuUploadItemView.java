package com.facebook.localcontent.menus;

import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: ec_config_action_bar */
public class PhotoMenuUploadItemView extends CustomFrameLayout {
    private EditText f15044a;
    public TextView f15045b;
    private FbDraweeView f15046c;
    private TextView f15047d;
    private ImageView f15048e;
    private TextWatcher f15049f;

    public PhotoMenuUploadItemView(Context context) {
        super(context);
        m17476a();
    }

    public PhotoMenuUploadItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m17476a();
    }

    public PhotoMenuUploadItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17476a();
    }

    public void setDescription(@Nullable String str) {
        this.f15044a.setText(str);
    }

    public void setDescriptionWatcher(TextWatcher textWatcher) {
        this.f15044a.removeTextChangedListener(this.f15049f);
        this.f15049f = textWatcher;
        this.f15044a.addTextChangedListener(this.f15049f);
    }

    public final void m17478a(Uri uri, int i, int i2, CallerContext callerContext) {
        this.f15046c.setAspectRatio(((float) i) / ((float) i2));
        this.f15046c.a(uri, callerContext);
    }

    public void setPhotoNumber(int i) {
        this.f15047d.setText(i);
    }

    public void setRemoveButtonOnClickListener(OnClickListener onClickListener) {
        this.f15048e.setOnClickListener(onClickListener);
    }

    private void m17476a() {
        LayoutInflater.from(getContext()).inflate(2130906200, this);
        this.f15044a = (EditText) c(2131565910);
        this.f15045b = (TextView) c(2131565911);
        this.f15046c = (FbDraweeView) c(2131565907);
        this.f15047d = (TextView) c(2131565908);
        this.f15048e = (ImageView) c(2131565909);
        m17477b();
    }

    private void m17477b() {
        final int integer = getResources().getInteger(2131492945);
        this.f15044a.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ PhotoMenuUploadItemView f15043b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f15043b.f15045b.setText(charSequence.length() + " / " + integer);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
