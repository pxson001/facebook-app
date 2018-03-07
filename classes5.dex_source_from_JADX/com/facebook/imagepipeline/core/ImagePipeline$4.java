package com.facebook.imagepipeline.core;

import bolts.Continuation;
import bolts.Task;
import com.facebook.datasource.SimpleDataSource;

/* compiled from: TRANSPARENT */
class ImagePipeline$4 implements Continuation<Boolean, Void> {
    final /* synthetic */ SimpleDataSource f13691a;
    final /* synthetic */ ImagePipeline f13692b;

    ImagePipeline$4(ImagePipeline imagePipeline, SimpleDataSource simpleDataSource) {
        this.f13692b = imagePipeline;
        this.f13691a = simpleDataSource;
    }

    public final Object m23018a(Task task) {
        SimpleDataSource simpleDataSource = this.f13691a;
        boolean z = (task.a() || task.b() || !((Boolean) task.c()).booleanValue()) ? false : true;
        simpleDataSource.m4032b(Boolean.valueOf(z));
        return null;
    }
}
