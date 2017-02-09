package com.apptest.sharedpreferences;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aditya on 07-May-16.
 */
@Singleton
@Component(modules = {SharedPreferenceModule.class})
public interface SharedPrerenceComponent {
    SharedPreferences getSharedPreference();
}
