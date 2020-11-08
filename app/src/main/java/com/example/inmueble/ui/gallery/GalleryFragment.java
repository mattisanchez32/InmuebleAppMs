package com.example.inmueble.ui.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.inmueble.R;
import com.example.inmueble.ViewPageAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment implements ClienteFragment.OnFragmentInteractionListener {



    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private GalleryViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
        //galleryViewModel.getText().observe(this, new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
        //    }
        //});

        viewPager= root.findViewById(R.id.viewPager);
        appBarLayout = root.findViewById(R.id.appBar);
        tabLayout = new TabLayout(getContext());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(GalleryViewModel.class);

        viewModel.getAdapter().observe(getViewLifecycleOwner(), new Observer<ViewPageAdapter>() {
            @Override
            public void onChanged(ViewPageAdapter viewPageAdapter) {
                viewPager.setAdapter(viewPageAdapter);
            }
        });


        appBarLayout.addView(tabLayout);
        viewModel.cargarDatos(getParentFragmentManager());

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        //ViewPageAdapter vpa=new ViewPageAdapter(getChildFragmentManager());

        //vpa.addFragment(new ClienteFragment(),"Prop1");
        //vpa.addFragment(new ClienteFragment(),"Prop2");

        //viewPager.setAdapter(vpa);
        //tabLayout.setupWithViewPager(viewPager);







        return root;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*public class ViewPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragments = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int posicion){
            return titulosFragments.get(posicion);
        }

        public void addFragment(Fragment fragment,String titulo){
            fragmentList.add(fragment);
            titulosFragments.add(titulo);
        }

    }*/
}