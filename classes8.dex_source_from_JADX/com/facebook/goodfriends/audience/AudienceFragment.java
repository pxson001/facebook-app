package com.facebook.goodfriends.audience;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.Event;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@UriMatchPatterns(fragment = ContentFragmentType.GOODFRIENDS_AUDIENCE_FRAGMENT)
/* compiled from: fetch_place_photos */
public class AudienceFragment extends FbFragment implements CanHandleBackPressed {
    public static final String f13405a = AudienceFragment.class.getSimpleName();
    private EditText al;
    public String am;
    public Handler an;
    private boolean ao;
    private Fb4aTitleBar ap;
    public ProgressDialog aq;
    public boolean ar = true;
    @Inject
    public AudienceRecyclerAdapterProvider f13406b;
    @Inject
    public Fb4aTitleBarSupplier f13407c;
    @Inject
    public GoodFriendsAnalyticsLogger f13408d;
    public final Runnable f13409e = new C14251(this);
    public final C14262 f13410f = new C14262(this);
    public AudienceRecyclerAdapter f13411g;
    private RecyclerView f13412h;
    public GridLayoutManager f13413i;

    /* compiled from: fetch_place_photos */
    class C14251 implements Runnable {
        final /* synthetic */ AudienceFragment f13399a;

        C14251(AudienceFragment audienceFragment) {
            this.f13399a = audienceFragment;
        }

        public void run() {
            this.f13399a.f13411g.m15047a(this.f13399a.am);
        }
    }

    /* compiled from: fetch_place_photos */
    public class C14262 {
        public final /* synthetic */ AudienceFragment f13400a;

        C14262(AudienceFragment audienceFragment) {
            this.f13400a = audienceFragment;
        }
    }

    /* compiled from: fetch_place_photos */
    class C14273 extends SpanSizeLookup {
        final /* synthetic */ AudienceFragment f13401b;

        C14273(AudienceFragment audienceFragment) {
            this.f13401b = audienceFragment;
        }

        public final int m15030a(int i) {
            AudienceRecyclerAdapter audienceRecyclerAdapter = this.f13401b.f13411g;
            return AudienceRecyclerAdapter.m15041e(i, this.f13401b.f13413i.c);
        }
    }

    /* compiled from: fetch_place_photos */
    class C14284 implements TextWatcher {
        final /* synthetic */ AudienceFragment f13402a;

        C14284(AudienceFragment audienceFragment) {
            this.f13402a = audienceFragment;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f13402a.am = charSequence.toString();
            HandlerDetour.a(this.f13402a.an, this.f13402a.f13409e);
            HandlerDetour.b(this.f13402a.an, this.f13402a.f13409e, 300, 1259362909);
            this.f13402a.f13408d.m15026a(Event.PICKER_SEARCH);
        }
    }

    /* compiled from: fetch_place_photos */
    class C14305 extends OnToolbarButtonListener {
        final /* synthetic */ AudienceFragment f13404a;

        /* compiled from: fetch_place_photos */
        class C14291 implements OnClickListener {
            final /* synthetic */ C14305 f13403a;

            C14291(C14305 c14305) {
                this.f13403a = c14305;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13403a.f13404a.aq.a(this.f13403a.f13404a.b(2131236185));
                this.f13403a.f13404a.aq.setCancelable(false);
                this.f13403a.f13404a.aq.show();
                this.f13403a.f13404a.f13411g.m15046a(this.f13403a.f13404a.f13410f);
            }
        }

        C14305(AudienceFragment audienceFragment) {
            this.f13404a = audienceFragment;
        }

