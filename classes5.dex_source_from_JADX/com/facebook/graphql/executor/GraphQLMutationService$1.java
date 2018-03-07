package com.facebook.graphql.executor;

/* compiled from: lightweight_place_picker_session_id */
class GraphQLMutationService$1 implements Runnable {
    final /* synthetic */ long f3199a;
    final /* synthetic */ int f3200b;
    final /* synthetic */ GraphQLMutationService f3201c;

    GraphQLMutationService$1(GraphQLMutationService graphQLMutationService, long j, int i) {
        this.f3201c = graphQLMutationService;
        this.f3199a = j;
        this.f3200b = i;
    }

    public void run() {
        try {
            GraphQLMutationService.a(this.f3201c, this.f3199a);
        } finally {
            GraphQLMutationService.b(this.f3201c, this.f3200b, this.f3199a);
        }
    }
}
