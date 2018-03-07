package com.facebook.transliteration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.transliteration.algorithms.TransliterationAlgorithm;
import com.facebook.transliteration.algorithms.bigram.BigramAlgorithmProvider;
import com.facebook.transliteration.algorithms.unigram.UnigramLanguageModel;
import com.facebook.transliteration.algorithms.unigram.UnigramModelAlgorithm;
import com.facebook.transliteration.algorithms.unigram.UnigramModelDataManager;
import com.facebook.transliteration.autocomplete.WordPredictor;
import com.facebook.transliteration.database.DictionarySchema.DictionaryTable.Columns;
import com.facebook.transliteration.database.TransliterationDatabaseSupplier;
import com.facebook.transliteration.datamanager.DictionaryDataManager;
import com.facebook.transliteration.datatypes.LanguageModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: extra_gif_picker_launcher_id */
public class Transliteration {
    public final Algorithm f15082a;
    public boolean f15083b = false;
    private Context f15084c;
    public ImmutableMap<String, String> f15085d;
    public final boolean f15086e;
    public final int f15087f;
    public final ListeningExecutorService f15088g;
    public int f15089h;
    public TransliterationAlgorithm f15090i;
    public final TransliterateAnalyticsLogger f15091j;
    public final TransliterationDatabaseSupplier f15092k;
    public UnigramModelDataManager f15093l;
    public DictionaryDataManager f15094m;
    public WordPredictor f15095n;

    /* compiled from: extra_gif_picker_launcher_id */
    public class C11171 implements Callable<LanguageModel> {
        final /* synthetic */ Transliteration f15068a;

        public C11171(Transliteration transliteration) {
            this.f15068a = transliteration;
        }

        public Object call() {
            return this.f15068a.f15093l.m19140a(this.f15068a.f15087f);
        }
    }

    /* compiled from: extra_gif_picker_launcher_id */
    public class C11182 implements FutureCallback<LanguageModel> {
        final /* synthetic */ Transliteration f15069a;

        public C11182(Transliteration transliteration) {
            this.f15069a = transliteration;
        }

