package com.example.job.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.job.API.ApiService;
import com.example.job.R;
import com.example.job.API.RetrofitClient;
import com.example.job.models.Job;
import com.example.job.screens.JobDetails;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private Context context;
    private List<Job> jobList;
    private ApiService api;
    String token = "Bearer 146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr";

    public JobAdapter(Context context, List<Job> jobList) {
        this.context = context;
        this.jobList = jobList;

        this.api = RetrofitClient.getClient().create(ApiService.class);
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobList.get(position);

        if (job.isFavorite()) {

            holder.favoriteIcon.setImageResource(R.drawable.img_10);
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.bookmark);
        }

        holder.tvTime.setText(safeText(job.getCreateTime()));
        holder.tvJobTitle.setText(safeText(job.getTitle()));
        holder.tvCompany.setText(safeText(job.getBusinessMan().getBusinessName()));

        Glide.with(context)
                .load(job.getBusinessMan().getImageUrl())
                .placeholder(R.drawable.img_33)
                .error(R.drawable.img_33)
                .into(holder.tvCodeImage);

        holder.tvCategory.setText(job.getEducationField() != null ? safeText(job.getEducationField().getName()) : "N/A");
        holder.tvSalary.setText(safeText(job.getEmploymentType()));
        holder.tvYears.setText(job.getExperienceYear() != null ? safeText(job.getExperienceYear().getName()) : "N/A");
        holder.tvExpire.setText(String.valueOf(job.getExpireDate()) != null ? safeText(String.valueOf(job.getExpireDate())) : "N/A");
        holder.tvDescription.setText(safeText(job.getFileDescription()));
        holder.tvViews.setText(String.valueOf(job.getWatchesCount()));
        holder.WorkFieldId.setText(String.valueOf(job.getWorkFieldId()));
        holder.tvDays.setText(String.valueOf(job.getJobValidUnite()));

        holder.favoriteIcon.setOnClickListener(v -> {
            holder.favoriteIcon.setEnabled(false);

            api.markJobAsFavorite(token, job.getId()).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    holder.favoriteIcon.setEnabled(true);
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "Added to favorites!", Toast.LENGTH_SHORT).show();
                        holder.favoriteIcon.setImageResource(R.drawable.img_10);
                        job.setFavorite(true);
                    } else {
                        Toast.makeText(context, "Failed to add to favorites", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    holder.favoriteIcon.setEnabled(true);
                    Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public void updateList(List<Job> newList) {
        this.jobList = newList;
        notifyDataSetChanged();
    }

    private String safeText(String value) {
        return value != null ? value : "N/A";
    }

    public class JobViewHolder extends RecyclerView.ViewHolder {

        TextView tvTime, tvJobTitle, tvCompany, WorkFieldId, tvCategory, tvViews,
                tvSalary, tvYears, tvDays, tvDescription, tvExpire;
        LinearLayout layoutSkills;
        ImageView tvCodeImage, favoriteIcon;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTime = itemView.findViewById(R.id.tvTime);
            tvJobTitle = itemView.findViewById(R.id.tvJobTitle);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvYears = itemView.findViewById(R.id.Years);
            tvDays = itemView.findViewById(R.id.days);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvExpire = itemView.findViewById(R.id.tvExpire);
            layoutSkills = itemView.findViewById(R.id.layoutSkills);
            tvViews = itemView.findViewById(R.id.tvViews);
            WorkFieldId = itemView.findViewById(R.id.workFieldId);
            favoriteIcon = itemView.findViewById(R.id.imgLike);
            tvCodeImage = itemView.findViewById(R.id.tvCodeImage);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Job selectedJob = jobList.get(position);
                    Intent intent = new Intent(context, JobDetails.class);
                    intent.putExtra("COURSE_ID", selectedJob.getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
