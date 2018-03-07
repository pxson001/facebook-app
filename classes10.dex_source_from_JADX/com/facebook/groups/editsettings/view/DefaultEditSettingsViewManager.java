package com.facebook.groups.editsettings.view;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.groups.create.coverphoto.GroupsCoverPhotoHandler;
import com.facebook.groups.editsettings.adapter.GroupEditSettingsAdapterRows;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.preferenceview.SwitchWithDescriptionView;
import com.facebook.groups.widget.preferenceview.delegates.SwitchPreferenceDelegate;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: USE_CURRENT_FETCH */
public class DefaultEditSettingsViewManager {
    public final Resources f21782a;
    public final Lazy<GroupsCoverPhotoHandler> f21783b;
    public final GlyphColorizer f21784c;

    /* compiled from: USE_CURRENT_FETCH */
    public class C31062 extends AbstractSection<LinearLayout> {
        final /* synthetic */ String f21773a;
        final /* synthetic */ String f21774b;
        final /* synthetic */ OnClickListener f21775c;
        final /* synthetic */ DefaultEditSettingsViewManager f21776d;

        public C31062(DefaultEditSettingsViewManager defaultEditSettingsViewManager, ViewType viewType, String str, String str2, OnClickListener onClickListener) {
            this.f21776d = defaultEditSettingsViewManager;
            this.f21773a = str;
            this.f21774b = str2;
            this.f21775c = onClickListener;
            super(viewType);
        }

        public final void mo11a(View view) {
            LinearLayout linearLayout = (LinearLayout) view;
            FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131562719);
            if (StringUtil.a(this.f21773a)) {
                fbDraweeView.setImageDrawable(this.f21776d.f21784c.a(2130840646, this.f21776d.f21782a.getColor(2131361917), false));
            } else {
                fbDraweeView.setImageURI(Uri.parse(this.f21773a));
            }
            if (!StringUtil.a(this.f21774b)) {
                ((FbTextView) linearLayout.findViewById(2131562720)).setText(this.f21774b);
            }
            linearLayout.setOnClickListener(this.f21775c);
        }
    }

    /* compiled from: USE_CURRENT_FETCH */
    public class C31073 extends AbstractSection<SwitchWithDescriptionView> {
        final /* synthetic */ SwitchPreferenceDelegate f21777a;
        final /* synthetic */ String f21778b;
        final /* synthetic */ DefaultEditSettingsViewManager f21779c;

        public C31073(DefaultEditSettingsViewManager defaultEditSettingsViewManager, ViewType viewType, SwitchPreferenceDelegate switchPreferenceDelegate, String str) {
            this.f21779c = defaultEditSettingsViewManager;
            this.f21777a = switchPreferenceDelegate;
            this.f21778b = str;
            super(viewType);
        }

        public final void mo11a(View view) {
            SwitchWithDescriptionView switchWithDescriptionView = (SwitchWithDescriptionView) view;
            switchWithDescriptionView.setDelegate(this.f21777a);
            switchWithDescriptionView.setSwitchDesciption(this.f21778b);
        }
    }

    public static DefaultEditSettingsViewManager m22884b(InjectorLike injectorLike) {
        return new DefaultEditSettingsViewManager(ResourcesMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 6876), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public DefaultEditSettingsViewManager(Resources resources, Lazy<GroupsCoverPhotoHandler> lazy, GlyphColorizer glyphColorizer) {
        this.f21782a = resources;
        this.f21783b = lazy;
        this.f21784c = glyphColorizer;
    }

    public final ImmutableList<Section> m22886a(String str, CharSequence charSequence, OnClickListener onClickListener) {
        Builder builder = ImmutableList.builder();
        final String str2 = str;
        final OnClickListener onClickListener2 = onClickListener;
        final CharSequence charSequence2 = charSequence;
        builder.c(new AbstractSection<LinearLayout>(this, GroupEditSettingsAdapterRows.f21614f) {
            final /* synthetic */ DefaultEditSettingsViewManager f21772d;

            public final void mo11a(View view) {
                LinearLayout linearLayout = (LinearLayout) view;
                BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131562714);
                betterTextView.setText(str2);
                linearLayout.setOnClickListener(onClickListener2);
                betterTextView.setOnClickListener(onClickListener2);
                SimpleAccessibleTextLayoutView simpleAccessibleTextLayoutView = (SimpleAccessibleTextLayoutView) linearLayout.findViewById(2131562713);
                if (charSequence2 != null) {
                    simpleAccessibleTextLayoutView.setVisibility(0);
                    simpleAccessibleTextLayoutView.f21785a = new TextLayoutBuilder().c(this.f21772d.f21782a.getColor(2131363507)).a(charSequence2).b(this.f21772d.f21782a.getDimensionPixelSize(2131427402));
                    return;
                }
                simpleAccessibleTextLayoutView.setVisibility(8);
            }
        });
        return builder.b();
    }

    public final ImmutableList<Section> m22885a(int i) {
        switch (i) {
            case 1:
                return m22883a(this.f21782a.getString(2131242115));
            case 2:
                return m22883a(this.f21782a.getString(2131242114));
            case 3:
                return m22883a(this.f21782a.getString(2131242116));
            default:
                return null;
        }
    }

    private ImmutableList<Section> m22883a(final String str) {
        Builder builder = ImmutableList.builder();
        builder.c(new StaticSection(GroupEditSettingsAdapterRows.f21616h));
        builder.c(new AbstractSection<BetterTextView>(this, GroupEditSettingsAdapterRows.f21609a) {
            final /* synthetic */ DefaultEditSettingsViewManager f21781b;

            public final void mo11a(View view) {
                ((BetterTextView) view).setText(str);
            }
        });
        return builder.b();
    }
}
