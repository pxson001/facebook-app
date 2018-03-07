package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.telephony.PhoneNumberUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.facebook.widget.tiles.TileBadge;
import com.facebook.widget.tiles.UserBadgeDrawable;
import com.facebook.widget.tiles.UserInitialsDrawable;
import javax.inject.Inject;

/* compiled from: qrcode_import_exception */
public class SMSContactItem extends CustomRelativeLayout {
    private static final CallerContext f4125c = CallerContext.a(SMSContactItem.class);
    @Inject
    GlyphColorizer f4126a;
    @Inject
    FbPhoneNumberUtils f4127b;
    private FbDraweeView f4128d;
    private UserInitialsDrawable f4129e;
    private TextView f4130f;
    private TextView f4131g;
    private CheckBox f4132h;
    private UserBadgeDrawable f4133i;

    private static <T extends View> void m3785a(Class<T> cls, T t) {
        m3786a((Object) t, t.getContext());
    }

    private static void m3786a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SMSContactItem) obj).m3784a(GlyphColorizer.a(fbInjector), FbPhoneNumberUtils.b(fbInjector));
    }

    public SMSContactItem(Context context) {
        super(context);
        m3783a(context, null, 0);
    }

    public SMSContactItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3783a(context, attributeSet, 0);
    }

    public SMSContactItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3783a(context, attributeSet, i);
    }

    private void m3783a(Context context, AttributeSet attributeSet, int i) {
        m3785a(SMSContactItem.class, (View) this);
        this.f4133i = new UserBadgeDrawable(context, attributeSet, i);
        this.f4133i.a(TileBadge.MESSENGER);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 346097169);
        super.onFinishInflate();
        this.f4128d = (FbDraweeView) a(2131568056);
        this.f4130f = (TextView) a(2131568057);
        this.f4131g = (TextView) a(2131568058);
        this.f4132h = (CheckBox) a(2131568059);
        FbDraweeView fbDraweeView = this.f4128d;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.u = RoundingParams.e();
        fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.e(getResources().getDrawable(2131363734)).e(ScaleType.f).u());
        this.f4132h.setOnClickListener(null);
        this.f4132h.setOnLongClickListener(null);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1358917826, a);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setContactRow(SMSLocalContactRow sMSLocalContactRow) {
        int i;
        int i2 = 0;
        ((GenericDraweeHierarchy) this.f4128d.getHierarchy()).a(m3781a(sMSLocalContactRow.f4182b), ScaleType.f);
        CharSequence b = StringUtil.c(sMSLocalContactRow.f4182b) ? this.f4127b.b(sMSLocalContactRow.f4181a) : sMSLocalContactRow.f4182b;
        CharSequence charSequence = null;
        if (!sMSLocalContactRow.f4186f) {
            charSequence = getResources().getString(2131240079);
        } else if (!(StringUtil.c(sMSLocalContactRow.f4182b) || PhoneNumberUtils.compare(sMSLocalContactRow.f4182b, sMSLocalContactRow.f4181a))) {
            charSequence = this.f4127b.b(sMSLocalContactRow.f4181a);
        }
        this.f4130f.setText(b);
        this.f4131g.setText(charSequence);
        TextView textView = this.f4131g;
        if (charSequence == null) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        this.f4132h.setChecked(sMSLocalContactRow.d());
        CheckBox checkBox = this.f4132h;
        if (!sMSLocalContactRow.f4186f) {
            i2 = 8;
        }
        checkBox.setVisibility(i2);
    }

    private void m3784a(GlyphColorizer glyphColorizer, FbPhoneNumberUtils fbPhoneNumberUtils) {
        this.f4126a = glyphColorizer;
        this.f4127b = fbPhoneNumberUtils;
    }

    public void setContactRow(SMSMatchedContactRow sMSMatchedContactRow) {
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.f4128d.getHierarchy();
        genericDraweeHierarchy.a(m3781a(sMSMatchedContactRow.f4192b), ScaleType.f);
        this.f4128d.setImageURI(sMSMatchedContactRow.f4193c);
        genericDraweeHierarchy.a(this.f4133i);
        this.f4130f.setText(sMSMatchedContactRow.f4192b);
        this.f4131g.setText(2131240078);
        this.f4131g.setVisibility(0);
        this.f4132h.setChecked(sMSMatchedContactRow.d());
    }

    private Drawable m3781a(String str) {
        return m3787b(str) ? m3788c(str) : this.f4126a.a(2130841413, -1);
    }

    private static boolean m3787b(String str) {
        return !StringUtil.c(str) && Character.isLetter(str.codePointAt(0));
    }

    private Drawable m3788c(String str) {
        m3782a();
        this.f4129e.a(Character.toUpperCase(str.codePointAt(0)));
        return this.f4129e;
    }

    private void m3782a() {
        if (this.f4129e == null) {
            this.f4129e = new UserInitialsDrawable();
            this.f4129e.a((float) getResources().getDimensionPixelSize(2131433333));
            UserInitialsDrawable userInitialsDrawable = this.f4129e;
            userInitialsDrawable.a.setTypeface(CustomFontHelper.a(getContext(), FontFamily.ROBOTO, FontWeight.LIGHT, null));
            userInitialsDrawable = this.f4129e;
            userInitialsDrawable.a.setStyle(Style.FILL);
            this.f4129e.b(-1);
        }
    }
}
