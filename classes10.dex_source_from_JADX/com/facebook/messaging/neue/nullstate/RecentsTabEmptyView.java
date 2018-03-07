package com.facebook.messaging.neue.nullstate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: richtext_element_start */
public class RecentsTabEmptyView extends CustomViewGroup {
    @Inject
    @IsWorkBuild
    public Boolean f3356a;
    @Nullable
    public RecentsTabEmptyViewListener f3357b;

    /* compiled from: richtext_element_start */
    class C05421 implements OnClickListener {
        final /* synthetic */ RecentsTabEmptyView f3354a;

        C05421(RecentsTabEmptyView recentsTabEmptyView) {
            this.f3354a = recentsTabEmptyView;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -359525870, Logger.a(2, EntryType.UI_INPUT_START, 1292859379));
        }
    }

    /* compiled from: richtext_element_start */
    class C05432 implements OnClickListener {
        final /* synthetic */ RecentsTabEmptyView f3355a;

        C05432(RecentsTabEmptyView recentsTabEmptyView) {
            this.f3355a = recentsTabEmptyView;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -1189500701, Logger.a(2, EntryType.UI_INPUT_START, -767159569));
        }
    }

    private static <T extends View> void m3266a(Class<T> cls, T t) {
        m3267a((Object) t, t.getContext());
    }

    private static void m3267a(Object obj, Context context) {
        ((RecentsTabEmptyView) obj).f3356a = Boolean_IsWorkBuildMethodAutoProvider.a(FbInjector.get(context));
    }

    public RecentsTabEmptyView(Context context) {
        super(context);
        m3263a();
    }

    public RecentsTabEmptyView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3263a();
    }

    public RecentsTabEmptyView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3263a();
    }

    public void setListener(RecentsTabEmptyViewListener recentsTabEmptyViewListener) {
        this.f3357b = recentsTabEmptyViewListener;
    }

    private void m3263a() {
        m3266a(RecentsTabEmptyView.class, (View) this);
        setContentView(2130905788);
        String string = getContext().getString(this.f3356a.booleanValue() ? 2131240951 : 2131240950);
        String string2 = getContext().getString(2131240952);
        TextView textView = (TextView) getView(2131564993);
        TextView textView2 = (TextView) getView(2131564994);
        Drawable drawable = getResources().getDrawable(2130842229);
        Drawable drawable2 = getResources().getDrawable(2130842095);
        m3264a(textView, string, drawable);
        m3264a(textView2, string2, drawable2);
        textView.setOnClickListener(new C05421(this));
        textView2.setOnClickListener(new C05432(this));
    }

    private void m3265a(Boolean bool) {
        this.f3356a = bool;
    }

    private void m3264a(TextView textView, String str, Drawable drawable) {
        CharSequence spannableString = new SpannableString(str);
        float applyDimension = TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        float applyDimension2 = TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics());
        drawable.setBounds(0, 0, (int) applyDimension, (int) applyDimension);
        PaddedDrawableSpan paddedDrawableSpan = new PaddedDrawableSpan(drawable, (int) applyDimension2, (int) applyDimension2);
        String str2 = " [[icon]] ";
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            str2 = "[[icon]]";
            indexOf = str.indexOf(str2);
        }
        int length = str2.length() + indexOf;
        if (indexOf != -1) {
            spannableString.setSpan(paddedDrawableSpan, indexOf, length, 18);
        }
        applyDimension = (-(applyDimension - textView.getTextSize())) / 3.0f;
        spannableString.setSpan(new VerticalOffsetScriptSpan((int) applyDimension), 0, indexOf, 18);
        spannableString.setSpan(new VerticalOffsetScriptSpan((int) applyDimension), length, spannableString.length(), 18);
        textView.setText(spannableString);
        textView.setText(spannableString);
    }
}
