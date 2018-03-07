package com.facebook.graphql.calls;

/* compiled from: progress_text */
public final class LightweightEventDeleteInputData extends GraphQlMutationCallInput {

    /* compiled from: progress_text */
    public final class Context extends GraphQlCallInput {

        /* compiled from: progress_text */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4451a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4452b(String str) {
                a("mechanism", str);
                return this;
            }
        }
    }
}
