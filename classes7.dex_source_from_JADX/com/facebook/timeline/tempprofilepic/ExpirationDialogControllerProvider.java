package com.facebook.timeline.tempprofilepic;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: facecast_reactions_toggle_off */
public class ExpirationDialogControllerProvider extends AbstractAssistedProvider<ExpirationDialogController> {
    public final ExpirationDialogController m18776a(long j) {
        return new ExpirationDialogController((Context) getInstance(Context.class), (ExpirationDialogModelProvider) getOnDemandAssistedProviderForStaticDi(ExpirationDialogModelProvider.class), ExpirationDialogViewBinder.m18790b(this), new ExpirationDialogNumberPickersViewBinder(ResourcesMethodAutoProvider.a(this)), AllCapsTransformationMethod.b(this), GlyphColorizer.a(this), j);
    }
}
