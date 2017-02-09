package com.apptest.Users.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import rx.Observable;

/**
 * Created by Aditya on 07-May-16.
 */
@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {
    Observable observable();
}
