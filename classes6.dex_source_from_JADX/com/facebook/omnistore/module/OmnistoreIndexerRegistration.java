package com.facebook.omnistore.module;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.contacts.omnistore.ContactIndexerFunction;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.IndexedFields;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
@Deprecated
/* compiled from: tempFile is null */
public class OmnistoreIndexerRegistration {
    private static final IndexedFields EMPTY_FIELDS = new IndexedFields();
    private static final String TAG = OmnistoreIndexerRegistration.class.getName();
    private static final Object f3210xb08b7b44 = new Object();
    private final Set<IndexerFunctionMultibindWrapper> mCollectionIndexerFunctionWrappers;
    private final AbstractFbErrorReporter mFbErrorReporter;
    @Nullable
    private ImmutableMultimap<CollectionName, IndexerFunction> mIndexerFunctions;

    /* compiled from: tempFile is null */
    public final class CollectionIndexingFunction {
        public final CollectionName mCollectionName;
        public final ContactIndexerFunction mIndexerFunction;

        public CollectionIndexingFunction(CollectionName collectionName, ContactIndexerFunction contactIndexerFunction) {
            this.mCollectionName = collectionName;
            this.mIndexerFunction = contactIndexerFunction;
        }
    }

    /* compiled from: tempFile is null */
    public final class IndexEntry {
        public final String indexType;
        public final String indexValue;

        public IndexEntry(String str, String str2) {
            this.indexType = str;
            this.indexValue = str2;
        }
    }

    /* compiled from: tempFile is null */
    public final class IndexerFunctionMultibindWrapper {
        public final Lazy<CollectionIndexingFunction> mLazy;

        public IndexerFunctionMultibindWrapper(Lazy<CollectionIndexingFunction> lazy) {
            this.mLazy = lazy;
        }
    }

    private static OmnistoreIndexerRegistration m4249xf97927c9(InjectorLike injectorLike) {
        return new OmnistoreIndexerRegistration(C0178x55cda8c3.getSet(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.omnistore.module.OmnistoreIndexerRegistration m4250xf8a12fa3(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f3210xb08b7b44;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m4249xf97927c9(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3210xb08b7b44;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.omnistore.module.OmnistoreIndexerRegistration) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.omnistore.module.OmnistoreIndexerRegistration) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f3210xb08b7b44;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.omnistore.module.OmnistoreIndexerRegistration) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.module.OmnistoreIndexerRegistration.getInstance__com_facebook_omnistore_module_OmnistoreIndexerRegistration__INJECTED_BY_TemplateInjector(com.facebook.inject.InjectorLike):com.facebook.omnistore.module.OmnistoreIndexerRegistration");
    }

    @Inject
    public OmnistoreIndexerRegistration(Set<IndexerFunctionMultibindWrapper> set, FbErrorReporter fbErrorReporter) {
        this.mCollectionIndexerFunctionWrappers = set;
        this.mFbErrorReporter = fbErrorReporter;
    }

    @Deprecated
    public IndexedFields getIndexedFields(CollectionName collectionName, String str, String str2, ByteBuffer byteBuffer) {
        Iterator it;
        if (this.mIndexerFunctions == null) {
            Builder c = ImmutableMultimap.c();
            for (IndexerFunctionMultibindWrapper indexerFunctionMultibindWrapper : this.mCollectionIndexerFunctionWrappers) {
                CollectionIndexingFunction collectionIndexingFunction = (CollectionIndexingFunction) indexerFunctionMultibindWrapper.mLazy.get();
                c.b(collectionIndexingFunction.mCollectionName, collectionIndexingFunction.mIndexerFunction);
            }
            this.mIndexerFunctions = c.b();
        }
        if (!this.mIndexerFunctions.f(collectionName)) {
            return EMPTY_FIELDS;
        }
        HashSet hashSet;
        HashMap hashMap = new HashMap();
        it = ((ImmutableCollection) Preconditions.checkNotNull(this.mIndexerFunctions.h(collectionName))).iterator();
        while (it.hasNext()) {
            try {
                for (IndexEntry indexEntry : ((ContactIndexerFunction) it.next()).addIndexEntries(collectionName, str, str2, byteBuffer)) {
                    hashSet = (HashSet) hashMap.get(indexEntry.indexType);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        hashMap.put(indexEntry.indexType, hashSet);
                    }
                    hashSet.add(indexEntry.indexValue);
                }
            } catch (Throwable th) {
                this.mFbErrorReporter.a(TAG, "Exception during indexing collection : " + collectionName.toString(), th);
            }
        }
        IndexedFields indexedFields = new IndexedFields();
        for (Entry entry : hashMap.entrySet()) {
            hashSet = (HashSet) entry.getValue();
            String[] strArr = new String[hashSet.size()];
            hashSet.toArray(strArr);
            indexedFields.setFieldValues((String) entry.getKey(), strArr);
        }
        return indexedFields;
    }
}
