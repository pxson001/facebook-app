package com.facebook.vault.service;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.vault.constants.VaultConstants;
import com.facebook.vault.protocol.VaultGetSyncedImageStatus;
import com.facebook.vault.protocol.VaultGetSyncedImageStatusMethod;
import com.facebook.vault.protocol.VaultGetSyncedImageStatusParams;
import com.facebook.vault.protocol.VaultGetSyncedImageStatusResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: first_and_last */
public class VaultImageStatusFetcher {
    private static final String f11587a = VaultImageStatusFetcher.class.getSimpleName();
    private final AbstractSingleMethodRunner f11588b;
    private final VaultGetSyncedImageStatusMethod f11589c;
    private final VaultConstants f11590d;
    private final AbstractFbErrorReporter f11591e;

    public static VaultImageStatusFetcher m12078b(InjectorLike injectorLike) {
        return new VaultImageStatusFetcher((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new VaultGetSyncedImageStatusMethod((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike)), new VaultConstants(), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public VaultImageStatusFetcher(AbstractSingleMethodRunner abstractSingleMethodRunner, VaultGetSyncedImageStatusMethod vaultGetSyncedImageStatusMethod, VaultConstants vaultConstants, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11588b = abstractSingleMethodRunner;
        this.f11589c = vaultGetSyncedImageStatusMethod;
        this.f11590d = vaultConstants;
        this.f11591e = abstractFbErrorReporter;
    }

    public final Map<String, VaultGetSyncedImageStatus> m12080a(Set<String> set, long j) {
        if (set == null || set.size() == 0) {
            return Collections.emptyMap();
        }
        Set hashSet = new HashSet();
        if (set.size() <= 100) {
            return m12079b(set, j);
        }
        Map<String, VaultGetSyncedImageStatus> c = Maps.c();
        for (String add : set) {
            hashSet.add(add);
            if (hashSet.size() == 100) {
                new StringBuilder("dispatching a set of ").append(hashSet.size()).append(" images");
                c.putAll(m12079b(hashSet, j));
                hashSet.clear();
            }
        }
        if (hashSet.size() > 0) {
            c.putAll(m12079b(hashSet, j));
        }
        return c;
    }

    private Map<String, VaultGetSyncedImageStatus> m12079b(Set<String> set, long j) {
        VaultGetSyncedImageStatusParams vaultGetSyncedImageStatusParams = new VaultGetSyncedImageStatusParams(j, set, 0);
        Maps.c();
        try {
            Map<String, VaultGetSyncedImageStatus> a = ((VaultGetSyncedImageStatusResult) this.f11588b.a(this.f11589c, vaultGetSyncedImageStatusParams)).a();
            Integer.valueOf(a.size());
            return a;
        } catch (Throwable e) {
            BLog.b(f11587a, "getImageStatus", e);
            this.f11591e.a("vault_local_image_status_api exception", e.getMessage(), e);
            return Collections.emptyMap();
        }
    }
}
