package com.facebook.graphql.connection;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.Callbacks;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: windowRoundedCornerRadius */
public class SingletonConnectionFetcher {
    public final Callbacks f231a;
    public final ConnectionTailLoaderManagerProvider f232b;
    public final LocalModelCursorLoaderManagerProvider f233c;
    public Session f234d = null;

    /* compiled from: windowRoundedCornerRadius */
    final class Session {
        public final ConnectionTailLoaderManager f228a;
        public final LocalModelCursorLoaderManager f229b;
        final /* synthetic */ SingletonConnectionFetcher f230c;

        public Session(final SingletonConnectionFetcher singletonConnectionFetcher, String str, BatchConfiguration batchConfiguration) {
            this.f230c = singletonConnectionFetcher;
            this.f228a = singletonConnectionFetcher.f232b.m200a(str, batchConfiguration, new Callbacks(this) {
                final /* synthetic */ Session f227b;

                public final void mo8a(ModelCursor modelCursor) {
                    if (this.f227b.f230c.f234d == this.f227b) {
                        this.f227b.f230c.f231a.mo8a(modelCursor);
                    } else if (modelCursor != null) {
                        modelCursor.close();
                    }
                }

                public final void mo9a(Throwable th) {
                    if (this.f227b.f230c.f234d == this.f227b) {
                        this.f227b.f230c.f231a.mo9a(th);
                    }
                }

                public final void mo10a(boolean z) {
                    if (this.f227b.f230c.f234d == this.f227b) {
                        this.f227b.f230c.f231a.mo10a(z);
                    }
                }
            }, null);
            this.f229b = singletonConnectionFetcher.f233c.a(str, this.f228a);
        }

        public final void m204a() {
            this.f229b.a();
        }

        public final void m205b() {
            this.f229b.close();
        }
    }

    @Inject
    public SingletonConnectionFetcher(@Assisted Callbacks callbacks, ConnectionTailLoaderManagerProvider connectionTailLoaderManagerProvider, LocalModelCursorLoaderManagerProvider localModelCursorLoaderManagerProvider) {
        this.f231a = (Callbacks) Preconditions.checkNotNull(callbacks);
        this.f232b = connectionTailLoaderManagerProvider;
        this.f233c = localModelCursorLoaderManagerProvider;
    }

    public final synchronized void m207a(String str, BatchConfiguration batchConfiguration) {
        Session session = this.f234d;
        this.f234d = new Session(this, str, batchConfiguration);
        this.f234d.m204a();
        if (session != null) {
            session.m205b();
        }
    }

    public final synchronized void m206a() {
        if (this.f234d != null) {
            this.f234d.m205b();
            this.f234d = null;
        }
    }
}
