package com.facebook.feedplugins.loadingindicator;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.impl.HasPositionInformationImpl;
import com.facebook.feedplugins.loadingindicator.LoadingStory.Type;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.Environments;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.widget.ShimmerFrameLayout;
import javax.inject.Inject;

/* compiled from: friends_center_friends_tab */
public class LoadingIndicatorManager {
    private final ShimmeringStoryPartDefinition<?> f12889a;
    private final GlowingStoryPartDefinition<?> f12890b;
    private final LoadingCoverPhotoPartDefinition f12891c;
    private final SimpleRenderer<?, HasPositionInformation, ShimmerFrameLayout> f12892d = new SimpleRenderer(this.f12889a, new HasPositionInformationImpl());
    private final SimpleRenderer<?, HasPositionInformation, GlowingStoryView> f12893e = new SimpleRenderer(this.f12890b, new HasPositionInformationImpl());
    public final SimpleRenderer<Float, AnyEnvironment, FbDraweeView> f12894f = new SimpleRenderer(this.f12891c, Environments.a);

    @Inject
    public LoadingIndicatorManager(ShimmeringStoryPartDefinition shimmeringStoryPartDefinition, GlowingStoryPartDefinition glowingStoryPartDefinition, LoadingCoverPhotoPartDefinition loadingCoverPhotoPartDefinition) {
        this.f12889a = shimmeringStoryPartDefinition;
        this.f12890b = glowingStoryPartDefinition;
        this.f12891c = loadingCoverPhotoPartDefinition;
    }

    public static ViewGroup m14647a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ViewGroup) layoutInflater.inflate(2130905110, viewGroup, false);
    }

    public final void m14648a(Type type, ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        for (int i2 = 0; i2 < i; i2++) {
            switch (type) {
                case GLOWING:
                    GlowingStoryView a = GlowingStoryPartDefinition.m14628a(context, viewGroup);
                    this.f12893e.a(a);
                    viewGroup.addView(a);
                    break;
                default:
                    ShimmerFrameLayout a2 = ShimmeringStoryPartDefinition.m14652a(context, viewGroup);
                    this.f12892d.a(a2);
                    viewGroup.addView(a2);
                    break;
            }
        }
    }

    public static int m14646a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) Math.ceil((double) (((float) displayMetrics.heightPixels) / resources.getDimension(2131429250)));
    }
}
