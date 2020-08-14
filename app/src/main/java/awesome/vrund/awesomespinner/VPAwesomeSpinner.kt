package awesome.vrund.awesomespinner

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getStringOrThrow
import kotlinx.android.synthetic.main.vp_awesome_spinner.view.*

class VPAwesomeSpinner @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.vp_awesome_spinner, this)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.VPAwesomeSpinner)

        val ttl = ta.getString(R.styleable.VPAwesomeSpinner_vp_title)
        if (ttl != null) {
            title.text = ttl
        }
        val textColor = ta.getColor(R.styleable.VPAwesomeSpinner_vp_titleColor, Color.WHITE)
        title.setTextColor(textColor)

        val tintColor = ta.getColor(R.styleable.VPAwesomeSpinner_vp_tintColor, Color.BLACK)
        val gd = title.background as GradientDrawable
        gd.setColor(tintColor)
        curveImg.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
        spnDrop.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)

        val ld = spinnerAwesome.background as LayerDrawable

        val backColor = ta.getColor(R.styleable.VPAwesomeSpinner_vp_backColor, ContextCompat.getColor(context, R.color.vp_back_color))
        val backGD = ContextCompat.getDrawable(context, R.drawable.vp_back) as GradientDrawable
        backGD.setColor(backColor)
        ld.setDrawableByLayerId(R.id.back, backGD)

        val dividerColor = ta.getColor(R.styleable.VPAwesomeSpinner_vp_dividerColor, ContextCompat.getColor(context, R.color.vp_divider_color))
        val dividerGD = ContextCompat.getDrawable(context, R.drawable.vp_divider) as GradientDrawable
        dividerGD.setColor(dividerColor)
        ld.setDrawableByLayerId(R.id.divider, dividerGD)

        spinnerAwesome.tag = ta.getString(R.styleable.VPAwesomeSpinner_vp_spinnerTag)

        ta.recycle()
    }

    fun setTitle(ttl: String) {
        title.text = ttl
    }

    fun setTitleColor(color: Int) {
        title.setTextColor(color)
    }

    fun setTintColor(color: Int) {
        val gd = title.background as GradientDrawable
        gd.setColor(color)
        curveImg.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        spnDrop.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }

    fun setBackColor(color: Int) {
        val ld = spinnerAwesome.background as LayerDrawable

        val gd = ContextCompat.getDrawable(context, R.drawable.vp_back) as GradientDrawable
        gd.setColor(color)
        ld.setDrawableByLayerId(R.id.back, gd)
    }

    fun setDividerColor(color: Int) {
        val ld = spinnerAwesome.background as LayerDrawable

        val gd = ContextCompat.getDrawable(context, R.drawable.vp_divider) as GradientDrawable
        gd.setColor(color)
        ld.setDrawableByLayerId(R.id.divider, gd)
    }

    fun setAdapter(adapter: ArrayAdapter<*>?) {
        spinnerAwesome.adapter = adapter
    }

    fun setSelection(pos: Int) {
        spinnerAwesome.setSelection(pos)
    }

    fun getSelectedItem(): Any {
        return spinnerAwesome.selectedItem
    }

    fun setOnItemSelectedListener(listener: AdapterView.OnItemSelectedListener?) {
        spinnerAwesome.onItemSelectedListener = listener
    }
}