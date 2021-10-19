package com.kirabium.freelancefinder;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kirabium.freelancefinder.ui.main.ViewModelFreelance;


public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory();
                }
            }
        }
        return factory;
    }


    private ViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ViewModelFreelance.class)) {
            return (T) new ViewModelFreelance();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}