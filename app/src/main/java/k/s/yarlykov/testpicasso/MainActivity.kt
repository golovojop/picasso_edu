package k.s.yarlykov.testpicasso

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isLandscape = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        if (isLandscape) {
            // При горизонталной ориентации потребуется асинхронно запросить размеры выделенные для ImageView
            ivDay.post {
                renderLandscape(Pair(ivDay.width, ivDay.height))
            }
        } else {
            ivDay.loadWithPicasso(R.drawable.summer_city_day_clear, EmptyTransformation, 0f)
            ivNight.loadWithPicasso(R.drawable.summer_city_night_clear, EmptyTransformation, 0f)
        }
    }

    private fun renderLandscape(dims: Pair<Int, Int>) {
        ivDay.loadAndCropWithPicasso(R.drawable.summer_city_day_clear, dims.first, dims.second)
        ivNight.loadAndCropWithPicasso(R.drawable.summer_city_night_clear, dims.first, dims.second)
    }
}
