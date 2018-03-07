package com.facebook.greetingcards.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.camera.ipc.CameraIntentBuilder;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {friendsSelectorExcluded -1} */
public class GreetingCardEditorActivity extends FbFragmentActivity {
    public CanDisplayCardPhoto f79A;
    private boolean f80B = false;
    private SecureContextHelper f81p;
    private CameraIntentBuilder f82q;
    private IFeedIntentBuilder f83r;
    private MediaItemFactory f84s;
    private GreetingCardThemeGrid f85t;
    public GreetingCardCoverPhotoView f86u;
    private EditText f87v;
    private ViewStub f88w;
    public final ArrayList<MomentSwitcher> f89x = Lists.a();
    public GreetingCardSelfieView f90y;
    private EditText f91z;

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00081 implements WantsGalleryListener {
        final /* synthetic */ GreetingCardEditorActivity f67a;

        C00081(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f67a = greetingCardEditorActivity;
        }

        public final void mo2a() {
            this.f67a.f79A = this.f67a.f86u;
            this.f67a.m82a(this.f67a.f86u);
        }
    }

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00092 implements WantsGalleryListener {
        final /* synthetic */ GreetingCardEditorActivity f68a;

        C00092(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f68a = greetingCardEditorActivity;
        }

        public final void mo2a() {
            this.f68a.f79A = this.f68a.f90y;
            this.f68a.m82a(this.f68a.f90y);
        }
    }

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00114 implements OnMenuItemClickListener {
        final /* synthetic */ GreetingCardEditorActivity f74a;

        C00114(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f74a = greetingCardEditorActivity;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GreetingCardEditorActivity.m103p(this.f74a);
            return true;
        }
    }

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00125 implements OnMenuItemClickListener {
        final /* synthetic */ GreetingCardEditorActivity f75a;

        C00125(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f75a = greetingCardEditorActivity;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GreetingCardEditorActivity.m101n(this.f75a);
            return true;
        }
    }

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00136 implements OnMenuItemClickListener {
        final /* synthetic */ GreetingCardEditorActivity f76a;

        C00136(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f76a = greetingCardEditorActivity;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GreetingCardEditorActivity.m102o(this.f76a);
            return true;
        }
    }

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00147 extends OnToolbarButtonListener {
        final /* synthetic */ GreetingCardEditorActivity f77a;

        public final void m78a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (titleBarButtonSpec.c == 0) {
                GreetingCardEditorActivity.m105r(this.f77a);
            }
        }

