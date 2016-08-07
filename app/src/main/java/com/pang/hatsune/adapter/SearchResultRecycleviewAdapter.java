package com.pang.hatsune.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pang.hatsune.R;
import com.pang.hatsune.info.gsonfactory.SearchResltInfo;

import java.util.List;

/**
 * Created by Pang on 2016/8/7.
 */
public class SearchResultRecycleviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //    SearchResltInfo info;
    List<SearchResltInfo.ResultBean.DataBean> list;
    Context context;
    private int TYPE_LOADING = 1;

    public SearchResultRecycleviewAdapter(List<SearchResltInfo.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LOADING) {
            View v = LayoutInflater.from(context).inflate(R.layout.loading, null, false);
            return new VH(v);
        }

        View v = LayoutInflater.from(context).inflate(R.layout.activity_search_result_list_item, null, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (list.get(position) == null) {
            return;
        }

        VH vh = (VH) holder;
//        vh.image.setImageURI(Uri.parse(list.get(position).getSound().getPic()));
        vh.desc.setText(list.get(position).getSound().getInfo());
        vh.title.setText(list.get(position).getSound().getName());
// info.getResult().getData().get(position).getSound().getSource();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) == null) {
            return TYPE_LOADING;
        }
        return super.getItemViewType(position);
    }

    public class VH extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView title;
        TextView desc;


        public VH(View itemView) {
            super(itemView);
            image = (SimpleDraweeView) itemView.findViewById(R.id.search_resutlt_item_image);
            title = (TextView) itemView.findViewById(R.id.search_resutlt_item_music_title);
            desc = (TextView) itemView.findViewById(R.id.search_resutlt_item_music_desc);
        }
    }
}