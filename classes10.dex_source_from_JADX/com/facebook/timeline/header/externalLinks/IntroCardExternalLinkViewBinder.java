package com.facebook.timeline.header.externalLinks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ExternalLinkModel;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: filter_fragment_tag */
public class IntroCardExternalLinkViewBinder {
    private static IntroCardExternalLinkViewBinder f11694b;
    private static final Object f11695c = new Object();
    public final SecureContextHelper f11696a;

    private static IntroCardExternalLinkViewBinder m11767b(InjectorLike injectorLike) {
        return new IntroCardExternalLinkViewBinder((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public IntroCardExternalLinkViewBinder(SecureContextHelper secureContextHelper) {
        this.f11696a = secureContextHelper;
    }

    public final void m11768a(IntroCardExternalLinkView introCardExternalLinkView, ExternalLinkModel externalLinkModel) {
        Uri uri;
        introCardExternalLinkView.f11691c.setText(m11763a(introCardExternalLinkView.getContext(), externalLinkModel));
        if (m11766a(externalLinkModel)) {
            introCardExternalLinkView.f11690b.a(Uri.parse(externalLinkModel.a().b()), IntroCardExternalLinkView.f11689a);
        } else {
            introCardExternalLinkView.f11690b.setVisibility(8);
        }
        if (externalLinkModel.d() == null) {
            uri = null;
        } else {
            uri = Uri.parse(externalLinkModel.d());
        }
        if (uri != null) {
            introCardExternalLinkView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ IntroCardExternalLinkViewBinder f11693b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -398096953);
                    this.f11693b.f11696a.b(new Intent("android.intent.action.VIEW", uri), view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1879007398, a);
                }
            });
            return;
        }
        introCardExternalLinkView.setOnClickListener(null);
        CustomViewUtils.b(introCardExternalLinkView, ContextCompat.a(introCardExternalLinkView.getContext(), 2130839567));
    }

    public static IntroCardExternalLinkViewBinder m11762a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            IntroCardExternalLinkViewBinder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11695c) {
                IntroCardExternalLinkViewBinder introCardExternalLinkViewBinder;
                if (a2 != null) {
                    introCardExternalLinkViewBinder = (IntroCardExternalLinkViewBinder) a2.a(f11695c);
                } else {
                    introCardExternalLinkViewBinder = f11694b;
                }
                if (introCardExternalLinkViewBinder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11767b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11695c, b3);
                        } else {
                            f11694b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = introCardExternalLinkViewBinder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    private CharSequence m11763a(Context context, ExternalLinkModel externalLinkModel) {
        String a = externalLinkModel.b() == null ? null : externalLinkModel.b().a();
        if (m11766a(externalLinkModel)) {
            return externalLinkModel.c();
        }
        return m11765a(a, externalLinkModel.c(), context);
    }

    private static boolean m11766a(ExternalLinkModel externalLinkModel) {
        return (externalLinkModel.a() == null || externalLinkModel.a().b() == null) ? false : true;
    }

    @Nullable
    private CharSequence m11765a(String str, String str2, Context context) {
        if (str == null && str2 == null) {
            return null;
        }
        if (str == null) {
            return str2;
        }
        Spannable spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 == null) {
            return m11764a(spannableStringBuilder, 0, context);
        }
        spannableStringBuilder.append(": ").append(str2);
        return m11764a(spannableStringBuilder, str2.length(), context);
    }

    private static CharSequence m11764a(Spannable spannable, int i, Context context) {
        spannable.setSpan(new ForegroundColorSpan(ContextCompat.b(context, 2131361937)), 0, spannable.length() - i, 33);
        return spannable;
    }
}
