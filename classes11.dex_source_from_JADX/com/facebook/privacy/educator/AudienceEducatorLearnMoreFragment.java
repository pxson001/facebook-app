package com.facebook.privacy.educator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;

/* compiled from: STORY_ID */
public final class AudienceEducatorLearnMoreFragment extends FbFragment {
    public SecureContextHelper f11282a;
    public AudienceEducatorType f11283b;
    private View f11284c;
    private View f11285d;

    /* compiled from: STORY_ID */
    class C13641 implements OnClickListener {
        final /* synthetic */ AudienceEducatorLearnMoreFragment f11279a;

        C13641(AudienceEducatorLearnMoreFragment audienceEducatorLearnMoreFragment) {
            this.f11279a = audienceEducatorLearnMoreFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1256928372);
            this.f11279a.ao().finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1446462320, a);
        }
    }

    /* compiled from: STORY_ID */
    public class C13652 extends ClickableSpan {
        final /* synthetic */ AudienceEducatorLearnMoreFragment f11280a;

        public C13652(AudienceEducatorLearnMoreFragment audienceEducatorLearnMoreFragment) {
            this.f11280a = audienceEducatorLearnMoreFragment;
        }

        public void onClick(View view) {
            String formatStrLocaleSafe;
            AudienceEducatorLearnMoreFragment audienceEducatorLearnMoreFragment = this.f11280a;
            Intent intent = new Intent();
            switch (C13663.f11281a[audienceEducatorLearnMoreFragment.f11283b.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode("https://m.facebook.com/help/android-app/120939471321735"));
                    break;
                default:
                    formatStrLocaleSafe = "";
                    break;
            }
            intent.setData(Uri.parse(formatStrLocaleSafe));
            audienceEducatorLearnMoreFragment.f11282a.a(intent, audienceEducatorLearnMoreFragment.getContext());
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f11280a.jW_().getColor(2131361975));
        }
    }

    /* compiled from: STORY_ID */
    public /* synthetic */ class C13663 {
        public static final /* synthetic */ int[] f11281a = new int[AudienceEducatorType.values().length];

        static {
            try {
                f11281a[AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11281a[AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11281a[AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m11656a(Object obj, Context context) {
        ((AudienceEducatorLearnMoreFragment) obj).f11282a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public final void m11661c(Bundle bundle) {
        super.c(bundle);
        Class cls = AudienceEducatorLearnMoreFragment.class;
        m11656a(this, getContext());
        this.f11283b = (AudienceEducatorType) this.s.getSerializable("extra_audience_educator_type");
        if (this.f11283b == null || this.f11283b == AudienceEducatorType.NONE) {
            this.f11283b = AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR;
        }
    }

    public final View m11660a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1321029054);
        this.f11284c = layoutInflater.inflate(2130903311, null);
        this.f11285d = this.f11284c.findViewById(2131559737);
        this.f11285d.setOnClickListener(new C13641(this));
        View view = this.f11284c;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1645955458, a);
        return view;
    }

    public final void m11659G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2125721490);
        super.G();
        m11657b(this.f11284c);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -728881349, a);
    }

    private void m11657b(View view) {
        int i;
        TextView textView = (TextView) view.findViewById(2131559738);
        switch (C13663.f11281a[this.f11283b.ordinal()]) {
            case 1:
            case 2:
                textView.setText(new StyledStringBuilder(jW_()).a(new StyleSpan(1), 33).a(2131242421).a().a("\n\n").a(2131242422).b());
                break;
            case 3:
                m11658b(textView);
                break;
            default:
                return;
        }
        switch (C13663.f11281a[this.f11283b.ordinal()]) {
            case 1:
                i = 2131242423;
                break;
            case 2:
                i = 2131242431;
                break;
            case 3:
                i = 2131242445;
                break;
            default:
        }
        TextView textView2 = (TextView) view.findViewById(2131559739);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(new StyledStringBuilder(jW_()).a(i).a("%1$s", b(2131234233), new C13652(this), 33).b());
    }

    private void m11658b(TextView textView) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(m11655a(2131242438, 2131242439, 2131242438, new StyleSpan(1)));
        spannableStringBuilder.append("\n\n\n");
        spannableStringBuilder.append(m11655a(2131242440, 2131242441, 2131242440, new StyleSpan(1)));
        spannableStringBuilder.append("\n\n\n");
        spannableStringBuilder.append(m11655a(2131242442, 2131242443, 2131242444, new StyleSpan(1)));
        textView.setText(spannableStringBuilder);
    }

    private CharSequence m11655a(int i, int i2, int i3, Object obj) {
        return new StyledStringBuilder(jW_()).a(new StyleSpan(1), 33).a(i).a().a("\n\n").a(new StyledStringBuilder(jW_()).a(i2).a("%1$s", b(i3), obj, 33).b()).b();
    }
}
