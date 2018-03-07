package com.facebook.transliteration;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: extra_hours_data */
public class SuggestionRenderer {
    TransliterationFragment f15060a;
    public FbTextView f15061b;
    public FbTextView f15062c;
    public FbTextView f15063d;
    public FbTextView f15064e;
    public ArrayList<String> f15065f;

    /* compiled from: extra_hours_data */
    public class C11131 implements OnClickListener {
        final /* synthetic */ SuggestionRenderer f15056a;

        public C11131(SuggestionRenderer suggestionRenderer) {
            this.f15056a = suggestionRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 554853770);
            SuggestionRenderer.m19043a(this.f15056a, 0, true);
            Logger.a(2, EntryType.UI_INPUT_END, 1305202974, a);
        }
    }

    /* compiled from: extra_hours_data */
    public class C11142 implements OnClickListener {
        final /* synthetic */ SuggestionRenderer f15057a;

        public C11142(SuggestionRenderer suggestionRenderer) {
            this.f15057a = suggestionRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1042676407);
            SuggestionRenderer.m19043a(this.f15057a, 1, false);
            Logger.a(2, EntryType.UI_INPUT_END, 1578715116, a);
        }
    }

    /* compiled from: extra_hours_data */
    public class C11153 implements OnClickListener {
        final /* synthetic */ SuggestionRenderer f15058a;

        public C11153(SuggestionRenderer suggestionRenderer) {
            this.f15058a = suggestionRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2036376946);
            SuggestionRenderer.m19043a(this.f15058a, 2, false);
            Logger.a(2, EntryType.UI_INPUT_END, -96478078, a);
        }
    }

    /* compiled from: extra_hours_data */
    public class C11164 implements OnClickListener {
        final /* synthetic */ SuggestionRenderer f15059a;

        public C11164(SuggestionRenderer suggestionRenderer) {
            this.f15059a = suggestionRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2125257638);
            SuggestionRenderer.m19043a(this.f15059a, 3, false);
            Logger.a(2, EntryType.UI_INPUT_END, 823395070, a);
        }
    }

    public SuggestionRenderer(TransliterationFragment transliterationFragment) {
        this.f15060a = transliterationFragment;
    }

    public static void m19043a(SuggestionRenderer suggestionRenderer, int i, boolean z) {
        if (suggestionRenderer.f15065f.size() > i) {
            suggestionRenderer.f15060a.m19100a((String) suggestionRenderer.f15065f.get(i), i - 1, z);
        }
    }

    public final void m19044a() {
        this.f15061b.setText(" ");
        this.f15062c.setText(" ");
        this.f15063d.setText(" ");
        this.f15064e.setText(" ");
        this.f15065f.clear();
    }

    public final void m19045a(List<String> list, String str) {
        this.f15065f.clear();
        this.f15065f.add(0, str);
        this.f15061b.setText(str);
        if (list.size() > 0) {
            String str2 = (String) list.get(0);
            this.f15065f.add(1, str2);
            this.f15062c.setText(str2);
        } else {
            this.f15062c.setText(" ");
        }
        if (list.size() > 1) {
            str2 = (String) list.get(1);
            this.f15065f.add(2, str2);
            this.f15063d.setText(str2);
        } else {
            this.f15063d.setText(" ");
        }
        if (list.size() > 2) {
            str2 = (String) list.get(2);
            this.f15065f.add(3, str2);
            this.f15064e.setText(str2);
            return;
        }
        this.f15064e.setText(" ");
    }
}
