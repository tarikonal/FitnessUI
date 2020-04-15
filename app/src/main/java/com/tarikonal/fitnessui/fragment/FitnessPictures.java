package com.tarikonal.fitnessui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tarikonal.fitnessui.FitnessMove;
import com.tarikonal.fitnessui.PopupActivity;
import com.tarikonal.fitnessui.R;
import com.tarikonal.fitnessui.recyclerview.FitnessPictureAdapter;

import java.util.ArrayList;

public class FitnessPictures extends Fragment implements  FitnessPictureAdapter.MyListener {
    private FitnessPictureAdapter fitnessPictureAdapter;
    RecyclerView recyclerView;
    ArrayList<FitnessMove> fitnessMoves;

    public static FitnessPictures newInstance(){
        return new FitnessPictures();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fitness_pictures,container,false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(),this);
        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();
        recyclerView = rootView.findViewById(R.id.fragment_fitness_pictures_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        if(isAdded()) {
            recyclerView.setAdapter(fitnessPictureAdapter);
        }
        getFitnessMoves(fitnessMoves);
        return rootView;
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves){
        //"https://images2.alphacoders.com/491/491173.jpg",
        //http://www.atilsamancioglu.com/wp-content/uploads/2018/06/fitness"+i+".jpg",
        for (int i=0;i<16;i++) {
            fitnessMoves.add(new FitnessMove("Fitness Move Name "+i,
                    "https://images2.alphacoders.com/491/491173.jpg",
                    "Fitness Move Description"+i,
                    100 + i));

        }
        return fitnessMoves;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {
        System.out.println("Fitness Move:"+fitnessMove.getFitnessName());
        Intent intent = PopupActivity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);
    }
}
