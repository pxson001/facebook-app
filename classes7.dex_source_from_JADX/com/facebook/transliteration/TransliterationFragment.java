package com.facebook.transliteration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.transliteration.SuggestionRenderer.C11131;
import com.facebook.transliteration.SuggestionRenderer.C11142;
import com.facebook.transliteration.SuggestionRenderer.C11153;
import com.facebook.transliteration.SuggestionRenderer.C11164;
import com.facebook.transliteration.Transliteration.C11171;
import com.facebook.transliteration.Transliteration.C11182;
import com.facebook.transliteration.Transliteration.C11193;
import com.facebook.transliteration.Transliteration.C11204;
import com.facebook.transliteration.Transliteration.C11237;
import com.facebook.transliteration.Transliteration.C11248;
import com.facebook.transliteration.gridview.CharacterMapGridFragment;
import com.facebook.transliteration.gridview.CharacterMapItem;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_entry_point */
public class TransliterationFragment extends FbFragment implements FragmentWithDebugInfo {
    public CharacterMapGridFragment f15112a;
    @Nullable
    public ExtractedWord al;
    @Nullable
    private String am;
    public Algorithm an;
    private int ao;
    private boolean ap;
    private RapidFeedbackController aq;
    private GlyphView f15113b;
    public GlyphView f15114c;
    private FbEditText f15115d;
    private TextWatcher f15116e;
    public Transliteration f15117f;
    public TransliterateAnalyticsLogger f15118g;
    public List<String> f15119h;
    public SuggestionRenderer f15120i;

    /* compiled from: extra_entry_point */
    class C11271 implements TextWatcher {
        final /* synthetic */ TransliterationFragment f15104a;

        C11271(TransliterationFragment transliterationFragment) {
            this.f15104a = transliterationFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            boolean z;
            boolean z2;
            int e = TransliterationFragment.m19090e(this.f15104a);
            String charSequence2 = charSequence.toString();
            int a = StringLengthHelper.a(charSequence2);
            if (e > a) {
                e = a == 0 ? 0 : a - 1;
            }
            if (e <= 0 || charSequence.charAt(e - 1) != ' ') {
                this.f15104a.al = WordDetector.m19105a(charSequence2, e);
                if (i3 == i2) {
                    z = false;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
            } else {
                this.f15104a.al = WordDetector.m19105a(charSequence2, e - 1);
                z = true;
                z2 = true;
            }
            if (this.f15104a.al == null) {
                this.f15104a.f15119h.clear();
                this.f15104a.f15120i.m19044a();
                this.f15104a.f15114c.setGlyphColor(this.f15104a.jW_().getColor(17170432));
                this.f15104a.f15114c.setEnabled(false);
                return;
            }
            this.f15104a.f15119h = this.f15104a.f15117f.m19065a(this.f15104a.al.f15051a);
            if (z2) {
                String str;
                SuggestionRenderer suggestionRenderer = this.f15104a.f15120i;
                if (suggestionRenderer.f15065f.size() > 1) {
                    str = (String) suggestionRenderer.f15065f.get(1);
                } else {
                    str = null;
                }
                String str2 = str;
                if (str2 != null) {
                    ModifiedSentence a2;
                    if (z) {
                        a2 = WordDetector.m19106a(charSequence2, this.f15104a.al, str2);
                        a2.f15055b++;
                    } else {
                        a2 = WordDetector.m19106a(charSequence2, this.f15104a.al, str2 + " ");
                    }
                    this.f15104a.m19098a(a2);
                    this.f15104a.f15118g.m19056a(this.f15104a.al.f15051a, str2, 0, this.f15104a.an, this.f15104a.f15117f.m19067c());
                }
                this.f15104a.f15119h.clear();
                this.f15104a.f15120i.m19044a();
                this.f15104a.f15114c.setGlyphColor(this.f15104a.jW_().getColor(17170432));
                this.f15104a.f15114c.setEnabled(false);
            } else if (!this.f15104a.f15119h.isEmpty()) {
                if (this.f15104a.f15119h.size() > 3) {
                    this.f15104a.f15114c.setGlyphColor(this.f15104a.jW_().getColor(17170450));
                    this.f15104a.f15114c.setEnabled(true);
                }
                this.f15104a.f15120i.m19045a(this.f15104a.f15119h, this.f15104a.al.f15051a);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: extra_entry_point */
    class C11292 implements OnClickListener {
        final /* synthetic */ TransliterationFragment f15106a;

        /* compiled from: extra_entry_point */
        class C11281 implements OnItemClickListener {
            final /* synthetic */ C11292 f15105a;

            C11281(C11292 c11292) {
                this.f15105a = c11292;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CharacterMapItem characterMapItem = (CharacterMapItem) adapterView.getItemAtPosition(i);
                this.f15105a.f15106a.f15118g.m19058b(characterMapItem.f15182a, this.f15105a.f15106a.an, this.f15105a.f15106a.f15117f.f15089h);
                this.f15105a.f15106a.f15112a.a();
                TransliterationFragment.m19088c(this.f15105a.f15106a, characterMapItem.f15182a);
            }
        }

        C11292(TransliterationFragment transliterationFragment) {
            this.f15106a = transliterationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1993120306);
            if (this.f15106a.f15112a == null) {
                List list;
                Transliteration transliteration = this.f15106a.f15117f;
                List arrayList = new ArrayList();
                if (transliteration.f15083b) {
                    if (transliteration.f15085d == null) {
                        transliteration.f15085d = transliteration.f15090i.mo1171a();
                    }
                    Iterator it = transliteration.f15085d.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        arrayList.add(new CharacterMapItem((String) entry.getKey(), (String) entry.getValue()));
                    }
                    list = arrayList;
                } else {
                    list = arrayList;
                }
                List list2 = list;
                OnItemClickListener c11281 = new C11281(this);
                TransliterationFragment transliterationFragment = this.f15106a;
                CharacterMapGridFragment characterMapGridFragment = new CharacterMapGridFragment();
                characterMapGridFragment.ao = list2;
                characterMapGridFragment.ap = c11281;
                transliterationFragment.f15112a = characterMapGridFragment;
            }
            this.f15106a.f15118g.m19050a();
            this.f15106a.f15112a.a(this.f15106a.D, CharacterMapGridFragment.am);
            Logger.a(2, EntryType.UI_INPUT_END, 484260183, a);
        }
    }

    /* compiled from: extra_entry_point */
    class C11323 implements OnClickListener {
        final /* synthetic */ TransliterationFragment f15109a;

        /* compiled from: extra_entry_point */
        class C11301 implements DialogInterface.OnClickListener {
            final /* synthetic */ C11323 f15107a;

            C11301(C11323 c11323) {
                this.f15107a = c11323;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f15107a.f15109a.f15118g.m19061d();
            }
        }

        /* compiled from: extra_entry_point */
        class C11312 implements DialogInterface.OnClickListener {
            final /* synthetic */ C11323 f15108a;

            C11312(C11323 c11323) {
                this.f15108a = c11323;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                TransliterationFragment.m19094g(this.f15108a.f15109a, i);
            }
        }

        C11323(TransliterationFragment transliterationFragment) {
            this.f15109a = transliterationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -137289333);
            if (this.f15109a.f15119h.isEmpty()) {
                Logger.a(2, EntryType.UI_INPUT_END, 1623650163, a);
                return;
            }
            String[] strArr = (String[]) this.f15109a.f15119h.toArray(new String[this.f15109a.f15119h.size()]);
            this.f15109a.f15118g.m19059c();
            new FbAlertDialogBuilder(this.f15109a.getContext()).a(strArr, new C11312(this)).c(2131233193, new C11301(this)).a().show();
            LogUtils.a(1161308872, a);
        }
    }

