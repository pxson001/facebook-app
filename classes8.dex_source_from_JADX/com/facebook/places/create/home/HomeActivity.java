package com.facebook.places.create.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.places.common.MockDeps;
import com.facebook.places.create.privacypicker.PrivacyPickerActivity;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: cards */
public abstract class HomeActivity extends FbFragmentActivity {
    public static final CallerContext f18272y = CallerContext.a(HomeActivity.class);
    private EditText f18273A;
    private EditText f18274B;
    private FrameLayout f18275C;
    public RelativeLayout f18276D;
    private ImageView f18277E;
    public FbDraweeView f18278F;
    private RelativeLayout f18279G;
    private ImageView f18280H;
    private TextView f18281I;
    private final OnToolbarButtonListener f18282J = new C19841(this);
    private final OnBackPressedListener f18283K = new C19852(this);
    private final OnDismissListener f18284L = new C19863(this);
    public HomeActivityModel f18285p;
    protected ComposerTitleBar f18286q;
    protected EditText f18287r;
    protected TextView f18288s;
    protected ImageView f18289t;
    @Inject
    public SecureContextHelper f18290u;
    @Inject
    @LoggedInUser
    public Provider<User> f18291v;
    @Inject
    public HomeActivityLogger f18292w;
    @Inject
    public PrivacyIcons f18293x;
    public MenuPopoverState f18294z;

    /* compiled from: cards */
    class C19841 extends OnToolbarButtonListener {
        final /* synthetic */ HomeActivity f18259a;

        C19841(HomeActivity homeActivity) {
            this.f18259a = homeActivity;
        }

