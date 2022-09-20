package org.sjhstudio.sunflowerclone.presentation.ui.home.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import org.sjhstudio.sunflowerclone.R
import org.sjhstudio.sunflowerclone.databinding.FragmentViewPagerBinding
import org.sjhstudio.sunflowerclone.presentation.base.BaseFragment
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.MY_GARDEN_PAGE_INDEX
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.PLANT_LIST_PAGE_INDEX
import org.sjhstudio.sunflowerclone.presentation.ui.home.adapter.SunflowerPagerAdapter

class HomeViewPagerFragment : BaseFragment<FragmentViewPagerBinding>(R.layout.fragment_view_pager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding) {
            viewPager.adapter = SunflowerPagerAdapter(this@HomeViewPagerFragment)

            TabLayoutMediator(layoutTab, viewPager) { tab, position ->
                tab.apply {
                    setIcon(getTabIcon(position))
                    text = getTabTitle(position)
                }
            }.attach()

            (activity as AppCompatActivity).setSupportActionBar(toolbar)
        }
    }

    private fun getTabIcon(position: Int): Int = when (position) {
        MY_GARDEN_PAGE_INDEX -> R.drawable.selector_my_garden_tab
        PLANT_LIST_PAGE_INDEX -> R.drawable.selector_plant_list_tab
        else -> throw IndexOutOfBoundsException()
    }

    private fun getTabTitle(position: Int): String? = when (position) {
        MY_GARDEN_PAGE_INDEX -> getString(R.string.title_my_garden)
        PLANT_LIST_PAGE_INDEX -> getString(R.string.title_plant_list)
        else -> null
    }
}