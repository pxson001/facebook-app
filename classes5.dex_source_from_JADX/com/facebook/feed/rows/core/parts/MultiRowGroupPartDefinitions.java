package com.facebook.feed.rows.core.parts;

import com.facebook.inject.Lazies;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;
import javax.inject.Provider;

/* compiled from: WWW_U2U_ANSWER_FEEDBACK */
public class MultiRowGroupPartDefinitions {

    /* compiled from: WWW_U2U_ANSWER_FEEDBACK */
    final class C11271 implements Provider<MultiRowGroupPartDefinition<T, ?, E>> {
        final /* synthetic */ Lazy f12257a;

        C11271(Lazy lazy) {
            this.f12257a = lazy;
        }

        public final Object get() {
            return new SingleChildMultiRowGroupPartDefinition((MultiRowSinglePartDefinition) this.f12257a.get());
        }
    }

    public static <T, E extends AnyEnvironment> Lazy<? extends MultiRowGroupPartDefinition<T, ?, E>> m20282a(Lazy<? extends SinglePartDefinitionWithViewTypeAndIsNeeded<T, ?, E, ?>> lazy) {
        return Lazies.m10019a(new C11271(lazy));
    }
}
