package com.example.madproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    EditText locationInput, dateInput, guestsInput;
    Button searchButton;

    RecyclerView popularCitiesRecycler, favoritePlacesRecycler;
    CityAdapter cityAdapter;
    PlaceAdapter placeAdapter;
    List<City> cityList;
    List<Place> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inputs and search
        locationInput = findViewById(R.id.locationInput);
        dateInput = findViewById(R.id.dateInput);
        guestsInput = findViewById(R.id.guestsInput);
        searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(v -> {
            String location = locationInput.getText().toString();
            String date = dateInput.getText().toString();
            String guests = guestsInput.getText().toString();
            Toast.makeText(this, "Searching: " + location, Toast.LENGTH_SHORT).show();
        });

        // RecyclerViews
        popularCitiesRecycler = findViewById(R.id.popularCitiesRecycler);
        favoritePlacesRecycler = findViewById(R.id.favoritePlacesRecyclerView);

        // Setup Popular Cities
        cityList = new ArrayList<>();
        cityList.add(new City(R.drawable.kolkata, "Kolkata"));
        cityList.add(new City(R.drawable.gulmarg, "Jammu&Kashmir"));
        cityList.add(new City(R.drawable.jaipur, "Jaipur"));
        cityList.add(new City(R.drawable.srinagar, "Jammu&Kashmir"));

        cityAdapter = new CityAdapter(cityList);
        popularCitiesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        popularCitiesRecycler.setAdapter(cityAdapter);

        // Setup Favorite Places
        placeList = new ArrayList<>();
        placeList.add(new Place(R.drawable.gulmarg, "Gulmarg"));
        placeList.add(new Place(R.drawable.jaipur, "Amber Palace"));
        placeList.add(new Place(R.drawable.kolkata, "Victoria Memorial"));
        placeList.add(new Place(R.drawable.dal_lake,"Dal Lake"));

        placeAdapter = new PlaceAdapter(placeList);
        favoritePlacesRecycler.setLayoutManager(new GridLayoutManager(this, 2));

        favoritePlacesRecycler.setAdapter(placeAdapter);
    }
}
