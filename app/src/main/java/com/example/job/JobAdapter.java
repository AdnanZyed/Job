package com.example.job;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private Context context;
    private List<Job> jobList;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public JobAdapter(Context context, List<Job> jobList) {
        this.context = context;
        this.jobList = jobList;
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

        holder.tvTime.setText(job.getTime());
        holder.tvJobTitle.setText(job.getTitle());
        holder.tvCompany.setText(job.getCompany());
        holder.tvCode.setText(job.getPureCode());

        holder.tvCategory.setText(job.getCategory());
        holder.tvSalary.setText(String.format("%.2f", job.getSalary()));
        holder.tvYears.setText(String.valueOf(job.getYears()));
        holder.tvDays.setText(String.valueOf(job.getRemainingDays()));
        holder.tvDescription.setText(job.getDescription());

        if (job.getExpire() != null) {
            holder.tvExpire.setText(job.getExpire().format(String.valueOf(dateFormatter)));
        } else {
            holder.tvExpire.setText("N/A");
        }

         holder.tvViews.setText(String.valueOf(job.getViews()));
        holder.layoutSkills.removeAllViews();
        for (String skill : job.getSkills()) {
            TextView skillView = new TextView(context);
            skillView.setText(skill);
            skillView.setBackgroundResource(R.drawable.shape2);
            skillView.setPadding(16, 8, 16, 8);
            skillView.setTextColor(context.getResources().getColor(R.color.primary));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            skillView.setLayoutParams(params);
            holder.layoutSkills.addView(skillView);
        }
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {

        TextView tvTime, tvJobTitle, tvCompany, tvCode, tvCategory ,tvViews,
                tvSalary, tvYears, tvDays, tvDescription, tvExpire;
        LinearLayout layoutSkills;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTime = itemView.findViewById(R.id.tvTime);
            tvJobTitle = itemView.findViewById(R.id.tvJobTitle);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvCode = itemView.findViewById(R.id.pure);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvYears = itemView.findViewById(R.id.Years);
            tvDays = itemView.findViewById(R.id.days);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvExpire = itemView.findViewById(R.id.tvExpire);
            layoutSkills = itemView.findViewById(R.id.layoutSkills);
            tvViews = itemView.findViewById(R.id.tvViews);

        }
    }
}
