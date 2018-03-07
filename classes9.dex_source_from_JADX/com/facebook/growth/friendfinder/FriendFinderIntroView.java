package com.facebook.growth.friendfinder;

import android.content.Context;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterLinkMovementMethod;
import java.util.List;
import javax.inject.Inject;

/* compiled from: password and accountType cannot both be set */
public class FriendFinderIntroView extends CustomLinearLayout {
    private static final CallerContext f7245b = CallerContext.a(FriendFinderIntroView.class);
    @Inject
    public BetterLinkMovementMethod f7246a;
    public FriendFinderIntroViewListener f7247c;
    private FacepileView f7248d;
    private TextView f7249e;
    private View f7250f;
    private TextView f7251g;
    private TextView f7252h;

    /* compiled from: password and accountType cannot both be set */
    public interface FriendFinderIntroViewListener {
        void mo282a();

        void mo283b();

        void mo284c();

        void mo285d();
    }

    /* compiled from: password and accountType cannot both be set */
    class C07831 implements OnClickListener {
        final /* synthetic */ FriendFinderIntroView f7240a;

        C07831(FriendFinderIntroView friendFinderIntroView) {
            this.f7240a = friendFinderIntroView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 74751076);
            if (this.f7240a.f7247c != null) {
                this.f7240a.f7247c.mo282a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 804557840, a);
        }
    }

    /* compiled from: password and accountType cannot both be set */
    class C07842 extends ClickableSpan {
        final /* synthetic */ FriendFinderIntroView f7241a;

        C07842(FriendFinderIntroView friendFinderIntroView) {
            this.f7241a = friendFinderIntroView;
        }

        public void onClick(View view) {
            if (this.f7241a.f7247c != null) {
                this.f7241a.f7247c.mo285d();
            }
        }
    }

    /* compiled from: password and accountType cannot both be set */
    class C07853 extends ClickableSpan {
        final /* synthetic */ FriendFinderIntroView f7242a;

        C07853(FriendFinderIntroView friendFinderIntroView) {
            this.f7242a = friendFinderIntroView;
        }

        public void onClick(View view) {
            if (this.f7242a.f7247c != null) {
                this.f7242a.f7247c.mo283b();
            }
        }
    }

    /* compiled from: password and accountType cannot both be set */
    class C07864 extends ClickableSpan {
        final /* synthetic */ FriendFinderIntroView f7243a;

        C07864(FriendFinderIntroView friendFinderIntroView) {
            this.f7243a = friendFinderIntroView;
        }

        public void onClick(View view) {
            if (this.f7243a.f7247c != null) {
                this.f7243a.f7247c.mo284c();
            }
        }
    }

    /* compiled from: password and accountType cannot both be set */
    public enum Theme {
        CURRENT,
        NEW_STYLE_DOUBLE_STEP,
        NEW_STYLE_SINGLE_STEP,
        DAILY_DIALOGUE_STYLE,
        REJECT_REG_TERMS_DOUBLE_STEP,
        REJECT_REG_TERMS_DD_STYLE
    }

    private static <T extends View> void m7529a(Class<T> cls, T t) {
        m7530a((Object) t, t.getContext());
    }

    private static void m7530a(Object obj, Context context) {
        ((FriendFinderIntroView) obj).f7246a = BetterLinkMovementMethod.a(FbInjector.get(context));
    }

    private void m7528a(BetterLinkMovementMethod betterLinkMovementMethod) {
        this.f7246a = betterLinkMovementMethod;
    }

    public FriendFinderIntroView(Context context) {
        super(context);
        m7531b();
    }

    public FriendFinderIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7531b();
    }

    protected FriendFinderIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7531b();
    }

    private void m7531b() {
        m7529a(FriendFinderIntroView.class, (View) this);
    }

    public void setIntroViewTheme(Theme theme) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        switch (theme) {
            case NEW_STYLE_SINGLE_STEP:
                i = 2131236393;
                i2 = 2131236401;
                i3 = 2131236405;
                i4 = 2130903802;
                i5 = 2131236397;
                break;
            case NEW_STYLE_DOUBLE_STEP:
                i = 2131236392;
                i2 = 2131236400;
                i3 = 2131236405;
                i4 = 2130903802;
                i5 = 2131236396;
                break;
            case DAILY_DIALOGUE_STYLE:
                i = 2131236392;
                i2 = 2131236400;
                i3 = 2131236405;
                i4 = 2130904609;
                i5 = 2131236396;
                break;
            case REJECT_REG_TERMS_DOUBLE_STEP:
                i = 2131236394;
                i2 = 2131236400;
                i3 = 2131236406;
                i4 = 2130903802;
                i5 = 2131236398;
                break;
            case REJECT_REG_TERMS_DD_STYLE:
                i = 2131236394;
                i2 = 2131236400;
                i3 = 2131236406;
                i4 = 2130904609;
                i5 = 2131236398;
                break;
            default:
                i = 2131236391;
                i2 = 2131236399;
                i3 = 2131236405;
                i4 = 2130904473;
                i5 = 2131236395;
                break;
        }
        setContentView(i4);
        this.f7251g = (TextView) a(2131562252);
        this.f7252h = (TextView) a(2131562253);
        this.f7248d = (FacepileView) a(2131562254);
        this.f7249e = (TextView) a(2131562255);
        this.f7250f = a(2131562256);
        TextView textView = (TextView) a(2131560794);
        Button button = (Button) a(2131560795);
        this.f7251g.setText(i);
        this.f7252h.setText(i5);
        button.setText(i3);
        button.setOnClickListener(new C07831(this));
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        if (theme == Theme.NEW_STYLE_DOUBLE_STEP || theme == Theme.DAILY_DIALOGUE_STYLE || theme == Theme.REJECT_REG_TERMS_DOUBLE_STEP || theme == Theme.REJECT_REG_TERMS_DD_STYLE) {
            styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(getResources().getString(i2), "{SETTINGS_TOKEN}", "{MANAGE_OR_DELETE_TOKEN}", "{LEARN_MORE_TOKEN}"));
            styledStringBuilder.a("{SETTINGS_TOKEN}", getResources().getString(2131236403), new C07842(this), 33);
        } else {
            if (theme == Theme.NEW_STYLE_SINGLE_STEP) {
                this.f7251g.setGravity(83);
                this.f7252h.setGravity(3);
            }
            styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(getResources().getString(i2), "{MANAGE_OR_DELETE_TOKEN}", "{LEARN_MORE_TOKEN}"));
        }
        styledStringBuilder.a("{MANAGE_OR_DELETE_TOKEN}", getResources().getString(2131236402), new C07853(this), 33);
        styledStringBuilder.a("{LEARN_MORE_TOKEN}", getResources().getString(2131236404), new C07864(this), 33);
        textView.setMovementMethod(this.f7246a);
        textView.setText(styledStringBuilder.b());
    }

    public void setFriendFinderIntroViewListener(FriendFinderIntroViewListener friendFinderIntroViewListener) {
        this.f7247c = friendFinderIntroViewListener;
    }

    public void setFacepileFaces(List<Uri> list) {
        this.f7248d.setFaceUrls(list);
    }

    public final void m7535a(List<String> list, int i) {
        int size = list.size();
        if (size == 2) {
            this.f7249e.setText(getResources().getString(2131233247, new Object[]{list.get(0), list.get(1)}));
        } else if (size == 3) {
            this.f7249e.setText(getResources().getString(2131233248, new Object[]{list.get(0), list.get(1), list.get(2)}));
        } else {
            this.f7249e.setText(getResources().getString(2131233249, new Object[]{list.get(0), list.get(1), Integer.valueOf(i - 2)}));
        }
    }

    public final void m7534a(String str, String str2) {
        this.f7251g.setText(str);
        this.f7252h.setText(str2);
    }

    public final void m7533a(String str, int i, int i2) {
        m7527a((FbDraweeView) a(2131560864), str, i, i2);
    }

    public final void m7536b(String str, int i, int i2) {
        m7527a((FbDraweeView) a(2131562576), str, i, i2);
    }

    private static void m7527a(FbDraweeView fbDraweeView, String str, int i, int i2) {
        if (str != null) {
            LayoutParams layoutParams = (LayoutParams) fbDraweeView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i;
            fbDraweeView.setVisibility(0);
            fbDraweeView.a(Uri.parse(str), f7245b);
        }
    }

    public final void m7532a() {
        this.f7248d.setVisibility(8);
        this.f7249e.setVisibility(8);
        this.f7250f.setVisibility(0);
    }
}
