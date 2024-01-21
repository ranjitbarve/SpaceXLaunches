package com.ranjit.spacex.launches.ui;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranjit.spacex.launches.R;
import com.ranjit.spacex.launches.databinding.ItemLaunchBinding;
import com.ranjit.spacex.launches.model.Launches;
import com.ranjit.spacex.launches.utils.DateUtils;
import com.ranjit.spacex.launches.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.ViewHolder> {
    private List<Launches> spaceLaunches;
    private OnItemClickListener onClick;

    public LaunchesAdapter(OnItemClickListener onClick) {
        this.onClick = onClick;
        this.spaceLaunches = new ArrayList<>();
    }

    // Method to update the data set and refresh the adapter
    public void setData(List<Launches> launches) {
        spaceLaunches = launches;
        notifyDataSetChanged();
    }

    // Interface to define item click actions
    public interface OnItemClickListener {
        void onItemClick(Launches launch);

        void onFabItemClick(Launches launch);
    }

    // ViewHolder class for RecyclerView items
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemLaunchBinding binding;

        public ViewHolder(ItemLaunchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Bind data to the ViewHolder
        public void bind(Launches item) {
            binding.tvMissionName.setText(item.getMissionName());
            binding.tvLaunchStatus.setText(item.isLaunchSuccess() ? R.string.launch_success : R.string.launch_failure);

            binding.tvRocketName.setText("Rocket Name : " + item.getRocketName());
            binding.tvLaunchDate.setText("Launch Date : " + DateUtils.convertDateFormat(item.getLaunchDateLocal()));

            ImageUtils.loadImage(item.getMissionPatchSmall(), binding.ivLaunchSmall);

            // Set bookmark button image based on favorite status
            binding.ibFavorite.setImageResource(item.isFavorite() ? R.drawable.ic_favorite_24 : R.drawable.ic_favorite_border_24);

            // Set click listener for the bookmark button
            binding.ibFavorite.setOnClickListener(v -> {
                if (onClick != null) {
                    // Toggle favorite status and notify item change
                    item.setFavorite(!item.isFavorite());
                    notifyItemChanged(getAdapterPosition());
                    onClick.onFabItemClick(item);
                }
            });

            // Set click listener for the whole item
            binding.getRoot().setOnClickListener(v -> {
                if (onClick != null) {
                    onClick.onItemClick(item);
                }
            });

            if (item.isLaunchSuccess()){
                binding.clRoot.setBackgroundResource(R.drawable.fill_rectangle_light_green);
            }else if (!item.isLaunchSuccess()){
                binding.clRoot.setBackgroundResource(R.drawable.fill_rectangle_light_red);
            }else {
                binding.clRoot.setBackgroundResource(R.drawable.fill_rectangle_light_blue);
            }

        }
    }

    // Inflate the item view and create a new ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemLaunchBinding binding = ItemLaunchBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    // Bind data to the ViewHolder at the specified position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Launches rocket = spaceLaunches.get(position);
        holder.bind(rocket);
    }

    // Return the total number of items in the data set
    @Override
    public int getItemCount() {
        return spaceLaunches.size();
    }
}