        public void onSuccess(Object obj) {
            LanguageModel languageModel = (LanguageModel) obj;
            if (this.f15069a.f15082a == Algorithm.UNIGRAM) {
                UnigramLanguageModel unigramLanguageModel = (UnigramLanguageModel) languageModel;
                this.f15069a.f15089h = unigramLanguageModel.mVersion;
                UnigramModelAlgorithm unigramModelAlgorithm = (UnigramModelAlgorithm) this.f15069a.f15090i;
                unigramModelAlgorithm.f15141b = unigramLanguageModel;
                int i = 0;
                for (String length : unigramModelAlgorithm.f15141b.mModel.keySet()) {
                    i = Math.max(i, length.length());
                }
                unigramModelAlgorithm.f15140a = i;
                this.f15069a.f15083b = true;
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: extra_gif_picker_launcher_id */
    public class C11193 implements Runnable {
        final /* synthetic */ Transliteration f15070a;

        public C11193(Transliteration transliteration) {
            this.f15070a = transliteration;
        }

        public void run() {
            this.f15070a.f15093l.m19141b(this.f15070a.f15087f);
        }
    }

    /* compiled from: extra_gif_picker_launcher_id */
    public class C11204 implements Runnable {
        final /* synthetic */ Transliteration f15071a;

        public C11204(Transliteration transliteration) {
            this.f15071a = transliteration;
        }

        public void run() {
            this.f15071a.f15094m.m19186b(this.f15071a.f15087f);
        }
    }

    /* compiled from: extra_gif_picker_launcher_id */
    public class C11237 implements Callable<Map<String, String>> {
        final /* synthetic */ Transliteration f15080a;

        public C11237(Transliteration transliteration) {
            this.f15080a = transliteration;
        }

        public Object call() {
            Map a = this.f15080a.f15094m.m19185a(this.f15080a.f15087f);
            Map a2 = this.f15080a.f15092k.m19162a(this.f15080a.f15087f);
            if (a != null) {
                a2.putAll(a);
            }
            return a2;
        }
    }

    /* compiled from: extra_gif_picker_launcher_id */
    public class C11248 implements FutureCallback<Map<String, String>> {
        final /* synthetic */ Transliteration f15081a;

        public C11248(Transliteration transliteration) {
            this.f15081a = transliteration;
        }

        public void onSuccess(Object obj) {
            Map map = (Map) obj;
            WordPredictor wordPredictor = this.f15081a.f15095n;
            for (Entry entry : map.entrySet()) {
                wordPredictor.f15159b.m19156a((String) entry.getKey(), (String) entry.getValue());
            }
        }

        public void onFailure(Throwable th) {
            this.f15081a.f15091j.m19051a(this.f15081a.f15082a);
        }
    }

    @Inject
    public Transliteration(ExecutorService executorService, Context context, TransliterateAnalyticsLogger transliterateAnalyticsLogger, TransliterationDatabaseSupplier transliterationDatabaseSupplier, DictionaryDataManager dictionaryDataManager, BigramAlgorithmProvider bigramAlgorithmProvider, Lazy<UnigramModelAlgorithm> lazy, Lazy<UnigramModelDataManager> lazy2, WordPredictor wordPredictor, @Assisted Algorithm algorithm, @Assisted Boolean bool, @Assisted Integer num) {
        this.f15082a = algorithm;
        this.f15086e = bool.booleanValue();
        this.f15087f = num.intValue();
        this.f15084c = context;
        this.f15088g = MoreExecutors.a(executorService);
        this.f15091j = transliterateAnalyticsLogger;
        this.f15092k = transliterationDatabaseSupplier;
        this.f15094m = dictionaryDataManager;
        this.f15095n = wordPredictor;
        if (this.f15082a == Algorithm.UNIGRAM) {
            this.f15093l = (UnigramModelDataManager) lazy2.get();
            this.f15090i = (TransliterationAlgorithm) lazy.get();
        } else if (this.f15082a == Algorithm.BIGRAM) {
            this.f15090i = bigramAlgorithmProvider.m19116a(num.intValue());
            this.f15083b = true;
        }
    }

    public final List<String> m19065a(String str) {
        List<String> arrayList = new ArrayList();
        if (this.f15083b && !StringUtil.a(str)) {
            Collection linkedHashSet = new LinkedHashSet();
            if (this.f15086e) {
                List a = this.f15095n.f15159b.m19155a(str, WordPredictor.f15158a);
                if (a != null) {
                    linkedHashSet.addAll(a);
                }
            }
            Collection a2 = this.f15090i.mo1172a(str, 20);
            if (arrayList != null) {
                linkedHashSet.addAll(a2);
            }
            arrayList.addAll(linkedHashSet);
        }
        return arrayList;
    }

    public final void m19066a(String str, String str2) {
        boolean z;
        Object obj;
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty());
        Preconditions.checkNotNull(str2);
        if (str2.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (this.f15095n.f15159b.m19154a(str).isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            m19064a(this.f15087f, str, str2, 0);
        } else if (!this.f15095n.f15159b.m19154a(str).contentEquals(str2)) {
            m19064a(this.f15087f, str, str2, 1);
        }
        this.f15095n.f15159b.m19156a(str, str2);
    }

    private void m19064a(int i, final String str, final String str2, int i2) {
        final int i3 = i;
        final String str3 = str;
        final String str4 = str2;
        final int i4 = i2;
        Futures.a(this.f15088g.a(new Callable<Long>(this) {
            final /* synthetic */ Transliteration f15076e;

            public Object call() {
                Transliteration transliteration = this.f15076e;
                int i = i3;
                String str = str3;
                String str2 = str4;
                int i2 = i4;
                SQLiteDatabase a = transliteration.f15092k.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put(Columns.f15161b.d, Integer.valueOf(i));
                contentValues.put(Columns.f15162c.d, str);
                contentValues.put(Columns.f15163d.d, str2);
                long j = 0;
                if (i2 == 1) {
                    j = (long) a.update("dictionary_table", contentValues, Columns.f15161b + "=? AND " + Columns.f15162c + "=?", new String[]{String.valueOf(i), str});
                } else if (i2 == 0) {
                    SQLiteDetour.a(57457500);
                    j = a.insertOrThrow("dictionary_table", null, contentValues);
                    SQLiteDetour.a(-312689715);
                }
                return Long.valueOf(j);
            }
        }), new FutureCallback<Long>(this) {
            final /* synthetic */ Transliteration f15079c;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f15079c.f15091j.m19055a(str, str2);
            }
        }, this.f15088g);
    }

    public final int m19067c() {
        return this.f15089h;
    }
}
