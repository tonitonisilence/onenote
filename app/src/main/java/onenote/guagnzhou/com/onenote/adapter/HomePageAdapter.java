package onenote.guagnzhou.com.onenote.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import onenote.guagnzhou.com.onenote.R;
import onenote.guagnzhou.com.onenote.model.NoteInfoBean;
import onenote.guagnzhou.com.onenote.views.CircleImageView;


public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    private Context mContext;
    RecyclerView recyclerView;
    private List<NoteInfoBean> noteInfoBeans = new ArrayList<NoteInfoBean>();

    public HomePageAdapter(Context context, List<NoteInfoBean> arraylist) {

        mContext = context;
        this.recyclerView = recyclerView;
        this.noteInfoBeans = arraylist;
    }

    @Override
    public int getItemCount() {
        return noteInfoBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        return noteInfoBeans.get(position).getType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        layout =  R.layout.adapter_homepage;
        //可在不同位置设置不同的配置文件
        switch (viewType) {
        }
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder  viewHolder, int position) {
        NoteInfoBean noteInfoBean = noteInfoBeans.get(position);
        viewHolder.textTitle.setText(noteInfoBean.getTitle());
        viewHolder.ivPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.iv_pic_home));
    }



    class ViewHolder  extends RecyclerView.ViewHolder{
        @Bind(R.id.iv_photo)
        ImageView ivPhoto;
        @Bind(R.id.text_title)
        TextView textTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}