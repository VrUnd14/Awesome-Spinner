package awesome.vrund.awesomespinner

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.vp_awesome_spinner.view.*

class VPAwesomeSpinner @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.vp_awesome_spinner, this)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.VPAwesomeSpinner)
        try {
            val ttl = ta.getString(R.styleable.VPAwesomeSpinner_title)
            val backColor = ta.getColor(R.styleable.VPAwesomeSpinner_tintColor, Color.BLACK)
            val textColor = ta.getColor(R.styleable.VPAwesomeSpinner_titleColor, Color.WHITE)
            spinnerAwesome.tag = ta.getString(R.styleable.VPAwesomeSpinner_spinnerTag)
            title.text = ttl
            title.setTextColor(textColor)
            val gd = title.background as GradientDrawable
            gd.setColor(backColor)
            curveImg.setColorFilter(backColor, PorterDuff.Mode.SRC_ATOP)
            spnDrop.setColorFilter(backColor, PorterDuff.Mode.SRC_ATOP)
        } finally {
            ta.recycle()
        }
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

    fun setAdapter(adapter: ArrayAdapter<*>?) {
        spinnerAwesome.adapter = adapter
    }

    fun setSelection(pos: Int) {
        spinnerAwesome.setSelection(pos)
    }

    fun setOnItemSelectedListener(listener: AdapterView.OnItemSelectedListener?) {
        spinnerAwesome.onItemSelectedListener = listener
    }
}