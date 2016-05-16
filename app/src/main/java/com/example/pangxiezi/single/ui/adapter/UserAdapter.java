package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pangxiezi.single.R;

import java.util.Collection;
import java.util.List;

/**
 * Created by COSCO on 2016/3/16.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> implements View.OnClickListener {

    private List<String> userDatas;
    private Context context;

    private OnChildClickListener listener;
    private RecyclerView recyclerView;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public UserAdapter(List<String> userDatas, Context context) {
        this.userDatas = userDatas;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        view.setOnClickListener(this);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.userTxt.setText(userDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return userDatas != null ? userDatas.size() : 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            int position = recyclerView.getChildAdapterPosition(v);
            listener.onChildCliCK(v, position, userDatas.get(position));
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private final TextView userTxt;

        public UserViewHolder(View itemView) {
            super(itemView);
            userTxt = ((TextView) itemView.findViewById(R.id.user_txt));

        }
    }

    public interface OnChildClickListener {
        void onChildCliCK(View child, int position, String userItem);
    }

}
