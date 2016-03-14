package onenote.guagnzhou.com.onenote.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;
import in.srain.cube.views.ptr.header.MaterialProgressDrawable;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import onenote.guagnzhou.com.onenote.R;
import onenote.guagnzhou.com.onenote.adapter.HomePageAdapter;
import onenote.guagnzhou.com.onenote.config.ConstantsConfig;
import onenote.guagnzhou.com.onenote.views.SpacesItemDecoration;

public class HomePageFragment extends Fragment {
    @Bind(R.id.ll_all)
    LinearLayout llAll;

    private Activity activity;
    HomePageAdapter homePageAdapter;
    @Bind(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Bundle args = getArguments();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        this.activity = activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        ButterKnife.bind(this, view);
        //设置动画和类型
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);


        homePageAdapter = new HomePageAdapter(activity, ConstantsConfig.getNoteInfo(activity));
        mRecyclerView.setAdapter(homePageAdapter);


        initlisener();
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



    public void initlisener() {


    }



}

