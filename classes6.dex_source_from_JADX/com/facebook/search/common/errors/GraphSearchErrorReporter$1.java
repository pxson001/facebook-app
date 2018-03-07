package com.facebook.search.common.errors;

import com.facebook.ui.toaster.ToastBuilder;

/* compiled from: ex_inner_msg */
public class GraphSearchErrorReporter$1 implements Runnable {
    final /* synthetic */ ToastBuilder f15852a;
    final /* synthetic */ GraphSearchErrorReporter f15853b;

    public GraphSearchErrorReporter$1(GraphSearchErrorReporter graphSearchErrorReporter, ToastBuilder toastBuilder) {
        this.f15853b = graphSearchErrorReporter;
        this.f15852a = toastBuilder;
    }

    public void run() {
        this.f15853b.c.b(this.f15852a);
    }
}
