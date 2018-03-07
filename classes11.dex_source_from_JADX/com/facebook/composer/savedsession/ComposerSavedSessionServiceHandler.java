package com.facebook.composer.savedsession;

import android.content.ContentValues;
import android.content.Context;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.publish.cache.db.ComposerDbSchemaPart.SessionsTable.Columns;
import com.facebook.composer.publish.cache.db.DbComposerHandler;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchRelayQuery */
public class ComposerSavedSessionServiceHandler implements BlueServiceHandler {
    private static ComposerSavedSessionServiceHandler f6937c;
    private static final Object f6938d = new Object();
    public final Lazy<DbComposerHandler> f6939a;
    public final FbObjectMapper f6940b;

    private static ComposerSavedSessionServiceHandler m8258b(InjectorLike injectorLike) {
        return new ComposerSavedSessionServiceHandler(IdBasedSingletonScopeProvider.b(injectorLike, 860), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerSavedSessionServiceHandler(Lazy<DbComposerHandler> lazy, FbObjectMapper fbObjectMapper) {
        this.f6939a = lazy;
        this.f6940b = fbObjectMapper;
    }

    public final OperationResult m8259a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("composer_save_session".equals(str)) {
            ComposerSavedSession composerSavedSession = (ComposerSavedSession) operationParams.c.getParcelable("saveSession");
            if (composerSavedSession != null) {
                String a = this.f6940b.a(composerSavedSession);
                DbComposerHandler dbComposerHandler = (DbComposerHandler) this.f6939a.get();
                dbComposerHandler.e.b();
                Preconditions.checkNotNull(a);
                dbComposerHandler.c();
                ContentValues contentValues = new ContentValues();
                contentValues.put(Columns.a.toString(), a);
                SQLiteDetour.a(-66702956);
                dbComposerHandler.d.a().replaceOrThrow("drafts", "", contentValues);
                SQLiteDetour.a(-1924238770);
            }
            return OperationResult.a;
        } else if ("composer_delete_session".equals(str)) {
            m8261b();
            return OperationResult.a;
        } else {
            throw new IllegalArgumentException("Unknown type: " + str);
        }
    }

    public final Optional<ComposerSavedSession> m8260a() {
        return Optional.fromNullable(this.f6940b.a(((DbComposerHandler) this.f6939a.get()).b(), ComposerSavedSession.class));
    }

    public static ComposerSavedSessionServiceHandler m8257a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ComposerSavedSessionServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6938d) {
                ComposerSavedSessionServiceHandler composerSavedSessionServiceHandler;
                if (a2 != null) {
                    composerSavedSessionServiceHandler = (ComposerSavedSessionServiceHandler) a2.a(f6938d);
                } else {
                    composerSavedSessionServiceHandler = f6937c;
                }
                if (composerSavedSessionServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8258b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6938d, b3);
                        } else {
                            f6937c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = composerSavedSessionServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m8261b() {
        ((DbComposerHandler) this.f6939a.get()).c();
    }
}
