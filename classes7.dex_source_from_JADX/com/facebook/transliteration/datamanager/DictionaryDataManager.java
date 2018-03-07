package com.facebook.transliteration.datamanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.transliteration.database.DictionarySchema.DictionaryTable.Columns;
import com.facebook.transliteration.datatypes.DictionaryItem;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: exception =  */
public class DictionaryDataManager {
    private static final String f15176a = DictionaryDataManager.class.getSimpleName();
    private DataManagerUtil f15177b;
    private FbObjectMapper f15178c;

    public static DictionaryDataManager m19184b(InjectorLike injectorLike) {
        return new DictionaryDataManager(DataManagerUtil.m19168b(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DictionaryDataManager(DataManagerUtil dataManagerUtil, FbObjectMapper fbObjectMapper) {
        this.f15177b = dataManagerUtil;
        this.f15178c = fbObjectMapper;
    }

    public final Map<String, String> m19185a(int i) {
        String c = this.f15177b.m19180c(0, i);
        return c == null ? null : m19183a(c);
    }

    private Map<String, String> m19183a(String str) {
        JsonParser a;
        DictionaryItem dictionaryItem;
        Throwable e;
        try {
            a = this.f15178c.b().a(str);
            try {
                dictionaryItem = (DictionaryItem) a.a(DictionaryItem.class);
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (JsonParseException e3) {
                e = e3;
                try {
                    BLog.b(f15176a, "Could not parse data", e);
                    if (a != null) {
                        try {
                            a.close();
                            dictionaryItem = null;
                        } catch (Exception e4) {
                            dictionaryItem = null;
                        }
                        if (dictionaryItem == null) {
                            return dictionaryItem.mDictionary;
                        }
                        return null;
                    }
                    dictionaryItem = null;
                    if (dictionaryItem == null) {
                        return null;
                    }
                    return dictionaryItem.mDictionary;
                } catch (Throwable th) {
                    e = th;
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            } catch (IOException e6) {
                e = e6;
                BLog.b(f15176a, "Could not convert class", e);
                if (a != null) {
                    try {
                        a.close();
                        dictionaryItem = null;
                    } catch (Exception e7) {
                        dictionaryItem = null;
                    }
                    if (dictionaryItem == null) {
                        return dictionaryItem.mDictionary;
                    }
                    return null;
                }
                dictionaryItem = null;
                if (dictionaryItem == null) {
                    return null;
                }
                return dictionaryItem.mDictionary;
            }
        } catch (JsonParseException e8) {
            e = e8;
            a = null;
            BLog.b(f15176a, "Could not parse data", e);
            if (a != null) {
                a.close();
                dictionaryItem = null;
                if (dictionaryItem == null) {
                    return dictionaryItem.mDictionary;
                }
                return null;
            }
            dictionaryItem = null;
            if (dictionaryItem == null) {
                return null;
            }
            return dictionaryItem.mDictionary;
        } catch (IOException e9) {
            e = e9;
            a = null;
            BLog.b(f15176a, "Could not convert class", e);
            if (a != null) {
                a.close();
                dictionaryItem = null;
                if (dictionaryItem == null) {
                    return dictionaryItem.mDictionary;
                }
                return null;
            }
            dictionaryItem = null;
            if (dictionaryItem == null) {
                return null;
            }
            return dictionaryItem.mDictionary;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        if (dictionaryItem == null) {
            return null;
        }
        return dictionaryItem.mDictionary;
    }

    public final void m19186b(int i) {
        String e = this.f15177b.m19182e(0, i);
        if (e != null) {
            Map a = m19183a(e);
            if (a != null) {
                DataManagerUtil dataManagerUtil = this.f15177b;
                Map a2 = dataManagerUtil.f15169b.m19162a(i);
                SQLiteDatabase a3 = dataManagerUtil.f15169b.a();
                for (Entry entry : a.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!a2.containsKey(str)) {
                        String b = DataManagerUtil.m19169b((String) entry.getValue());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Columns.f15161b.d, Integer.valueOf(i));
                        contentValues.put(Columns.f15162c.d, str);
                        contentValues.put(Columns.f15163d.d, b);
                        SQLiteDetour.a(-1412362190);
                        a3.insert("dictionary_table", null, contentValues);
                        SQLiteDetour.a(1955813445);
                    }
                }
            }
        }
    }
}
