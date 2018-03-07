package com.facebook.privacy.selector;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.DropdownMode;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.SelectedTokenHighlightColor;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.TextMode;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.facebook.widget.tokenizedtypeahead.model.SimpleFriendlistToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadItemRow;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: fb4a_intern_settings */
public class FriendsExceptTypeaheadFragment extends AbstractCustomPrivacyTypeaheadFragment {
    public static final Class<?> aw = FriendsExceptTypeaheadFragment.class;
    public final OnItemClickListener aA = new C10576(this);
    private FbTextView ax;
    private View ay;
    public final TextWatcher az = new C10565(this);

    /* compiled from: fb4a_intern_settings */
    class C10521 implements OnGlobalFocusChangeListener {
        final /* synthetic */ FriendsExceptTypeaheadFragment f15243a;

        C10521(FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment) {
            this.f15243a = friendsExceptTypeaheadFragment;
        }

        public void onGlobalFocusChanged(View view, View view2) {
            this.f15243a.aq.m28729a();
        }
    }

    /* compiled from: fb4a_intern_settings */
    class C10532 implements OnClickListener {
        final /* synthetic */ FriendsExceptTypeaheadFragment f15244a;

        C10532(FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment) {
            this.f15244a = friendsExceptTypeaheadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 903318195);
            this.f15244a.at();
            Logger.a(2, EntryType.UI_INPUT_END, -1963734234, a);
        }
    }

    /* compiled from: fb4a_intern_settings */
    public class C10543 implements OnTouchListener {
        final /* synthetic */ FriendsExceptTypeaheadFragment f15245a;

        public C10543(FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment) {
            this.f15245a = friendsExceptTypeaheadFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: fb4a_intern_settings */
    public class C10554 implements OnKeyListener {
        final /* synthetic */ FriendsExceptTypeaheadFragment f15246a;

        public C10554(FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment) {
            this.f15246a = friendsExceptTypeaheadFragment;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getKeyCode() != 66) {
                return false;
            }
            this.f15246a.at();
            return true;
        }
    }

    /* compiled from: fb4a_intern_settings */
    class C10565 implements TextWatcher {
        final /* synthetic */ FriendsExceptTypeaheadFragment f15247a;
        private List<BaseToken> f15248b;

        C10565(FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment) {
            this.f15247a = friendsExceptTypeaheadFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f15247a.f15141g.mo438a().mo389a(this.f15247a.aq.getUserEnteredPlainText());
            this.f15247a.au = AbstractCustomPrivacyTypeaheadFragment.m22725a(this.f15247a.aq);
            if (this.f15248b == null || this.f15248b.size() != this.f15247a.au.size()) {
                this.f15248b = this.f15247a.au;
                this.f15247a.f15141g.f18485i = this.f15247a.au;
                this.f15247a.ar();
            }
        }
    }

    /* compiled from: fb4a_intern_settings */
    class C10576 implements OnItemClickListener {
        final /* synthetic */ FriendsExceptTypeaheadFragment f15249a;

        C10576(FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment) {
            this.f15249a = friendsExceptTypeaheadFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            List a = AbstractCustomPrivacyTypeaheadFragment.m22725a(this.f15249a.aq);
            Token token = (BaseToken) this.f15249a.f15141g.getItem(i);
            if (token != null) {
                if (a.size() < 25 || a.contains(token)) {
                    AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment = this.f15249a;
                    TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView = this.f15249a.aq;
                    List a2 = AbstractCustomPrivacyTypeaheadFragment.m22725a(tokenizedAutoCompleteTextView);
                    if (token.f15080a == Type.USER || token.f15080a == Type.FRIENDLIST) {
                        if (a2.contains(token)) {
                            tokenizedAutoCompleteTextView.m28733a(token, true);
                        } else {
                            tokenizedAutoCompleteTextView.m28732a(token);
                        }
                        tokenizedAutoCompleteTextView.m28740e();
                        abstractCustomPrivacyTypeaheadFragment.ar();
                    } else {
                        abstractCustomPrivacyTypeaheadFragment.f15143i.a(SoftError.a(FriendsExceptTypeaheadFragment.aw.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Unexpected selected option token of type %s", token.f15080a.name())).g());
                    }
                    this.f15249a.aq.m28739d();
                    return;
                }
                new Builder(this.f15249a.getContext()).a(this.f15249a.b(2131234223)).b(this.f15249a.a(2131234224, new Object[]{Integer.valueOf(25)})).a(2131230726, null).a(true).b();
            }
        }
    }

    /* compiled from: fb4a_intern_settings */
    public class ExcludedItemViewFactory extends DefaultViewFactory {
        public ExcludedItemViewFactory() {
            super(true);
        }

        public final View mo1201a(ViewGroup viewGroup) {
            TypeaheadItemRow a = new TypeaheadItemRow(viewGroup.getContext()).m28795a();
            a.setCheckboxBackground(2130839554);
            return a;
        }
    }

    public static FriendsExceptTypeaheadFragment m22905a(boolean z) {
        FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment = new FriendsExceptTypeaheadFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("shouldHideToBar", z);
        friendsExceptTypeaheadFragment.g(bundle);
        return friendsExceptTypeaheadFragment;
    }

    public final void mo1216c(Bundle bundle) {
        super.mo1216c(bundle);
        Class cls = FriendsExceptTypeaheadFragment.class;
        FbInjector.get(getContext());
    }

    public final View m22906a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1201631684);
        this.ap = layoutInflater.inflate(2130906393, viewGroup, false);
        View view = this.ap;
        this.f15141g.m27106a(this.al, new ExcludedItemViewFactory());
        this.f15141g.m27107a(ImmutableList.of(new ImmutableSectionedListSection(), new ImmutableSectionedListSection()));
        this.ar = (BetterListView) view.findViewById(2131566273);
        this.ar.setAdapter(this.f15141g);
        this.ar.setOnScrollListener(this.av);
        this.ar.setOnItemClickListener(this.aA);
        this.as = view.findViewById(2131566274);
        this.as.setOnTouchListener(new C10543(this));
        this.aq = (TokenizedAutoCompleteTextView) this.ap.findViewById(2131566271);
        this.aq.addTextChangedListener(this.az);
        this.aq.f20028f = DropdownMode.NO_DROPDOWN;
        this.aq.setTextMode(TextMode.PLAIN_TEXT);
        this.aq.f20038p = jW_().getColor(2131361917);
        this.aq.setLongClickable(false);
        this.aq.setOnKeyListener(new C10554(this));
        this.ax = (FbTextView) this.ap.findViewById(2131566269);
        this.aq.f20038p = jW_().getColor(2131361918);
        this.aq.setTokenIconColor(jW_().getColor(2131361918));
        this.aq.setSelectedTokenHighlightColor(SelectedTokenHighlightColor.RED);
        this.ao = this.ap.findViewById(2131566272);
        this.ay = this.ap.findViewById(2131566268);
        this.at = this.ap.findViewById(2131566270);
        m22732b();
        this.aq.getViewTreeObserver().addOnGlobalFocusChangeListener(new C10521(this));
        view = this.at;
        View view2 = this.ay;
        Optional d = ContextUtils.d(getContext(), 2130772544);
        if (d.isPresent()) {
            CustomViewUtils.a(view, (Drawable) d.get());
            CustomViewUtils.a(view2, (Drawable) d.get());
        }
        OnClickListener c10532 = new C10532(this);
        this.ay.setOnClickListener(c10532);
        if (this.s.getBoolean("shouldHideToBar")) {
            this.ay.setVisibility(8);
        } else {
            this.ay.setVisibility(0);
        }
        this.at.setOnClickListener(c10532);
        view = this.ap;
        LogUtils.f(-64640220, a);
        return view;
    }

    public final void ar() {
        List<BaseToken> a = AbstractCustomPrivacyTypeaheadFragment.m22725a(this.aq);
        if (as()) {
            List arrayList = new ArrayList();
            for (BaseToken baseToken : a) {
                Object a2;
                if (baseToken.f15080a == Type.USER) {
                    a2 = AudienceTypeaheadUtil.m22859a((SimpleUserToken) baseToken);
                } else if (baseToken.f15080a == Type.FRIENDLIST) {
                    a2 = AudienceTypeaheadUtil.m22858a((SimpleFriendlistToken) baseToken);
                } else {
                    a2 = null;
                }
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            if (this.am != null) {
                this.am.mo1199a(arrayList);
            }
            if (this.an != null) {
                this.an.mo1214a(a);
            }
            this.ax.setText(AudienceTypeaheadUtil.m22861a(jW_(), arrayList));
        }
    }
}
