package net.slipp.kotlin.stalk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.slipp.kotlin.stalk.R;
import net.slipp.kotlin.stalk.listener.JOnItemClickListener;
import net.slipp.kotlin.stalk.vo.JMember;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rudia on 2018-08-22.
 */
public class JMainUserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<JMember> itemList;
    private JOnItemClickListener listener;

    public JMainUserAdapter(Context context, List<JMember> itemList, JOnItemClickListener listener) {
        this.context = context;
        this.itemList = new ArrayList<>();
        this.itemList.addAll(itemList);
        this.listener = listener;
    }

    public ArrayList<JMember> getList() {
        return itemList;
    }

    public void setItemList(ArrayList<JMember> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindItemView(holder, position);
    }

    void onBindItemView(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        ((ViewHolder) holder).position = position;

        final JMember item = itemList.get(position);
        viewHolder.tvUserName.setText(context.getString(R.string.friend_list,item.getNickName(), item.getName()));
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvUserName)
        TextView tvUserName;

        int position;

        @OnClick(R.id.layer_content)
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClickPosition(itemList.get(position));
            }
        }

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
