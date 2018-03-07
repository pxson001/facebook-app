package com.facebook.platform.composer.titlebar;

import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: result_place_search_suggestion */
public class PlatformComposerTargetImageController {
    public final PrivacyIcons f4406a;
    public final CallerContext f4407b = CallerContext.a(PlatformComposerTargetImageController.class);
    public final View f4408c;
    public final View f4409d;
    public final FbDraweeView f4410e = ((FbDraweeView) this.f4409d.findViewById(2131566129));
    public final GlyphView f4411f = ((GlyphView) this.f4408c.findViewById(2131566127));
    public final GlyphView f4412g = ((GlyphView) this.f4408c.findViewById(2131566128));

    @Inject
    public PlatformComposerTargetImageController(@Assisted View view, @Assisted View view2, Provider<User> provider, PrivacyIcons privacyIcons) {
        this.f4406a = privacyIcons;
        this.f4409d = view;
        this.f4408c = view2;
        Uri parse = Uri.parse(((User) provider.get()).x());
        ((FbDraweeView) this.f4409d.findViewById(2131566126)).a(parse, this.f4407b);
        ((FbDraweeView) this.f4408c.findViewById(2131566126)).a(parse, this.f4407b);
    }

    public final void m4288a(ComposerTargetData composerTargetData, ComposerPrivacyData composerPrivacyData) {
        if (composerTargetData.targetType == TargetType.USER) {
            this.f4409d.setVisibility(0);
            this.f4408c.setVisibility(8);
            this.f4410e.a(Uri.parse(composerTargetData.targetProfilePicUrl), this.f4407b);
            return;
        }
        this.f4409d.setVisibility(8);
        this.f4408c.setVisibility(0);
        this.f4410e.a(null, this.f4407b);
        if (composerPrivacyData.b != null && composerPrivacyData.b.a != null && composerPrivacyData.b.d.l() != null) {
            GlyphView glyphView;
            GraphQLPrivacyOptionType fromIconName = GraphQLPrivacyOptionType.fromIconName(composerPrivacyData.b.d.l().d());
            if (fromIconName == GraphQLPrivacyOptionType.EVERYONE) {
                this.f4411f.setVisibility(8);
                this.f4412g.setVisibility(0);
                glyphView = this.f4412g;
            } else {
                this.f4411f.setVisibility(0);
                this.f4412g.setVisibility(8);
                glyphView = this.f4411f;
            }
            glyphView.setImageDrawable(glyphView.getResources().getDrawable(this.f4406a.a(fromIconName, Size.GLYPH)));
        } else if (composerPrivacyData.a != null) {
            ComposerFixedPrivacyData composerFixedPrivacyData = composerPrivacyData.a;
            this.f4411f.setVisibility(0);
            this.f4412g.setVisibility(8);
            this.f4411f.setImageDrawable(this.f4411f.getResources().getDrawable(this.f4406a.a(composerFixedPrivacyData.a, Size.PILL)));
        }
    }
}
