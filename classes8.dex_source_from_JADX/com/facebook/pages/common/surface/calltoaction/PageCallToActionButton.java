package com.facebook.pages.common.surface.calltoaction;

import android.content.Context;
import android.os.ParcelUuid;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.BindModel;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.CallToActionClickState;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.CallToActionDesignState;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.OnDispatchDrawListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: creation_create_succeeded */
public class PageCallToActionButton extends CustomLinearLayout {
    @Inject
    CallToActionButtonHandler f16619a;
    @Inject
    InterstitialManager f16620b;
    private FbTextView f16621c;
    private GlyphView f16622d;
    private BindModel f16623e;

    /* compiled from: creation_create_succeeded */
    class C17971 implements OnClickListener {
        final /* synthetic */ PageCallToActionButton f16616a;

        C17971(PageCallToActionButton pageCallToActionButton) {
            this.f16616a = pageCallToActionButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -837880055);
            this.f16616a.f16619a.mo1017a();
            Logger.a(2, EntryType.UI_INPUT_END, -1125070309, a);
        }
    }

    /* compiled from: creation_create_succeeded */
    public interface CallToActionButtonHandler {
        BindModel mo1016a(PageHeaderData pageHeaderData);

        void mo1017a();

        void mo1018a(ParcelUuid parcelUuid);

        OnDispatchDrawListener mo1019b();
    }

    private static <T extends View> void m19657a(Class<T> cls, T t) {
        m19658a((Object) t, t.getContext());
    }

    private static void m19658a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PageCallToActionButton) obj).m19656a((CallToActionButtonHandler) PageCallToActionButtonController.m19671b(injectorLike), InterstitialManager.a(injectorLike));
    }

    public PageCallToActionButton(Context context) {
        super(context);
        m19655a();
    }

    public PageCallToActionButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19655a();
    }

    public PageCallToActionButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19655a();
    }

    private void m19655a() {
        m19657a(PageCallToActionButton.class, (View) this);
        setContentView(2130905969);
        this.f16621c = (FbTextView) a(2131565373);
        this.f16622d = (GlyphView) a(2131565374);
        a(this.f16619a.mo1019b());
    }

    public final void m19666a(PageHeaderData pageHeaderData) {
        TracerDetour.a("PageCallToActionButton.bindModel", 1360864789);
        try {
            this.f16623e = this.f16619a.mo1016a(pageHeaderData);
            if (this.f16623e.f16653f == CallToActionClickState.NOT_CLICKABLE) {
                setOnClickListener(null);
                return;
            }
            m19659b();
            m19660c();
            m19661d();
            m19662e();
            m19665h();
            setOnClickListener(new C17971(this));
            TracerDetour.a(1870484423);
        } finally {
            TracerDetour.a(884483843);
        }
    }

    public void setLoggingUuid(ParcelUuid parcelUuid) {
        this.f16619a.mo1018a(parcelUuid);
    }

    private void m19659b() {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (this.f16623e.f16654g == CallToActionDesignState.WIDE) {
            layoutParams.height = getResources().getDimensionPixelSize(2131432973);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(2131432974);
        }
        setLayoutParams(layoutParams);
    }

    private void m19660c() {
        if (this.f16623e.f16654g == CallToActionDesignState.WIDE) {
            CustomViewUtils.b(this, getResources().getDrawable(2130842435));
        } else {
            CustomViewUtils.b(this, getResources().getDrawable(2130842438));
        }
    }

    private void m19661d() {
        if (this.f16623e.f16654g == CallToActionDesignState.NARROW) {
            this.f16621c.setTextSize((float) SizeUtil.c(getResources(), 2131427400));
        }
        this.f16621c.setText((CharSequence) this.f16623e.f16650c.get());
    }

    private void m19662e() {
        switch (this.f16623e.f16649b) {
            case PENCIL:
                this.f16622d.setVisibility(0);
                m19663f();
                return;
            case LEAVE_APP:
                this.f16622d.setVisibility(0);
                m19664g();
                return;
            case HIDDEN:
                this.f16622d.setVisibility(8);
                return;
            default:
                return;
        }
    }

    private void m19663f() {
        this.f16622d.setImageDrawable(getResources().getDrawable(2130838470));
    }

    private void m19664g() {
        this.f16622d.setImageDrawable(getResources().getDrawable(2130841038));
    }

    private void m19665h() {
        String str = "";
        String string;
        switch (this.f16623e.f16652e) {
            case AUTO_PROVISION_SHOP_CTA:
                string = getResources().getString(2131239591);
                break;
            case AUTO_PROVISION_MESSENGER_CTA:
                string = getResources().getString(2131239592);
                break;
            case AUTO_PROVISION_CALL_CTA:
                string = getResources().getString(2131239593, new Object[]{this.f16623e.f16648a, this.f16623e.f16651d.get()});
                break;
            case CREATE_CTA:
                string = getResources().getString(2131239589);
                break;
            case EDIT_CTA:
                string = getResources().getString(2131239590);
                break;
            case NONE:
                return;
            default:
                Object obj = str;
                break;
        }
        PageCallToActionButtonNuxController pageCallToActionButtonNuxController = (PageCallToActionButtonNuxController) this.f16620b.a(new InterstitialTrigger(Action.PAGE_CALL_TO_ACTION_BUTTON), PageCallToActionButtonNuxController.class);
        if (pageCallToActionButtonNuxController != null && !StringUtil.a(obj)) {
            PageCallToActionButtonNuxController.a(this, this.f16621c, getContext(), obj);
            this.f16620b.a().a(pageCallToActionButtonNuxController.b());
        }
    }

    private void m19656a(CallToActionButtonHandler callToActionButtonHandler, InterstitialManager interstitialManager) {
        this.f16619a = callToActionButtonHandler;
        this.f16620b = interstitialManager;
    }
}
