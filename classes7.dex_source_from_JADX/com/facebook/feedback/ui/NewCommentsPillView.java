package com.facebook.feedback.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: route must not be null */
public class NewCommentsPillView extends CustomLinearLayout {
    private FacepileView f4636a;
    private FbTextView f4637b;

    public NewCommentsPillView(Context context) {
        this(context, null);
    }

    public NewCommentsPillView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewCommentsPillView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5174a();
    }

    public void setPillText(CharSequence charSequence) {
        this.f4637b.setText(charSequence);
    }

    public CharSequence getPillText() {
        return this.f4637b.getText();
    }

    public void setPillProfilePictures(List<Uri> list) {
        if (list == null) {
            this.f4636a.setVisibility(8);
            return;
        }
        boolean z;
        if (list.size() <= 3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        List a = Lists.a();
        for (Uri face : list) {
            a.add(new Face(face));
        }
        this.f4636a.setFaces(a);
        this.f4636a.setVisibility(0);
    }

    private void m5174a() {
        setContentView(2130905433);
        this.f4636a = (FacepileView) a(2131564210);
        this.f4637b = (FbTextView) a(2131564211);
        setGravity(17);
    }
}
