package com.facebook.events.create.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: conference_call_button */
public class EventHostSelector extends CustomFrameLayout implements OnClickListener {
    private String f16360a;
    private String f16361b;
    private Drawable f16362c;
    private boolean f16363d;
    private String f16364e;
    public int f16365f;
    private boolean f16366g;
    private GlyphView f16367h;
    private FbTextView f16368i;
    private MetricAffectingSpan f16369j;
    private MetricAffectingSpan f16370k;
    private Provider<ComponentName> f16371l;
    private SecureContextHelper f16372m;

    private static <T extends View> void m16832a(Class<T> cls, T t) {
        m16833a((Object) t, t.getContext());
    }

    private static void m16833a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventHostSelector) obj).m16834a(IdBasedProvider.a(fbInjector, 12), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    public EventHostSelector(Context context) {
        super(context);
        m16830a();
    }

    public EventHostSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16830a();
    }

    public EventHostSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16830a();
    }

    @Inject
    private void m16834a(@FragmentChromeActivity Provider<ComponentName> provider, SecureContextHelper secureContextHelper) {
        this.f16372m = secureContextHelper;
        this.f16371l = provider;
    }

    private void m16830a() {
        m16832a(EventHostSelector.class, (View) this);
        setContentView(2130904024);
        this.f16367h = (GlyphView) c(2131561271);
        this.f16368i = (FbTextView) c(2131561272);
        this.f16369j = new TextAppearanceSpan(getContext(), 2131625738);
        this.f16370k = new TextAppearanceSpan(getContext(), 2131625739);
        setOnClickListener(this);
    }

    public final void m16837a(String str, String str2, boolean z, boolean z2) {
        this.f16364e = str;
        this.f16360a = str2;
        this.f16361b = getResources().getString(2131236929);
        this.f16363d = z;
        this.f16362c = getStartDrawable();
        this.f16366g = z2;
        m16835b();
    }

    private Drawable getStartDrawable() {
        if (this.f16363d) {
            return getResources().getDrawable(2130839509);
        }
        return getResources().getDrawable(2130839533);
    }

    private void m16835b() {
        this.f16367h.setImageDrawable(this.f16362c);
        this.f16368i.setText(getHostText());
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private SpannableStringBuilder getHostText() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!StringUtil.a(this.f16360a)) {
            m16831a(spannableStringBuilder, this.f16360a, this.f16369j, 17);
        }
        if (!StringUtil.a(this.f16361b)) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n");
            }
            m16831a(spannableStringBuilder, this.f16361b, this.f16370k, 17);
        }
        return spannableStringBuilder;
    }

    private static void m16831a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj, int i) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), i);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1628245199);
        if (this.f16366g) {
            m16836e();
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1969368579, a);
    }

    private void m16836e() {
        Intent component = new Intent().setComponent((ComponentName) this.f16371l.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENT_CREATE_HOST_SELECTION_FRAGMENT.ordinal());
        component.putExtra("extra_event_host_id", this.f16364e);
        this.f16372m.a(component, this.f16365f, (Activity) ContextUtils.a(getContext(), Activity.class));
    }

    public void setEventHostSelectionActivityId(int i) {
        this.f16365f = i;
    }
}
