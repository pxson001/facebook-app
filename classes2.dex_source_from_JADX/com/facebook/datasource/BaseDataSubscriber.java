package com.facebook.datasource;

/* compiled from: media_question_photo_size */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    protected abstract void mo2803e(DataSource<T> dataSource);

    protected abstract void mo2804f(DataSource<T> dataSource);

    public final void mo2805a(DataSource<T> dataSource) {
        boolean b = dataSource.mo2784b();
        try {
            mo2803e(dataSource);
        } finally {
            if (b) {
                dataSource.mo2782g();
            }
        }
    }

    public final void mo2806b(DataSource<T> dataSource) {
        try {
            mo2804f(dataSource);
        } finally {
            dataSource.mo2782g();
        }
    }

    public final void mo2807c(DataSource<T> dataSource) {
    }

    public void mo2802d(DataSource<T> dataSource) {
    }
}
