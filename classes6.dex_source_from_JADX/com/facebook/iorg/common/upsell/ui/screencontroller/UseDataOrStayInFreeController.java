package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.upsell.ui.handlers.UpsellDontShowAgainHandler;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: locale not supported  */
public class UseDataOrStayInFreeController extends AbstractUpsellDialogScreenController {
    public final IorgFb4aAnalyticsLogger f11444c;
    public UpsellDontShowAgainHandler f11445d;
    public boolean f11446e = false;

    /* compiled from: locale not supported  */
    class C07272 implements OnCheckedChangeListener {
        final /* synthetic */ UseDataOrStayInFreeController f11439a;

        C07272(UseDataOrStayInFreeController useDataOrStayInFreeController) {
            this.f11439a = useDataOrStayInFreeController;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f11439a.f11446e = z;
        }
    }

    /* compiled from: locale not supported  */
    class C07283 implements OnClickListener {
        final /* synthetic */ UseDataOrStayInFreeController f11440a;

        C07283(UseDataOrStayInFreeController useDataOrStayInFreeController) {
            this.f11440a = useDataOrStayInFreeController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1815992951);
            if (this.f11440a.f11446e) {
                this.f11440a.f11445d.mo1072a(this.f11440a.f11391a.ar);
            }
            this.f11440a.f11391a.aq();
            Logger.a(2, EntryType.UI_INPUT_END, -616012100, a);
        }
    }

    @Inject
    public UseDataOrStayInFreeController(UpsellDontShowAgainHandler upsellDontShowAgainHandler, IorgFb4aAnalyticsLogger iorgFb4aAnalyticsLogger) {
        this.f11445d = upsellDontShowAgainHandler;
        this.f11444c = iorgFb4aAnalyticsLogger;
    }

    public final View mo1077a(Context context) {
        String str;
        OnClickListener a;
        View upsellDialogView = new UpsellDialogView(context);
        ZeroRecommendedPromoResult zeroRecommendedPromoResult = this.f11391a.aw;
        if (zeroRecommendedPromoResult == null) {
            str = "";
        } else {
            str = zeroRecommendedPromoResult.f11321D;
        }
        if (Strings.isNullOrEmpty(str)) {
            a = m18186a(Screen.PROMOS_LIST);
        } else {
            a = new OnClickListener(this) {
                final /* synthetic */ UseDataOrStayInFreeController f11438b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1403476152);
                    this.f11438b.f11444c.a(UpsellsAnalyticsEvent.m);
                    this.f11438b.f11391a.a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    Logger.a(2, EntryType.UI_INPUT_END, -581640881, a);
                }
            };
        }
        Resources resources = context.getResources();
        CharSequence charSequence = null;
        if (!(zeroRecommendedPromoResult == null || a == null || Strings.isNullOrEmpty(zeroRecommendedPromoResult.f11323b) || Strings.isNullOrEmpty(zeroRecommendedPromoResult.f11326e))) {
            String[] split = zeroRecommendedPromoResult.f11323b.split(zeroRecommendedPromoResult.f11326e);
            if (split.length == 2) {
                final int color = resources.getColor(2131362664);
                charSequence = new StyledStringBuilder(resources).a(split[0]).a(new ClickableSpan(this) {
                    final /* synthetic */ UseDataOrStayInFreeController f11443c;

                    public void onClick(View view) {
                        a.onClick(view);
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(color);
                        textPaint.setUnderlineText(false);
                    }
                }, 33).a(zeroRecommendedPromoResult.f11326e).a().a(split[1]).b();
            }
        }
        CharSequence charSequence2 = charSequence;
        UpsellDialogViewModel upsellDialogViewModel = new UpsellDialogViewModel();
        upsellDialogViewModel.f11270r = this.f11391a.ax();
        upsellDialogViewModel = upsellDialogViewModel;
        if (charSequence2 != null) {
            UpsellDialogViewModel b = upsellDialogViewModel.m18127a(this.f11391a.b(2131232872), mo1079d()).m18129b(this.f11391a.b(2131232866), m18191c());
            b.f11256d = charSequence2;
            b.m18125a(Boolean.valueOf(true));
        } else {
            upsellDialogViewModel.m18127a(this.f11391a.b(2131232872), mo1079d()).m18129b(this.f11391a.b(2131232866), m18191c()).m18130c(this.f11391a.b(2131232871), a);
        }
        if (this.f11445d.mo1073b(this.f11391a.ar)) {
            upsellDialogViewModel.f11268p = new C07272(this);
        }
        if (zeroRecommendedPromoResult != null) {
            upsellDialogViewModel.f11271s = zeroRecommendedPromoResult.f11325d;
            upsellDialogViewModel.m18126a(zeroRecommendedPromoResult.f11322a).f11255c = zeroRecommendedPromoResult.f11323b;
        }
        upsellDialogView.m18174a(upsellDialogViewModel);
        return upsellDialogView;
    }

    protected final OnClickListener mo1079d() {
        return new C07283(this);
    }
}
