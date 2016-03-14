package onenote.guagnzhou.com.onenote.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import onenote.guagnzhou.com.onenote.R;
import onenote.guagnzhou.com.onenote.model.MenuBean;
import onenote.guagnzhou.com.onenote.views.CircleImageView;


public class MenuAdapter extends ArrayAdapter<MenuBean> {

    private LayoutInflater mInflater;
    private Context mContext;
    ListView mListView;
    private Intent intent = new Intent();
    private Activity activity;
    private List<MenuBean> menuBeans = new ArrayList<MenuBean>();

    public MenuAdapter(Context context, List<MenuBean> arraylist,
                       ListView listview) {

        super(context, 0, arraylist);
        mContext = context;
        mInflater = (LayoutInflater) context
                .getSystemService("layout_inflater");
        mListView = listview;
        this.menuBeans = arraylist;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            // 这里是我们的item
            convertView = mInflater.inflate(
                    R.layout.adapter_menu, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MenuBean item = menuBeans.get(position);

        holder.textTitle.setText(item.getTitle());
        if (item.getId().equals("1")) {
            holder.llText.setVisibility(View.GONE);
            holder.mFrameLayout.setVisibility(View.VISIBLE);
            holder.ivPhoto.setImageDrawable(mContext.getDrawable(R.mipmap.iv_default_photo));
        } else {
            holder.llText.setVisibility(View.VISIBLE);
            holder.mFrameLayout.setVisibility(View.GONE);
        }

        if (item.getId().equals("2"))
            holder.ivIcon.setImageDrawable(mContext.getDrawable(R.mipmap.ic_leftview_home));
        else if (item.getId().equals("3"))
            holder.ivIcon.setImageDrawable(mContext.getDrawable(R.mipmap.ic_leftview_circle));
        else if (item.getId().equals("4"))
            holder.ivIcon.setImageDrawable(mContext.getDrawable(R.mipmap.ic_leftview_friends));
        else if (item.getId().equals("5"))
            holder.ivIcon.setImageDrawable(mContext.getDrawable(R.mipmap.ic_leftview_settings));


        return convertView;

    }


    public static class ViewHolder {
        @Bind(R.id.iv_photo)
        CircleImageView ivPhoto;
        @Bind(R.id.ll_photo)
        LinearLayout llPhoto;
        @Bind(R.id.mFrameLayout)
        FrameLayout mFrameLayout;
        @Bind(R.id.text_title)
        TextView textTitle;
        @Bind(R.id.ll_text)
        LinearLayout llText;
        @Bind(R.id.ll_all)
        LinearLayout llAll;
        @Bind(R.id.iv_icon)
        ImageView ivIcon;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}