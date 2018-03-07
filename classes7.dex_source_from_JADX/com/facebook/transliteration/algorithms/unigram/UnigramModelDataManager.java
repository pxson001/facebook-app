package com.facebook.transliteration.algorithms.unigram;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.facebook.transliteration.datamanager.DataManagerUtil;
import com.facebook.transliteration.datatypes.LanguageModel;
import com.fasterxml.jackson.core.JsonParseException;
import javax.inject.Inject;

/* compiled from: expiration_time_duration */
public class UnigramModelDataManager {
    private DataManagerUtil f15144a;
    private FbObjectMapper f15145b;

    @Inject
    public UnigramModelDataManager(DataManagerUtil dataManagerUtil, FbObjectMapper fbObjectMapper) {
        this.f15144a = dataManagerUtil;
        this.f15145b = fbObjectMapper;
    }

    private LanguageModel m19138a(String str) {
        try {
            return (UnigramLanguageModel) this.f15145b.b().a(str).a(UnigramLanguageModel.class);
        } catch (JsonParseException e) {
            BLog.b("TRANSLITERATION", "Could not parse data", e);
            return null;
        } catch (Throwable e2) {
            BLog.b("TRANSLITERATION", "Could not convert class", e2);
            return null;
        }
    }

    public final LanguageModel m19140a(int i) {
        String b = this.f15144a.m19179b(0, i);
        if (b != null) {
            return m19138a(b);
        }
        b = this.f15144a.m19177a(0, i);
        return b == null ? null : m19138a(b);
    }

    public final void m19141b(int i) {
        String d = this.f15144a.m19181d(0, i);
        int b = m19139b(d);
        if (b != -1) {
            this.f15144a.m19178a(d, 0, i, b);
        }
    }

    private int m19139b(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        UnigramLanguageModel unigramLanguageModel = (UnigramLanguageModel) m19138a(str);
        if (unigramLanguageModel == null) {
            return -1;
        }
        return unigramLanguageModel.mVersion;
    }
}
