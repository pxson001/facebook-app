package com.facebook.graphql.calls;

/* compiled from: quick_promotion_items */
public class EventThemeEventInfoInputData extends GraphQlMutationCallInput {

    /* compiled from: quick_promotion_items */
    public class EventInfo extends GraphQlCallInput {
        public final EventInfo m4402a(String str) {
            a("name", str);
            return this;
        }

        public final EventInfo m4403b(String str) {
            a("description", str);
            return this;
        }
    }
}
