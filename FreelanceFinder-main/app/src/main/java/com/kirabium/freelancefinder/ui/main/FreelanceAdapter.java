package com.kirabium.freelancefinder.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kirabium.freelancefinder.R;


public class FreelanceAdapter extends ListAdapter<FreelanceStateItem, FreelanceAdapter.ViewHolder> {


    public FreelanceAdapter() {
        super(new ListNeighbourItemCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.freelance_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView firstnameTextView;
        private final TextView seniorityTextView;
        private final TextView tjmTextView;
        private final TextView cityTextView;
        private final ImageView avatarImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstnameTextView = itemView.findViewById(R.id.freelance_item_firstname);
            cityTextView = itemView.findViewById(R.id.freelance_item_city);
            seniorityTextView = itemView.findViewById(R.id.freelance_item_seniority);
            tjmTextView = itemView.findViewById(R.id.freelance_item_tjm);
            avatarImageView= itemView.findViewById(R.id.freelance_item_avatar);
        }

        public void bind(FreelanceStateItem item) {
            firstnameTextView.setText(item.getFirstname());
            cityTextView.setText(item.getCity());
            seniorityTextView.setText(item.getSeniority());
            tjmTextView.setText(item.getTjm());
            Glide.with(avatarImageView)
                    .load(item.getAvatarUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(avatarImageView);
        }
    }

    private static class ListNeighbourItemCallback extends DiffUtil.ItemCallback<FreelanceStateItem> {
        @Override
        public boolean areItemsTheSame(@NonNull FreelanceStateItem oldItem, @NonNull FreelanceStateItem newItem) {
            return oldItem.getFirstname().equals(newItem.getFirstname()) && oldItem.getSeniority().equals(newItem.getSeniority());
        }

        @Override
        public boolean areContentsTheSame(@NonNull FreelanceStateItem oldItem, @NonNull FreelanceStateItem newItem) {
            return oldItem.equals(newItem);
        }
    }
}
