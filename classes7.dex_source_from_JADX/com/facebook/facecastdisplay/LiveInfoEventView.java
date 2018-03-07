package com.facebook.facecastdisplay;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.facecastdisplay.LiveInfoEventModel.LiveInfoType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: auto_crop */
public class LiveInfoEventView extends CustomLinearLayout {
    private final FbTextView f18893a;

    public LiveInfoEventView(Context context) {
        this(context, null);
    }

    public LiveInfoEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveInfoEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905083);
        this.f18893a = (FbTextView) a(2131563486);
    }

    public void setInfoType(LiveInfoType liveInfoType) {
        switch (liveInfoType) {
            case LIVE_INDICATOR_INFO:
                this.f18893a.setText(new StyledStringBuilder(getResources()).a(getResources().getString(2131232704)).a("%1$s", FacecastUiUtil.m3099a(true, getResources())).b());
                return;
            default:
                return;
        }
    }
}