    private static <T extends InjectableComponentWithContext> void m19083a(Class<T> cls, T t) {
        m19084a((Object) t, t.getContext());
    }

    private static void m19084a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TransliterationFragment) obj).m19082a((TransliterationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TransliterationProvider.class), TransliterateAnalyticsLogger.m19046a(injectorLike), RapidFeedbackController.b(injectorLike));
    }

    @Inject
    private void m19082a(TransliterationProvider transliterationProvider, TransliterateAnalyticsLogger transliterateAnalyticsLogger, RapidFeedbackController rapidFeedbackController) {
        this.f15118g = transliterateAnalyticsLogger;
        this.aq = rapidFeedbackController;
        this.an = Algorithm.BIGRAM;
        this.ao = 0;
        this.ap = true;
        this.f15117f = transliterationProvider.m19104a(this.an, Boolean.valueOf(this.ap), Integer.valueOf(this.ao));
        Transliteration transliteration = this.f15117f;
        if (transliteration.f15082a == Algorithm.UNIGRAM) {
            Futures.a(transliteration.f15088g.a(new C11171(transliteration)), new C11182(transliteration), transliteration.f15088g);
            ExecutorDetour.a(transliteration.f15088g, new C11193(transliteration), -95773158);
        }
        if (transliteration.f15086e) {
            Futures.a(transliteration.f15088g.a(new C11237(transliteration)), new C11248(transliteration), transliteration.f15088g);
            ExecutorDetour.a(transliteration.f15088g, new C11204(transliteration), 625087316);
        }
        this.f15119h = new ArrayList();
        this.am = null;
    }

    public final View m19097a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1112867043);
        View inflate = layoutInflater.inflate(2130907538, viewGroup);
        this.f15115d = (FbEditText) FindViewUtil.b(inflate, 2131568104);
        this.f15113b = (GlyphView) FindViewUtil.b(inflate, 2131568106);
        this.f15114c = (GlyphView) FindViewUtil.b(inflate, 2131568111);
        this.f15120i = new SuggestionRenderer(this);
        SuggestionRenderer suggestionRenderer = this.f15120i;
        FbTextView fbTextView = (FbTextView) FindViewUtil.b(inflate, 2131568108);
        FbTextView fbTextView2 = (FbTextView) FindViewUtil.b(inflate, 2131568109);
        FbTextView fbTextView3 = (FbTextView) FindViewUtil.b(inflate, 2131568110);
        suggestionRenderer.f15061b = (FbTextView) FindViewUtil.b(inflate, 2131568107);
        suggestionRenderer.f15062c = fbTextView;
        suggestionRenderer.f15063d = fbTextView2;
        suggestionRenderer.f15064e = fbTextView3;
        suggestionRenderer.f15065f = new ArrayList();
        suggestionRenderer.f15061b.setOnClickListener(new C11131(suggestionRenderer));
        suggestionRenderer.f15062c.setOnClickListener(new C11142(suggestionRenderer));
        suggestionRenderer.f15063d.setOnClickListener(new C11153(suggestionRenderer));
        suggestionRenderer.f15064e.setOnClickListener(new C11164(suggestionRenderer));
        this.f15116e = new C11271(this);
        this.f15115d.addTextChangedListener(this.f15116e);
        this.f15113b.setOnClickListener(new C11292(this));
        this.f15114c.setOnClickListener(new C11323(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1044106510, a);
        return inflate;
    }

    public static int m19090e(TransliterationFragment transliterationFragment) {
        return Math.max(transliterationFragment.f15115d.getSelectionStart(), 0);
    }

    public static void m19094g(TransliterationFragment transliterationFragment, int i) {
        Preconditions.checkState(transliterationFragment.al != null);
        if (transliterationFragment.f15119h.size() >= i + 1) {
            transliterationFragment.m19100a((String) transliterationFragment.f15119h.get(i), i, false);
        }
    }

    public final void m19100a(String str, int i, boolean z) {
        Preconditions.checkState(this.al != null);
        String obj = this.f15115d.getText().toString();
        if (!z) {
            this.f15117f.m19066a(this.al.f15051a, str);
            this.f15118g.m19056a(this.al.f15051a, str, i, this.an, this.f15117f.f15089h);
        }
        m19098a(WordDetector.m19106a(obj, this.al, str + " "));
        this.f15119h.clear();
        this.f15120i.m19044a();
        this.f15114c.setGlyphColor(jW_().getColor(17170432));
        this.f15114c.setEnabled(false);
    }

    public final void m19099a(String str) {
        this.f15118g.m19054a(str, this.an, this.f15117f.f15089h);
    }

    public final void m19102b(String str) {
        this.am = str;
        if (str != null) {
            this.f15115d.setText(str);
            this.f15115d.setSelection(StringLengthHelper.a(str));
        }
    }

    public final void m19098a(ModifiedSentence modifiedSentence) {
        this.f15115d.removeTextChangedListener(this.f15116e);
        this.f15115d.setText(modifiedSentence.f15054a);
        this.f15115d.setSelection(modifiedSentence.f15055b);
        this.f15115d.addTextChangedListener(this.f15116e);
    }

    public static void m19088c(TransliterationFragment transliterationFragment, String str) {
        int max = Math.max(transliterationFragment.f15115d.getSelectionStart(), 0);
        int max2 = Math.max(transliterationFragment.f15115d.getSelectionEnd(), 0);
        transliterationFragment.f15115d.getText().replace(Math.min(max, max2), Math.max(max, max2), str, 0, str.length());
        transliterationFragment.m19086b(transliterationFragment.f15115d);
    }

    private void m19086b(final View view) {
        view.postDelayed(new Runnable(this) {
            final /* synthetic */ TransliterationFragment f15111b;

            public void run() {
                KeyboardUtils.b(this.f15111b.getContext(), view);
            }
        }, 100);
    }

    public final void m19103c(Bundle bundle) {
        super.c(bundle);
        m19083a(TransliterationFragment.class, (InjectableComponentWithContext) this);
    }

    public final void m19101b() {
        String obj = this.f15115d.getText().toString();
        if (TextUtils.equals(this.am, obj) || (this.am == null && TextUtils.isEmpty(obj))) {
            this.f15118g.m19052a(this.an, this.f15117f.f15089h);
        } else {
            this.f15118g.m19060c(obj, this.an, this.f15117f.f15089h);
            Intent intent = new Intent();
            intent.putExtra("transliterated_text", obj);
            o().setResult(-1, intent);
        }
        this.aq.a("989272751122317", getContext());
        KeyboardUtils.a(o());
        o().finish();
    }

    public Map<String, String> getDebugInfo() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("trans_source_text", this.f15115d.getText().toString());
        hashMap.put("trans_language", Integer.toString(this.ao));
        hashMap.put("trans_dict_enabled", Boolean.toString(this.ap));
        SuggestionRenderer suggestionRenderer = this.f15120i;
        hashMap.put("trans_suggestion_1", suggestionRenderer.f15061b.getText().toString());
        hashMap.put("trans_suggestion_2", suggestionRenderer.f15062c.getText().toString());
        hashMap.put("trans_suggestion_3", suggestionRenderer.f15063d.getText().toString());
        hashMap.put("trans_suggestion_4", suggestionRenderer.f15064e.getText().toString());
        return hashMap;
    }
}
