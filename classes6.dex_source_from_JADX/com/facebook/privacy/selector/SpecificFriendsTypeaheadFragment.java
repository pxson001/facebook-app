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
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.DropdownMode;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.TextMode;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: fb4a_composer */
public class SpecificFriendsTypeaheadFragment extends AbstractCustomPrivacyTypeaheadFragment {
    public static final Class<?> aw = SpecificFriendsTypeaheadFragment.class;
    public final TextWatcher ax = new C10625(this);
    public final OnItemClickListener ay = new C10636(this);

    /* compiled from: fb4a_composer */
    class C10581 implements OnClickListener {
        final /* synthetic */ SpecificFriendsTypeaheadFragment f15251a;

        C10581(SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment) {
            this.f15251a = specificFriendsTypeaheadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1919362580);
            this.f15251a.at();
            Logger.a(2, EntryType.UI_INPUT_END, -941113640, a);
        }
    }

    /* compiled from: fb4a_composer */
    class C10592 implements OnGlobalFocusChangeListener {
        final /* synthetic */ SpecificFriendsTypeaheadFragment f15252a;

        C10592(SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment) {
            this.f15252a = specificFriendsTypeaheadFragment;
        }

        public void onGlobalFocusChanged(View view, View view2) {
            this.f15252a.aq.m28729a();
        }
    }

    /* compiled from: fb4a_composer */
    public class C10603 implements OnTouchListener {
        final /* synthetic */ SpecificFriendsTypeaheadFragment f15253a;

        public C10603(SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment) {
            this.f15253a = specificFriendsTypeaheadFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: fb4a_composer */
    public class C10614 implements OnKeyListener {
        final /* synthetic */ SpecificFriendsTypeaheadFragment f15254a;

        public C10614(SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment) {
            this.f15254a = specificFriendsTypeaheadFragment;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getKeyCode() != 66) {
                return false;
            }
            this.f15254a.at();
            return true;
        }
    }

    /* compiled from: fb4a_composer */
    class C10625 implements TextWatcher {
        final /* synthetic */ SpecificFriendsTypeaheadFragment f15255a;
        private List<BaseToken> f15256b;

        C10625(SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment) {
            this.f15255a = specificFriendsTypeaheadFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f15255a.f15141g.mo438a().mo389a(this.f15255a.aq.getUserEnteredPlainText());
            this.f15255a.au = AbstractCustomPrivacyTypeaheadFragment.m22725a(this.f15255a.aq);
            if (this.f15256b == null || this.f15256b.size() != this.f15255a.au.size()) {
                this.f15256b = this.f15255a.au;
                this.f15255a.f15141g.f18485i = this.f15255a.au;
                this.f15255a.ar();
            }
        }
    }

    /* compiled from: fb4a_composer */
    class C10636 implements OnItemClickListener {
        final /* synthetic */ SpecificFriendsTypeaheadFragment f15257a;

        C10636(SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment) {
            this.f15257a = specificFriendsTypeaheadFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            List a = AbstractCustomPrivacyTypeaheadFragment.m22725a(this.f15257a.aq);
            Token token = (BaseToken) this.f15257a.f15141g.getItem(i);
            if (token != null) {
                if (a.size() < 25 || a.contains(token)) {
                    AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment = this.f15257a;
                    TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView = this.f15257a.aq;
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
                        abstractCustomPrivacyTypeaheadFragment.f15143i.a(SoftError.a(SpecificFriendsTypeaheadFragment.aw.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Unexpected selected option token of type %s", token.f15080a.name())).g());
                    }
                    this.f15257a.aq.m28739d();
                    return;
                }
                new Builder(this.f15257a.getContext()).a(this.f15257a.b(2131234223)).b(this.f15257a.a(2131234225, new Object[]{Integer.valueOf(25)})).a(2131230726, null).a(true).b();
            }
        }
    }

    public final void mo1216c(Bundle bundle) {
        super.mo1216c(bundle);
        Class cls = SpecificFriendsTypeaheadFragment.class;
        FbInjector.get(getContext());
    }

    public final View m22911a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1874582020);
        this.ap = layoutInflater.inflate(2130906404, viewGroup, false);
        View view = this.ap;
        this.f15141g.m27105a(this.al);
        this.f15141g.m27107a(ImmutableList.of(new ImmutableSectionedListSection(), new ImmutableSectionedListSection()));
        this.ar = (BetterListView) view.findViewById(2131566283);
        this.ar.setAdapter(this.f15141g);
        this.ar.setOnScrollListener(this.av);
        this.ar.setOnItemClickListener(this.ay);
        this.as = view.findViewById(2131566284);
        this.as.setOnTouchListener(new C10603(this));
        this.aq = (TokenizedAutoCompleteTextView) this.ap.findViewById(2131566281);
        this.aq.addTextChangedListener(this.ax);
        this.aq.f20028f = DropdownMode.NO_DROPDOWN;
        this.aq.setTextMode(TextMode.PLAIN_TEXT);
        this.aq.f20038p = jW_().getColor(2131361917);
        this.aq.setLongClickable(false);
        this.aq.setOnKeyListener(new C10614(this));
        this.ao = this.ap.findViewById(2131566282);
        this.at = this.ap.findViewById(2131566280);
        this.at.setOnClickListener(new C10581(this));
        m22732b();
        this.aq.getViewTreeObserver().addOnGlobalFocusChangeListener(new C10592(this));
        view = this.at;
        Optional d = ContextUtils.d(getContext(), 2130772544);
        if (d.isPresent()) {
            CustomViewUtils.a(view, (Drawable) d.get());
        }
        view = this.ap;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1303353980, a);
        return view;
    }
}
