package com.kirabium.freelancefinder.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kirabium.freelancefinder.R;
import com.kirabium.freelancefinder.ViewModelFactory;
import com.kirabium.freelancefinder.model.Freelance;
import com.kirabium.freelancefinder.service.FirebaseHelper;


public class MainActivity extends AppCompatActivity {

    private ViewModelFreelance viewModel;
    private FreelanceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }


    private void initUI() {
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }


    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.freelance_rv);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(ViewModelFreelance.class);
        adapter = new FreelanceAdapter();
        recyclerView.setAdapter(adapter);
        getBaseList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sort_city:
                sortListByCity();
                return true;
            case R.id.sort_tjm:
                sortListByTJM();
                return true;
            case R.id.reset_sort:
                getBaseList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getBaseList() {
        viewModel.getAllFreelances().observe(this, adapter::submitList);
    }

    private void sortListByTJM() {
        viewModel.getAllFreelancesSortedByTJM().observe(this, adapter::submitList);
    }

    private void sortListByCity() {
        viewModel.getAllFreelancesSortedByCity().observe(this, adapter::submitList);
    }

}