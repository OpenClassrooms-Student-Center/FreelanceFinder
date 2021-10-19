package com.kirabium.freelancefinder.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.kirabium.freelancefinder.model.Freelance;
import com.kirabium.freelancefinder.service.FreelanceRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewModelFreelance extends ViewModel {
    private final FreelanceRepository repository;


    public ViewModelFreelance() {
        repository = FreelanceRepository.getInstance();
    }

    //Mapping data from remote source to view data, ask to your mentor to know why it is important to do so
    private LiveData<List<FreelanceStateItem>> mapDataToViewState(LiveData<List<Freelance>> freelances) {
        return Transformations.map(freelances, freelance -> {
            List<FreelanceStateItem> freelanceViewStateItems = new ArrayList<>();
            for (Freelance f : freelance) {
                freelanceViewStateItems.add(
                        new FreelanceStateItem(f)
                );
            }
            return freelanceViewStateItems;
        });
    }

    public LiveData<List<FreelanceStateItem>> getAllFreelances() {
        return mapDataToViewState(repository.getAllFreelances());
    }

    public LiveData<List<FreelanceStateItem>> getAllFreelancesSortedByTJM() {
        return mapDataToViewState(repository.getAllFreelancesSortedByTJM());

    }
    public LiveData<List<FreelanceStateItem>> getAllFreelancesSortedByCity() {
        return mapDataToViewState(repository.getAllFreelancesSortedByCity());

    }
}