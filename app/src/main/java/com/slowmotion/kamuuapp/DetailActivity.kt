package com.slowmotion.kamuuapp

import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.slowmotion.kamuuapp.model.ResponseMain
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var item: ResponseMain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        tv_detail_name.setText(item?.Name)
        tv_description.setText(item?.Description)
        tv_detail_harga.setText(item?.Price)

        Glide.with(this)
            .load(item?.Picture)
            .apply(
                RequestOptions()
                    .override(500,500)
                    .placeholder(R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH))
                    .into(iv_detail)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            tv_description.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD

        }

}
}