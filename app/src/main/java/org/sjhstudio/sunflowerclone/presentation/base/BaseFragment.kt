package org.sjhstudio.sunflowerclone.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    Fragment(layoutRes) {

    private var _binding: T? = null
    val binding: T
        get() = _binding ?: error("ViewBinding error")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        binding.unbind()
        _binding = null
        super.onDestroyView()
    }
}