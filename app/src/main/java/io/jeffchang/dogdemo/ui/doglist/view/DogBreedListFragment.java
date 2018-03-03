package io.jeffchang.dogdemo.ui.doglist.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.jeffchang.dogdemo.R;
import io.jeffchang.dogdemo.ui.common.BaseFragment;

/**
 * Fragment that displays a list of dog breeds.
 */

public class DogBreedListFragment extends BaseFragment implements DogBreedListView{

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_list;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onDogBreedListSuccess() {

    }

    @Override
    public void onDogBreedListFailure() {

    }
}
