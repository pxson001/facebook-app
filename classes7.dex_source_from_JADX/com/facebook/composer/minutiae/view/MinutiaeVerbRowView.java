package com.facebook.composer.minutiae.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: tertiary_title */
public class MinutiaeVerbRowView extends FbTextView {
    protected static final CallerContext f1893a = CallerContext.a(MinutiaeVerbRowView.class, "composer");
    @Inject
    public FbDraweeControllerBuilder f1894b;
    private final DraweeHolder f1895c = new DraweeHolder(new GenericDraweeHierarchyBuilder(getResources()).u());
    private final int f1896d = getResources().getDimensionPixelSize(2131429624);

    private static <T extends View> void m1847a(Class<T> cls, T t) {
        m1848a((Object) t, t.getContext());
    }

    private static void m1848a(Object obj, Context context) {
        ((MinutiaeVerbRowView) obj).f1894b = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public MinutiaeVerbRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1847a(MinutiaeVerbRowView.class, (View) this);
    }

    public final MinutiaeVerbRowView m1849a(Uri uri) {
        this.f1895c.a(((FbDraweeControllerBuilder) this.f1894b.a(f1893a).b(this.f1895c.f)).b(uri).s());
        Drawable h = this.f1895c.h();
        if (h != null) {
            h.setBounds(0, 0, this.f1896d, this.f1896d);
            setCompoundDrawables(h, null, getCompoundDrawables()[2], null);
        }
        return this;
    }

    public final MinutiaeVerbRowView m1850a(String str) {
        setText(str);
        return this;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -847990628);
        super.onAttachedToWindow();
        this.f1895c.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1913533651, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1205295956);
        super.onDetachedFromWindow();
        this.f1895c.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1538728362, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f1895c.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f1895c.b();
    }

    private void m1846a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f1894b = fbDraweeControllerBuilder;
    }
}
