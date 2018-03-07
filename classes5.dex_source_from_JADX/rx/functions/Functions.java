package rx.functions;

import com.facebook.graphql.executor.RequestObservable$5;
import com.facebook.graphql.executor.RequestObservable$6;

/* compiled from: can_cast_video */
public final class Functions {

    /* compiled from: can_cast_video */
    public final class C08733 implements FuncN<R> {
        final /* synthetic */ RequestObservable$5 f7700a;

        public C08733(RequestObservable$5 requestObservable$5) {
            this.f7700a = requestObservable$5;
        }

        public final R mo1023a(Object... objArr) {
            if (objArr.length != 2) {
                throw new RuntimeException("Func2 expecting 2 arguments.");
            }
            RequestObservable$5 requestObservable$5 = this.f7700a;
            return requestObservable$5.f3233a.m6292a(objArr[0], objArr[1]);
        }
    }

    /* compiled from: can_cast_video */
    public final class C08744 implements FuncN<R> {
        final /* synthetic */ RequestObservable$6 f7701a;

        public C08744(RequestObservable$6 requestObservable$6) {
            this.f7701a = requestObservable$6;
        }

        public final R mo1023a(Object... objArr) {
            if (objArr.length != 3) {
                throw new RuntimeException("Func3 expecting 3 arguments.");
            }
            RequestObservable$6 requestObservable$6 = this.f7701a;
            return requestObservable$6.f3234a.a(objArr[0], objArr[1], objArr[2]);
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }
}
