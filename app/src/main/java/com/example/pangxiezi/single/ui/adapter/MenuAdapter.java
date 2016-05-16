package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pangxiezi.single.R;

import java.util.List;


/**
 * Created by COSCO on 2016/3/15.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> implements View.OnClickListener {

    private List<String> menuDatas;
    private Context context;

    private RecyclerView recyclerView;
    private OnChildClickListener listener;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public MenuAdapter(List<String> menuDatas, Context context) {
        this.menuDatas = menuDatas;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        view.setOnClickListener(this);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.menuTxt.setText(menuDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return menuDatas != null ? menuDatas.size() : 0;
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
            listener.onChildClick(v, position, menuDatas.get(position));
        }
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        private final TextView menuTxt;

        public MenuViewHolder(View itemView) {
            super(itemView);
            menuTxt = ((TextView) itemView.findViewById(R.id.menu_txt));
        }
    }

    public interface OnChildClickListener{
        void onChildClick(View child, int position, String menuName);
    }

}
