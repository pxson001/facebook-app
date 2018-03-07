package com.facebook.graphql.executor;

/* compiled from: lightweight_place_picker_session_id */
class GraphQLMutationService$2 implements Runnable {
    final /* synthetic */ GraphQLMutationService f3202a;

    GraphQLMutationService$2(GraphQLMutationService graphQLMutationService) {
        this.f3202a = graphQLMutationService;
    }

    public void run() {
        synchronized (this.f3202a) {
            if (this.f3202a.h == 0) {
                Integer.valueOf(this.f3202a.i);
                this.f3202a.stopSelf(this.f3202a.i);
            }
        }
    }
}
