package com.facebook.backgroundlocation.privacypicker;

import android.content.Context;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.privacy.ui.PrivacyIcons;
import javax.inject.Inject;

/* compiled from: doDbFetch */
public class BackgroundLocationPrivacyPickerOptionView extends ImageBlockLayout {
    @Inject
    public PrivacyIcons f14848h;
    public GlyphView f14849i = ((GlyphView) getView(2131559814));
    public TextView f14850j = ((TextView) getView(2131559815));

    public static void m15295a(Object obj, Context context) {
        ((BackgroundLocationPrivacyPickerOptionView) obj).f14848h = PrivacyIcons.a(FbInjector.get(context));
    }

    public BackgroundLocationPrivacyPickerOptionView(Context context) {
        super(context, null);
        Class cls = BackgroundLocationPrivacyPickerOptionView.class;
        m15295a(this, getContext());
        setContentView(2130903343);
        setThumbnailGravity(16);
        setGravity(16);
        setPadding(getResources().getDimensionPixelSize(2131427416), 0, 0, 0);
    }
}
