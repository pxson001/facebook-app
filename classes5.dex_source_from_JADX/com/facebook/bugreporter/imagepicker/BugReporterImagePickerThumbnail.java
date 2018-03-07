package com.facebook.bugreporter.imagepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ui.compat.opacity.ImageViewOpacity;

/* compiled from: android.intent.extra.shortcut.ICON */
public class BugReporterImagePickerThumbnail extends FrameLayout {
    public ImageView f10759a;
    public ImageView f10760b;
    public boolean f10761c;

    /* compiled from: android.intent.extra.shortcut.ICON */
    public class C10481 implements OnTouchListener {
        final /* synthetic */ BugReporterImagePickerThumbnail f10758a;

        public C10481(BugReporterImagePickerThumbnail bugReporterImagePickerThumbnail) {
            this.f10758a = bugReporterImagePickerThumbnail;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f10758a.f10761c = true;
                ImageViewOpacity.m10314a(this.f10758a.f10759a, 128);
            } else if (this.f10758a.f10761c && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                this.f10758a.f10761c = false;
                ImageViewOpacity.m10314a(this.f10758a.f10759a, 255);
            } else if (!this.f10758a.f10761c) {
                ImageViewOpacity.m10314a(this.f10758a.f10759a, 255);
            }
            return false;
        }
    }

    public BugReporterImagePickerThumbnail(Context context) {
        this(context, null, 0);
    }

    private BugReporterImagePickerThumbnail(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10761c = false;
        View.inflate(getContext(), 2130904835, this);
        this.f10759a = (ImageView) findViewById(2131563053);
        this.f10760b = (ImageView) findViewById(2131563054);
        this.f10760b.setOnTouchListener(new C10481(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131430593);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 48;
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setLayoutParams(layoutParams);
    }
}