        public final void m22215a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f18259a.f18292w.m22262t();
            this.f18259a.m22232o();
            this.f18259a.mo1092l();
        }
    }

    /* compiled from: cards */
    class C19852 implements OnBackPressedListener {
        final /* synthetic */ HomeActivity f18260a;

        C19852(HomeActivity homeActivity) {
            this.f18260a = homeActivity;
        }

        public final void m22216a() {
            this.f18260a.onBackPressed();
        }
    }

    /* compiled from: cards */
    class C19863 implements OnDismissListener {
        final /* synthetic */ HomeActivity f18261a;

        C19863(HomeActivity homeActivity) {
            this.f18261a = homeActivity;
        }

        public final boolean m22217a(PopoverWindow popoverWindow) {
            this.f18261a.f18294z = MenuPopoverState.CLOSED;
            return true;
        }
    }

    /* compiled from: cards */
    class C19874 implements OnClickListener {
        final /* synthetic */ HomeActivity f18262a;

        C19874(HomeActivity homeActivity) {
            this.f18262a = homeActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 715132399);
            this.f18262a.f18292w.m22256n();
            if (this.f18262a.f18285p.f18316i == null) {
                HomeActivity homeActivity = this.f18262a;
                homeActivity.m22232o();
                homeActivity.f18290u.a(SimplePickerIntent.a(homeActivity.getApplicationContext(), new Builder(SimplePickerSource.PLACES_HOME).h().i().a(Action.NONE)), 11, homeActivity);
            } else {
                HomeActivity.m22220v(this.f18262a);
            }
            LogUtils.a(-1150733319, a);
        }
    }

    /* compiled from: cards */
    class C19885 implements OnClickListener {
        final /* synthetic */ HomeActivity f18263a;

        C19885(HomeActivity homeActivity) {
            this.f18263a = homeActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1376263362);
            this.f18263a.f18292w.m22254l();
            HomeActivity homeActivity = this.f18263a;
            homeActivity.m22232o();
            Intent intent = new Intent(homeActivity, PrivacyPickerActivity.class);
            FlatBufferModelHelper.a(intent, "extra_initial_privacy", homeActivity.f18285p.f18314g);
            homeActivity.f18290u.a(intent, 13, homeActivity);
            Logger.a(2, EntryType.UI_INPUT_END, -1072310183, a);
        }
    }

    /* compiled from: cards */
    class C19896 implements Runnable {
        final /* synthetic */ HomeActivity f18264a;

        C19896(HomeActivity homeActivity) {
            this.f18264a = homeActivity;
        }

        public void run() {
            HomeActivity.m22220v(this.f18264a);
        }
    }

    /* compiled from: cards */
    class C19907 implements OnMenuItemClickListener {
        final /* synthetic */ HomeActivity f18265a;

        C19907(HomeActivity homeActivity) {
            this.f18265a = homeActivity;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18265a.f18292w.m22258p();
            HomeActivity homeActivity = this.f18265a;
            homeActivity.m22232o();
            homeActivity.f18290u.a(SimplePickerIntent.a(homeActivity.getApplicationContext(), new Builder(SimplePickerSource.PLACES_HOME).h().i().a(Action.NONE)), 11, homeActivity);
            return true;
        }
    }

    /* compiled from: cards */
    class C19918 implements OnMenuItemClickListener {
        final /* synthetic */ HomeActivity f18266a;

        C19918(HomeActivity homeActivity) {
            this.f18266a = homeActivity;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18266a.f18292w.m22257o();
            this.f18266a.mo1097r();
            return true;
        }
    }

    /* compiled from: cards */
    public class HomeFocusListener implements OnFocusChangeListener {
        public final /* synthetic */ HomeActivity f18268a;
        private View f18269b;

        public HomeFocusListener(HomeActivity homeActivity, View view) {
            this.f18268a = homeActivity;
            this.f18269b = view;
        }

        public void onFocusChange(View view, boolean z) {
            int id = this.f18269b.getId();
            if (id == 2131562901) {
                if (z) {
                    this.f18268a.f18292w.m22248f();
                } else {
                    this.f18268a.f18292w.m22249g();
                }
            } else if (id == 2131562907) {
                if (z) {
                    this.f18268a.f18292w.m22246d();
                } else {
                    this.f18268a.f18292w.m22247e();
                }
            } else if (id == 2131562906) {
                if (z) {
                    this.f18268a.f18292w.m22250h();
                } else {
                    this.f18268a.f18292w.m22251i();
                }
            }
        }
    }

    /* compiled from: cards */
    class HomeTextWatcher implements TextWatcher {
        final /* synthetic */ HomeActivity f18270a;
        private View f18271b;

        public HomeTextWatcher(HomeActivity homeActivity, View view) {
            this.f18270a = homeActivity;
            this.f18271b = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int id = this.f18271b.getId();
            if (id == 2131562901) {
                this.f18270a.f18285p.f18308a = editable.toString();
            } else if (id == 2131562907) {
                this.f18270a.f18285p.f18310c = editable.toString();
            } else if (id == 2131562906) {
                this.f18270a.f18285p.f18311d = editable.toString();
            }
        }
    }

    /* compiled from: cards */
    enum MenuPopoverState {
        CLOSED,
        PHOTO
    }

    public static void m22218a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        HomeActivity homeActivity = (HomeActivity) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        Provider a = IdBasedProvider.a(injectorLike, 3595);
        HomeActivityLogger b = HomeActivityLogger.m22238b(injectorLike);
        PrivacyIcons a2 = PrivacyIcons.a(injectorLike);
        homeActivity.f18290u = secureContextHelper;
        homeActivity.f18291v = a;
        homeActivity.f18292w = b;
        homeActivity.f18293x = a2;
    }

    protected abstract String mo1089i();

    protected abstract void mo1090j();

    protected abstract HomeActivityLoggerData mo1091k();

    protected abstract void mo1092l();

    protected void mo1088c(Bundle bundle) {
    }

    public final void m22223b(Bundle bundle) {
        HomeActivityLoggerData k;
        boolean z;
        setContentView(2130904786);
        Class cls = HomeActivity.class;
        m22218a(this, this);
        MockDeps.a(this);
        if (bundle == null) {
            Preconditions.checkArgument(getIntent().hasExtra("home_activity_entry_flow"));
            mo1090j();
            k = mo1091k();
            k.f18302a = SafeUUIDGenerator.a().toString();
            this.f18294z = MenuPopoverState.CLOSED;
            z = false;
        } else {
            this.f18285p = (HomeActivityModel) bundle.getParcelable("state_home_creation_model");
            k = (HomeActivityLoggerData) bundle.getParcelable("state_home_creation_logger_data");
            this.f18294z = (MenuPopoverState) bundle.getSerializable("state_menu_popover");
            z = bundle.getBoolean("state_loading_view");
        }
        Preconditions.checkNotNull(k);
        this.f18292w.f18301e = k;
        this.f18292w.f18299c = this.f18285p;
        if (bundle == null) {
            this.f18292w.m22243b();
        }
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(this.f18283K);
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = mo1089i();
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        this.f18286q = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
        ComposerTitleBar composerTitleBar = this.f18286q;
        StateBuilder a = this.f18286q.b.a();
        TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.a();
        a2.g = getString(2131235281);
        a.b = a2.a();
        a = a;
        a.c = this.f18282J;
        composerTitleBar.a(a.a());
        this.f18275C = (FrameLayout) a(2131559308);
        if (z) {
            m22233p();
        }
        this.f18276D = (RelativeLayout) a(2131562903);
        this.f18278F = (FbDraweeView) this.f18276D.findViewById(2131561267);
        this.f18277E = (ImageView) this.f18276D.findViewById(2131562900);
        this.f18277E.setOnClickListener(new C19874(this));
        this.f18287r = (EditText) a(2131562901);
        this.f18287r.addTextChangedListener(new HomeTextWatcher(this, this.f18287r));
        this.f18287r.setOnFocusChangeListener(new HomeFocusListener(this, this.f18287r));
        this.f18287r.setSelection(this.f18287r.getText().length());
        this.f18287r.requestFocus();
        this.f18273A = (EditText) a(2131562906);
        this.f18273A.addTextChangedListener(new HomeTextWatcher(this, this.f18273A));
        this.f18274B = (EditText) a(2131562907);
        this.f18274B.addTextChangedListener(new HomeTextWatcher(this, this.f18274B));
        this.f18288s = (TextView) a(2131562904);
        this.f18289t = (ImageView) a(2131562905);
        this.f18279G = (RelativeLayout) a(2131562908);
        this.f18279G.setOnClickListener(new C19885(this));
        this.f18280H = (ImageView) this.f18279G.findViewById(2131560951);
        this.f18281I = (TextView) this.f18279G.findViewById(2131565983);
        if (this.f18294z != MenuPopoverState.CLOSED) {
            switch (this.f18294z) {
                case PHOTO:
                    this.f18276D.post(new C19896(this));
                    break;
            }
        }
        m22230m();
        mo1088c(bundle);
    }

    public final void m22230m() {
        if (this.f18285p.f18308a != null) {
            this.f18287r.setText(this.f18285p.f18308a);
        }
        if (this.f18285p.f18310c != null) {
            this.f18274B.setText(this.f18285p.f18310c);
        }
        if (this.f18285p.f18311d != null) {
            this.f18273A.setText(this.f18285p.f18311d);
        }
        m22221w();
        mo1093n();
        m22219s();
    }

    protected void mo1093n() {
        if (this.f18285p.f18309b != null) {
            this.f18288s.setText(this.f18285p.f18309b);
        } else {
            this.f18288s.setText(getResources().getString(2131235203));
        }
    }

    private void m22219s() {
        if (this.f18285p.f18314g != null) {
            this.f18280H.setImageResource(this.f18293x.a(PrivacyOptionHelper.a(this.f18285p.f18314g), Size.LIST));
            this.f18281I.setText(this.f18285p.f18314g.d());
        }
    }

    public final void m22232o() {
        this.f18287r.clearFocus();
        this.f18274B.clearFocus();
        this.f18273A.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    protected final void m22224b(boolean z) {
        this.f18286q.a(this.f18286q.b.a().a(z).a());
        this.f18286q.b.a().a(z);
    }

    protected final void m22233p() {
        this.f18275C.setVisibility(0);
        this.f18275C.bringToFront();
    }

    public final void m22234q() {
        this.f18275C.setVisibility(8);
    }

    public static void m22220v(HomeActivity homeActivity) {
        homeActivity.m22232o();
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(homeActivity);
        PopoverMenu c = figPopoverMenuWindow.c();
        MenuItemImpl a = c.a(2131235239);
        a.setIcon(2130842607);
        a.setOnMenuItemClickListener(new C19907(homeActivity));
        MenuItemImpl a2 = c.a(2131235240);
        a2.setIcon(2130843014);
        a2.setOnMenuItemClickListener(new C19918(homeActivity));
        homeActivity.f18294z = MenuPopoverState.PHOTO;
        figPopoverMenuWindow.H = homeActivity.f18284L;
        figPopoverMenuWindow.a(homeActivity.f18277E);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11) {
            if (i2 == -1) {
                List parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
                if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                    mo1095a((PhotoItem) parcelableArrayListExtra.get(0));
                    return;
                }
                return;
            }
            this.f18292w.m22260r();
        } else if (i == 13 && i2 == -1) {
            this.f18285p.f18314g = (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "selected_privacy");
            this.f18292w.m22255m();
            m22219s();
        }
    }

    protected void mo1095a(PhotoItem photoItem) {
        this.f18292w.m22259q();
        this.f18285p.f18315h = photoItem;
        this.f18285p.f18316i = Uri.fromFile(new File(this.f18285p.f18315h.e()));
        m22221w();
    }

    protected void mo1097r() {
        this.f18285p.f18315h = null;
        this.f18285p.f18316i = null;
        m22221w();
    }

    private void m22221w() {
        if (this.f18285p.f18316i == null) {
            this.f18278F.a(null, f18272y);
            this.f18278F.setVisibility(8);
            this.f18276D.getLayoutParams().height = (int) getResources().getDimension(2131429995);
            this.f18276D.requestLayout();
            return;
        }
        this.f18278F.setVisibility(0);
        this.f18278F.a(this.f18285p.f18316i, f18272y);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f18292w.m22245c();
        bundle.putParcelable("state_home_creation_model", this.f18285p);
        bundle.putParcelable("state_home_creation_logger_data", this.f18292w.f18301e);
        bundle.putSerializable("state_menu_popover", this.f18294z);
        bundle.putBoolean("state_loading_view", this.f18275C.getVisibility() == 0);
    }

    public void onBackPressed() {
        m22232o();
        this.f18292w.m22261s();
        super.onBackPressed();
    }
}
