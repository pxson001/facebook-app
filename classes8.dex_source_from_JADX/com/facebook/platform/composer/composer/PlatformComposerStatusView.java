package com.facebook.platform.composer.composer;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerAppHashtagView.Listener;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: rich_document_first_measure */
public class PlatformComposerStatusView extends CustomLinearLayout {
    private static final CallerContext f4133a = CallerContext.a(PlatformComposerStatusView.class, "composer");
    private EditText f4134b;
    private FbDraweeView f4135c;
    public PlatformComposerEditText f4136d;
    private PlatformComposerAppHashtagView f4137e;
    private DraweeHolder<GenericDraweeHierarchy> f4138f;
    private final OnLongClickListener f4139g = new C05371(this);
    private final OnTouchListener f4140h = new C05382(this);

    /* compiled from: rich_document_first_measure */
    class C05371 implements OnLongClickListener {
        final /* synthetic */ PlatformComposerStatusView f4131a;

        C05371(PlatformComposerStatusView platformComposerStatusView) {
            this.f4131a = platformComposerStatusView;
        }

        public boolean onLongClick(View view) {
            return this.f4131a.f4136d.performLongClick();
        }
    }

    /* compiled from: rich_document_first_measure */
    class C05382 implements OnTouchListener {
        final /* synthetic */ PlatformComposerStatusView f4132a;

        C05382(PlatformComposerStatusView platformComposerStatusView) {
            this.f4132a = platformComposerStatusView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            motionEvent.setLocation((float) this.f4132a.f4136d.getWidth(), motionEvent.getY() + ((float) this.f4132a.f4136d.getHeight()));
            this.f4132a.f4136d.onTouchEvent(motionEvent);
            return false;
        }
    }

    public PlatformComposerStatusView(Context context) {
        super(context);
        m4098b();
    }

    public PlatformComposerStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4098b();
    }

    private void m4098b() {
        setContentView(2130906319);
        this.f4136d = (PlatformComposerEditText) a(2131563416);
        this.f4135c = (FbDraweeView) a(2131561876);
        this.f4137e = (PlatformComposerAppHashtagView) a(2131566130);
        this.f4138f = DraweeHolder.a(new GenericDraweeHierarchyBuilder(getResources()).u(), getContext());
        this.f4134b = (EditText) a(2131560631);
        setOnLongClickListener(this.f4139g);
        setOnTouchListener(this.f4140h);
        CustomViewUtils.b(this, null);
    }

    public void setListener(Listener listener) {
        if (this.f4137e != null) {
            this.f4137e.f3979c = listener;
        }
    }

    public void setProfileImage(String str) {
        this.f4135c.a(Uri.parse(str), f4133a);
    }

    public final void m4099a() {
        this.f4135c.setVisibility(8);
    }

    public void setAppProvidedHashtag(String str) {
        this.f4137e.setAppProvidedHashtag(str);
        PlatformComposerAppHashtagView platformComposerAppHashtagView = this.f4137e;
        int i = (str == null || str.isEmpty()) ? 8 : 0;
        platformComposerAppHashtagView.setVisibility(i);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 777595604);
        super.onAttachedToWindow();
        if (this.f4138f != null) {
            this.f4138f.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2023875851, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1419422595);
        super.onDetachedFromWindow();
        if (this.f4138f != null) {
            this.f4138f.d();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1164768344, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f4138f != null) {
            this.f4138f.d();
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f4138f != null) {
            this.f4138f.b();
        }
    }

    public final void m4100a(SpannableStringBuilder spannableStringBuilder) {
        this.f4134b.setVisibility(0);
        this.f4134b.setText(spannableStringBuilder);
    }
}
