package com.example.onlinestore.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinestore.R;
import com.example.onlinestore.adapters.HomeAdapter;
import com.example.onlinestore.adapters.PopularAdapters;
import com.example.onlinestore.adapters.RecommendedAdapter;

import com.example.onlinestore.models.HomeCategory;
import com.example.onlinestore.models.PopularModel;
import com.example.onlinestore.models.RecommendedModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;



import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends  Fragment {

    private HomeViewModel homeViewModel;

    ScrollView scrollView;
    ProgressBar progressBar;
    RecyclerView popularRec,homeCatRec,recommendedRec;
    FirebaseFirestore db;

    List<PopularModel> popularModelList;
    PopularAdapters popularAdapters;

    //Home Category
    List<HomeCategory> categoryList;
    HomeAdapter homeAdapter;

    //Recommended
    List<RecommendedModel> recommendedModelList;
    RecommendedAdapter recommendedAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View root=inflater.inflate(R.layout.fragment_home,container,false);
        db= FirebaseFirestore.getInstance();
        popularRec=root.findViewById(R.id.poprec);
        homeCatRec=root.findViewById(R.id.explore_rec);
        //recommendedRec=root.findViewById(R.id.recommended_rec);
        scrollView=root.findViewById(R.id.scroll_view);
       // progressBar=root.findViewById(R.id.progressbar);

        //progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        //popular items

        popularRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        popularModelList=new ArrayList<>();
        popularAdapters= new PopularAdapters(getActivity(),popularModelList);
        popularRec.setAdapter(popularAdapters);
        db.collection("PopularProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                PopularModel popularModel=document.toObject(PopularModel.class);
                                popularModelList.add(popularModel);
                                popularAdapters.notifyDataSetChanged();

                               // progressBar.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        //Home Category
        homeCatRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryList=new ArrayList<>();
        homeAdapter= new HomeAdapter(getActivity(),categoryList);
        homeCatRec.setAdapter(homeAdapter);
        db.collection("HomeCategory")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                HomeCategory homeCategory=document.toObject(HomeCategory.class);
                                categoryList.add(homeCategory);
                                homeAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //Recommended items
//        recommendedRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
//        recommendedModelList=new ArrayList<>();
//        recommendedAdapter= new RecommendedAdapter(getActivity(),recommendedModelList);
//        recommendedRec.setAdapter(recommendedAdapter);
//        db.collection("Recommended")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//
//                            RecommendedModel recommendedModel=document.toObject(RecommendedModel.class);
//                            recommendedModelList.add(recommendedModel);
//                            recommendedAdapter.notifyDataSetChanged();
//                        }
//                    } else {
//                        Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        com.example.onlinestore.databinding.FragmentHomeBinding binding = null;
    }
}