        public final void m15031a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (!this.f13404a.ar || this.f13404a.f13411g.f13427o >= 5) {
                this.f13404a.f13411g.m15046a(this.f13404a.f13410f);
                return;
            }
            this.f13404a.ar = false;
            Context context = this.f13404a.getContext();
            int i = this.f13404a.f13411g.f13427o;
            OnClickListener c14291 = new C14291(this);
            AlertDialog a = new Builder(context).a();
            if (i == 0) {
                a.setTitle(context.getResources().getString(2131236179));
                a.a(context.getResources().getString(2131236180));
                a.a(-1, context.getResources().getString(2131236183), c14291);
                a.a(-2, context.getResources().getString(2131236182), new C14316());
            } else {
                a.setTitle(context.getResources().getQuantityString(2131689653, i, new Object[]{Integer.valueOf(i)}));
                a.a(context.getResources().getString(2131236181));
                a.a(-1, context.getResources().getQuantityString(2131689652, i, new Object[]{Integer.valueOf(i)}), c14291);
                a.a(-2, context.getResources().getString(2131236184), new C14327());
            }
            a.show();
        }
    }

    /* compiled from: fetch_place_photos */
    public final class C14316 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: fetch_place_photos */
    public final class C14327 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public static void m15032a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AudienceFragment audienceFragment = (AudienceFragment) obj;
        AudienceRecyclerAdapterProvider audienceRecyclerAdapterProvider = (AudienceRecyclerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AudienceRecyclerAdapterProvider.class);
        Fb4aTitleBarSupplier a = Fb4aTitleBarSupplier.a(injectorLike);
        GoodFriendsAnalyticsLogger a2 = GoodFriendsAnalyticsLogger.m15022a(injectorLike);
        audienceFragment.f13406b = audienceRecyclerAdapterProvider;
        audienceFragment.f13407c = a;
        audienceFragment.f13408d = a2;
    }

    public final void m15037c(@Nullable Bundle bundle) {
        super.c(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 == null) {
            this.ao = false;
        } else {
            this.ao = bundle2.getBoolean("triggered_by_nux", false);
        }
    }

    public final View m15035a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2018780873);
        Class cls = AudienceFragment.class;
        m15032a((Object) this, getContext());
        View inflate = layoutInflater.inflate(2130903312, null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 490250559, a);
        return inflate;
    }

    public final void m15036a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f13411g = this.f13406b.m15051a(this.ao);
        this.f13412h = (RecyclerView) view.findViewById(2131559740);
        this.al = (EditText) view.findViewById(2131559133);
        EditText editText = this.al;
        Drawable drawable = getContext().getResources().getDrawable(2130840089);
        drawable.setColorFilter(getContext().getResources().getColor(2131361937), Mode.SRC_IN);
        editText.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        this.f13413i = new GridLayoutManager(getContext(), 3);
        this.an = new Handler();
        this.f13412h.setLayoutManager(this.f13413i);
        this.f13412h.setAdapter(this.f13411g);
        this.f13413i.h = new C14273(this);
        this.al.addTextChangedListener(new C14284(this));
        this.f13412h.v = true;
        AudienceRecyclerAdapter audienceRecyclerAdapter = this.f13411g;
        audienceRecyclerAdapter.f13417e.a(true, audienceRecyclerAdapter.f13419g);
        this.ap = this.f13407c.a;
        this.ap.setTitle(2131236164);
        this.ap.setSearchButtonVisible(false);
        Fb4aTitleBar fb4aTitleBar = this.ap;
        List arrayList = new ArrayList();
        String string = jW_().getString(2131236165);
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = string;
        a = a;
        a.j = string;
        a = a;
        a.d = true;
        a = a;
        a.q = true;
        arrayList.add(a.a());
        fb4aTitleBar.setButtonSpecs(arrayList);
        this.ap.setOnToolbarButtonListener(new C14305(this));
        this.aq = new ProgressDialog(o());
    }

    public final void m15033G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 149086201);
        super.G();
        this.ar = true;
        this.f13408d.m15026a(Event.PICKER_OPEN);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 919671995, a);
    }

    public final void m15034H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 61156059);
        KeyboardUtils.a(o(), this.al);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 162674870, a);
    }

    public final boolean O_() {
        ao().setResult(0);
        this.f13408d.m15025a(this.f13411g.f13427o, this.f13411g.m15050l());
        this.f13408d.m15026a(Event.PICKER_CLOSE);
        return false;
    }
}
