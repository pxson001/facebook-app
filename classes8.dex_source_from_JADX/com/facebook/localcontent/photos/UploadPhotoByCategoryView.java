package com.facebook.localcontent.photos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: document_authors */
public class UploadPhotoByCategoryView extends CustomLinearLayout {
    private TextView f15223a;
    private TextView f15224b;
    private ImageView f15225c;
    private Button f15226d;

    public UploadPhotoByCategoryView(Context context) {
        super(context);
        m17661a();
    }

    public UploadPhotoByCategoryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m17661a();
    }

    public UploadPhotoByCategoryView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17661a();
    }

    public void setPrimaryUploadMessage(String str) {
        this.f15223a.setText(str);
    }

    public void setSecondaryUploadMessage(@Nullable String str) {
        this.f15224b.setText(str);
        this.f15224b.setVisibility(str == null ? 8 : 0);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f15225c.setImageDrawable(drawable);
    }

    public void setUploadButtonOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f15226d.setOnClickListener(onClickListener);
    }

    private void m17661a() {
        setContentView(2130907611);
        setOrientation(1);
        this.f15223a = (TextView) a(2131568196);
        this.f15224b = (TextView) a(2131568197);
        this.f15225c = (ImageView) a(2131568198);
        this.f15226d = (Button) a(2131559595);
    }
}
