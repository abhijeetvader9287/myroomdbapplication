package com.abhijeet.myroomdbapplication;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abhijeet.myroomdbapplication.Database.DBModels.NotificationModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * The type Message adapter.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> implements Filterable {
    /**
     * The Filter list.
     */
    final List<NotificationModel> filterList;
    /**
     * The Context.
     */
    final Context context;
    /**
     * The Message model list.
     */
    List<NotificationModel> messageModelList;
    /**
     * The Filter.
     */
    SearchMessageFilter filter;
    /**
     * The Gson.
     */
    Gson gson=new Gson();

    /**
     * Instantiates a new Message adapter.
     *
     * @param context          the context
     * @param messageModelList the message model list
     */
    public MessageAdapter(Context context, List<NotificationModel> messageModelList) {
        this.messageModelList = messageModelList;
        filterList = messageModelList;
        this.context = context;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_message_list_item, parent, false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, final int position) {
        NotificationModel model = messageModelList.get(position);
        holder.textTitle.setText(model.getTitle());
        holder.textMessage.setText(model.getMessage());

    }


    @Override
    public int getItemCount() {
        return messageModelList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new SearchMessageFilter((ArrayList<NotificationModel>) filterList, this);
        }
        return filter;
    }

    /**
     * Remove item.
     *
     * @param position the position
     */
    public void removeItem(int position) {
        messageModelList.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * Restore item.
     *
     * @param item     the item
     * @param position the position
     */
    public void restoreItem(NotificationModel item, int position) {
        messageModelList.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

    /**
     * The type Message view holder.
     */
    public class MessageViewHolder extends RecyclerView.ViewHolder {
        /**
         * The View background.
         */
        @BindView(R.id.view_background_MessageListItem)
        public RelativeLayout viewBackground;
        /**
         * The View foreground.
         */
        @BindView(R.id.view_foreground_MessageListItem)
        public LinearLayout viewForeground;
        /**
         * The Text title.
         */
        @BindView(R.id.txtTitle_MessageListItem)
        TextView textTitle;
        /**
         * The Text date.
         */
        @BindView(R.id.txtDate_MessageListItem)
        TextView textDate;
        /**
         * The Text message.
         */
        @BindView(R.id.txtMessage_MessageListItem)
        TextView textMessage;
        /**
         * The Image main.
         */
        @BindView(R.id.img_MessageListItem)
        ImageView imageMain;
        /**
         * The Image type.
         */
        @BindView(R.id.imgType_MessageListItem)
        ImageView imageType;
        /**
         * The Relative layout.
         */
        @BindView(R.id.layNext_MessageListItem)
        RelativeLayout relativeLayout;

        /**
         * Instantiates a new Message view holder.
         *
         * @param view the view
         */
        MessageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * The type Search message filter.
     */
    class SearchMessageFilter extends Filter {
        /**
         * The Message adapter.
         */
        final MessageAdapter messageAdapter;
        /**
         * The Filter list.
         */
        final ArrayList<NotificationModel> filterList;

        /**
         * Instantiates a new Search message filter.
         *
         * @param filterList     the filter list
         * @param messageAdapter the message adapter
         */
        SearchMessageFilter(ArrayList<NotificationModel> filterList, MessageAdapter messageAdapter) {
            this.messageAdapter = messageAdapter;
            this.filterList = filterList;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<NotificationModel> filteredContactUserModels = new ArrayList<>();
                for (int i = 0; i < filterList.size(); i++) {
                    if ((filterList.get(i).getTitle().toUpperCase().contains(constraint))
                            || (filterList.get(i).getMessage().toUpperCase().contains(constraint))) {
                        filteredContactUserModels.add(filterList.get(i));
                    }
                }
                results.count = filteredContactUserModels.size();
                results.values = filteredContactUserModels;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            messageAdapter.messageModelList = (ArrayList<NotificationModel>) results.values;
            messageAdapter.notifyDataSetChanged();
        }
    }
}