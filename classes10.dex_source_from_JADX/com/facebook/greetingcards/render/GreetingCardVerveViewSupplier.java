package com.facebook.greetingcards.render;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.greetingcards.render.templatefetch.TemplateResult;
import com.facebook.greetingcards.verve.VerveViewSupplier;
import com.facebook.greetingcards.verve.VerveViewSupplier.RecyclerType;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.render.VerveVideoContainer;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: xtewjdfitfiuficfiefijianfhtuptathatiatskfcxizfrojkyhadhaeeddrepteksocsodsofsossousozmbrazoazaosbveutkayderefdyzdymdyicbronkonzzoezoicbyzozxmafivkjkkjikjryzyyzzyzoivahxiwpoacyheeheahenhejuiyresxondfhitywreevogfygfggfdftwftybybodzdfyjecaaabhbodgugagypojorfpsevsepsebutzameknua_iijxchataiciacizsxdjcragoagwbvbevitrcodycupctrrdfzizxcikjgxprdbzjanjaggbietsucczgzzgwwebkricfiineinainceooregaksakkakoakabrybrinkfer_nkoerverbernfaintsntintkntokthktcyphypoemeembemoemyyevcoobnjhataigninnifykaobbxymwaiwafwawgrujvbszdhtghtcekkibosprghfsobaevzadmrjffmffiehjytwtjegjxynaynydzbyoypuregucedcepyptdictnjypunchstistrkapkazbzbstuwomkwoaddiyagszgsgeezeedrunrubwhaidefdhfdsfduna_nahnainavnazsvertibxrozbastwitjnbnyczxzeccmacmagarsmaharvbecaripyzpyiuraurturvursbiaurykemkeeothotbynfubityidmaautfhmnekmedmemmeidroxusisovysgsbtypdodhjxbarbaixfoungfnhkirkikopeophbrfxwekorjhmjhnjhtergrguhbkbodhbraynayiayeoobnyimajfeczsxgetgenfdjavopavoibbosujkoubbogrpoiukajahysabbgggggafwbeyedezderjdtdecryirycpawokuokofhvoidkonkoskoutocrbubadbdbadeikaikeradrawfuzjxtcecewjewmewgewsdgemovcuibitoeomkakmcfakiiviiodanytureapguudwuduudimismirxdgxdcshmkuibydysuiozwyekwaadbadaadmfyrfyynjanjgrchbujbuhbuipimpixoaiubakupxfcencaprrrrbgswskajybidnhotokrykrakcyntvtnukmuhzbsybeywtripjyzjyfywaywoicegisgiegidtiktifrobrofdesthdmstyjcyjgryjejaiaciayhubnevfcctkfdybaytpoiuhbyhozbdtiewbzrpiwutjudrvarviigsigiighuwafafsubangsuxankmzydfjzyjbfyupsdumswzriexsewnsrregvfusekydtatspotafkbckbpbycnfoounkvaouswhohuyiowebaedsmyimyhnomavaaymndoowsvadbcnmykmygzvfcfd */
public class GreetingCardVerveViewSupplier implements VerveViewSupplier {
    private static final CallerContext f211a = CallerContext.a(GreetingCardVerveViewSupplier.class);
    private final TemplateResult f212b;
    private final Resources f213c;
    public final ImmutableMap<String, String> f214d;
    public final Provider<MediaGalleryLauncher> f215e;

    public final <T extends Enum & RecyclerType> ImmutableSet<T> m256a() {
        return RegularImmutableSet.a;
    }

    public GreetingCardVerveViewSupplier(TemplateResult templateResult, Resources resources, ImmutableMap<String, String> immutableMap, Provider<MediaGalleryLauncher> provider) {
        this.f212b = templateResult;
        this.f213c = resources;
        this.f214d = immutableMap;
        this.f215e = provider;
    }

    public final ImageView m255a(Context context, VMView vMView) {
        return new FbDraweeView(context);
    }

    public final void m258a(VMView vMView, VMSlide vMSlide, ImmutableMap<String, String> immutableMap, @Nullable Drawable drawable, final ImageView imageView) {
        final String str = vMView.src;
        String str2 = (String) immutableMap.get(str);
        if (str2 == null || !this.f212b.f244b.containsKey(str2)) {
            FbDraweeView fbDraweeView = (FbDraweeView) imageView;
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(this.f213c);
            if (drawable != null) {
                genericDraweeHierarchyBuilder.f = drawable;
            }
            if (str != null && Uri.parse(str).isAbsolute()) {
                fbDraweeView.a(Uri.parse(str), f211a);
                if (vMView.b != null) {
                    genericDraweeHierarchyBuilder.p = vMView.b;
                    genericDraweeHierarchyBuilder.e(ScaleType.h);
                }
            }
            if ("Back".equals(vMSlide.className) && "media1".equals(vMView.valueName)) {
                genericDraweeHierarchyBuilder.u = RoundingParams.e();
            }
            fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.u());
            if (this.f214d.containsKey(str)) {
                fbDraweeView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ GreetingCardVerveViewSupplier f210c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 472477200);
                        MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory = new MediaGalleryLauncherParamsFactory();
                        Builder a2 = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(this.f210c.f214d.get(str))).a(FullscreenGallerySource.OTHER);
                        a2.m = true;
                        ((MediaGalleryLauncher) this.f210c.f215e.get()).a(imageView.getContext(), a2.b(), null);
                        Logger.a(2, EntryType.UI_INPUT_END, 1873155069, a);
                    }
                });
                return;
            }
            return;
        }
        ((FbDraweeView) imageView).a((Uri) this.f212b.f244b.get(str2), f211a);
    }

    public final <T extends View & VerveVideoContainer> T m260b(Context context, VMView vMView) {
        return null;
    }

    public final void m259a(VMView vMView, ImmutableMap<String, String> immutableMap, VerveVideoContainer verveVideoContainer) {
    }

    public final Button m261c(Context context, VMView vMView) {
        int i;
        if ("small".equals(vMView.buttonSize)) {
            if ("special".equals(vMView.buttonStyle)) {
                i = 2130772395;
            } else if ("primary".equals(vMView.buttonStyle)) {
                i = 2130772389;
            } else {
                i = 2130772383;
            }
        } else if ("medium".equals(vMView.buttonSize)) {
            if ("special".equals(vMView.buttonStyle)) {
                i = 2130772396;
            } else if ("primary".equals(vMView.buttonStyle)) {
                i = 2130772390;
            } else {
                i = 2130772384;
            }
        } else if ("special".equals(vMView.buttonStyle)) {
            i = 2130772397;
        } else if ("primary".equals(vMView.buttonStyle)) {
            i = 2130772391;
        } else {
            i = 2130772385;
        }
        Button button = new Button(context, null, i);
        if (vMView.title != null) {
            button.setText(vMView.title);
        }
        button.setPadding(0, 0, 0, 0);
        return button;
    }

    @Nullable
    public final <T extends Enum & RecyclerType> T m257a(VMView vMView) {
        return null;
    }
}