        C00147(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f77a = greetingCardEditorActivity;
        }
    }

    /* compiled from: {friendsSelectorExcluded -1} */
    class C00158 implements OnClickListener {
        final /* synthetic */ GreetingCardEditorActivity f78a;

        C00158(GreetingCardEditorActivity greetingCardEditorActivity) {
            this.f78a = greetingCardEditorActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            super.onBackPressed();
        }
    }

    private static <T extends Context> void m86a(Class<T> cls, T t) {
        m87a((Object) t, (Context) t);
    }

    public static void m87a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GreetingCardEditorActivity) obj).m83a(CameraIntentBuilder.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), MediaItemFactory.b(fbInjector));
    }

    public static Intent m79a(Context context, GreetingCard greetingCard) {
        Intent intent = new Intent(context, GreetingCardEditorActivity.class);
        intent.putExtra("args_greeting_card", greetingCard);
        return intent;
    }

    @Inject
    private void m83a(CameraIntentBuilder cameraIntentBuilder, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, MediaItemFactory mediaItemFactory) {
        this.f82q = cameraIntentBuilder;
        this.f81p = secureContextHelper;
        this.f83r = iFeedIntentBuilder;
        this.f84s = mediaItemFactory;
    }

    public final void m106b(Bundle bundle) {
        super.b(bundle);
        Class cls = GreetingCardEditorActivity.class;
        m87a((Object) this, (Context) this);
        GreetingCard greetingCard = getIntent().getExtras() == null ? null : (GreetingCard) getIntent().getExtras().getParcelable("args_greeting_card");
        Preconditions.checkNotNull(greetingCard);
        setContentView(2130904781);
        m104q();
        this.f85t = (GreetingCardThemeGrid) a(2131562890);
        this.f86u = (GreetingCardCoverPhotoView) a(2131562888);
        this.f87v = (EditText) a(2131562889);
        this.f88w = (ViewStub) a(2131562891);
        this.f90y = (GreetingCardSelfieView) a(2131562892);
        this.f91z = (EditText) a(2131562893);
        m96i();
        m97j();
        m85a(greetingCard);
    }

    private void m96i() {
        ViewGroup viewGroup = (ViewGroup) this.f88w.getParent();
        int indexOfChild = viewGroup.indexOfChild(this.f88w);
        viewGroup.removeView(this.f88w);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434017);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131434019);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(2131434018);
        int i = indexOfChild;
        for (int i2 = 0; i2 < 8; i2++) {
            View momentSwitcher = new MomentSwitcher(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
            momentSwitcher.setLayoutParams(layoutParams);
            indexOfChild = i + 1;
            viewGroup.addView(momentSwitcher, i);
            this.f89x.add(momentSwitcher);
            if (i2 < 7) {
                View view = new View(this, null, 2131626514);
                view.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361940)));
                view.setVisibility(8);
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, dimensionPixelSize2);
                layoutParams2.topMargin = dimensionPixelSize3;
                layoutParams2.bottomMargin = dimensionPixelSize3;
                view.setLayoutParams(layoutParams2);
                i = indexOfChild + 1;
                viewGroup.addView(view, indexOfChild);
            } else {
                i = indexOfChild;
            }
            if (i2 > 0) {
                momentSwitcher.setVisibility(8);
            }
        }
    }

    private void m97j() {
        int i;
        this.f86u.f63b = new C00081(this);
        for (i = 0; i < 8; i++) {
            m89b(i);
        }
        this.f90y.f95c = new C00092(this);
        i = getResources().getInteger(2131492960) - 1;
        int integer = getResources().getInteger(2131492961) - 1;
        this.f87v.addTextChangedListener(new CharLimitNotifier(this, this.f87v, i, getResources().getString(2131241466, new Object[]{Integer.valueOf(i)})));
        this.f91z.addTextChangedListener(new CharLimitNotifier(this, this.f91z, integer, getResources().getString(2131241467, new Object[]{Integer.valueOf(integer)})));
    }

    private void m89b(int i) {
        final MomentSwitcher momentSwitcher = (MomentSwitcher) this.f89x.get(i);
        final ViewGroup viewGroup = (ViewGroup) momentSwitcher.getParent();
        final int indexOfChild = viewGroup.indexOfChild(momentSwitcher);
        final int i2 = i;
        C00103 c00103 = new Object(this) {
            final /* synthetic */ GreetingCardEditorActivity f73e;

            public final void m75a() {
                this.f73e.f79A = momentSwitcher;
                this.f73e.m82a(momentSwitcher);
            }

            public final void m76b() {
                momentSwitcher.m144b();
                if (i2 > 0 && !((MomentSwitcher) this.f73e.f89x.get(i2 - 1)).m143a()) {
                    viewGroup.getChildAt(indexOfChild - 1).setVisibility(8);
                    momentSwitcher.setVisibility(8);
                }
                if (i2 < 7) {
                    MomentSwitcher momentSwitcher = (MomentSwitcher) this.f73e.f89x.get(i2 + 1);
                    if (!momentSwitcher.m143a()) {
                        momentSwitcher.m144b();
                        viewGroup.getChildAt(indexOfChild + 1).setVisibility(8);
                        momentSwitcher.setVisibility(8);
                    }
                }
            }

            public final void m77c() {
                if (i2 < 7) {
                    viewGroup.getChildAt(indexOfChild + 1).setVisibility(0);
                    viewGroup.getChildAt(indexOfChild + 2).setVisibility(0);
                }
            }
        };
        momentSwitcher.f129a = c00103;
        momentSwitcher.f131c.f142g = c00103;
    }

    private void m85a(@Nullable GreetingCard greetingCard) {
        if (greetingCard != null) {
            if (greetingCard.a != null) {
                if (!greetingCard.a.c.isEmpty()) {
                    this.f86u.mo1a((CardPhoto) greetingCard.a.c.get(0));
                }
                this.f87v.setText(greetingCard.a.a);
            }
            int size = greetingCard.b.size();
            Preconditions.checkPositionIndex(size, 8);
            for (int i = 0; i < size; i++) {
                ((MomentSwitcher) this.f89x.get(i)).setSlide((Slide) greetingCard.b.get(i));
            }
            if (greetingCard.c != null) {
                if (!greetingCard.c.c.isEmpty()) {
                    this.f90y.mo1a((CardPhoto) greetingCard.c.c.get(0));
                }
                this.f91z.setText(greetingCard.c.a);
            }
            if (greetingCard.d != null) {
                this.f85t.m120a(greetingCard.d);
                if (greetingCard.e != null) {
                    this.f85t.setSelectedTheme(greetingCard.e);
                }
            }
            m99l();
        }
    }

    private GreetingCard m98k() {
        ImmutableList immutableList;
        String obj = this.f87v.getText().toString();
        String str = "";
        if (this.f86u.f66e == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.of(this.f86u.f66e);
        }
        Slide slide = new Slide(obj, str, immutableList);
        Builder builder = ImmutableList.builder();
        int size = this.f89x.size();
        for (int i = 0; i < size; i++) {
            MomentSwitcher momentSwitcher = (MomentSwitcher) this.f89x.get(i);
            if (momentSwitcher.m143a()) {
                Slide slide2;
                if (momentSwitcher.getDisplayedChild() == 0) {
                    slide2 = null;
                } else {
                    slide2 = momentSwitcher.f131c.getComposedSlide();
                }
                builder.c(slide2);
            }
        }
        obj = this.f91z.getText().toString();
        String str2 = "";
        if (this.f90y.f96d == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.of(this.f90y.f96d);
        }
        return new GreetingCard(slide, builder.b(), new Slide(obj, str2, immutableList), this.f85t.f103d, this.f85t.f104e, null);
    }

    private void m99l() {
        if (!this.f80B && this.f86u.f66e != null) {
            m100m();
        }
    }

    private void m100m() {
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.a = 0;
        a = a;
        a.g = getResources().getString(2131241448);
        a = a;
        a.d = true;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        this.f80B = true;
    }

    private void m82a(View view) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this);
        PopoverMenu c = figPopoverMenuWindow.c();
        if (view instanceof GreetingCardSelfieView) {
            c.a(2131241445).setOnMenuItemClickListener(new C00114(this));
        }
        c.a(2131241446).setOnMenuItemClickListener(new C00125(this));
        c.a(2131241449).setOnMenuItemClickListener(new C00136(this));
        figPopoverMenuWindow.a(view);
    }

    public static void m101n(GreetingCardEditorActivity greetingCardEditorActivity) {
        greetingCardEditorActivity.f81p.a(greetingCardEditorActivity.f83r.b(greetingCardEditorActivity, FBLinks.dS), 9913, greetingCardEditorActivity);
    }

    public static void m102o(GreetingCardEditorActivity greetingCardEditorActivity) {
        greetingCardEditorActivity.f81p.a(SimplePickerIntent.a(greetingCardEditorActivity.getApplicationContext(), new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.HOLIDAY_CARDS).h().i().a(Action.NONE)), 7, greetingCardEditorActivity);
    }

    public static void m103p(GreetingCardEditorActivity greetingCardEditorActivity) {
        CameraIntentBuilder cameraIntentBuilder = greetingCardEditorActivity.f82q;
        cameraIntentBuilder.e.putExtra("extra_no_composer", true);
        cameraIntentBuilder = cameraIntentBuilder.b(true).a(1).c(true);
        cameraIntentBuilder.b = greetingCardEditorActivity;
        greetingCardEditorActivity.f81p.a(cameraIntentBuilder.a(), 6, greetingCardEditorActivity);
    }

    private void m104q() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        fbTitleBar.setTitle(getResources().getString(2131241447));
        fbTitleBar.setHasBackButton(true);
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.a = 0;
        a = a;
        a.g = getResources().getString(2131241448);
        a = a;
        a.d = false;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fbTitleBar.setOnToolbarButtonListener(new C00147(this));
    }

    public static void m105r(GreetingCardEditorActivity greetingCardEditorActivity) {
        Intent intent = new Intent();
        intent.putExtra("args_greeting_card", greetingCardEditorActivity.m98k());
        greetingCardEditorActivity.setResult(-1, intent);
        greetingCardEditorActivity.finish();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this).b(2131230727, null).a(2131241461, new C00158(this)).b(getResources().getString(2131241460)).b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("card", m98k());
        super.onSaveInstanceState(bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 6 && i2 == 5) {
            MediaItem a = this.f84s.a(CameraActivity.i(), FallbackMediaId.DEFAULT);
            if (a == null) {
                BLog.b(getClass(), "Mediaitem is null");
                return;
            }
            this.f79A.mo1a(CardPhoto.a(a));
        } else if (i2 == -1 && i == 7) {
            this.f79A.mo1a(CardPhoto.a((MediaItem) intent.getParcelableArrayListExtra("extra_media_items").get(0)));
        } else if (i2 == -1 && i == 9913) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) FlatBufferModelHelper.a(intent, "photo");
            if (graphQLPhoto == null) {
                throw new IllegalStateException("PICKER_RESULT_PHOTO is not passed for greeting card");
            }
            this.f79A.mo1a(CardPhoto.a(ImageUtil.a(graphQLPhoto.L()), graphQLPhoto.K(), graphQLPhoto.G() == null ? null : new PointF((float) graphQLPhoto.G().a(), (float) graphQLPhoto.G().b())));
        }
        if (this.f79A == this.f86u) {
            m99l();
        }
    }
}
